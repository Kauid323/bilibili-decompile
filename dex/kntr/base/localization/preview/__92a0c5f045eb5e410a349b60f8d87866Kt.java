package kntr.base.localization.preview;

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

/* compiled from: __92a0c5f045eb5e410a349b60f8d87866.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"__92a0c5f045eb5e410a349b60f8d87866", "Lkntr/base/router/target/RouterTarget;", "Lkntr/base/router/target/RouterTargetContext;", "preview_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class __92a0c5f045eb5e410a349b60f8d87866Kt {
    public static final RouterTarget __92a0c5f045eb5e410a349b60f8d87866(RouterTargetContext $this$__92a0c5f045eb5e410a349b60f8d87866) {
        Intrinsics.checkNotNullParameter($this$__92a0c5f045eb5e410a349b60f8d87866, "<this>");
        Function2 __f__ = ComposableSingletons$__92a0c5f045eb5e410a349b60f8d87866Kt.INSTANCE.getLambda$544705878$preview_debug();
        return new FunctionTarget(Reflection.typeOf(Function2.class, new KTypeProjection[]{KTypeProjection.Companion.invariant(Reflection.typeOf(Composer.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Integer.TYPE)), KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class))}), __f__, "kntr.base.localization.preview", null, "LocalizationPreview", null);
    }
}