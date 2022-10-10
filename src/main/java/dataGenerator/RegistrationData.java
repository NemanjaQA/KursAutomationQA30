package dataGenerator;

import com.github.javafaker.Faker;

public class RegistrationData {

    private String firstName;
    private String lastName;
    private String adress;
    private String email;
    private String password;
    private String cityName;
    private String postalCode;
    private String mobilePhone;
    private String state;

    public RegistrationData() {
    }

    public RegistrationData(String firstName, String lastName, String adress, String email, String password, String cityName, String postalCode, String mobilePhone, String state) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.adress = adress;
        this.email = email;
        this.password = password;
        this.cityName = cityName;
        this.postalCode = postalCode;
        this.mobilePhone = mobilePhone;
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public static RegistrationData generateRandomUser() {
        RegistrationData randomUser = new RegistrationData();
        randomUser.setFirstName(DataCreation.firstName());
        randomUser.setLastName(new Faker().name().lastName());
        randomUser.setEmail(new Faker().internet().emailAddress());
        randomUser.setAdress(new Faker().address().fullAddress());
        randomUser.setCityName(new Faker().address().city());
        randomUser.setMobilePhone(new Faker().phoneNumber().cellPhone());
        randomUser.setPostalCode(new Faker().number().digits(5));
        randomUser.setState(new Faker().address().state());
        randomUser.setPassword(new Faker().internet().password(8, 10, true, true, true));
        return randomUser;

    }
}
