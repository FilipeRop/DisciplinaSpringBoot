package com.alunoonline.api.service;

import com.alunoonline.api.model.Aluno;
import com.alunoonline.api.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository repository;

    public Aluno criar(Aluno aluno){
        return repository.save(aluno);
    }

    public List<Aluno> listarTodos(){
        return repository.findAll();
    }
}
