package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enitity.Product;
import service.ProductService;

/**
 * Servlet implementation class SerchServlet
 */
@WebServlet("/SerchServlet")
public class SerchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SerchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// response.getWriter().append("Served at: ").append(request.getContextPath());
//		// 文字化け対策
		request.setCharacterEncoding("UTF-8");
//
		// キーワードを取得
		String keyWord = request.getParameter("serch");
		ProductService ps = new ProductService();
		
		
		if (keyWord.equals("")) {
			// 未入力
			List<Product> productList = ps.findAll();
			request.setAttribute("result", productList);
			request.getRequestDispatcher("menu.jsp").forward(request, response);
			return;
//		
		} else {
			List<Product> productList = ps.getByLikeKeyWord(keyWord);
			request.setAttribute("result", productList);
			request.getRequestDispatcher("menu.jsp").forward(request, response);
		}

		// 次画面指定
		// request.getRequestDispatcher("menu.jsp").forward(request, response);
//		// ログインID、パスワードを取得

//		// 入力値のチェック
//		if (ParamUtil.isNullOrEmpty(id)) {
//			// メッセージ設定
//			request.setAttribute("msg", "product_idを入力してください");
//
//			// 次画面指定
//			request.getRequestDispatcher("top.jsp").forward(request, response);
//			return;
//		}
//		// ログインチェック

//		// 表示メッセージの受け渡し
//		if (productId != null) {
////			// メッセージ設定
////
//			request.setAttribute("productID", productId);
////
//			// 次画面指定
//			request.getRequestDispatcher("menu.jsp").forward(request, response);
//		}
//			List<Product> list = productService.find();
//			String msg = list.get(0).getProductName();
//			// メッセージ設定
//			request.setAttribute("msg", msg);
//			request.setAttribute("msg", "対象のデータはありません。 ");
//
//			// 次画面指定
//			request.getRequestDispatcher("top.jsp").forward(request, response);
//		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 文字化け対策
		request.setCharacterEncoding("UTF-8");
	}

}
