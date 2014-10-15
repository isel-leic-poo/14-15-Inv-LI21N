package poo.demos.rubish;

public class PenApp {

	private static void writeWithPen(Pen pen, String message)
	{
		System.out.println(pen.write(message));
	}
	
	public static void main(String[] args) 
	{
		Pen pen1 = new Pen("Red");
		Pen pen4 = new Pen("Red");
		
		System.out.println(pen1 == pen4);
		System.out.println(pen1.equals(pen4));
		
		Object obj = pen4;
		System.out.println(pen1.equals(obj));
		
		System.out.println(pen1);
		System.out.println(pen4);
		writeWithPen(pen1, "SLB, O Maior!");
		System.out.println(pen1);
		
		Pen pen2 = new CheapPen("Yellow");

		System.out.println(pen2);
		writeWithPen(pen2, "Mal por mal, prefiro o Estoril.");
		System.out.println(pen2);
		
//		ErasablePen pen3 = new ErasablePen("Green");
//		writeWithPen(pen3, "WTF?!?!?");	
//		pen3.erase();
	}

}
