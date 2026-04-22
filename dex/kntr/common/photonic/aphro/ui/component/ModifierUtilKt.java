package kntr.common.photonic.aphro.ui.component;

import androidx.compose.ui.Modifier;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ModifierUtil.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a,\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0005H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0006"}, d2 = {"ifMatch", "Landroidx/compose/ui/Modifier;", "predict", "", "block", "Lkotlin/Function1;", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ModifierUtilKt {
    public static final Modifier ifMatch(Modifier $this$ifMatch, boolean predict, Function1<? super Modifier, ? extends Modifier> function1) {
        Intrinsics.checkNotNullParameter($this$ifMatch, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        return predict ? (Modifier) function1.invoke($this$ifMatch) : $this$ifMatch;
    }
}