package tv.danmaku.bili.ui.main2.basic.story;

import android.app.Application;
import android.graphics.Rect;
import com.bilibili.base.BiliContext;
import com.bilibili.homepage.HomeStoryEntranceService;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.blconfig.ConfigManager;
import javax.inject.Singleton;
import kotlin.Metadata;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main2.resource.MainResourceManager;

/* compiled from: HomeStoryEntranceServiceImpl.kt */
@Singleton
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Ltv/danmaku/bili/ui/main2/basic/story/HomeStoryEntranceServiceImpl;", "Lcom/bilibili/homepage/HomeStoryEntranceService;", "<init>", "()V", "enableAnimation", "", "entranceRect", "Landroid/graphics/Rect;", "getEntranceRect", "()Landroid/graphics/Rect;", "setEntranceRect", "(Landroid/graphics/Rect;)V", "listener", "Ltv/danmaku/bili/ui/main2/basic/story/StoryExitAnimationListener;", "getListener", "()Ltv/danmaku/bili/ui/main2/basic/story/StoryExitAnimationListener;", "setListener", "(Ltv/danmaku/bili/ui/main2/basic/story/StoryExitAnimationListener;)V", "getEntranceRectInWindow", "notifyAnimationStart", "", "hitAvatarAndStoryBadgeExp", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class HomeStoryEntranceServiceImpl implements HomeStoryEntranceService {
    public static final int $stable = 8;
    private final boolean enableAnimation;
    private Rect entranceRect;
    private StoryExitAnimationListener listener;

    public HomeStoryEntranceServiceImpl() {
        Boolean bool = (Boolean) ConfigManager.Companion.ab().get("ff_key_home_story_entrance_show_animation", true);
        this.enableAnimation = bool != null ? bool.booleanValue() : true;
    }

    public final Rect getEntranceRect() {
        return this.entranceRect;
    }

    public final void setEntranceRect(Rect rect) {
        this.entranceRect = rect;
    }

    public final StoryExitAnimationListener getListener() {
        return this.listener;
    }

    public final void setListener(StoryExitAnimationListener storyExitAnimationListener) {
        this.listener = storyExitAnimationListener;
    }

    public Rect getEntranceRectInWindow() {
        if (this.enableAnimation && hitAvatarAndStoryBadgeExp()) {
            return this.entranceRect;
        }
        return null;
    }

    public void notifyAnimationStart() {
        StoryExitAnimationListener storyExitAnimationListener;
        if (!hitAvatarAndStoryBadgeExp() || (storyExitAnimationListener = this.listener) == null) {
            return;
        }
        storyExitAnimationListener.onStoryExitAnimationStart();
    }

    public boolean hitAvatarAndStoryBadgeExp() {
        Application ctx = BiliContext.application();
        if (ctx == null) {
            return false;
        }
        MainResourceManager.TopLeftInfo topLeftInfo = HomeTopLeftStateHolderKt.getTopLeftInfo();
        boolean hitExp = topLeftInfo != null && topLeftInfo.hitAvatarAndStoryBadgeExp();
        boolean isLogin = BiliAccounts.get(ctx).isLogin();
        BLog.i("HomeStoryEntranceServiceImpl", "HIT EXP :" + hitExp + " isLogin:" + isLogin);
        return hitExp && isLogin;
    }
}