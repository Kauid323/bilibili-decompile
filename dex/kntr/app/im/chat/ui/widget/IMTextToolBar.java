package kntr.app.im.chat.ui.widget;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import kntr.app.ad.domain.alarm.AdAlarmExtraKey;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMTextToolBar.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JP\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\r2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\r2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\r2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\rH\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/im/chat/ui/widget/IMTextToolBar;", "Landroidx/compose/ui/platform/TextToolbar;", "<init>", "()V", AdAlarmExtraKey.STATUS, "Landroidx/compose/ui/platform/TextToolbarStatus;", "getStatus", "()Landroidx/compose/ui/platform/TextToolbarStatus;", "showMenu", RoomRecommendViewModel.EMPTY_CURSOR, "rect", "Landroidx/compose/ui/geometry/Rect;", "onCopyRequested", "Lkotlin/Function0;", "onPasteRequested", "onCutRequested", "onSelectAllRequested", "hide", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMTextToolBar implements TextToolbar {
    public static final int $stable = 0;

    public /* bridge */ void showMenu(Rect rect, Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03, Function0<Unit> function04, Function0<Unit> function05) {
        TextToolbar.-CC.$default$showMenu(this, rect, function0, function02, function03, function04, function05);
    }

    public TextToolbarStatus getStatus() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public void showMenu(Rect rect, Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03, Function0<Unit> function04) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public void hide() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}