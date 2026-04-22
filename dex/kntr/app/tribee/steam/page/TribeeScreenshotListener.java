package kntr.app.tribee.steam.page;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.screenshot.ScreenshotListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeeScreenshotListener.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0016R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lkntr/app/tribee/steam/page/TribeeScreenshotListener;", "Lkntr/common/screenshot/ScreenshotListener;", "action", "Lkotlin/Function1;", "", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getAction", "()Lkotlin/jvm/functions/Function1;", "onScreenshotTaken", "filePath", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeScreenshotListener implements ScreenshotListener {
    public static final int $stable = 0;
    private final Function1<String, Unit> action;

    /* JADX WARN: Multi-variable type inference failed */
    public TribeeScreenshotListener(Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "action");
        this.action = function1;
    }

    public final Function1<String, Unit> getAction() {
        return this.action;
    }

    @Override // kntr.common.screenshot.ScreenshotListener
    public void onScreenshotTaken(String filePath) {
        this.action.invoke(filePath == null ? "" : filePath);
    }
}