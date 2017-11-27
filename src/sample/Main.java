package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

    private final int RectSize = 100;

    @Override
    public void start(Stage primaryStage) throws Exception{

        Group root = new Group();
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");

        Scene scene = new Scene(root, 1000, 600);
        primaryStage.setScene(scene);

        Maze maze = new Maze();

        maze = maze.loadMazeFromFile("maze1");

        boolean[][] map = new boolean[3][4];
        map[2][0] = true;

        Robot robot = new Robot(map, 0, 2, 0);
        robot.Go(maze, root, primaryStage);


//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 4; j++) {
//                Rectangle rect1 = new Rectangle(30 + (RectSize+10)*j, 30 + (RectSize+10)*i, RectSize, RectSize);
//                rect1.setFill(Color.TOMATO);
//
//                //root.getChildrenUnmodifiable().addAll(rect1);
//                root.getChildren().addAll(rect1);
//
//                primaryStage.show();
//
//                //Thread.sleep(500);
//            }
//        }

//        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
