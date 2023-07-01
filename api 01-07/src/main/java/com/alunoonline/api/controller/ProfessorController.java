package com.alunoonline.api.controller;

import com.alunoonline.api.model.Aluno;
import com.alunoonline.api.model.Professor;
import com.alunoonline.api.service.AlunoService;
import com.alunoonline.api.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professor")

public class ProfessorController {

    @Autowired
    ProfessorService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Professor> criar(@RequestBody Professor professor){
        Professor professorCriado = service.criar(professor);
        return ResponseEntity.status(201).body(professorCriado);
    }

    @GetMapping("/listar-todos")
    @ResponseStatus(HttpStatus.OK)
    public List<Professor> listarTodos(){
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Professor> procurarPeloId(@PathVariable Long id){return service.procurarPeloId(id);}

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){service.delete(id);}

    @GetMapping("/lista-paginada")
    public ResponseEntity<Page<Professor>> listarProfessorPaginado(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        return ResponseEntity.ok(service.listarProfessorPaginado(page, size));
    }
}
