package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// cmd + shift + t : 테스트 코드 바로 생성
public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long squence = 0L;
    private static final MemberRepository instance = new MemberRepository();

    private MemberRepository(){
    }

    public static MemberRepository getInstance(){
        return instance;
    }

    public Member save(Member member){
        member.setId(++squence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id){
        return store.get(id);
    }

    // 값을 조작해도 store 에 있는 값을 변경하고 싶지 않아서, store 자체 보호하기 위해
    public List<Member> findAll(){
        return new ArrayList<>(store.values());
    }

    // 테스트 때 많이 씀
    public void clearStore(){
        store.clear();
    }


}
