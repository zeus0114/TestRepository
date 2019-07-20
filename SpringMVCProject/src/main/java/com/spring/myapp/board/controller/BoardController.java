package com.spring.myapp.board.controller;
//게시판에 자원요청을해줄 컨트롤러

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.myapp.board.model.BoardVO;
import com.spring.myapp.board.service.IBoardService;
import com.spring.myapp.commons.paging.Criteria;
import com.spring.myapp.commons.paging.PageCreator;
import com.spring.myapp.commons.paging.SearchCriteria;

@Controller
@RequestMapping("/board")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private IBoardService service;


	//게시글 목록요청 처리 메서드
	//list라는 요청이 오면 이 메서드가 처리한다.
	//페이징 처리 전
	/*@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(Box b, Model model ) throws Exception {

		logger.info("/board/list request~~");

		model.addAttribute("articles", service.getAllArticles());


		//System.out.println("게시물 목록 페이지 열람 요청이 들어옴!");

		//model.addAttribute("aaaa", b.getAaa());
		//model.addAttribute("bbbb", b.getBbb());

		//System.out.println("aaa:" + b.getAaa());
		//System.out.println("bbb:" + b.getBbb());

		//System.out.println("aaa:" + aaa);
		//System.out.println("bbb:" + bbb);

		//System.out.println("aaa:" +req.getParameter("aaa"));
		//System.out.println("bbb:" +req.getParameter("bbb"));

		return "board/list";
	}*/
	
	//페이징 처리 후 게시글 목록 요청
	/*@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(Criteria cri, Model model) throws Exception{
		
		logger.info("/board/list : GET요청 발생");
		
		PageCreator pc = new PageCreator();
		pc.setCriteria(cri);
		pc.setArticleTotalCount(service.countArticles());
		
		model.addAttribute("articles", service.listPaging(cri));
		model.addAttribute("pageCreator", pc);
		
		return "board/list";
	}*/
	
	//검색 처리 후 게시글 목록 불러오기
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(SearchCriteria cri, Model model) throws Exception{
		
		logger.info("/board/list : GET요청 발생");
		
		PageCreator pc = new PageCreator();
		pc.setCriteria(cri);
		
		
			pc.setArticleTotalCount(service.countSearchedArticles(cri));
			model.addAttribute("articles", service.listSearch(cri));
			model.addAttribute("pageCreator", pc);
		
		return "board/list";
	}
	/*@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(SearchCriteria cri, Model model) throws Exception{
		
		logger.info("/board/list : GET요청 발생");
		
		PageCreator pc = new PageCreator();
		pc.setCriteria(cri);
		
		if(cri.getCondition().equals("title+content")) {
			pc.setArticleTotalCount(service.countSearchedArticles(cri));
			model.addAttribute("articles", service.listSearchByTitleContent(cri));
		}else {
			model.addAttribute("articles", service.listSearchByTitle(cri));
		}
		model.addAttribute("pageCreator", pc);
		
		return "board/list";
	}*/
	
	//게시글 작성화면 열람요청
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write(){

		logger.info("method: get > /board/write request~~");
		return "board/write";
	}

	//게시글 등록 요청
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(BoardVO article, RedirectAttributes redirectAttr) throws Exception {
		logger.info("method: post > /board/write");
		logger.info(article.toString());

		//서비스에서 insert 불러옴
		service.insert(article);
		redirectAttr.addFlashAttribute("message","regSuccess");
		return "redirect:/board/list";
	}

	@RequestMapping(value="/content", method=RequestMethod.GET)
	public String content(@RequestParam("boardNo") int boardNo, @ModelAttribute("criteria") SearchCriteria cri,
			Model model) throws Exception {

		logger.info("method: get > /board/content");
		model.addAttribute("article", service.getArticle(boardNo));
//      model.addAttribute("page", page);

		return "board/content";
	}

	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public String modify(@RequestParam("boardNo") int boardNo, @ModelAttribute("criteria") SearchCriteria cri,
			Model model) throws Exception {

		logger.info("method: get > /board/modify");
		model.addAttribute("article", service.getArticle(boardNo));
		
		return "board/modify";

	}

	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(BoardVO article,
			SearchCriteria cri,
			RedirectAttributes redirectAttributes) throws Exception {

		logger.info("method: post > /board/modify");
		service.update(article);
		
		redirectAttributes.addAttribute("page", cri.getPage())
						  .addAttribute("countPerPage", cri.getCountPerPage())
						  .addAttribute("condition", cri.getCondition())
						  .addAttribute("keyword", cri.getKeyword())
						  .addFlashAttribute("message", "modSuccess");
		
						  	
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	   public String remove(@RequestParam("boardNo") int boardNo,
			   SearchCriteria cri,
	         RedirectAttributes redirectAttributes) throws Exception {

	      logger.info("method: post > /board/delete");
	      service.delete(boardNo);
	      
	      redirectAttributes.addAttribute("page", cri.getPage())
		  .addAttribute("countPerPage", cri.getCountPerPage())
		  .addAttribute("condition", cri.getCondition())
		  .addAttribute("keyword", cri.getKeyword())
		  .addFlashAttribute("message", "modSuccess");
	      
	      return "redirect:/board/list";
	   }


	
	


}
