package com.wildcodeschool.webook.Auth.domain.service.interfaces;


import com.mailjet.client.errors.MailjetException;

public interface IEmailService {
    public void SendMail(String recipientEmail, String body) throws MailjetException;
}
