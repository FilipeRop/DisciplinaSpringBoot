package com.alunoonline.api.repository;

import com.alunoonline.api.model.MatriculaAluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaAlunoReposiroy extends JpaRepository<MatriculaAluno, Long> {
}
