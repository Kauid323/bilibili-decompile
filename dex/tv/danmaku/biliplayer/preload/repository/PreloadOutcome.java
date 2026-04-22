package tv.danmaku.biliplayer.preload.repository;

import BottomSheetItemData$;
import com.bilibili.lib.media.resolver2.IResolveParams;
import com.bilibili.lib.media.resource.MediaResource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.coreV2.MediaItem;

/* compiled from: PreloadElement.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÆ\u0003JA\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006#"}, d2 = {"Ltv/danmaku/biliplayer/preload/repository/PreloadOutcome;", "", "resolverParams", "Lcom/bilibili/lib/media/resolver2/IResolveParams;", "mediaItem", "Ltv/danmaku/videoplayer/coreV2/MediaItem;", "mediaResource", "Lcom/bilibili/lib/media/resource/MediaResource;", "sceneIdentity", "", "reusable", "", "<init>", "(Lcom/bilibili/lib/media/resolver2/IResolveParams;Ltv/danmaku/videoplayer/coreV2/MediaItem;Lcom/bilibili/lib/media/resource/MediaResource;Ljava/lang/String;Z)V", "getResolverParams", "()Lcom/bilibili/lib/media/resolver2/IResolveParams;", "getMediaItem", "()Ltv/danmaku/videoplayer/coreV2/MediaItem;", "getMediaResource", "()Lcom/bilibili/lib/media/resource/MediaResource;", "getSceneIdentity", "()Ljava/lang/String;", "getReusable", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "player-preload_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PreloadOutcome {
    private final MediaItem<?> mediaItem;
    private final MediaResource mediaResource;
    private final IResolveParams resolverParams;
    private final boolean reusable;
    private final String sceneIdentity;

    public static /* synthetic */ PreloadOutcome copy$default(PreloadOutcome preloadOutcome, IResolveParams iResolveParams, MediaItem mediaItem, MediaResource mediaResource, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            iResolveParams = preloadOutcome.resolverParams;
        }
        MediaItem<?> mediaItem2 = mediaItem;
        if ((i & 2) != 0) {
            mediaItem2 = preloadOutcome.mediaItem;
        }
        MediaItem mediaItem3 = mediaItem2;
        if ((i & 4) != 0) {
            mediaResource = preloadOutcome.mediaResource;
        }
        MediaResource mediaResource2 = mediaResource;
        if ((i & 8) != 0) {
            str = preloadOutcome.sceneIdentity;
        }
        String str2 = str;
        if ((i & 16) != 0) {
            z = preloadOutcome.reusable;
        }
        return preloadOutcome.copy(iResolveParams, mediaItem3, mediaResource2, str2, z);
    }

    public final IResolveParams component1() {
        return this.resolverParams;
    }

    public final MediaItem<?> component2() {
        return this.mediaItem;
    }

    public final MediaResource component3() {
        return this.mediaResource;
    }

    public final String component4() {
        return this.sceneIdentity;
    }

    public final boolean component5() {
        return this.reusable;
    }

    public final PreloadOutcome copy(IResolveParams iResolveParams, MediaItem<?> mediaItem, MediaResource mediaResource, String str, boolean z) {
        Intrinsics.checkNotNullParameter(iResolveParams, "resolverParams");
        Intrinsics.checkNotNullParameter(mediaResource, "mediaResource");
        Intrinsics.checkNotNullParameter(str, "sceneIdentity");
        return new PreloadOutcome(iResolveParams, mediaItem, mediaResource, str, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PreloadOutcome) {
            PreloadOutcome preloadOutcome = (PreloadOutcome) obj;
            return Intrinsics.areEqual(this.resolverParams, preloadOutcome.resolverParams) && Intrinsics.areEqual(this.mediaItem, preloadOutcome.mediaItem) && Intrinsics.areEqual(this.mediaResource, preloadOutcome.mediaResource) && Intrinsics.areEqual(this.sceneIdentity, preloadOutcome.sceneIdentity) && this.reusable == preloadOutcome.reusable;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.resolverParams.hashCode() * 31) + (this.mediaItem == null ? 0 : this.mediaItem.hashCode())) * 31) + this.mediaResource.hashCode()) * 31) + this.sceneIdentity.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.reusable);
    }

    public String toString() {
        IResolveParams iResolveParams = this.resolverParams;
        MediaItem<?> mediaItem = this.mediaItem;
        MediaResource mediaResource = this.mediaResource;
        String str = this.sceneIdentity;
        return "PreloadOutcome(resolverParams=" + iResolveParams + ", mediaItem=" + mediaItem + ", mediaResource=" + mediaResource + ", sceneIdentity=" + str + ", reusable=" + this.reusable + ")";
    }

    public PreloadOutcome(IResolveParams resolverParams, MediaItem<?> mediaItem, MediaResource mediaResource, String sceneIdentity, boolean reusable) {
        Intrinsics.checkNotNullParameter(resolverParams, "resolverParams");
        Intrinsics.checkNotNullParameter(mediaResource, "mediaResource");
        Intrinsics.checkNotNullParameter(sceneIdentity, "sceneIdentity");
        this.resolverParams = resolverParams;
        this.mediaItem = mediaItem;
        this.mediaResource = mediaResource;
        this.sceneIdentity = sceneIdentity;
        this.reusable = reusable;
    }

    public final IResolveParams getResolverParams() {
        return this.resolverParams;
    }

    public final MediaItem<?> getMediaItem() {
        return this.mediaItem;
    }

    public final MediaResource getMediaResource() {
        return this.mediaResource;
    }

    public final String getSceneIdentity() {
        return this.sceneIdentity;
    }

    public final boolean getReusable() {
        return this.reusable;
    }
}