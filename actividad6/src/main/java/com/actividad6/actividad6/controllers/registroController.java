package com.actividad6.actividad6.controllers;

import com.actividad6.actividad6.model.Formulario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class registroController {

    @GetMapping("/registro")
    public String mostrarFormulario() {
        return "formulario";
    }


    @PostMapping("/registro")
    @ResponseBody
    public String procesarFormulario(@ModelAttribute Formulario formulario) {

        boolean tieneContrasena = true;
        String respuesta = "Los datos son: ";

        if (formulario.getNombre().isEmpty()) {
            return "El apartado \"nombre\" es obligatorio";
        } else {
            respuesta += "Nombre "+formulario.getNombre();
        }
        if (formulario.getApellidos().isEmpty()) {
            formulario.setApellidos("");
        }
        respuesta += " Apellido "+formulario.getApellidos();

        if (formulario.getCorreo().isEmpty()) {
            return "El apartado \"correo\" es obligatorio";
        } else {
            respuesta += " Correo "+formulario.getCorreo();
        }
        if (formulario.getContrasena().isEmpty()) {
            int pass = (int)(Math.random() * 1000000);
            formulario.setContrasena(String.format("%06d",pass));
            tieneContrasena = false;
            respuesta += " Contra "
        }

        if (!tieneContrasena) {
            return "Se ha generado una contraseña aleatoria: " + formulario.getContrasena();
        }

        return

    }

}
