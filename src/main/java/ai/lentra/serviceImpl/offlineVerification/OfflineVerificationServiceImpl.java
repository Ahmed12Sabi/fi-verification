package ai.lentra.serviceImpl.offlineVerification;

import ai.lentra.dto.offlineVerification.DataFields;
import ai.lentra.dto.offlineVerification.OffileInputDataDTO;
import ai.lentra.modal.ApplicationDetails;
import ai.lentra.modal.masterconfig.*;
import ai.lentra.repository.applicationDetails.ApplicationRepository;
import ai.lentra.repository.masterconfig.MasterVerificationConfigurationRepository;
import ai.lentra.repository.masterconfig.ProductConfigRepository;
import ai.lentra.repository.masterconfig.VerificationFormConfigRepository;
import ai.lentra.repository.masterconfig.VerificationFormFieldsConfigRepository;
import ai.lentra.service.offlineVerification.OfflineVerificationService;
import freemarker.template.Configuration;
import freemarker.template.Template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.*;
import com.itextpdf.html2pdf.HtmlConverter;

@Service
public class OfflineVerificationServiceImpl implements OfflineVerificationService {
    @Autowired
    private Configuration config;
    @Autowired
    ApplicationRepository applicationRepository;
    @Autowired
    MasterVerificationConfigurationRepository masterVerificationConfigurationRepository;
    @Autowired
    ProductConfigRepository productConfigRepository;
    @Autowired
    VerificationFormConfigRepository verificationFormConfigRepository;
    @Autowired
    VerificationFormFieldsConfigRepository verificationFormFieldsConfigRepository;
    public String getOffLinePDF(HttpServletRequest request) throws Exception {
        String instituteId = "1";
        String product = "HL";
        Template template = config.getTemplate("offlineVerificationHtml.ftl");
        StringBuilder html = new StringBuilder();
        html.append("<html> <body>");
        html.append("<style>  th, td { border:1px solid black; } </style>");
        ApplicationDetails appl = applicationRepository.getByInsIdAndProductType(instituteId, product);
        ProductConfigEntity pce = productConfigRepository.getByInstituteIdAndProductType(instituteId, product);
        List<MasterVerificationConfiguration> mvc = masterVerificationConfigurationRepository.findByProfileName(pce.getProfileName());

        for (MasterVerificationConfiguration singleMvc : mvc) {
            List<MasterVerificationConfiguration> subProfiles = masterVerificationConfigurationRepository.findBySubProfileName(singleMvc.getSubProfileName());
            for (MasterVerificationConfiguration subProfile : subProfiles) {
                List<VerificationFormConfig> forms = verificationFormConfigRepository.getBySubProfileName(subProfile.getSubProfileName());
                for (VerificationFormConfig form : forms) {
                    if (!form.isHidden()) {

                        html.append("<h2><center> "+form.getFormName() +" </center></h2>");
                        List<VerificationFormFieldsConfig> fields = verificationFormFieldsConfigRepository.getByFormFields(form.getFormId());
                        for (VerificationFormFieldsConfig field : fields) {
                            if (!field.isHidden()) {
                               // dataFields.setDataFields(Arrays.asList(new DataFields(field.getFieldName(), "Afroze")));
                                html.append(FreeMarkerTemplateUtils.processTemplateIntoString(template, new OffileInputDataDTO(Arrays.asList(new DataFields(field.getFieldName(), "Afroze")))));
                            }
                        }
                    }
                }
            }

        }
       // html.append(" Hello ");
        html.append("</html> </body>");
        OutputStream os =new FileOutputStream("/home/afroze/Downloads/offlineVerification.pdf");
        HtmlConverter.convertToPdf(String.valueOf(html), os);

        return "SuccessFully Pdf downloaded";
    }
    }


