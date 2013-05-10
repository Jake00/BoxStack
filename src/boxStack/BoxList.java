package boxStack;

import java.util.LinkedList;

@SuppressWarnings("serial")
public class BoxList extends LinkedList<Box> {
	/**
	 * 
	 */
	private int height;
	public BoxList(){
		super();
	}
	
	public void add(int loc, Box box){
		super.add(loc, box);
		height += box.getHeight();
	}

	public Box remove(int loc){
		Box box = super.remove(loc);
		height -= box.getHeight();
		return box;
	}

	public int getHeight(){
		return height;
	}
}
