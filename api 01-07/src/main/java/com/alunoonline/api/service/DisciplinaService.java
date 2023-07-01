package com.alunoonline.api.service;

import com.alunoonline.api.model.Aluno;
import com.alunoonline.api.model.Disciplina;
import com.alunoonline.api.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {

    @Autowired
    DisciplinaRepository repository;

    public Disciplina criar(Disciplina disciplina){
        return repository.save(disciplina);
    }

    public List<Disciplina> listarTodos(){
        return repository.findAll();
    }

    public Optional<Disciplina> procurarPeloId(Long id){return repository.findById(id);}

    public void delete(Long id){repository.deleteById(id);}

    public List<Disciplina> procurarPorProfessorId(Long professorId){return  repository.findByProfessorId(professorId);}

    public Page<Disciplina> listarDisciplinaPaginado(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return  repository.findAll(pageable);}
}
