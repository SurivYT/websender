package com.example;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/mail")
public class mailAPI {

    @Inject
    Mailer mailer;

    @POST
    @Path("/contact")
    @Consumes(MediaType.APPLICATION_JSON)
    public void sendASimpleEmail(Contacts contacts) {

        System.out.println(contacts);

        if(contacts.phone==""||contacts.phone==null){
            contacts.phone="nicht angegeben";
        }
        Mail mail = new Mail();
        mail.setTo(List.of(new String[]{"corinna305@outlook.de"}));
        mail.setSubject("Kontaktaufnahme: "+contacts.subject);
        mail.setText("Kontaktaufnahme via Website"+ "\n" +
                "\n" +
                "Name: " + contacts.name + "\n" +
                "Email: " + contacts.email +"\n" +
                "Telefon: " + contacts.phone + "\n" +
                contacts.message);
        mail.setHtml("<h1>Kontaktaufnahme via Website</h1>" +
                "Kontaktinformationen:"+
                "<ul>" +
                "<li>Name: "+contacts.phone+"</li>" +
                "<li>Telefon:<a href=\"tel:"+contacts.phone+"\">"+contacts.phone+"</a></li>" +
                "<li>Email:<a href=\"mailto:"+contacts.email+"\">"+contacts.email+"</a></li>" +
                "</ul><br>" +
                "Nachricht:<br>"+
                contacts.message);
        mailer.send(mail);
    }
}
