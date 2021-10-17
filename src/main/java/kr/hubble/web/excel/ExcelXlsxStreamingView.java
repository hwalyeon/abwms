package kr.hubble.web.excel;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxStreamingView;

@Component
public class ExcelXlsxStreamingView extends AbstractXlsxStreamingView {

    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) {
        new ExcelWriteComponent(workbook, model, response).create();
    }

}
