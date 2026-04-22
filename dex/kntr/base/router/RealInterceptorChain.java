package kntr.base.router;

import com.bilibili.lib.brouter.uri.Uri;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.router.Interceptor;
import kntr.base.router.Response;
import kntr.base.router.target.ContextMissingTarget;
import kntr.base.router.target.RouterTarget;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;

/* compiled from: RealInterceptorChain.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001BK\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$H\u0016J\u0012\u0010%\u001a\u0004\u0018\u00010\u000f2\u0006\u0010&\u001a\u00020\u000fH\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001f\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006'"}, d2 = {"Lkntr/base/router/RealInterceptorChain;", "Lkntr/base/router/Interceptor$Chain;", "interceptors", "", "Lkntr/base/router/Interceptor;", "index", "", "router", "Lkntr/base/router/Router;", "target", "Lkntr/base/router/target/RouterTarget;", "uri", "Lcom/bilibili/lib/brouter/uri/Uri;", "uriParamGetter", "Lkotlin/Function1;", "", "<init>", "(Ljava/util/List;ILkntr/base/router/Router;Lkntr/base/router/target/RouterTarget;Lcom/bilibili/lib/brouter/uri/Uri;Lkotlin/jvm/functions/Function1;)V", "getInterceptors", "()Ljava/util/List;", "getIndex", "()I", "getRouter", "()Lkntr/base/router/Router;", "getTarget", "()Lkntr/base/router/target/RouterTarget;", "getUri", "()Lcom/bilibili/lib/brouter/uri/Uri;", "getUriParamGetter", "()Lkotlin/jvm/functions/Function1;", "find", "proceed", "Lkntr/base/router/Response;", "contextUnsafe", "", "type", "Lkotlin/reflect/KType;", "getUriParam", "key", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class RealInterceptorChain implements Interceptor.Chain {
    private final int index;
    private final List<Interceptor> interceptors;
    private final Router router;
    private final RouterTarget target;
    private final Uri uri;
    private final Function1<String, String> uriParamGetter;

    /* JADX WARN: Multi-variable type inference failed */
    public RealInterceptorChain(List<? extends Interceptor> list, int index, Router router, RouterTarget target, Uri uri, Function1<? super String, String> function1) {
        Intrinsics.checkNotNullParameter(list, "interceptors");
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(function1, "uriParamGetter");
        this.interceptors = list;
        this.index = index;
        this.router = router;
        this.target = target;
        this.uri = uri;
        this.uriParamGetter = function1;
    }

    public final List<Interceptor> getInterceptors() {
        return this.interceptors;
    }

    public final int getIndex() {
        return this.index;
    }

    public final Router getRouter() {
        return this.router;
    }

    @Override // kntr.base.router.Interceptor.Chain
    public RouterTarget getTarget() {
        return this.target;
    }

    @Override // kntr.base.router.Interceptor.Chain
    public Uri getUri() {
        return this.uri;
    }

    public final Function1<String, String> getUriParamGetter() {
        return this.uriParamGetter;
    }

    @Override // kntr.base.router.Interceptor.Chain
    public RouterTarget find(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return this.router.find(uri);
    }

    @Override // kntr.base.router.Interceptor.Chain
    public Response proceed(RouterTarget target, Uri uri) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(uri, "uri");
        if (this.index >= this.interceptors.size()) {
            if (target instanceof ContextMissingTarget) {
                return new Response.ContextMissing(target);
            }
            return new Response.NotIntercepted(target);
        }
        RealInterceptorChain next = new RealInterceptorChain(this.interceptors, this.index + 1, this.router, target, uri, this.uriParamGetter);
        Interceptor interceptor = this.interceptors.get(this.index);
        return interceptor.intercept(next);
    }

    @Override // kntr.base.router.Interceptor.Chain
    public Object contextUnsafe(KType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        Function0<Object> function0 = this.router.getContextProviders$core_debug().get(type);
        if (function0 != null) {
            return function0.invoke();
        }
        return null;
    }

    @Override // kntr.base.router.Interceptor.Chain
    public String getUriParam(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (String) this.uriParamGetter.invoke(key);
    }
}