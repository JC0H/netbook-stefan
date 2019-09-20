package pl.laptopy.polizingowe.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.laptopy.polizingowe.model.MailEntity;
import pl.laptopy.polizingowe.service.MailService;

import javax.validation.Valid;
import java.util.Collections;

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

    @GetMapping
    public MailEntity asd() {
        return MailEntity.builder()
                .receivers(Collections.singletonList("ostap.shevchenko95@gmail.com"))
                .subject("oneMoreTEst")
                .message("Hello there, You are the best programmer ever!! :)")
                .build();
    }
}
