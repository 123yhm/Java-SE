package com.hp.tz.EnumDemo;

public class Person {
	private Gender sex;
	private Gender wu;

	public Gender getWu() {
		return wu;
	}

	public void setWu(Gender wu) {
		this.wu = wu;
	}

	public Gender getSex() {
		return sex;
	}

	public Person(Gender wu,Gender sex) {
		super();
		this.wu = wu;
		this.sex = sex;
	}
	public Person(Gender sex) {
		super();
		this.sex = sex;
	}



	public void setSex(Gender sex) {
		this.sex = sex;
	}


	@Override
	public String toString() {
		return "Person [sex=" + sex + "]";
	}
}


