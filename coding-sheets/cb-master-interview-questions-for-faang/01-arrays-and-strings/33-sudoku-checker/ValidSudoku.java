import java.util.*;
import java.io.*;


public class ValidSudoku {

  public static void main(String args[]) {

    Scanner scn=new Scanner(System.in);
    char[][] matrix=new char[9][9];

    for(int i=0;i<9;i++)
    {
      for(int j=0;j<9;j++)
      {
        matrix[i][j]=scn.next().charAt(0);
      }
    }

    System.out.print(isValidSudoku(matrix));
  }

  public static boolean isValidSudoku(char[][] board) {
    //Complete the function
    // init data
    HashMap<Integer, Integer> [] rows = new HashMap[9];
    HashMap<Integer, Integer> [] columns = new HashMap[9];
    HashMap<Integer, Integer> [] boxes = new HashMap[9];
    
    for (int i = 0; i < 9; i++) {
      rows[i] = new HashMap<Integer, Integer>();
      columns[i] = new HashMap<Integer, Integer>();
      boxes[i] = new HashMap<Integer, Integer>();
    }
    // validate a board
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        char num = board[i][j];
        if (num != '.') {
          int n = (int)num;
          int box_index = (i / 3 ) * 3 + j / 3;

          // keep the current cell value
          rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
          columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);

          boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);

          // check if this value has been already seen before
          if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1)
            return false;
        }
      }
    }
    return true;

  }
}