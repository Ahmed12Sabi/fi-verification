
package ai.lentra.modal.allocation;

import javax.persistence.*;

@Entity
@Table(name = "m_branches")
public class BranchDealer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long key;
    private String label;
    private String location;
    private String region;
    private String zone;
    private String pincode;
    private String latitude;

  public long getKey() {
    return key;
  }

  public void setKey(long key) {
    this.key = key;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public String getZone() {
    return zone;
  }

  public void setZone(String zone) {
    this.zone = zone;
  }

  public String getPincode() {
    return pincode;
  }

  public void setPincode(String pincode) {
    this.pincode = pincode;
  }

  public String getLatitude() {
    return latitude;
  }

  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }

  public String getLongitude() {
    return longitude;
  }

  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public Boolean getActive() {
    return isActive;
  }

  public void setActive(Boolean active) {
    isActive = active;
  }

  private String longitude;
    private String country;
    private Boolean isActive;
}
