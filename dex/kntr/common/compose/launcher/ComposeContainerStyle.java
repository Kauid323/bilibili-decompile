package kntr.common.compose.launcher;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* compiled from: ComposeContainerStyle.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JA\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006¢\u0006\u0002\b\u00072\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006¢\u0006\u0002\b\u0007H&¢\u0006\u0002\u0010\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lkntr/common/compose/launcher/ComposeContainerStyle;", "", "style", "Lkotlin/Function1;", "Landroidx/compose/ui/Modifier;", "", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/UiComposable;", "original", "(Lkotlin/jvm/functions/Function3;)Lkotlin/jvm/functions/Function3;", "compose-launcher_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface ComposeContainerStyle {
    Function3<Modifier, Composer, Integer, Unit> style(Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function3);
}