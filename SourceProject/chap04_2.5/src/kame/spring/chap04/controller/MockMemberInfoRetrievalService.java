package kame.spring.chap04.controller;

public class MockMemberInfoRetrievalService implements
		MemberInfoRetrievalService {

	@Override
	public MemberInfo getMemberInfo(String userId) {
		MemberInfo memberInfo = new MemberInfo();
		memberInfo.setUserId(userId);
		memberInfo.setName("최범균");
		Address address = new Address();
		address.setAddress1("주소1");
		address.setAddress2("주소2");
		memberInfo.setAddress(address);
		return memberInfo;
	}

}
