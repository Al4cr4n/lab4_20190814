package com.example.lab4_20190814.controller;

import com.example.lab4_20190814.entity.carrito;
import com.example.lab4_20190814.repository.CarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CarritoController {

    @Autowired
    private CarritoRepository carritoRepository;

    @GetMapping("/carrito")
    public String mostrarCarrito(Model model, @RequestParam("usuarioId") Integer usuarioId) {
        List<carrito> listaCarrito = carritoRepository.findByUsuarioUsuarioId(usuarioId);
        model.addAttribute("listaCarrito", listaCarrito);
        return "carrito";
    }

    @PostMapping("/carrito/agregar")
    public String agregarAlCarrito(@RequestParam("florId") Integer florId, @RequestParam("cantidad") Integer cantidad, @RequestParam("usuarioId") Integer usuarioId) {
        // Lógica para agregar al carrito
        return "redirect:/carrito?usuarioId=" + usuarioId;
    }

    @PostMapping("/carrito/finalizarCompra")
    public String finalizarCompra(@RequestParam("usuarioId") Integer usuarioId) {
        // Lógica para finalizar la compra
        return "redirect:/compra";
    }
}
