package tv.danmaku.bili.update.internal.binder;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.bilibili.app.updater.R;
import tv.danmaku.bili.update.internal.binder.BinderParams;
import tv.danmaku.bili.update.internal.exception.ViewNotFoundException;
import tv.danmaku.bili.update.internal.network.download.UpdatePatchHelper;
import tv.danmaku.bili.update.internal.persist.files.UpdateApk;
import tv.danmaku.bili.update.model.BiliUpgradeInfo;
import tv.danmaku.bili.update.model.Patch;
import tv.danmaku.bili.update.utils.CommonUtilsKt;
import tv.danmaku.bili.update.utils.DisplaySizeHelper;
import tv.danmaku.bili.update.utils.RuntimeHelper;
import tv.danmaku.bili.update.utils.TintHelper;

public class DownloadUpdateDialogBinder extends DialogViewBinder<BinderParams.ManualUpdate> {
    @Override // tv.danmaku.bili.update.internal.binder.DialogViewBinder
    public void setUpWifiView(Dialog dialog) throws ViewNotFoundException {
        View ivWifiIndicator = requireViewById(dialog, R.id.update_iv_wifi_indicator, "update_iv_wifi_indicator");
        if (CommonUtilsKt.isInWifi(getContext()) || RuntimeHelper.checkApkUpdateFreeDataAvailable(getContext())) {
            ivWifiIndicator.setVisibility(8);
        } else {
            ivWifiIndicator.setVisibility(0);
        }
    }

    @Override // tv.danmaku.bili.update.internal.binder.DialogViewBinder
    public void setUpUpdateContentView(Dialog dialog) throws ViewNotFoundException {
        TextView tvContentText = (TextView) requireViewById(dialog, R.id.update_tv_content_text, "update_tv_content_text");
        tvContentText.setText(generateUpdateContent(getContext(), getUpgradeInfo()));
    }

    @Override // tv.danmaku.bili.update.internal.binder.DialogViewBinder
    public void setUpTitleView(Dialog dialog) throws ViewNotFoundException {
        TextView tvTitle = (TextView) requireViewById(dialog, R.id.update_tv_title, "update_tv_title");
        if (!TextUtils.isEmpty(getUpgradeInfo().getTitle()) && tvTitle != null) {
            tvTitle.setText(getUpgradeInfo().getTitle());
        }
    }

    @Override // tv.danmaku.bili.update.internal.binder.DialogViewBinder
    public void setUpIgnoreView(Dialog dialog) throws ViewNotFoundException {
        CheckBox cbxIgnoreVersion = (CheckBox) requireViewById(dialog, R.id.update_cbx_ignore_version, "update_cbx_ignore_version");
        cbxIgnoreVersion.setVisibility(8);
    }

    @Override // tv.danmaku.bili.update.internal.binder.DialogViewBinder
    public void setUpPositiveButton(Dialog dialog) throws ViewNotFoundException {
        Button positiveBtn = (Button) requireViewById(dialog, R.id.update_btn_confirm, "update_btn_confirm");
        TintHelper.tryTintPositiveButtonBackground(getContext(), dialog, positiveBtn);
        if (!CommonUtilsKt.isInWifi(getContext()) && RuntimeHelper.checkApkUpdateFreeDataAvailable(getContext())) {
            positiveBtn.setText(R.string.update_confirm_free_data);
        }
        if (isIncrementalUpgradePolicyEffective()) {
            positiveBtn.setText(String.format(getContext().getString(R.string.update_confirm_incremental_fmt), DisplaySizeHelper.byteCountToDisplaySize(UpdatePatchHelper.getPreferPatch(getUpgradeInfo()).getSize())));
            positiveBtn.setTextSize(0, getContext().getResources().getDimensionPixelSize(R.dimen.update_text_size_small));
        }
    }

    private String generateUpdateContent(Context context, BiliUpgradeInfo info) {
        Patch patch = UpdatePatchHelper.getPreferPatch(info);
        StringBuilder builder = new StringBuilder();
        builder.append(context.getString(R.string.update_version)).append(info.getVersion()).append('\n');
        builder.append(context.getString(R.string.update_package_size)).append(DisplaySizeHelper.byteCountToDisplaySize(info.getSize())).append('\n');
        if (info.getPolicy() == 0 && UpdateApk.enableIncremental(context) && patch != null) {
            builder.append(context.getString(R.string.update_patch_size)).append(DisplaySizeHelper.byteCountToDisplaySize(patch.getSize())).append('\n');
        }
        builder.append('\n').append(context.getString(R.string.update_content_title)).append('\n').append(info.getContent());
        return builder.toString();
    }

    private boolean isIncrementalUpgradePolicyEffective() {
        return getUpgradeInfo().getPolicy() == 0 && UpdateApk.enableIncremental(getContext()) && UpdatePatchHelper.getPreferPatch(getUpgradeInfo()) != null;
    }
}