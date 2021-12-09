package com.kanboo.www.controller.noaccess;

import com.kanboo.www.domain.entity.member.Member;
import com.kanboo.www.dto.member.MemberDTO;
import com.kanboo.www.security.JwtSecurityService;
import com.kanboo.www.service.inter.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/access")
public class AccessController {

    private final MemberService memberService;
    private final JwtSecurityService jwtSecurityService;


    @PostMapping("/login")
    public String loginHandler(MemberDTO memberDTO) {

        String jwt_token = "fail";
        System.out.println(memberDTO);
        boolean loginHandler = memberService.loginHandler(memberDTO);
        if (loginHandler) {
            jwt_token = jwtSecurityService.createToken(memberDTO.getMemId(), 60L);
        }
        return jwt_token;
    }

    @PostMapping("/sign")
    public String signHandler(MemberDTO memberDTO) {
        System.out.println(memberDTO);
        MemberDTO member = memberService.signHandler(memberDTO);
        return member.getMemToken();
    }

    @PostMapping("/idCheck")
    public boolean idDuplicateCheck(String memId) {
        return memberService.isExistId(memId) > 0;
    }

    @PostMapping("/findId")
    public String findIdHandler(MemberDTO memberDTO) {
        return memberService.findIdHandler(memberDTO).getMemId();
    }

    @PostMapping("/resetPw")
    public boolean resetPwHandler(MemberDTO memberDTO){
        String resetPass = memberService.resetPwHandler(memberDTO);

        return false;
    }
}


