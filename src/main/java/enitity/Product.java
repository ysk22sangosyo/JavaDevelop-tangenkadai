package enitity;

public class Product {
	private String productId;
	private int categoryId;
	private String productName;
	private int price;
	private String description;
   // private Category category;
	
	public Product() {
	}
	
	 public Product(String productId,int categoryId,String productName,int price,String description) {
	        this.productId = productId;
	        this.categoryId = categoryId;
	        this.productName = productName;
	        this.price = price;
	        this.description= description;
	    }
//	 public Product(String productId,String productName,int price,String description,int categoryId,String categoryName){
//		    this.productId = productId;
//	        this.categoryId = categoryId;
//	        this.productName = productName;
//	        this.price = price;
//	        this.description= description;
//	        this.category =new Category(categoryId,categoryName);
//	 }
	   

		public void setProductId(String productId) {
	        this.productId = productId;
	    }

	    public String getProductId() {
	        return this.productId;
	    }

	    public void setCategoryId(int categoryId) {
	        this.categoryId = categoryId;
	    }

	    public int getCategoryId() {
	        return this.categoryId;
	    }
	    
	    public void setProductName(String productName) {
	        this.productName = productName;
	    }

	    public String getProductName() {
	        return this.productName;
	    }
	    
	    public void setPrice(int price) {
	        this.price = price;
	    }

	    public int getPrice() {
	        return this.price;
	    }
	    
	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public String getDescription() {
	        return this.description;
	    }

}
