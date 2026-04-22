package kntr.app.deepsearch.service;

import com.bapis.bilibili.broadcast.message.deepsearch.KDeepSearchResponse;
import com.bapis.bilibili.broadcast.message.deepsearch.KSearchMoss;
import com.google.protobuf.KEmpty;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.log.KLog_androidKt;
import kntr.base.moss.api.KMethodDescriptor;
import kntr.base.moss.api.KMossException;
import kntr.base.moss.api.KMossStream;
import kntr.base.moss.platform.IPlatformResponseHandler;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.serialization.BinaryFormat;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.protobuf.ProtoBuf;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeepSearchBroadcastServiceImp.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/Result;", "Lcom/bapis/bilibili/broadcast/message/deepsearch/KDeepSearchResponse;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.service.DeepSearchBroadcastServiceImp$Companion$startFlow$1", f = "DeepSearchBroadcastServiceImp.kt", i = {0, 0, 0, 0}, l = {83}, m = "invokeSuspend", n = {"$this$callbackFlow", "method", "req", "applicationResponseHandler"}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 1)
public final class DeepSearchBroadcastServiceImp$Companion$startFlow$1 extends SuspendLambda implements Function2<ProducerScope<? super Result<? extends KDeepSearchResponse>>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DeepSearchBroadcastServiceImp$Companion$startFlow$1(Continuation<? super DeepSearchBroadcastServiceImp$Companion$startFlow$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> deepSearchBroadcastServiceImp$Companion$startFlow$1 = new DeepSearchBroadcastServiceImp$Companion$startFlow$1(continuation);
        deepSearchBroadcastServiceImp$Companion$startFlow$1.L$0 = obj;
        return deepSearchBroadcastServiceImp$Companion$startFlow$1;
    }

    public final Object invoke(ProducerScope<? super Result<KDeepSearchResponse>> producerScope, Continuation<? super Unit> continuation) {
        return create(producerScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        final ProducerScope $this$callbackFlow = (ProducerScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final KMethodDescriptor method = KSearchMoss.Companion.getDeepSearchResponsePushMethod();
                BinaryFormat $this$encodeToByteArray$iv = ProtoBuf.Default;
                Object value$iv = new KEmpty();
                $this$encodeToByteArray$iv.getSerializersModule();
                byte[] req = $this$encodeToByteArray$iv.encodeToByteArray(KEmpty.Companion.serializer(), value$iv);
                IPlatformResponseHandler iPlatformResponseHandler = new IPlatformResponseHandler() { // from class: kntr.app.deepsearch.service.DeepSearchBroadcastServiceImp$Companion$startFlow$1$applicationResponseHandler$1
                    public /* bridge */ void onCompleted() {
                        IPlatformResponseHandler.-CC.$default$onCompleted(this);
                    }

                    public void onNext(byte[] value) {
                        KDeepSearchResponse response = null;
                        if (value != null) {
                            try {
                                BinaryFormat $this$decodeFromByteArray$iv = ProtoBuf.Default;
                                $this$decodeFromByteArray$iv.getSerializersModule();
                                response = (KDeepSearchResponse) $this$decodeFromByteArray$iv.decodeFromByteArray(KDeepSearchResponse.Companion.serializer(), value);
                            } catch (SerializationException e) {
                            }
                        }
                        if (response != null) {
                            try {
                                ProducerScope<Result<KDeepSearchResponse>> producerScope = $this$callbackFlow;
                                Result.Companion companion = Result.Companion;
                                producerScope.trySend-JP2dKIU(Result.box-impl(Result.constructor-impl(response)));
                            } catch (Exception e2) {
                                KLog_androidKt.getKLog().i("DeepSearchBroadcastServiceImp", "broadcast send error: " + e2.getMessage());
                            }
                        }
                    }

                    public void onError(KMossException t) {
                        if (t != null) {
                            ProducerScope<Result<KDeepSearchResponse>> producerScope = $this$callbackFlow;
                            Result.Companion companion = Result.Companion;
                            producerScope.trySend-JP2dKIU(Result.box-impl(Result.constructor-impl(ResultKt.createFailure((Throwable) t))));
                            return;
                        }
                        ProducerScope<Result<KDeepSearchResponse>> producerScope2 = $this$callbackFlow;
                        Result.Companion companion2 = Result.Companion;
                        producerScope2.trySend-JP2dKIU(Result.box-impl(Result.constructor-impl(ResultKt.createFailure(new KMossException("deepsearch broadcast error", (Throwable) null)))));
                    }
                };
                KMossStream.Companion.getShared().register(method, req, iPlatformResponseHandler);
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$callbackFlow);
                this.L$1 = SpillingKt.nullOutSpilledVariable(method);
                this.L$2 = SpillingKt.nullOutSpilledVariable(req);
                this.L$3 = SpillingKt.nullOutSpilledVariable(iPlatformResponseHandler);
                this.label = 1;
                if (ProduceKt.awaitClose($this$callbackFlow, new Function0() { // from class: kntr.app.deepsearch.service.DeepSearchBroadcastServiceImp$Companion$startFlow$1$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = DeepSearchBroadcastServiceImp$Companion$startFlow$1.invokeSuspend$lambda$0(method);
                        return invokeSuspend$lambda$0;
                    }
                }, (Continuation) this) != coroutine_suspended) {
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                DeepSearchBroadcastServiceImp$Companion$startFlow$1$applicationResponseHandler$1 deepSearchBroadcastServiceImp$Companion$startFlow$1$applicationResponseHandler$1 = (DeepSearchBroadcastServiceImp$Companion$startFlow$1$applicationResponseHandler$1) this.L$3;
                byte[] bArr = (byte[]) this.L$2;
                KMethodDescriptor kMethodDescriptor = (KMethodDescriptor) this.L$1;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(KMethodDescriptor $method) {
        KLog_androidKt.getKLog().i("DeepSearchBroadcastServiceImp", "broadcast close");
        KMossStream.Companion.getShared().unregister($method);
        return Unit.INSTANCE;
    }
}