package io.ktor.client;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.engine.HttpClientEngine;
import io.ktor.client.engine.HttpClientEngineCapability;
import io.ktor.client.engine.HttpClientEngineConfig;
import io.ktor.client.plugins.BodyProgressKt;
import io.ktor.client.plugins.DefaultResponseValidationKt;
import io.ktor.client.plugins.DefaultTransformKt;
import io.ktor.client.plugins.DoubleReceivePluginKt;
import io.ktor.client.plugins.HttpCallValidatorKt;
import io.ktor.client.plugins.HttpClientPluginKt;
import io.ktor.client.plugins.HttpPlainTextKt;
import io.ktor.client.plugins.HttpRedirectKt;
import io.ktor.client.plugins.HttpRequestLifecycleKt;
import io.ktor.client.plugins.HttpSend;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.client.request.HttpSendPipeline;
import io.ktor.client.statement.HttpReceivePipeline;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseContainer;
import io.ktor.client.statement.HttpResponsePipeline;
import io.ktor.client.utils.ClientEventsKt;
import io.ktor.client.utils.HttpResponseReceiveFail;
import io.ktor.events.Events;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import io.ktor.util.AttributesJvmKt;
import io.ktor.util.pipeline.PipelineContext;
import java.io.Closeable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* compiled from: HttpClient.kt */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003B!\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nB)\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\t\u0010\rJ\u0018\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0080@¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0016\u001a\u00020\u000b2\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u0014¢\u0006\u0004\b\u0016\u0010\u0017J*\u0010\u001c\u001a\u00020\u00002\u001b\u0010\u001b\u001a\u0017\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00020\u00190\u0018¢\u0006\u0002\b\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010#\u001a\u0004\b$\u0010%R\u001c\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010&R\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010'R\u0014\u0010)\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u001a\u0010,\u001a\u00020+8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0017\u00101\u001a\u0002008\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0017\u00106\u001a\u0002058\u0006¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u0017\u0010;\u001a\u00020:8\u0006¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u0017\u0010@\u001a\u00020?8\u0006¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\u0017\u0010E\u001a\u00020D8\u0006¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\u0017\u0010I\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010LR\u0017\u0010N\u001a\u00020M8\u0006¢\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010QR \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001c\u0010&\u001a\u0004\bR\u0010S¨\u0006T"}, d2 = {"Lio/ktor/client/HttpClient;", "Lkotlinx/coroutines/CoroutineScope;", "Ljava/io/Closeable;", "Lio/ktor/utils/io/core/Closeable;", "Lio/ktor/client/engine/HttpClientEngine;", "engine", "Lio/ktor/client/HttpClientConfig;", "Lio/ktor/client/engine/HttpClientEngineConfig;", "userConfig", "<init>", "(Lio/ktor/client/engine/HttpClientEngine;Lio/ktor/client/HttpClientConfig;)V", "", "manageEngine", "(Lio/ktor/client/engine/HttpClientEngine;Lio/ktor/client/HttpClientConfig;Z)V", "Lio/ktor/client/request/HttpRequestBuilder;", "builder", "Lio/ktor/client/call/HttpClientCall;", "execute$ktor_client_core", "(Lio/ktor/client/request/HttpRequestBuilder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "execute", "Lio/ktor/client/engine/HttpClientEngineCapability;", "capability", "isSupported", "(Lio/ktor/client/engine/HttpClientEngineCapability;)Z", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "block", "config", "(Lkotlin/jvm/functions/Function1;)Lio/ktor/client/HttpClient;", "close", "()V", "", "toString", "()Ljava/lang/String;", "Lio/ktor/client/engine/HttpClientEngine;", "getEngine", "()Lio/ktor/client/engine/HttpClientEngine;", "Lio/ktor/client/HttpClientConfig;", "Z", "Lkotlinx/coroutines/CompletableJob;", "clientJob", "Lkotlinx/coroutines/CompletableJob;", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Lio/ktor/client/request/HttpRequestPipeline;", "requestPipeline", "Lio/ktor/client/request/HttpRequestPipeline;", "getRequestPipeline", "()Lio/ktor/client/request/HttpRequestPipeline;", "Lio/ktor/client/statement/HttpResponsePipeline;", "responsePipeline", "Lio/ktor/client/statement/HttpResponsePipeline;", "getResponsePipeline", "()Lio/ktor/client/statement/HttpResponsePipeline;", "Lio/ktor/client/request/HttpSendPipeline;", "sendPipeline", "Lio/ktor/client/request/HttpSendPipeline;", "getSendPipeline", "()Lio/ktor/client/request/HttpSendPipeline;", "Lio/ktor/client/statement/HttpReceivePipeline;", "receivePipeline", "Lio/ktor/client/statement/HttpReceivePipeline;", "getReceivePipeline", "()Lio/ktor/client/statement/HttpReceivePipeline;", "Lio/ktor/util/Attributes;", "attributes", "Lio/ktor/util/Attributes;", "getAttributes", "()Lio/ktor/util/Attributes;", "engineConfig", "Lio/ktor/client/engine/HttpClientEngineConfig;", "getEngineConfig", "()Lio/ktor/client/engine/HttpClientEngineConfig;", "Lio/ktor/events/Events;", "monitor", "Lio/ktor/events/Events;", "getMonitor", "()Lio/ktor/events/Events;", "getConfig$ktor_client_core", "()Lio/ktor/client/HttpClientConfig;", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HttpClient implements CoroutineScope, Closeable {
    private static final /* synthetic */ AtomicIntegerFieldUpdater closed$FU = AtomicIntegerFieldUpdater.newUpdater(HttpClient.class, "closed");
    private final Attributes attributes;
    private final CompletableJob clientJob;
    private volatile /* synthetic */ int closed;
    private final HttpClientConfig<HttpClientEngineConfig> config;
    private final CoroutineContext coroutineContext;
    private final HttpClientEngine engine;
    private final HttpClientEngineConfig engineConfig;
    private boolean manageEngine;
    private final Events monitor;
    private final HttpReceivePipeline receivePipeline;
    private final HttpRequestPipeline requestPipeline;
    private final HttpResponsePipeline responsePipeline;
    private final HttpSendPipeline sendPipeline;
    private final HttpClientConfig<? extends HttpClientEngineConfig> userConfig;

    public HttpClient(HttpClientEngine engine, HttpClientConfig<? extends HttpClientEngineConfig> httpClientConfig) {
        Intrinsics.checkNotNullParameter(engine, "engine");
        Intrinsics.checkNotNullParameter(httpClientConfig, "userConfig");
        this.engine = engine;
        this.userConfig = httpClientConfig;
        this.closed = 0;
        this.clientJob = JobKt.Job(this.engine.getCoroutineContext().get(Job.Key));
        this.coroutineContext = this.engine.getCoroutineContext().plus(this.clientJob);
        this.requestPipeline = new HttpRequestPipeline(false, 1, null);
        this.responsePipeline = new HttpResponsePipeline(false, 1, null);
        this.sendPipeline = new HttpSendPipeline(false, 1, null);
        this.receivePipeline = new HttpReceivePipeline(false, 1, null);
        this.attributes = AttributesJvmKt.Attributes(true);
        this.engineConfig = this.engine.getConfig();
        this.monitor = new Events();
        this.config = new HttpClientConfig<>();
        if (this.manageEngine) {
            this.clientJob.invokeOnCompletion(new Function1() { // from class: io.ktor.client.HttpClient$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit _init_$lambda$0;
                    _init_$lambda$0 = HttpClient._init_$lambda$0(HttpClient.this, (Throwable) obj);
                    return _init_$lambda$0;
                }
            });
        }
        this.engine.install(this);
        this.sendPipeline.intercept(HttpSendPipeline.Phases.getReceive(), new AnonymousClass2(null));
        HttpClientConfig $this$_init__u24lambda_u242 = this.userConfig;
        HttpClientConfig.install$default(this.config, HttpRequestLifecycleKt.getHttpRequestLifecycle(), null, 2, null);
        HttpClientConfig.install$default(this.config, BodyProgressKt.getBodyProgress(), null, 2, null);
        HttpClientConfig.install$default(this.config, DoubleReceivePluginKt.getSaveBodyPlugin(), null, 2, null);
        if ($this$_init__u24lambda_u242.getUseDefaultTransformers()) {
            this.config.install("DefaultTransformers", new Function1() { // from class: io.ktor.client.HttpClient$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    return HttpClient.lambda$2$lambda$1((HttpClient) obj);
                }
            });
        }
        HttpClientConfig.install$default(this.config, HttpSend.Plugin, null, 2, null);
        HttpClientConfig.install$default(this.config, HttpCallValidatorKt.getHttpCallValidator(), null, 2, null);
        if ($this$_init__u24lambda_u242.getFollowRedirects()) {
            HttpClientConfig.install$default(this.config, HttpRedirectKt.getHttpRedirect(), null, 2, null);
        }
        this.config.plusAssign($this$_init__u24lambda_u242);
        if ($this$_init__u24lambda_u242.getUseDefaultTransformers()) {
            HttpClientConfig.install$default(this.config, HttpPlainTextKt.getHttpPlainText(), null, 2, null);
        }
        DefaultResponseValidationKt.addDefaultResponseValidation(this.config);
        this.config.install(this);
        this.responsePipeline.intercept(HttpResponsePipeline.Phases.getReceive(), new AnonymousClass4(null));
    }

    public /* synthetic */ HttpClient(HttpClientEngine httpClientEngine, HttpClientConfig httpClientConfig, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(httpClientEngine, (i2 & 2) != 0 ? new HttpClientConfig() : httpClientConfig);
    }

    public final HttpClientEngine getEngine() {
        return this.engine;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpClient(HttpClientEngine engine, HttpClientConfig<? extends HttpClientEngineConfig> httpClientConfig, boolean manageEngine) {
        this(engine, httpClientConfig);
        Intrinsics.checkNotNullParameter(engine, "engine");
        Intrinsics.checkNotNullParameter(httpClientConfig, "userConfig");
        this.manageEngine = manageEngine;
    }

    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public final HttpRequestPipeline getRequestPipeline() {
        return this.requestPipeline;
    }

    public final HttpResponsePipeline getResponsePipeline() {
        return this.responsePipeline;
    }

    public final HttpSendPipeline getSendPipeline() {
        return this.sendPipeline;
    }

    public final HttpReceivePipeline getReceivePipeline() {
        return this.receivePipeline;
    }

    public final Attributes getAttributes() {
        return this.attributes;
    }

    public final HttpClientEngineConfig getEngineConfig() {
        return this.engineConfig;
    }

    public final Events getMonitor() {
        return this.monitor;
    }

    public final HttpClientConfig<HttpClientEngineConfig> getConfig$ktor_client_core() {
        return this.config;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(HttpClient this$0, Throwable it) {
        if (it != null) {
            CoroutineScopeKt.cancel$default(this$0.engine, (CancellationException) null, 1, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* compiled from: HttpClient.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "call"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.HttpClient$2", f = "HttpClient.kt", i = {0, 0}, l = {1345, 1347}, m = "invokeSuspend", n = {"$this$intercept", "call"}, s = {"L$0", "L$1"})
    /* renamed from: io.ktor.client.HttpClient$2  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    static final class AnonymousClass2 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
        }

        public final Object invoke(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation<? super Unit> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
            anonymousClass2.L$0 = pipelineContext;
            anonymousClass2.L$1 = obj;
            return anonymousClass2.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x006e A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:17:0x006f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object $result) {
            Object call;
            PipelineContext $this$intercept;
            Object call2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    PipelineContext $this$intercept2 = (PipelineContext) this.L$0;
                    Object call3 = this.L$1;
                    if (call3 instanceof HttpClientCall) {
                        this.L$0 = $this$intercept2;
                        this.L$1 = call3;
                        this.label = 1;
                        Object execute = HttpClient.this.getReceivePipeline().execute(Unit.INSTANCE, ((HttpClientCall) call3).getResponse(), (Continuation) this);
                        if (execute == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        call = $result;
                        $result = execute;
                        $this$intercept = $this$intercept2;
                        call2 = call3;
                        HttpResponse response = (HttpResponse) $result;
                        ((HttpClientCall) call2).setResponse$ktor_client_core(response);
                        this.L$0 = null;
                        this.L$1 = null;
                        this.label = 2;
                        return $this$intercept.proceedWith(call2, (Continuation) this) != coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
                    }
                    throw new IllegalStateException(("Error: HttpClientCall expected, but found " + call3 + '(' + Reflection.getOrCreateKotlinClass(call3.getClass()) + ").").toString());
                case 1:
                    Object call4 = this.L$1;
                    ResultKt.throwOnFailure($result);
                    $this$intercept = (PipelineContext) this.L$0;
                    call2 = call4;
                    call = $result;
                    HttpResponse response2 = (HttpResponse) $result;
                    ((HttpClientCall) call2).setResponse$ktor_client_core(response2);
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 2;
                    if ($this$intercept.proceedWith(call2, (Continuation) this) != coroutine_suspended) {
                    }
                    break;
                case 2:
                    ResultKt.throwOnFailure($result);
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$2$lambda$1(HttpClient $this$install) {
        Intrinsics.checkNotNullParameter($this$install, "$this$install");
        DefaultTransformKt.defaultTransformers($this$install);
        return Unit.INSTANCE;
    }

    /* compiled from: HttpClient.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/client/statement/HttpResponseContainer;", "Lio/ktor/client/call/HttpClientCall;", "it"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.HttpClient$4", f = "HttpClient.kt", i = {0}, l = {1379}, m = "invokeSuspend", n = {"$this$intercept"}, s = {"L$0"})
    /* renamed from: io.ktor.client.HttpClient$4  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    static final class AnonymousClass4 extends SuspendLambda implements Function3<PipelineContext<HttpResponseContainer, HttpClientCall>, HttpResponseContainer, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass4(Continuation<? super AnonymousClass4> continuation) {
            super(3, continuation);
        }

        public final Object invoke(PipelineContext<HttpResponseContainer, HttpClientCall> pipelineContext, HttpResponseContainer httpResponseContainer, Continuation<? super Unit> continuation) {
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(continuation);
            anonymousClass4.L$0 = pipelineContext;
            return anonymousClass4.invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            PipelineContext $this$intercept;
            Throwable cause;
            PipelineContext $this$intercept2;
            Object $result2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$intercept = (PipelineContext) this.L$0;
                    try {
                        this.L$0 = $this$intercept;
                        this.label = 1;
                        Object proceed = $this$intercept.proceed((Continuation) this);
                        if (proceed == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result2 = $result;
                        $result = proceed;
                        try {
                            HttpResponseContainer httpResponseContainer = (HttpResponseContainer) $result;
                            return Unit.INSTANCE;
                        } catch (Throwable th) {
                            PipelineContext pipelineContext = $this$intercept;
                            cause = th;
                            $this$intercept2 = pipelineContext;
                            HttpClient.this.getMonitor().raise(ClientEventsKt.getHttpResponseReceiveFailed(), new HttpResponseReceiveFail(((HttpClientCall) $this$intercept2.getContext()).getResponse(), cause));
                            throw cause;
                        }
                    } catch (Throwable th2) {
                        cause = th2;
                        $this$intercept2 = $this$intercept;
                        HttpClient.this.getMonitor().raise(ClientEventsKt.getHttpResponseReceiveFailed(), new HttpResponseReceiveFail(((HttpClientCall) $this$intercept2.getContext()).getResponse(), cause));
                        throw cause;
                    }
                case 1:
                    $this$intercept2 = (PipelineContext) this.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        $this$intercept = $this$intercept2;
                        $result2 = $result;
                        HttpResponseContainer httpResponseContainer2 = (HttpResponseContainer) $result;
                        return Unit.INSTANCE;
                    } catch (Throwable th3) {
                        cause = th3;
                        HttpClient.this.getMonitor().raise(ClientEventsKt.getHttpResponseReceiveFailed(), new HttpResponseReceiveFail(((HttpClientCall) $this$intercept2.getContext()).getResponse(), cause));
                        throw cause;
                    }
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object execute$ktor_client_core(HttpRequestBuilder builder, Continuation<? super HttpClientCall> continuation) {
        HttpClient$execute$1 httpClient$execute$1;
        Object execute;
        if (continuation instanceof HttpClient$execute$1) {
            httpClient$execute$1 = (HttpClient$execute$1) continuation;
            if ((httpClient$execute$1.label & Integer.MIN_VALUE) != 0) {
                httpClient$execute$1.label -= Integer.MIN_VALUE;
                Object $result = httpClient$execute$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (httpClient$execute$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        this.monitor.raise(ClientEventsKt.getHttpRequestCreated(), builder);
                        HttpRequestPipeline httpRequestPipeline = this.requestPipeline;
                        Object body = builder.getBody();
                        httpClient$execute$1.label = 1;
                        execute = httpRequestPipeline.execute(builder, body, httpClient$execute$1);
                        if (execute == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        execute = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Intrinsics.checkNotNull(execute, "null cannot be cast to non-null type io.ktor.client.call.HttpClientCall");
                return (HttpClientCall) execute;
            }
        }
        httpClient$execute$1 = new HttpClient$execute$1(this, continuation);
        Object $result2 = httpClient$execute$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (httpClient$execute$1.label) {
        }
        Intrinsics.checkNotNull(execute, "null cannot be cast to non-null type io.ktor.client.call.HttpClientCall");
        return (HttpClientCall) execute;
    }

    public final boolean isSupported(HttpClientEngineCapability<?> httpClientEngineCapability) {
        Intrinsics.checkNotNullParameter(httpClientEngineCapability, "capability");
        return this.engine.getSupportedCapabilities().contains(httpClientEngineCapability);
    }

    public final HttpClient config(Function1<? super HttpClientConfig<?>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        HttpClientEngine httpClientEngine = this.engine;
        HttpClientConfig $this$config_u24lambda_u243 = new HttpClientConfig();
        $this$config_u24lambda_u243.plusAssign(this.userConfig);
        function1.invoke($this$config_u24lambda_u243);
        return new HttpClient(httpClientEngine, $this$config_u24lambda_u243, this.manageEngine);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        boolean success = closed$FU.compareAndSet(this, 0, 1);
        if (success) {
            Attributes installedFeatures = (Attributes) this.attributes.get(HttpClientPluginKt.getPLUGIN_INSTALLED_LIST());
            Iterable $this$forEach$iv = installedFeatures.getAllKeys();
            for (Object element$iv : $this$forEach$iv) {
                AttributeKey key = (AttributeKey) element$iv;
                Intrinsics.checkNotNull(key, "null cannot be cast to non-null type io.ktor.util.AttributeKey<kotlin.Any>");
                Object plugin = installedFeatures.get(key);
                if (plugin instanceof Closeable) {
                    ((Closeable) plugin).close();
                }
            }
            this.clientJob.complete();
            if (this.manageEngine) {
                this.engine.close();
            }
        }
    }

    public String toString() {
        return "HttpClient[" + this.engine + ']';
    }
}