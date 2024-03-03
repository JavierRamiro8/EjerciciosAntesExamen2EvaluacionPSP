package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.simplejavamail.api.email.Email;
import org.simplejavamail.api.mailer.Mailer;
import org.simplejavamail.api.mailer.config.TransportStrategy;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args)throws IOException {

        String archivoMensajes=args[0];
        String archivoCorreos=args[1];
        String usuario=args[2];
        String contrasena=args[3];

        BufferedReader lectorCorreos=new BufferedReader(new FileReader(archivoCorreos));
        BufferedReader lectorMensajes=new BufferedReader(new FileReader(archivoMensajes));
        

        while(lectorCorreos.readLine()!=null && lectorMensajes.readLine()!=null){
            String cuentaCorreo=lectorCorreos.readLine().toString();
            String mensajes=lectorMensajes.readLine().toString();
            Email email = EmailBuilder.startingBlank()
            .to("Javier", cuentaCorreo)
            .from("Javier", "javier.ramiro8@educa.madrid.org")
            .withReplyTo("javier", "javier.ramiro8@educa.madrid.org")
            .withSubject("MIAU")
            .withPlainText(mensajes)
            .buildEmail();

    Mailer mailer = MailerBuilder
            .withSMTPServer("smtp.educa.madrid.org", 587, usuario, contrasena)
            .withTransportStrategy(TransportStrategy.SMTP_TLS)
            .clearEmailValidator() // turns off email validation
            .buildMailer();
    mailer.sendMail(email);
        }
        lectorCorreos.close();
        lectorMensajes.close();
    }
}