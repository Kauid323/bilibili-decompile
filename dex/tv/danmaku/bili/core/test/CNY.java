package tv.danmaku.bili.core.test;

import android.content.Context;
import android.view.View;
import com.bilibili.bus.Violet;
import com.bilibili.lib.jsbridge.common.bus.WebBusModel;
import com.bilibili.list.test.AbsButtonTestItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: MainTestPageActivity.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/core/test/CNY兴趣选择追打天马;", "Lcom/bilibili/list/test/AbsButtonTestItem;", "<init>", "()V", "onClick", "", "v", "Landroid/view/View;", "getButtonText", "", "context", "Landroid/content/Context;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
/* renamed from: tv.danmaku.bili.core.test.CNY兴趣选择追打天马  reason: invalid class name */
public final class CNY extends AbsButtonTestItem {
    public static final int $stable = AbsButtonTestItem.$stable;

    public void onClick(View v) {
        Violet.INSTANCE.sendMsg(new WebBusModel("cny_interest_force_pegasus_refresh", "1"));
    }

    public CharSequence getButtonText(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        return simpleName;
    }
}