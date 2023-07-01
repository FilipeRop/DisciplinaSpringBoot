package com.alunoonline.api.service;

import com.alunoonline.api.model.MatriculaAluno;
import com.alunoonline.api.repository.MatriculaAlunoReposiroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatriculaAlunoService {

    @Autowired
    MatriculaAlunoReposiroy reposiroy;

    public MatriculaAluno matricularAluno(MatriculaAluno matriculaAluno){
        matriculaAluno.setStatus("MATRICULAOD");
        return reposiroy.save(matriculaAluno);
    }
}
