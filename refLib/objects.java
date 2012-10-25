import java.util.*;

public class objects{

	public int min;
	public int max;

	public static void main(String[] args) {
		Scanner r = new Scanner(System.in);
		objects o = new objects();
		
		r.useDelimiter("\\s+");
		
		while(r.hasNextLine()) {
	
			String input = r.nextLine();
			String[] elements = input.split(" ");
			
			o.min = Integer.parseInt(elements[0]);
			o.max = Integer.parseInt(elements[1]);
			
			System.out.println(o.min + " " + o.max);
			System.out.print("\n");
		}
	}
}
