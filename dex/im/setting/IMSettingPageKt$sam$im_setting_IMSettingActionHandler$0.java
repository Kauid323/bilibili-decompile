package im.setting;

import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMSettingPage.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final class IMSettingPageKt$sam$im_setting_IMSettingActionHandler$0 implements IMSettingActionHandler, FunctionAdapter {
    private final /* synthetic */ Function1 function;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IMSettingPageKt$sam$im_setting_IMSettingActionHandler$0(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "function");
        this.function = function1;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof IMSettingActionHandler) && (obj instanceof FunctionAdapter)) {
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

    @Override // im.setting.IMSettingActionHandler
    public final /* synthetic */ void invoke(IMSettingAction iMSettingAction) {
        this.function.invoke(iMSettingAction);
    }
}