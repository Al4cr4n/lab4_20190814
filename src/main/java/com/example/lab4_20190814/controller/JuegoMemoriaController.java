package com.example.lab4_20190814.controller;
import com.example.lab4_20190814.entity.usuario;
import com.example.lab4_20190814.entity.juegoMemoria;
import com.example.lab4_20190814.repository.JuegoMemoriaRepository;
import com.example.lab4_20190814.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class JuegoMemoriaController {


    final JuegoMemoriaRepository juegoMemoriaRepository;
    final UsuarioRepository usuarioRepository;

    public JuegoMemoriaController(JuegoMemoriaRepository juegoMemoriaRepository, UsuarioRepository usuarioRepository) {
        this.juegoMemoriaRepository = juegoMemoriaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/entretenimiento")
    public String mostrarJuegoMemoria(Model model) {
        List<juegoMemoria> listaJugadores = juegoMemoriaRepository.findAll();
        model.addAttribute("listaJugadores", listaJugadores);
        return "entretenimiento";
    }

    @PostMapping("/juego/registrar")
    public String registrarJugador(@RequestParam("nickname") String nickname, @RequestParam("puntaje") Integer puntaje) {
        // Supongamos que tienes un método en UsuarioRepository para buscar el usuario por su nickname
        usuario usuario = usuarioRepository.findByNickname(nickname);

        if (usuario == null) {
            // Manejar el caso en el que el usuario no exista
            return "redirect:/error";
        }

        // Crear nuevo juego de memoria
        juegoMemoria jugador = new juegoMemoria();
        jugador.setUsuario(usuario);  // Asignar el usuario al juego
        jugador.setPuntaje(puntaje);
        jugador.setFechaJuego(LocalDateTime.now());

        juegoMemoriaRepository.save(jugador);

        return "redirect:/entretenimiento";
    }

}
