package leakcanary.internal.tv;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.squareup.leakcanary.core.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TvToast.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lleakcanary/internal/tv/TvToast;", "", "()V", "makeText", "Landroid/widget/Toast;", "activity", "Landroid/app/Activity;", "text", "", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class TvToast {
    public static final TvToast INSTANCE = new TvToast();

    private TvToast() {
    }

    public final Toast makeText(Activity activity, CharSequence text) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Intrinsics.checkParameterIsNotNull(text, "text");
        LayoutInflater inflater = LayoutInflater.from(activity);
        Toast toast = new Toast(activity);
        toast.setGravity(16, 0, 0);
        toast.setDuration(1);
        View it = inflater.inflate(R.layout.leak_canary_heap_dump_toast, (ViewGroup) null);
        View findViewById = it.findViewById(R.id.leak_canary_toast_text);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "it.findViewById<TextView…d.leak_canary_toast_text)");
        ((TextView) findViewById).setText(text);
        Unit unit = Unit.INSTANCE;
        toast.setView(it);
        return toast;
    }
}