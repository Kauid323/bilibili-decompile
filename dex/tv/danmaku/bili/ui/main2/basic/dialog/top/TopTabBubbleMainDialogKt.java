package tv.danmaku.bili.ui.main2.basic.dialog.top;

import android.content.Context;
import com.bilibili.app.dialogmanager.MainDialogManager;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: TopTabBubbleMainDialog.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u001a\b\u0010\f\u001a\u00020\rH\u0000\"\"\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006\"\u001a\u0010\u0007\u001a\u00020\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"mMainDialog", "Ljava/lang/ref/WeakReference;", "Ltv/danmaku/bili/ui/main2/basic/dialog/top/TopTabBubbleMainDialog;", "getMMainDialog", "()Ljava/lang/ref/WeakReference;", "setMMainDialog", "(Ljava/lang/ref/WeakReference;)V", "isDialogAdded", "", "()Z", "setDialogAdded", "(Z)V", "showNextDialog", "", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class TopTabBubbleMainDialogKt {
    private static boolean isDialogAdded;
    private static WeakReference<TopTabBubbleMainDialog> mMainDialog;

    public static final WeakReference<TopTabBubbleMainDialog> getMMainDialog() {
        return mMainDialog;
    }

    public static final void setMMainDialog(WeakReference<TopTabBubbleMainDialog> weakReference) {
        mMainDialog = weakReference;
    }

    public static final boolean isDialogAdded() {
        return isDialogAdded;
    }

    public static final void setDialogAdded(boolean z) {
        isDialogAdded = z;
    }

    public static final void showNextDialog() {
        MainDialogManager.showNextDialog("top_tab_bubble", false, (Context) null);
        mMainDialog = null;
    }
}