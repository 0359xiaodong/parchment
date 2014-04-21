package mobi.parchment.widget.adapterview.snapposition;

import android.view.View;

import mobi.parchment.widget.adapterview.LayoutManager;
import mobi.parchment.widget.adapterview.Move;
import mobi.parchment.widget.adapterview.ScrollDirectionManager;

import java.util.List;

/**
 * Created by Emir Hasanbegovic on 2014-03-11.
 */
public class CenterSnapPosition<Cell> implements SnapPositionInterface<Cell> {

    @Override
    public int getDrawLimitMoveForwardOverDrawAdjust(final LayoutManager<Cell> layoutManager, final List<Cell> cells, final int size, final Cell cell) {
        final int startSizePadding = layoutManager.getStartSizePadding();
        final int cellSize = layoutManager.getCellSize(cell);
        return startSizePadding + (size + cellSize) / 2;
    }

    @Override
    public int getDrawLimitMoveBackwardOverDrawAdjust(LayoutManager<Cell> layoutManager, List<Cell> cells, int size, Cell cell) {
        final int startSizePadding = layoutManager.getStartSizePadding();
        final int cellSize = layoutManager.getCellSize(cell);
        return startSizePadding + (size - cellSize) / 2;
    }

    @Override
    public int getDisplacementFromSnapPosition(LayoutManager<Cell> layoutManager, int size, Cell firstPosition, Cell lastPosition) {
        final Integer firstDisplacement = getCellDisplacementFromSnapPosition(layoutManager, size, firstPosition);
        final Integer lastDisplacement = getCellDisplacementFromSnapPosition(layoutManager, size, lastPosition);

        if (firstDisplacement != null && lastDisplacement != null) {
            if (Math.abs(firstDisplacement) < Math.abs(lastDisplacement)) {
                return firstDisplacement;
            } else {
                return lastDisplacement;
            }
        } else if (firstDisplacement != null) {
            return firstDisplacement;
        } else if (lastDisplacement != null) {
            return lastDisplacement;
        }

        return 0;
    }

    private Integer getCellDisplacementFromSnapPosition(LayoutManager<Cell> layoutManager, int size, Cell cell) {
        if (cell == null) {
            return null;
        }
        final int startSizePadding = layoutManager.getStartSizePadding();
        final int currentCellCenter = layoutManager.getCellCenter(cell);
        final int center = startSizePadding + size / 2;
        final int displacement = center - currentCellCenter;
        return displacement;
    }

    @Override
    public int getCellDistanceFromSnapPosition(final LayoutManager<Cell> layoutManager, final int size, final Cell cell) {
        final int displacement = getDisplacementFromSnapPosition(layoutManager, size, cell, null);
        return Math.abs(displacement);
    }

    @Override
    public int getSnapToPixelDistance(LayoutManager<Cell> layoutManager, ScrollDirectionManager scrollDirectionManager, int size, View view) {
        final int viewSize = scrollDirectionManager.getViewSize(view);
        final int startPixel = scrollDirectionManager.getViewStart(view);
        final int startSizePadding = layoutManager.getStartSizePadding();

        return startSizePadding + (size - viewSize) / 2 - startPixel;
    }

    @Override
    public int getRedrawOffset(final ScrollDirectionManager scrollDirectionManager, final View incomingView, final View outgoingView) {
        final int outgoingViewStart = scrollDirectionManager.getViewStart(outgoingView);
        final int incomingViewSize = scrollDirectionManager.getViewSize(incomingView);
        final int outgoingViewSize = scrollDirectionManager.getViewSize(outgoingView);
        final int viewDifference = (outgoingViewSize - incomingViewSize) / 2;

        return outgoingViewStart + viewDifference;
    }

    @Override
    public int getAbsoluteSnapPosition(final LayoutManager<Cell> layoutManager, final int size, final int cellSize, final Move move) {
        final int startSizePadding = layoutManager.getStartSizePadding();
        final int snapPosition = startSizePadding + (size - cellSize) / 2;
        return snapPosition;
    }
}
