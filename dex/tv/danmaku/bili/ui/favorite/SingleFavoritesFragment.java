package tv.danmaku.bili.ui.favorite;

import android.os.Bundle;
import com.bilibili.playset.PlaySetFragment;
import tv.danmaku.bili.ui.favorite.BaseFavoritesFragment;
import tv.danmaku.bili.ui.favorite.api.FavoriteTab;

public class SingleFavoritesFragment extends BaseFavoritesFragment {
    public static SingleFavoritesFragment newInstance(Bundle extra) {
        SingleFavoritesFragment singleFavoritesFragment = new SingleFavoritesFragment();
        singleFavoritesFragment.setArguments(extra);
        return singleFavoritesFragment;
    }

    @Override // tv.danmaku.bili.ui.favorite.BaseFavoritesFragment
    protected boolean enableNavigationIcon() {
        return false;
    }

    @Override // tv.danmaku.bili.ui.favorite.BaseFavoritesFragment
    public void onCreatedFolder() {
        if (this.mTabData == null || this.mTabData.isEmpty()) {
            return;
        }
        BaseFavoritesFragment.FavoritePagerAdapter adapter = this.viewPager.getAdapter();
        if (!(adapter instanceof BaseFavoritesFragment.FavoritePagerAdapter)) {
            return;
        }
        BaseFavoritesFragment.FavoritePagerAdapter adapter2 = adapter;
        for (int i = 0; i < this.mTabData.size(); i++) {
            FavoriteTab tab = this.mTabData.get(i);
            if ("favorite".equals(tab.id)) {
                PlaySetFragment item = adapter2.getItem(i);
                if (item instanceof PlaySetFragment) {
                    item.onRefresh();
                    return;
                }
                return;
            }
        }
    }
}