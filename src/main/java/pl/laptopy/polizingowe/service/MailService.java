package pl.laptopy.polizingowe.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import pl.laptopy.polizingowe.config.PropertiesConfig;
import pl.laptopy.polizingowe.entity.Customer;
import pl.laptopy.polizingowe.entity.OrderSummary;
import pl.laptopy.polizingowe.errors.ApiRequestException;
import pl.laptopy.polizingowe.errors.ErrorCode;
import pl.laptopy.polizingowe.utils.ListConverter;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MailService {

    private final JavaMailSender javaMailSender;
    private final ListConverter listConverter;
    private static final String MAIL_SUBJECT_TO_CUSTOMER = "Your order summary.";
    private static final String MAIL_SUBJECT_TO_STEFAN = "People made an order, please check";
    private final PropertiesConfig propertiesConfig;

    public void sendMailNotification(OrderSummary orderSummary) {
        sendMailNotificationToStefan(orderSummary);
        sendMailNotificationToCustomer(orderSummary);
    }

    private void sendMailNotificationToStefan(OrderSummary orderSummary) {
        SimpleMailMessage message = new SimpleMailMessage();
        String customersMail = orderSummary.getCustomer().getEmail();
        message.setTo(customersMail);
        message.setSubject(MAIL_SUBJECT_TO_STEFAN);
        message.setText("some text, will decide later");
        javaMailSender.send(message);
    }

    private void sendMailNotificationToCustomer(OrderSummary orderSummary) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        Customer customer = orderSummary.getCustomer();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setTo(propertiesConfig.getMail());
            mimeMessageHelper.setSubject(MAIL_SUBJECT_TO_CUSTOMER);
            mimeMessageHelper.setText("decide later");

            ClassPathResource classPathResource = new ClassPathResource("attachments/Attachment.img");
            mimeMessageHelper.addAttachment(classPathResource.getFilename(), classPathResource);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            log.error("Error while sending mail to {}.", customer.getEmail(), e);
            throw new ApiRequestException(ErrorCode.MESSAGE_WITH_ATTACHMENTS_EXCEPTION);
        }
    }

    private void addAttachments(List<String> pathsToAttachments, MimeMessageHelper mimeMessageHelper) {
        for (String path : pathsToAttachments) {
            FileSystemResource file = new FileSystemResource(new File(path));
            try {
                mimeMessageHelper.addAttachment(file.getFilename(), file);
            } catch (MessagingException e) {
                log.error("Attachment is incorrect: {} .", path, e);
                throw new ApiRequestException(ErrorCode.MESSAGE_WITH_ATTACHMENTS_EXCEPTION);
            }
        }
    }
}
