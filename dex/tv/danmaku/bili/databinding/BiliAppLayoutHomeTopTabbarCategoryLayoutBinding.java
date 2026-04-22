package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.magicasakura.widgets.TintLinearLayout;
import tv.danmaku.bili.R;

public final class BiliAppLayoutHomeTopTabbarCategoryLayoutBinding implements ViewBinding {
    public final FrameLayout categoryClickArea;
    public final BiliImageView categoryImage;
    private final TintLinearLayout rootView;
    public final FrameLayout searchClickArea;
    public final BiliImageView searchImage;

    private BiliAppLayoutHomeTopTabbarCategoryLayoutBinding(TintLinearLayout rootView, FrameLayout categoryClickArea, BiliImageView categoryImage, FrameLayout searchClickArea, BiliImageView searchImage) {
        this.rootView = rootView;
        this.categoryClickArea = categoryClickArea;
        this.categoryImage = categoryImage;
        this.searchClickArea = searchClickArea;
        this.searchImage = searchImage;
    }

    public TintLinearLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppLayoutHomeTopTabbarCategoryLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppLayoutHomeTopTabbarCategoryLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_layout_home_top_tabbar_category_layout, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppLayoutHomeTopTabbarCategoryLayoutBinding bind(View rootView) {
        BiliImageView categoryImage;
        BiliImageView searchImage;
        int id = R.id.category_click_area;
        FrameLayout categoryClickArea = (FrameLayout) ViewBindings.findChildViewById(rootView, id);
        if (categoryClickArea != null && (categoryImage = ViewBindings.findChildViewById(rootView, (id = R.id.category_image))) != null) {
            id = R.id.search_click_area;
            FrameLayout searchClickArea = (FrameLayout) ViewBindings.findChildViewById(rootView, id);
            if (searchClickArea != null && (searchImage = ViewBindings.findChildViewById(rootView, (id = R.id.search_image))) != null) {
                return new BiliAppLayoutHomeTopTabbarCategoryLayoutBinding((TintLinearLayout) rootView, categoryClickArea, categoryImage, searchClickArea, searchImage);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}