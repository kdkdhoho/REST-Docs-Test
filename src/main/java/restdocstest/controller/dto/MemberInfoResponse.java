package restdocstest.controller.dto;

import restdocstest.domain.Member;

public record MemberInfoResponse(
        Long id,
        String name
) {

    public static MemberInfoResponse toResponse(Member member) {
        return new MemberInfoResponse(
                member.id(),
                member.name()
        );
    }
}
