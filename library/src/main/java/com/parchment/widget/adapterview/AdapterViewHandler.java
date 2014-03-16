package com.parchment.widget.adapterview;

import android.view.View;
import android.view.ViewGroup.LayoutParams;

/**
 * Created by Emir Hasanbegovic
 */
public interface AdapterViewHandler {

    public boolean addViewInAdapterView(final View view, final int index, final LayoutParams layoutParams);

    public void removeViewInAdapterView(final View view);

    public int getPaddingTop();

    public int getPaddingBottom();

    public int getPaddingLeft();

    public int getPaddingRight();


}
