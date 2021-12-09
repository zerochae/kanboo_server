package com.kanboo.www.domain.entity.project;

import com.kanboo.www.domain.entity.member.Member;
import com.kanboo.www.dto.project.KanbanItemDTO;
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
@Table(name = "kanban_item")
@Builder
public class KanbanItem {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long kbItmIdx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kb_idx")
    private Kanban kanban;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mem_idx")
    private Member member;

    private String kbCn;
    private String kbItmNum;
    private LocalDateTime kbDate;
    private String kbBadge;
    private String kbColor;

    public KanbanItemDTO entityToDto() {
        return KanbanItemDTO.builder()
                .kbItmIdx(kbItmIdx)
                .kanban(kanban.entityToDto())
                .member(member.entityToDto())
                .kbCn(kbCn)
                .kbItmNum(kbItmNum)
                .kbDate(kbDate)
                .kbBadge(kbBadge)
                .kbColor(kbColor)
                .build();
    }
}
