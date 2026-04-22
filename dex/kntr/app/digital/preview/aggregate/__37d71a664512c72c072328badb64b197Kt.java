package kntr.app.digital.preview.aggregate;

import kntr.base.router.target.FunctionTarget;
import kntr.base.router.target.ParameterInvalidTarget;
import kntr.base.router.target.RouterTarget;
import kntr.base.router.target.RouterTargetContext;
import kntr.common.komponent.Komponent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KTypeProjection;

/* compiled from: __37d71a664512c72c072328badb64b197.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"__37d71a664512c72c072328badb64b197", "Lkntr/base/router/target/RouterTarget;", "Lkntr/base/router/target/RouterTargetContext;", "preview_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class __37d71a664512c72c072328badb64b197Kt {
    public static final RouterTarget __37d71a664512c72c072328badb64b197(RouterTargetContext $this$__37d71a664512c72c072328badb64b197) {
        Intrinsics.checkNotNullParameter($this$__37d71a664512c72c072328badb64b197, "<this>");
        final Ref.ObjectRef act_id = new Ref.ObjectRef();
        act_id.element = $this$__37d71a664512c72c072328badb64b197.getUriParam("act_id");
        if (act_id.element == null) {
            return new ParameterInvalidTarget("Non-null parameter `act_id` not provided.");
        }
        final Ref.ObjectRef anchor_id = new Ref.ObjectRef();
        anchor_id.element = $this$__37d71a664512c72c072328badb64b197.getUriParam("anchor_id");
        if (anchor_id.element == null) {
            return new ParameterInvalidTarget("Non-null parameter `anchor_id` not provided.");
        }
        final Ref.ObjectRef vmid = new Ref.ObjectRef();
        vmid.element = $this$__37d71a664512c72c072328badb64b197.getUriParam("vmid");
        if (vmid.element == null) {
            return new ParameterInvalidTarget("Non-null parameter `vmid` not provided.");
        }
        final Ref.ObjectRef lottery_id = new Ref.ObjectRef();
        lottery_id.element = $this$__37d71a664512c72c072328badb64b197.getUriParam("lottery_id");
        if (lottery_id.element == null) {
            return new ParameterInvalidTarget("Non-null parameter `lottery_id` not provided.");
        }
        final Ref.ObjectRef f_source = new Ref.ObjectRef();
        f_source.element = $this$__37d71a664512c72c072328badb64b197.getUriParam("f_source");
        final Ref.ObjectRef from = new Ref.ObjectRef();
        from.element = $this$__37d71a664512c72c072328badb64b197.getUriParam("from");
        final Ref.ObjectRef from_id = new Ref.ObjectRef();
        from_id.element = $this$__37d71a664512c72c072328badb64b197.getUriParam("from_id");
        final Ref.ObjectRef owned_status = new Ref.ObjectRef();
        owned_status.element = $this$__37d71a664512c72c072328badb64b197.getUriParam("owned_status");
        final Ref.ObjectRef simple_card = new Ref.ObjectRef();
        simple_card.element = $this$__37d71a664512c72c072328badb64b197.getUriParam("simple_card");
        Function0 __f__ = new Function0() { // from class: kntr.app.digital.preview.aggregate.__37d71a664512c72c072328badb64b197Kt$$ExternalSyntheticLambda0
            public final Object invoke() {
                Komponent __37d71a664512c72c072328badb64b197$lambda$0;
                __37d71a664512c72c072328badb64b197$lambda$0 = __37d71a664512c72c072328badb64b197Kt.__37d71a664512c72c072328badb64b197$lambda$0(act_id, anchor_id, vmid, lottery_id, f_source, from, from_id, owned_status, simple_card);
                return __37d71a664512c72c072328badb64b197$lambda$0;
            }
        };
        return new FunctionTarget(Reflection.typeOf(Function0.class, KTypeProjection.Companion.invariant(Reflection.typeOf(Komponent.class, KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class))))), __f__, "kntr.app.digital.preview.aggregate", (KClass) null, "cardPreviewEntrance", (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Komponent __37d71a664512c72c072328badb64b197$lambda$0(Ref.ObjectRef $act_id, Ref.ObjectRef $anchor_id, Ref.ObjectRef $vmid, Ref.ObjectRef $lottery_id, Ref.ObjectRef $f_source, Ref.ObjectRef $from, Ref.ObjectRef $from_id, Ref.ObjectRef $owned_status, Ref.ObjectRef $simple_card) {
        return CardPreviewEntranceKt.cardPreviewEntrance((String) $act_id.element, (String) $anchor_id.element, (String) $vmid.element, (String) $lottery_id.element, (String) $f_source.element, (String) $from.element, (String) $from_id.element, (String) $owned_status.element, (String) $simple_card.element);
    }
}