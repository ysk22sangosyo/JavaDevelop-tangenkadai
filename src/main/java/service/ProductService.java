package service;
import java.sql.Connection;
import java.util.List;

import dao.ProductDao;
import enitity.Product;
import util.DbUtil;
public class ProductService {
	//Id指定検索
	public List<Product> getByLikeKeyWord(String keyWord) {
        try (Connection conn = DbUtil.getConnection()) {
        	ProductDao productDao = new ProductDao(conn);
        	List<Product> product = productDao.findByLikeKeyWord(keyWord);

            return product;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
}

    /**
     * 更新
     */
    public void update(Product pd) {
        try (Connection con = DbUtil.getConnection()) {
            ProductDao pdDao = new ProductDao(con);
            pdDao.update(pd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 削除
     */
    public void delete(Integer productId) {
        try (Connection con = DbUtil.getConnection()) {
            ProductDao pdDao = new ProductDao(con);
            pdDao.delete(productId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

 public List<Product> findAll() {
        try (Connection conn = DbUtil.getConnection()) {
        	ProductDao productDao = new ProductDao(conn);
          List<Product> list = productDao.findAll();

            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null; 
    }   


}
