package com.dkd.mailServiceImpl;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.dkd.mailService.MailService;

@Component
public class MailServiceImpl implements MailService{
	
	@Autowired
	private JavaMailSender mailSender;

	@Value("${mail.fromMail.addr}")
	private String from;
	
	//发送简单邮件
    @Override
    public void sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        try {
            mailSender.send(message);
            System.out.println("发送简单邮件成功！");
        } catch (Exception e) {
        	System.out.println("发送简单邮件时发生异常！");
        	e.printStackTrace();
        }

    }
		
    //发送html邮件
	@Override
	public void sendHtmlMail(String to, String subject, String content) {
	    MimeMessage message = mailSender.createMimeMessage();
	    try {
	        //true表示需要创建一个multipart message
	        MimeMessageHelper helper = new MimeMessageHelper(message, true);
	        helper.setFrom(from);
	        helper.setTo(to);
	        helper.setSubject(subject);
	        helper.setText(content, true);
	        mailSender.send(message);
	        System.out.println("发送html邮件成功！");
	    } catch (MessagingException e) {
	        System.out.println("发送html邮件时发生异常！");
	        e.printStackTrace();
	    }
		
	}
	
	//发送带有附件的邮件
	@Override
	public void sendAttachmentsMail(String to, String subject, String content, String filePath) {
	    MimeMessage message = mailSender.createMimeMessage();
	    try {
	        MimeMessageHelper helper = new MimeMessageHelper(message, true);
	        helper.setFrom(from);
	        helper.setTo(to);
	        helper.setSubject(subject);
	        helper.setText(content, true);
	        FileSystemResource file = new FileSystemResource(new File(filePath));
	        helper.addAttachment("测试图片", file);
	        mailSender.send(message);
	        System.out.println("带附件的邮件已经发送。");
	    } catch (MessagingException e) {
	    	System.out.println("发送带附件的邮件时发生异常！");
	    	e.printStackTrace();
	    }
		
	}
	
	//发送具有静态资源的邮件
	@Override
	public void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId) {
	    MimeMessage message = mailSender.createMimeMessage();

	    try {
	        MimeMessageHelper helper = new MimeMessageHelper(message, true);
	        helper.setFrom(from);
	        helper.setTo(to);
	        helper.setSubject(subject);
	        helper.setText(content, true);

	        FileSystemResource res = new FileSystemResource(new File(rscPath));
	        helper.addInline(rscId, res);

	        mailSender.send(message);
	        System.out.println("邮件发送成功!");
	    } catch (MessagingException e) {
	    	System.out.println("邮件发送出现异常！");
	    	e.printStackTrace();
	    	
	    }
		
	}

}
