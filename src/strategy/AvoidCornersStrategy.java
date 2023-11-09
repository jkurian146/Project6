package strategy;

import java.util.List;
import model.ReadOnlyReversiModel;
import player.Player;

public class AvoidCornersStrategy extends AbstractStrategy{

  public AvoidCornersStrategy(ReadOnlyReversiModel reversiModel, Player player) {
    super(reversiModel,player);
  }
  @Override
  public boolean equals() {
    return false;
  }

  @Override
  public List<Integer> executeStrategy() {
    return null;
  }
}
