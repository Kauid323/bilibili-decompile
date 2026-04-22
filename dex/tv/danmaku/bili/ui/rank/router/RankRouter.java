package tv.danmaku.bili.ui.rank.router;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.bilibili.api.utils.BfsThumbImageUriGetter;
import com.bilibili.api.utils.ThumbImageUriGetter;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequestKt;
import com.bilibili.lib.router.Router;
import com.bilibili.moduleservice.main.MainCommonService;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: RankRouter.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002\u001c\u001dB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u001a\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0007J\u001a\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0007J$\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0007J6\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u0007J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Ltv/danmaku/bili/ui/rank/router/RankRouter;", "", "<init>", "()V", "AUTHOR_SPACE", "", "ROUTE_ACTIVITY_URI_LOGIN", "intentTo", "", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "gotoPgcDetail", "uriString", "addToWatchLater", "avId", "gotoVideoDetail", BundleKey.VIDEO_DETAIL_COVER, "goToAuthorSpace", "Lcom/bilibili/lib/router/Router$RouterProxy;", BundleKey.AUTHOR_SPACE_MID, "", "name", "from", "", "anchorTab", "gotoLogin", "BundleKey", "RankConst", "rank_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class RankRouter {
    public static final int $stable = 0;
    public static final String AUTHOR_SPACE = "activity://main/authorspace/";
    public static final RankRouter INSTANCE = new RankRouter();
    private static final String ROUTE_ACTIVITY_URI_LOGIN = "activity://main/login/";

    private RankRouter() {
    }

    /* compiled from: RankRouter.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0012\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Ltv/danmaku/bili/ui/rank/router/RankRouter$BundleKey;", "", "<init>", "()V", "TYPE", "", "TYPE_V2", "TID", "WATCH_LATER_AVID", "VIDEO_DETAIL_FROM", "VIDEO_DETAIL_COVER", "VIDEO_DETAIL_FROM_SPMID_KEY", "VIDEO_DETAIL_FROM_SPMID", "BANGUMI_DETAIL_FROM", "AUTHOR_SPACE_MID", "AUTHOR_SPACE_NAME", "AUTHOR_SPACE_FROM", "AUTHOR_SPACE_ANCHOR_TAB", "ACTION_PARAM_TYPE", "ACTION_PARAM_TID", "ACTION_PARAM_TITLE", "ACTION_PARAM_IS_PGC", "ACTION_PARAM_FROM", "rank_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class BundleKey {
        public static final int $stable = 0;
        public static final String ACTION_PARAM_FROM = "from";
        public static final String ACTION_PARAM_IS_PGC = "is_pgc";
        public static final String ACTION_PARAM_TID = "tid";
        public static final String ACTION_PARAM_TITLE = "title";
        public static final String ACTION_PARAM_TYPE = "type";
        public static final String AUTHOR_SPACE_ANCHOR_TAB = "anchor_tab";
        public static final String AUTHOR_SPACE_FROM = "from";
        public static final String AUTHOR_SPACE_MID = "mid";
        public static final String AUTHOR_SPACE_NAME = "name";
        public static final String BANGUMI_DETAIL_FROM = "intentFrom";
        public static final BundleKey INSTANCE = new BundleKey();
        public static final String TID = "tid";
        public static final String TYPE = "order_type";
        public static final String TYPE_V2 = "type";
        public static final String VIDEO_DETAIL_COVER = "cover";
        public static final String VIDEO_DETAIL_FROM = "jumpFrom";
        public static final String VIDEO_DETAIL_FROM_SPMID = "creation.regional-rank.0.0";
        public static final String VIDEO_DETAIL_FROM_SPMID_KEY = "from_spmid";
        public static final String WATCH_LATER_AVID = "avid";

        private BundleKey() {
        }
    }

    /* compiled from: RankRouter.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Ltv/danmaku/bili/ui/rank/router/RankRouter$RankConst;", "", "<init>", "()V", "TYPE_HOT", "", "TYPE_TOP", "NO_ID", "TYPE_ALL", "", "TYPE_ORIGINAL", "VD_NEW_FROM_RANK", "TAB_MAIN", "BD_NEW_FROM_RANK", "rank_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class RankConst {
        public static final int $stable = 0;
        public static final int BD_NEW_FROM_RANK = 25;
        public static final RankConst INSTANCE = new RankConst();
        public static final int NO_ID = -1;
        public static final String TAB_MAIN = "main";
        public static final String TYPE_ALL = "all";
        public static final int TYPE_HOT = 1;
        public static final String TYPE_ORIGINAL = "original";
        public static final int TYPE_TOP = 2;
        public static final int VD_NEW_FROM_RANK = 33;

        private RankConst() {
        }
    }

    @JvmStatic
    public static final void intentTo(Context context, Uri uri) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (uri != null) {
            BLRouter.routeTo(RouteRequestKt.toRouteRequest(uri), context);
        }
    }

    @JvmStatic
    public static final void gotoPgcDetail(Context context, String uriString) {
        Intrinsics.checkNotNullParameter(context, "context");
        String str = uriString;
        if (str == null || StringsKt.isBlank(str)) {
            return;
        }
        Uri.Builder builder = Uri.parse(uriString).buildUpon();
        builder.appendQueryParameter("intentFrom", "25");
        builder.appendQueryParameter("from_spmid", BundleKey.VIDEO_DETAIL_FROM_SPMID);
        Uri uri = builder.build();
        intentTo(context, uri);
    }

    @JvmStatic
    public static final void addToWatchLater(Context context, String avId) {
        Intrinsics.checkNotNullParameter(context, "context");
        MainCommonService mainCommonService = (MainCommonService) BLRouter.get$default(BLRouter.INSTANCE, MainCommonService.class, (String) null, 2, (Object) null);
        if (mainCommonService != null) {
            mainCommonService.addWatchLater(context, avId, (String) null);
        }
    }

    @JvmStatic
    public static final void gotoVideoDetail(Context context, String uriString, String cover) {
        Intrinsics.checkNotNullParameter(context, "context");
        String str = uriString;
        boolean z = false;
        if (str == null || StringsKt.isBlank(str)) {
            return;
        }
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources != null ? resources.getDisplayMetrics() : null;
        int width = (int) TypedValue.applyDimension(1, 160.0f, displayMetrics);
        int height = (int) TypedValue.applyDimension(1, 100.0f, displayMetrics);
        String webpUrl = null;
        String str2 = cover;
        if (str2 == null || StringsKt.isBlank(str2)) {
            z = true;
        }
        if (z) {
            webpUrl = BfsThumbImageUriGetter.getInstance().get(ThumbImageUriGetter.Params.createWebpParam(cover, width, height, true));
        }
        Uri.Builder builder = Uri.parse(uriString).buildUpon();
        builder.appendQueryParameter("jumpFrom", "33").appendQueryParameter(BundleKey.VIDEO_DETAIL_COVER, webpUrl).appendQueryParameter("from_spmid", BundleKey.VIDEO_DETAIL_FROM_SPMID);
        Uri uri = builder.build();
        intentTo(context, uri);
    }

    @JvmStatic
    public static final Router.RouterProxy goToAuthorSpace(Context context, long mid, String name, int from, String anchorTab) {
        Intrinsics.checkNotNullParameter(context, "context");
        return Router.Companion.global().with(context).with(BundleKey.AUTHOR_SPACE_MID, String.valueOf(mid)).with("name", name).with("from", String.valueOf(from)).with(BundleKey.AUTHOR_SPACE_ANCHOR_TAB, anchorTab);
    }

    @JvmStatic
    public static final void gotoLogin(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Router.Companion.global().with(context).open(ROUTE_ACTIVITY_URI_LOGIN);
    }
}