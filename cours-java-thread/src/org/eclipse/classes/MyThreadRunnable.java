package org.eclipse.classes;

public class MyThreadRunnable implements Runnable {

	private String name;
	
	public MyThreadRunnable() {
		// TODO Auto-generated constructor stub
	}
	
	public MyThreadRunnable(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			System.out.print(this.getName() + " ");
		}
	}

}
