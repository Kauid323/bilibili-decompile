package tv.danmaku.bili.core.test;

import android.content.Context;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bilibili.app.provider.UtilKt;
import com.bilibili.list.test.AbsButtonTestItem;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.bili.BR;

/* compiled from: MainTestPageActivity.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/core/test/CleanTopGameTabLottieDisplayHistory;", "Lcom/bilibili/list/test/AbsButtonTestItem;", "<init>", "()V", "getButtonText", "", "context", "Landroid/content/Context;", "onClick", "", "v", "Landroid/view/View;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class CleanTopGameTabLottieDisplayHistory extends AbsButtonTestItem {
    public static final int $stable = AbsButtonTestItem.$stable;

    public CharSequence getButtonText(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return "清除顶部Icon Lottie展示记录";
    }

    public void onClick(View v) {
        CoroutineScope lifecycleScope;
        AppCompatActivity findActivityOrNull = UtilKt.findActivityOrNull(v != null ? v.getContext() : null);
        AppCompatActivity appCompatActivity = findActivityOrNull instanceof AppCompatActivity ? findActivityOrNull : null;
        if (appCompatActivity != null && (lifecycleScope = LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) appCompatActivity)) != null) {
            BuildersKt.launch$default(lifecycleScope, (CoroutineContext) null, (CoroutineStart) null, new CleanTopGameTabLottieDisplayHistory$onClick$1(v, null), 3, (Object) null);
        }
    }
}