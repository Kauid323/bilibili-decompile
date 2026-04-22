package tv.danmaku.bili.videopage.common.helper;

import android.content.Context;
import android.text.TextUtils;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.router.Router;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BangumiRoutes.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005J8\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0002JB\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Ltv/danmaku/bili/videopage/common/helper/BangumiRoutes;", "", "<init>", "()V", "URI_BANGUMI_DETAIL", "", "BD_FROM_OFFLINE_CACHE", "", "BD_FROM_VIDEO_DETAIL", "SPMID_MAIN_CACHE", "goToDetail", "", "context", "Landroid/content/Context;", "seasonId", "from", "spmidFrom", "epId", "url", "BundleKey", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BangumiRoutes {
    public static final int BD_FROM_OFFLINE_CACHE = 13;
    public static final int BD_FROM_VIDEO_DETAIL = 4;
    public static final BangumiRoutes INSTANCE = new BangumiRoutes();
    public static final String SPMID_MAIN_CACHE = "main.my-cache.0.0";
    public static final String URI_BANGUMI_DETAIL = "bilibili://pgc/season";

    private BangumiRoutes() {
    }

    public final void goToDetail(Context context, String seasonId, int from, String spmidFrom) {
        Router.Companion.global().with(context).with("season_id", seasonId).with("intentFrom", String.valueOf(from)).with("from_spmid", spmidFrom).with(BundleKey.DETAIL_COMMENT_STATE, "0").open(URI_BANGUMI_DETAIL);
    }

    private final void goToDetail(Context context, String seasonId, String epId, int from, String spmidFrom) {
        Router.Companion.global().with(context).with("season_id", seasonId).with("epid", epId).with("intentFrom", String.valueOf(from)).with("from_spmid", spmidFrom).with(BundleKey.DETAIL_COMMENT_STATE, "0").open(URI_BANGUMI_DETAIL);
    }

    @JvmStatic
    public static final void goToDetail(Context context, String seasonId, String epId, final int from, final String spmidFrom, String url) {
        String str = url;
        if (str == null || str.length() == 0) {
            if (TextUtils.isEmpty(epId)) {
                INSTANCE.goToDetail(context, seasonId, from, spmidFrom);
                return;
            } else {
                INSTANCE.goToDetail(context, seasonId, epId, from, spmidFrom);
                return;
            }
        }
        RouteRequest request = new RouteRequest.Builder(url).extras(new Function1() { // from class: tv.danmaku.bili.videopage.common.helper.BangumiRoutes$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit goToDetail$lambda$0;
                goToDetail$lambda$0 = BangumiRoutes.goToDetail$lambda$0(from, spmidFrom, (MutableBundleLike) obj);
                return goToDetail$lambda$0;
            }
        }).build();
        BLRouter.routeTo(request, context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit goToDetail$lambda$0(int $from, String $spmidFrom, MutableBundleLike $this$extras) {
        Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
        $this$extras.put("intentFrom", String.valueOf($from));
        Intrinsics.checkNotNull($spmidFrom);
        $this$extras.put("from_spmid", $spmidFrom);
        $this$extras.put(BundleKey.DETAIL_COMMENT_STATE, "0");
        return Unit.INSTANCE;
    }

    /* compiled from: BangumiRoutes.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/videopage/common/helper/BangumiRoutes$BundleKey;", "", "<init>", "()V", "DETAIL_FROM", "", "DETAIL_FROM_SPMID", "DETAIL_SEASON_ID", "DETAIL_EP_ID", "DETAIL_COMMENT_STATE", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class BundleKey {
        public static final String DETAIL_COMMENT_STATE = "comment_state";
        public static final String DETAIL_EP_ID = "epid";
        public static final String DETAIL_FROM = "intentFrom";
        public static final String DETAIL_FROM_SPMID = "from_spmid";
        public static final String DETAIL_SEASON_ID = "season_id";
        public static final BundleKey INSTANCE = new BundleKey();

        private BundleKey() {
        }
    }
}