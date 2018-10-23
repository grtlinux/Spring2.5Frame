package kame.spring.bbs.domain.service;

import java.util.ArrayList;
import java.util.List;

import kame.spring.bbs.domain.model.Member;

public class MemberRepositoryImpl implements MemberRepository {

	@Override
	public List<Member> findByInteretCategory(Integer categoryId) {
		List<Member> members = new ArrayList<Member>();
		members.add(new Member("a@a.com", "a"));
		members.add(new Member("b@b.com", "b"));
		return members;
	}

}
