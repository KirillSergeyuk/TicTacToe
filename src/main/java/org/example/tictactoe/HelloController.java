package org.example.tictactoe;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;

public class HelloController {
    @FXML
    private GridPane grid;
    @FXML
    private Button b1;
    @FXML
    private Button b2;
    @FXML
    private Button b3;
    @FXML
    private Button b4;
    @FXML
    private Button b5;
    @FXML
    private Button b6;
    @FXML
    private Button b7;
    @FXML
    private Button b8;
    @FXML
    private Button b9;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    private boolean isGame = true;

    private char[][] gameField = new char[][]{{' ', ' ', ' '},
                                              {' ', ' ', ' '},
                                              {' ', ' ', ' '}};

    private char nowSym = 'x';

    void winner(char symWinner){
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "У нас есть победитель -> \"" + symWinner + "\"", ButtonType.OK);
        alert.showAndWait();
    }

    @FXML
    void btnClick(ActionEvent event) {
        if(!isGame) return;

        Button btn = (Button)event.getSource();
        int rowIndex = GridPane.getRowIndex(btn) == null ? 0 : GridPane.getRowIndex(btn);
        int columnIndex = GridPane.getColumnIndex(btn) == null ? 0 : GridPane.getColumnIndex(btn);

        if(Character.isWhitespace(gameField[rowIndex][columnIndex])){
            btn.setText(String.valueOf(nowSym));
        }   else return;
        gameField[rowIndex][columnIndex] = nowSym;

        if(gameField[0][0] == gameField[0][1] && gameField[0][2] == gameField[0][0] && !Character.isWhitespace(gameField[0][0])){
            winner(nowSym);
            isGame = false;
        }
        if(gameField[1][0] == gameField[1][1] && gameField[1][2] == gameField[1][0] && !Character.isWhitespace(gameField[1][0])){
            winner(nowSym);
            isGame = false;
        }
        if(gameField[2][0] == gameField[2][1] && gameField[2][2] == gameField[2][0] && !Character.isWhitespace(gameField[2][0])){
            winner(nowSym);
            isGame = false;
        }
        if(gameField[0][0] == gameField[1][0] && gameField[2][0] == gameField[0][0] && !Character.isWhitespace(gameField[0][0])){
            winner(nowSym);
            isGame = false;
        }
        if(gameField[0][1] == gameField[1][1] && gameField[2][1] == gameField[0][1] && !Character.isWhitespace(gameField[0][1])){
            winner(nowSym);
            isGame = false;
        }
        if(gameField[0][2] == gameField[1][2] && gameField[2][2] == gameField[0][2] && !Character.isWhitespace(gameField[0][2])){
            winner(nowSym);
            isGame = false;
        }
        if(gameField[0][0] == gameField[1][1] && gameField[2][2] == gameField[0][0] && !Character.isWhitespace(gameField[0][0])){
            winner(nowSym);
            isGame = false;
        }
        if(gameField[0][2] == gameField[1][1] && gameField[2][0] == gameField[0][2] && !Character.isWhitespace(gameField[0][2])){
            winner(nowSym);
            isGame = false;
        }
        nowSym = nowSym == 'x' ? 'o' : 'x';
    }

    @FXML
    void reset(){
        ObservableList<Node> btns = grid.getChildren();
        for (Node node : btns) {
            Button btn = (Button) node;
            btn.setText(" ");
        }
        gameField = new char[][]{{' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}};
        nowSym = 'x';
        isGame = true;
    }



    @FXML
    void initialize() {

    }

}

