package step.learning.services.culture;

public class StringResourceProvider implements ResourceProvider{

    private String defaultCulture;
    @Override
    public String getString(String name, String culture) {
        switch (name){
            case "signup_login_too_short":
                switch (culture){
                    default: return "Too short login";
                }
            case "signup_login_empty" :
                switch (culture){
                    default: return "Login cannot be empty";
                }
            case "signup_login_pattern_mismatch" :
                switch (culture){
                    default: return "Login contains invalid characters";
                }

            case "signup_name_empty" :
                switch (culture){
                    default: return "Name cannot be empty";
                }
            case "signup_phone_empty" :
                switch (culture){
                    default: return "Phone cannot be empty";
                }
            case "signup_birthdate_empty" :
                switch (culture) {
                    default:
                        return "Birthdate cannot be empty";
                }
            case "signup_password_empty" :
                switch (culture) {
                    default:
                        return "Password cannot be empty";
                }
            case "signup_repeat_empty" :
                switch (culture) {
                    default:
                        return "Repeat password";
                }
            case "signup_isAgree_empty" :
                switch (culture) {
                    default:
                        return "Please sign";
                }

        }


        return null;
    }

    @Override
    public String getString(String name) {
        return getString(name, defaultCulture);
    }

    @Override
    public void setCulture(String culture) {
        defaultCulture = culture;
    }

    @Override
    public String getCulture() {
        return null;
    }


}
