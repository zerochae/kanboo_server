package com.kanboo.www.service.impl.member;

import com.kanboo.www.domain.entity.member.Member;
import com.kanboo.www.domain.repository.member.MemberRepository;
import com.kanboo.www.dto.global.RoleDto;
import com.kanboo.www.dto.member.MemberDTO;
import com.kanboo.www.service.inter.member.MemberService;
import com.kanboo.www.util.CreateKTag;
import com.kanboo.www.util.CreateTempPw;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public boolean loginHandler(MemberDTO memberDTO) {
        return memberRepository
                .findByMemIdAndMemPass(memberDTO.getMemId(), memberDTO.getMemPass()) != null;
    }

    @Override
    public MemberDTO signHandler(MemberDTO memberDTO) {

        String kTag, toKen = "";

        do {
            kTag = CreateKTag.create();
        } while (isExistKTag(kTag) > 0);

        do {
            toKen = UUID.randomUUID().toString();
        } while (isExistToken(toKen) > 0);

        memberDTO.setRole(new RoleDto(1L, "ROLE_MEMBER"));

        memberDTO.setMemToken(toKen);
        memberDTO.setMemTag(kTag);

        Member member = memberRepository.save(memberDTO.dtoToEntity());

        return member.entityToDto();
    }

    @Override
    public int isExistKTag(String kTag) {
        return memberRepository.countByMemTag(kTag);
    }

    @Override
    public int isExistToken(String token) {
        return memberRepository.countByMemToken(token);
    }

    @Override
    public int isExistId(String memId) {
        return memberRepository.countByMemId(memId);
    }

    @Override
    public MemberDTO findIdHandler(String token) {
        return memberRepository.findByMemToken(token).entityToDto();
    }

    @Override
    public MemberDTO resetPwHandler(String token, String memId) {

        MemberDTO member = memberRepository.findByMemTokenAndMemId(token,memId).entityToDto();
        member.setMemPass(CreateTempPw.create());
        System.out.println(member.getMemPass());
        return memberRepository.findByMemTokenAndMemId(token, memId).entityToDto();
    }
}
