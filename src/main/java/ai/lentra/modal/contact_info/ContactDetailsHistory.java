package ai.lentra.modal.contact_info;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.sql.Timestamp;
import java.time.Instant;

@Entity

@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
public class ContactDetailsHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "applicant_id", nullable = false)
    private long applicantId;
    @Pattern(regexp = "^\\d{10,13}$",message = "Mobile number should contain 10 to 13 digits only")
    private String mobileNumber;

    @Pattern(regexp = "^[a-zA-Z0-9._%+-]{1,64}@[a-zA-Z0-9.-]{1,63}\\.[a-zA-Z]{2,}$",message = "Email must be well formed")
    private String personalEmail;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "sim_card_type")
    private String simType;

    private boolean mobileNumberVerified;

    @Pattern(regexp = "^\\d{10,13}$",message = "Phone number should contain 10 to 13 digits only")
    private String phoneNumber;

    private boolean phoneNumberVerified;
    private boolean personalEmailVerified;
    private boolean contDomainCheck;
    private boolean registeredWithBank;

    private Timestamp modifiedAt=Timestamp.from(Instant.now());
    private String modifiedBy;
    private String branchName;
    private String roleType;
    private String insId;
    private String productType;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(long applicantId) {
        this.applicantId = applicantId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPersonalEmail() {
        return personalEmail;
    }

    public void setPersonalEmail(String personalEmail) {
        this.personalEmail = personalEmail;
    }

    public String getSimType() {
        return simType;
    }

    public void setSimType(String simType) {
        this.simType = simType;
    }

    public boolean isMobileNumberVerified() {
        return mobileNumberVerified;
    }

    public void setMobileNumberVerified(boolean mobileNumberVerified) {
        this.mobileNumberVerified = mobileNumberVerified;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isPhoneNumberVerified() {
        return phoneNumberVerified;
    }

    public void setPhoneNumberVerified(boolean phoneNumberVerified) {
        this.phoneNumberVerified = phoneNumberVerified;
    }

    public boolean isPersonalEmailVerified() {
        return personalEmailVerified;
    }

    public void setPersonalEmailVerified(boolean personalEmailVerified) {
        this.personalEmailVerified = personalEmailVerified;
    }

    public boolean isContDomainCheck() {
        return contDomainCheck;
    }

    public void setContDomainCheck(boolean contDomainCheck) {
        this.contDomainCheck = contDomainCheck;
    }

    public boolean isRegisteredWithBank() {
        return registeredWithBank;
    }

    public void setRegisteredWithBank(boolean registeredWithBank) {
        this.registeredWithBank = registeredWithBank;
    }

    public Timestamp getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Timestamp modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getInsId() {
        return insId;
    }

    public void setInsId(String insId) {
        this.insId = insId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }
}