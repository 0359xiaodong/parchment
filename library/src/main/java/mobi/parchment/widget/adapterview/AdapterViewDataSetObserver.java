package mobi.parchment.widget.adapterview;

import android.database.DataSetObserver;

/**
 * Created by Emir Hasanbegovic
 */
public abstract class AdapterViewDataSetObserver extends DataSetObserver {

    protected final AdapterViewManager mAdapterViewManager;

    public AdapterViewDataSetObserver(final AdapterViewManager adapterViewManager) {
        mAdapterViewManager = adapterViewManager;
        mAdapterViewManager.registerDataSetObserver(this);
    }

    protected abstract void onDataSetChanged();

    public void destroy() {
        mAdapterViewManager.unregisterDataSetObserver(this);
    }

    @Override
    public void onChanged() {
        onDataSetChanged();
    }

    @Override
    public void onInvalidated() {
        onDataSetChanged();
    }

    protected AdapterViewManager getAdapterViewManager() {
        return mAdapterViewManager;
    }

}