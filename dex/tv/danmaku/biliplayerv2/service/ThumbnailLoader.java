package tv.danmaku.biliplayerv2.service;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.service.interact.helper.ThumbnailConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SeekService.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\bH&J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/ThumbnailLoader;", "", "fetch", "", "position", "", "duration", "waitFetchRes", "", "hasThumbnails", "setResponseCallback", "callback", "Ltv/danmaku/biliplayerv2/service/ThumbnailFetcherCallback;", "setConfig", "config", "Ltv/danmaku/biliplayerv2/service/interact/helper/ThumbnailConfig;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface ThumbnailLoader {
    void fetch(int i, int i2, boolean z);

    boolean hasThumbnails();

    void setConfig(ThumbnailConfig thumbnailConfig);

    void setResponseCallback(ThumbnailFetcherCallback thumbnailFetcherCallback);

    /* compiled from: SeekService.kt */
    /* renamed from: tv.danmaku.biliplayerv2.service.ThumbnailLoader$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ void fetch$default(ThumbnailLoader thumbnailLoader, int i, int i2, boolean z, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fetch");
            }
            if ((i3 & 4) != 0) {
                z = false;
            }
            thumbnailLoader.fetch(i, i2, z);
        }
    }
}