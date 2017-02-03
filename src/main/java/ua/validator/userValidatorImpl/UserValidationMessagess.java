package ua.validator.userValidatorImpl;

/**
 * Created by buriedsinner on 12/5/16.
 */
public interface UserValidationMessagess {

    String EMPTY_USERNAME_FIELD = "login field is empty";
    String NAME_CONTAINS_SYMBOLS = "Username may only contain alphanumeric characters ";
    String NAME_ALREADY_EXISTS = "NAME_ALREADY_EXISTS";
    String EMPTY_PASSWORD_FIELD = "password field is empty";
    String EMPTY_EMAIl_FIELD = "email field is empty";
    String EMAIL_ALREADY_EXIST = "this e-mail is already exists";
    String PHONE_ALREADY_EXIST = "this phone number is already exists";
    String EMPTY_PHONE_FIELD = "empty phone field";
    String BAD_PHONE_NUMBER = "number contains irregular symbols";
    String BAD_EMAIL = "email contains irregular symbols";
    String BAD_PASSWORD = " password contains irregular symbols";


}
