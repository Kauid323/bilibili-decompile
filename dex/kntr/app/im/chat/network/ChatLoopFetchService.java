package kntr.app.im.chat.network;

import im.base.config.IMConfigSetting;
import javax.inject.Inject;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: ChatLoopFetchService.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lkntr/app/im/chat/network/ChatLoopFetchService;", RoomRecommendViewModel.EMPTY_CURSOR, "setting", "Lim/base/config/IMConfigSetting;", "<init>", "(Lim/base/config/IMConfigSetting;)V", "flow", "Lkotlinx/coroutines/flow/Flow;", RoomRecommendViewModel.EMPTY_CURSOR, "getFlow", "()Lkotlinx/coroutines/flow/Flow;", "network_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ChatLoopFetchService {
    private final Flow<Unit> flow;
    private final IMConfigSetting setting;

    @Inject
    public ChatLoopFetchService(IMConfigSetting setting) {
        Flow<Unit> emptyFlow;
        Intrinsics.checkNotNullParameter(setting, "setting");
        this.setting = setting;
        if (Duration.compareTo-LRDsOJo(this.setting.getChatLoopFetchDuration-UwyO8pc(), Duration.Companion.getZERO-UwyO8pc()) > 0) {
            emptyFlow = FlowKt.flow(new ChatLoopFetchService$flow$1(this, null));
        } else {
            emptyFlow = FlowKt.emptyFlow();
        }
        this.flow = emptyFlow;
    }

    public final Flow<Unit> getFlow() {
        return this.flow;
    }
}