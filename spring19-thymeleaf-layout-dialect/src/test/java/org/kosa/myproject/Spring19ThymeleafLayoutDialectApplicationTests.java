package org.kosa.myproject;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.kosa.myproject.domain.Member;
import org.kosa.myproject.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//JUnit Test Framework : TDD 를 위한 자바 테스트 프레임워크
@SpringBootTest
class Spring19ThymeleafLayoutDialectApplicationTests {
	@Autowired
	private MemberMapper memberMapper;
	@Test
	void contextLoads() {
		System.out.println(memberMapper);
	}
	@Test
	void findMemberList() {
		List<Map<String,String>> list = memberMapper.findMemberMapList();
		System.out.println(list.size());
		Assertions.assertNotEquals(2,list.size()); // 0 이 아님을 예상(assert) -> 오류 없음 / 2가 아님을 예상 : 오류 나옴
	}
	@Test
	void insertMember() {
		int result = memberMapper.insertMember(new Member("TDD","b","기성용","포항"));
		Assertions.assertEquals(1, result);
	}

}
