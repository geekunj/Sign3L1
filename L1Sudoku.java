class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if(!isValidRow(board, i)){
                return false;
            }
        }
        for (int j = 0; j < 9; j++){
            if(!isValidColumn(board, j)){
                return false;
            }
        }
        for (int i = 0; i < 9; i+=3){
            for (int j = 0; j < 9; j+=3){
                if(!isValidSubGrid(board, i, j)){
                    return false;
                }
            }
            
        }
        return true;

    }


    private static boolean isValidRow(char[][] board, int row){
        boolean[] visited = new boolean[9];
        for (int j = 0; j < 9; j++) {
            char ch = board[row][j];
            if(ch != '.'){
                int value = ch - '1';
                if(visited[value]){
                    return false;
                }
                visited[value] = true;
            }
        }
        return true;
    }

    private static boolean isValidColumn(char[][] board, int col){
        boolean[] visited = new boolean[9];
        for (int j = 0; j < 9; j++) {
            char ch = board[j][col];
            if(ch != '.'){
                int value = ch - '1';
                if(visited[value]){
                    return false;
                }
                visited[value] = true;
            }
        }
        return true;
    }

    private static boolean isValidSubGrid(char[][] board, int row, int col){
        boolean[] visited = new boolean[9];
        for (int i = row; i < row + 3; i++) {
            for(int j = col; j < col + 3; j++){
                char ch = board[i][j];
                if(ch != '.'){
                    int value = ch - '1';
                    if(visited[value]){
                        return false;
                    }
                visited[value] = true;
                }
            }
        }
        return true;
    }

}
