package tv.danmaku.bili.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bilibili.app.auth.R;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.bean.ImageInfo;
import com.bilibili.lib.image2.bean.ImageLoadingListener;
import com.bilibili.lib.image2.view.legacy.StaticImageView2;
import com.bilibili.lib.ui.BaseToolbarFragment;
import tv.danmaku.android.util.AppResUtil;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.router.ChannelRoutes;

public class AuthPassedFragment extends BaseToolbarFragment {
    private ImageLoadingListener imageLoadingListener = new ImageLoadingListener() { // from class: tv.danmaku.bili.ui.AuthPassedFragment.1
        public /* synthetic */ void onImageLoadFailed(Throwable th) {
            ImageLoadingListener.-CC.$default$onImageLoadFailed(this, th);
        }

        public /* synthetic */ void onImageLoading(Uri uri) {
            ImageLoadingListener.-CC.$default$onImageLoading(this, uri);
        }

        public /* synthetic */ void onImageSet(ImageInfo imageInfo, Bitmap bitmap) {
            ImageLoadingListener.-CC.$default$onImageSet(this, imageInfo, bitmap);
        }

        public /* synthetic */ void onIntermediateImageSet(ImageInfo imageInfo) {
            ImageLoadingListener.-CC.$default$onIntermediateImageSet(this, imageInfo);
        }

        public void onImageSet(ImageInfo imageInfo) {
            if (imageInfo != null && AuthPassedFragment.this.imageView != null) {
                ViewGroup.LayoutParams layoutParams = AuthPassedFragment.this.imageView.getLayoutParams();
                layoutParams.height = (int) ((imageInfo.getHeight() / imageInfo.getWidth()) * layoutParams.width);
                AuthPassedFragment.this.imageView.setLayoutParams(layoutParams);
            }
        }
    };
    StaticImageView2 imageView;
    private TextView mTvCard;
    private TextView mTvRealName;
    public static String EXTRA_INNER_KEY_NAME = ChannelRoutes.CHANNEL_NAME;
    public static String EXTRA_INNER_KEY_CARD = "card";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            AuthResultCbHelper.setResultToActivity((Activity) activity, 3);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bili_app_fragment_auth_passed, container, false);
        this.mTvRealName = (TextView) view.findViewById(R.id.tv_realname);
        this.mTvCard = (TextView) view.findViewById(R.id.tv_card);
        this.imageView = view.findViewById(R.id.iv_bg);
        BiliImageLoader.INSTANCE.with(view.getContext()).url(AppResUtil.getImageUrl("img_holder_pay_success.webp")).imageLoadingListener(this.imageLoadingListener).into(this.imageView);
        Bundle extra = getArguments();
        if (extra != null) {
            String name = extra.getString(EXTRA_INNER_KEY_NAME);
            String card = extra.getString(EXTRA_INNER_KEY_CARD);
            this.mTvRealName.setText(getString(bili.resource.account.R.string.account_global_string_307, new Object[]{name == null ? "" : name}));
            this.mTvCard.setText(getString(bili.resource.account.R.string.account_global_string_332, new Object[]{card != null ? card : ""}));
        }
        return view;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            setTitle(activity.getString(bili.resource.account.R.string.account_global_string_285));
        }
    }
}