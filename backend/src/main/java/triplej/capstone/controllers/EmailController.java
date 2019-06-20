package triplej.capstone.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import triplej.capstone.services.EmailService;

@CrossOrigin(origins = "*")
@RestController
public class EmailController {
    @Autowired
    JavaMailSender javaMailSender;

    @PostMapping("/email")
    public String emailSend() {
//        EmailService emailService = new EmailService();
//        emailService.setJavaMailSender(javaMailSender);
//        emailService.sendSimpleMessage("jaeho618@naver.com", "제목","내용");
        return "success";
    }
}
