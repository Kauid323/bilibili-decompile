package kntr.common.trio.pagecontroller;

import androidx.activity.OnBackPressedCallback;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnBackPressedCallback.android.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a/\u0010\u0000\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u001b\u0010\u0005\u001a\u0017\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\b*\n\u0010\u0000\"\u00020\u00012\u00020\u0001¨\u0006\t"}, d2 = {"OnBackPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "Lkntr/common/trio/pagecontroller/OnBackPressedCallback;", "enabled", "", "onBackPressed", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "trio_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OnBackPressedCallback_androidKt {
    public static final OnBackPressedCallback OnBackPressedCallback(final boolean enabled, final Function1<? super OnBackPressedCallback, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onBackPressed");
        return new OnBackPressedCallback(enabled) { // from class: kntr.common.trio.pagecontroller.OnBackPressedCallback_androidKt$OnBackPressedCallback$1
            public void handleOnBackPressed() {
                function1.invoke(this);
            }
        };
    }
}