package kame.spring.chap04.controller;

public class MockMemberInfoRetrievalService implements
		MemberInfoRetrievalService {

	@Override
	public MemberInfo getMemberInfo(String userId) {
		MemberInfo memberInfo = new MemberInfo();
		memberInfo.setUserId(userId);
		memberInfo.setName("弥裹闭");
		Address address = new Address();
		address.setAddress1("林家1");
		address.setAddress2("林家2");
		memberInfo.setAddress(address);
		return memberInfo;
	}

}
