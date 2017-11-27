package sample;

import java.io.BufferedReader;
import java.io.FileReader;

public class Maze {

    static class Cell {
        String value;
        static class Paths {
            boolean right, up, left, down;
        }
        Paths paths;
    }
    Cell[][] cells;

    Maze loadMazeFromFile (String filename) {

        Maze maze = new Maze();

        BufferedReader br = null;
        FileReader fr = null;

        try {
            fr = new FileReader(filename);
            br = new BufferedReader(fr);

            String sCurrentLine;
            sCurrentLine = br.readLine();

            int rows = Integer.parseInt(sCurrentLine.split(" ")[0]);
            int cols = Integer.parseInt(sCurrentLine.split(" ")[1]);
            maze.cells = new Cell[rows][];
            for (int i = 0; i < rows; i++) {
                maze.cells[i] = new Cell[cols];
                for (int j = 0; j < cols; j++) {
                    maze.cells[i][j] = new Cell();
                    maze.cells[i][j].paths = new Cell.Paths();
                }
            }

            while ((sCurrentLine = br.readLine()) != null) {
                String[] line = sCurrentLine.split(" ");
                if (line.length != 7) {
                    System.out.println("loadMazeFromFile(String filename) error: invalid string " + sCurrentLine +
                            " format is: <row col val r u l d>");
                    System.exit(-1);
                }
                int row = Integer.parseInt(line[0]);
                int col = Integer.parseInt(line[1]);

                maze.cells[row][col].value = line[2];
                maze.cells[row][col].paths.right = (Integer.parseInt(line[3]) == 1);
                maze.cells[row][col].paths.up = (Integer.parseInt(line[4]) == 1);
                maze.cells[row][col].paths.left = (Integer.parseInt(line[5]) == 1);
                maze.cells[row][col].paths.down = (Integer.parseInt(line[6]) == 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return maze;
    }
}
