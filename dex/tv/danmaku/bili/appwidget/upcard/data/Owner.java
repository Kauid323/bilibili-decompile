package tv.danmaku.bili.appwidget.upcard.data;

import com.alibaba.fastjson.annotation.JSONField;
import kotlin.Metadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.router.ChannelRoutes;

/* compiled from: UpCardWidgetData.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010¨\u0006\u0014"}, d2 = {"Ltv/danmaku/bili/appwidget/upcard/data/Owner;", "", "<init>", "()V", "mid", "", "getMid", "()Ljava/lang/Long;", "setMid", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", ChannelRoutes.CHANNEL_NAME, "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "face", "getFace", "setFace", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class Owner {
    public static final int $stable = 8;
    @JSONField(name = "face")
    private String face;
    @JSONField(name = "mid")
    private Long mid;
    @JSONField(name = ChannelRoutes.CHANNEL_NAME)
    private String name;

    public final Long getMid() {
        return this.mid;
    }

    public final void setMid(Long l) {
        this.mid = l;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getFace() {
        return this.face;
    }

    public final void setFace(String str) {
        this.face = str;
    }
}