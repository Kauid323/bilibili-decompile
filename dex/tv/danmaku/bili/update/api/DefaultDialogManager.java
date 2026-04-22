package tv.danmaku.bili.update.api;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: UpdateDialogManager.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001e\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0016J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u000f"}, d2 = {"Ltv/danmaku/bili/update/api/DefaultDialogManager;", "Ltv/danmaku/bili/update/api/UpdateDialogManager;", "<init>", "()V", "addUpdateDialog", "", "context", "Landroid/content/Context;", "showDialog", "Lkotlin/Function0;", "showUpdateNextDialog", "suspend", "", "addInstallCheckDialog", "showInstallCheckNextDialog", "updater_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DefaultDialogManager implements UpdateDialogManager {
    @Override // tv.danmaku.bili.update.api.UpdateDialogManager
    public void addUpdateDialog(Context context, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function0, "showDialog");
        function0.invoke();
    }

    @Override // tv.danmaku.bili.update.api.UpdateDialogManager
    public void showUpdateNextDialog(boolean suspend, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // tv.danmaku.bili.update.api.UpdateDialogManager
    public void addInstallCheckDialog(Context context, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function0, "showDialog");
        function0.invoke();
    }

    @Override // tv.danmaku.bili.update.api.UpdateDialogManager
    public void showInstallCheckNextDialog(boolean suspend, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }
}