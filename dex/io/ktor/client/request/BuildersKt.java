package io.ktor.client.request;

import com.tencent.open.SocialConstants;
import io.ktor.client.HttpClient;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpMethod;
import io.ktor.http.Url;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: builders.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u001a\u001e\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0086H¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001e\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0086H¢\u0006\u0004\b\u0007\u0010\u0005\u001a-\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\nH\u0086H¢\u0006\u0004\b\u0004\u0010\f\u001a-\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\nH\u0086H¢\u0006\u0004\b\u0007\u0010\f\u001a7\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0019\b\u0002\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\nH\u0086H¢\u0006\u0004\b\u0004\u0010\u000f\u001a7\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0019\b\u0002\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\nH\u0086H¢\u0006\u0004\b\u0007\u0010\u000f\u001a7\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0019\b\u0002\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\nH\u0086H¢\u0006\u0004\b\u0004\u0010\u0012\u001a7\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0019\b\u0002\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\nH\u0086H¢\u0006\u0004\b\u0007\u0010\u0012\u001a\u001c\u0010\u0013\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086H¢\u0006\u0004\b\u0013\u0010\u0005\u001a\u001c\u0010\u0014\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086H¢\u0006\u0004\b\u0014\u0010\u0005\u001a\u001c\u0010\u0015\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086H¢\u0006\u0004\b\u0015\u0010\u0005\u001a\u001c\u0010\u0016\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086H¢\u0006\u0004\b\u0016\u0010\u0005\u001a\u001c\u0010\u0017\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086H¢\u0006\u0004\b\u0017\u0010\u0005\u001a\u001c\u0010\u0018\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086H¢\u0006\u0004\b\u0018\u0010\u0005\u001a\u001c\u0010\u0019\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086H¢\u0006\u0004\b\u0019\u0010\u0005\u001a\u001c\u0010\u001a\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086H¢\u0006\u0004\b\u001a\u0010\u0005\u001a\u001c\u0010\u001b\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086H¢\u0006\u0004\b\u001b\u0010\u0005\u001a\u001c\u0010\u001c\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086H¢\u0006\u0004\b\u001c\u0010\u0005\u001a\u001c\u0010\u001d\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086H¢\u0006\u0004\b\u001d\u0010\u0005\u001a\u001c\u0010\u001e\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086H¢\u0006\u0004\b\u001e\u0010\u0005\u001a\u001c\u0010\u001f\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086H¢\u0006\u0004\b\u001f\u0010\u0005\u001a\u001c\u0010 \u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086H¢\u0006\u0004\b \u0010\u0005\u001a-\u0010\u0013\u001a\u00020\u0003*\u00020\u00002\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\nH\u0086H¢\u0006\u0004\b\u0013\u0010\f\u001a-\u0010\u0014\u001a\u00020\u0003*\u00020\u00002\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\nH\u0086H¢\u0006\u0004\b\u0014\u0010\f\u001a-\u0010\u0015\u001a\u00020\u0003*\u00020\u00002\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\nH\u0086H¢\u0006\u0004\b\u0015\u0010\f\u001a-\u0010\u0016\u001a\u00020\u0003*\u00020\u00002\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\nH\u0086H¢\u0006\u0004\b\u0016\u0010\f\u001a-\u0010\u0017\u001a\u00020\u0003*\u00020\u00002\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\nH\u0086H¢\u0006\u0004\b\u0017\u0010\f\u001a-\u0010\u0018\u001a\u00020\u0003*\u00020\u00002\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\nH\u0086H¢\u0006\u0004\b\u0018\u0010\f\u001a-\u0010\u0019\u001a\u00020\u0003*\u00020\u00002\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\nH\u0086H¢\u0006\u0004\b\u0019\u0010\f\u001a-\u0010\u001a\u001a\u00020\u0006*\u00020\u00002\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\nH\u0086H¢\u0006\u0004\b\u001a\u0010\f\u001a-\u0010\u001b\u001a\u00020\u0006*\u00020\u00002\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\nH\u0086H¢\u0006\u0004\b\u001b\u0010\f\u001a-\u0010\u001c\u001a\u00020\u0006*\u00020\u00002\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\nH\u0086H¢\u0006\u0004\b\u001c\u0010\f\u001a-\u0010\u001d\u001a\u00020\u0006*\u00020\u00002\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\nH\u0086H¢\u0006\u0004\b\u001d\u0010\f\u001a-\u0010\u001e\u001a\u00020\u0006*\u00020\u00002\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\nH\u0086H¢\u0006\u0004\b\u001e\u0010\f\u001a-\u0010\u001f\u001a\u00020\u0006*\u00020\u00002\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\nH\u0086H¢\u0006\u0004\b\u001f\u0010\f\u001a-\u0010 \u001a\u00020\u0006*\u00020\u00002\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\nH\u0086H¢\u0006\u0004\b \u0010\f\u001a&\u0010\u0004\u001a\u00020\u00012\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\n¢\u0006\u0004\b\u0004\u0010!\u001a7\u0010\u0013\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0019\b\u0002\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\nH\u0086H¢\u0006\u0004\b\u0013\u0010\u000f\u001a7\u0010\u0014\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0019\b\u0002\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\nH\u0086H¢\u0006\u0004\b\u0014\u0010\u000f\u001a7\u0010\u0015\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0019\b\u0002\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\nH\u0086H¢\u0006\u0004\b\u0015\u0010\u000f\u001a7\u0010\u0016\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0019\b\u0002\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\nH\u0086H¢\u0006\u0004\b\u0016\u0010\u000f\u001a7\u0010\u0017\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0019\b\u0002\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\nH\u0086H¢\u0006\u0004\b\u0017\u0010\u000f\u001a7\u0010\u0018\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0019\b\u0002\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\nH\u0086H¢\u0006\u0004\b\u0018\u0010\u000f\u001a7\u0010\u0019\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0019\b\u0002\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\nH\u0086H¢\u0006\u0004\b\u0019\u0010\u000f\u001a7\u0010\u001a\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0019\b\u0002\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\nH\u0086H¢\u0006\u0004\b\u001a\u0010\u000f\u001a7\u0010\u001b\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0019\b\u0002\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\nH\u0086H¢\u0006\u0004\b\u001b\u0010\u000f\u001a7\u0010\u001c\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0019\b\u0002\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\nH\u0086H¢\u0006\u0004\b\u001c\u0010\u000f\u001a7\u0010\u001d\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0019\b\u0002\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\nH\u0086H¢\u0006\u0004\b\u001d\u0010\u000f\u001a7\u0010\u001e\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0019\b\u0002\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\nH\u0086H¢\u0006\u0004\b\u001e\u0010\u000f\u001a7\u0010\u001f\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0019\b\u0002\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\nH\u0086H¢\u0006\u0004\b\u001f\u0010\u000f\u001a7\u0010 \u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0019\b\u0002\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\nH\u0086H¢\u0006\u0004\b \u0010\u000f¨\u0006\""}, d2 = {"Lio/ktor/client/HttpClient;", "Lio/ktor/client/request/HttpRequestBuilder;", "builder", "Lio/ktor/client/statement/HttpResponse;", SocialConstants.TYPE_REQUEST, "(Lio/ktor/client/HttpClient;Lio/ktor/client/request/HttpRequestBuilder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/client/statement/HttpStatement;", "prepareRequest", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "block", "(Lio/ktor/client/HttpClient;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "urlString", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/http/Url;", "url", "(Lio/ktor/client/HttpClient;Lio/ktor/http/Url;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "get", "post", "put", "delete", "options", "patch", "head", "prepareGet", "preparePost", "preparePut", "prepareDelete", "prepareOptions", "preparePatch", "prepareHead", "(Lkotlin/jvm/functions/Function1;)Lio/ktor/client/request/HttpRequestBuilder;", "ktor-client-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BuildersKt {
    public static /* synthetic */ Object request$default(HttpClient $this$request_u24default, HttpRequestBuilder builder, Continuation $completion, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            builder = new HttpRequestBuilder();
        }
        HttpStatement httpStatement = new HttpStatement(builder, $this$request_u24default);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute($completion);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object request(HttpClient $this$request, HttpRequestBuilder builder, Continuation<? super HttpResponse> continuation) {
        return new HttpStatement(builder, $this$request).execute(continuation);
    }

    private static final Object request$$forInline(HttpClient $this$request, HttpRequestBuilder builder, Continuation<? super HttpResponse> continuation) {
        HttpStatement httpStatement = new HttpStatement(builder, $this$request);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static /* synthetic */ Object prepareRequest$default(HttpClient $this$prepareRequest_u24default, HttpRequestBuilder builder, Continuation $completion, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            builder = new HttpRequestBuilder();
        }
        return new HttpStatement(builder, $this$prepareRequest_u24default);
    }

    public static final Object prepareRequest(HttpClient $this$prepareRequest, HttpRequestBuilder builder, Continuation<? super HttpStatement> continuation) {
        return new HttpStatement(builder, $this$prepareRequest);
    }

    private static final Object prepareRequest$$forInline(HttpClient $this$prepareRequest, HttpRequestBuilder builder, Continuation<? super HttpStatement> continuation) {
        return new HttpStatement(builder, $this$prepareRequest);
    }

    public static final Object request(HttpClient $this$request, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder builder$iv = new HttpRequestBuilder();
        function1.invoke(builder$iv);
        return new HttpStatement(builder$iv, $this$request).execute(continuation);
    }

    private static final Object request$$forInline(HttpClient $this$request, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        HttpRequestBuilder builder$iv = httpRequestBuilder;
        HttpStatement httpStatement = new HttpStatement(builder$iv, $this$request);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object prepareRequest(HttpClient $this$prepareRequest, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder builder$iv = new HttpRequestBuilder();
        function1.invoke(builder$iv);
        return new HttpStatement(builder$iv, $this$prepareRequest);
    }

    private static final Object prepareRequest$$forInline(HttpClient $this$prepareRequest, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        HttpRequestBuilder builder$iv = httpRequestBuilder;
        return new HttpStatement(builder$iv, $this$prepareRequest);
    }

    public static /* synthetic */ Object request$default(HttpClient $this$request_u24default, String urlString, Function1 block, Continuation $completion, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            Function1 block2 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.BuildersKt$request$4
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    invoke((HttpRequestBuilder) p1);
                    return Unit.INSTANCE;
                }

                public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
                }
            };
            block = block2;
        }
        HttpRequestBuilder $this$request_u24lambda_u240 = new HttpRequestBuilder();
        HttpRequestKt.url($this$request_u24lambda_u240, urlString);
        block.invoke($this$request_u24lambda_u240);
        HttpStatement httpStatement = new HttpStatement($this$request_u24lambda_u240, $this$request_u24default);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute($completion);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object request(HttpClient $this$request, String urlString, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder $this$request_u24lambda_u240 = new HttpRequestBuilder();
        HttpRequestKt.url($this$request_u24lambda_u240, urlString);
        function1.invoke($this$request_u24lambda_u240);
        return new HttpStatement($this$request_u24lambda_u240, $this$request).execute(continuation);
    }

    private static final Object request$$forInline(HttpClient $this$request, String urlString, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestBuilder $this$request_u24lambda_u240 = httpRequestBuilder;
        HttpRequestKt.url($this$request_u24lambda_u240, urlString);
        function1.invoke($this$request_u24lambda_u240);
        Unit unit = Unit.INSTANCE;
        HttpRequestBuilder builder$iv$iv = httpRequestBuilder;
        HttpStatement httpStatement = new HttpStatement(builder$iv$iv, $this$request);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static /* synthetic */ Object prepareRequest$default(HttpClient $this$prepareRequest_u24default, String urlString, Function1 block, Continuation $completion, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            Function1 block2 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.BuildersKt$prepareRequest$4
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    invoke((HttpRequestBuilder) p1);
                    return Unit.INSTANCE;
                }

                public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
                }
            };
            block = block2;
        }
        HttpRequestBuilder $this$prepareRequest_u24lambda_u241 = new HttpRequestBuilder();
        HttpRequestKt.url($this$prepareRequest_u24lambda_u241, urlString);
        block.invoke($this$prepareRequest_u24lambda_u241);
        return new HttpStatement($this$prepareRequest_u24lambda_u241, $this$prepareRequest_u24default);
    }

    public static final Object prepareRequest(HttpClient $this$prepareRequest, String urlString, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder $this$prepareRequest_u24lambda_u241 = new HttpRequestBuilder();
        HttpRequestKt.url($this$prepareRequest_u24lambda_u241, urlString);
        function1.invoke($this$prepareRequest_u24lambda_u241);
        return new HttpStatement($this$prepareRequest_u24lambda_u241, $this$prepareRequest);
    }

    private static final Object prepareRequest$$forInline(HttpClient $this$prepareRequest, String urlString, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestBuilder $this$prepareRequest_u24lambda_u241 = httpRequestBuilder;
        HttpRequestKt.url($this$prepareRequest_u24lambda_u241, urlString);
        function1.invoke($this$prepareRequest_u24lambda_u241);
        Unit unit = Unit.INSTANCE;
        HttpRequestBuilder builder$iv$iv = httpRequestBuilder;
        return new HttpStatement(builder$iv$iv, $this$prepareRequest);
    }

    public static /* synthetic */ Object request$default(HttpClient $this$request_u24default, Url url, Function1 block, Continuation $completion, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            Function1 block2 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.BuildersKt$request$7
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    invoke((HttpRequestBuilder) p1);
                    return Unit.INSTANCE;
                }

                public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
                }
            };
            block = block2;
        }
        HttpRequestBuilder $this$request_u24lambda_u242 = new HttpRequestBuilder();
        BuildersWithUrlKt.url($this$request_u24lambda_u242, url);
        block.invoke($this$request_u24lambda_u242);
        HttpStatement httpStatement = new HttpStatement($this$request_u24lambda_u242, $this$request_u24default);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute($completion);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object request(HttpClient $this$request, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder $this$request_u24lambda_u242 = new HttpRequestBuilder();
        BuildersWithUrlKt.url($this$request_u24lambda_u242, url);
        function1.invoke($this$request_u24lambda_u242);
        return new HttpStatement($this$request_u24lambda_u242, $this$request).execute(continuation);
    }

    private static final Object request$$forInline(HttpClient $this$request, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestBuilder $this$request_u24lambda_u242 = httpRequestBuilder;
        BuildersWithUrlKt.url($this$request_u24lambda_u242, url);
        function1.invoke($this$request_u24lambda_u242);
        Unit unit = Unit.INSTANCE;
        HttpRequestBuilder builder$iv$iv = httpRequestBuilder;
        HttpStatement httpStatement = new HttpStatement(builder$iv$iv, $this$request);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static /* synthetic */ Object prepareRequest$default(HttpClient $this$prepareRequest_u24default, Url url, Function1 block, Continuation $completion, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            Function1 block2 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.BuildersKt$prepareRequest$7
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    invoke((HttpRequestBuilder) p1);
                    return Unit.INSTANCE;
                }

                public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
                }
            };
            block = block2;
        }
        HttpRequestBuilder $this$prepareRequest_u24lambda_u243 = new HttpRequestBuilder();
        BuildersWithUrlKt.url($this$prepareRequest_u24lambda_u243, url);
        block.invoke($this$prepareRequest_u24lambda_u243);
        return new HttpStatement($this$prepareRequest_u24lambda_u243, $this$prepareRequest_u24default);
    }

    public static final Object prepareRequest(HttpClient $this$prepareRequest, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder $this$prepareRequest_u24lambda_u243 = new HttpRequestBuilder();
        BuildersWithUrlKt.url($this$prepareRequest_u24lambda_u243, url);
        function1.invoke($this$prepareRequest_u24lambda_u243);
        return new HttpStatement($this$prepareRequest_u24lambda_u243, $this$prepareRequest);
    }

    private static final Object prepareRequest$$forInline(HttpClient $this$prepareRequest, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestBuilder $this$prepareRequest_u24lambda_u243 = httpRequestBuilder;
        BuildersWithUrlKt.url($this$prepareRequest_u24lambda_u243, url);
        function1.invoke($this$prepareRequest_u24lambda_u243);
        Unit unit = Unit.INSTANCE;
        HttpRequestBuilder builder$iv$iv = httpRequestBuilder;
        return new HttpStatement(builder$iv$iv, $this$prepareRequest);
    }

    public static final Object get(HttpClient $this$get, HttpRequestBuilder builder, Continuation<? super HttpResponse> continuation) {
        builder.setMethod(HttpMethod.Companion.getGet());
        return new HttpStatement(builder, $this$get).execute(continuation);
    }

    private static final Object get$$forInline(HttpClient $this$get, HttpRequestBuilder builder, Continuation<? super HttpResponse> continuation) {
        builder.setMethod(HttpMethod.Companion.getGet());
        HttpStatement httpStatement = new HttpStatement(builder, $this$get);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object post(HttpClient $this$post, HttpRequestBuilder builder, Continuation<? super HttpResponse> continuation) {
        builder.setMethod(HttpMethod.Companion.getPost());
        return new HttpStatement(builder, $this$post).execute(continuation);
    }

    private static final Object post$$forInline(HttpClient $this$post, HttpRequestBuilder builder, Continuation<? super HttpResponse> continuation) {
        builder.setMethod(HttpMethod.Companion.getPost());
        HttpStatement httpStatement = new HttpStatement(builder, $this$post);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object put(HttpClient $this$put, HttpRequestBuilder builder, Continuation<? super HttpResponse> continuation) {
        builder.setMethod(HttpMethod.Companion.getPut());
        return new HttpStatement(builder, $this$put).execute(continuation);
    }

    private static final Object put$$forInline(HttpClient $this$put, HttpRequestBuilder builder, Continuation<? super HttpResponse> continuation) {
        builder.setMethod(HttpMethod.Companion.getPut());
        HttpStatement httpStatement = new HttpStatement(builder, $this$put);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object delete(HttpClient $this$delete, HttpRequestBuilder builder, Continuation<? super HttpResponse> continuation) {
        builder.setMethod(HttpMethod.Companion.getDelete());
        return new HttpStatement(builder, $this$delete).execute(continuation);
    }

    private static final Object delete$$forInline(HttpClient $this$delete, HttpRequestBuilder builder, Continuation<? super HttpResponse> continuation) {
        builder.setMethod(HttpMethod.Companion.getDelete());
        HttpStatement httpStatement = new HttpStatement(builder, $this$delete);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object options(HttpClient $this$options, HttpRequestBuilder builder, Continuation<? super HttpResponse> continuation) {
        builder.setMethod(HttpMethod.Companion.getOptions());
        return new HttpStatement(builder, $this$options).execute(continuation);
    }

    private static final Object options$$forInline(HttpClient $this$options, HttpRequestBuilder builder, Continuation<? super HttpResponse> continuation) {
        builder.setMethod(HttpMethod.Companion.getOptions());
        HttpStatement httpStatement = new HttpStatement(builder, $this$options);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object patch(HttpClient $this$patch, HttpRequestBuilder builder, Continuation<? super HttpResponse> continuation) {
        builder.setMethod(HttpMethod.Companion.getPatch());
        return new HttpStatement(builder, $this$patch).execute(continuation);
    }

    private static final Object patch$$forInline(HttpClient $this$patch, HttpRequestBuilder builder, Continuation<? super HttpResponse> continuation) {
        builder.setMethod(HttpMethod.Companion.getPatch());
        HttpStatement httpStatement = new HttpStatement(builder, $this$patch);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object head(HttpClient $this$head, HttpRequestBuilder builder, Continuation<? super HttpResponse> continuation) {
        builder.setMethod(HttpMethod.Companion.getHead());
        return new HttpStatement(builder, $this$head).execute(continuation);
    }

    private static final Object head$$forInline(HttpClient $this$head, HttpRequestBuilder builder, Continuation<? super HttpResponse> continuation) {
        builder.setMethod(HttpMethod.Companion.getHead());
        HttpStatement httpStatement = new HttpStatement(builder, $this$head);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object prepareGet(HttpClient $this$prepareGet, HttpRequestBuilder builder, Continuation<? super HttpStatement> continuation) {
        builder.setMethod(HttpMethod.Companion.getGet());
        return new HttpStatement(builder, $this$prepareGet);
    }

    private static final Object prepareGet$$forInline(HttpClient $this$prepareGet, HttpRequestBuilder builder, Continuation<? super HttpStatement> continuation) {
        builder.setMethod(HttpMethod.Companion.getGet());
        return new HttpStatement(builder, $this$prepareGet);
    }

    public static final Object preparePost(HttpClient $this$preparePost, HttpRequestBuilder builder, Continuation<? super HttpStatement> continuation) {
        builder.setMethod(HttpMethod.Companion.getPost());
        return new HttpStatement(builder, $this$preparePost);
    }

    private static final Object preparePost$$forInline(HttpClient $this$preparePost, HttpRequestBuilder builder, Continuation<? super HttpStatement> continuation) {
        builder.setMethod(HttpMethod.Companion.getPost());
        return new HttpStatement(builder, $this$preparePost);
    }

    public static final Object preparePut(HttpClient $this$preparePut, HttpRequestBuilder builder, Continuation<? super HttpStatement> continuation) {
        builder.setMethod(HttpMethod.Companion.getPut());
        return new HttpStatement(builder, $this$preparePut);
    }

    private static final Object preparePut$$forInline(HttpClient $this$preparePut, HttpRequestBuilder builder, Continuation<? super HttpStatement> continuation) {
        builder.setMethod(HttpMethod.Companion.getPut());
        return new HttpStatement(builder, $this$preparePut);
    }

    public static final Object prepareDelete(HttpClient $this$prepareDelete, HttpRequestBuilder builder, Continuation<? super HttpStatement> continuation) {
        builder.setMethod(HttpMethod.Companion.getDelete());
        return new HttpStatement(builder, $this$prepareDelete);
    }

    private static final Object prepareDelete$$forInline(HttpClient $this$prepareDelete, HttpRequestBuilder builder, Continuation<? super HttpStatement> continuation) {
        builder.setMethod(HttpMethod.Companion.getDelete());
        return new HttpStatement(builder, $this$prepareDelete);
    }

    public static final Object prepareOptions(HttpClient $this$prepareOptions, HttpRequestBuilder builder, Continuation<? super HttpStatement> continuation) {
        builder.setMethod(HttpMethod.Companion.getOptions());
        return new HttpStatement(builder, $this$prepareOptions);
    }

    private static final Object prepareOptions$$forInline(HttpClient $this$prepareOptions, HttpRequestBuilder builder, Continuation<? super HttpStatement> continuation) {
        builder.setMethod(HttpMethod.Companion.getOptions());
        return new HttpStatement(builder, $this$prepareOptions);
    }

    public static final Object preparePatch(HttpClient $this$preparePatch, HttpRequestBuilder builder, Continuation<? super HttpStatement> continuation) {
        builder.setMethod(HttpMethod.Companion.getPatch());
        return new HttpStatement(builder, $this$preparePatch);
    }

    private static final Object preparePatch$$forInline(HttpClient $this$preparePatch, HttpRequestBuilder builder, Continuation<? super HttpStatement> continuation) {
        builder.setMethod(HttpMethod.Companion.getPatch());
        return new HttpStatement(builder, $this$preparePatch);
    }

    public static final Object prepareHead(HttpClient $this$prepareHead, HttpRequestBuilder builder, Continuation<? super HttpStatement> continuation) {
        builder.setMethod(HttpMethod.Companion.getHead());
        return new HttpStatement(builder, $this$prepareHead);
    }

    private static final Object prepareHead$$forInline(HttpClient $this$prepareHead, HttpRequestBuilder builder, Continuation<? super HttpStatement> continuation) {
        builder.setMethod(HttpMethod.Companion.getHead());
        return new HttpStatement(builder, $this$prepareHead);
    }

    public static final Object get(HttpClient $this$get, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder builder$iv = new HttpRequestBuilder();
        function1.invoke(builder$iv);
        builder$iv.setMethod(HttpMethod.Companion.getGet());
        return new HttpStatement(builder$iv, $this$get).execute(continuation);
    }

    private static final Object get$$forInline(HttpClient $this$get, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        HttpRequestBuilder builder$iv = httpRequestBuilder;
        builder$iv.setMethod(HttpMethod.Companion.getGet());
        HttpStatement httpStatement = new HttpStatement(builder$iv, $this$get);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object post(HttpClient $this$post, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder builder$iv = new HttpRequestBuilder();
        function1.invoke(builder$iv);
        builder$iv.setMethod(HttpMethod.Companion.getPost());
        return new HttpStatement(builder$iv, $this$post).execute(continuation);
    }

    private static final Object post$$forInline(HttpClient $this$post, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        HttpRequestBuilder builder$iv = httpRequestBuilder;
        builder$iv.setMethod(HttpMethod.Companion.getPost());
        HttpStatement httpStatement = new HttpStatement(builder$iv, $this$post);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object put(HttpClient $this$put, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder builder$iv = new HttpRequestBuilder();
        function1.invoke(builder$iv);
        builder$iv.setMethod(HttpMethod.Companion.getPut());
        return new HttpStatement(builder$iv, $this$put).execute(continuation);
    }

    private static final Object put$$forInline(HttpClient $this$put, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        HttpRequestBuilder builder$iv = httpRequestBuilder;
        builder$iv.setMethod(HttpMethod.Companion.getPut());
        HttpStatement httpStatement = new HttpStatement(builder$iv, $this$put);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object delete(HttpClient $this$delete, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder builder$iv = new HttpRequestBuilder();
        function1.invoke(builder$iv);
        builder$iv.setMethod(HttpMethod.Companion.getDelete());
        return new HttpStatement(builder$iv, $this$delete).execute(continuation);
    }

    private static final Object delete$$forInline(HttpClient $this$delete, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        HttpRequestBuilder builder$iv = httpRequestBuilder;
        builder$iv.setMethod(HttpMethod.Companion.getDelete());
        HttpStatement httpStatement = new HttpStatement(builder$iv, $this$delete);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object options(HttpClient $this$options, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder builder$iv = new HttpRequestBuilder();
        function1.invoke(builder$iv);
        builder$iv.setMethod(HttpMethod.Companion.getOptions());
        return new HttpStatement(builder$iv, $this$options).execute(continuation);
    }

    private static final Object options$$forInline(HttpClient $this$options, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        HttpRequestBuilder builder$iv = httpRequestBuilder;
        builder$iv.setMethod(HttpMethod.Companion.getOptions());
        HttpStatement httpStatement = new HttpStatement(builder$iv, $this$options);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object patch(HttpClient $this$patch, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder builder$iv = new HttpRequestBuilder();
        function1.invoke(builder$iv);
        builder$iv.setMethod(HttpMethod.Companion.getPatch());
        return new HttpStatement(builder$iv, $this$patch).execute(continuation);
    }

    private static final Object patch$$forInline(HttpClient $this$patch, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        HttpRequestBuilder builder$iv = httpRequestBuilder;
        builder$iv.setMethod(HttpMethod.Companion.getPatch());
        HttpStatement httpStatement = new HttpStatement(builder$iv, $this$patch);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object head(HttpClient $this$head, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder builder$iv = new HttpRequestBuilder();
        function1.invoke(builder$iv);
        builder$iv.setMethod(HttpMethod.Companion.getHead());
        return new HttpStatement(builder$iv, $this$head).execute(continuation);
    }

    private static final Object head$$forInline(HttpClient $this$head, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        HttpRequestBuilder builder$iv = httpRequestBuilder;
        builder$iv.setMethod(HttpMethod.Companion.getHead());
        HttpStatement httpStatement = new HttpStatement(builder$iv, $this$head);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object prepareGet(HttpClient $this$prepareGet, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder builder$iv = new HttpRequestBuilder();
        function1.invoke(builder$iv);
        builder$iv.setMethod(HttpMethod.Companion.getGet());
        return new HttpStatement(builder$iv, $this$prepareGet);
    }

    private static final Object prepareGet$$forInline(HttpClient $this$prepareGet, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        HttpRequestBuilder builder$iv = httpRequestBuilder;
        builder$iv.setMethod(HttpMethod.Companion.getGet());
        return new HttpStatement(builder$iv, $this$prepareGet);
    }

    public static final Object preparePost(HttpClient $this$preparePost, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder builder$iv = new HttpRequestBuilder();
        function1.invoke(builder$iv);
        builder$iv.setMethod(HttpMethod.Companion.getPost());
        return new HttpStatement(builder$iv, $this$preparePost);
    }

    private static final Object preparePost$$forInline(HttpClient $this$preparePost, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        HttpRequestBuilder builder$iv = httpRequestBuilder;
        builder$iv.setMethod(HttpMethod.Companion.getPost());
        return new HttpStatement(builder$iv, $this$preparePost);
    }

    public static final Object preparePut(HttpClient $this$preparePut, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder builder$iv = new HttpRequestBuilder();
        function1.invoke(builder$iv);
        builder$iv.setMethod(HttpMethod.Companion.getPut());
        return new HttpStatement(builder$iv, $this$preparePut);
    }

    private static final Object preparePut$$forInline(HttpClient $this$preparePut, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        HttpRequestBuilder builder$iv = httpRequestBuilder;
        builder$iv.setMethod(HttpMethod.Companion.getPut());
        return new HttpStatement(builder$iv, $this$preparePut);
    }

    public static final Object prepareDelete(HttpClient $this$prepareDelete, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder builder$iv = new HttpRequestBuilder();
        function1.invoke(builder$iv);
        builder$iv.setMethod(HttpMethod.Companion.getDelete());
        return new HttpStatement(builder$iv, $this$prepareDelete);
    }

    private static final Object prepareDelete$$forInline(HttpClient $this$prepareDelete, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        HttpRequestBuilder builder$iv = httpRequestBuilder;
        builder$iv.setMethod(HttpMethod.Companion.getDelete());
        return new HttpStatement(builder$iv, $this$prepareDelete);
    }

    public static final Object prepareOptions(HttpClient $this$prepareOptions, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder builder$iv = new HttpRequestBuilder();
        function1.invoke(builder$iv);
        builder$iv.setMethod(HttpMethod.Companion.getOptions());
        return new HttpStatement(builder$iv, $this$prepareOptions);
    }

    private static final Object prepareOptions$$forInline(HttpClient $this$prepareOptions, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        HttpRequestBuilder builder$iv = httpRequestBuilder;
        builder$iv.setMethod(HttpMethod.Companion.getOptions());
        return new HttpStatement(builder$iv, $this$prepareOptions);
    }

    public static final Object preparePatch(HttpClient $this$preparePatch, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder builder$iv = new HttpRequestBuilder();
        function1.invoke(builder$iv);
        builder$iv.setMethod(HttpMethod.Companion.getPatch());
        return new HttpStatement(builder$iv, $this$preparePatch);
    }

    private static final Object preparePatch$$forInline(HttpClient $this$preparePatch, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        HttpRequestBuilder builder$iv = httpRequestBuilder;
        builder$iv.setMethod(HttpMethod.Companion.getPatch());
        return new HttpStatement(builder$iv, $this$preparePatch);
    }

    public static final Object prepareHead(HttpClient $this$prepareHead, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder builder$iv = new HttpRequestBuilder();
        function1.invoke(builder$iv);
        builder$iv.setMethod(HttpMethod.Companion.getHead());
        return new HttpStatement(builder$iv, $this$prepareHead);
    }

    private static final Object prepareHead$$forInline(HttpClient $this$prepareHead, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        HttpRequestBuilder builder$iv = httpRequestBuilder;
        builder$iv.setMethod(HttpMethod.Companion.getHead());
        return new HttpStatement(builder$iv, $this$prepareHead);
    }

    public static final HttpRequestBuilder request(Function1<? super HttpRequestBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        return httpRequestBuilder;
    }

    public static /* synthetic */ Object get$default(HttpClient $this$get_u24default, String urlString, Function1 block, Continuation $completion, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            Function1 block2 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.BuildersKt$get$4
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    invoke((HttpRequestBuilder) p1);
                    return Unit.INSTANCE;
                }

                public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
                }
            };
            block = block2;
        }
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        HttpRequestKt.url(builder$iv$iv, urlString);
        block.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getGet());
        HttpStatement httpStatement = new HttpStatement(builder$iv$iv, $this$get_u24default);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute($completion);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object get(HttpClient $this$get, String urlString, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        HttpRequestKt.url(builder$iv$iv, urlString);
        function1.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getGet());
        return new HttpStatement(builder$iv$iv, $this$get).execute(continuation);
    }

    private static final Object get$$forInline(HttpClient $this$get, String urlString, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestBuilder $this$get_u24lambda_u244 = httpRequestBuilder;
        HttpRequestKt.url($this$get_u24lambda_u244, urlString);
        function1.invoke($this$get_u24lambda_u244);
        Unit unit = Unit.INSTANCE;
        HttpRequestBuilder builder$iv$iv = httpRequestBuilder;
        builder$iv$iv.setMethod(HttpMethod.Companion.getGet());
        HttpStatement httpStatement = new HttpStatement(builder$iv$iv, $this$get);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static /* synthetic */ Object post$default(HttpClient $this$post_u24default, String urlString, Function1 block, Continuation $completion, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            Function1 block2 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.BuildersKt$post$4
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    invoke((HttpRequestBuilder) p1);
                    return Unit.INSTANCE;
                }

                public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
                }
            };
            block = block2;
        }
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        HttpRequestKt.url(builder$iv$iv, urlString);
        block.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getPost());
        HttpStatement httpStatement = new HttpStatement(builder$iv$iv, $this$post_u24default);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute($completion);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object post(HttpClient $this$post, String urlString, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        HttpRequestKt.url(builder$iv$iv, urlString);
        function1.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getPost());
        return new HttpStatement(builder$iv$iv, $this$post).execute(continuation);
    }

    private static final Object post$$forInline(HttpClient $this$post, String urlString, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestBuilder $this$post_u24lambda_u245 = httpRequestBuilder;
        HttpRequestKt.url($this$post_u24lambda_u245, urlString);
        function1.invoke($this$post_u24lambda_u245);
        Unit unit = Unit.INSTANCE;
        HttpRequestBuilder builder$iv$iv = httpRequestBuilder;
        builder$iv$iv.setMethod(HttpMethod.Companion.getPost());
        HttpStatement httpStatement = new HttpStatement(builder$iv$iv, $this$post);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static /* synthetic */ Object put$default(HttpClient $this$put_u24default, String urlString, Function1 block, Continuation $completion, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            Function1 block2 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.BuildersKt$put$4
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    invoke((HttpRequestBuilder) p1);
                    return Unit.INSTANCE;
                }

                public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
                }
            };
            block = block2;
        }
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        HttpRequestKt.url(builder$iv$iv, urlString);
        block.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getPut());
        HttpStatement httpStatement = new HttpStatement(builder$iv$iv, $this$put_u24default);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute($completion);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object put(HttpClient $this$put, String urlString, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        HttpRequestKt.url(builder$iv$iv, urlString);
        function1.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getPut());
        return new HttpStatement(builder$iv$iv, $this$put).execute(continuation);
    }

    private static final Object put$$forInline(HttpClient $this$put, String urlString, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestBuilder $this$put_u24lambda_u246 = httpRequestBuilder;
        HttpRequestKt.url($this$put_u24lambda_u246, urlString);
        function1.invoke($this$put_u24lambda_u246);
        Unit unit = Unit.INSTANCE;
        HttpRequestBuilder builder$iv$iv = httpRequestBuilder;
        builder$iv$iv.setMethod(HttpMethod.Companion.getPut());
        HttpStatement httpStatement = new HttpStatement(builder$iv$iv, $this$put);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static /* synthetic */ Object delete$default(HttpClient $this$delete_u24default, String urlString, Function1 block, Continuation $completion, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            Function1 block2 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.BuildersKt$delete$4
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    invoke((HttpRequestBuilder) p1);
                    return Unit.INSTANCE;
                }

                public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
                }
            };
            block = block2;
        }
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        HttpRequestKt.url(builder$iv$iv, urlString);
        block.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getDelete());
        HttpStatement httpStatement = new HttpStatement(builder$iv$iv, $this$delete_u24default);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute($completion);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object delete(HttpClient $this$delete, String urlString, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        HttpRequestKt.url(builder$iv$iv, urlString);
        function1.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getDelete());
        return new HttpStatement(builder$iv$iv, $this$delete).execute(continuation);
    }

    private static final Object delete$$forInline(HttpClient $this$delete, String urlString, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestBuilder $this$delete_u24lambda_u247 = httpRequestBuilder;
        HttpRequestKt.url($this$delete_u24lambda_u247, urlString);
        function1.invoke($this$delete_u24lambda_u247);
        Unit unit = Unit.INSTANCE;
        HttpRequestBuilder builder$iv$iv = httpRequestBuilder;
        builder$iv$iv.setMethod(HttpMethod.Companion.getDelete());
        HttpStatement httpStatement = new HttpStatement(builder$iv$iv, $this$delete);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static /* synthetic */ Object options$default(HttpClient $this$options_u24default, String urlString, Function1 block, Continuation $completion, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            Function1 block2 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.BuildersKt$options$4
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    invoke((HttpRequestBuilder) p1);
                    return Unit.INSTANCE;
                }

                public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
                }
            };
            block = block2;
        }
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        HttpRequestKt.url(builder$iv$iv, urlString);
        block.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getOptions());
        HttpStatement httpStatement = new HttpStatement(builder$iv$iv, $this$options_u24default);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute($completion);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object options(HttpClient $this$options, String urlString, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        HttpRequestKt.url(builder$iv$iv, urlString);
        function1.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getOptions());
        return new HttpStatement(builder$iv$iv, $this$options).execute(continuation);
    }

    private static final Object options$$forInline(HttpClient $this$options, String urlString, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestBuilder $this$options_u24lambda_u248 = httpRequestBuilder;
        HttpRequestKt.url($this$options_u24lambda_u248, urlString);
        function1.invoke($this$options_u24lambda_u248);
        Unit unit = Unit.INSTANCE;
        HttpRequestBuilder builder$iv$iv = httpRequestBuilder;
        builder$iv$iv.setMethod(HttpMethod.Companion.getOptions());
        HttpStatement httpStatement = new HttpStatement(builder$iv$iv, $this$options);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static /* synthetic */ Object patch$default(HttpClient $this$patch_u24default, String urlString, Function1 block, Continuation $completion, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            Function1 block2 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.BuildersKt$patch$4
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    invoke((HttpRequestBuilder) p1);
                    return Unit.INSTANCE;
                }

                public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
                }
            };
            block = block2;
        }
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        HttpRequestKt.url(builder$iv$iv, urlString);
        block.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getPatch());
        HttpStatement httpStatement = new HttpStatement(builder$iv$iv, $this$patch_u24default);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute($completion);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object patch(HttpClient $this$patch, String urlString, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        HttpRequestKt.url(builder$iv$iv, urlString);
        function1.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getPatch());
        return new HttpStatement(builder$iv$iv, $this$patch).execute(continuation);
    }

    private static final Object patch$$forInline(HttpClient $this$patch, String urlString, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestBuilder $this$patch_u24lambda_u249 = httpRequestBuilder;
        HttpRequestKt.url($this$patch_u24lambda_u249, urlString);
        function1.invoke($this$patch_u24lambda_u249);
        Unit unit = Unit.INSTANCE;
        HttpRequestBuilder builder$iv$iv = httpRequestBuilder;
        builder$iv$iv.setMethod(HttpMethod.Companion.getPatch());
        HttpStatement httpStatement = new HttpStatement(builder$iv$iv, $this$patch);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static /* synthetic */ Object head$default(HttpClient $this$head_u24default, String urlString, Function1 block, Continuation $completion, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            Function1 block2 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.BuildersKt$head$4
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    invoke((HttpRequestBuilder) p1);
                    return Unit.INSTANCE;
                }

                public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
                }
            };
            block = block2;
        }
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        HttpRequestKt.url(builder$iv$iv, urlString);
        block.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getHead());
        HttpStatement httpStatement = new HttpStatement(builder$iv$iv, $this$head_u24default);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute($completion);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object head(HttpClient $this$head, String urlString, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        HttpRequestKt.url(builder$iv$iv, urlString);
        function1.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getHead());
        return new HttpStatement(builder$iv$iv, $this$head).execute(continuation);
    }

    private static final Object head$$forInline(HttpClient $this$head, String urlString, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestBuilder $this$head_u24lambda_u2410 = httpRequestBuilder;
        HttpRequestKt.url($this$head_u24lambda_u2410, urlString);
        function1.invoke($this$head_u24lambda_u2410);
        Unit unit = Unit.INSTANCE;
        HttpRequestBuilder builder$iv$iv = httpRequestBuilder;
        builder$iv$iv.setMethod(HttpMethod.Companion.getHead());
        HttpStatement httpStatement = new HttpStatement(builder$iv$iv, $this$head);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static /* synthetic */ Object prepareGet$default(HttpClient $this$prepareGet_u24default, String urlString, Function1 block, Continuation $completion, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            Function1 block2 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.BuildersKt$prepareGet$4
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    invoke((HttpRequestBuilder) p1);
                    return Unit.INSTANCE;
                }

                public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
                }
            };
            block = block2;
        }
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        HttpRequestKt.url(builder$iv$iv, urlString);
        block.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getGet());
        return new HttpStatement(builder$iv$iv, $this$prepareGet_u24default);
    }

    public static final Object prepareGet(HttpClient $this$prepareGet, String urlString, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        HttpRequestKt.url(builder$iv$iv, urlString);
        function1.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getGet());
        return new HttpStatement(builder$iv$iv, $this$prepareGet);
    }

    private static final Object prepareGet$$forInline(HttpClient $this$prepareGet, String urlString, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestBuilder $this$prepareGet_u24lambda_u2411 = httpRequestBuilder;
        HttpRequestKt.url($this$prepareGet_u24lambda_u2411, urlString);
        function1.invoke($this$prepareGet_u24lambda_u2411);
        Unit unit = Unit.INSTANCE;
        HttpRequestBuilder builder$iv$iv = httpRequestBuilder;
        builder$iv$iv.setMethod(HttpMethod.Companion.getGet());
        return new HttpStatement(builder$iv$iv, $this$prepareGet);
    }

    public static /* synthetic */ Object preparePost$default(HttpClient $this$preparePost_u24default, String urlString, Function1 block, Continuation $completion, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            Function1 block2 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.BuildersKt$preparePost$4
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    invoke((HttpRequestBuilder) p1);
                    return Unit.INSTANCE;
                }

                public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
                }
            };
            block = block2;
        }
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        HttpRequestKt.url(builder$iv$iv, urlString);
        block.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getPost());
        return new HttpStatement(builder$iv$iv, $this$preparePost_u24default);
    }

    public static final Object preparePost(HttpClient $this$preparePost, String urlString, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        HttpRequestKt.url(builder$iv$iv, urlString);
        function1.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getPost());
        return new HttpStatement(builder$iv$iv, $this$preparePost);
    }

    private static final Object preparePost$$forInline(HttpClient $this$preparePost, String urlString, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestBuilder $this$preparePost_u24lambda_u2412 = httpRequestBuilder;
        HttpRequestKt.url($this$preparePost_u24lambda_u2412, urlString);
        function1.invoke($this$preparePost_u24lambda_u2412);
        Unit unit = Unit.INSTANCE;
        HttpRequestBuilder builder$iv$iv = httpRequestBuilder;
        builder$iv$iv.setMethod(HttpMethod.Companion.getPost());
        return new HttpStatement(builder$iv$iv, $this$preparePost);
    }

    public static /* synthetic */ Object preparePut$default(HttpClient $this$preparePut_u24default, String urlString, Function1 block, Continuation $completion, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            Function1 block2 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.BuildersKt$preparePut$4
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    invoke((HttpRequestBuilder) p1);
                    return Unit.INSTANCE;
                }

                public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
                }
            };
            block = block2;
        }
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        HttpRequestKt.url(builder$iv$iv, urlString);
        block.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getPut());
        return new HttpStatement(builder$iv$iv, $this$preparePut_u24default);
    }

    public static final Object preparePut(HttpClient $this$preparePut, String urlString, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        HttpRequestKt.url(builder$iv$iv, urlString);
        function1.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getPut());
        return new HttpStatement(builder$iv$iv, $this$preparePut);
    }

    private static final Object preparePut$$forInline(HttpClient $this$preparePut, String urlString, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestBuilder $this$preparePut_u24lambda_u2413 = httpRequestBuilder;
        HttpRequestKt.url($this$preparePut_u24lambda_u2413, urlString);
        function1.invoke($this$preparePut_u24lambda_u2413);
        Unit unit = Unit.INSTANCE;
        HttpRequestBuilder builder$iv$iv = httpRequestBuilder;
        builder$iv$iv.setMethod(HttpMethod.Companion.getPut());
        return new HttpStatement(builder$iv$iv, $this$preparePut);
    }

    public static /* synthetic */ Object prepareDelete$default(HttpClient $this$prepareDelete_u24default, String urlString, Function1 block, Continuation $completion, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            Function1 block2 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.BuildersKt$prepareDelete$4
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    invoke((HttpRequestBuilder) p1);
                    return Unit.INSTANCE;
                }

                public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
                }
            };
            block = block2;
        }
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        HttpRequestKt.url(builder$iv$iv, urlString);
        block.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getDelete());
        return new HttpStatement(builder$iv$iv, $this$prepareDelete_u24default);
    }

    public static final Object prepareDelete(HttpClient $this$prepareDelete, String urlString, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        HttpRequestKt.url(builder$iv$iv, urlString);
        function1.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getDelete());
        return new HttpStatement(builder$iv$iv, $this$prepareDelete);
    }

    private static final Object prepareDelete$$forInline(HttpClient $this$prepareDelete, String urlString, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestBuilder $this$prepareDelete_u24lambda_u2414 = httpRequestBuilder;
        HttpRequestKt.url($this$prepareDelete_u24lambda_u2414, urlString);
        function1.invoke($this$prepareDelete_u24lambda_u2414);
        Unit unit = Unit.INSTANCE;
        HttpRequestBuilder builder$iv$iv = httpRequestBuilder;
        builder$iv$iv.setMethod(HttpMethod.Companion.getDelete());
        return new HttpStatement(builder$iv$iv, $this$prepareDelete);
    }

    public static /* synthetic */ Object prepareOptions$default(HttpClient $this$prepareOptions_u24default, String urlString, Function1 block, Continuation $completion, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            Function1 block2 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.BuildersKt$prepareOptions$4
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    invoke((HttpRequestBuilder) p1);
                    return Unit.INSTANCE;
                }

                public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
                }
            };
            block = block2;
        }
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        HttpRequestKt.url(builder$iv$iv, urlString);
        block.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getOptions());
        return new HttpStatement(builder$iv$iv, $this$prepareOptions_u24default);
    }

    public static final Object prepareOptions(HttpClient $this$prepareOptions, String urlString, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        HttpRequestKt.url(builder$iv$iv, urlString);
        function1.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getOptions());
        return new HttpStatement(builder$iv$iv, $this$prepareOptions);
    }

    private static final Object prepareOptions$$forInline(HttpClient $this$prepareOptions, String urlString, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestBuilder $this$prepareOptions_u24lambda_u2415 = httpRequestBuilder;
        HttpRequestKt.url($this$prepareOptions_u24lambda_u2415, urlString);
        function1.invoke($this$prepareOptions_u24lambda_u2415);
        Unit unit = Unit.INSTANCE;
        HttpRequestBuilder builder$iv$iv = httpRequestBuilder;
        builder$iv$iv.setMethod(HttpMethod.Companion.getOptions());
        return new HttpStatement(builder$iv$iv, $this$prepareOptions);
    }

    public static /* synthetic */ Object preparePatch$default(HttpClient $this$preparePatch_u24default, String urlString, Function1 block, Continuation $completion, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            Function1 block2 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.BuildersKt$preparePatch$4
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    invoke((HttpRequestBuilder) p1);
                    return Unit.INSTANCE;
                }

                public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
                }
            };
            block = block2;
        }
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        HttpRequestKt.url(builder$iv$iv, urlString);
        block.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getPatch());
        return new HttpStatement(builder$iv$iv, $this$preparePatch_u24default);
    }

    public static final Object preparePatch(HttpClient $this$preparePatch, String urlString, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        HttpRequestKt.url(builder$iv$iv, urlString);
        function1.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getPatch());
        return new HttpStatement(builder$iv$iv, $this$preparePatch);
    }

    private static final Object preparePatch$$forInline(HttpClient $this$preparePatch, String urlString, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestBuilder $this$preparePatch_u24lambda_u2416 = httpRequestBuilder;
        HttpRequestKt.url($this$preparePatch_u24lambda_u2416, urlString);
        function1.invoke($this$preparePatch_u24lambda_u2416);
        Unit unit = Unit.INSTANCE;
        HttpRequestBuilder builder$iv$iv = httpRequestBuilder;
        builder$iv$iv.setMethod(HttpMethod.Companion.getPatch());
        return new HttpStatement(builder$iv$iv, $this$preparePatch);
    }

    public static /* synthetic */ Object prepareHead$default(HttpClient $this$prepareHead_u24default, String urlString, Function1 block, Continuation $completion, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            Function1 block2 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.request.BuildersKt$prepareHead$4
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    invoke((HttpRequestBuilder) p1);
                    return Unit.INSTANCE;
                }

                public final void invoke(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
                }
            };
            block = block2;
        }
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        HttpRequestKt.url(builder$iv$iv, urlString);
        block.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getHead());
        return new HttpStatement(builder$iv$iv, $this$prepareHead_u24default);
    }

    public static final Object prepareHead(HttpClient $this$prepareHead, String urlString, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder builder$iv$iv = new HttpRequestBuilder();
        HttpRequestKt.url(builder$iv$iv, urlString);
        function1.invoke(builder$iv$iv);
        builder$iv$iv.setMethod(HttpMethod.Companion.getHead());
        return new HttpStatement(builder$iv$iv, $this$prepareHead);
    }

    private static final Object prepareHead$$forInline(HttpClient $this$prepareHead, String urlString, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestBuilder $this$prepareHead_u24lambda_u2417 = httpRequestBuilder;
        HttpRequestKt.url($this$prepareHead_u24lambda_u2417, urlString);
        function1.invoke($this$prepareHead_u24lambda_u2417);
        Unit unit = Unit.INSTANCE;
        HttpRequestBuilder builder$iv$iv = httpRequestBuilder;
        builder$iv$iv.setMethod(HttpMethod.Companion.getHead());
        return new HttpStatement(builder$iv$iv, $this$prepareHead);
    }
}