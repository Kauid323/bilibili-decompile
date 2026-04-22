package tv.danmaku.bili.freedata.internal.ipc.brdcst;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bilibili.base.BiliContext;
import com.bilibili.fd_service.FreeDataManager;
import com.bilibili.lib.tf.freedata.util.log.TfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: TfSyncModelsReceiver.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/freedata/internal/ipc/brdcst/TfSyncModelsReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "network-ignet-ctr_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class TfSyncModelsReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String str;
        if (intent != null) {
            String from = intent.getStringExtra("from");
            TfLog.Companion companion = TfLog.Companion;
            String currentProcessName = BiliContext.currentProcessName();
            str = TfSyncModelsReceiverKt.SYNC_ACTION;
            companion.i("tf.app.ipc.brdcst", currentProcessName + " 收到 " + str + " 广播，from=" + from);
            if (!Intrinsics.areEqual(BiliContext.currentProcessName(), from)) {
                FreeDataManager.getInstance().onSyncModels();
            } else {
                TfLog.Companion.v("tf.app.ipc.brdcst", "Ignore self broadcast message");
            }
        }
    }
}