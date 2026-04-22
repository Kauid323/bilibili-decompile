package tv.danmaku.bili.core.test;

import android.content.Context;
import android.view.View;
import com.bilibili.homepage.HomeTabService;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.list.test.AbsButtonTestItem;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import tv.danmaku.bili.BR;

/* compiled from: MainTestPageActivity.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/core/test/ForceUpdateHomeTab;", "Lcom/bilibili/list/test/AbsButtonTestItem;", "<init>", "()V", "onClick", "", "view", "Landroid/view/View;", "getButtonText", "", "context", "Landroid/content/Context;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ForceUpdateHomeTab extends AbsButtonTestItem {
    public static final int $stable = AbsButtonTestItem.$stable;

    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        HomeTabService service = (HomeTabService) BLRouter.INSTANCE.get(HomeTabService.class, "HOME_TAB_SERVICE");
        if (service == null) {
            return;
        }
        BuildersKt.launch$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new ForceUpdateHomeTab$onClick$1(service, view, null), 3, (Object) null);
    }

    public CharSequence getButtonText(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return "强制刷新跳转到青少年tab";
    }
}