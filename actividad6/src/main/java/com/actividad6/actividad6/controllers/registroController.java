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

        if (formulario.getNombre().isEmpty()) {
            return "El apartado \"nombre\" es obligatorio";
        }
        if (formulario.getApellidos().isEmpty()) {
            formulario.setApellidos("");
        }
        if (formulario.getCorreo().isEmpty()) {
            return "El apartado \"correo\" es obligatorio";
        }
        if (formulario.getContrasena(). )

        return "Formulario recibido. Nombre " + formulario.getNombre() + ", Apellidos: " + formulario.getApellidos()
                + ", Correo: " + formulario.getCorreo() + ", Contraseña: " + formulario.getContrasena();

    }

}
