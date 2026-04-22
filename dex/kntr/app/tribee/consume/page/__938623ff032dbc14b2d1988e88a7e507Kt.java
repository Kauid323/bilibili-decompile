package kntr.app.tribee.consume.page;

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

/* compiled from: __938623ff032dbc14b2d1988e88a7e507.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"__938623ff032dbc14b2d1988e88a7e507", "Lkntr/base/router/target/RouterTarget;", "Lkntr/base/router/target/RouterTargetContext;", "consume_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class __938623ff032dbc14b2d1988e88a7e507Kt {
    public static final RouterTarget __938623ff032dbc14b2d1988e88a7e507(RouterTargetContext $this$__938623ff032dbc14b2d1988e88a7e507) {
        Intrinsics.checkNotNullParameter($this$__938623ff032dbc14b2d1988e88a7e507, "<this>");
        final Ref.ObjectRef id = new Ref.ObjectRef();
        id.element = $this$__938623ff032dbc14b2d1988e88a7e507.getUriParam("id");
        final Ref.ObjectRef fromSpmid = new Ref.ObjectRef();
        fromSpmid.element = $this$__938623ff032dbc14b2d1988e88a7e507.getUriParam("from_spmid");
        final Ref.ObjectRef tribeeId = new Ref.ObjectRef();
        tribeeId.element = $this$__938623ff032dbc14b2d1988e88a7e507.getUriParam("tribee_id");
        final Ref.ObjectRef inviteCode = new Ref.ObjectRef();
        inviteCode.element = $this$__938623ff032dbc14b2d1988e88a7e507.getUriParam("invite_code");
        final Ref.ObjectRef categoryIdFromRouter = new Ref.ObjectRef();
        categoryIdFromRouter.element = $this$__938623ff032dbc14b2d1988e88a7e507.getUriParam("category_id");
        final Ref.ObjectRef fakeCardResultKeyFromRouter = new Ref.ObjectRef();
        fakeCardResultKeyFromRouter.element = $this$__938623ff032dbc14b2d1988e88a7e507.getUriParam("fake_card_result_key");
        final Ref.ObjectRef insertFakeCardToastFromRouter = new Ref.ObjectRef();
        insertFakeCardToastFromRouter.element = $this$__938623ff032dbc14b2d1988e88a7e507.getUriParam("insert_fake_card_toast");
        Function2 __f__ = ComposableLambdaKt.composableLambdaInstance(1016577787, true, new Function2() { // from class: kntr.app.tribee.consume.page.__938623ff032dbc14b2d1988e88a7e507Kt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2) {
                Unit __938623ff032dbc14b2d1988e88a7e507$lambda$0;
                __938623ff032dbc14b2d1988e88a7e507$lambda$0 = __938623ff032dbc14b2d1988e88a7e507Kt.__938623ff032dbc14b2d1988e88a7e507$lambda$0(id, fromSpmid, tribeeId, inviteCode, categoryIdFromRouter, fakeCardResultKeyFromRouter, insertFakeCardToastFromRouter, (Composer) obj, ((Integer) obj2).intValue());
                return __938623ff032dbc14b2d1988e88a7e507$lambda$0;
            }
        });
        return new FunctionTarget(Reflection.typeOf(Function2.class, new KTypeProjection[]{KTypeProjection.Companion.invariant(Reflection.typeOf(Composer.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Integer.TYPE)), KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class))}), __f__, "kntr.app.tribee.consume.page", null, "TribeeHomePage", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit __938623ff032dbc14b2d1988e88a7e507$lambda$0(Ref.ObjectRef $id, Ref.ObjectRef $fromSpmid, Ref.ObjectRef $tribeeId, Ref.ObjectRef $inviteCode, Ref.ObjectRef $categoryIdFromRouter, Ref.ObjectRef $fakeCardResultKeyFromRouter, Ref.ObjectRef $insertFakeCardToastFromRouter, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C17@745L308:__938623ff032dbc14b2d1988e88a7e507.kt#iitu82");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1016577787, $changed, -1, "kntr.app.tribee.consume.page.__938623ff032dbc14b2d1988e88a7e507.<anonymous> (__938623ff032dbc14b2d1988e88a7e507.kt:17)");
            }
            TribeeHomePageKt.TribeeHomePage((String) $id.element, (String) $fromSpmid.element, (String) $tribeeId.element, (String) $inviteCode.element, (String) $categoryIdFromRouter.element, (String) $fakeCardResultKeyFromRouter.element, (String) $insertFakeCardToastFromRouter.element, $composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}