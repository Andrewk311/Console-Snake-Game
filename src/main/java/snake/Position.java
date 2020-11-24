package snake;

import java.util.Random;

public class Position {

	Random rand = new Random();
	int x; 
	int y;
	
	public Position(int x, int y) {
		this.x=x;
		this.y=y;
	}
	public void Move(int z) {
		if (z == 0) {
         	x--;             //y++ = right, y-- = left, x-- = up, x++ = down
         }
         else if(z == 1) {
         	x++;
         }
         else if(z == 2) {
         	y--;
         }
         else if(z == 3) {
         	y++;
         }
	}
	public void ApplePos(){
		x = rand.nextInt((10 - 1) + 1) + 1;
 		y = rand.nextInt((20 - 1) + 1) + 1;
	}
	
		
	
}
