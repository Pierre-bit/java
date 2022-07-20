package model;

//Dans une interface tout est public
public interface I {

	// equivalent a public static final String ...
	String MSG = "hello";

	// equivalent a public abstract void sayHello();
	void sayHello();

	
	//java 8 
	default void direBonjour() {
		System.out.println(createMessage()+"hello");
		
	}

	// une methode statique utilise des methode static
	static int add(int a, int b) {
		giveResult(a+b);
		return a + b;
	}
	
	// java 9 
	private String createMessage()
	{
		return "le message est ";
	}
	
	private static void giveResult(int result)
	{
		System.out.println("the result"+ result);
	}
	
	default void doIt()
	{
		
	}

}