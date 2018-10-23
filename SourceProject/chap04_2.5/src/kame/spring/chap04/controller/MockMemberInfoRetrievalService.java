package kame.spring.chap04.controller;

public class MockMemberInfoRetrievalService implements
		MemberInfoRetrievalService {

	@Override
	public MemberInfo getMemberInfo(String userId) {
		MemberInfo memberInfo = new MemberInfo();
		memberInfo.setUserId(userId);
		memberInfo.setName("�ֹ���");
		Address address = new Address();
		address.setAddress1("�ּ�1");
		address.setAddress2("�ּ�2");
		memberInfo.setAddress(address);
		return memberInfo;
	}

}
