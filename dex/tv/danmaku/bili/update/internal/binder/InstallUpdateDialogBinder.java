package tv.danmaku.bili.update.internal.binder;

import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.bilibili.app.updater.R;
import tv.danmaku.bili.update.internal.binder.BinderParams;
import tv.danmaku.bili.update.internal.exception.ViewNotFoundException;
import tv.danmaku.bili.update.utils.TintHelper;

public class InstallUpdateDialogBinder extends DialogViewBinder<BinderParams.WifeAutoUpdate> {
    @Override // tv.danmaku.bili.update.internal.binder.DialogViewBinder
    public void setUpPositiveButton(Dialog dialog) throws ViewNotFoundException {
        View positiveBtn = requireViewById(dialog, R.id.update_btn_confirm, "update_btn_confirm");
        TintHelper.tryTintPositiveButtonBackground(getContext(), dialog, positiveBtn);
    }

    @Override // tv.danmaku.bili.update.internal.binder.DialogViewBinder
    public void setUpUpdateContentView(Dialog dialog) throws ViewNotFoundException {
        if (TextUtils.isEmpty(getUpgradeInfo().getContent())) {
            View tvContentHint = requireViewById(dialog, R.id.update_tv_content_hint, "update_tv_content_hint");
            View tvContent = requireViewById(dialog, R.id.update_tv_content_text, "update_tv_content_text");
            tvContentHint.setVisibility(8);
            tvContent.setVisibility(8);
            return;
        }
        TextView tvContentText = (TextView) requireViewById(dialog, R.id.update_tv_content_text, "update_tv_content_text");
        tvContentText.setText(getUpgradeInfo().getContent());
    }
}