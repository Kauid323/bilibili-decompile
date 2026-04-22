package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.magicasakura.widgets.TintToolbar;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.floatvideo.SectionedSeekBar;

public final class BiliAppActivityFloatWindowSizeBinding implements ViewBinding {
    public final TintToolbar navTopBar;
    public final BiliImageView previewView;
    private final LinearLayout rootView;
    public final SectionedSeekBar seekbar;

    private BiliAppActivityFloatWindowSizeBinding(LinearLayout rootView, TintToolbar navTopBar, BiliImageView previewView, SectionedSeekBar seekbar) {
        this.rootView = rootView;
        this.navTopBar = navTopBar;
        this.previewView = previewView;
        this.seekbar = seekbar;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppActivityFloatWindowSizeBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppActivityFloatWindowSizeBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_activity_float_window_size, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppActivityFloatWindowSizeBinding bind(View rootView) {
        BiliImageView previewView;
        int id = R.id.nav_top_bar;
        TintToolbar navTopBar = ViewBindings.findChildViewById(rootView, id);
        if (navTopBar != null && (previewView = ViewBindings.findChildViewById(rootView, (id = R.id.preview_view))) != null) {
            id = R.id.seekbar;
            SectionedSeekBar seekbar = (SectionedSeekBar) ViewBindings.findChildViewById(rootView, id);
            if (seekbar != null) {
                return new BiliAppActivityFloatWindowSizeBinding((LinearLayout) rootView, navTopBar, previewView, seekbar);
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}