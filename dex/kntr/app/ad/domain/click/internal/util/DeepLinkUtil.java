package kntr.app.ad.domain.click.internal.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import java.util.List;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeepLinkUtil.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"Lkntr/app/ad/domain/click/internal/util/DeepLinkUtil;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "isApkInstalled", RoomRecommendViewModel.EMPTY_CURSOR, "context", "Landroid/content/Context;", "url", RoomRecommendViewModel.EMPTY_CURSOR, "canHandleIntent", "intent", "Landroid/content/Intent;", "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeepLinkUtil {
    public static final DeepLinkUtil INSTANCE = new DeepLinkUtil();

    private DeepLinkUtil() {
    }

    public final boolean isApkInstalled(Context context, String url) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
        return canHandleIntent(context, intent);
    }

    public final boolean canHandleIntent(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        try {
            List resolveInfos = context.getPackageManager().queryIntentActivities(intent, 65536);
            Intrinsics.checkNotNullExpressionValue(resolveInfos, "queryIntentActivities(...)");
            return !resolveInfos.isEmpty();
        } catch (Exception e) {
            return false;
        }
    }
}