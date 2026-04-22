package kntr.app.ad.domain.click.internal.interop;

import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteRequest;
import kntr.app.ad.domain.click.internal.ClickContext;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BiliNative.android.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0080@¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"openBiliNative", RoomRecommendViewModel.EMPTY_CURSOR, "context", "Lkntr/app/ad/domain/click/internal/ClickContext;", "url", RoomRecommendViewModel.EMPTY_CURSOR, "(Lkntr/app/ad/domain/click/internal/ClickContext;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "click_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BiliNative_androidKt {
    public static final Object openBiliNative(ClickContext context, final String url, Continuation<? super Boolean> continuation) {
        RouteRequest request = new RouteRequest.Builder(url).extras(new Function1() { // from class: kntr.app.ad.domain.click.internal.interop.BiliNative_androidKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit openBiliNative$lambda$0;
                openBiliNative$lambda$0 = BiliNative_androidKt.openBiliNative$lambda$0(url, (MutableBundleLike) obj);
                return openBiliNative$lambda$0;
            }
        }).build();
        BLRouter.routeTo(request, context.getService().getPlatformContext());
        return Boxing.boxBoolean(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit openBiliNative$lambda$0(String $url, MutableBundleLike $this$extras) {
        Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
        $this$extras.put("ori_url", $url);
        $this$extras.put("bili_only", "1");
        return Unit.INSTANCE;
    }
}