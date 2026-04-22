package kntr.base.dd.preview;

import androidx.compose.runtime.Composer;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.router.target.FunctionTarget;
import kntr.base.router.target.RouterTarget;
import kntr.base.router.target.RouterTargetContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KTypeProjection;

/* compiled from: __1e400856e658df27b5cf04a3efd9fba2.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"__1e400856e658df27b5cf04a3efd9fba2", "Lkntr/base/router/target/RouterTarget;", "Lkntr/base/router/target/RouterTargetContext;", "preview_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class __1e400856e658df27b5cf04a3efd9fba2Kt {
    public static final RouterTarget __1e400856e658df27b5cf04a3efd9fba2(RouterTargetContext $this$__1e400856e658df27b5cf04a3efd9fba2) {
        Intrinsics.checkNotNullParameter($this$__1e400856e658df27b5cf04a3efd9fba2, "<this>");
        Function2 __f__ = ComposableSingletons$__1e400856e658df27b5cf04a3efd9fba2Kt.INSTANCE.getLambda$1058200015$preview_debug();
        return new FunctionTarget(Reflection.typeOf(Function2.class, new KTypeProjection[]{KTypeProjection.Companion.invariant(Reflection.typeOf(Composer.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Integer.TYPE)), KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class))}), __f__, "kntr.base.dd.preview", null, "DDDebuggerPreview", null);
    }
}