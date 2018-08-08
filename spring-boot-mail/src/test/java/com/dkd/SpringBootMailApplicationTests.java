package com.dkd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dkd.mailServiceImpl.MailServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMailApplicationTests {
	
    @Autowired
    private MailServiceImpl mailService;
    
    //测试简单 邮件发送
//	@Test
	public void sendSimpleMail() {
		mailService.sendSimpleMail("469920680@qq.com","test simple mail"," hello this is simple mail");
	}
	
	//测试html邮件发送
//	@Test
	public void sendHtmlMail() {
	    String content="<html>\n" +
	            "<body>\n" +
	            "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
	            "</body>\n" +
	            "</html>";
	    mailService.sendHtmlMail("469920680@qq.com","test simple mail",content);
	}
	
//	@Test
	public void sendAttachMail() {
	    String filePath="D:\\test.jpg";
	    mailService.sendAttachmentsMail("469920680@qq.com", "主题：带附件的邮件", "有附件，请查收！", filePath);
	}
	
	@Test
	public void sendInlineResourceMail() {
	    String rscId = "test";
	    String content="<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
	    String imgPath = "D:\\test.jpg";

	    mailService.sendInlineResourceMail("469920680@qq.com", "主题：这是有图片的邮件", content, imgPath, rscId);
	}
}
