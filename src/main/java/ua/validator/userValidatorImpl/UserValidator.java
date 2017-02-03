package ua.validator.userValidatorImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.DAO.UserRepository;
import ua.entities.User;
import ua.validator.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component("userValidator")
public class UserValidator implements Validator{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void validate(Object object) throws Exception {
        User user = (User) object;

        Pattern regexPattern;
        Matcher regMatcher;
        Pattern regexPattern2;
        Matcher regMatcher2;
        Pattern regexPattern3;
        Matcher regMatcher3;
        Pattern regexPattern4;
        Matcher regMatcher4;

        regexPattern = Pattern.compile("^[(a-zA-Z-0-9-\\_\\+\\.)]+@[(a-z-A-z)]+\\.[(a-zA-z)]{2,3}$");
        regMatcher = regexPattern.matcher(user.getEmail());
        regexPattern2 = Pattern.compile("^\\+[0-9]{2,3}+-[0-9]{10}$");
        regMatcher2 = regexPattern2.matcher(user.getPhone());
        regexPattern3 = Pattern.compile("[A-Za-z0-9_]+");
        regMatcher3 = regexPattern3.matcher(user.getName());
        regexPattern4 = Pattern.compile("[A-Za-z0-9_]+");
        regMatcher4 = regexPattern4.matcher(user.getPassword());
       if(!validateLetters(user.getName())){
           throw new UserValidationException(UserValidationMessagess.NAME_CONTAINS_SYMBOLS);
        }
        if(user.getName().isEmpty()){
            throw new UserValidationException(UserValidationMessagess.EMPTY_USERNAME_FIELD);
        }
        if(userRepository.findByName(user.getName()) != null){
            throw  new UserValidationException(UserValidationMessagess.NAME_ALREADY_EXISTS);
        }
        if(user.getPassword().isEmpty()){
            throw new UserValidationException(UserValidationMessagess.EMPTY_PASSWORD_FIELD);
        }
        if(user.getEmail().isEmpty()){
            throw new UserValidationException(UserValidationMessagess.EMPTY_EMAIl_FIELD);
        }
        if(userRepository.userExistsByEmail(user.getEmail())){
            throw new UserValidationException(UserValidationMessagess.EMAIL_ALREADY_EXIST);
        }
       /* if(user.getPhone().isEmpty()){
            throw new UserValidationException(UserValidationMessagess.EMPTY_PHONE_FIELD);
        }
        if(userRepository.findByPhone(user.getPhone()) != null){
            throw new UserValidationException(UserValidationMessagess.PHONE_ALREADY_EXIST);
        }*/
        if(regMatcher.matches()){

        }else{
            throw new UserValidationException(UserValidationMessagess.BAD_EMAIL);
        }

        /*if(regMatcher2.matches()){

        }else{
            throw new UserValidationException(UserValidationMessagess.BAD_PHONE_NUMBER);
        }*/

        if(regMatcher3.matches()){

        }else{
            throw new UserValidationException(UserValidationMessagess.NAME_CONTAINS_SYMBOLS);
        }

        if(regMatcher4.matches()){

        }else{
            throw new UserValidationException(UserValidationMessagess.BAD_PASSWORD);
        }


    }
    private boolean validateLetters(String string){ return string.matches("^[\\p{L} .'-]+$");}
}
