package boxStack;

public class Box {

	private final int d1;
	private final int d2; 
	private final int d3; 
	private final int name;
	private int orientation;

	
	public Box(int d1, int d2, int d3, int name){
		this.d1 = d1;
		this.d2 = d2;
		this.d3 = d3; 
		this.name = name;
		orientation = 3; 
	}
	
	public int[] getFace(){
		switch (orientation) {
		case 1:
			return new int[]{d2,d3};
		case 2:
			return new int[]{d1,d3};
		case 3:
			return new int[]{d1,d2};
		default:
			return null;
		}
		
	}
	
	public void rotate(){
		if(++orientation > 3)
			orientation = 1;
	}
	
	public int getHeight(){
		switch (orientation) {
		case 1:
			return d1;
		case 2:
			return d2;
		case 3:
			return d3;
		default:
			return 0;
		}
		
	}
}
