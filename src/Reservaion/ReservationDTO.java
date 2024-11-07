package Reservaion;

public class ReservationDTO {
	int num;
	String name;
	String age;
	String image;
	String ageimage;
	
	public ReservationDTO() {
		
	}
	
	public ReservationDTO(String name) {
		super();
		this.name = name;
	}
	public ReservationDTO(String name,String image) {
		super();
		this.name = name;
		this.image = image;
	}
	
	public ReservationDTO(int num, String name, String age, String image, String ageimage) {
		super();
		this.num = num;
		this.name = name;
		this.age = age;
		this.image = image;
		this.ageimage = ageimage;
	}
	
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getAgeimage() {
		return ageimage;
	}
	public void setAgeimage(String ageimage) {
		this.ageimage = ageimage;
	}
	@Override
	public String toString() {
		return "ReservationDTO [num=" + num + ", name=" + name + ", age=" + age + ", image=" + image + ", ageimage="
				+ ageimage + "]";
	}

}
