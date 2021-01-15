import java.util.Scanner;
import java.util.Vector;

public class Main {

	//abstract class
	
	public Main() {
		// TODO Auto-generated constructor stub
//		Mobil mobil1 = new CityCar("My Car2", "Xenia", "Daihatsu", 100000000, "Sony", 7);
//		System.out.println(mobil1.getNama());
//		System.out.println(((CityCar)mobil1).getSpeakerType());
//		mobil1.testDrive();
//		
//		System.out.println();
//		
//		Mobil mobil2 = new SuperCar("My Car 1", "Supra", "Toyota", 500000000, 200, 4); 
//		System.out.println(mobil2.getNama());
//		System.out.println(((SuperCar)mobil2).getTopSpeed());
//		mobil2.testDrive();
		Menu();
	}

	Scanner scan = new Scanner(System.in);
	Vector<Mobil> listMobil = new Vector<Mobil>();
	
	void Clear() {
		for(int a = 0; a < 30; a++) {
			System.out.println("");
		}
	}
	
	void Menu() {
		int chooseMenu;
		do {
			Clear();
			System.out.println("Car Dealer");
			System.out.println("----------\n");
			System.out.println("1. Add new Car");
			System.out.println("2. View All Car");
			System.out.println("3. Update Car");
			System.out.println("4. Delete Car");
			System.out.println("5. Exit");
			System.out.print(">> ");
			chooseMenu = scan.nextInt();
			scan.nextLine();
		}while(chooseMenu < 1 || chooseMenu > 5);
		
		switch(chooseMenu) {
		case 1:
			AddCar();
			break;
		case 2:
			ViewCar();
			break;
		case 3:
			updateCar();
			break;
		case 4:
			deleteCar();
			break;
		case 5:
			Clear();
			return;
		}
	}
	
	void AddCar() {
		String carName, carType, carManu, carModel, speakerType;
		int carPrice, seatCount, topSpeed, nitroCount;
		Clear();
		System.out.println("Add Car");
		System.out.println("-------\n");
		
		System.out.print("Insert Car Name: ");
		carName = scan.nextLine();
		
		System.out.print("Insert Car Type: ");
		carType = scan.nextLine();
		
		System.out.print("Insert Car Manufacturer: ");
		carManu = scan.nextLine();
		
		System.out.print("Insert Car Price(in million): ");
		carPrice = scan.nextInt();
		scan.nextLine();
		
		do {
			System.out.print("Insert Car Model(SuperCar/CityCar): ");
			carModel = scan.nextLine();
		}while(!(carModel.contentEquals("SuperCar") || carModel.contentEquals("CityCar")));
		
		if(carModel.contentEquals("CityCar")) {
			System.out.print("Input Speaker Type: ");
			speakerType = scan.nextLine();
			
			System.out.print("Input Total Seat: ");
			seatCount = scan.nextInt();
			scan.nextLine();
			
			listMobil.add(new CityCar(carName, carType, carManu, carPrice, speakerType, seatCount));
		}else if(carModel.contentEquals("SuperCar")) {
			System.out.print("Input Car Top Speed(in kmph): ");
			topSpeed = scan.nextInt();
			scan.nextLine();
			
			System.out.print("Input Nitro Count: ");
			nitroCount = scan.nextInt();
			scan.nextLine();
			
			listMobil.add(new SuperCar(carName, carType, carManu, carPrice, topSpeed, nitroCount));
		}
		System.out.println("\nData successfully added\n");
		
		System.out.println("Press Enter to Continue...");
		scan.nextLine();
		Menu();
	}
	
	void ViewCar() {
		int carView;
		Clear();
		
		if(listMobil.isEmpty()) {
			System.out.println("There is no car\n");
			System.out.println("Press Enter to Continue...");
			scan.nextLine();
			Menu();
		}else {
			System.out.println("View Car");
			System.out.println("--------\n");
			
			for(int a = 0; a < listMobil.size(); a++) {
				System.out.println((a+1) + ". " + listMobil.get(a).getNama());
			}
			
			do {
				System.out.print("\nSelect Car Number to View(0 to exit)(1-" + listMobil.size() + "): ");
				carView = scan.nextInt();
				scan.nextLine();
			}while(carView < 0 || carView > listMobil.size());
			
			if(carView == 0) {
				System.out.println("\nPress Enter to Continue...");
				scan.nextLine();
				Menu();
			}else {
				viewCarDetail(carView-1);
			}
		}
	}
	
	void viewCarDetail(int index) {
		String valid;
		Clear();
		System.out.println("Name: " + listMobil.get(index).getNama());
		System.out.println("---------------------\n");
		System.out.println("Car Type: " + listMobil.get(index).getType());
		System.out.println("Car Manufacturer: " + listMobil.get(index).getManufacturer());
		System.out.println("Car Price: " + listMobil.get(index).getPrice() + " million");
		
		if(listMobil.get(index) instanceof CityCar) {
			System.out.println("Speaker Type: " + ((CityCar)listMobil.get(index)).getSpeakerType());
			System.out.println("Seat Count: " + ((CityCar)listMobil.get(index)).getSeatCount());
		}else if(listMobil.get(index) instanceof SuperCar) {
			System.out.println("Top Speed: " + ((SuperCar)listMobil.get(index)).getTopSpeed() + " kmph");
			System.out.println("Nitro Count: " + ((SuperCar)listMobil.get(index)).getNitroCount());
		}
		
		do {
			System.out.print("\nDo you want to test drive(yes/no): ");
			valid = scan.nextLine();
		}while(!(valid.equalsIgnoreCase("yes") || valid.equalsIgnoreCase("no")));
		
		if(valid.equalsIgnoreCase("yes")) {
			System.out.println();
			listMobil.get(index).testDrive();
		}
		
		System.out.println("\nPress Enter to Continue...");
		scan.nextLine();
		Menu();
	}
	
	void updateCar() {
		int carUpdate, carPrice, nitroCount;
		String speakerType;
		Clear();
		if(listMobil.isEmpty()) {
			System.out.println("There is no car\n");
			System.out.println("Press Enter to Continue...");
			scan.nextLine();
			Menu();
		}else {
			System.out.println("Update Car");
			System.out.println("----------\n");
			
			for(int a = 0; a < listMobil.size(); a++) {
				System.out.println((a+1) + ". " + listMobil.get(a).getNama());
			}
			
			do {
				System.out.print("\nSelect Car Number to Update(0 to exit)(1-" + listMobil.size() + "): ");
				carUpdate = scan.nextInt();
				scan.nextLine();
			}while(carUpdate < 0 || carUpdate > listMobil.size());
			
			if(carUpdate == 0) {
				System.out.println("\nPress Enter to Continue...");
				scan.nextLine();
				Menu();
			}else {
				System.out.print("Input new Price: ");
				carPrice = scan.nextInt();
				scan.nextLine();
				
				listMobil.get(carUpdate-1).setPrice(carPrice);
				
				if(listMobil.get(carUpdate-1) instanceof CityCar) {
					System.out.print("Input new Speaker Type: ");
					speakerType = scan.nextLine();
					
					((CityCar)listMobil.get(carUpdate-1)).setSpeakerType(speakerType);
				}else {
					System.out.print("Input new Nitro Count: ");
					nitroCount = scan.nextInt();
					scan.nextLine();
					
					((SuperCar)listMobil.get(carUpdate-1)).setNitroCount(nitroCount);
				}
				
				System.out.println("\nData Successfully Updated\n");
				
				System.out.println("Press Enter to Continue...");
				scan.nextLine();
				Menu();
			}
		}
	}
	
	void deleteCar() {
		int carDelete;
		Clear();
		if(listMobil.isEmpty()) {
			System.out.println("There is no car\n");
			System.out.println("Press Enter to Continue...");
			scan.nextLine();
			Menu();
		}else {
			System.out.println("Delete Car");
			System.out.println("----------\n");
			
			for(int a = 0; a < listMobil.size(); a++) {
				System.out.println((a+1) + ". " + listMobil.get(a).getNama());
			}
			
			do {
				System.out.print("\nSelect Car Number to Delete(0 to exit)(1-" + listMobil.size() + "): ");
				carDelete = scan.nextInt();
				scan.nextLine();
			}while(carDelete < 0 || carDelete > listMobil.size());
			
			if(carDelete == 0) {
				System.out.println("\nPress Enter to Continue...");
				scan.nextLine();
				Menu();
			}else {
				listMobil.remove(carDelete-1);
				
				System.out.println("\nCar Successfully Deleted\n");
				
				System.out.println("Press Enter to Continue...");
				scan.nextLine();
				Menu();
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
