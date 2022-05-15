package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    // 매 테스트 후 repo 초기화
    @AfterEach
    void atterEach(){
        memberRepository.clearStore();
    }

    @Test
    void save(){
        Member member = new Member("hello", 20);

        Member savedMember = memberRepository.save(member);

        Member findMember = memberRepository.findById(member.getId());
        assertThat(findMember).isEqualTo(savedMember);
    }

    @Test
    void findAll(){
        Member member1 = new Member("member1", 22);
        Member member2 = new Member("member2", 32);

        memberRepository.save(member1);
        memberRepository.save(member2);

        List<Member> result = memberRepository.findAll();

        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(member1,member2);
    }
}