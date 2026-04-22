package tv.danmaku.biliplayer.preload.repository;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import com.bilibili.lib.media.resolver2.IResolveParams;
import com.bilibili.lib.media.resource.MediaResource;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.videoplayer.coreV2.MediaItem;

/* compiled from: PreloadElement.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b.\b\u0086\b\u0018\u00002\u00020\u0001B·\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012&\b\u0002\u0010\u0010\u001a \u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0011j\u0004\u0018\u0001`\u0013\u0012\u001e\b\u0002\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0015j\u0004\u0018\u0001`\u0016\u0012\"\b\u0002\u0010\u0017\u001a\u001c\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0018\u0018\u00010\u0015j\u0004\u0018\u0001`\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\b\u00105\u001a\u00020\u0003H\u0016J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0005HÆ\u0003J\t\u00108\u001a\u00020\u0007HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010:\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b;\u0010!J\t\u0010<\u001a\u00020\rHÆ\u0003J\t\u0010=\u001a\u00020\u000fHÆ\u0003J'\u0010>\u001a \u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0011j\u0004\u0018\u0001`\u0013HÆ\u0003J\u001f\u0010?\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0015j\u0004\u0018\u0001`\u0016HÆ\u0003J#\u0010@\u001a\u001c\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0018\u0018\u00010\u0015j\u0004\u0018\u0001`\u0019HÆ\u0003JÆ\u0001\u0010A\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2&\b\u0002\u0010\u0010\u001a \u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0011j\u0004\u0018\u0001`\u00132\u001e\b\u0002\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0015j\u0004\u0018\u0001`\u00162\"\b\u0002\u0010\u0017\u001a\u001c\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0018\u0018\u00010\u0015j\u0004\u0018\u0001`\u0019HÆ\u0001¢\u0006\u0004\bB\u0010CJ\u0013\u0010D\u001a\u00020\u000f2\b\u0010E\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010F\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\n\u001a\u00020\u000b¢\u0006\n\n\u0002\u0010%\u001a\u0004\b$\u0010!R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R/\u0010\u0010\u001a \u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0011j\u0004\u0018\u0001`\u0013¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R'\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0015j\u0004\u0018\u0001`\u0016¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R+\u0010\u0017\u001a\u001c\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0018\u0018\u00010\u0015j\u0004\u0018\u0001`\u0019¢\u0006\b\n\u0000\u001a\u0004\b.\u0010-R$\u0010/\u001a\u00020\u00038\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b0\u00101\u001a\u0004\b2\u0010\u001d\"\u0004\b3\u00104¨\u0006G"}, d2 = {"Ltv/danmaku/biliplayer/preload/repository/PreloadAction;", "", "flashJson", "", "resolverParams", "Lcom/bilibili/lib/media/resolver2/IResolveParams;", "startPosition", "", "reportData", "Ltv/danmaku/biliplayer/preload/repository/PreloadReportData;", "priority", "Ltv/danmaku/biliplayer/preload/repository/PreloadPriority;", "cacheTimeMs", "", "reusable", "", "flashMediaResourceCreator", "Lkotlin/Function2;", "Lcom/bilibili/lib/media/resource/MediaResource;", "Ltv/danmaku/biliplayer/preload/repository/PreloadFlashResolver;", "paramsMediaResourceCreator", "Lkotlin/Function1;", "Ltv/danmaku/biliplayer/preload/repository/PreloadResolver;", "mediaItemCreator", "Ltv/danmaku/videoplayer/coreV2/MediaItem;", "Ltv/danmaku/biliplayer/preload/repository/PreloadMediaItemCreator;", "<init>", "(Ljava/lang/String;Lcom/bilibili/lib/media/resolver2/IResolveParams;ILtv/danmaku/biliplayer/preload/repository/PreloadReportData;IJZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getFlashJson", "()Ljava/lang/String;", "getResolverParams", "()Lcom/bilibili/lib/media/resolver2/IResolveParams;", "getStartPosition", "()I", "getReportData", "()Ltv/danmaku/biliplayer/preload/repository/PreloadReportData;", "getPriority-3gV422k", "I", "getCacheTimeMs", "()J", "getReusable", "()Z", "getFlashMediaResourceCreator", "()Lkotlin/jvm/functions/Function2;", "getParamsMediaResourceCreator", "()Lkotlin/jvm/functions/Function1;", "getMediaItemCreator", "sceneIdentity", "getSceneIdentity$player_preload_debug$annotations", "()V", "getSceneIdentity$player_preload_debug", "setSceneIdentity$player_preload_debug", "(Ljava/lang/String;)V", "toString", "component1", "component2", "component3", "component4", "component5", "component5-3gV422k", "component6", "component7", "component8", "component9", "component10", "copy", "copy-YY7Da1s", "(Ljava/lang/String;Lcom/bilibili/lib/media/resolver2/IResolveParams;ILtv/danmaku/biliplayer/preload/repository/PreloadReportData;IJZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ltv/danmaku/biliplayer/preload/repository/PreloadAction;", "equals", "other", "hashCode", "player-preload_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PreloadAction {
    private final long cacheTimeMs;
    private final String flashJson;
    private final Function2<IResolveParams, String, MediaResource> flashMediaResourceCreator;
    private final Function1<MediaResource, MediaItem<?>> mediaItemCreator;
    private final Function1<IResolveParams, MediaResource> paramsMediaResourceCreator;
    private final int priority;
    private final PreloadReportData reportData;
    private final IResolveParams resolverParams;
    private final boolean reusable;
    private String sceneIdentity;
    private final int startPosition;

    public /* synthetic */ PreloadAction(String str, IResolveParams iResolveParams, int i, PreloadReportData preloadReportData, int i2, long j, boolean z, Function2 function2, Function1 function1, Function1 function12, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, iResolveParams, i, preloadReportData, i2, j, z, function2, function1, function12);
    }

    @Deprecated(message = "v1使用，实验全量后可删除")
    public static /* synthetic */ void getSceneIdentity$player_preload_debug$annotations() {
    }

    public final String component1() {
        return this.flashJson;
    }

    public final Function1<MediaResource, MediaItem<?>> component10() {
        return this.mediaItemCreator;
    }

    public final IResolveParams component2() {
        return this.resolverParams;
    }

    public final int component3() {
        return this.startPosition;
    }

    public final PreloadReportData component4() {
        return this.reportData;
    }

    /* renamed from: component5-3gV422k  reason: not valid java name */
    public final int m2142component53gV422k() {
        return this.priority;
    }

    public final long component6() {
        return this.cacheTimeMs;
    }

    public final boolean component7() {
        return this.reusable;
    }

    public final Function2<IResolveParams, String, MediaResource> component8() {
        return this.flashMediaResourceCreator;
    }

    public final Function1<IResolveParams, MediaResource> component9() {
        return this.paramsMediaResourceCreator;
    }

    /* renamed from: copy-YY7Da1s  reason: not valid java name */
    public final PreloadAction m2143copyYY7Da1s(String str, IResolveParams iResolveParams, int i, PreloadReportData preloadReportData, int i2, long j, boolean z, Function2<? super IResolveParams, ? super String, MediaResource> function2, Function1<? super IResolveParams, MediaResource> function1, Function1<? super MediaResource, ? extends MediaItem<?>> function12) {
        Intrinsics.checkNotNullParameter(iResolveParams, "resolverParams");
        return new PreloadAction(str, iResolveParams, i, preloadReportData, i2, j, z, function2, function1, function12, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PreloadAction) {
            PreloadAction preloadAction = (PreloadAction) obj;
            return Intrinsics.areEqual(this.flashJson, preloadAction.flashJson) && Intrinsics.areEqual(this.resolverParams, preloadAction.resolverParams) && this.startPosition == preloadAction.startPosition && Intrinsics.areEqual(this.reportData, preloadAction.reportData) && PreloadPriority.m2149equalsimpl0(this.priority, preloadAction.priority) && this.cacheTimeMs == preloadAction.cacheTimeMs && this.reusable == preloadAction.reusable && Intrinsics.areEqual(this.flashMediaResourceCreator, preloadAction.flashMediaResourceCreator) && Intrinsics.areEqual(this.paramsMediaResourceCreator, preloadAction.paramsMediaResourceCreator) && Intrinsics.areEqual(this.mediaItemCreator, preloadAction.mediaItemCreator);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((this.flashJson == null ? 0 : this.flashJson.hashCode()) * 31) + this.resolverParams.hashCode()) * 31) + this.startPosition) * 31) + (this.reportData == null ? 0 : this.reportData.hashCode())) * 31) + PreloadPriority.m2150hashCodeimpl(this.priority)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.cacheTimeMs)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.reusable)) * 31) + (this.flashMediaResourceCreator == null ? 0 : this.flashMediaResourceCreator.hashCode())) * 31) + (this.paramsMediaResourceCreator == null ? 0 : this.paramsMediaResourceCreator.hashCode())) * 31) + (this.mediaItemCreator != null ? this.mediaItemCreator.hashCode() : 0);
    }

    private PreloadAction(String flashJson, IResolveParams resolverParams, int startPosition, PreloadReportData reportData, int priority, long cacheTimeMs, boolean reusable, Function2<? super IResolveParams, ? super String, MediaResource> function2, Function1<? super IResolveParams, MediaResource> function1, Function1<? super MediaResource, ? extends MediaItem<?>> function12) {
        Intrinsics.checkNotNullParameter(resolverParams, "resolverParams");
        this.flashJson = flashJson;
        this.resolverParams = resolverParams;
        this.startPosition = startPosition;
        this.reportData = reportData;
        this.priority = priority;
        this.cacheTimeMs = cacheTimeMs;
        this.reusable = reusable;
        this.flashMediaResourceCreator = function2;
        this.paramsMediaResourceCreator = function1;
        this.mediaItemCreator = function12;
        this.sceneIdentity = PreloadElementKt.PRELOAD_IDENTITY_UNIDENTIFIED;
    }

    public /* synthetic */ PreloadAction(String str, IResolveParams iResolveParams, int i, PreloadReportData preloadReportData, int i2, long j, boolean z, Function2 function2, Function1 function1, Function1 function12, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, iResolveParams, (i3 & 4) != 0 ? 0 : i, preloadReportData, (i3 & 16) != 0 ? PreloadPriority.Companion.m2154getDefault3gV422k() : i2, (i3 & 32) != 0 ? 500L : j, (i3 & 64) != 0 ? false : z, (i3 & 128) != 0 ? null : function2, (i3 & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) != 0 ? null : function1, (i3 & 512) != 0 ? null : function12, null);
    }

    public final String getFlashJson() {
        return this.flashJson;
    }

    public final IResolveParams getResolverParams() {
        return this.resolverParams;
    }

    public final int getStartPosition() {
        return this.startPosition;
    }

    public final PreloadReportData getReportData() {
        return this.reportData;
    }

    /* renamed from: getPriority-3gV422k  reason: not valid java name */
    public final int m2144getPriority3gV422k() {
        return this.priority;
    }

    public final long getCacheTimeMs() {
        return this.cacheTimeMs;
    }

    public final boolean getReusable() {
        return this.reusable;
    }

    public final Function2<IResolveParams, String, MediaResource> getFlashMediaResourceCreator() {
        return this.flashMediaResourceCreator;
    }

    public final Function1<IResolveParams, MediaResource> getParamsMediaResourceCreator() {
        return this.paramsMediaResourceCreator;
    }

    public final Function1<MediaResource, MediaItem<?>> getMediaItemCreator() {
        return this.mediaItemCreator;
    }

    public final String getSceneIdentity$player_preload_debug() {
        return this.sceneIdentity;
    }

    public final void setSceneIdentity$player_preload_debug(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sceneIdentity = str;
    }

    public String toString() {
        String id = this.resolverParams.getId();
        String from = this.resolverParams.getFrom();
        return "Preload Player Action, resolverParams key: " + id + ", resolverParams from:" + from + " hash:" + hashCode();
    }
}