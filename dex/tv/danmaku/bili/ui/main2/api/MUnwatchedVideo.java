package tv.danmaku.bili.ui.main2.api;

import com.alibaba.fastjson.annotation.JSONField;
import kntr.app.upcomingEpisode.list.model.UnwatchedVideo;
import kotlin.Metadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;

/* compiled from: MVideoUpdateCalendar.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u001c\u001a\u00020\u001dR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR \u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR \u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR \u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR \u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\t¨\u0006\u001e"}, d2 = {"Ltv/danmaku/bili/ui/main2/api/MUnwatchedVideo;", "", "<init>", "()V", ReportUtilKt.POS_COVER, "", "getCover", "()Ljava/lang/String;", "setCover", "(Ljava/lang/String;)V", ReportUtilKt.POS_TITLE, "getTitle", "setTitle", "upIcon", "getUpIcon", "setUpIcon", "upName", "getUpName", "setUpName", "updateTime", "getUpdateTime", "setUpdateTime", "url", "getUrl", "setUrl", "videoDuration", "getVideoDuration", "setVideoDuration", "toK", "Lkntr/app/upcomingEpisode/list/model/UnwatchedVideo;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MUnwatchedVideo {
    public static final int $stable = 8;
    @JSONField(name = ReportUtilKt.POS_COVER)
    private String cover;
    @JSONField(name = ReportUtilKt.POS_TITLE)
    private String title;
    @JSONField(name = "up_icon")
    private String upIcon;
    @JSONField(name = "up_name")
    private String upName;
    @JSONField(name = "update_time")
    private String updateTime;
    @JSONField(name = "url")
    private String url;
    @JSONField(name = "video_duration")
    private String videoDuration;

    public final String getCover() {
        return this.cover;
    }

    public final void setCover(String str) {
        this.cover = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getUpIcon() {
        return this.upIcon;
    }

    public final void setUpIcon(String str) {
        this.upIcon = str;
    }

    public final String getUpName() {
        return this.upName;
    }

    public final void setUpName(String str) {
        this.upName = str;
    }

    public final String getUpdateTime() {
        return this.updateTime;
    }

    public final void setUpdateTime(String str) {
        this.updateTime = str;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final String getVideoDuration() {
        return this.videoDuration;
    }

    public final void setVideoDuration(String str) {
        this.videoDuration = str;
    }

    public final UnwatchedVideo toK() {
        return new UnwatchedVideo(this.cover, this.title, this.upIcon, this.upName, this.updateTime, this.url, this.videoDuration, Integer.valueOf(hashCode()));
    }
}