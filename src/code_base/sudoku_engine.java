package code_base;

public class sudoku_engine {
    public sudoku_engine(int [][] board){

    }

    public static boolean valid(int [][] board,int [] position, int number){
        //y check : up and down
        for(int y = 0;y < board.length;y++ ){
            int current = board[y][position[1]];
            if (y != position[0]){
                if (current == number){
                    return false;
                }
            }
        }
        //x check : across
        for(int x = 0; x <board[0].length; x++){
            int curr = board[position[0]][x];
            if (x != position[1]){
                if(curr == number){
                    return false;
                }
            }
        }
        //sub square check
        int x_box = position[1] / 3;
        int y_box = position[0] / 3;
        for (int y_check = y_box * 3;y_check <= (y_box * 3)+2; y_check++){
            for (int x_check = x_box*3; x_check <=(x_box*3)+2; x_check++){
                int kurent = board[y_check][x_check];
                if ((y_check == position[0]) && (x_check == position[1])){
                    continue;
                }
                if (kurent == number){
                    return false;
                }
            }
        }
    return true;
    }
    public static int[] find_empty(int [][] board){
        int [] pos ;
        for(int y = 0 ;y < board.length; y++){
            for (int x = 0 ; x < board[0].length;x++){
                int current = board[y][x];
                if(current == 0){
                    pos = new int[] {y,x};
                    return pos;
                }
            }
        }
        return  new int[] {-1,-1};
    }
    public static boolean solve(int[][] board){
        int [] next_position = find_empty(board);
        if(next_position[0] == -1){
            return true;
        }

        for(int i = 1;i <= 9; i++){
            if(valid(board,next_position,i)){
                board[next_position[0]][next_position[1]] = i;

                if (solve(board)){
                    return true;
                }
                board[next_position[0]][next_position[1]] = 0;
            }
        }

        return false;
    }
    public static void print_board(int [][] board){
        for (int y = 0;y < board.length; y++){
            if((y %3 ==0)&& (y != 0)){
                System.out.println("----------------------");
            }
            for (int x = 0; x < board[0].length; x++){
                if (x == board[0].length-1){
                    System.out.println(board[y][x]+" ");
                }else{
                    System.out.print(board[y][x]+" ");
                }
                if((x==2)||(x==5)){
                    System.out.print("| ");
                }

            }
        }
    }
    public static void main(String[] args) {
        int [][] board = new int[][]{
                {0, 0, 0, 2, 6, 0, 7, 0, 1},
                {6, 8, 0, 0, 7, 0, 0, 9, 0},
                {1, 9, 0, 0, 0, 4, 5, 0, 0},
                {8, 2, 0, 1, 0, 0, 0, 4, 0},
                {0, 0, 4, 6, 0, 2, 9, 0, 0},
                {0, 5, 0, 0, 0, 3, 0, 2, 8},
                {0, 0, 9, 3, 0, 0, 0, 7, 4},
                {0, 4, 0, 0, 5, 0, 0, 3, 6},
                {7, 0, 3, 0, 1, 8, 0, 0, 0}};
        print_board(board);
        solve(board);
        System.out.println("***********solution**************");
        print_board(board);

    }
}
