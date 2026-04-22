package tv.danmaku.bili.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.res.ResourcesCompat;
import bolts.Continuation;
import bolts.Task;
import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.fastjson.JSON;
import com.bilibili.app.authorspace.ui.widget.VerifyAvatarFrameLayout;
import com.bilibili.droid.StringUtil;
import com.bilibili.lib.accountinfo.model.OfficialInfo;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.BiliImageLoaderHelper;
import com.bilibili.lib.image2.ImageRequestBuilder;
import com.bilibili.lib.image2.bean.RoundingParams;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.lib.okhttp.OkHttpClientWrapper;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.player.utils.BitmapUtil;
import tv.danmaku.bili.widget.VerifyAnimationAvatarFrameLayout;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;

public class VerifyAnimationAvatarFrameLayout extends FrameLayout {
    protected BiliImageView mAvatarImg;
    private String mAvatarUrl;
    private int mBottomMargin;
    protected LottieAnimationView mLottieView;
    private int mRightMargin;
    private RoundingParams mRoundingParams;
    protected ImageView mVerifyImg;

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public enum VType {
        IMG,
        LOTTIE
    }

    public VerifyAnimationAvatarFrameLayout(Context context) {
        this(context, null);
    }

    public VerifyAnimationAvatarFrameLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public VerifyAnimationAvatarFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray ta = context.obtainStyledAttributes(attrs, tv.danmaku.bili.R.styleable.VerifyAvatarFrameLayout);
        this.mRightMargin = ta.getDimensionPixelOffset(tv.danmaku.bili.R.styleable.VerifyAvatarFrameLayout_verifyImageRightMargin, 0);
        this.mBottomMargin = ta.getDimensionPixelOffset(tv.danmaku.bili.R.styleable.VerifyAvatarFrameLayout_verifyImageBottomMargin, 0);
        ta.recycle();
        this.mRoundingParams = new RoundingParams();
        this.mRoundingParams.setRoundAsCircle(true);
        this.mRoundingParams.setBorderWidth((float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
    }

    private void initViews(VType type) {
        removeAllViews();
        if (type == VType.IMG) {
            addImageView();
        } else {
            addLottieView();
        }
        this.mVerifyImg = new ImageView(getContext());
        FrameLayout.LayoutParams lp1 = new FrameLayout.LayoutParams(-2, -2);
        lp1.gravity = 8388693;
        lp1.rightMargin = this.mRightMargin;
        lp1.bottomMargin = this.mBottomMargin;
        this.mVerifyImg.setLayoutParams(lp1);
        this.mVerifyImg.setVisibility(8);
        addView(this.mVerifyImg);
    }

    private void addLottieView() {
        if (this.mLottieView == null) {
            this.mLottieView = new LottieAnimationView(getContext());
            FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(-1, -1);
            this.mLottieView.setLayoutParams(lp);
            this.mLottieView.setRepeatCount(-1);
        }
        addView(this.mLottieView);
    }

    private void addImageView() {
        if (this.mAvatarImg == null) {
            this.mAvatarImg = new BiliImageView(new ContextThemeWrapper(getContext(), com.bilibili.app.authorspace.R.style.Widget_App_StaticImageView_Thumb_Custom_CircleAvatar));
            FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(-1, -1);
            this.mAvatarImg.setLayoutParams(lp);
        }
        addView(this.mAvatarImg);
    }

    public void displayAvatar(String url, VType type, int placeHolder, int failedId) {
        displayAvatar(url, type, null, null, placeHolder, failedId);
    }

    public void displayAvatar(final String url, final VType type, final String placeHolder, final String failed, final int placeHolderRes, final int failedIdRes) {
        post(new Runnable() { // from class: tv.danmaku.bili.widget.VerifyAnimationAvatarFrameLayout$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                VerifyAnimationAvatarFrameLayout.this.m2060lambda$displayAvatar$2$tvdanmakubiliwidgetVerifyAnimationAvatarFrameLayout(url, type, placeHolder, failed, placeHolderRes, failedIdRes);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$displayAvatar$2$tv-danmaku-bili-widget-VerifyAnimationAvatarFrameLayout  reason: not valid java name */
    public /* synthetic */ void m2060lambda$displayAvatar$2$tvdanmakubiliwidgetVerifyAnimationAvatarFrameLayout(final String url, final VType type, final String placeHolder, final String failed, final int placeHolderRes, final int failedIdRes) {
        if (TextUtils.equals(this.mAvatarUrl, url) && url != null) {
            return;
        }
        initViews(type);
        this.mAvatarUrl = url;
        Task.callInBackground(new Callable() { // from class: tv.danmaku.bili.widget.VerifyAnimationAvatarFrameLayout$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return VerifyAnimationAvatarFrameLayout.this.m2058lambda$displayAvatar$0$tvdanmakubiliwidgetVerifyAnimationAvatarFrameLayout(placeHolder, failed);
            }
        }).continueWith(new Continuation() { // from class: tv.danmaku.bili.widget.VerifyAnimationAvatarFrameLayout$$ExternalSyntheticLambda2
            public final Object then(Task task) {
                return VerifyAnimationAvatarFrameLayout.this.m2059lambda$displayAvatar$1$tvdanmakubiliwidgetVerifyAnimationAvatarFrameLayout(type, placeHolderRes, failedIdRes, url, task);
            }
        }, Task.UI_THREAD_EXECUTOR);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$displayAvatar$0$tv-danmaku-bili-widget-VerifyAnimationAvatarFrameLayout  reason: not valid java name */
    public /* synthetic */ Pair m2058lambda$displayAvatar$0$tvdanmakubiliwidgetVerifyAnimationAvatarFrameLayout(String placeHolder, String failed) throws Exception {
        Bitmap placeHolderBitmap = readFromFile(BiliImageLoaderHelper.getDiskCacheFile(placeHolder));
        Bitmap failedBitmap = readFromFile(BiliImageLoaderHelper.getDiskCacheFile(failed));
        return new Pair(placeHolderBitmap, failedBitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$displayAvatar$1$tv-danmaku-bili-widget-VerifyAnimationAvatarFrameLayout  reason: not valid java name */
    public /* synthetic */ Void m2059lambda$displayAvatar$1$tvdanmakubiliwidgetVerifyAnimationAvatarFrameLayout(VType type, int placeHolderRes, int failedIdRes, String url, Task task) throws Exception {
        Pair<Bitmap, Bitmap> images = (Pair) task.getResult();
        Bitmap placeHolderBitmap = (Bitmap) images.first;
        Bitmap failedBitmap = (Bitmap) images.second;
        if (type == VType.IMG || StringUtil.isBlank(this.mAvatarUrl)) {
            ImageRequestBuilder avatarRequestBuilder = BiliImageLoader.INSTANCE.with(getContext()).roundingParams(this.mRoundingParams);
            if (placeHolderBitmap == null) {
                avatarRequestBuilder.placeholderImageResId(placeHolderRes);
            } else {
                avatarRequestBuilder.placeholderImageDrawable(new BitmapDrawable(getResources(), placeHolderBitmap));
            }
            if (failedBitmap == null) {
                avatarRequestBuilder.failureImageResId(failedIdRes);
            } else {
                avatarRequestBuilder.failureImageDrawable(new BitmapDrawable(getResources(), failedBitmap));
            }
            avatarRequestBuilder.url(url).into(this.mAvatarImg);
            return null;
        } else if (type == VType.LOTTIE) {
            if (placeHolderBitmap != null) {
                this.mLottieView.setImageBitmap(placeHolderBitmap);
            } else {
                this.mLottieView.setImageResource(placeHolderRes);
            }
            Request request = new Request.Builder().url(url).get().build();
            OkHttpClient client = OkHttpClientWrapper.get();
            client.newCall(request).enqueue(new LottieDownloadCallback(this.mLottieView, failedIdRes));
            return null;
        } else {
            return null;
        }
    }

    private Bitmap readFromFile(File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            return BitmapUtil.decodeFile(file.getPath(), getWidth(), getHeight());
        } catch (Exception e) {
            return null;
        }
    }

    public void displayAvatar(int resource) {
        if (resource < 0) {
            return;
        }
        this.mAvatarUrl = null;
        initViews(VType.IMG);
        if (this.mAvatarImg != null) {
            this.mAvatarImg.setImageDrawable(ResourcesCompat.getDrawable(getResources(), resource, getContext().getTheme()));
        }
    }

    public void setOfficialVerify(OfficialInfo officialVerify, VerifyAvatarFrameLayout.VSize size) {
        if (this.mVerifyImg == null) {
            return;
        }
        if (officialVerify == null) {
            this.mVerifyImg.setVisibility(8);
            return;
        }
        int round = getPx(size.dp);
        this.mVerifyImg.getLayoutParams().width = round;
        this.mVerifyImg.getLayoutParams().height = round;
        switch (officialVerify.getType()) {
            case 0:
                this.mVerifyImg.setVisibility(0);
                int person = getVPerson(size);
                this.mVerifyImg.setImageResource(person);
                return;
            case 1:
                this.mVerifyImg.setVisibility(0);
                int company = getVCompany(size);
                this.mVerifyImg.setImageResource(company);
                return;
            default:
                this.mVerifyImg.setVisibility(8);
                return;
        }
    }

    public void setVerifyImg(int resource) {
        if (this.mVerifyImg == null) {
            return;
        }
        this.mVerifyImg.setImageResource(resource);
        this.mVerifyImg.setVisibility(0);
    }

    public void setVerifyImgSize(VerifyAvatarFrameLayout.VSize size) {
        int round = getPx(size.dp);
        this.mVerifyImg.getLayoutParams().width = round;
        this.mVerifyImg.getLayoutParams().height = round;
    }

    public void setVerifyImgVisibility(int visibility) {
        if (this.mVerifyImg == null) {
            return;
        }
        this.mVerifyImg.setVisibility(visibility);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: tv.danmaku.bili.widget.VerifyAnimationAvatarFrameLayout$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bilibili$app$authorspace$ui$widget$VerifyAvatarFrameLayout$VSize = new int[VerifyAvatarFrameLayout.VSize.values().length];

        static {
            try {
                $SwitchMap$com$bilibili$app$authorspace$ui$widget$VerifyAvatarFrameLayout$VSize[VerifyAvatarFrameLayout.VSize.SMALL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$bilibili$app$authorspace$ui$widget$VerifyAvatarFrameLayout$VSize[VerifyAvatarFrameLayout.VSize.MED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$bilibili$app$authorspace$ui$widget$VerifyAvatarFrameLayout$VSize[VerifyAvatarFrameLayout.VSize.LARGE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$bilibili$app$authorspace$ui$widget$VerifyAvatarFrameLayout$VSize[VerifyAvatarFrameLayout.VSize.SUPERB.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    private int getVCompany(VerifyAvatarFrameLayout.VSize vsize) {
        switch (AnonymousClass1.$SwitchMap$com$bilibili$app$authorspace$ui$widget$VerifyAvatarFrameLayout$VSize[vsize.ordinal()]) {
            case 1:
                return com.bilibili.app.comm.baseres.R.drawable.ic_authentication_organization_size_8;
            case 2:
                return com.bilibili.app.comm.baseres.R.drawable.ic_authentication_organization_size_10;
            case 3:
                return com.bilibili.app.comm.baseres.R.drawable.ic_authentication_organization_size_16;
            case 4:
                return com.bilibili.app.comm.baseres.R.drawable.ic_authentication_organization_size_22;
            default:
                return com.bilibili.app.comm.baseres.R.drawable.ic_authentication_organization_size_8;
        }
    }

    private int getVPerson(VerifyAvatarFrameLayout.VSize vsize) {
        switch (AnonymousClass1.$SwitchMap$com$bilibili$app$authorspace$ui$widget$VerifyAvatarFrameLayout$VSize[vsize.ordinal()]) {
            case 1:
                return com.bilibili.app.comm.baseres.R.drawable.ic_authentication_personal_size_8;
            case 2:
                return com.bilibili.app.comm.baseres.R.drawable.ic_authentication_personal_size_10;
            case 3:
                return com.bilibili.app.comm.baseres.R.drawable.ic_authentication_personal_size_16;
            case 4:
                return com.bilibili.app.comm.baseres.R.drawable.ic_authentication_personal_size_22;
            default:
                return com.bilibili.app.comm.baseres.R.drawable.ic_authentication_personal_size_8;
        }
    }

    private int getPx(int dp) {
        return (int) TypedValue.applyDimension(1, dp, getResources().getDisplayMetrics());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class LottieDownloadCallback implements Callback {
        private int mFailResId;
        private WeakReference<LottieAnimationView> mViewRef;

        public LottieDownloadCallback(LottieAnimationView view2, int failResId) {
            this.mViewRef = new WeakReference<>(view2);
            this.mFailResId = failResId;
        }

        public void onFailure(Call call, IOException e) {
            BLog.e("download lottie avatar failure for url " + call.request().url(), e);
            LottieAnimationView view2 = this.mViewRef.get();
            if (view2 != null) {
                view2.setImageResource(this.mFailResId);
            }
        }

        public void onResponse(final Call call, final Response response) throws IOException {
            Task.call(new Callable() { // from class: tv.danmaku.bili.widget.VerifyAnimationAvatarFrameLayout$LottieDownloadCallback$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return VerifyAnimationAvatarFrameLayout.LottieDownloadCallback.this.m2061lambda$onResponse$0$tvdanmakubiliwidgetVerifyAnimationAvatarFrameLayout$LottieDownloadCallback(response, call);
                }
            }, Task.UI_THREAD_EXECUTOR);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$onResponse$0$tv-danmaku-bili-widget-VerifyAnimationAvatarFrameLayout$LottieDownloadCallback  reason: not valid java name */
        public /* synthetic */ Object m2061lambda$onResponse$0$tvdanmakubiliwidgetVerifyAnimationAvatarFrameLayout$LottieDownloadCallback(Response response, Call call) throws Exception {
            LottieAnimationView view2 = this.mViewRef.get();
            if (view2 != null) {
                if (response.isSuccessful() && response.body() != null) {
                    try {
                        String json = response.body().string();
                        JSON.parse(json);
                        view2.setAnimationFromJson(json);
                        view2.playAnimation();
                        return null;
                    } catch (Exception e) {
                        view2.setImageResource(this.mFailResId);
                        return null;
                    }
                }
                BLog.e("download lottie avatar failure for url " + call.request().url());
                view2.setImageResource(this.mFailResId);
                return null;
            }
            return null;
        }
    }
}