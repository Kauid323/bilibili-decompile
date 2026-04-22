package tv.danmaku.bili.dislikefeedback.router;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.blrouter.RouteRequestKt;
import com.bilibili.lib.blrouter.Runtime;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;

/* compiled from: Router.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J0\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005H\u0007J\"\u0010\u0019\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0005H\u0007J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0012\u0010\u001d\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\u001c\u0010\u001e\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u001f\u001a\u0004\u0018\u00010\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Ltv/danmaku/bili/dislikefeedback/router/Router;", "", "<init>", "()V", "BUNDLE_KEY_AVID", "", "BUNDLE_KEY_CID", "BUNDLE_KEY_SEASON_ID", "BUNDLE_KEY_IS_BANGUMI", "BUNDLE_KEY_IS_SHOW_BANGUMI_SKIP_HEAD_OPTION", "BUNDLE_KEY_FROM_PLAYER", "BUNDLE_KEY_PLAYER_CURRENT_QUALITY", "BUNDLE_KEY_SPMID", "BUNDLE_KEY_FROM_SPMID", "KEY_DEFAULT_EXTRA_BUNDLE", "gotoUserFeedback", "", "context", "Landroid/content/Context;", "gotoPlayerFeedback", "avid", "", "cid", FavoritesConstsKt.SPMID, "fromSpmid", "gotoAppeal", "bvid", "checkAndLogin", "", "goToLogin", "goToUri", AudioIntentHelper.ARGS_URI, "dislike-feedback_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class Router {
    private static final String BUNDLE_KEY_AVID = "key_avid";
    private static final String BUNDLE_KEY_CID = "key_cid";
    private static final String BUNDLE_KEY_FROM_PLAYER = "key_from_player";
    private static final String BUNDLE_KEY_FROM_SPMID = "key_from_spmid";
    private static final String BUNDLE_KEY_IS_BANGUMI = "key_is_bangumi";
    private static final String BUNDLE_KEY_IS_SHOW_BANGUMI_SKIP_HEAD_OPTION = "key_is_show_bangumi_skip_head_option";
    private static final String BUNDLE_KEY_PLAYER_CURRENT_QUALITY = "key_player_tag";
    private static final String BUNDLE_KEY_SEASON_ID = "key_season_id";
    private static final String BUNDLE_KEY_SPMID = "key_spmid";
    public static final Router INSTANCE = new Router();
    private static final String KEY_DEFAULT_EXTRA_BUNDLE = "default_extra_bundle";

    private Router() {
    }

    @JvmStatic
    public static final void gotoUserFeedback(Context context) {
        if (context == null) {
            return;
        }
        BLRouter.routeTo(new RouteRequest.Builder("https://www.bilibili.com/h5/faq/feedback?type=story").build(), context);
    }

    @JvmStatic
    public static final void gotoPlayerFeedback(Context context, final long avid, final long cid, final String spmid, final String fromSpmid) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(spmid, FavoritesConstsKt.SPMID);
        Intrinsics.checkNotNullParameter(fromSpmid, "fromSpmid");
        BLRouter.routeTo(new RouteRequest.Builder("bilibili://feedback/player").extras(new Function1() { // from class: tv.danmaku.bili.dislikefeedback.router.Router$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit gotoPlayerFeedback$lambda$0;
                gotoPlayerFeedback$lambda$0 = Router.gotoPlayerFeedback$lambda$0(avid, cid, spmid, fromSpmid, (MutableBundleLike) obj);
                return gotoPlayerFeedback$lambda$0;
            }
        }).build(), context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit gotoPlayerFeedback$lambda$0(long $avid, long $cid, String $spmid, String $fromSpmid, MutableBundleLike $this$extras) {
        Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
        Bundle $this$gotoPlayerFeedback_u24lambda_u240_u240 = new Bundle();
        $this$gotoPlayerFeedback_u24lambda_u240_u240.putLong(BUNDLE_KEY_AVID, $avid);
        $this$gotoPlayerFeedback_u24lambda_u240_u240.putLong(BUNDLE_KEY_CID, $cid);
        $this$gotoPlayerFeedback_u24lambda_u240_u240.putLong(BUNDLE_KEY_SEASON_ID, 0L);
        $this$gotoPlayerFeedback_u24lambda_u240_u240.putBoolean(BUNDLE_KEY_IS_BANGUMI, false);
        $this$gotoPlayerFeedback_u24lambda_u240_u240.putBoolean(BUNDLE_KEY_IS_SHOW_BANGUMI_SKIP_HEAD_OPTION, false);
        $this$gotoPlayerFeedback_u24lambda_u240_u240.putBoolean(BUNDLE_KEY_FROM_PLAYER, false);
        $this$gotoPlayerFeedback_u24lambda_u240_u240.putString(BUNDLE_KEY_PLAYER_CURRENT_QUALITY, "");
        $this$gotoPlayerFeedback_u24lambda_u240_u240.putString(BUNDLE_KEY_SPMID, $spmid);
        $this$gotoPlayerFeedback_u24lambda_u240_u240.putString(BUNDLE_KEY_FROM_SPMID, $fromSpmid);
        Unit unit = Unit.INSTANCE;
        $this$extras.put(KEY_DEFAULT_EXTRA_BUNDLE, $this$gotoPlayerFeedback_u24lambda_u240_u240);
        return Unit.INSTANCE;
    }

    @JvmStatic
    public static final void gotoAppeal(Context context, long avid, String bvid) {
        Intrinsics.checkNotNullParameter(bvid, "bvid");
        if (context != null && checkAndLogin(context)) {
            Uri uri = Uri.parse("https://www.bilibili.com/appeal/").buildUpon().appendQueryParameter("avid", String.valueOf(avid)).appendQueryParameter("bvid", bvid).build();
            Intrinsics.checkNotNull(uri);
            RouteRequest request = new RouteRequest.Builder(uri).runtime(CollectionsKt.listOf(Runtime.WEB)).build();
            BLRouter.routeTo(request, context);
        }
    }

    @JvmStatic
    public static final boolean checkAndLogin(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (BiliAccounts.get(context).isLogin()) {
            return true;
        }
        goToLogin(context);
        return false;
    }

    @JvmStatic
    public static final void goToLogin(Context context) {
        if (context == null) {
            return;
        }
        goToUri(context, "bilibili://login");
    }

    @JvmStatic
    public static final void goToUri(Context context, String uri) {
        if (context == null || TextUtils.isEmpty(uri)) {
            return;
        }
        Intrinsics.checkNotNull(uri);
        BLRouter.routeTo(RouteRequestKt.toRouteRequest(uri), context);
    }
}