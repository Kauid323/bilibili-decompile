package video.base.utils;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: StriingExt.android.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0016\u0010\u0002\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\u0003\"\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {IjkMediaMeta.IJKM_KEY_FORMAT, "", "args", "", "", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "base_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class StriingExt_androidKt {
    public static final String format(String $this$format, Object... args) {
        Intrinsics.checkNotNullParameter($this$format, "<this>");
        Intrinsics.checkNotNullParameter(args, "args");
        String format = String.format($this$format, Arrays.copyOf(args, args.length));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }
}