package com.spring.myapp.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.myapp.board.model.BoardVO;
import com.spring.myapp.board.repository.IBoardDAO;
import com.spring.myapp.commons.paging.Criteria;
import com.spring.myapp.commons.paging.SearchCriteria;

@Service
public class BoardService implements IBoardService {
	
	@Autowired
	private IBoardDAO dao;
	
	@Override
	public void insert(BoardVO article) throws Exception {
		dao.insert(article);
		
	}

	@Override
	public BoardVO getArticle(int boardNo) throws Exception {
		
		return dao.getArticle(boardNo);
	}

	@Override
	public void update(BoardVO article) throws Exception {
		dao.update(article);
	}

	@Override
	public void delete(int boardNo) throws Exception {
		dao.delete(boardNo);
	}

	@Override
	public List<BoardVO> getAllArticles() throws Exception {
		
		return dao.getAllArticles();
	}

	@Override
	public List<BoardVO> listPaging(Criteria cri) throws Exception {
		
		return dao.listPaging(cri);
	}

	@Override
	public int countArticles() throws Exception {
		
		return dao.countArticles();
	}
	
	@Override
	public List<BoardVO> listSearch(SearchCriteria cri) throws Exception {

		return dao.listSearch(cri);
	}

	
	
	
	
	
	
	

	@Override
	public List<BoardVO> listSearchByTitle(SearchCriteria cri) throws Exception {
		
		return dao.listSearchByTitle(cri);
	}

	@Override
	public int countSearchedArticles(SearchCriteria cri) throws Exception {
		return dao.countSearchedArticles(cri);
	}

	@Override
	public List<BoardVO> listSearchByTitleContent(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.listSearchByTitleContent(cri);
	}

	
}
