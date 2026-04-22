package tv.danmaku.bili.videopage.common.segment;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
import com.bilibili.base.BiliContext;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: WindowStateManageSegment.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0002\u0015\u0016B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0006\u0010\u0011\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u000eJ\u0010\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\fR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Ltv/danmaku/bili/videopage/common/segment/SystemGravityHelper;", "Landroid/database/ContentObserver;", "context", "Landroid/content/Context;", "handler", "Landroid/os/Handler;", "<init>", "(Landroid/content/Context;Landroid/os/Handler;)V", "mResolver", "Landroid/content/ContentResolver;", "mChangedListener", "Ljava/lang/ref/WeakReference;", "Ltv/danmaku/bili/videopage/common/segment/SystemGravityHelper$OnSystemGravityChangedListener;", "onChange", "", "selfChange", "", "startObserver", "stopObserver", "setChangedListener", "changedListener", "OnSystemGravityChangedListener", "Companion", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SystemGravityHelper extends ContentObserver {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "SystemGravityHelper";
    private WeakReference<OnSystemGravityChangedListener> mChangedListener;
    private final ContentResolver mResolver;

    /* compiled from: WindowStateManageSegment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0005À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/videopage/common/segment/SystemGravityHelper$OnSystemGravityChangedListener;", "", "onOpen", "", "onClose", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface OnSystemGravityChangedListener {
        void onClose();

        void onOpen();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SystemGravityHelper(Context context, Handler handler) {
        super(handler);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(handler, "handler");
        ContentResolver contentResolver = context.getApplicationContext().getContentResolver();
        Intrinsics.checkNotNullExpressionValue(contentResolver, "getContentResolver(...)");
        this.mResolver = contentResolver;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean selfChange) {
        Application application;
        Context context;
        OnSystemGravityChangedListener onSystemGravityChangedListener;
        OnSystemGravityChangedListener onSystemGravityChangedListener2;
        super.onChange(selfChange);
        if (this.mChangedListener == null || (application = BiliContext.application()) == null || (context = application.getApplicationContext()) == null) {
            return;
        }
        if (Companion.getGravityOpenStatus(context)) {
            WeakReference<OnSystemGravityChangedListener> weakReference = this.mChangedListener;
            if (weakReference == null || (onSystemGravityChangedListener2 = weakReference.get()) == null) {
                return;
            }
            onSystemGravityChangedListener2.onOpen();
            return;
        }
        WeakReference<OnSystemGravityChangedListener> weakReference2 = this.mChangedListener;
        if (weakReference2 == null || (onSystemGravityChangedListener = weakReference2.get()) == null) {
            return;
        }
        onSystemGravityChangedListener.onClose();
    }

    public final void startObserver() {
        this.mResolver.registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this);
    }

    public final void stopObserver() {
        this.mResolver.unregisterContentObserver(this);
    }

    public final void setChangedListener(OnSystemGravityChangedListener changedListener) {
        WeakReference<OnSystemGravityChangedListener> weakReference;
        if (changedListener == null) {
            weakReference = null;
        } else {
            weakReference = new WeakReference<>(changedListener);
        }
        this.mChangedListener = weakReference;
    }

    /* compiled from: WindowStateManageSegment.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/videopage/common/segment/SystemGravityHelper$Companion;", "", "<init>", "()V", "TAG", "", "getGravityOpenStatus", "", "context", "Landroid/content/Context;", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean getGravityOpenStatus(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            int status = 1;
            try {
                status = Settings.System.getInt(context.getContentResolver(), "accelerometer_rotation");
            } catch (Settings.SettingNotFoundException e) {
                BLog.e(SystemGravityHelper.TAG, e);
            }
            BLog.i(SystemGravityHelper.TAG, "Current system gravity state: " + (status != 0));
            return status != 0;
        }
    }
}