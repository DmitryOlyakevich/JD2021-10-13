package by.it.ena.jd01_15;

import java.util.Random;

public class TaskA {
    public static final int MIN = -15;
    public static final int MAX = 15;

    public static void main(String[] args) {
        TaskA taskA = new TaskA();
        PathFinder pathFinderService = new PathFinderImpl();
        int[][] array = new int[6][4];
        taskA.fillArray(array, MIN, MAX);
        String filename = pathFinderService.getStringPath(TaskA.class, "matrix.txt");
        RepoMatrix repoMatrix = new RepoMatrixImpl(filename);
        repoMatrix.save(array);
        int[][] arrayAfterLoad = repoMatrix.load();
        taskA.printArray(arrayAfterLoad);
    }

    private void fillArray(int[][] array, int min, int max) {
        Random random = new Random();
        for (int[] row : array) {
            for (int i = 0; i < row.length; i++) {
                row[i] = min + random.nextInt(max - min + 1);
            }
        }
    }

    private void printArray(int[][] array) {
        for (int[] row : array) {
            for (int element : row) {
                System.out.printf("%3d ", element);
            }
            System.out.println();
        }
    }
}
