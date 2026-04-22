package tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc;

import android.os.Looper;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import com.bilibili.okretro.call.json.JsonUtilKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.messagewrapper.ChronosAsyncMessage;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.messagewrapper.ChronosSyncMessage;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.DanmakuConfigChange;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.DanmakuFilterChange;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.DanmakuList;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.DanmakuVisibleChange;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.GestureEventReceived;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.protocol.IChronosRpcSender;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: ChronosMessageSender.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 42\u00020\u0001:\u00014B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0014H\u0016J¢\u0001\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00162P\u0010\u0017\u001aL\u0012\u0015\u0012\u0013\u0018\u00010\u0019¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001d¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\f0\u0018j\b\u0012\u0004\u0012\u00020\u0019`!2>\u0010\"\u001a:\u0012\u0015\u0012\u0013\u0018\u00010#¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b($\u0012\u0015\u0012\u0013\u0018\u00010\u001e¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\f0\u0018j\u0002`&H\u0016J\u0010\u0010'\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020(H\u0016J3\u0010)\u001a\u00020\f\"\u0004\b\u0000\u0010*2\b\u0010\u0011\u001a\u0004\u0018\u0001H*2\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001dH\u0016¢\u0006\u0002\u0010+JI\u0010,\u001a\u0004\u0018\u0001H-\"\u0004\b\u0000\u0010*\"\u0004\b\u0001\u0010-2\b\u0010\u0011\u001a\u0004\u0018\u0001H*2\u0014\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001d2\f\u0010/\u001a\b\u0012\u0004\u0012\u0002H-0\bH\u0016¢\u0006\u0002\u00100Já\u0001\u0010)\u001a\u00020\f\"\u0004\b\u0000\u0010*\"\u0004\b\u0001\u0010-2\b\u0010\u0011\u001a\u0004\u0018\u0001H*2\u0014\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001d2\f\u0010/\u001a\b\u0012\u0004\u0012\u0002H-0\b2T\u00101\u001aP\u0012\u0015\u0012\u0013\u0018\u0001H-¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001d¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\f\u0018\u00010\u0018j\n\u0012\u0004\u0012\u0002H-\u0018\u0001`!2B\u00102\u001a>\u0012\u0015\u0012\u0013\u0018\u00010#¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b($\u0012\u0015\u0012\u0013\u0018\u00010\u001e¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\f\u0018\u00010\u0018j\u0004\u0018\u0001`&H\u0016¢\u0006\u0002\u00103R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0006\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/ChronosMessageSender;", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/protocol/IChronosRpcSender;", "messageSender", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/ChronosRpcMessageSender;", "<init>", "(Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/ChronosRpcMessageSender;)V", "mAsyncMessagePool", "", "Ljava/lang/Class;", "", "Ljava/lang/Runnable;", "onChronosValid", "", "onDanmakuVisibilityChanged", "visible", "", "onDanmakuFilterChanged", "req", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/DanmakuFilterChange$Request;", "onDanmakuConfigChanged", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/DanmakuConfigChange$Request;", "requestDanmakuList", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/DanmakuList$Request;", "onComplete", "Lkotlin/Function2;", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/DanmakuList$Response;", "Lkotlin/ParameterName;", "name", "result", "", "", "", "extra", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/ChronosSenderComplete;", "onError", "", "code", "desc", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/ChronosSenderError;", "onGestureEventReceived", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/GestureEventReceived$Request;", "sendAsyncMessage", "T", "(Ljava/lang/Object;Ljava/util/Map;)V", "sendSyncMessage", "U", "ex", "resp", "(Ljava/lang/Object;Ljava/util/Map;Ljava/lang/Class;)Ljava/lang/Object;", "complete", "error", "(Ljava/lang/Object;Ljava/util/Map;Ljava/lang/Class;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "Companion", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ChronosMessageSender implements IChronosRpcSender {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "ChronosMessageSender";
    private final Map<Class<?>, List<Runnable>> mAsyncMessagePool;
    private final ChronosRpcMessageSender messageSender;

    /* compiled from: ChronosMessageSender.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/ChronosMessageSender$Companion;", "", "<init>", "()V", "TAG", "", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public ChronosMessageSender(ChronosRpcMessageSender messageSender) {
        Intrinsics.checkNotNullParameter(messageSender, "messageSender");
        this.messageSender = messageSender;
        this.mAsyncMessagePool = new LinkedHashMap();
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.protocol.IChronosRpcSender
    public void onChronosValid() {
        Runnable flushTask = new Runnable() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.ChronosMessageSender$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                ChronosMessageSender.onChronosValid$lambda$0(ChronosMessageSender.this);
            }
        };
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            flushTask.run();
        } else {
            HandlerThreads.post(0, flushTask);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onChronosValid$lambda$0(ChronosMessageSender this$0) {
        int i;
        Map $this$map$iv = this$0.mAsyncMessagePool;
        Collection destination$iv$iv = new ArrayList($this$map$iv.size());
        for (Map.Entry item$iv$iv : $this$map$iv.entrySet()) {
            destination$iv$iv.add(Integer.valueOf(item$iv$iv.getValue().size()));
        }
        Iterable it = (List) destination$iv$iv;
        if (!Boolean.valueOf(!((Collection) it).isEmpty()).booleanValue()) {
            it = null;
        }
        if (it != null) {
            Iterable $this$reduce$iv = it;
            Iterator iterator$iv = $this$reduce$iv.iterator();
            if (!iterator$iv.hasNext()) {
                throw new UnsupportedOperationException("Empty collection can't be reduced.");
            }
            Object accumulator$iv = iterator$iv.next();
            while (iterator$iv.hasNext()) {
                int p1 = ((Number) iterator$iv.next()).intValue();
                int p0 = ((Number) accumulator$iv).intValue();
                accumulator$iv = Integer.valueOf(p0 + p1);
            }
            i = ((Number) accumulator$iv).intValue();
        } else {
            i = 0;
        }
        BLog.i(TAG, "send cache message size: " + i);
        Map $this$forEach$iv = this$0.mAsyncMessagePool;
        for (Map.Entry element$iv : $this$forEach$iv.entrySet()) {
            if (element$iv.getValue().size() > 1) {
                String name = element$iv.getKey().getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                String str = (String) CollectionsKt.lastOrNull(StringsKt.split$default(name, new String[]{"."}, false, 0, 6, (Object) null));
                if (str == null) {
                    str = IjkMediaMeta.IJKM_VAL_TYPE__UNKNOWN;
                }
                BLog.w(TAG, "cached " + str + " size: " + element$iv.getValue().size());
            }
            List<Runnable> $this$forEach$iv2 = element$iv.getValue();
            for (Runnable it2 : $this$forEach$iv2) {
                it2.run();
            }
        }
        Map $this$forEach$iv3 = this$0.mAsyncMessagePool;
        $this$forEach$iv3.clear();
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.protocol.IChronosRpcSender
    public void onDanmakuVisibilityChanged(boolean visible) {
        DanmakuVisibleChange.Request req = new DanmakuVisibleChange.Request();
        req.setEnabled(Boolean.valueOf(visible));
        IChronosRpcSender.CC.sendAsyncMessage$default(this, req, null, DefaultResponse.class, null, null, 24, null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.protocol.IChronosRpcSender
    public void onDanmakuFilterChanged(DanmakuFilterChange.Request req) {
        Intrinsics.checkNotNullParameter(req, "req");
        BLog.i(TAG, "onDanmakuFilterChanged: " + JsonUtilKt.toJson(req));
        IChronosRpcSender.CC.sendAsyncMessage$default(this, req, null, DefaultResponse.class, null, null, 24, null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.protocol.IChronosRpcSender
    public void onDanmakuConfigChanged(DanmakuConfigChange.Request req) {
        Intrinsics.checkNotNullParameter(req, "req");
        BLog.i(TAG, "onDanmakuConfigChanged: " + JsonUtilKt.toJson(req));
        IChronosRpcSender.CC.sendAsyncMessage$default(this, req, null, DefaultResponse.class, null, null, 24, null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.protocol.IChronosRpcSender
    public void requestDanmakuList(DanmakuList.Request req, Function2<? super DanmakuList.Response, ? super Map<String, byte[]>, Unit> function2, Function2<? super Integer, ? super String, Unit> function22) {
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(function2, "onComplete");
        Intrinsics.checkNotNullParameter(function22, "onError");
        sendAsyncMessage(req, null, DanmakuList.Response.class, function2, function22);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.protocol.IChronosRpcSender
    public boolean onGestureEventReceived(GestureEventReceived.Request req) {
        Boolean handled;
        Intrinsics.checkNotNullParameter(req, "req");
        GestureEventReceived.Response result = (GestureEventReceived.Response) sendSyncMessage(req, null, GestureEventReceived.Response.class);
        if (result == null || (handled = result.getHandled()) == null) {
            return false;
        }
        return handled.booleanValue();
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.protocol.IChronosRpcSender
    public <T> void sendAsyncMessage(T t, Map<String, byte[]> map) {
        Map extra = EnhancedUnmodifiabilityKt.unmodifiable(map);
        IChronosRpcSender.CC.sendAsyncMessage$default(this, t, extra, DefaultResponse.class, null, null, 24, null);
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.protocol.IChronosRpcSender
    public <T, U> U sendSyncMessage(T t, Map<String, byte[]> map, Class<U> cls) {
        Pair<U, Map<String, byte[]>> sendMessageSync;
        Map<String, byte[]> ex = EnhancedUnmodifiabilityKt.unmodifiable(map);
        Intrinsics.checkNotNullParameter(cls, "resp");
        ChronosSyncMessage $this$sendSyncMessage_u24lambda_u240 = new ChronosSyncMessage();
        $this$sendSyncMessage_u24lambda_u240.setRequest(t);
        $this$sendSyncMessage_u24lambda_u240.setExtra(ex);
        $this$sendSyncMessage_u24lambda_u240.setResponse(cls);
        if (!this.messageSender.isChronosValid() || (sendMessageSync = this.messageSender.sendMessageSync($this$sendSyncMessage_u24lambda_u240)) == null) {
            return null;
        }
        return (U) sendMessageSync.getFirst();
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.protocol.IChronosRpcSender
    public <T, U> void sendAsyncMessage(T t, Map<String, byte[]> map, Class<U> cls, Function2<? super U, ? super Map<String, byte[]>, Unit> function2, Function2<? super Integer, ? super String, Unit> function22) {
        Map<String, byte[]> ex = EnhancedUnmodifiabilityKt.unmodifiable(map);
        Intrinsics.checkNotNullParameter(cls, "resp");
        if (t == null) {
            return;
        }
        final ChronosAsyncMessage $this$sendAsyncMessage_u24lambda_u240 = new ChronosAsyncMessage();
        $this$sendAsyncMessage_u24lambda_u240.setRequest(t);
        $this$sendAsyncMessage_u24lambda_u240.setExtra(ex);
        $this$sendAsyncMessage_u24lambda_u240.setResponse(cls);
        $this$sendAsyncMessage_u24lambda_u240.setOnComplete(function2);
        $this$sendAsyncMessage_u24lambda_u240.setOnError(function22);
        if (!this.messageSender.isChronosValid()) {
            Class clazz = t.getClass();
            if (!this.mAsyncMessagePool.containsKey(clazz)) {
                this.mAsyncMessagePool.put(clazz, new ArrayList());
            }
            try {
                List<Runnable> list = this.mAsyncMessagePool.get(clazz);
                if (list != null) {
                    Boolean.valueOf(list.add(new Runnable() { // from class: tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.ChronosMessageSender$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            ChronosMessageSender.sendAsyncMessage$lambda$0$0(ChronosMessageSender.this, $this$sendAsyncMessage_u24lambda_u240);
                        }
                    }));
                    return;
                }
                return;
            } catch (Exception e) {
                BLog.e(e.toString());
                Unit unit = Unit.INSTANCE;
                return;
            }
        }
        this.messageSender.sendMessageAsync($this$sendAsyncMessage_u24lambda_u240);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendAsyncMessage$lambda$0$0(ChronosMessageSender this$0, ChronosAsyncMessage $this_apply) {
        this$0.messageSender.sendMessageAsync($this_apply);
    }
}