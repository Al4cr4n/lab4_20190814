package com.example.lab4_20190814.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CompraController {

    @PostMapping("/compra/realizarPago")
    public String realizarPago(@RequestParam("cardNumber") String cardNumber,
                               @RequestParam("cardHolder") String cardHolder,
                               @RequestParam("expiryDate") String expiryDate,
                               @RequestParam("cvv") String cvv) {
        // Lógica para procesar el pago
        return "redirect:/pagoExitoso";
    }
}
