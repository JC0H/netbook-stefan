package pl.laptopy.polizingowe.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.laptopy.polizingowe.service.EmailService;

@RestController
@RequiredArgsConstructor
@RequestMapping("mail")
public class NotificationController {

    private final EmailService emailService;

    @GetMapping
    public ResponseEntity sendSimpleMailToCustomers(
            @RequestParam String subject,
            @RequestParam String text,
            @RequestParam String to
    ) {
        emailService.sendSimpleMessage(subject, text, to);
        return ResponseEntity.ok("emails were sent");
    }

}
