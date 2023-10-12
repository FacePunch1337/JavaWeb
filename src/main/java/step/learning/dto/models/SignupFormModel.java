package step.learning.dto.models;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class SignupFormModel {
    private static final SimpleDateFormat formDateFormat =
            new SimpleDateFormat( "yyyy-MM-dd" ) ;

    public SignupFormModel( HttpServletRequest request ) throws ParseException {
        this.setLogin( request.getParameter( "reg-login" ) ) ;
        this.setName( request.getParameter( "reg-name" ) ) ;
        this.setPhone( request.getParameter( "reg-phone" ) ); ;
        this.setPassword( request.getParameter( "reg-password" ) ) ;
        this.setRepeat( request.getParameter( "reg-repeat" ) ) ;
        this.setEmail( request.getParameter( "reg-email" ) ) ;
        this.setAgree( request.getParameter( "reg-agree" ) ) ;
        this.setBirthdate( request.getParameter( "reg-birthdate" ) ) ;
    }

    /**
     * Валідація кожного з полів та формування повідомлень про помилки.
     * Порожня відповідь означає успішну валідацію
     * @return словник "ім'я поля" - "повідомлення про помилку"
     */
    public Map<String, String> getValidationErrorMessages() {
        Map<String, String> result = new HashMap<>();
        result.putAll(loginCheckValidation());
        result.putAll(emailCheckValidation());
        result.putAll(birthdateCheckValidation());
        result.putAll(nameCheckValidation());
        result.putAll(phoneCheckValidation());
        result.putAll(passwordCheckValidation());
        result.putAll(repeatPasswordCheckValidation());
        result.putAll(agreeCheckValidation());





        return result ;
    }

    private HashMap agreeCheckValidation() {
        HashMap result = new HashMap();
        if (isAgree == null || !isAgree) {
            result.put("isAgree", "Please sign");
        }
        return result;
    }

    private HashMap birthdateCheckValidation() {
        HashMap result = new HashMap();
        if( birthdate == null ) {
            result.put( "birthdate", "Birthdate cannot be empty" ) ;
        }
        return result;
    }
    private HashMap nameCheckValidation() {
        HashMap result = new HashMap();
        if( name == null || name.isEmpty() ) {
            result.put( "name", "Name cannot be empty" ) ;
        }
        return result;
    }
    private HashMap phoneCheckValidation() {
        HashMap result = new HashMap();
        if( phone == null || phone.isEmpty() ) {
            result.put( "phone", "Phone cannot be empty" ) ;
        }
        else if (!Pattern.matches("^[0-9+]+$", phone)) {
            result.put("phone", "Phone must consist only of digits");
        }
        return result;
    }

    private HashMap passwordCheckValidation() {
        HashMap result = new HashMap();
        if( password == null || password.isEmpty() ) {
            result.put( "password", "Password cannot be empty" ) ;
        }
        else if(!Pattern.matches("^[a-zA-Z0-9_-]+$",password)){
            result.put("password", "The password must consist only of numbers and Latin letters");
        }
        return result;
    }

    private HashMap repeatPasswordCheckValidation() {
        HashMap result = new HashMap();
        if( repeat == null || repeat.isEmpty()) {
            result.put( "repeat", "Repeat password" ) ;
        }
        else if(!repeat.equals(password)){
            result.put("repeat", "Passwords do not match");
        }

        return result;
    }


    public HashMap loginCheckValidation(){
        HashMap result = new HashMap();
        if( login == null || login.isEmpty() ) {
            result.put( "login", "Login cannot be empty" ) ;
        }
        else if(login.length() < 2){
            result.put("login", "Too short login");
        }
        else if(!Pattern.matches("^[a-zA-Z0-9_-]+$",login)){
            result.put("login", "Login contains invalid characters");
        }

        return result;
    }

    public HashMap emailCheckValidation(){
        HashMap result = new HashMap();
        if( email == null || email.isEmpty() ) {
            result.put( "email", "Email cannot be empty" ) ;
        }
        else if(!Pattern.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", email)){
            result.put("email", "Email has an incorrect format 'example@mail.com'");
        }



        return result;
    }

    // region fields
    private String login ;
    private String name ;

    private String phone ;
    private String password ;
    private String repeat ;
    private String email ;
    private Date birthdate ;
    private Boolean isAgree ;
    // endregion

    // region accessors
    public void setBirthdate( String birthdate ) throws ParseException {
        if( birthdate == null || birthdate.isEmpty() ) {
            this.birthdate = null ;
        }
        else {
            this.setBirthdate( formDateFormat.parse( birthdate ) ) ;
        }
    }
    public void setAgree( String input ) {
        this.setAgree(
                "on".equalsIgnoreCase( input ) || "true".equalsIgnoreCase( input )
        ) ;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeat() {
        return repeat;
    }

    public void setRepeat(String repeat) {
        this.repeat = repeat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Boolean getAgree() {
        return isAgree;
    }

    public void setAgree(Boolean agree) {
        isAgree = agree;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // endregion
}