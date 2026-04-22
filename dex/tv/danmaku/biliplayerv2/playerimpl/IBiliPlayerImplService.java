package tv.danmaku.biliplayerv2.playerimpl;

import android.content.Context;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.ControlContainerConfig;
import tv.danmaku.biliplayerv2.ControlContainerType;
import tv.danmaku.biliplayerv2.IPlayerContainer;
import tv.danmaku.biliplayerv2.PlayerParamsV2;
import tv.danmaku.biliplayerv2.service.IPlayerService;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IBiliPlayerImplService.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H&J,\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rH&J\u0016\u0010\u0010\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u00050\u0011H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0013À\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/playerimpl/IBiliPlayerImplService;", "", "isCoreService", "", "clazz", "Ljava/lang/Class;", "createPlayerContainer", "Ltv/danmaku/biliplayerv2/IPlayerContainer;", "context", "Landroid/content/Context;", "playerParams", "Ltv/danmaku/biliplayerv2/PlayerParamsV2;", "controlContainerConfig", "", "Ltv/danmaku/biliplayerv2/ControlContainerType;", "Ltv/danmaku/biliplayerv2/ControlContainerConfig;", "getCoreService", "", "Ltv/danmaku/biliplayerv2/service/IPlayerService;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IBiliPlayerImplService {
    IPlayerContainer createPlayerContainer(Context context, PlayerParamsV2 playerParamsV2, Map<ControlContainerType, ControlContainerConfig> map);

    List<Class<? extends IPlayerService>> getCoreService();

    boolean isCoreService(Class<?> cls);
}