package tv.danmaku.bili.ui.main2.api;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kntr.app.upcomingEpisode.list.model.UnpublishedVideo;
import kntr.app.upcomingEpisode.list.model.VideoUpdateCalendar;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;

/* compiled from: MVideoUpdateCalendar.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010*\u001a\u00020+R,\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R&\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R \u0010!\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R \u0010'\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\r\"\u0004\b)\u0010\u000f¨\u0006,"}, d2 = {"Ltv/danmaku/bili/ui/main2/api/MVideoUpdateCalendar;", "", "<init>", "()V", "reportParams", "", "", "getReportParams", "()Ljava/util/Map;", "setReportParams", "(Ljava/util/Map;)V", ReportUtilKt.POS_TITLE, "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "trackInfo", "getTrackInfo", "setTrackInfo", "type", "", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "unpublishedVideoList", "", "Ltv/danmaku/bili/ui/main2/api/MUnpublishedVideo;", "getUnpublishedVideoList", "()Ljava/util/List;", "setUnpublishedVideoList", "(Ljava/util/List;)V", "unwatchedVideo", "Ltv/danmaku/bili/ui/main2/api/MUnwatchedVideo;", "getUnwatchedVideo", "()Ltv/danmaku/bili/ui/main2/api/MUnwatchedVideo;", "setUnwatchedVideo", "(Ltv/danmaku/bili/ui/main2/api/MUnwatchedVideo;)V", "url", "getUrl", "setUrl", "toK", "Lkntr/app/upcomingEpisode/list/model/VideoUpdateCalendar;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MVideoUpdateCalendar {
    public static final int $stable = 8;
    @JSONField(name = "report_params")
    private Map<String, ? extends Object> reportParams;
    @JSONField(name = ReportUtilKt.POS_TITLE)
    private String title;
    @JSONField(name = "track_info")
    private String trackInfo;
    @JSONField(name = "type")
    private Integer type;
    @JSONField(name = "unpublished_video_list")
    private List<MUnpublishedVideo> unpublishedVideoList;
    @JSONField(name = "unwatched_video")
    private MUnwatchedVideo unwatchedVideo;
    @JSONField(name = "url")
    private String url;

    public final Map<String, Object> getReportParams() {
        return this.reportParams;
    }

    public final void setReportParams(Map<String, ? extends Object> map) {
        this.reportParams = map;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getTrackInfo() {
        return this.trackInfo;
    }

    public final void setTrackInfo(String str) {
        this.trackInfo = str;
    }

    public final Integer getType() {
        return this.type;
    }

    public final void setType(Integer num) {
        this.type = num;
    }

    public final List<MUnpublishedVideo> getUnpublishedVideoList() {
        return this.unpublishedVideoList;
    }

    public final void setUnpublishedVideoList(List<MUnpublishedVideo> list) {
        this.unpublishedVideoList = list;
    }

    public final MUnwatchedVideo getUnwatchedVideo() {
        return this.unwatchedVideo;
    }

    public final void setUnwatchedVideo(MUnwatchedVideo mUnwatchedVideo) {
        this.unwatchedVideo = mUnwatchedVideo;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final VideoUpdateCalendar toK() {
        Map map;
        ArrayList arrayList;
        Map $this$map$iv = this.reportParams;
        if ($this$map$iv != null) {
            Collection destination$iv$iv = new ArrayList($this$map$iv.size());
            for (Map.Entry item$iv$iv : $this$map$iv.entrySet()) {
                String key = item$iv$iv.getKey();
                Object value = item$iv$iv.getValue();
                destination$iv$iv.add(TuplesKt.to(key, value.toString()));
            }
            map = MapsKt.toMap((List) destination$iv$iv);
        } else {
            map = null;
        }
        String str = this.title;
        String str2 = this.trackInfo;
        Integer num = this.type;
        Iterable iterable = this.unpublishedVideoList;
        if (iterable != null) {
            Iterable<MUnpublishedVideo> $this$map$iv2 = iterable;
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
            for (MUnpublishedVideo it : $this$map$iv2) {
                destination$iv$iv2.add(new UnpublishedVideo(it.getTitle(), it.getPrefixTitle()));
                $this$map$iv2 = $this$map$iv2;
            }
            arrayList = (List) destination$iv$iv2;
        } else {
            arrayList = null;
        }
        MUnwatchedVideo mUnwatchedVideo = this.unwatchedVideo;
        return new VideoUpdateCalendar(map, str, str2, num, this.url, arrayList, mUnwatchedVideo != null ? mUnwatchedVideo.toK() : null, false, (int) BR.cover, (DefaultConstructorMarker) null);
    }
}