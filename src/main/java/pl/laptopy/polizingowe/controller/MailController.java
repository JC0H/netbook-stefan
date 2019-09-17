package pl.laptopy.polizingowe.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.laptopy.polizingowe.model.MailEntity;
import pl.laptopy.polizingowe.service.MailService;

@RestController
@RequiredArgsConstructor
@RequestMapping(name = "${api.stefan.notebook}", method = RequestMethod.GET)
public class MailController {

    private final MailService mailService;

    @PostMapping("/mail")
    public ResponseEntity sendSimpleMailToCustomers(@RequestBody MailEntity mailEntityToSend) {
        mailService.sendMail(mailEntityToSend);
        return ResponseEntity.ok("emails were sent");
    }

}
