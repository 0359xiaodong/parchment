package mobi.parchment.widget.adapterview.snapposition;

import android.view.View;

import java.util.List;

import mobi.parchment.widget.adapterview.LayoutManager;
import mobi.parchment.widget.adapterview.Move;
import mobi.parchment.widget.adapterview.ScrollDirectionManager;

/**
 * Created by Emir Hasanbegovic on 2014-03-11.
 */
public class StartSnapPosition<Cell> implements SnapPositionInterface<Cell> {

    @Override
    public int getDrawLimitMoveForwardOverDrawAdjust(final LayoutManager<Cell> layoutManager, final List<Cell> cells, final int size, final Cell cell) {
        final int startSizePadding = layoutManager.getStartSizePadding();
        final int cellSize = layoutManager.getCellSize(cell);
        return startSizePadding + cellSize;
    }

    @Override
    public int getDrawLimitMoveBackwardOverDrawAdjust(LayoutManager<Cell> layoutManager, List<Cell> cells, int size, Cell cell) {
        final int startSizePadding = layoutManager.getStartSizePadding();
        return startSizePadding;
    }

    @Override
    public int getDisplacementFromSnapPosition(LayoutManager<Cell> layoutManager, int size, Cell firstPosition, Cell lastPosition, Move move) {
        final Integer firstDisplacement = getCellDisplacementFromSnapPosition(layoutManager, firstPosition);

        if (firstDisplacement != null) {
            return firstDisplacement;
        }

        return 0;
    }

    private Integer getCellDisplacementFromSnapPosition(final LayoutManager<Cell> layoutManager, final Cell cell) {
        if (cell == null) {
            return null;
        }
        final int startSizePadding = layoutManager.getStartSizePadding();
        final int currentCellStart = layoutManager.getCellStart(cell);
        return startSizePadding - currentCellStart;
    }

    @Override
    public int getCellDistanceFromSnapPosition(LayoutManager<Cell> layoutManager, int size, Cell cell) {
        return Math.abs(getCellDisplacementFromSnapPosition(layoutManager,cell));

    }

    @Override
    public int getSnapToPixelDistance(LayoutManager<Cell> layoutManager, ScrollDirectionManager scrollDirectionManager, int size, View view) {
        final int startSizePadding = layoutManager.getStartSizePadding();
        final int startPixel = scrollDirectionManager.getViewStart(view);

        return startSizePadding - startPixel;
    }

    @Override
    public int getRedrawOffset(final ScrollDirectionManager scrollDirectionManager, final View incomingView, final View outgoingView) {
        final int outgoingViewStart = scrollDirectionManager.getViewStart(outgoingView);
        return outgoingViewStart;
    }

    @Override
    public int getAbsoluteSnapPosition(final LayoutManager<Cell> layoutManager, final int size, final int cellSize, final Move move) {
        final int startSizePadding = layoutManager.getStartSizePadding();
        return startSizePadding;
    }
}
