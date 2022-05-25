package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import enitity.Product;
import util.DbUtil;
import util.ParamUtil;

/**
 * Servlet implementation class Insert
 */
@WebServlet("/Insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		// 文字化け対策
        request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("productId");	
		String name = request.getParameter("productName");	
		String pri = request.getParameter("price");	
		String role = request.getParameter("roleId");	
		
		 // 入力値のチェック
//        if (ParamUtil.isNullOrEmpty(id) || ParamUtil.isNullOrEmpty(name) || ParamUtil.isNullOrEmpty(pri)||ParamUtil.isNullOrEmpty(role)) {
//        	request.setAttribute("id", "商品IDは必須です");
//        	request.setAttribute("name", " 商品名は必須です");
//        	request.setAttribute("price", "単価は必須です");
//        	request.setAttribute("roled", " カテゴリは必須です");
//  
//     
//        	request.getRequestDispatcher("insert.jsp").forward(request, response);
		
		//表示
        if(ParamUtil.isNullOrEmpty(id)) {
        	request.setAttribute("id", "商品IDは必須です");
        }
        if(ParamUtil.isNullOrEmpty(name)) {
        	request.setAttribute("name", "商品名は必須です");
        }
        if(ParamUtil.isNullOrEmpty(pri)) {
        	request.setAttribute("price", "単価は必須です");
        }
        if(ParamUtil.isNullOrEmpty(role)) {
        	request.setAttribute("roled", "商品名は必須です");
        }
        
        //入力受け取る
        request.getRequestDispatcher("insert.jsp").forward(request, response);
		String productId = request.getParameter("productId");	
		int categoryId = ParamUtil.checkAndParseInt(request.getParameter("categoryId"));
		String productName = request.getParameter("productName");
		int price = ParamUtil.checkAndParseInt(request.getParameter("price"));
		int roleId = ParamUtil.checkAndParseInt(request.getParameter("roleId"));
		String description = request.getParameter("description");
		
		 // Daoインスタンス化
        ProductDao dao = new ProductDao(DbUtil.getConnection());

        // 登録に使用するデータを用意
        Product newProduct = new Product(productId,categoryId,productName,price,description);

        // 登録処理
        dao.insert(newProduct);

        request.getRequestDispatcher("menu.jsp").forward(request, response);

        return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
