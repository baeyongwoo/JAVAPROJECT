package kr.sc.ictjsp.board.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.sc.ictjsp.board.model.boardDAO;
import kr.sc.ictjsp.board.model.boardVO;

public class boardListService implements boardService {

	@Override
	public void execute(HttpServletRequest requset, HttpServletResponse response) {

		List<boardVO> Blist = new ArrayList<>();

		try {
			boardDAO dao = boardDAO.getInstance();
			Blist = dao.boardList();

			requset.setAttribute("b_l", Blist);
			System.out.println(Blist);
		} catch (Exception e) {
			e.printStackTrace();

		}

	}
}
