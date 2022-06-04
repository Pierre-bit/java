package org.eclipse.enums;

public enum Sport {

	FOOT ("foot",1),
	RUGBY("rugby",2),
	TENNIS("tennis",3),
	CROSS_FIT("cross_fit",4),
	BASKET("basket",5);
	private final String name;
	private final int code;
	
	Sport (String name, int code)
	{
		this.name=name;
		this.code=code;
	}

	public int getCode() {
		return code;
	}

	public String getName() {
		return name;
	}
	
	
	
}
