package com.kanboo.www.domain.entity.member;

import com.kanboo.www.domain.entity.global.Role;
import com.kanboo.www.dto.member.MemberDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "member")
@Builder
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memIdx;

    private String memId;
    private String memNick;
    private String memCelNum;
    private String memToken;
    private String memTag;
    private String memImg;
    private String memPass;

    @OneToOne
    @JoinColumn(name = "roleIdx")
    private Role role;

    public MemberDTO entityToDto() {
        return MemberDTO.builder()
                .memIdx(memIdx)
                .memId(memId)
                .memNick(memNick)
                .memCelNum(memCelNum)
                .memToken(memToken)
                .memTag(memTag)
                .memImg(memImg)
                .memPass(memPass)
                .role(role.entityToDto())
                .build();
    }
}
