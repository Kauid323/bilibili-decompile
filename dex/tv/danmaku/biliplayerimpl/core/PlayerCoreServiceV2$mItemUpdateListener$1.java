package tv.danmaku.biliplayerimpl.core;

import android.text.TextUtils;
import com.bilibili.fd_service.FreeDataManager;
import com.bilibili.lib.media.resolver2.BiliCodec;
import com.bilibili.lib.media.resource.MediaResource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.HookErrorType;
import tv.danmaku.biliplayerv2.collection.Collections;
import tv.danmaku.biliplayerv2.service.IAssetUpdateObserver;
import tv.danmaku.biliplayerv2.service.OnAssetUpdateListener;
import tv.danmaku.biliplayerv2.service.OnMeteredNetworkUrlHookListener;
import tv.danmaku.biliplayerv2.service.network.PlayerFreeDataHelper;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkAssetUpdateReason;
import tv.danmaku.ijk.media.player.IjkMediaAsset;
import tv.danmaku.ijk.media.player.IjkMediaPlayerItem;
import tv.danmaku.ijk.media.player.IjkNetworkUtils;
import tv.danmaku.videoplayer.core.log.PlayerLog;

/* compiled from: PlayerCoreServiceV2.kt */
@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J$\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"tv/danmaku/biliplayerimpl/core/PlayerCoreServiceV2$mItemUpdateListener$1", "Ltv/danmaku/ijk/media/player/IjkMediaPlayerItem$IjkMediaPlayerItemAssetUpdateListener;", "onAssetUpdate", "Ltv/danmaku/ijk/media/player/IjkMediaAsset;", "p0", "Ltv/danmaku/ijk/media/player/IjkAssetUpdateReason;", "onMeteredNetworkUrlHook", "", "url", "type", "Ltv/danmaku/ijk/media/player/IjkNetworkUtils$NetWorkType;", "reasonType", "", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PlayerCoreServiceV2$mItemUpdateListener$1 implements IjkMediaPlayerItem.IjkMediaPlayerItemAssetUpdateListener {
    final /* synthetic */ PlayerCoreServiceV2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PlayerCoreServiceV2$mItemUpdateListener$1(PlayerCoreServiceV2 $receiver) {
        this.this$0 = $receiver;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x008c, code lost:
        r5 = r10.this$0.mMeteredNetworkUrlHookListener;
     */
    @Override // tv.danmaku.ijk.media.player.IjkMediaPlayerItem.IjkMediaPlayerItemAssetUpdateListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public IjkMediaAsset onAssetUpdate(IjkAssetUpdateReason p0) {
        OnAssetUpdateListener onAssetUpdateListener;
        OnMeteredNetworkUrlHookListener onMeteredNetworkUrlHookListener;
        Collections.SafeIteratorList safeIteratorList;
        Intrinsics.checkNotNullParameter(p0, "p0");
        int reason = p0.getReason();
        IjkNetworkUtils.NetWorkType type = p0.getCurrentNetWork();
        int codecType = p0.getVideoCodecType();
        int format = p0.getFormat();
        PlayerLog.i("PlayerCoreServiceV2", "onAssetUpdate called, reason: " + reason + ", videoCodecType: " + codecType + ", format: " + format + " type:" + type);
        if (reason == 0) {
            return null;
        }
        if (reason == 2 && type == IjkNetworkUtils.NetWorkType.NONE) {
            return null;
        }
        if (reason == 3 && type == IjkNetworkUtils.NetWorkType.NONE) {
            return null;
        }
        if (reason == 4) {
            safeIteratorList = this.this$0.mAssetUpdateObserverList;
            safeIteratorList.forEach(new Collections.IteratorAction() { // from class: tv.danmaku.biliplayerimpl.core.PlayerCoreServiceV2$mItemUpdateListener$1$$ExternalSyntheticLambda0
                @Override // tv.danmaku.biliplayerv2.collection.Collections.IteratorAction
                public final void run(Object obj) {
                    ((IAssetUpdateObserver) obj).onHttpResponseInvalid();
                }
            });
        }
        onAssetUpdateListener = this.this$0.mAssetUpdateListener;
        MediaResource currentResource = onAssetUpdateListener != null ? onAssetUpdateListener.mo2211obtainUpdateAsset4pVzu0o(reason, BiliCodec.Companion.invoke-RukcXV4(codecType), format) : null;
        if (reason == 2 && type == IjkNetworkUtils.NetWorkType.WIFI && onMeteredNetworkUrlHookListener != null) {
            onMeteredNetworkUrlHookListener.onMeteredNetworkUrlHook(null, IjkNetworkUtils.NetWorkType.WIFI, HookErrorType.Companion.convertHookErrorType(Integer.valueOf(reason)));
        }
        boolean z = false;
        if (currentResource != null && currentResource.isPlayable()) {
            z = true;
        }
        if (z) {
            this.this$0.mMediaResource = currentResource;
            return currentResource.translateToIjkMediaAsset();
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0044, code lost:
        if (r2.supportDrmFreeData(r4 != null ? r4.getDrmType() : null) != false) goto L22;
     */
    @Override // tv.danmaku.ijk.media.player.IjkMediaPlayerItem.IjkMediaPlayerItemAssetUpdateListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String onMeteredNetworkUrlHook(String url, IjkNetworkUtils.NetWorkType type, int reasonType) {
        OnMeteredNetworkUrlHookListener onMeteredNetworkUrlHookListener;
        OnMeteredNetworkUrlHookListener onMeteredNetworkUrlHookListener2;
        MediaResource mediaResource;
        MediaResource mediaResource2;
        Intrinsics.checkNotNullParameter(url, "url");
        if (type == null) {
            PlayerLog.w("PlayerCoreServiceV2", "onMeteredNetworkUrlHook network type is null!");
            return url;
        }
        String processedUrl = url;
        if (reasonType != 5 && PlayerFreeDataHelper.INSTANCE.shouldProcessUrl()) {
            mediaResource = this.this$0.mMediaResource;
            boolean z = false;
            if (mediaResource != null && mediaResource.isDrm()) {
                z = true;
            }
            if (z) {
                PlayerFreeDataHelper playerFreeDataHelper = PlayerFreeDataHelper.INSTANCE;
                mediaResource2 = this.this$0.mMediaResource;
            }
            processedUrl = PlayerFreeDataHelper.INSTANCE.processUrl(FreeDataManager.ResType.RES_VIDEO, url);
            if (TextUtils.isEmpty(processedUrl)) {
                processedUrl = url;
            }
        }
        PlayerLog.i("PlayerCoreServiceV2", "onMeteredNetworkUrlHook called, url: " + url + ",processed url:" + processedUrl + ",network:" + type + ",reasonType:" + reasonType);
        onMeteredNetworkUrlHookListener = this.this$0.mMeteredNetworkUrlHookListener;
        if (onMeteredNetworkUrlHookListener != null) {
            onMeteredNetworkUrlHookListener2 = this.this$0.mMeteredNetworkUrlHookListener;
            if (onMeteredNetworkUrlHookListener2 != null) {
                return onMeteredNetworkUrlHookListener2.onMeteredNetworkUrlHook(processedUrl, type, HookErrorType.Companion.convertHookErrorType(Integer.valueOf(reasonType)));
            }
            return null;
        }
        PlayerLog.i("PlayerCoreServiceV2", "onMeteredNetworkUrlHook listener is null!");
        return processedUrl;
    }
}