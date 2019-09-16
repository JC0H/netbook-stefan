package pl.laptopy.polizingowe.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.laptopy.polizingowe.model.MailToCustomers;
import pl.laptopy.polizingowe.service.EmailService;

@RestController
@RequiredArgsConstructor
@RequestMapping("mail")
public class MailToCustomersController {

    private final EmailService emailService;

    @GetMapping
    public ResponseEntity sendSimpleMailToCustomers(@RequestBody MailToCustomers mailToCustomers) {
        emailService.sendSimpleMessage(mailToCustomers);
        return ResponseEntity.ok("emails were sent");
    }

}
