package com.kanboo.www.domain.entity.project;

import com.kanboo.www.domain.entity.project.idclass.ChatId;
import com.kanboo.www.dto.project.ChattingContentDTO;
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
@Table(name = "chatting_content")
@Builder
public class ChattingContent {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chatContentIdx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "project", referencedColumnName = "prjct_idx"),
            @JoinColumn(name = "member", referencedColumnName = "mem_idx")
    })
    private Chat chat;

    private String chatCn;
    private LocalDateTime chatCnDate;

    public ChattingContentDTO entityToDto() {
        return ChattingContentDTO.builder()
                .chatContentIdx(chatContentIdx)
                .chat(chat.entityToDto())
                .chatCn(chatCn)
                .chatCnDate(chatCnDate)
                .build();
    }
}
