package tv.danmaku.bili.ui.main.opdialog;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.bilibili.app.dialogmanager.MainDialogManager;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.neuron.api.Neurons;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.main.opdialog.OpBizDialogHelper;
import tv.danmaku.bili.widget.BaseDialog;

/* compiled from: OpBizDialog.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0014J\b\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Ltv/danmaku/bili/ui/main/opdialog/OpBizDialog;", "Ltv/danmaku/bili/widget/BaseDialog;", "cxt", "Landroid/content/Context;", "opInfo", "Ltv/danmaku/bili/ui/main/opdialog/OpBizDialogHelper$OpDialogInfo;", "<init>", "(Landroid/content/Context;Ltv/danmaku/bili/ui/main/opdialog/OpBizDialogHelper$OpDialogInfo;)V", "onStart", "", "mCloseWay", "", "onCreateView", "Landroid/view/View;", "onViewCreated", "view", "mRunnable", "Ljava/lang/Runnable;", "onBackPressed", "setUiBeforeShow", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class OpBizDialog extends BaseDialog<OpBizDialog> {
    public static final int $stable = 8;
    private final Context cxt;
    private int mCloseWay;
    private final Runnable mRunnable;
    private final OpBizDialogHelper.OpDialogInfo opInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OpBizDialog(Context cxt, OpBizDialogHelper.OpDialogInfo opInfo) {
        super(cxt);
        Intrinsics.checkNotNullParameter(cxt, "cxt");
        Intrinsics.checkNotNullParameter(opInfo, "opInfo");
        this.cxt = cxt;
        this.opInfo = opInfo;
        this.mCloseWay = 2;
        this.mRunnable = new Runnable() { // from class: tv.danmaku.bili.ui.main.opdialog.OpBizDialog$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                OpBizDialog.mRunnable$lambda$0(OpBizDialog.this);
            }
        };
    }

    protected void onStart() {
        super.onStart();
        Window window = getWindow();
        if (window != null) {
            window.setWindowAnimations(R.style.Animation_Biz_Dialog);
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setDimAmount(0.7f);
        }
        Window window3 = getWindow();
        if (window3 != null) {
            window3.setGravity(17);
        }
    }

    public View onCreateView() {
        View inflate = LayoutInflater.from(this.cxt).inflate(R.layout.bili_app_layout_op_biz_dialog, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }

    public void onViewCreated(View view) {
        super.onViewCreated(view);
        if (view == null) {
            return;
        }
        View dialogContainer = view.findViewById(R.id.dialog_container);
        if (dialogContainer != null) {
            dialogContainer.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.main.opdialog.OpBizDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    OpBizDialog.onViewCreated$lambda$0(OpBizDialog.this, view2);
                }
            });
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.close);
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.main.opdialog.OpBizDialog$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    OpBizDialog.onViewCreated$lambda$1(OpBizDialog.this, view2);
                }
            });
        }
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: tv.danmaku.bili.ui.main.opdialog.OpBizDialog$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                OpBizDialog.onViewCreated$lambda$2(OpBizDialog.this, dialogInterface);
            }
        });
        if (this.opInfo.getImageBm() != null) {
            Bitmap imageBm = this.opInfo.getImageBm();
            Intrinsics.checkNotNull(imageBm);
            if (!imageBm.isRecycled()) {
                ImageView imageView2 = (ImageView) view.findViewById(R.id.dialog_image);
                if (imageView2 != null) {
                    imageView2.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.main.opdialog.OpBizDialog$$ExternalSyntheticLambda3
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            OpBizDialog.onViewCreated$lambda$3(OpBizDialog.this, view2);
                        }
                    });
                }
                if (imageView2 != null) {
                    Bitmap imageBm2 = this.opInfo.getImageBm();
                    Intrinsics.checkNotNull(imageBm2);
                    imageView2.setImageBitmap(imageBm2);
                }
                if (this.opInfo.getAutoClose() && this.opInfo.getAutoCloseTime() > 0) {
                    HandlerThreads.postDelayed(0, this.mRunnable, this.opInfo.getAutoCloseTime() * 1000);
                }
                Animation animIn = AnimationUtils.loadAnimation(getContext(), R.anim.anim_op_biz_dialog_in);
                dialogContainer.startAnimation(animIn);
                OpBizDialogHelper.INSTANCE.reportDialogShow(this.opInfo.getReportData());
                Neurons.trackT(false, "main.recommend.popups.show.track", MapsKt.mapOf(TuplesKt.to("report_data", this.opInfo.getReportData())), 1, new Function0() { // from class: tv.danmaku.bili.ui.main.opdialog.OpBizDialog$$ExternalSyntheticLambda4
                    public final Object invoke() {
                        boolean onViewCreated$lambda$4;
                        onViewCreated$lambda$4 = OpBizDialog.onViewCreated$lambda$4();
                        return Boolean.valueOf(onViewCreated$lambda$4);
                    }
                });
                return;
            }
        }
        this.mCloseWay = 3;
        BLog.i(OpBizDialogHelper.TAG, "Op biz dialog error close.");
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(OpBizDialog this$0, View it) {
        this$0.mCloseWay = 1;
        this$0.dismiss();
        BLog.i(OpBizDialogHelper.TAG, "Op biz dialog outside close click.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(OpBizDialog this$0, View it) {
        this$0.mCloseWay = 1;
        this$0.dismiss();
        BLog.i(OpBizDialogHelper.TAG, "Op biz dialog close click.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(OpBizDialog this$0, DialogInterface it) {
        HandlerThreads.remove(0, this$0.mRunnable);
        OpBizDialogHelper.INSTANCE.reportDialogClose(this$0.opInfo.getReportData(), this$0.mCloseWay);
        Neurons.trackT(false, "main.recommend.popups.close.track", MapsKt.mapOf(new Pair[]{TuplesKt.to("report_data", this$0.opInfo.getReportData()), TuplesKt.to("close_way", String.valueOf(this$0.mCloseWay))}), 1, new Function0() { // from class: tv.danmaku.bili.ui.main.opdialog.OpBizDialog$$ExternalSyntheticLambda5
            public final Object invoke() {
                boolean onViewCreated$lambda$2$0;
                onViewCreated$lambda$2$0 = OpBizDialog.onViewCreated$lambda$2$0();
                return Boolean.valueOf(onViewCreated$lambda$2$0);
            }
        });
        MainDialogManager.showNextDialog("op_biz_dialog", false, this$0.getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$2$0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$3(OpBizDialog this$0, View it) {
        if (!TextUtils.isEmpty(this$0.opInfo.getLink())) {
            String link = this$0.opInfo.getLink();
            Intrinsics.checkNotNull(link);
            RouteRequest req = new RouteRequest.Builder(link).build();
            BLRouter.routeTo(req, this$0.getContext());
            this$0.mCloseWay = 1;
            OpBizDialogHelper.INSTANCE.reportDialogClick(this$0.opInfo.getReportData());
            this$0.dismiss();
            BLog.i(OpBizDialogHelper.TAG, "Op biz dialog image click.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onViewCreated$lambda$4() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mRunnable$lambda$0(OpBizDialog this$0) {
        if (!this$0.isShowing()) {
            return;
        }
        this$0.mCloseWay = 2;
        this$0.dismiss();
        BLog.i(OpBizDialogHelper.TAG, "Op biz dialog auto dismiss.");
    }

    public void onBackPressed() {
        this.mCloseWay = 1;
        super.onBackPressed();
    }

    public void setUiBeforeShow() {
    }
}