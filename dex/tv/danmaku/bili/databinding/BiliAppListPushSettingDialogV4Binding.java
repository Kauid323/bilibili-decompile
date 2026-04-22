package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.magicasakura.widgets.TintFrameLayout;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.R;

public final class BiliAppListPushSettingDialogV4Binding implements ViewBinding {
    public final ImageView close;
    public final TintTextView open;
    private final TintFrameLayout rootView;
    public final RecyclerView rvOptions;
    public final TintTextView title;
    public final BiliImageView topBanner;

    private BiliAppListPushSettingDialogV4Binding(TintFrameLayout rootView, ImageView close, TintTextView open, RecyclerView rvOptions, TintTextView title, BiliImageView topBanner) {
        this.rootView = rootView;
        this.close = close;
        this.open = open;
        this.rvOptions = rvOptions;
        this.title = title;
        this.topBanner = topBanner;
    }

    public TintFrameLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppListPushSettingDialogV4Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppListPushSettingDialogV4Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_list_push_setting_dialog_v4, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppListPushSettingDialogV4Binding bind(View rootView) {
        TintTextView open;
        RecyclerView rvOptions;
        TintTextView title;
        BiliImageView topBanner;
        int id = R.id.close;
        ImageView close = (ImageView) ViewBindings.findChildViewById(rootView, id);
        if (close != null && (open = ViewBindings.findChildViewById(rootView, (id = R.id.open))) != null && (rvOptions = ViewBindings.findChildViewById(rootView, (id = R.id.rv_options))) != null && (title = ViewBindings.findChildViewById(rootView, (id = R.id.title))) != null && (topBanner = ViewBindings.findChildViewById(rootView, (id = R.id.top_banner))) != null) {
            return new BiliAppListPushSettingDialogV4Binding((TintFrameLayout) rootView, close, open, rvOptions, title, topBanner);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}