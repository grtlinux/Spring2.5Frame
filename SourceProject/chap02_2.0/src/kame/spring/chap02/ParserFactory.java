package kame.spring.chap02;

public class ParserFactory {

	private static ParserFactory instance = new ParserFactory();
	
	public static ParserFactory getInstance() {
		return instance;
	}
	
	private ParserFactory() {
	}
	
}
