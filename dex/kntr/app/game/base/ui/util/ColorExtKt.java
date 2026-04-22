package kntr.app.game.base.ui.util;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* compiled from: ColorExt.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u0011\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001d\u0010\u0005\u001a\u00020\u0002*\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"argbToHsl", RoomRecommendViewModel.EMPTY_CURSOR, "Landroidx/compose/ui/graphics/Color;", "argbToHsl-8_81llA", "(J)[F", "toColor", RoomRecommendViewModel.EMPTY_CURSOR, "defaultColor", "toColor-4WTKRHQ", "(Ljava/lang/String;J)J", "base-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ColorExtKt {
    /* renamed from: argbToHsl-8_81llA  reason: not valid java name */
    public static final float[] m1086argbToHsl8_81llA(long j2) {
        float s;
        float f;
        float h;
        float r = Color.getRed-impl(j2);
        float g = Color.getGreen-impl(j2);
        float b = Color.getBlue-impl(j2);
        float max = Math.max(r, Math.max(g, b));
        float min = Math.min(r, Math.min(g, b));
        float delta = max - min;
        float f2 = 2;
        float l = (max + min) / f2;
        if (delta == 0.0f) {
            h = 0.0f;
            s = 0.0f;
        } else {
            s = delta / (l < 0.5f ? max + min : (f2 - max) - min);
            if (max == r) {
                f = ((g - b) / delta) + (g < b ? 6 : 0);
            } else {
                f = (max > g ? 1 : (max == g ? 0 : -1)) == 0 ? f2 + ((b - r) / delta) : ((r - g) / delta) + 4;
            }
            h = f / 6;
        }
        return new float[]{360 * h, s, l};
    }

    /* renamed from: toColor-4WTKRHQ$default  reason: not valid java name */
    public static /* synthetic */ long m1088toColor4WTKRHQ$default(String str, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j2 = Color.Companion.getTransparent-0d7_KjU();
        }
        return m1087toColor4WTKRHQ(str, j2);
    }

    /* renamed from: toColor-4WTKRHQ  reason: not valid java name */
    public static final long m1087toColor4WTKRHQ(String $this$toColor_u2d4WTKRHQ, long j2) {
        String expandedColorString;
        if ($this$toColor_u2d4WTKRHQ == null) {
            return j2;
        }
        try {
            String colorString = StringsKt.removePrefix($this$toColor_u2d4WTKRHQ, "#");
            int i = 0;
            switch (colorString.length()) {
                case 3:
                    String $this$map$iv = colorString;
                    Collection destination$iv$iv = new ArrayList($this$map$iv.length());
                    while (i < $this$map$iv.length()) {
                        char item$iv$iv = $this$map$iv.charAt(i);
                        destination$iv$iv.add(new StringBuilder().append(item$iv$iv).append(item$iv$iv).toString());
                        i++;
                    }
                    expandedColorString = CollectionsKt.joinToString$default((List) destination$iv$iv, RoomRecommendViewModel.EMPTY_CURSOR, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
                    break;
                case 4:
                    String $this$map$iv2 = colorString;
                    Collection destination$iv$iv2 = new ArrayList($this$map$iv2.length());
                    while (i < $this$map$iv2.length()) {
                        char item$iv$iv2 = $this$map$iv2.charAt(i);
                        destination$iv$iv2.add(new StringBuilder().append(item$iv$iv2).append(item$iv$iv2).toString());
                        i++;
                    }
                    expandedColorString = CollectionsKt.joinToString$default((List) destination$iv$iv2, RoomRecommendViewModel.EMPTY_CURSOR, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
                    break;
                case 5:
                case 7:
                default:
                    return j2;
                case 6:
                case 8:
                    expandedColorString = colorString;
                    break;
            }
            long colorInt = Long.parseLong(expandedColorString, CharsKt.checkRadix(16));
            return ColorKt.Color((int) ((colorInt >> 16) & 255), (int) ((colorInt >> 8) & 255), (int) (colorInt & 255), expandedColorString.length() == 8 ? (int) (255 & (colorInt >> 24)) : 255);
        } catch (Exception e) {
            return j2;
        }
    }
}