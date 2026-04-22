package tv.danmaku.biliplayerimpl;

import android.content.Context;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.List;
import java.util.Map;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.ControlContainerConfig;
import tv.danmaku.biliplayerv2.ControlContainerType;
import tv.danmaku.biliplayerv2.IPlayerContainer;
import tv.danmaku.biliplayerv2.PlayerParamsV2;
import tv.danmaku.biliplayerv2.playerimpl.IBiliPlayerImplService;
import tv.danmaku.biliplayerv2.service.IPlayerService;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BiliPlayerImplService.kt */
@Singleton
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0016J,\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fH\u0016J\u0016\u0010\u0012\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u00070\u0013H\u0016¨\u0006\u0015"}, d2 = {"Ltv/danmaku/biliplayerimpl/BiliPlayerImplService;", "Ltv/danmaku/biliplayerv2/playerimpl/IBiliPlayerImplService;", "<init>", "()V", "isCoreService", "", "clazz", "Ljava/lang/Class;", "createPlayerContainer", "Ltv/danmaku/biliplayerv2/IPlayerContainer;", "context", "Landroid/content/Context;", "playerParams", "Ltv/danmaku/biliplayerv2/PlayerParamsV2;", "controlContainerConfig", "", "Ltv/danmaku/biliplayerv2/ControlContainerType;", "Ltv/danmaku/biliplayerv2/ControlContainerConfig;", "getCoreService", "", "Ltv/danmaku/biliplayerv2/service/IPlayerService;", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BiliPlayerImplService implements IBiliPlayerImplService {
    @Override // tv.danmaku.biliplayerv2.playerimpl.IBiliPlayerImplService
    public boolean isCoreService(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        return CorePlayerServicesConfig.INSTANCE.isCoreService(cls);
    }

    @Override // tv.danmaku.biliplayerv2.playerimpl.IBiliPlayerImplService
    public IPlayerContainer createPlayerContainer(Context context, PlayerParamsV2 playerParams, Map<ControlContainerType, ControlContainerConfig> map) {
        Map controlContainerConfig = EnhancedUnmodifiabilityKt.unmodifiable(map);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(playerParams, "playerParams");
        Intrinsics.checkNotNullParameter(controlContainerConfig, "controlContainerConfig");
        return new PlayerContainerImpl(context, playerParams, controlContainerConfig);
    }

    @Override // tv.danmaku.biliplayerv2.playerimpl.IBiliPlayerImplService
    public List<Class<? extends IPlayerService>> getCoreService() {
        return EnhancedUnmodifiabilityKt.unmodifiable(CorePlayerServicesConfig.INSTANCE.getSCorePlayerServices());
    }
}