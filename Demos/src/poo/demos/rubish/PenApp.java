package poo.demos.rubish;

public class PenApp {

	private static void writeWithPen(Pen pen, String str)
	{
		System.out.println(pen.write(str));
	}
	
	public static void main(String[] args) 
	{
		Pen pen1 = new Pen("red");
		writeWithPen(pen1, "SLB, o Maior!");		
		
		Pen pen2 = new ErasablePen("yellow");
		writeWithPen(pen2, "Apesar de tudo, prefiro o Estoril aos demais.");		
	}

	
}
