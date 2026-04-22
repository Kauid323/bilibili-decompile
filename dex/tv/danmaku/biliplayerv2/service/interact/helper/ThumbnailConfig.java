package tv.danmaku.biliplayerv2.service.interact.helper;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ThumbnailConfig.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/helper/ThumbnailConfig;", "", "bitmapCrop", "", "durationConstraint", "Ltv/danmaku/biliplayerv2/service/interact/helper/DurationConstraint;", "content", "", "<init>", "(ZLtv/danmaku/biliplayerv2/service/interact/helper/DurationConstraint;Ljava/lang/String;)V", "getBitmapCrop", "()Z", "getDurationConstraint", "()Ltv/danmaku/biliplayerv2/service/interact/helper/DurationConstraint;", "getContent", "()Ljava/lang/String;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ThumbnailConfig {
    private final boolean bitmapCrop;
    private final String content;
    private final DurationConstraint durationConstraint;

    public ThumbnailConfig(boolean bitmapCrop, DurationConstraint durationConstraint, String content) {
        Intrinsics.checkNotNullParameter(durationConstraint, "durationConstraint");
        Intrinsics.checkNotNullParameter(content, "content");
        this.bitmapCrop = bitmapCrop;
        this.durationConstraint = durationConstraint;
        this.content = content;
    }

    public final boolean getBitmapCrop() {
        return this.bitmapCrop;
    }

    public final DurationConstraint getDurationConstraint() {
        return this.durationConstraint;
    }

    public final String getContent() {
        return this.content;
    }
}