package kntr.app.ad.domain.click.internal.interop;

import kntr.app.ad.domain.click.ClickService;
import kntr.app.ad.domain.click.internal.ClickContext;
import kntr.app.ad.domain.click.internal.action.results.WxOpenFailureReason;
import kntr.app.ad.domain.click.internal.action.results.WxOpenResult;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: WxProgram.android.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0080@¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"openWxProgram", "Lkntr/app/ad/domain/click/internal/action/results/WxOpenResult;", "context", "Lkntr/app/ad/domain/click/internal/ClickContext;", "orgId", RoomRecommendViewModel.EMPTY_CURSOR, "name", "path", "(Lkntr/app/ad/domain/click/internal/ClickContext;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "click_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class WxProgram_androidKt {
    public static final Object openWxProgram(ClickContext context, String orgId, String name, String path, Continuation<? super WxOpenResult> continuation) {
        if (ClickService.CC.openWxProgram$default(context.getService(), context.getService().getPlatformContext(), orgId, path, null, 8, null)) {
            return WxOpenResult.Success.INSTANCE;
        }
        return new WxOpenResult.Failure(new WxOpenFailureReason.InternalError("Failed to open WeChat mini program"));
    }
}