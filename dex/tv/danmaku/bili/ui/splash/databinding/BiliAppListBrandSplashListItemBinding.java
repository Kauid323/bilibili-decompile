package tv.danmaku.bili.ui.splash.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.ui.splash.R;

public final class BiliAppListBrandSplashListItemBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final ConstraintLayout rvContainer;
    public final RecyclerView rvItems;
    public final TintTextView title;
    public final ImageView titleIcon;

    private BiliAppListBrandSplashListItemBinding(ConstraintLayout rootView, ConstraintLayout rvContainer, RecyclerView rvItems, TintTextView title, ImageView titleIcon) {
        this.rootView = rootView;
        this.rvContainer = rvContainer;
        this.rvItems = rvItems;
        this.title = title;
        this.titleIcon = titleIcon;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppListBrandSplashListItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppListBrandSplashListItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_list_brand_splash_list_item, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppListBrandSplashListItemBinding bind(View rootView) {
        TintTextView title;
        ConstraintLayout rvContainer = (ConstraintLayout) rootView;
        int id = R.id.rv_items;
        RecyclerView rvItems = ViewBindings.findChildViewById(rootView, id);
        if (rvItems != null && (title = ViewBindings.findChildViewById(rootView, (id = R.id.title))) != null) {
            int id2 = R.id.title_icon;
            ImageView titleIcon = (ImageView) ViewBindings.findChildViewById(rootView, id2);
            if (titleIcon == null) {
                id = id2;
            } else {
                return new BiliAppListBrandSplashListItemBinding((ConstraintLayout) rootView, rvContainer, rvItems, title, titleIcon);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}