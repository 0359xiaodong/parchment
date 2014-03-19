package mobi.parchment.widget.adapterview;

import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Emir Hasanbegovic on 2014-03-03.
 */
public class ScrollDirectionManager {

    private final boolean mIsVerticalScroll;

    public ScrollDirectionManager(final boolean isVerticalScroll){
        mIsVerticalScroll = isVerticalScroll;
    }

    public ScrollDirectionManager(final LayoutManagerAttributes attributes) {
        mIsVerticalScroll = attributes.isVertical();
    }

    public boolean isVerticalScroll(){
        return mIsVerticalScroll;
    }

    public int getViewStart(final View view) {
        if (isVerticalScroll())
            return view.getTop();
        return view.getLeft();
    }

    public int getViewEnd(final View view) {
        if (isVerticalScroll())
            return view.getBottom();
        return view.getRight();
    }

    public int getViewSize(final View view) {
        if (isVerticalScroll())
            return view.getMeasuredHeight();
        return view.getMeasuredWidth();
    }

    public int getViewBreadth(final View view) {
        if (isVerticalScroll())
            return view.getMeasuredWidth();
        return view.getMeasuredHeight();
    }

    public int getViewGroupSize(final ViewGroup viewGroup) {
        if (isVerticalScroll())
            return viewGroup.getMeasuredHeight();
        return viewGroup.getMeasuredWidth();
    }

    public int getDrawSize(int left, int top, int right, int bottom) {
        if (isVerticalScroll())
            return bottom - top;
        return right - left;
    }

    public int getDrawBreadth(int left, int top, int right, int bottom) {
        if (isVerticalScroll())
            return right - left;
        return bottom - top;
    }


}
