package tv.danmaku.bili.ui.main.imagerecognize;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import bolts.Task;
import com.bilibili.app.dialogmanager.MainDialogManager;
import com.bilibili.droid.BundleUtil;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.ImageRequestBuilder;
import com.bilibili.lib.image2.bean.ImageInfo;
import com.bilibili.lib.image2.bean.ImageLoadingListener;
import com.bilibili.lib.image2.bean.ScaleType;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.lib.resmanager.ResManager;
import com.bilibili.lib.resmanager.ResRequest;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.BaseAppCompatActivity;
import com.opensource.svgaplayer.SVGAImageView;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import java.net.URL;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.flowcontrol.internal.config.FlowControlConfig;
import tv.danmaku.bili.splash.ad.config.BusinessSplashDefine;
import tv.danmaku.bili.widget.PendantAvatarFrameLayout;

/* compiled from: ImageRecognizeDialogActivity.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\b\u0010\u000b\u001a\u00020\bH\u0014J\b\u0010\f\u001a\u00020\bH\u0002J\b\u0010\u000f\u001a\u00020\bH\u0016J\u0012\u0010\u0010\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\bH\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Ltv/danmaku/bili/ui/main/imagerecognize/ImageRecognizeDialogActivity;", "Lcom/bilibili/lib/ui/BaseAppCompatActivity;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "mUrlInfo", "Ltv/danmaku/bili/ui/main/imagerecognize/ImageUrlInfo;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "initView", "mRunnable", "Ljava/lang/Runnable;", "finish", "onClick", "v", "Landroid/view/View;", "onDestroy", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ImageRecognizeDialogActivity extends BaseAppCompatActivity implements View.OnClickListener {
    public static final int $stable = 8;
    private final Runnable mRunnable = new Runnable() { // from class: tv.danmaku.bili.ui.main.imagerecognize.ImageRecognizeDialogActivity$$ExternalSyntheticLambda1
        @Override // java.lang.Runnable
        public final void run() {
            ImageRecognizeDialogActivity.this.finish();
        }
    };
    private ImageUrlInfo mUrlInfo;

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    protected void onCreate(Bundle savedInstanceState) {
        Bundle bundleExtra;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bili_app_layout_image_recognize_dialog);
        Intent intent = getIntent();
        this.mUrlInfo = (intent == null || (bundleExtra = intent.getBundleExtra(BundleUtil.KEY_DEFAULT_EXTRA_BUNDLE)) == null) ? null : (ImageUrlInfo) bundleExtra.getParcelable(ImageRecognizeDialogActivityKt.ARGS_IMAGE_URL_INFO);
        if (this.mUrlInfo == null) {
            finish();
            return;
        }
        initView();
        ImageRecognizeHelper imageRecognizeHelper = ImageRecognizeHelper.INSTANCE;
        ImageUrlInfo imageUrlInfo = this.mUrlInfo;
        Intrinsics.checkNotNull(imageUrlInfo);
        imageRecognizeHelper.reportDialogShow$core_apinkDebug(imageUrlInfo);
    }

    protected void onStart() {
        super.onStart();
        Window $this$onStart_u24lambda_u240 = getWindow();
        if ($this$onStart_u24lambda_u240 != null) {
            $this$onStart_u24lambda_u240.setGravity(17);
            $this$onStart_u24lambda_u240.setLayout(-2, -2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x032b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void initView() {
        Integer intOrNull;
        View labelContainer;
        int i;
        BiliImageView cover = findViewById(R.id.cover);
        TextView playNum = (TextView) findViewById(R.id.play_num);
        View playNumIc = findViewById(R.id.play_num_icon);
        TextView duration = (TextView) findViewById(R.id.duration);
        TextView title = (TextView) findViewById(R.id.title);
        PendantAvatarFrameLayout avatar = findViewById(R.id.avatar);
        TextView nickname = (TextView) findViewById(R.id.nickname);
        TextView fansNum = (TextView) findViewById(R.id.fans_num);
        TextView hint = (TextView) findViewById(R.id.hint);
        final View playIc = findViewById(R.id.play_ic);
        BiliImageView fullCover = findViewById(R.id.full_cover);
        View content = findViewById(R.id.dialog_content);
        final View labelContainer2 = findViewById(R.id.label_container);
        BiliImageView imageLabel = findViewById(R.id.image_label);
        final SVGAImageView svgaLabel = findViewById(R.id.svga_label);
        Button playBtn = (Button) findViewById(R.id.play);
        playBtn.setOnClickListener(this);
        cover.setOnClickListener(this);
        fullCover.setOnClickListener(this);
        findViewById(R.id.close_btn).setOnClickListener(this);
        ImageUrlInfo $this$initView_u24lambda_u240 = this.mUrlInfo;
        if ($this$initView_u24lambda_u240 != null) {
            if ($this$initView_u24lambda_u240.getShareType() == 2) {
                content.setVisibility(8);
                fullCover.setVisibility(0);
                ImageRequestBuilder url = BiliImageLoader.INSTANCE.with((FragmentActivity) this).url(BusinessSplashDefine.FILE_URI_PREFIX + $this$initView_u24lambda_u240.getImageLocalPath());
                ScaleType scaleType = ScaleType.CENTER_CROP;
                Intrinsics.checkNotNullExpressionValue(scaleType, "CENTER_CROP");
                ImageRequestBuilder failureImageResId$default = ImageRequestBuilder.failureImageResId$default(url.actualImageScaleType(scaleType), com.bilibili.app.comm.baseres.R.drawable.bili_default_image_tv, (ScaleType) null, 2, (Object) null);
                Intrinsics.checkNotNull(fullCover);
                failureImageResId$default.into(fullCover);
            } else {
                content.setVisibility(0);
                fullCover.setVisibility(8);
                ImageRequestBuilder url2 = BiliImageLoader.INSTANCE.with((FragmentActivity) this).url(BusinessSplashDefine.FILE_URI_PREFIX + $this$initView_u24lambda_u240.getImageLocalPath());
                ScaleType scaleType2 = ScaleType.CENTER_CROP;
                Intrinsics.checkNotNullExpressionValue(scaleType2, "CENTER_CROP");
                ImageRequestBuilder imageLoadingListener = ImageRequestBuilder.failureImageResId$default(url2.actualImageScaleType(scaleType2), com.bilibili.app.comm.baseres.R.drawable.bili_default_image_tv, (ScaleType) null, 2, (Object) null).imageLoadingListener(new ImageLoadingListener() { // from class: tv.danmaku.bili.ui.main.imagerecognize.ImageRecognizeDialogActivity$initView$1$1
                    public /* synthetic */ void onImageLoading(Uri uri) {
                        ImageLoadingListener.-CC.$default$onImageLoading(this, uri);
                    }

                    public /* synthetic */ void onImageSet(ImageInfo imageInfo) {
                        ImageLoadingListener.-CC.$default$onImageSet(this, imageInfo);
                    }

                    public /* synthetic */ void onImageSet(ImageInfo imageInfo, Bitmap bitmap) {
                        ImageLoadingListener.-CC.$default$onImageSet(this, imageInfo, bitmap);
                    }

                    public /* synthetic */ void onIntermediateImageSet(ImageInfo imageInfo) {
                        ImageLoadingListener.-CC.$default$onIntermediateImageSet(this, imageInfo);
                    }

                    public void onImageLoadFailed(Throwable err) {
                        playIc.setVisibility(8);
                    }
                });
                Intrinsics.checkNotNull(cover);
                imageLoadingListener.into(cover);
                if (TextUtils.isEmpty($this$initView_u24lambda_u240.getPlayCount())) {
                    playNum.setVisibility(8);
                    playNumIc.setVisibility(8);
                } else {
                    playNum.setText($this$initView_u24lambda_u240.getPlayCount());
                }
                title.setText($this$initView_u24lambda_u240.getTitle());
                duration.setText($this$initView_u24lambda_u240.getDuration());
                ShareAuthor $this$initView_u24lambda_u240_u240 = $this$initView_u24lambda_u240.getAuthor();
                if ($this$initView_u24lambda_u240_u240 != null) {
                    PendantAvatarFrameLayout.ShowParams showParams = new PendantAvatarFrameLayout.ShowParams().avatarImgUrl($this$initView_u24lambda_u240_u240.getAvatarUrl()).badgeImgRes($this$initView_u24lambda_u240_u240.getVerifyIcon()).defaultAvatar(com.bilibili.app.comm.baseres.R.drawable.ic_default_avatar);
                    avatar.show(showParams);
                    nickname.setText($this$initView_u24lambda_u240_u240.getNickname());
                    if (!TextUtils.isEmpty($this$initView_u24lambda_u240_u240.getFollower())) {
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        Locale locale = Locale.US;
                        Resources resources = getResources();
                        int i2 = bili.resource.common.R.plurals.common_global_string_440;
                        String follower = $this$initView_u24lambda_u240_u240.getFollower();
                        String quantityString = resources.getQuantityString(i2, (follower == null || (intOrNull = StringsKt.toIntOrNull(follower)) == null) ? FlowControlConfig.RETRY_MAX_TIMES : intOrNull.intValue(), $this$initView_u24lambda_u240_u240.getFollower());
                        Intrinsics.checkNotNullExpressionValue(quantityString, "getQuantityString(...)");
                        String format = String.format(locale, quantityString, Arrays.copyOf(new Object[]{$this$initView_u24lambda_u240_u240.getFollower()}, 1));
                        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                        fansNum.setText(format);
                    }
                }
                if (!TextUtils.isEmpty($this$initView_u24lambda_u240.getMessage())) {
                    hint.setText($this$initView_u24lambda_u240.getMessage());
                    hint.setVisibility(0);
                } else {
                    hint.setVisibility(8);
                }
            }
            if ($this$initView_u24lambda_u240.getAutoClose()) {
                int delay = $this$initView_u24lambda_u240.getAutoCloseTime() > 0 ? $this$initView_u24lambda_u240.getAutoCloseTime() : 5;
                HandlerThreads.postDelayed(0, this.mRunnable, delay * 1000);
            }
            if (TextUtils.isEmpty($this$initView_u24lambda_u240.getMarkUrl())) {
                labelContainer = labelContainer2;
                i = 8;
            } else if ($this$initView_u24lambda_u240.getMarkType() != 0) {
                labelContainer2.setVisibility(0);
                switch ($this$initView_u24lambda_u240.getMarkType()) {
                    case 1:
                        imageLabel.setVisibility(0);
                        svgaLabel.setVisibility(8);
                        ImageRequestBuilder url3 = BiliImageLoader.INSTANCE.with((FragmentActivity) this).url($this$initView_u24lambda_u240.getMarkUrl());
                        Intrinsics.checkNotNull(imageLabel);
                        url3.into(imageLabel);
                        break;
                    case 2:
                        svgaLabel.setVisibility(0);
                        imageLabel.setVisibility(8);
                        SVGAParser sVGAParser = new SVGAParser((Context) this);
                        URL url4 = new URL($this$initView_u24lambda_u240.getMarkUrl());
                        String markUrl = $this$initView_u24lambda_u240.getMarkUrl();
                        Intrinsics.checkNotNull(markUrl);
                        sVGAParser.parse(url4, markUrl, new SVGAParser.ParseCompletion() { // from class: tv.danmaku.bili.ui.main.imagerecognize.ImageRecognizeDialogActivity$initView$1$3
                            public void onComplete(SVGAVideoEntity videoItem) {
                                Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                                svgaLabel.setVideoItem(videoItem);
                                svgaLabel.startAnimation();
                            }

                            public void onError() {
                                labelContainer2.setVisibility(8);
                            }

                            public void onCacheExist() {
                            }
                        });
                        break;
                    default:
                        labelContainer2.setVisibility(8);
                        break;
                }
                if (TextUtils.isEmpty($this$initView_u24lambda_u240.getButtonText())) {
                    playBtn.setText($this$initView_u24lambda_u240.getButtonText());
                    return;
                }
                return;
            } else {
                labelContainer = labelContainer2;
                i = 8;
            }
            labelContainer.setVisibility(i);
            if (TextUtils.isEmpty($this$initView_u24lambda_u240.getButtonText())) {
            }
        }
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.anim_op_biz_dialog_out);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (v == null) {
            return;
        }
        int id = v.getId();
        if (id == R.id.play || id == R.id.cover || id == R.id.full_cover) {
            ImageRecognizeHelperKt.routerToSchema((Activity) this, this.mUrlInfo);
        } else if (id == R.id.close_btn) {
            finish();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        HandlerThreads.remove(0, this.mRunnable);
        MainDialogManager.showNextDialog("share_image_recognize", false, (Context) this);
        Task.callInBackground(new Callable() { // from class: tv.danmaku.bili.ui.main.imagerecognize.ImageRecognizeDialogActivity$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Unit onDestroy$lambda$0;
                onDestroy$lambda$0 = ImageRecognizeDialogActivity.onDestroy$lambda$0(ImageRecognizeDialogActivity.this);
                return onDestroy$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onDestroy$lambda$0(ImageRecognizeDialogActivity this$0) {
        if (this$0.mUrlInfo != null) {
            ImageUrlInfo imageUrlInfo = this$0.mUrlInfo;
            Intrinsics.checkNotNull(imageUrlInfo);
            ResManager.delete(new ResRequest(imageUrlInfo.getPicUrl(), (String) null, 2, (DefaultConstructorMarker) null));
        }
        return Unit.INSTANCE;
    }
}