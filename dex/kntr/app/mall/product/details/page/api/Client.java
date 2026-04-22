package kntr.app.mall.product.details.page.api;

import com.bilibili.ktor.KtorClientKt;
import com.bilibili.mall.kmm.base.MallEnvKt;
import io.ktor.client.HttpClient;
import io.ktor.client.HttpClientConfig;
import io.ktor.client.HttpClientKt;
import io.ktor.client.plugins.contentnegotiation.ContentNegotiationConfig;
import io.ktor.client.plugins.contentnegotiation.ContentNegotiationKt;
import io.ktor.http.ContentType;
import io.ktor.serialization.Configuration;
import io.ktor.serialization.kotlinx.json.JsonSupportKt;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.reflect.KType;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import kotlinx.serialization.modules.SerializersModule;

/* compiled from: Client.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J^\u0010\u000f\u001a\u0002H\u0010\"\u0006\b\u0000\u0010\u0010\u0018\u00012\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\u0018\b\u0002\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00152\u0018\b\u0002\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0015H\u0080H¢\u0006\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lkntr/app/mall/product/details/page/api/Client;", "", "<init>", "()V", "httpClient", "Lio/ktor/client/HttpClient;", "getHttpClient", "()Lio/ktor/client/HttpClient;", "httpClient$delegate", "Lkotlin/Lazy;", "json", "Lkotlinx/serialization/json/Json;", "getJson", "()Lkotlinx/serialization/json/Json;", "json$delegate", "kntrRequest", "T", "url", "", "method", "headers", "", "params", "kntrRequest$product_details_page_debug", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class Client {
    public static final Client INSTANCE = new Client();
    private static final Lazy httpClient$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.mall.product.details.page.api.Client$$ExternalSyntheticLambda4
        public final Object invoke() {
            HttpClient httpClient_delegate$lambda$0;
            httpClient_delegate$lambda$0 = Client.httpClient_delegate$lambda$0();
            return httpClient_delegate$lambda$0;
        }
    });
    private static final Lazy json$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.mall.product.details.page.api.Client$$ExternalSyntheticLambda5
        public final Object invoke() {
            Json json_delegate$lambda$0;
            json_delegate$lambda$0 = Client.json_delegate$lambda$0();
            return json_delegate$lambda$0;
        }
    });
    public static final int $stable = 8;

    private Client() {
    }

    public final HttpClient getHttpClient() {
        return (HttpClient) httpClient$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HttpClient httpClient_delegate$lambda$0() {
        return HttpClientKt.HttpClient(KtorClientKt.getBiliKtorHttpClientEngine(), new Function1() { // from class: kntr.app.mall.product.details.page.api.Client$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit httpClient_delegate$lambda$0$0;
                httpClient_delegate$lambda$0$0 = Client.httpClient_delegate$lambda$0$0((HttpClientConfig) obj);
                return httpClient_delegate$lambda$0$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit httpClient_delegate$lambda$0$0(HttpClientConfig $this$HttpClient) {
        Intrinsics.checkNotNullParameter($this$HttpClient, "$this$HttpClient");
        $this$HttpClient.install(ContentNegotiationKt.getContentNegotiation(), new Function1() { // from class: kntr.app.mall.product.details.page.api.Client$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit httpClient_delegate$lambda$0$0$0;
                httpClient_delegate$lambda$0$0$0 = Client.httpClient_delegate$lambda$0$0$0((ContentNegotiationConfig) obj);
                return httpClient_delegate$lambda$0$0$0;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit httpClient_delegate$lambda$0$0$0(ContentNegotiationConfig $this$install) {
        Intrinsics.checkNotNullParameter($this$install, "$this$install");
        JsonSupportKt.json$default((Configuration) $this$install, JsonKt.Json$default((Json) null, new Function1() { // from class: kntr.app.mall.product.details.page.api.Client$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit httpClient_delegate$lambda$0$0$0$0;
                httpClient_delegate$lambda$0$0$0$0 = Client.httpClient_delegate$lambda$0$0$0$0((JsonBuilder) obj);
                return httpClient_delegate$lambda$0$0$0$0;
            }
        }, 1, (Object) null), (ContentType) null, 2, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit httpClient_delegate$lambda$0$0$0$0(JsonBuilder $this$Json) {
        Intrinsics.checkNotNullParameter($this$Json, "$this$Json");
        $this$Json.setPrettyPrint(true);
        $this$Json.setLenient(true);
        $this$Json.setIgnoreUnknownKeys(true);
        $this$Json.setEncodeDefaults(true);
        $this$Json.setCoerceInputValues(true);
        $this$Json.setExplicitNulls(false);
        return Unit.INSTANCE;
    }

    public final Json getJson() {
        return (Json) json$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Json json_delegate$lambda$0() {
        return JsonKt.Json$default((Json) null, new Function1() { // from class: kntr.app.mall.product.details.page.api.Client$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit json_delegate$lambda$0$0;
                json_delegate$lambda$0$0 = Client.json_delegate$lambda$0$0((JsonBuilder) obj);
                return json_delegate$lambda$0$0;
            }
        }, 1, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit json_delegate$lambda$0$0(JsonBuilder $this$Json) {
        Intrinsics.checkNotNullParameter($this$Json, "$this$Json");
        $this$Json.setPrettyPrint(true);
        $this$Json.setLenient(true);
        $this$Json.setIgnoreUnknownKeys(true);
        $this$Json.setEncodeDefaults(true);
        $this$Json.setCoerceInputValues(true);
        $this$Json.setExplicitNulls(false);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object kntrRequest$product_details_page_debug$default(Client $this, String url, String method, Map headers, Map params, Continuation $completion, int i, Object obj) {
        if ((i & 2) != 0) {
            method = "GET";
        }
        if ((i & 4) != 0) {
            headers = null;
        }
        if ((i & 8) != 0) {
            params = null;
        }
        try {
            InlineMarker.mark(0);
            Object mallKntrAsyncRequest = MallEnvKt.mallKntrAsyncRequest(url, method, headers, params, $completion);
            InlineMarker.mark(1);
            String jsonString = (String) mallKntrAsyncRequest;
            Json this_$iv = $this.getJson();
            Intrinsics.checkNotNull(jsonString);
            SerializersModule serializersModule = this_$iv.getSerializersModule();
            Intrinsics.reifiedOperationMarker(6, "T");
            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
            Object res = this_$iv.decodeFromString(SerializersKt.serializer(serializersModule, (KType) null), jsonString);
            return res;
        } catch (Exception e) {
            KLog_androidKt.getKLog().e("Client", "请求失败: " + e.getMessage(), e);
            throw e;
        }
    }

    public final /* synthetic */ <T> Object kntrRequest$product_details_page_debug(String url, String method, Map<String, ? extends Object> map, Map<String, ? extends Object> map2, Continuation<? super T> continuation) {
        try {
            InlineMarker.mark(0);
            Object mallKntrAsyncRequest = MallEnvKt.mallKntrAsyncRequest(url, method, map, map2, continuation);
            InlineMarker.mark(1);
            String jsonString = (String) mallKntrAsyncRequest;
            Json this_$iv = getJson();
            Intrinsics.checkNotNull(jsonString);
            SerializersModule serializersModule = this_$iv.getSerializersModule();
            Intrinsics.reifiedOperationMarker(6, "T");
            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
            Object res = this_$iv.decodeFromString(SerializersKt.serializer(serializersModule, (KType) null), jsonString);
            return res;
        } catch (Exception e) {
            KLog_androidKt.getKLog().e("Client", "请求失败: " + e.getMessage(), e);
            throw e;
        }
    }
}