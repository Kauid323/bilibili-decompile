package kntr.app.deepsearch.ui.colors;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import com.bilibili.compose.theme.BiliColors;
import com.bilibili.compose.theme.BiliColorsSourceKt;
import java.util.Map;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DSColors.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001a\u0010\u0014\u001a\u00020\u000f*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0001H\u0081\u0002¢\u0006\u0002\u0010\u0017\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\" \u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000f0\u000eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\" \u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000f0\u000eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u0018"}, d2 = {"INPUT_BOX", RoomRecommendViewModel.EMPTY_CURSOR, "THINKING_TITLE", "THINKING_TITLE_P_START", "THINKING_TITLE_P_END", "THINKING_TITLE_P_BLEND", "THINKING_TEXT", "THINKING_FAKE_BG_START", "THINKING_FAKE_BG_END", "THINKING_FAKE_BAR", "THINKING_STROKE", "THINKING_BACKGROUND_START", "THINKING_BACKGROUND_END", "dayMap", RoomRecommendViewModel.EMPTY_CURSOR, "Landroidx/compose/ui/graphics/Color;", "getDayMap", "()Ljava/util/Map;", "nightMap", "getNightMap", "get", "Lcom/bilibili/compose/theme/BiliColors;", "key", "(Lcom/bilibili/compose/theme/BiliColors;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)J", "compose_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DSColorsKt {
    public static final String INPUT_BOX = "input_box";
    public static final String THINKING_TITLE = "thinking_title";
    public static final String THINKING_TITLE_P_START = "thinking_title_p_start";
    public static final String THINKING_TITLE_P_END = "thinking_title_p_end";
    public static final String THINKING_TITLE_P_BLEND = "thinking_title_p_blend";
    public static final String THINKING_TEXT = "thinking_text";
    public static final String THINKING_FAKE_BG_START = "thinking_fake_bg_start";
    public static final String THINKING_FAKE_BG_END = "thinking_fake_bg_end";
    public static final String THINKING_FAKE_BAR = "thinking_fake_bar";
    public static final String THINKING_STROKE = "thinking_STROKE";
    public static final String THINKING_BACKGROUND_START = "thinking_background_start";
    public static final String THINKING_BACKGROUND_END = "thinking_background_end";
    private static final Map<String, Color> dayMap = MapsKt.mapOf(new Pair[]{TuplesKt.to(INPUT_BOX, Color.box-impl(ColorKt.Color(4294309368L))), TuplesKt.to(THINKING_TITLE, Color.box-impl(ColorKt.Color(4287928736L))), TuplesKt.to(THINKING_TITLE_P_START, Color.box-impl(ColorKt.Color(4292863231L))), TuplesKt.to(THINKING_TITLE_P_END, Color.box-impl(ColorKt.Color(4291487231L))), TuplesKt.to(THINKING_TITLE_P_BLEND, Color.box-impl(ColorKt.Color(4284385273L))), TuplesKt.to(THINKING_TEXT, Color.box-impl(ColorKt.Color(4279832386L))), TuplesKt.to(THINKING_FAKE_BG_START, Color.box-impl(ColorKt.Color(4294045695L))), TuplesKt.to(THINKING_FAKE_BG_END, Color.box-impl(ColorKt.Color(4293916927L))), TuplesKt.to(THINKING_FAKE_BAR, Color.box-impl(ColorKt.Color(643865343))), TuplesKt.to(THINKING_STROKE, Color.box-impl(ColorKt.Color(2582506239L))), TuplesKt.to(THINKING_BACKGROUND_START, Color.box-impl(ColorKt.Color(4294572543L))), TuplesKt.to(THINKING_BACKGROUND_END, Color.box-impl(ColorKt.Color(4294507775L)))});
    private static final Map<String, Color> nightMap = MapsKt.mapOf(new Pair[]{TuplesKt.to(INPUT_BOX, Color.box-impl(BiliColorsSourceKt.getNightColors().getGa2-0d7_KjU())), TuplesKt.to(THINKING_TITLE, Color.box-impl(ColorKt.Color(4287928736L))), TuplesKt.to(THINKING_TITLE_P_START, Color.box-impl(ColorKt.Color(4281545565L))), TuplesKt.to(THINKING_TITLE_P_END, Color.box-impl(ColorKt.Color(4279117883L))), TuplesKt.to(THINKING_TITLE_P_BLEND, Color.box-impl(ColorKt.Color(4283526066L))), TuplesKt.to(THINKING_FAKE_BG_START, Color.box-impl(ColorKt.Color(4279966509L))), TuplesKt.to(THINKING_FAKE_BG_END, Color.box-impl(ColorKt.Color(4278983977L))), TuplesKt.to(THINKING_FAKE_BAR, Color.box-impl(ColorKt.Color(639590092))), TuplesKt.to(THINKING_TEXT, Color.box-impl(ColorKt.Color(4287009974L))), TuplesKt.to(THINKING_STROKE, Color.box-impl(ColorKt.Color(2571913564L))), TuplesKt.to(THINKING_BACKGROUND_START, Color.box-impl(ColorKt.Color(4279966509L))), TuplesKt.to(THINKING_BACKGROUND_END, Color.box-impl(ColorKt.Color(4278983977L)))});

    public static final Map<String, Color> getDayMap() {
        return dayMap;
    }

    public static final Map<String, Color> getNightMap() {
        return nightMap;
    }

    public static final long get(BiliColors $this$get, String key, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$get, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        ComposerKt.sourceInformationMarkerStart($composer, -1187497485, "C(get)N(key):DSColors.kt#mcacju");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1187497485, $changed, -1, "kntr.app.deepsearch.ui.colors.get (DSColors.kt:57)");
        }
        Color color = (Intrinsics.areEqual($this$get, BiliColorsSourceKt.getDayColors()) ? dayMap : nightMap).get(key);
        long j2 = color != null ? color.unbox-impl() : Color.Companion.getTransparent-0d7_KjU();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return j2;
    }
}