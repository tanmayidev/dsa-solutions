import java.util.*;

public class Sudoku {
  public static void main(String[] args) {
  Scanner scn = new Scanner(System.in);
  int n = scn.nextInt();
  int[][] board = new int[n][n];
  for (int i = 0; i < board.length; i++) {
  for (int j = 0; j < board[0].length; j++) {
  board[i][j] = scn.nextInt();
  }
  // System.out.println();
  }
  Sudoku(board, 0, 0);
  display(board);
  }
  public static boolean Sudoku(int[][] board, int row, int col) {
  if (col == board[0].length) {
  row = row + 1;
  col = 0;
  }
  if (row == board.length) {
  // display(board);
  return true;
  }
  if (board[row][col] != 0) {
  return Sudoku(board, row, col + 1);
  }
  for (int i = 1; i <= 9; i++) {
  if (isItSafe(board, row, col, i)) {
  board[row][col] = i;
  boolean res = Sudoku(board, row, col + 1);
  if (res)
  return true;
  board[row][col] = 0;
  }
  
  }
  return false;
  }
  public static boolean isItSafe(int[][] board, int row, int col, int
  val) {
  return isItSafeRow(board, row, val) && isItSafeCol(board, col,
  val) && isItSafeCell(board, row, col, val);
  }
  public static boolean isItSafeRow(int[][] board, int row, int val)
  {
  for (int col = 0; col < board[0].length; col++) {
  if (board[row][col] == val) {
  return false;
  }
  }
  return true;
  }
  public static boolean isItSafeCol(int[][] board, int col, int val)
  {
  for (int row = 0; row < board.length; row++) {
  if (board[row][col] == val) {
  return false;
  }
  }
  return true;
  }
  public static boolean isItSafeCell(int[][] board, int row, int col,
  int val) {
  int rs = row - row % 3;
  int cs = col - col % 3;
  for (int r = rs; r < rs + 3; r++) {
  for (int c = cs; c < cs + 3; c++) {
  if (board[r][c] == val) {
  return false;
  }
  }
  }
  return true;
  }
  public static void display(int[][] board) {
  for (int i = 0; i < board.length; i++) {
  
  for (int j = 0; j < board[0].length; j++) {
  System.out.print(board[i][j] + " ");
  }
  System.out.println();
  }
  }
  }