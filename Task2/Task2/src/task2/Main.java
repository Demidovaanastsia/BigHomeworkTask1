// тут 


package task2;

import java.text.SimpleDateFormat;
import java.util.Date;
import static mypackage.MyScanner.*;

public class Main {

	public static void main(String[] args) throws Exception {
		Logger log = new Logger();
		// Асинхронный метод который закрывает смену 
		Thread myThready = new Thread(new Runnable()
		{
			private TxtWorker rw = new TxtWorker();
			private Checker check = new Checker();
			private Logger log = new Logger();
			public void run()
			{
				while(true) {
					try {
						Date dateNow = new Date();
						if(dateNow.getHours()==20 & dateNow.getMinutes()==00 & !check.isShiftFile(dateNow)) {
							log.INFO("Закрытие смены");
							Report rep = new Report();
							SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd-MM-yyyy");
							log.INFO("Запись в файл"+formatForDateNow.format(dateNow)+".txt");
							rw.Write(formatForDateNow.format(dateNow)+".txt", rep.getResultReportText(), false, "Task2/src/txtFiles/Shifts");
							
						}
						Thread.sleep(60000);// проверка каждую минуту 
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
		myThready.start();
		
		Session s1;
		User user;
		TaskController tc;

		int checkNum;
		
		s1 = new Session();
		log.INFO("СТАРТ НОВОЙ СЕССИИ");
		s1.start();

		user = s1.user;
		user.dispInterface();
		checkNum = user.checkInterface();

		tc = new TaskController();
		tc.setTaskNum(checkNum);
		tc.taskCheck();

	}
}
// Ввыполнение входа под одним из видов пользователя
class Session {
	private Logger log = new Logger();
	private String[][] accounts = { { "Admin", "123zxc" }, { "Operator", "123zxc" } };

	private String login;
	private String password;

	public User user;

	public void start() throws Exception {

		System.out.print("\n Пожалуйста, введите логин: ");
		login = scanLine();

		System.out.print("\n Пожалуйста, введите пароль: ");
		password = scanLine();

		autorization(login, password);
	}

	private void autorization(String login, String password) throws Exception {
		if (accounts[0][0].equals(login) && accounts[0][1].equals(password)) {
			System.out.println("\n Вход под администратором \n");
			log.INFO("Вход под администратором");
			user = new Admin();
		}

		else if (accounts[1][0].equals(login) && accounts[1][1].equals(password)) {
			System.out.println("\n Вход под оператором \n");
			log.INFO("Вход под оператором");
			user = new Operator();
		}

		else {
			System.out.println("Некорректные данные ввода");
			log.INFO("Некорректные данные ввода");
			System.exit(0);
		}
	}
}