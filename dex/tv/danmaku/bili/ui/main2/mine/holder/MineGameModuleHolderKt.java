package tv.danmaku.bili.ui.main2.mine.holder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: MineGameModuleHolder.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¨\u0006\u0005"}, d2 = {"inflateFrom", "Landroid/view/View;", "", "parent", "Landroid/view/ViewGroup;", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MineGameModuleHolderKt {
    public static final /* synthetic */ View access$inflateFrom(int $receiver, ViewGroup parent) {
        return inflateFrom($receiver, parent);
    }

    public static final View inflateFrom(int $this$inflateFrom, ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate($this$inflateFrom, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }
}