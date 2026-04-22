package tv.danmaku.bili.update.internal.binder;

import android.app.Dialog;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import com.bilibili.app.updateapi.applet.DialogOptions;
import com.bilibili.app.updater.R;
import tv.danmaku.bili.update.internal.binder.BinderParams;
import tv.danmaku.bili.update.internal.exception.ViewNotFoundException;
import tv.danmaku.bili.update.internal.network.download.UpdatePatchHelper;
import tv.danmaku.bili.update.internal.persist.files.UpdateApk;
import tv.danmaku.bili.update.model.BiliUpgradeInfo;
import tv.danmaku.bili.update.utils.CommonUtilsKt;
import tv.danmaku.bili.update.utils.DisplaySizeHelper;
import tv.danmaku.bili.update.utils.RuntimeHelper;
import tv.danmaku.bili.update.utils.TintHelper;

public class AppletUpdateDialogBinder extends DialogViewBinder<BinderParams.AppletUpdate> {
    private static final String TAG = "AppletUpdateDialogBinder";

    @Override // tv.danmaku.bili.update.internal.binder.DialogViewBinder
    public void setUpTitleView(Dialog dialog) throws ViewNotFoundException {
        DialogOptions dialogOptions = ((BinderParams.AppletUpdate) this.mBindParams).getDialogOptions();
        if (dialogOptions == null) {
            return;
        }
        TextView tvTitle = (TextView) requireViewById(dialog, R.id.update_tv_title, "update_tv_title");
        if (TextUtils.isEmpty(dialogOptions.getTitle())) {
            return;
        }
        tvTitle.setText(dialogOptions.getTitle());
    }

    @Override // tv.danmaku.bili.update.internal.binder.DialogViewBinder
    public void setUpUpdateContentView(Dialog dialog) throws ViewNotFoundException {
        TextView tvContentText = (TextView) requireViewById(dialog, R.id.update_tv_content_text, "update_tv_content_text");
        DialogOptions dialogOptions = ((BinderParams.AppletUpdate) this.mBindParams).getDialogOptions();
        if (dialogOptions != null && !TextUtils.isEmpty(dialogOptions.getContent())) {
            tvContentText.setText(dialogOptions.getContent());
            return;
        }
        BiliUpgradeInfo biliUpgradeInfo = getUpgradeInfo();
        if (biliUpgradeInfo != null) {
            tvContentText.setText(biliUpgradeInfo.getContent());
        }
    }

    @Override // tv.danmaku.bili.update.internal.binder.DialogViewBinder
    public void setUpPositiveButton(Dialog dialog) throws ViewNotFoundException {
        Button positiveBtn = (Button) requireViewById(dialog, R.id.update_btn_confirm, "update_btn_confirm");
        TintHelper.tryTintPositiveButtonBackground(getContext(), dialog, positiveBtn);
        DialogOptions dialogOptions = ((BinderParams.AppletUpdate) this.mBindParams).getDialogOptions();
        if (dialogOptions != null && !TextUtils.isEmpty(dialogOptions.getPositiveText())) {
            positiveBtn.setText(dialogOptions.getPositiveText());
            return;
        }
        if (!CommonUtilsKt.isInWifi(getContext()) && RuntimeHelper.checkApkUpdateFreeDataAvailable(getContext())) {
            positiveBtn.setText(R.string.update_confirm_free_data);
        }
        if (isIncrementalUpgradePolicyEffective()) {
            positiveBtn.setText(String.format(getContext().getString(R.string.update_confirm_incremental_fmt), DisplaySizeHelper.byteCountToDisplaySize(UpdatePatchHelper.getPreferPatch(getUpgradeInfo()).getSize())));
            positiveBtn.setTextSize(0, getContext().getResources().getDimensionPixelSize(R.dimen.update_text_size_small));
        }
    }

    @Override // tv.danmaku.bili.update.internal.binder.DialogViewBinder
    public void setUpNegativeButton(Dialog dialog) throws ViewNotFoundException {
        DialogOptions dialogOptions = ((BinderParams.AppletUpdate) this.mBindParams).getDialogOptions();
        if (dialogOptions == null) {
            return;
        }
        Button negativeBtn = (Button) requireViewById(dialog, R.id.update_btn_cancel, "update_btn_cancel");
        if (TextUtils.isEmpty(dialogOptions.getNegativeText())) {
            return;
        }
        negativeBtn.setText(dialogOptions.getNegativeText());
    }

    private boolean isIncrementalUpgradePolicyEffective() {
        return getUpgradeInfo().getPolicy() == 0 && UpdateApk.enableIncremental(getContext()) && UpdatePatchHelper.getPreferPatch(getUpgradeInfo()) != null;
    }
}