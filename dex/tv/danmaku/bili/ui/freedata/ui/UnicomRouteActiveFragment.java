package tv.danmaku.bili.ui.freedata.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import bili.resource.homepage.R;
import com.bilibili.droid.StringUtil;
import com.bilibili.fd_service.FreeDataManager;
import com.bilibili.freedata.ui.unicom.UnicomActivateFragment;
import com.bilibili.lib.config.BLRemoteConfig;
import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: UnicomRouteActiveFragment.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/ui/freedata/ui/UnicomRouteActiveFragment;", "Lcom/bilibili/freedata/ui/unicom/UnicomActivateFragment;", "<init>", "()V", "initView", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class UnicomRouteActiveFragment extends UnicomActivateFragment {
    public static final int $stable = 8;

    protected void initView() {
        super.initView();
        this.mSecDescTv.setOnLongClickListener(new View.OnLongClickListener() { // from class: tv.danmaku.bili.ui.freedata.ui.UnicomRouteActiveFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean initView$lambda$0;
                initView$lambda$0 = UnicomRouteActiveFragment.initView$lambda$0(UnicomRouteActiveFragment.this, view);
                return initView$lambda$0;
            }
        });
        String tips = BLRemoteConfig.getInstance().getString("unicom_active_page_tips");
        if (StringUtil.isNotBlank(tips)) {
            this.mSecDescTv.setText(tips);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initView$lambda$0(UnicomRouteActiveFragment this$0, View it) {
        Context $this$initView_u24lambda_u240_u240 = this$0.getContext();
        if ($this$initView_u24lambda_u240_u240 != null) {
            new AlertDialog.Builder($this$initView_u24lambda_u240_u240).setTitle($this$initView_u24lambda_u240_u240.getString(R.string.homepage_global_string_234)).setMessage($this$initView_u24lambda_u240_u240.getString(R.string.homepage_global_string_377)).setPositiveButton(bili.resource.common.R.string.common_global_string_202, new DialogInterface.OnClickListener() { // from class: tv.danmaku.bili.ui.freedata.ui.UnicomRouteActiveFragment$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    UnicomRouteActiveFragment.initView$lambda$0$0$0(dialogInterface, i);
                }
            }).setNegativeButton(bili.resource.common.R.string.common_global_string_238, new DialogInterface.OnClickListener() { // from class: tv.danmaku.bili.ui.freedata.ui.UnicomRouteActiveFragment$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).show();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0$0$0(DialogInterface dialog, int i) {
        FreeDataManager.getInstance().clearActive();
        dialog.dismiss();
    }
}