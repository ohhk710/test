package day9;

class TV{ //class 앞의 public 쓰면 따로 파일저장해야함 아님 전부 빼거나 
	private String model;
	private int size;
	private int channel;
	
	public TV() {
		
	}
	public TV(String model, int size, int channel) {
		this.model=model;
		this.size=size;
		this.channel=channel;
	}
	public void channelUp() {
		if(channel>10) {
			channel=1;
		}else {
			channel+=1;
		}
	}
	public void channelDown() {
		if(channel<1) {
			channel=10;
		}else {
			channel-=1;
		}
	}//channel 변수필요 값필요 ->get,set 필요 
	public int getChannel() {
		return channel;
	}
	public void setChannel(int channel) {
		this.channel = channel;
	}
	//model과 size의 변수값필요 get 변수값변화아니니set불필요 
	public String getModel() {
		return model;
	}
	public int getSize() {
		return size;
	}
}

class SaleTV extends TV{
	private int price;
	
	public SaleTV() {
		
	}
	public SaleTV(int price,String model,int size,int channel) {
		super(model,size,channel);//super먼저 적기
		this.price=price;
	}
	public void play() {
		System.out.printf("판매 TV 채널 %d번의 프로를 플레이 합니다.",super.getChannel());
	}
	public void sale() {
		System.out.printf("%s 모델의 상품을 판매합니다. %d 을 지불해 주세요.",super.getModel(),this.price);
	}
	public String toString() {//public필요
		return String.format("판매상품정보 : 모델명(%s), 가격(%d원), 크기(%d)",super.getModel(),this.price,super.getSize() );
	}
}

class RentalTV extends TV implements Rentable{
	private int price;
	public RentalTV() {
		
	}
	public RentalTV(int price,String model,int size,int channel) {
		super(model,size,channel);	
		this.price=price;
	}
	public void play(){
		System.out.printf("대여 TV 채널 %d번의 프로를 플레이 합니다.",super.getChannel());
	}
	public void rent() {
		System.out.printf("%s 모델의 상품을 대여합니다. %d 을 지불해 주세요.",super.getModel());
	}
	public String toString() {
		return String.format("판매상품정보 : 모델명(%s), 가격(%,d원), 크기(%d)",super.getModel(),this.price,super.getSize() );
	}//String.format 으로 리턴 받고 아니면 printf / ,d 100,000으로 나옴
}
interface Rentable{
	void rent();
}


public class TvTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SaleTV Stv= new SaleTV(300000,"SALETV-1",40,1);
		RentalTV Rtv=new RentalTV(100000,"RENTALTV-10",42,1);
		
		Stv.channelUp();
		Stv.channelUp();
		
		Rtv.channelDown();
		Rtv.channelDown();
		Rtv.channelDown();
		printAllTV(Stv);
		printAllTV(Rtv);
		printRentalTV((Rentable) Rtv);// 형변환필수
	}
	static void printAllTV(TV tv) {
		System.out.println(tv.toString());
		
		if(tv instanceof SaleTV) { //형변환
			((SaleTV)tv).play();
			((SaleTV)tv).sale();
//			SaleTV stv=(SaleTV) tv; //형변환해서 변수에담아 한번에호출하는게나음
//			stv.play();
//			stv.sale();
		}else if(tv instanceof RentalTV)
			((RentalTV)tv).play();
		
	}
	static void printRentalTV(Rentable tv) {//아규먼트로 전달된 Rentable =tv말함
		tv.rent();
	}

}














