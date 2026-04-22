package tv.danmaku.bili.ui.rank.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bilibili.lib.accountinfo.model.OfficialVerify;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.BiliImageLoaderHelper;
import com.bilibili.lib.image2.view.legacy.StaticImageView2;
import tv.danmaku.bili.ui.rank.R;

public class VerifyAvatarFrameLayout extends FrameLayout {
    private StaticImageView2 mAvatarImg;
    private String mAvatarUrl;
    private ImageView mVerifyImg;

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public enum VSize {
        SMALL(10),
        MED(12),
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
        init(context, attrs);
    }

    private void init(Context context, AttributeSet set) {
        this.mAvatarImg = LayoutInflater.from(context).inflate(R.layout.bill_app_layout_list_item_rank_avatar, (ViewGroup) this, false);
        addView(this.mAvatarImg);
        TypedArray ta = context.obtainStyledAttributes(set, R.styleable.VerifyAvatarFrameLayout);
        int rightMargin = ta.getDimensionPixelOffset(R.styleable.VerifyAvatarFrameLayout_verifyImageRightMargin, 0);
        int bottomMargin = ta.getDimensionPixelOffset(R.styleable.VerifyAvatarFrameLayout_verifyImageBottomMargin, 0);
        this.mVerifyImg = new ImageView(context);
        FrameLayout.LayoutParams lp1 = new FrameLayout.LayoutParams(-2, -2);
        lp1.gravity = 8388693;
        lp1.rightMargin = rightMargin;
        lp1.bottomMargin = bottomMargin;
        this.mVerifyImg.setLayoutParams(lp1);
        this.mVerifyImg.setVisibility(8);
        addView(this.mVerifyImg);
        ta.recycle();
    }

    public void displayAvatar(String url) {
        if (this.mAvatarImg == null || TextUtils.isEmpty(url) || TextUtils.equals(this.mAvatarUrl, url)) {
            return;
        }
        this.mAvatarUrl = url;
        BiliImageLoader.INSTANCE.with(getContext()).url(url).into(this.mAvatarImg);
    }

    public void displayAvatar(int resource) {
        if (this.mAvatarImg == null || resource < 0) {
            return;
        }
        this.mAvatarUrl = null;
        BiliImageLoader.INSTANCE.with(getContext()).url(BiliImageLoaderHelper.resourceToUri(resource)).into(this.mAvatarImg);
    }

    public void setOfficialVerify(OfficialVerify officialVerify, VSize size) {
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
        switch (officialVerify.type) {
            case -1:
                this.mVerifyImg.setVisibility(8);
                return;
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
                return com.bilibili.app.comm.baseres.R.drawable.ic_authentication_organization_size_10;
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
                return com.bilibili.app.comm.baseres.R.drawable.ic_authentication_personal_size_10;
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