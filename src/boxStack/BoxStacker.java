package boxStack;

import java.io.*;
import java.util.LinkedList;

public class BoxStacker {

	
	LinkedList<Box> currentStack = new LinkedList<Box>();
	int currentHeight;
	LinkedList<Box> head = new LinkedList<Box>();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(args[0]));
			String line;
			int count = 0;
			
			while ((line = br.readLine()) != null){
				String[] ints = line.split(" ");
				Box box = new Box(Integer.parseInt(ints[0]), Integer.parseInt(ints[1]), Integer.parseInt(ints[2]), ++count);
				
			}
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void addBox(Box aBox){
		
	}

	public int getHeight;

}
