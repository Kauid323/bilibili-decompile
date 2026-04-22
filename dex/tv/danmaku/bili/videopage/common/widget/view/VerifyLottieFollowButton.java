package tv.danmaku.bili.videopage.common.widget.view;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.airbnb.lottie.LottieAnimationView;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.okretro.BiliApiDataCallback;
import com.bilibili.relation.FollowStateManager;
import com.bilibili.relation.api.RelationApiManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.videopage.common.helper.VideoRouter;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: VerifyLottieFollowButton.kt */
@Metadata(d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000e*\u0001\u001b\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010\u001d\u001a\u00020\u001eH\u0014J\b\u0010\u001f\u001a\u00020\u001eH\u0014Jj\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u00162\b\u0010$\u001a\u0004\u0018\u00010\u000e2\b\u0010%\u001a\u0004\u0018\u00010\u000e2\b\u0010&\u001a\u0004\u0018\u00010\u000e2\u0014\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00122\b\u0010(\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u000eH\u0007J\u0006\u0010*\u001a\u00020\u0014J\u0014\u0010+\u001a\u00020\u001e2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u000eH\u0002R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001c¨\u0006,"}, d2 = {"Ltv/danmaku/bili/videopage/common/widget/view/VerifyLottieFollowButton;", "Lcom/airbnb/lottie/LottieAnimationView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mFrom", "mSpmid", "", "mFromSpmid", "mFromScmid", "mExtendContent", "", "mAuthorId", "", "mIsFollowed", "", "mIsFollowing", "mFollowCallback", "Ltv/danmaku/bili/videopage/common/widget/view/FollowCallback;", "mFollowStateCallback", "tv/danmaku/bili/videopage/common/widget/view/VerifyLottieFollowButton$mFollowStateCallback$1", "Ltv/danmaku/bili/videopage/common/widget/view/VerifyLottieFollowButton$mFollowStateCallback$1;", "onAttachedToWindow", "", "onDetachedFromWindow", "bindFollow", "authorId", "from", "followed", "spmid", "fromSpmid", "fromScmid", "extendContent", "followCallback", "loginToast", "getAuthorId", "follow", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class VerifyLottieFollowButton extends LottieAnimationView {
    private long mAuthorId;
    private Map<String, String> mExtendContent;
    private FollowCallback mFollowCallback;
    private final VerifyLottieFollowButton$mFollowStateCallback$1 mFollowStateCallback;
    private int mFrom;
    private String mFromScmid;
    private String mFromSpmid;
    private boolean mIsFollowed;
    private boolean mIsFollowing;
    private String mSpmid;

    public final void bindFollow(long j, int i, boolean z, String str, String str2, String str3, Map<String, String> map, FollowCallback followCallback) {
        bindFollow$default(this, j, i, z, str, str2, str3, map, followCallback, null, IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN, null);
    }

    public VerifyLottieFollowButton(Context context) {
        this(context, null);
    }

    public VerifyLottieFollowButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [tv.danmaku.bili.videopage.common.widget.view.VerifyLottieFollowButton$mFollowStateCallback$1] */
    public VerifyLottieFollowButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mFollowStateCallback = new FollowStateManager.FollowChangeListener() { // from class: tv.danmaku.bili.videopage.common.widget.view.VerifyLottieFollowButton$mFollowStateCallback$1
            public void onFollowChange(boolean isFollow) {
                FollowCallback followCallback;
                followCallback = VerifyLottieFollowButton.this.mFollowCallback;
                if (followCallback != null) {
                    followCallback.onFollowStateChanged(isFollow);
                }
            }
        };
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        FollowStateManager.Companion.getInstance().register(this.mAuthorId, this.mFollowStateCallback);
    }

    protected void onDetachedFromWindow() {
        FollowStateManager.Companion.getInstance().unregister(this.mAuthorId, this.mFollowStateCallback);
        super.onDetachedFromWindow();
    }

    public static /* synthetic */ void bindFollow$default(VerifyLottieFollowButton verifyLottieFollowButton, long j, int i, boolean z, String str, String str2, String str3, Map map, FollowCallback followCallback, String str4, int i2, Object obj) {
        String str5;
        if ((i2 & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) == 0) {
            str5 = str4;
        } else {
            str5 = null;
        }
        verifyLottieFollowButton.bindFollow(j, i, z, str, str2, str3, map, followCallback, str5);
    }

    public final void bindFollow(long authorId, int from, boolean followed, String spmid, String fromSpmid, String fromScmid, Map<String, String> map, FollowCallback followCallback, final String loginToast) {
        this.mIsFollowed = followed;
        if (this.mIsFollowed) {
            setProgress(1.0f);
        } else {
            setProgress(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        }
        this.mAuthorId = authorId;
        if (followCallback != null) {
            this.mFollowCallback = followCallback;
        }
        this.mFrom = from;
        this.mSpmid = spmid;
        this.mFromSpmid = fromSpmid;
        this.mFromScmid = fromScmid;
        this.mExtendContent = map;
        setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.videopage.common.widget.view.VerifyLottieFollowButton$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                VerifyLottieFollowButton.this.follow(loginToast);
            }
        });
    }

    public final long getAuthorId() {
        return this.mAuthorId;
    }

    static /* synthetic */ void follow$default(VerifyLottieFollowButton verifyLottieFollowButton, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        verifyLottieFollowButton.follow(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void follow(String loginToast) {
        FollowCallback followCallback;
        if (this.mIsFollowed | this.mIsFollowing) {
            return;
        }
        Context context = getContext();
        Intrinsics.checkNotNull(context);
        if (!VideoRouter.checkAndLogin$default(context, loginToast, "main.ugc-video-detail.up-create-team-id.*.click", null, null, 24, null)) {
            return;
        }
        this.mIsFollowing = true;
        if (this.mAuthorId == 0 && (followCallback = this.mFollowCallback) != null) {
            followCallback.onFollowError(null);
        }
        final long authorId = this.mAuthorId;
        String accessKey = BiliAccounts.get(getContext()).getAccessKey();
        RelationApiManager.addAuthorAttentionV2(accessKey, authorId, this.mFrom, this.mSpmid, this.mFromSpmid, this.mFromScmid, this.mExtendContent, new BiliApiDataCallback<Void>() { // from class: tv.danmaku.bili.videopage.common.widget.view.VerifyLottieFollowButton$follow$1
            public boolean isCancel() {
                FollowCallback followCallback2;
                VerifyLottieFollowButton.this.mIsFollowing = false;
                followCallback2 = VerifyLottieFollowButton.this.mFollowCallback;
                return followCallback2 != null && followCallback2.isCancel();
            }

            public void onDataSuccess(Void data) {
                long j;
                FollowCallback followCallback2;
                VerifyLottieFollowButton.this.mIsFollowed = true;
                VerifyLottieFollowButton.this.mIsFollowing = false;
                long j2 = authorId;
                j = VerifyLottieFollowButton.this.mAuthorId;
                if (j2 != j) {
                    followCallback2 = VerifyLottieFollowButton.this.mFollowCallback;
                    if (followCallback2 != null) {
                        followCallback2.onFollowSuccess();
                        return;
                    }
                    return;
                }
                VerifyLottieFollowButton.this.playAnimation();
                VerifyLottieFollowButton verifyLottieFollowButton = VerifyLottieFollowButton.this;
                final VerifyLottieFollowButton verifyLottieFollowButton2 = VerifyLottieFollowButton.this;
                verifyLottieFollowButton.addAnimatorListener(new Animator.AnimatorListener() { // from class: tv.danmaku.bili.videopage.common.widget.view.VerifyLottieFollowButton$follow$1$onDataSuccess$1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator p0) {
                        Intrinsics.checkNotNullParameter(p0, "p0");
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator p0) {
                        FollowCallback followCallback3;
                        Intrinsics.checkNotNullParameter(p0, "p0");
                        VerifyLottieFollowButton.this.removeAnimatorListener(this);
                        followCallback3 = VerifyLottieFollowButton.this.mFollowCallback;
                        if (followCallback3 != null) {
                            followCallback3.onFollowSuccess();
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator p0) {
                        FollowCallback followCallback3;
                        Intrinsics.checkNotNullParameter(p0, "p0");
                        VerifyLottieFollowButton.this.removeAnimatorListener(this);
                        followCallback3 = VerifyLottieFollowButton.this.mFollowCallback;
                        if (followCallback3 != null) {
                            followCallback3.onFollowSuccess();
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator p0) {
                        Intrinsics.checkNotNullParameter(p0, "p0");
                    }
                });
            }

            public void onError(Throwable error) {
                FollowCallback followCallback2;
                VerifyLottieFollowButton.this.mIsFollowing = false;
                followCallback2 = VerifyLottieFollowButton.this.mFollowCallback;
                if (followCallback2 != null) {
                    followCallback2.onFollowError(error);
                }
            }
        });
    }
}