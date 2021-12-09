package com.kanboo.www.domain.repository.member;

import com.kanboo.www.domain.entity.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByMemIdAndMemPass(String memId, String memPw);

    int countByMemTag(String kTag);

    int countByMemToken(String token);

    int countByMemId(String memId);

    Member findByMemToken(String token);

    Member findByMemTokenAndMemId(String token,String memId);

}
