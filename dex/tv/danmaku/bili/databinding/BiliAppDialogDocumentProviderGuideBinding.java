package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.R;

public final class BiliAppDialogDocumentProviderGuideBinding implements ViewBinding {
    public final TextView guideTxt;
    private final RelativeLayout rootView;

    private BiliAppDialogDocumentProviderGuideBinding(RelativeLayout rootView, TextView guideTxt) {
        this.rootView = rootView;
        this.guideTxt = guideTxt;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppDialogDocumentProviderGuideBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppDialogDocumentProviderGuideBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_dialog_document_provider_guide, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppDialogDocumentProviderGuideBinding bind(View rootView) {
        int id = R.id.guide_txt;
        TextView guideTxt = (TextView) ViewBindings.findChildViewById(rootView, id);
        if (guideTxt != null) {
            return new BiliAppDialogDocumentProviderGuideBinding((RelativeLayout) rootView, guideTxt);
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}