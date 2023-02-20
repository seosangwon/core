package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{


    //오로지 memberRepository 인터페이스만 있을 뿐 MemoryMemberRepository 구현체는 없다.
    private final MemberRepository memberRepository;

    //중요!!
    //생성자 : 객체 의존성 주입을 받기 위해 선언했다. 이제 파라미터에 구현 객체가 들어올 것이다.
    @Autowired
     public MemberServiceImpl(MemberRepository memberRepository) {

         this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {

         memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);

    }
}
