package io.ktor.client.plugins.json;

import faceverify.q;
import io.ktor.client.HttpClient;
import io.ktor.client.plugins.HttpClientPlugin;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.client.statement.HttpResponsePipeline;
import io.ktor.http.ContentType;
import io.ktor.http.ContentTypeMatcher;
import io.ktor.util.AttributeKey;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.KtorDsl;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;

/* compiled from: JsonPlugin.kt */
@Deprecated(level = DeprecationLevel.ERROR, message = "Please use ContentNegotiation plugin: https://ktor.io/docs/migration-to-20x.html#serialization-client")
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001e\u001dBE\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\u0012\b\u0002\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\t¢\u0006\u0004\b\f\u0010\rB\u0011\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\f\u0010\u0010J\u0017\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0019R\u001e\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lio/ktor/client/plugins/json/JsonPlugin;", "", "Lio/ktor/client/plugins/json/JsonSerializer;", "serializer", "", "Lio/ktor/http/ContentType;", "acceptContentTypes", "Lio/ktor/http/ContentTypeMatcher;", "receiveContentTypeMatchers", "", "Lkotlin/reflect/KClass;", "ignoredTypes", "<init>", "(Lio/ktor/client/plugins/json/JsonSerializer;Ljava/util/List;Ljava/util/List;Ljava/util/Set;)V", "Lio/ktor/client/plugins/json/JsonPlugin$Config;", "config", "(Lio/ktor/client/plugins/json/JsonPlugin$Config;)V", "contentType", "", "canHandle$ktor_client_json", "(Lio/ktor/http/ContentType;)Z", "canHandle", "Lio/ktor/client/plugins/json/JsonSerializer;", "getSerializer", "()Lio/ktor/client/plugins/json/JsonSerializer;", "Ljava/util/List;", "getAcceptContentTypes", "()Ljava/util/List;", "Ljava/util/Set;", "Plugin", "Config", "ktor-client-json"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class JsonPlugin {
    public static final Plugin Plugin = new Plugin(null);
    private static final AttributeKey<JsonPlugin> key;
    private final List<ContentType> acceptContentTypes;
    private final Set<KClass<?>> ignoredTypes;
    private final List<ContentTypeMatcher> receiveContentTypeMatchers;
    private final JsonSerializer serializer;

    /* JADX WARN: Multi-variable type inference failed */
    public JsonPlugin(JsonSerializer serializer, List<ContentType> list, List<? extends ContentTypeMatcher> list2, Set<? extends KClass<?>> set) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(list, "acceptContentTypes");
        Intrinsics.checkNotNullParameter(list2, "receiveContentTypeMatchers");
        Intrinsics.checkNotNullParameter(set, "ignoredTypes");
        this.serializer = serializer;
        this.acceptContentTypes = list;
        this.receiveContentTypeMatchers = list2;
        this.ignoredTypes = set;
    }

    public /* synthetic */ JsonPlugin(JsonSerializer jsonSerializer, List list, List list2, Set set, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(jsonSerializer, (i2 & 2) != 0 ? CollectionsKt.listOf(ContentType.Application.INSTANCE.getJson()) : list, (i2 & 4) != 0 ? CollectionsKt.listOf(new JsonContentTypeMatcher()) : list2, (i2 & 8) != 0 ? SetsKt.plus(JsonPluginKt.getDefaultCommonIgnoredTypes(), JsonPluginJvmKt.getDefaultIgnoredTypes()) : set);
    }

    public final JsonSerializer getSerializer() {
        return this.serializer;
    }

    public final List<ContentType> getAcceptContentTypes() {
        return this.acceptContentTypes;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JsonPlugin(Config config) {
        this(r0 == null ? DefaultJvmKt.defaultSerializer() : r0, config.getAcceptContentTypes(), config.getReceiveContentTypeMatchers(), null, 8, null);
        Intrinsics.checkNotNullParameter(config, "config");
        JsonSerializer serializer = config.getSerializer();
    }

    /* compiled from: JsonPlugin.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u00020\u00072\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u000f\u001a\u00020\u0007\"\u0006\b\u0000\u0010\u000e\u0018\u0001H\u0086\b¢\u0006\u0004\b\u000f\u0010\u0003J\u0018\u0010\u0010\u001a\u00020\u0007\"\u0006\b\u0000\u0010\u000e\u0018\u0001H\u0086\b¢\u0006\u0004\b\u0010\u0010\u0003J\u0019\u0010\u0010\u001a\u00020\u00072\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0011¢\u0006\u0004\b\u0010\u0010\u0013J\u0019\u0010\u000f\u001a\u00020\u00072\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0011¢\u0006\u0004\b\u000f\u0010\u0013J\r\u0010\u0014\u001a\u00020\u0007¢\u0006\u0004\b\u0014\u0010\u0003R$\u0010\u0016\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00110\u00158\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00050!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\n0!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010#R0\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00050%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050%8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R0\u0010.\u001a\b\u0012\u0004\u0012\u00020\n0%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\n0%8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b,\u0010(\"\u0004\b-\u0010*¨\u0006/"}, d2 = {"Lio/ktor/client/plugins/json/JsonPlugin$Config;", "", "<init>", "()V", "", "Lio/ktor/http/ContentType;", "contentTypes", "", "accept", "([Lio/ktor/http/ContentType;)V", "Lio/ktor/http/ContentTypeMatcher;", "matcher", "receive", "(Lio/ktor/http/ContentTypeMatcher;)V", "T", "ignoreType", "removeIgnoredType", "Lkotlin/reflect/KClass;", "type", "(Lkotlin/reflect/KClass;)V", "clearIgnoredTypes", "", "ignoredTypes", "Ljava/util/Set;", "getIgnoredTypes$ktor_client_json", "()Ljava/util/Set;", "Lio/ktor/client/plugins/json/JsonSerializer;", "serializer", "Lio/ktor/client/plugins/json/JsonSerializer;", "getSerializer", "()Lio/ktor/client/plugins/json/JsonSerializer;", "setSerializer", "(Lio/ktor/client/plugins/json/JsonSerializer;)V", "", "_acceptContentTypes", "Ljava/util/List;", "_receiveContentTypeMatchers", "", "value", "getAcceptContentTypes", "()Ljava/util/List;", "setAcceptContentTypes", "(Ljava/util/List;)V", "acceptContentTypes", "getReceiveContentTypeMatchers", "setReceiveContentTypeMatchers", "receiveContentTypeMatchers", "ktor-client-json"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @KtorDsl
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Config {
        private JsonSerializer serializer;
        private final Set<KClass<?>> ignoredTypes = CollectionsKt.toMutableSet(SetsKt.plus(JsonPluginJvmKt.getDefaultIgnoredTypes(), JsonPluginKt.getDefaultCommonIgnoredTypes()));
        private final List<ContentType> _acceptContentTypes = CollectionsKt.mutableListOf(new ContentType[]{ContentType.Application.INSTANCE.getJson()});
        private final List<ContentTypeMatcher> _receiveContentTypeMatchers = CollectionsKt.mutableListOf(new ContentTypeMatcher[]{new JsonContentTypeMatcher()});

        public final Set<KClass<?>> getIgnoredTypes$ktor_client_json() {
            return this.ignoredTypes;
        }

        public final JsonSerializer getSerializer() {
            return this.serializer;
        }

        public final void setSerializer(JsonSerializer jsonSerializer) {
            this.serializer = jsonSerializer;
        }

        public final void setAcceptContentTypes(List<ContentType> list) {
            Intrinsics.checkNotNullParameter(list, "value");
            if (list.isEmpty()) {
                throw new IllegalArgumentException("At least one content type should be provided to acceptContentTypes".toString());
            }
            this._acceptContentTypes.clear();
            this._acceptContentTypes.addAll(list);
        }

        public final List<ContentType> getAcceptContentTypes() {
            return this._acceptContentTypes;
        }

        public final void setReceiveContentTypeMatchers(List<? extends ContentTypeMatcher> list) {
            Intrinsics.checkNotNullParameter(list, "value");
            if (list.isEmpty()) {
                throw new IllegalArgumentException("At least one content type should be provided to acceptContentTypes".toString());
            }
            this._receiveContentTypeMatchers.clear();
            this._receiveContentTypeMatchers.addAll(list);
        }

        public final List<ContentTypeMatcher> getReceiveContentTypeMatchers() {
            return this._receiveContentTypeMatchers;
        }

        public final void accept(ContentType... contentTypes) {
            Intrinsics.checkNotNullParameter(contentTypes, "contentTypes");
            CollectionsKt.addAll(this._acceptContentTypes, contentTypes);
        }

        public final void receive(ContentTypeMatcher matcher) {
            Intrinsics.checkNotNullParameter(matcher, "matcher");
            this._receiveContentTypeMatchers.add(matcher);
        }

        public final /* synthetic */ <T> void ignoreType() {
            Intrinsics.reifiedOperationMarker(4, "T");
            ignoreType(Reflection.getOrCreateKotlinClass(Object.class));
        }

        public final /* synthetic */ <T> void removeIgnoredType() {
            Intrinsics.reifiedOperationMarker(4, "T");
            removeIgnoredType(Reflection.getOrCreateKotlinClass(Object.class));
        }

        public final void removeIgnoredType(KClass<?> kClass) {
            Intrinsics.checkNotNullParameter(kClass, "type");
            this.ignoredTypes.remove(kClass);
        }

        public final void ignoreType(KClass<?> kClass) {
            Intrinsics.checkNotNullParameter(kClass, "type");
            this.ignoredTypes.add(kClass);
        }

        public final void clearIgnoredTypes() {
            this.ignoredTypes.clear();
        }
    }

    public final boolean canHandle$ktor_client_json(ContentType contentType) {
        Iterable $this$any$iv;
        Iterable $this$any$iv2;
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Iterable $this$any$iv3 = this.acceptContentTypes;
        if (!($this$any$iv3 instanceof Collection) || !((Collection) $this$any$iv3).isEmpty()) {
            Iterator<T> it = $this$any$iv3.iterator();
            while (true) {
                if (it.hasNext()) {
                    Object element$iv = it.next();
                    ContentType it2 = (ContentType) element$iv;
                    if (contentType.match(it2)) {
                        $this$any$iv = 1;
                        break;
                    }
                } else {
                    $this$any$iv = null;
                    break;
                }
            }
        } else {
            $this$any$iv = null;
        }
        Iterable matchers = this.receiveContentTypeMatchers;
        if ($this$any$iv == null) {
            Iterable $this$any$iv4 = matchers;
            if (!($this$any$iv4 instanceof Collection) || !((Collection) $this$any$iv4).isEmpty()) {
                Iterator<T> it3 = $this$any$iv4.iterator();
                while (true) {
                    if (it3.hasNext()) {
                        Object element$iv2 = it3.next();
                        ContentTypeMatcher matcher = (ContentTypeMatcher) element$iv2;
                        if (matcher.contains(contentType)) {
                            $this$any$iv2 = 1;
                            break;
                        }
                    } else {
                        $this$any$iv2 = null;
                        break;
                    }
                }
            } else {
                $this$any$iv2 = null;
            }
            return $this$any$iv2 != null;
        }
        return true;
    }

    /* compiled from: JsonPlugin.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\n\u001a\u00020\u00032\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00118\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lio/ktor/client/plugins/json/JsonPlugin$Plugin;", "Lio/ktor/client/plugins/HttpClientPlugin;", "Lio/ktor/client/plugins/json/JsonPlugin$Config;", "Lio/ktor/client/plugins/json/JsonPlugin;", "<init>", "()V", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "block", "prepare", "(Lkotlin/jvm/functions/Function1;)Lio/ktor/client/plugins/json/JsonPlugin;", "plugin", "Lio/ktor/client/HttpClient;", "scope", "install", "(Lio/ktor/client/plugins/json/JsonPlugin;Lio/ktor/client/HttpClient;)V", "Lio/ktor/util/AttributeKey;", q.KEY_RES_9_KEY, "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "ktor-client-json"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Plugin implements HttpClientPlugin<Config, JsonPlugin> {
        public /* synthetic */ Plugin(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Plugin() {
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public AttributeKey<JsonPlugin> getKey() {
            return JsonPlugin.key;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.ktor.client.plugins.HttpClientPlugin
        public JsonPlugin prepare(Function1<? super Config, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            Config config = new Config();
            function1.invoke(config);
            JsonSerializer serializer = config.getSerializer();
            if (serializer == null) {
                serializer = DefaultJvmKt.defaultSerializer();
            }
            List allowedContentTypes = CollectionsKt.toList(config.getAcceptContentTypes());
            List receiveContentTypeMatchers = config.getReceiveContentTypeMatchers();
            Set ignoredTypes = config.getIgnoredTypes$ktor_client_json();
            return new JsonPlugin(serializer, allowedContentTypes, receiveContentTypeMatchers, ignoredTypes);
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public void install(JsonPlugin plugin, HttpClient scope) {
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            Intrinsics.checkNotNullParameter(scope, "scope");
            scope.getRequestPipeline().intercept(HttpRequestPipeline.Phases.getTransform(), new JsonPlugin$Plugin$install$1(plugin, null));
            scope.getResponsePipeline().intercept(HttpResponsePipeline.Phases.getTransform(), new JsonPlugin$Plugin$install$2(plugin, null));
        }
    }

    static {
        KType kType = null;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(JsonPlugin.class);
        try {
            kType = Reflection.typeOf(JsonPlugin.class);
        } catch (Throwable th) {
        }
        key = new AttributeKey<>("Json", new TypeInfo(orCreateKotlinClass, kType));
    }
}