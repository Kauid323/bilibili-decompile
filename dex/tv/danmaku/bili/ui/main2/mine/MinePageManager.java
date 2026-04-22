package tv.danmaku.bili.ui.main2.mine;

import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bilibili.lib.homepage.mine.IMineMenuItemRedirection;
import com.bilibili.lib.homepage.mine.IMineMenuItemSolution;
import com.bilibili.lib.homepage.mine.IMinePageInfo;
import com.bilibili.lib.homepage.mine.MenuGroup;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.login.LoginReporterV2;
import tv.danmaku.bili.ui.main2.AccountMineInfoManager;

/* compiled from: MinePageManager.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\bJ\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0011J\u0012\u0010\u0016\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0019\u001a\u00020\bH\u0002J\u000e\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0014J\u0018\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u001e"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/MinePageManager;", "", AudioIntentHelper.FROM_ACTIVITY, "Landroidx/fragment/app/FragmentActivity;", "<init>", "(Landroidx/fragment/app/FragmentActivity;)V", "_pages", "", "", "Ltv/danmaku/bili/ui/main2/mine/MinePage;", "pages", "", "getPages", "()Ljava/util/Map;", "findTarget", "minePageUrl", "onLoginStateChanged", "", "onMineMenuItemClick", "menuItem", "Lcom/bilibili/lib/homepage/mine/MenuGroup$Item;", "onMineMenuDestroy", "switchTo", "targetPage", "getPromptSceneFromUrl", "url", "createSinglePage", "item", "updateSinglePage", LoginReporterV2.PAGE_FROM_KEY, "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MinePageManager {
    public static final int $stable = 8;
    private final Map<String, MinePage> _pages;
    private final FragmentActivity activity;

    public MinePageManager(FragmentActivity activity) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        this.activity = activity;
        this._pages = new HashMap();
    }

    public final Map<String, MinePage> getPages() {
        return this._pages;
    }

    public final MinePage findTarget(String minePageUrl) {
        Intrinsics.checkNotNullParameter(minePageUrl, "minePageUrl");
        return this._pages.get(minePageUrl);
    }

    public final void onLoginStateChanged() {
        for (MinePage page : this._pages.values()) {
            IMineMenuItemSolution solution = page.mPageInfo.getMenuItemSolution();
            if (solution != null) {
                solution.onLoginStateChanged(this.activity, page.mMenuItem);
            }
        }
    }

    public final void onMineMenuItemClick(MenuGroup.Item menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "menuItem");
        String str = menuItem.uri;
        Intrinsics.checkNotNullExpressionValue(str, AudioIntentHelper.ARGS_URI);
        MinePage targetPage = findTarget(str);
        if (targetPage == null) {
            return;
        }
        switchTo(targetPage);
        IMineMenuItemSolution menuItemSolution = targetPage.mPageInfo.getMenuItemSolution();
        if (menuItemSolution != null) {
            menuItemSolution.onMenuItemClick(this.activity, menuItem);
        }
    }

    public final void onMineMenuDestroy() {
        for (MinePage page : this._pages.values()) {
            IMineMenuItemSolution solution = page.mPageInfo.getMenuItemSolution();
            if (solution != null) {
                solution.onMenuDestroy(this.activity);
            }
        }
    }

    private final void switchTo(MinePage targetPage) {
        if (targetPage == null) {
            return;
        }
        IMinePageInfo pageInfo = targetPage.mPageInfo;
        Intrinsics.checkNotNullExpressionValue(pageInfo, "mPageInfo");
        IMineMenuItemRedirection redirection = pageInfo.getRedirection();
        if (redirection == null) {
            return;
        }
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.activity), (CoroutineContext) null, (CoroutineStart) null, new MinePageManager$switchTo$1(this, redirection, targetPage, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getPromptSceneFromUrl(String url) {
        try {
            Uri uri = Uri.parse(url);
            return uri.getQueryParameter("prompt_scene");
        } catch (Exception e) {
            return null;
        }
    }

    public final void createSinglePage(MenuGroup.Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        MinePage page = new MinePage(item.id, item.uri, item, AccountMineInfoManager.createMineSolution(item));
        this._pages.put(page.mUrl, page);
        IMineMenuItemSolution menuItemSolution = page.mPageInfo.getMenuItemSolution();
        if (menuItemSolution != null) {
            menuItemSolution.onMenuCreated(this.activity, page.mMenuItem);
        }
    }

    public final void updateSinglePage(MinePage page, MenuGroup.Item item) {
        Intrinsics.checkNotNullParameter(page, LoginReporterV2.PAGE_FROM_KEY);
        Intrinsics.checkNotNull(item);
        page.mMenuItem = item;
        IMineMenuItemSolution menuItemSolution = page.mPageInfo.getMenuItemSolution();
        if (menuItemSolution != null) {
            menuItemSolution.onMenuItemUpdate(this.activity, page.mMenuItem);
        }
    }
}