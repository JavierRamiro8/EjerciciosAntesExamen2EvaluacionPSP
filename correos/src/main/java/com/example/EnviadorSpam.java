package com.example;

import org.simplejavamail.api.email.Email;
import org.simplejavamail.api.mailer.Mailer;
import org.simplejavamail.api.mailer.config.TransportStrategy;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;

import com.example.LectorSpam.ObservadorCorreos;

public class EnviadorSpam implements ObservadorCorreos {
    private String usuario;
    private String contrasena;

    public EnviadorSpam(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    @Override
    public void actualizar(String mensaje, String correo) {
        Email email = EmailBuilder.startingBlank()
                .to("Javier", correo)
                .from("Javier", "javier.ramiro8@educa.madrid.org")
                .withReplyTo("javier", "javier.ramiro8@educa.madrid.org")
                .withSubject("MIAU")
                .withPlainText(mensaje)
                .buildEmail();

        Mailer mailer = MailerBuilder
                .withSMTPServer("smtp.educa.madrid.org", 587, usuario, contrasena)
                .withTransportStrategy(TransportStrategy.SMTP_TLS)
                .clearEmailValidator() // turns off email validation
                .buildMailer();
        mailer.sendMail(email);
    }
}
