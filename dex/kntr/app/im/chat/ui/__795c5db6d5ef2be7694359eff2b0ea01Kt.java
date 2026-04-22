package kntr.app.im.chat.ui;

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

/* compiled from: __795c5db6d5ef2be7694359eff2b0ea01.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"__795c5db6d5ef2be7694359eff2b0ea01", "Lkntr/base/router/target/RouterTarget;", "Lkntr/base/router/target/RouterTargetContext;", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class __795c5db6d5ef2be7694359eff2b0ea01Kt {
    public static final RouterTarget __795c5db6d5ef2be7694359eff2b0ea01(RouterTargetContext $this$__795c5db6d5ef2be7694359eff2b0ea01) {
        Intrinsics.checkNotNullParameter($this$__795c5db6d5ef2be7694359eff2b0ea01, "<this>");
        final Ref.ObjectRef assistantTypeStr = new Ref.ObjectRef();
        assistantTypeStr.element = $this$__795c5db6d5ef2be7694359eff2b0ea01.getUriParam("assistantTypeStr");
        if (assistantTypeStr.element == null) {
            return new ParameterInvalidTarget("Non-null parameter `assistantTypeStr` not provided.");
        }
        final Ref.ObjectRef assistantIdStr = new Ref.ObjectRef();
        assistantIdStr.element = $this$__795c5db6d5ef2be7694359eff2b0ea01.getUriParam("assistantIdStr");
        if (assistantIdStr.element == null) {
            return new ParameterInvalidTarget("Non-null parameter `assistantIdStr` not provided.");
        }
        final Ref.ObjectRef eventFrom = new Ref.ObjectRef();
        eventFrom.element = $this$__795c5db6d5ef2be7694359eff2b0ea01.getUriParam("source_event");
        final Ref.ObjectRef msgNewBadge = new Ref.ObjectRef();
        msgNewBadge.element = $this$__795c5db6d5ef2be7694359eff2b0ea01.getUriParam("msg_new");
        Function0 __f__ = new Function0() { // from class: kntr.app.im.chat.ui.__795c5db6d5ef2be7694359eff2b0ea01Kt$$ExternalSyntheticLambda0
            public final Object invoke() {
                Komponent __795c5db6d5ef2be7694359eff2b0ea01$lambda$0;
                __795c5db6d5ef2be7694359eff2b0ea01$lambda$0 = __795c5db6d5ef2be7694359eff2b0ea01Kt.__795c5db6d5ef2be7694359eff2b0ea01$lambda$0(assistantTypeStr, assistantIdStr, eventFrom, msgNewBadge);
                return __795c5db6d5ef2be7694359eff2b0ea01$lambda$0;
            }
        };
        return new FunctionTarget(Reflection.typeOf(Function0.class, KTypeProjection.Companion.invariant(Reflection.typeOf(Komponent.class, KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class))))), __f__, "kntr.app.im.chat.ui", (KClass) null, "IMAssistantChatPage", (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Komponent __795c5db6d5ef2be7694359eff2b0ea01$lambda$0(Ref.ObjectRef $assistantTypeStr, Ref.ObjectRef $assistantIdStr, Ref.ObjectRef $eventFrom, Ref.ObjectRef $msgNewBadge) {
        return IMAssistantChatPageKt.IMAssistantChatPage((String) $assistantTypeStr.element, (String) $assistantIdStr.element, (String) $eventFrom.element, (String) $msgNewBadge.element);
    }
}