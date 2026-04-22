package tv.danmaku.biliplayerv2.service;

import kotlin.Metadata;
import tv.danmaku.bili.ui.videospace.AuthorSpaceHeaderVideoModel;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IPlayerCoreService.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0016J(\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0007H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/IPlayerSourceObserver;", "", "onSourceChanged", "", "success", "", "oldQuality", "", "newQuality", "fromAuto", "onAudioSourceChanged", "onRecommendVideoSourceStarted", AuthorSpaceHeaderVideoModel.EXTRA_PARAM_QUALITY, "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IPlayerSourceObserver {
    void onAudioSourceChanged(boolean z, int i, int i2, boolean z2);

    void onRecommendVideoSourceStarted(int i);

    void onSourceChanged(boolean z, int i, int i2, boolean z2);

    /* compiled from: IPlayerCoreService.kt */
    /* renamed from: tv.danmaku.biliplayerv2.service.IPlayerSourceObserver$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        public static void $default$onSourceChanged(IPlayerSourceObserver _this, boolean success, int oldQuality, int newQuality, boolean fromAuto) {
        }

        public static void $default$onAudioSourceChanged(IPlayerSourceObserver _this, boolean success, int oldQuality, int newQuality, boolean fromAuto) {
        }

        public static void $default$onRecommendVideoSourceStarted(IPlayerSourceObserver _this, int quality) {
        }
    }
}