package tv.danmaku.bili.ui.main2.basic.dialog.top;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.bilibili.homepage.HomeTabSelectedListener;
import com.bilibili.lib.homepage.startdust.secondary.SecondaryPageClickAnim;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.garb.NftCardJsBridgeCallHandler;
import tv.danmaku.bili.ui.main2.resource.HomeTabServiceImpl;
import tv.danmaku.bili.ui.main2.resource.HomeTabServiceImplKt;

/* compiled from: TopTabClickAnim.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n\u001a\u0006\u0010\u000b\u001a\u00020\u0006\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {TopTabClickAnimKt.HOME_TAB_CLICK_ANIM, "", "TAG", "mTopTabClickAnim", "Ltv/danmaku/bili/ui/main2/basic/dialog/top/TopTabClickAnim;", NftCardJsBridgeCallHandler.PRELOAD_RESOURCE, "", "context", "Landroid/content/Context;", "clickAnim", "Lcom/bilibili/lib/homepage/startdust/secondary/SecondaryPageClickAnim;", "registerTopTabClickAnim", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class TopTabClickAnimKt {
    public static final String HOME_TAB_CLICK_ANIM = "HOME_TAB_CLICK_ANIM";
    private static final String TAG = "TopTapClickAnim";
    private static TopTabClickAnim mTopTabClickAnim;

    public static final void preloadResource(Context context, SecondaryPageClickAnim clickAnim) {
        Intrinsics.checkNotNullParameter(clickAnim, "clickAnim");
        if (context == null) {
            return;
        }
        new SVGAParser(context).parseOnlyCache(new URL(clickAnim.getFile()), new SVGAParser.ParseCompletion() { // from class: tv.danmaku.bili.ui.main2.basic.dialog.top.TopTabClickAnimKt$preloadResource$1
            public void onComplete(SVGAVideoEntity videoItem) {
                Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                BLog.d("TopTapClickAnim", "anim pre load complete");
            }

            public void onError() {
                BLog.d("TopTapClickAnim", "anim pre load error");
            }

            public void onCacheExist() {
                BLog.d("TopTapClickAnim", "anim pre load cache exist");
            }
        });
    }

    public static final void registerTopTabClickAnim() {
        HomeTabServiceImpl homeTabService = HomeTabServiceImplKt.getHomeTabServiceImpl();
        if (homeTabService == null) {
            return;
        }
        homeTabService.registerHomeTabSelectedListener(new HomeTabSelectedListener() { // from class: tv.danmaku.bili.ui.main2.basic.dialog.top.TopTabClickAnimKt$registerTopTabClickAnim$1
            public void onTabSelected(boolean isTop, int position, String tabUrl, View tabView, Bundle extra) {
                TopTabClickAnim topTabClickAnim;
                if ((tabView instanceof ViewGroup) && isTop) {
                    topTabClickAnim = TopTabClickAnimKt.mTopTabClickAnim;
                    if (topTabClickAnim != null) {
                        topTabClickAnim.clearTabAnim((ViewGroup) tabView);
                    }
                    TopTabClickAnimKt.mTopTabClickAnim = null;
                    SecondaryPageClickAnim serializable = extra != null ? extra.getSerializable(TopTabClickAnimKt.HOME_TAB_CLICK_ANIM) : null;
                    SecondaryPageClickAnim clickAnim = serializable instanceof SecondaryPageClickAnim ? serializable : null;
                    if (clickAnim != null && clickAnim.inInvalidTimeGap()) {
                        TopTabClickAnim $this$onTabSelected_u24lambda_u240 = new TopTabClickAnim(position, clickAnim);
                        $this$onTabSelected_u24lambda_u240.playTabAnim((ViewGroup) tabView);
                        TopTabClickAnimKt.mTopTabClickAnim = $this$onTabSelected_u24lambda_u240;
                    }
                }
            }
        });
    }
}