package im.contact;

import im.contact.model.IMContactAction;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMContactPage.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final /* synthetic */ class IMContactPageKt$IMContactPage$state$1$1 implements IMContactActionHandler, FunctionAdapter {
    final /* synthetic */ IMContactViewModel $tmp0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IMContactPageKt$IMContactPage$state$1$1(IMContactViewModel iMContactViewModel) {
        this.$tmp0 = iMContactViewModel;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof IMContactActionHandler) && (obj instanceof FunctionAdapter)) {
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
        }
        return false;
    }

    public final Function<?> getFunctionDelegate() {
        return new FunctionReferenceImpl<>(1, this.$tmp0, IMContactViewModel.class, "dispatchAction", "dispatchAction(Lim/contact/model/IMContactAction;)V", 0);
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    @Override // im.contact.IMContactActionHandler
    public final void invoke(IMContactAction p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        this.$tmp0.dispatchAction(p0);
    }
}