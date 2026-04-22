package tv.danmaku.bili.ui.garb.nft.helper;

import com.bilibili.bililive.uam.config.IUAMConfig;
import com.bilibili.bililive.uam.view.UAMViewListener;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* compiled from: SimpleUAMListener.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\b\u0017\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\rH\u0016J\u0018\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\rH\u0016¨\u0006\u0016"}, d2 = {"Ltv/danmaku/bili/ui/garb/nft/helper/SimpleUAMListener;", "Lcom/bilibili/bililive/uam/view/UAMViewListener;", "<init>", "()V", "onInnerSurfaceStatusChanged", "", "isAvailable", "", "onConfigParseFinish", "config", "Lcom/bilibili/bililive/uam/config/IUAMConfig;", "onVideoFormatReadFinish", "mime", "", "onPlayStart", "onPlayFinish", "onBeforeRenderFailed", LoginReporterV2.Show.SIGNUP_KEY_CODE, "", "message", "onPlayFailed", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public class SimpleUAMListener implements UAMViewListener {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final String TAG = Reflection.getOrCreateKotlinClass(SimpleUAMListener.class).getSimpleName();

    /* compiled from: SimpleUAMListener.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/ui/garb/nft/helper/SimpleUAMListener$Companion;", "", "<init>", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG() {
            return SimpleUAMListener.TAG;
        }
    }

    public void onInnerSurfaceStatusChanged(boolean isAvailable) {
        BLog.d(TAG, "load card anim onInnerSurfaceStatusChanged " + isAvailable);
    }

    public void onConfigParseFinish(IUAMConfig config) {
        BLog.d(TAG, "load card anim onConfigParseFinish");
    }

    public void onVideoFormatReadFinish(String mime) {
        BLog.d(TAG, "load card anim onVideoFormatReadFinish");
    }

    public void onPlayStart() {
        BLog.d(TAG, "load card anim onPlayStart");
    }

    public void onPlayFinish() {
        BLog.i(TAG, "load card anim onPlayFinish");
    }

    public void onBeforeRenderFailed(int code, String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        BLog.w(TAG, "load card anim onBeforeRenderFailed");
    }

    public void onPlayFailed(int code, String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        BLog.w(TAG, "load card anim onPlayFailed, " + code + ", msg: " + message);
    }
}