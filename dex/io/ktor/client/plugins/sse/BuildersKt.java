package io.ktor.client.plugins.sse;

import com.tencent.open.SocialConstants;
import io.ktor.client.HttpClient;
import io.ktor.client.HttpClientConfig;
import io.ktor.client.plugins.HttpClientPluginKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.URLParserKt;
import io.ktor.util.AttributeKey;
import io.ktor.util.reflect.TypeInfo;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.time.Duration;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* compiled from: builders.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u000e\u001a.\u0010\u0006\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00002\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001aQ\u0010\u0013\u001a\u00020\u0010*\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0083\u0001\u0010\u0013\u001a\u00020\u0010*\u00020\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0019\b\u0002\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b\u001a\u0010\u001b\u001a[\u0010\u0013\u001a\u00020\u0010*\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00142\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0019\b\u0002\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b\u001d\u0010\u001e\u001az\u0010%\u001a\u00020\u0003*\u00020\b2\u0017\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2'\u0010\u000f\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030!\u0012\u0006\u0012\u0004\u0018\u00010\"0 ¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b#\u0010$\u001a¬\u0001\u0010%\u001a\u00020\u0003*\u00020\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0019\b\u0002\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u00042'\u0010\u000f\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030!\u0012\u0006\u0012\u0004\u0018\u00010\"0 ¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b&\u0010'\u001a\u0084\u0001\u0010%\u001a\u00020\u0003*\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00142\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0019\b\u0002\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u00042'\u0010\u000f\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030!\u0012\u0006\u0012\u0004\u0018\u00010\"0 ¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b(\u0010)\u001aQ\u0010+\u001a\u00020\u0010*\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b*\u0010\u0012\u001a\u0083\u0001\u0010+\u001a\u00020\u0010*\u00020\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0019\b\u0002\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b,\u0010\u001b\u001a[\u0010+\u001a\u00020\u0010*\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00142\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0019\b\u0002\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b-\u0010\u001e\u001az\u0010/\u001a\u00020\u0003*\u00020\b2\u0017\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2'\u0010\u000f\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030!\u0012\u0006\u0012\u0004\u0018\u00010\"0 ¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b.\u0010$\u001a¬\u0001\u0010/\u001a\u00020\u0003*\u00020\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00142\u0019\b\u0002\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2'\u0010\u000f\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030!\u0012\u0006\u0012\u0004\u0018\u00010\"0 ¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b0\u00101\u001a\u0084\u0001\u0010/\u001a\u00020\u0003*\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00142\u0019\b\u0002\u0010\u001f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2'\u0010\u000f\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030!\u0012\u0006\u0012\u0004\u0018\u00010\"0 ¢\u0006\u0002\b\u0004H\u0086@¢\u0006\u0004\b2\u00103\u001a5\u00108\u001a\u00020\u0003\"\b\b\u0000\u00104*\u00020\"*\u00020\u000e2\f\u00106\u001a\b\u0012\u0004\u0012\u00028\u0000052\b\u00107\u001a\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0004\b8\u00109\u001a!\u0010>\u001a\u00020<2\b\u0010;\u001a\u0004\u0018\u00010:2\u0006\u0010=\u001a\u00020<H\u0002¢\u0006\u0004\b>\u0010?\" \u0010@\u001a\b\u0012\u0004\u0012\u00020\u000b058\u0000X\u0080\u0004¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\" \u0010D\u001a\b\u0012\u0004\u0012\u00020\t058\u0000X\u0080\u0004¢\u0006\f\n\u0004\bD\u0010A\u001a\u0004\bE\u0010C\" \u0010F\u001a\b\u0012\u0004\u0012\u00020\u000b058\u0000X\u0080\u0004¢\u0006\f\n\u0004\bF\u0010A\u001a\u0004\bG\u0010C\" \u0010H\u001a\b\u0012\u0004\u0012\u00020\u000b058\u0000X\u0080\u0004¢\u0006\f\n\u0004\bH\u0010A\u001a\u0004\bI\u0010C¨\u0006J"}, d2 = {"Lio/ktor/client/HttpClientConfig;", "Lkotlin/Function1;", "Lio/ktor/client/plugins/sse/SSEConfig;", "", "Lkotlin/ExtensionFunctionType;", "config", "SSE", "(Lio/ktor/client/HttpClientConfig;Lkotlin/jvm/functions/Function1;)V", "Lio/ktor/client/HttpClient;", "Lkotlin/time/Duration;", "reconnectionTime", "", "showCommentEvents", "showRetryEvents", "Lio/ktor/client/request/HttpRequestBuilder;", "block", "Lio/ktor/client/plugins/sse/ClientSSESession;", "serverSentEventsSession-i8z2VEo", "(Lio/ktor/client/HttpClient;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "serverSentEventsSession", "", "scheme", "host", "", "port", "path", "serverSentEventsSession-xEWcMm4", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urlString", "serverSentEventsSession-mY9Nd3A", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", SocialConstants.TYPE_REQUEST, "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "serverSentEvents-mY9Nd3A", "(Lio/ktor/client/HttpClient;Lkotlin/jvm/functions/Function1;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "serverSentEvents", "serverSentEvents-1wIb-0I", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "serverSentEvents-3bFjkrY", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sseSession-i8z2VEo", "sseSession", "sseSession-xEWcMm4", "sseSession-mY9Nd3A", "sse-mY9Nd3A", "sse", "sse-tL6_L-A", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sse-Mswn-_c", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/time/Duration;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "T", "Lio/ktor/util/AttributeKey;", "attributeKey", "value", "addAttribute", "(Lio/ktor/client/request/HttpRequestBuilder;Lio/ktor/util/AttributeKey;Ljava/lang/Object;)V", "Lio/ktor/client/statement/HttpResponse;", "response", "", "cause", "mapToSSEException", "(Lio/ktor/client/statement/HttpResponse;Ljava/lang/Throwable;)Ljava/lang/Throwable;", "sseRequestAttr", "Lio/ktor/util/AttributeKey;", "getSseRequestAttr", "()Lio/ktor/util/AttributeKey;", "reconnectionTimeAttr", "getReconnectionTimeAttr", "showCommentEventsAttr", "getShowCommentEventsAttr", "showRetryEventsAttr", "getShowRetryEventsAttr", "ktor-client-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BuildersKt {
    private static final AttributeKey<Duration> reconnectionTimeAttr;
    private static final AttributeKey<Boolean> showCommentEventsAttr;
    private static final AttributeKey<Boolean> showRetryEventsAttr;
    private static final AttributeKey<Boolean> sseRequestAttr;

    static {
        KType kType;
        KType kType2;
        KType kType3;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Boolean.class);
        KType kType4 = null;
        try {
            kType = Reflection.typeOf(Boolean.TYPE);
        } catch (Throwable th) {
            kType = null;
        }
        sseRequestAttr = new AttributeKey<>("SSERequestFlag", new TypeInfo(orCreateKotlinClass, kType));
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Duration.class);
        try {
            kType2 = Reflection.typeOf(Duration.class);
        } catch (Throwable th2) {
            kType2 = null;
        }
        reconnectionTimeAttr = new AttributeKey<>("SSEReconnectionTime", new TypeInfo(orCreateKotlinClass2, kType2));
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Boolean.class);
        try {
            kType3 = Reflection.typeOf(Boolean.TYPE);
        } catch (Throwable th3) {
            kType3 = null;
        }
        showCommentEventsAttr = new AttributeKey<>("SSEShowCommentEvents", new TypeInfo(orCreateKotlinClass3, kType3));
        KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Boolean.class);
        try {
            kType4 = Reflection.typeOf(Boolean.TYPE);
        } catch (Throwable th4) {
        }
        showRetryEventsAttr = new AttributeKey<>("SSEShowRetryEvents", new TypeInfo(orCreateKotlinClass4, kType4));
    }

    public static final AttributeKey<Boolean> getSseRequestAttr() {
        return sseRequestAttr;
    }

    public static final AttributeKey<Duration> getReconnectionTimeAttr() {
        return reconnectionTimeAttr;
    }

    public static final AttributeKey<Boolean> getShowCommentEventsAttr() {
        return showCommentEventsAttr;
    }

    public static final AttributeKey<Boolean> getShowRetryEventsAttr() {
        return showRetryEventsAttr;
    }

    public static final void SSE(HttpClientConfig<?> httpClientConfig, final Function1<? super SSEConfig, Unit> function1) {
        Intrinsics.checkNotNullParameter(httpClientConfig, "<this>");
        Intrinsics.checkNotNullParameter(function1, "config");
        httpClientConfig.install(SSEKt.getSSE(), new Function1() { // from class: io.ktor.client.plugins.sse.BuildersKt$$ExternalSyntheticLambda11
            public final Object invoke(Object obj) {
                Unit SSE$lambda$0;
                SSE$lambda$0 = BuildersKt.SSE$lambda$0(function1, (SSEConfig) obj);
                return SSE$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SSE$lambda$0(Function1 $config, SSEConfig $this$install) {
        Intrinsics.checkNotNullParameter($this$install, "$this$install");
        $config.invoke($this$install);
        return Unit.INSTANCE;
    }

    /* renamed from: serverSentEventsSession-i8z2VEo  reason: not valid java name */
    public static final Object m3480serverSentEventsSessioni8z2VEo(HttpClient $this$serverSentEventsSession_u2di8z2VEo, Duration reconnectionTime, Boolean showCommentEvents, Boolean showRetryEvents, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super ClientSSESession> continuation) {
        HttpClientPluginKt.plugin($this$serverSentEventsSession_u2di8z2VEo, SSEKt.getSSE());
        CompletableDeferred sessionDeferred = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
        HttpRequestBuilder $this$serverSentEventsSession_i8z2VEo_u24lambda_u241 = new HttpRequestBuilder();
        function1.invoke($this$serverSentEventsSession_i8z2VEo_u24lambda_u241);
        addAttribute($this$serverSentEventsSession_i8z2VEo_u24lambda_u241, sseRequestAttr, Boxing.boxBoolean(true));
        addAttribute($this$serverSentEventsSession_i8z2VEo_u24lambda_u241, reconnectionTimeAttr, reconnectionTime);
        addAttribute($this$serverSentEventsSession_i8z2VEo_u24lambda_u241, showCommentEventsAttr, showCommentEvents);
        addAttribute($this$serverSentEventsSession_i8z2VEo_u24lambda_u241, showRetryEventsAttr, showRetryEvents);
        HttpStatement statement = new HttpStatement($this$serverSentEventsSession_i8z2VEo_u24lambda_u241, $this$serverSentEventsSession_u2di8z2VEo);
        kotlinx.coroutines.BuildersKt.launch$default($this$serverSentEventsSession_u2di8z2VEo, (CoroutineContext) null, (CoroutineStart) null, new BuildersKt$serverSentEventsSession$2(statement, sessionDeferred, null), 3, (Object) null);
        return sessionDeferred.await(continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serverSentEventsSession_xEWcMm4$lambda$2(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    /* renamed from: serverSentEventsSession-xEWcMm4  reason: not valid java name */
    public static final Object m3484serverSentEventsSessionxEWcMm4(HttpClient $this$serverSentEventsSession_u2dxEWcMm4, final String scheme, final String host2, final Integer port, final String path, Duration reconnectionTime, Boolean showCommentEvents, Boolean showRetryEvents, final Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super ClientSSESession> continuation) {
        return m3480serverSentEventsSessioni8z2VEo($this$serverSentEventsSession_u2dxEWcMm4, reconnectionTime, showCommentEvents, showRetryEvents, new Function1() { // from class: io.ktor.client.plugins.sse.BuildersKt$$ExternalSyntheticLambda9
            public final Object invoke(Object obj) {
                Unit serverSentEventsSession_xEWcMm4$lambda$3;
                serverSentEventsSession_xEWcMm4$lambda$3 = BuildersKt.serverSentEventsSession_xEWcMm4$lambda$3(scheme, host2, port, path, function1, (HttpRequestBuilder) obj);
                return serverSentEventsSession_xEWcMm4$lambda$3;
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serverSentEventsSession_xEWcMm4$lambda$3(String $scheme, String $host, Integer $port, String $path, Function1 $block, HttpRequestBuilder $this$serverSentEventsSession) {
        Intrinsics.checkNotNullParameter($this$serverSentEventsSession, "$this$serverSentEventsSession");
        HttpRequestKt.url$default($this$serverSentEventsSession, $scheme, $host, $port, $path, null, 16, null);
        $block.invoke($this$serverSentEventsSession);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serverSentEventsSession_mY9Nd3A$lambda$4(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    /* renamed from: serverSentEventsSession-mY9Nd3A  reason: not valid java name */
    public static final Object m3482serverSentEventsSessionmY9Nd3A(HttpClient $this$serverSentEventsSession_u2dmY9Nd3A, final String urlString, Duration reconnectionTime, Boolean showCommentEvents, Boolean showRetryEvents, final Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super ClientSSESession> continuation) {
        return m3480serverSentEventsSessioni8z2VEo($this$serverSentEventsSession_u2dmY9Nd3A, reconnectionTime, showCommentEvents, showRetryEvents, new Function1() { // from class: io.ktor.client.plugins.sse.BuildersKt$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit serverSentEventsSession_mY9Nd3A$lambda$5;
                serverSentEventsSession_mY9Nd3A$lambda$5 = BuildersKt.serverSentEventsSession_mY9Nd3A$lambda$5(urlString, function1, (HttpRequestBuilder) obj);
                return serverSentEventsSession_mY9Nd3A$lambda$5;
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serverSentEventsSession_mY9Nd3A$lambda$5(String $urlString, Function1 $block, HttpRequestBuilder $this$serverSentEventsSession) {
        Intrinsics.checkNotNullParameter($this$serverSentEventsSession, "$this$serverSentEventsSession");
        URLParserKt.takeFrom($this$serverSentEventsSession.getUrl(), $urlString);
        $block.invoke($this$serverSentEventsSession);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006e A[RETURN] */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10, types: [kotlin.Unit, java.lang.Object] */
    /* renamed from: serverSentEvents-mY9Nd3A  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m3478serverSentEventsmY9Nd3A(HttpClient $this$serverSentEvents_u2dmY9Nd3A, Function1<? super HttpRequestBuilder, Unit> function1, Duration reconnectionTime, Boolean showCommentEvents, Boolean showRetryEvents, Function2<? super ClientSSESession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        BuildersKt$serverSentEvents$1 buildersKt$serverSentEvents$1;
        ClientSSESession session;
        Function2 block;
        Object m3480serverSentEventsSessioni8z2VEo;
        ClientSSESession session2;
        try {
            if (continuation instanceof BuildersKt$serverSentEvents$1) {
                buildersKt$serverSentEvents$1 = (BuildersKt$serverSentEvents$1) continuation;
                if ((buildersKt$serverSentEvents$1.label & Integer.MIN_VALUE) != 0) {
                    buildersKt$serverSentEvents$1.label -= Integer.MIN_VALUE;
                    BuildersKt$serverSentEvents$1 buildersKt$serverSentEvents$12 = buildersKt$serverSentEvents$1;
                    Object $result = buildersKt$serverSentEvents$12.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    session = buildersKt$serverSentEvents$12.label;
                    switch (session) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            block = function2;
                            buildersKt$serverSentEvents$12.L$0 = block;
                            buildersKt$serverSentEvents$12.label = 1;
                            m3480serverSentEventsSessioni8z2VEo = m3480serverSentEventsSessioni8z2VEo($this$serverSentEvents_u2dmY9Nd3A, reconnectionTime, showCommentEvents, showRetryEvents, function1, buildersKt$serverSentEvents$12);
                            if (m3480serverSentEventsSessioni8z2VEo == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            session2 = (ClientSSESession) m3480serverSentEventsSessioni8z2VEo;
                            buildersKt$serverSentEvents$12.L$0 = session2;
                            buildersKt$serverSentEvents$12.label = 2;
                            if (block.invoke(session2, buildersKt$serverSentEvents$12) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            CoroutineScopeKt.cancel$default(session2, (CancellationException) null, 1, (Object) null);
                            session = Unit.INSTANCE;
                            return session;
                        case 1:
                            ResultKt.throwOnFailure($result);
                            block = (Function2) buildersKt$serverSentEvents$12.L$0;
                            m3480serverSentEventsSessioni8z2VEo = $result;
                            session2 = (ClientSSESession) m3480serverSentEventsSessioni8z2VEo;
                            buildersKt$serverSentEvents$12.L$0 = session2;
                            buildersKt$serverSentEvents$12.label = 2;
                            if (block.invoke(session2, buildersKt$serverSentEvents$12) == coroutine_suspended) {
                            }
                            CoroutineScopeKt.cancel$default(session2, (CancellationException) null, 1, (Object) null);
                            session = Unit.INSTANCE;
                            return session;
                        case 2:
                            session2 = (ClientSSESession) buildersKt$serverSentEvents$12.L$0;
                            try {
                                ResultKt.throwOnFailure($result);
                                CoroutineScopeKt.cancel$default(session2, (CancellationException) null, 1, (Object) null);
                                session = Unit.INSTANCE;
                                return session;
                            } catch (Throwable cause) {
                                CoroutineScopeKt.cancel$default(session2, (CancellationException) null, 1, (Object) null);
                                throw cause;
                            }
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            switch (session) {
            }
        } catch (CancellationException cause2) {
            throw cause2;
        } catch (Throwable cause3) {
            throw mapToSSEException(session.getCall().getResponse(), cause3);
        }
        buildersKt$serverSentEvents$1 = new BuildersKt$serverSentEvents$1(continuation);
        BuildersKt$serverSentEvents$1 buildersKt$serverSentEvents$122 = buildersKt$serverSentEvents$1;
        Object $result2 = buildersKt$serverSentEvents$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        session = buildersKt$serverSentEvents$122.label;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serverSentEvents_1wIb_0I$lambda$6(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    /* renamed from: serverSentEvents-1wIb-0I  reason: not valid java name */
    public static final Object m3474serverSentEvents1wIb0I(HttpClient $this$serverSentEvents_u2d1wIb_u2d0I, final String scheme, final String host2, final Integer port, final String path, Duration reconnectionTime, Boolean showCommentEvents, Boolean showRetryEvents, final Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super ClientSSESession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object m3478serverSentEventsmY9Nd3A = m3478serverSentEventsmY9Nd3A($this$serverSentEvents_u2d1wIb_u2d0I, new Function1() { // from class: io.ktor.client.plugins.sse.BuildersKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit serverSentEvents_1wIb_0I$lambda$7;
                serverSentEvents_1wIb_0I$lambda$7 = BuildersKt.serverSentEvents_1wIb_0I$lambda$7(scheme, host2, port, path, function1, (HttpRequestBuilder) obj);
                return serverSentEvents_1wIb_0I$lambda$7;
            }
        }, reconnectionTime, showCommentEvents, showRetryEvents, function2, continuation);
        return m3478serverSentEventsmY9Nd3A == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m3478serverSentEventsmY9Nd3A : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serverSentEvents_1wIb_0I$lambda$7(String $scheme, String $host, Integer $port, String $path, Function1 $request, HttpRequestBuilder $this$serverSentEvents) {
        Intrinsics.checkNotNullParameter($this$serverSentEvents, "$this$serverSentEvents");
        HttpRequestKt.url$default($this$serverSentEvents, $scheme, $host, $port, $path, null, 16, null);
        $request.invoke($this$serverSentEvents);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serverSentEvents_3bFjkrY$lambda$8(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    /* renamed from: serverSentEvents-3bFjkrY  reason: not valid java name */
    public static final Object m3476serverSentEvents3bFjkrY(HttpClient $this$serverSentEvents_u2d3bFjkrY, final String urlString, Duration reconnectionTime, Boolean showCommentEvents, Boolean showRetryEvents, final Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super ClientSSESession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object m3478serverSentEventsmY9Nd3A = m3478serverSentEventsmY9Nd3A($this$serverSentEvents_u2d3bFjkrY, new Function1() { // from class: io.ktor.client.plugins.sse.BuildersKt$$ExternalSyntheticLambda10
            public final Object invoke(Object obj) {
                Unit serverSentEvents_3bFjkrY$lambda$9;
                serverSentEvents_3bFjkrY$lambda$9 = BuildersKt.serverSentEvents_3bFjkrY$lambda$9(urlString, function1, (HttpRequestBuilder) obj);
                return serverSentEvents_3bFjkrY$lambda$9;
            }
        }, reconnectionTime, showCommentEvents, showRetryEvents, function2, continuation);
        return m3478serverSentEventsmY9Nd3A == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m3478serverSentEventsmY9Nd3A : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit serverSentEvents_3bFjkrY$lambda$9(String $urlString, Function1 $request, HttpRequestBuilder $this$serverSentEvents) {
        Intrinsics.checkNotNullParameter($this$serverSentEvents, "$this$serverSentEvents");
        URLParserKt.takeFrom($this$serverSentEvents.getUrl(), $urlString);
        $request.invoke($this$serverSentEvents);
        return Unit.INSTANCE;
    }

    /* renamed from: sseSession-i8z2VEo  reason: not valid java name */
    public static final Object m3492sseSessioni8z2VEo(HttpClient $this$sseSession_u2di8z2VEo, Duration reconnectionTime, Boolean showCommentEvents, Boolean showRetryEvents, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super ClientSSESession> continuation) {
        return m3480serverSentEventsSessioni8z2VEo($this$sseSession_u2di8z2VEo, reconnectionTime, showCommentEvents, showRetryEvents, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sseSession_xEWcMm4$lambda$10(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    /* renamed from: sseSession-xEWcMm4  reason: not valid java name */
    public static final Object m3496sseSessionxEWcMm4(HttpClient $this$sseSession_u2dxEWcMm4, String scheme, String host2, Integer port, String path, Duration reconnectionTime, Boolean showCommentEvents, Boolean showRetryEvents, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super ClientSSESession> continuation) {
        return m3484serverSentEventsSessionxEWcMm4($this$sseSession_u2dxEWcMm4, scheme, host2, port, path, reconnectionTime, showCommentEvents, showRetryEvents, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sseSession_mY9Nd3A$lambda$11(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    /* renamed from: sseSession-mY9Nd3A  reason: not valid java name */
    public static final Object m3494sseSessionmY9Nd3A(HttpClient $this$sseSession_u2dmY9Nd3A, String urlString, Duration reconnectionTime, Boolean showCommentEvents, Boolean showRetryEvents, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super ClientSSESession> continuation) {
        return m3482serverSentEventsSessionmY9Nd3A($this$sseSession_u2dmY9Nd3A, urlString, reconnectionTime, showCommentEvents, showRetryEvents, function1, continuation);
    }

    /* renamed from: sse-mY9Nd3A  reason: not valid java name */
    public static final Object m3488ssemY9Nd3A(HttpClient $this$sse_u2dmY9Nd3A, Function1<? super HttpRequestBuilder, Unit> function1, Duration reconnectionTime, Boolean showCommentEvents, Boolean showRetryEvents, Function2<? super ClientSSESession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object m3478serverSentEventsmY9Nd3A = m3478serverSentEventsmY9Nd3A($this$sse_u2dmY9Nd3A, function1, reconnectionTime, showCommentEvents, showRetryEvents, function2, continuation);
        return m3478serverSentEventsmY9Nd3A == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m3478serverSentEventsmY9Nd3A : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sse_tL6_L_A$lambda$12(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    /* renamed from: sse-tL6_L-A  reason: not valid java name */
    public static final Object m3490ssetL6_LA(HttpClient $this$sse_u2dtL6_L_u2dA, String scheme, String host2, Integer port, String path, Function1<? super HttpRequestBuilder, Unit> function1, Duration reconnectionTime, Boolean showCommentEvents, Boolean showRetryEvents, Function2<? super ClientSSESession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object m3474serverSentEvents1wIb0I = m3474serverSentEvents1wIb0I($this$sse_u2dtL6_L_u2dA, scheme, host2, port, path, reconnectionTime, showCommentEvents, showRetryEvents, function1, function2, continuation);
        return m3474serverSentEvents1wIb0I == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m3474serverSentEvents1wIb0I : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sse_Mswn__c$lambda$13(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        return Unit.INSTANCE;
    }

    /* renamed from: sse-Mswn-_c  reason: not valid java name */
    public static final Object m3486sseMswn_c(HttpClient $this$sse_u2dMswn_u2d_c, String urlString, Function1<? super HttpRequestBuilder, Unit> function1, Duration reconnectionTime, Boolean showCommentEvents, Boolean showRetryEvents, Function2<? super ClientSSESession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object m3476serverSentEvents3bFjkrY = m3476serverSentEvents3bFjkrY($this$sse_u2dMswn_u2d_c, urlString, reconnectionTime, showCommentEvents, showRetryEvents, function1, function2, continuation);
        return m3476serverSentEvents3bFjkrY == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m3476serverSentEvents3bFjkrY : Unit.INSTANCE;
    }

    private static final <T> void addAttribute(HttpRequestBuilder $this$addAttribute, AttributeKey<T> attributeKey, T t) {
        if (t != null) {
            $this$addAttribute.getAttributes().put(attributeKey, t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Throwable mapToSSEException(HttpResponse response, Throwable cause) {
        if ((cause instanceof SSEClientException) && ((SSEClientException) cause).getResponse() != null) {
            return cause;
        }
        return new SSEClientException(response, cause, cause.getMessage());
    }
}