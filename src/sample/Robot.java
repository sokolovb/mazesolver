package sample;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Robot {


    public boolean[][] Map;
    public int sum;
    public int x, y;

    Robot(boolean[][] map, int sum, int y, int x) {
        this.Map = map;
        this.sum = sum;
        this.y = y;
        this.x = x;
    }

    public void Go(Maze maze, Group root, Stage primaryStage) {

        if (maze.cells[y][x].paths.right && !this.Map[y][x+1]) {
            boolean[][] map1 = new boolean[3][4];

            for (int i = 0; i < 3; i++) {
                System.arraycopy(this.Map[i], 0, map1[i], 0, 4);
            }

            map1[y][x+1] = true;
            if (maze.cells[y][x+1].value.equals("f")) {
                RenderMap(map1, root, primaryStage);
                return;
            }

            int sum1 = this.sum + Integer.parseInt(maze.cells[y][x+1].value);
            Robot robot1 = new Robot(map1, sum1, y, x+1);
            robot1.Go(maze, root, primaryStage);
        }
        if (maze.cells[y][x].paths.up && !this.Map[y-1][x]) {
            boolean[][] map1 = new boolean[3][4];

            for (int i = 0; i < 3; i++) {
                System.arraycopy(this.Map[i], 0, map1[i], 0, 4);
            }
            map1[y-1][x] = true;

            if (maze.cells[y-1][x].value.equals("f")) {
                RenderMap(map1, root, primaryStage);
                return;
            }

            int sum1 = this.sum + Integer.parseInt(maze.cells[y-1][x].value);
            Robot robot1 = new Robot(map1, sum1, y-1, x);
            robot1.Go(maze, root, primaryStage);
        }
        if (maze.cells[y][x].paths.left && !this.Map[y][x-1]) {
            boolean[][] map1 = new boolean[3][4];

            for (int i = 0; i < 3; i++) {
                System.arraycopy(this.Map[i], 0, map1[i], 0, 4);
            }

            map1[y][x-1] = true;

            if (maze.cells[y][x-1].value.equals("f")) {
                RenderMap(map1, root, primaryStage);
                return;
            }

            int sum1 = this.sum + Integer.parseInt(maze.cells[y][x-1].value);
            Robot robot1 = new Robot(map1, sum1, y, x-1);
            robot1.Go(maze, root, primaryStage);
        }
        if (maze.cells[y][x].paths.down && !this.Map[y+1][x]) {
            boolean[][] map1 = new boolean[3][4];

            for (int i = 0; i < 3; i++) {
                System.arraycopy(this.Map[i], 0, map1[i], 0, 4);
            }
            map1[y+1][x] = true;

            if (maze.cells[y+1][x].value.equals("f")) {
                RenderMap(map1, root, primaryStage);
                return;
            }

            int sum1 = this.sum + Integer.parseInt(maze.cells[y+1][x].value);
            Robot robot1 = new Robot(map1, sum1, y+1, x);
            robot1.Go(maze, root, primaryStage);
        }
        //TODO: stop condition (dead end or "f" cell)


    }

    private final int RectSize = 100;


    public void RenderMap(boolean[][] map, Group root, Stage primaryStage) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                Rectangle rect1 = new Rectangle(30 + (RectSize+10)*j, 30 + (RectSize+10)*i, RectSize, RectSize);

                if (map[i][j]){
                    rect1.setFill(Color.TOMATO);
                } else {
                    rect1.setFill(Color.VIOLET);
                }

                //root.getChildrenUnmodifiable().addAll(rect1);
                root.getChildren().addAll(rect1);

                primaryStage.show();

                //Thread.sleep(500);
            }
        }
    }
}
