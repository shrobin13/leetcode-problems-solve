class NumberOfIslands {

  public static void wipeIsland(char[][] grid, int i, int j) {
    if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0')
      return;

    grid[i][j] = '0';

    wipeIsland(grid, i + 1, j);
    wipeIsland(grid, i - 1, j);
    wipeIsland(grid, i, j - 1);
    wipeIsland(grid, i, j + 1);
  }

  public static int countIslands(char[][] grid) {
    int islands = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1') {
          islands++;
          wipeIsland(grid, i, j);
        }
      }
    }

    return islands;
  }

  public static void main(String[] args) {
    char[][] grid = new char[][] {
        { '1', '1', '1', '1', '0' },
        { '1', '1', '0', '1', '0' },
        { '1', '1', '0', '0', '0' },
        { '0', '0', '0', '0', '0' },
    };

    System.out.println(countIslands(grid));
  }
}
