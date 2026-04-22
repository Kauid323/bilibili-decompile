package kntr.app.ad.domain.click.internal.interop;

import kntr.app.ad.domain.click.IClickContext;
import kntr.app.ad.domain.click.internal.ActionUiEvent;
import kntr.app.ad.domain.click.internal.ClickContext;
import kntr.app.ad.domain.click.internal.util.OpenWebHelper;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;

/* compiled from: AdWeb.android.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0080@¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"openAdWeb", RoomRecommendViewModel.EMPTY_CURSOR, "context", "Lkntr/app/ad/domain/click/internal/ClickContext;", "url", RoomRecommendViewModel.EMPTY_CURSOR, "(Lkntr/app/ad/domain/click/internal/ClickContext;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "click_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AdWeb_androidKt {
    public static final Object openAdWeb(ClickContext context, String url, Continuation<? super Boolean> continuation) {
        IClickContext.CC.reportUi$default(context, ActionUiEvent.ROUTE_AD_BROWSER, null, 2, null);
        return Boxing.boxBoolean(OpenWebHelper.INSTANCE.openAdWeb(context, url));
    }
}