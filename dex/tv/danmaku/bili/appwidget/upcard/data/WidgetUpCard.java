package tv.danmaku.bili.appwidget.upcard.data;

import com.alibaba.fastjson.annotation.JSONField;
import kotlin.Metadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* compiled from: UpCardWidgetData.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR \u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR \u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\"\u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\u001d\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0007\"\u0004\b\u001f\u0010\tR \u0010 \u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006&"}, d2 = {"Ltv/danmaku/bili/appwidget/upcard/data/WidgetUpCard;", "", "<init>", "()V", ReportUtilKt.POS_TITLE, "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "goTo", "getGoTo", "setGoTo", AudioIntentHelper.ARGS_URI, "getUri", "setUri", ReportUtilKt.POS_COVER, "getCover", "setCover", "cover43", "getCover43", "setCover43", "avId", "", "getAvId", "()Ljava/lang/Long;", "setAvId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "duration", "getDuration", "setDuration", "owner", "Ltv/danmaku/bili/appwidget/upcard/data/Owner;", "getOwner", "()Ltv/danmaku/bili/appwidget/upcard/data/Owner;", "setOwner", "(Ltv/danmaku/bili/appwidget/upcard/data/Owner;)V", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class WidgetUpCard {
    public static final int $stable = 8;
    @JSONField(name = "av_id")
    private Long avId;
    @JSONField(name = ReportUtilKt.POS_COVER)
    private String cover;
    @JSONField(name = "cover43")
    private String cover43;
    @JSONField(name = "duration")
    private String duration;
    @JSONField(name = "goto")
    private String goTo;
    @JSONField(name = "owner")
    private Owner owner;
    @JSONField(name = ReportUtilKt.POS_TITLE)
    private String title;
    @JSONField(name = AudioIntentHelper.ARGS_URI)
    private String uri;

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getGoTo() {
        return this.goTo;
    }

    public final void setGoTo(String str) {
        this.goTo = str;
    }

    public final String getUri() {
        return this.uri;
    }

    public final void setUri(String str) {
        this.uri = str;
    }

    public final String getCover() {
        return this.cover;
    }

    public final void setCover(String str) {
        this.cover = str;
    }

    public final String getCover43() {
        return this.cover43;
    }

    public final void setCover43(String str) {
        this.cover43 = str;
    }

    public final Long getAvId() {
        return this.avId;
    }

    public final void setAvId(Long l) {
        this.avId = l;
    }

    public final String getDuration() {
        return this.duration;
    }

    public final void setDuration(String str) {
        this.duration = str;
    }

    public final Owner getOwner() {
        return this.owner;
    }

    public final void setOwner(Owner owner) {
        this.owner = owner;
    }
}