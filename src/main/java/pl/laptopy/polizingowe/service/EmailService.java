package pl.laptopy.polizingowe.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import pl.laptopy.polizingowe.model.MailToCustomers;
import pl.laptopy.polizingowe.utils.ListConverter;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender javaMailSender;
    private final ListConverter listConverter;

    public void sendSimpleMessage(MailToCustomers mailToCustomers) {
        SimpleMailMessage message = new SimpleMailMessage();
        String[] receiversArray = listConverter.convertListToArray(mailToCustomers.getReceivers());
        message.setTo(receiversArray);
        message.setSubject(mailToCustomers.getSubject());
        message.setText(mailToCustomers.getMessage());
        javaMailSender.send(message);
    }

}
