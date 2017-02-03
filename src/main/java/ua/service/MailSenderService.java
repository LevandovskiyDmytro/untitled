package ua.service;

/**
 * Created by buriedsinner on 12/7/16.
 */
public interface MailSenderService {

    void sendMail(String theme,String mailBody,String email);
}
