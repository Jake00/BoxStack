package boxStack;

import java.io.*;

public class BoxStacker {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(args[0]));
			StackCreator sc = new StackCreator(br);
			sc.readBoxes();
			sc.printStack();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

