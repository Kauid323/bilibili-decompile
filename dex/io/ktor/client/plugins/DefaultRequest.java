package io.ktor.client.plugins;

import faceverify.q;
import io.ktor.client.HttpClient;
import io.ktor.client.plugins.DefaultRequest;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.http.ParametersBuilder;
import io.ktor.http.ParametersKt;
import io.ktor.http.URLBuilder;
import io.ktor.http.URLBuilderKt;
import io.ktor.http.URLParserKt;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import io.ktor.util.AttributesJvmKt;
import io.ktor.util.StringValuesKt;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.KtorDsl;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* compiled from: DefaultRequest.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0002\n\u000bB\"\b\u0002\u0012\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0002\b\u0005¢\u0006\u0004\b\u0007\u0010\bR%\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0002\b\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\t¨\u0006\f"}, d2 = {"Lio/ktor/client/plugins/DefaultRequest;", "", "Lkotlin/Function1;", "Lio/ktor/client/plugins/DefaultRequest$DefaultRequestBuilder;", "", "Lkotlin/ExtensionFunctionType;", "block", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/jvm/functions/Function1;", "Plugin", "DefaultRequestBuilder", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DefaultRequest {
    public static final Plugin Plugin = new Plugin(null);
    private static final AttributeKey<DefaultRequest> key;
    private final Function1<DefaultRequestBuilder, Unit> block;

    public /* synthetic */ DefaultRequest(Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private DefaultRequest(Function1<? super DefaultRequestBuilder, Unit> function1) {
        this.block = function1;
    }

    /* compiled from: DefaultRequest.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\n\u001a\u00020\u00032\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J1\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002¢\u0006\u0004\b\u001b\u0010\u001cR \u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u001d8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006\""}, d2 = {"Lio/ktor/client/plugins/DefaultRequest$Plugin;", "Lio/ktor/client/plugins/HttpClientPlugin;", "Lio/ktor/client/plugins/DefaultRequest$DefaultRequestBuilder;", "Lio/ktor/client/plugins/DefaultRequest;", "<init>", "()V", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "block", "prepare", "(Lkotlin/jvm/functions/Function1;)Lio/ktor/client/plugins/DefaultRequest;", "plugin", "Lio/ktor/client/HttpClient;", "scope", "install", "(Lio/ktor/client/plugins/DefaultRequest;Lio/ktor/client/HttpClient;)V", "Lio/ktor/http/Url;", "baseUrl", "Lio/ktor/http/URLBuilder;", "requestUrl", "mergeUrls", "(Lio/ktor/http/Url;Lio/ktor/http/URLBuilder;)V", "", "", "parent", "child", "concatenatePath", "(Ljava/util/List;Ljava/util/List;)Ljava/util/List;", "Lio/ktor/util/AttributeKey;", q.KEY_RES_9_KEY, "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Plugin implements HttpClientPlugin<DefaultRequestBuilder, DefaultRequest> {
        public /* synthetic */ Plugin(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Plugin() {
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public AttributeKey<DefaultRequest> getKey() {
            return DefaultRequest.key;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.ktor.client.plugins.HttpClientPlugin
        public DefaultRequest prepare(Function1<? super DefaultRequestBuilder, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            return new DefaultRequest(function1, null);
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public void install(DefaultRequest plugin, HttpClient scope) {
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            Intrinsics.checkNotNullParameter(scope, "scope");
            scope.getRequestPipeline().intercept(HttpRequestPipeline.Phases.getBefore(), new DefaultRequest$Plugin$install$1(plugin, null));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void mergeUrls(Url baseUrl, URLBuilder requestUrl) {
            if (requestUrl.getProtocolOrNull() == null) {
                requestUrl.setProtocolOrNull(baseUrl.getProtocolOrNull());
            }
            if (requestUrl.getHost().length() > 0) {
                return;
            }
            URLBuilder resultUrl = URLUtilsKt.URLBuilder(baseUrl);
            resultUrl.setProtocolOrNull(requestUrl.getProtocolOrNull());
            if (requestUrl.getPort() != 0) {
                resultUrl.setPort(requestUrl.getPort());
            }
            resultUrl.setEncodedPathSegments(DefaultRequest.Plugin.concatenatePath(resultUrl.getEncodedPathSegments(), requestUrl.getEncodedPathSegments()));
            if (requestUrl.getEncodedFragment().length() > 0) {
                resultUrl.setEncodedFragment(requestUrl.getEncodedFragment());
            }
            ParametersBuilder defaultParameters = ParametersKt.ParametersBuilder$default(0, 1, null);
            StringValuesKt.appendAll(defaultParameters, resultUrl.getEncodedParameters());
            resultUrl.setEncodedParameters(requestUrl.getEncodedParameters());
            Iterable $this$forEach$iv = defaultParameters.entries();
            for (Object element$iv : $this$forEach$iv) {
                Map.Entry entry = (Map.Entry) element$iv;
                String key = (String) entry.getKey();
                List values = (List) entry.getValue();
                if (!resultUrl.getEncodedParameters().contains(key)) {
                    resultUrl.getEncodedParameters().appendAll(key, values);
                }
            }
            URLUtilsKt.takeFrom(requestUrl, resultUrl);
        }

        private final List<String> concatenatePath(List<String> list, List<String> list2) {
            if (list2.isEmpty()) {
                return list;
            }
            if (list.isEmpty()) {
                return list2;
            }
            if (((CharSequence) CollectionsKt.first(list2)).length() == 0) {
                return list2;
            }
            List $this$concatenatePath_u24lambda_u243 = CollectionsKt.createListBuilder((list.size() + list2.size()) - 1);
            int size = list.size() - 1;
            for (int index = 0; index < size; index++) {
                $this$concatenatePath_u24lambda_u243.add(list.get(index));
            }
            $this$concatenatePath_u24lambda_u243.addAll(list2);
            return CollectionsKt.build($this$concatenatePath_u24lambda_u243);
        }
    }

    static {
        KType kType = null;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(DefaultRequest.class);
        try {
            kType = Reflection.typeOf(DefaultRequest.class);
        } catch (Throwable th) {
        }
        key = new AttributeKey<>("DefaultRequest", new TypeInfo(orCreateKotlinClass, kType));
    }

    /* compiled from: DefaultRequest.kt */
    @KtorDsl
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\t\u001a\u00020\u00062\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¢\u0006\u0004\b\t\u0010\nJX\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\u0019\b\u0002\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¢\u0006\u0004\b\t\u0010\u0011J\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u000b¢\u0006\u0004\b\t\u0010\u0013J&\u0010\u0015\u001a\u00020\u00062\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¢\u0006\u0004\b\u0015\u0010\nR\u001a\u0010\u0017\u001a\u00020\u00168\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\t\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\t\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u001e\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R$\u0010\r\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010\u0013R$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u000e8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006*"}, d2 = {"Lio/ktor/client/plugins/DefaultRequest$DefaultRequestBuilder;", "Lio/ktor/http/HttpMessageBuilder;", "<init>", "()V", "Lkotlin/Function1;", "Lio/ktor/http/URLBuilder;", "", "Lkotlin/ExtensionFunctionType;", "block", "url", "(Lkotlin/jvm/functions/Function1;)V", "", "scheme", "host", "", "port", "path", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "urlString", "(Ljava/lang/String;)V", "Lio/ktor/util/Attributes;", "setAttributes", "Lio/ktor/http/HeadersBuilder;", "headers", "Lio/ktor/http/HeadersBuilder;", "getHeaders", "()Lio/ktor/http/HeadersBuilder;", "Lio/ktor/http/URLBuilder;", "getUrl", "()Lio/ktor/http/URLBuilder;", "attributes", "Lio/ktor/util/Attributes;", "getAttributes", "()Lio/ktor/util/Attributes;", "value", "getHost", "()Ljava/lang/String;", "setHost", "getPort", "()I", "setPort", "(I)V", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class DefaultRequestBuilder implements HttpMessageBuilder {
        private final HeadersBuilder headers = new HeadersBuilder(0, 1, null);
        private final URLBuilder url = new URLBuilder(null, null, 0, null, null, null, null, null, false, 511, null);
        private final Attributes attributes = AttributesJvmKt.Attributes(true);

        @Override // io.ktor.http.HttpMessageBuilder
        public HeadersBuilder getHeaders() {
            return this.headers;
        }

        public final URLBuilder getUrl() {
            return this.url;
        }

        public final Attributes getAttributes() {
            return this.attributes;
        }

        public final void url(Function1<? super URLBuilder, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            function1.invoke(this.url);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void url$default(DefaultRequestBuilder defaultRequestBuilder, String str, String str2, Integer num, String str3, Function1 function1, int i2, Object obj) {
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
                function1 = new Function1() { // from class: io.ktor.client.plugins.DefaultRequest$DefaultRequestBuilder$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj2) {
                        Unit url$lambda$0;
                        url$lambda$0 = DefaultRequest.DefaultRequestBuilder.url$lambda$0((URLBuilder) obj2);
                        return url$lambda$0;
                    }
                };
            }
            defaultRequestBuilder.url(str, str2, num, str3, function1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit url$lambda$0(URLBuilder uRLBuilder) {
            Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
            return Unit.INSTANCE;
        }

        public final void url(String scheme, String host2, Integer port, String path, Function1<? super URLBuilder, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            URLBuilderKt.set(this.url, scheme, host2, port, path, function1);
        }

        public final void url(String urlString) {
            Intrinsics.checkNotNullParameter(urlString, "urlString");
            URLParserKt.takeFrom(this.url, urlString);
        }

        public final String getHost() {
            return this.url.getHost();
        }

        public final void setHost(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.url.setHost(value);
        }

        public final int getPort() {
            return this.url.getPort();
        }

        public final void setPort(int value) {
            this.url.setPort(value);
        }

        public final void setAttributes(Function1<? super Attributes, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            function1.invoke(this.attributes);
        }
    }
}