package kntr.base.router;

import com.bilibili.lib.brouter.api.BRouteInfo;
import com.bilibili.lib.brouter.api.BRouteRequest;
import com.bilibili.lib.brouter.api.BRouteRequest_androidKt;
import com.bilibili.lib.brouter.api.BRouteResponse;
import com.bilibili.lib.brouter.uri.Uri;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.router.Interceptor;
import kntr.base.router.internal.ActionInterceptor;
import kntr.base.router.target.RouterTarget;
import kntr.base.router.target.RouterTargetContext;
import kntr.base.router.target.UnregisteredTarget;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KType;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: Router.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B3\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b0\u0006¢\u0006\u0004\b\t\u0010\nJ\f\u0010\r\u001a\u00020\u000e*\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u000e\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0016\u001a\u00020\u0017R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b0\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0019"}, d2 = {"Lkntr/base/router/Router;", "", "interceptors", "", "Lkntr/base/router/Interceptor;", "contextProviders", "", "Lkotlin/reflect/KType;", "Lkotlin/Function0;", "<init>", "(Ljava/util/List;Ljava/util/Map;)V", "getContextProviders$core_debug", "()Ljava/util/Map;", "toTarget", "Lkntr/base/router/target/RouterTarget;", "Lcom/bilibili/lib/brouter/api/BRouteResponse;", "_find", "uri", "Lcom/bilibili/lib/brouter/uri/Uri;", "find", "launch", "Lkntr/base/router/Response;", "newBuilder", "Lkntr/base/router/Router$Builder;", "Builder", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class Router {
    private final Map<KType, Function0<Object>> contextProviders;
    private final List<Interceptor> interceptors;

    /* JADX WARN: Multi-variable type inference failed */
    public Router(List<? extends Interceptor> list, Map<KType, ? extends Function0<? extends Object>> map) {
        Intrinsics.checkNotNullParameter(list, "interceptors");
        Intrinsics.checkNotNullParameter(map, "contextProviders");
        this.interceptors = list;
        this.contextProviders = map;
    }

    public final Map<KType, Function0<Object>> getContextProviders$core_debug() {
        return this.contextProviders;
    }

    private final RouterTarget toTarget(final BRouteResponse $this$toTarget) {
        RouterTarget routerTarget;
        BRouteInfo route = $this$toTarget.getRoute();
        Object target = route != null ? route.getTarget() : null;
        Function1 invoker = TypeIntrinsics.isFunctionOfArity(target, 1) ? (Function1) target : null;
        if (invoker != null && (routerTarget = (RouterTarget) invoker.invoke(new RouterTargetContext($this$toTarget, this) { // from class: kntr.base.router.Router$toTarget$1
            final /* synthetic */ BRouteResponse $this_toTarget;
            final /* synthetic */ Router this$0;
            private final Uri uri;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.$this_toTarget = $this$toTarget;
                this.this$0 = this;
                this.uri = $this$toTarget.getRequest().getUniformUri();
            }

            @Override // kntr.base.router.target.RouterTargetContext
            public RouterTarget find(Uri uri) {
                Intrinsics.checkNotNullParameter(uri, "uri");
                return this.this$0.find(uri);
            }

            @Override // kntr.base.router.target.RouterTargetContext
            public Response launch(Uri uri) {
                Intrinsics.checkNotNullParameter(uri, "uri");
                return this.this$0.launch(uri);
            }

            @Override // kntr.base.router.target.RouterTargetContext
            public Object contextUnsafe(KType type) {
                Intrinsics.checkNotNullParameter(type, "type");
                Function0<Object> function0 = this.this$0.getContextProviders$core_debug().get(type);
                if (function0 != null) {
                    return function0.invoke();
                }
                return null;
            }

            @Override // kntr.base.router.target.RouterTargetContext
            public Uri getUri() {
                return this.uri;
            }

            @Override // kntr.base.router.target.RouterTargetContext
            public String getUriParam(String key) {
                Map captures;
                String str;
                Intrinsics.checkNotNullParameter(key, "key");
                BRouteInfo route2 = this.$this_toTarget.getRoute();
                if (route2 == null || (captures = route2.getCaptures()) == null || (str = (String) captures.get(key)) == null) {
                    String str2 = this.$this_toTarget.getRequest().getParams().get(key);
                    return str2 == null ? this.$this_toTarget.getRequest().getProps().get(key) : str2;
                }
                return str;
            }
        })) != null) {
            return routerTarget;
        }
        return UnregisteredTarget.INSTANCE;
    }

    private final BRouteResponse _find(Uri uri) {
        BRouteRequest request = BRouteRequest_androidKt.toBuilder(uri).routeTypes(CollectionsKt.listOf(RouteKt.BROUTE_TYPE)).build();
        return (BRouteResponse) BuildersKt.runBlocking(Dispatchers.getMain().getImmediate(), new Router$_find$1(request, null));
    }

    public final RouterTarget find(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return toTarget(_find(uri));
    }

    public final Response launch(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        BRouteResponse resp = _find(uri);
        RouterTarget target = toTarget(resp);
        List $this$launch_u24lambda_u240 = CollectionsKt.createListBuilder();
        $this$launch_u24lambda_u240.addAll(CollectionsKt.asReversed(this.interceptors));
        $this$launch_u24lambda_u240.add(ActionInterceptor.INSTANCE);
        List interceptors = CollectionsKt.build($this$launch_u24lambda_u240);
        final BRouteInfo info = resp.getRoute();
        final BRouteRequest request = resp.getRequest();
        RealInterceptorChain chain = new RealInterceptorChain(interceptors, 0, this, target, uri, new Function1() { // from class: kntr.base.router.Router$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                String launch$lambda$1;
                launch$lambda$1 = Router.launch$lambda$1(info, request, (String) obj);
                return launch$lambda$1;
            }
        });
        return Interceptor.Chain.CC.proceed$default(chain, target, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String launch$lambda$1(BRouteInfo $info, BRouteRequest $request, String key) {
        Map captures;
        String str;
        Intrinsics.checkNotNullParameter(key, "key");
        if ($info == null || (captures = $info.getCaptures()) == null || (str = (String) captures.get(key)) == null) {
            String str2 = $request.getParams().get(key);
            return str2 == null ? $request.getProps().get(key) : str2;
        }
        return str;
    }

    public final Builder newBuilder() {
        return new Builder(CollectionsKt.toMutableList(this.interceptors), MapsKt.toMutableMap(this.contextProviders));
    }

    /* compiled from: Router.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B3\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b0\u0006¢\u0006\u0004\b\t\u0010\nB\t\b\u0016¢\u0006\u0004\b\t\u0010\u000bJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0004J(\u0010\u000e\u001a\u00020\u0000\"\n\b\u0000\u0010\u000f\u0018\u0001*\u00020\u00012\u000e\b\b\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\bH\u0086\bø\u0001\u0000J \u0010\u000e\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bH\u0001J\u0006\u0010\u0013\u001a\u00020\u0014R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0015"}, d2 = {"Lkntr/base/router/Router$Builder;", "", "interceptors", "", "Lkntr/base/router/Interceptor;", "contextProviders", "", "Lkotlin/reflect/KType;", "Lkotlin/Function0;", "<init>", "(Ljava/util/List;Ljava/util/Map;)V", "()V", "addInterceptor", "interceptor", "addContextProvider", "T", "provider", "", "type", "build", "Lkntr/base/router/Router;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Builder {
        private final Map<KType, Function0<Object>> contextProviders;
        private final List<Interceptor> interceptors;

        public Builder(List<Interceptor> list, Map<KType, Function0<Object>> map) {
            Intrinsics.checkNotNullParameter(list, "interceptors");
            Intrinsics.checkNotNullParameter(map, "contextProviders");
            this.interceptors = list;
            this.contextProviders = map;
        }

        public Builder() {
            this(new ArrayList(), new HashMap());
        }

        public final Builder addInterceptor(Interceptor interceptor) {
            Intrinsics.checkNotNullParameter(interceptor, "interceptor");
            Builder $this$addInterceptor_u24lambda_u240 = this;
            $this$addInterceptor_u24lambda_u240.interceptors.add(interceptor);
            return this;
        }

        public final /* synthetic */ <T> Builder addContextProvider(Function0<? extends T> function0) {
            Intrinsics.checkNotNullParameter(function0, "provider");
            Builder $this$addContextProvider_u24lambda_u240 = this;
            Intrinsics.reifiedOperationMarker(6, "T");
            $this$addContextProvider_u24lambda_u240.addContextProvider(null, function0);
            return this;
        }

        public final void addContextProvider(KType type, Function0<? extends Object> function0) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(function0, "provider");
            this.contextProviders.put(type, function0);
        }

        public final Router build() {
            return new Router(this.interceptors, this.contextProviders);
        }
    }
}