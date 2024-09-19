package com.tareas.tareas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.tareas.tareas.models.tarea;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class emailService {
    
    @Autowired
    private JavaMailSender javaMailSender;

     public String enviarCorreoRegistro(String destinatario) {
        try {
            String asunto = "Le damos la bienvenida a nuestro sitio web";
            String cuerpo = ""
                    + "<body style=\"font-family: Arial, sans-serif; background-color: #f4f4f4; padding: 20px;\">\r\n"
                    + "<div style=\"max-width: 600px; margin: 0 auto; background-color: #ffffff; padding: 20px; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\">\r\n"
                    + "  <h1 style=\"font-size: 24px; font-weight: bold; color: #333333;\">¡Hola!</h1>\r\n"
                    + "  <p style=\"font-size: 16px; color: #555555;\">Estamos emocionados de darte la bienvenida a Nuestro sitio web.</p>\r\n"
                    + "  <p style=\"font-size: 16px; color: #555555;\">Esperamos poder brindarle la mejor experiencia posible.</p>\r\n"
                    + "  <p style=\"font-size: 16px; color: #555555;\">No dudes en explorar todas las funciones y contactarnos si necesitas ayuda.</p>\r\n"
                    + "</div>\r\n"
                    + "</body>";

            var retorno = enviarCorreo(destinatario, asunto, cuerpo);
            if (retorno) {
                return "Se envio correctamente";
            } else {
                return "No se pudo enviar";
            }

        } catch (Exception e) {
            return "Error al enviar" + e.getMessage();
        }
    }

    public String cambiarTipoDocumento(tarea tarea) {
        try {
            String asunto = "Es hora de actualizar su tipo de documento";
            String cuerpo = ""
                    + "<body style=\"font-family: Arial, sans-serif; background-color: #f4f4f4; padding: 20px;\">\r\n"
                    + "<div style=\"max-width: 600px; margin: 0 auto; background-color: #ffffff; padding: 20px; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\">\r\n"
                    + "  <h1 style=\"font-size: 24px; font-weight: bold; color: #333333;\">¡Hola! " 
                    + "</h1>\r\n"
                    + "  <p style=\"font-size: 16px; color: #555555;\">Queremos recordarte que es el momento de actualizar tu tipo de documento. Es un proceso rápido que te ayudará a mantener tus datos al día en nuestra web.</p>\r\n"
                    + "  <p style=\"font-size: 16px; color: #555555;\">Por favor, accede a tu cuenta y realiza la actualización lo antes posible.</p>\r\n"
                    + "  <p style=\"font-size: 16px; color: #555555;\">Gracias por tu colaboración.</p>\r\n"
                    + "</div>\r\n"
                    + "</body>";

            var retorno = enviarCorreo(tarea.getAssignedTo(), asunto, cuerpo);
            if (retorno) {
                return "se envió correctamente";
            } else {
                return "No se pudo envíar";
            }

        } catch (Exception e) {
            // TODO: handle exception
            return "Error al envíar " + e.getMessage();
        }
    }

    public String actualizarPassword(tarea tarea) {
        try {
            String asunto = "Es hora de actualizar su contraseña";
            String cuerpo = ""
                    + "<body style=\"font-family: Arial, sans-serif; background-color: #f4f4f4; padding: 20px;\">\r\n"
                    + "<div style=\"max-width: 600px; margin: 0 auto; background-color: #ffffff; padding: 20px; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\">\r\n"
                    + "  <h1 style=\"font-size: 24px; font-weight: bold; color: #333333;\">¡Hola! "
                    + "</h1>\r\n"
                    + "  <p style=\"font-size: 16px; color: #555555;\">Queremos recordarte que es el momento de actualizar su contraseña. Es un proceso rápido que te ayudará a mantener tus datos al día en nuestra web.</p>\r\n"
                    + "  <p style=\"font-size: 16px; color: #555555;\">Por favor, accede a tu cuenta y realiza la actualización lo antes posible.</p>\r\n"
                    + "  <p style=\"font-size: 16px; color: #555555;\">Gracias por tu colaboración.</p>\r\n"
                    + "</div>\r\n"
                    + "</body>";

            var retorno = enviarCorreo(tarea.getAssignedTo(), asunto, cuerpo);
            if (retorno) {
                return "se envió correctamente";
            } else {
                return "No se pudo envíar";
            }

        } catch (Exception e) {
            // TODO: handle exception
            return "Error al envíar " + e.getMessage();
        }
    }

    public String inicioSesionNotificar(tarea tarea) {
        try {
            String asunto = "Es hora de actualizar su contraseña";
            String cuerpo = ""
                    + "<body style=\"font-family: Arial, sans-serif; background-color: #f4f4f4; padding: 20px;\">\r\n"
                    + "<div style=\"max-width: 600px; margin: 0 auto; background-color: #ffffff; padding: 20px; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\">\r\n"
                    + "  <h1 style=\"font-size: 24px; font-weight: bold; color: #333333;\">¡Hola! "
                    + "</h1>\r\n"
                    + "  <p style=\"font-size: 16px; color: #555555;\">Queremos recordarte que es el momento de iniciar sesion. Es un proceso rápido que te ayudará a mantener tus datos al día en nuestra web.</p>\r\n"
                    + "  <p style=\"font-size: 16px; color: #555555;\">Por favor, accede a tu cuenta y realiza la actualización lo antes posible.</p>\r\n"
                    + "  <p style=\"font-size: 16px; color: #555555;\">Gracias por tu colaboración.</p>\r\n"
                    + "</div>\r\n"
                    + "</body>";

            var retorno = enviarCorreo(tarea.getAssignedTo(), asunto, cuerpo);
            if (retorno) {
                return "se envió correctamente";
            } else {
                return "No se pudo envíar";
            }

        } catch (Exception e) {
            // TODO: handle exception
            return "Error al envíar " + e.getMessage();
        }
    }

    public boolean enviarCorreo(String destinatario, String asunto, String cuerpo) throws MessagingException {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(destinatario);
            helper.setSubject(asunto);
            helper.setText(cuerpo, true);

            javaMailSender.send(message);
            return true;
        } catch (Exception e) {

            return false;
        }

    }
}
