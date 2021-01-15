
public class CityCar extends Mobil {

	private String speakerType;
	private int seatCount;
	
	public CityCar(String nama, String type, String manufacturer, int price, String speakerType, int seatCount) {
		super(nama, type, manufacturer, price);
		this.speakerType = speakerType;
		this.seatCount = seatCount;
	}

	public String getSpeakerType() {
		return speakerType;
	}

	public void setSpeakerType(String speakerType) {
		this.speakerType = speakerType;
	}

	public int getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}

	@Override
	public void testDrive() {
		// TODO Auto-generated method stub
		System.out.println("1..2..3..4..5");
		System.out.println("Ngengg");
	}
	
	//alt + shift + s
	
	
}
