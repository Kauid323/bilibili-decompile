package im.base.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NameRenderHolder.android.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0004"}, d2 = {"buildNameRender", "Lim/base/model/NameRenderHolder;", "byteArray", "", "base_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class NameRenderHolder_androidKt {
    public static final NameRenderHolder buildNameRender(byte[] byteArray) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        return new NameRenderHolder(NameRenderHolderKt.deserializeNameRender(byteArray), byteArray);
    }
}