package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {


    private MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping(value = "/new-form", method = RequestMethod.GET)
    public String newForm(){
        // Spring 은 유연하게 설계되어 있기 때문에, 발전한 방향인 ModelAndView 를 반환해도 되며, String 으로 논리 경로를 반환해도 된다
        // 저 안에서 해결해주는 것
//        return new ModelAndView("new-form");
        return "new-form";
    }

    @RequestMapping("/save")
    public String save(@RequestParam("username") String username,
                             @RequestParam("age") int age,
                             Model model) {
        // @RequestParam 은 request.getParameter 를 받으며
        // ㄴ int 의 경우 자동 Integer.ParseInt 도 해줌 ... 좋네
        // Model 이라는 객체를 받아서 데이터를 넣고 넘길 수 있음
        Member member = new Member(username, age);
        memberRepository.save(member);

        model.addAttribute("member", member); // Model

        return "save-result";
    }

    @RequestMapping
    public String members(Model model) {

        List<Member> members = memberRepository.findAll();

        model.addAttribute("members", members);
        return "members";
    }
}
