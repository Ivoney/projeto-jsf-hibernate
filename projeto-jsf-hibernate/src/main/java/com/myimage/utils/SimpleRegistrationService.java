/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myimage.utils;

/**
 *
 * @author Yvonei
 */
import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.myimage.model.Profile;

import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;

public class SimpleRegistrationService {

    private JavaMailSender mailSender;
    private VelocityEngine velocityEngine;

    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void setVelocityEngine(VelocityEngine velocityEngine) {
        this.velocityEngine = velocityEngine;
    }

    public void register(Profile profile) {

        sendConfirmationEmail(profile);
    }

    private void sendConfirmationEmail(final Profile profile) {

        MimeMessagePreparator preparator = new MimeMessagePreparator() {

            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                message.setTo(profile.getEmail());
                message.setSubject("Confirmação de cadastro");
                message.setFrom("MyImage.com");
                
                Map<String, Object> model = new HashMap<String, Object>();

                model.put("profile", profile);
                model.put("context", Context.getContextPath());
                String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "template/registration-confirmation.vm", "ISO-8859-1", model);
                message.setText(text, true);

            }
        };
        this.mailSender.send(preparator);
    }

}
