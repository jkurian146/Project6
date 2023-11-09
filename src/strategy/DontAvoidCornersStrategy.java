package strategy;

import java.util.List;
import model.ReadOnlyReversiModel;
import player.Player;

public class DontAvoidCornersStrategy extends AbstractStrategy {

  public DontAvoidCornersStrategy(ReadOnlyReversiModel reversiModel, Player player) {
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
    return null;
  }


}