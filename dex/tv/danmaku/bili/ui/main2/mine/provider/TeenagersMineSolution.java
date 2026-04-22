package tv.danmaku.bili.ui.main2.mine.provider;

import android.app.Activity;
import android.net.Uri;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.homepage.mine.IMineMenuItemRedirection;
import com.bilibili.lib.homepage.mine.IMineMenuItemSolution;
import com.bilibili.lib.homepage.mine.IMinePageInfo;
import com.bilibili.lib.homepage.mine.MenuGroup;
import com.bilibili.teenagersmode.TeenagersModeReportHelper;
import com.bilibili.teenagersmode.utils.TeenagersRouter;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import tv.danmaku.bili.auth.BiliAuthConstants;
import tv.danmaku.bili.ui.main2.mine.DefaultMineMenuSolution;
import tv.danmaku.bili.ui.main2.mine.provider.TeenagersMineSolution;

public class TeenagersMineSolution implements IMinePageInfo {
    private IMineMenuItemSolution mMenuSolution = new DefaultMineMenuSolution();
    private IMineMenuItemRedirection mRedirection = new AnonymousClass1();

    /* renamed from: tv.danmaku.bili.ui.main2.mine.provider.TeenagersMineSolution$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    class AnonymousClass1 implements IMineMenuItemRedirection {
        AnonymousClass1() {
        }

        public void redirect(Activity context, MenuGroup.Item menuData) {
            TeenagersModeReportHelper.reportNavigationItemClick();
            RouteRequest request = new RouteRequest.Builder(Uri.parse(menuData.uri)).extras(new Function1() { // from class: tv.danmaku.bili.ui.main2.mine.provider.TeenagersMineSolution$1$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    return TeenagersMineSolution.AnonymousClass1.lambda$redirect$0((MutableBundleLike) obj);
                }
            }).build();
            BLRouter.routeTo(request, context);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Unit lambda$redirect$0(MutableBundleLike bundle) {
            bundle.put(BiliAuthConstants.BUNDLE_KEY_SOURCE_EVENT, TeenagersRouter.SourceEvent.USER_CENTER.getValue());
            return null;
        }

        public boolean isNeedLoginBeforeRedirect(MenuGroup.Item menuData) {
            return menuData.needLogin == 1;
        }
    }

    public IMineMenuItemSolution getMenuItemSolution() {
        return this.mMenuSolution;
    }

    public IMineMenuItemRedirection getRedirection() {
        return this.mRedirection;
    }
}