package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import enitity.Product;

public class ProductDao {
	private static final String SQL_SELECT_ALL = "SELECT * FROM products join categories on products.category_id = categories.id ORDER BY products.name;"
			+ "";
	private static final String SQL_INSERT = "INSERT INTO products (product_id,name, price,category_id,description) VALUES ( ?, ?, ?, ?, ?)";
	private static final String SQL_SELECT_WHERE_LIKE_PRODUCTS_NAME_OR_CATEGORIES_NAME = "SELECT * FROM products join categories on products.category_id=categories.id WHERE products.name LIKE ? OR categories.name LIKE ?";
	private static final String UPDATE = "UPDATE products SET name = ?, price = ?,category_id = ?,description = ? WHERE product_id = ?";
	private static final String DELETE = "DELETE FROM products WHERE product_id = ?";
	private static final String SQL_SELECT_WHERE_PRODUCT_NAME = "SELECT * FROM products WHERE name = ?";
	
	private Connection con;

	public ProductDao(Connection con) {
		this.con = con;
	}

	public List<Product> findAll() {
		List<Product> list = new ArrayList<Product>();

		try (PreparedStatement stmt = con.prepareStatement(SQL_SELECT_ALL)) {
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Product p = new Product(rs.getString("product_id"), rs.getInt("category_Id"),
						rs.getString("name"), rs.getInt("price"),rs.getString("description"));
				list.add(p);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}

	

	public List<Product> findByLikeKeyWord(String keyWord) {
		List<Product> list = new ArrayList<Product>();

		try (PreparedStatement stmt = con.prepareStatement(SQL_SELECT_WHERE_LIKE_PRODUCTS_NAME_OR_CATEGORIES_NAME)) {
			stmt.setString(1, "%"+keyWord+ "%");
			stmt.setString(2, "%"+keyWord+ "%");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Product p = new Product(rs.getString("product_id"), rs.getInt("category_Id"),
						rs.getString("name"), rs.getInt("price"),rs.getString("description"));
				list.add(p);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
	
//	public Product findByLikeKeyWord(String keyWord) {
//		
//		
//		try (PreparedStatement stmt = con.prepareStatement(SQL_SELECT_WHERE_LIKE_PRODUCTS_NAME_OR_CATEGORIES_NAME)) {
//
//			stmt.setString(1, "%"+keyWord+ "%");
//			stmt.setString(2, "%"+keyWord+ "%");
//
//			ResultSet rs = stmt.executeQuery();
//
//			if (rs.next()) {
//				return new Product(rs.getString("product_id"), rs.getInt("category_id"), rs.getString("name"),
//						rs.getInt("price"), rs.getString("description"));
//				
//			}
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//		return null;
//	}

	/**
	 * 更新
	 */
	public void update(Product pd) {

		try (PreparedStatement stmt = con.prepareStatement(UPDATE)) {
			stmt.setString(1, pd.getProductName());
			stmt.setInt(2, pd.getPrice());
			stmt.setString(3, pd.getProductId());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 削除
	 */
	public void delete(Integer productId) {

		try (PreparedStatement stmt = con.prepareStatement(DELETE)) {
			stmt.setInt(1, productId);

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void register(Product product) {
		try (PreparedStatement stmt = con.prepareStatement(SQL_INSERT)) {

			stmt.setString(1, product.getProductName());
			stmt.setInt(2, product.getPrice());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//登録
	public int insert(Product product) {
		try (PreparedStatement stmt = con.prepareStatement(SQL_INSERT)) {
			stmt.setString(1, product.getProductId());
			stmt.setInt(2, product.getCategoryId());
			stmt.setString(3, product.getProductName());
			stmt.setInt(4, product.getPrice());
			stmt.setString(5, product.getDescription());

			return stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
