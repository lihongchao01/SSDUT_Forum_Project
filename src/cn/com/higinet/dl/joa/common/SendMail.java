package cn.com.higinet.dl.joa.common;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class SendMail {
	public void SendMailText(String email,String subject,String text){
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("./resources/spring/joa-applicationContext.xml");  
        //取得配置  
        JavaMailSender mailSender = (JavaMailSender) context.getBean("mailSender");  
        SimpleMailMessage mail = new SimpleMailMessage();  
        mail.setFrom("hhyyjjkkzz@126.com");  
        mail.setTo(email);  
        mail.setSubject(subject);   
        mail.setText(text);  
        mailSender.send(mail);
	}
	public void SendMailtoHtml(String email,String subject,String text) throws MessagingException{
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext context =new ClassPathXmlApplicationContext("./resources/spring/joa-applicationContext.xml");
		JavaMailSender mailSender=(JavaMailSender) context.getBean("mailSender");
		MimeMessage mailMessage=mailSender.createMimeMessage();	
		MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mailMessage,"UTF-8");
		mimeMessageHelper.setTo(email);
		mimeMessageHelper.setFrom("hhyyjjkkzz@126.com");
		mimeMessageHelper.setSubject(subject);
		mimeMessageHelper.setText(text,true);
		mailSender.send(mailMessage);
	}

}
