package kr.sc.ictjsp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.sc.ictjsp.correct.service.CorrectService;
import kr.sc.ictjsp.correct.service.InsertCorrect;
import kr.sc.ictjsp.question.service.InsertQuestionService;
import kr.sc.ictjsp.question.service.ListQuestionService;
import kr.sc.ictjsp.question.service.QuestionDetailService;
import kr.sc.ictjsp.question.service.QuestionService;
import kr.sc.ictjsp.question.service.SelectQuestionService;
import kr.sc.ictjsp.solve.service.InsertSolveService;
import kr.sc.ictjsp.solve.service.SolveService;
import kr.sc.ictjsp.users.service.BUserService;
import kr.sc.ictjsp.users.service.UserDeleteService;
import kr.sc.ictjsp.users.service.UserGetinfoService;
import kr.sc.ictjsp.users.service.UserJoinService;
import kr.sc.ictjsp.users.service.UserLoginService;
import kr.sc.ictjsp.users.service.UserLogoutService;
import kr.sc.ictjsp.users.service.UserUpdateService;

/**
 * Servlet implementation class Controller
 */
@WebServlet("*.use")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        System.out.println("Controller 생성");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Controller 실행");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("Controller 종료");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		deRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		deRequest(request, response);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	
	protected void deRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//businessUserService
		BUserService busv = null;
		QuestionService qs = null;
		CorrectService cs = null;
		SolveService ss = null;
		
		
		//ui 지정하기
		String ui = null;
		ui = "/UserView/notice.jsp";
		
		
		String uri = request.getRequestURI();
		System.out.println("현재 사용자 페이지 : " + uri);
		
		response.setContentType("text/html charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = null;
		session = request.getSession();
		// 회원가입~로그인처리 로직
		if(uri.equals("/OurJspProject/join.use")) {
			System.out.println("회원가입 요청");
			System.out.println("현재 사용자 페이지 : " + uri);
			busv = new UserJoinService();
			busv.execute(request, response);
			ui = "/UserView/login_form.jsp";
			
		} else if(uri.equals("/OurJspProject/login.use")) {
			System.out.println("로그인 요청");
			System.out.println("현재 사용자 페이지 : " + uri);
			busv = new UserLoginService();
			busv.execute(request, response);
			
			
			String check = (String)session.getAttribute("l_f");
			System.out.println("현재 사용자 페이지 : " + uri);
			if(check != null && check.equals("fail")) {
				session.invalidate();
				ui = "/UserView/login_form.jsp";
			}else {
				//System.out.println("이름 세션 : " +  );
				ui = "/UserView/login_success.jsp";
			}
			
		}else if(uri.equals("/OurJspProject/logout.use")) {
			System.out.println("현재 사용자 페이지 : " + uri);
			System.out.println("로그아웃 요청");
			busv = new UserLogoutService();
			busv.execute(request, response);
			ui = "/UserView/notice.jsp";
			
		}else if(uri.equals("/OurJspProject/update.use")) {
			System.out.println("현재  사용자 페이지 : " + uri);
			System.out.println("회원정보 수정");
			busv = new UserUpdateService();
			busv.execute(request, response);
			ui = "/UserView/update_form.jsp";
			
		}else if(uri.equals("/OurJspProject/delete.use")) {
			System.out.println("현재  사용자 페이지 : " + uri);
			System.out.println("회원탈퇴 요청");
			busv = new UserDeleteService();
			busv.execute(request, response);
			
			String check = (String)session.getAttribute("u_delete_fail");
			System.out.println("현재 사용자 페이지 : " + uri);
			
			if(check != null && check.equals("fail")) {
				session.invalidate();
				ui = "/UserView/login_form.jsp";
			}else {
				ui = "/UserView/delete_ok.jsp";
			}
			
		}else if(uri.equals("/OurJspProject/getinfo.use")) {
			System.out.println("현재 사용자 페이지 : " + uri);
			System.out.println("회원 정보 보기 요청");
			busv = new UserGetinfoService();
			busv.execute(request, response);
		}
		//문제 출제
		
		else if(uri.equals("/OurJspProject/questions.use")) {
			System.out.println("현재 사용자 페이지 : " + uri);
			System.out.println("문제 출제 페이지");
			qs = new InsertQuestionService();
			qs.execute(request, response);
			cs = new InsertCorrect();
			cs.execute(request, response);

			ui = "/TEST/question_list.jsp";
		}
		else if(uri.equals("/OurJspProject/q_list.use")) {
			System.out.println("현재사용자 페이지 : " + uri);
			System.out.println("현재 등록된 문제 페이지");
			qs = new ListQuestionService();
			qs.execute(request, response);
			ui = "/TEST/question_list.jsp";
			
		} else if(uri.equals("/OurJspProject/question_detail.use")) {
			System.out.println("현재 사용자 페이지 : " + uri);
			System.out.println("현재 문제 상세보기 페이지");
			ui = "/TEST/question_detail.jsp";
			
			qs = new QuestionDetailService();
			qs.execute(request, response);
		} else if(uri.equals("/OurJspProject/submit.use")) {
			System.out.println("현재 사용자 페이지 : " + uri);
			System.out.println("사용자 답안 제출 페이지");
			ss = new InsertSolveService();
			
			String qcode = request.getParameter("qcode");
			ui = "/OurJspProject/TEST/solve_form.jsp";
			
			ss.execute(request, response);
			
		} else if(uri.equals("/OurJspProject/solve_form.use")) {
			System.out.println("현재 사용자 페이지 : " + uri);
			System.out.println("사용자 답안 제출 페이지");
			ss = new InsertSolveService();
			
			String qcode = request.getParameter("qcode");
			ui = "/TEST/solve_form.jsp";
			
			ss.execute(request, response);
			
			
		} 
		else {
			System.out.println("잘못된 페이지");
		}
		
		RequestDispatcher dp  = request.getRequestDispatcher(ui);
		dp.forward(request, response);
	}
	

}
