package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import tv.danmaku.bili.R;

public final class BiliAppActivitySdexternalstorageTestBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView videoAdvice;
    public final TextView videoAdviceContent;
    public final TextView videoInfo;
    public final TextView videoInfoContent;
    public final TextView videoResult;
    public final TextView videoResultContent;
    public final TextView videoTest;
    public final TextView videoTestContent;

    private BiliAppActivitySdexternalstorageTestBinding(LinearLayout rootView, TextView videoAdvice, TextView videoAdviceContent, TextView videoInfo, TextView videoInfoContent, TextView videoResult, TextView videoResultContent, TextView videoTest, TextView videoTestContent) {
        this.rootView = rootView;
        this.videoAdvice = videoAdvice;
        this.videoAdviceContent = videoAdviceContent;
        this.videoInfo = videoInfo;
        this.videoInfoContent = videoInfoContent;
        this.videoResult = videoResult;
        this.videoResultContent = videoResultContent;
        this.videoTest = videoTest;
        this.videoTestContent = videoTestContent;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppActivitySdexternalstorageTestBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppActivitySdexternalstorageTestBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_activity_sdexternalstorage_test, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppActivitySdexternalstorageTestBinding bind(View rootView) {
        int id = R.id.video_advice;
        TextView videoAdvice = (TextView) ViewBindings.findChildViewById(rootView, id);
        if (videoAdvice != null) {
            id = R.id.video_advice_content;
            TextView videoAdviceContent = (TextView) ViewBindings.findChildViewById(rootView, id);
            if (videoAdviceContent != null) {
                id = R.id.video_info;
                TextView videoInfo = (TextView) ViewBindings.findChildViewById(rootView, id);
                if (videoInfo != null) {
                    id = R.id.video_info_content;
                    TextView videoInfoContent = (TextView) ViewBindings.findChildViewById(rootView, id);
                    if (videoInfoContent != null) {
                        id = R.id.video_result;
                        TextView videoResult = (TextView) ViewBindings.findChildViewById(rootView, id);
                        if (videoResult != null) {
                            id = R.id.video_result_content;
                            TextView videoResultContent = (TextView) ViewBindings.findChildViewById(rootView, id);
                            if (videoResultContent != null) {
                                id = R.id.video_test;
                                TextView videoTest = (TextView) ViewBindings.findChildViewById(rootView, id);
                                if (videoTest != null) {
                                    id = R.id.video_test_content;
                                    TextView videoTestContent = (TextView) ViewBindings.findChildViewById(rootView, id);
                                    if (videoTestContent != null) {
                                        return new BiliAppActivitySdexternalstorageTestBinding((LinearLayout) rootView, videoAdvice, videoAdviceContent, videoInfo, videoInfoContent, videoResult, videoResultContent, videoTest, videoTestContent);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        String missingId = rootView.getResources().getResourceName(id);
        throw new NullPointerException("Missing required view with ID: ".concat(missingId));
    }
}