package ai.lentra.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.util.Date;


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

 public Integer getFamilyDetailsId() {
  return familyDetailsId;
 }

 public void setFamilyDetailsId(Integer familyDetailsId) {
  this.familyDetailsId = familyDetailsId;
 }

 public String getNo_of_dependants() {
  return no_of_dependants;
 }

 public void setNo_of_dependants(String no_of_dependants) {
  this.no_of_dependants = no_of_dependants;
 }

 public String getNo_of_minor() {
  return no_of_minor;
 }

 public void setNo_of_minor(String no_of_minor) {
  this.no_of_minor = no_of_minor;
 }

 public String getChild_educational_level() {
  return child_educational_level;
 }

 public void setChild_educational_level(String child_educational_level) {
  this.child_educational_level = child_educational_level;
 }

 public Integer getSpouse_age() {
  return spouse_age;
 }

 public void setSpouse_age(Integer spouse_age) {
  this.spouse_age = spouse_age;
 }

 public Integer getFather_age() {
  return father_age;
 }

 public void setFather_age(Integer father_age) {
  this.father_age = father_age;
 }

 public Integer getMother_age() {
  return mother_age;
 }

 public void setMother_age(Integer mother_age) {
  this.mother_age = mother_age;
 }

 public String getSpouse_citizenship() {
  return spouse_citizenship;
 }

 public void setSpouse_citizenship(String spouse_citizenship) {
  this.spouse_citizenship = spouse_citizenship;
 }

 public boolean isEntity_confirmation_spouse() {
  return entity_confirmation_spouse;
 }

 public void setEntity_confirmation_spouse(boolean entity_confirmation_spouse) {
  this.entity_confirmation_spouse = entity_confirmation_spouse;
 }

 public boolean isSpouse_working() {
  return spouse_working;
 }

 public void setSpouse_working(boolean spouse_working) {
  this.spouse_working = spouse_working;
 }

 public String getSpouse_occupation() {
  return spouse_occupation;
 }

 public void setSpouse_occupation(String spouse_occupation) {
  this.spouse_occupation = spouse_occupation;
 }

 public boolean isEntity_confirmation_father() {
  return entity_confirmation_father;
 }

 public void setEntity_confirmation_father(boolean entity_confirmation_father) {
  this.entity_confirmation_father = entity_confirmation_father;
 }

 public boolean isEntity_confirmation_mother() {
  return entity_confirmation_mother;
 }

 public void setEntity_confirmation_mother(boolean entity_confirmation_mother) {
  this.entity_confirmation_mother = entity_confirmation_mother;
 }

 public String getSpouse_last_name() {
  return spouse_last_name;
 }

 public void setSpouse_last_name(String spouse_last_name) {
  this.spouse_last_name = spouse_last_name;
 }

 public String getSpouse_first_name() {
  return spouse_first_name;
 }

 public void setSpouse_first_name(String spouse_first_name) {
  this.spouse_first_name = spouse_first_name;
 }

 public String getSpouse_mid_name() {
  return spouse_mid_name;
 }

 public void setSpouse_mid_name(String spouse_mid_name) {
  this.spouse_mid_name = spouse_mid_name;
 }

 public String getSpouse_suffix() {
  return spouse_suffix;
 }

 public void setSpouse_suffix(String spouse_suffix) {
  this.spouse_suffix = spouse_suffix;
 }

 public String getSpouse_alias() {
  return spouse_alias;
 }

 public void setSpouse_alias(String spouse_alias) {
  this.spouse_alias = spouse_alias;
 }

 public Date getSpouse_birth_date() {
  return spouse_birth_date;
 }

 public void setSpouse_birth_date(Date spouse_birth_date) {
  this.spouse_birth_date = spouse_birth_date;
 }

 public String getSpouse_religion() {
  return spouse_religion;
 }

 public void setSpouse_religion(String spouse_religion) {
  this.spouse_religion = spouse_religion;
 }

 public String getFathers_first_name() {
  return Fathers_first_name;
 }

 public void setFathers_first_name(String fathers_first_name) {
  Fathers_first_name = fathers_first_name;
 }

 public String getFathers_middle_name() {
  return Fathers_middle_name;
 }

 public void setFathers_middle_name(String fathers_middle_name) {
  Fathers_middle_name = fathers_middle_name;
 }

 public String getFathers_last_name() {
  return Fathers_last_name;
 }

 public void setFathers_last_name(String fathers_last_name) {
  Fathers_last_name = fathers_last_name;
 }

 public String getFather_religion() {
  return father_religion;
 }

 public void setFather_religion(String father_religion) {
  this.father_religion = father_religion;
 }

 public String getMothers_first_name() {
  return Mothers_first_name;
 }

 public void setMothers_first_name(String mothers_first_name) {
  Mothers_first_name = mothers_first_name;
 }

 public String getMothers_middle_name() {
  return Mothers_middle_name;
 }

 public void setMothers_middle_name(String mothers_middle_name) {
  Mothers_middle_name = mothers_middle_name;
 }

 public String getMothers_last_name() {
  return Mothers_last_name;
 }

 public void setMothers_last_name(String mothers_last_name) {
  Mothers_last_name = mothers_last_name;
 }

 public String getMother_religion() {
  return mother_religion;
 }

 public void setMother_religion(String mother_religion) {
  this.mother_religion = mother_religion;
 }
}
