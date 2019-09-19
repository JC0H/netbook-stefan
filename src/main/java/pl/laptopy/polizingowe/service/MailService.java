package pl.laptopy.polizingowe.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import pl.laptopy.polizingowe.model.MailEntity;
import pl.laptopy.polizingowe.utils.ListConverter;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class MailService {

    private final JavaMailSender javaMailSender;
    private final ListConverter listConverter;

    public void sendMail(MailEntity mailEntityToSend) {
        if (!Objects.isNull(mailEntityToSend.getPathToAttachment())) sendMailWithAttachments(mailEntityToSend);
        else sendSimpleMail(mailEntityToSend);
    }

    private void sendSimpleMail(MailEntity mailEntityToSend) {
        SimpleMailMessage message = new SimpleMailMessage();
        String[] receiversArray = listConverter.convertListToArray(mailEntityToSend.getReceivers());
        message.setTo(receiversArray);
        message.setSubject(mailEntityToSend.getSubject());
        message.setText(mailEntityToSend.getMessage());
        javaMailSender.send(message);
    }

    private void sendMailWithAttachments(MailEntity mailEntityToSend) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            String[] receiversArray = listConverter.convertListToArray(mailEntityToSend.getReceivers());
            mimeMessageHelper.setTo(receiversArray);
            mimeMessageHelper.setSubject(mailEntityToSend.getSubject());
            mimeMessageHelper.setText(mailEntityToSend.getMessage());
            addAttachments(mailEntityToSend.getPathToAttachment(), mimeMessageHelper);

            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            log.error("Mime message wasn't sent properly.", e);
        }
    }

    private void addAttachments(List<String> pathsToAttachments, MimeMessageHelper mimeMessageHelper) {
        for (String path : pathsToAttachments) {
            FileSystemResource file = new FileSystemResource(new File(path));
            try {
                mimeMessageHelper.addAttachment(file.getFilename(), file);
            } catch (MessagingException e) {
                log.error("Attachment is incorrect: {} .", path, e);
            }
        }
    }
}
