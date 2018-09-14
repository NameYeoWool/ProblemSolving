package edu.skku.charactergraphics;

public class Rectangle extends ShapeBasics implements RectangleInterface {
	
	private int height;
	private int width;
	
	public Rectangle(){
		super();
		height = 0;
		width = 0;
	}
	
	public Rectangle(int theOffset, int theHeight, int theWidth){
		super(theOffset);
		height = theHeight;
		width = theWidth;
	}
	
	public void set(int newHeight, int newWidth){
		height = newHeight;
		width = newWidth;
	}
	
	public void drawHere(){
		
		if(height == 0 || width == 0) System.out.println("가로 또는 세로 입력 값이 '0'으로 입니다.");
		
		drawHorizontalLine();
		drawSides();
		drawHorizontalLine();
	}
	
	//writes the indicated number of spaces.
	private static void skipSpace(int number){
		for(int count = 0 ; count <number; count++){
			System.out.print(' ');
		}
	}
	
	
	
	public void drawHorizontalLine(){
		int offset = super.getOffset();
		
		skipSpace(offset);
		
		
	}
	
	
	public void drawSides(){
		
		
	}

}
