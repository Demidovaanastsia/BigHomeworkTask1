package task2;

import java.util.ArrayList;
// создание класса отчёт
public class Report {
	private Calculator calc = new Calculator();
	private Parser pars = new Parser();
	private TxtWorker rw = new TxtWorker();
	private Formatter form = new Formatter();
	private ArrayList<Car> cars;
	private ArrayList<Driver> drivers;
	
	int totalCost;
	int[][] classCost;
	int typeMaxCost;
	int typeMinCost;
	String carInfoSortMileage;
	String carInfoSortAdditParam;
	String salaryDriver;
	String resultReportText;
	
	Report() throws Exception {
		cars = pars.getUseCars(pars.getCars(rw.Read("Cars.txt","Task2/src/txtFiles"),true));
		drivers = pars.getDrivers(rw.Read("Drivers.txt","Task2/src/txtFiles"));
		
		totalCost = calc.getTotalCost(cars);
		classCost = calc.getClassCost(cars);
		typeMaxCost = calc.getMaxCost(classCost);
		typeMinCost = calc.getMinCost(classCost);

		carInfoSortMileage = pars.splitCarType(cars,1);
		carInfoSortAdditParam = pars.splitCarType(cars,2);
		
		salaryDriver = form.textSalaryDriver(cars, drivers);

		resultReportText = form.getReport(totalCost, classCost, typeMaxCost, typeMinCost, carInfoSortMileage,
				carInfoSortAdditParam,salaryDriver);
	}
	
	
	public String getResultReportText() {
		return resultReportText;
	}
	
	public String getSalaryDriver() {
		return salaryDriver;
	}
}
