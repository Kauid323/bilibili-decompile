package kntr.app.ad.domain.click.internal.interop;

import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import kntr.app.ad.domain.click.internal.ClickContext;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;

/* compiled from: IMax.android.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0080@¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"openIMax", RoomRecommendViewModel.EMPTY_CURSOR, "context", "Lkntr/app/ad/domain/click/internal/ClickContext;", "url", RoomRecommendViewModel.EMPTY_CURSOR, "(Lkntr/app/ad/domain/click/internal/ClickContext;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "click_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IMax_androidKt {
    public static final Object openIMax(ClickContext context, String url, Continuation<? super Boolean> continuation) {
        RouteRequest request = new RouteRequest.Builder(url).build();
        BLRouter.routeTo(request, context.getService().getPlatformContext());
        return Boxing.boxBoolean(true);
    }
}