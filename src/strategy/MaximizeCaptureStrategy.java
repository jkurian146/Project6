package strategy;

import java.util.List;
import model.ReadOnlyReversiModel;
import player.Player;

public class MaximizeCaptureStrategy extends AbstractStrategy {

  public MaximizeCaptureStrategy(ReadOnlyReversiModel reversiModel, Player player) {
    super(reversiModel,player);
  }
  @Override
  public boolean equals() {
    return false;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public List<Integer> executeStrategy() {
    List<List<List<Integer>>> validPositions = getPositionsForBFS();
    for (int i = 0; i < validPositions.size(); i++) {
      List<List<Integer>> validPositions2d = validPositions.get(i);
    }
    return null;
  }


}