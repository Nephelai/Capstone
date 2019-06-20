package triplej.capstone.services;

import lombok.AllArgsConstructor;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import triplej.capstone.dtos.RestaurantEmailDto;

import java.text.SimpleDateFormat;

@Service
@AllArgsConstructor
public class EmailService {
    JavaMailSender emailSender;
    private FindRestaurantsInfoService findRestaurantsInfoService;

    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.emailSender = javaMailSender;
    }

    private void sendSimpleMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        try {
            emailSender.send(message);
        } catch (MailException e) {
            e.printStackTrace();
        }
    }

    public void constructMessage(String id, String username, String count, String phonenumber) {
        SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
        RestaurantEmailDto restaurantEmail = findRestaurantsInfoService.findEmailById(id);
        String to = restaurantEmail.getEmail();
        String subject = username;
        String text = "사용자 수 : " + count + "\n 전화번호 : " + phonenumber + "\n 예약시간 : " + format.format(System.currentTimeMillis());
        sendSimpleMessage(to, subject, text);
    }
}
