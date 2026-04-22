package tv.danmaku.bili.freedata.internal.delegate;

import com.bilibili.lib.tf.LogLevel;
import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: TfLog.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.dynamicDurationSt)
public final /* synthetic */ class NaTfDelegate$log$$inlined$logLevel$1$wm$TfLog$Companion$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        int[] iArr = new int[LogLevel.values().length];
        iArr[LogLevel.VERBOSE.ordinal()] = 1;
        iArr[LogLevel.DEBUG.ordinal()] = 2;
        iArr[LogLevel.INFO.ordinal()] = 3;
        iArr[LogLevel.WARNING.ordinal()] = 4;
        iArr[LogLevel.ERROR.ordinal()] = 5;
        iArr[LogLevel.UNRECOGNIZED.ordinal()] = 6;
        $EnumSwitchMapping$0 = iArr;
    }
}