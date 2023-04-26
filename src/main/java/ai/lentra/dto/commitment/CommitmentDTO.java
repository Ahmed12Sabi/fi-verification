package ai.lentra.dto.commitment;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;



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

    public Integer getCommitmentId() {
        return commitmentId;
    }

    public void setCommitmentId(Integer commitmentId) {
        this.commitmentId = commitmentId;
    }

    public String getInsurance_type() {
        return insurance_type;
    }

    public void setInsurance_type(String insurance_type) {
        this.insurance_type = insurance_type;
    }

    public String getLife_insurance_amt() {
        return life_insurance_amt;
    }

    public void setLife_insurance_amt(String life_insurance_amt) {
        this.life_insurance_amt = life_insurance_amt;
    }

    public String getLife_insurance_duration() {
        return life_insurance_duration;
    }

    public void setLife_insurance_duration(String life_insurance_duration) {
        this.life_insurance_duration = life_insurance_duration;
    }

    public String getCar_insurance_amt() {
        return car_insurance_amt;
    }

    public void setCar_insurance_amt(String car_insurance_amt) {
        this.car_insurance_amt = car_insurance_amt;
    }

    public String getCar_insurance_duration() {
        return car_insurance_duration;
    }

    public void setCar_insurance_duration(String car_insurance_duration) {
        this.car_insurance_duration = car_insurance_duration;
    }

    public String getHealth_insurance_amt() {
        return health_insurance_amt;
    }

    public void setHealth_insurance_amt(String health_insurance_amt) {
        this.health_insurance_amt = health_insurance_amt;
    }

    public String getHealth_insurance_duration() {
        return health_insurance_duration;
    }

    public void setHealth_insurance_duration(String health_insurance_duration) {
        this.health_insurance_duration = health_insurance_duration;
    }

    public String getTwoWheeler_insurance_amt() {
        return twoWheeler_insurance_amt;
    }

    public void setTwoWheeler_insurance_amt(String twoWheeler_insurance_amt) {
        this.twoWheeler_insurance_amt = twoWheeler_insurance_amt;
    }

    public String getTwoWheeler_insurance_duration() {
        return twoWheeler_insurance_duration;
    }

    public void setTwoWheeler_insurance_duration(String twoWheeler_insurance_duration) {
        this.twoWheeler_insurance_duration = twoWheeler_insurance_duration;
    }

    public String getHome_insurance_amt() {
        return home_insurance_amt;
    }

    public void setHome_insurance_amt(String home_insurance_amt) {
        this.home_insurance_amt = home_insurance_amt;
    }

    public String getHome_insurance_duration() {
        return home_insurance_duration;
    }

    public void setHome_insurance_duration(String home_insurance_duration) {
        this.home_insurance_duration = home_insurance_duration;
    }

    public String getTerm_insurance_amt() {
        return term_insurance_amt;
    }

    public void setTerm_insurance_amt(String term_insurance_amt) {
        this.term_insurance_amt = term_insurance_amt;
    }

    public String getTerm_insurance_duration() {
        return term_insurance_duration;
    }

    public void setTerm_insurance_duration(String term_insurance_duration) {
        this.term_insurance_duration = term_insurance_duration;
    }

    public String getLoc_amt() {
        return loc_amt;
    }

    public void setLoc_amt(String loc_amt) {
        this.loc_amt = loc_amt;
    }

    public String getLoc_expiry_date() {
        return loc_expiry_date;
    }

    public void setLoc_expiry_date(String loc_expiry_date) {
        this.loc_expiry_date = loc_expiry_date;
    }

    public String getNps_applicant_name() {
        return nps_applicant_name;
    }

    public void setNps_applicant_name(String nps_applicant_name) {
        this.nps_applicant_name = nps_applicant_name;
    }

    public String getNps_amt() {
        return nps_amt;
    }

    public void setNps_amt(String nps_amt) {
        this.nps_amt = nps_amt;
    }

    public String getNps_duration() {
        return nps_duration;
    }

    public void setNps_duration(String nps_duration) {
        this.nps_duration = nps_duration;
    }

    public String getBank_name_loc() {
        return bank_name_loc;
    }

    public void setBank_name_loc(String bank_name_loc) {
        this.bank_name_loc = bank_name_loc;
    }
}


