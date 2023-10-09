package restdocstest.controller;

import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import restdocstest.domain.Member;
import restdocstest.repository.MemberRepository;
import restdocstest.restdocs.RestDocsTest;

class MemberControllerTest extends RestDocsTest {

    @MockBean
    private MemberRepository memberRepository;

    @Test
    void test1() throws Exception {
        // given
        List<Member> members = List.of(new Member("doggy"), new Member("odo"));
        when(memberRepository.findAll()).thenReturn(members);

        String expected = objectMapper.writeValueAsString(members);

        // then
        mockMvc.perform(get("/members"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_VALUE))
                .andExpect(content().json(expected))
                .andDo(document("get-members"));
    }
}
