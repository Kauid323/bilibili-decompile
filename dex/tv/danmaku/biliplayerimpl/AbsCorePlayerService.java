package tv.danmaku.biliplayerimpl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.PlayerSharingBundle;
import tv.danmaku.biliplayerv2.PlayerSharingType;
import tv.danmaku.biliplayerv2.service.IPlayerService;
import tv.danmaku.biliplayerv2.service.PlayerServiceManager;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: AbsCorePlayerService.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Ltv/danmaku/biliplayerimpl/AbsCorePlayerService;", "Ltv/danmaku/biliplayerv2/service/IPlayerService;", "<init>", "()V", "bindPlayerContainer", "", "playerContainer", "Ltv/danmaku/biliplayerv2/PlayerContainer;", "Ltv/danmaku/biliplayerimpl/PlayerContainerImpl;", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public abstract class AbsCorePlayerService implements IPlayerService {
    public abstract void bindPlayerContainer(PlayerContainerImpl playerContainerImpl);

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public /* synthetic */ void onAttachByShared(PlayerSharingType playerSharingType, PlayerSharingBundle playerSharingBundle) {
        Intrinsics.checkNotNullParameter(playerSharingType, "sharingType");
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public /* synthetic */ void onCollectSharedParams(PlayerSharingType playerSharingType, PlayerSharingBundle playerSharingBundle) {
        IPlayerService.CC.$default$onCollectSharedParams(this, playerSharingType, playerSharingBundle);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public /* synthetic */ void onPlayerReset() {
        IPlayerService.CC.$default$onPlayerReset(this);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public /* synthetic */ PlayerServiceManager.ServiceConfig serviceConfig() {
        return IPlayerService.CC.$default$serviceConfig(this);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public final void bindPlayerContainer(PlayerContainer playerContainer) {
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        bindPlayerContainer((PlayerContainerImpl) playerContainer);
    }
}