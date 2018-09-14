package edu.skku.charactergraphics;

public interface ShapeInterface {
	
	
	//return the offset for the shape.
	
	public void setOffset(int newOffset);
	
	//return the offset for the shape
	
	public int getOffset();
	
	//Draw the shape at lineNumber line down 
	// from the current line.
	
	public void drawAt(int lineNumber);
	
	// Draw the shape at the current line.
	
	public void drawHere();

}
