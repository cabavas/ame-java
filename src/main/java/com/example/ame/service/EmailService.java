package com.example.ame.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Async
    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setFrom("cabavas@gmail.com");
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);
    }

    public boolean sendEmailWithAttachment(String to, String subject, String body, byte[] attachmentData, String attachmentName) throws MessagingException {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom("MS_D5eBiD@trial-o65qngk3q7j4wr12.mlsender.net");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body);

            InputStream inputStream = new ByteArrayInputStream(attachmentData);
            helper.addAttachment(attachmentName, () -> inputStream);
            mailSender.send(message);
        } catch (MessagingException e) {
            e.getMessage();
            return false;
        }
        return true;
    }
}
