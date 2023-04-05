package ai.lentra.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.util.Date;

@ToString
@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class FamilyDetailsRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "serial", name = "familyDetailsId")
    @JsonProperty("familyDetailsId")
    private Integer familyDetailsId;
   @Pattern(regexp = "^\\d{1,2}(\\.\\d{0,1})?$",message = "This field should be accept only 1 to 2 digits not accepted characters")
   @JsonProperty("no_of_dependants")
    private String no_of_dependants;
    @Pattern(regexp = "^\\d{1,3}(\\.\\d{0,1})?$",message = "This field should be accept only 1 to 2 digits not accepted characters")
    @JsonProperty("no_of_minor")
    private String no_of_minor;
    @JsonProperty("child_educational_level")
    private String child_educational_level;
    @NotNull @Min(18) @Max(100)
    @DateTimeFormat(pattern="MM/dd/yyyy")
    @JsonProperty("spouse_age")
    private Integer spouse_age;
    @NotNull @Min(18) @Max(100)
    @DateTimeFormat(pattern="MM/dd/yyyy")
    @JsonProperty("father_age")
    private Integer father_age;
    @NotNull @Min(18) @Max(100)
    @DateTimeFormat(pattern="MM/dd/yyyy")
    @JsonProperty("mother_age")
    private Integer mother_age;
    @JsonProperty("spouse_citizenship")
    private String spouse_citizenship;
    @JsonProperty("entity_confirmation_spouse")
    private boolean entity_confirmation_spouse;
    @JsonProperty("spouse_working")
    private boolean spouse_working;
    @JsonProperty("spouse_occupation")
    private String spouse_occupation;
    @JsonProperty("entity_confirmation_father")
    private boolean entity_confirmation_father;
    @JsonProperty("entity_confirmation_mother")
    private boolean entity_confirmation_mother;
    @Size(min=3, max=50, message=" spouse_last_name should have atleast 50 characters")
    @Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")
    @JsonProperty("spouse_last_name")
    private String spouse_last_name;
    @Size(min=3, max=50, message=" spouse_first_name should have atleast 50 characters")
    @Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")
    @JsonProperty("spouse_first_name")
    private String spouse_first_name;
    @Size(min=1, max=50, message=" spouse_mid_name should have atleast 50 characters")
    @Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")
    @JsonProperty("spouse_mid_name")
    private String spouse_mid_name;
    @Size(min=2, max=10, message=" spouse_suffix should have atleast 10 characters")
    @Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")
    @JsonProperty("spouse_suffix")
    private String spouse_suffix;
    @Size(min=2, max=50, message=" spouse_alias should have atleast 50 characters")
    @Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")
    @JsonProperty("spouse_alias")
    private String spouse_alias;
    @PastOrPresent
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @JsonProperty("spouse_birth_date")
    private Date spouse_birth_date;
    @Size(min=4, max=10, message=" spouse_religion should have atleast 10 characters")
    @Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")
    //@Column(name = "spouse_religion")
    @JsonProperty("spouse_religion")
    private String spouse_religion;
    @Size(min=3, max=50, message=" Fathers_first_name should have atleast 50 characters")
    @Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")
    //@Column(name = "Fathers_first_name")
    @JsonProperty("Fathers_first_name")
    private String Fathers_first_name;
    @Size(min=1, max=50, message=" Fathers_middle_name should have atleast 50 characters")
    @Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")
    @JsonProperty("Fathers_middle_name")
    private  String Fathers_middle_name;
    @Size(min=3, max=50, message=" Fathers_last_name should have atleast 50 characters")
    @Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")
    @JsonProperty("Fathers_last_name")
    private  String Fathers_last_name;
    @Size(min=4, max=10, message=" father_religion should have atleast 10 characters")
    @Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")
    @JsonProperty("father_religion")
    private  String father_religion;
    @Size(min=3, max=50, message=" Mothers_first_name should have atleast 50 characters")
    @Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")
    @JsonProperty("Mothers_first_name")
    private String Mothers_first_name;
    @Size(min=1, max=50, message=" Mothers_middle_name should have atleast 50 characters")
    @Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")
    @JsonProperty("Mothers_middle_name")
    private  String Mothers_middle_name;
    @Size(min=3, max=50, message=" Mothers_last_name should have atleast 50 characters")
    @Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")
    @JsonProperty("Mothers_last_name")
    private String Mothers_last_name;
    @Size(min=4, max=10, message=" mother_religion should have atleast 10 characters")
    @Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")
    @JsonProperty("mother_religion")
    private  String mother_religion;


}
