package tv.danmaku.video.bilicardplayer.player;

import com.bilibili.playerbizcommon.features.headset.PlayerHeadsetService;
import com.bilibili.playerbizcommon.features.network.PlayerNetworkService;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import tv.danmaku.biliplayerv2.service.PlayerServiceManager;
import tv.danmaku.biliplayerv2.service.business.ServiceElement;
import tv.danmaku.biliplayerv2.service.business.StartMode;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: CardPlayerBuiltServices.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"CardPlayerBuiltInServices", "", "Ltv/danmaku/biliplayerv2/service/business/ServiceElement;", "getCardPlayerBuiltInServices", "()Ljava/util/List;", "bilicardplayer_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class CardPlayerBuiltServicesKt {
    private static final List<ServiceElement> CardPlayerBuiltInServices = CollectionsKt.listOf(new ServiceElement[]{new ServiceElement(PlayerServiceManager.ServiceDescriptor.Companion.obtain(CardBackgroundPlayService.class), StartMode.Immediately), new ServiceElement(PlayerServiceManager.ServiceDescriptor.Companion.obtain(PlayerHeadsetService.class), StartMode.Immediately), new ServiceElement(PlayerServiceManager.ServiceDescriptor.Companion.obtain(CardPlayerQualityService.class), StartMode.Immediately), new ServiceElement(PlayerServiceManager.ServiceDescriptor.Companion.obtain(PlayerNetworkService.class), StartMode.Immediately), new ServiceElement(PlayerServiceManager.ServiceDescriptor.Companion.obtain(PlayerNetworkService.class), StartMode.Immediately)});

    public static final List<ServiceElement> getCardPlayerBuiltInServices() {
        return CardPlayerBuiltInServices;
    }
}