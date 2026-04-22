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

/* compiled from: __ab581fc3eb721eb12d69396664d38b65.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"__ab581fc3eb721eb12d69396664d38b65", "Lkntr/base/router/target/RouterTarget;", "Lkntr/base/router/target/RouterTargetContext;", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class __ab581fc3eb721eb12d69396664d38b65Kt {
    public static final RouterTarget __ab581fc3eb721eb12d69396664d38b65(RouterTargetContext $this$__ab581fc3eb721eb12d69396664d38b65) {
        Intrinsics.checkNotNullParameter($this$__ab581fc3eb721eb12d69396664d38b65, "<this>");
        final Ref.ObjectRef userIdStr = new Ref.ObjectRef();
        userIdStr.element = $this$__ab581fc3eb721eb12d69396664d38b65.getUriParam("userIdStr");
        if (userIdStr.element == null) {
            return new ParameterInvalidTarget("Non-null parameter `userIdStr` not provided.");
        }
        final Ref.ObjectRef eventFrom = new Ref.ObjectRef();
        eventFrom.element = $this$__ab581fc3eb721eb12d69396664d38b65.getUriParam("source_event");
        final Ref.ObjectRef msgNewBadge = new Ref.ObjectRef();
        msgNewBadge.element = $this$__ab581fc3eb721eb12d69396664d38b65.getUriParam("msg_new");
        Function0 __f__ = new Function0() { // from class: kntr.app.im.chat.ui.__ab581fc3eb721eb12d69396664d38b65Kt$$ExternalSyntheticLambda0
            public final Object invoke() {
                Komponent __ab581fc3eb721eb12d69396664d38b65$lambda$0;
                __ab581fc3eb721eb12d69396664d38b65$lambda$0 = __ab581fc3eb721eb12d69396664d38b65Kt.__ab581fc3eb721eb12d69396664d38b65$lambda$0(userIdStr, eventFrom, msgNewBadge);
                return __ab581fc3eb721eb12d69396664d38b65$lambda$0;
            }
        };
        return new FunctionTarget(Reflection.typeOf(Function0.class, KTypeProjection.Companion.invariant(Reflection.typeOf(Komponent.class, KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class))))), __f__, "kntr.app.im.chat.ui", (KClass) null, "IMPersonalChatPage", (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Komponent __ab581fc3eb721eb12d69396664d38b65$lambda$0(Ref.ObjectRef $userIdStr, Ref.ObjectRef $eventFrom, Ref.ObjectRef $msgNewBadge) {
        return IMPersonalChatPageKt.IMPersonalChatPage((String) $userIdStr.element, (String) $eventFrom.element, (String) $msgNewBadge.element);
    }
}