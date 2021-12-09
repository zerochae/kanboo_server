package com.kanboo.www.dto.board;

import com.kanboo.www.domain.entity.board.Board;
import com.kanboo.www.domain.entity.member.Member;
import com.kanboo.www.dto.global.CodeDetailDto;
import com.kanboo.www.dto.member.MemberDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {

    private Long boardIdx;
    private MemberDTO member;
    private String boardCn;
    private LocalDateTime boardDate;
    private int likeNum;
    private int reportNum;
    private String delAt;
    private CodeDetailDto codeDetail;
    private String fileAt;

    public Board dtoToEntity() {
        return Board.builder()
                .boardIdx(boardIdx)
                .member(member.dtoToEntity())
                .boardCn(boardCn)
                .boardDate(boardDate)
                .likeNum(likeNum)
                .reportNum(reportNum)
                .delAt(delAt)
                .codeDetail(codeDetail.dtoToEntity())
                .fileAt(fileAt)
                .build();
    }
}
