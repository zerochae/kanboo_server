package com.kanboo.www.domain.repository.project;

import com.kanboo.www.domain.entity.project.Kanban;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KanbanItemRepository extends JpaRepository<Kanban, Long> {
}
