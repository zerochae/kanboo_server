package com.kanboo.www.domain.entity.board;

import com.kanboo.www.domain.entity.global.CodeDetail;
import com.kanboo.www.domain.entity.member.Member;
import com.kanboo.www.dto.board.BoardDTO;
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
@Builder
@Table(name = "board")
public class Board {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardIdx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mem_idx")
    private Member member;

    private String boardCn;
    private LocalDateTime boardDate;
    private int likeNum;
    private int reportNum;
    private String delAt;

    @OneToOne
    @JoinColumn(name = "code_detail_idx")
    private CodeDetail codeDetail;

    private String fileAt;

    public BoardDTO entityToDto() {
        return BoardDTO.builder()
                .boardIdx(boardIdx)
                .member(member.entityToDto())
                .boardCn(boardCn)
                .boardDate(boardDate)
                .likeNum(likeNum)
                .reportNum(reportNum)
                .delAt(delAt)
                .codeDetail(codeDetail.entityToDto())
                .fileAt(fileAt)
                .build();
    }
}
