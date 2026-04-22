package tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.protocol;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.DanmakuConfigChange;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.DanmakuFilterChange;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.DanmakuList;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.GestureEventReceived;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IChronosRpcSender.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u000bH&J¢\u0001\u0010\f\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\r2P\u0010\u000e\u001aL\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0014¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00030\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u00182>\u0010\u0019\u001a:\u0012\u0015\u0012\u0013\u0018\u00010\u001a¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001b\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00030\u000fj\u0002`\u001dH&J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u001fH&J5\u0010 \u001a\u00020\u0003\"\u0004\b\u0000\u0010!2\b\u0010\b\u001a\u0004\u0018\u0001H!2\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0014H&¢\u0006\u0002\u0010\"JI\u0010#\u001a\u0004\u0018\u0001H$\"\u0004\b\u0000\u0010!\"\u0004\b\u0001\u0010$2\b\u0010\b\u001a\u0004\u0018\u0001H!2\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00142\f\u0010&\u001a\b\u0012\u0004\u0012\u0002H$0'H&¢\u0006\u0002\u0010(Jå\u0001\u0010 \u001a\u00020\u0003\"\u0004\b\u0000\u0010!\"\u0004\b\u0001\u0010$2\b\u0010\b\u001a\u0004\u0018\u0001H!2\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00142\f\u0010&\u001a\b\u0012\u0004\u0012\u0002H$0'2V\b\u0002\u0010)\u001aP\u0012\u0015\u0012\u0013\u0018\u0001H$¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0014¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fj\n\u0012\u0004\u0012\u0002H$\u0018\u0001`\u00182D\b\u0002\u0010*\u001a>\u0012\u0015\u0012\u0013\u0018\u00010\u001a¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001b\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fj\u0004\u0018\u0001`\u001dH&¢\u0006\u0002\u0010+ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006,À\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/protocol/IChronosRpcSender;", "", "onChronosValid", "", "onDanmakuVisibilityChanged", "visible", "", "onDanmakuFilterChanged", "req", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/DanmakuFilterChange$Request;", "onDanmakuConfigChanged", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/DanmakuConfigChange$Request;", "requestDanmakuList", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/DanmakuList$Request;", "onComplete", "Lkotlin/Function2;", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/DanmakuList$Response;", "Lkotlin/ParameterName;", "name", "result", "", "", "", "extra", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/ChronosSenderComplete;", "onError", "", "code", "desc", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/ChronosSenderError;", "onGestureEventReceived", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/GestureEventReceived$Request;", "sendAsyncMessage", "T", "(Ljava/lang/Object;Ljava/util/Map;)V", "sendSyncMessage", "U", "ex", "resp", "Ljava/lang/Class;", "(Ljava/lang/Object;Ljava/util/Map;Ljava/lang/Class;)Ljava/lang/Object;", "complete", "error", "(Ljava/lang/Object;Ljava/util/Map;Ljava/lang/Class;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IChronosRpcSender {
    void onChronosValid();

    void onDanmakuConfigChanged(DanmakuConfigChange.Request request);

    void onDanmakuFilterChanged(DanmakuFilterChange.Request request);

    void onDanmakuVisibilityChanged(boolean z);

    boolean onGestureEventReceived(GestureEventReceived.Request request);

    void requestDanmakuList(DanmakuList.Request request, Function2<? super DanmakuList.Response, ? super Map<String, byte[]>, Unit> function2, Function2<? super Integer, ? super String, Unit> function22);

    <T> void sendAsyncMessage(T t, Map<String, byte[]> map);

    <T, U> void sendAsyncMessage(T t, Map<String, byte[]> map, Class<U> cls, Function2<? super U, ? super Map<String, byte[]>, Unit> function2, Function2<? super Integer, ? super String, Unit> function22);

    <T, U> U sendSyncMessage(T t, Map<String, byte[]> map, Class<U> cls);

    /* compiled from: IChronosRpcSender.kt */
    /* renamed from: tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.protocol.IChronosRpcSender$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void sendAsyncMessage$default(IChronosRpcSender iChronosRpcSender, Object obj, Map map, int i, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendAsyncMessage");
            }
            if ((i & 2) != 0) {
                map = null;
            }
            iChronosRpcSender.sendAsyncMessage(obj, map);
        }

        public static /* synthetic */ void sendAsyncMessage$default(IChronosRpcSender iChronosRpcSender, Object obj, Map map, Class cls, Function2 function2, Function2 function22, int i, Object obj2) {
            Function2 function23;
            Function2 function24;
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendAsyncMessage");
            }
            if ((i & 8) == 0) {
                function23 = function2;
            } else {
                function23 = null;
            }
            if ((i & 16) == 0) {
                function24 = function22;
            } else {
                function24 = null;
            }
            iChronosRpcSender.sendAsyncMessage(obj, map, cls, function23, function24);
        }
    }
}