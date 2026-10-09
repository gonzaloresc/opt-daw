package com.actividad4.actividad4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class tablaController {

    @GetMapping("/tabla")
    public String tabla(
            @RequestParam(name = "filas", required = false, defaultValue = "1") String filas,
            @RequestParam(name = "columnas", required = false, defaultValue = "1") String columnas
            ) {

        int filasNum;
        int columnasNum;

        try {
            filasNum = Integer.parseInt(filas);
        } catch (NumberFormatException e) {
            System.out.println("Los valores no eran números así que se pondrán los valores por defecto");
            filasNum = 1;
        }
        // Para filas

        try {
            columnasNum = Integer.parseInt(columnas);
        } catch (NumberFormatException e) {
            System.out.println("Los valores no eran números así que se pondrán los valores por defecto");
            columnasNum = 1;
        }
        // Para columnas

        // En esta parte intento convertir los valores recibidos por el get en numeros si no lo consigue habrá un aviso y se pondrán los valores por defecto

        if (filasNum < 1) {
            filasNum = 1;
        }
        if (columnasNum < 1) {
            columnasNum = 1;
        }
        if (filasNum > 20) {
            filasNum = 20;
        }
        if (columnasNum > 20) {
            columnasNum = 20;
        }
        // Aquí cambio los datos que estén mal por los valores límite


        // y aquí abajo hago el doc html y formo la tabla
        String tablaFinal = "<!DOCTYPE html>" +
                "<html lang=\"es\">" +
                "<head>" +
                "<meta charset=\"UTF-8\">" +
                "<title>Ejercicio tablas spring</title>" +
                "</head>" +
                "<body>" +
                "<table border=\"1\">" +
                "<caption>Tabla de ";
        tablaFinal += filasNum + " filas y " + columnasNum + " columnas</caption>";

        for (int i = 1; i <= filasNum; i++){
            tablaFinal += "<tr>";
            for (int j = 1; j <= columnasNum; j++){
                tablaFinal += "<td> fila: " + i + ", Columna: " + j + "</td>";
            }
            tablaFinal += "</tr>";
        }
        tablaFinal += "</table>" +
                "</body>" +
                "</html>";

        // Aquí lo mando todo
        return tablaFinal;

    }
}