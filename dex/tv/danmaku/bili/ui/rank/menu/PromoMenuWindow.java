package tv.danmaku.bili.ui.rank.menu;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bilibili.app.comm.baseres.R;
import com.bilibili.lib.ui.menu.FloatMenuWindow;
import com.bilibili.lib.ui.menu.IFloatMenuItem;
import com.bilibili.lib.ui.menu.NormalMenuItem;
import java.util.List;
import tv.danmaku.bili.ui.rank.reporter.RankingReport;
import tv.danmaku.bili.ui.rank.router.RankRouter;

public class PromoMenuWindow {
    public static NormalMenuItem createWatchLaterMenuItem(final Context context, final String fromPageName, final String avId) {
        return new NormalMenuItem(R.drawable.ic_promo_index_watch_later, context.getString(bili.resource.common.R.string.common_global_string_293), new NormalMenuItem.OnMenuClickListener() { // from class: tv.danmaku.bili.ui.rank.menu.PromoMenuWindow.1
            public void onMenuClick(View view2) {
                RankingReport.reportRankingMoreClick(fromPageName, "2");
                if (!TextUtils.isEmpty(avId) && TextUtils.isDigitsOnly(avId)) {
                    RankRouter.addToWatchLater(context, avId);
                }
            }
        });
    }

    public static void show(Context context, View anchor, List<IFloatMenuItem> menus) {
        FloatMenuWindow.show(context, anchor, menus);
    }
}