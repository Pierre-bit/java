package org.eclipse.classes;

public class MyThreadRunnable implements Runnable {

	private String name;
	
	public MyThreadRunnable() {
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
		for (int i = 0; i < 5; i++) {
			System.out.print(this.getName() + " ");
		}
	}

}
