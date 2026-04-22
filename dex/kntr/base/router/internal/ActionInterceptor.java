package kntr.base.router.internal;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.router.Interceptor;
import kntr.base.router.Response;
import kntr.base.router.target.FunctionTarget;
import kntr.base.router.target.RouterTarget;
import kntr.base.router.target.RouterTargetKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KTypeProjection;

/* compiled from: ActionInterceptor.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lkntr/base/router/internal/ActionInterceptor;", "Lkntr/base/router/Interceptor;", "<init>", "()V", "intercept", "Lkntr/base/router/Response;", "chain", "Lkntr/base/router/Interceptor$Chain;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ActionInterceptor implements Interceptor {
    public static final ActionInterceptor INSTANCE = new ActionInterceptor();

    private ActionInterceptor() {
    }

    @Override // kntr.base.router.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        RouterTarget target = chain.getTarget();
        FunctionTarget actionTarget = (FunctionTarget) RouterTargetKt.castOrNull(target, Reflection.typeOf(FunctionTarget.class, KTypeProjection.Companion.invariant(Reflection.typeOf(Function0.class, KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class))))));
        if (actionTarget != null) {
            ((Function0) actionTarget.getF()).invoke();
            return Response.Done.INSTANCE;
        }
        return Interceptor.Chain.CC.proceed$default(chain, target, null, 2, null);
    }
}