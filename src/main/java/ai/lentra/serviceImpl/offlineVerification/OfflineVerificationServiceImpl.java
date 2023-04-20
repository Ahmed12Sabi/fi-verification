package ai.lentra.serviceImpl.offlineVerification;

import ai.lentra.dto.offlineVerification.OffileInputDataDTO;

import ai.lentra.dto.offlineVerification.ValueExampleObject;
import ai.lentra.service.offlineVerification.OfflineVerificationService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;
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
import java.io.*;
import java.util.*;

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
    //for temporary void method added
    public void getOffLineHTML(HttpServletResponse response) throws Exception {

        Configuration cfg = new Configuration();

        // Where do we load the templates from:
        cfg.setClassForTemplateLoading(OfflineVerificationServiceImpl.class, "templates");

        // Some other recommended settings:
        cfg.setIncompatibleImprovements(new Version(2, 3, 20));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setLocale(Locale.US);
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        Map<String, Object> input = new HashMap<String, Object>();

        input.put("title", "Vogella example");

        input.put("exampleObject", new ValueExampleObject("Java object", "me"));

        List<ValueExampleObject> systems = new ArrayList<ValueExampleObject>();
        systems.add(new ValueExampleObject("Android", "Google"));
        systems.add(new ValueExampleObject("iOS States", "Apple"));
        systems.add(new ValueExampleObject("Ubuntu", "Canonical"));
        systems.add(new ValueExampleObject("Windows7", "Microsoft"));
        input.put("systems", systems);

        // 2.2. Get the template

        Template template = cfg.getTemplate("helloworld.ftl");

        // 2.3. Generate the output

        // Write output to the console
        Writer consoleWriter = new OutputStreamWriter(System.out);
        template.process(input, consoleWriter);

        // For the sake of example, also write output into a file:
        Writer fileWriter = new FileWriter(new File("output.html"));
        try {
            template.process(input, fileWriter);
        }catch(Exception e){

        }finally {
            fileWriter.close();
        }

    }

    }

