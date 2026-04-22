package kntr.app.ad.domain.click.internal.util;

import android.net.Uri;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import kntr.app.ad.domain.click.internal.ClickContext;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OpenWebHelper.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\u000b"}, d2 = {"Lkntr/app/ad/domain/click/internal/util/OpenWebHelper;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "openAdWeb", RoomRecommendViewModel.EMPTY_CURSOR, "context", "Lkntr/app/ad/domain/click/internal/ClickContext;", "url", RoomRecommendViewModel.EMPTY_CURSOR, "openMWeb", "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class OpenWebHelper {
    public static final OpenWebHelper INSTANCE = new OpenWebHelper();

    private OpenWebHelper() {
    }

    public final boolean openAdWeb(ClickContext context, String url) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        context.getService().addOpenApkInfoIfNeed();
        context.getService().openAdWeb(context.getService().getPlatformContext(), url, context.isInstalled());
        return true;
    }

    public final boolean openMWeb(ClickContext context, String url) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        context.getService().addOpenApkInfoIfNeed();
        RouteRequest request = new RouteRequest.Builder("bilibili://browser").data(Uri.parse(url)).build();
        BLRouter.routeTo(request, context.getService().getPlatformContext());
        return true;
    }
}