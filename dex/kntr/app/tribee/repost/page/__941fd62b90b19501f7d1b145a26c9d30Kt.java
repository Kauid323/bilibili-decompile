package kntr.app.tribee.repost.page;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.router.target.FunctionTarget;
import kntr.base.router.target.RouterTarget;
import kntr.base.router.target.RouterTargetContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KTypeProjection;

/* compiled from: __941fd62b90b19501f7d1b145a26c9d30.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"__941fd62b90b19501f7d1b145a26c9d30", "Lkntr/base/router/target/RouterTarget;", "Lkntr/base/router/target/RouterTargetContext;", "repost_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class __941fd62b90b19501f7d1b145a26c9d30Kt {
    public static final RouterTarget __941fd62b90b19501f7d1b145a26c9d30(RouterTargetContext $this$__941fd62b90b19501f7d1b145a26c9d30) {
        Intrinsics.checkNotNullParameter($this$__941fd62b90b19501f7d1b145a26c9d30, "<this>");
        final Ref.ObjectRef originDynamicId = new Ref.ObjectRef();
        originDynamicId.element = $this$__941fd62b90b19501f7d1b145a26c9d30.getUriParam("origin_dynamic_id");
        final Ref.ObjectRef fromSpmid = new Ref.ObjectRef();
        fromSpmid.element = $this$__941fd62b90b19501f7d1b145a26c9d30.getUriParam("from_spmid");
        Function2 __f__ = ComposableLambdaKt.composableLambdaInstance(696988562, true, new Function2() { // from class: kntr.app.tribee.repost.page.__941fd62b90b19501f7d1b145a26c9d30Kt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2) {
                Unit __941fd62b90b19501f7d1b145a26c9d30$lambda$0;
                __941fd62b90b19501f7d1b145a26c9d30$lambda$0 = __941fd62b90b19501f7d1b145a26c9d30Kt.__941fd62b90b19501f7d1b145a26c9d30$lambda$0(originDynamicId, fromSpmid, (Composer) obj, ((Integer) obj2).intValue());
                return __941fd62b90b19501f7d1b145a26c9d30$lambda$0;
            }
        });
        return new FunctionTarget(Reflection.typeOf(Function2.class, new KTypeProjection[]{KTypeProjection.Companion.invariant(Reflection.typeOf(Composer.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Integer.TYPE)), KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class))}), __f__, "kntr.app.tribee.repost.page", null, "TribeeRepostPage", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit __941fd62b90b19501f7d1b145a26c9d30$lambda$0(Ref.ObjectRef $originDynamicId, Ref.ObjectRef $fromSpmid, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C12@480L93:__941fd62b90b19501f7d1b145a26c9d30.kt#qxdvwz");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(696988562, $changed, -1, "kntr.app.tribee.repost.page.__941fd62b90b19501f7d1b145a26c9d30.<anonymous> (__941fd62b90b19501f7d1b145a26c9d30.kt:12)");
            }
            TribeeRepostPageKt.TribeeRepostPage((String) $originDynamicId.element, (String) $fromSpmid.element, $composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}