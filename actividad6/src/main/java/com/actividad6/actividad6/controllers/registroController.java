package com.actividad6.actividad6.controllers;

import com.actividad6.actividad6.model.Formulario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

@Controller
public class registroController {

    @GetMapping("/registro")
    public String mostrarFormulario() {
        return "formulario";
    }


    @PostMapping("/registro")
    @ResponseBody
    public String procesarFormulario(@ModelAttribute Formulario formulario) {

        Map<String, String> claveUsu = new HashMap<>();
        claveUsu.put("ana@example.com","246810");
        claveUsu.put("luis@example.com","clave123");

        String respuesta = "";

        if (formulario.getNombre().isEmpty()) {
            return "El apartado \"nombre\" es obligatorio";
        } else {
            respuesta += "<p>Nombre: "+formulario.getNombre();
        }
        if (formulario.getApellidos().isEmpty()) {
            formulario.setApellidos("");
        }
        respuesta += " "+formulario.getApellidos();

        if (formulario.getCorreo().isEmpty()) {
            return "El apartado \"correo\" es obligatorio";
        } else {
            respuesta += " </p><p>Correo: "+formulario.getCorreo();
        }
        if (formulario.getContrasena().isEmpty()) {
            int pass = (int)(Math.random() * 1000000);
            formulario.setContrasena(String.format("%06d",pass));
            respuesta += " </p><p>Se ha generado una contraseña aleatoria: " + formulario.getContrasena();

        }

        respuesta += "</p>";

        String salida;

        if (claveUsu.containsKey(formulario.getCorreo())) {
            if (claveUsu.get(formulario.getCorreo()).equals(formulario.getContrasena())) {
                salida = "Inicio de sesión correcto";
            } else {
                salida = "Contraseña incorrecta";
            }
        } else {
            salida = "Usuario inexistente, creando usuario";
            claveUsu.put(formulario.getCorreo(),formulario.getContrasena());
        }


        String html = """
                <html lang="es">
                <head>
                    <meta charset="UTF-8">
                    <title>Registro de usuario</title>
                </head>
                <body>
                    <h1>
                """;

        html += salida + "</h1>" + respuesta + "</body></html>";

        return html;

    }

}
