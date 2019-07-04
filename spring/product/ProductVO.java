package vo;

public class ProductVO {

	private int bananaNb;
	private int appleNb;
	private int halabongNb;
	//�����Լ����� ������/ private�̴ϱ� public���� �ؼ� ��������
	public ProductVO() {
		bananaNb=0;
		appleNb=0;
		halabongNb=0;
	}
	
	public int getBananaNb() {
		return bananaNb;
	}
	public int getAppleNb() {
		return appleNb;
	}
	public int getHalabongNb() {
		return halabongNb;
	}
	public void setBananaNb(int bananaNb) {
		this.bananaNb += bananaNb;
	}
	public void setAppleNb(int appleNb) {
		this.appleNb += appleNb;
	}
	public void setHalabonNb(int halabongNb) {
		this.halabongNb += halabongNb;
	}
	
	
	
	
}
