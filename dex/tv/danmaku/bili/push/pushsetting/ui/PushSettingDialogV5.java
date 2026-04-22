package tv.danmaku.bili.push.pushsetting.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.push.pushsetting.model.PushCallBackInfo;

/* compiled from: PushSettingDialogV5.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Ltv/danmaku/bili/push/pushsetting/ui/PushSettingDialogV5;", "Ltv/danmaku/bili/push/pushsetting/ui/BasePushSettingDialog;", "<init>", "()V", "mContents", "Landroid/widget/TextView;", "getLayoutResId", "", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class PushSettingDialogV5 extends BasePushSettingDialog {
    public static final int $stable = 8;
    private TextView mContents;

    public PushSettingDialogV5() {
        setCancelable(true);
    }

    @Override // tv.danmaku.bili.push.pushsetting.ui.BasePushSettingDialog
    public int getLayoutResId() {
        return R.layout.bili_app_list_push_setting_dialog_v5;
    }

    @Override // tv.danmaku.bili.push.pushsetting.ui.BasePushSettingDialog
    public void onViewCreated(View view, Bundle savedInstanceState) {
        List<String> list;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.mContents = (TextView) view.findViewById(R.id.contents);
        View mCloseBtn = getMCloseBtn();
        String str = null;
        TextView textView = mCloseBtn instanceof TextView ? (TextView) mCloseBtn : null;
        if (textView != null) {
            PushCallBackInfo mPushData = getMPushData();
            textView.setText(mPushData != null ? mPushData.closeButton : null);
        }
        TextView textView2 = this.mContents;
        if (textView2 != null) {
            PushCallBackInfo mPushData2 = getMPushData();
            if (mPushData2 != null && (list = mPushData2.contents) != null) {
                str = CollectionsKt.joinToString$default(list, "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
            }
            textView2.setText(str);
        }
    }
}