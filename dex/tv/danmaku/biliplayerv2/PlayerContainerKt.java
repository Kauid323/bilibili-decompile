package tv.danmaku.biliplayerv2;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.service.IPlayDirector;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PlayerContainer.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H\u0001\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"TAG", "", "getPlayDirector", "Ltv/danmaku/biliplayerv2/service/IPlayDirector;", "Ltv/danmaku/biliplayerv2/PlayerContainer;", "Ltv/danmaku/biliplayerv2/IPlayerContainer;", "biliplayerv2_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PlayerContainerKt {
    public static final String TAG = "BiliPlayerV2";

    /* compiled from: PlayerContainer.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DirectorVersion.values().length];
            try {
                iArr[DirectorVersion.V1.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[DirectorVersion.V3.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final IPlayDirector getPlayDirector(PlayerContainer $this$getPlayDirector) {
        Intrinsics.checkNotNullParameter($this$getPlayDirector, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[$this$getPlayDirector.getPlayerParams().getConfig().getDirectorVersion().ordinal()]) {
            case 1:
                return $this$getPlayDirector.getVideoPlayDirectorService();
            case 2:
                return $this$getPlayDirector.getPlayDirectorServiceV3();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final IPlayDirector getPlayDirector(IPlayerContainer $this$getPlayDirector) {
        Intrinsics.checkNotNullParameter($this$getPlayDirector, "<this>");
        PlayerContainer playerContainer = (PlayerContainer) $this$getPlayDirector;
        return getPlayDirector(playerContainer);
    }
}