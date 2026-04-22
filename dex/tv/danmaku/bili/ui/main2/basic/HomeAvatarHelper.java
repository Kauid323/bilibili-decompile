package tv.danmaku.bili.ui.main2.basic;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.ViewCompat;
import com.bilibili.base.BiliContext;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.homepage.HomeSideCenterTab;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.homepage.util.DpUtils;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.ImageRequestBuilder;
import com.bilibili.lib.image2.view.BiliImageView;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.main2.basic.story.HomeStoryEntranceAnimationKt;
import tv.danmaku.bili.ui.main2.basic.story.HomeTopLeftStateHolderKt;
import tv.danmaku.bili.ui.main2.basic.story.StoryEntranceClickGuidance;
import tv.danmaku.bili.ui.main2.basic.story.StoryEntranceClickGuidanceKt;
import tv.danmaku.bili.ui.main2.basic.story.StoryExitAvatarAnimation;
import tv.danmaku.bili.ui.main2.resource.MainResourceManager;

public class HomeAvatarHelper {
    private static final String KEY_SP_HOME_AVATAR = "bili_main_home_last_avatar_url";
    private static final String TAG = "HomeAvatarHelper";
    private static Runnable mAnimationRunnable;
    public static boolean shownTagThisTime = false;
    public static int showTagTimes = -1;
    public static Boolean userHasClickedRect = null;
    private static boolean isSplashVisible = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void saveAvatar(String avatarUrl) {
        Context ctx = BiliContext.application();
        if (ctx != null) {
            BiliGlobalPreferenceHelper.getInstance(ctx).edit().putString(KEY_SP_HOME_AVATAR, avatarUrl).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getLastAvatar() {
        Context ctx = BiliContext.application();
        if (ctx != null) {
            return BiliGlobalPreferenceHelper.getInstance(ctx).optString(KEY_SP_HOME_AVATAR, (String) null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void clearAvatar() {
        Context ctx = BiliContext.application();
        if (ctx != null) {
            BiliGlobalPreferenceHelper.getInstance(ctx).edit().remove(KEY_SP_HOME_AVATAR).apply();
        }
    }

    public static void notifySplashExit() {
        isSplashVisible = true;
        triggerStoryEntranceAnimation();
    }

    public static void setAvatarStyle(View avatar, boolean hitExp) {
        ViewGroup.LayoutParams lp = avatar.getLayoutParams();
        if (lp instanceof ViewGroup.MarginLayoutParams) {
            if (!hitExp) {
                int dp2Px = DpUtils.INSTANCE.dp2Px(40);
                lp.height = dp2Px;
                lp.width = dp2Px;
                return;
            }
            int dp2Px2 = DpUtils.INSTANCE.dp2Px(36);
            lp.height = dp2Px2;
            lp.width = dp2Px2;
        }
    }

    public static void tryShowAvatarEntranceAnimation(final View avatarView, final ViewGroup rectView) {
        boolean canPlayAvatarAnimation = HomeTopLeftStateHolderKt.canDisplayTopLeftAnimation();
        HomeTopLeftStateHolderKt.setLastIsSideCenterPage(false);
        if (avatarView == null || rectView == null || !canPlayAvatarAnimation) {
            return;
        }
        boolean isColdStartPlayedAnimation = HomeTopLeftStateHolderKt.isColdStartPlayTopLeftAnimation();
        Boolean hitFF = (Boolean) ConfigManager.ab().get("ff_show_home_avatar_story_entrance_animation", true);
        BLog.i(TAG, "showAvatarEntranceAnimation isColdStartPlayedAnimation:" + isColdStartPlayedAnimation + "hitFF:" + hitFF);
        if (hitFF == null || !hitFF.booleanValue()) {
            return;
        }
        HomeTopLeftStateHolderKt.setColdStartPlayTopLeftAnimation(true);
        if (HomeTopLeftStateHolderKt.getCurrentHomeSideCenterTab() == HomeSideCenterTab.RECENT) {
            HomeTopLeftStateHolderKt.setHasDoTopLeftMiniGameAnimation(true);
        }
        mAnimationRunnable = new Runnable() { // from class: tv.danmaku.bili.ui.main2.basic.HomeAvatarHelper$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                HomeAvatarHelper.lambda$tryShowAvatarEntranceAnimation$0(avatarView, rectView);
            }
        };
        triggerStoryEntranceAnimation();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$tryShowAvatarEntranceAnimation$0(View avatarView, ViewGroup rectView) {
        HomeStoryEntranceAnimationKt.showEntrance(avatarView, rectView, true, 2500L);
        HomeStoryEntranceAnimationKt.showAvatar(avatarView, rectView, true, 6000L);
    }

    public static void startStoryExitAnimation(final View avatarView, final ViewGroup rectView) {
        if (avatarView == null || rectView == null || !ViewCompat.isAttachedToWindow(avatarView)) {
            return;
        }
        HomeStoryEntranceAnimationKt.clearPendingAnimations();
        HomeStoryEntranceAnimationKt.clearRunningAnimations();
        HomeStoryEntranceAnimationKt.showEntrance(avatarView, rectView, false);
        avatarView.postDelayed(new Runnable() { // from class: tv.danmaku.bili.ui.main2.basic.HomeAvatarHelper$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                HomeAvatarHelper.lambda$startStoryExitAnimation$1(avatarView, rectView);
            }
        }, 400L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$startStoryExitAnimation$1(View avatarView, ViewGroup rectView) {
        if (ViewCompat.isAttachedToWindow(avatarView)) {
            showAvatarClickGuide(avatarView);
            new StoryExitAvatarAnimation(avatarView, rectView).startAnimation();
        }
    }

    public static void showAvatarClickGuide(View anchor) {
        if (StoryEntranceClickGuidanceKt.canShowGuidance()) {
            ViewParent parent = anchor.getParent();
            if (parent instanceof View) {
                new StoryEntranceClickGuidance().show((View) parent);
            }
        }
    }

    private static void triggerStoryEntranceAnimation() {
        BLog.i(TAG, "triggerStoryEntranceAnimation " + mAnimationRunnable + " isSplashVisible " + isSplashVisible);
        if (mAnimationRunnable != null && isSplashVisible) {
            mAnimationRunnable.run();
            mAnimationRunnable = null;
        }
    }

    public static void setAvatarRectRes(BiliImageView bg, BiliImageView fg, MainResourceManager.TopLeftInfo avatarInfo) {
        HomeSideCenterTab tab;
        if (bg == null || fg == null || avatarInfo == null || (tab = HomeTopLeftStateHolderKt.getCurrentHomeSideCenterTab()) == HomeSideCenterTab.UNKNOWN) {
            return;
        }
        ImageRequestBuilder bgBuilder = BiliImageLoader.INSTANCE.with(bg.getContext());
        ImageRequestBuilder fgBuilder = BiliImageLoader.INSTANCE.with(fg.getContext());
        if (tab == HomeSideCenterTab.STORY) {
            bgBuilder.placeholderImageResId(R.drawable.ic_bg_home_story_entrance);
            fgBuilder.placeholderImageResId(R.drawable.ic_home_story_entrance);
            bgBuilder.failureImageResId(R.drawable.ic_bg_home_story_entrance);
            fgBuilder.failureImageResId(R.drawable.ic_home_story_entrance);
            bgBuilder.url(avatarInfo.storyBackgroundImage);
            fgBuilder.url(avatarInfo.storyForegroundImage);
        } else if (tab == HomeSideCenterTab.LISTEN) {
            bgBuilder.placeholderImageResId(R.drawable.ic_bg_home_podcast_entrance);
            fgBuilder.placeholderImageResId(R.drawable.ic_home_podcast_entrance);
            bgBuilder.failureImageResId(R.drawable.ic_bg_home_podcast_entrance);
            fgBuilder.failureImageResId(R.drawable.ic_home_podcast_entrance);
            bgBuilder.url(avatarInfo.podcastBackgroundImage);
            fgBuilder.url(avatarInfo.podcastForegroundImage);
        } else if (tab == HomeSideCenterTab.RECENT) {
            bgBuilder.placeholderImageResId(R.drawable.ic_bg_home_game_entrance);
            fgBuilder.placeholderImageResId(R.drawable.ic_home_game_entrance);
            bgBuilder.failureImageResId(R.drawable.ic_bg_home_game_entrance);
            fgBuilder.failureImageResId(R.drawable.ic_home_game_entrance);
            bgBuilder.url(avatarInfo.gameBackgroundImage);
            fgBuilder.url(avatarInfo.gameForegroundImage);
        }
        bgBuilder.into(bg);
        fgBuilder.into(fg);
    }

    public static boolean usePixelColor() {
        Boolean hitFF = (Boolean) ConfigManager.ab().get("ff_key_home_use_pixel_color", true);
        return hitFF == null || hitFF.booleanValue();
    }
}