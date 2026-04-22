package tv.danmaku.biliplayerv2.service;

import com.bilibili.lib.media.resource.MediaResource;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: IPlayerCoreService.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H&¢\u0006\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/OnAssetUpdateListener;", "", "obtainUpdateAsset", "Lcom/bilibili/lib/media/resource/MediaResource;", "reason", "", "codecType", "Lcom/bilibili/lib/media/resolver2/BiliCodec;", IjkMediaMeta.IJKM_KEY_FORMAT, "obtainUpdateAsset-4pVzu0o", "(III)Lcom/bilibili/lib/media/resource/MediaResource;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface OnAssetUpdateListener {
    /* renamed from: obtainUpdateAsset-4pVzu0o */
    MediaResource mo2211obtainUpdateAsset4pVzu0o(int i, int i2, int i3);
}