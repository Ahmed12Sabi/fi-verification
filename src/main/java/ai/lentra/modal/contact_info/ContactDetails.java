package ai.lentra.modal.contact_info;

import ai.lentra.modal.lookups.SimCardType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
public class ContactDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
 private long id;

    @Column(name = "applicant_id")
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
}