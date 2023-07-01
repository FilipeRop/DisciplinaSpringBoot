package com.alunoonline.api.controller;

import com.alunoonline.api.model.Aluno;
import com.alunoonline.api.model.dtos.AlunoNomeCursoDTO;
import com.alunoonline.api.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aluno")

public class AlunoController {
    @Autowired
    AlunoService service;

    @GetMapping("/curso-nome/{id}")
    public ResponseEntity<AlunoNomeCursoDTO> obterNomeCursoAluno(@PathVariable long id){
        AlunoNomeCursoDTO alunoDTO = new AlunoNomeCursoDTO(service.procurarPeloId(id).get());
        return ResponseEntity.ok(alunoDTO);
    }
    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Aluno>> buscarPorNome(@PathVariable("nome")String nome){
        return ResponseEntity.ok(service.buscarPorNome(nome));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Aluno> buscarPorEmail(@PathVariable("email")String email){
        return ResponseEntity.ok(service.buscarPorEmail(email));
    }
    @GetMapping("/lista-paginada")
    public ResponseEntity<Page<Aluno>> listarAlunosPaginado(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        return ResponseEntity.ok(service.listarAlunoPaginado(page, size));
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Aluno> criar(@RequestBody @Valid Aluno aluno){
        Aluno alunoCriado = service.criar(aluno);

        return ResponseEntity.status(201).body(alunoCriado);
    }

    @GetMapping("/listar-todos")
    @ResponseStatus(HttpStatus.OK)
    public List<Aluno> listarTodos(){
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Aluno> procurarPeloId(@PathVariable Long id){return service.procurarPeloId(id);}

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){service.delete(id);}


}
