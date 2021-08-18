package kr.sc.ictjsp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.sc.ictjsp.user.service.BUserService;
import kr.sc.ictjsp.user.service.UserJoinService;
import kr.sc.ictjsp.user.service.UserLoginService;
import kr.sc.ictjsp.user.service.UserLogoutService;

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
		
		
		//ui 지정하기
		String ui = null;
		ui = "/UserView/notice.jsp";
		
		
		String uri = request.getRequestURI();
		System.out.println("현재 페이지 : " + uri);
		
		response.setContentType("text/html charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		// 회원가입~로그인처리 로직
		if(uri.equals("/OurJspProject/join.use")) {
			System.out.println("회원가입 요청");
			busv = new UserJoinService();
			busv.execute(request, response);
			ui = "/UserView/login_form.jsp";
			
		} else if(uri.equals("/OurJspProject/login.use")) {
			System.out.println("로그인 요청");
			busv = new UserLoginService();
			busv.execute(request, response);
			ui = "/UserView/login_form.jsp";
			
		}else if(uri.equals("/OurJspProject/logout.use")) {
			System.out.println("로그아웃 요청");
			busv = new UserLogoutService();
			busv.execute(request, response);
			ui = "/UserView/login_forom.jsp";
			
		} 
		//게시판관련 로직
		
		
		else {
			//나중에 오류페이지로 보내주기
			//out.print("잘못된 페이지");
		}
		
		RequestDispatcher dp  = request.getRequestDispatcher(ui);
		dp.forward(request, response);
	}
	

}
