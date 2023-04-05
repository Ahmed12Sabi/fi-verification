package ai.lentra.dto.commitment;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@ToString
@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommitmentDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("commitmentId")
    private Integer commitmentId;
    @JsonProperty("insurance_type")
    private String insurance_type;
    @Pattern(regexp = "^\\d{3,13}(\\.\\d{0,2})?$",message = "This field should be accept only 3 to 13 digits not accepted characters")
    @JsonProperty("life_insurance_amt")
    private String life_insurance_amt;
   @Pattern(regexp = "^\\d{1,3}(\\.\\d{0,1})?$",message = "This field should be accept only 1 to 3 digits not accepted characters")
    @JsonProperty("life_insurance_duration")
    private String life_insurance_duration;
   @Pattern(regexp = "^\\d{3,13}(\\.\\d{0,2})?$",message = "This field should be accept only 3 to 13 digits not accepted characters")
    @JsonProperty("car_insurance_amt")
    private String  car_insurance_amt;
    @Pattern(regexp = "^\\d{1,3}(\\.\\d{0,1})?$",message = "This field should be accept only 1 to 3 digits not accepted characters")
    @JsonProperty("car_insurance_duration")
    private String car_insurance_duration;
   @Pattern(regexp = "^\\d{3,13}(\\.\\d{0,2})?$",message = "This field should be accept only 3 to 13 digits not accepted characters")
    @JsonProperty("health_insurance_amt")
    private String  health_insurance_amt;
   @Pattern(regexp = "^\\d{1,3}(\\.\\d{0,1})?$",message = "This field should be accept only 1 to 3 digits not accepted characters")
    @JsonProperty("health_insurance_duration")
    private String health_insurance_duration;
    @Pattern(regexp = "^\\d{3,13}(\\.\\d{0,2})?$",message = "This field should be accept only 3 to 13 digits not accepted characters")
    @JsonProperty("twoWheeler_insurance_amt")
    private String  twoWheeler_insurance_amt;
    @Pattern(regexp = "^\\d{1,3}(\\.\\d{0,1})?$",message = "This field should be accept only 1 to 3 digits not accepted characters")
    @JsonProperty("twoWheeler_insurance_duration")
    private String twoWheeler_insurance_duration;
    @Pattern(regexp = "^\\d{3,13}(\\.\\d{0,2})?$",message = "This field should be accept only 3 to 13 digits not accepted characters")
    @JsonProperty("home_insurance_amt")
    private String  home_insurance_amt;
       @Pattern(regexp = "^\\d{1,3}(\\.\\d{0,1})?$",message = "This field should be accept only 1 to 3 digits not accepted characters")
    @JsonProperty("home_insurance_duration")
    private String home_insurance_duration;
   @Pattern(regexp = "^\\d{3,13}(\\.\\d{0,2})?$",message = "This field should be accept only 3 to 13 digits not accepted characters")
    @JsonProperty("term_insurance_amt")
    private String  term_insurance_amt;
    @Pattern(regexp = "^\\d{1,3}(\\.\\d{0,1})?$",message = "This field should be accept only 1 to 3 digits not accepted characters")
    @JsonProperty("term_insurance_duration")
    private String term_insurance_duration;
   @Pattern(regexp = "^\\d{3,13}(\\.\\d{0,2})?$",message = "This field should be accept only 3 to 13 digits not accepted characters")
    @JsonProperty("loc_amt")
    private String loc_amt;
   @Pattern(regexp = "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$",message = "date must be in the format of 'DD/MM/YYYY'")
    @Column(name = "loc_expiry_date")
    @JsonProperty("loc_expiry_date")
    private String loc_expiry_date;
    @Size(min=6, max=50, message=" nps_applicant_name should have 6-50characters and not allow numbers ")
    @Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")
    @JsonProperty("nps_applicant_name")
    private String nps_applicant_name;
    @Pattern(regexp = "^\\d{3,13}(\\.\\d{0,2})?$",message = "This field should be accept only 3 to 13 digits only not accepted characters")
    @JsonProperty("nps_amt")
    private String  nps_amt;
    @Pattern(regexp = "^\\d{1,3}(\\.\\d{0,1})?$",message = "This field should be accept only 1 to 3 digits not accepted characters")
    @JsonProperty("nps_duration")
    private String nps_duration;
    @Size(min=4, max=50, message=" bank_name_loc should have 4-50characters and not allow numbers")
    @Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")
    @JsonProperty("bank_name_loc")
    private String bank_name_loc;


}


