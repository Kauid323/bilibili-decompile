package video.biz.offline.base.model.model;

import ComposableSingletons$CustomBottomSheetKt$;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.videoplayer.core.media.ijk.IjkFnHelper;
import video.biz.offline.base.model.entity.OfflineVideoEntity;

/* compiled from: ResolveModel.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b5\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 d2\u00020\u0001:\u0002cdB·\u0001\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u000b\u0012\u0006\u0010\u0019\u001a\u00020\u000b\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u0003¢\u0006\u0004\b\u001d\u0010\u001eBß\u0001\b\u0010\u0012\u0006\u0010\u001f\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u000b\u0012\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\b\u0010 \u001a\u0004\u0018\u00010!¢\u0006\u0004\b\u001d\u0010\"J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0005HÆ\u0003J\t\u0010B\u001a\u00020\u0005HÆ\u0003J\t\u0010C\u001a\u00020\u0005HÆ\u0003J\t\u0010D\u001a\u00020\u0005HÆ\u0003J\t\u0010E\u001a\u00020\u0005HÆ\u0003J\t\u0010F\u001a\u00020\u000bHÆ\u0003J\t\u0010G\u001a\u00020\u000bHÆ\u0003J\t\u0010H\u001a\u00020\u000bHÆ\u0003J\t\u0010I\u001a\u00020\u000bHÆ\u0003J\t\u0010J\u001a\u00020\u000bHÆ\u0003J\t\u0010K\u001a\u00020\u0005HÆ\u0003J\t\u0010L\u001a\u00020\u000bHÆ\u0003J\t\u0010M\u001a\u00020\u0013HÆ\u0003J\t\u0010N\u001a\u00020\u0005HÆ\u0003J\t\u0010O\u001a\u00020\u0005HÆ\u0003J\t\u0010P\u001a\u00020\u0017HÆ\u0003J\t\u0010Q\u001a\u00020\u000bHÆ\u0003J\t\u0010R\u001a\u00020\u000bHÆ\u0003J\u000f\u0010S\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001bHÆ\u0003J\t\u0010T\u001a\u00020\u0003HÆ\u0003Já\u0001\u0010U\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u000b2\b\b\u0002\u0010\u0019\u001a\u00020\u000b2\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u0003HÆ\u0001J\u0013\u0010V\u001a\u00020W2\b\u0010X\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010Y\u001a\u00020\u0003HÖ\u0001J\t\u0010Z\u001a\u00020\u000bHÖ\u0001J%\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020\u00002\u0006\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020aH\u0001¢\u0006\u0002\bbR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010&R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010&R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010&R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010&R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b-\u0010,R\u0011\u0010\r\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b.\u0010,R\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b/\u0010,R\u0011\u0010\u000f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b0\u0010,R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u0010&R\u0011\u0010\u0011\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b2\u0010,R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u0010&R\u0011\u0010\u0015\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b6\u0010&R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0011\u0010\u0018\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b9\u0010,R\u0011\u0010\u0019\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b:\u0010,R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001b¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u001a\u0010\u001c\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010$\"\u0004\b>\u0010?¨\u0006e"}, d2 = {"Lvideo/biz/offline/base/model/model/VideoInfo;", "", "videoAttr", "", "groupId", "", "aid", "cid", "seasonId", "episodeId", "bvId", "", "groupTitle", "videoTitle", "pageTitle", "author", "authorMid", RankRouter.BundleKey.VIDEO_DETAIL_COVER, "biz", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$BizType;", "videoIndex", "pageIndex", "seasonType", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$SeasonType;", "fromScene", "extended", "epSortedIds", "", "epStatus", "<init>", "(IJJJJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$BizType;JJLvideo/biz/offline/base/model/entity/OfflineVideoEntity$SeasonType;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;I)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIJJJJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$BizType;JJLvideo/biz/offline/base/model/entity/OfflineVideoEntity$SeasonType;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getVideoAttr", "()I", "getGroupId", "()J", "getAid", "getCid", "getSeasonId", "getEpisodeId", "getBvId", "()Ljava/lang/String;", "getGroupTitle", "getVideoTitle", "getPageTitle", "getAuthor", "getAuthorMid", "getCover", "getBiz", "()Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$BizType;", "getVideoIndex", "getPageIndex", "getSeasonType", "()Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$SeasonType;", "getFromScene", "getExtended", "getEpSortedIds", "()Ljava/util/List;", "getEpStatus", "setEpStatus", "(I)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$model_debug", "$serializer", "Companion", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@Serializable
public final class VideoInfo {
    private final long aid;
    private final String author;
    private final long authorMid;
    private final OfflineVideoEntity.BizType biz;
    private final String bvId;
    private final long cid;
    private final String cover;
    private final List<String> epSortedIds;
    private int epStatus;
    private final long episodeId;
    private final String extended;
    private final String fromScene;
    private final long groupId;
    private final String groupTitle;
    private final long pageIndex;
    private final String pageTitle;
    private final long seasonId;
    private final OfflineVideoEntity.SeasonType seasonType;
    private final int videoAttr;
    private final long videoIndex;
    private final String videoTitle;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, null, null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: video.biz.offline.base.model.model.VideoInfo$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = VideoInfo._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: video.biz.offline.base.model.model.VideoInfo$$ExternalSyntheticLambda1
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$0;
            _childSerializers$_anonymous_$0 = VideoInfo._childSerializers$_anonymous_$0();
            return _childSerializers$_anonymous_$0;
        }
    }), null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: video.biz.offline.base.model.model.VideoInfo$$ExternalSyntheticLambda2
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$1;
            _childSerializers$_anonymous_$1 = VideoInfo._childSerializers$_anonymous_$1();
            return _childSerializers$_anonymous_$1;
        }
    }), null};

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VideoInfo copy$default(VideoInfo videoInfo, int i, long j, long j2, long j3, long j4, long j5, String str, String str2, String str3, String str4, String str5, long j6, String str6, OfflineVideoEntity.BizType bizType, long j7, long j8, OfflineVideoEntity.SeasonType seasonType, String str7, String str8, List list, int i2, int i3, Object obj) {
        int i4 = (i3 & 1) != 0 ? videoInfo.videoAttr : i;
        long j9 = (i3 & 2) != 0 ? videoInfo.groupId : j;
        long j10 = (i3 & 4) != 0 ? videoInfo.aid : j2;
        long j11 = (i3 & 8) != 0 ? videoInfo.cid : j3;
        long j12 = (i3 & 16) != 0 ? videoInfo.seasonId : j4;
        long j13 = (i3 & 32) != 0 ? videoInfo.episodeId : j5;
        String str9 = (i3 & 64) != 0 ? videoInfo.bvId : str;
        String str10 = (i3 & 128) != 0 ? videoInfo.groupTitle : str2;
        return videoInfo.copy(i4, j9, j10, j11, j12, j13, str9, str10, (i3 & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) != 0 ? videoInfo.videoTitle : str3, (i3 & 512) != 0 ? videoInfo.pageTitle : str4, (i3 & 1024) != 0 ? videoInfo.author : str5, (i3 & IjkMediaMeta.FF_PROFILE_H264_INTRA) != 0 ? videoInfo.authorMid : j6, (i3 & 4096) != 0 ? videoInfo.cover : str6, (i3 & 8192) != 0 ? videoInfo.biz : bizType, (i3 & IjkFnHelper.PLAY_URL_FLAG_HDR_VIVID) != 0 ? videoInfo.videoIndex : j7, (i3 & 32768) != 0 ? videoInfo.pageIndex : j8, (i3 & 65536) != 0 ? videoInfo.seasonType : seasonType, (131072 & i3) != 0 ? videoInfo.fromScene : str7, (i3 & 262144) != 0 ? videoInfo.extended : str8, (i3 & 524288) != 0 ? videoInfo.epSortedIds : list, (i3 & 1048576) != 0 ? videoInfo.epStatus : i2);
    }

    public final int component1() {
        return this.videoAttr;
    }

    public final String component10() {
        return this.pageTitle;
    }

    public final String component11() {
        return this.author;
    }

    public final long component12() {
        return this.authorMid;
    }

    public final String component13() {
        return this.cover;
    }

    public final OfflineVideoEntity.BizType component14() {
        return this.biz;
    }

    public final long component15() {
        return this.videoIndex;
    }

    public final long component16() {
        return this.pageIndex;
    }

    public final OfflineVideoEntity.SeasonType component17() {
        return this.seasonType;
    }

    public final String component18() {
        return this.fromScene;
    }

    public final String component19() {
        return this.extended;
    }

    public final long component2() {
        return this.groupId;
    }

    public final List<String> component20() {
        return this.epSortedIds;
    }

    public final int component21() {
        return this.epStatus;
    }

    public final long component3() {
        return this.aid;
    }

    public final long component4() {
        return this.cid;
    }

    public final long component5() {
        return this.seasonId;
    }

    public final long component6() {
        return this.episodeId;
    }

    public final String component7() {
        return this.bvId;
    }

    public final String component8() {
        return this.groupTitle;
    }

    public final String component9() {
        return this.videoTitle;
    }

    public final VideoInfo copy(int i, long j, long j2, long j3, long j4, long j5, String str, String str2, String str3, String str4, String str5, long j6, String str6, OfflineVideoEntity.BizType bizType, long j7, long j8, OfflineVideoEntity.SeasonType seasonType, String str7, String str8, List<String> list, int i2) {
        Intrinsics.checkNotNullParameter(str, "bvId");
        Intrinsics.checkNotNullParameter(str2, "groupTitle");
        Intrinsics.checkNotNullParameter(str3, "videoTitle");
        Intrinsics.checkNotNullParameter(str4, "pageTitle");
        Intrinsics.checkNotNullParameter(str5, "author");
        Intrinsics.checkNotNullParameter(str6, RankRouter.BundleKey.VIDEO_DETAIL_COVER);
        Intrinsics.checkNotNullParameter(bizType, "biz");
        Intrinsics.checkNotNullParameter(seasonType, "seasonType");
        Intrinsics.checkNotNullParameter(str7, "fromScene");
        Intrinsics.checkNotNullParameter(str8, "extended");
        Intrinsics.checkNotNullParameter(list, "epSortedIds");
        return new VideoInfo(i, j, j2, j3, j4, j5, str, str2, str3, str4, str5, j6, str6, bizType, j7, j8, seasonType, str7, str8, list, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof VideoInfo) {
            VideoInfo videoInfo = (VideoInfo) obj;
            return this.videoAttr == videoInfo.videoAttr && this.groupId == videoInfo.groupId && this.aid == videoInfo.aid && this.cid == videoInfo.cid && this.seasonId == videoInfo.seasonId && this.episodeId == videoInfo.episodeId && Intrinsics.areEqual(this.bvId, videoInfo.bvId) && Intrinsics.areEqual(this.groupTitle, videoInfo.groupTitle) && Intrinsics.areEqual(this.videoTitle, videoInfo.videoTitle) && Intrinsics.areEqual(this.pageTitle, videoInfo.pageTitle) && Intrinsics.areEqual(this.author, videoInfo.author) && this.authorMid == videoInfo.authorMid && Intrinsics.areEqual(this.cover, videoInfo.cover) && this.biz == videoInfo.biz && this.videoIndex == videoInfo.videoIndex && this.pageIndex == videoInfo.pageIndex && this.seasonType == videoInfo.seasonType && Intrinsics.areEqual(this.fromScene, videoInfo.fromScene) && Intrinsics.areEqual(this.extended, videoInfo.extended) && Intrinsics.areEqual(this.epSortedIds, videoInfo.epSortedIds) && this.epStatus == videoInfo.epStatus;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((this.videoAttr * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.groupId)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.aid)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.cid)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.seasonId)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.episodeId)) * 31) + this.bvId.hashCode()) * 31) + this.groupTitle.hashCode()) * 31) + this.videoTitle.hashCode()) * 31) + this.pageTitle.hashCode()) * 31) + this.author.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.authorMid)) * 31) + this.cover.hashCode()) * 31) + this.biz.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.videoIndex)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.pageIndex)) * 31) + this.seasonType.hashCode()) * 31) + this.fromScene.hashCode()) * 31) + this.extended.hashCode()) * 31) + this.epSortedIds.hashCode()) * 31) + this.epStatus;
    }

    public String toString() {
        int i = this.videoAttr;
        long j = this.groupId;
        long j2 = this.aid;
        long j3 = this.cid;
        long j4 = this.seasonId;
        long j5 = this.episodeId;
        String str = this.bvId;
        String str2 = this.groupTitle;
        String str3 = this.videoTitle;
        String str4 = this.pageTitle;
        String str5 = this.author;
        long j6 = this.authorMid;
        String str6 = this.cover;
        OfflineVideoEntity.BizType bizType = this.biz;
        long j7 = this.videoIndex;
        long j8 = this.pageIndex;
        OfflineVideoEntity.SeasonType seasonType = this.seasonType;
        String str7 = this.fromScene;
        String str8 = this.extended;
        List<String> list = this.epSortedIds;
        return "VideoInfo(videoAttr=" + i + ", groupId=" + j + ", aid=" + j2 + ", cid=" + j3 + ", seasonId=" + j4 + ", episodeId=" + j5 + ", bvId=" + str + ", groupTitle=" + str2 + ", videoTitle=" + str3 + ", pageTitle=" + str4 + ", author=" + str5 + ", authorMid=" + j6 + ", cover=" + str6 + ", biz=" + bizType + ", videoIndex=" + j7 + ", pageIndex=" + j8 + ", seasonType=" + seasonType + ", fromScene=" + str7 + ", extended=" + str8 + ", epSortedIds=" + list + ", epStatus=" + this.epStatus + ")";
    }

    /* compiled from: ResolveModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lvideo/biz/offline/base/model/model/VideoInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lvideo/biz/offline/base/model/model/VideoInfo;", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<VideoInfo> serializer() {
            return VideoInfo$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ VideoInfo(int seen0, int videoAttr, long groupId, long aid, long cid, long seasonId, long episodeId, String bvId, String groupTitle, String videoTitle, String pageTitle, String author, long authorMid, String cover, OfflineVideoEntity.BizType biz, long videoIndex, long pageIndex, OfflineVideoEntity.SeasonType seasonType, String fromScene, String extended, List epSortedIds, int epStatus, SerializationConstructorMarker serializationConstructorMarker) {
        if (2097151 != (seen0 & 2097151)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 2097151, VideoInfo$$serializer.INSTANCE.getDescriptor());
        }
        this.videoAttr = videoAttr;
        this.groupId = groupId;
        this.aid = aid;
        this.cid = cid;
        this.seasonId = seasonId;
        this.episodeId = episodeId;
        this.bvId = bvId;
        this.groupTitle = groupTitle;
        this.videoTitle = videoTitle;
        this.pageTitle = pageTitle;
        this.author = author;
        this.authorMid = authorMid;
        this.cover = cover;
        this.biz = biz;
        this.videoIndex = videoIndex;
        this.pageIndex = pageIndex;
        this.seasonType = seasonType;
        this.fromScene = fromScene;
        this.extended = extended;
        this.epSortedIds = epSortedIds;
        this.epStatus = epStatus;
    }

    public VideoInfo(int videoAttr, long groupId, long aid, long cid, long seasonId, long episodeId, String bvId, String groupTitle, String videoTitle, String pageTitle, String author, long authorMid, String cover, OfflineVideoEntity.BizType biz, long videoIndex, long pageIndex, OfflineVideoEntity.SeasonType seasonType, String fromScene, String extended, List<String> list, int epStatus) {
        Intrinsics.checkNotNullParameter(bvId, "bvId");
        Intrinsics.checkNotNullParameter(groupTitle, "groupTitle");
        Intrinsics.checkNotNullParameter(videoTitle, "videoTitle");
        Intrinsics.checkNotNullParameter(pageTitle, "pageTitle");
        Intrinsics.checkNotNullParameter(author, "author");
        Intrinsics.checkNotNullParameter(cover, RankRouter.BundleKey.VIDEO_DETAIL_COVER);
        Intrinsics.checkNotNullParameter(biz, "biz");
        Intrinsics.checkNotNullParameter(seasonType, "seasonType");
        Intrinsics.checkNotNullParameter(fromScene, "fromScene");
        Intrinsics.checkNotNullParameter(extended, "extended");
        Intrinsics.checkNotNullParameter(list, "epSortedIds");
        this.videoAttr = videoAttr;
        this.groupId = groupId;
        this.aid = aid;
        this.cid = cid;
        this.seasonId = seasonId;
        this.episodeId = episodeId;
        this.bvId = bvId;
        this.groupTitle = groupTitle;
        this.videoTitle = videoTitle;
        this.pageTitle = pageTitle;
        this.author = author;
        this.authorMid = authorMid;
        this.cover = cover;
        this.biz = biz;
        this.videoIndex = videoIndex;
        this.pageIndex = pageIndex;
        this.seasonType = seasonType;
        this.fromScene = fromScene;
        this.extended = extended;
        this.epSortedIds = list;
        this.epStatus = epStatus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return EnumsKt.createSimpleEnumSerializer("video.biz.offline.base.model.entity.OfflineVideoEntity.BizType", OfflineVideoEntity.BizType.values());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return EnumsKt.createSimpleEnumSerializer("video.biz.offline.base.model.entity.OfflineVideoEntity.SeasonType", OfflineVideoEntity.SeasonType.values());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
        return new ArrayListSerializer(StringSerializer.INSTANCE);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$model_debug(VideoInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        output.encodeIntElement(serialDesc, 0, self.videoAttr);
        output.encodeLongElement(serialDesc, 1, self.groupId);
        output.encodeLongElement(serialDesc, 2, self.aid);
        output.encodeLongElement(serialDesc, 3, self.cid);
        output.encodeLongElement(serialDesc, 4, self.seasonId);
        output.encodeLongElement(serialDesc, 5, self.episodeId);
        output.encodeStringElement(serialDesc, 6, self.bvId);
        output.encodeStringElement(serialDesc, 7, self.groupTitle);
        output.encodeStringElement(serialDesc, 8, self.videoTitle);
        output.encodeStringElement(serialDesc, 9, self.pageTitle);
        output.encodeStringElement(serialDesc, 10, self.author);
        output.encodeLongElement(serialDesc, 11, self.authorMid);
        output.encodeStringElement(serialDesc, 12, self.cover);
        output.encodeSerializableElement(serialDesc, 13, (SerializationStrategy) lazyArr[13].getValue(), self.biz);
        output.encodeLongElement(serialDesc, 14, self.videoIndex);
        output.encodeLongElement(serialDesc, 15, self.pageIndex);
        output.encodeSerializableElement(serialDesc, 16, (SerializationStrategy) lazyArr[16].getValue(), self.seasonType);
        output.encodeStringElement(serialDesc, 17, self.fromScene);
        output.encodeStringElement(serialDesc, 18, self.extended);
        output.encodeSerializableElement(serialDesc, 19, (SerializationStrategy) lazyArr[19].getValue(), self.epSortedIds);
        output.encodeIntElement(serialDesc, 20, self.epStatus);
    }

    public final int getVideoAttr() {
        return this.videoAttr;
    }

    public final long getGroupId() {
        return this.groupId;
    }

    public final long getAid() {
        return this.aid;
    }

    public final long getCid() {
        return this.cid;
    }

    public final long getSeasonId() {
        return this.seasonId;
    }

    public final long getEpisodeId() {
        return this.episodeId;
    }

    public final String getBvId() {
        return this.bvId;
    }

    public final String getGroupTitle() {
        return this.groupTitle;
    }

    public final String getVideoTitle() {
        return this.videoTitle;
    }

    public final String getPageTitle() {
        return this.pageTitle;
    }

    public final String getAuthor() {
        return this.author;
    }

    public final long getAuthorMid() {
        return this.authorMid;
    }

    public final String getCover() {
        return this.cover;
    }

    public final OfflineVideoEntity.BizType getBiz() {
        return this.biz;
    }

    public final long getVideoIndex() {
        return this.videoIndex;
    }

    public final long getPageIndex() {
        return this.pageIndex;
    }

    public final OfflineVideoEntity.SeasonType getSeasonType() {
        return this.seasonType;
    }

    public final String getFromScene() {
        return this.fromScene;
    }

    public final String getExtended() {
        return this.extended;
    }

    public final List<String> getEpSortedIds() {
        return this.epSortedIds;
    }

    public final int getEpStatus() {
        return this.epStatus;
    }

    public final void setEpStatus(int i) {
        this.epStatus = i;
    }
}