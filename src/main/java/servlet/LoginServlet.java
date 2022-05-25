package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import enitity.User;
import service.UserService;
import util.ParamUtil;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 文字化け対策
        request.setCharacterEncoding("UTF-8");
        //セッションを取得
        HttpSession session = request.getSession();

        // ログインID、パスワードを取得
        String id = request.getParameter("loginId");
        String pass = request.getParameter("pass");

        // 入力値のチェック
//        if (ParamUtil.isNullOrEmpty(id) || ParamUtil.isNullOrEmpty(pass)) {
//        	request.setAttribute("id", "IDは必須です");
//        	request.setAttribute("pass", " PASSは必須です");
//        	request.getRequestDispatcher("index.jsp").forward(request, response);
//        }
        
        // ログインチェック
        UserService userService = new UserService();
        User user = userService.authentication(id, pass);

        // 表示メッセージの受け渡し
//        if(ParamUtil.isNullOrEmpty(id) && ParamUtil.isNullOrEmpty(pass)) {
//        	request.setAttribute("id", "IDは必須です");
//        	request.setAttribute("pass", " PASSは必須です");
//        	request.getRequestDispatcher("index.jsp").forward(request, response);
//        }
         if (user != null) {
            // 次画面指定
        	request.setAttribute("user", user);
        	session.setAttribute("user1", user.getUserName());
            request.getRequestDispatcher("menu.jsp").forward(request, response);
         }
         if (ParamUtil.isNullOrEmpty(id) && ParamUtil.isNullOrEmpty(pass)) {
 			request.setAttribute("id", "IDは必須です");
 			request.setAttribute("pass", " PASSは必須です");
 			request.getRequestDispatcher("index.jsp").forward(request, response);
      }
         if (ParamUtil.isNullOrEmpty(id)) {
    			request.setAttribute("id", "IDは必須です");
    			request.getRequestDispatcher("index.jsp").forward(request, response);
         }
         if (ParamUtil.isNullOrEmpty(pass)) {
            	request.setAttribute("pass", " PASSは必須です");
            	request.getRequestDispatcher("index.jsp").forward(request, response);
	     } else {
	    	 	request.setAttribute("msg", "IDまたはパスワードが不正です");	
	    	 	request.getRequestDispatcher("index.jsp").forward(request, response);
	     }
        
            
//        }else if (ParamUtil.isNullOrEmpty(id)) {
//        			request.setAttribute("id", "IDは必須です");
//        			request.getRequestDispatcher("index.jsp").forward(request, response);
//        } else if (ParamUtil.isNullOrEmpty(pass)) {
//        	request.setAttribute("pass", " PASSは必須です");
//        	request.getRequestDispatcher("index.jsp").forward(request, response);
//        	
        
            // メッセージ設定
           // request.setAttribute("msg", "IDまたはパスワードが不正です");

            // 次画面指定
            //request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    
	
	
}
