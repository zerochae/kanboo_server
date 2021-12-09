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
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public boolean loginHandler(MemberDTO memberDTO) {

        Member member = memberRepository
                .findByMemIdAndMemPass(memberDTO.getMemId(), memberDTO.getMemPass());

        return member != null;
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
    public MemberDTO findIdHandler(MemberDTO memberDTO) {
        return memberRepository.findByMemToken(memberDTO.getMemToken()).entityToDto();
    }

    @Override
    @Transactional
    public String resetPwHandler(MemberDTO memberDTO) {
        Member member = memberRepository.findByMemToken(memberDTO.getMemToken());
        String newPw = null;

        if (member != null) {
            newPw = CreateTempPw.create();
            member.changeMemPass(newPw);
        }

        return newPw;
    }
}
