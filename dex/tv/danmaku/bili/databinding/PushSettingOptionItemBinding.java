package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.magicasakura.widgets.TintFrameLayout;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.R;

public final class PushSettingOptionItemBinding implements ViewBinding {
    public final BiliImageView ivSelect;
    private final TintFrameLayout rootView;
    public final TintTextView tag;
    public final TintTextView tvItemTitle;

    private PushSettingOptionItemBinding(TintFrameLayout rootView, BiliImageView ivSelect, TintTextView tag, TintTextView tvItemTitle) {
        this.rootView = rootView;
        this.ivSelect = ivSelect;
        this.tag = tag;
        this.tvItemTitle = tvItemTitle;
    }

    public TintFrameLayout getRoot() {
        return this.rootView;
    }

    public static PushSettingOptionItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static PushSettingOptionItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.push_setting_option_item, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static PushSettingOptionItemBinding bind(View rootView) {
        TintTextView tag;
        TintTextView tvItemTitle;
        int id = R.id.iv_select;
        BiliImageView ivSelect = ViewBindings.findChildViewById(rootView, id);
        if (ivSelect != null && (tag = ViewBindings.findChildViewById(rootView, (id = R.id.tag))) != null && (tvItemTitle = ViewBindings.findChildViewById(rootView, (id = R.id.tv_item_title))) != null) {
            return new PushSettingOptionItemBinding((TintFrameLayout) rootView, ivSelect, tag, tvItemTitle);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}