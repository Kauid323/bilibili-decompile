package defpackage;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bilibili.bililive.infra.log.LiveLog;
import com.bilibili.bililive.infra.log.LiveLogDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;

/* compiled from: Extension.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0086\bø\u0001\u0000\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {"showFragmentSafely", "", "Landroidx/fragment/app/FragmentActivity;", "tag", "", "fragmentFactory", "Lkotlin/Function0;", "Landroidx/fragment/app/DialogFragment;", "Landroidx/fragment/app/FragmentManager;", "giftCommon_debug"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* renamed from: ExtensionKt  reason: default package */
public final class ExtensionKt {
    public static final void showFragmentSafely(FragmentActivity $this$showFragmentSafely, String tag, Function0<? extends DialogFragment> function0) {
        Intrinsics.checkNotNullParameter($this$showFragmentSafely, "<this>");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(function0, "fragmentFactory");
        Fragment fragment = $this$showFragmentSafely.getSupportFragmentManager().findFragmentByTag(tag);
        if (fragment != null && fragment.isAdded()) {
            return;
        }
        $this$showFragmentSafely.getSupportFragmentManager().beginTransaction().add((Fragment) function0.invoke(), tag).commitAllowingStateLoss();
    }

    public static final void showFragmentSafely(FragmentManager $this$showFragmentSafely, String tag, Function0<? extends DialogFragment> function0) {
        String msg$iv$iv;
        Intrinsics.checkNotNullParameter($this$showFragmentSafely, "<this>");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(function0, "fragmentFactory");
        Fragment fragment = $this$showFragmentSafely.findFragmentByTag(tag);
        if (fragment != null && fragment.isAdded()) {
            LiveLog.Companion $this$iv = LiveLog.Companion;
            if ($this$iv.matchLevel(3)) {
                msg$iv$iv = "showFragmentSafely failed for (fragment != null && fragment.isAdded)";
                msg$iv$iv = msg$iv$iv == null ? "" : "showFragmentSafely failed for (fragment != null && fragment.isAdded)";
                LiveLogDelegate logDelegate = $this$iv.getLogDelegate();
                if (logDelegate != null) {
                    LiveLogDelegate.-CC.onLog$default(logDelegate, 3, "SHOW_FRAGMENT", msg$iv$iv, (Throwable) null, 8, (Object) null);
                }
                BLog.i("SHOW_FRAGMENT", msg$iv$iv);
                return;
            }
            return;
        }
        $this$showFragmentSafely.beginTransaction().add((Fragment) function0.invoke(), tag).commitAllowingStateLoss();
    }
}