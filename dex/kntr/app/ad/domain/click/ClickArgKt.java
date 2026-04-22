package kntr.app.ad.domain.click;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClickArg.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a!\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0007¨\u0006\u0007"}, d2 = {"clickArg", "Lkntr/app/ad/domain/click/ClickArg;", "block", "Lkotlin/Function1;", "Lkntr/app/ad/domain/click/ClickArgBuilder;", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlin/ExtensionFunctionType;", "click_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ClickArgKt {
    public static final ClickArg clickArg(Function1<? super ClickArgBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        ClickArgBuilder clickArgBuilder = new ClickArgBuilder();
        function1.invoke(clickArgBuilder);
        return clickArgBuilder.build();
    }
}