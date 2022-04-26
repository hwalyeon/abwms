package kr.co.seculink.feign.service;

import feign.FeignException;
import kr.co.seculink.exception.BizException;
import kr.co.seculink.feign.client.AbEjdClient;
import kr.co.seculink.feign.vo.AlrmVO;
import kr.co.seculink.feign.vo.HlthCareVO;
import kr.co.seculink.util.XUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FeignServiceImpl implements FeignService
{
    @Autowired
    private AbEjdClient abEjdClient;

    public AlrmVO sendPush(AlrmVO params) throws BizException
    {
        if ( XUtil.isEmpty(String.valueOf(params.getGuarNo())) ) {
            throw new BizException("VALID.001", new String[] {"보호자 번호"});
        }

        if ( XUtil.isEmpty(String.valueOf(params.getStdtNo())) ) {
            throw new BizException("VALID.001", new String[] {"학생 번호"});
        }

        if ( XUtil.isEmpty(String.valueOf(params.getUserId())) ) {
            throw new BizException("VALID.001", new String[] {"사용자 ID"});
        }

        if ( XUtil.isEmpty(String.valueOf(params.getAlamTitl())) ) {
            throw new BizException("VALID.001", new String[] {"제목"});
        }

        if ( XUtil.isEmpty(String.valueOf(params.getEtcAlamCntn())) ) {
            throw new BizException("VALID.001", new String[] {"내용"});
        }

        if ( XUtil.isEmpty(String.valueOf(params.getAlamTypeCd())) ) {
            throw new BizException("VALID.001", new String[] {"알림유형"});
        }

        AlrmVO rtnVO = null;

        try {
            rtnVO = abEjdClient.sendPush(params);
        } catch ( FeignException e ) {
            e.printStackTrace();
            log.error("ABEJD 서비스와 연결할 수 없습니다.");

            rtnVO = new AlrmVO();
            rtnVO.setRsltCd("99");
            rtnVO.setRsltCntn("ABEJD 서비스와 연결할 수 없습니다.");

        } catch ( Exception e ) {
            e.printStackTrace();
            log.error("ABEJD 서비스 호출 중 에러가 발생하였습니다.");

            rtnVO = new AlrmVO();
            rtnVO.setRsltCd("99");
            rtnVO.setRsltCntn("ABEJD 서비스와 연결할 수 없습니다.");
        } finally {
            log.debug("rsltCd/rsltCntn:{}/{}", rtnVO.getRsltCd(), rtnVO.getRsltCntn());
        }

        return rtnVO;

    }

    // 학생/부모의 신체정보가 변경된 경우
    public HlthCareVO chagneBodyInfo(HlthCareVO params) throws BizException
    {
        validation(params);
        params.setEvntDivCd(FeignService.EVNT_DIV_CD_BODY);
        return process(params);
    }

    private void validation(HlthCareVO params) throws BizException
    {
        log.debug("validation");
        if (XUtil.isEmpty(params.getStdtNo()) ) {
            throw new BizException("VALID.001", new String[] {"학생번호"});
        }

        if (XUtil.isEmpty(params.getStndDt()) ) {
            throw new BizException("VALID.001", new String[] {"기준일자"});
        }

        if (XUtil.isEmpty(params.getUserId()) ) {
            throw new BizException("VALID.001", new String[] {"사용자ID"});
        }
    }

    private HlthCareVO process(HlthCareVO params) //throws BizException
    {
        log.debug("process");

        HlthCareVO rtnVO = null;

        try {
            rtnVO = abEjdClient.healthcare(params);
        } catch ( FeignException e ) {
            e.printStackTrace();
            log.error("ABEJD 서비스와 연결할 수 없습니다.");

            rtnVO = new HlthCareVO();
            rtnVO.setRsltCd("99");
            rtnVO.setRsltCntn("ABEJD 서비스와 연결할 수 없습니다.");
//            throw new BizException("ECOM999", new String[] {"ABEJD 서비스와 연결할 수 없습니다."});
        } catch ( Exception e ) {
            e.printStackTrace();
            log.error("ABEJD 서비스 호출 중 에러가 발생하였습니다.");
        } finally {
            log.debug("rsltCd/rsltCntn:{}/{}", rtnVO.getRsltCd(), rtnVO.getRsltCntn());
        }

        return rtnVO;
    }
}
