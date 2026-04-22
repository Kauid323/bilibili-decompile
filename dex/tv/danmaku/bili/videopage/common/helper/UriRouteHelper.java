package tv.danmaku.bili.videopage.common.helper;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequestKt;
import com.bilibili.moduleservice.account.AccountService;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: UriRouteHelper.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0007J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0005H\u0007J\b\u0010\u000f\u001a\u00020\u0010H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/videopage/common/helper/UriRouteHelper;", "", "<init>", "()V", "LOGIN", "", "VIDEO_DETAIL", "goToUri", "", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "goToVideo", "avid", "isAuthorVipLabelEnable", "", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class UriRouteHelper {
    public static final UriRouteHelper INSTANCE = new UriRouteHelper();
    private static final String LOGIN = "activity://main/login/";
    private static final String VIDEO_DETAIL = "bilibili://video/";

    private UriRouteHelper() {
    }

    @JvmStatic
    public static final void goToUri(Context context, String uri) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        if (TextUtils.isEmpty(uri)) {
            return;
        }
        BLRouter.routeTo(RouteRequestKt.toRouteRequest(uri), context);
    }

    @JvmStatic
    public static final void goToUri(Context context, Uri uri) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (uri != null) {
            String uri2 = uri.toString();
            Intrinsics.checkNotNullExpressionValue(uri2, "toString(...)");
            goToUri(context, uri2);
        }
    }

    @JvmStatic
    public static final void goToVideo(Context context, String avid) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(avid, "avid");
        Uri uri = Uri.parse(VIDEO_DETAIL).buildUpon().path(avid).build();
        goToUri(context, uri);
    }

    @JvmStatic
    public static final boolean isAuthorVipLabelEnable() {
        AccountService accountService = (AccountService) BLRouter.INSTANCE.get(AccountService.class, "default");
        if (accountService != null) {
            return accountService.isNewVipLabel();
        }
        return false;
    }
}