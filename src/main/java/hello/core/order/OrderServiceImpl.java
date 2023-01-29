package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;


//중요! 인터페이스에만 으존하므로 DI를 지켜주고 있다.
public class OrderServiceImpl implements  OrderService{

    //final이 있으면 생성자가 있어서 할당 되어야 한다.
    private final MemberRepository memberRepository;
    private final  DiscountPolicy discountPolicy;

    // 생성자 에서 받은 파라미터 구현체로 의존성을 주입 받는다.
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    //단일체계원칙으로 order에서 한꺼번에 할인이 아닌 할인정책을 따로 설계된것이다.
    @Override // 할인가격이 추가 된  Order 객체 생성
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        //memberId로 찾은 멤버를 넘겨주었다.
        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
