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
		height = 0;
	}
	
	public BoxList(BoxList bl){
		super();
		for(int i = 0; i < bl.size(); i++){
			this.add(i, bl.get(i));
			height = bl.getHeight();
		}
	}
	
	@Override 
	public void add(int loc, Box box){
		height += box.getHeight();
		super.add(loc, box);
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
