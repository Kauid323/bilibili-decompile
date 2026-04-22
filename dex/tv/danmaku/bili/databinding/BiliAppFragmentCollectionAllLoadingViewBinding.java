package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.magicasakura.widgets.TintProgressBar;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.R;
import tv.danmaku.bili.widget.ForegroundRelativeLayout;

public final class BiliAppFragmentCollectionAllLoadingViewBinding implements ViewBinding {
    public final TintProgressBar collectionLoading;
    public final AppCompatImageView collectionRightArrow;
    public final TintTextView collectionText;
    public final ForegroundRelativeLayout loadingView;
    private final ForegroundRelativeLayout rootView;

    private BiliAppFragmentCollectionAllLoadingViewBinding(ForegroundRelativeLayout rootView, TintProgressBar collectionLoading, AppCompatImageView collectionRightArrow, TintTextView collectionText, ForegroundRelativeLayout loadingView) {
        this.rootView = rootView;
        this.collectionLoading = collectionLoading;
        this.collectionRightArrow = collectionRightArrow;
        this.collectionText = collectionText;
        this.loadingView = loadingView;
    }

    public ForegroundRelativeLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppFragmentCollectionAllLoadingViewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppFragmentCollectionAllLoadingViewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_fragment_collection_all_loading_view, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppFragmentCollectionAllLoadingViewBinding bind(View rootView) {
        AppCompatImageView collectionRightArrow;
        TintTextView collectionText;
        int id = R.id.collection_loading;
        TintProgressBar collectionLoading = ViewBindings.findChildViewById(rootView, id);
        if (collectionLoading != null && (collectionRightArrow = ViewBindings.findChildViewById(rootView, (id = R.id.collection_right_arrow))) != null && (collectionText = ViewBindings.findChildViewById(rootView, (id = R.id.collection_text))) != null) {
            ForegroundRelativeLayout loadingView = (ForegroundRelativeLayout) rootView;
            return new BiliAppFragmentCollectionAllLoadingViewBinding((ForegroundRelativeLayout) rootView, collectionLoading, collectionRightArrow, collectionText, loadingView);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}