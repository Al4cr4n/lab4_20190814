package com.example.lab4_20190814.controller;

import java.nio.file.StandardCopyOption;
import com.example.lab4_20190814.entity.flores;  // Cambiar a mayúscula para seguir las convenciones de Java
import com.example.lab4_20190814.repository.FlorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class FlorController {

    @Autowired
    private FlorRepository florRepository;

    // Ruta del directorio de imágenes (definido en application.properties)
    @Value("${image.upload.dir}")
    private String imageUploadDir;

    // Mostrar el catálogo de flores
    @GetMapping("/catalogo")
    public String mostrarCatalogo(Model model) {
        List<flores> listaFlores = florRepository.findAll();
        model.addAttribute("listaFlores", listaFlores);
        return "catalogo_flores";
    }

    // Método para subir una flor con una imagen
    @PostMapping("/subirImagen")
    public String subirFlor(@RequestParam("nombreFlor") String nombreFlor,
                            @RequestParam("imagenFlor") MultipartFile imagenFlor,
                            @RequestParam("descripcionFlor") String descripcionFlor,
                            @RequestParam("precioFlor") Integer precioFlor,
                            @RequestParam("colorFlor") String colorFlor,
                            @RequestParam("ocasionFlor") String ocasionFlor) {
        try {
            // Asegurarse de que el directorio exista
            File directorio = new File(imageUploadDir);
            if (!directorio.exists()) {
                directorio.mkdirs();
            }

            // Generar un nombre de archivo único
            String nombreArchivo = System.currentTimeMillis() + "_" + imagenFlor.getOriginalFilename();

            // Definir la ruta completa donde se almacenará la imagen
            Path rutaArchivo = Paths.get(imageUploadDir + File.separator + nombreArchivo);

            // Guardar la imagen en el servidor
            Files.copy(imagenFlor.getInputStream(), rutaArchivo, StandardCopyOption.REPLACE_EXISTING);

            // Crear una nueva flor y guardar en la base de datos
            flores nuevaFlor = new flores();
            nuevaFlor.setNombre(nombreFlor);
            nuevaFlor.setImagen(nombreArchivo);
            nuevaFlor.setDescripcion(descripcionFlor);
            nuevaFlor.setPrecio(precioFlor);
            nuevaFlor.setColor(colorFlor);
            nuevaFlor.setOcasion(ocasionFlor);

            florRepository.save(nuevaFlor);

            return "redirect:/catalogo";
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
    }





    @GetMapping("/subirFlor")
    public String mostrarFormularioSubirFlor() {
        return "subir_flor";  // Retorna la vista subir_flor.html
    }

}
