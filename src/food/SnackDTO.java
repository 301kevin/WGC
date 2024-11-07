package food;

public class SnackDTO {
	String foodname ;
	int price;
	int amount;
	
	public SnackDTO() {
	
	}
	
	public SnackDTO(String foodname, int price, int amount) {
		super();
		this.foodname = foodname;
		this.price = price;
		this.amount = amount;
	}
	public String getFoodname() {
		return foodname;
	}
	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

	

	
	

}
