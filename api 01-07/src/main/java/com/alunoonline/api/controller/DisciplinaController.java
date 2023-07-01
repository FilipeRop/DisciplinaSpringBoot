package com.alunoonline.api.controller;

import com.alunoonline.api.model.Aluno;
import com.alunoonline.api.model.Disciplina;
import com.alunoonline.api.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/disciplina")

public class DisciplinaController {

    @Autowired
    DisciplinaService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Disciplina> criar(@RequestBody Disciplina disciplina){
        Disciplina DisciplinaCriada = service.criar(disciplina);

        return ResponseEntity.status(201).body(DisciplinaCriada);
    }

    @GetMapping("/listar-todos")
    @ResponseStatus(HttpStatus.OK)
    public List<Disciplina> listarTodos(){
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Disciplina> procurarPeloId(@PathVariable Long id){return service.procurarPeloId(id);}

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){service.delete(id);}

    @GetMapping("professor/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Disciplina> procurarPorProfessorId(@PathVariable Long id){return  service.procurarPorProfessorId(id);}

    @GetMapping("/lista-paginada")
    public ResponseEntity<Page<Disciplina>> listarDisciplinaPaginado(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        return ResponseEntity.ok(service.listarDisciplinaPaginado(page, size));
    }
}
