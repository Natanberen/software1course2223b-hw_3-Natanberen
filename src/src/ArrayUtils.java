import java.util.Arrays;

public class ArrayUtils {

    public static int[] shiftArrayCyclic(int[] array, int move, char direction) {
        if (move <= 0) {
            move = array.length - (Math.abs(move) % array.length);
        } else {
            move = move % array.length;
        }

        if (direction == 'R') {

            reverseArray(array, 0, array.length - 1);
            reverseArray(array, 0, move - 1);
            reverseArray(array, move, array.length - 1);
        } else if (direction == 'L') {

            reverseArray(array, 0, move - 1);
            reverseArray(array, move, array.length - 1);
            reverseArray(array, 0, array.length - 1);
        }

        return array;
    }

    private static void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

    }


    public static int findShortestPath(int[][] m, int i, int j) {
        if (i == j) {
            return 0;
        }
        int n = m.length;
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(dist, -1);
        dist[i] = 0;
        findShortestPathHelper(m, i, visited, dist);
        return dist[j];
    }

    private static void findShortestPathHelper(int[][] matrix, int i, boolean[] visited, int[] dist) {
        visited[i] = true;
        for (int j = 0; j < matrix.length; j++) {
            if (matrix[i][j] == 1 && !visited[j]) {
                if (dist[j] == -1 || dist[j] > dist[i] + 1) {
                    dist[j] = dist[i] + 1;
                    findShortestPathHelper(matrix, j, visited, dist);
                }
            }
        }
        visited[i] = false;
    }




}