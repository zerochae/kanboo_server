package com.kanboo.www.controller.noaccess;

import com.kanboo.www.dto.member.MemberDTO;
import com.kanboo.www.security.JwtSecurityService;
import com.kanboo.www.service.inter.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/access")
public class AccessController {

    private final MemberService memberService;
    private final JwtSecurityService jwtSecurityService;


    @PostMapping("/login")
    public String loginHandler(MemberDTO memberDTO) {

        String token = "";

        boolean loginHandler = memberService.loginHandler(memberDTO);
        if (loginHandler) {
            token = jwtSecurityService.createToken(memberDTO.getMemId(), 60L);
        }
        return token;
    }

    @PostMapping("/sign")
    public String signHandler(MemberDTO memberDTO) {
        System.out.println(memberDTO);
        MemberDTO signHandler = memberService.signHandler(memberDTO);
        return signHandler.getMemToken();
    }

    @GetMapping("/idCheck")
    public boolean idDuplicateCheck(String memId) {
        return memberService.isExistId(memId) > 0;
    }

    @PostMapping("/findId")
    public String findIdHandler(String token) {

        //아이디 찾기는 아이디만
        // 패스워드찾기는 resetmethod작성해서 문자 발송하고 비번 변경시킨다음
        // 개인정보는 묶어서 post

        return memberService.findIdHandler(token).getMemId();
    }

    @PostMapping("/resetPw")
    public boolean resetPwHandler(String token, String memId){
        return memberService.resetPwHandler(token,memId) != null;
    }
}


