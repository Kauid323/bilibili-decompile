package tv.danmaku.bili.widget.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.bilibili.lib.widget.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BaseDialogFragment.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J&\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J&\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\u001a\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u000bH\u0014J\b\u0010\u001a\u001a\u00020\u000bH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u001cH\u0014J\b\u0010\u001e\u001a\u00020\u000bH\u0014J\u0010\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000fH$J\b\u0010 \u001a\u00020\u001cH%J\u001a\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006&"}, d2 = {"Ltv/danmaku/bili/widget/dialog/BaseDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "cancelableOnTouchOutside", "", "getCancelableOnTouchOutside", "()Z", "setCancelableOnTouchOutside", "(Z)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "createDialogView", "onViewCreated", "view", "getDimAmount", "", "onDialogCreated", "onResume", "requestWidth", "", "requestHeight", "initSavedData", "initView", "getDialogViewRes", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "", "widget_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public abstract class BaseDialogFragment extends DialogFragment {
    private boolean cancelableOnTouchOutside = true;

    protected abstract int getDialogViewRes();

    protected abstract void initView(View view2);

    public final boolean getCancelableOnTouchOutside() {
        return this.cancelableOnTouchOutside;
    }

    public final void setCancelableOnTouchOutside(boolean z) {
        this.cancelableOnTouchOutside = z;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(1, 0);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return createDialogView(inflater, container, savedInstanceState);
    }

    private final View createDialogView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(getDialogViewRes(), container, false);
    }

    public void onViewCreated(View view2, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view2, "view");
        super.onViewCreated(view2, savedInstanceState);
        initSavedData();
        initView(view2);
        Dialog $this$onViewCreated_u24lambda_u240 = getDialog();
        if ($this$onViewCreated_u24lambda_u240 != null) {
            Window window = $this$onViewCreated_u24lambda_u240.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
            }
            Window window2 = $this$onViewCreated_u24lambda_u240.getWindow();
            if (window2 != null) {
                window2.setDimAmount(getDimAmount());
            }
            $this$onViewCreated_u24lambda_u240.setCancelable(isCancelable());
            $this$onViewCreated_u24lambda_u240.setCanceledOnTouchOutside(this.cancelableOnTouchOutside);
            $this$onViewCreated_u24lambda_u240.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: tv.danmaku.bili.widget.dialog.BaseDialogFragment$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    boolean onViewCreated$lambda$0$0;
                    onViewCreated$lambda$0$0 = BaseDialogFragment.onViewCreated$lambda$0$0(BaseDialogFragment.this, dialogInterface, i, keyEvent);
                    return onViewCreated$lambda$0$0;
                }
            });
        }
        onDialogCreated();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$0$0(BaseDialogFragment this$0, DialogInterface dialogInterface, int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return keyCode == 4 && event.getAction() == 0 && !this$0.isCancelable();
    }

    private final float getDimAmount() {
        return ResourcesCompat.getFloat(requireContext().getResources(), R.dimen.bili_dialog_dim_amount);
    }

    protected void onDialogCreated() {
    }

    public void onResume() {
        Window window;
        Window window2;
        super.onResume();
        if (requestWidth() != 0 || requestHeight() != 0) {
            Dialog dialog = getDialog();
            WindowManager.LayoutParams layoutParams = (dialog == null || (window2 = dialog.getWindow()) == null) ? null : window2.getAttributes();
            if (layoutParams != null) {
                WindowManager.LayoutParams $this$onResume_u24lambda_u240 = layoutParams;
                if (requestWidth() != 0) {
                    $this$onResume_u24lambda_u240.width = requestWidth();
                }
                if (requestHeight() != 0) {
                    $this$onResume_u24lambda_u240.height = requestHeight();
                }
            }
            Dialog dialog2 = getDialog();
            if (dialog2 == null || (window = dialog2.getWindow()) == null) {
                return;
            }
            window.setAttributes(layoutParams);
        }
    }

    protected int requestWidth() {
        return 0;
    }

    protected int requestHeight() {
        return 0;
    }

    protected void initSavedData() {
    }

    public void show(FragmentManager manager, String tag) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        if (!manager.isStateSaved() && !manager.isDestroyed()) {
            super.show(manager, tag);
        }
    }
}