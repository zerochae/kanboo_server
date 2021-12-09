package com.kanboo.www.dto.board;

import com.kanboo.www.domain.entity.board.Board;
import com.kanboo.www.domain.entity.board.Comment;
import com.kanboo.www.domain.entity.member.Member;
import com.kanboo.www.dto.member.MemberDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {

    private Long answerIdx;
    private BoardDTO board;
    private MemberDTO member;
    private String answerCn;
    private int answerReportNum;
    private LocalDateTime answerDate;
    private String answerDelAt;

    public Comment dtoToEntity() {
        return Comment.builder()
                .answerIdx(answerIdx)
                .board(board.dtoToEntity())
                .member(member.dtoToEntity())
                .answerCn(answerCn)
                .answerReportNum(answerReportNum)
                .answerDate(answerDate)
                .answerDelAt(answerDelAt)
                .build();
    }
}
