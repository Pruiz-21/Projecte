package com.pablo.springboot.app.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

@RestController
public class GestionMedicaController {

    private static final String URL = "jdbc:mysql://localhost:3306/gestionesmedicas";
    private static final String USUARIO = "root";
    private static final String CONTRASEÑA = "root";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
    }

    @GetMapping("/medicos")
    public List<Map> getMedicos() {
        try {
            Connection c = conectar();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT nombre, especialidad FROM medicos");

            ArrayList<Map> medicos = new ArrayList<>();
            Map<String, String> medico = new HashMap<>();

            while (rs.next()) {
                String firstName = rs.getString("nombre");
                String lastName = rs.getString("especialidad");

                medico = new HashMap<>();
                medico.put("nombre", firstName);
                medico.put("especialidad", lastName);
                medicos.add(medico);
            }

            c.close();
            stmt.close();
            rs.close();

            return medicos;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/hello")
    public Map<String, String> foo() {
        Map<String, String> json = new HashMap<>();
        json.put("message", "Hola mundo Spring Boot API REST");
        return json;
    }


}

