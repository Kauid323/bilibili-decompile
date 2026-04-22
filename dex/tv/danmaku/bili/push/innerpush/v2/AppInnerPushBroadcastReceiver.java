package tv.danmaku.bili.push.innerpush.v2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.bilibili.module.main.innerpush.InnerPush;
import com.google.gson.Gson;
import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: AppInnerPushBroadcastReceiver.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/push/innerpush/v2/AppInnerPushBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AppInnerPushBroadcastReceiver extends BroadcastReceiver {
    public static final int $stable = 8;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Bundle bundle;
        if (intent == null || (bundle = intent.getExtras()) == null) {
            return;
        }
        String json = bundle.getString(InnerPushReceiverKt.KEY_EXTRA);
        try {
            InnerPush pushObj = (InnerPush) new Gson().fromJson(json, InnerPush.class);
            AppInnerPushManagerV2.Companion.getInstance().onReceived(pushObj);
        } catch (Exception e) {
        }
    }
}