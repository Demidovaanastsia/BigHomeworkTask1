package task2;

import java.util.ArrayList;

public class Calculator {//класс для произведения расчётов
	private final double gsmCost_100 = 46.10;
	private final double gsmCost_200 = 48.90;
	private final double gsmCost_300 = 47.50;
	private final double gsmCost_400 = 48.90;

	private final double fuelCons_100 = 12.5;
	private final double fuelCons_200 = 12;
	private final double fuelCons_300 = 11.5;
	private final double fuelCons_400 = 20;
	
	private final int costKilometer = 5;

	public int getTotalCost(ArrayList<Car> cars) {//полная стоимость расходов ГСМ за смену
		int totalCost = 0;
		for (Car car : cars) {
			switch (car.getCodeCar()) {
			case 100:
				totalCost += ((fuelCons_100 / 100) * gsmCost_100 * car.getMileage());
				break;
			case 200:
				totalCost += ((fuelCons_200 / 100) * gsmCost_200 * car.getMileage());
				break;
			case 300:
				totalCost += ((fuelCons_300 / 100) * gsmCost_300 * car.getMileage());
				break;
			case 400:
				totalCost += ((fuelCons_400 / 100) * gsmCost_400 * car.getMileage());
				break;
			}
		}
		return totalCost;
	}

	public int[][] getClassCost(ArrayList<Car> cars) {//полная стоимость расходов ГСМ за смену для каждого класса
		int[][] classCost = new int[4][2];
		for (Car car : cars) {
			switch (car.getCodeCar()) {
			case 100:
				classCost[0][0] += ((fuelCons_100 / 100) * gsmCost_100 * car.getMileage());
				classCost[0][1] = 100;
				break;
			case 200:
				classCost[1][0] += ((fuelCons_200 / 100) * gsmCost_200 * car.getMileage());
				classCost[1][1] = 200;
				break;
			case 300:
				classCost[2][0] += ((fuelCons_300 / 100) * gsmCost_300 * car.getMileage());
				classCost[2][1] = 300;
				break;
			case 400:
				classCost[3][0] += ((fuelCons_400 / 100) * gsmCost_400 * car.getMileage());
				classCost[3][1] = 400;
				break;
			}
		}
		return classCost;
	}

	public int getMaxCost(int[][] carCosts) { // нахождение максимальной стоимости 
		int maxValue = -1;
		int currentType = 0;

		for (int c = 0; c < carCosts.length; c++) {
			if (carCosts[c][0] > maxValue) {
				maxValue = carCosts[c][0];
				currentType = carCosts[c][1];
			}
		}
		return currentType;
	}

	public int getMinCost(int[][] carCosts) { // нахождение минимальной стоимости 
		int minValue = carCosts[0][0];
		int currentType = carCosts[0][1];

		for (int c = 0; c < carCosts.length; c++) {
			if (carCosts[c][0] < minValue) {
				minValue = carCosts[c][0];
				currentType = carCosts[c][1];
			}
		}
		return currentType;
	}
	
	public int getSalary(int mileage) {//расчёт зарплаты за смену водителю
		return mileage*costKilometer;
	}
}
