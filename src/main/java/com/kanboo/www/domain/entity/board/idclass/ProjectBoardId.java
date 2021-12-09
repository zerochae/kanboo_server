package com.kanboo.www.domain.entity.board.idclass;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
public class ProjectBoardId implements Serializable {

    private Long board;
    private Long project;
}
