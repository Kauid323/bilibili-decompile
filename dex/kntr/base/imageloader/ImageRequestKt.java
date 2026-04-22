package kntr.base.imageloader;

import com.bilibili.lib.brouter.uri.Url;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.ILogger;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImageRequest.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, d2 = {"isBfsUrl", "", "", "imageloader_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ImageRequestKt {
    public static final /* synthetic */ boolean access$isBfsUrl(String $receiver) {
        return isBfsUrl($receiver);
    }

    public static final boolean isBfsUrl(String $this$isBfsUrl) {
        try {
            Result.Companion companion = Result.Companion;
            Url uri = Url.Companion.parse($this$isBfsUrl);
            return Intrinsics.areEqual(uri.getPathSegments().get(0), "bfs");
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Throwable it = Result.m2639exceptionOrNullimpl(Result.m2636constructorimpl(ResultKt.createFailure(th)));
            if (it != null) {
                ILogger kLog = KLog_androidKt.getKLog();
                String message = it.getMessage();
                kLog.e(ApiKt.TAG, "url parse error, message = " + message + ", cause = " + it.getCause());
            }
            return false;
        }
    }
}