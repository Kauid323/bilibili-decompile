package tv.danmaku.bili.ui.main2.mine.provider;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bilibili.app.provider.UtilKt;
import com.bilibili.lib.homepage.mine.IMineMenuItemRedirection;
import com.bilibili.lib.homepage.mine.IMineMenuItemSolution;
import com.bilibili.lib.homepage.mine.IMinePageInfo;
import com.bilibili.lib.homepage.mine.MenuGroup;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main2.mine.DefaultMineMenuSolution;

/* compiled from: ParentControlModeSolution.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/provider/ParentControlModeSolution;", "Lcom/bilibili/lib/homepage/mine/IMinePageInfo;", "<init>", "()V", "menuItemSolution", "Lcom/bilibili/lib/homepage/mine/IMineMenuItemSolution;", "getMenuItemSolution", "redirect", "Lcom/bilibili/lib/homepage/mine/IMineMenuItemRedirection;", "getRedirection", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ParentControlModeSolution implements IMinePageInfo {
    public static final int $stable = 8;
    private final IMineMenuItemSolution menuItemSolution = new DefaultMineMenuSolution();
    private final IMineMenuItemRedirection redirect = new IMineMenuItemRedirection() { // from class: tv.danmaku.bili.ui.main2.mine.provider.ParentControlModeSolution$redirect$1
        public void redirect(Activity context, MenuGroup.Item item) {
            CoroutineScope lifecycleScope;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(item, "item");
            Activity $this$findTypedActivityOrNull$iv = context;
            LifecycleOwner lifecycleOwner = (FragmentActivity) UtilKt.findTypedActivityOrNull($this$findTypedActivityOrNull$iv, FragmentActivity.class);
            if (lifecycleOwner == null || (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner)) == null) {
                return;
            }
            BuildersKt.launch$default(lifecycleScope, (CoroutineContext) null, (CoroutineStart) null, new ParentControlModeSolution$redirect$1$redirect$1(context, null), 3, (Object) null);
        }

        public boolean isNeedLoginBeforeRedirect(MenuGroup.Item item) {
            Intrinsics.checkNotNullParameter(item, "item");
            return item.needLogin == 1;
        }
    };

    public IMineMenuItemSolution getMenuItemSolution() {
        return this.menuItemSolution;
    }

    public IMineMenuItemRedirection getRedirection() {
        return this.redirect;
    }
}