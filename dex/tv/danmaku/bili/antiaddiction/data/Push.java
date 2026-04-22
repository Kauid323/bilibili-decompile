package tv.danmaku.bili.antiaddiction.data;

import com.alibaba.fastjson.annotation.JSONField;
import kotlin.Metadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;

/* compiled from: SleepRemindData.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001e\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u00020 8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R \u0010%\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0007\"\u0004\b'\u0010\tR \u0010(\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0007\"\u0004\b*\u0010\t¨\u0006+"}, d2 = {"Ltv/danmaku/bili/antiaddiction/data/Push;", "", "<init>", "()V", ReportUtilKt.POS_TITLE, "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "summary", "getSummary", "setSummary", "img", "getImg", "setImg", "position", "", "getPosition", "()I", "setPosition", "(I)V", "duration", "getDuration", "setDuration", "expire", "", "getExpire", "()J", "setExpire", "(J)V", "hide_arrow", "", "getHide_arrow", "()Z", "setHide_arrow", "(Z)V", "link", "getLink", "setLink", "msg_source", "getMsg_source", "setMsg_source", "antiaddiction_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class Push {
    @JSONField(name = "expire")
    private long expire;
    @JSONField(name = "hide_arrow")
    private boolean hide_arrow;
    @JSONField(name = "img")
    private String img;
    @JSONField(name = "link")
    private String link;
    @JSONField(name = "msg_source")
    private String msg_source;
    @JSONField(name = "summary")
    private String summary;
    @JSONField(name = ReportUtilKt.POS_TITLE)
    private String title;
    @JSONField(name = "position")
    private int position = 1;
    @JSONField(name = "duration")
    private int duration = 3;

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final void setSummary(String str) {
        this.summary = str;
    }

    public final String getImg() {
        return this.img;
    }

    public final void setImg(String str) {
        this.img = str;
    }

    public final int getPosition() {
        return this.position;
    }

    public final void setPosition(int i) {
        this.position = i;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final void setDuration(int i) {
        this.duration = i;
    }

    public final long getExpire() {
        return this.expire;
    }

    public final void setExpire(long j) {
        this.expire = j;
    }

    public final boolean getHide_arrow() {
        return this.hide_arrow;
    }

    public final void setHide_arrow(boolean z) {
        this.hide_arrow = z;
    }

    public final String getLink() {
        return this.link;
    }

    public final void setLink(String str) {
        this.link = str;
    }

    public final String getMsg_source() {
        return this.msg_source;
    }

    public final void setMsg_source(String str) {
        this.msg_source = str;
    }
}