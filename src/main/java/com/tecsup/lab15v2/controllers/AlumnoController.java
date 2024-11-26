package com.tecsup.lab15v2.controllers;

import com.tecsup.lab15v2.model.daos.AlumnoDao;
import com.tecsup.lab15v2.model.documents.Alumno;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.spring6.context.webflux.ReactiveDataDriverContextVariable;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Controller
public class AlumnoController {

    @Autowired
    private AlumnoDao dao;

    private static final Logger log = LoggerFactory.getLogger(AlumnoController.class);

    @GetMapping({"/alumnos/listar", "/alumnos"})
    public String listar(Model model) {

        Flux<Alumno> alumnos = dao.findAll().map(alumno -> {
            alumno.nombre().toUpperCase();
            return alumno;
        });

        alumnos.subscribe(alumno -> log.info(alumno.nombre()));

        model.addAttribute("alumnos", alumnos);
        model.addAttribute("titulo", "Listado de alumnos");
        return "alumnos-listar";
    }

    @GetMapping("/alumnos/listar-datadriver")
    public String listarDataDriver(Model model) {

        Flux<Alumno> alumnos = dao.findAll().map(alumno -> {
            alumno.nombre().toUpperCase();
            return alumno;
        }).delayElements(Duration.ofSeconds(2));

        alumnos.subscribe(alumno -> log.info(alumno.nombre()));

        model.addAttribute("alumnos", new ReactiveDataDriverContextVariable(alumnos, 2));
        model.addAttribute("titulo", "Listado de alumnos");
        return "alumnos-listar";
    }

    @GetMapping("/alumnos/listar-full")
    public String listarFull(Model model) {

        Flux<Alumno> alumnos = dao.findAll().map(alumno -> {
            alumno.nombre().toUpperCase();
            return alumno;
        }).repeat(5000);

        model.addAttribute("alumnos", alumnos);
        model.addAttribute("titulo", "Listado de alumnos");
        return "alumnos-listar";
    }

    @GetMapping("/alumnos/listar-chunked")
    public String listarChunked(Model model) {

        Flux<Alumno> alumnos = dao.findAll().map(alumno -> {
            alumno.nombre().toUpperCase();
            return alumno;
        }).repeat(5000);

        model.addAttribute("alumnos", alumnos);
        model.addAttribute("titulo", "Listado de alumnos");
        return "alumnos-listar-chunked";
    }
}
