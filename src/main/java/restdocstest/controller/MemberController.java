package restdocstest.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restdocstest.controller.dto.MemberInfoResponse;
import restdocstest.domain.Member;
import restdocstest.repository.MemberRepository;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberRepository memberRepository;

    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @GetMapping
    ResponseEntity<List<MemberInfoResponse>> findAll() {
        List<Member> members = memberRepository.findAll();
        List<MemberInfoResponse> response = members.stream()
                .map(MemberInfoResponse::toResponse)
                .toList();

        return ResponseEntity.ok(response);
    }
}
