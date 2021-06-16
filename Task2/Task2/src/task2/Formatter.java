package task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.text.SimpleDateFormat;
import java.util.Date;
// приведение инфо к нужному виду для глаз пользователя
public class Formatter {
	public String DriversView(String text) {
		int iterator = 1;
		String outputText = "";

		String[] driverNamesList = text.split(",");
		for (String dNL : driverNamesList) {
			outputText += iterator + ") " + dNL.split(" ")[0] + "\n";
			iterator++;
		}
		return outputText;
	}

	public String CarsView(String text) {
		int iterator = 1;
		String outputText = "";

		String[] carList = text.split(",");
		for (String car : carList) {
			outputText += iterator + ") " + "Код: " + car.trim().split(" ")[0] + "\n" + "Номер: "
					+ car.trim().split(" ")[1] + "\n" + "Пробег: " + car.trim().split(" ")[2] + "\n" + "Доп.параметр: "
					+ car.trim().split(" ")[3] + "\n";
			iterator++;
		}
		return outputText;
	}

	public String carForWrite(Car car) {
		String outputText = "";

		outputText = car.getCodeCar() + " " + car.getRegNumber() + " " + car.getMileage() + " " + car.getAdditParam()
				+ " " + car.getId() + " " + car.getDriverId() + ",";

		return outputText;
	}

	public String driverForWrite(Driver driver) {
		String outputText = "";

		outputText = driver.getName() + " " + driver.getId() + " " + driver.getCarId() + ",";

		return outputText;
	}
	
	public String textSalaryDriver(ArrayList<Car> cars, ArrayList<Driver> drivers) {
		Calculator calc = new Calculator();
		String outputText = "";
		
		for (Driver driver : drivers) {
			for (Car car : cars) {
				if(driver.getId()==car.getDriverId()) {
					outputText += "Driver "+driver.getName() + 
							" : Salary is "+ calc.getSalary(car.getMileage()) + "\n";
					break;
				}
			}
		}

		return outputText;
	}

	public String sortMileage(ArrayList<Car> cars) {

		String outputText = "";

		Collections.sort(cars, new Comparator<Car>() {
			@Override //переопределение метода сортировки, для сортировки коллекции по параметру 
			public int compare(Car o1, Car o2) {
				if (o1.getMileage() - o2.getMileage() > 0) {
					return 0;
				} else {
					return -1;
				}
			}
		});

		for (Car car : cars) {
			outputText += " \nТип авто: " + car.getCodeCar() + "\nНомер авто: " + car.getRegNumber() + "\nПробег: "
					+ car.getMileage() + "\nДоп.параметр: " + car.getAdditParam()+"\n\n";
		}
		return outputText;
	}

	public String sortAdditParam(ArrayList<Car> cars) {
		String outputText = "";

		Collections.sort(cars, new Comparator<Car>() {
			@Override
			public int compare(Car o1, Car o2) {
				if (o1.getAdditParam() - o2.getAdditParam() > 0) {
					return 0;
				} else {
					return -1;
				}
			}
		});

		for (Car car : cars) {
			outputText += " \nТип авто: " + car.getCodeCar() + "\nНомер авто: " + car.getRegNumber() + "\nПробег: "
					+ car.getMileage() + "\nДоп.параметр: " + car.getAdditParam()+"\n\n";
		}
		return outputText;
	}

	public String getReport(int totalCost, int[][] classCost, int typeMaxCost, int typeMinCost,
			String carInfoSortMileage, String carInfoSortAdditParam, String salaryDriver) {
		// формирование отчёта

		Date dateNow = new Date();
		SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd-MM-yyyy");
		String outputText = "";

		outputText = "Отчет от " + formatForDateNow.format(dateNow) + "\n\n" 
		+ "Общие затраты на ГСМ: " + totalCost + "\n\n" 
		+ "Затраты на каждый класс авто составили: \n" 
		+ "Тип " + classCost[0][1]+" : "+ classCost[0][0] + "\n"
		+ "Тип " + classCost[1][1]+" : "+ classCost[1][0] + "\n"
		+ "Тип " + classCost[2][1]+" : "+ classCost[2][0] + "\n"
		+ "Тип " + classCost[3][1]+" : "+ classCost[3][0] + "\n\n"
		+ "Наименьшие затраты имеет тип: " + typeMinCost + "\n"
		+ "Наибольшие затраты имеет тип: " + typeMaxCost + "\n\n"
		+ "Отсортированная информация по пробегу: \n" + carInfoSortMileage+ "\n\n"
		+ "Отсортированная информация по доп.параметру: \n" + carInfoSortAdditParam + "\n\n"
		+ "Заработанные водителями средства \n" + salaryDriver;

		return outputText;
	}
}