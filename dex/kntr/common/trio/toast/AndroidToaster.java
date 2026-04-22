package kntr.common.trio.toast;

import android.content.Context;
import com.bilibili.droid.ToastHelper;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Toaster.android.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkntr/common/trio/toast/AndroidToaster;", "Lkntr/common/trio/toast/Toaster;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "showToast", "", "message", "", "duration", "Lkntr/common/trio/toast/ToastDuration;", "trio_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AndroidToaster implements Toaster {
    public static final int $stable = 8;
    private final Context context;

    public AndroidToaster(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    @Override // kntr.common.trio.toast.Toaster
    public void showToast(String message, ToastDuration duration) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(duration, "duration");
        ToastHelper.showToast(this.context, message, Toaster_androidKt.access$getAndroidDuration(duration));
    }
}