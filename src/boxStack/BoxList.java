package boxStack;

import java.util.LinkedList;

/**
 * @author Jake Bellamy 1130587 jrb46
 * @author Michael Coleman 1144239 mjc62
 */
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
	public boolean add(Box box){
		height += box.getHeight();
		return super.add(box);
	}

	public int getHeight(){
		return height;
	}
	
}
