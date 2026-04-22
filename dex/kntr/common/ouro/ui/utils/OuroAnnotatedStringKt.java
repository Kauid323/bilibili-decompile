package kntr.common.ouro.ui.utils;

import androidx.compose.ui.text.AnnotatedString;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.ui.utils.OuroAnnotatedString;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroAnnotatedString.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a%\u0010\u0007\u001a\u00020\b2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\rH\u0080\bø\u0001\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000*$\b\u0002\u0010\u0000\"\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000e"}, d2 = {"AnnotationMap", "", "", "Lkntr/common/ouro/ui/utils/OuroCustomStyle;", "LIST_ORDER_MINIMAL_WIDTH", "", "LIST_ORDER_SPACING", "buildOuroAnnotatedString", "Lkntr/common/ouro/ui/utils/OuroAnnotatedString;", "builder", "Lkotlin/Function1;", "Lkntr/common/ouro/ui/utils/OuroAnnotatedString$Builder;", "", "Lkotlin/ExtensionFunctionType;", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroAnnotatedStringKt {
    public static final double LIST_ORDER_MINIMAL_WIDTH = 18.0d;
    public static final double LIST_ORDER_SPACING = 4.0d;

    public static final OuroAnnotatedString buildOuroAnnotatedString(Function1<? super OuroAnnotatedString.Builder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "builder");
        OuroAnnotatedString.Builder builder = new OuroAnnotatedString.Builder(new AnnotatedString.Builder(0, 1, (DefaultConstructorMarker) null), null, null, null, null, null, 62, null);
        function1.invoke(builder);
        return builder.toAnnotatedString();
    }
}