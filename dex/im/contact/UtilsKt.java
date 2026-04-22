package im.contact;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0003"}, d2 = {"TAG", "", "subTag", "contact_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class UtilsKt {
    public static final String TAG = "IMContact";

    public static final String TAG(String subTag) {
        Intrinsics.checkNotNullParameter(subTag, "subTag");
        return "IMContact-" + subTag;
    }
}