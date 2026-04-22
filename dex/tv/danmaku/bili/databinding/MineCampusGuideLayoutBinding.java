package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.image2.view.BiliImageView;
import tv.danmaku.bili.R;

public final class MineCampusGuideLayoutBinding implements ViewBinding {
    public final BiliImageView campusGuidImg;
    private final View rootView;

    private MineCampusGuideLayoutBinding(View rootView, BiliImageView campusGuidImg) {
        this.rootView = rootView;
        this.campusGuidImg = campusGuidImg;
    }

    public View getRoot() {
        return this.rootView;
    }

    public static MineCampusGuideLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent) {
        if (parent == null) {
            throw new NullPointerException("parent");
        }
        inflater.inflate(R.layout.mine_campus_guide_layout, parent);
        return bind(parent);
    }

    public static MineCampusGuideLayoutBinding bind(View rootView) {
        int id = R.id.campus_guid_img;
        BiliImageView campusGuidImg = ViewBindings.findChildViewById(rootView, id);
        if (campusGuidImg != null) {
            return new MineCampusGuideLayoutBinding(rootView, campusGuidImg);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}