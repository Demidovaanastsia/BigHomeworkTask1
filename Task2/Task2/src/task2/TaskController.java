package task2;

import java.io.*;
import static mypackage.MyScanner.*;
import java.util.ArrayList;

public class TaskController {
	private int taskNum;
	private String path = "Task2/src/txtFiles";
	private TxtWorker rw = new TxtWorker();
	private Checker check = new Checker();
	private Parser pars = new Parser();
	private Formatter form = new Formatter();
	private Folder fold = new Folder();
	private Logger log = new Logger();
	private String inputText;
	private ArrayList<Car> cars;
	private ArrayList<Driver> drivers;

	public void setTaskNum(int taskNum) {
		this.taskNum = taskNum;
	}

	public void taskCheck() throws Exception {
		switch (taskNum) {
		case 1:
			setDrivers();
			break;
		case 2:
			setCars();
			break;
		case 3:
			getDrivers();
			break;
		case 4:
			getCars();
			break;
		case 5:
			changeDriver();
			break;
		case 6:
			generateReport();
			break;
		case 7:
			salaryDriver();
			break;
		case 8:
			getArchive();
			break;
		}
	}

	private void getDrivers() throws Exception {
		
		log.INFO("Список водителей");
		String driverNames = form.DriversView(rw.Read("Drivers.txt","Task2/src/txtFiles"));
		System.out.println(driverNames);
	}

	private void getCars() throws Exception {
		
		log.INFO("Список авто");
		String carNames = form.CarsView(rw.Read("Cars.txt","Task2/src/txtFiles"));
		System.out.println(carNames);
	}

	private void setCars() throws Exception {
		
		log.INFO("Ввод авто");
		boolean isInput = false;
		System.out.println("Пожалуйста введите список авто. Формат данных - С(CODE_CAR)_гос номер-пробег-доп.параметр "
				+ "или загрузите файл в формате txt, записав его название: 'name.txt'\n");

		String emptyLine = scanLine();
		inputText = scanLine();

		if (check.textCarsMaskCheck(inputText)) {
			isInput = true;
		} else if (check.fileMaskCheck(inputText)) {
			inputText = rw.Read(inputText,"Task2/src/txtFiles");
			if (check.textCarsMaskCheck(inputText)) {
				isInput = true;
			}
		}
		
		log.INFO("isInput: "+isInput);
		if (isInput) {
			String textCars = pars.getTextInputCars(inputText);
			cars = pars.getCars(textCars,false);

			for (Car car : cars) {
				String textCar = form.carForWrite(car);
				rw.Write("Cars.txt", textCar, true, path);
			}
		}
	}

	private void setDrivers() throws Exception {

		boolean isInput = false;
		System.out.println("Пожалуйста введите список водителей. Формат: Имя водителя, тип авто, номер; "
				+ "Или загрузите файл в формате txt, записав его название: 'name.txt'  \n");

		String emptyLine = scanLine();
		inputText = scanLine();

		if (check.textDriversMaskCheck(inputText)) {
			isInput = true;
		} else if (check.fileMaskCheck(inputText)) {
			inputText = rw.Read(inputText,"Task2/src/txtFiles");
			if (check.textDriversMaskCheck(inputText)) {
				isInput = true;
			}
		}

		if (isInput) {
			cars = pars.getCars(rw.Read("Cars.txt","Task2/src/txtFiles"),true);
			drivers = pars.getDrivers(rw.Read("Drivers.txt","Task2/src/txtFiles"));

			String[] driverList = inputText.split(";");

			for (int dN = 0; dN < driverList.length; dN++) {
				String name = driverList[dN].split(",")[0];
				int code = Integer.parseInt(driverList[dN].split(",")[1]);
				int num = Integer.parseInt(driverList[dN].split(",")[2]);

				for (Car car : cars) {
					if (car.getCodeCar() == code && car.getRegNumber() == num) {
						Driver driver = new Driver();
						driver.setId(driver.getCounter());
						driver.setName(name);
						driver.setCarId(car.getId());
						drivers.add(driver);
						car.setDriverId(driver.getId());
						break;
					}
				}
			}

			rw.Write("Cars.txt", "", false, path);
			for (Car car : cars) {
				String textCar = form.carForWrite(car);
				rw.Write("Cars.txt", textCar, true, path);
			}

			rw.Write("Drivers.txt", "", false, path);
			for (Driver driver : drivers) {
				String textDriver = form.driverForWrite(driver);
				rw.Write("Drivers.txt", textDriver, true, path);
			}
		}
	}

	private void changeDriver() throws Exception {

		boolean isInput = false;
		System.out.println("Пожалуйста введите водителя с машиной или загрузите файл. "
				+ "загрузите файл в формате txt, записав его название: 'name.txt' " + "Формат ввода: Имя водителя, тип авто, номер; \n");

		String emptyLine = scanLine();
		inputText = scanLine();

		if (check.textDriversMaskCheck(inputText)) {
			isInput = true;
		} else if (check.fileMaskCheck(inputText)) {
			inputText = rw.Read(inputText,"Task2/src/txtFiles");
			if (check.textDriversMaskCheck(inputText)) {
				isInput = true;
			}
		}

		if (isInput) {
			cars = pars.getCars(rw.Read("Cars.txt","Task2/src/txtFiles"),true);
			drivers = pars.getDrivers(rw.Read("Drivers.txt","Task2/src/txtFiles"));

			String[] driverList = inputText.split(";");

			for (int dN = 0; dN < driverList.length; dN++) {
				String name = driverList[dN].split(",")[0];
				int code = Integer.parseInt(driverList[dN].split(",")[1]);
				int num = Integer.parseInt(driverList[dN].split(",")[2]);

				for (Car car : cars) {
					if (car.getCodeCar() == code && car.getRegNumber() == num) {
						for (Driver driver : drivers) {
							if (driver.getId() == car.getDriverId()) {
								driver.setName(name);
							}
						}
					}
				}
			}

			rw.Write("Drivers.txt", "", false, path);
			for (Driver driver : drivers) {
				String textDriver = form.driverForWrite(driver);
				rw.Write("Drivers.txt", textDriver, true, path);
			}
		}
	}

	private void generateReport() throws Exception {
		
		Report rep = new Report();
		System.out.println(rep.getResultReportText());
	}

	private void salaryDriver() throws Exception {
		
		cars = pars.getUseCars(pars.getCars(rw.Read("Cars.txt","Task2/src/txtFiles"),true));
		drivers = pars.getDrivers(rw.Read("Drivers.txt","Task2/src/txtFiles"));
		
		System.out.println(form.textSalaryDriver(cars, drivers));
	}
	
	private void getArchive() throws Exception {
		
		File folder = new File("Task2/src/txtFiles/Shifts");
		fold.listFilesForFolder(folder);
		
		System.out.println("Пожалуйста введите название файла");

		String emptyLine = scanLine();
		inputText = scanLine();
		
		System.out.println(rw.Read(inputText,"Task2/src/txtFiles/Shifts"));
	}
}
