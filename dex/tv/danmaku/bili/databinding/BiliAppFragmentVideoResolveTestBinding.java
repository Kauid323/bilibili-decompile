package tv.danmaku.bili.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bilibili.magicasakura.widgets.TintButton;
import tv.danmaku.bili.R;

public final class BiliAppFragmentVideoResolveTestBinding implements ViewBinding {
    public final TintButton reportLog;
    public final RelativeLayout rootLayout;
    private final RelativeLayout rootView;
    public final TextView videoDesc;
    public final TextView videoDescContent;
    public final TextView videoResult;
    public final TextView videoResultContent;
    public final TextView videoStorage;
    public final TextView videoStorageContent;
    public final TextView videoTips;
    public final TextView videoTipsContent;
    public final TextView videoTree;
    public final TextView videoTreeContent;

    private BiliAppFragmentVideoResolveTestBinding(RelativeLayout rootView, TintButton reportLog, RelativeLayout rootLayout, TextView videoDesc, TextView videoDescContent, TextView videoResult, TextView videoResultContent, TextView videoStorage, TextView videoStorageContent, TextView videoTips, TextView videoTipsContent, TextView videoTree, TextView videoTreeContent) {
        this.rootView = rootView;
        this.reportLog = reportLog;
        this.rootLayout = rootLayout;
        this.videoDesc = videoDesc;
        this.videoDescContent = videoDescContent;
        this.videoResult = videoResult;
        this.videoResultContent = videoResultContent;
        this.videoStorage = videoStorage;
        this.videoStorageContent = videoStorageContent;
        this.videoTips = videoTips;
        this.videoTipsContent = videoTipsContent;
        this.videoTree = videoTree;
        this.videoTreeContent = videoTreeContent;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static BiliAppFragmentVideoResolveTestBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static BiliAppFragmentVideoResolveTestBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View root = inflater.inflate(R.layout.bili_app_fragment_video_resolve_test, parent, false);
        if (attachToParent) {
            parent.addView(root);
        }
        return bind(root);
    }

    public static BiliAppFragmentVideoResolveTestBinding bind(View rootView) {
        int id = R.id.report_log;
        TintButton reportLog = ViewBindings.findChildViewById(rootView, id);
        if (reportLog != null) {
            RelativeLayout rootLayout = (RelativeLayout) rootView;
            id = R.id.video_desc;
            TextView videoDesc = (TextView) ViewBindings.findChildViewById(rootView, id);
            if (videoDesc != null) {
                id = R.id.video_desc_content;
                TextView videoDescContent = (TextView) ViewBindings.findChildViewById(rootView, id);
                if (videoDescContent != null) {
                    id = R.id.video_result;
                    TextView videoResult = (TextView) ViewBindings.findChildViewById(rootView, id);
                    if (videoResult != null) {
                        id = R.id.video_result_content;
                        TextView videoResultContent = (TextView) ViewBindings.findChildViewById(rootView, id);
                        if (videoResultContent != null) {
                            id = R.id.video_storage;
                            TextView videoStorage = (TextView) ViewBindings.findChildViewById(rootView, id);
                            if (videoStorage != null) {
                                id = R.id.video_storage_content;
                                TextView videoStorageContent = (TextView) ViewBindings.findChildViewById(rootView, id);
                                if (videoStorageContent != null) {
                                    id = R.id.video_tips;
                                    TextView videoTips = (TextView) ViewBindings.findChildViewById(rootView, id);
                                    if (videoTips != null) {
                                        id = R.id.video_tips_content;
                                        TextView videoTipsContent = (TextView) ViewBindings.findChildViewById(rootView, id);
                                        if (videoTipsContent != null) {
                                            id = R.id.video_tree;
                                            TextView videoTree = (TextView) ViewBindings.findChildViewById(rootView, id);
                                            if (videoTree != null) {
                                                id = R.id.video_tree_content;
                                                TextView videoTreeContent = (TextView) ViewBindings.findChildViewById(rootView, id);
                                                if (videoTreeContent != null) {
                                                    return new BiliAppFragmentVideoResolveTestBinding((RelativeLayout) rootView, reportLog, rootLayout, videoDesc, videoDescContent, videoResult, videoResultContent, videoStorage, videoStorageContent, videoTips, videoTipsContent, videoTree, videoTreeContent);
                                                }
                                            }
                                        }
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