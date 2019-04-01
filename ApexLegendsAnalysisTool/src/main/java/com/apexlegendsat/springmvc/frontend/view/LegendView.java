package com.apexlegendsat.springmvc.frontend.view;


public class LegendView {

	private int id;
	private String nickName;
	private String role;
	private String name;
	private String age;
	private String tacticalAbility;
	private String passiveAbility;
	private String ultimateAbility;
	private String imageSource;
	
	public LegendView () {
		
	}

	public LegendView(int id, String nickName, String role, String name, String age, String tacticalAbility, String passiveAbility,
			String ultimateAbility, String imageSource) {
		super();
		this.id = id;
		this.nickName = nickName;
		this.role = role;
		this.name = name;
		this.age = age;
		this.tacticalAbility = tacticalAbility;
		this.passiveAbility = passiveAbility;
		this.ultimateAbility = ultimateAbility;
		this.imageSource = imageSource;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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

	public String getTacticalAbility() {
		return tacticalAbility;
	}

	public void setTacticalAbility(String tacticalAbility) {
		this.tacticalAbility = tacticalAbility;
	}

	public String getPassiveAbility() {
		return passiveAbility;
	}

	public void setPassiveAbility(String passiveAbility) {
		this.passiveAbility = passiveAbility;
	}

	public String getUltimateAbility() {
		return ultimateAbility;
	}

	public void setUltimateAbility(String ultimateAbility) {
		this.ultimateAbility = ultimateAbility;
	}
	
	public String getImageSource() {
		return this.imageSource;
	}
	
	public void setImageSource(String image) {
		this.imageSource = image;
	}

	@Override
	public String toString() {
		return "LegendView [id=" + id + ", nickName=" + nickName + ", name=" + name + ", age=" + age
				+ ", tacticalAbility=" + tacticalAbility + ", passiveAbility=" + passiveAbility + ", ultimateAbility="
				+ ultimateAbility + ", imageSource=" + imageSource + "]";
	}
	
}
