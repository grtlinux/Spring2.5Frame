package kame.spring.bbs.domain.service;

import java.util.List;

import kame.spring.bbs.domain.model.Member;

public interface MemberRepository {

	List<Member> findByInteretCategory(Integer categoryId);

}
