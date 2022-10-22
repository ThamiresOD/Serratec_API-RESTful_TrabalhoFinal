package br.org.serratec.projeto.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class MailConfig {
	      @Autowired
	      JavaMailSender javaMailSender;

	      public void sendMail(String para, String assunto, String texto) {
		            SimpleMailMessage message = new SimpleMailMessage();
		            message.setFrom("breno.leonardof10@gmail.com"); //pode trocar por outro email de alguém no grupo
		            message.setSubject(assunto);
		            message.setText(texto);
		            message.setTo(para);
		            javaMailSender.send(message);
        //a validacao atraves do cadastro e realizada no service

	      }
}
