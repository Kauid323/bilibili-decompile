package video.biz.offline.base.infra.model;

import ComposableSingletons$CustomBottomSheetKt$;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.videoplayer.core.media.ijk.IjkFnHelper;
import tv.danmaku.videoplayer.coreV2.transformer.MediaItemParams;

/* compiled from: DeprecatedEntryModel.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b4\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 Z2\u00020\u0001:\u0002YZB\u009d\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003¢\u0006\u0004\b\u0014\u0010\u0015B\u009f\u0001\b\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u0014\u0010\u0019J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0005HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\bHÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\bHÆ\u0003J\t\u0010B\u001a\u00020\bHÆ\u0003J\t\u0010C\u001a\u00020\bHÆ\u0003J\t\u0010D\u001a\u00020\u0005HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\t\u0010H\u001a\u00020\bHÆ\u0003J\t\u0010I\u001a\u00020\bHÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\u009f\u0001\u0010K\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\u0003HÆ\u0001J\u0013\u0010L\u001a\u00020M2\b\u0010N\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010O\u001a\u00020\u0005HÖ\u0001J\t\u0010P\u001a\u00020\bHÖ\u0001J%\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020\u00002\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020WH\u0001¢\u0006\u0002\bXR\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u001b\u001a\u0004\b\"\u0010\u001dR\u001c\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u001b\u001a\u0004\b$\u0010%R\u001c\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u001b\u001a\u0004\b'\u0010\u001dR\u001c\u0010\n\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010\u001b\u001a\u0004\b)\u0010%R\u001c\u0010\u000b\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u001b\u001a\u0004\b+\u0010%R\u001c\u0010\f\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010\u001b\u001a\u0004\b-\u0010%R\u001c\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010\u001b\u001a\u0004\b/\u0010 R\u001c\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010\u001b\u001a\u0004\b1\u0010\u001dR\u001c\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b2\u0010\u001b\u001a\u0004\b3\u0010\u001dR\u001c\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b4\u0010\u001b\u001a\u0004\b5\u0010\u001dR\u001c\u0010\u0011\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b6\u0010\u001b\u001a\u0004\b7\u0010%R\u001c\u0010\u0012\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b8\u0010\u001b\u001a\u0004\b9\u0010%R\u001c\u0010\u0013\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b:\u0010\u001b\u001a\u0004\b;\u0010\u001d¨\u0006["}, d2 = {"Lvideo/biz/offline/base/infra/model/DeprecatedEpisodeModel;", "", "avId", "", "page", "", "danmaku", RankRouter.BundleKey.VIDEO_DETAIL_COVER, "", "episodeId", "index", "indexTitle", "from", "seasonType", "width", "height", "rotate", "link", "bvid", "sortIndex", "<init>", "(JIJLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IJJJLjava/lang/String;Ljava/lang/String;J)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJIJLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IJJJLjava/lang/String;Ljava/lang/String;JLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAvId$annotations", "()V", "getAvId", "()J", "getPage$annotations", "getPage", "()I", "getDanmaku$annotations", "getDanmaku", "getCover$annotations", "getCover", "()Ljava/lang/String;", "getEpisodeId$annotations", "getEpisodeId", "getIndex$annotations", "getIndex", "getIndexTitle$annotations", "getIndexTitle", "getFrom$annotations", "getFrom", "getSeasonType$annotations", "getSeasonType", "getWidth$annotations", "getWidth", "getHeight$annotations", "getHeight", "getRotate$annotations", "getRotate", "getLink$annotations", "getLink", "getBvid$annotations", "getBvid", "getSortIndex$annotations", "getSortIndex", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$infra_debug", "$serializer", "Companion", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@Serializable
public final class DeprecatedEpisodeModel {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final long avId;
    private final String bvid;
    private final String cover;
    private final long danmaku;
    private final long episodeId;
    private final String from;
    private final long height;
    private final String index;
    private final String indexTitle;
    private final String link;
    private final int page;
    private final long rotate;
    private final int seasonType;
    private final long sortIndex;
    private final long width;

    public DeprecatedEpisodeModel() {
        this(0L, 0, 0L, (String) null, 0L, (String) null, (String) null, (String) null, 0, 0L, 0L, 0L, (String) null, (String) null, 0L, 32767, (DefaultConstructorMarker) null);
    }

    @SerialName("av_id")
    public static /* synthetic */ void getAvId$annotations() {
    }

    @SerialName("bvid")
    public static /* synthetic */ void getBvid$annotations() {
    }

    @SerialName(RankRouter.BundleKey.VIDEO_DETAIL_COVER)
    public static /* synthetic */ void getCover$annotations() {
    }

    @SerialName("danmaku")
    public static /* synthetic */ void getDanmaku$annotations() {
    }

    @SerialName("episode_id")
    public static /* synthetic */ void getEpisodeId$annotations() {
    }

    @SerialName("from")
    public static /* synthetic */ void getFrom$annotations() {
    }

    @SerialName("height")
    public static /* synthetic */ void getHeight$annotations() {
    }

    @SerialName("index")
    public static /* synthetic */ void getIndex$annotations() {
    }

    @SerialName("index_title")
    public static /* synthetic */ void getIndexTitle$annotations() {
    }

    @SerialName("link")
    public static /* synthetic */ void getLink$annotations() {
    }

    @SerialName("page")
    public static /* synthetic */ void getPage$annotations() {
    }

    @SerialName("rotate")
    public static /* synthetic */ void getRotate$annotations() {
    }

    @SerialName(MediaItemParams.IJK_REPORT_KEY_SEASON_TYPE)
    public static /* synthetic */ void getSeasonType$annotations() {
    }

    @SerialName("sort_index")
    public static /* synthetic */ void getSortIndex$annotations() {
    }

    @SerialName("width")
    public static /* synthetic */ void getWidth$annotations() {
    }

    public final long component1() {
        return this.avId;
    }

    public final long component10() {
        return this.width;
    }

    public final long component11() {
        return this.height;
    }

    public final long component12() {
        return this.rotate;
    }

    public final String component13() {
        return this.link;
    }

    public final String component14() {
        return this.bvid;
    }

    public final long component15() {
        return this.sortIndex;
    }

    public final int component2() {
        return this.page;
    }

    public final long component3() {
        return this.danmaku;
    }

    public final String component4() {
        return this.cover;
    }

    public final long component5() {
        return this.episodeId;
    }

    public final String component6() {
        return this.index;
    }

    public final String component7() {
        return this.indexTitle;
    }

    public final String component8() {
        return this.from;
    }

    public final int component9() {
        return this.seasonType;
    }

    public final DeprecatedEpisodeModel copy(long j, int i, long j2, String str, long j3, String str2, String str3, String str4, int i2, long j4, long j5, long j6, String str5, String str6, long j7) {
        Intrinsics.checkNotNullParameter(str, RankRouter.BundleKey.VIDEO_DETAIL_COVER);
        Intrinsics.checkNotNullParameter(str2, "index");
        Intrinsics.checkNotNullParameter(str3, "indexTitle");
        Intrinsics.checkNotNullParameter(str4, "from");
        Intrinsics.checkNotNullParameter(str5, "link");
        Intrinsics.checkNotNullParameter(str6, "bvid");
        return new DeprecatedEpisodeModel(j, i, j2, str, j3, str2, str3, str4, i2, j4, j5, j6, str5, str6, j7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DeprecatedEpisodeModel) {
            DeprecatedEpisodeModel deprecatedEpisodeModel = (DeprecatedEpisodeModel) obj;
            return this.avId == deprecatedEpisodeModel.avId && this.page == deprecatedEpisodeModel.page && this.danmaku == deprecatedEpisodeModel.danmaku && Intrinsics.areEqual(this.cover, deprecatedEpisodeModel.cover) && this.episodeId == deprecatedEpisodeModel.episodeId && Intrinsics.areEqual(this.index, deprecatedEpisodeModel.index) && Intrinsics.areEqual(this.indexTitle, deprecatedEpisodeModel.indexTitle) && Intrinsics.areEqual(this.from, deprecatedEpisodeModel.from) && this.seasonType == deprecatedEpisodeModel.seasonType && this.width == deprecatedEpisodeModel.width && this.height == deprecatedEpisodeModel.height && this.rotate == deprecatedEpisodeModel.rotate && Intrinsics.areEqual(this.link, deprecatedEpisodeModel.link) && Intrinsics.areEqual(this.bvid, deprecatedEpisodeModel.bvid) && this.sortIndex == deprecatedEpisodeModel.sortIndex;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.avId) * 31) + this.page) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.danmaku)) * 31) + this.cover.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.episodeId)) * 31) + this.index.hashCode()) * 31) + this.indexTitle.hashCode()) * 31) + this.from.hashCode()) * 31) + this.seasonType) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.width)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.height)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.rotate)) * 31) + this.link.hashCode()) * 31) + this.bvid.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.sortIndex);
    }

    public String toString() {
        long j = this.avId;
        int i = this.page;
        long j2 = this.danmaku;
        String str = this.cover;
        long j3 = this.episodeId;
        String str2 = this.index;
        String str3 = this.indexTitle;
        String str4 = this.from;
        int i2 = this.seasonType;
        long j4 = this.width;
        long j5 = this.height;
        long j6 = this.rotate;
        String str5 = this.link;
        String str6 = this.bvid;
        return "DeprecatedEpisodeModel(avId=" + j + ", page=" + i + ", danmaku=" + j2 + ", cover=" + str + ", episodeId=" + j3 + ", index=" + str2 + ", indexTitle=" + str3 + ", from=" + str4 + ", seasonType=" + i2 + ", width=" + j4 + ", height=" + j5 + ", rotate=" + j6 + ", link=" + str5 + ", bvid=" + str6 + ", sortIndex=" + this.sortIndex + ")";
    }

    /* compiled from: DeprecatedEntryModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lvideo/biz/offline/base/infra/model/DeprecatedEpisodeModel$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lvideo/biz/offline/base/infra/model/DeprecatedEpisodeModel;", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DeprecatedEpisodeModel> serializer() {
            return DeprecatedEpisodeModel$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ DeprecatedEpisodeModel(int seen0, long avId, int page, long danmaku, String cover, long episodeId, String index, String indexTitle, String from, int seasonType, long width, long height, long rotate, String link, String bvid, long sortIndex, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.avId = 0L;
        } else {
            this.avId = avId;
        }
        if ((seen0 & 2) == 0) {
            this.page = 0;
        } else {
            this.page = page;
        }
        if ((seen0 & 4) == 0) {
            this.danmaku = 0L;
        } else {
            this.danmaku = danmaku;
        }
        if ((seen0 & 8) == 0) {
            this.cover = "";
        } else {
            this.cover = cover;
        }
        if ((seen0 & 16) == 0) {
            this.episodeId = 0L;
        } else {
            this.episodeId = episodeId;
        }
        if ((seen0 & 32) == 0) {
            this.index = "";
        } else {
            this.index = index;
        }
        if ((seen0 & 64) == 0) {
            this.indexTitle = "";
        } else {
            this.indexTitle = indexTitle;
        }
        if ((seen0 & 128) == 0) {
            this.from = "";
        } else {
            this.from = from;
        }
        if ((seen0 & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) == 0) {
            this.seasonType = 0;
        } else {
            this.seasonType = seasonType;
        }
        if ((seen0 & 512) == 0) {
            this.width = 0L;
        } else {
            this.width = width;
        }
        if ((seen0 & 1024) == 0) {
            this.height = 0L;
        } else {
            this.height = height;
        }
        if ((seen0 & IjkMediaMeta.FF_PROFILE_H264_INTRA) == 0) {
            this.rotate = 0L;
        } else {
            this.rotate = rotate;
        }
        if ((seen0 & 4096) == 0) {
            this.link = "";
        } else {
            this.link = link;
        }
        if ((seen0 & 8192) == 0) {
            this.bvid = "";
        } else {
            this.bvid = bvid;
        }
        if ((seen0 & IjkFnHelper.PLAY_URL_FLAG_HDR_VIVID) == 0) {
            this.sortIndex = 0L;
        } else {
            this.sortIndex = sortIndex;
        }
    }

    public DeprecatedEpisodeModel(long avId, int page, long danmaku, String cover, long episodeId, String index, String indexTitle, String from, int seasonType, long width, long height, long rotate, String link, String bvid, long sortIndex) {
        Intrinsics.checkNotNullParameter(cover, RankRouter.BundleKey.VIDEO_DETAIL_COVER);
        Intrinsics.checkNotNullParameter(index, "index");
        Intrinsics.checkNotNullParameter(indexTitle, "indexTitle");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(link, "link");
        Intrinsics.checkNotNullParameter(bvid, "bvid");
        this.avId = avId;
        this.page = page;
        this.danmaku = danmaku;
        this.cover = cover;
        this.episodeId = episodeId;
        this.index = index;
        this.indexTitle = indexTitle;
        this.from = from;
        this.seasonType = seasonType;
        this.width = width;
        this.height = height;
        this.rotate = rotate;
        this.link = link;
        this.bvid = bvid;
        this.sortIndex = sortIndex;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$infra_debug(DeprecatedEpisodeModel self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.avId != 0) {
            output.encodeLongElement(serialDesc, 0, self.avId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.page != 0) {
            output.encodeIntElement(serialDesc, 1, self.page);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.danmaku != 0) {
            output.encodeLongElement(serialDesc, 2, self.danmaku);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.cover, "")) {
            output.encodeStringElement(serialDesc, 3, self.cover);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.episodeId != 0) {
            output.encodeLongElement(serialDesc, 4, self.episodeId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || !Intrinsics.areEqual(self.index, "")) {
            output.encodeStringElement(serialDesc, 5, self.index);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || !Intrinsics.areEqual(self.indexTitle, "")) {
            output.encodeStringElement(serialDesc, 6, self.indexTitle);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || !Intrinsics.areEqual(self.from, "")) {
            output.encodeStringElement(serialDesc, 7, self.from);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.seasonType != 0) {
            output.encodeIntElement(serialDesc, 8, self.seasonType);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.width != 0) {
            output.encodeLongElement(serialDesc, 9, self.width);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.height != 0) {
            output.encodeLongElement(serialDesc, 10, self.height);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.rotate != 0) {
            output.encodeLongElement(serialDesc, 11, self.rotate);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || !Intrinsics.areEqual(self.link, "")) {
            output.encodeStringElement(serialDesc, 12, self.link);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || !Intrinsics.areEqual(self.bvid, "")) {
            output.encodeStringElement(serialDesc, 13, self.bvid);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || self.sortIndex != 0) {
            output.encodeLongElement(serialDesc, 14, self.sortIndex);
        }
    }

    public /* synthetic */ DeprecatedEpisodeModel(long j, int i, long j2, String str, long j3, String str2, String str3, String str4, int i2, long j4, long j5, long j6, String str5, String str6, long j7, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? 0L : j2, (i3 & 8) != 0 ? "" : str, (i3 & 16) != 0 ? 0L : j3, (i3 & 32) != 0 ? "" : str2, (i3 & 64) != 0 ? "" : str3, (i3 & 128) != 0 ? "" : str4, (i3 & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) == 0 ? i2 : 0, (i3 & 512) != 0 ? 0L : j4, (i3 & 1024) != 0 ? 0L : j5, (i3 & IjkMediaMeta.FF_PROFILE_H264_INTRA) != 0 ? 0L : j6, (i3 & 4096) != 0 ? "" : str5, (i3 & 8192) != 0 ? "" : str6, (i3 & IjkFnHelper.PLAY_URL_FLAG_HDR_VIVID) != 0 ? 0L : j7);
    }

    public final long getAvId() {
        return this.avId;
    }

    public final int getPage() {
        return this.page;
    }

    public final long getDanmaku() {
        return this.danmaku;
    }

    public final String getCover() {
        return this.cover;
    }

    public final long getEpisodeId() {
        return this.episodeId;
    }

    public final String getIndex() {
        return this.index;
    }

    public final String getIndexTitle() {
        return this.indexTitle;
    }

    public final String getFrom() {
        return this.from;
    }

    public final int getSeasonType() {
        return this.seasonType;
    }

    public final long getWidth() {
        return this.width;
    }

    public final long getHeight() {
        return this.height;
    }

    public final long getRotate() {
        return this.rotate;
    }

    public final String getLink() {
        return this.link;
    }

    public final String getBvid() {
        return this.bvid;
    }

    public final long getSortIndex() {
        return this.sortIndex;
    }
}