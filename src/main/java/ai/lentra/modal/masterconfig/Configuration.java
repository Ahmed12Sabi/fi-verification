package ai.lentra.modal.masterconfig;
public class Configuration {
private long id;
   private String fieldName;
    private String profileName;
    private String vType;
    private String userType;
    private String subProfileName;
    private String formName;

 public long getId() {
  return id;
 }

 public void setId(long id) {
  this.id = id;
 }

 public String getFieldName() {
  return fieldName;
 }

 public void setFieldName(String fieldName) {
  this.fieldName = fieldName;
 }

 public String getProfileName() {
  return profileName;
 }

 public void setProfileName(String profileName) {
  this.profileName = profileName;
 }

 public String getvType() {
  return vType;
 }

 public void setvType(String vType) {
  this.vType = vType;
 }

 public String getUserType() {
  return userType;
 }

 public void setUserType(String userType) {
  this.userType = userType;
 }

 public String getSubProfileName() {
  return subProfileName;
 }

 public void setSubProfileName(String subProfileName) {
  this.subProfileName = subProfileName;
 }

 public String getFormName() {
  return formName;
 }

 public void setFormName(String formName) {
  this.formName = formName;
 }
}
