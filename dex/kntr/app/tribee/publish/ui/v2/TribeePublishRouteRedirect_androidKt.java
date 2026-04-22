package kntr.app.tribee.publish.ui.v2;

import com.bilibili.lib.brouter.uri.Uri;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kntr.base.router.target.RouterTarget;
import kntr.base.router.target.RouterTargetContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeePublishRouteRedirect.android.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"tribeeAndroidRedirect", "Lkntr/base/router/target/RouterTarget;", "Lkntr/base/router/target/RouterTargetContext;", "TAG", "", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeePublishRouteRedirect_androidKt {
    private static final String TAG = "TribeeRoute";

    public static final RouterTarget tribeeAndroidRedirect(RouterTargetContext $this$tribeeAndroidRedirect) {
        String version;
        Intrinsics.checkNotNullParameter($this$tribeeAndroidRedirect, "<this>");
        if (TribeeConfig.INSTANCE.getUsePublishV2()) {
            version = "v2";
        } else {
            version = "v1";
        }
        Uri url = $this$tribeeAndroidRedirect.getUri();
        Uri.Builder $this$tribeeAndroidRedirect_u24lambda_u240 = new Uri.Builder().scheme(url.getScheme()).authority(url.getAuthority());
        Iterable $this$forEach$iv = url.getPathSegments();
        for (Object element$iv : $this$forEach$iv) {
            String it = (String) element$iv;
            $this$tribeeAndroidRedirect_u24lambda_u240.appendPath(it);
            if (Intrinsics.areEqual(it, "edit") || Intrinsics.areEqual(it, "publish")) {
                $this$tribeeAndroidRedirect_u24lambda_u240.appendPath(version);
            }
        }
        Uri newUrl = $this$tribeeAndroidRedirect_u24lambda_u240.encodedQuery(url.getEncodedQuery()).build();
        KLog_androidKt.getKLog().i(TAG, "Redirecting to " + newUrl);
        return $this$tribeeAndroidRedirect.find(newUrl);
    }
}