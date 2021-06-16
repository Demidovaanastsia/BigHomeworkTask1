package task2;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
// проверка того что ввёл пользователь при вводе машин, водителей, названия файла.
public class Checker {
	private String textCarMask = "^(?:\\{?\\\"?C[0-9]{3}_[0-9]+-[0-9]+(-[0-9]+)?\\\"?\\}?, ?)*(?:\\{?\\\"?C[0-9]{3}_[0-9]+-[0-9]+(-[0-9]+)?\\\"?\\}? ?){1}$";
	private String textDriverMask = "^([A-Za-zА-Яа-яЁё],(?:100|200|300|400)+,[0-9]+;+)+$";
	private String fileMask = "^[A-Za-z0-9]+\\.txt$";

	private boolean maskCheckCarText;
	private boolean maskCheckDriverText;
	private boolean maskCheckfile;

	public boolean textCarsMaskCheck(String text) {
		maskCheckCarText = text.matches(textCarMask);
		return maskCheckCarText;
	}
	
	public boolean textDriversMaskCheck(String text) {
		maskCheckDriverText = text.trim().matches(textDriverMask);
		return maskCheckDriverText;
	}

	public boolean fileMaskCheck(String text) {
		maskCheckfile = text.matches(fileMask);
		return maskCheckfile;
	}

	public int[] isCar(ArrayList<Car> cars,int code, int num) {
		
		int[] result = new int[2];
		int driverId = -1;
		int index = -1;
		
		for(Car car : cars) {
			if (car.getCodeCar()==code && car.getRegNumber()==num) {
				index = cars.indexOf(car);
				if(car.getDriverId()==0) {
					driverId = 0;
				} else {
					driverId = car.getDriverId();
				}
			}
		}
		result[0] = driverId;
		result[1] = index;
		return result;
	}
	
	public boolean isShiftFile(Date dateNow) {
		boolean isShiftFile = false;
		
		SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd-MM-yyyy");
		
		isShiftFile = new File("Task2/src/txtFiles/Shifts"+formatForDateNow.format(dateNow)+".txt").isFile();
		return isShiftFile;
	}
}
