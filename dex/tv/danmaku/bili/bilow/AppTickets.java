package tv.danmaku.bili.bilow;

import android.content.Context;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.ticket.api.BiliTickets;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: AppTickets.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/bilow/AppTickets;", "", "<init>", "()V", "init", "", "context", "Landroid/content/Context;", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AppTickets {
    public static final AppTickets INSTANCE = new AppTickets();

    private AppTickets() {
    }

    @JvmStatic
    public static final void init(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        HandlerThreads.postDelayed(2, new Runnable() { // from class: tv.danmaku.bili.bilow.AppTickets$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AppTickets.init$lambda$0();
            }
        }, 800L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$0() {
        BiliTickets.INSTANCE.init();
    }
}