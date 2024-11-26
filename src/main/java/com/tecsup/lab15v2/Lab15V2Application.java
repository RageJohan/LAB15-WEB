package com.tecsup.lab15v2;

import com.tecsup.lab15v2.model.documents.Curso;
import com.tecsup.lab15v2.model.documents.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

@SpringBootApplication
public class Lab15V2Application implements CommandLineRunner {
    @Autowired
    private ReactiveMongoTemplate template;
    public static void main(String[] args) {
        SpringApplication.run(Lab15V2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //borrar la coleccion
        template.dropCollection("cursos").subscribe();
        template.dropCollection("cursos").subscribe();
        //insertar cursos
        template.insert(new Curso("C01","Java 17", 4)).subscribe();
        template.insert(new Curso("C02","SPRING BOOT", 5)).subscribe();
        template.insert(new Curso("C03","Jenkins", 3)).subscribe();
        template.insert(new Curso("C04","kubernetes", 4)).subscribe();
        template.insert(new Curso("C05","kafka", 3)).subscribe();
        template.insert(new Curso("C06","microservicios", 4)).subscribe();
        template.insert(new Curso("C07","angular", 5)).subscribe();
        template.insert(new Curso("C08","typescript", 4)).subscribe();
        template.insert(new Curso("C09","html", 4)).subscribe();
        template.insert(new Curso("C10","css 3", 1)).subscribe();

        // Insertar alumnos
        template.insert(new Alumno("A01", "Andrés Carrasco", 18)).subscribe();
        template.insert(new Alumno("A02", "Johan Lopez", 20)).subscribe();
        template.insert(new Alumno("A03", "Jeremias Remon", 15)).subscribe();
        template.insert(new Alumno("A04", "Ana Torres", 17)).subscribe();
        template.insert(new Alumno("A05", "Carlos Herrera", 19)).subscribe();
        template.insert(new Alumno("A06", "Sofía Morales", 16)).subscribe();
        template.insert(new Alumno("A07", "Pedro Mendoza", 21)).subscribe();
        template.insert(new Alumno("A08", "Lucía Vargas", 22)).subscribe();
        template.insert(new Alumno("A09", "Fernando López", 14)).subscribe();
        template.insert(new Alumno("A10", "Carmen Silva", 18)).subscribe();
    }

}
