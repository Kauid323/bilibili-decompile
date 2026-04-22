package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.lib.image2.view.legacy.StaticImageView2;
import com.bilibili.magicasakura.widgets.TintLinearLayout;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.R;
import tv.danmaku.bili.widget.SearchView;

public final class BiliAppActivityOfflineSearchBinding implements ViewBinding {
    public final FrameLayout bottomContainer;
    public final TintTextView cancel;
    public final ConstraintLayout contentLayout;
    public final RecyclerView recycler;
    private final ConstraintLayout rootView;
    public final SearchView searchBar;
    public final TintLinearLayout searchLayout;
    public final View shadow;
    public final TextView summary;
    public final StaticImageView2 tipImage;
    public final TextView tipMessage;
    public final LinearLayout tipView;

    private BiliAppActivityOfflineSearchBinding(ConstraintLayout rootView, FrameLayout bottomContainer, TintTextView cancel, ConstraintLayout contentLayout, RecyclerView recycler, SearchView searchBar, TintLinearLayout searchLayout, View shadow, TextView summary, StaticImageView2 tipImage, TextView tipMessage, LinearLayout tipView) {
        this.rootView = rootView;
        this.bottomContainer = bottomContainer;
        this.cancel = cancel;
        this.contentLayout = contentLayout;
        this.recycler = recycler;
        this.searchBar = searchBar;
        this.searchLayout = searchLayout;
        this.shadow = shadow;
        this.summary = summary;
        this.tipImage = tipImage;
        this.tipMessage = tipMessage;
        this.tipView = tipView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppActivityOfflineSearchBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppActivityOfflineSearchBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_activity_offline_search, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppActivityOfflineSearchBinding bind(View rootView) {
        TintTextView cancel;
        SearchView searchBar;
        TintLinearLayout searchLayout;
        View shadow;
        StaticImageView2 tipImage;
        int id = R.id.bottom_container;
        FrameLayout bottomContainer = (FrameLayout) ViewBindings.findChildViewById(rootView, id);
        if (bottomContainer != null && (cancel = ViewBindings.findChildViewById(rootView, (id = R.id.cancel))) != null) {
            ConstraintLayout contentLayout = (ConstraintLayout) rootView;
            id = R.id.recycler;
            RecyclerView recycler = ViewBindings.findChildViewById(rootView, id);
            if (recycler != null && (searchBar = ViewBindings.findChildViewById(rootView, (id = R.id.search_bar))) != null && (searchLayout = ViewBindings.findChildViewById(rootView, (id = R.id.search_layout))) != null && (shadow = ViewBindings.findChildViewById(rootView, (id = R.id.shadow))) != null) {
                id = R.id.summary;
                TextView summary = (TextView) ViewBindings.findChildViewById(rootView, id);
                if (summary != null && (tipImage = ViewBindings.findChildViewById(rootView, (id = R.id.tip_image))) != null) {
                    id = R.id.tip_message;
                    TextView tipMessage = (TextView) ViewBindings.findChildViewById(rootView, id);
                    if (tipMessage != null) {
                        id = R.id.tip_view;
                        LinearLayout tipView = (LinearLayout) ViewBindings.findChildViewById(rootView, id);
                        if (tipView != null) {
                            return new BiliAppActivityOfflineSearchBinding((ConstraintLayout) rootView, bottomContainer, cancel, contentLayout, recycler, searchBar, searchLayout, shadow, summary, tipImage, tipMessage, tipView);
                        }
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}