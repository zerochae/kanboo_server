package com.kanboo.www.domain.entity.project;

import com.kanboo.www.dto.project.ProjectDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "project")
@Builder
public class Project {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prjctIdx;

    private String prjctNm;
    private LocalDateTime prjctStartDate;
    private LocalDateTime prjctEndDate;
    private int prjctoProgress;
    private String prjctDelAt;

    public ProjectDTO entityToDto() {
        return ProjectDTO.builder()
                .prjctIdx(prjctIdx)
                .prjctNm(prjctNm)
                .prjctStartDate(prjctStartDate)
                .prjctEndDate(prjctEndDate)
                .prjctoProgress(prjctoProgress)
                .prjctDelAt(prjctDelAt)
                .build();
    }
}
