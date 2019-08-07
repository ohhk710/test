package lamdaexam;

import java.util.Calendar;

public class LamdaThreadLab {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH) + 1;
		int date = cal.get(Calendar.DATE);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);

		Thread t1 = new Thread(()-> {//AnonyThreadLab$1 로 이름됨 = runnable=interface라 객체만들어야함
			
				for (int i = 1; i <= 3; i++) {
					try {
						Thread.sleep(10 * 1000); // 10�ʸ���
						System.out.println("오늘은" + month + "월 " + date + "일.");
					} catch (InterruptedException e) {
					}
				}
			
		});

		Thread t2 = new Thread(()-> {
			
				for (int i = 1; i <= 5; i++) {
					try {
						Thread.sleep(3 * 1000); // 10�ʸ���
						System.out.println(hour + "시 " + minute + "분 " + second + "초");
					} catch (InterruptedException e) {
					}
				}
		});
		t1.start();
		t2.start();
		for (int i = 1; i <= 10; i++) {
			try {
				Thread.sleep(3 * 1000);
				System.out.println("number of milliseconds since January 1, 1970, 00:00:00 GMT");
			} catch (InterruptedException e) {
			}
		}
	}
}

//class Lab1 implements Runnable {
//	public void run() {
//
//		Calendar cal = Calendar.getInstance();
//		int month = cal.get(Calendar.MONTH) + 1;
//		int date = cal.get(Calendar.DATE);
//
//		for (int i = 1; i <= 3; i++) {
//			try {
//				Thread.sleep(10 * 1000); // 10�ʸ���
//				System.out.println("������" + month + "�� " + date + "���Դϴ�.");
//			} catch (InterruptedException e) {
//			}
//		}
//	}
//}

//class Lab2 implements Runnable {
//	public void run() {
//
//		Calendar cal = Calendar.getInstance();
//		int hour = cal.get(Calendar.HOUR_OF_DAY);
//		int minute = cal.get(Calendar.MINUTE);
//		int second = cal.get(Calendar.SECOND);
//
//		for (int i = 1; i <= 5; i++) {
//			try {
//				Thread.sleep(3 * 1000); // 10�ʸ���
//				System.out.println(hour + "�� " + minute + "�� " + second + "��");
//			} catch (InterruptedException e) {
//			}
//		}
//	}
//}
