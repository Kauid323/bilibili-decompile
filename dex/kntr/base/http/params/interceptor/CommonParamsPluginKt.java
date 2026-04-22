package kntr.base.http.params.interceptor;

import com.bilibili.ktor.AttributesKt;
import com.bilibili.lib.gripper.api.SuspendProducer;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.api.ClientPlugin;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.CreatePluginUtilsKt;
import io.ktor.client.plugins.api.Send;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestData;
import io.ktor.client.request.HttpResponseData;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.CodecsKt;
import io.ktor.http.ContentType;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpProtocolVersion;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.Parameters;
import io.ktor.http.ParametersBuilder;
import io.ktor.http.ParametersKt;
import io.ktor.http.URLBuilderKt;
import io.ktor.http.URLParserKt;
import io.ktor.http.URLProtocol;
import io.ktor.util.StringValuesKt;
import io.ktor.util.date.DateJvmKt;
import io.ktor.util.date.GMTDate;
import io.ktor.utils.io.ByteChannelCtorKt;
import io.ktor.utils.io.ByteReadChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.config.KConfig;
import kntr.base.log.KLog_androidKt;
import kntr.base.net.Body;
import kntr.base.net.GInterceptor;
import kntr.base.net.GNetPublicParam;
import kntr.base.net.GNetPublicParamList;
import kntr.base.net.GnetKt;
import kntr.base.net.HttpStatus;
import kntr.base.net.MutableRequest;
import kntr.base.net.Param;
import kntr.base.net.Request;
import kntr.base.net.Response;
import kntr.base.net.UrlProtocol;
import kntr.base.net.tags.RequestTime;
import kntr.base.utils.crypto.MD5_androidKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlinx.datetime.Clock;
import kotlinx.io.Source;

/* compiled from: CommonParamsPlugin.kt */
@Metadata(d1 = {"\u0000~\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001aJ\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00050\u00042\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\u0004H\u0007\u001aB\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00050\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\u000f\u001a$\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015\u001a$\u0010\u0010\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u0015\u001a\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0016H\u0002\u001a\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u0016H\u0002\u001a\u0010\u0010\u0014\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u0016H\u0002\u001a\u000e\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020$\u001a\u000e\u0010%\u001a\u00020\u00152\u0006\u0010#\u001a\u00020$\u001a\u0012\u0010&\u001a\u00020'*\u00020(2\u0006\u0010#\u001a\u00020)\u001a\n\u0010*\u001a\u00020$*\u00020)\u001a$\u0010+\u001a\u00020)*\u00020$2\u0018\b\u0002\u0010,\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030.\u0012\u0004\u0012\u00020/0-\u001a\u001a\u00100\u001a\u00020(*\u00020'2\u0006\u00101\u001a\u0002022\u0006\u0010#\u001a\u00020$\"\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u00063"}, d2 = {"providesCommonParamsPlugin", "Lio/ktor/client/plugins/api/ClientPlugin;", "", "suspendNetPublicParam", "", "Lcom/bilibili/lib/gripper/api/SuspendProducer;", "Lkntr/base/net/GNetPublicParam;", "suspendNetPublicParamList", "Lkntr/base/net/GNetPublicParamList;", "suspendInterceptor", "Lkntr/base/net/GInterceptor;", "commonParamsPlugin", "suspendGetPublicParam", "suspendGetPublicParamList", "interceptor", "", "addCommonParams", "Lio/ktor/http/Parameters;", "netPublicParam", "params", "sign", "", "Lio/ktor/http/ParametersBuilder;", "queries", "builder", "sortParams", "encodeParams", "", "bilibiliUrlRegex", "Lkotlin/text/Regex;", "getBilibiliUrlRegex", "()Lkotlin/text/Regex;", "setBilibiliUrlRegex", "(Lkotlin/text/Regex;)V", "isCommonParamsEnabled", "request", "Lio/ktor/client/request/HttpRequestBuilder;", "isSignEnabled", "toResponse", "Lkntr/base/net/Response;", "Lio/ktor/client/call/HttpClientCall;", "Lkntr/base/net/Request;", "toHttpRequestBuilder", "toRequest", "tags", "", "Lkotlin/reflect/KClass;", "", "toHttpClientCall", "client", "Lio/ktor/client/HttpClient;", "http-params-interceptor_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class CommonParamsPluginKt {
    private static Regex bilibiliUrlRegex = new Regex(GnetKt.enableNewInterceptorParamHosts(), RegexOption.IGNORE_CASE);

    public static final ClientPlugin<Unit> providesCommonParamsPlugin(Set<? extends SuspendProducer<GNetPublicParam>> set, Set<? extends SuspendProducer<GNetPublicParamList>> set2, Set<? extends SuspendProducer<GInterceptor>> set3) {
        Intrinsics.checkNotNullParameter(set, "suspendNetPublicParam");
        Intrinsics.checkNotNullParameter(set2, "suspendNetPublicParamList");
        Intrinsics.checkNotNullParameter(set3, "suspendInterceptor");
        Set<? extends SuspendProducer<GInterceptor>> $this$map$iv = set3;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            SuspendProducer it = (SuspendProducer) item$iv$iv;
            destination$iv$iv.add((GInterceptor) it.get());
        }
        final Comparator comparator = new Comparator() { // from class: kntr.base.http.params.interceptor.CommonParamsPluginKt$providesCommonParamsPlugin$$inlined$compareBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                GInterceptor it2 = (GInterceptor) t;
                GInterceptor it3 = (GInterceptor) t2;
                return ComparisonsKt.compareValues(it2.getPhase(), it3.getPhase());
            }
        };
        return commonParamsPlugin(set, set2, CollectionsKt.sortedWith(CollectionsKt.toList(CollectionsKt.filterNotNull((List) destination$iv$iv)), new Comparator() { // from class: kntr.base.http.params.interceptor.CommonParamsPluginKt$providesCommonParamsPlugin$$inlined$thenByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int previousCompare = comparator.compare(t, t2);
                if (previousCompare != 0) {
                    return previousCompare;
                }
                GInterceptor it2 = (GInterceptor) t2;
                GInterceptor it3 = (GInterceptor) t;
                return ComparisonsKt.compareValues(it2.getName(), it3.getName());
            }
        }));
    }

    public static final ClientPlugin<Unit> commonParamsPlugin(final Set<? extends SuspendProducer<GNetPublicParam>> set, final Set<? extends SuspendProducer<GNetPublicParamList>> set2, final List<? extends GInterceptor> list) {
        Intrinsics.checkNotNullParameter(set, "suspendGetPublicParam");
        Intrinsics.checkNotNullParameter(set2, "suspendGetPublicParamList");
        Intrinsics.checkNotNullParameter(list, "interceptor");
        int i = 0;
        for (GInterceptor gInterceptor : list) {
            int index = i;
            i++;
            KLog_androidKt.getKLog().d("net.interceptor", index + " " + gInterceptor.getName());
        }
        final Function0 publicParam = new Function0() { // from class: kntr.base.http.params.interceptor.CommonParamsPluginKt$$ExternalSyntheticLambda2
            public final Object invoke() {
                Set commonParamsPlugin$lambda$0;
                commonParamsPlugin$lambda$0 = CommonParamsPluginKt.commonParamsPlugin$lambda$0(set2, set);
                return commonParamsPlugin$lambda$0;
            }
        };
        return CreatePluginUtilsKt.createClientPlugin("CommonParamsPlugin", new Function1() { // from class: kntr.base.http.params.interceptor.CommonParamsPluginKt$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit commonParamsPlugin$lambda$1;
                commonParamsPlugin$lambda$1 = CommonParamsPluginKt.commonParamsPlugin$lambda$1(publicParam, list, (ClientPluginBuilder) obj);
                return commonParamsPlugin$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set commonParamsPlugin$lambda$0(Set $suspendGetPublicParamList, Set $suspendGetPublicParam) {
        Set $this$map$iv = $suspendGetPublicParamList;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            SuspendProducer it = (SuspendProducer) item$iv$iv;
            destination$iv$iv.add((GNetPublicParamList) it.get());
        }
        Iterable $this$flatMap$iv = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList();
        for (Object element$iv$iv : $this$flatMap$iv) {
            GNetPublicParamList it2 = (GNetPublicParamList) element$iv$iv;
            Iterable list$iv$iv = it2.list();
            CollectionsKt.addAll(destination$iv$iv2, list$iv$iv);
        }
        Collection collection = (List) destination$iv$iv2;
        Set $this$map$iv2 = $suspendGetPublicParam;
        Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        for (Object item$iv$iv2 : $this$map$iv2) {
            SuspendProducer it3 = (SuspendProducer) item$iv$iv2;
            destination$iv$iv3.add((GNetPublicParam) it3.get());
        }
        return CollectionsKt.toSet(CollectionsKt.plus(collection, (List) destination$iv$iv3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit commonParamsPlugin$lambda$1(Function0 $publicParam, List $interceptor, ClientPluginBuilder $this$createClientPlugin) {
        Intrinsics.checkNotNullParameter($this$createClientPlugin, "$this$createClientPlugin");
        $this$createClientPlugin.transformRequestBody(new CommonParamsPluginKt$commonParamsPlugin$1$1($publicParam, null));
        $this$createClientPlugin.onRequest(new CommonParamsPluginKt$commonParamsPlugin$1$2($publicParam, null));
        $this$createClientPlugin.on(Send.INSTANCE, new CommonParamsPluginKt$commonParamsPlugin$1$3($interceptor, $this$createClientPlugin, $publicParam, null));
        return Unit.INSTANCE;
    }

    public static final Parameters addCommonParams(Set<? extends GNetPublicParam> set, Parameters params, boolean sign) {
        Intrinsics.checkNotNullParameter(set, "netPublicParam");
        Intrinsics.checkNotNullParameter(params, "params");
        final ParametersBuilder builder = ParametersKt.ParametersBuilder$default(0, 1, (Object) null);
        params.forEach(new Function2() { // from class: kntr.base.http.params.interceptor.CommonParamsPluginKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj, Object obj2) {
                Unit addCommonParams$lambda$0$0;
                addCommonParams$lambda$0$0 = CommonParamsPluginKt.addCommonParams$lambda$0$0(builder, (String) obj, (List) obj2);
                return addCommonParams$lambda$0$0;
            }
        });
        addCommonParams(set, builder, sign);
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addCommonParams$lambda$0$0(ParametersBuilder $this_apply, String k, List v) {
        Intrinsics.checkNotNullParameter(k, "k");
        Intrinsics.checkNotNullParameter(v, "v");
        $this_apply.appendAll(k, v);
        return Unit.INSTANCE;
    }

    public static final ParametersBuilder addCommonParams(Set<? extends GNetPublicParam> set, ParametersBuilder builder, boolean sign) {
        Intrinsics.checkNotNullParameter(set, "queries");
        Intrinsics.checkNotNullParameter(builder, "builder");
        Set<? extends GNetPublicParam> $this$forEach$iv = set;
        for (Object element$iv : $this$forEach$iv) {
            GNetPublicParam it = (GNetPublicParam) element$iv;
            Param q = it.param();
            if (q != null && !builder.contains(q.getKey())) {
                builder.appendMissing(q.getKey(), CollectionsKt.listOf(q.getValue()));
            }
        }
        if (sign) {
            if (!builder.contains("ts")) {
                if (KConfig.INSTANCE.ff("dd.sign_ts_use_milliseconds", false)) {
                    builder.append("ts", String.valueOf(Clock.System.INSTANCE.now().toEpochMilliseconds()));
                } else {
                    builder.append("ts", String.valueOf(Clock.System.INSTANCE.now().getEpochSeconds()));
                }
            }
            sortParams(builder);
            String signString = sign(builder);
            builder.append("sign", signString);
        }
        return builder;
    }

    private static final void sortParams(ParametersBuilder builder) {
        Parameters kvs = builder.build();
        builder.clear();
        Iterable $this$sortedBy$iv = kvs.entries();
        Iterable $this$forEach$iv = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: kntr.base.http.params.interceptor.CommonParamsPluginKt$sortParams$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                Map.Entry it = (Map.Entry) t;
                Map.Entry it2 = (Map.Entry) t2;
                return ComparisonsKt.compareValues((String) it.getKey(), (String) it2.getKey());
            }
        });
        for (Object element$iv : $this$forEach$iv) {
            Map.Entry it = (Map.Entry) element$iv;
            builder.appendAll((String) it.getKey(), (Iterable) it.getValue());
        }
    }

    private static final String encodeParams(ParametersBuilder builder) {
        Iterable $this$map$iv = builder.build().entries();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Map.Entry it = (Map.Entry) item$iv$iv;
            String joinValue = CollectionsKt.joinToString$default((Iterable) it.getValue(), ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
            destination$iv$iv.add(TuplesKt.to(CodecsKt.encodeURLParameter$default((String) it.getKey(), false, 1, (Object) null), CodecsKt.encodeURLParameter$default(joinValue, false, 1, (Object) null)));
        }
        return CollectionsKt.joinToString$default((List) destination$iv$iv, "&", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: kntr.base.http.params.interceptor.CommonParamsPluginKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                CharSequence encodeParams$lambda$1;
                encodeParams$lambda$1 = CommonParamsPluginKt.encodeParams$lambda$1((Pair) obj);
                return encodeParams$lambda$1;
            }
        }, 30, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence encodeParams$lambda$1(Pair it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object first = it.getFirst();
        return first + "=" + it.getSecond();
    }

    private static final String sign(ParametersBuilder builder) {
        String raw = encodeParams(builder);
        return MD5_androidKt.encryptMd5(raw + SecretKt.getSecret(builder.get("appkey"), builder.get("mobi_app")));
    }

    public static final Regex getBilibiliUrlRegex() {
        return bilibiliUrlRegex;
    }

    public static final void setBilibiliUrlRegex(Regex regex) {
        Intrinsics.checkNotNullParameter(regex, "<set-?>");
        bilibiliUrlRegex = regex;
    }

    public static final boolean isCommonParamsEnabled(HttpRequestBuilder request) {
        Intrinsics.checkNotNullParameter(request, "request");
        Boolean bool = (Boolean) request.getAttributes().getOrNull(AttributesKt.getEnableCommonParams());
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public static final boolean isSignEnabled(HttpRequestBuilder request) {
        Intrinsics.checkNotNullParameter(request, "request");
        Boolean bool = (Boolean) request.getAttributes().getOrNull(AttributesKt.getEnableSign());
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public static final Response toResponse(final HttpClientCall $this$toResponse, final Request request) {
        Intrinsics.checkNotNullParameter($this$toResponse, "<this>");
        Intrinsics.checkNotNullParameter(request, "request");
        final HttpResponse response = $this$toResponse.getResponse();
        return new Response() { // from class: kntr.base.http.params.interceptor.CommonParamsPluginKt$toResponse$1
            @Override // kntr.base.net.Response
            public String getHost() {
                return response.getCall().getRequest().getUrl().getHost();
            }

            @Override // kntr.base.net.Response
            public String getPath() {
                return response.getCall().getRequest().getUrl().getEncodedPath();
            }

            @Override // kntr.base.net.Response
            public Request getRequest() {
                return request;
            }

            @Override // kntr.base.net.Response
            public HttpStatus getHttpStatus() {
                return new HttpStatus(response.getStatus().getValue(), response.getStatus().getDescription());
            }

            @Override // kntr.base.net.Response
            public Body getBody() {
                final Source content = response.getRawContent().getReadBuffer();
                final HttpResponse httpResponse = response;
                return new Body() { // from class: kntr.base.http.params.interceptor.CommonParamsPluginKt$toResponse$1$body$1
                    @Override // kntr.base.net.Body
                    public String getContentType() {
                        String contentType;
                        ContentType contentType2 = HttpMessagePropertiesKt.contentType(httpResponse);
                        return (contentType2 == null || (contentType = contentType2.toString()) == null) ? "" : contentType;
                    }

                    @Override // kntr.base.net.Body
                    public long getContentLength() {
                        Long contentLength = HttpMessagePropertiesKt.contentLength(httpResponse);
                        if (contentLength != null) {
                            return contentLength.longValue();
                        }
                        return 0L;
                    }

                    @Override // kntr.base.net.Body
                    public Source content() {
                        return content;
                    }
                };
            }

            @Override // kntr.base.net.Response
            public String header(String name) {
                Intrinsics.checkNotNullParameter(name, "name");
                return response.getHeaders().get(name);
            }

            @Override // kntr.base.net.Response
            public Map<String, List<String>> headers() {
                return StringValuesKt.toMap(response.getHeaders());
            }

            @Override // kntr.base.net.Response
            public Object source() {
                return $this$toResponse;
            }
        };
    }

    public static final HttpRequestBuilder toHttpRequestBuilder(Request $this$toHttpRequestBuilder) {
        Intrinsics.checkNotNullParameter($this$toHttpRequestBuilder, "<this>");
        Object src = $this$toHttpRequestBuilder.source();
        HttpRequestBuilder httpRequestBuilder = src instanceof HttpRequestBuilder ? (HttpRequestBuilder) src : null;
        if (httpRequestBuilder != null) {
            return httpRequestBuilder;
        }
        throw new IllegalStateException("Request.source() must be of HttpRequestBuilder type but got " + Reflection.getOrCreateKotlinClass(src.getClass()).getSimpleName() + ".");
    }

    public static /* synthetic */ Request toRequest$default(HttpRequestBuilder httpRequestBuilder, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = new HashMap();
        }
        return toRequest(httpRequestBuilder, map);
    }

    public static final Request toRequest(final HttpRequestBuilder $this$toRequest, final Map<KClass<?>, Object> map) {
        Intrinsics.checkNotNullParameter($this$toRequest, "<this>");
        Intrinsics.checkNotNullParameter(map, "tags");
        return new MutableRequest(map, $this$toRequest) { // from class: kntr.base.http.params.interceptor.CommonParamsPluginKt$toRequest$1
            final /* synthetic */ HttpRequestBuilder $request;
            final /* synthetic */ Map<KClass<?>, Object> $tags;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(map);
                this.$tags = map;
                this.$request = $this$toRequest;
            }

            @Override // kntr.base.net.MutableRequest, kntr.base.net.Request
            public UrlProtocol getProtocol() {
                return new UrlProtocol(this.$request.getUrl().getProtocol().getName(), this.$request.getUrl().getProtocol().getDefaultPort());
            }

            @Override // kntr.base.net.MutableRequest
            public void setProtocol(UrlProtocol value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this.$request.getUrl().setProtocol(new URLProtocol(value.getName(), value.getDefaultPort()));
                this.$request.getUrl().setPort(value.getDefaultPort());
            }

            @Override // kntr.base.net.MutableRequest, kntr.base.net.Request
            public String getHost() {
                return this.$request.getUrl().getHost();
            }

            @Override // kntr.base.net.MutableRequest
            public void setHost(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this.$request.getUrl().setHost(value);
            }

            @Override // kntr.base.net.MutableRequest, kntr.base.net.Request
            public String getPath() {
                return URLBuilderKt.getEncodedPath(this.$request.getUrl());
            }

            @Override // kntr.base.net.MutableRequest
            public void setPath(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                URLBuilderKt.setEncodedPath(this.$request.getUrl(), value);
            }

            @Override // kntr.base.net.MutableRequest, kntr.base.net.Request
            public String getUrl() {
                return this.$request.getUrl().build().toString();
            }

            @Override // kntr.base.net.MutableRequest
            public void setUrl(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                URLParserKt.takeFrom(this.$request.getUrl(), value);
            }

            @Override // kntr.base.net.MutableRequest, kntr.base.net.Request
            public String header(String name) {
                Intrinsics.checkNotNullParameter(name, "name");
                return this.$request.getHeaders().get(name);
            }

            @Override // kntr.base.net.MutableRequest
            public void header(String name, String value) {
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(value, "value");
                this.$request.getHeaders().set(name, value);
            }

            @Override // kntr.base.net.MutableRequest
            public void query(String name, String value) {
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(value, "value");
                this.$request.getUrl().getParameters().append(name, value);
            }

            @Override // kntr.base.net.Request
            public Object source() {
                return this.$request;
            }

            @Override // kntr.base.net.Request
            public MutableRequest copy() {
                Request request = CommonParamsPluginKt.toRequest(new HttpRequestBuilder().takeFrom(this.$request), this.$tags);
                Intrinsics.checkNotNull(request, "null cannot be cast to non-null type kntr.base.net.MutableRequest");
                return (MutableRequest) request;
            }
        };
    }

    public static final HttpClientCall toHttpClientCall(Response $this$toHttpClientCall, HttpClient client, HttpRequestBuilder request) {
        ByteReadChannel empty;
        Source it;
        Intrinsics.checkNotNullParameter($this$toHttpClientCall, "<this>");
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(request, "request");
        if ($this$toHttpClientCall.source() instanceof HttpClientCall) {
            Object source = $this$toHttpClientCall.source();
            Intrinsics.checkNotNull(source, "null cannot be cast to non-null type io.ktor.client.call.HttpClientCall");
            return (HttpClientCall) source;
        }
        RequestTime requestTime = (RequestTime) $this$toHttpClientCall.getRequest().tag(Reflection.getOrCreateKotlinClass(RequestTime.class));
        long time = requestTime != null ? requestTime.getTime() : Clock.System.INSTANCE.now().toEpochMilliseconds();
        HttpRequestData build = request.build();
        HttpStatusCode httpStatusCode = new HttpStatusCode($this$toHttpClientCall.getHttpStatus().getValue(), $this$toHttpClientCall.getHttpStatus().getDescription());
        GMTDate GMTDate = DateJvmKt.GMTDate(Long.valueOf(time));
        Headers.Companion companion = Headers.Companion;
        HeadersBuilder $this$toHttpClientCall_u24lambda_u240 = new HeadersBuilder(0, 1, (DefaultConstructorMarker) null);
        Map $this$forEach$iv = $this$toHttpClientCall.headers();
        if ($this$forEach$iv != null) {
            for (Map.Entry element$iv : $this$forEach$iv.entrySet()) {
                $this$toHttpClientCall_u24lambda_u240.appendAll(element$iv.getKey(), element$iv.getValue());
            }
        }
        Unit unit = Unit.INSTANCE;
        Headers build2 = $this$toHttpClientCall_u24lambda_u240.build();
        HttpProtocolVersion http_1_1 = HttpProtocolVersion.Companion.getHTTP_1_1();
        Body body = $this$toHttpClientCall.getBody();
        if (body == null || (it = body.content()) == null || (empty = ByteChannelCtorKt.ByteReadChannel(it)) == null) {
            empty = ByteReadChannel.Companion.getEmpty();
        }
        return new HttpClientCall(client, build, new HttpResponseData(httpStatusCode, GMTDate, build2, http_1_1, empty, request.getExecutionContext()));
    }
}