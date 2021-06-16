package task2;

import static mypackage.MyScanner.*;
// создание класса пользователя. Администратора и пользователя 
abstract class User {

	int checkNum = -1;

	public abstract void dispInterface();

	public abstract int checkInterface();
}

class Operator extends User {

	public void dispInterface() {
		System.out.println("Пожалуйста выберете:\n");
		System.out.print("1 - Ввод информации по смене\n");
	}

	public int checkInterface() {

		checkNum = scanInt();

		switch (checkNum) {
		case 1:
			return checkNum;
		default:
			checkNum = 1;
			return checkNum;
		}
	}
}

class Admin extends User {

	public void dispInterface() {
		System.out.println("Please enter:\n");
		System.out.print("1 - Завести водителей\n");
		System.out.print("2 - Завести машины\n");
		System.out.print("3 - Список водителей\n");
		System.out.print("4 - Список автомобилей\n");
		System.out.print("5 - Переназначить водителя\n");
		System.out.print("6 - Создать отчёт\n");
		System.out.print("7 - Зарплата водителей\n");
		System.out.print("8 - Просмотреть архив\n");
	}

	public int checkInterface() {

		checkNum = scanInt();

		switch (checkNum) {
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:	
			return checkNum;
		default:
			checkNum = 1;
			return checkNum;
		}
	}
}