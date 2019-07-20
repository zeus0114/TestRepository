package com.spring.myapp.board.service;

import java.util.List;

import com.spring.myapp.board.model.BoardVO;
import com.spring.myapp.commons.paging.Criteria;
import com.spring.myapp.commons.paging.SearchCriteria;

public interface IBoardService {

	void insert(BoardVO article) throws Exception;//에러나면 예외 처리 throws 사용하는쪽에서 예외처리
	BoardVO getArticle(int boardNo) throws Exception;
	void update(BoardVO article) throws Exception;
	void delete(int boardNo) throws Exception;
	
	List<BoardVO> getAllArticles() throws Exception;
	
	//페이징 처리
	List<BoardVO> listPaging(Criteria cri) throws Exception;
	//게시글의 총 게시물 수를 불러오기
	int countArticles() throws Exception;
	
	List<BoardVO> listSearch(SearchCriteria cri) throws Exception;
	
	
	//제목으로 검색하여 게시물 불러오기
	List<BoardVO> listSearchByTitle(SearchCriteria cri) throws Exception;
	List<BoardVO> listSearchByTitleContent(SearchCriteria cri) throws Exception;
		
	int countSearchedArticles(SearchCriteria cri) throws Exception;	
}
