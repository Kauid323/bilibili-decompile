package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.magicasakura.widgets.TintImageView;
import com.bilibili.magicasakura.widgets.TintLinearLayout;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.R;

public final class BiliAppDialogBottomNavPopBinding implements ViewBinding {
    public final TintLinearLayout contentLayout;
    private final LinearLayout rootView;
    public final TintTextView text;
    public final TintImageView triangle;

    private BiliAppDialogBottomNavPopBinding(LinearLayout rootView, TintLinearLayout contentLayout, TintTextView text, TintImageView triangle) {
        this.rootView = rootView;
        this.contentLayout = contentLayout;
        this.text = text;
        this.triangle = triangle;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppDialogBottomNavPopBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppDialogBottomNavPopBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_dialog_bottom_nav_pop, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppDialogBottomNavPopBinding bind(View rootView) {
        TintTextView text;
        TintImageView triangle;
        int id = R.id.content_layout;
        TintLinearLayout contentLayout = ViewBindings.findChildViewById(rootView, id);
        if (contentLayout != null && (text = ViewBindings.findChildViewById(rootView, (id = R.id.text))) != null && (triangle = ViewBindings.findChildViewById(rootView, (id = R.id.triangle))) != null) {
            return new BiliAppDialogBottomNavPopBinding((LinearLayout) rootView, contentLayout, text, triangle);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}