package kntr.base.moss.api;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SerializationStrategy;

/* compiled from: KSuspendCall.kt */
@Metadata(d1 = {"\u0000&\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a\u008a\u0001\u0010\u0000\u001a\u0002H\u0001\"\f\b\u0000\u0010\u0002*\u00060\u0003j\u0002`\u0004\"\f\b\u0001\u0010\u0001*\u00060\u0003j\u0002`\u00042:\b\u0004\u0010\u0005\u001a4\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\b\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\t\u0012\u0004\u0012\u00020\n0\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00010\b2\u0006\u0010\r\u001a\u0002H\u0002H\u0086H¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"suspendCall", "KRespT", "KReqT", "", "Lkntr/base/moss/api/KProtoMessage;", "call", "Lkotlin/Function4;", "Lkotlinx/serialization/SerializationStrategy;", "Lkotlinx/serialization/DeserializationStrategy;", "Lkntr/base/moss/api/KMossResponseHandler;", "", "reqSerializer", "respSerializationStrategy", "req", "(Lkotlin/jvm/functions/Function4;Lkotlinx/serialization/SerializationStrategy;Lkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "moss_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KSuspendCallKt {
    public static final <KReqT, KRespT> Object suspendCall(Function4<? super KReqT, ? super SerializationStrategy<? super KReqT>, ? super DeserializationStrategy<? extends KRespT>, ? super KMossResponseHandler<KRespT>, Unit> function4, SerializationStrategy<? super KReqT> serializationStrategy, DeserializationStrategy<? extends KRespT> deserializationStrategy, KReqT kreqt, Continuation<? super KRespT> continuation) {
        CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuation it = cancellableContinuationImpl;
        function4.invoke(kreqt, serializationStrategy, deserializationStrategy, new KSuspendCallKt$suspendCall$2$1(it));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    private static final <KReqT, KRespT> Object suspendCall$$forInline(Function4<? super KReqT, ? super SerializationStrategy<? super KReqT>, ? super DeserializationStrategy<? extends KRespT>, ? super KMossResponseHandler<KRespT>, Unit> function4, SerializationStrategy<? super KReqT> serializationStrategy, DeserializationStrategy<? extends KRespT> deserializationStrategy, KReqT kreqt, Continuation<? super KRespT> continuation) {
        InlineMarker.mark(0);
        Continuation<? super KRespT> uCont$iv = continuation;
        CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(uCont$iv), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuation it = cancellableContinuationImpl;
        function4.invoke(kreqt, serializationStrategy, deserializationStrategy, new KSuspendCallKt$suspendCall$2$1(it));
        Unit unit = Unit.INSTANCE;
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        InlineMarker.mark(1);
        return result;
    }
}