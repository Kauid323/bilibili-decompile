package kntr.base.net;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.GInterceptor;
import kntr.base.net.tags.GInterceptorEnable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: Init.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lkntr/base/net/GInterceptorEnableInterceptor;", "Lkntr/base/net/GInterceptor;", "delegate", "<init>", "(Lkntr/base/net/GInterceptor;)V", "name", "", "getName", "()Ljava/lang/String;", "phase", "Lkntr/base/net/PHASE;", "getPhase", "()Lkntr/base/net/PHASE;", "intercept", "", "chain", "Lkntr/base/net/GInterceptor$Chain;", "pre", "Lkntr/base/net/ResponseCallBack;", "net_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class GInterceptorEnableInterceptor implements GInterceptor {
    private final GInterceptor delegate;

    public GInterceptorEnableInterceptor(GInterceptor delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // kntr.base.net.GInterceptor
    public String getName() {
        return this.delegate.getName() + "_proxy";
    }

    @Override // kntr.base.net.GInterceptor
    public PHASE getPhase() {
        return this.delegate.getPhase();
    }

    @Override // kntr.base.net.GInterceptor
    public void intercept(GInterceptor.Chain chain, ResponseCallBack pre) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Intrinsics.checkNotNullParameter(pre, "pre");
        GInterceptorEnable tag = (GInterceptorEnable) chain.getRequest().tag(Reflection.getOrCreateKotlinClass(GInterceptorEnable.class));
        boolean enable = tag != null && tag.getEnable();
        if (enable) {
            this.delegate.intercept(chain, pre);
        } else {
            chain.proceed(chain.getRequest(), pre);
        }
    }
}