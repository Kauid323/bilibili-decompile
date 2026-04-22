package io.ktor.client.plugins.observer;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.open.log.TraceLevel;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.observer.AfterReceiveHook;
import io.ktor.client.statement.HttpResponse;
import io.ktor.util.ByteChannelsKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ResponseObserver.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/client/plugins/observer/AfterReceiveHook$Context;", "response", "Lio/ktor/client/statement/HttpResponse;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.observer.ResponseObserverKt$ResponseObserver$2$1", f = "ResponseObserver.kt", i = {0, 0, 0}, l = {TraceLevel.ALL, 72}, m = "invokeSuspend", n = {"$this$on", "newResponse", "sideResponse"}, s = {"L$0", "L$1", "L$2"})
public final class ResponseObserverKt$ResponseObserver$2$1 extends SuspendLambda implements Function3<AfterReceiveHook.Context, HttpResponse, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<HttpClientCall, Boolean> $filter;
    final /* synthetic */ Function2<HttpResponse, Continuation<? super Unit>, Object> $responseHandler;
    final /* synthetic */ ClientPluginBuilder<ResponseObserverConfig> $this_createClientPlugin;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ResponseObserverKt$ResponseObserver$2$1(Function1<? super HttpClientCall, Boolean> function1, ClientPluginBuilder<ResponseObserverConfig> clientPluginBuilder, Function2<? super HttpResponse, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super ResponseObserverKt$ResponseObserver$2$1> continuation) {
        super(3, continuation);
        this.$filter = function1;
        this.$this_createClientPlugin = clientPluginBuilder;
        this.$responseHandler = function2;
    }

    public final Object invoke(AfterReceiveHook.Context context, HttpResponse httpResponse, Continuation<? super Unit> continuation) {
        ResponseObserverKt$ResponseObserver$2$1 responseObserverKt$ResponseObserver$2$1 = new ResponseObserverKt$ResponseObserver$2$1(this.$filter, this.$this_createClientPlugin, this.$responseHandler, continuation);
        responseObserverKt$ResponseObserver$2$1.L$0 = context;
        responseObserverKt$ResponseObserver$2$1.L$1 = httpResponse;
        return responseObserverKt$ResponseObserver$2$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00d1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d2  */
    /* JADX WARN: Type inference failed for: r1v8, types: [kotlinx.coroutines.CoroutineScope] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        HttpResponse sideResponse;
        HttpResponse newResponse;
        AfterReceiveHook.Context $this$on;
        HttpClient httpClient;
        Object $result2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                AfterReceiveHook.Context $this$on2 = (AfterReceiveHook.Context) this.L$0;
                HttpResponse response = (HttpResponse) this.L$1;
                Function1<HttpClientCall, Boolean> function1 = this.$filter;
                boolean z = false;
                if (function1 != null && !((Boolean) function1.invoke(response.getCall())).booleanValue()) {
                    z = true;
                }
                if (z) {
                    return Unit.INSTANCE;
                }
                Pair split = ByteChannelsKt.split(response.getRawContent(), response);
                ByteReadChannel loggingContent = (ByteReadChannel) split.component1();
                ByteReadChannel responseContent = (ByteReadChannel) split.component2();
                HttpResponse newResponse2 = DelegatedCallKt.wrapWithContent(response.getCall(), responseContent).getResponse();
                HttpResponse response2 = DelegatedCallKt.wrapWithContent(response.getCall(), loggingContent).getResponse();
                HttpClient client = this.$this_createClientPlugin.getClient();
                this.L$0 = $this$on2;
                this.L$1 = newResponse2;
                this.L$2 = response2;
                this.L$3 = client;
                this.label = 1;
                Object responseObserverContext = ResponseObserverContextJvmKt.getResponseObserverContext((Continuation) this);
                if (responseObserverContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
                sideResponse = response2;
                newResponse = newResponse2;
                $this$on = $this$on2;
                httpClient = client;
                $result2 = $result;
                $result = responseObserverContext;
                BuildersKt.launch$default(httpClient, (CoroutineContext) $result, (CoroutineStart) null, new AnonymousClass1(sideResponse, this.$responseHandler, null), 2, (Object) null);
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.L$3 = null;
                this.label = 2;
                if ($this$on.proceedWith(newResponse, (Continuation) this) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                HttpResponse sideResponse2 = (HttpResponse) this.L$2;
                ResultKt.throwOnFailure($result);
                sideResponse = sideResponse2;
                newResponse = (HttpResponse) this.L$1;
                $this$on = (AfterReceiveHook.Context) this.L$0;
                httpClient = (CoroutineScope) this.L$3;
                $result2 = $result;
                BuildersKt.launch$default(httpClient, (CoroutineContext) $result, (CoroutineStart) null, new AnonymousClass1(sideResponse, this.$responseHandler, null), 2, (Object) null);
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.L$3 = null;
                this.label = 2;
                if ($this$on.proceedWith(newResponse, (Continuation) this) != coroutine_suspended) {
                }
                break;
            case 2:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ResponseObserver.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.plugins.observer.ResponseObserverKt$ResponseObserver$2$1$1", f = "ResponseObserver.kt", i = {0}, l = {64, WXMediaMessage.IMediaObject.TYPE_OPENSDK_LITEAPP}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    /* renamed from: io.ktor.client.plugins.observer.ResponseObserverKt$ResponseObserver$2$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<HttpResponse, Continuation<? super Unit>, Object> $responseHandler;
        final /* synthetic */ HttpResponse $sideResponse;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(HttpResponse httpResponse, Function2<? super HttpResponse, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$sideResponse = httpResponse;
            this.$responseHandler = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$sideResponse, this.$responseHandler, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object $result2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                try {
                } catch (Throwable th) {
                    Result.Companion companion = Result.Companion;
                    Result.constructor-impl(ResultKt.createFailure(th));
                }
            } catch (Throwable th2) {
                th = th2;
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.createFailure(th));
                return Unit.INSTANCE;
            }
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    CoroutineScope $this$launch = (CoroutineScope) this.L$0;
                    Function2<HttpResponse, Continuation<? super Unit>, Object> function2 = this.$responseHandler;
                    HttpResponse httpResponse = this.$sideResponse;
                    Result.Companion companion3 = Result.Companion;
                    this.L$0 = $this$launch;
                    this.label = 1;
                    if (function2.invoke(httpResponse, this) != coroutine_suspended) {
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                case 1:
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                    ResultKt.throwOnFailure($result);
                    break;
                case 2:
                    ResultKt.throwOnFailure($result);
                    $result2 = $result;
                    try {
                        Result.constructor-impl(Boxing.boxLong(((Number) $result).longValue()));
                    } catch (Throwable th3) {
                        th = th3;
                        Result.Companion companion22 = Result.Companion;
                        Result.constructor-impl(ResultKt.createFailure(th));
                        return Unit.INSTANCE;
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Result.constructor-impl(Unit.INSTANCE);
            ByteReadChannel content = this.$sideResponse.getRawContent();
            if (!content.isClosedForRead()) {
                Result.Companion companion4 = Result.Companion;
                this.L$0 = null;
                this.label = 2;
                Object discard$default = ByteReadChannelOperationsKt.discard$default(content, 0L, this, 1, (Object) null);
                if (discard$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $result2 = $result;
                $result = discard$default;
                Result.constructor-impl(Boxing.boxLong(((Number) $result).longValue()));
            }
            return Unit.INSTANCE;
        }
    }
}