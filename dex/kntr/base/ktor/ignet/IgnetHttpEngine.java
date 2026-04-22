package kntr.base.ktor.ignet;

import com.bilibili.ktor.IgnetCapability;
import com.bilibili.lib.ighttp.IgHttpEngine;
import com.bilibili.lib.ighttp.IgHttpRequest;
import com.bilibili.lib.ighttp.IgHttpResponse;
import com.bilibili.lib.ighttp.Protocol;
import com.google.gson.JsonObject;
import io.ktor.client.engine.HttpClientEngineBase;
import io.ktor.client.engine.HttpClientEngineCapability;
import io.ktor.client.engine.HttpClientEngineConfig;
import io.ktor.client.engine.UtilsKt;
import io.ktor.client.plugins.HttpTimeoutCapability;
import io.ktor.client.request.HttpRequestData;
import io.ktor.client.request.HttpResponseData;
import io.ktor.http.Headers;
import io.ktor.http.HttpProtocolVersion;
import io.ktor.http.HttpStatusCode;
import io.ktor.util.date.DateJvmKt;
import io.ktor.util.date.GMTDate;
import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteReadChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.comm.redirect.RedirectImpKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;

/* compiled from: IgnetHttpEngine.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0096@¢\u0006\u0002\u0010\u0017J \u0010\u0018\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0082@¢\u0006\u0002\u0010\u001dJ\u0014\u0010\u001e\u001a\u00020\u001f*\u00020 2\u0006\u0010!\u001a\u00020\u001cH\u0002J(\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086D¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006("}, d2 = {"Lkntr/base/ktor/ignet/IgnetHttpEngine;", "Lio/ktor/client/engine/HttpClientEngineBase;", RedirectImpKt.REDIRECT_KV_CONFIG, "Lio/ktor/client/engine/HttpClientEngineConfig;", "<init>", "(Lio/ktor/client/engine/HttpClientEngineConfig;)V", "getConfig", "()Lio/ktor/client/engine/HttpClientEngineConfig;", "supportedCapabilities", "", "Lio/ktor/client/engine/HttpClientEngineCapability;", "getSupportedCapabilities", "()Ljava/util/Set;", "TAG", "", "getTAG$annotations", "()V", "getTAG", "()Ljava/lang/String;", "execute", "Lio/ktor/client/request/HttpResponseData;", "data", "Lio/ktor/client/request/HttpRequestData;", "(Lio/ktor/client/request/HttpRequestData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeIgnetHttpRequest", "igHttpRequest", "Lcom/bilibili/lib/ighttp/IgHttpRequest;", "callContext", "Lkotlin/coroutines/CoroutineContext;", "(Lcom/bilibili/lib/ighttp/IgHttpRequest;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toChannel", "Lio/ktor/utils/io/ByteReadChannel;", "Lcom/bilibili/lib/ighttp/IgHttpResponse;", "context", "buildResponseData", "response", "requestTime", "Lio/ktor/util/date/GMTDate;", "body", "", "ktor-ignet-engine_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class IgnetHttpEngine extends HttpClientEngineBase {
    private final String TAG;
    private final HttpClientEngineConfig config;
    private final Set<HttpClientEngineCapability<?>> supportedCapabilities;

    public static /* synthetic */ void getTAG$annotations() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IgnetHttpEngine(HttpClientEngineConfig config) {
        super("ktor-ignet-http");
        Intrinsics.checkNotNullParameter(config, RedirectImpKt.REDIRECT_KV_CONFIG);
        this.config = config;
        this.supportedCapabilities = SetsKt.setOf(new HttpClientEngineCapability[]{HttpTimeoutCapability.INSTANCE, IgnetCapability.INSTANCE});
        this.TAG = "Ktor-Ignet";
        IgHttpEngine.getInstanceWithConfig(new JsonObject());
    }

    public HttpClientEngineConfig getConfig() {
        return this.config;
    }

    public Set<HttpClientEngineCapability<?>> getSupportedCapabilities() {
        return this.supportedCapabilities;
    }

    public final String getTAG() {
        return this.TAG;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object execute(HttpRequestData data, Continuation<? super HttpResponseData> continuation) {
        IgnetHttpEngine$execute$1 ignetHttpEngine$execute$1;
        Object callContext;
        CoroutineContext callContext2;
        Object convertToIgnetHttpRequest;
        if (continuation instanceof IgnetHttpEngine$execute$1) {
            ignetHttpEngine$execute$1 = (IgnetHttpEngine$execute$1) continuation;
            if ((ignetHttpEngine$execute$1.label & Integer.MIN_VALUE) != 0) {
                ignetHttpEngine$execute$1.label -= Integer.MIN_VALUE;
                Object $result = ignetHttpEngine$execute$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (ignetHttpEngine$execute$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        ignetHttpEngine$execute$1.L$0 = data;
                        ignetHttpEngine$execute$1.label = 1;
                        callContext = UtilsKt.callContext(ignetHttpEngine$execute$1);
                        if (callContext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        callContext2 = (CoroutineContext) callContext;
                        HttpClientEngineConfig config = getConfig();
                        ignetHttpEngine$execute$1.L$0 = SpillingKt.nullOutSpilledVariable(data);
                        ignetHttpEngine$execute$1.L$1 = callContext2;
                        ignetHttpEngine$execute$1.label = 2;
                        convertToIgnetHttpRequest = IgnetHttpEngineKt.convertToIgnetHttpRequest(data, callContext2, config, ignetHttpEngine$execute$1);
                        if (convertToIgnetHttpRequest == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        IgHttpRequest ighttpRequest = (IgHttpRequest) convertToIgnetHttpRequest;
                        ignetHttpEngine$execute$1.L$0 = SpillingKt.nullOutSpilledVariable(data);
                        ignetHttpEngine$execute$1.L$1 = SpillingKt.nullOutSpilledVariable(callContext2);
                        ignetHttpEngine$execute$1.L$2 = SpillingKt.nullOutSpilledVariable(ighttpRequest);
                        ignetHttpEngine$execute$1.label = 3;
                        Object executeIgnetHttpRequest = executeIgnetHttpRequest(ighttpRequest, callContext2, ignetHttpEngine$execute$1);
                        return executeIgnetHttpRequest == coroutine_suspended ? coroutine_suspended : executeIgnetHttpRequest;
                    case 1:
                        data = (HttpRequestData) ignetHttpEngine$execute$1.L$0;
                        ResultKt.throwOnFailure($result);
                        callContext = $result;
                        callContext2 = (CoroutineContext) callContext;
                        HttpClientEngineConfig config2 = getConfig();
                        ignetHttpEngine$execute$1.L$0 = SpillingKt.nullOutSpilledVariable(data);
                        ignetHttpEngine$execute$1.L$1 = callContext2;
                        ignetHttpEngine$execute$1.label = 2;
                        convertToIgnetHttpRequest = IgnetHttpEngineKt.convertToIgnetHttpRequest(data, callContext2, config2, ignetHttpEngine$execute$1);
                        if (convertToIgnetHttpRequest == coroutine_suspended) {
                        }
                        IgHttpRequest ighttpRequest2 = (IgHttpRequest) convertToIgnetHttpRequest;
                        ignetHttpEngine$execute$1.L$0 = SpillingKt.nullOutSpilledVariable(data);
                        ignetHttpEngine$execute$1.L$1 = SpillingKt.nullOutSpilledVariable(callContext2);
                        ignetHttpEngine$execute$1.L$2 = SpillingKt.nullOutSpilledVariable(ighttpRequest2);
                        ignetHttpEngine$execute$1.label = 3;
                        Object executeIgnetHttpRequest2 = executeIgnetHttpRequest(ighttpRequest2, callContext2, ignetHttpEngine$execute$1);
                        if (executeIgnetHttpRequest2 == coroutine_suspended) {
                        }
                        break;
                    case 2:
                        callContext2 = (CoroutineContext) ignetHttpEngine$execute$1.L$1;
                        data = (HttpRequestData) ignetHttpEngine$execute$1.L$0;
                        ResultKt.throwOnFailure($result);
                        convertToIgnetHttpRequest = $result;
                        IgHttpRequest ighttpRequest22 = (IgHttpRequest) convertToIgnetHttpRequest;
                        ignetHttpEngine$execute$1.L$0 = SpillingKt.nullOutSpilledVariable(data);
                        ignetHttpEngine$execute$1.L$1 = SpillingKt.nullOutSpilledVariable(callContext2);
                        ignetHttpEngine$execute$1.L$2 = SpillingKt.nullOutSpilledVariable(ighttpRequest22);
                        ignetHttpEngine$execute$1.label = 3;
                        Object executeIgnetHttpRequest22 = executeIgnetHttpRequest(ighttpRequest22, callContext2, ignetHttpEngine$execute$1);
                        if (executeIgnetHttpRequest22 == coroutine_suspended) {
                        }
                        break;
                    case 3:
                        IgHttpRequest igHttpRequest = (IgHttpRequest) ignetHttpEngine$execute$1.L$2;
                        CoroutineContext coroutineContext = (CoroutineContext) ignetHttpEngine$execute$1.L$1;
                        HttpRequestData httpRequestData = (HttpRequestData) ignetHttpEngine$execute$1.L$0;
                        ResultKt.throwOnFailure($result);
                        return $result;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        ignetHttpEngine$execute$1 = new IgnetHttpEngine$execute$1(this, continuation);
        Object $result2 = ignetHttpEngine$execute$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (ignetHttpEngine$execute$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object executeIgnetHttpRequest(IgHttpRequest igHttpRequest, CoroutineContext callContext, Continuation<? super HttpResponseData> continuation) {
        GMTDate requestTime = DateJvmKt.GMTDate$default((Long) null, 1, (Object) null);
        Intrinsics.checkNotNull(igHttpRequest);
        IgHttpResponse igHttpResponse = igHttpRequest.execute();
        Intrinsics.checkNotNull(igHttpResponse);
        ByteReadChannel responseContent = toChannel(igHttpResponse, callContext);
        Intrinsics.checkNotNull(igHttpResponse);
        return buildResponseData(igHttpResponse, requestTime, responseContent, callContext);
    }

    private final ByteReadChannel toChannel(IgHttpResponse $this$toChannel, CoroutineContext context) {
        ByteReadChannel byteChannel = new ByteChannel(true);
        BuildersKt.launch$default(GlobalScope.INSTANCE, context, (CoroutineStart) null, new IgnetHttpEngine$toChannel$1($this$toChannel, byteChannel, null), 2, (Object) null);
        return byteChannel;
    }

    private final HttpResponseData buildResponseData(IgHttpResponse response, GMTDate requestTime, Object body, CoroutineContext callContext) {
        int httpCode = response.httpCode();
        String httpMessage = response.httpMessage();
        Intrinsics.checkNotNullExpressionValue(httpMessage, "httpMessage(...)");
        HttpStatusCode status = new HttpStatusCode(httpCode, httpMessage);
        Protocol protocol = response.protocol();
        HttpProtocolVersion version = protocol != null ? IgnetHttpEngineKt.fromIgnetHttp(protocol) : null;
        Map $this$flatMap$iv = response.headers();
        Intrinsics.checkNotNullExpressionValue($this$flatMap$iv, "headers(...)");
        Collection destination$iv$iv = new ArrayList();
        for (Map.Entry element$iv$iv : $this$flatMap$iv.entrySet()) {
            String key = (String) element$iv$iv.getKey();
            String value = (String) element$iv$iv.getValue();
            Intrinsics.checkNotNull(key);
            String capitalizedStr = CollectionsKt.joinToString$default(StringsKt.split$default(key, new String[]{"-"}, false, 0, 6, (Object) null), "-", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: kntr.base.ktor.ignet.IgnetHttpEngine$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    CharSequence buildResponseData$lambda$0$0;
                    buildResponseData$lambda$0$0 = IgnetHttpEngine.buildResponseData$lambda$0$0((String) obj);
                    return buildResponseData$lambda$0$0;
                }
            }, 30, (Object) null);
            Iterable list$iv$iv = CollectionsKt.listOf(new Pair[]{TuplesKt.to(key, value), TuplesKt.to(capitalizedStr, value)});
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
        }
        Headers headers = IgnetHttpEngineKt.fromIgnetHttp(MapsKt.toMap((List) destination$iv$iv));
        return new HttpResponseData(status, requestTime, headers, version == null ? HttpProtocolVersion.Companion.getHTTP_1_0() : version, body, callContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence buildResponseData$lambda$0$0(String it) {
        String str;
        String valueOf;
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.length() > 0) {
            StringBuilder sb = new StringBuilder();
            char it2 = it.charAt(0);
            if (Character.isLowerCase(it2)) {
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
                valueOf = CharsKt.titlecase(it2, locale);
            } else {
                valueOf = String.valueOf(it2);
            }
            StringBuilder append = sb.append((Object) valueOf);
            String substring = it.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            str = append.append(substring).toString();
        } else {
            str = it;
        }
        return str;
    }
}