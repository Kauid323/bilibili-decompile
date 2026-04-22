package tv.danmaku.gifplayer;

import androidx.collection.LruCache;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaPlayerItem;

/* compiled from: GifVideoView.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J*\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0014¨\u0006\r"}, d2 = {"Ltv/danmaku/gifplayer/MediaPlayerItemCache;", "Landroidx/collection/LruCache;", "", "Ltv/danmaku/ijk/media/player/IjkMediaPlayerItem;", "<init>", "()V", "entryRemoved", "", "evicted", "", "key", "oldValue", "newValue", "biligifplayer_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class MediaPlayerItemCache extends LruCache<String, IjkMediaPlayerItem> {
    public MediaPlayerItemCache() {
        super(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void entryRemoved(boolean evicted, String key, IjkMediaPlayerItem oldValue, IjkMediaPlayerItem newValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(oldValue, "oldValue");
        super.entryRemoved(evicted, key, oldValue, newValue);
        if (evicted) {
            oldValue.release();
            oldValue.setAssetUpdateListener(null);
        }
    }
}