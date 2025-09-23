import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        int leng = line.length;
        List<long[]> points = new ArrayList<>();
        long minX = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE;
        long maxY = Long.MIN_VALUE;

        for (int i = 0; i < leng; i++) {
            for (int j = i + 1; j < leng; j++) {
                long[] point = getIntersection(line[i], line[j]);
                if (point != null) {
                    points.add(point);
                    minX = Math.min(minX, point[0]);
                    maxX = Math.max(maxX, point[0]);
                    minY = Math.min(minY, point[1]);
                    maxY = Math.max(maxY, point[1]);
                }
            }
        }

        int w = (int)(maxX - minX + 1);
        int h = (int)(maxY - minY + 1);

        char[][] board = new char[h][w];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        for (long[] p : points) {
            int x = (int)(p[0] - minX);
            int y = (int)(maxY - p[1]);
            board[y][x] = '*';
        }

        String[] rslt = new String[h];
        for (int i = 0; i < h; i++) {
            rslt[i] = new String(board[i]);
        }
        return rslt;
    }
    
    private long[] getIntersection(int[] line1, int[] line2) {
        long x1 = line1[0];
        long y1 = line1[1];
        long z1 = line1[2];
        long x2 = line2[0];
        long y2 = line2[1];
        long z2 = line2[2];

        long dt = x1 * y2 - x2 * y1;
        if (dt == 0) {
            return null;
        }

        long xNum = y1 * z2 - y2 * z1;
        long yNum = z1 * x2 - z2 * x1;

        if (xNum % dt != 0 || yNum % dt != 0) {
            return null;
        }

        long x = xNum / dt;
        long y = yNum / dt;

        return new long[]{x, y};
    }
}
