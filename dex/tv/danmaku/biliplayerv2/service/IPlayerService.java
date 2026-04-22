package tv.danmaku.biliplayerv2.service;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.PlayerSharingBundle;
import tv.danmaku.biliplayerv2.PlayerSharingType;
import tv.danmaku.biliplayerv2.service.PlayerServiceManager;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IPlayerService.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\u001a\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001c\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0003"}, d2 = {"Ltv/danmaku/biliplayerv2/service/IPlayerService;", "", "onStart", "", "bundle", "Ltv/danmaku/biliplayerv2/PlayerSharingBundle;", "onStop", "bindPlayerContainer", "playerContainer", "Ltv/danmaku/biliplayerv2/PlayerContainer;", "onPlayerReset", "onCollectSharedParams", "sharingType", "Ltv/danmaku/biliplayerv2/PlayerSharingType;", "onAttachByShared", "serviceConfig", "Ltv/danmaku/biliplayerv2/service/PlayerServiceManager$ServiceConfig;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IPlayerService {
    void bindPlayerContainer(PlayerContainer playerContainer);

    void onAttachByShared(PlayerSharingType playerSharingType, PlayerSharingBundle playerSharingBundle);

    void onCollectSharedParams(PlayerSharingType playerSharingType, PlayerSharingBundle playerSharingBundle);

    void onPlayerReset();

    void onStart(PlayerSharingBundle playerSharingBundle);

    void onStop();

    PlayerServiceManager.ServiceConfig serviceConfig();

    /* compiled from: IPlayerService.kt */
    /* renamed from: tv.danmaku.biliplayerv2.service.IPlayerService$-CC */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        public static void $default$onPlayerReset(IPlayerService _this) {
        }

        public static void $default$onCollectSharedParams(IPlayerService _this, PlayerSharingType sharingType, PlayerSharingBundle bundle) {
            Intrinsics.checkNotNullParameter(sharingType, "sharingType");
            Intrinsics.checkNotNullParameter(bundle, "bundle");
        }

        public static /* synthetic */ void onCollectSharedParams$default(IPlayerService iPlayerService, PlayerSharingType playerSharingType, PlayerSharingBundle playerSharingBundle, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onCollectSharedParams");
            }
            if ((i & 1) != 0) {
                playerSharingType = PlayerSharingType.NORMAL;
            }
            iPlayerService.onCollectSharedParams(playerSharingType, playerSharingBundle);
        }

        public static void $default$onAttachByShared(IPlayerService _this, PlayerSharingType sharingType, PlayerSharingBundle bundle) {
            Intrinsics.checkNotNullParameter(sharingType, "sharingType");
        }

        public static /* synthetic */ void onAttachByShared$default(IPlayerService iPlayerService, PlayerSharingType playerSharingType, PlayerSharingBundle playerSharingBundle, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onAttachByShared");
            }
            if ((i & 1) != 0) {
                playerSharingType = PlayerSharingType.NORMAL;
            }
            iPlayerService.onAttachByShared(playerSharingType, playerSharingBundle);
        }

        public static PlayerServiceManager.ServiceConfig $default$serviceConfig(IPlayerService _this) {
            if (PlayerServiceManager.Companion.isCoreService$biliplayerv2_debug(_this.getClass())) {
                return PlayerServiceManager.ServiceConfig.Companion.obtain(true);
            }
            return PlayerServiceManager.ServiceConfig.Companion.obtain(false);
        }
    }

    /* compiled from: IPlayerService.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static void bindPlayerContainer(IPlayerService $this, PlayerContainer playerContainer) {
            Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
            Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        }

        @Deprecated
        public static void onPlayerReset(IPlayerService $this) {
            CC.$default$onPlayerReset($this);
        }

        @Deprecated
        public static void onCollectSharedParams(IPlayerService $this, PlayerSharingType sharingType, PlayerSharingBundle bundle) {
            Intrinsics.checkNotNullParameter(sharingType, "sharingType");
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            CC.$default$onCollectSharedParams($this, sharingType, bundle);
        }

        @Deprecated
        public static void onAttachByShared(IPlayerService $this, PlayerSharingType sharingType, PlayerSharingBundle bundle) {
            Intrinsics.checkNotNullParameter(sharingType, "sharingType");
            Intrinsics.checkNotNullParameter(sharingType, "sharingType");
        }

        @Deprecated
        public static PlayerServiceManager.ServiceConfig serviceConfig(IPlayerService $this) {
            return CC.$default$serviceConfig($this);
        }
    }
}