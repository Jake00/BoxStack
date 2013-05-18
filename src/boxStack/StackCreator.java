package boxStack;

import java.io.IOException;
import java.util.ArrayList;

public class StackCreator {
	
	/**
	 * @author Jake Bellamy 1130587 jrb46
	 * @author Michael Coleman 1144239 mjc62
	 */
	ArrayList<Box> rotatedBoxes; 
	public StackCreator(ArrayList<Box> b) throws NumberFormatException, IOException{
		rotatedBoxes = b;
	}

	/**
	 * reads the boxes in from a file and stacks them in the order to give maximum height. 
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public void stack(){
		BoxList stacks[] = new BoxList[rotatedBoxes.size()];
		for(int i = 0; i < rotatedBoxes.size(); i++){
			BoxList bl = new BoxList();
			bl.add(rotatedBoxes.get(i));
			stacks[i] = bl;
		}

		for (int i = 1; i < rotatedBoxes.size(); i++)
			for (int j = 0; j < i; j++){
				if(rotatedBoxes.get(i).getFace()[0] < rotatedBoxes.get(j).getFace()[0] && 
						rotatedBoxes.get(i).getFace()[1] < rotatedBoxes.get(j).getFace()[1] && 
						stacks[i].getHeight() < stacks[j].getHeight() + rotatedBoxes.get(i).getHeight()){
					stacks[i] = new BoxList(stacks[j]);
					stacks[i].add(rotatedBoxes.get(i));
				}
			}

		BoxList max = new BoxList();
		for ( int i = 0; i < rotatedBoxes.size(); i++ )
			if ( max.getHeight() < stacks[i].getHeight())
				max = stacks[i];

		for(int i = 0; i < max.size(); i++){
			System.out.print(max.get(i).getName() + " ");
		}
		System.out.println();
		System.out.println(max.getHeight());
	}
}
