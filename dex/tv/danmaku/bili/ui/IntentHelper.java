package tv.danmaku.bili.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.router.Router;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BuildConfig;
import tv.danmaku.bili.router.ChannelRoutes;
import tv.danmaku.bili.router.MainRouteUris;

public final class IntentHelper {
    public static void intentToAuthorForResult(Context context, Fragment fragment, int requestCode, final long mid, final String name, final int from) {
        RouteRequest request = new RouteRequest.Builder(MainRouteUris.URI_BILIBILI_SPACE).extras(new Function1() { // from class: tv.danmaku.bili.ui.IntentHelper$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return IntentHelper.lambda$intentToAuthorForResult$0(mid, name, from, (MutableBundleLike) obj);
            }
        }).requestCode(requestCode).build();
        BLRouter.routeTo(request, fragment);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit lambda$intentToAuthorForResult$0(long mid, String name, int from, MutableBundleLike mutableBundleLike) {
        mutableBundleLike.put("mid", String.valueOf(mid));
        mutableBundleLike.put(ChannelRoutes.CHANNEL_NAME, name);
        mutableBundleLike.put("from", String.valueOf(from));
        mutableBundleLike.put("defaultTab", "video");
        return null;
    }

    public static void intentTo(Context context, Uri uri) {
        intentTo(context, uri, true);
    }

    public static void intentTo(Context context, Uri uri, boolean onlyBili) {
        BLRouter.routeTo(new RouteRequest.Builder(uri).build(), context);
    }

    public static void intentToLive(Context context, String roomId, int from) {
        try {
            goToLiveRoom(context, Integer.parseInt(roomId), from);
        } catch (NumberFormatException e) {
            if (BuildConfig.DEBUG) {
                throw new IllegalArgumentException(e);
            }
        }
    }

    public static void intentToLive(Context context, String roomId, int from, String routeUrl) {
        boolean isSuccess = false;
        try {
            if (!TextUtils.isEmpty(routeUrl)) {
                Uri uri = Uri.parse(routeUrl).buildUpon().appendQueryParameter("extra_jump_from", String.valueOf(from)).build();
                RouteRequest request = new RouteRequest.Builder(uri).build();
                isSuccess = BLRouter.routeTo(request, context).isSuccess();
            }
            if (!isSuccess) {
                intentToLive(context, roomId, from);
            }
        } catch (Exception e) {
            if (BuildConfig.DEBUG) {
                throw e;
            }
            BLog.e("IntentHelper intent to live : " + e.getMessage());
        }
    }

    public static void goToLiveRoom(Context context, int roomId, int jumpFrom) {
        Router.global().with(context).with("extra_room_id", String.valueOf(roomId)).with("extra_jump_from", String.valueOf(jumpFrom)).open("activity://live/live-room");
    }

    public static void intentToUrl(Context context, String url) {
        intentToUrl(context, url, true);
    }

    public static void intentToUrl(Context context, String url, boolean biliOnly) {
        intentTo(context, Uri.parse(url), biliOnly);
    }

    public static void intentTo(Context context, long aid, int from, String fromSpmid) {
        Router.global().with(context).with("avid", String.valueOf(aid)).with("jumpFrom", String.valueOf(from)).with("from_spmid", fromSpmid).open(MainRouteUris.ROUTE_URI_BILI_VIDEO_DETAIL);
    }

    public static void intentToOpenBrowser(Context context, final String url) {
        RouteRequest request = new RouteRequest.Builder("bilibili://thirdapp").extras(new Function1() { // from class: tv.danmaku.bili.ui.IntentHelper$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return IntentHelper.lambda$intentToOpenBrowser$1(url, (MutableBundleLike) obj);
            }
        }).build();
        BLRouter.routeTo(request, context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit lambda$intentToOpenBrowser$1(String url, MutableBundleLike bundle) {
        Bundle inner = new Bundle();
        inner.putString("intent.action", "android.intent.action.VIEW");
        inner.putString("intent.data", url);
        inner.putInt("intent.flags", 268435456);
        return null;
    }
}