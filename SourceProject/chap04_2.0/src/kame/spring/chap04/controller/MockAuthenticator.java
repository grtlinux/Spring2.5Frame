package kame.spring.chap04.controller;

public class MockAuthenticator implements Authenticator {

	@Override
	public void authenticate(String id, String password) {
		if (!id.equals("madvirus")) {
			throw new AuthenticationException("invalid id "+id);
		}
	}

}
