package im.session.common;

import im.session.IMAction;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMSessionPageState.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class IMSessionPageStateKt$sam$im_session_common_IMSessionActionHandler$0 implements IMSessionActionHandler, FunctionAdapter {
    private final /* synthetic */ Function1 function;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IMSessionPageStateKt$sam$im_session_common_IMSessionActionHandler$0(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "function");
        this.function = function1;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof IMSessionActionHandler) && (obj instanceof FunctionAdapter)) {
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
        }
        return false;
    }

    public final Function<?> getFunctionDelegate() {
        return this.function;
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    @Override // im.session.common.IMSessionActionHandler
    public final /* synthetic */ void invoke(IMAction iMAction) {
        this.function.invoke(iMAction);
    }
}