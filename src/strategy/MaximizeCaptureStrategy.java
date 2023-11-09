package strategy;

import java.util.List;

import model.BoardUtils;
import model.ReadOnlyReversiModel;
import model.ReversiModel;
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
    List<List<List<Integer>>> validPositions3d = getPositionsForBFS();
    for (int x = 0; x < validPositions3d.size(); x++) {
      // all positions that are eligible for bfs
      List<List<Integer>> validPositions2d = validPositions3d.get(x);
      runBfs(validPositions2d);
    }
    return null;
  }

  private void runBfs(List<List<Integer>> validPositions2d) {
    for (int y = 0; y < validPositions2d.size(); y++) {
        List<Integer> validPosition = validPositions2d.get(y);
        int currX = validPosition.get(0);
        int currY = validPosition.get(1);
        List<List<List<Integer>>> capturedPieces = BoardUtils.bfs(this.reversiModel, currX, currY);
    }
  }
}