package fr.ort.m1.spring;

public class SalutationImpl implements Salutation {
	
	private Hello zeHello;

	public void setZeHello(Hello zeHello) {
		this.zeHello = zeHello;
	}

	
	public String saluerQqn(String name) {
		return zeHello.sayHello(name)+ ", tranquille ?";
	}

}
