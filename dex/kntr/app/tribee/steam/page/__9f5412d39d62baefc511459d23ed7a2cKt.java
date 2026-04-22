package kntr.app.tribee.steam.page;

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

/* compiled from: __9f5412d39d62baefc511459d23ed7a2c.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"__9f5412d39d62baefc511459d23ed7a2c", "Lkntr/base/router/target/RouterTarget;", "Lkntr/base/router/target/RouterTargetContext;", "consume_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class __9f5412d39d62baefc511459d23ed7a2cKt {
    public static final RouterTarget __9f5412d39d62baefc511459d23ed7a2c(RouterTargetContext $this$__9f5412d39d62baefc511459d23ed7a2c) {
        Intrinsics.checkNotNullParameter($this$__9f5412d39d62baefc511459d23ed7a2c, "<this>");
        final Ref.ObjectRef fromSpmid = new Ref.ObjectRef();
        fromSpmid.element = $this$__9f5412d39d62baefc511459d23ed7a2c.getUriParam("from_spmid");
        final Ref.ObjectRef hostId = new Ref.ObjectRef();
        hostId.element = $this$__9f5412d39d62baefc511459d23ed7a2c.getUriParam("host_mid");
        final Ref.ObjectRef tribeeId = new Ref.ObjectRef();
        tribeeId.element = $this$__9f5412d39d62baefc511459d23ed7a2c.getUriParam("tribee_id");
        final Ref.ObjectRef selectedGameId = new Ref.ObjectRef();
        selectedGameId.element = $this$__9f5412d39d62baefc511459d23ed7a2c.getUriParam("selected_game_id");
        final Ref.ObjectRef signature = new Ref.ObjectRef();
        signature.element = $this$__9f5412d39d62baefc511459d23ed7a2c.getUriParam("sig");
        Function2 __f__ = ComposableLambdaKt.composableLambdaInstance(134835087, true, new Function2() { // from class: kntr.app.tribee.steam.page.__9f5412d39d62baefc511459d23ed7a2cKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2) {
                Unit __9f5412d39d62baefc511459d23ed7a2c$lambda$0;
                __9f5412d39d62baefc511459d23ed7a2c$lambda$0 = __9f5412d39d62baefc511459d23ed7a2cKt.__9f5412d39d62baefc511459d23ed7a2c$lambda$0(fromSpmid, hostId, tribeeId, selectedGameId, signature, (Composer) obj, ((Integer) obj2).intValue());
                return __9f5412d39d62baefc511459d23ed7a2c$lambda$0;
            }
        });
        return new FunctionTarget(Reflection.typeOf(Function2.class, new KTypeProjection[]{KTypeProjection.Companion.invariant(Reflection.typeOf(Composer.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Integer.TYPE)), KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class))}), __f__, "kntr.app.tribee.steam.page", null, "TribeeWithSteamPage", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit __9f5412d39d62baefc511459d23ed7a2c$lambda$0(Ref.ObjectRef $fromSpmid, Ref.ObjectRef $hostId, Ref.ObjectRef $tribeeId, Ref.ObjectRef $selectedGameId, Ref.ObjectRef $signature, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C15@595L173:__9f5412d39d62baefc511459d23ed7a2c.kt#k3l5ii");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(134835087, $changed, -1, "kntr.app.tribee.steam.page.__9f5412d39d62baefc511459d23ed7a2c.<anonymous> (__9f5412d39d62baefc511459d23ed7a2c.kt:15)");
            }
            TribeeWithSteamPageKt.TribeeWithSteamPage((String) $fromSpmid.element, (String) $hostId.element, (String) $tribeeId.element, (String) $selectedGameId.element, (String) $signature.element, $composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}