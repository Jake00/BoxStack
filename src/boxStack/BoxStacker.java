package boxStack;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;


public class BoxStacker {

	/**
	 * @author Jake Bellamy 1130587 jrb46
	 * @author Michael Coleman 1144239 mjc62
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(args[0]));
			String line;
			int count = 0;
			ArrayList boxes = new ArrayList<Box>();

			while ((line = br.readLine()) != null){
				String[] ints = line.split(" ");
				Box box = new Box(Integer.parseInt(ints[0]), Integer.parseInt(ints[1]), Integer.parseInt(ints[2]), 1, ++count);
				boxes.add(box);
				for(int i = 2; i < 4; i++){
					boxes.add(box.rotate(i, count));
				}
			}
			br.close();
			Collections.sort(boxes);
			StackCreator sc = new StackCreator(boxes);
			sc.stack();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
