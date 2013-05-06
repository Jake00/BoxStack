package boxStack;

import java.util.LinkedList;

public class BoxList<Box> extends LinkedList<Box> {
	private int height;
	public BoxList(){
		super();
	}
	
	public void add(int loc, Box abox){
		super.add(loc, abox);
	}

	public Box remove(int loc){
		Box box = super.remove(loc);
		return box;
	}

	public int getHeight(){
		return height;
	}
}
