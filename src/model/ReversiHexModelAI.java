package model;

import java.util.HashMap;
import java.util.Map;

import discs.Disc;
import discs.DiscColor;
import discs.DiscType;
import player.Player;
import player.PlayerTurn;
import strategy.IStrategy;

public class ReversiHexModelAI extends ReversiHexModel implements ReversiModel {

  private final IStrategy iStrategy;
  private final Player player1;
  private final Player player2;

  public ReversiHexModelAI(IStrategy iStrategy) {
    super();
    this.iStrategy = iStrategy;
    this.player1 = new Player(PlayerTurn.PLAYER1);
    this.player2 = new Player(PlayerTurn.PLAYER2, iStrategy);
  }

  @Override
  public void makeMove(int x, int y) {
    this.moveNonAi(x,y);
    this.moveAi();
  }

  private void moveNonAi(int x, int y) {
    super.makeMove(x,y);
    this.pass();
  }

  private void moveAi() {
    Disc[][] currentBoard = getCurrentBoardState();
    this.pass();
  }
  @Override
  public void pass() {
    if (super.pt == this.player1.getPlayerTurn()) {
      super.pt = this.player2.getPlayerTurn();
    } else {
      super.pt = this.player1.getPlayerTurn();
    }
  }
}
