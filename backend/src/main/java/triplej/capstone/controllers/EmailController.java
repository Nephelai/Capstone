package triplej.capstone.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import triplej.capstone.services.EmailService;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@Slf4j
public class EmailController {
    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    EmailService emailService;

    @PostMapping("/email")
    public String emailSend(@RequestBody Map<String, Object> params) {
        emailService.setJavaMailSender(javaMailSender);
        emailService.constructMessage(params.get("id").toString(), params.get("name").toString(), params.get("number").toString(), params.get("phone").toString());
        return "success";
    }
}
