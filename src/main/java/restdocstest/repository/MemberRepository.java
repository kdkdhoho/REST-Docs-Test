package restdocstest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restdocstest.domain.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
