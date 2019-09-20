package pl.laptopy.polizingowe.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.laptopy.polizingowe.model.MailEntity;
import pl.laptopy.polizingowe.service.MailService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "${api.stefan.notebook}" + "/mail")
public class MailController {
    private final MailService mailService;

    @PostMapping
    public ResponseEntity sendSimpleMailToCustomers(@Valid @RequestBody MailEntity mailEntityToSend) {
        mailService.sendMail(mailEntityToSend);
        return ResponseEntity.ok(mailEntityToSend);
    }

}
