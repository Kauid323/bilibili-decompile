package kntr.base.net.comm.imp;

import com.bilibili.lib.gripper.api.internal.ProducerBase;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.GInterceptor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: InitFFProxyKt_provideFFProxyRequest_Lambda.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0000H\u0016J\u000e\u0010\b\u001a\u00020\u0002H\u0094@¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lkntr/base/net/comm/imp/InitFFProxyKt_provideFFProxyRequest_Lambda;", "Lcom/bilibili/lib/gripper/api/internal/ProducerBase;", "Lkntr/base/net/GInterceptor;", "compatJavaParam", "", "<init>", "(Lkotlin/Unit;)V", "create", "invokeProducer", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ffproxy_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class InitFFProxyKt_provideFFProxyRequest_Lambda extends ProducerBase<GInterceptor> {
    public InitFFProxyKt_provideFFProxyRequest_Lambda(Unit compatJavaParam) {
    }

    public InitFFProxyKt_provideFFProxyRequest_Lambda create() {
        return new InitFFProxyKt_provideFFProxyRequest_Lambda(null);
    }

    protected Object invokeProducer(Continuation<? super GInterceptor> continuation) {
        return InitFFProxyKt.provideFFProxyRequest();
    }
}