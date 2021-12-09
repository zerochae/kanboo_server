package com.kanboo.www.domain.entity.member;

import com.kanboo.www.dto.member.BanDTO;
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
@Table(name = "ban")
@Builder
public class Ban {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long banIdx;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mem_idx")
    private Member member;

    private LocalDateTime banStartDate;
    private LocalDateTime banEndDate;

    public BanDTO entityToDto() {
        return BanDTO.builder()
                .banIdx(banIdx)
                .member(member.entityToDto())
                .banStartDate(banStartDate)
                .banEndDate(banEndDate)
                .build();
    }
}
