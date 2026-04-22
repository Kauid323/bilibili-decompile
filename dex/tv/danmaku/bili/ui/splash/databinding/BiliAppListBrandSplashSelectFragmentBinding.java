package tv.danmaku.bili.ui.splash.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.magicasakura.widgets.TintFrameLayout;
import com.bilibili.magicasakura.widgets.TintLinearLayout;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.ui.splash.R;

public final class BiliAppListBrandSplashSelectFragmentBinding implements ViewBinding {
    public final ImageView close;
    public final TintLinearLayout contentAreaContainer;
    public final TintFrameLayout flSelectContainer;
    private final TintFrameLayout rootView;
    public final RecyclerView rvItems;
    public final TintTextView title;

    private BiliAppListBrandSplashSelectFragmentBinding(TintFrameLayout rootView, ImageView close, TintLinearLayout contentAreaContainer, TintFrameLayout flSelectContainer, RecyclerView rvItems, TintTextView title) {
        this.rootView = rootView;
        this.close = close;
        this.contentAreaContainer = contentAreaContainer;
        this.flSelectContainer = flSelectContainer;
        this.rvItems = rvItems;
        this.title = title;
    }

    public TintFrameLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppListBrandSplashSelectFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppListBrandSplashSelectFragmentBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_list_brand_splash_select_fragment, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppListBrandSplashSelectFragmentBinding bind(View rootView) {
        TintLinearLayout contentAreaContainer;
        TintTextView title;
        int id = R.id.close;
        ImageView close = (ImageView) ViewBindings.findChildViewById(rootView, id);
        if (close != null && (contentAreaContainer = ViewBindings.findChildViewById(rootView, (id = R.id.content_area_container))) != null) {
            TintFrameLayout flSelectContainer = (TintFrameLayout) rootView;
            id = R.id.rv_items;
            RecyclerView rvItems = ViewBindings.findChildViewById(rootView, id);
            if (rvItems != null && (title = ViewBindings.findChildViewById(rootView, (id = R.id.title))) != null) {
                return new BiliAppListBrandSplashSelectFragmentBinding((TintFrameLayout) rootView, close, contentAreaContainer, flSelectContainer, rvItems, title);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}