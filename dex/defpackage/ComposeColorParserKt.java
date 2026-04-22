package defpackage;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import java.util.List;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* compiled from: ComposeColorParser.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b¢\u0006\u0002\u0010\u0003\u001a\u000f\u0010\u0004\u001a\u00020\u0001*\u00020\u0002¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"rememberAsColor", "Landroidx/compose/ui/graphics/Color;", "", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)J", "parseColor", "(Ljava/lang/String;)J", "compose-utils_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: ComposeColorParserKt  reason: default package */
public final class ComposeColorParserKt {
    public static final long rememberAsColor(String $this$rememberAsColor, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$rememberAsColor, "<this>");
        ComposerKt.sourceInformationMarkerStart($composer, -1146072542, "CC(rememberAsColor)8@245L48:ComposeColorParser.kt");
        ComposerKt.sourceInformationMarkerStart($composer, -1864083694, "CC(remember):ComposeColorParser.kt#9igjgp");
        boolean invalid$iv = ((($changed & 14) ^ 6) > 4 && $composer.changed($this$rememberAsColor)) || ($changed & 6) == 4;
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = Color.box-impl(parseColor($this$rememberAsColor));
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        long j = ((Color) it$iv).unbox-impl();
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        return j;
    }

    public static final long parseColor(String $this$parseColor) {
        int a;
        Intrinsics.checkNotNullParameter($this$parseColor, "<this>");
        try {
            List colorFields = CollectionsKt.toMutableList(StringsKt.chunked(StringsKt.substringAfter$default($this$parseColor, "#", (String) null, 2, (Object) null), 2));
            if (colorFields.size() == 4) {
                a = Integer.parseInt((String) colorFields.remove(0), CharsKt.checkRadix(16));
            } else {
                a = 255;
            }
            int r = Integer.parseInt((String) colorFields.remove(0), CharsKt.checkRadix(16));
            int g = Integer.parseInt((String) colorFields.remove(0), CharsKt.checkRadix(16));
            int b = Integer.parseInt((String) colorFields.remove(0), CharsKt.checkRadix(16));
            return ColorKt.Color(r, g, b, a);
        } catch (Exception e) {
            KLog_androidKt.getKLog().e("ComposeUtils", "Fail to parse color " + $this$parseColor, e);
            return Color.Companion.getTransparent-0d7_KjU();
        }
    }
}