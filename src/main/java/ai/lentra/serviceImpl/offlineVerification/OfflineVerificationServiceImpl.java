package ai.lentra.serviceImpl.offlineVerification;

import ai.lentra.dto.offlineVerification.OffileInputDataDTO;

import ai.lentra.service.offlineVerification.OfflineVerificationService;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OfflineVerificationServiceImpl implements OfflineVerificationService {
    @Autowired
    public DataSource dataSource;
    public HttpServletResponse getOffLinePDF(HttpServletResponse response) throws Exception {
        String sourceFileName = ResourceUtils.getFile("/home/afroze/git/lentra/target/classes/"+ "OffLineFiFormsPDF.jasper").getAbsolutePath();
        // creating our list of beans

        final Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", "1");
        parameters.put("subReportPath", "/home/afroze/git/lentra/target/classes/");
        JasperPrint jasperPrint = JasperFillManager.fillReport(sourceFileName,parameters,dataSource.getConnection());
        final String filePath = "/home/afroze/git/lentra/target/classes/";
        JasperExportManager.exportReportToPdfFile(jasperPrint, filePath + "Employee_report.pdf");
        // JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
        response.setContentType("application/pdf");
        response.addHeader("Content-Disposition", "inline; filename=jasper.pdf;");
        return response;
    }
}
