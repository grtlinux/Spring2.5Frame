package kame.spring.chap03.core;

public class GetBoardServiceImpl implements GetBoardService {

	@Override
	public Board getBoard(Integer id) {
		return new Board(id);
	}

}
