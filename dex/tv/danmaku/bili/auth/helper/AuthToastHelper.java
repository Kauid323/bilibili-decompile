package tv.danmaku.bili.auth.helper;

import android.content.DialogInterface;
import android.view.KeyEvent;
import bili.resource.account.R;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.lib.ui.BaseAppCompatActivity;
import com.bilibili.magicasakura.widgets.TintProgressDialog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* compiled from: AuthToastHelper.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\tJ\u0006\u0010\u000e\u001a\u00020\fR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Ltv/danmaku/bili/auth/helper/AuthToastHelper;", "", AudioIntentHelper.FROM_ACTIVITY, "Lcom/bilibili/lib/ui/BaseAppCompatActivity;", "<init>", "(Lcom/bilibili/lib/ui/BaseAppCompatActivity;)V", "mProgressDialog", "Lcom/bilibili/magicasakura/widgets/TintProgressDialog;", "loadingMessage", "", "mContext", "showLoading", "", "message", "dismissLoading", "loadingRunnable", "Ljava/lang/Runnable;", "getLoadingRunnable", "()Ljava/lang/Runnable;", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AuthToastHelper {
    private String loadingMessage = "";
    private final Runnable loadingRunnable = new Runnable() { // from class: tv.danmaku.bili.auth.helper.AuthToastHelper$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            AuthToastHelper.loadingRunnable$lambda$0(AuthToastHelper.this);
        }
    };
    private BaseAppCompatActivity mContext;
    private TintProgressDialog mProgressDialog;

    public AuthToastHelper(BaseAppCompatActivity activity) {
        this.mContext = (BaseAppCompatActivity) new WeakReference(activity).get();
    }

    public static /* synthetic */ void showLoading$default(AuthToastHelper authToastHelper, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        authToastHelper.showLoading(str);
    }

    public final void showLoading(String message) {
        String str;
        dismissLoading();
        if (message == null) {
            str = FoundationAlias.getFapp().getString(R.string.account_global_string_243);
            Intrinsics.checkNotNullExpressionValue(str, "getString(...)");
        } else {
            str = message;
        }
        this.loadingMessage = str;
        HandlerThreads.postDelayed(0, this.loadingRunnable, 500L);
    }

    public final void dismissLoading() {
        TintProgressDialog tintProgressDialog;
        boolean z = false;
        HandlerThreads.remove(0, this.loadingRunnable);
        BaseAppCompatActivity baseAppCompatActivity = this.mContext;
        if (baseAppCompatActivity != null && baseAppCompatActivity.isFinishing()) {
            return;
        }
        BaseAppCompatActivity baseAppCompatActivity2 = this.mContext;
        if (baseAppCompatActivity2 != null && baseAppCompatActivity2.isDestroyed()) {
            z = true;
        }
        if (!z && (tintProgressDialog = this.mProgressDialog) != null) {
            tintProgressDialog.dismiss();
        }
    }

    public final Runnable getLoadingRunnable() {
        return this.loadingRunnable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadingRunnable$lambda$0(AuthToastHelper this$0) {
        TintProgressDialog tintProgressDialog;
        BaseAppCompatActivity baseAppCompatActivity = this$0.mContext;
        boolean z = true;
        if (baseAppCompatActivity != null && baseAppCompatActivity.isFinishing()) {
            return;
        }
        BaseAppCompatActivity baseAppCompatActivity2 = this$0.mContext;
        if (baseAppCompatActivity2 != null && baseAppCompatActivity2.isDestroyed()) {
            return;
        }
        if (this$0.mProgressDialog == null) {
            this$0.mProgressDialog = new TintProgressDialog(this$0.mContext);
            TintProgressDialog tintProgressDialog2 = this$0.mProgressDialog;
            if (tintProgressDialog2 != null) {
                tintProgressDialog2.setCanceledOnTouchOutside(false);
            }
            TintProgressDialog tintProgressDialog3 = this$0.mProgressDialog;
            if (tintProgressDialog3 != null) {
                tintProgressDialog3.setMessage(this$0.loadingMessage);
            }
            TintProgressDialog tintProgressDialog4 = this$0.mProgressDialog;
            if (tintProgressDialog4 != null) {
                tintProgressDialog4.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: tv.danmaku.bili.auth.helper.AuthToastHelper$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnKeyListener
                    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        boolean loadingRunnable$lambda$0$0;
                        loadingRunnable$lambda$0$0 = AuthToastHelper.loadingRunnable$lambda$0$0(dialogInterface, i, keyEvent);
                        return loadingRunnable$lambda$0$0;
                    }
                });
            }
        }
        TintProgressDialog tintProgressDialog5 = this$0.mProgressDialog;
        if (tintProgressDialog5 == null || tintProgressDialog5.isShowing()) {
            z = false;
        }
        if (!z || (tintProgressDialog = this$0.mProgressDialog) == null) {
            return;
        }
        tintProgressDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean loadingRunnable$lambda$0$0(DialogInterface dialogT, int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        event.getAction();
        return false;
    }
}