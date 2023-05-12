package ai.lentra.serviceImpl.offlineVerification;

import ai.lentra.dto.offlineVerification.DataFields;
import ai.lentra.dto.offlineVerification.OffileInputDataDTO;
import ai.lentra.modal.applicant_details.ApplicantDetails;
import ai.lentra.modal.application.ApplicationDetails;
import ai.lentra.modal.masterconfig.*;
import ai.lentra.repository.allocation.ApplicationRepository;
import ai.lentra.repository.masterconfig.MasterVerificationConfigurationRepository;
import ai.lentra.repository.masterconfig.ProductConfigRepository;
import ai.lentra.repository.masterconfig.VerificationFormConfigRepository;
import ai.lentra.repository.masterconfig.VerificationFormFieldsConfigRepository;
import ai.lentra.service.ApplicantDetailsService;
import ai.lentra.service.offlineVerification.OfflineVerificationService;
import freemarker.template.Configuration;
import freemarker.template.Template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.persistence.Column;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.lang.reflect.Field;
import java.util.*;
import com.itextpdf.html2pdf.HtmlConverter;

@Service
public class OfflineVerificationServiceImpl implements OfflineVerificationService {
    @Autowired
    private Configuration config;

    @Autowired
    JdbcTemplate jdbcTemplate;
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
    @Autowired
    private ApplicantDetailsService applicantDetailsService;
    public String getOffLinePDF(HttpServletRequest request) throws Exception {
        Long applicant_id=1L;
        String instituteId = "1";
        String product = "HL";
        Template template = config.getTemplate("offlineVerificationHtml.ftl");
        StringBuilder html = new StringBuilder();
        html.append("<html> <body>");
        html.append("<style>  th, td { border:1px solid black; } </style>");
        ApplicationDetails appl = applicationRepository.getByInsIdAndProductType(instituteId, product);
        ProductConfigEntity pce = productConfigRepository.getByInstituteIdAndProductType(instituteId, product);
        List<MasterVerificationConfiguration> mvc = masterVerificationConfigurationRepository.findByProfileName(pce.getProfileName());
        ResponseEntity applicantDetails = applicantDetailsService.getApplicantDetails(applicant_id);
        String tableName="";
        /*for (MasterVerificationConfiguration singleMvc : mvc) {
            List<MasterVerificationConfiguration> subProfiles = masterVerificationConfigurationRepository.findBySubProfileName(singleMvc.getSubProfileName());
            for (MasterVerificationConfiguration subProfile : subProfiles) {
                List<VerificationFormConfig> forms = verificationFormConfigRepository.getBySubProfileName(subProfile.getSubProfileName());
                for (VerificationFormConfig form : forms) {
                    if (!form.isHidden()) {

                        if(form.getFormName().equalsIgnoreCase("Contact details")){
                            tableName="contact_details";
                            }
                        if(form.getFormName().equalsIgnoreCase("Personal Details")){
                            tableName="personal_details";
                            }
                        if(form.getFormName().equalsIgnoreCase("Office self employed details")){
                            
                            tableName="office_self_employment";
                            }
                        if(form.getFormName().equalsIgnoreCase("Commitment")){
                            
                            tableName="commitment_details";
                            }
                        if(form.getFormName().equalsIgnoreCase("Expenses")){
                            
                            tableName="expenses";
                            }
                        if(form.getFormName().equalsIgnoreCase("Family details")){
                            tableName="family_details";
                            }
                        if(form.getFormName().equalsIgnoreCase("Residence")){
                            
                            tableName="residence_details";
                            }
                        if(form.getFormName().equalsIgnoreCase("Vehicle Information")){
                            
                            tableName="vehicle_details";
                            }
                        if(form.getFormName().equalsIgnoreCase("Summary")){
                            
                            tableName="summary";
                            }
                      
                        }

                        html.append("<h2><center> "+form.getFormName() +" </center></h2>");
                        List<VerificationFormFieldsConfig> fields = verificationFormFieldsConfigRepository.getByFormFields(form.getFormId());
                        for (VerificationFormFieldsConfig field : fields) {
                            if (!field.isHidden()) {
                               // dataFields.setDataFields(Arrays.asList(new DataFields(field.getFieldName(), findValue(findById(field.getFieldId())) )));
                                html.append(FreeMarkerTemplateUtils.processTemplateIntoString(template, new OffileInputDataDTO(Arrays.asList(new DataFields(field.getFieldName(), findValue(findById(field.getFieldId(),applicant_id ,applicantDetails,tableName)) )))));
                            }
                        }
                    }
                }
            }*/


       // html.append(" Hello ");
        html.append("</html> </body>");
        OutputStream os =new FileOutputStream("/home/afroze/Downloads/offlineVerification.pdf");
        HtmlConverter.convertToPdf(String.valueOf(html), os);

        return "SuccessFully Pdf downloaded";
    }

   // @Override
    public String findById(Long id, Long applicant_id,ResponseEntity applicantDetails,String tableName) {

        for (Field field : applicantDetails.getBody().getClass().getDeclaredFields()) {
            Column column = field.getAnnotation(Column.class);
            if (column != null) {
                tableName=column.name();
            }
        }
        return jdbcTemplate.queryForObject("select * from books where field_id = ? limit 1",
                new Object[]{id}, (rs, rowNum) -> ("select " + rs.getString("field_name") + " from " + rs.getString("tableName") + " where applicant_id = " + applicant_id + "  limit 1"));
    }


        public String findValue(String value) {
        return jdbcTemplate.queryForObject( value,(rs, rowNum) ->(rs.getString(0)));
    }

}

