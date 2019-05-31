package mobile;

abstract class Mobile{
	private String mobileName;
	private int batterySize;
	private String osType;
	
	public Mobile(){
	}
	public Mobile(String mobileName, int batterySize, String osType) {
		this.mobileName=mobileName;
		this.batterySize=batterySize;
		this.osType=osType;
	}
	//get이나 set은 생성자 밑으로 보통 만듦
	//sauce에서 getters setters 생성메뉴 하면 됨
	
	public String getMobileName() {
		return mobileName;
	}
	public int getBatterySize() {
		return batterySize; //실제 이용 매서드. 배터리사이즈 값
	}
	public String getOsType() {
		return osType;
	}
	public void setMobileName(String mobileName) {
		this.mobileName = mobileName;
	}
	public void setBatterySize(int batterySize) {
		this.batterySize = batterySize;//입력되는 배터리 값 시작 ..
	}
	public void setOsType(String osType) {
		this.osType = osType;
	}
		
	public abstract void operate(int time) ;//abs라 세미콜론!바디없음으로 마무리 중괄호=일반메서드//{
	//} 반드시 오버라이딩 해줘야 실현가능
	public abstract void charge(int charge);
}
//getters 와 setters 이용하기!


class Ltab extends Mobile{
	public Ltab() {
	}
	public Ltab(String mobileName,int batterySize, String osType) {
		super(mobileName,batterySize,osType);
	}
	public void operate(int time) {//꼭 abs 매서드 오버라이딩 배터리 값에 시간당 10초씩 감소
		super.setBatterySize(super.getBatterySize()-time*10); 
		
	}
	public void charge(int time) {//꼭 abs 매서드 오버라이딩
		super.setBatterySize(super.getBatterySize()+time*10); 
	}
}
class Otab extends Mobile{
	public Otab() {
	}
	public Otab(String mobileName,int batterySize, String osType) {
		super(mobileName,batterySize,osType);
	}
	public void operate(int time) {//꼭 abs 매서드 오버라이딩 배터리 값에 시간당 10초씩 감소
		super.setBatterySize(super.getBatterySize()-time*12); 
		
	}
	public void charge(int time) {//꼭 abs 매서드 오버라이딩
		super.setBatterySize(super.getBatterySize()+time*8); 
	}
}

public class MobileTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ltab lt=new Ltab("Ltab",500,"ABC-01");
		Otab ot=new Otab("Otab",1000,"XYZ-20");
		
		printTitle();
		printMobile(lt);
		printMobile(ot);
		System.out.println();
		
		System.out.println("10분 충전");
		lt.charge(10);
		ot.charge(10);
		printTitle();
		printMobile(lt);
		printMobile(ot);
		System.out.println();
		
		System.out.println("5분 통화");
		lt.operate(5);
		ot.operate(5);
		printTitle();
		printMobile(lt);
		printMobile(ot);
		
	}
	public static void printMobile(Mobile mobile) {
		System.out.println(mobile.getMobileName()+"\t\t"+mobile.getBatterySize()+"\t\t\t"+mobile.getOsType());
	}
	
	public static void printTitle() {
		System.out.println("Mobile         "+"Battery           "+"OS");
		System.out.println("---------------------------------------");
	}
}
