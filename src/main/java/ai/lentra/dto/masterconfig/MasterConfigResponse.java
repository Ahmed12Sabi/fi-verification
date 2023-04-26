package ai.lentra.dto.masterconfig;


public class MasterConfigResponse {
    private long mId;
    private String userType;
    private String multiVerificationAllowed;
    private boolean retrigerVerification;
    private String productLevelLogic;
    private long profileId;
    private String subProfileName;
    private long institutionId;
    private long vId;
    private String vDescription;
    private long formId;
    private String formName;
    private String formDescription;
    private long fieldId;
    private String fieldName;
    private String fieldType;
    private boolean status;
    private boolean hidden;
    private boolean required;

    public long getmId() {
        return mId;
    }

    public void setmId(long mId) {
        this.mId = mId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getMultiVerificationAllowed() {
        return multiVerificationAllowed;
    }

    public void setMultiVerificationAllowed(String multiVerificationAllowed) {
        this.multiVerificationAllowed = multiVerificationAllowed;
    }

    public boolean isRetrigerVerification() {
        return retrigerVerification;
    }

    public void setRetrigerVerification(boolean retrigerVerification) {
        this.retrigerVerification = retrigerVerification;
    }

    public String getProductLevelLogic() {
        return productLevelLogic;
    }

    public void setProductLevelLogic(String productLevelLogic) {
        this.productLevelLogic = productLevelLogic;
    }

    public long getProfileId() {
        return profileId;
    }

    public void setProfileId(long profileId) {
        this.profileId = profileId;
    }

    public String getSubProfileName() {
        return subProfileName;
    }

    public void setSubProfileName(String subProfileName) {
        this.subProfileName = subProfileName;
    }

    public long getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(long institutionId) {
        this.institutionId = institutionId;
    }

    public long getvId() {
        return vId;
    }

    public void setvId(long vId) {
        this.vId = vId;
    }

    public String getvDescription() {
        return vDescription;
    }

    public void setvDescription(String vDescription) {
        this.vDescription = vDescription;
    }

    public long getFormId() {
        return formId;
    }

    public void setFormId(long formId) {
        this.formId = formId;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public String getFormDescription() {
        return formDescription;
    }

    public void setFormDescription(String formDescription) {
        this.formDescription = formDescription;
    }

    public long getFieldId() {
        return fieldId;
    }

    public void setFieldId(long fieldId) {
        this.fieldId = fieldId;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }
}
