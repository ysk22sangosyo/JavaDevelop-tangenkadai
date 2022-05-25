package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import enitity.Product;
import service.ProductService;
import util.ParamUtil;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 // 文字化け対策
        request.setCharacterEncoding("UTF-8");

        // 入力値取得
        Integer productId = ParamUtil.checkAndParseInt(request.getParameter("productId"));

        // 未入力時
        if (productId == null) {
            request.setAttribute("idErrMsg", "product_idは必須です");
            request.getRequestDispatcher("/delete.jsp").forward(request, response);

            return;
        }

        // サービスをインスタンス化
        ProductService ps = new ProductService();

        // 対象のデータがあるか確認
        Product product = ps.findById(productId);

        if (product == null) {
            request.setAttribute("msg", "対象のデータはありません");
            request.getRequestDispatcher("/delete.jsp").forward(request, response);

            return;
        }

        // 削除
        ps.delete(productId);

        // 結果画面へ
        request.getRequestDispatcher("/deleteResult.jsp").forward(request, response);

    }
	}

}
