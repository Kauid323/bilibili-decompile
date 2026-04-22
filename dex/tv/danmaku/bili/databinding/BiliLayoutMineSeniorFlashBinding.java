package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.image2.view.BiliImageView;
import tv.danmaku.bili.R;

public final class BiliLayoutMineSeniorFlashBinding implements ViewBinding {
    public final BiliImageView mineLevelFlash;
    public final View mineLevelFlashClickArea;
    private final ConstraintLayout rootView;

    private BiliLayoutMineSeniorFlashBinding(ConstraintLayout rootView, BiliImageView mineLevelFlash, View mineLevelFlashClickArea) {
        this.rootView = rootView;
        this.mineLevelFlash = mineLevelFlash;
        this.mineLevelFlashClickArea = mineLevelFlashClickArea;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliLayoutMineSeniorFlashBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliLayoutMineSeniorFlashBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_layout_mine_senior_flash, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliLayoutMineSeniorFlashBinding bind(View rootView) {
        View mineLevelFlashClickArea;
        int id = R.id.mine_level_flash;
        BiliImageView mineLevelFlash = ViewBindings.findChildViewById(rootView, id);
        if (mineLevelFlash != null && (mineLevelFlashClickArea = ViewBindings.findChildViewById(rootView, (id = R.id.mine_level_flash_click_area))) != null) {
            return new BiliLayoutMineSeniorFlashBinding((ConstraintLayout) rootView, mineLevelFlash, mineLevelFlashClickArea);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}