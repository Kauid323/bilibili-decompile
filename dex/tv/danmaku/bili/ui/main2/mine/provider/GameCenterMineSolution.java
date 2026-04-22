package tv.danmaku.bili.ui.main2.mine.provider;

import android.app.Activity;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.homepage.mine.IMineMenuItemRedirection;
import com.bilibili.lib.homepage.mine.IMineMenuItemSolution;
import com.bilibili.lib.homepage.mine.IMinePageInfo;
import com.bilibili.lib.homepage.mine.MenuGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main2.mine.MineGameCenterHelperKt;

/* compiled from: GameCenterMineSolution.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/provider/GameCenterMineSolution;", "Lcom/bilibili/lib/homepage/mine/IMinePageInfo;", "<init>", "()V", "mMenuSolution", "Lcom/bilibili/lib/homepage/mine/IMineMenuItemSolution;", "mRedirection", "Lcom/bilibili/lib/homepage/mine/IMineMenuItemRedirection;", "getMenuItemSolution", "getRedirection", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class GameCenterMineSolution implements IMinePageInfo {
    public static final int $stable = 8;
    private final IMineMenuItemSolution mMenuSolution = new GameMineMenuItemSolution();
    private final IMineMenuItemRedirection mRedirection = new IMineMenuItemRedirection() { // from class: tv.danmaku.bili.ui.main2.mine.provider.GameCenterMineSolution$mRedirection$1
        public void redirect(Activity context, MenuGroup.Item menuData) {
            String it;
            Intrinsics.checkNotNullParameter(context, "context");
            if (menuData != null && (it = menuData.uri) != null) {
                MineGameCenterHelperKt.notifyWeakClick(it);
                BLRouter.routeTo(new RouteRequest.Builder(it).build(), context);
            }
        }

        public boolean isNeedLoginBeforeRedirect(MenuGroup.Item menuData) {
            Intrinsics.checkNotNullParameter(menuData, "menuData");
            return menuData.needLogin == 1;
        }
    };

    public IMineMenuItemSolution getMenuItemSolution() {
        return this.mMenuSolution;
    }

    public IMineMenuItemRedirection getRedirection() {
        return this.mRedirection;
    }
}