package poo.demos.rubish;

public class PenApp {

	private static void writeWithPen(Pen pen, String str)
	{
		System.out.println(pen.write(str));
	}
	
	public static void main(String[] args) 
	{
		Pen pen1 = new Pen("red");
		Pen pen2 = new Pen("red");
		
		System.out.println(pen1.toString());
		System.out.println(pen2.toString());

		for(int i = 0; i < 10; ++i)
		{
			writeWithPen(pen1, "SLB, o Maior!");		
			writeWithPen(pen2, "Glorioso S L B!");
		}
		
		System.out.println(pen1.equals(pen2)); 
		System.out.println(pen2.equals(pen1)); 
		System.out.println(pen1.hashCode()); 
		System.out.println(pen2.hashCode()); 
//		System.out.println(pen1.equals(pen1)); 
		
//		Object obj1 = pen1;
//		Object obj2 = "Banana"; 
		
//		System.out.println(obj1.equals(obj2)); 
//		System.out.println(obj2.equals(obj1)); 
//		System.out.println(obj1.equals(obj1)); 

		Pen pen3 = new CheapPen("red");
		writeWithPen(pen3, "Limpinho, limpinho.");
		System.out.println(pen1.equals(pen3)); 
		System.out.println(pen3.equals(pen1)); 
		System.out.println(pen1.hashCode()); 
		System.out.println(pen3.hashCode()); 
	
		Pen cheapHasHell = new CheapPen("Green");
		System.out.println(cheapHasHell);
		writeWithPen(cheapHasHell, "Se é barato, não é bom");		
		System.out.println(cheapHasHell);
	}

	
}
