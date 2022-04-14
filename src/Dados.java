    public class Dados {
    private String status;
    private String message;
    private String country;
    private String countryCode;
    public String getStatus() {
        return status;
    }
    public String getCountryCode() {
        return countryCode;
    }
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public void setStatus(String status) {
        this.status = status;
    }       
}