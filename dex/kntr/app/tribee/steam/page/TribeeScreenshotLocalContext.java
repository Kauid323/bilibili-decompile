package kntr.app.tribee.steam.page;

import android.app.Activity;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kntr.common.screenshot.ScreenshotLocalContext;
import kotlin.Metadata;

/* compiled from: TribeeScreenshotLocalContext.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lkntr/app/tribee/steam/page/TribeeScreenshotLocalContext;", "Lkntr/common/screenshot/ScreenshotLocalContext;", "activity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "currentContext", "", "getCurrentContext", "()Ljava/lang/Object;", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeScreenshotLocalContext implements ScreenshotLocalContext {
    public static final int $stable = 8;
    private final Activity activity;

    public TribeeScreenshotLocalContext(Activity activity) {
        this.activity = activity;
        if (this.activity != null) {
            return;
        }
        KLog_androidKt.getKLog().e("TribeeScreenshotLocalContext", "activity is null");
    }

    @Override // kntr.common.screenshot.ScreenshotLocalContext
    public Object getCurrentContext() {
        Activity activity = this.activity;
        return activity == null ? "" : activity;
    }
}