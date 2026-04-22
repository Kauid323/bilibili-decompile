package io.ktor.client.request;

import faceverify.q;
import io.ktor.client.engine.HttpClientEngineCapability;
import io.ktor.client.engine.HttpClientEngineCapabilityKt;
import io.ktor.client.utils.EmptyContent;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.http.HttpMethod;
import io.ktor.http.URLBuilder;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.Attributes;
import io.ktor.util.AttributesJvmKt;
import io.ktor.util.AttributesKt;
import io.ktor.util.StringValuesKt;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.InternalAPI;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* compiled from: HttpRequest.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 F2\u00020\u0001:\u0001FB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\t\u001a\u00020\u00062\u001d\u0010\b\u001a\u0019\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ&\u0010\u0010\u001a\u00020\u00062\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00060\u000e¢\u0006\u0002\b\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0000¢\u0006\u0004\b\u0015\u0010\u0014J-\u0010\u001b\u001a\u00020\u0006\"\b\b\u0000\u0010\u0017*\u00020\u00162\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00182\u0006\u0010\u001a\u001a\u00028\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ'\u0010\u001d\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0017*\u00020\u00162\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018¢\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010\t\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\t\u0010\u001f\u001a\u0004\b \u0010!R\"\u0010#\u001a\u00020\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010*\u001a\u00020)8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R*\u0010/\u001a\u00020\u00162\u0006\u0010.\u001a\u00020\u00168\u0006@GX\u0086\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R(\u0010:\u001a\u0004\u0018\u0001052\b\u0010.\u001a\u0004\u0018\u0001058F@GX\u0086\u000e¢\u0006\f\u001a\u0004\b6\u00107\"\u0004\b8\u00109R*\u0010<\u001a\u00020;2\u0006\u0010.\u001a\u00020;8\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u0017\u0010B\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E¨\u0006G"}, d2 = {"Lio/ktor/client/request/HttpRequestBuilder;", "Lio/ktor/http/HttpMessageBuilder;", "<init>", "()V", "Lkotlin/Function2;", "Lio/ktor/http/URLBuilder;", "", "Lkotlin/ExtensionFunctionType;", "block", "url", "(Lkotlin/jvm/functions/Function2;)V", "Lio/ktor/client/request/HttpRequestData;", "build", "()Lio/ktor/client/request/HttpRequestData;", "Lkotlin/Function1;", "Lio/ktor/util/Attributes;", "setAttributes", "(Lkotlin/jvm/functions/Function1;)V", "builder", "takeFromWithExecutionContext", "(Lio/ktor/client/request/HttpRequestBuilder;)Lio/ktor/client/request/HttpRequestBuilder;", "takeFrom", "", "T", "Lio/ktor/client/engine/HttpClientEngineCapability;", q.KEY_RES_9_KEY, "capability", "setCapability", "(Lio/ktor/client/engine/HttpClientEngineCapability;Ljava/lang/Object;)V", "getCapabilityOrNull", "(Lio/ktor/client/engine/HttpClientEngineCapability;)Ljava/lang/Object;", "Lio/ktor/http/URLBuilder;", "getUrl", "()Lio/ktor/http/URLBuilder;", "Lio/ktor/http/HttpMethod;", "method", "Lio/ktor/http/HttpMethod;", "getMethod", "()Lio/ktor/http/HttpMethod;", "setMethod", "(Lio/ktor/http/HttpMethod;)V", "Lio/ktor/http/HeadersBuilder;", "headers", "Lio/ktor/http/HeadersBuilder;", "getHeaders", "()Lio/ktor/http/HeadersBuilder;", "value", "body", "Ljava/lang/Object;", "getBody", "()Ljava/lang/Object;", "setBody", "(Ljava/lang/Object;)V", "Lio/ktor/util/reflect/TypeInfo;", "getBodyType", "()Lio/ktor/util/reflect/TypeInfo;", "setBodyType", "(Lio/ktor/util/reflect/TypeInfo;)V", "bodyType", "Lkotlinx/coroutines/Job;", "executionContext", "Lkotlinx/coroutines/Job;", "getExecutionContext", "()Lkotlinx/coroutines/Job;", "setExecutionContext$ktor_client_core", "(Lkotlinx/coroutines/Job;)V", "attributes", "Lio/ktor/util/Attributes;", "getAttributes", "()Lio/ktor/util/Attributes;", "Companion", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HttpRequestBuilder implements HttpMessageBuilder {
    public static final Companion Companion = new Companion(null);
    private final URLBuilder url = new URLBuilder(null, null, 0, null, null, null, null, null, false, 511, null);
    private HttpMethod method = HttpMethod.Companion.getGet();
    private final HeadersBuilder headers = new HeadersBuilder(0, 1, null);
    private Object body = EmptyContent.INSTANCE;
    private Job executionContext = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
    private final Attributes attributes = AttributesJvmKt.Attributes(true);

    public final URLBuilder getUrl() {
        return this.url;
    }

    public final HttpMethod getMethod() {
        return this.method;
    }

    public final void setMethod(HttpMethod httpMethod) {
        Intrinsics.checkNotNullParameter(httpMethod, "<set-?>");
        this.method = httpMethod;
    }

    @Override // io.ktor.http.HttpMessageBuilder
    public HeadersBuilder getHeaders() {
        return this.headers;
    }

    public final Object getBody() {
        return this.body;
    }

    @InternalAPI
    public final void setBody(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<set-?>");
        this.body = obj;
    }

    public final TypeInfo getBodyType() {
        return (TypeInfo) this.attributes.getOrNull(RequestBodyKt.getBodyTypeAttributeKey());
    }

    @InternalAPI
    public final void setBodyType(TypeInfo value) {
        if (value != null) {
            this.attributes.put(RequestBodyKt.getBodyTypeAttributeKey(), value);
        } else {
            this.attributes.remove(RequestBodyKt.getBodyTypeAttributeKey());
        }
    }

    public final Job getExecutionContext() {
        return this.executionContext;
    }

    public final void setExecutionContext$ktor_client_core(Job job) {
        Intrinsics.checkNotNullParameter(job, "<set-?>");
        this.executionContext = job;
    }

    public final Attributes getAttributes() {
        return this.attributes;
    }

    public final void url(Function2<? super URLBuilder, ? super URLBuilder, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        function2.invoke(this.url, this.url);
    }

    public final HttpRequestData build() {
        Url build = this.url.build();
        HttpMethod httpMethod = this.method;
        Headers m3526build = getHeaders().m3526build();
        Object obj = this.body;
        OutgoingContent outgoingContent = obj instanceof OutgoingContent ? (OutgoingContent) obj : null;
        if (outgoingContent != null) {
            return new HttpRequestData(build, httpMethod, m3526build, outgoingContent, this.executionContext, this.attributes);
        }
        throw new IllegalStateException(("No request transformation found: " + this.body).toString());
    }

    public final void setAttributes(Function1<? super Attributes, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        function1.invoke(this.attributes);
    }

    @InternalAPI
    public final HttpRequestBuilder takeFromWithExecutionContext(HttpRequestBuilder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.executionContext = builder.executionContext;
        return takeFrom(builder);
    }

    public final HttpRequestBuilder takeFrom(HttpRequestBuilder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.method = builder.method;
        this.body = builder.body;
        setBodyType(builder.getBodyType());
        URLUtilsKt.takeFrom(this.url, builder.url);
        this.url.setEncodedPathSegments(this.url.getEncodedPathSegments());
        StringValuesKt.appendAll(getHeaders(), builder.getHeaders());
        AttributesKt.putAll(this.attributes, builder.attributes);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map setCapability$lambda$0() {
        return new LinkedHashMap();
    }

    public final <T> void setCapability(HttpClientEngineCapability<T> httpClientEngineCapability, T t) {
        Intrinsics.checkNotNullParameter(httpClientEngineCapability, q.KEY_RES_9_KEY);
        Intrinsics.checkNotNullParameter(t, "capability");
        Map capabilities = (Map) this.attributes.computeIfAbsent(HttpClientEngineCapabilityKt.getENGINE_CAPABILITIES_KEY(), new Function0() { // from class: io.ktor.client.request.HttpRequestBuilder$$ExternalSyntheticLambda0
            public final Object invoke() {
                Map capability$lambda$0;
                capability$lambda$0 = HttpRequestBuilder.setCapability$lambda$0();
                return capability$lambda$0;
            }
        });
        capabilities.put(httpClientEngineCapability, t);
    }

    public final <T> T getCapabilityOrNull(HttpClientEngineCapability<T> httpClientEngineCapability) {
        Intrinsics.checkNotNullParameter(httpClientEngineCapability, q.KEY_RES_9_KEY);
        Map map = (Map) this.attributes.getOrNull(HttpClientEngineCapabilityKt.getENGINE_CAPABILITIES_KEY());
        if (map != null) {
            return (T) map.get(httpClientEngineCapability);
        }
        return null;
    }

    /* compiled from: HttpRequest.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/ktor/client/request/HttpRequestBuilder$Companion;", "", "<init>", "()V", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}