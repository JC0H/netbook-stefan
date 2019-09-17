package pl.laptopy.polizingowe.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.laptopy.polizingowe.model.MailToSend;
import pl.laptopy.polizingowe.service.MailService;

@RestController
@RequiredArgsConstructor
@RequestMapping("mail")
public class MailToCustomersController {

    private final MailService mailService;

    @GetMapping
    public ResponseEntity sendSimpleMailToCustomers(@RequestBody MailToSend mailToSend) {
        mailService.sendMail(mailToSend);
        return ResponseEntity.ok("emails were sent");
    }

}
