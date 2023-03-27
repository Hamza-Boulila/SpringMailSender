package com.hbl.springemailsender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
    @Autowired
    private JavaMailSender mailSender;

    @Value("${app.mail.to}")
    String toEmail;
    @Value("${app.mail.subject}")
    String subject;
    @Value("${app.mail.text}")
    String body;

    public void sendEmail()
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);

        mailSender.send(message);

        System.out.println("Mail sent successfully...");
    }

}
