package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.magicasakura.widgets.TintFrameLayout;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.R;

public final class BiliAppFavoriteFolderGuideBubbleBinding implements ViewBinding {
    public final ImageView icon;
    private final ConstraintLayout rootView;
    public final TintTextView text;
    public final TintFrameLayout textContainer;

    private BiliAppFavoriteFolderGuideBubbleBinding(ConstraintLayout rootView, ImageView icon, TintTextView text, TintFrameLayout textContainer) {
        this.rootView = rootView;
        this.icon = icon;
        this.text = text;
        this.textContainer = textContainer;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppFavoriteFolderGuideBubbleBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppFavoriteFolderGuideBubbleBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_favorite_folder_guide_bubble, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppFavoriteFolderGuideBubbleBinding bind(View rootView) {
        TintTextView text;
        TintFrameLayout textContainer;
        int id = R.id.icon;
        ImageView icon = (ImageView) ViewBindings.findChildViewById(rootView, id);
        if (icon != null && (text = ViewBindings.findChildViewById(rootView, (id = R.id.text))) != null && (textContainer = ViewBindings.findChildViewById(rootView, (id = R.id.text_container))) != null) {
            return new BiliAppFavoriteFolderGuideBubbleBinding((ConstraintLayout) rootView, icon, text, textContainer);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}