package tv.danmaku.bili.videopage.common.widget.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bilibili.droid.TalkbackUtilsKt;
import com.bilibili.lib.ui.util.NightTheme;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import tv.danmaku.bili.videopage.common.helper.DisplayUtils;
import tv.danmaku.biliplayer.baseres.R;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: VerifyAvatarWithFollow.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001c\u0010\u0010\u001a\u00020\u00112\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J0\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\nH\u0014Jj\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010!\u001a\u0004\u0018\u00010\u001f2\u0014\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u001fH\u0007J\u0006\u0010'\u001a\u00020(J\u0006\u0010\u001a\u001a\u00020\u001bR\u000e\u0010\f\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Ltv/danmaku/bili/videopage/common/widget/view/VerifyAvatarWithFollow;", "Ltv/danmaku/bili/videopage/common/widget/view/VerifyAvatarWithTopLabel;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mLeftOffset", "mTopOffset", "mFollowButton", "Ltv/danmaku/bili/videopage/common/widget/view/VerifyLottieFollowButton;", "init", "", "onLayout", "changed", "", "left", "top", "right", "bottom", "bindFollow", "authorId", "", "from", "followed", "spmid", "", "fromSpmid", "fromScmid", "extendContent", "Ljava/util/HashMap;", "followCallback", "Ltv/danmaku/bili/videopage/common/widget/view/FollowCallback;", "loginToast", "followButton", "Landroid/view/View;", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public class VerifyAvatarWithFollow extends VerifyAvatarWithTopLabel {
    private VerifyLottieFollowButton mFollowButton;
    private final int mLeftOffset;
    private final int mTopOffset;

    public final void bindFollow(long j, int i, boolean z, String str, String str2, String str3, HashMap<String, String> hashMap, FollowCallback followCallback) {
        bindFollow$default(this, j, i, z, str, str2, str3, hashMap, followCallback, null, IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN, null);
    }

    public VerifyAvatarWithFollow(Context context) {
        this(context, null);
    }

    public VerifyAvatarWithFollow(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public VerifyAvatarWithFollow(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mLeftOffset = DisplayUtils.dp2Px(4);
        this.mTopOffset = DisplayUtils.dp2Px(2);
        init(context, attrs);
    }

    private final void init(Context context, AttributeSet attrs) {
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(-2, -2);
        this.mFollowButton = new VerifyLottieFollowButton(context);
        VerifyLottieFollowButton verifyLottieFollowButton = this.mFollowButton;
        VerifyLottieFollowButton verifyLottieFollowButton2 = null;
        if (verifyLottieFollowButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFollowButton");
            verifyLottieFollowButton = null;
        }
        verifyLottieFollowButton.setRepeatCount(0);
        if (attrs != null) {
            Intrinsics.checkNotNull(context);
            TypedArray arrays = context.obtainStyledAttributes(attrs, R.styleable.VerifyAvatarWithFollow);
            Intrinsics.checkNotNullExpressionValue(arrays, "obtainStyledAttributes(...)");
            String fileName = arrays.getString(R.styleable.VerifyAvatarWithFollow_followAnimationFileName);
            if (TextUtils.isEmpty(fileName)) {
                fileName = "player_follow_guide.json";
            }
            if (NightTheme.isNightTheme(context)) {
                Intrinsics.checkNotNull(fileName);
                List fs = StringsKt.split$default(fileName, new String[]{"."}, false, 0, 6, (Object) null);
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("%s_%s.%s", Arrays.copyOf(new Object[]{fs.get(fs.size() - 2), "night", fs.get(fs.size() - 1)}, 3));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                fileName = format;
            }
            VerifyLottieFollowButton verifyLottieFollowButton3 = this.mFollowButton;
            if (verifyLottieFollowButton3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFollowButton");
                verifyLottieFollowButton3 = null;
            }
            verifyLottieFollowButton3.setAnimation(fileName);
            float w = arrays.getDimension(R.styleable.VerifyAvatarWithFollow_followButtonWidth, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
            lp.width = (int) w;
            float h = arrays.getDimension(R.styleable.VerifyAvatarWithFollow_followButtonHeight, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
            lp.height = (int) h;
            arrays.recycle();
        }
        VerifyLottieFollowButton verifyLottieFollowButton4 = this.mFollowButton;
        if (verifyLottieFollowButton4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFollowButton");
            verifyLottieFollowButton4 = null;
        }
        TalkbackUtilsKt.setViewNotImportantForAccessibility((View) verifyLottieFollowButton4);
        VerifyLottieFollowButton verifyLottieFollowButton5 = this.mFollowButton;
        if (verifyLottieFollowButton5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFollowButton");
        } else {
            verifyLottieFollowButton2 = verifyLottieFollowButton5;
        }
        addView((View) verifyLottieFollowButton2, lp);
        this.mVerifyImg.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.bili.videopage.common.widget.view.VerifyAvatarWithTopLabel, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        VerifyLottieFollowButton verifyLottieFollowButton = this.mFollowButton;
        VerifyLottieFollowButton verifyLottieFollowButton2 = null;
        if (verifyLottieFollowButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFollowButton");
            verifyLottieFollowButton = null;
        }
        if (verifyLottieFollowButton.getVisibility() != 8) {
            VerifyLottieFollowButton verifyLottieFollowButton3 = this.mFollowButton;
            if (verifyLottieFollowButton3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFollowButton");
                verifyLottieFollowButton3 = null;
            }
            int width = this.mAvatarImg.getWidth() - this.mAvatarImg.getPaddingRight();
            VerifyLottieFollowButton verifyLottieFollowButton4 = this.mFollowButton;
            if (verifyLottieFollowButton4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFollowButton");
                verifyLottieFollowButton4 = null;
            }
            verifyLottieFollowButton3.setLeft((width - verifyLottieFollowButton4.getMeasuredWidth()) + this.mAvatarImg.getLeft() + this.mLeftOffset);
            VerifyLottieFollowButton verifyLottieFollowButton5 = this.mFollowButton;
            if (verifyLottieFollowButton5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFollowButton");
                verifyLottieFollowButton5 = null;
            }
            int height = this.mAvatarImg.getHeight() - this.mAvatarImg.getPaddingBottom();
            VerifyLottieFollowButton verifyLottieFollowButton6 = this.mFollowButton;
            if (verifyLottieFollowButton6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFollowButton");
                verifyLottieFollowButton6 = null;
            }
            verifyLottieFollowButton5.setTop((height - verifyLottieFollowButton6.getMeasuredHeight()) + this.mAvatarImg.getTop() + this.mTopOffset);
            VerifyLottieFollowButton verifyLottieFollowButton7 = this.mFollowButton;
            if (verifyLottieFollowButton7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFollowButton");
                verifyLottieFollowButton7 = null;
            }
            VerifyLottieFollowButton verifyLottieFollowButton8 = this.mFollowButton;
            if (verifyLottieFollowButton8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFollowButton");
                verifyLottieFollowButton8 = null;
            }
            int left2 = verifyLottieFollowButton8.getLeft();
            VerifyLottieFollowButton verifyLottieFollowButton9 = this.mFollowButton;
            if (verifyLottieFollowButton9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFollowButton");
                verifyLottieFollowButton9 = null;
            }
            verifyLottieFollowButton7.setRight(left2 + verifyLottieFollowButton9.getMeasuredWidth());
            VerifyLottieFollowButton verifyLottieFollowButton10 = this.mFollowButton;
            if (verifyLottieFollowButton10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFollowButton");
                verifyLottieFollowButton10 = null;
            }
            VerifyLottieFollowButton verifyLottieFollowButton11 = this.mFollowButton;
            if (verifyLottieFollowButton11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFollowButton");
                verifyLottieFollowButton11 = null;
            }
            int top2 = verifyLottieFollowButton11.getTop();
            VerifyLottieFollowButton verifyLottieFollowButton12 = this.mFollowButton;
            if (verifyLottieFollowButton12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFollowButton");
            } else {
                verifyLottieFollowButton2 = verifyLottieFollowButton12;
            }
            verifyLottieFollowButton10.setBottom(top2 + verifyLottieFollowButton2.getMeasuredHeight());
        }
    }

    public static /* synthetic */ void bindFollow$default(VerifyAvatarWithFollow verifyAvatarWithFollow, long j, int i, boolean z, String str, String str2, String str3, HashMap hashMap, FollowCallback followCallback, String str4, int i2, Object obj) {
        String str5;
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bindFollow");
        }
        if ((i2 & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) == 0) {
            str5 = str4;
        } else {
            str5 = null;
        }
        verifyAvatarWithFollow.bindFollow(j, i, z, str, str2, str3, hashMap, followCallback, str5);
    }

    public final void bindFollow(long authorId, int from, boolean followed, String spmid, String fromSpmid, String fromScmid, HashMap<String, String> hashMap, FollowCallback followCallback, String loginToast) {
        VerifyLottieFollowButton verifyLottieFollowButton = this.mFollowButton;
        if (verifyLottieFollowButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFollowButton");
            verifyLottieFollowButton = null;
        }
        verifyLottieFollowButton.bindFollow(authorId, from, followed, spmid, fromSpmid, fromScmid, hashMap, followCallback, loginToast);
    }

    public final View followButton() {
        VerifyLottieFollowButton verifyLottieFollowButton = this.mFollowButton;
        if (verifyLottieFollowButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFollowButton");
            verifyLottieFollowButton = null;
        }
        return (View) verifyLottieFollowButton;
    }

    public final long authorId() {
        VerifyLottieFollowButton verifyLottieFollowButton = this.mFollowButton;
        if (verifyLottieFollowButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFollowButton");
            verifyLottieFollowButton = null;
        }
        return verifyLottieFollowButton.getAuthorId();
    }
}