package java_files;

public class Items {
	
	private properties prop = new properties();
	
	private int quantity;

	public properties getProp() {
		return prop;
	}

	public void setProp(properties prop) {
		this.prop = prop;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Items(properties prop, int quantity) {
		super();
		this.prop = prop;
		this.quantity = quantity;
	}
	
	public Items() {
		  super();
		 }
	

}
