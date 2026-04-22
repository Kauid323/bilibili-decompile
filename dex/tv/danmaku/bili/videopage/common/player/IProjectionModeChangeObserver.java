package tv.danmaku.bili.videopage.common.player;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IProjectionModeChangeObserver.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0007H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/videopage/common/player/IProjectionModeChangeObserver;", "", "onEnterProjectionMode", "", "onExitProjectionMode", "onProjectionDanmakuChanged", "show", "", "onProjectionDevicesSearchPageShown", "onProjectionItemOperationChange", "configChange", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IProjectionModeChangeObserver {
    void onEnterProjectionMode();

    void onExitProjectionMode();

    void onProjectionDanmakuChanged(boolean z);

    void onProjectionDevicesSearchPageShown();

    void onProjectionItemOperationChange(boolean z);

    /* compiled from: IProjectionModeChangeObserver.kt */
    /* renamed from: tv.danmaku.bili.videopage.common.player.IProjectionModeChangeObserver$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        public static void $default$onProjectionDanmakuChanged(IProjectionModeChangeObserver _this, boolean show) {
        }

        public static void $default$onProjectionDevicesSearchPageShown(IProjectionModeChangeObserver _this) {
        }

        public static void $default$onProjectionItemOperationChange(IProjectionModeChangeObserver _this, boolean configChange) {
        }
    }
}