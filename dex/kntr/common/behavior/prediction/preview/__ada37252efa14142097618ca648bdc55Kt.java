package kntr.common.behavior.prediction.preview;

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

/* compiled from: __ada37252efa14142097618ca648bdc55.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"__ada37252efa14142097618ca648bdc55", "Lkntr/base/router/target/RouterTarget;", "Lkntr/base/router/target/RouterTargetContext;", "preview_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class __ada37252efa14142097618ca648bdc55Kt {
    public static final RouterTarget __ada37252efa14142097618ca648bdc55(RouterTargetContext $this$__ada37252efa14142097618ca648bdc55) {
        Intrinsics.checkNotNullParameter($this$__ada37252efa14142097618ca648bdc55, "<this>");
        Function2 __f__ = ComposableSingletons$__ada37252efa14142097618ca648bdc55Kt.INSTANCE.getLambda$1185962824$preview_debug();
        return new FunctionTarget(Reflection.typeOf(Function2.class, new KTypeProjection[]{KTypeProjection.Companion.invariant(Reflection.typeOf(Composer.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Integer.TYPE)), KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class))}), __f__, "kntr.common.behavior.prediction.preview", null, "BPVideoQualityPreview", null);
    }
}