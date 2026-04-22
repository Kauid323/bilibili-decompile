package kntr.base.net.comm.imp;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kntr.base.net.GInterceptor;
import kntr.base.net.MutableRequest;
import kntr.base.net.Request;
import kntr.base.net.RequestHook;
import kntr.base.net.comm.ProxyConfigManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

/* compiled from: InitFFProxy.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0007¨\u0006\u0002"}, d2 = {"provideFFProxyRequest", "Lkntr/base/net/GInterceptor;", "ffproxy_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class InitFFProxyKt {
    public static final GInterceptor provideFFProxyRequest() {
        return new RequestHook("ffproxy", null, new Function1() { // from class: kntr.base.net.comm.imp.InitFFProxyKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Request provideFFProxyRequest$lambda$0;
                provideFFProxyRequest$lambda$0 = InitFFProxyKt.provideFFProxyRequest$lambda$0((Request) obj);
                return provideFFProxyRequest$lambda$0;
            }
        }, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Request provideFFProxyRequest$lambda$0(Request req) {
        JsonPrimitive jsonPrimitive;
        Intrinsics.checkNotNullParameter(req, "req");
        if (!ProxyConfigManager.INSTANCE.isFFProxyEnabled() || Intrinsics.areEqual(req.getHost(), ProxyConfigManager.PROXY_HOST)) {
            return req;
        }
        MutableRequest request = req.copy();
        String originHost = req.getHost();
        request.setHost(ProxyConfigManager.PROXY_HOST);
        request.header(ProxyConfigManager.TARGET_HOST_HEADER, originHost);
        String it = ProxyConfigManager.INSTANCE.getProxyId();
        if (it != null) {
            request.header(ProxyConfigManager.PROXY_ID_HEADER, it);
        }
        String it2 = ProxyConfigManager.INSTANCE.getProxyEnv();
        if (it2 != null) {
            request.header(ProxyConfigManager.PROXY_ENV_HEADER, it2);
        }
        String it3 = ProxyConfigManager.INSTANCE.getProxyColor();
        if (it3 != null) {
            request.header(ProxyConfigManager.PROXY_COLOR_HEADER, it3);
        }
        String it4 = ProxyConfigManager.INSTANCE.getExtraHeaders();
        if (it4 != null) {
            Json json = JsonKt.Json$default((Json) null, new Function1() { // from class: kntr.base.net.comm.imp.InitFFProxyKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit provideFFProxyRequest$lambda$0$3$0;
                    provideFFProxyRequest$lambda$0$3$0 = InitFFProxyKt.provideFFProxyRequest$lambda$0$3$0((JsonBuilder) obj);
                    return provideFFProxyRequest$lambda$0$3$0;
                }
            }, 1, (Object) null);
            try {
                json.getSerializersModule();
                JsonObject jsonObject = (JsonObject) json.decodeFromString(JsonObject.Companion.serializer(), it4);
                for (String key : jsonObject.keySet()) {
                    switch (key.hashCode()) {
                        case -1521116814:
                            if (!key.equals(ProxyConfigManager.PROXY_ID_HEADER)) {
                                break;
                            } else {
                                continue;
                            }
                        case 90015606:
                            if (!key.equals(ProxyConfigManager.PROXY_ENV_HEADER)) {
                                break;
                            } else {
                                continue;
                            }
                        case 2088807546:
                            if (!key.equals(ProxyConfigManager.PROXY_COLOR_HEADER)) {
                                break;
                            } else {
                                continue;
                            }
                    }
                    JsonElement jsonElement = (JsonElement) jsonObject.get(key);
                    request.header(key, (jsonElement == null || (jsonPrimitive = JsonElementKt.getJsonPrimitive(jsonElement)) == null || (r11 = JsonElementKt.getContentOrNull(jsonPrimitive)) == null) ? "" : "");
                }
            } catch (Exception e) {
                KLog_androidKt.getKLog().i("FFProxy", "GInterceptor e: " + e);
            }
        }
        return request;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit provideFFProxyRequest$lambda$0$3$0(JsonBuilder $this$Json) {
        Intrinsics.checkNotNullParameter($this$Json, "$this$Json");
        $this$Json.setLenient(true);
        $this$Json.setIgnoreUnknownKeys(true);
        return Unit.INSTANCE;
    }
}