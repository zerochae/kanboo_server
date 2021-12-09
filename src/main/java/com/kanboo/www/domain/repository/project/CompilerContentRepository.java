package com.kanboo.www.domain.repository.project;

import com.kanboo.www.domain.entity.project.CompilerFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompilerContentRepository extends JpaRepository<CompilerFile, Long> {
}
