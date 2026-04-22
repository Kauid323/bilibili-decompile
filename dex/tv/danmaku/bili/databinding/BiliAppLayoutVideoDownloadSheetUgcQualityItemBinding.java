package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.bili.R;

public final class BiliAppLayoutVideoDownloadSheetUgcQualityItemBinding implements ViewBinding {
    public final TintTextView quality;
    private final TintTextView rootView;

    private BiliAppLayoutVideoDownloadSheetUgcQualityItemBinding(TintTextView rootView, TintTextView quality) {
        this.rootView = rootView;
        this.quality = quality;
    }

    public TintTextView getRoot() {
        return this.rootView;
    }

    public static BiliAppLayoutVideoDownloadSheetUgcQualityItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppLayoutVideoDownloadSheetUgcQualityItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_layout_video_download_sheet_ugc_quality_item, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppLayoutVideoDownloadSheetUgcQualityItemBinding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        TintTextView quality = (TintTextView) rootView;
        return new BiliAppLayoutVideoDownloadSheetUgcQualityItemBinding((TintTextView) rootView, quality);
    }
}