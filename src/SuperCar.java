
public class SuperCar extends Mobil{
	
	int topSpeed;
	int nitroCount;
	
	public SuperCar(String nama, String type, String manufacturer, int price, int topSpeed, int nitroCount) {
		super(nama, type, manufacturer, price);
		this.topSpeed = topSpeed;
		this.nitroCount = nitroCount;
	}

	public int getTopSpeed() {
		return topSpeed;
	}

	public void setTopSpeed(int topSpeed) {
		this.topSpeed = topSpeed;
	}

	public int getNitroCount() {
		return nitroCount;
	}

	public void setNitroCount(int nitroCount) {
		this.nitroCount = nitroCount;
	}

	@Override
	public void testDrive() {
		// TODO Auto-generated method stub
		System.out.println("1..2..3..4..5");
		System.out.println("brmmmmmmmm");
	}
	
}
