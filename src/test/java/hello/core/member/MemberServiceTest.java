package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberServiceImpl memberService;
    @BeforeEach //각 테스트 실행 전에 무조건 실행 됨
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService= appConfig.memberService();
    }

   // 이전코드 MemberService memberService= new MemberServiceImpl();
    @Test
    void join(){
        //given
        Member member=new Member(1L,"memberA",Grade.VIP);


        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findMember); // 멤버랑,찾은멤버랑 같은지

    }
}
