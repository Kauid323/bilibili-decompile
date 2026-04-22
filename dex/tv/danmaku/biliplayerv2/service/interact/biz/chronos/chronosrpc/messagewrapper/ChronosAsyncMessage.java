package tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.messagewrapper;

import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.wauth.WAuthErrorMsg;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ChronosAsyncMessage.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u001e\u0010\u0006\u001a\u0004\u0018\u00018\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\rX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R(\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019Rh\u0010\u001a\u001aP\u0012\u0015\u0012\u0013\u0018\u00018\u0001¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0013¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001bj\n\u0012\u0004\u0012\u00028\u0001\u0018\u0001` X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$RV\u0010%\u001a>\u0012\u0015\u0012\u0013\u0018\u00010&¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b('\u0012\u0015\u0012\u0013\u0018\u00010\u0014¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001bj\u0004\u0018\u0001`)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\"\"\u0004\b+\u0010$¨\u0006,"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/messagewrapper/ChronosAsyncMessage;", "T", "U", "", "<init>", "()V", WAuthErrorMsg.ERROR_MESSAGE_REQUEST, "getRequest", "()Ljava/lang/Object;", "setRequest", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "response", "Ljava/lang/Class;", "getResponse", "()Ljava/lang/Class;", "setResponse", "(Ljava/lang/Class;)V", "extra", "", "", "", "getExtra", "()Ljava/util/Map;", "setExtra", "(Ljava/util/Map;)V", "onComplete", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "result", "", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/ChronosSenderComplete;", "getOnComplete", "()Lkotlin/jvm/functions/Function2;", "setOnComplete", "(Lkotlin/jvm/functions/Function2;)V", "onError", "", "code", "desc", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/ChronosSenderError;", "getOnError", "setOnError", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ChronosAsyncMessage<T, U> {
    private Map<String, byte[]> extra;
    private Function2<? super U, ? super Map<String, byte[]>, Unit> onComplete;
    private Function2<? super Integer, ? super String, Unit> onError;
    private T request;
    public Class<U> response;

    public final T getRequest() {
        return this.request;
    }

    public final void setRequest(T t) {
        this.request = t;
    }

    public final Class<U> getResponse() {
        Class<U> cls = this.response;
        if (cls != null) {
            return cls;
        }
        Intrinsics.throwUninitializedPropertyAccessException("response");
        return null;
    }

    public final void setResponse(Class<U> cls) {
        Intrinsics.checkNotNullParameter(cls, "<set-?>");
        this.response = cls;
    }

    public final Map<String, byte[]> getExtra() {
        return EnhancedUnmodifiabilityKt.unmodifiable(this.extra);
    }

    public final void setExtra(Map<String, byte[]> map) {
        this.extra = map;
    }

    public final Function2<U, Map<String, byte[]>, Unit> getOnComplete() {
        return (Function2<? super U, ? super Map<String, byte[]>, Unit>) this.onComplete;
    }

    public final void setOnComplete(Function2<? super U, ? super Map<String, byte[]>, Unit> function2) {
        this.onComplete = function2;
    }

    public final Function2<Integer, String, Unit> getOnError() {
        return this.onError;
    }

    public final void setOnError(Function2<? super Integer, ? super String, Unit> function2) {
        this.onError = function2;
    }
}