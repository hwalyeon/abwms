package kr.co.seculink.util;

import static org.bytedeco.opencv.global.opencv_core.CV_32SC1;
import static org.bytedeco.opencv.global.opencv_imgcodecs.IMREAD_GRAYSCALE;
import static org.bytedeco.opencv.global.opencv_imgcodecs.imread;
import static org.bytedeco.opencv.global.opencv_imgcodecs.imwrite;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.IntBuffer;
import java.util.List;

import org.bytedeco.javacpp.DoublePointer;
import org.bytedeco.javacpp.IntPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.MatVector;
import org.bytedeco.opencv.opencv_core.Rect;
import org.bytedeco.opencv.opencv_core.RectVector;
import org.bytedeco.opencv.opencv_face.FaceRecognizer;
import org.bytedeco.opencv.opencv_face.LBPHFaceRecognizer;
import org.bytedeco.opencv.opencv_objdetect.CascadeClassifier;

import kr.hubble.exception.BaseException;
import kr.hubble.exception.BizException;
import kr.hubble.exception.SysException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OpenCVUtil {

	/**
	 * 사진에서 얼굴만 크롭 (얼굴 인식 프로필 사진 생성 용)
	 * @param faceImage 얼굴이 들어간 사진 File
	 * @param saveDir 크롭된 사진이 저장될 경로 (파일명은 원본 파일명과 동일하게 저장)
	 * @return 크롭된 사진 File객체
	 * @throws BaseException
	 * 얼굴이 검출되지 않거나 저장이 실패한 경우 Exception
	 */
	public static File cropFaceImage(File faceImage, String saveDir) throws BaseException {
		File resultFile = null;
		CascadeClassifier faceDetector = null;
		
		log.debug("crop target image : {}", faceImage.getAbsolutePath());

		// Load Face Detector
		URL url;
		try {
			url = new URL(
					"https://raw.github.com/opencv/opencv/master/data/haarcascades/haarcascade_frontalface_alt.xml");
			File file = Loader.cacheResource(url);
			String classifierName = file.getAbsolutePath();

			faceDetector = new CascadeClassifier(classifierName);
		} catch (MalformedURLException e) {
			throw new SysException("ESYS006"); // 시스템 라이브러리 연동 중 오류입니다
		} catch (IOException e) {
			throw new SysException("ESYS006"); // 시스템 라이브러리 연동 중 오류입니다
		}

		// Load image
		Mat img = imread(faceImage.getAbsolutePath());

		// Find faces on the image
		RectVector faces = new RectVector();
		faceDetector.detectMultiScale(img, faces);

		log.debug("Faces detected: " + faces.size());
		
		if (faces.size() <= 0) {
			//얼굴이 검출되지 않았을 경우 오류
			throw new BizException("EFIL003"); //사진에 검출된 얼굴이 없습니다.
		}

		Rect rect = faces.get(0);

		Rect rectCrop = new Rect(rect.x(), rect.y(), rect.width(), rect.height());
		Mat croppedImage = new Mat(img, rectCrop);

		// Save results
		boolean isSaved = imwrite(saveDir + File.separator + faceImage.getName(), croppedImage);
		
		if (isSaved == false) {
			throw new BizException("EFIL001"); //파일 저장에 실패 했습니다
		} else {
			resultFile = new File(saveDir + File.separator + faceImage.getName());
		}

		return resultFile;
	}
	
	/**
	 * 얼굴 비교
	 * @param profileImage 프로파일 사진 (기준 사진)
	 * @param liveImage 촬영한 사진
	 * @param confidence 비교값 (기본적으로 50 추천)
	 * @return true - 같은 사람(confidence값이 기준보다 낮음) false - 다른사람
	 * @throws BaseException
	 * 얼굴이 검출되지 않은 경우 오류
	 */
	public static boolean isEqaulFace(List<File> profileImage, File liveImage, int confidence) throws BaseException {
		
		boolean isEqual = false;
		
		CascadeClassifier faceDetector = null;
		
		log.debug("live image : {}", liveImage.getAbsolutePath());

		// Load Face Detector
		URL url;
		try {
			url = new URL(
					"https://raw.github.com/opencv/opencv/master/data/haarcascades/haarcascade_frontalface_alt.xml");
			File file = Loader.cacheResource(url);
			String classifierName = file.getAbsolutePath();

			faceDetector = new CascadeClassifier(classifierName);
		} catch (MalformedURLException e) {
			throw new SysException("ESYS006"); // 시스템 라이브러리 연동 중 오류입니다
		} catch (IOException e) {
			throw new SysException("ESYS006"); // 시스템 라이브러리 연동 중 오류입니다
		}
		
		//String trainingDir = args[0];
        Mat img = imread(liveImage.getAbsolutePath(), IMREAD_GRAYSCALE);

        // Find faces on the image
        RectVector faces = new RectVector ();
        faceDetector.detectMultiScale(img, faces);
        
        if (faces.size() <= 0) {
			//얼굴이 검출되지 않았을 경우 오류
			throw new BizException("EFIL003"); //사진에 검출된 얼굴이 없습니다.
		}
        
        Rect rect = faces.get(0);
        
        Rect rectCrop = new Rect(rect.x(), rect.y(), rect.width(), rect.height());
        Mat croppedImage = new Mat(img, rectCrop);
        System.out.println("size : " + profileImage.size());
        int cntVector = profileImage.size() == 1 ? 2 : profileImage.size();
        
        MatVector images = new MatVector(cntVector);

        Mat labels = new Mat(cntVector, 1, CV_32SC1);
        
        IntBuffer labelsBuf = labels.createBuffer();

        if (profileImage.size() <= 1) {
        
        	log.debug("profile image : {}", profileImage.get(0).getAbsolutePath());
        	
	        Mat imgT = imread(profileImage.get(0).getAbsolutePath(), IMREAD_GRAYSCALE);
	
	        images.put(0, imgT);
	
	        labelsBuf.put(0, 1);
	        
	        images.put(1, imgT);
	        
	        labelsBuf.put(0, 2);
        
        } else {
        	
        	int counter = 0;
        	
        	for (File pImage : profileImage) {
        		
        		log.debug("profile image : {}", pImage.getAbsolutePath());
        		
        		Mat imgT = imread(pImage.getAbsolutePath(), IMREAD_GRAYSCALE);
        		
    	        images.put(counter, imgT);
    	
    	        labelsBuf.put(0, counter + 1);
    	        
    	        counter++;
    	        
        	}
        	
        }

        FaceRecognizer faceRecognizer = LBPHFaceRecognizer.create();

        faceRecognizer.train(images, labels);

        IntPointer label = new IntPointer(1);
        DoublePointer dConfidence = new DoublePointer(1);
        
        faceRecognizer.predict(croppedImage, label, dConfidence);
        
        int predictedLabel = label.get(0);

        log.debug("Predicted label: " + predictedLabel);
        log.debug("confidence : {}", dConfidence.get(0));
		
        if (dConfidence.get(0) <= confidence) {
        	return true;
        } else {
        	return false;
        }
		
	}
}
 