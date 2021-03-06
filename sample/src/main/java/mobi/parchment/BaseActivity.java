package mobi.parchment;

import android.app.Activity;

/**
 * Created by emir on 16/03/14.
 */
public abstract class BaseActivity extends Activity {
    private ProductsAdapter mProductsAdapter = new ProductsAdapter(getLayoutResourceId());

    public ProductsAdapter getProductsAdapter() {
        return mProductsAdapter;
    }

    public abstract int getLayoutResourceId();

}
