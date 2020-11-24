package snake;
import java.util.Scanner;
public class Move{

	int z;
 
	public int MoveSnake(){
		System.out.println("Pick a direction (wasd ONLY!)");
		Scanner sc = new Scanner(System.in);
		char direction = sc.next().charAt(0);
		switch (direction) {
		case 'w': z=0; break;
		case 's': z=1; break;
		case 'a': z=2; break;
		case 'd': z=3; break;
	}
		return z;
	
	}
}