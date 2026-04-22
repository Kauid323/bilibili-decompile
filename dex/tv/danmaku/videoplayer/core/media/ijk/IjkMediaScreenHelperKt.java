package tv.danmaku.videoplayer.core.media.ijk;

import android.view.WindowManager;
import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaScreenInfo;

/* compiled from: IjkMediaScreenHelper.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\"\u001b\u0010\u0000\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\"\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t\"\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\r8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u000e\u0010\u0011\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"ijkMediaScreenInfo", "Ltv/danmaku/ijk/media/player/IjkMediaScreenInfo;", "getIjkMediaScreenInfo", "()Ltv/danmaku/ijk/media/player/IjkMediaScreenInfo;", "ijkMediaScreenInfo$delegate", "Lkotlin/Lazy;", "ijkMediaScreenLongEdge", "", "getIjkMediaScreenLongEdge", "()I", "ijkMediaScreenShortEdge", "getIjkMediaScreenShortEdge", "ijkMediaScreenEdgeList", "", "", "getIjkMediaScreenEdgeList", "()Ljava/util/Map;", "TAG", "EXTRA_CONTENT_KEY_LONG_EDGE", "EXTRA_CONTENT_KEY_SHORT_EDGE", "playercore_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class IjkMediaScreenHelperKt {
    public static final String EXTRA_CONTENT_KEY_LONG_EDGE = "long_edge";
    public static final String EXTRA_CONTENT_KEY_SHORT_EDGE = "short_edge";
    private static final String TAG = "IjkMediaScreenHelper";
    private static final Lazy ijkMediaScreenInfo$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.videoplayer.core.media.ijk.IjkMediaScreenHelperKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            IjkMediaScreenInfo ijkMediaScreenInfo_delegate$lambda$0;
            ijkMediaScreenInfo_delegate$lambda$0 = IjkMediaScreenHelperKt.ijkMediaScreenInfo_delegate$lambda$0();
            return ijkMediaScreenInfo_delegate$lambda$0;
        }
    });
    private static final int ijkMediaScreenLongEdge = getIjkMediaScreenInfo().screenHeight;
    private static final int ijkMediaScreenShortEdge = getIjkMediaScreenInfo().screenWidth;

    public static final IjkMediaScreenInfo getIjkMediaScreenInfo() {
        Object value = ijkMediaScreenInfo$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (IjkMediaScreenInfo) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IjkMediaScreenInfo ijkMediaScreenInfo_delegate$lambda$0() {
        IjkMediaScreenInfo it = IjkMediaScreenInfo.getScreenInfo((WindowManager) FoundationAlias.getFapp().getSystemService("window"));
        int i = it.screenHeight;
        BLog.i(TAG, "ijkMediaScreenInfo height: " + i + " width: " + it.screenWidth);
        return it;
    }

    public static final int getIjkMediaScreenLongEdge() {
        return ijkMediaScreenLongEdge;
    }

    public static final int getIjkMediaScreenShortEdge() {
        return ijkMediaScreenShortEdge;
    }

    public static final Map<String, String> getIjkMediaScreenEdgeList() {
        Map map = new HashMap();
        map.put(EXTRA_CONTENT_KEY_LONG_EDGE, String.valueOf(ijkMediaScreenLongEdge));
        map.put(EXTRA_CONTENT_KEY_SHORT_EDGE, String.valueOf(ijkMediaScreenShortEdge));
        return EnhancedUnmodifiabilityKt.unmodifiable(map);
    }
}