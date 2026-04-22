package tv.danmaku.bili.ui.main2.basic;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bilibili.lib.badge.Badge;
import com.bilibili.lib.homepage.widget.TabHost;
import com.bilibili.lib.homepage.widget.badge.BadgeManager;
import com.bilibili.lib.homepage.widget.badge.IBadgeView;
import com.bilibili.lib.ui.garb.Garb;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.DisplayUtils;

public final class TabHostHelper {
    private static final String TAG = "home.main.nav.helper";
    private BadgeManager mBadgeManager = new BadgeManager(0);
    private TabHost mTabHost;

    public TabHostHelper(TabHost tabHost) {
        this.mTabHost = tabHost;
    }

    public View findMenuView(int menuId) {
        int count = this.mTabHost.getItemCount();
        if (count == 0) {
            return null;
        }
        for (int index = 0; index < count; index++) {
            View view = this.mTabHost.getItemView(index);
            if (view.getId() == menuId) {
                return view;
            }
        }
        return null;
    }

    public void showBadge(final int position, final Badge badge, final Garb garb) {
        this.mTabHost.post(new Runnable() { // from class: tv.danmaku.bili.ui.main2.basic.TabHostHelper.1
            @Override // java.lang.Runnable
            public void run() {
                TabHostHelper.this.showBadgeInner(position, badge, garb);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showBadgeInner(int position, Badge badge, Garb garb) {
        boolean resetBadge;
        ViewGroup container = getItemView(position);
        IBadgeView current = findBadgeView(container);
        View anchorView = findAnchorView(container);
        int i = 0;
        boolean resetBadge2 = garb.isPure() || garb.isBottomIconsEmpty() || garb.isTailColorModel();
        if (resetBadge2 && !TextUtils.isEmpty(badge.coverImageUrl)) {
            resetBadge = false;
        } else {
            resetBadge = resetBadge2;
        }
        this.mBadgeManager.show(current, anchorView, container, badge, resetBadge ? 0 : DisplayUtils.dp2Px(10), resetBadge ? 0 : DisplayUtils.dp2Px(10), (!resetBadge || badge.badgeType == 2) ? -1 : -1);
        this.mTabHost.showCoverImageView(position, badge);
    }

    public void hideBadge(final int position) {
        this.mTabHost.post(new Runnable() { // from class: tv.danmaku.bili.ui.main2.basic.TabHostHelper.2
            @Override // java.lang.Runnable
            public void run() {
                TabHostHelper.this.hideBadgeInner(position);
            }
        });
    }

    public void hideBadgeInner(int position) {
        ViewGroup itemView = getItemView(position);
        IBadgeView badgeView = findBadgeView(itemView);
        this.mBadgeManager.detach(badgeView);
        this.mTabHost.showCoverImageView(position, (Badge) null);
    }

    public int getItemCount() {
        return this.mTabHost.getItemCount();
    }

    private ViewGroup getItemView(int position) {
        return this.mTabHost.getItemView(position);
    }

    private IBadgeView findBadgeView(ViewGroup itemView) {
        if (itemView == null) {
            return null;
        }
        int count = itemView.getChildCount();
        for (int index = 0; index < count; index++) {
            IBadgeView childAt = itemView.getChildAt(index);
            if (childAt instanceof IBadgeView) {
                return childAt;
            }
        }
        return null;
    }

    private View findAnchorView(ViewGroup itemView) {
        if (itemView == null) {
            return null;
        }
        return itemView.findViewById(R.id.icon_layout);
    }
}