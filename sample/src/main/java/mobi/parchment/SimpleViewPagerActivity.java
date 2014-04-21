package mobi.parchment;

import android.os.Bundle;
import android.widget.BaseAdapter;

import mobi.parchment.widget.adapterview.listview.ListView;

public class SimpleViewPagerActivity extends BaseActivity{


	@SuppressWarnings("unchecked")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_simple_view_pager);

		final ListView viewPager = (ListView<BaseAdapter>) findViewById(R.id.parchment_view);
		viewPager.setAdapter(getProductsAdapter());
	}

    @Override
    public int getLayoutResourceId() {
        return R.layout.list_item_view_pager_picture;
    }

}
