package kntr.app.mall.mallDynamicPage;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import io.ktor.http.Parameters;
import io.ktor.http.URLUtilsKt;
import java.util.Map;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.app.mall.mallDynamicPage.parser.JsonParserKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;

/* compiled from: MallDynamicPageViewModel.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u0001BØ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012D\u0010\u0006\u001a@\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007\u0012o\u0010\r\u001ak\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012+\u0012)\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0004\b\u0012\u0010\u0013J\u0006\u0010(\u001a\u00020\u0010J\u0010\u0010)\u001a\u00020\u00102\b\u0010\f\u001a\u0004\u0018\u00010\u0001J6\u0010*\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u00032\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000RX\u0010\u0006\u001a@\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017Rw\u0010\r\u001ak\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012+\u0012)\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00100\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\u0003X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR&\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR#\u0010 \u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000b0!¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020%¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'¨\u0006,"}, d2 = {"Lkntr/app/mall/mallDynamicPage/MallDynamicPageViewModel;", RoomRecommendViewModel.EMPTY_CURSOR, "url", RoomRecommendViewModel.EMPTY_CURSOR, "uiString", "jsString", "valueBridge", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "key", RoomRecommendViewModel.EMPTY_CURSOR, "data", "bridgeCall", "Lkotlin/Function3;", "Lkotlin/Function1;", RoomRecommendViewModel.EMPTY_CURSOR, "callback", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;)V", "getValueBridge", "()Lkotlin/jvm/functions/Function2;", "setValueBridge", "(Lkotlin/jvm/functions/Function2;)V", "string", "getString", "()Ljava/lang/String;", "ui", "getUi", "()Ljava/util/Map;", "setUi", "(Ljava/util/Map;)V", "dataState", "Landroidx/compose/runtime/MutableState;", "getDataState", "()Landroidx/compose/runtime/MutableState;", "jsonBuilder", "Lkotlinx/serialization/json/Json;", "getJsonBuilder", "()Lkotlinx/serialization/json/Json;", "init", "refresh", "executeJs", "params", "mallDynamicPage_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MallDynamicPageViewModel {
    public static final int $stable = 8;
    private Function3<? super String, ? super Map<String, ? extends Object>, ? super Function1<? super Map<String, ? extends Object>, Unit>, Unit> bridgeCall;
    private final MutableState<Map<String, Object>> dataState;
    private String jsString;
    private final Json jsonBuilder;
    private final String string;
    private Map<String, ? extends Object> ui;
    private String uiString;
    private String url;
    private Function2<? super String, ? super Map<String, ? extends Object>, ? extends Object> valueBridge;

    public MallDynamicPageViewModel(String url, String uiString, String jsString, Function2<? super String, ? super Map<String, ? extends Object>, ? extends Object> function2, Function3<? super String, ? super Map<String, ? extends Object>, ? super Function1<? super Map<String, ? extends Object>, Unit>, Unit> function3) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(uiString, "uiString");
        Intrinsics.checkNotNullParameter(jsString, "jsString");
        Intrinsics.checkNotNullParameter(function2, "valueBridge");
        Intrinsics.checkNotNullParameter(function3, "bridgeCall");
        this.url = url;
        this.uiString = uiString;
        this.jsString = jsString;
        this.valueBridge = function2;
        this.bridgeCall = function3;
        this.string = "{}";
        this.ui = MapsKt.emptyMap();
        this.dataState = SnapshotStateKt.mutableStateOf$default(JsonParserKt.jsonToMap(this.string), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.jsonBuilder = JsonKt.Json$default((Json) null, new Function1() { // from class: kntr.app.mall.mallDynamicPage.MallDynamicPageViewModel$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                Unit jsonBuilder$lambda$0;
                jsonBuilder$lambda$0 = MallDynamicPageViewModel.jsonBuilder$lambda$0((JsonBuilder) obj);
                return jsonBuilder$lambda$0;
            }
        }, 1, (Object) null);
        init();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ MallDynamicPageViewModel(String str, String str2, String str3, Function2 function2, Function3 function3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, str2, str3, function2, function3);
        String str4;
        if ((i & 1) == 0) {
            str4 = str;
        } else {
            str4 = RoomRecommendViewModel.EMPTY_CURSOR;
        }
    }

    public final Function2<String, Map<String, ? extends Object>, Object> getValueBridge() {
        return this.valueBridge;
    }

    public final void setValueBridge(Function2<? super String, ? super Map<String, ? extends Object>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        this.valueBridge = function2;
    }

    public final String getString() {
        return this.string;
    }

    public final Map<String, Object> getUi() {
        return this.ui;
    }

    public final void setUi(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.ui = map;
    }

    public final MutableState<Map<String, Object>> getDataState() {
        return this.dataState;
    }

    public final Json getJsonBuilder() {
        return this.jsonBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit jsonBuilder$lambda$0(JsonBuilder $this$Json) {
        Intrinsics.checkNotNullParameter($this$Json, "$this$Json");
        $this$Json.setIgnoreUnknownKeys(true);
        $this$Json.setLenient(true);
        return Unit.INSTANCE;
    }

    public final void init() {
        Parameters params = URLUtilsKt.Url(this.url).getParameters();
        String debug = params.get("debug");
        this.bridgeCall.invoke("register", MapsKt.emptyMap(), new Function1() { // from class: kntr.app.mall.mallDynamicPage.MallDynamicPageViewModel$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit init$lambda$0;
                init$lambda$0 = MallDynamicPageViewModel.init$lambda$0(MallDynamicPageViewModel.this, (Map) obj);
                return init$lambda$0;
            }
        });
        if (Intrinsics.areEqual(debug, "1")) {
            this.bridgeCall.invoke("request", MapsKt.mapOf(TuplesKt.to("url", "https://mall.bilibili.com/mall-c-search/dynamic/test/ui")), new Function1() { // from class: kntr.app.mall.mallDynamicPage.MallDynamicPageViewModel$$ExternalSyntheticLambda4
                public final Object invoke(Object obj) {
                    Unit init$lambda$1;
                    init$lambda$1 = MallDynamicPageViewModel.init$lambda$1(MallDynamicPageViewModel.this, r2, (Map) obj);
                    return init$lambda$1;
                }
            });
            return;
        }
        Object uiString = this.valueBridge.invoke("getModResource", MapsKt.mapOf(new Pair[]{TuplesKt.to("modName", "minePage"), TuplesKt.to("fileName", "ui.json")}));
        String it = uiString instanceof String ? (String) uiString : null;
        if (it != null) {
            this.ui = JsonParserKt.jsonToMap(it);
        }
        Object jsString = this.valueBridge.invoke("getModResource", MapsKt.mapOf(new Pair[]{TuplesKt.to("modName", "minePage"), TuplesKt.to("fileName", "index.js")}));
        if (jsString != null) {
            this.bridgeCall.invoke("evaluateScript", MapsKt.mapOf(TuplesKt.to("js", jsString)), new Function1() { // from class: kntr.app.mall.mallDynamicPage.MallDynamicPageViewModel$$ExternalSyntheticLambda5
                public final Object invoke(Object obj) {
                    Unit init$lambda$3$0;
                    init$lambda$3$0 = MallDynamicPageViewModel.init$lambda$3$0((Map) obj);
                    return init$lambda$3$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit init$lambda$0(MallDynamicPageViewModel this$0, Map data) {
        Intrinsics.checkNotNullParameter(data, "data");
        Object obj = data.get("key");
        String it = obj instanceof String ? (String) obj : null;
        if (it != null && Intrinsics.areEqual(it, "dynamicRefresh")) {
            this$0.refresh(data.get("data"));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit init$lambda$1(final MallDynamicPageViewModel this$0, String $jsStringUrl, Map uiData) {
        Intrinsics.checkNotNullParameter(uiData, "uiData");
        Object obj = uiData.get("result");
        String uiString = obj instanceof String ? (String) obj : null;
        if (uiString != null) {
            this$0.ui = JsonParserKt.jsonToMap(uiString);
            this$0.bridgeCall.invoke("request", MapsKt.mapOf(TuplesKt.to("url", $jsStringUrl)), new Function1() { // from class: kntr.app.mall.mallDynamicPage.MallDynamicPageViewModel$$ExternalSyntheticLambda2
                public final Object invoke(Object obj2) {
                    Unit init$lambda$1$0$0;
                    init$lambda$1$0$0 = MallDynamicPageViewModel.init$lambda$1$0$0(MallDynamicPageViewModel.this, (Map) obj2);
                    return init$lambda$1$0$0;
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit init$lambda$1$0$0(MallDynamicPageViewModel this$0, Map jsData) {
        Intrinsics.checkNotNullParameter(jsData, "jsData");
        Object obj = jsData.get("result");
        String jsString = obj instanceof String ? (String) obj : null;
        if (jsString != null) {
            this$0.bridgeCall.invoke("evaluateScript", MapsKt.mapOf(TuplesKt.to("js", jsString)), new Function1() { // from class: kntr.app.mall.mallDynamicPage.MallDynamicPageViewModel$$ExternalSyntheticLambda0
                public final Object invoke(Object obj2) {
                    Unit init$lambda$1$0$0$0$0;
                    init$lambda$1$0$0$0$0 = MallDynamicPageViewModel.init$lambda$1$0$0$0$0((Map) obj2);
                    return init$lambda$1$0$0$0$0;
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit init$lambda$1$0$0$0$0(Map map) {
        Intrinsics.checkNotNullParameter(map, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit init$lambda$3$0(Map map) {
        Intrinsics.checkNotNullParameter(map, "<unused var>");
        return Unit.INSTANCE;
    }

    public final void refresh(Object data) {
        String it = data instanceof String ? (String) data : null;
        if (it != null) {
            this.dataState.setValue(JsonParserKt.jsonToMap(it));
        }
    }

    public final void executeJs(String name, Map<String, ? extends Object> map, Map<String, ? extends Object> map2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(map, "params");
        Intrinsics.checkNotNullParameter(map2, "data");
        boolean z = false;
        JsonObjectBuilder builder$iv = new JsonObjectBuilder();
        boolean z2 = false;
        for (Map.Entry element$iv : map.entrySet()) {
            String k = element$iv.getKey();
            Object v = element$iv.getValue();
            boolean z3 = z;
            boolean z4 = z2;
            Object result = this.valueBridge.invoke("kmmAntlrExec", MapsKt.mapOf(new Pair[]{TuplesKt.to("expression", v), TuplesKt.to("data", map2)}));
            if (!(result instanceof JsonElement)) {
                if (!(result instanceof String)) {
                    if (!(result instanceof Number)) {
                        if (result instanceof Boolean) {
                            builder$iv.put(k, JsonElementKt.JsonPrimitive((Boolean) result));
                        } else {
                            builder$iv.put(k, JsonElementKt.JsonPrimitive(String.valueOf(result)));
                        }
                    } else {
                        builder$iv.put(k, JsonElementKt.JsonPrimitive((Number) result));
                    }
                } else {
                    builder$iv.put(k, JsonElementKt.JsonPrimitive((String) result));
                }
            } else {
                builder$iv.put(k, (JsonElement) result);
            }
            z = z3;
            z2 = z4;
        }
        JsonObject jsObject = builder$iv.build();
        String jsParams = jsObject.toString();
        String jsCall = name + "(" + jsParams + ")";
        this.bridgeCall.invoke("evaluateScript", MapsKt.mapOf(TuplesKt.to("js", jsCall)), new Function1() { // from class: kntr.app.mall.mallDynamicPage.MallDynamicPageViewModel$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit executeJs$lambda$1;
                executeJs$lambda$1 = MallDynamicPageViewModel.executeJs$lambda$1((Map) obj);
                return executeJs$lambda$1;
            }
        });
        System.out.println((Object) ("wbw---jscall--name " + name + " --params: " + jsParams));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit executeJs$lambda$1(Map map) {
        Intrinsics.checkNotNullParameter(map, "<unused var>");
        return Unit.INSTANCE;
    }
}