package tv.danmaku.bili.ui.main2.mine;

import android.content.Context;
import com.bilibili.app.comm.restrict.RestrictedMode;
import com.bilibili.app.comm.restrict.RestrictedType;
import com.bilibili.lib.homepage.mine.IMineMenuItemSolution;
import com.bilibili.lib.homepage.mine.MenuGroup;
import com.bilibili.lib.homepage.util.UriUtils;

public class DefaultMineMenuSolution implements IMineMenuItemSolution {
    private static final String CHEESE_URI = "https://m.bilibili.com/cheese/mine";
    private static final String GARB_URI = "https://www.bilibili.com/h5/mall/home";
    private static final String LESSONS_MODE_TAG = "misc";

    public void onMenuCreated(Context context, MenuGroup.Item item) {
        onMenuItemUpdate(context, item);
    }

    private boolean shouldHide(MenuGroup.Item item) {
        boolean isInterceptUri = UriUtils.equals(CHEESE_URI, item.uri) || UriUtils.equals(GARB_URI, item.uri);
        return isInterceptUri && RestrictedMode.isEnable(RestrictedType.LESSONS, LESSONS_MODE_TAG);
    }

    public void onMenuItemClick(Context context, MenuGroup.Item item) {
    }

    public void onMenuItemUpdate(Context context, MenuGroup.Item item) {
        if (shouldShowBadge(item)) {
            showBadge(item);
        }
        if (shouldHide(item)) {
            setVisible(item, false);
        }
    }

    public void onLoginStateChanged(Context context, MenuGroup.Item item) {
    }

    public void onMenuDestroy(Context context) {
    }

    private boolean shouldShowBadge(MenuGroup.Item item) {
        return item.redDot == 1;
    }

    protected void showBadge(MenuGroup.Item item, int number) {
        item.localRedDot = number;
    }

    protected void showBadge(MenuGroup.Item item) {
        showBadge(item, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setVisible(MenuGroup.Item item, boolean show) {
        item.localShow = show;
    }
}