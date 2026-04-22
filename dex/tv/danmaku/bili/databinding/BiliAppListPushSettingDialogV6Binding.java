package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.magicasakura.widgets.TintLinearLayout;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.R;

public final class BiliAppListPushSettingDialogV6Binding implements ViewBinding {
    public final TintTextView close;
    public final TintTextView open;
    private final TintLinearLayout rootView;
    public final RecyclerView rvOptions;
    public final TintTextView title;
    public final BiliImageView topBanner;

    private BiliAppListPushSettingDialogV6Binding(TintLinearLayout rootView, TintTextView close, TintTextView open, RecyclerView rvOptions, TintTextView title, BiliImageView topBanner) {
        this.rootView = rootView;
        this.close = close;
        this.open = open;
        this.rvOptions = rvOptions;
        this.title = title;
        this.topBanner = topBanner;
    }

    public TintLinearLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppListPushSettingDialogV6Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppListPushSettingDialogV6Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_list_push_setting_dialog_v6, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppListPushSettingDialogV6Binding bind(View rootView) {
        TintTextView open;
        RecyclerView rvOptions;
        TintTextView title;
        BiliImageView topBanner;
        int id = R.id.close;
        TintTextView close = ViewBindings.findChildViewById(rootView, id);
        if (close != null && (open = ViewBindings.findChildViewById(rootView, (id = R.id.open))) != null && (rvOptions = ViewBindings.findChildViewById(rootView, (id = R.id.rv_options))) != null && (title = ViewBindings.findChildViewById(rootView, (id = R.id.title))) != null && (topBanner = ViewBindings.findChildViewById(rootView, (id = R.id.top_banner))) != null) {
            return new BiliAppListPushSettingDialogV6Binding((TintLinearLayout) rootView, close, open, rvOptions, title, topBanner);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}