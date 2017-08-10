package cn.itmuch.entity;

public class BookInfo {
	/*
	 * select type ,max(price) maxPrice ,sum(price) totalPrice from books group
	 * by type;
	 */
	private Integer type;
	private double maxPrice;
	private double totalPrice;

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public double getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "BookInfo [type=" + type + ", maxPrice=" + maxPrice + ", totalPrice=" + totalPrice + "]";
	}

	public BookInfo(Integer type, double maxPrice, double totalPrice) {
		super();
		this.type = type;
		this.maxPrice = maxPrice;
		this.totalPrice = totalPrice;
	}

}
