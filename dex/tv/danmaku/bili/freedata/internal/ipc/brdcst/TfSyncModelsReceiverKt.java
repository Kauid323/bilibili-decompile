package tv.danmaku.bili.freedata.internal.ipc.brdcst;

import android.app.Application;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.bilibili.base.BiliContext;
import com.bilibili.base.BiliContextKt;
import com.bilibili.lib.tf.freedata.util.log.TfLog;
import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: TfSyncModelsReceiver.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\b\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\b\u0010\u0006\u001a\u00020\u0005H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"TAG", "", "SYNC_ACTION", "SYNC_EXTRA_FROM", "registerSyncModelReceiver", "", "syncModels", "network-ignet-ctr_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class TfSyncModelsReceiverKt {
    private static String SYNC_ACTION = BiliContextKt.getPackageName(BiliContext.INSTANCE) + "tf.models.sync";
    private static final String SYNC_EXTRA_FROM = "from";
    private static final String TAG = "tf.app.ipc.brdcst";

    public static final void registerSyncModelReceiver() {
        Application context = BiliContext.application();
        if (context == null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(SYNC_ACTION);
        ContextCompat.registerReceiver(context, new TfSyncModelsReceiver(), intentFilter, 4);
        TfLog.Companion.i(TAG, "注册接收广播 " + SYNC_ACTION);
    }

    public static final void syncModels() {
        Application context = BiliContext.application();
        if (context == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction(SYNC_ACTION);
        intent.setPackage(BiliContextKt.getPackageName(BiliContext.INSTANCE));
        intent.putExtra("from", BiliContext.currentProcessName());
        context.sendBroadcast(intent);
        TfLog.Companion companion = TfLog.Companion;
        String currentProcessName = BiliContext.currentProcessName();
        companion.i(TAG, currentProcessName + " 发出 " + SYNC_ACTION + " 广播");
    }
}