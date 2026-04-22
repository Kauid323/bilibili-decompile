package tv.danmaku.bili.ui.compatibility;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatDialog;
import com.bilibili.gripper.api.updater.GUpdater;
import dagger.hilt.EntryPoints;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.update.api.updater.IUpdater;

/* compiled from: CompatibilityUpdateDialog.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/ui/compatibility/CompatibilityUpdateDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "mActivity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class CompatibilityUpdateDialog extends AppCompatDialog {
    public static final int $stable = 8;
    private final Activity mActivity;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CompatibilityUpdateDialog(Activity mActivity) {
        super(mActivity, R.style.AppTheme_AppCompat_Dialog_Alert_NoTitle);
        Intrinsics.checkNotNullParameter(mActivity, "mActivity");
        this.mActivity = mActivity;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bili_app_dialog_update_compatibility);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        Window $this$onCreate_u24lambda_u240 = getWindow();
        if ($this$onCreate_u24lambda_u240 != null) {
            $this$onCreate_u24lambda_u240.setBackgroundDrawable(new ColorDrawable(0));
            $this$onCreate_u24lambda_u240.setGravity(17);
            $this$onCreate_u24lambda_u240.setLayout(-2, -2);
        }
        View findViewById = findViewById(R.id.tv_confirm);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.compatibility.CompatibilityUpdateDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CompatibilityUpdateDialog.onCreate$lambda$1(CompatibilityUpdateDialog.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(CompatibilityUpdateDialog this$0, View it) {
        GUpdater obj = ((GUpdater.Fetcher) EntryPoints.get(this$0.mActivity.getApplicationContext(), GUpdater.Fetcher.class)).getObj();
        if (obj != null) {
            GUpdater.-CC.checkCompatibilityUpdater$default(obj, this$0.mActivity, (IUpdater) null, 2, (Object) null);
        }
    }
}