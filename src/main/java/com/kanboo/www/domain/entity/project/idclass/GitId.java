package com.kanboo.www.domain.entity.project.idclass;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class GitId implements Serializable {

    private Long project;
}
