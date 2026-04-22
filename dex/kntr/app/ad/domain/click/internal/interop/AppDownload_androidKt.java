package kntr.app.ad.domain.click.internal.interop;

import kntr.app.ad.domain.click.internal.ClickContext;
import kntr.app.ad.domain.click.internal.action.results.DownloadFailureReason;
import kntr.app.ad.domain.click.internal.action.results.DownloadResult;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: AppDownload.android.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0080@¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"appDownload", "Lkntr/app/ad/domain/click/internal/action/results/DownloadResult;", "context", "Lkntr/app/ad/domain/click/internal/ClickContext;", "url", RoomRecommendViewModel.EMPTY_CURSOR, "(Lkntr/app/ad/domain/click/internal/ClickContext;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "click_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AppDownload_androidKt {
    public static final Object appDownload(ClickContext context, String url, Continuation<? super DownloadResult> continuation) {
        if (context.getService().downloadApk(context.getService().getPlatformContext(), url)) {
            return DownloadResult.Success.INSTANCE;
        }
        return new DownloadResult.Failure(new DownloadFailureReason.InternalError(null, 1, null));
    }
}