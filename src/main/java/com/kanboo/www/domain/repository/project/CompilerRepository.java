package com.kanboo.www.domain.repository.project;

import com.kanboo.www.domain.entity.project.Compiler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompilerRepository extends JpaRepository<Compiler, Long> {
}
