package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor // 자동으로 생성자를 만들어준다. + 생성자는 하나 니까 빈 등록도 자동
//중요! 인터페이스에만 으존하므로 DI를 지켜주고 있다.
public class OrderServiceImpl implements  OrderService{


    private final MemberRepository memberRepository;
    private final  DiscountPolicy discountPolicy;




    //단일체계원칙으로 order에서 한꺼번에 할인이 아닌 할인정책을 따로 설계된것이다.
    @Override // 할인가격이 추가 된  Order 객체 생성
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        //memberId로 찾은 멤버를 넘겨주었다.
        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
