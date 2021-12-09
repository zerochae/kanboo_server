package com.kanboo.www.domain.repository.member;

import com.kanboo.www.domain.entity.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByMemIdAndMemPass(String memId, String memPw);

    int countByMemTag(String memTag);

    int countByMemToken(String memToken);

    int countByMemId(String memId);

    Member findByMemToken(String memToken);
}
