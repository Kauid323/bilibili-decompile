package tv.danmaku.bili.ui.main;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import com.bilibili.app.comm.baseres.R;
import com.bilibili.lib.homepage.ISearchViewHost;
import com.bilibili.lib.ui.BaseFragment;
import tv.danmaku.bili.ui.videodownload.VideoDownloadListActivity;

@Deprecated
public abstract class MainPagerFragment extends BaseFragment implements Toolbar.OnMenuItemClickListener {
    protected abstract Toolbar getBar();

    protected int getTitleId() {
        return 0;
    }

    protected boolean enableNavigationIcon() {
        return true;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Toolbar toolbar = getBar();
        if (getTitleId() == 0) {
            toolbar.setTitle((CharSequence) null);
        } else {
            toolbar.setTitle(getTitleId());
        }
        if (enableNavigationIcon()) {
            toolbar.setNavigationIcon(R.drawable.ic_navigation_drawer);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.main.MainPagerFragment.1
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    FragmentActivity activity = MainPagerFragment.this.getActivity();
                    if (activity != null) {
                        activity.onBackPressed();
                    }
                }
            });
        } else {
            toolbar.setNavigationIcon((Drawable) null);
        }
        if (getActivity() != null) {
            onCreateMenu(toolbar.getMenu(), getActivity().getMenuInflater());
        }
        toolbar.setOnMenuItemClickListener(this);
    }

    public boolean onMenuItemClick(MenuItem item) {
        int menuId = item.getItemId();
        if (menuId != tv.danmaku.bili.R.id.searchable_search) {
            if (menuId == tv.danmaku.bili.R.id.searchable_download) {
                startActivity(VideoDownloadListActivity.createIntent(getActivity()));
                return true;
            }
            return false;
        }
        ISearchViewHost activity = getActivity();
        if (activity instanceof ISearchViewHost) {
            activity.showSearchView();
            return true;
        }
        return true;
    }

    public void onCreateMenu(Menu menu, MenuInflater inflater) {
        View view;
        inflater.inflate(tv.danmaku.bili.R.menu.searchable_top_menu, menu);
        int n = menu.size();
        for (int pos = 0; pos < n; pos++) {
            final MenuItem item = menu.getItem(pos);
            if (item != null && (view = item.getActionView()) != null) {
                view.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.main.MainPagerFragment.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        MainPagerFragment.this.onMenuItemClick(item);
                    }
                });
            }
        }
    }

    public void onDestroyView() {
        MenuItem item;
        Toolbar bar = getBar();
        if (bar != null) {
            Menu menu = bar.getMenu();
            if (menu != null && (item = menu.findItem(tv.danmaku.bili.R.id.searchable_download)) != null) {
                item.getActionView().setOnClickListener(null);
            }
            bar.setOnMenuItemClickListener((Toolbar.OnMenuItemClickListener) null);
            bar.setNavigationOnClickListener((View.OnClickListener) null);
        }
        super.onDestroyView();
    }
}