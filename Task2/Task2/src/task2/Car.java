package task2;

public class Car {// класс авто
	private int counter;
	private int id;
	private int codeCar = 0;
	private int regNumber = 0;
	private int mileage = 0;
	private int additParam = 0;
	private int DriverId = 0;
	
	private TxtWorker rw = new TxtWorker();
	
	Car() throws Exception{
		counter = Integer.parseInt(rw.Read("MaxIdCar.txt", "Task2/src/txtFiles"));
	}

	public void setCodeCar(int codeCar) {
		this.codeCar = codeCar;
	}

	public void setRegNumber(int regNumber) {
		this.regNumber = regNumber;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public void setAdditParam(int additParam) {
		this.additParam = additParam;
	}
	
	public void setDriverId(int DriverId) {
		this.DriverId = DriverId;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getCodeCar() {
		 return this.codeCar;
	}

	public int getRegNumber() {
		return this.regNumber;
	}

	public int getMileage() {
		return this.mileage;
	}

	public int getAdditParam() {
		return this.additParam;
	}
	
	public int getDriverId() {
		return this.DriverId;
	}
	
	public int getId() {
		return this.id;
	}
	
	public int getCounter() throws Exception {
		counter++;
		rw.Write("MaxIdCar.txt", "", false, "Task2/src/txtFiles");
		rw.Write("MaxIdCar.txt", ""+counter, true, "Task2/src/txtFiles");
		return this.counter;
	}
}
