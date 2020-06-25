package JetBrains;

import java.util.Scanner;

public class TicTacToe {
    public static void printGrid(char[] a){
        System.out.println("Grid layout / co-ordinates");
        System.out.println("(1, 3) (2, 3) (3, 3)");
        System.out.println("(1, 2) (2, 2) (3, 2)");
        System.out.println("(1, 1) (2, 1) (3, 1)");
        System.out.println("---------");
        System.out.println("|"+" "+a[0]+" "+a[1]+" "+a[2]+" "+"|");
        System.out.println("|"+" "+a[3]+" "+a[4]+" "+a[5]+" "+"|");
        System.out.println("|"+" "+a[6]+" "+a[7]+" "+a[8]+" "+"|");        
        System.out.println("---------");
        
    }
       
    // Decides if game has ended or not
    public static boolean gameOver(boolean gameFinish, char[] a){
        for(int i = 0 ; i < 9 ; i++){
            if(a[i] == '_'){
                gameFinish=false;
                break;
            }
            else {
                gameFinish=true;
            }
        }
        return gameFinish;
    }
    
    // X wins the game
    public static boolean winner1(boolean xWins, char[] a){
        //X wins horizontally
        if(a[0]=='X' && a[1]=='X' && a[2]=='X' ){
            xWins = true;
        }
        else if(a[3]=='X' && a[4]=='X' && a[5]=='X' ){
            xWins = true;
        }
        else if(a[6]=='X' && a[7]=='X' && a[8]=='X' ){
            xWins = true;
        }
        //X wins vertically
        
        else if(a[0]=='X' && a[3]=='X' && a[6]=='X' ){
            xWins = true;
        }
        else if(a[1]=='X' && a[4]=='X' && a[7]=='X' ){
            xWins = true;
        }
        else if(a[2]=='X' && a[5]=='X' && a[8]=='X' ){
            xWins = true;
        }
        //X wins diagonally
        
        else if(a[0]=='X' && a[4]=='X' && a[8]=='X' ){
            xWins = true;
        }
        else if(a[6]=='X' && a[4]=='X' && a[2]=='X' ){
            xWins = true;
        }
        return xWins;
    }
    
    // O wins the game
    public static boolean winner2(boolean oWins, char[] a){
        
         //O wins horizontally
        if(a[0]=='O' && a[1]=='O' && a[2]=='O' ){
            oWins = true;
        }
        else if(a[3]=='O' && a[4]=='O' && a[5]=='O' ){
            oWins = true;
        }
        else if(a[6]=='O' && a[7]=='O' && a[8]=='O' ){
            oWins = true;
        }
        //O wins vertically
        
        else if(a[0]=='O' && a[3]=='O' && a[6]=='O' ){
            oWins = true;
        }
        else if(a[1]=='O' && a[4]=='O' && a[7]=='O' ){           
            oWins = true;
        }
        else if(a[2]=='O' && a[5]=='O' && a[8]=='O' ){
            oWins=true;
        }
        //O wins diagonally
        
        else if(a[0]=='O' && a[4]=='O' && a[8]=='O' ){
            oWins = true;
        }
        else if(a[6]=='O' && a[4]=='O' && a[2]=='O' ){
            oWins = true;
        }
        return oWins;
    }
    
    //modify 1D array
    public static char[] modify1D(char[][] b,char[] a){
        
        //bottom row left to right
        a[6] = b[0][0];
        a[7] = b[0][1];
        a[8] = b[0][2];
        
        //middle row left to right
        a[3] = b[1][0];
        a[4] = b[1][1];
        a[5] = b[1][2];
        
        //top row left to right
        a[0] = b[2][0];
        a[1] = b[2][1];
        a[2] = b[2][2];
        
        return a;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //System.out.print("Enter cells: ");
        String s = "_________";
        //System.out.println();
        char arr[]=s.toCharArray();
        
        printGrid(arr);
        
        char arr2D[][] = new char[3][3];
        
        //bottom row left to right
        arr2D[0][0]= arr[6];
        arr2D[0][1]= arr[7];
        arr2D[0][2]= arr[8];
        
        //middle row left to right
        arr2D[1][0]= arr[3];
        arr2D[1][1]= arr[4];
        arr2D[1][2]= arr[5];
        
        //top row left to right
        arr2D[2][0]= arr[0];
        arr2D[2][1]= arr[1];
        arr2D[2][2]= arr[2];
                
        // booleans and function calls
        boolean gameFinish = false;
        boolean validInput = false;
        boolean Xwins = false;
        boolean Owins = false;
        int var = 1;
        
        while(validInput==false || gameFinish==false){
            
            char player = 'X';
            if(var % 2 == 1){
                player = 'X';
            }
            else player = 'O';
            System.out.print("Enter the coordinates: ");           
            String a = sc.next();
            String b = sc.next();
            System.out.println();
            int x;
            int y;
            if(Character.isDigit(a.charAt(0)) && Character.isDigit(b.charAt(0)) ){
                x=Integer.parseInt(String.valueOf(a)) -1;
                y=Integer.parseInt(String.valueOf(b)) -1;
                
                if( x<0 || x>2 || y<0 || y>2 ){
                    System.out.println("Coordinates should be from 1 to 3!");
                    validInput = false;
                }
                else{
            
                    if(arr2D[y][x]=='_'){
                        arr2D[y][x]=player;
                        arr=modify1D(arr2D,arr);
                        printGrid(arr);                        
                        Xwins=winner1(Xwins, arr);
                        if(Xwins) break;
                        Owins=winner2(Owins,arr);
                        if(Owins) break;
                        var++;
                        validInput=true;
                        gameFinish=gameOver(gameFinish , arr);
                    }
                    else if(arr2D[y][x]=='X' || arr2D[y][x]=='O'){
                        System.out.println("This cell is occupied! Choose another one!");
                        validInput=false;
                    }
                }    
            }
            else{
                System.out.println("You should enter numbers!");
                validInput=false;
            }         
        }
        
        if(gameFinish || Xwins || Owins){
            if(Xwins && !Owins){
                System.out.println("X wins");
            }
            else if(Owins && !Xwins){
                System.out.println("O wins");
            }
            else {
                System.out.println("Draw");
            }
        }
        
}
}
