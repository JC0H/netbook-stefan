package pl.laptopy.polizingowe.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import pl.laptopy.polizingowe.config.PropertiesConfig;
import pl.laptopy.polizingowe.dto.OrderSummaryDto;
import pl.laptopy.polizingowe.errors.ApiException;
import pl.laptopy.polizingowe.errors.ErrorCode;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.List;

@Service
@Slf4j
public class MailService {

    private final JavaMailSender javaMailSender;
    private static final String MAIL_SUBJECT_TO_CUSTOMER = "Your order summary.";
    private static final String MAIL_SUBJECT_TO_STEFAN = "People made an order, please check";
    private final PropertiesConfig propertiesConfig;

    public MailService(JavaMailSender javaMailSender, PropertiesConfig propertiesConfig) {
        this.javaMailSender = javaMailSender;
        this.propertiesConfig = propertiesConfig;
    }

    public void sendMailNotification(OrderSummaryDto orderSummaryDto) {
        sendMailNotificationToStefan(orderSummaryDto);
        sendMailNotificationToCustomer(orderSummaryDto);
    }

    private void sendMailNotificationToStefan(OrderSummaryDto orderSummaryDto) {
        SimpleMailMessage message = new SimpleMailMessage();
        String customersMail = orderSummaryDto.getCustomerEmail();
        message.setTo(customersMail);
        message.setSubject(MAIL_SUBJECT_TO_STEFAN);
        message.setText("some text, will decide later");
        javaMailSender.send(message);
    }

    private void sendMailNotificationToCustomer(OrderSummaryDto orderSummaryDto) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setTo(propertiesConfig.getMail());
            mimeMessageHelper.setSubject(MAIL_SUBJECT_TO_CUSTOMER);
            mimeMessageHelper.setText("decide later");

            ClassPathResource classPathResource = new ClassPathResource("attachments/Attachment.img");
            mimeMessageHelper.addAttachment(classPathResource.getFilename(), classPathResource);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            log.error("Error while sending mail to {}.", orderSummaryDto.getCustomerEmail(), e);
            throw new ApiException(ErrorCode.MESSAGE_WITH_ATTACHMENTS_EXCEPTION);
        }
    }

    private void addAttachments(List<String> pathsToAttachments, MimeMessageHelper mimeMessageHelper) {
        for (String path : pathsToAttachments) {
            FileSystemResource file = new FileSystemResource(new File(path));
            try {
                mimeMessageHelper.addAttachment(file.getFilename(), file);
            } catch (MessagingException e) {
                log.error("Attachment is incorrect: {} .", path, e);
                throw new ApiException(ErrorCode.MESSAGE_WITH_ATTACHMENTS_EXCEPTION);
            }
        }
    }
}
