package com.kanboo.www.domain.entity.project;
import com.kanboo.www.dto.project.GanttDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "gantt")
@Builder
public class Gantt {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gtIdx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prjct_idx")
    private Project project;

    private String gtState;
    private String gtPriority;
    private int gtProgress;
    private LocalDateTime gtStartDate;
    private LocalDateTime gtEndDate;
    private  String gtExplanation;
    private String gtTitle;

    public GanttDTO entityToDto() {
        return GanttDTO.builder()
                .gtIdx(gtIdx)
                .project(project.entityToDto())
                .gtState(gtState)
                .gtPriority(gtPriority)
                .gtProgress(gtProgress)
                .gtStartDate(gtStartDate)
                .gtEndDate(gtEndDate)
                .gtExplanation(gtExplanation)
                .gtTitle(gtTitle)
                .build();
    }
}
