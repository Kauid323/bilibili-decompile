package tv.danmaku.bili.videopage.common.widget.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.bapis.bilibili.app.view.v1.NftFaceIcon;
import com.bilibili.droid.TalkbackUtilsKt;
import com.bilibili.lib.accountinfo.model.OfficialVerify;
import com.bilibili.lib.avatar.widget.RoundBorderImageView;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.BiliImageLoaderHelper;
import com.bilibili.lib.image2.bean.RoundingParams;
import com.bilibili.lib.image2.bean.ScaleType;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.lib.ui.util.MultipleThemeUtils;
import com.bilibili.magicasakura.widgets.TintLinearLayout;
import com.bilibili.magicasakura.widgets.TintTextView;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.videopage.common.helper.DisplayUtils;
import tv.danmaku.bili.videopage.common.widget.LiveAvatarStore;
import tv.danmaku.biliplayer.baseres.R;

public class VerifyAvatarFrameLayout extends FrameLayout {
    private final String TAG;
    private final int defaultBorderColor;
    protected BiliImageView mAvatarImg;
    private String mAvatarUrl;
    protected Boolean mLiveAvatarState;
    private LiveAvatarStore mLiveAvatarStore;
    protected LiveAvatarCircleView mLiveCircleView;
    protected TintLinearLayout mLiveDescLayout;
    protected RoundBorderImageView mVerifyImg;

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public enum VSize {
        SMALL(10),
        MED(14),
        LARGE(16),
        SUPERB(22);
        
        public int dp;

        VSize(int dp) {
            this.dp = dp;
        }
    }

    public VerifyAvatarFrameLayout(Context context) {
        this(context, null);
    }

    public VerifyAvatarFrameLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public VerifyAvatarFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mLiveAvatarState = false;
        this.defaultBorderColor = Color.argb(15, 0, 0, 0);
        this.TAG = "VerifyAvatar";
        init(context, attrs);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mLiveAvatarStore != null) {
            this.mLiveAvatarStore.stop();
        }
    }

    public void setAvatarLength(int length) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getPx(length), getPx(length));
        layoutParams.gravity = 17;
        this.mAvatarImg.setLayoutParams(layoutParams);
    }

    private void init(Context context, AttributeSet set) {
        this.mAvatarImg = new BiliImageView(context);
        this.mAvatarImg.setAspectRatio(1.0f);
        TalkbackUtilsKt.setViewContentDescription(this.mAvatarImg, "up主头像");
        addView(this.mAvatarImg);
        this.mLiveAvatarStore = new LiveAvatarStore(context);
        this.mLiveCircleView = new LiveAvatarCircleView(context);
        FrameLayout.LayoutParams circleLp = new FrameLayout.LayoutParams(getPx(42), getPx(42));
        circleLp.gravity = 17;
        this.mLiveCircleView.setLayoutParams(circleLp);
        this.mLiveAvatarStore.addCircleView(this.mLiveCircleView);
        this.mLiveCircleView.setVisibility(8);
        addView(this.mLiveCircleView);
        TypedArray ta = context.obtainStyledAttributes(set, R.styleable.VerifyAvatarFrameLayout);
        int rightMargin = ta.getDimensionPixelOffset(R.styleable.VerifyAvatarFrameLayout_verifyImageRightMargin, 0);
        int bottomMargin = ta.getDimensionPixelOffset(R.styleable.VerifyAvatarFrameLayout_verifyImageBottomMargin, 0);
        this.mVerifyImg = new RoundBorderImageView(context);
        FrameLayout.LayoutParams lp1 = new FrameLayout.LayoutParams(-2, -2);
        lp1.gravity = 8388693;
        lp1.rightMargin = rightMargin;
        lp1.bottomMargin = bottomMargin;
        this.mVerifyImg.setLayoutParams(lp1);
        this.mVerifyImg.setVisibility(8);
        addView(this.mVerifyImg);
        FrameLayout.LayoutParams lp0 = new FrameLayout.LayoutParams(getPx(52), getPx(16));
        lp0.gravity = 81;
        this.mLiveDescLayout = new TintLinearLayout(context);
        this.mLiveDescLayout.setGravity(17);
        this.mLiveDescLayout.setBackgroundResource(R.drawable.bili_video_avatar_live_desc_bg);
        this.mLiveDescLayout.setOrientation(0);
        this.mLiveDescLayout.setLayoutParams(lp0);
        LottieAnimationView mLottieAnimationView = new LottieAnimationView(context);
        LinearLayout.LayoutParams lottieLp = new LinearLayout.LayoutParams(getPx(10), getPx(10));
        mLottieAnimationView.setLayoutParams(lottieLp);
        mLottieAnimationView.setAnimation("player_live_avatar_anim.json");
        mLottieAnimationView.setRepeatMode(1);
        this.mLiveDescLayout.addView(mLottieAnimationView);
        this.mLiveAvatarStore.addLottieViews(mLottieAnimationView);
        TintTextView mLiveHintText = new TintTextView(context);
        LinearLayout.LayoutParams liveHintLp = new LinearLayout.LayoutParams(-2, -2);
        liveHintLp.leftMargin = getPx(1);
        mLiveHintText.setLayoutParams(liveHintLp);
        mLiveHintText.setTextAppearance(context, R.style.VideoDetailLiveTag);
        mLiveHintText.setText(context.getResources().getString(bili.resource.playerbaseres.R.string.playerbaseres_global_string_655));
        this.mLiveDescLayout.addView(mLiveHintText);
        this.mLiveDescLayout.setVisibility(8);
        addView(this.mLiveDescLayout);
        ta.recycle();
    }

    public void setLiveAvatarState(Boolean isUseLiveAvatar) {
        this.mLiveAvatarState = isUseLiveAvatar;
    }

    public void displayAvatar(String url) {
        if (this.mAvatarImg == null || TextUtils.isEmpty(url)) {
            return;
        }
        this.mAvatarUrl = url;
        if (this.mLiveAvatarState.booleanValue()) {
            this.mLiveCircleView.setVisibility(0);
            this.mLiveDescLayout.setVisibility(0);
            this.mLiveAvatarStore.getConfig().onTint(getContext());
            this.mLiveAvatarStore.start();
            BiliImageLoader.INSTANCE.with(getContext()).url(this.mAvatarUrl).actualImageScaleType(ScaleType.CENTER_CROP).roundingParams(RoundingParams.asCircle()).into(this.mAvatarImg);
            return;
        }
        this.mLiveCircleView.setVisibility(8);
        this.mLiveDescLayout.setVisibility(8);
        this.mLiveAvatarStore.stop();
        BiliImageLoader.INSTANCE.with(getContext()).url(this.mAvatarUrl).actualImageScaleType(ScaleType.CENTER_CROP).roundingParams(RoundingParams.asCircle().setBorder(this.defaultBorderColor, getPx(1))).into(this.mAvatarImg);
    }

    public void displayAvatar(int resource) {
        if (this.mAvatarImg == null || resource < 0) {
            return;
        }
        String url = BiliImageLoaderHelper.resourceToUri(this.mAvatarImg.getContext().getPackageName(), resource);
        BiliImageLoader.INSTANCE.with(getContext()).url(url).roundingParams(RoundingParams.asCircle().setBorder(this.defaultBorderColor, getPx(1))).into(this.mAvatarImg);
    }

    public void displayAvatar(String url, int placeHolder, int failedId, int borderColor) {
        if (TextUtils.equals(this.mAvatarUrl, url) && url != null) {
            return;
        }
        this.mAvatarUrl = url;
        int color = this.defaultBorderColor;
        if (borderColor != -1) {
            color = borderColor;
        }
        BiliImageLoader.INSTANCE.with(getContext()).url(url).roundingParams(RoundingParams.asCircle().setBorder(color, getPx(1))).placeholderImageResId(placeHolder).failureImageResId(failedId).into(this.mAvatarImg);
    }

    public void setOfficialVerify(OfficialVerify officialVerify, NftFaceIcon nftFaceIcon, VSize size) {
        RoundBorderImageView verifyImg = this.mVerifyImg;
        if (verifyImg == null) {
            return;
        }
        if (this.mLiveAvatarState.booleanValue()) {
            verifyImg.setVisibility(8);
            return;
        }
        int round = getPx(size.dp);
        verifyImg.getLayoutParams().width = round;
        verifyImg.getLayoutParams().height = round;
        verifyImg.setVisibility(8);
        if (officialVerify != null) {
            switch (officialVerify.type) {
                case 0:
                    verifyImg.setVisibility(0);
                    int person = getVPerson(size);
                    setVerifyImg(person);
                    return;
                case 1:
                    verifyImg.setVisibility(0);
                    int company = getVCompany(size);
                    setVerifyImg(company);
                    return;
                default:
                    if (!checkNftVerify(nftFaceIcon, verifyImg)) {
                        verifyImg.setVisibility(8);
                        return;
                    }
                    return;
            }
        }
        checkNftVerify(nftFaceIcon, verifyImg);
    }

    private boolean checkNftVerify(NftFaceIcon nftFaceIcon, RoundBorderImageView verifyImg) {
        if (nftFaceIcon == null) {
            return false;
        }
        try {
            verifyImg.setVisibility(0);
            int color = getResources().getColor(com.bilibili.lib.theme.R.color.Wh0);
            this.mVerifyImg.setBorder(DisplayUtils.dp2Px(1.0f), color);
            BiliImageLoader.INSTANCE.with(getContext()).url(nftFaceIcon.getIcon()).enableAutoPlayAnimation(true).into(verifyImg.getImageView());
            return true;
        } catch (Exception e) {
            verifyImg.setVisibility(8);
            BLog.e("VerifyAvatar", "nft icon uri parsed failed");
            return false;
        }
    }

    public void setVerifyImg(int resource) {
        if (this.mVerifyImg == null) {
            return;
        }
        if (this.mVerifyImg.getVisibility() != 0) {
            this.mVerifyImg.setVisibility(0);
        }
        Drawable image = ContextCompat.getDrawable(getContext(), resource);
        if (image != null) {
            this.mVerifyImg.getImageView().getGenericProperties().setImage(image);
        }
        boolean night = MultipleThemeUtils.isNightTheme(getContext());
        int color = 0;
        if (night) {
            color = getResources().getColor(com.bilibili.lib.theme.R.color.Wh0);
        }
        this.mVerifyImg.getImageView().getGenericProperties().setRoundingParams(RoundingParams.asCircle().setBorder(color, DisplayUtils.dp2Px(1.5f)));
    }

    public void setVerifyImgSize(VSize size) {
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

    private int getVCompany(VSize vsize) {
        switch (vsize) {
            case SMALL:
                return com.bilibili.app.comm.baseres.R.drawable.ic_authentication_organization_size_8;
            case MED:
                return R.drawable.ic_authentication_organization_size_14;
            case LARGE:
                return com.bilibili.app.comm.baseres.R.drawable.ic_authentication_organization_size_16;
            case SUPERB:
                return com.bilibili.app.comm.baseres.R.drawable.ic_authentication_organization_size_22;
            default:
                return com.bilibili.app.comm.baseres.R.drawable.ic_authentication_organization_size_8;
        }
    }

    private int getVPerson(VSize vsize) {
        switch (vsize) {
            case SMALL:
                return com.bilibili.app.comm.baseres.R.drawable.ic_authentication_personal_size_8;
            case MED:
                return R.drawable.ic_authentication_personal_size_14;
            case LARGE:
                return com.bilibili.app.comm.baseres.R.drawable.ic_authentication_personal_size_16;
            case SUPERB:
                return com.bilibili.app.comm.baseres.R.drawable.ic_authentication_personal_size_22;
            default:
                return com.bilibili.app.comm.baseres.R.drawable.ic_authentication_personal_size_8;
        }
    }

    private int getPx(int dp) {
        return (int) TypedValue.applyDimension(1, dp, getResources().getDisplayMetrics());
    }
}