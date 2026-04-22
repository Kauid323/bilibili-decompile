package kntr.app.im.chat.ui.utils;

import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextStyleExt.android.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0000\u001a\u00020\u0002¨\u0006\u0003"}, d2 = {"includeFontPadding", "Landroidx/compose/ui/text/TextStyle;", RoomRecommendViewModel.EMPTY_CURSOR, "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class TextStyleExt_androidKt {
    public static /* synthetic */ TextStyle includeFontPadding$default(TextStyle textStyle, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return includeFontPadding(textStyle, z);
    }

    public static final TextStyle includeFontPadding(TextStyle $this$includeFontPadding, boolean includeFontPadding) {
        Intrinsics.checkNotNullParameter($this$includeFontPadding, "<this>");
        return $this$includeFontPadding.merge(new TextStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, new PlatformTextStyle(includeFontPadding), (LineHeightStyle) null, 0, 0, (TextMotion) null, 16252927, (DefaultConstructorMarker) null));
    }
}