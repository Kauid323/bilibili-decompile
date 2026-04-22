package io.ktor.client.request;

import com.tencent.open.SocialConstants;
import io.ktor.client.plugins.sse.SSEClientContent;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.http.URLBuilder;
import io.ktor.http.URLBuilderKt;
import io.ktor.http.URLParserKt;
import io.ktor.http.URLUtilsKt;
import io.ktor.util.AttributeKey;
import io.ktor.util.AttributesKt;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.InternalAPI;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* compiled from: HttpRequest.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a*\u0010\u0006\u001a\u00020\u0002*\u00020\u00002\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0019\u0010\u000b\u001a\u00020\b*\u00020\b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\f\u001a*\u0010\u000e\u001a\u00020\u0003*\u00020\b2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0019\u0010\u000b\u001a\u00020\b*\u00020\b2\u0006\u0010\n\u001a\u00020\u0010¢\u0006\u0004\b\u000b\u0010\u0011\u001a-\u0010\u0013\u001a\u00020\b*\u00020\u00122\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004H\u0086\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001a\\\u0010\u000e\u001a\u00020\u0003*\u00020\b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00152\u0019\b\u0002\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004¢\u0006\u0004\b\u000e\u0010\u001b\u001a_\u0010\u0013\u001a\u00020\b*\u00020\u00122\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00152\u0019\b\u0002\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004H\u0086\u0002¢\u0006\u0004\b\u0013\u0010\u001c\u001a\u0019\u0010\u000e\u001a\u00020\u0003*\u00020\b2\u0006\u0010\u001d\u001a\u00020\u0015¢\u0006\u0004\b\u000e\u0010\u001e\u001a\u0013\u0010 \u001a\u00020\u001f*\u00020\u0010H\u0007¢\u0006\u0004\b \u0010!\u001a\u0013\u0010\"\u001a\u00020\u001f*\u00020\u0010H\u0007¢\u0006\u0004\b\"\u0010!\"&\u0010%\u001a\b\u0012\u0004\u0012\u00020$0#8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b%\u0010&\u0012\u0004\b)\u0010*\u001a\u0004\b'\u0010(¨\u0006+"}, d2 = {"Lio/ktor/http/HttpMessageBuilder;", "Lkotlin/Function1;", "Lio/ktor/http/HeadersBuilder;", "", "Lkotlin/ExtensionFunctionType;", "block", "headers", "(Lio/ktor/http/HttpMessageBuilder;Lkotlin/jvm/functions/Function1;)Lio/ktor/http/HeadersBuilder;", "Lio/ktor/client/request/HttpRequestBuilder;", "Lio/ktor/client/request/HttpRequest;", SocialConstants.TYPE_REQUEST, "takeFrom", "(Lio/ktor/client/request/HttpRequestBuilder;Lio/ktor/client/request/HttpRequest;)Lio/ktor/client/request/HttpRequestBuilder;", "Lio/ktor/http/URLBuilder;", "url", "(Lio/ktor/client/request/HttpRequestBuilder;Lkotlin/jvm/functions/Function1;)V", "Lio/ktor/client/request/HttpRequestData;", "(Lio/ktor/client/request/HttpRequestBuilder;Lio/ktor/client/request/HttpRequestData;)Lio/ktor/client/request/HttpRequestBuilder;", "Lio/ktor/client/request/HttpRequestBuilder$Companion;", "invoke", "(Lio/ktor/client/request/HttpRequestBuilder$Companion;Lkotlin/jvm/functions/Function1;)Lio/ktor/client/request/HttpRequestBuilder;", "", "scheme", "host", "", "port", "path", "(Lio/ktor/client/request/HttpRequestBuilder;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "(Lio/ktor/client/request/HttpRequestBuilder$Companion;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Lio/ktor/client/request/HttpRequestBuilder;", "urlString", "(Lio/ktor/client/request/HttpRequestBuilder;Ljava/lang/String;)V", "", "isUpgradeRequest", "(Lio/ktor/client/request/HttpRequestData;)Z", "isSseRequest", "Lio/ktor/util/AttributeKey;", "Lio/ktor/client/request/ResponseAdapter;", "ResponseAdapterAttributeKey", "Lio/ktor/util/AttributeKey;", "getResponseAdapterAttributeKey", "()Lio/ktor/util/AttributeKey;", "getResponseAdapterAttributeKey$annotations", "()V", "ktor-client-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class HttpRequestKt {
    private static final AttributeKey<ResponseAdapter> ResponseAdapterAttributeKey;

    @InternalAPI
    public static /* synthetic */ void getResponseAdapterAttributeKey$annotations() {
    }

    public static final HeadersBuilder headers(HttpMessageBuilder $this$headers, Function1<? super HeadersBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter($this$headers, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        HeadersBuilder headers = $this$headers.getHeaders();
        function1.invoke(headers);
        return headers;
    }

    public static final HttpRequestBuilder takeFrom(HttpRequestBuilder $this$takeFrom, HttpRequest request) {
        Intrinsics.checkNotNullParameter($this$takeFrom, "<this>");
        Intrinsics.checkNotNullParameter(request, SocialConstants.TYPE_REQUEST);
        $this$takeFrom.setMethod(request.getMethod());
        $this$takeFrom.setBody(request.getContent());
        $this$takeFrom.setBodyType((TypeInfo) $this$takeFrom.getAttributes().getOrNull(RequestBodyKt.getBodyTypeAttributeKey()));
        URLUtilsKt.takeFrom($this$takeFrom.getUrl(), request.getUrl());
        $this$takeFrom.getHeaders().appendAll(request.getHeaders());
        AttributesKt.putAll($this$takeFrom.getAttributes(), request.getAttributes());
        return $this$takeFrom;
    }

    public static final void url(HttpRequestBuilder $this$url, Function1<? super URLBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter($this$url, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        function1.invoke($this$url.getUrl());
    }

    public static final HttpRequestBuilder takeFrom(HttpRequestBuilder $this$takeFrom, HttpRequestData request) {
        Intrinsics.checkNotNullParameter($this$takeFrom, "<this>");
        Intrinsics.checkNotNullParameter(request, SocialConstants.TYPE_REQUEST);
        $this$takeFrom.setMethod(request.getMethod());
        $this$takeFrom.setBody(request.getBody());
        $this$takeFrom.setBodyType((TypeInfo) $this$takeFrom.getAttributes().getOrNull(RequestBodyKt.getBodyTypeAttributeKey()));
        URLUtilsKt.takeFrom($this$takeFrom.getUrl(), request.getUrl());
        $this$takeFrom.getHeaders().appendAll(request.getHeaders());
        AttributesKt.putAll($this$takeFrom.getAttributes(), request.getAttributes());
        return $this$takeFrom;
    }

    public static final HttpRequestBuilder invoke(HttpRequestBuilder.Companion $this$invoke, Function1<? super URLBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter($this$invoke, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        HttpRequestBuilder $this$invoke_u24lambda_u240 = new HttpRequestBuilder();
        url($this$invoke_u24lambda_u240, function1);
        return $this$invoke_u24lambda_u240;
    }

    public static /* synthetic */ void url$default(HttpRequestBuilder httpRequestBuilder, String str, String str2, Integer num, String str3, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        if ((i2 & 4) != 0) {
            num = null;
        }
        if ((i2 & 8) != 0) {
            str3 = null;
        }
        if ((i2 & 16) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.HttpRequestKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj2) {
                    Unit url$lambda$1;
                    url$lambda$1 = HttpRequestKt.url$lambda$1((URLBuilder) obj2);
                    return url$lambda$1;
                }
            };
        }
        url(httpRequestBuilder, str, str2, num, str3, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit url$lambda$1(URLBuilder uRLBuilder) {
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        return Unit.INSTANCE;
    }

    public static final void url(HttpRequestBuilder $this$url, String scheme, String host2, Integer port, String path, Function1<? super URLBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter($this$url, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        URLBuilderKt.set($this$url.getUrl(), scheme, host2, port, path, function1);
    }

    public static /* synthetic */ HttpRequestBuilder invoke$default(HttpRequestBuilder.Companion companion, String str, String str2, Integer num, String str3, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        if ((i2 & 4) != 0) {
            num = null;
        }
        if ((i2 & 8) != 0) {
            str3 = null;
        }
        if ((i2 & 16) != 0) {
            function1 = new Function1() { // from class: io.ktor.client.request.HttpRequestKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj2) {
                    Unit invoke$lambda$2;
                    invoke$lambda$2 = HttpRequestKt.invoke$lambda$2((URLBuilder) obj2);
                    return invoke$lambda$2;
                }
            };
        }
        return invoke(companion, str, str2, num, str3, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$2(URLBuilder uRLBuilder) {
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        return Unit.INSTANCE;
    }

    public static final HttpRequestBuilder invoke(HttpRequestBuilder.Companion $this$invoke, String scheme, String host2, Integer port, String path, Function1<? super URLBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter($this$invoke, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        HttpRequestBuilder $this$invoke_u24lambda_u243 = new HttpRequestBuilder();
        url($this$invoke_u24lambda_u243, scheme, host2, port, path, function1);
        return $this$invoke_u24lambda_u243;
    }

    public static final void url(HttpRequestBuilder $this$url, String urlString) {
        Intrinsics.checkNotNullParameter($this$url, "<this>");
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        URLParserKt.takeFrom($this$url.getUrl(), urlString);
    }

    @InternalAPI
    public static final boolean isUpgradeRequest(HttpRequestData $this$isUpgradeRequest) {
        Intrinsics.checkNotNullParameter($this$isUpgradeRequest, "<this>");
        return $this$isUpgradeRequest.getBody() instanceof ClientUpgradeContent;
    }

    @InternalAPI
    public static final boolean isSseRequest(HttpRequestData $this$isSseRequest) {
        Intrinsics.checkNotNullParameter($this$isSseRequest, "<this>");
        return $this$isSseRequest.getBody() instanceof SSEClientContent;
    }

    public static final AttributeKey<ResponseAdapter> getResponseAdapterAttributeKey() {
        return ResponseAdapterAttributeKey;
    }

    static {
        KType kType;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ResponseAdapter.class);
        try {
            kType = Reflection.typeOf(ResponseAdapter.class);
        } catch (Throwable th) {
            kType = null;
        }
        ResponseAdapterAttributeKey = new AttributeKey<>("ResponseAdapterAttributeKey", new TypeInfo(orCreateKotlinClass, kType));
    }
}