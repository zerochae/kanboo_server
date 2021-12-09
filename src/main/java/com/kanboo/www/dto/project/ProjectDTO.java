package com.kanboo.www.dto.project;

import com.kanboo.www.domain.entity.project.Project;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data @Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {

    private Long prjctIdx;
    private String prjctNm;
    private LocalDateTime prjctStartDate;
    private LocalDateTime prjctEndDate;
    private int prjctoProgress;
    private String prjctDelAt;

    public Project dtoToEntity() {
        return Project.builder()
                .prjctIdx(prjctIdx)
                .prjctNm(prjctNm)
                .prjctStartDate(prjctStartDate)
                .prjctEndDate(prjctEndDate)
                .prjctoProgress(prjctoProgress)
                .prjctDelAt(prjctDelAt)
                .build();
    }
}
