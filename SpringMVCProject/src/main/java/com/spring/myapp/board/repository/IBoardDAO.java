
package com.spring.myapp.board.repository;

import java.util.List;

import com.spring.myapp.board.model.BoardVO;
import com.spring.myapp.commons.paging.Criteria;
import com.spring.myapp.commons.paging.SearchCriteria;

public interface IBoardDAO {

	
	void insert(BoardVO article) throws Exception;//에러나면 예외 처리 throws 사용하는쪽에서 예외처리
	BoardVO getArticle(int boardNo) throws Exception;
	void update(BoardVO article) throws Exception;
	void delete(int boardNo) throws Exception;
	
	//게시글 전체목록 불러오기
	List<BoardVO> getAllArticles() throws Exception;
	
	//게시글 페이지 별로 불러오기
	List<BoardVO> listPaging(Criteria cri) throws Exception;
	
	//게시글의 총 게시물 수를 불러오기
	int countArticles() throws Exception;
	
	//검색 동적 SQL처리
	List<BoardVO> listSearch(SearchCriteria cri) throws Exception;
	int countSearchArticles(SearchCriteria cri) throws Exception;
	
	
	/////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////안써이거//////////////////////////////////////////////////
	
	//제목으로 검색 SQL처리
	List<BoardVO> listSearchByTitle(SearchCriteria cri) throws Exception;
	
	List<BoardVO> listSearchByTitleContent(SearchCriteria cri) throws Exception;
	
	List<BoardVO> listSearchByWriter(SearchCriteria cri) throws Exception;

	List<BoardVO> listSearchByContent(SearchCriteria cri) throws Exception;
	
	//검색 후 게시물 수를 가져오기
	int countSearchedArticles(SearchCriteria cri) throws Exception;
	
	
	
}
