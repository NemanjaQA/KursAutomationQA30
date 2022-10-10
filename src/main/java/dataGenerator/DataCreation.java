package dataGenerator;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataCreation {
    public static String firstName(){
        return new Faker(new Locale("en-GB")).name().firstName();
    }
    public static String lastName(){
        return new Faker().name().lastName();
    }
    public static String email(){
        return new Faker().internet().emailAddress();
    }
    public static String password(){
        return new Faker().internet().password();
    }
    public static String address(){
        return new Faker().address().fullAddress();
    }
    public static String cityName(){
        return new Faker().address().city();
    }
    public static String postalCode(){
        return new Faker().number().digits(5);
    }
    public static String mobilePhone(){
        return new Faker().phoneNumber().cellPhone();
    }

    public static String state() {
        return new Faker().address().state();
    }




}
