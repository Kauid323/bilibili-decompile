package kntr.app.tribee.invite.page;

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

/* compiled from: __fee9c29d904de6d332341fe4340c7fd6.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"__fee9c29d904de6d332341fe4340c7fd6", "Lkntr/base/router/target/RouterTarget;", "Lkntr/base/router/target/RouterTargetContext;", "consume_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class __fee9c29d904de6d332341fe4340c7fd6Kt {
    public static final RouterTarget __fee9c29d904de6d332341fe4340c7fd6(RouterTargetContext $this$__fee9c29d904de6d332341fe4340c7fd6) {
        Intrinsics.checkNotNullParameter($this$__fee9c29d904de6d332341fe4340c7fd6, "<this>");
        final Ref.ObjectRef fromTribeeId = new Ref.ObjectRef();
        fromTribeeId.element = $this$__fee9c29d904de6d332341fe4340c7fd6.getUriParam("from_tribee_id");
        final Ref.ObjectRef fromSpmid = new Ref.ObjectRef();
        fromSpmid.element = $this$__fee9c29d904de6d332341fe4340c7fd6.getUriParam("from_spmid");
        Function2 __f__ = ComposableLambdaKt.composableLambdaInstance(-215862336, true, new Function2() { // from class: kntr.app.tribee.invite.page.__fee9c29d904de6d332341fe4340c7fd6Kt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2) {
                Unit __fee9c29d904de6d332341fe4340c7fd6$lambda$0;
                __fee9c29d904de6d332341fe4340c7fd6$lambda$0 = __fee9c29d904de6d332341fe4340c7fd6Kt.__fee9c29d904de6d332341fe4340c7fd6$lambda$0(fromTribeeId, fromSpmid, (Composer) obj, ((Integer) obj2).intValue());
                return __fee9c29d904de6d332341fe4340c7fd6$lambda$0;
            }
        });
        return new FunctionTarget(Reflection.typeOf(Function2.class, new KTypeProjection[]{KTypeProjection.Companion.invariant(Reflection.typeOf(Composer.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Integer.TYPE)), KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class))}), __f__, "kntr.app.tribee.invite.page", null, "TribeeInvitePage", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit __fee9c29d904de6d332341fe4340c7fd6$lambda$0(Ref.ObjectRef $fromTribeeId, Ref.ObjectRef $fromSpmid, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C12@474L87:__fee9c29d904de6d332341fe4340c7fd6.kt#8mvn07");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-215862336, $changed, -1, "kntr.app.tribee.invite.page.__fee9c29d904de6d332341fe4340c7fd6.<anonymous> (__fee9c29d904de6d332341fe4340c7fd6.kt:12)");
            }
            TribeeInvitePageKt.TribeeInvitePage((String) $fromTribeeId.element, (String) $fromSpmid.element, $composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}