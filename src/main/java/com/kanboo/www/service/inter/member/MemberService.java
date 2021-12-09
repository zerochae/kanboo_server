package com.kanboo.www.service.inter.member;

import com.kanboo.www.domain.entity.member.Member;
import com.kanboo.www.dto.member.MemberDTO;

public interface MemberService {

    boolean loginHandler(MemberDTO memberDTO);

    MemberDTO signHandler(MemberDTO memberDTO);

    int isExistKTag(String kTag);

    int isExistToken(String token);

    int isExistId(String memId);

    MemberDTO findIdHandler(MemberDTO memberDTO);

    String resetPwHandler(MemberDTO memberDTO);

}
