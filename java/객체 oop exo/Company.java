package emp;

abstract class Employee {
	private String name;
	private int number;
	private String department;// 부서
	private int salary;// 월급

	public Employee() {

	}

	public Employee(String name, int number, String department, int salary) {
		this.name = name;
		this.number = number;
		this.department = department;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public int getNumber() {
		return number;
	}

	public String getDepartment() {
		return department;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public abstract double tax();// 세금
}

//매서드 오버라이딩 관련있는 자손 매서드를 super로 부름 . 부모메서드는 그냥호출가능
//=============================================
class Secretary extends Employee implements Bonus {
	public Secretary() {

	}

	public Secretary(String name, int number, String department, int salary) {
		super(name, number, department, salary);
	}

	public double tax() {// 세금
		return super.getSalary() * 0.1;
		
	}

	public void incentive(int pay) {// 인센티브지급
		super.setSalary((int) (super.getSalary() + pay * 0.8));
	}
}

//==============================================
class Sales extends Employee implements Bonus {
	public Sales() {

	}

	public Sales(String name, int number, String department, int salary) {
		super(name, number, department, salary);
	}

	public double tax() {// 세금
		return super.getSalary() * 0.13;
	}

	public void incentive(int pay) {// 인센티브지급
		super.setSalary((int) (super.getSalary() + pay * 1.2));
	}

	public double getExtraPay() {// 추가수당지급
		return super.getSalary() * 0.03;
	}
}

//=====================================
interface Bonus {
	public void incentive(int pay);// 인센티브지급
}
//=====================================

public class Company {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee[] emp = new Employee[2];  //배열화
		emp[0] = new Secretary("Duke", 1, "secretary", 800);
		emp[1] = new Sales("Tuxi", 2, "sales", 1200);
		// 이름이 적혀있어도 그게 아니라서 호출할때 emp[1]은 진짜 Sales가 아니기때문에 비교하려면 형변환 필요할수도
// 		Employee[] emp = {
//		new Secretary("Duke", 1, "Secretary", 800),
//		new Sales("Tuxi", 2, "Sales", 1200)};


		printEmployee(emp, false);

		System.out.println("[인센티브 100지급]");
		((Secretary) emp[0]).incentive(100);
		((Sales) emp[1]).incentive(100);
		//for (Employee data:emp)  //배열을 문자열로
			//((Bonus))data).incentive(100);   ->data.
		
		printEmployee(emp, true);

	}

	public static void printEmployee(Employee[] emp, boolean isTax) {

		if (isTax == true) {
			System.out.println("name  	   department 	 salary 	     tax        extra pay");
			System.out.println("-------------------------------------------------------");
			
			System.out.println(emp[0].getName() + "\t\t" + emp[0].getDepartment() + "\t\t" + emp[0].getSalary() + "\t\t"
					+ emp[0].tax());
			System.out.println(emp[1].getName() + "\t\t" + emp[1].getDepartment() + "\t\t" + emp[1].getSalary() + "\t\t"
					+ emp[1].tax() + "\t\t" + ((Sales) emp[1]).getExtraPay());
//			for(Employee data : emp) {
//				if(data instanceof Secretary)
//					System.out.printf("%s\t\t%s\t\t%d\t\t%.1f\n", data.getName(), data.getDepartment(), data.getSalary(), data.tax());
//				else
//					System.out.printf("%s\t\t%s\t\t%d\t\t%.1f\t%.1f\n", data.getName(), data.getDepartment(), data.getSalary(), data.tax(), ((Sales)data).getExtraPay());
//			}
		} else {
			System.out.println("name  	   department 	  salary	     extra pay");
			System.out.println("-------------------------------------------------------");
			
			System.out.println(emp[0].getName() + "\t\t" + emp[0].getDepartment() + "\t\t" + emp[0].getSalary());
			System.out.println(emp[1].getName() + "\t\t" + emp[1].getDepartment() + "\t\t" + emp[1].getSalary() + "\t\t"
					+ ((Sales) emp[1]).getExtraPay());
			
//			for(Employee data : emp) {
//				if(data instanceof Secretary)
//					System.out.printf("%s\t\t%s\t\t%d\n", data.getName(), data.getDepartment(), data.getSalary());
//				else
//					System.out.printf("%s\t\t%s\t\t%d\t\t%.1f\n", data.getName(), data.getDepartment(), data.getSalary(), ((Sales)data).getExtraPay());
//			}
		}
	}
}
