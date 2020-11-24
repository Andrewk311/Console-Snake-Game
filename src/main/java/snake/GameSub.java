package snake;

import java.util.ArrayList;
import java.util.Random;

class Game {
	
	Position apple;
	Position pos;
	static Random rand = new Random();
	public static int x = 10;
    public static int y = 20;
    public static int a = 15;
    public static int b = 15;
    public int r;
    public int c;
    public String[][] board;
    public String symbolBlank;
    public String symbolApple;
    public String symbolSnake;
    public String symbolSnakeBod;
    public static int score = 0;
    Position past = new Position(x,y);
    public static int count = -1; 
    ArrayList<Position> pastMoves = new ArrayList<Position>();
    public static int n = -1; 
    
    
    public Game(){
        r = 20;
        c = 40;
        board = new String[r][c];
        symbolBlank = " ";
        symbolApple = "A";
        symbolSnake = "S";
        symbolSnakeBod = "s";
        pos = new Position(x,y);
        apple = new Position(0,0);
        apple.ApplePos();
        
    }
    
    
    public String printBoard(){
        
        //Puts line at top
        String result = " ";
        for (int i = 0; i < c; i++){
            result += "_";
        }
        result += "\n"; 
        
        //Fills the inside and puts pipes on the sides
        for (int i = 0; i < r; i ++){
            result += "|";
            for (int j = 0; j < c; j++){
                result += board[i][j];
            }
            result += "|\n";
        }
        
        //Puts line on bottom
        result += " ";
        for (int i = 0; i < c; i++){
            result += "-";
        }
        return result;
    }
    //resets the board 
    public  void resetBoard(){
        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                board[i][j] = symbolBlank; 
            }
        }
    }
    
    //fills the board with the new x and y position 
    public void fillBoard(){
        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                board[i][j] = symbolBlank;
            }
        }
        
        board[pos.x][pos.y] = symbolSnake;
        board[apple.x][apple.y] = symbolApple;

        if (count>0) {
        	for (int i = 0 ; i < score; i++) {
        		board[pastMoves.get(count-(i+1)).x][pastMoves.get(count-(i+1)).y] = symbolSnakeBod;
        		if (pos.x == pastMoves.get(count-(i+1)).x && pos.y == pastMoves.get(count-(i+1)).y) {
        			System.out.println("You crashed! Your final score was: " + score);
        			System.exit(0);
        		}
        	}
        }
	
    }

    //clears the terminal
//    public void clearScreen() {  
//        System.out.print("\033[H\033[2J");  
//        System.out.flush();  
//    }  

    public void play() {
    	Move move = new Move();
    	 
    	 //use a counting variable to print out the last index, then the second to last and so on 
    	
    	while (pos.x >= 0 && pos.x < 20 && pos.y >= 0 && pos.y < 40){
//           game.clearScreen();
    		 fillBoard();
             System.out.println(printBoard());
             int z = move.MoveSnake();
             pos.Move(z);
             Position temp = new Position(pos.x,pos.y);
         	 pastMoves.add(temp);
             count ++; 
             if (pos.x == apple.x && pos.y == apple.y) {
            	apple.ApplePos();
         		score++;
         		n++;

             }

         }
    	System.out.println("You crashed! Your final score was: " + score);

    }
}
public class GameSub{
    public static void main(String[] args){
    	Game game = new Game();
    	game.play();
    

    }
}