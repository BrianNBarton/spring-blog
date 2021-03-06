package com.codeup.blog.services;

import com.codeup.blog.models.Ad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("mailService")
public class EmailServices {

    @Autowired
    public JavaMailSender emailSender;
//
//    @Value("${spring.mail.from}")
//    private String from;

    public void prepareAndSend(String toEmail, String subject, String body) {
        SimpleMailMessage msg = new SimpleMailMessage();
//        msg.setFrom(from);
        msg.setTo(toEmail);
        msg.setSubject(subject);
        msg.setText(body);
        new Thread(new RunnableEmail(this, msg)).start();
    }
}

class RunnableEmail implements Runnable {
    private EmailServices emailService;
    private SimpleMailMessage msg;

    public RunnableEmail(EmailServices emailService, SimpleMailMessage msg) {
        this.emailService = emailService;
        this.msg = msg;
    }

    @Override
    public void run() {
        try{
            emailService.emailSender.send(msg);
        }
        catch (MailException ex) {
            // simply log it and go on...
            System.err.println(ex.getMessage());
        }
    }
}