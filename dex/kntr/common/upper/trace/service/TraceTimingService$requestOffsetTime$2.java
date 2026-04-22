package kntr.common.upper.trace.service;

import com.bilibili.ktor.KApiResponse;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpMethod;
import io.ktor.http.Parameters;
import io.ktor.http.URLBuilder;
import io.ktor.http.URLBuilderKt;
import io.ktor.http.URLProtocol;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import io.ktor.util.reflect.TypeInfo;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kntr.common.upper.trace.TraceUtilsKt;
import kntr.common.upper.trace.config.TraceGlobal;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.datetime.Clock;

/* compiled from: TraceTimingService.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.upper.trace.service.TraceTimingService$requestOffsetTime$2", f = "TraceTimingService.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {104, 105}, m = "invokeSuspend", n = {"url", "$this$post_u24default$iv", "url$iv", "$this$post$iv$iv", "$this$post$iv$iv$iv", "builder$iv$iv$iv", "$this$request$iv$iv$iv$iv", "ct1", "$i$f$post", "$i$f$post", "$i$f$post", "$i$f$request", "url", "httpResponse", "$this$body$iv", "ct1", "$i$f$body"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "J$0", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "J$0", "I$0"}, v = 1)
final class TraceTimingService$requestOffsetTime$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TraceTimingService$requestOffsetTime$2(Continuation<? super TraceTimingService$requestOffsetTime$2> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TraceTimingService$requestOffsetTime$2(continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0171 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x023c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        long ct1;
        HttpClient $this$post_u24default$iv;
        Object execute;
        Object obj;
        Url url;
        KType kType;
        Object bodyNullable;
        long clockOffset;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                URLBuilder $this$invokeSuspend_u24lambda_u240 = new URLBuilder(URLProtocol.Companion.getHTTPS(), "core.bilivideo.com", 0, (String) null, (String) null, (List) null, (Parameters) null, (String) null, false, 508, (DefaultConstructorMarker) null);
                URLBuilderKt.setEncodedPath($this$invokeSuspend_u24lambda_u240, "/live-delay/measure/time");
                Url url2 = $this$invokeSuspend_u24lambda_u240.build();
                ct1 = Clock.System.INSTANCE.now().toEpochMilliseconds();
                $this$post_u24default$iv = TraceTimingService.client;
                HttpRequestBuilder builder$iv$iv$iv = new HttpRequestBuilder();
                URLUtilsKt.takeFrom(builder$iv$iv$iv.getUrl(), url2);
                builder$iv$iv$iv.setMethod(HttpMethod.Companion.getPost());
                this.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                this.L$1 = SpillingKt.nullOutSpilledVariable($this$post_u24default$iv);
                this.L$2 = SpillingKt.nullOutSpilledVariable(url2);
                this.L$3 = SpillingKt.nullOutSpilledVariable($this$post_u24default$iv);
                this.L$4 = SpillingKt.nullOutSpilledVariable($this$post_u24default$iv);
                this.L$5 = SpillingKt.nullOutSpilledVariable(builder$iv$iv$iv);
                this.L$6 = SpillingKt.nullOutSpilledVariable($this$post_u24default$iv);
                this.J$0 = ct1;
                this.I$0 = 0;
                this.I$1 = 0;
                this.I$2 = 0;
                this.I$3 = 0;
                this.label = 1;
                execute = new HttpStatement(builder$iv$iv$iv, $this$post_u24default$iv).execute((Continuation) this);
                obj = coroutine_suspended;
                if (execute == obj) {
                    return obj;
                }
                url = url2;
                HttpResponse httpResponse = (HttpResponse) execute;
                HttpClientCall call = httpResponse.getCall();
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                try {
                    kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(TraceTimingBean.class)));
                } catch (Throwable th) {
                    kType = null;
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable(url);
                this.L$1 = SpillingKt.nullOutSpilledVariable(httpResponse);
                this.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse);
                this.L$3 = null;
                this.L$4 = null;
                this.L$5 = null;
                this.L$6 = null;
                this.J$0 = ct1;
                this.I$0 = 0;
                this.label = 2;
                bodyNullable = call.bodyNullable(new TypeInfo(orCreateKotlinClass, kType), (Continuation) this);
                if (bodyNullable == obj) {
                    return obj;
                }
                if (bodyNullable != null) {
                    KApiResponse.Success success = (KApiResponse) bodyNullable;
                    if (!(success instanceof KApiResponse.Success)) {
                        if (success instanceof KApiResponse.BusinessFailure) {
                            throw new Throwable("KResponse.Failure(" + ((KApiResponse.BusinessFailure) success).getCode() + ", " + ((KApiResponse.BusinessFailure) success).getMessage() + ")");
                        } else if (success instanceof KApiResponse.ServiceUnavailable) {
                            throw new Throwable("KResponse.Unavailable(" + ((KApiResponse.ServiceUnavailable) success).getException().getMessage() + ")");
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                    long ct2 = Clock.System.INSTANCE.now().toEpochMilliseconds();
                    TraceTimingBean result = (TraceTimingBean) success.getData();
                    TraceGlobal.INSTANCE.setEnableTimeOffset(true);
                    TraceGlobal traceGlobal = TraceGlobal.INSTANCE;
                    clockOffset = TraceTimingService.INSTANCE.clockOffset(ct1, ct2, result.getT1(), result.getT2());
                    traceGlobal.setTimeOffset(clockOffset);
                    TraceUtilsKt.traceD(KLog_androidKt.getKLog(), "Timing success: offset=" + TraceGlobal.INSTANCE.getTimeOffset());
                    return Unit.INSTANCE;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.bilibili.ktor.KApiResponse<kntr.common.upper.trace.service.TraceTimingBean>");
            case 1:
                int $i$f$body = this.I$3;
                int i = this.I$2;
                int i2 = this.I$1;
                int i3 = this.I$0;
                long ct12 = this.J$0;
                HttpClient httpClient = (HttpClient) this.L$6;
                HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) this.L$5;
                HttpClient httpClient2 = (HttpClient) this.L$4;
                HttpClient httpClient3 = (HttpClient) this.L$3;
                Url url3 = (Url) this.L$2;
                HttpClient httpClient4 = (HttpClient) this.L$1;
                url = (Url) this.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                execute = $result;
                ct1 = ct12;
                HttpResponse httpResponse2 = (HttpResponse) execute;
                HttpClientCall call2 = httpResponse2.getCall();
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(TraceTimingBean.class)));
                this.L$0 = SpillingKt.nullOutSpilledVariable(url);
                this.L$1 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                this.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                this.L$3 = null;
                this.L$4 = null;
                this.L$5 = null;
                this.L$6 = null;
                this.J$0 = ct1;
                this.I$0 = 0;
                this.label = 2;
                bodyNullable = call2.bodyNullable(new TypeInfo(orCreateKotlinClass2, kType), (Continuation) this);
                if (bodyNullable == obj) {
                }
                if (bodyNullable != null) {
                }
                break;
            case 2:
                int i4 = this.I$0;
                ct1 = this.J$0;
                HttpResponse httpResponse3 = (HttpResponse) this.L$2;
                HttpResponse httpResponse4 = (HttpResponse) this.L$1;
                Url url4 = (Url) this.L$0;
                ResultKt.throwOnFailure($result);
                bodyNullable = $result;
                if (bodyNullable != null) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}