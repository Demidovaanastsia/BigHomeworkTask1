package task2;

import java.util.ArrayList;
// преобразование полученных данных от пользователя к виду с которым можно работать
public class Parser {

	private Formatter form = new Formatter();

	public String getTextInputCars(String text) {
		String inputCars = text.replace("{", "").replace("}", "").replace(" ", "").replace("\"", "").replace("C", "")
				.replace("_", " ").replace("-", " ").replace(",", " 0 0 0,").trim(); 

		return inputCars;
	}

	public ArrayList<Car> getCars(String text, boolean type) throws Exception { // формирование коллекции машин
		int len = 0;
		ArrayList<Car> cars = new ArrayList<Car>();
		String[] textCars = text.split(",");

		if (type) {
			len = textCars.length;
		} else {
			len = textCars.length - 1;
		}
		for (int i = 0; i < len; i++) {
			Car car = new Car();
			int carId = car.getCounter();
			car.setCodeCar(Integer.parseInt(textCars[i].split(" ")[0]));
			car.setRegNumber(Integer.parseInt(textCars[i].split(" ")[1]));
			car.setMileage(Integer.parseInt(textCars[i].split(" ")[2]));
			car.setAdditParam(Integer.parseInt(textCars[i].split(" ")[3]));
			if (Integer.parseInt(textCars[i].split(" ")[4]) != 0) {
				car.setId(Integer.parseInt(textCars[i].split(" ")[4]));
			} else {
				car.setId(carId);
			}
			car.setDriverId(Integer.parseInt(textCars[i].split(" ")[5]));
			cars.add(car);
		}
		return cars;
	}

	public ArrayList<Driver> getDrivers(String text) throws NumberFormatException, Exception {

		ArrayList<Driver> drivers = new ArrayList<Driver>();

		String[] textDrivers = text.split(",");
		for (int i = 0; i < textDrivers.length - 1; i++) {
			Driver driver = new Driver();
			driver.setName(textDrivers[i].split(" ")[0].trim());
			driver.setId(Integer.parseInt(textDrivers[i].split(" ")[1]));
			driver.setCarId(Integer.parseInt(textDrivers[i].split(" ")[2]));
			drivers.add(driver);
		}
		return drivers;
	}

	public ArrayList<Car> getUseCars(ArrayList<Car> cars) {

		ArrayList<Car> useCars = new ArrayList<Car>();

		for (Car car : cars) {
			if (car.getDriverId() > 0) {
				useCars.add(car);
			}
		}
		return useCars;
	}

	public String splitCarType(ArrayList<Car> cars, int type) {
		ArrayList<Car> cars_100 = new ArrayList<Car>();
		ArrayList<Car> cars_200 = new ArrayList<Car>();
		ArrayList<Car> cars_300 = new ArrayList<Car>();
		ArrayList<Car> cars_400 = new ArrayList<Car>();

		String outputText = "";

		for (Car car : cars) {
			if (car.getCodeCar() == 100) {
				cars_100.add(car);
			} else if (car.getCodeCar() == 200) {
				cars_200.add(car);
			} else if (car.getCodeCar() == 300) {
				cars_300.add(car);
			} else {
				cars_400.add(car);
			}
		}
		if (type == 1) {
			outputText += "TYPE 100:\n"+form.sortMileage(cars_100)+"\n";
			outputText += "TYPE 200:\n"+form.sortMileage(cars_200)+"\n";
			outputText += "TYPE 300:\n"+form.sortMileage(cars_300)+"\n";
			outputText += "TYPE 400:\n"+form.sortMileage(cars_400)+"\n";
		} else {
			outputText += "TYPE 100:\n"+form.sortAdditParam(cars_100)+"\n";
			outputText += "TYPE 200:\n"+form.sortAdditParam(cars_200)+"\n";
			outputText += "TYPE 300:\n"+form.sortAdditParam(cars_300)+"\n";
			outputText += "TYPE 400:\n"+form.sortAdditParam(cars_400)+"\n";
		}
		return outputText;
	}
}
