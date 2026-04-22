package tv.danmaku.bili.ui.main2.event;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.bilibili.homepage.HomeMenuService;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.homepage.badge.IBadgeServer;
import com.bilibili.lib.homepage.badge.SimpleBadgeServer;
import com.bilibili.lib.homepage.startdust.menu.IDynamicMenuItemServer;
import com.bilibili.lib.homepage.startdust.menu.IMenuAnimatorServer;
import com.bilibili.lib.homepage.widget.MenuActionView;
import javax.inject.Named;
import javax.inject.Singleton;
import tv.danmaku.bili.ui.main.event.EventEntranceHelper;
import tv.danmaku.bili.ui.main.event.model.EventEntranceModel;

@Singleton
@Named(EventMenuAction.ACTION)
public class EventMenuAction implements HomeMenuService {
    public static final String ACTION = "action://fission/entrance_menu";

    public Object getDynamicMenuItemServer(final Context context, int type, int badgeNum, String iconUrl, String lottieJsonUrl, String animatorIconUrl, final String jumpUrl) {
        if (context == null) {
            return null;
        }
        return new IDynamicMenuItemServer() { // from class: tv.danmaku.bili.ui.main2.event.EventMenuAction.1
            public /* synthetic */ void show() {
                IDynamicMenuItemServer.-CC.$default$show(this);
            }

            public /* synthetic */ void strictExpose() {
                IDynamicMenuItemServer.-CC.$default$strictExpose(this);
            }

            public IBadgeServer getBadgeServer() {
                return new SimpleBadgeServer() { // from class: tv.danmaku.bili.ui.main2.event.EventMenuAction.1.1
                    public void refresh(Context context1) {
                        EventEntranceModel info = EventEntranceHelper.entranceInfo;
                        boolean needAnimate = info != null && info.hasAnimate() && EventEntranceHelper.animValid(context1);
                        if (info != null && !needAnimate) {
                            EventEntranceHelper.showRetDot();
                        }
                    }
                };
            }

            public void intent() {
                if (TextUtils.isEmpty(jumpUrl)) {
                    return;
                }
                RouteRequest request = new RouteRequest.Builder(jumpUrl).build();
                BLRouter.routeTo(request, context);
                EventEntranceHelper.onEntranceClick(context);
            }

            public IMenuAnimatorServer getMenuAnimatorServer() {
                return new IMenuAnimatorServer() { // from class: tv.danmaku.bili.ui.main2.event.EventMenuAction.1.2
                    public void startAnimator(MenuActionView view) {
                    }

                    public void startUpdateAnimator(MenuActionView view) {
                        if (view instanceof EventMenuActionView) {
                            EventEntranceModel info = EventEntranceHelper.entranceInfo;
                            if (info == null || info.getOnline() == null || info.getOnline().getAnimate() == null || (TextUtils.isEmpty(info.getOnline().getAnimate().getSvg()) && info.getLottieAnim() == null)) {
                                view.resetView();
                                return;
                            }
                            MenuActionView.UpdateAnim anim = new MenuActionView.UpdateAnim();
                            anim.animIcon = info.getOnline().getAnimate().getIcon();
                            anim.animJsonUrl = info.getOnline().getAnimate().getJson();
                            anim.anim = info.getLottieAnim();
                            anim.svga = info.getOnline().getAnimate().getSvg();
                            anim.loop = info.getOnline().getAnimate().getLoop();
                            anim.iconLocalPath = info.getIconLocalPath();
                            ((EventMenuActionView) view).startUpdateAnim(anim);
                            EventEntranceHelper.onAnimShow(context);
                            new Handler().post(new Runnable() { // from class: tv.danmaku.bili.ui.main2.event.EventMenuAction$1$2$$ExternalSyntheticLambda0
                                @Override // java.lang.Runnable
                                public final void run() {
                                    EventEntranceHelper.showRetDot();
                                }
                            });
                        }
                    }
                };
            }
        };
    }
}