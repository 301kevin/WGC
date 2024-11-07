package Movie;

public class MoveDTO {
	private int num;
    private String name;
    private String age;
    private String ageimage;
    private String image;
    
    public MoveDTO() {
		// TODO Auto-generated constructor stub
	}

	public MoveDTO(int num, String name, String age, String ageimage, String image) {
		super();
		this.num = num;
		this.name = name;
		this.age = age;
		this.ageimage = ageimage;
		this.image = image;
	}

	@Override
	public String toString() {
		String str = String.format("%s\t,%s\t,%s\t,%s\t,%s", num,name,age,ageimage,image);
		return str;
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

	public String getAgeimage() {
		return ageimage;
	}

	public void setAgeimage(String ageimage) {
		this.ageimage = ageimage;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
    
    
}
