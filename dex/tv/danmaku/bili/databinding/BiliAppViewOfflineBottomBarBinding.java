package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.magicasakura.widgets.TintCheckBox;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.R;

public final class BiliAppViewOfflineBottomBarBinding implements ViewBinding {
    public final LinearLayout checkArea;
    public final TintCheckBox checkbox;
    public final TintTextView delete;
    private final View rootView;
    public final TintTextView updateDanmaku;

    private BiliAppViewOfflineBottomBarBinding(View rootView, LinearLayout checkArea, TintCheckBox checkbox, TintTextView delete, TintTextView updateDanmaku) {
        this.rootView = rootView;
        this.checkArea = checkArea;
        this.checkbox = checkbox;
        this.delete = delete;
        this.updateDanmaku = updateDanmaku;
    }

    public View getRoot() {
        return this.rootView;
    }

    public static BiliAppViewOfflineBottomBarBinding inflate(LayoutInflater inflater, ViewGroup parent) {
        if (parent == null) {
            throw new NullPointerException("parent");
        }
        inflater.inflate(R.layout.bili_app_view_offline_bottom_bar, parent);
        return bind(parent);
    }

    public static BiliAppViewOfflineBottomBarBinding bind(View rootView) {
        TintCheckBox checkbox;
        TintTextView delete;
        TintTextView updateDanmaku;
        int id = R.id.check_area;
        LinearLayout checkArea = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
        if (checkArea != null && (checkbox = ViewBindings.findChildViewById(rootView, (id = R.id.checkbox))) != null && (delete = ViewBindings.findChildViewById(rootView, (id = R.id.delete))) != null && (updateDanmaku = ViewBindings.findChildViewById(rootView, (id = R.id.update_danmaku))) != null) {
            return new BiliAppViewOfflineBottomBarBinding(rootView, checkArea, checkbox, delete, updateDanmaku);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}