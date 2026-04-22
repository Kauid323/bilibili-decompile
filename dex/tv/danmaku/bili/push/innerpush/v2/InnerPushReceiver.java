package tv.danmaku.bili.push.innerpush.v2;

import android.content.Context;
import android.content.Intent;
import com.bilibili.comm.bbc.JsonOpMessage;
import com.bilibili.comm.bbc.OpMessage;
import com.bilibili.comm.bbc.service.OperationReceiver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: InnerPushReceiver.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/push/innerpush/v2/InnerPushReceiver;", "Lcom/bilibili/comm/bbc/service/OperationReceiver;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "onReceived", "", "op", "Lcom/bilibili/comm/bbc/OpMessage;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class InnerPushReceiver implements OperationReceiver {
    public static final int $stable = 8;
    private final Context context;

    public InnerPushReceiver(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public final Context getContext() {
        return this.context;
    }

    public void onReceived(OpMessage op) {
        Intrinsics.checkNotNullParameter(op, "op");
        if (op instanceof JsonOpMessage) {
            Intent i = new Intent(InnerPushReceiverKt.getPushIntentAction(this.context));
            i.setPackage(this.context.getPackageName());
            i.putExtra(InnerPushReceiverKt.KEY_EXTRA, ((JsonOpMessage) op).getBody().toString());
            this.context.sendBroadcast(i);
        }
    }
}