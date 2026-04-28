import java.util.ArrayDeque;
import java.util.Queue;

public class RottingOranges {
  public static int rottingOrange(int[][] grid) {
    if (grid == null || grid.length == 0)
      return 0;

    Queue<int[]> q = new ArrayDeque<>();
    int fresh = 0;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == 2)
          q.offer(new int[] { i, j });
        else if (grid[i][j] == 1)
          fresh++;
      }
    }

    if (fresh == 0)
      return 0;

    int minutes = 0;
    int[][] directions = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    // if says about diagonal just add it in the directions i.e: {1,1},{1,-1}

    while (!q.isEmpty() && fresh > 0) {
      minutes++;
      int size = q.size();

      for (int i = 0; i < size; i++) {
        int curr[] = q.poll();

        for (int d[] : directions) {
          int posX = curr[0] + d[0];
          int posY = curr[1] + d[1];

          if (posX >= 0 && posX < grid.length && posY >= 0 && posY < grid[0].length && grid[posX][posY] == 1) {
            grid[posX][posY] = 2;
            fresh--;

            q.offer(new int[] { posX, posY });
          }
        }
      }
    }

    return fresh == 0 ? minutes : -1;
  }

  public static void main(String[] args) {
    int[][] grid = new int[][] {
        { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 }
    };

    System.out.println(rottingOrange(grid));
  }
}
