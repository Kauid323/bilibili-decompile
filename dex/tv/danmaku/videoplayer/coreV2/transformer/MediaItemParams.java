package tv.danmaku.videoplayer.coreV2.transformer;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import com.bilibili.lib.media.dolby.DolbyVisionConfigManager;
import com.bilibili.lib.media.resource.VolumeInfo;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.videoplayer.core.media.ijk.IjkFnHelper;

/* compiled from: IMediaItemTransformer.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\ba\b\u0086\b\u0018\u0000 \u008c\u00012\u00020\u0001:\u0004\u008b\u0001\u008c\u0001B×\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0005\u0012\u0006\u0010\u0019\u001a\u00020\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\u0006\u0010\u001d\u001a\u00020\u0007\u0012\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001f\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\b\u0010!\u001a\u0004\u0018\u00010\"\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010$\u001a\u00020\u0007\u0012\u0006\u0010%\u001a\u00020\u0007\u0012\u0006\u0010&\u001a\u00020\u000b\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010(\u001a\u00020\u0007\u0012\b\b\u0002\u0010)\u001a\u00020\u0007\u0012(\b\u0002\u0010*\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010+j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`,¢\u0006\u0004\b-\u0010.J\u000b\u0010c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010d\u001a\u00020\u0005HÆ\u0003J\t\u0010e\u001a\u00020\u0007HÆ\u0003J\t\u0010f\u001a\u00020\u0005HÆ\u0003J\t\u0010g\u001a\u00020\u0007HÆ\u0003J\t\u0010h\u001a\u00020\u000bHÆ\u0003J\t\u0010i\u001a\u00020\u0007HÆ\u0003J\t\u0010j\u001a\u00020\u0005HÆ\u0003J\t\u0010k\u001a\u00020\u0003HÆ\u0003J\t\u0010l\u001a\u00020\u000bHÆ\u0003J\t\u0010m\u001a\u00020\u000bHÆ\u0003J\t\u0010n\u001a\u00020\u0007HÆ\u0003J\t\u0010o\u001a\u00020\u0005HÆ\u0003J\t\u0010p\u001a\u00020\u000bHÆ\u0003J\t\u0010q\u001a\u00020\u0005HÆ\u0003J\t\u0010r\u001a\u00020\u0005HÆ\u0003J\t\u0010s\u001a\u00020\u0005HÆ\u0003J\t\u0010t\u001a\u00020\u0007HÆ\u0003J\t\u0010u\u001a\u00020\u0005HÆ\u0003J\t\u0010v\u001a\u00020\u0007HÆ\u0003J\t\u0010w\u001a\u00020\u0003HÆ\u0003J\u000b\u0010x\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\t\u0010y\u001a\u00020\u0007HÆ\u0003J\u0017\u0010z\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001fHÆ\u0003J\u000b\u0010{\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010|\u001a\u0004\u0018\u00010\"HÆ\u0003J\u0010\u0010}\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010WJ\t\u0010~\u001a\u00020\u0007HÆ\u0003J\t\u0010\u007f\u001a\u00020\u0007HÆ\u0003J\n\u0010\u0080\u0001\u001a\u00020\u000bHÆ\u0003J\u0011\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010WJ\n\u0010\u0082\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010\u0083\u0001\u001a\u00020\u0007HÆ\u0003J*\u0010\u0084\u0001\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010+j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`,HÆ\u0003J\u009e\u0003\u0010\u0085\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00072\u0016\b\u0002\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010$\u001a\u00020\u00072\b\b\u0002\u0010%\u001a\u00020\u00072\b\b\u0002\u0010&\u001a\u00020\u000b2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010(\u001a\u00020\u00072\b\b\u0002\u0010)\u001a\u00020\u00072(\b\u0002\u0010*\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010+j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`,HÆ\u0001¢\u0006\u0003\u0010\u0086\u0001J\u0015\u0010\u0087\u0001\u001a\u00020\u00072\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010\u0089\u0001\u001a\u00020\u0005HÖ\u0001J\n\u0010\u008a\u0001\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u00102R\u001a\u0010\t\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00104\"\u0004\b7\u00108R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b;\u00104R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b<\u00102R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b=\u00100R\u0011\u0010\u000f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b>\u0010:R\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010:\"\u0004\b@\u0010AR\u0011\u0010\u0011\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u00104R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bB\u00102R\u0011\u0010\u0013\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bC\u0010:R\u001a\u0010\u0014\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u00102\"\u0004\bE\u0010FR\u001a\u0010\u0015\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u00102\"\u0004\bH\u0010FR\u0011\u0010\u0016\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bI\u00102R\u0011\u0010\u0017\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u00104R\u0011\u0010\u0018\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bJ\u00102R\u0011\u0010\u0019\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u00104R\u0011\u0010\u001a\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bK\u00100R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u0011\u0010\u001d\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bN\u00104R(\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u0013\u0010 \u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bS\u00100R\u0013\u0010!\u001a\u0004\u0018\u00010\"¢\u0006\b\n\u0000\u001a\u0004\bT\u0010UR\u0015\u0010#\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010X\u001a\u0004\bV\u0010WR\u0011\u0010$\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bY\u00104R\u0011\u0010%\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bZ\u00104R\u0011\u0010&\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b[\u0010:R\u0015\u0010'\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010X\u001a\u0004\b\\\u0010WR\u001a\u0010(\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u00104\"\u0004\b^\u00108R\u001a\u0010)\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u00104\"\u0004\b`\u00108R1\u0010*\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010+j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`,¢\u0006\b\n\u0000\u001a\u0004\ba\u0010b¨\u0006\u008d\u0001"}, d2 = {"Ltv/danmaku/videoplayer/coreV2/transformer/MediaItemParams;", "", "id", "", "scheme", "", "enableHWCodex", "", "skipLoopFilter", "forceRenderLastFrame", "cacheTime", "", "startWhenPrepared", "trackerMode", "neuronSession", "trackerId", "startPosition", "isForceStartAccurateSeek", "accurateSeekTimeoutMs", "avid", "videoStreamId", "audioStreamId", "ijkAudioStreamType", "isHdr", "hdrType", "isDolbyVision", "dolbyConfigPath", "p2pParams", "Ltv/danmaku/videoplayer/coreV2/transformer/P2PParams;", "enableRawData", "recommendStartQualityRange", "Lkotlin/Pair;", "abr", "volumeInfo", "Lcom/bilibili/lib/media/resource/VolumeInfo;", "startScreenRatio", "enableAlphaLayer", "enableLiveSkipFrame", "liveStartLatency", "screenState", "renderAfterPrepare", "variableResolutionRatio", "extraReportParams", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "<init>", "(Ljava/lang/String;IZIZJZILjava/lang/String;JJZIJIIIZIZLjava/lang/String;Ltv/danmaku/videoplayer/coreV2/transformer/P2PParams;ZLkotlin/Pair;Ljava/lang/String;Lcom/bilibili/lib/media/resource/VolumeInfo;Ljava/lang/Integer;ZZJLjava/lang/Integer;ZZLjava/util/HashMap;)V", "getId", "()Ljava/lang/String;", "getScheme", "()I", "getEnableHWCodex", "()Z", "getSkipLoopFilter", "getForceRenderLastFrame", "setForceRenderLastFrame", "(Z)V", "getCacheTime", "()J", "getStartWhenPrepared", "getTrackerMode", "getNeuronSession", "getTrackerId", "getStartPosition", "setStartPosition", "(J)V", "getAccurateSeekTimeoutMs", "getAvid", "getVideoStreamId", "setVideoStreamId", "(I)V", "getAudioStreamId", "setAudioStreamId", "getIjkAudioStreamType", "getHdrType", "getDolbyConfigPath", "getP2pParams", "()Ltv/danmaku/videoplayer/coreV2/transformer/P2PParams;", "getEnableRawData", "getRecommendStartQualityRange", "()Lkotlin/Pair;", "setRecommendStartQualityRange", "(Lkotlin/Pair;)V", "getAbr", "getVolumeInfo", "()Lcom/bilibili/lib/media/resource/VolumeInfo;", "getStartScreenRatio", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEnableAlphaLayer", "getEnableLiveSkipFrame", "getLiveStartLatency", "getScreenState", "getRenderAfterPrepare", "setRenderAfterPrepare", "getVariableResolutionRatio", "setVariableResolutionRatio", "getExtraReportParams", "()Ljava/util/HashMap;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "copy", "(Ljava/lang/String;IZIZJZILjava/lang/String;JJZIJIIIZIZLjava/lang/String;Ltv/danmaku/videoplayer/coreV2/transformer/P2PParams;ZLkotlin/Pair;Ljava/lang/String;Lcom/bilibili/lib/media/resource/VolumeInfo;Ljava/lang/Integer;ZZJLjava/lang/Integer;ZZLjava/util/HashMap;)Ltv/danmaku/videoplayer/coreV2/transformer/MediaItemParams;", "equals", "other", "hashCode", "toString", "Builder", "Companion", "playercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class MediaItemParams {
    public static final Companion Companion = new Companion(null);
    public static final String IJK_REPORT_KEY_BIZ_TYPE = "biz_type";
    public static final String IJK_REPORT_KEY_EPID = "epid";
    public static final String IJK_REPORT_KEY_FLASH = "preload_url";
    public static final String IJK_REPORT_KEY_FORCE_REPORT = "force_report";
    public static final String IJK_REPORT_KEY_FROM_SPMID = "from_spmid";
    public static final String IJK_REPORT_KEY_IS_DRM_RESOURCE = "is_drm_resource";
    public static final String IJK_REPORT_KEY_LIVE_MODE = "create_mode";
    public static final String IJK_REPORT_KEY_LIVE_SCENE = "live_scene";
    public static final String IJK_REPORT_KEY_MEDIA_SOURCE = "media_source";
    public static final String IJK_REPORT_KEY_SEASON_ID = "season_id";
    public static final String IJK_REPORT_KEY_SEASON_TYPE = "season_type";
    public static final String IJK_REPORT_KEY_SPMID = "spmid";
    private final String abr;
    private final int accurateSeekTimeoutMs;
    private int audioStreamId;
    private final long avid;
    private final long cacheTime;
    private final String dolbyConfigPath;
    private final boolean enableAlphaLayer;
    private final boolean enableHWCodex;
    private final boolean enableLiveSkipFrame;
    private final boolean enableRawData;
    private final HashMap<String, String> extraReportParams;
    private boolean forceRenderLastFrame;
    private final int hdrType;
    private final String id;
    private final int ijkAudioStreamType;
    private final boolean isDolbyVision;
    private final boolean isForceStartAccurateSeek;
    private final boolean isHdr;
    private final long liveStartLatency;
    private final String neuronSession;
    private final P2PParams p2pParams;
    private Pair<Integer, Integer> recommendStartQualityRange;
    private boolean renderAfterPrepare;
    private final int scheme;
    private final Integer screenState;
    private final int skipLoopFilter;
    private long startPosition;
    private final Integer startScreenRatio;
    private final boolean startWhenPrepared;
    private final long trackerId;
    private final int trackerMode;
    private boolean variableResolutionRatio;
    private int videoStreamId;
    private final VolumeInfo volumeInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MediaItemParams copy$default(MediaItemParams mediaItemParams, String str, int i, boolean z, int i2, boolean z2, long j, boolean z3, int i3, String str2, long j2, long j3, boolean z4, int i4, long j4, int i5, int i6, int i7, boolean z5, int i8, boolean z6, String str3, P2PParams p2PParams, boolean z7, Pair pair, String str4, VolumeInfo volumeInfo, Integer num, boolean z8, boolean z9, long j5, Integer num2, boolean z10, boolean z11, HashMap hashMap, int i9, int i10, Object obj) {
        String str5 = (i9 & 1) != 0 ? mediaItemParams.id : str;
        int i11 = (i9 & 2) != 0 ? mediaItemParams.scheme : i;
        boolean z12 = (i9 & 4) != 0 ? mediaItemParams.enableHWCodex : z;
        int i12 = (i9 & 8) != 0 ? mediaItemParams.skipLoopFilter : i2;
        boolean z13 = (i9 & 16) != 0 ? mediaItemParams.forceRenderLastFrame : z2;
        long j6 = (i9 & 32) != 0 ? mediaItemParams.cacheTime : j;
        boolean z14 = (i9 & 64) != 0 ? mediaItemParams.startWhenPrepared : z3;
        int i13 = (i9 & 128) != 0 ? mediaItemParams.trackerMode : i3;
        String str6 = (i9 & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) != 0 ? mediaItemParams.neuronSession : str2;
        long j7 = (i9 & 512) != 0 ? mediaItemParams.trackerId : j2;
        long j8 = (i9 & 1024) != 0 ? mediaItemParams.startPosition : j3;
        boolean z15 = (i9 & IjkMediaMeta.FF_PROFILE_H264_INTRA) != 0 ? mediaItemParams.isForceStartAccurateSeek : z4;
        return mediaItemParams.copy(str5, i11, z12, i12, z13, j6, z14, i13, str6, j7, j8, z15, (i9 & 4096) != 0 ? mediaItemParams.accurateSeekTimeoutMs : i4, (i9 & 8192) != 0 ? mediaItemParams.avid : j4, (i9 & IjkFnHelper.PLAY_URL_FLAG_HDR_VIVID) != 0 ? mediaItemParams.videoStreamId : i5, (32768 & i9) != 0 ? mediaItemParams.audioStreamId : i6, (i9 & 65536) != 0 ? mediaItemParams.ijkAudioStreamType : i7, (i9 & 131072) != 0 ? mediaItemParams.isHdr : z5, (i9 & 262144) != 0 ? mediaItemParams.hdrType : i8, (i9 & 524288) != 0 ? mediaItemParams.isDolbyVision : z6, (i9 & 1048576) != 0 ? mediaItemParams.dolbyConfigPath : str3, (i9 & 2097152) != 0 ? mediaItemParams.p2pParams : p2PParams, (i9 & 4194304) != 0 ? mediaItemParams.enableRawData : z7, (i9 & 8388608) != 0 ? mediaItemParams.recommendStartQualityRange : pair, (i9 & 16777216) != 0 ? mediaItemParams.abr : str4, (i9 & 33554432) != 0 ? mediaItemParams.volumeInfo : volumeInfo, (i9 & 67108864) != 0 ? mediaItemParams.startScreenRatio : num, (i9 & 134217728) != 0 ? mediaItemParams.enableAlphaLayer : z8, (i9 & 268435456) != 0 ? mediaItemParams.enableLiveSkipFrame : z9, (i9 & 536870912) != 0 ? mediaItemParams.liveStartLatency : j5, (i9 & 1073741824) != 0 ? mediaItemParams.screenState : num2, (i9 & Integer.MIN_VALUE) != 0 ? mediaItemParams.renderAfterPrepare : z10, (i10 & 1) != 0 ? mediaItemParams.variableResolutionRatio : z11, (i10 & 2) != 0 ? mediaItemParams.extraReportParams : hashMap);
    }

    public final String component1() {
        return this.id;
    }

    public final long component10() {
        return this.trackerId;
    }

    public final long component11() {
        return this.startPosition;
    }

    public final boolean component12() {
        return this.isForceStartAccurateSeek;
    }

    public final int component13() {
        return this.accurateSeekTimeoutMs;
    }

    public final long component14() {
        return this.avid;
    }

    public final int component15() {
        return this.videoStreamId;
    }

    public final int component16() {
        return this.audioStreamId;
    }

    public final int component17() {
        return this.ijkAudioStreamType;
    }

    public final boolean component18() {
        return this.isHdr;
    }

    public final int component19() {
        return this.hdrType;
    }

    public final int component2() {
        return this.scheme;
    }

    public final boolean component20() {
        return this.isDolbyVision;
    }

    public final String component21() {
        return this.dolbyConfigPath;
    }

    public final P2PParams component22() {
        return this.p2pParams;
    }

    public final boolean component23() {
        return this.enableRawData;
    }

    public final Pair<Integer, Integer> component24() {
        return this.recommendStartQualityRange;
    }

    public final String component25() {
        return this.abr;
    }

    public final VolumeInfo component26() {
        return this.volumeInfo;
    }

    public final Integer component27() {
        return this.startScreenRatio;
    }

    public final boolean component28() {
        return this.enableAlphaLayer;
    }

    public final boolean component29() {
        return this.enableLiveSkipFrame;
    }

    public final boolean component3() {
        return this.enableHWCodex;
    }

    public final long component30() {
        return this.liveStartLatency;
    }

    public final Integer component31() {
        return this.screenState;
    }

    public final boolean component32() {
        return this.renderAfterPrepare;
    }

    public final boolean component33() {
        return this.variableResolutionRatio;
    }

    public final HashMap<String, String> component34() {
        return this.extraReportParams;
    }

    public final int component4() {
        return this.skipLoopFilter;
    }

    public final boolean component5() {
        return this.forceRenderLastFrame;
    }

    public final long component6() {
        return this.cacheTime;
    }

    public final boolean component7() {
        return this.startWhenPrepared;
    }

    public final int component8() {
        return this.trackerMode;
    }

    public final String component9() {
        return this.neuronSession;
    }

    public final MediaItemParams copy(String str, int i, boolean z, int i2, boolean z2, long j, boolean z3, int i3, String str2, long j2, long j3, boolean z4, int i4, long j4, int i5, int i6, int i7, boolean z5, int i8, boolean z6, String str3, P2PParams p2PParams, boolean z7, Pair<Integer, Integer> pair, String str4, VolumeInfo volumeInfo, Integer num, boolean z8, boolean z9, long j5, Integer num2, boolean z10, boolean z11, HashMap<String, String> hashMap) {
        Intrinsics.checkNotNullParameter(str2, "neuronSession");
        Intrinsics.checkNotNullParameter(str3, "dolbyConfigPath");
        return new MediaItemParams(str, i, z, i2, z2, j, z3, i3, str2, j2, j3, z4, i4, j4, i5, i6, i7, z5, i8, z6, str3, p2PParams, z7, pair, str4, volumeInfo, num, z8, z9, j5, num2, z10, z11, hashMap);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MediaItemParams) {
            MediaItemParams mediaItemParams = (MediaItemParams) obj;
            return Intrinsics.areEqual(this.id, mediaItemParams.id) && this.scheme == mediaItemParams.scheme && this.enableHWCodex == mediaItemParams.enableHWCodex && this.skipLoopFilter == mediaItemParams.skipLoopFilter && this.forceRenderLastFrame == mediaItemParams.forceRenderLastFrame && this.cacheTime == mediaItemParams.cacheTime && this.startWhenPrepared == mediaItemParams.startWhenPrepared && this.trackerMode == mediaItemParams.trackerMode && Intrinsics.areEqual(this.neuronSession, mediaItemParams.neuronSession) && this.trackerId == mediaItemParams.trackerId && this.startPosition == mediaItemParams.startPosition && this.isForceStartAccurateSeek == mediaItemParams.isForceStartAccurateSeek && this.accurateSeekTimeoutMs == mediaItemParams.accurateSeekTimeoutMs && this.avid == mediaItemParams.avid && this.videoStreamId == mediaItemParams.videoStreamId && this.audioStreamId == mediaItemParams.audioStreamId && this.ijkAudioStreamType == mediaItemParams.ijkAudioStreamType && this.isHdr == mediaItemParams.isHdr && this.hdrType == mediaItemParams.hdrType && this.isDolbyVision == mediaItemParams.isDolbyVision && Intrinsics.areEqual(this.dolbyConfigPath, mediaItemParams.dolbyConfigPath) && Intrinsics.areEqual(this.p2pParams, mediaItemParams.p2pParams) && this.enableRawData == mediaItemParams.enableRawData && Intrinsics.areEqual(this.recommendStartQualityRange, mediaItemParams.recommendStartQualityRange) && Intrinsics.areEqual(this.abr, mediaItemParams.abr) && Intrinsics.areEqual(this.volumeInfo, mediaItemParams.volumeInfo) && Intrinsics.areEqual(this.startScreenRatio, mediaItemParams.startScreenRatio) && this.enableAlphaLayer == mediaItemParams.enableAlphaLayer && this.enableLiveSkipFrame == mediaItemParams.enableLiveSkipFrame && this.liveStartLatency == mediaItemParams.liveStartLatency && Intrinsics.areEqual(this.screenState, mediaItemParams.screenState) && this.renderAfterPrepare == mediaItemParams.renderAfterPrepare && this.variableResolutionRatio == mediaItemParams.variableResolutionRatio && Intrinsics.areEqual(this.extraReportParams, mediaItemParams.extraReportParams);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + this.scheme) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.enableHWCodex)) * 31) + this.skipLoopFilter) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.forceRenderLastFrame)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.cacheTime)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.startWhenPrepared)) * 31) + this.trackerMode) * 31) + this.neuronSession.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.trackerId)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.startPosition)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isForceStartAccurateSeek)) * 31) + this.accurateSeekTimeoutMs) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.avid)) * 31) + this.videoStreamId) * 31) + this.audioStreamId) * 31) + this.ijkAudioStreamType) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isHdr)) * 31) + this.hdrType) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isDolbyVision)) * 31) + this.dolbyConfigPath.hashCode()) * 31) + (this.p2pParams == null ? 0 : this.p2pParams.hashCode())) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.enableRawData)) * 31) + (this.recommendStartQualityRange == null ? 0 : this.recommendStartQualityRange.hashCode())) * 31) + (this.abr == null ? 0 : this.abr.hashCode())) * 31) + (this.volumeInfo == null ? 0 : this.volumeInfo.hashCode())) * 31) + (this.startScreenRatio == null ? 0 : this.startScreenRatio.hashCode())) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.enableAlphaLayer)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.enableLiveSkipFrame)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.liveStartLatency)) * 31) + (this.screenState == null ? 0 : this.screenState.hashCode())) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.renderAfterPrepare)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.variableResolutionRatio)) * 31) + (this.extraReportParams != null ? this.extraReportParams.hashCode() : 0);
    }

    public String toString() {
        String str = this.id;
        int i = this.scheme;
        boolean z = this.enableHWCodex;
        int i2 = this.skipLoopFilter;
        boolean z2 = this.forceRenderLastFrame;
        long j = this.cacheTime;
        boolean z3 = this.startWhenPrepared;
        int i3 = this.trackerMode;
        String str2 = this.neuronSession;
        long j2 = this.trackerId;
        long j3 = this.startPosition;
        boolean z4 = this.isForceStartAccurateSeek;
        int i4 = this.accurateSeekTimeoutMs;
        long j4 = this.avid;
        int i5 = this.videoStreamId;
        int i6 = this.audioStreamId;
        int i7 = this.ijkAudioStreamType;
        boolean z5 = this.isHdr;
        int i8 = this.hdrType;
        boolean z6 = this.isDolbyVision;
        String str3 = this.dolbyConfigPath;
        P2PParams p2PParams = this.p2pParams;
        boolean z7 = this.enableRawData;
        Pair<Integer, Integer> pair = this.recommendStartQualityRange;
        String str4 = this.abr;
        VolumeInfo volumeInfo = this.volumeInfo;
        Integer num = this.startScreenRatio;
        boolean z8 = this.enableAlphaLayer;
        boolean z9 = this.enableLiveSkipFrame;
        long j5 = this.liveStartLatency;
        Integer num2 = this.screenState;
        boolean z10 = this.renderAfterPrepare;
        boolean z11 = this.variableResolutionRatio;
        return "MediaItemParams(id=" + str + ", scheme=" + i + ", enableHWCodex=" + z + ", skipLoopFilter=" + i2 + ", forceRenderLastFrame=" + z2 + ", cacheTime=" + j + ", startWhenPrepared=" + z3 + ", trackerMode=" + i3 + ", neuronSession=" + str2 + ", trackerId=" + j2 + ", startPosition=" + j3 + ", isForceStartAccurateSeek=" + z4 + ", accurateSeekTimeoutMs=" + i4 + ", avid=" + j4 + ", videoStreamId=" + i5 + ", audioStreamId=" + i6 + ", ijkAudioStreamType=" + i7 + ", isHdr=" + z5 + ", hdrType=" + i8 + ", isDolbyVision=" + z6 + ", dolbyConfigPath=" + str3 + ", p2pParams=" + p2PParams + ", enableRawData=" + z7 + ", recommendStartQualityRange=" + pair + ", abr=" + str4 + ", volumeInfo=" + volumeInfo + ", startScreenRatio=" + num + ", enableAlphaLayer=" + z8 + ", enableLiveSkipFrame=" + z9 + ", liveStartLatency=" + j5 + ", screenState=" + num2 + ", renderAfterPrepare=" + z10 + ", variableResolutionRatio=" + z11 + ", extraReportParams=" + this.extraReportParams + ")";
    }

    public MediaItemParams(String id, int scheme, boolean enableHWCodex, int skipLoopFilter, boolean forceRenderLastFrame, long cacheTime, boolean startWhenPrepared, int trackerMode, String neuronSession, long trackerId, long startPosition, boolean isForceStartAccurateSeek, int accurateSeekTimeoutMs, long avid, int videoStreamId, int audioStreamId, int ijkAudioStreamType, boolean isHdr, int hdrType, boolean isDolbyVision, String dolbyConfigPath, P2PParams p2pParams, boolean enableRawData, Pair<Integer, Integer> pair, String abr, VolumeInfo volumeInfo, Integer startScreenRatio, boolean enableAlphaLayer, boolean enableLiveSkipFrame, long liveStartLatency, Integer screenState, boolean renderAfterPrepare, boolean variableResolutionRatio, HashMap<String, String> hashMap) {
        Intrinsics.checkNotNullParameter(neuronSession, "neuronSession");
        Intrinsics.checkNotNullParameter(dolbyConfigPath, "dolbyConfigPath");
        this.id = id;
        this.scheme = scheme;
        this.enableHWCodex = enableHWCodex;
        this.skipLoopFilter = skipLoopFilter;
        this.forceRenderLastFrame = forceRenderLastFrame;
        this.cacheTime = cacheTime;
        this.startWhenPrepared = startWhenPrepared;
        this.trackerMode = trackerMode;
        this.neuronSession = neuronSession;
        this.trackerId = trackerId;
        this.startPosition = startPosition;
        this.isForceStartAccurateSeek = isForceStartAccurateSeek;
        this.accurateSeekTimeoutMs = accurateSeekTimeoutMs;
        this.avid = avid;
        this.videoStreamId = videoStreamId;
        this.audioStreamId = audioStreamId;
        this.ijkAudioStreamType = ijkAudioStreamType;
        this.isHdr = isHdr;
        this.hdrType = hdrType;
        this.isDolbyVision = isDolbyVision;
        this.dolbyConfigPath = dolbyConfigPath;
        this.p2pParams = p2pParams;
        this.enableRawData = enableRawData;
        this.recommendStartQualityRange = pair;
        this.abr = abr;
        this.volumeInfo = volumeInfo;
        this.startScreenRatio = startScreenRatio;
        this.enableAlphaLayer = enableAlphaLayer;
        this.enableLiveSkipFrame = enableLiveSkipFrame;
        this.liveStartLatency = liveStartLatency;
        this.screenState = screenState;
        this.renderAfterPrepare = renderAfterPrepare;
        this.variableResolutionRatio = variableResolutionRatio;
        this.extraReportParams = hashMap;
    }

    public /* synthetic */ MediaItemParams(String str, int i, boolean z, int i2, boolean z2, long j, boolean z3, int i3, String str2, long j2, long j3, boolean z4, int i4, long j4, int i5, int i6, int i7, boolean z5, int i8, boolean z6, String str3, P2PParams p2PParams, boolean z7, Pair pair, String str4, VolumeInfo volumeInfo, Integer num, boolean z8, boolean z9, long j5, Integer num2, boolean z10, boolean z11, HashMap hashMap, int i9, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, z, i2, z2, j, z3, i3, str2, j2, j3, z4, i4, j4, i5, i6, i7, z5, i8, z6, str3, p2PParams, z7, pair, str4, volumeInfo, num, z8, z9, j5, num2, (i9 & Integer.MIN_VALUE) != 0 ? true : z10, (i10 & 1) != 0 ? false : z11, (i10 & 2) != 0 ? null : hashMap);
    }

    public final String getId() {
        return this.id;
    }

    public final int getScheme() {
        return this.scheme;
    }

    public final boolean getEnableHWCodex() {
        return this.enableHWCodex;
    }

    public final int getSkipLoopFilter() {
        return this.skipLoopFilter;
    }

    public final boolean getForceRenderLastFrame() {
        return this.forceRenderLastFrame;
    }

    public final void setForceRenderLastFrame(boolean z) {
        this.forceRenderLastFrame = z;
    }

    public final long getCacheTime() {
        return this.cacheTime;
    }

    public final boolean getStartWhenPrepared() {
        return this.startWhenPrepared;
    }

    public final int getTrackerMode() {
        return this.trackerMode;
    }

    public final String getNeuronSession() {
        return this.neuronSession;
    }

    public final long getTrackerId() {
        return this.trackerId;
    }

    public final long getStartPosition() {
        return this.startPosition;
    }

    public final void setStartPosition(long j) {
        this.startPosition = j;
    }

    public final boolean isForceStartAccurateSeek() {
        return this.isForceStartAccurateSeek;
    }

    public final int getAccurateSeekTimeoutMs() {
        return this.accurateSeekTimeoutMs;
    }

    public final long getAvid() {
        return this.avid;
    }

    public final int getVideoStreamId() {
        return this.videoStreamId;
    }

    public final void setVideoStreamId(int i) {
        this.videoStreamId = i;
    }

    public final int getAudioStreamId() {
        return this.audioStreamId;
    }

    public final void setAudioStreamId(int i) {
        this.audioStreamId = i;
    }

    public final int getIjkAudioStreamType() {
        return this.ijkAudioStreamType;
    }

    public final boolean isHdr() {
        return this.isHdr;
    }

    public final int getHdrType() {
        return this.hdrType;
    }

    public final boolean isDolbyVision() {
        return this.isDolbyVision;
    }

    public final String getDolbyConfigPath() {
        return this.dolbyConfigPath;
    }

    public final P2PParams getP2pParams() {
        return this.p2pParams;
    }

    public final boolean getEnableRawData() {
        return this.enableRawData;
    }

    public final Pair<Integer, Integer> getRecommendStartQualityRange() {
        return this.recommendStartQualityRange;
    }

    public final void setRecommendStartQualityRange(Pair<Integer, Integer> pair) {
        this.recommendStartQualityRange = pair;
    }

    public final String getAbr() {
        return this.abr;
    }

    public final VolumeInfo getVolumeInfo() {
        return this.volumeInfo;
    }

    public final Integer getStartScreenRatio() {
        return this.startScreenRatio;
    }

    public final boolean getEnableAlphaLayer() {
        return this.enableAlphaLayer;
    }

    public final boolean getEnableLiveSkipFrame() {
        return this.enableLiveSkipFrame;
    }

    public final long getLiveStartLatency() {
        return this.liveStartLatency;
    }

    public final Integer getScreenState() {
        return this.screenState;
    }

    public final boolean getRenderAfterPrepare() {
        return this.renderAfterPrepare;
    }

    public final void setRenderAfterPrepare(boolean z) {
        this.renderAfterPrepare = z;
    }

    public final boolean getVariableResolutionRatio() {
        return this.variableResolutionRatio;
    }

    public final void setVariableResolutionRatio(boolean z) {
        this.variableResolutionRatio = z;
    }

    public final HashMap<String, String> getExtraReportParams() {
        return this.extraReportParams;
    }

    /* compiled from: IMediaItemTransformer.kt */
    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u0015\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010}\u001a\u00020~2\u0006\u0010\u007f\u001a\u00020\u00052\u0007\u0010\u0080\u0001\u001a\u00020\u0005J\b\u0010\u0081\u0001\u001a\u00030\u0082\u0001J\t\u0010\u0083\u0001\u001a\u00020~H\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001a\u0010\u0019\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0013\"\u0004\b$\u0010\u0015R\u001a\u0010%\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\r\"\u0004\b'\u0010\u000fR\u001a\u0010(\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0007\"\u0004\b*\u0010\tR\u001a\u0010+\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001f\"\u0004\b-\u0010!R\u001a\u0010.\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001f\"\u0004\b0\u0010!R\u001a\u00101\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0013\"\u0004\b2\u0010\u0015R\u001a\u00103\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\r\"\u0004\b5\u0010\u000fR\u001a\u00106\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001f\"\u0004\b8\u0010!R\u001a\u00109\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0013\"\u0004\b:\u0010\u0015R\u001a\u0010;\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\r\"\u0004\b=\u0010\u000fR\u001a\u0010>\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0013\"\u0004\b?\u0010\u0015R\u000e\u0010@\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010A\u001a\u0004\u0018\u00010BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001e\u0010G\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010L\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001a\u0010M\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u0013\"\u0004\bO\u0010\u0015R\u001a\u0010P\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\r\"\u0004\bR\u0010\u000fR\u001a\u0010S\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\r\"\u0004\bU\u0010\u000fR\u001a\u0010V\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\r\"\u0004\bX\u0010\u000fR\u001a\u0010Y\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\u0013\"\u0004\b[\u0010\u0015R\u001a\u0010\\\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010\u0013\"\u0004\b^\u0010\u0015R\u001a\u0010_\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\u001f\"\u0004\ba\u0010!R\u001a\u0010b\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010\u0013\"\u0004\bd\u0010\u0015R\u001c\u0010e\u001a\u0004\u0018\u00010fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\u001a\u0010k\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010\u0013\"\u0004\bm\u0010\u0015R\u001c\u0010n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010\u0007\"\u0004\bp\u0010\tR\u001c\u0010q\u001a\u0004\u0018\u00010rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR\u001e\u0010w\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010L\u001a\u0004\bx\u0010I\"\u0004\by\u0010KR.\u0010z\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010{j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001`|X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0084\u0001"}, d2 = {"Ltv/danmaku/videoplayer/coreV2/transformer/MediaItemParams$Builder;", "", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "scheme", "", "getScheme", "()I", "setScheme", "(I)V", "enableHWCodex", "", "getEnableHWCodex", "()Z", "setEnableHWCodex", "(Z)V", "skipLoopFilter", "getSkipLoopFilter", "setSkipLoopFilter", "forceRenderLastFrame", "getForceRenderLastFrame", "setForceRenderLastFrame", "cacheTime", "", "getCacheTime", "()J", "setCacheTime", "(J)V", "startWhenPrepared", "getStartWhenPrepared", "setStartWhenPrepared", "trackerMode", "getTrackerMode", "setTrackerMode", "neuronSession", "getNeuronSession", "setNeuronSession", "trackerId", "getTrackerId", "setTrackerId", "startPosition", "getStartPosition", "setStartPosition", "isForceStartAccurateSeek", "setForceStartAccurateSeek", "accurateSeekTimeoutMs", "getAccurateSeekTimeoutMs", "setAccurateSeekTimeoutMs", "avid", "getAvid", "setAvid", "isHdr", "setHdr", "hdrType", "getHdrType", "setHdrType", "isDolbyVision", "setDolbyVision", "dolbyConfigPath", "p2pParams", "Ltv/danmaku/videoplayer/coreV2/transformer/P2PParams;", "getP2pParams", "()Ltv/danmaku/videoplayer/coreV2/transformer/P2PParams;", "setP2pParams", "(Ltv/danmaku/videoplayer/coreV2/transformer/P2PParams;)V", "screenState", "getScreenState", "()Ljava/lang/Integer;", "setScreenState", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "enableRawData", "getEnableRawData", "setEnableRawData", "videoStreamId", "getVideoStreamId", "setVideoStreamId", "audioStreamId", "getAudioStreamId", "setAudioStreamId", "ijkAudioStreamType", "getIjkAudioStreamType", "setIjkAudioStreamType", "enableAlphaLayer", "getEnableAlphaLayer", "setEnableAlphaLayer", "enableLiveSkipFrame", "getEnableLiveSkipFrame", "setEnableLiveSkipFrame", "liveStartLatency", "getLiveStartLatency", "setLiveStartLatency", "renderAfterPrepare", "getRenderAfterPrepare", "setRenderAfterPrepare", "recommendStartQualityRange", "", "getRecommendStartQualityRange", "()[I", "setRecommendStartQualityRange", "([I)V", "variableResolutionRatio", "getVariableResolutionRatio", "setVariableResolutionRatio", "abr", "getAbr", "setAbr", "volumeInfo", "Lcom/bilibili/lib/media/resource/VolumeInfo;", "getVolumeInfo", "()Lcom/bilibili/lib/media/resource/VolumeInfo;", "setVolumeInfo", "(Lcom/bilibili/lib/media/resource/VolumeInfo;)V", "startScreenRatio", "getStartScreenRatio", "setStartScreenRatio", "extraReportParams", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "putReportParam", "", "key", "value", "build", "Ltv/danmaku/videoplayer/coreV2/transformer/MediaItemParams;", "buildInterceptor", "playercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Builder {
        private String abr;
        private int accurateSeekTimeoutMs;
        private long avid;
        private long cacheTime;
        private boolean enableAlphaLayer;
        private boolean enableLiveSkipFrame;
        private boolean enableRawData;
        private HashMap<String, String> extraReportParams;
        private boolean forceRenderLastFrame;
        private int hdrType;
        private String id;
        private boolean isDolbyVision;
        private boolean isForceStartAccurateSeek;
        private boolean isHdr;
        private long liveStartLatency;
        private P2PParams p2pParams;
        private int[] recommendStartQualityRange;
        private int scheme;
        private Integer screenState;
        private int skipLoopFilter;
        private long startPosition;
        private Integer startScreenRatio;
        private boolean startWhenPrepared;
        private long trackerId;
        private int trackerMode;
        private boolean variableResolutionRatio;
        private VolumeInfo volumeInfo;
        private boolean enableHWCodex = true;
        private String neuronSession = "";
        private String dolbyConfigPath = "";
        private int videoStreamId = -1;
        private int audioStreamId = -1;
        private int ijkAudioStreamType = 3;
        private boolean renderAfterPrepare = true;

        public final String getId() {
            return this.id;
        }

        public final void setId(String str) {
            this.id = str;
        }

        public final int getScheme() {
            return this.scheme;
        }

        public final void setScheme(int i) {
            this.scheme = i;
        }

        public final boolean getEnableHWCodex() {
            return this.enableHWCodex;
        }

        public final void setEnableHWCodex(boolean z) {
            this.enableHWCodex = z;
        }

        public final int getSkipLoopFilter() {
            return this.skipLoopFilter;
        }

        public final void setSkipLoopFilter(int i) {
            this.skipLoopFilter = i;
        }

        public final boolean getForceRenderLastFrame() {
            return this.forceRenderLastFrame;
        }

        public final void setForceRenderLastFrame(boolean z) {
            this.forceRenderLastFrame = z;
        }

        public final long getCacheTime() {
            return this.cacheTime;
        }

        public final void setCacheTime(long j) {
            this.cacheTime = j;
        }

        public final boolean getStartWhenPrepared() {
            return this.startWhenPrepared;
        }

        public final void setStartWhenPrepared(boolean z) {
            this.startWhenPrepared = z;
        }

        public final int getTrackerMode() {
            return this.trackerMode;
        }

        public final void setTrackerMode(int i) {
            this.trackerMode = i;
        }

        public final String getNeuronSession() {
            return this.neuronSession;
        }

        public final void setNeuronSession(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.neuronSession = str;
        }

        public final long getTrackerId() {
            return this.trackerId;
        }

        public final void setTrackerId(long j) {
            this.trackerId = j;
        }

        public final long getStartPosition() {
            return this.startPosition;
        }

        public final void setStartPosition(long j) {
            this.startPosition = j;
        }

        public final boolean isForceStartAccurateSeek() {
            return this.isForceStartAccurateSeek;
        }

        public final void setForceStartAccurateSeek(boolean z) {
            this.isForceStartAccurateSeek = z;
        }

        public final int getAccurateSeekTimeoutMs() {
            return this.accurateSeekTimeoutMs;
        }

        public final void setAccurateSeekTimeoutMs(int i) {
            this.accurateSeekTimeoutMs = i;
        }

        public final long getAvid() {
            return this.avid;
        }

        public final void setAvid(long j) {
            this.avid = j;
        }

        public final boolean isHdr() {
            return this.isHdr;
        }

        public final void setHdr(boolean z) {
            this.isHdr = z;
        }

        public final int getHdrType() {
            return this.hdrType;
        }

        public final void setHdrType(int i) {
            this.hdrType = i;
        }

        public final boolean isDolbyVision() {
            return this.isDolbyVision;
        }

        public final void setDolbyVision(boolean z) {
            this.isDolbyVision = z;
        }

        public final P2PParams getP2pParams() {
            return this.p2pParams;
        }

        public final void setP2pParams(P2PParams p2PParams) {
            this.p2pParams = p2PParams;
        }

        public final Integer getScreenState() {
            return this.screenState;
        }

        public final void setScreenState(Integer num) {
            this.screenState = num;
        }

        public final boolean getEnableRawData() {
            return this.enableRawData;
        }

        public final void setEnableRawData(boolean z) {
            this.enableRawData = z;
        }

        public final int getVideoStreamId() {
            return this.videoStreamId;
        }

        public final void setVideoStreamId(int i) {
            this.videoStreamId = i;
        }

        public final int getAudioStreamId() {
            return this.audioStreamId;
        }

        public final void setAudioStreamId(int i) {
            this.audioStreamId = i;
        }

        public final int getIjkAudioStreamType() {
            return this.ijkAudioStreamType;
        }

        public final void setIjkAudioStreamType(int i) {
            this.ijkAudioStreamType = i;
        }

        public final boolean getEnableAlphaLayer() {
            return this.enableAlphaLayer;
        }

        public final void setEnableAlphaLayer(boolean z) {
            this.enableAlphaLayer = z;
        }

        public final boolean getEnableLiveSkipFrame() {
            return this.enableLiveSkipFrame;
        }

        public final void setEnableLiveSkipFrame(boolean z) {
            this.enableLiveSkipFrame = z;
        }

        public final long getLiveStartLatency() {
            return this.liveStartLatency;
        }

        public final void setLiveStartLatency(long j) {
            this.liveStartLatency = j;
        }

        public final boolean getRenderAfterPrepare() {
            return this.renderAfterPrepare;
        }

        public final void setRenderAfterPrepare(boolean z) {
            this.renderAfterPrepare = z;
        }

        public final int[] getRecommendStartQualityRange() {
            return this.recommendStartQualityRange;
        }

        public final void setRecommendStartQualityRange(int[] iArr) {
            this.recommendStartQualityRange = iArr;
        }

        public final boolean getVariableResolutionRatio() {
            return this.variableResolutionRatio;
        }

        public final void setVariableResolutionRatio(boolean z) {
            this.variableResolutionRatio = z;
        }

        public final String getAbr() {
            return this.abr;
        }

        public final void setAbr(String str) {
            this.abr = str;
        }

        public final VolumeInfo getVolumeInfo() {
            return this.volumeInfo;
        }

        public final void setVolumeInfo(VolumeInfo volumeInfo) {
            this.volumeInfo = volumeInfo;
        }

        public final Integer getStartScreenRatio() {
            return this.startScreenRatio;
        }

        public final void setStartScreenRatio(Integer num) {
            this.startScreenRatio = num;
        }

        public final void putReportParam(String key, String value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            if (this.extraReportParams == null) {
                this.extraReportParams = new HashMap<>();
            }
            HashMap<String, String> hashMap = this.extraReportParams;
            Intrinsics.checkNotNull(hashMap);
            hashMap.put(key, value);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0062  */
        /* JADX WARN: Removed duplicated region for block: B:11:0x0080  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final MediaItemParams build() {
            boolean z;
            boolean z2;
            int i;
            Pair pair;
            buildInterceptor();
            String str = this.id;
            int i2 = this.scheme;
            boolean z3 = this.enableHWCodex;
            int i3 = this.skipLoopFilter;
            boolean z4 = this.forceRenderLastFrame;
            long j = this.cacheTime;
            boolean z5 = this.startWhenPrepared;
            int i4 = this.trackerMode;
            String str2 = this.neuronSession;
            long j2 = this.trackerId;
            long j3 = this.startPosition;
            boolean z6 = this.isForceStartAccurateSeek;
            int i5 = this.accurateSeekTimeoutMs;
            long j4 = this.avid;
            int i6 = this.videoStreamId;
            int i7 = this.audioStreamId;
            int i8 = this.ijkAudioStreamType;
            boolean z7 = this.isHdr;
            int i9 = this.hdrType;
            boolean z8 = this.isDolbyVision;
            String str3 = this.dolbyConfigPath;
            P2PParams p2PParams = this.p2pParams;
            boolean z9 = this.enableRawData;
            int[] iArr = this.recommendStartQualityRange;
            if (iArr != null) {
                z = z9;
                if (iArr.length == 2) {
                    z2 = true;
                    if (z2) {
                        i = i7;
                        pair = null;
                    } else {
                        int[] iArr2 = this.recommendStartQualityRange;
                        Intrinsics.checkNotNull(iArr2);
                        Integer valueOf = Integer.valueOf(iArr2[0]);
                        i = i7;
                        int[] iArr3 = this.recommendStartQualityRange;
                        Intrinsics.checkNotNull(iArr3);
                        pair = new Pair(valueOf, Integer.valueOf(iArr3[1]));
                    }
                    return new MediaItemParams(str, i2, z3, i3, z4, j, z5, i4, str2, j2, j3, z6, i5, j4, i6, i, i8, z7, i9, z8, str3, p2PParams, z, pair, this.abr, this.volumeInfo, this.startScreenRatio, this.enableAlphaLayer, this.enableLiveSkipFrame, this.liveStartLatency, this.screenState, this.renderAfterPrepare, this.variableResolutionRatio, this.extraReportParams);
                }
            } else {
                z = z9;
            }
            z2 = false;
            if (z2) {
            }
            return new MediaItemParams(str, i2, z3, i3, z4, j, z5, i4, str2, j2, j3, z6, i5, j4, i6, i, i8, z7, i9, z8, str3, p2PParams, z, pair, this.abr, this.volumeInfo, this.startScreenRatio, this.enableAlphaLayer, this.enableLiveSkipFrame, this.liveStartLatency, this.screenState, this.renderAfterPrepare, this.variableResolutionRatio, this.extraReportParams);
        }

        private final void buildInterceptor() {
            if (this.isDolbyVision) {
                String configPath = DolbyVisionConfigManager.INSTANCE.getConfigPath();
                if (configPath == null) {
                    configPath = "";
                }
                this.dolbyConfigPath = configPath;
            }
        }
    }

    /* compiled from: IMediaItemTransformer.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\bø\u0001\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0018"}, d2 = {"Ltv/danmaku/videoplayer/coreV2/transformer/MediaItemParams$Companion;", "", "<init>", "()V", "build", "Ltv/danmaku/videoplayer/coreV2/transformer/MediaItemParams;", "block", "Lkotlin/Function1;", "Ltv/danmaku/videoplayer/coreV2/transformer/MediaItemParams$Builder;", "", "Lkotlin/ExtensionFunctionType;", "IJK_REPORT_KEY_FROM_SPMID", "", "IJK_REPORT_KEY_SPMID", "IJK_REPORT_KEY_BIZ_TYPE", "IJK_REPORT_KEY_MEDIA_SOURCE", "IJK_REPORT_KEY_FLASH", "IJK_REPORT_KEY_FORCE_REPORT", "IJK_REPORT_KEY_LIVE_SCENE", "IJK_REPORT_KEY_LIVE_MODE", "IJK_REPORT_KEY_SEASON_TYPE", "IJK_REPORT_KEY_SEASON_ID", "IJK_REPORT_KEY_EPID", "IJK_REPORT_KEY_IS_DRM_RESOURCE", "playercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MediaItemParams build(Function1<? super Builder, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            Builder builder = new Builder();
            function1.invoke(builder);
            return builder.build();
        }
    }
}