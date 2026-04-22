package util;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bilibili.bililive.infra.log.LiveLog;
import com.bilibili.bililive.infra.log.LiveLogDelegate;
import com.bilibili.bililive.infra.log.LiveLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: LiveGiftPanelHeightComputed.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0014\u001a\u00020\u00152\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0017J\u0016\u0010\u0018\u001a\u00020\u00152\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0017J\u000e\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\rJ\u0006\u0010\u001b\u001a\u00020\u0015J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u0006\u0010\u001e\u001a\u00020\u0015R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011¨\u0006 "}, d2 = {"Lutil/LiveGiftPanelHeightComputed;", "Lcom/bilibili/bililive/infra/log/LiveLogger;", "<init>", "()V", "logTag", "", "getLogTag", "()Ljava/lang/String;", "mNeedCountViews", "", "Landroid/view/View;", "mNoNeedCountViews", "mListener", "Lutil/LiveGiftPanelHeightChangedListener;", "mHandler", "Landroid/os/Handler;", "getMHandler", "()Landroid/os/Handler;", "mHandler$delegate", "Lkotlin/Lazy;", "registerNeedCountViews", "", "views", "", "registerNoNeedCountViews", "setGiftPanelHeightChangedListener", "listener", "updateGiftPanelHeight", "calculateGiftPanelHeight", "", "release", "Companion", "giftCommon_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class LiveGiftPanelHeightComputed implements LiveLogger {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "LiveGiftPanelHeightComputed";
    private LiveGiftPanelHeightChangedListener mListener;
    private final List<View> mNeedCountViews = new ArrayList();
    private final List<View> mNoNeedCountViews = new ArrayList();
    private final Lazy mHandler$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0() { // from class: util.LiveGiftPanelHeightComputed$$ExternalSyntheticLambda1
        public final Object invoke() {
            Handler mHandler_delegate$lambda$0;
            mHandler_delegate$lambda$0 = LiveGiftPanelHeightComputed.mHandler_delegate$lambda$0();
            return mHandler_delegate$lambda$0;
        }
    });

    public String getLogTag() {
        return TAG;
    }

    private final Handler getMHandler() {
        return (Handler) this.mHandler$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Handler mHandler_delegate$lambda$0() {
        return new Handler(Looper.getMainLooper());
    }

    public final void registerNeedCountViews(List<? extends View> list) {
        Intrinsics.checkNotNullParameter(list, "views");
        this.mNeedCountViews.addAll(list);
    }

    public final void registerNoNeedCountViews(List<? extends View> list) {
        Intrinsics.checkNotNullParameter(list, "views");
        this.mNoNeedCountViews.addAll(list);
    }

    public final void setGiftPanelHeightChangedListener(LiveGiftPanelHeightChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mListener = listener;
    }

    public final void updateGiftPanelHeight() {
        getMHandler().post(new Runnable() { // from class: util.LiveGiftPanelHeightComputed$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                LiveGiftPanelHeightComputed.this.calculateGiftPanelHeight();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int calculateGiftPanelHeight() {
        String msg$iv$iv$iv$iv;
        String str;
        int newHeight = 0;
        Iterable $this$forEach$iv = this.mNeedCountViews;
        Iterator<T> it = $this$forEach$iv.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object element$iv = it.next();
            View it2 = (View) element$iv;
            if (it2 != null) {
                newHeight += it2.getVisibility() != 8 ? it2.getHeight() : 0;
            }
        }
        Iterable $this$forEach$iv2 = this.mNoNeedCountViews;
        int newHeight2 = newHeight;
        for (Object element$iv2 : $this$forEach$iv2) {
            View it3 = (View) element$iv2;
            if (it3 != null) {
                newHeight2 -= it3.getVisibility() == 8 ? 0 : it3.getHeight();
            }
        }
        LiveGiftPanelHeightComputed $this$logDebug_u24default$iv = this;
        LiveLog.Companion this_$iv$iv = LiveLog.Companion;
        String tag$iv$iv = $this$logDebug_u24default$iv.getLogTag();
        if (this_$iv$iv.isDebug()) {
            try {
                str = "newHeight:" + newHeight2;
            } catch (Exception e$iv$iv$iv) {
                BLog.e("LiveLog", "getLogMessage", e$iv$iv$iv);
                str = null;
            }
            String msg$iv$iv$iv = str;
            String msg$iv$iv$iv2 = msg$iv$iv$iv != null ? msg$iv$iv$iv : "";
            BLog.d(tag$iv$iv, msg$iv$iv$iv2);
            LiveLogDelegate logDelegate = this_$iv$iv.getLogDelegate();
            if (logDelegate != null) {
                LiveLogDelegate.-CC.onLog$default(logDelegate, 4, tag$iv$iv, msg$iv$iv$iv2, (Throwable) null, 8, (Object) null);
            }
        } else if (this_$iv$iv.matchLevel(4) && this_$iv$iv.matchLevel(3)) {
            try {
                msg$iv$iv$iv$iv = "newHeight:" + newHeight2;
            } catch (Exception e$iv$iv$iv$iv) {
                BLog.e("LiveLog", "getLogMessage", e$iv$iv$iv$iv);
                msg$iv$iv$iv$iv = null;
            }
            String msg$iv$iv$iv$iv2 = msg$iv$iv$iv$iv != null ? msg$iv$iv$iv$iv : "";
            LiveLogDelegate logDelegate2 = this_$iv$iv.getLogDelegate();
            if (logDelegate2 != null) {
                LiveLogDelegate.-CC.onLog$default(logDelegate2, 3, tag$iv$iv, msg$iv$iv$iv$iv2, (Throwable) null, 8, (Object) null);
            }
            BLog.i(tag$iv$iv, msg$iv$iv$iv$iv2);
        }
        LiveGiftPanelHeightChangedListener liveGiftPanelHeightChangedListener = this.mListener;
        if (liveGiftPanelHeightChangedListener != null) {
            liveGiftPanelHeightChangedListener.onGiftPanelHeightChanged(newHeight2);
        }
        return newHeight2;
    }

    public final void release() {
        this.mListener = null;
        getMHandler().removeCallbacksAndMessages(null);
        this.mNeedCountViews.clear();
        this.mNoNeedCountViews.clear();
    }

    /* compiled from: LiveGiftPanelHeightComputed.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lutil/LiveGiftPanelHeightComputed$Companion;", "", "<init>", "()V", "TAG", "", "giftCommon_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}