package strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import discs.Disc;
import discs.DiscColor;
import model.MoveDirection;
import model.MoveRules;
import model.ReadOnlyReversiModel;
import player.Player;

public abstract class AbstractStrategy implements IStrategy {

  private final ReadOnlyReversiModel reversiModel;
  private final Player player;
  public AbstractStrategy(ReadOnlyReversiModel reversiModel, Player player) {
    this.reversiModel = reversiModel;
    this.player = player;
  }

  protected List<List<List<Integer>>> getPositionsForBFS() {
    List<List<List<Integer>>> res = new ArrayList<>();
    for (int i = 0; i < this.reversiModel.getDimensions(); i++) {
      for (int j = 0; j < this.reversiModel.getDimensions(); j++) {
        try {
          DiscColor currentDiscColor = this.reversiModel.getDiscAt(i, j).getColor();
          DiscColor targetColor = this.getOppositeColor(this.player.getPlayerColor());
          // we're looking for the opposite color of the currentPlayer because we can only
          // capture cells that are of the opposite players color
          if (currentDiscColor != DiscColor.FACEDOWN && currentDiscColor == targetColor) {
            List<List<Integer>> allAdjacentEmpty = getAllAdjacent(i,j);
            res.add(allAdjacentEmpty);
          }
        } catch (IllegalArgumentException iae) {
          // we encountered a null cell do nothing
        }
      }
    }
    return res;
  }

  private DiscColor getOppositeColor(DiscColor discColor) {
    switch (discColor) {
      case FACEDOWN:
        return DiscColor.FACEDOWN;
      case WHITE:
        return DiscColor.BLACK;
      case BLACK:
        return DiscColor.WHITE;
    }
    return null;
  }

  private List<List<Integer>> getAllAdjacent(int i, int j)  {
    List<List<Integer>> res = new ArrayList<>();
    for (MoveDirection moveDir : MoveDirection.values()) {
      List<Integer> currCoordinate = MoveRules.applyShiftBasedOnDirection(i,j,moveDir);
      int x = currCoordinate.get(0);
      int y = currCoordinate.get(1);
      try {
        Disc currDisc = this.reversiModel.getDiscAt(x,y);
        if (currDisc.getColor() == DiscColor.FACEDOWN) {
          res.add(new ArrayList<>(Arrays.asList(x,y)));
        }
      } catch (IllegalArgumentException iae) {

      }
    }
    return res;
  }

}
