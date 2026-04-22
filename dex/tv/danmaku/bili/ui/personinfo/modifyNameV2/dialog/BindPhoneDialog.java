package tv.danmaku.bili.ui.personinfo.modifyNameV2.dialog;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.bilibili.app.personinfo.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.widget.dialog.BaseDialogFragment;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BindPhoneDialog.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u0018H\u0014R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Ltv/danmaku/bili/ui/personinfo/modifyNameV2/dialog/BindPhoneDialog;", "Ltv/danmaku/bili/widget/dialog/BaseDialogFragment;", "<init>", "()V", "confirmListener", "Lkotlin/Function0;", "", "getConfirmListener", "()Lkotlin/jvm/functions/Function0;", "setConfirmListener", "(Lkotlin/jvm/functions/Function0;)V", "cancelListener", "getCancelListener", "setCancelListener", "conditionMsg", "", "getConditionMsg", "()Ljava/lang/String;", "setConditionMsg", "(Ljava/lang/String;)V", "initView", "view", "Landroid/view/View;", "getDialogViewRes", "", "requestWidth", "personinfo_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BindPhoneDialog extends BaseDialogFragment {
    public static final int $stable = 8;
    private Function0<Unit> cancelListener;
    private String conditionMsg = "";
    private Function0<Unit> confirmListener;

    public final Function0<Unit> getConfirmListener() {
        return this.confirmListener;
    }

    public final void setConfirmListener(Function0<Unit> function0) {
        this.confirmListener = function0;
    }

    public final Function0<Unit> getCancelListener() {
        return this.cancelListener;
    }

    public final void setCancelListener(Function0<Unit> function0) {
        this.cancelListener = function0;
    }

    public final String getConditionMsg() {
        return this.conditionMsg;
    }

    public final void setConditionMsg(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.conditionMsg = str;
    }

    @Override // tv.danmaku.bili.widget.dialog.BaseDialogFragment
    protected void initView(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        view2.findViewById(R.id.common_dialog_nagetive_btn).setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.personinfo.modifyNameV2.dialog.BindPhoneDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                BindPhoneDialog.initView$lambda$0(BindPhoneDialog.this, view3);
            }
        });
        view2.findViewById(R.id.common_dialog_positive_btn).setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.personinfo.modifyNameV2.dialog.BindPhoneDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                BindPhoneDialog.initView$lambda$1(BindPhoneDialog.this, view3);
            }
        });
        View findViewById = view2.findViewById(R.id.condition_message);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById).setText(this.conditionMsg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(BindPhoneDialog this$0, View it) {
        Function0<Unit> function0 = this$0.cancelListener;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(BindPhoneDialog this$0, View it) {
        Function0<Unit> function0 = this$0.confirmListener;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // tv.danmaku.bili.widget.dialog.BaseDialogFragment
    protected int getDialogViewRes() {
        return R.layout.bili_app_modify_name_authentication_dialog;
    }

    @Override // tv.danmaku.bili.widget.dialog.BaseDialogFragment
    protected int requestWidth() {
        Resources resources;
        Context context = getContext();
        if (context == null || (resources = context.getResources()) == null) {
            return 0;
        }
        return resources.getDimensionPixelSize(R.dimen.person_info_dialog_width);
    }
}