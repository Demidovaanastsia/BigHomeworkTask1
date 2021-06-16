package task2;

public class Driver {//класс водитель
	private int counter = 0;
	private int id = 0;
	private String name = "";
	private int carId = 0;
	
	private TxtWorker rw = new TxtWorker();
	
	Driver() throws NumberFormatException, Exception{
		counter = Integer.parseInt(rw.Read("MaxIdDriver.txt", "Task2/src/txtFiles"));
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getCounter() throws Exception {
		counter++;
		rw.Write("MaxIdDriver.txt", "", false, "Task2/src/txtFiles");
		rw.Write("MaxIdDriver.txt", ""+counter, true, "Task2/src/txtFiles"); 
		return this.counter;
	}
	
	public int getId() {
		 return this.id;
	}

	public String getName() {
		return this.name;
	}

	public int getCarId() {
		return this.carId;
	}

}
