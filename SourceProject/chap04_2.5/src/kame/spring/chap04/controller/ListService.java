package kame.spring.chap04.controller;

import java.util.List;

public interface ListService {

	List<Article> getList(String bbsId, Integer pageNo, String searchKeyword);

}
