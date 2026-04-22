package base;

import android.content.Context;
import com.bilibili.upper.BR;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LiveBaseGiftController.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H&R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lbase/LiveBaseGiftController;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "onDestroy", "", "giftCommon_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public abstract class LiveBaseGiftController {
    private final Context context;

    public abstract void onDestroy();

    public LiveBaseGiftController(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }
}