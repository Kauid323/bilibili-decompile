package tv.danmaku.bili.push.innerpush;

import com.bilibili.module.main.innerpush.ISendPushMessage;
import com.bilibili.module.main.innerpush.InnerPush;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.push.innerpush.v2.AppInnerPushManagerV2;

/* compiled from: SendPushMessageImp.kt */
@Singleton
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/push/innerpush/SendPushMessageImp;", "Lcom/bilibili/module/main/innerpush/ISendPushMessage;", "<init>", "()V", "sendPushMessage", "", "innerPush", "Lcom/bilibili/module/main/innerpush/InnerPush;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SendPushMessageImp implements ISendPushMessage {
    public static final int $stable = 0;

    public void sendPushMessage(InnerPush innerPush) {
        Intrinsics.checkNotNullParameter(innerPush, "innerPush");
        try {
            AppInnerPushManagerV2.Companion.getInstance().onReceived(innerPush);
        } catch (Exception e) {
        }
    }
}