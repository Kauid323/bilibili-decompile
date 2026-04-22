package video.biz.offline.base.facade.model;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.videoplayer.core.media.ijk.IjkFnHelper;
import video.biz.offline.base.model.entity.OfflineVideoEntity;

/* compiled from: OfflinePlayListModel.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b5\b\u0087\b\u0018\u00002\u00020\u0001B±\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u0012\b\b\u0002\u0010\u0010\u001a\u00020\n\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\b\u0012\b\b\u0002\u0010\u0017\u001a\u00020\b\u0012\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0005HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\bHÆ\u0003J\t\u0010=\u001a\u00020\nHÆ\u0003J\t\u0010>\u001a\u00020\nHÆ\u0003J\t\u0010?\u001a\u00020\nHÆ\u0003J\t\u0010@\u001a\u00020\nHÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\nHÆ\u0003J\t\u0010C\u001a\u00020\nHÆ\u0003J\t\u0010D\u001a\u00020\u0012HÆ\u0003J\t\u0010E\u001a\u00020\u0012HÆ\u0003J\t\u0010F\u001a\u00020\u0015HÆ\u0003J\t\u0010G\u001a\u00020\bHÆ\u0003J\t\u0010H\u001a\u00020\bHÆ\u0003J\u000f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019HÆ\u0003J¹\u0001\u0010J\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\b2\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019HÆ\u0001J\u0013\u0010K\u001a\u00020\u00122\b\u0010L\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010M\u001a\u00020\u0003HÖ\u0001J\t\u0010N\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001e\"\u0004\b\"\u0010#R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b(\u0010'R\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b)\u0010'R\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b*\u0010'R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001eR\u0011\u0010\u000f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b,\u0010'R\u0011\u0010\u0010\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b-\u0010'R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010.\"\u0004\b/\u00100R\u001a\u0010\u0013\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010.\"\u0004\b2\u00100R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\u0016\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b5\u0010%R\u0011\u0010\u0017\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b6\u0010%R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\b\n\u0000\u001a\u0004\b7\u00108¨\u0006O"}, d2 = {"Lvideo/biz/offline/base/facade/model/OfflinePlayListModel;", "", "videoAttr", "", "bizType", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$BizType;", "index", "id", "", "bvid", "", RankRouter.BundleKey.ACTION_PARAM_TITLE, "intro", RankRouter.BundleKey.VIDEO_DETAIL_COVER, "duration", "author", "link", "isVip", "", "authPassed", "seasonType", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$SeasonType;", "pubTime", "volume", "videos", "", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "<init>", "(ILvideo/biz/offline/base/model/entity/OfflineVideoEntity$BizType;IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ZZLvideo/biz/offline/base/model/entity/OfflineVideoEntity$SeasonType;JJLjava/util/List;)V", "getVideoAttr", "()I", "getBizType", "()Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$BizType;", "getIndex", "setIndex", "(I)V", "getId", "()J", "getBvid", "()Ljava/lang/String;", "getTitle", "getIntro", "getCover", "getDuration", "getAuthor", "getLink", "()Z", "setVip", "(Z)V", "getAuthPassed", "setAuthPassed", "getSeasonType", "()Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$SeasonType;", "getPubTime", "getVolume", "getVideos", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "equals", "other", "hashCode", "toString", "facade_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflinePlayListModel {
    public static final int $stable = 8;
    private boolean authPassed;
    private final String author;
    private final OfflineVideoEntity.BizType bizType;
    private final String bvid;
    private final String cover;
    private final int duration;
    private final long id;
    private int index;
    private final String intro;
    private boolean isVip;
    private final String link;
    private final long pubTime;
    private final OfflineVideoEntity.SeasonType seasonType;
    private final String title;
    private final int videoAttr;
    private final List<OfflineVideoEntity> videos;
    private final long volume;

    public final int component1() {
        return this.videoAttr;
    }

    public final String component10() {
        return this.author;
    }

    public final String component11() {
        return this.link;
    }

    public final boolean component12() {
        return this.isVip;
    }

    public final boolean component13() {
        return this.authPassed;
    }

    public final OfflineVideoEntity.SeasonType component14() {
        return this.seasonType;
    }

    public final long component15() {
        return this.pubTime;
    }

    public final long component16() {
        return this.volume;
    }

    public final List<OfflineVideoEntity> component17() {
        return this.videos;
    }

    public final OfflineVideoEntity.BizType component2() {
        return this.bizType;
    }

    public final int component3() {
        return this.index;
    }

    public final long component4() {
        return this.id;
    }

    public final String component5() {
        return this.bvid;
    }

    public final String component6() {
        return this.title;
    }

    public final String component7() {
        return this.intro;
    }

    public final String component8() {
        return this.cover;
    }

    public final int component9() {
        return this.duration;
    }

    public final OfflinePlayListModel copy(int i, OfflineVideoEntity.BizType bizType, int i2, long j, String str, String str2, String str3, String str4, int i3, String str5, String str6, boolean z, boolean z2, OfflineVideoEntity.SeasonType seasonType, long j2, long j3, List<OfflineVideoEntity> list) {
        Intrinsics.checkNotNullParameter(bizType, "bizType");
        Intrinsics.checkNotNullParameter(str, "bvid");
        Intrinsics.checkNotNullParameter(str2, RankRouter.BundleKey.ACTION_PARAM_TITLE);
        Intrinsics.checkNotNullParameter(str3, "intro");
        Intrinsics.checkNotNullParameter(str4, RankRouter.BundleKey.VIDEO_DETAIL_COVER);
        Intrinsics.checkNotNullParameter(str5, "author");
        Intrinsics.checkNotNullParameter(str6, "link");
        Intrinsics.checkNotNullParameter(seasonType, "seasonType");
        Intrinsics.checkNotNullParameter(list, "videos");
        return new OfflinePlayListModel(i, bizType, i2, j, str, str2, str3, str4, i3, str5, str6, z, z2, seasonType, j2, j3, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OfflinePlayListModel) {
            OfflinePlayListModel offlinePlayListModel = (OfflinePlayListModel) obj;
            return this.videoAttr == offlinePlayListModel.videoAttr && this.bizType == offlinePlayListModel.bizType && this.index == offlinePlayListModel.index && this.id == offlinePlayListModel.id && Intrinsics.areEqual(this.bvid, offlinePlayListModel.bvid) && Intrinsics.areEqual(this.title, offlinePlayListModel.title) && Intrinsics.areEqual(this.intro, offlinePlayListModel.intro) && Intrinsics.areEqual(this.cover, offlinePlayListModel.cover) && this.duration == offlinePlayListModel.duration && Intrinsics.areEqual(this.author, offlinePlayListModel.author) && Intrinsics.areEqual(this.link, offlinePlayListModel.link) && this.isVip == offlinePlayListModel.isVip && this.authPassed == offlinePlayListModel.authPassed && this.seasonType == offlinePlayListModel.seasonType && this.pubTime == offlinePlayListModel.pubTime && this.volume == offlinePlayListModel.volume && Intrinsics.areEqual(this.videos, offlinePlayListModel.videos);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((this.videoAttr * 31) + this.bizType.hashCode()) * 31) + this.index) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.id)) * 31) + this.bvid.hashCode()) * 31) + this.title.hashCode()) * 31) + this.intro.hashCode()) * 31) + this.cover.hashCode()) * 31) + this.duration) * 31) + this.author.hashCode()) * 31) + this.link.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isVip)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.authPassed)) * 31) + this.seasonType.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.pubTime)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.volume)) * 31) + this.videos.hashCode();
    }

    public String toString() {
        int i = this.videoAttr;
        OfflineVideoEntity.BizType bizType = this.bizType;
        int i2 = this.index;
        long j = this.id;
        String str = this.bvid;
        String str2 = this.title;
        String str3 = this.intro;
        String str4 = this.cover;
        int i3 = this.duration;
        String str5 = this.author;
        String str6 = this.link;
        boolean z = this.isVip;
        boolean z2 = this.authPassed;
        OfflineVideoEntity.SeasonType seasonType = this.seasonType;
        long j2 = this.pubTime;
        long j3 = this.volume;
        return "OfflinePlayListModel(videoAttr=" + i + ", bizType=" + bizType + ", index=" + i2 + ", id=" + j + ", bvid=" + str + ", title=" + str2 + ", intro=" + str3 + ", cover=" + str4 + ", duration=" + i3 + ", author=" + str5 + ", link=" + str6 + ", isVip=" + z + ", authPassed=" + z2 + ", seasonType=" + seasonType + ", pubTime=" + j2 + ", volume=" + j3 + ", videos=" + this.videos + ")";
    }

    public OfflinePlayListModel(int videoAttr, OfflineVideoEntity.BizType bizType, int index, long id, String bvid, String title, String intro, String cover, int duration, String author, String link, boolean isVip, boolean authPassed, OfflineVideoEntity.SeasonType seasonType, long pubTime, long volume, List<OfflineVideoEntity> list) {
        Intrinsics.checkNotNullParameter(bizType, "bizType");
        Intrinsics.checkNotNullParameter(bvid, "bvid");
        Intrinsics.checkNotNullParameter(title, RankRouter.BundleKey.ACTION_PARAM_TITLE);
        Intrinsics.checkNotNullParameter(intro, "intro");
        Intrinsics.checkNotNullParameter(cover, RankRouter.BundleKey.VIDEO_DETAIL_COVER);
        Intrinsics.checkNotNullParameter(author, "author");
        Intrinsics.checkNotNullParameter(link, "link");
        Intrinsics.checkNotNullParameter(seasonType, "seasonType");
        Intrinsics.checkNotNullParameter(list, "videos");
        this.videoAttr = videoAttr;
        this.bizType = bizType;
        this.index = index;
        this.id = id;
        this.bvid = bvid;
        this.title = title;
        this.intro = intro;
        this.cover = cover;
        this.duration = duration;
        this.author = author;
        this.link = link;
        this.isVip = isVip;
        this.authPassed = authPassed;
        this.seasonType = seasonType;
        this.pubTime = pubTime;
        this.volume = volume;
        this.videos = list;
    }

    public /* synthetic */ OfflinePlayListModel(int i, OfflineVideoEntity.BizType bizType, int i2, long j, String str, String str2, String str3, String str4, int i3, String str5, String str6, boolean z, boolean z2, OfflineVideoEntity.SeasonType seasonType, long j2, long j3, List list, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i, bizType, (i4 & 4) != 0 ? 0 : i2, j, (i4 & 16) != 0 ? "" : str, (i4 & 32) != 0 ? "" : str2, (i4 & 64) != 0 ? "" : str3, (i4 & 128) != 0 ? "" : str4, (i4 & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) != 0 ? 0 : i3, (i4 & 512) != 0 ? "" : str5, (i4 & 1024) != 0 ? "" : str6, (i4 & IjkMediaMeta.FF_PROFILE_H264_INTRA) != 0 ? false : z, (i4 & 4096) != 0 ? false : z2, seasonType, (i4 & IjkFnHelper.PLAY_URL_FLAG_HDR_VIVID) != 0 ? 0L : j2, (32768 & i4) != 0 ? 0L : j3, (i4 & 65536) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final int getVideoAttr() {
        return this.videoAttr;
    }

    public final OfflineVideoEntity.BizType getBizType() {
        return this.bizType;
    }

    public final int getIndex() {
        return this.index;
    }

    public final void setIndex(int i) {
        this.index = i;
    }

    public final long getId() {
        return this.id;
    }

    public final String getBvid() {
        return this.bvid;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getIntro() {
        return this.intro;
    }

    public final String getCover() {
        return this.cover;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final String getAuthor() {
        return this.author;
    }

    public final String getLink() {
        return this.link;
    }

    public final boolean isVip() {
        return this.isVip;
    }

    public final void setVip(boolean z) {
        this.isVip = z;
    }

    public final boolean getAuthPassed() {
        return this.authPassed;
    }

    public final void setAuthPassed(boolean z) {
        this.authPassed = z;
    }

    public final OfflineVideoEntity.SeasonType getSeasonType() {
        return this.seasonType;
    }

    public final long getPubTime() {
        return this.pubTime;
    }

    public final long getVolume() {
        return this.volume;
    }

    public final List<OfflineVideoEntity> getVideos() {
        return this.videos;
    }
}