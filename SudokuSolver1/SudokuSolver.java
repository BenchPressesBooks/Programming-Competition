/**
 * This program is executed in the following way:
 *    java SudokuSolver <input-file>
 * For details of the input-file format, see the Grid.java class.
 *
 */
import java.io.*;
import java.util.*;

public class SudokuSolver {
    public static void main(String[] args) throws Exception {
        // Open the file containing the givens
        File file = new File(args[0]);
        FileReader rd = new FileReader(args[0]);

        // Process each grid in the file
        while (true) {
            Grid grid = Grid.create(rd);
            if (grid == null) {
                // No more grids
                break;
            }

            // Find a solution
            List<Grid> solutions = new ArrayList<Grid>();
            solve(grid, solutions);

            printSolutions(grid, solutions);
        }
    }

    // Recursive routine that implements the bifurcation algorithm
    private static void solve(Grid grid, List<Grid> solutions) {
        // Return if there is already a solution
        if (solutions.size() >= 2) {
            return;
        }

        // Find first empty cell
        int loc = grid.findEmptyCell();

        // If no empty cells are found, a solution is found
        if (loc < 0) {
            solutions.add(grid.clone());
            return;
        }

        // Try each of the 9 digits in this empty cell
        for (int n=1; n<10; n++) {
            if (grid.set(loc, n)) {
                // With this cell set, work on the next cell
                solve(grid, solutions);

                // Clear the cell so that it can be filled with another digit
                grid.clear(loc);
            }
        }
    }

    private static void printSolutions(Grid grid, List<Grid> solutions) {
        // Print the grid with the givens
        System.out.println("Original");
        System.out.println(grid);

        // Print the solution
        if (solutions.size() == 0) {
            System.out.println("Unsolveable");
        } else if (solutions.size() == 1) {
            System.out.println("Solved");
        } else {
            System.out.println("At least two solutions");
        }

        // Print the solution(s)
        for (int i=0; i<solutions.size(); i++) {
            System.out.println(solutions.get(i));
        }
        System.out.println();
        System.out.println();
    }
}
