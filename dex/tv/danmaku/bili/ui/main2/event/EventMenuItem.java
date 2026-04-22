package tv.danmaku.bili.ui.main2.event;

import android.content.Context;
import com.bilibili.lib.homepage.startdust.menu.BaseBadgeOptionMenuItem;
import com.bilibili.lib.homepage.startdust.menu.DynamicMenuItem;
import com.bilibili.lib.homepage.startdust.menu.IMenuAnimatorServer;
import com.bilibili.lib.homepage.widget.MenuActionView;

public class EventMenuItem extends DynamicMenuItem {
    private EventMenuActionView mActionView;

    public EventMenuItem(Context context, BaseBadgeOptionMenuItem.MenuItemInfo itemInfo) {
        super(context, itemInfo);
    }

    protected MenuActionView buildActionView() {
        this.mActionView = new EventMenuActionView(this.mContext);
        this.mActionView.setTitle(this.mItemInfo.name);
        this.mActionView.loadIcon(this.mItemInfo.iconUrl);
        return this.mActionView;
    }

    public void showAnim() {
        IMenuAnimatorServer server = forAnimatorServer();
        if (server != null) {
            server.startUpdateAnimator(this.mActionView);
        }
    }
}