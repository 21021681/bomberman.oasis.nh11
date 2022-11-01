package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.GameButton;
import model.GameSubScene;

import java.util.ArrayList;
import java.util.List;

public class ViewManager {
    private static final int HEIGHT = 600;
    private static final int WIDTH = 800;
    private final AnchorPane mainPane;
    private final Scene mainScene;
    private final Stage mainStage;

    private final static int MENU_BUTTON_START_X = 150;
    private final static int MENU_BUTTON_START_Y = 300;

    private GameSubScene startSubscene;
    private GameSubScene helpSubscene;
    private GameSubScene creditsSubscene;

    private GameSubScene sceneToHide;

    List<GameButton> menuButtons;

    public ViewManager() {
        menuButtons = new ArrayList<GameButton>();
        mainPane = new AnchorPane();
        mainScene = new Scene(mainPane, WIDTH, HEIGHT);
        mainStage = new Stage();
        mainStage.setScene(mainScene);
        createButtons();
        createBackground();
        createLogo();
        createSubScenes();
    }

    public Stage getMainStage() {
        return mainStage;
    }

    private void addMenuButton(GameButton button) {
        button.setLayoutX(MENU_BUTTON_START_X);
        button.setLayoutY(MENU_BUTTON_START_Y + menuButtons.size() * 75);
        menuButtons.add(button);
        mainPane.getChildren().add(button);
    }

    private void createButtons() {
        createStartButton();
        createHelpButton();
        createExitButton();
    }

    private void createStartButton() {
        final GameButton startButton = new GameButton("PLAY");
        addMenuButton(startButton);

        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //showSubScene(startSubscene);
                GameViewManager gameManager = new GameViewManager();
                gameManager.createNewGame(mainStage);
            }
        });
    }

    private void createHelpButton() {
        GameButton helpButton = new GameButton("HELP");
        addMenuButton(helpButton);

        helpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                showSubScene(helpSubscene);
            }
        });
    }

    private void createExitButton() {
        GameButton exitButton = new GameButton("EXIT");
        addMenuButton(exitButton);

        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                mainStage.close();
            }
        });
    }

    private void createBackground() {
        Image image = new Image("/view/res/green.png",0, 0, false, true);
        BackgroundImage bg = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                        BackgroundPosition.DEFAULT, new BackgroundSize(WIDTH, HEIGHT, false, false, false, false));
        mainPane.setBackground(new Background(bg));
    }

    private void createLogo() {
        Image logoImage = new Image("/view/res/logo.png", 100, 100, false, false);
        final ImageView logo = new ImageView(logoImage);
        logo.setLayoutX(325);
        logo.setLayoutY(150);
        logo.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                logo.setEffect(new DropShadow(100, Color.YELLOW));
            }
        });
        logo.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                logo.setEffect(null);
            }
        });
        mainPane.getChildren().add(logo);
    }

    private void createSubScenes() {
        startSubscene = new GameSubScene();
        mainPane.getChildren().add(startSubscene);
        helpSubscene = new GameSubScene();
        mainPane.getChildren().add(helpSubscene);
        creditsSubscene = new GameSubScene();
        mainPane.getChildren().add(creditsSubscene);
    }

    private void showSubScene(GameSubScene subScene) {
        if (sceneToHide != null) {
            sceneToHide.moveSubScene();
        }
        subScene.moveSubScene();
        sceneToHide = subScene;
    }
}
