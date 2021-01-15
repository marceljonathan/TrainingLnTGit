
public abstract class Mobil {
	
	private String nama;
	private String type;
	private String manufacturer;
	private int price;
	
	public abstract void testDrive();
	
	public Mobil(String nama, String type, String manufacturer, int price) {
		super();
		this.nama = nama;
		this.type = type;
		this.manufacturer = manufacturer;
		this.price = price;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	//alt + shift + s
	
}
