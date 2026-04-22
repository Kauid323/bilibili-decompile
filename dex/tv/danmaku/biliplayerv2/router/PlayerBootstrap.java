package tv.danmaku.biliplayerv2.router;

import android.content.Context;
import com.bilibili.base.Bootstrap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PlayerBootstrap.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\f"}, d2 = {"Ltv/danmaku/biliplayerv2/router/PlayerBootstrap;", "Lcom/bilibili/base/Bootstrap$Launch;", "<init>", "()V", "bootInProcess", "", "context", "Landroid/content/Context;", "processName", "", "launchWithWorker", "launchWithUI", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PlayerBootstrap extends Bootstrap.Launch {
    public void bootInProcess(Context context, String processName) {
        Intrinsics.checkNotNullParameter(context, "context");
        PlayerBootstrapUtils.INSTANCE.bootInProcess(context, processName);
    }

    public void launchWithWorker(Context context, String processName) {
        Intrinsics.checkNotNullParameter(context, "context");
        PlayerBootstrapUtils.INSTANCE.launchWithWorker(context, processName);
    }

    public void launchWithUI(Context context, String processName) {
        Intrinsics.checkNotNullParameter(context, "context");
        PlayerBootstrapUtils.INSTANCE.launchWithUI(context, processName);
    }
}