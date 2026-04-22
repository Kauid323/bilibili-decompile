package kntr.common.screenshot;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: ScreenshotProvider.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lkntr/common/screenshot/ScreenshotProvider;", "", "registerContentObserver", "", "context", "Lkntr/common/screenshot/ScreenshotLocalContext;", "listener", "Lkntr/common/screenshot/ScreenshotListener;", "unregisterContentObserver", "screenshot_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface ScreenshotProvider {
    void registerContentObserver(ScreenshotLocalContext screenshotLocalContext, ScreenshotListener screenshotListener);

    void unregisterContentObserver(ScreenshotLocalContext screenshotLocalContext, ScreenshotListener screenshotListener);
}