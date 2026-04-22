package tv.danmaku.video.resolver;

import android.content.Context;
import com.bapis.bilibili.app.playurl.v1.ArcConf;
import com.bapis.bilibili.app.playurl.v1.Business;
import com.bapis.bilibili.app.playurl.v1.CodeType;
import com.bapis.bilibili.app.playurl.v1.DashItem;
import com.bapis.bilibili.app.playurl.v1.DashVideo;
import com.bapis.bilibili.app.playurl.v1.DolbyItem;
import com.bapis.bilibili.app.playurl.v1.LossLessItem;
import com.bapis.bilibili.app.playurl.v1.PlayAbilityConf;
import com.bapis.bilibili.app.playurl.v1.PlayArcConf;
import com.bapis.bilibili.app.playurl.v1.PlayURLMoss;
import com.bapis.bilibili.app.playurl.v1.PlayViewReply;
import com.bapis.bilibili.app.playurl.v1.PlayViewReq;
import com.bapis.bilibili.app.playurl.v1.ResponseUrl;
import com.bapis.bilibili.app.playurl.v1.SegmentVideo;
import com.bapis.bilibili.app.playurl.v1.Stream;
import com.bapis.bilibili.app.playurl.v1.StreamInfo;
import com.bapis.bilibili.app.playurl.v1.VideoInfo;
import com.bapis.bilibili.playershared.UnsupportScene;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.ServicesProvider;
import com.bilibili.lib.media.resolver.exception.ResolveException;
import com.bilibili.lib.media.resolver.exception.ResolveHttpException;
import com.bilibili.lib.media.resolver.exception.ResolveMediaSourceException;
import com.bilibili.lib.media.resolver2.IMediaResolverV2;
import com.bilibili.lib.media.resolver2.IResolveParams;
import com.bilibili.lib.media.resource.AudioEnhancementResource;
import com.bilibili.lib.media.resource.DashMediaIndex;
import com.bilibili.lib.media.resource.DashResource;
import com.bilibili.lib.media.resource.ExtraInfo;
import com.bilibili.lib.media.resource.MediaResource;
import com.bilibili.lib.media.resource.PlayConfig;
import com.bilibili.lib.media.resource.PlayIndex;
import com.bilibili.lib.media.resource.PlayStreamLimit;
import com.bilibili.lib.media.resource.Segment;
import com.bilibili.lib.media.resource.VolumeInfo;
import com.bilibili.lib.media.util.PlayerCloudSetting;
import com.bilibili.lib.moss.api.CallOptions;
import com.bilibili.lib.moss.api.MossException;
import com.bilibili.moduleservice.videodownload.VideoDownloadService;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.videospace.AuthorSpaceHeaderVideoModel;
import tv.danmaku.bili.utils.LoginSceneProcessor;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkCodecHelper;
import tv.danmaku.ijk.media.player.IjkMediaAsset;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: UGCDefaultResolver.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 <2\u00020\u0001:\u0001<B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0012H\u0002J\u001a\u0010\u0016\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0010H\u0002J&\u0010\u0017\u001a\u0004\u0018\u00010\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u0010H\u0002J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\tH\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002Jv\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\u00152\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020)2\b\u0010-\u001a\u0004\u0018\u00010\u00052\b\u0010.\u001a\u0004\u0018\u00010\u00052\u0006\u0010/\u001a\u00020)2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0015H\u0002J\u001a\u00105\u001a\u0004\u0018\u00010\u00052\u0006\u00106\u001a\u00020\u00052\u0006\u00107\u001a\u00020\u0005H\u0002J\u0010\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0002R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006="}, d2 = {"Ltv/danmaku/video/resolver/UGCDefaultResolver;", "Lcom/bilibili/lib/media/resolver2/IMediaResolverV2;", "<init>", "()V", "resolveType", "", "getResolveType", "()Ljava/lang/String;", "resolveMediaResource", "Lcom/bilibili/lib/media/resource/MediaResource;", "context", "Landroid/content/Context;", "resolveParams", "Lcom/bilibili/lib/media/resolver2/IResolveParams;", "getPlayViewRpc", "resourceParams", "Ltv/danmaku/video/resolver/UGCResolverParams;", "transformUnSupportSceneList", "", "Lcom/bapis/bilibili/playershared/UnsupportScene;", "scenes", "", "resolveFromDownloadFile", "mergeMediaResource", "mediaResourceRemote", "mediaResourceLocal", "processVolumeInfo", "", "videoInfo", "Lcom/bapis/bilibili/app/playurl/v1/VideoInfo;", "mediaResource", "checkStreamSupport", "", "stream", "Lcom/bapis/bilibili/app/playurl/v1/Stream;", "requestPlayView", "Lcom/bapis/bilibili/app/playurl/v1/PlayViewReply;", "aid", "cid", IjkMediaPlayer.OnNativeInvokeListener.ARG_QN, "fnver", "", "fnval", "download", "forceHost", "fromSpmid", "spmid", "teenagersMode", "codecType", "Ltv/danmaku/ijk/media/player/IjkMediaAsset$VideoCodecType;", LoginSceneProcessor.BIZ_KEY, "Lcom/bapis/bilibili/app/playurl/v1/Business;", "volumeBalance", "generateTypeTag", IjkMediaMeta.IJKM_KEY_FORMAT, AuthorSpaceHeaderVideoModel.EXTRA_PARAM_QUALITY, "transformDashAudio", "Lcom/bilibili/lib/media/resource/DashMediaIndex;", "item", "Lcom/bapis/bilibili/app/playurl/v1/DashItem;", "Companion", "ugcresolver_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class UGCDefaultResolver implements IMediaResolverV2 {
    public static final Companion Companion = new Companion(null);
    private static final String FF_KEY_DOLBY_VISION_FRAME_CHECK = "videodetail.enable_dolby_vision_frame_check";
    private static final int QUALITY_DOLBY_VISION = 126;
    private static final String TAG = "UGCDefaultResolver";

    /* compiled from: UGCDefaultResolver.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[DolbyItem.Type.values().length];
            try {
                iArr[DolbyItem.Type.ATMOS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[DolbyItem.Type.COMMON.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[IjkMediaAsset.VideoCodecType.values().length];
            try {
                iArr2[IjkMediaAsset.VideoCodecType.AV1.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr2[IjkMediaAsset.VideoCodecType.H265.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* compiled from: UGCDefaultResolver.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Ltv/danmaku/video/resolver/UGCDefaultResolver$Companion;", "", "<init>", "()V", "TAG", "", "FF_KEY_DOLBY_VISION_FRAME_CHECK", "QUALITY_DOLBY_VISION", "", "ugcresolver_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public String getResolveType() {
        return "vupload";
    }

    public MediaResource resolveMediaResource(Context context, IResolveParams resolveParams) throws ResolveException, ResolveHttpException, ResolveMediaSourceException.ResolveInvalidCodeException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(resolveParams, "resolveParams");
        try {
            UGCResolverParams rp = resolveParams instanceof UGCResolverParams ? (UGCResolverParams) resolveParams : null;
            if (rp == null) {
                throw new ResolveMediaSourceException.ResolveInvalidCodeException("convert resourceParams to  UGCResolverParams failed ", -11);
            }
            if (!rp.getResolveFromDownloadedFile()) {
                return getPlayViewRpc(rp);
            }
            MediaResource $this$resolveMediaResource_u24lambda_u240 = resolveFromDownloadFile(context, rp);
            if ($this$resolveMediaResource_u24lambda_u240 != null) {
                $this$resolveMediaResource_u24lambda_u240.sourceForm(3);
                if (!((UGCResolverParams) resolveParams).getForceLocalOnly()) {
                    $this$resolveMediaResource_u24lambda_u240.setResolvedIndex(-1);
                    PlayIndex it = $this$resolveMediaResource_u24lambda_u240.mVodIndex.getPlayIndexByQuality((int) ((UGCResolverParams) resolveParams).getRealQuality());
                    if (it != null) {
                        ArrayList arrayList = $this$resolveMediaResource_u24lambda_u240.mVodIndex.mVodList;
                        $this$resolveMediaResource_u24lambda_u240.setResolvedIndex(arrayList != null ? arrayList.indexOf(it) : -1);
                    }
                    if ($this$resolveMediaResource_u24lambda_u240.getResolvedIndex() == -1) {
                        BLog.e(TAG, "Not found quality: " + ((UGCResolverParams) resolveParams).getRealQuality());
                    }
                }
                $this$resolveMediaResource_u24lambda_u240.setVolumeInfo((VolumeInfo) null);
                return $this$resolveMediaResource_u24lambda_u240;
            }
            return null;
        } catch (ResolveException e) {
            throw e;
        } catch (ResolveHttpException e2) {
            throw e2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:300:0x0af7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final MediaResource getPlayViewRpc(UGCResolverParams resourceParams) throws ResolveException, ResolveHttpException {
        String str;
        DefaultConstructorMarker defaultConstructorMarker;
        MossException e;
        Exception e2;
        String message;
        UGCDefaultResolver uGCDefaultResolver;
        int resolveIndex;
        int ignoredQualityCount;
        boolean mExpectedQualityNoRexcode;
        try {
            long avid = resourceParams.getAvid();
            long cid = resourceParams.getCid();
            IjkMediaAsset.VideoCodecType codecType = resourceParams.getFinalCodecType();
            BLog.i(TAG, "start request playview, avid:" + avid + ", cid:" + cid + ", codecType:" + codecType);
            try {
                try {
                    PlayViewReply playViewReply = requestPlayView(avid, cid, resourceParams.getRealQuality(), resourceParams.getFnVer(), resourceParams.getFnVal(), resourceParams.getRequestFromDownloader(), resourceParams.getDomainParams(), resourceParams.getFromSpmid(), resourceParams.getSpmid(), resourceParams.getTeenagerMode(), codecType, resourceParams.getBusiness(), resourceParams.getVolumeBalance());
                    if (playViewReply == null) {
                        return null;
                    }
                    try {
                        MediaResource mediaResource = new MediaResource();
                        ExtraInfo extraInfo = new ExtraInfo();
                        mediaResource.setExtraInfo(extraInfo);
                        PlayConfig playConfig = new PlayConfig();
                        if (playViewReply.hasPlayArc()) {
                            try {
                                PlayArcConf basePC = playViewReply.getPlayArc();
                                if (basePC.hasBackgroundPlayConf()) {
                                    ArcConf bgConf = basePC.getBackgroundPlayConf();
                                    PlayConfig.PlayMenuConfig.ExtraContent extraContent = null;
                                    if (bgConf.hasExtraContent()) {
                                        try {
                                            try {
                                                extraContent = new PlayConfig.PlayMenuConfig.ExtraContent(bgConf.getExtraContent().getDisabledReason(), bgConf.getExtraContent().getDisabledCode());
                                            } catch (MossException e3) {
                                                e = e3;
                                                e = e;
                                                str = TAG;
                                                defaultConstructorMarker = null;
                                                BLog.e(str, e);
                                                message = e.getMessage();
                                                if (message == null) {
                                                    message = "moss error";
                                                }
                                                throw new ResolveHttpException(message, 0, 2, defaultConstructorMarker);
                                            }
                                        } catch (Exception e4) {
                                            e = e4;
                                            e2 = e;
                                            str = TAG;
                                            BLog.e(str, e2);
                                            throw new ResolveException(e2.getMessage());
                                        }
                                    }
                                    boolean isSupport = bgConf.getIsSupport();
                                    boolean disabled = bgConf.getDisabled();
                                    PlayConfig.PlayConfigType playConfigType = PlayConfig.PlayConfigType.BACKGROUNDPLAY;
                                    List<Long> unsupportSceneList = bgConf.getUnsupportSceneList();
                                    Intrinsics.checkNotNullExpressionValue(unsupportSceneList, "getUnsupportSceneList(...)");
                                    try {
                                        uGCDefaultResolver = this;
                                        playConfig.mBackgroundPlayConfig = new PlayConfig.PlayMenuConfig(isSupport, disabled, extraContent, playConfigType, transformUnSupportSceneList(unsupportSceneList));
                                    } catch (MossException e5) {
                                        e = e5;
                                        e = e;
                                        str = TAG;
                                        defaultConstructorMarker = null;
                                        BLog.e(str, e);
                                        message = e.getMessage();
                                        if (message == null) {
                                        }
                                        throw new ResolveHttpException(message, 0, 2, defaultConstructorMarker);
                                    } catch (Exception e6) {
                                        e = e6;
                                        e2 = e;
                                        str = TAG;
                                        BLog.e(str, e2);
                                        throw new ResolveException(e2.getMessage());
                                    }
                                } else {
                                    uGCDefaultResolver = this;
                                }
                                if (basePC.hasFlipConf()) {
                                    boolean isSupport2 = basePC.getFlipConf().getIsSupport();
                                    PlayConfig.PlayConfigType playConfigType2 = PlayConfig.PlayConfigType.FLIPCONF;
                                    List<Long> unsupportSceneList2 = basePC.getFlipConf().getUnsupportSceneList();
                                    Intrinsics.checkNotNullExpressionValue(unsupportSceneList2, "getUnsupportSceneList(...)");
                                    playConfig.mFlipConfig = new PlayConfig.PlayMenuConfig(isSupport2, playConfigType2, uGCDefaultResolver.transformUnSupportSceneList(unsupportSceneList2));
                                }
                                if (basePC.hasCastConf()) {
                                    PlayConfig.PlayMenuConfig.ExtraContent extraContent2 = basePC.getCastConf().hasExtraContent() ? new PlayConfig.PlayMenuConfig.ExtraContent(basePC.getCastConf().getExtraContent().getDisabledReason(), basePC.getCastConf().getExtraContent().getDisabledCode()) : null;
                                    boolean isSupport3 = basePC.getCastConf().getIsSupport();
                                    boolean disabled2 = basePC.getCastConf().getDisabled();
                                    PlayConfig.PlayConfigType playConfigType3 = PlayConfig.PlayConfigType.CASTCONF;
                                    List<Long> unsupportSceneList3 = basePC.getCastConf().getUnsupportSceneList();
                                    Intrinsics.checkNotNullExpressionValue(unsupportSceneList3, "getUnsupportSceneList(...)");
                                    playConfig.mCastConfig = new PlayConfig.PlayMenuConfig(isSupport3, disabled2, extraContent2, playConfigType3, uGCDefaultResolver.transformUnSupportSceneList(unsupportSceneList3));
                                }
                                if (basePC.hasFeedbackConf()) {
                                    boolean isSupport4 = basePC.getFeedbackConf().getIsSupport();
                                    PlayConfig.PlayConfigType playConfigType4 = PlayConfig.PlayConfigType.FEEDBACK;
                                    List<Long> unsupportSceneList4 = basePC.getFeedbackConf().getUnsupportSceneList();
                                    Intrinsics.checkNotNullExpressionValue(unsupportSceneList4, "getUnsupportSceneList(...)");
                                    playConfig.mFeedbackConfig = new PlayConfig.PlayMenuConfig(isSupport4, playConfigType4, uGCDefaultResolver.transformUnSupportSceneList(unsupportSceneList4));
                                }
                                if (basePC.hasSubtitleConf()) {
                                    boolean isSupport5 = basePC.getSubtitleConf().getIsSupport();
                                    PlayConfig.PlayConfigType playConfigType5 = PlayConfig.PlayConfigType.SUBTITLE;
                                    List<Long> unsupportSceneList5 = basePC.getSubtitleConf().getUnsupportSceneList();
                                    Intrinsics.checkNotNullExpressionValue(unsupportSceneList5, "getUnsupportSceneList(...)");
                                    playConfig.mSubtitleConfig = new PlayConfig.PlayMenuConfig(isSupport5, playConfigType5, uGCDefaultResolver.transformUnSupportSceneList(unsupportSceneList5));
                                }
                                if (basePC.hasPlaybackRateConf()) {
                                    boolean isSupport6 = basePC.getPlaybackRateConf().getIsSupport();
                                    PlayConfig.PlayConfigType playConfigType6 = PlayConfig.PlayConfigType.PLAYBACKRATE;
                                    List<Long> unsupportSceneList6 = basePC.getPlaybackRateConf().getUnsupportSceneList();
                                    Intrinsics.checkNotNullExpressionValue(unsupportSceneList6, "getUnsupportSceneList(...)");
                                    playConfig.mPlaybackRateConfig = new PlayConfig.PlayMenuConfig(isSupport6, playConfigType6, uGCDefaultResolver.transformUnSupportSceneList(unsupportSceneList6));
                                }
                                if (basePC.hasTimeUpConf()) {
                                    boolean isSupport7 = basePC.getTimeUpConf().getIsSupport();
                                    PlayConfig.PlayConfigType playConfigType7 = PlayConfig.PlayConfigType.TIMEUP;
                                    List<Long> unsupportSceneList7 = basePC.getTimeUpConf().getUnsupportSceneList();
                                    Intrinsics.checkNotNullExpressionValue(unsupportSceneList7, "getUnsupportSceneList(...)");
                                    playConfig.mTimeUpConfig = new PlayConfig.PlayMenuConfig(isSupport7, playConfigType7, uGCDefaultResolver.transformUnSupportSceneList(unsupportSceneList7));
                                }
                                if (basePC.hasPlaybackModeConf()) {
                                    boolean isSupport8 = basePC.getPlaybackModeConf().getIsSupport();
                                    PlayConfig.PlayConfigType playConfigType8 = PlayConfig.PlayConfigType.PLAYBACKMODE;
                                    List<Long> unsupportSceneList8 = basePC.getPlaybackModeConf().getUnsupportSceneList();
                                    Intrinsics.checkNotNullExpressionValue(unsupportSceneList8, "getUnsupportSceneList(...)");
                                    playConfig.mPlaybackModeConfig = new PlayConfig.PlayMenuConfig(isSupport8, playConfigType8, uGCDefaultResolver.transformUnSupportSceneList(unsupportSceneList8));
                                }
                                if (basePC.hasScaleModeConf()) {
                                    boolean isSupport9 = basePC.getScaleModeConf().getIsSupport();
                                    PlayConfig.PlayConfigType playConfigType9 = PlayConfig.PlayConfigType.SCALEMODE;
                                    List<Long> unsupportSceneList9 = basePC.getScaleModeConf().getUnsupportSceneList();
                                    Intrinsics.checkNotNullExpressionValue(unsupportSceneList9, "getUnsupportSceneList(...)");
                                    playConfig.mScaleModeConfig = new PlayConfig.PlayMenuConfig(isSupport9, playConfigType9, uGCDefaultResolver.transformUnSupportSceneList(unsupportSceneList9));
                                }
                                if (basePC.hasLikeConf()) {
                                    boolean isSupport10 = basePC.getLikeConf().getIsSupport();
                                    PlayConfig.PlayConfigType playConfigType10 = PlayConfig.PlayConfigType.LIKE;
                                    List<Long> unsupportSceneList10 = basePC.getLikeConf().getUnsupportSceneList();
                                    Intrinsics.checkNotNullExpressionValue(unsupportSceneList10, "getUnsupportSceneList(...)");
                                    playConfig.mLikeConfig = new PlayConfig.PlayMenuConfig(isSupport10, playConfigType10, uGCDefaultResolver.transformUnSupportSceneList(unsupportSceneList10));
                                }
                                if (basePC.hasDislikeConf()) {
                                    boolean isSupport11 = basePC.getDislikeConf().getIsSupport();
                                    PlayConfig.PlayConfigType playConfigType11 = PlayConfig.PlayConfigType.DISLIKE;
                                    List<Long> unsupportSceneList11 = basePC.getDislikeConf().getUnsupportSceneList();
                                    Intrinsics.checkNotNullExpressionValue(unsupportSceneList11, "getUnsupportSceneList(...)");
                                    playConfig.mDislikeConfig = new PlayConfig.PlayMenuConfig(isSupport11, playConfigType11, uGCDefaultResolver.transformUnSupportSceneList(unsupportSceneList11));
                                }
                                if (basePC.hasCoinConf()) {
                                    boolean isSupport12 = basePC.getCoinConf().getIsSupport();
                                    PlayConfig.PlayConfigType playConfigType12 = PlayConfig.PlayConfigType.COIN;
                                    List<Long> unsupportSceneList12 = basePC.getCoinConf().getUnsupportSceneList();
                                    Intrinsics.checkNotNullExpressionValue(unsupportSceneList12, "getUnsupportSceneList(...)");
                                    playConfig.mCoinConfig = new PlayConfig.PlayMenuConfig(isSupport12, playConfigType12, uGCDefaultResolver.transformUnSupportSceneList(unsupportSceneList12));
                                }
                                if (basePC.hasElecConf()) {
                                    boolean isSupport13 = basePC.getElecConf().getIsSupport();
                                    PlayConfig.PlayConfigType playConfigType13 = PlayConfig.PlayConfigType.CHARGE;
                                    List<Long> unsupportSceneList13 = basePC.getElecConf().getUnsupportSceneList();
                                    Intrinsics.checkNotNullExpressionValue(unsupportSceneList13, "getUnsupportSceneList(...)");
                                    playConfig.mChargeConfig = new PlayConfig.PlayMenuConfig(isSupport13, playConfigType13, uGCDefaultResolver.transformUnSupportSceneList(unsupportSceneList13));
                                }
                                if (basePC.hasShareConf()) {
                                    boolean isSupport14 = basePC.getShareConf().getIsSupport();
                                    PlayConfig.PlayConfigType playConfigType14 = PlayConfig.PlayConfigType.SHARE;
                                    List<Long> unsupportSceneList14 = basePC.getShareConf().getUnsupportSceneList();
                                    Intrinsics.checkNotNullExpressionValue(unsupportSceneList14, "getUnsupportSceneList(...)");
                                    playConfig.mShareConfig = new PlayConfig.PlayMenuConfig(isSupport14, playConfigType14, uGCDefaultResolver.transformUnSupportSceneList(unsupportSceneList14));
                                }
                                if (basePC.hasScreenShotConf()) {
                                    boolean isSupport15 = basePC.getScreenShotConf().getIsSupport();
                                    PlayConfig.PlayConfigType playConfigType15 = PlayConfig.PlayConfigType.SNAPSHOT;
                                    List<Long> unsupportSceneList15 = basePC.getScreenShotConf().getUnsupportSceneList();
                                    Intrinsics.checkNotNullExpressionValue(unsupportSceneList15, "getUnsupportSceneList(...)");
                                    playConfig.mSnapshotConfig = new PlayConfig.PlayMenuConfig(isSupport15, playConfigType15, uGCDefaultResolver.transformUnSupportSceneList(unsupportSceneList15));
                                }
                                if (basePC.hasScreenRecordingConf()) {
                                    boolean isSupport16 = basePC.getScreenRecordingConf().getIsSupport();
                                    PlayConfig.PlayConfigType playConfigType16 = PlayConfig.PlayConfigType.SCREENRECORD;
                                    List<Long> unsupportSceneList16 = basePC.getScreenRecordingConf().getUnsupportSceneList();
                                    Intrinsics.checkNotNullExpressionValue(unsupportSceneList16, "getUnsupportSceneList(...)");
                                    playConfig.mRecordConfig = new PlayConfig.PlayMenuConfig(isSupport16, playConfigType16, uGCDefaultResolver.transformUnSupportSceneList(unsupportSceneList16));
                                }
                                if (basePC.hasLockScreenConf()) {
                                    boolean isSupport17 = basePC.getLockScreenConf().getIsSupport();
                                    PlayConfig.PlayConfigType playConfigType17 = PlayConfig.PlayConfigType.LOCKSCREEN;
                                    List<Long> unsupportSceneList17 = basePC.getLockScreenConf().getUnsupportSceneList();
                                    Intrinsics.checkNotNullExpressionValue(unsupportSceneList17, "getUnsupportSceneList(...)");
                                    playConfig.mLockScreenConfig = new PlayConfig.PlayMenuConfig(isSupport17, playConfigType17, uGCDefaultResolver.transformUnSupportSceneList(unsupportSceneList17));
                                }
                                if (basePC.hasRecommendConf()) {
                                    boolean isSupport18 = basePC.getRecommendConf().getIsSupport();
                                    PlayConfig.PlayConfigType playConfigType18 = PlayConfig.PlayConfigType.RECOMMEND;
                                    List<Long> unsupportSceneList18 = basePC.getRecommendConf().getUnsupportSceneList();
                                    Intrinsics.checkNotNullExpressionValue(unsupportSceneList18, "getUnsupportSceneList(...)");
                                    playConfig.mRecommendConfig = new PlayConfig.PlayMenuConfig(isSupport18, playConfigType18, uGCDefaultResolver.transformUnSupportSceneList(unsupportSceneList18));
                                }
                                if (basePC.hasPlaybackSpeedConf()) {
                                    boolean isSupport19 = basePC.getPlaybackSpeedConf().getIsSupport();
                                    PlayConfig.PlayConfigType playConfigType19 = PlayConfig.PlayConfigType.PLAYBACKSPEED;
                                    List<Long> unsupportSceneList19 = basePC.getPlaybackSpeedConf().getUnsupportSceneList();
                                    Intrinsics.checkNotNullExpressionValue(unsupportSceneList19, "getUnsupportSceneList(...)");
                                    playConfig.mPlaybackSpeedConfig = new PlayConfig.PlayMenuConfig(isSupport19, playConfigType19, uGCDefaultResolver.transformUnSupportSceneList(unsupportSceneList19));
                                }
                                if (basePC.hasDefinitionConf()) {
                                    boolean isSupport20 = basePC.getDefinitionConf().getIsSupport();
                                    PlayConfig.PlayConfigType playConfigType20 = PlayConfig.PlayConfigType.QUALITY;
                                    List<Long> unsupportSceneList20 = basePC.getDefinitionConf().getUnsupportSceneList();
                                    Intrinsics.checkNotNullExpressionValue(unsupportSceneList20, "getUnsupportSceneList(...)");
                                    playConfig.mQualityConfig = new PlayConfig.PlayMenuConfig(isSupport20, playConfigType20, uGCDefaultResolver.transformUnSupportSceneList(unsupportSceneList20));
                                }
                                if (basePC.hasSelectionsConf()) {
                                    boolean isSupport21 = basePC.getSelectionsConf().getIsSupport();
                                    PlayConfig.PlayConfigType playConfigType21 = PlayConfig.PlayConfigType.PAGES;
                                    List<Long> unsupportSceneList21 = basePC.getSelectionsConf().getUnsupportSceneList();
                                    Intrinsics.checkNotNullExpressionValue(unsupportSceneList21, "getUnsupportSceneList(...)");
                                    playConfig.mPagesConfig = new PlayConfig.PlayMenuConfig(isSupport21, playConfigType21, uGCDefaultResolver.transformUnSupportSceneList(unsupportSceneList21));
                                }
                                if (basePC.hasNextConf()) {
                                    boolean isSupport22 = basePC.getNextConf().getIsSupport();
                                    PlayConfig.PlayConfigType playConfigType22 = PlayConfig.PlayConfigType.NEXT;
                                    List<Long> unsupportSceneList22 = basePC.getNextConf().getUnsupportSceneList();
                                    Intrinsics.checkNotNullExpressionValue(unsupportSceneList22, "getUnsupportSceneList(...)");
                                    playConfig.mNextConfig = new PlayConfig.PlayMenuConfig(isSupport22, playConfigType22, uGCDefaultResolver.transformUnSupportSceneList(unsupportSceneList22));
                                }
                                if (basePC.hasEditDmConf()) {
                                    boolean isSupport23 = basePC.getEditDmConf().getIsSupport();
                                    PlayConfig.PlayConfigType playConfigType23 = PlayConfig.PlayConfigType.DANMAKU;
                                    List<Long> unsupportSceneList23 = basePC.getEditDmConf().getUnsupportSceneList();
                                    Intrinsics.checkNotNullExpressionValue(unsupportSceneList23, "getUnsupportSceneList(...)");
                                    playConfig.mDanmakuConfig = new PlayConfig.PlayMenuConfig(isSupport23, playConfigType23, uGCDefaultResolver.transformUnSupportSceneList(unsupportSceneList23));
                                }
                                if (basePC.hasSmallWindowConf()) {
                                    boolean isSupport24 = basePC.getSmallWindowConf().getIsSupport();
                                    PlayConfig.PlayConfigType playConfigType24 = PlayConfig.PlayConfigType.MINIPLAYER;
                                    List<Long> unsupportSceneList24 = basePC.getSmallWindowConf().getUnsupportSceneList();
                                    Intrinsics.checkNotNullExpressionValue(unsupportSceneList24, "getUnsupportSceneList(...)");
                                    playConfig.mMiniPlayerConfig = new PlayConfig.PlayMenuConfig(isSupport24, playConfigType24, uGCDefaultResolver.transformUnSupportSceneList(unsupportSceneList24));
                                }
                                if (basePC.hasOuterDmConf()) {
                                    boolean isSupport25 = basePC.getOuterDmConf().getIsSupport();
                                    PlayConfig.PlayConfigType playConfigType25 = PlayConfig.PlayConfigType.OUTDANMAKUSETTINGSWITCH;
                                    List<Long> unsupportSceneList25 = basePC.getOuterDmConf().getUnsupportSceneList();
                                    Intrinsics.checkNotNullExpressionValue(unsupportSceneList25, "getUnsupportSceneList(...)");
                                    playConfig.mOuterDanmakuSettingSwitchConfig = new PlayConfig.PlayMenuConfig(isSupport25, playConfigType25, uGCDefaultResolver.transformUnSupportSceneList(unsupportSceneList25));
                                }
                                if (basePC.hasInnerDmConf()) {
                                    boolean isSupport26 = basePC.getInnerDmConf().getIsSupport();
                                    PlayConfig.PlayConfigType playConfigType26 = PlayConfig.PlayConfigType.INNERDANMAKUSETTINGSWITCH;
                                    List<Long> unsupportSceneList26 = basePC.getInnerDmConf().getUnsupportSceneList();
                                    Intrinsics.checkNotNullExpressionValue(unsupportSceneList26, "getUnsupportSceneList(...)");
                                    playConfig.mInnerDanmakuSettingSwitchConfig = new PlayConfig.PlayMenuConfig(isSupport26, playConfigType26, uGCDefaultResolver.transformUnSupportSceneList(unsupportSceneList26));
                                }
                                if (basePC.hasPanoramaConf()) {
                                    boolean isSupport27 = basePC.getPanoramaConf().getIsSupport();
                                    PlayConfig.PlayConfigType playConfigType27 = PlayConfig.PlayConfigType.WHOLESCENE;
                                    List<Long> unsupportSceneList27 = basePC.getPanoramaConf().getUnsupportSceneList();
                                    Intrinsics.checkNotNullExpressionValue(unsupportSceneList27, "getUnsupportSceneList(...)");
                                    playConfig.mWholeSceneConfig = new PlayConfig.PlayMenuConfig(isSupport27, playConfigType27, uGCDefaultResolver.transformUnSupportSceneList(unsupportSceneList27));
                                }
                                if (basePC.hasDolbyConf()) {
                                    boolean isSupport28 = basePC.getDolbyConf().getIsSupport();
                                    PlayConfig.PlayConfigType playConfigType28 = PlayConfig.PlayConfigType.DOLBY;
                                    List<Long> unsupportSceneList28 = basePC.getDolbyConf().getUnsupportSceneList();
                                    Intrinsics.checkNotNullExpressionValue(unsupportSceneList28, "getUnsupportSceneList(...)");
                                    playConfig.mDolbyConfig = new PlayConfig.PlayMenuConfig(isSupport28, playConfigType28, uGCDefaultResolver.transformUnSupportSceneList(unsupportSceneList28));
                                }
                                if (basePC.hasLossLessConf()) {
                                    playConfig.mHiResConfig = new PlayConfig.PlayMenuConfig(basePC.getLossLessConf().getIsSupport(), PlayConfig.PlayConfigType.HIRES);
                                }
                                if (basePC.hasColorFilterConf()) {
                                    boolean isSupport29 = basePC.getColorFilterConf().getIsSupport();
                                    PlayConfig.PlayConfigType playConfigType29 = PlayConfig.PlayConfigType.COLORFILTER;
                                    List<Long> unsupportSceneList29 = basePC.getColorFilterConf().getUnsupportSceneList();
                                    Intrinsics.checkNotNullExpressionValue(unsupportSceneList29, "getUnsupportSceneList(...)");
                                    playConfig.mFilterConfig = new PlayConfig.PlayMenuConfig(isSupport29, playConfigType29, uGCDefaultResolver.transformUnSupportSceneList(unsupportSceneList29));
                                }
                            } catch (MossException e7) {
                                e = e7;
                            } catch (Exception e8) {
                                e = e8;
                            }
                        } else {
                            uGCDefaultResolver = this;
                        }
                        mediaResource.setPlayConfig(playConfig);
                        if (playViewReply.hasPlayConf()) {
                            PlayAbilityConf config = playViewReply.getPlayConf();
                            if (config.hasPanoramaConf() && config.getPanoramaConf().hasConfValue()) {
                                PlayerCloudSetting.INSTANCE.setSettingBooleanValue(PlayerCloudSetting.Setting.WholeScreen, config.getPanoramaConf().getConfValue().getSwitchVal(), true);
                            }
                            if (config.hasDolbyConf() && config.getDolbyConf().hasConfValue()) {
                                PlayerCloudSetting.INSTANCE.setSettingBooleanValue(PlayerCloudSetting.Setting.DolbyAudio, config.getDolbyConf().getConfValue().getSwitchVal(), true);
                            }
                            if (config.hasLossLessConf() && config.getLossLessConf().hasConfValue()) {
                                PlayerCloudSetting.INSTANCE.setSettingBooleanValue(PlayerCloudSetting.Setting.HiRes, config.getLossLessConf().getConfValue().getSwitchVal(), true);
                            }
                            if (config.hasBackgroundPlayConf() && config.getBackgroundPlayConf().hasConfValue()) {
                                PlayerCloudSetting.INSTANCE.setSettingBooleanValue(PlayerCloudSetting.Setting.BackgroundPlay, config.getBackgroundPlayConf().getConfValue().getSwitchVal(), true);
                            }
                            if (config.hasSubtitleConf() && config.getSubtitleConf().hasConfValue()) {
                                PlayerCloudSetting.INSTANCE.setSettingBooleanValue(PlayerCloudSetting.Setting.Subtitle, config.getSubtitleConf().getConfValue().getSwitchVal(), true);
                            }
                            if (config.hasColorFilterConf() && config.getColorFilterConf().hasConfValue()) {
                                PlayerCloudSetting.INSTANCE.setSettingLongValue(PlayerCloudSetting.Setting.ColorFilter, config.getColorFilterConf().getConfValue().getSelectedVal(), true);
                            }
                        }
                        int resolveIndex2 = 0;
                        if (playViewReply.hasVideoInfo()) {
                            VideoInfo videoInfo = playViewReply.getVideoInfo();
                            List streamListList = videoInfo.getStreamListList();
                            DashResource dash = new DashResource();
                            List videoList = new ArrayList();
                            List audioList = new ArrayList();
                            List dashAudioList = videoInfo.getDashAudioList();
                            int i = 0;
                            int size = dashAudioList.size();
                            while (i < size) {
                                DashItem dashItem = (DashItem) dashAudioList.get(i);
                                DashMediaIndex audioIndex = new DashMediaIndex();
                                audioIndex.id = dashItem.getId();
                                audioIndex.setBackupUrl(dashItem.getBackupUrlList());
                                audioIndex.baseUrl = dashItem.getBaseUrl();
                                audioIndex.bandWidth = dashItem.getBandwidth();
                                audioIndex.codecId = dashItem.getCodecid();
                                audioIndex.setMd5(dashItem.getMd5());
                                audioIndex.bytes = dashItem.getSize();
                                audioList.add(audioIndex);
                                i++;
                                playConfig = playConfig;
                                resolveIndex2 = resolveIndex2;
                                playViewReply = playViewReply;
                            }
                            PlayConfig playConfig2 = playConfig;
                            int resolveIndex3 = resolveIndex2;
                            DolbyItem dolbyItem = videoInfo.hasDolby() ? videoInfo.getDolby() : null;
                            if (dolbyItem != null) {
                                AudioEnhancementResource dolbyResource = new AudioEnhancementResource();
                                DolbyItem.Type type = dolbyItem.getType();
                                switch (type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
                                    case 1:
                                        dolbyResource.type = 2;
                                        Unit unit = Unit.INSTANCE;
                                        break;
                                    case 2:
                                        dolbyResource.type = 1;
                                        Unit unit2 = Unit.INSTANCE;
                                        break;
                                    default:
                                        dolbyResource.type = -1;
                                        Unit unit3 = Unit.INSTANCE;
                                        break;
                                }
                                dolbyResource.audioList = new ArrayList();
                                if (dolbyResource.type != -1) {
                                    List<DashItem> dolbyAudioList = dolbyItem.getAudioList();
                                    for (DashItem item : dolbyAudioList) {
                                        List list = dolbyResource.audioList;
                                        Intrinsics.checkNotNull(item);
                                        list.add(uGCDefaultResolver.transformDashAudio(item));
                                        dolbyItem = dolbyItem;
                                        playConfig2 = playConfig2;
                                    }
                                }
                                List list2 = dolbyResource.audioList;
                                Intrinsics.checkNotNullExpressionValue(list2, "audioList");
                                audioList.addAll(list2);
                                mediaResource.dolbyResource = dolbyResource;
                            }
                            LossLessItem hiResItem = videoInfo.hasLossLessItem() ? videoInfo.getLossLessItem() : null;
                            if (hiResItem != null) {
                                AudioEnhancementResource hiResResource = new AudioEnhancementResource();
                                hiResResource.type = 3;
                                hiResResource.needVip = hiResItem.getNeedVip();
                                hiResResource.audioList = new ArrayList();
                                if (hiResItem.hasAudio()) {
                                    List list3 = hiResResource.audioList;
                                    DashItem audio = hiResItem.getAudio();
                                    Intrinsics.checkNotNullExpressionValue(audio, "getAudio(...)");
                                    list3.add(uGCDefaultResolver.transformDashAudio(audio));
                                }
                                List list4 = hiResResource.audioList;
                                Intrinsics.checkNotNullExpressionValue(list4, "audioList");
                                audioList.addAll(list4);
                                mediaResource.setHiResResource(hiResResource);
                            }
                            Intrinsics.checkNotNull(videoInfo);
                            uGCDefaultResolver.processVolumeInfo(videoInfo, mediaResource);
                            boolean mExpectedQualityNoRexcode2 = false;
                            UGCDefaultResolver uGCDefaultResolver2 = uGCDefaultResolver;
                            int i2 = 0;
                            int streamListListSize = streamListList.size();
                            while (true) {
                                if (i2 < streamListListSize) {
                                    Stream steam = (Stream) streamListList.get(i2);
                                    StreamInfo info = steam.getStreamInfo();
                                    LossLessItem hiResItem2 = hiResItem;
                                    boolean mExpectedQualityNoRexcode3 = mExpectedQualityNoRexcode2;
                                    if (steam.getContentCase() == Stream.ContentCase.DASH_VIDEO && videoInfo.getQuality() == info.getQuality()) {
                                        mExpectedQualityNoRexcode2 = steam.getDashVideo().getNoRexcode();
                                        r5 = steam.getStreamInfo() != null ? steam.getStreamInfo() : null;
                                    }
                                    i2++;
                                    hiResItem = hiResItem2;
                                    mExpectedQualityNoRexcode2 = mExpectedQualityNoRexcode3;
                                }
                            }
                            Unit unit4 = Unit.INSTANCE;
                            int i3 = 0;
                            int streamListListSize2 = streamListList.size();
                            int ignoredQualityCount2 = 0;
                            int resolveIndex4 = resolveIndex3;
                            while (i3 < streamListListSize2) {
                                Stream steam2 = (Stream) streamListList.get(i3);
                                StreamInfo info2 = steam2.getStreamInfo();
                                Intrinsics.checkNotNull(steam2);
                                if (uGCDefaultResolver.checkStreamSupport(steam2)) {
                                    List streamListList2 = streamListList;
                                    int quality = videoInfo.getQuality();
                                    int streamListListSize3 = streamListListSize2;
                                    int streamListListSize4 = info2.getQuality();
                                    if (quality == streamListListSize4) {
                                        resolveIndex4 = i3 - ignoredQualityCount2;
                                    }
                                    PlayIndex index = new PlayIndex();
                                    index.mFrom = resourceParams.getFrom();
                                    index.mQuality = info2.getQuality();
                                    index.mFormat = info2.getFormat();
                                    index.mDescription = info2.getNewDescription();
                                    index.mPithyDescription = info2.getDisplayDesc();
                                    index.mSuperscript = info2.getSuperscript();
                                    index.mSubtitle = info2.getSubtitle();
                                    index.mPlayError = PlayIndex.PlayError.values()[info2.getErrCode().getNumber()];
                                    index.mStreamLimit = new PlayStreamLimit();
                                    List dashAudioList2 = dashAudioList;
                                    index.mStreamLimit.mTitle = info2.getLimit().getTitle();
                                    index.mStreamLimit.mMsg = info2.getLimit().getMsg();
                                    index.mStreamLimit.mUri = info2.getLimit().getUri();
                                    index.mNeedVip = info2.getNeedVip();
                                    index.mNeedLogin = info2.getNeedLogin();
                                    index.mVipFree = info2.getVipFree();
                                    index.mIntact = info2.getIntact();
                                    index.attribute = info2.getAttribute();
                                    index.noRexcode = info2.getNoRexcode();
                                    Stream.ContentCase contentCase = steam2.getContentCase();
                                    if (contentCase == Stream.ContentCase.SEGMENT_VIDEO) {
                                        try {
                                            String format = info2.getFormat();
                                            resolveIndex = resolveIndex4;
                                            Intrinsics.checkNotNullExpressionValue(format, "getFormat(...)");
                                            index.mTypeTag = uGCDefaultResolver.generateTypeTag(format, String.valueOf(info2.getQuality()));
                                            SegmentVideo video2 = steam2.getSegmentVideo();
                                            Iterator it = video2.getSegmentList().iterator();
                                            while (it.hasNext()) {
                                                ResponseUrl url = (ResponseUrl) it.next();
                                                Segment segment = new Segment();
                                                SegmentVideo video3 = video2;
                                                segment.mOrder = url.getOrder();
                                                Iterator it2 = it;
                                                int ignoredQualityCount3 = ignoredQualityCount2;
                                                segment.mDuration = url.getLength();
                                                segment.mBytes = url.getSize();
                                                segment.mUrl = url.getUrl();
                                                if (segment.mBackupUrls == null) {
                                                    segment.mBackupUrls = new ArrayList();
                                                }
                                                segment.mBackupUrls.addAll(url.getBackupUrlList());
                                                segment.mMd5 = url.getMd5();
                                                index.mSegmentList.add(segment);
                                                ignoredQualityCount2 = ignoredQualityCount3;
                                                video2 = video3;
                                                it = it2;
                                            }
                                            int ignoredQualityCount4 = ignoredQualityCount2;
                                            if (index.mSegmentList != null && index.mSegmentList.size() == 1) {
                                                index.mNormalMrl = ((Segment) index.mSegmentList.get(0)).mUrl;
                                                mediaResource.mVodIndex.mVodList.add(index);
                                                ignoredQualityCount = ignoredQualityCount4;
                                                mExpectedQualityNoRexcode = mExpectedQualityNoRexcode2;
                                            }
                                            mediaResource.mVodIndex.mVodList.add(index);
                                            ignoredQualityCount = ignoredQualityCount4;
                                            mExpectedQualityNoRexcode = mExpectedQualityNoRexcode2;
                                        } catch (MossException e9) {
                                            e = e9;
                                            e = e;
                                            str = TAG;
                                            defaultConstructorMarker = null;
                                            BLog.e(str, e);
                                            message = e.getMessage();
                                            if (message == null) {
                                            }
                                            throw new ResolveHttpException(message, 0, 2, defaultConstructorMarker);
                                        }
                                    } else {
                                        resolveIndex = resolveIndex4;
                                        int ignoredQualityCount5 = ignoredQualityCount2;
                                        if (contentCase == Stream.ContentCase.DASH_VIDEO) {
                                            DashVideo url2 = steam2.getDashVideo();
                                            if (mExpectedQualityNoRexcode2 != url2.getNoRexcode()) {
                                                ignoredQualityCount = ignoredQualityCount5;
                                                mExpectedQualityNoRexcode = mExpectedQualityNoRexcode2;
                                            } else if (r5 != null && r5.getAttribute() == steam2.getStreamInfo().getAttribute()) {
                                                mediaResource.mVodIndex.mVodList.add(index);
                                                DashMediaIndex videoIndex = new DashMediaIndex();
                                                videoIndex.id = steam2.getStreamInfo().getQuality();
                                                videoIndex.setBackupUrl(url2.getBackupUrlList());
                                                videoIndex.baseUrl = url2.getBaseUrl();
                                                videoIndex.bandWidth = url2.getBandwidth();
                                                videoIndex.codecId = url2.getCodecid();
                                                videoIndex.setMd5(url2.getMd5());
                                                ignoredQualityCount = ignoredQualityCount5;
                                                mExpectedQualityNoRexcode = mExpectedQualityNoRexcode2;
                                                videoIndex.bytes = url2.getSize();
                                                videoIndex.setNoRexCode(url2.getNoRexcode());
                                                videoIndex.setFrameRate(url2.getFrameRate());
                                                videoIndex.setWidth(url2.getWidth());
                                                videoIndex.setHeight(url2.getHeight());
                                                videoList.add(videoIndex);
                                            } else {
                                                ignoredQualityCount = ignoredQualityCount5;
                                                mExpectedQualityNoRexcode = mExpectedQualityNoRexcode2;
                                            }
                                            mediaResource.mVodIndex.mVodList.add(index);
                                        } else {
                                            ignoredQualityCount = ignoredQualityCount5;
                                            mExpectedQualityNoRexcode = mExpectedQualityNoRexcode2;
                                            mediaResource.mVodIndex.mVodList.add(index);
                                        }
                                    }
                                    i3++;
                                    uGCDefaultResolver = this;
                                    mExpectedQualityNoRexcode2 = mExpectedQualityNoRexcode;
                                    streamListList = streamListList2;
                                    streamListListSize2 = streamListListSize3;
                                    resolveIndex4 = resolveIndex;
                                    dashAudioList = dashAudioList2;
                                    ignoredQualityCount2 = ignoredQualityCount;
                                } else {
                                    i3++;
                                    ignoredQualityCount2++;
                                }
                            }
                            if (!audioList.isEmpty() || !videoList.isEmpty()) {
                                dash.setAudioList(audioList);
                                dash.setVideoList(videoList);
                                mediaResource.setDashResource(dash);
                            }
                            mediaResource.setResolvedIndex(resolveIndex4);
                            mediaResource.setTimelength(videoInfo.getTimelength());
                            mediaResource.setMFormat(videoInfo.getFormat());
                            mediaResource.setMVideoCodeId(videoInfo.getVideoCodecid());
                        } else {
                            str = TAG;
                            try {
                                BLog.w(str, "response lack video info");
                            } catch (MossException e10) {
                                e = e10;
                                e = e;
                                defaultConstructorMarker = null;
                                BLog.e(str, e);
                                message = e.getMessage();
                                if (message == null) {
                                }
                                throw new ResolveHttpException(message, 0, 2, defaultConstructorMarker);
                            } catch (Exception e11) {
                                e = e11;
                                e2 = e;
                                BLog.e(str, e2);
                                throw new ResolveException(e2.getMessage());
                            }
                        }
                        return mediaResource;
                    } catch (MossException e12) {
                        e = e12;
                        str = TAG;
                    }
                } catch (Exception e13) {
                    e = e13;
                    str = TAG;
                }
            } catch (MossException e14) {
                e = e14;
                str = TAG;
                defaultConstructorMarker = null;
                e = e;
                BLog.e(str, e);
                message = e.getMessage();
                if (message == null) {
                }
                throw new ResolveHttpException(message, 0, 2, defaultConstructorMarker);
            }
        } catch (MossException e15) {
            e = e15;
            defaultConstructorMarker = null;
            str = TAG;
        } catch (Exception e16) {
            e = e16;
            str = TAG;
        }
    }

    private final List<UnsupportScene> transformUnSupportSceneList(List<Long> list) {
        Iterable scenes = EnhancedUnmodifiabilityKt.unmodifiable(list);
        Iterable $this$map$iv = scenes;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            ((Number) item$iv$iv).longValue();
            destination$iv$iv.add(UnsupportScene.UNKNOWN_SCENE);
        }
        return EnhancedUnmodifiabilityKt.unmodifiable((List) destination$iv$iv);
    }

    private final MediaResource resolveFromDownloadFile(Context context, UGCResolverParams resolveParams) {
        MediaResource mediaResource = null;
        VideoDownloadService videoDownloadService = (VideoDownloadService) ServicesProvider.DefaultImpls.get$default(BLRouter.INSTANCE.getServices(VideoDownloadService.class), (String) null, 1, (Object) null);
        Object resolveMedia$default = videoDownloadService != null ? VideoDownloadService.-CC.resolveMedia$default(videoDownloadService, context, Long.valueOf(resolveParams.getAvid()), Long.valueOf(resolveParams.getCid()), Integer.valueOf(resolveParams.getPage()), (Long) null, (String) null, resolveParams.getFrom(), (String) null, 176, (Object) null) : null;
        MediaResource mediaResourceLocal = resolveMedia$default instanceof MediaResource ? (MediaResource) resolveMedia$default : null;
        if (resolveParams.getForceLocalOnly()) {
            return mediaResourceLocal;
        }
        try {
            mediaResource = getPlayViewRpc(resolveParams);
        } catch (Exception e) {
        }
        MediaResource mediaResourceRemote = mediaResource;
        return mergeMediaResource(mediaResourceRemote, mediaResourceLocal, resolveParams);
    }

    private final MediaResource mergeMediaResource(MediaResource mediaResourceRemote, MediaResource mediaResourceLocal, UGCResolverParams resolveParams) {
        Iterable iterable;
        Iterable $this$forEachIndexed$iv;
        boolean z;
        DashMediaIndex dashMediaIndex;
        List list;
        List list2;
        List list3;
        Object obj;
        Iterable videoList;
        Iterable $this$forEachIndexed$iv2;
        boolean z2;
        DashMediaIndex dashMediaIndex2;
        List videoList2;
        List videoList3;
        List videoList4;
        Object obj2;
        Iterable audioList;
        Iterable $this$forEachIndexed$iv3;
        boolean z3;
        DashMediaIndex dashMediaIndex3;
        List audioList2;
        List audioList3;
        List audioList4;
        Object obj3;
        PlayIndex playIndex;
        Object obj4;
        boolean z4;
        if (mediaResourceRemote == null || mediaResourceLocal == null || !mediaResourceLocal.isPlayable()) {
            return mediaResourceLocal;
        }
        Iterable $this$forEachIndexed$iv4 = mediaResourceLocal.mVodIndex.mVodList;
        if ($this$forEachIndexed$iv4 != null) {
            int index$iv = 0;
            for (Object item$iv : $this$forEachIndexed$iv4) {
                int index$iv2 = index$iv + 1;
                if (index$iv < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                PlayIndex local = (PlayIndex) item$iv;
                ArrayList arrayList = mediaResourceRemote.mVodIndex.mVodList;
                if (arrayList != null) {
                    Iterator it = arrayList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj4 = null;
                            break;
                        }
                        obj4 = it.next();
                        PlayIndex it2 = (PlayIndex) obj4;
                        if (it2.mQuality == local.mQuality) {
                            z4 = true;
                            continue;
                        } else {
                            z4 = false;
                            continue;
                        }
                        if (z4) {
                            break;
                        }
                    }
                    playIndex = (PlayIndex) obj4;
                } else {
                    playIndex = null;
                }
                PlayIndex findLocalInRemote = playIndex;
                if (findLocalInRemote == null) {
                    BLog.e(TAG, "Not found quality:" + local.mQuality + " in remote resource, force play from local!!");
                    resolveParams.setForceLocalOnly(true);
                    return mediaResourceLocal;
                }
                findLocalInRemote.mFrom = local.mFrom;
                findLocalInRemote.mSegmentList = local.mSegmentList;
                index$iv = index$iv2;
            }
        }
        DashResource dashResource = mediaResourceLocal.getDashResource();
        if (dashResource != null && (audioList = dashResource.getAudioList()) != null) {
            Iterable $this$forEachIndexed$iv5 = audioList;
            boolean z5 = false;
            int index$iv3 = 0;
            for (Object item$iv2 : $this$forEachIndexed$iv5) {
                int index$iv4 = index$iv3 + 1;
                if (index$iv3 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                DashMediaIndex local2 = (DashMediaIndex) item$iv2;
                DashResource dashResource2 = mediaResourceRemote.getDashResource();
                if (dashResource2 == null || (audioList4 = dashResource2.getAudioList()) == null) {
                    $this$forEachIndexed$iv3 = $this$forEachIndexed$iv5;
                    z3 = z5;
                    dashMediaIndex3 = null;
                } else {
                    Iterator it3 = audioList4.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            $this$forEachIndexed$iv3 = $this$forEachIndexed$iv5;
                            z3 = z5;
                            obj3 = null;
                            break;
                        }
                        obj3 = it3.next();
                        DashMediaIndex it4 = (DashMediaIndex) obj3;
                        $this$forEachIndexed$iv3 = $this$forEachIndexed$iv5;
                        int i = it4.id;
                        z3 = z5;
                        int $i$f$forEachIndexed = local2.id;
                        if (i == $i$f$forEachIndexed) {
                            break;
                        }
                        $this$forEachIndexed$iv5 = $this$forEachIndexed$iv3;
                        z5 = z3;
                    }
                    dashMediaIndex3 = (DashMediaIndex) obj3;
                }
                DashMediaIndex findLocalInRemote2 = dashMediaIndex3;
                if (findLocalInRemote2 == null) {
                    BLog.e(TAG, "Not found audio:" + local2.id + " in remote resource, force play from local!!");
                    resolveParams.setForceLocalOnly(true);
                    return mediaResourceLocal;
                }
                DashResource dashResource3 = mediaResourceRemote.getDashResource();
                Integer index = (dashResource3 == null || (audioList3 = dashResource3.getAudioList()) == null) ? null : Integer.valueOf(audioList3.indexOf(findLocalInRemote2));
                if (index == null) {
                    BLog.e(TAG, "Something error with audio, force play from local!!");
                    resolveParams.setForceLocalOnly(true);
                    return mediaResourceLocal;
                }
                DashResource dashResource4 = mediaResourceRemote.getDashResource();
                if (dashResource4 != null && (audioList2 = dashResource4.getAudioList()) != null) {
                    DashMediaIndex dashMediaIndex4 = (DashMediaIndex) audioList2.set(index.intValue(), local2);
                }
                index$iv3 = index$iv4;
                $this$forEachIndexed$iv5 = $this$forEachIndexed$iv3;
                z5 = z3;
            }
        }
        DashResource dashResource5 = mediaResourceLocal.getDashResource();
        if (dashResource5 != null && (videoList = dashResource5.getVideoList()) != null) {
            Iterable $this$forEachIndexed$iv6 = videoList;
            boolean z6 = false;
            int index$iv5 = 0;
            for (Object item$iv3 : $this$forEachIndexed$iv6) {
                int index$iv6 = index$iv5 + 1;
                if (index$iv5 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                DashMediaIndex local3 = (DashMediaIndex) item$iv3;
                DashResource dashResource6 = mediaResourceRemote.getDashResource();
                if (dashResource6 == null || (videoList4 = dashResource6.getVideoList()) == null) {
                    $this$forEachIndexed$iv2 = $this$forEachIndexed$iv6;
                    z2 = z6;
                    dashMediaIndex2 = null;
                } else {
                    Iterator it5 = videoList4.iterator();
                    while (true) {
                        if (!it5.hasNext()) {
                            $this$forEachIndexed$iv2 = $this$forEachIndexed$iv6;
                            z2 = z6;
                            obj2 = null;
                            break;
                        }
                        obj2 = it5.next();
                        DashMediaIndex it6 = (DashMediaIndex) obj2;
                        $this$forEachIndexed$iv2 = $this$forEachIndexed$iv6;
                        int i2 = it6.id;
                        z2 = z6;
                        int $i$f$forEachIndexed2 = local3.id;
                        if (i2 == $i$f$forEachIndexed2) {
                            break;
                        }
                        $this$forEachIndexed$iv6 = $this$forEachIndexed$iv2;
                        z6 = z2;
                    }
                    dashMediaIndex2 = (DashMediaIndex) obj2;
                }
                DashMediaIndex findLocalInRemote3 = dashMediaIndex2;
                if (findLocalInRemote3 != null) {
                    DashResource dashResource7 = mediaResourceRemote.getDashResource();
                    Integer index2 = (dashResource7 == null || (videoList3 = dashResource7.getVideoList()) == null) ? null : Integer.valueOf(videoList3.indexOf(findLocalInRemote3));
                    if (index2 == null) {
                        BLog.e(TAG, "Something error with video, force play from local!!");
                        resolveParams.setForceLocalOnly(true);
                        return mediaResourceLocal;
                    }
                    DashResource dashResource8 = mediaResourceRemote.getDashResource();
                    if (dashResource8 != null && (videoList2 = dashResource8.getVideoList()) != null) {
                        DashMediaIndex dashMediaIndex5 = (DashMediaIndex) videoList2.set(index2.intValue(), local3);
                    }
                }
                index$iv5 = index$iv6;
                $this$forEachIndexed$iv6 = $this$forEachIndexed$iv2;
                z6 = z2;
            }
        }
        AudioEnhancementResource audioEnhancementResource = mediaResourceLocal.dolbyResource;
        if (audioEnhancementResource != null && (iterable = audioEnhancementResource.audioList) != null) {
            Iterable $this$forEachIndexed$iv7 = iterable;
            boolean z7 = false;
            int index$iv7 = 0;
            for (Object item$iv4 : $this$forEachIndexed$iv7) {
                int index$iv8 = index$iv7 + 1;
                if (index$iv7 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                DashMediaIndex local4 = (DashMediaIndex) item$iv4;
                AudioEnhancementResource audioEnhancementResource2 = mediaResourceRemote.dolbyResource;
                if (audioEnhancementResource2 == null || (list3 = audioEnhancementResource2.audioList) == null) {
                    $this$forEachIndexed$iv = $this$forEachIndexed$iv7;
                    z = z7;
                    dashMediaIndex = null;
                } else {
                    Iterator it7 = list3.iterator();
                    while (true) {
                        if (!it7.hasNext()) {
                            $this$forEachIndexed$iv = $this$forEachIndexed$iv7;
                            z = z7;
                            obj = null;
                            break;
                        }
                        obj = it7.next();
                        DashMediaIndex it8 = (DashMediaIndex) obj;
                        $this$forEachIndexed$iv = $this$forEachIndexed$iv7;
                        int i3 = it8.id;
                        z = z7;
                        int $i$f$forEachIndexed3 = local4.id;
                        if (i3 == $i$f$forEachIndexed3) {
                            break;
                        }
                        $this$forEachIndexed$iv7 = $this$forEachIndexed$iv;
                        z7 = z;
                    }
                    dashMediaIndex = (DashMediaIndex) obj;
                }
                DashMediaIndex findLocalInRemote4 = dashMediaIndex;
                if (findLocalInRemote4 == null) {
                    BLog.e(TAG, "Not found dolby audio:" + local4.id + " in remote resource, force play from local!!");
                    resolveParams.setForceLocalOnly(true);
                    return mediaResourceLocal;
                }
                AudioEnhancementResource audioEnhancementResource3 = mediaResourceRemote.dolbyResource;
                Integer index3 = (audioEnhancementResource3 == null || (list2 = audioEnhancementResource3.audioList) == null) ? null : Integer.valueOf(list2.indexOf(findLocalInRemote4));
                if (index3 == null) {
                    BLog.e(TAG, "Something error with dolby audio, force play from local!!");
                    resolveParams.setForceLocalOnly(true);
                    return mediaResourceLocal;
                }
                AudioEnhancementResource audioEnhancementResource4 = mediaResourceRemote.dolbyResource;
                if (audioEnhancementResource4 != null && (list = audioEnhancementResource4.audioList) != null) {
                    DashMediaIndex dashMediaIndex6 = (DashMediaIndex) list.set(index3.intValue(), local4);
                }
                index$iv7 = index$iv8;
                $this$forEachIndexed$iv7 = $this$forEachIndexed$iv;
                z7 = z;
            }
        }
        return mediaResourceRemote;
    }

    private final void processVolumeInfo(VideoInfo videoInfo, MediaResource mediaResource) {
        if (videoInfo.hasVolume()) {
            com.bapis.bilibili.app.playurl.v1.VolumeInfo volume = videoInfo.getVolume();
            VolumeInfo $this$processVolumeInfo_u24lambda_u240 = new VolumeInfo();
            $this$processVolumeInfo_u24lambda_u240.setMeasuredI(volume.getMeasuredI());
            $this$processVolumeInfo_u24lambda_u240.setMeasuredLra(volume.getMeasuredLra());
            $this$processVolumeInfo_u24lambda_u240.setMeasuredTp(volume.getMeasuredTp());
            $this$processVolumeInfo_u24lambda_u240.setMeasuredThreshold(volume.getMeasuredThreshold());
            $this$processVolumeInfo_u24lambda_u240.setTargetI(volume.getTargetI());
            $this$processVolumeInfo_u24lambda_u240.setTargetOffset(volume.getTargetOffset());
            $this$processVolumeInfo_u24lambda_u240.setTargetTp(volume.getTargetTp());
            mediaResource.setVolumeInfo($this$processVolumeInfo_u24lambda_u240);
        }
    }

    private final boolean checkStreamSupport(Stream stream) {
        int quality = stream.getStreamInfo().getQuality();
        if (quality == 126 && ConfigManager.Companion.isHitFF(FF_KEY_DOLBY_VISION_FRAME_CHECK)) {
            String frameRate = stream.getDashVideo().getFrameRate();
            Intrinsics.checkNotNullExpressionValue(frameRate, "getFrameRate(...)");
            Double doubleOrNull = StringsKt.toDoubleOrNull(frameRate);
            if (doubleOrNull == null) {
                return true;
            }
            double frame = doubleOrNull.doubleValue();
            int width = stream.getDashVideo().getWidth() != 0 ? stream.getDashVideo().getWidth() : 3840;
            int height = stream.getDashVideo().getHeight() != 0 ? stream.getDashVideo().getHeight() : 2160;
            double maxSuportDolbyVisionFrame = IjkCodecHelper.getSupportFrameRateForSize("video/hevc", width, height);
            if (frame > maxSuportDolbyVisionFrame) {
                BLog.e(TAG, "Donot support " + frame + " FPS dolbyVision! Max FPS:" + maxSuportDolbyVisionFrame + ", width: " + width + ", height: " + height);
                return false;
            }
        }
        return true;
    }

    private final PlayViewReply requestPlayView(long aid, long cid, long qn, int fnver, int fnval, int download, int forceHost, String fromSpmid, String spmid, int teenagersMode, IjkMediaAsset.VideoCodecType codecType, Business business, long volumeBalance) throws MossException {
        CodeType codeType;
        PlayViewReq.Builder teenagersMode2 = PlayViewReq.newBuilder().setAid(aid).setCid(cid).setQn(qn).setFnver(fnver).setFnval(fnval).setDownload(download).setForceHost(forceHost).setSpmid(spmid == null ? "" : spmid).setFromSpmid(fromSpmid != null ? fromSpmid : "").setTeenagersMode(teenagersMode);
        switch (WhenMappings.$EnumSwitchMapping$1[codecType.ordinal()]) {
            case 1:
                codeType = CodeType.CODEAV1;
                break;
            case 2:
                codeType = CodeType.CODE265;
                break;
            default:
                codeType = CodeType.CODE264;
                break;
        }
        PlayViewReq request = teenagersMode2.setPreferCodecType(codeType).setBusiness(business).setVoiceBalance(volumeBalance).build();
        PlayURLMoss playURLMoss = new PlayURLMoss("IGNORED IN 5.46 AS PLACEHOLDER", 443, (CallOptions) null, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNull(request);
        return playURLMoss.executePlayView(request);
    }

    private final String generateTypeTag(String format, String quality) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format2 = String.format("lua.%s.%s.%s", Arrays.copyOf(new Object[]{format, "bili2api", quality}, 3));
        Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
        return format2;
    }

    private final DashMediaIndex transformDashAudio(DashItem item) {
        DashMediaIndex audioIndex = new DashMediaIndex();
        audioIndex.id = item.getId();
        audioIndex.setBackupUrl(item.getBackupUrlList());
        audioIndex.baseUrl = item.getBaseUrl();
        audioIndex.bandWidth = item.getBandwidth();
        audioIndex.codecId = item.getCodecid();
        audioIndex.setMd5(item.getMd5());
        audioIndex.bytes = item.getSize();
        return audioIndex;
    }
}