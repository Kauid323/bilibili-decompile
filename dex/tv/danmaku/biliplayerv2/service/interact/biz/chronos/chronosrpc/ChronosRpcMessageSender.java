package tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.messagewrapper.ChronosAsyncMessage;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.messagewrapper.ChronosSyncMessage;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: HandlerInterface.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001JF\u0010\u0002\u001a \u0012\u0006\u0012\u0004\u0018\u0001H\u0004\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005\u0018\u00010\u0003\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\u00040\nH&J(\u0010\u000b\u001a\u00020\f\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u00042\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\u00040\u000eH&J\b\u0010\u000f\u001a\u00020\u0010H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/ChronosRpcMessageSender;", "", "sendMessageSync", "Lkotlin/Pair;", "U", "", "", "", "T", "chronosSyncMessage", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/messagewrapper/ChronosSyncMessage;", "sendMessageAsync", "", "chronosAsyncMsg", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/messagewrapper/ChronosAsyncMessage;", "isChronosValid", "", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface ChronosRpcMessageSender {
    boolean isChronosValid();

    <T, U> void sendMessageAsync(ChronosAsyncMessage<T, U> chronosAsyncMessage);

    <T, U> Pair<U, Map<String, byte[]>> sendMessageSync(ChronosSyncMessage<T, U> chronosSyncMessage);
}