package poo.demos.rubish;

public class PenApp {

	private static void writeWithPen(Pen pen, String message)
	{
		System.out.println(pen.write(message));
	}
	
	public static void main(String[] args) 
	{
		Pen pen1 = new Pen("Red");
		writeWithPen(pen1, "SLB, O Maior!");
		
		Pen pen2 = new Pen("Yellow");
		writeWithPen(pen2, "Mal por mal, prefiro o Estoril.");
		
		ErasablePen pen3 = new ErasablePen("Green");
		writeWithPen(pen3, "WTF?!?!?");	
		pen3.erase();
	}

}
