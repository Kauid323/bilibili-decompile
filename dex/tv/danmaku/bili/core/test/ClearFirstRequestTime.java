package tv.danmaku.bili.core.test;

import android.content.Context;
import android.view.View;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.list.test.AbsButtonTestItem;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.bili.BR;

/* compiled from: MainTestPageActivity.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/core/test/ClearFirstRequestTime;", "Lcom/bilibili/list/test/AbsButtonTestItem;", "<init>", "()V", "getButtonText", "", "context", "Landroid/content/Context;", "onClick", "", "v", "Landroid/view/View;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ClearFirstRequestTime extends AbsButtonTestItem {
    public static final int $stable = AbsButtonTestItem.$stable;

    public CharSequence getButtonText(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        long firstRequestTime = BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).getLong("notification_permission_android_13_first_request_time", 0L);
        long currentTime = System.currentTimeMillis();
        String str = (String) ConfigManager.Companion.config().get("push.request_notification_permission_interval_1", "3");
        int intervalDays = str != null ? Integer.parseInt(str) : 3;
        boolean shouldShow = currentTime - firstRequestTime > ((long) ((((intervalDays * 24) * 60) * 60) * 1000));
        return "设置满足第二次申请的时间间隔，第一次时间戳为：" + firstRequestTime + "，当前系统时间戳为：" + currentTime + "， 差值：" + (currentTime - firstRequestTime) + "，命中config对应间隔天数：" + intervalDays + ",对应毫秒值：" + (intervalDays * 24 * 60 * 60 * 1000) + "，是否符合间隔：" + shouldShow;
    }

    public void onClick(View v) {
        if (v == null) {
            return;
        }
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), (CoroutineContext) null, (CoroutineStart) null, new ClearFirstRequestTime$onClick$1(v, null), 3, (Object) null);
    }
}