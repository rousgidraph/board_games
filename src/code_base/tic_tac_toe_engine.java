package code_base;

public class tic_tac_toe_engine {

    public static void print_toe(char [][] board){
        for(int y = 0 ;  y < board.length; y ++){
            if((y != 0) &&(y !=board.length)){
                System.out.println("__________");
            }
            for (int x = 0; x <board[0].length; x++){
                if((x != 0) && (x !=board[0].length )){
                    System.out.print(" | ");
                }
                if(x == board[0].length-1){
                    System.out.println(board[y][x]);
                }else{
                    System.out.print(board[y][x]);
                }
            }
        }
    }

    public static int  win_check(char [][] board){
        //upwards
            for(int x =0 ; x < board[0].length ; x ++){
                char [] row = new char[3];
                for (int y = 0 ; y < board.length;y++){
                    row[y] = board[y][x];
                }
                if(row[0] == row[1] && row[1] == row[2]){
                    //return true
                }
            }
        //sideways
            for(int y = 0 ; y < board.length ; y++){
                char [] row =new char[3];
                for (int x = 0; x < board[0].length; x++){
                    row[x] = board[y][x];
                }
                if(row[0] == row[1] && row[1] == row[2]){
                    //return true
                }
            }
        //diagonal right to left
        char [] diags_1 = new char[3];
            for(int diag_x = board[0].length-1; diag_x >= 0; diag_x--){
                diags_1[(board[0].length-1) - diag_x] = board[diag_x][diag_x];
            }
            if((diags_1[0] == diags_1[1])&&(diags_1[1] == diags_1[2])){
                //return true
            }
        //diagonal left to right
        char [] diags_2 = new char[3];
        for(int diag_y = 0 ; diag_y < board.length ; diag_y++){

        }

        return 0;
    }

    public void playermove(char [][] board, char candidate, int [] pos){
        if((candidate != 'X') &&( candidate != 'O')){
            System.out.println("invalid character");
            return;
        }
        board[pos[0]][pos[1]] = candidate;
        return;
    }

    public static void main(String[] args) {
        char [][] board  = new char [][] {
                {'X','O','-'},
                {'-','-','X'},
                {'O','X','-'}};
        print_toe(board);
    }
}
