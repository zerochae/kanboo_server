package com.kanboo.www.domain.entity.member.idclass;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
public class ProjectMemberId implements Serializable {
    private Long member;
    private Long project;
}
