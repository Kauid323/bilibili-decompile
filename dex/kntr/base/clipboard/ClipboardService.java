package kntr.base.clipboard;

import androidx.compose.ui.platform.ClipEntry;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: ClipboardService.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lkntr/base/clipboard/ClipboardService;", "", "writeTextIntoClipBoard", "", "text", "", "readTextFromClipBoard", "generateClipboardEntry", "Landroidx/compose/ui/platform/ClipEntry;", "clipboard_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface ClipboardService {
    ClipEntry generateClipboardEntry(String str);

    String readTextFromClipBoard();

    void writeTextIntoClipBoard(String str);
}