package cn.com.ssdut.forum.common;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class Email_Authenticator extends Authenticator
{
	private String username,password;
	
    public Email_Authenticator()
    {
        super();
    }

    public Email_Authenticator(String user, String pwd)
    {
        super();
        username = user;
        password = pwd;
    }

    public PasswordAuthentication getPasswordAuthentication()
    {
        return new PasswordAuthentication(username, password);
    }
}
