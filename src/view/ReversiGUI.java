package view;

import javax.swing.*;
import java.awt.*;
import discs.Disc;
import discs.DiscColor;
import model.ReadOnlyReversiModel;
import model.ReversiHexModel;
import model.ReversiModel;

// make size constraints
// make them clickable
// fill in stub method for click position
// make test class

public class ReversiGUI extends JFrame implements ReversiView {
  private final ReadOnlyReversiModel model;
  private final HexagonButton[][] boardButtons;

  public ReversiGUI(ReadOnlyReversiModel model) {
    this.model = model;
    getContentPane().setBackground(new Color(100, 100, 100));
    setTitle(model.getType() + " Reversi");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);

    int dimensions = model.getDimensions();
    boardButtons = new HexagonButton[dimensions][dimensions];

    setLayout(null);
    int sideLength = 60;
    int xOffset = sideLength;  // Updated xOffset
    int yOffset = (int) (sideLength * Math.sqrt(3) / 2.0);

    int boardWidth = dimensions * xOffset + xOffset / 2;  // Updated boardWidth
    int boardHeight = (int) ((dimensions + 0.5) * yOffset);  // Updated boardHeight

    setSize(boardWidth + 100, boardHeight + 100);

    int xCenterOffset = (getWidth() - boardWidth) / 2;
    int yCenterOffset = (getHeight() - boardHeight) / 2;

    for (int i = 0; i < dimensions; i++) {
      for (int j = 0; j < dimensions; j++) {
        boardButtons[i][j] = new HexagonButton();
        boardButtons[i][j].setOpaque(false);
        int x = j * xOffset;
        int y = i * yOffset;
        if (i % 2 == 1) {
          x += xOffset / 2;
        }
        boardButtons[i][j].setBounds(x + xCenterOffset, y + yCenterOffset, sideLength, sideLength);
        add(boardButtons[i][j]);
      }
    }

    setVisible(true);
    ImageIcon reversiStartingPcs = new ImageIcon("Screenshot 2023-11-4 at 6.22.45 PM.png");
    setIconImage(reversiStartingPcs.getImage());
    render();
  }

  @Override
  public void render() {
    Color customGray = new Color(160, 160, 160);
    Disc[][] board = model.getCurrentBoardState();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == null) {
          boardButtons[i][j].setVisible(false);
        } else {
          boardButtons[i][j].setVisible(true);
          if (board[i][j].getColor() == DiscColor.WHITE) {
            boardButtons[i][j].setBackground(Color.WHITE);
          } else if (board[i][j].getColor() == DiscColor.BLACK) {
            boardButtons[i][j].setBackground(Color.BLACK);
          } else if (board[i][j].getColor() == DiscColor.FACEDOWN) {
            boardButtons[i][j].setBackground(customGray);
          }
        }
      }
    }
  }

  public static void main(String[] args) {
    ReversiModel model = new ReversiHexModel();
    model.startGame(7);
//    model.makeMove(2, 2);
//    model.makeMove(5, 2);
//    model.makeMove(6, 2);
//    model.pass();
//    model.makeMove(5,4);

    ReversiGUI gui = new ReversiGUI(model);
    gui.render();
  }
}