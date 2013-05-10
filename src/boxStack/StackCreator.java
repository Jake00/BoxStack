package boxStack;

import java.io.BufferedReader;
import java.io.IOException;

public class StackCreator {
	BoxList currentStack = new BoxList();
	BoxList head = new BoxList();
	BufferedReader br;

	public StackCreator(BufferedReader br) throws NumberFormatException, IOException{
		this.br = br;
	}

	/**
	 * reads the boxes in from a file and stacks them in the order to give maximum height. 
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public void readBoxes() throws NumberFormatException, IOException{
		String line;
		int count = 0;

		while ((line = br.readLine()) != null){
			String[] ints = line.split(" ");
			Box box = new Box(Integer.parseInt(ints[0]), Integer.parseInt(ints[1]), Integer.parseInt(ints[2]), ++count);
			BoxList temp1 = currentStack;
			BoxList temp2 = currentStack;
			BoxList temp3 = currentStack;
			addBox(box, temp1);
			box.rotate();
			addBox(box, temp2);
			box.rotate();
			addBox(box, temp3);

			if(temp1.getHeight() > temp2.getHeight() && temp1.getHeight() > temp3.getHeight()){
				currentStack = temp1;
			}
			else if(temp2.getHeight() > temp1.getHeight() && temp2.getHeight() > temp3.getHeight()){
				currentStack = temp2;
			}
			else if(temp3.getHeight() > temp1.getHeight() && temp3.getHeight() > temp2.getHeight()){
				currentStack = temp2;
			}
			else
				System.err.println("Error when checking boxstack height");
		}
	}

	/**
	 * adds the current rotation of a box to a temporary stack for height comparisons 
	 * @param box is one of three rotations of the box that will be added
	 * @param stack is the temporary stack we will be adding this rotation of the box to to calculate its height.
	 * @return 1 if the add has been successful or -1 if the box cannot be used and needs to be stored.
	 */
	public int addBox(Box box, BoxList stack){
		//if the stack is empty just add the box.
		if(stack.getHeight() == 0){ 
			stack.add(box);
			return 1;
		}

		for(int i = 0; i < stack.size(); i++){ 
			//check all boxes in the stack and check if it can fit on top of them
			if (stack.get(i).getFace()[0] > box.getFace()[0] && stack.get(i).getFace()[1] > box.getFace()[1]){
				if(i > 0){
					//if the box above will fit on top of the box we want to add
					if(stack.get(i - 1).getFace()[0] < box.getFace()[0] && stack.get(i - 1).getFace()[1] < box.getFace()[1]){
						stack.add(box);
						return 1;
					}
					//if it wont fit, do a height comparisson to decide if this box is a more suitable candidate.
					else{
						if(stack.get(i).getHeight() < box.getHeight()){
							stack.remove(i);
							stack.add(i, box);
							//TODO: add box to a storage list.
						}
					}
				}
				//if the box will fit on the top	
				else{
					stack.add(i, box);
					return 1;
				}
			}


		}
		//check if the box will fit on the bottom
		if(stack.get(stack.size() -1).getFace()[0] < box.getFace()[0] && stack.get(stack.size() -1).getFace()[1] < box.getFace()[1]){
			stack.addLast(box);
			return 1;
		}


		return 0;
	}
}
