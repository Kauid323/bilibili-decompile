package tv.danmaku.bili.ui.main.opdialog;

import android.app.Activity;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.okretro.BiliApiDataCallback;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main.opdialog.OpBizDialogHelper;

/* compiled from: OpBizDialogHelper.kt */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"tv/danmaku/bili/ui/main/opdialog/OpBizDialogHelper$fetchOpDialogInfo$1", "Lcom/bilibili/okretro/BiliApiDataCallback;", "Ltv/danmaku/bili/ui/main/opdialog/OpBizDialogHelper$OpDialogInfo;", "onDataSuccess", "", "data", "onError", "t", "", "isCancel", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class OpBizDialogHelper$fetchOpDialogInfo$1 extends BiliApiDataCallback<OpBizDialogHelper.OpDialogInfo> {
    final /* synthetic */ Activity $activity;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpBizDialogHelper$fetchOpDialogInfo$1(Activity $activity) {
        this.$activity = $activity;
    }

    public void onDataSuccess(OpBizDialogHelper.OpDialogInfo data) {
        boolean canShowDialog;
        if (data != null) {
            OpBizDialogHelper.OpDialogInfo it = data.isValid() ? data : null;
            if (it != null) {
                Activity activity = this.$activity;
                OpBizDialogHelper.INSTANCE.reportDialogReceive(it.getReportData());
                Neurons.trackT(false, "main.recommend.popups.get.track", MapsKt.mapOf(TuplesKt.to("report_data", it.getReportData())), 1, new Function0() { // from class: tv.danmaku.bili.ui.main.opdialog.OpBizDialogHelper$fetchOpDialogInfo$1$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        boolean onDataSuccess$lambda$1$0;
                        onDataSuccess$lambda$1$0 = OpBizDialogHelper$fetchOpDialogInfo$1.onDataSuccess$lambda$1$0();
                        return Boolean.valueOf(onDataSuccess$lambda$1$0);
                    }
                });
                BLog.i(OpBizDialogHelper.TAG, "Receive op dialog show.");
                canShowDialog = OpBizDialogHelper.INSTANCE.canShowDialog(activity, it);
                if (canShowDialog) {
                    OpBizDialogHelper.INSTANCE.dealWithDialog(activity, it);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onDataSuccess$lambda$1$0() {
        return true;
    }

    public void onError(Throwable t) {
        BLog.e(OpBizDialogHelper.TAG, "Fetch op dialog info error.", t);
    }

    public boolean isCancel() {
        return this.$activity.isFinishing();
    }
}