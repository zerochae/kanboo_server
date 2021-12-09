package com.kanboo.www.dto.project;

import com.kanboo.www.domain.entity.member.Member;
import com.kanboo.www.domain.entity.project.Issue;
import com.kanboo.www.domain.entity.project.Project;
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
public class IssueDTO {

    private Long issueIdx;
    private ProjectDTO project;
    private MemberDTO member;
    private String issueCn;
    private LocalDateTime issueDate;
    private String issueState;

    public Issue dtoToEntity() {
        return Issue.builder()
                .issueIdx(issueIdx)
                .project(project.dtoToEntity())
                .member(member.dtoToEntity())
                .issueCn(issueCn)
                .issueDate(issueDate)
                .issueState(issueState)
                .build();
    }
}
