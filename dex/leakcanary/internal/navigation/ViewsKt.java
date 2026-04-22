package leakcanary.internal.navigation;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import com.squareup.leakcanary.core.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: Views.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001b\u0010\u0000\u001a\u0002H\u0005\"\b\b\u0000\u0010\u0005*\u00020\u0001*\u00020\u0002H\u0000¢\u0006\u0002\u0010\u0004\u001a\u0014\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\u0007H\u0000\u001a\f\u0010\n\u001a\u00020\u000b*\u00020\u0002H\u0000\u001a\u0014\u0010\f\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0000\u001a\u0014\u0010\u000f\u001a\u00020\u0002*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007H\u0000\u001a\f\u0010\u0012\u001a\u00020\u000b*\u00020\u0002H\u0000\u001a \u0010\u0013\u001a\u00020\u000b*\u00020\u00022\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000b0\u0014H\u0000\u001a\u001a\u0010\u0016\u001a\u00020\u000b*\u00020\u00022\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0018H\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0019"}, d2 = {"activity", "Landroid/app/Activity;", "Landroid/view/View;", "getActivity", "(Landroid/view/View;)Landroid/app/Activity;", "T", "getColorCompat", "", "Landroid/content/Context;", "id", "goBack", "", "goTo", "screen", "Lleakcanary/internal/navigation/Screen;", "inflate", "Landroid/view/ViewGroup;", "layoutResId", "notifyScreenExiting", "onCreateOptionsMenu", "Lkotlin/Function1;", "Landroid/view/Menu;", "onScreenExiting", "block", "Lkotlin/Function0;", "leakcanary-android-core_release"}, k = 2, mv = {1, 4, 1})
public final class ViewsKt {
    public static final View inflate(ViewGroup inflate, int layoutResId) {
        Intrinsics.checkParameterIsNotNull(inflate, "$this$inflate");
        View inflate2 = LayoutInflater.from(inflate.getContext()).inflate(layoutResId, inflate, false);
        if (inflate2 == null) {
            Intrinsics.throwNpe();
        }
        return inflate2;
    }

    public static final Activity getActivity(View activity) {
        Intrinsics.checkParameterIsNotNull(activity, "$this$activity");
        Context context = activity.getContext();
        if (context != null) {
            return (Activity) context;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
    }

    public static final <T extends Activity> T activity(View activity) {
        Intrinsics.checkParameterIsNotNull(activity, "$this$activity");
        Context context = activity.getContext();
        if (context != null) {
            return (T) context;
        }
        throw new TypeCastException("null cannot be cast to non-null type T");
    }

    public static final void onCreateOptionsMenu(View onCreateOptionsMenu, Function1<? super Menu, Unit> onCreateOptionsMenu2) {
        Intrinsics.checkParameterIsNotNull(onCreateOptionsMenu, "$this$onCreateOptionsMenu");
        Intrinsics.checkParameterIsNotNull(onCreateOptionsMenu2, "onCreateOptionsMenu");
        ((NavigatingActivity) activity(onCreateOptionsMenu)).setOnCreateOptionsMenu(onCreateOptionsMenu2);
        getActivity(onCreateOptionsMenu).invalidateOptionsMenu();
    }

    public static final void goTo(View goTo, Screen screen) {
        Intrinsics.checkParameterIsNotNull(goTo, "$this$goTo");
        Intrinsics.checkParameterIsNotNull(screen, "screen");
        ((NavigatingActivity) activity(goTo)).goTo(screen);
    }

    public static final void goBack(View goBack) {
        Intrinsics.checkParameterIsNotNull(goBack, "$this$goBack");
        ((NavigatingActivity) activity(goBack)).goBack();
    }

    public static final int getColorCompat(Context getColorCompat, int id) {
        Intrinsics.checkParameterIsNotNull(getColorCompat, "$this$getColorCompat");
        return getColorCompat.getColor(id);
    }

    public static final void onScreenExiting(View onScreenExiting, Function0<Unit> block) {
        Intrinsics.checkParameterIsNotNull(onScreenExiting, "$this$onScreenExiting");
        Intrinsics.checkParameterIsNotNull(block, "block");
        List callbacks = TypeIntrinsics.asMutableList(onScreenExiting.getTag(R.id.leak_canary_notification_on_screen_exit));
        if (callbacks == null) {
            callbacks = new ArrayList();
            onScreenExiting.setTag(R.id.leak_canary_notification_on_screen_exit, callbacks);
        }
        callbacks.add(block);
    }

    public static final void notifyScreenExiting(View notifyScreenExiting) {
        Intrinsics.checkParameterIsNotNull(notifyScreenExiting, "$this$notifyScreenExiting");
        Iterable callbacks = TypeIntrinsics.asMutableList(notifyScreenExiting.getTag(R.id.leak_canary_notification_on_screen_exit));
        if (callbacks == null) {
            return;
        }
        Iterable $this$forEach$iv = callbacks;
        for (Object element$iv : $this$forEach$iv) {
            Function0 it = (Function0) element$iv;
            it.invoke();
        }
    }
}