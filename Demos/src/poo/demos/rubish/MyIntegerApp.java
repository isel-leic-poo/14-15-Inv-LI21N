package poo.demos.rubish;

public class MyIntegerApp {

	@SuppressWarnings("unused")
	public static void main(String[] args) 
	{
		MyInteger[] values = new MyInteger[10];
		for(int count = 0; count < values.length; ++count)
			values[count] = MyInteger.newMyInteger(count);
		
		MyInteger another = MyInteger.newMyInteger(0);
	}

}
