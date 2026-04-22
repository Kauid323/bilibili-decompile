package tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: LocalServiceHandler.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0012\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/local/OfflineDanmakus;", "", "<init>", "()V", "avid", "", "getAvid", "()Ljava/lang/String;", "setAvid", "(Ljava/lang/String;)V", "cid", "getCid", "setCid", IjkMediaMeta.IJKM_KEY_FORMAT, "getFormat", "setFormat", "danmakus", "", "getDanmakus", "()[B", "setDanmakus", "([B)V", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineDanmakus {
    private String avid;
    private String cid;
    private byte[] danmakus;
    private String format = "XML";

    public final String getAvid() {
        return this.avid;
    }

    public final void setAvid(String str) {
        this.avid = str;
    }

    public final String getCid() {
        return this.cid;
    }

    public final void setCid(String str) {
        this.cid = str;
    }

    public final String getFormat() {
        return this.format;
    }

    public final void setFormat(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.format = str;
    }

    public final byte[] getDanmakus() {
        return this.danmakus;
    }

    public final void setDanmakus(byte[] bArr) {
        this.danmakus = bArr;
    }
}