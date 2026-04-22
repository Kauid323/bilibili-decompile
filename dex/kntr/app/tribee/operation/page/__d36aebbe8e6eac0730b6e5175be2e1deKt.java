package kntr.app.tribee.operation.page;

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

/* compiled from: __d36aebbe8e6eac0730b6e5175be2e1de.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"__d36aebbe8e6eac0730b6e5175be2e1de", "Lkntr/base/router/target/RouterTarget;", "Lkntr/base/router/target/RouterTargetContext;", "operation_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class __d36aebbe8e6eac0730b6e5175be2e1deKt {
    public static final RouterTarget __d36aebbe8e6eac0730b6e5175be2e1de(RouterTargetContext $this$__d36aebbe8e6eac0730b6e5175be2e1de) {
        Intrinsics.checkNotNullParameter($this$__d36aebbe8e6eac0730b6e5175be2e1de, "<this>");
        final Ref.ObjectRef inviteeMid = new Ref.ObjectRef();
        inviteeMid.element = $this$__d36aebbe8e6eac0730b6e5175be2e1de.getUriParam("invitee_mid");
        final Ref.ObjectRef opusTribeeId = new Ref.ObjectRef();
        opusTribeeId.element = $this$__d36aebbe8e6eac0730b6e5175be2e1de.getUriParam("opus_tribee_id");
        Function2 __f__ = ComposableLambdaKt.composableLambdaInstance(-805729530, true, new Function2() { // from class: kntr.app.tribee.operation.page.__d36aebbe8e6eac0730b6e5175be2e1deKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2) {
                Unit __d36aebbe8e6eac0730b6e5175be2e1de$lambda$0;
                __d36aebbe8e6eac0730b6e5175be2e1de$lambda$0 = __d36aebbe8e6eac0730b6e5175be2e1deKt.__d36aebbe8e6eac0730b6e5175be2e1de$lambda$0(inviteeMid, opusTribeeId, (Composer) obj, ((Integer) obj2).intValue());
                return __d36aebbe8e6eac0730b6e5175be2e1de$lambda$0;
            }
        });
        return new FunctionTarget(Reflection.typeOf(Function2.class, new KTypeProjection[]{KTypeProjection.Companion.invariant(Reflection.typeOf(Composer.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Integer.TYPE)), KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class))}), __f__, "kntr.app.tribee.operation.page", null, "TribeeInvitationManagerPage", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit __d36aebbe8e6eac0730b6e5175be2e1de$lambda$0(Ref.ObjectRef $inviteeMid, Ref.ObjectRef $opusTribeeId, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C12@479L100:__d36aebbe8e6eac0730b6e5175be2e1de.kt#4gfcoj");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-805729530, $changed, -1, "kntr.app.tribee.operation.page.__d36aebbe8e6eac0730b6e5175be2e1de.<anonymous> (__d36aebbe8e6eac0730b6e5175be2e1de.kt:12)");
            }
            InvitationManagerPageKt.TribeeInvitationManagerPage((String) $inviteeMid.element, (String) $opusTribeeId.element, $composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}