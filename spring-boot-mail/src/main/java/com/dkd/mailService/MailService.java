package com.dkd.mailService;

public interface MailService {
	//发送简单邮件方法
	public void sendSimpleMail(String to, String subject, String content);
	//发送带有Html页面的邮件
	public void sendHtmlMail(String to, String subject, String content);
	//发送带附件的邮件
	public void sendAttachmentsMail(String to, String subject, String content, String filePath);
	//发送带有静态资源(图片)的邮件
	public void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId);
}
