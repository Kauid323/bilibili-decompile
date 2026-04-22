package kntr.compose.avatar.internal;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.painter.Painter;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BiliImagePainterKt;
import kntr.base.imageloader.ImageRequest;
import kntr.base.imageloader.ImmutableImageRequest;
import kntr.base.imageloader.Pixel;
import kntr.base.imageloader.Style;
import kntr.compose.avatar.AvatarLayerScope;
import kntr.compose.avatar.model.LocalResourceKt;
import kntr.compose.avatar.model.common.PositionSpec;
import kntr.compose.avatar.model.common.SizeSpec;
import kntr.compose.avatar.model.common.UrlResource;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000F\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001aB\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00012\b\u0010\u0003\u001a\u0004\u0018\u0001H\u00022\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u0005¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u001b\u0010\b\u001a\u0004\u0018\u00010\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0001¢\u0006\u0002\u0010\r\u001a\u001f\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000f*\u00020\u0011H\u0001¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001f\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000f*\u00020\u0014H\u0001¢\u0006\u0004\b\u0015\u0010\u0013\u001a\u0018\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000f*\u00020\u0016H\u0001\u001a\u0018\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000f*\u00020\u0017H\u0001\u001a\u0018\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000f*\u00020\u0018H\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0019"}, d2 = {"withNullable", "R", "T", "t", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "getPainter", "Landroidx/compose/ui/graphics/painter/Painter;", "Lkntr/compose/avatar/AvatarLayerScope;", "resource", "Lkntr/compose/avatar/model/common/UrlResource;", "(Lkntr/compose/avatar/AvatarLayerScope;Lkntr/compose/avatar/model/common/UrlResource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/painter/Painter;", "inspectInfo", "", "", "Landroidx/compose/ui/geometry/Size;", "inspectInfo-uvyYCjk", "(J)Ljava/util/Map;", "Landroidx/compose/ui/geometry/Offset;", "inspectInfo-k-4lQ0M", "Landroidx/compose/ui/geometry/Rect;", "Lkntr/compose/avatar/model/common/SizeSpec;", "Lkntr/compose/avatar/model/common/PositionSpec;", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class UtilsKt {
    public static final <T, R> R withNullable(T t, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        if (t != null) {
            return (R) function1.invoke(t);
        }
        return null;
    }

    public static final Painter getPainter(AvatarLayerScope $this$getPainter, UrlResource resource, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$getPainter, "<this>");
        Intrinsics.checkNotNullParameter(resource, "resource");
        ComposerKt.sourceInformationMarkerStart($composer, -1805869231, "C(getPainter)N(resource)45@1432L12,47@1469L70,50@1567L43,51@1648L100,51@1615L133:Utils.kt#cxtxmf");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1805869231, $changed, -1, "kntr.compose.avatar.internal.getPainter (Utils.kt:38)");
        }
        String $this$asRequest$iv = resource.getUrl();
        ImageRequest $this$getPainter_u24lambda_u240 = new ImageRequest($this$asRequest$iv);
        $this$getPainter_u24lambda_u240.m1492requestStyleR_Oh58k(Style.m1584constructorimpl(resource.getStyle()));
        int bits$iv$iv$iv = (int) ($this$getPainter.mo2456getLayerSizeNHjbRc() >> 32);
        $this$getPainter_u24lambda_u240.m1493requestWidth3VbuI34(Pixel.m1517constructorimpl(MathKt.roundToInt(Float.intBitsToFloat(bits$iv$iv$iv))));
        int bits$iv$iv$iv2 = (int) (4294967295L & $this$getPainter.mo2456getLayerSizeNHjbRc());
        $this$getPainter_u24lambda_u240.m1488requestHeight3VbuI34(Pixel.m1517constructorimpl(MathKt.roundToInt(Float.intBitsToFloat(bits$iv$iv$iv2))));
        ImmutableImageRequest request = $this$getPainter_u24lambda_u240.build();
        Painter placeholder = LocalResourceKt.getPainter(resource.getPlaceHolder(), $composer, 0);
        ComposerKt.sourceInformationMarkerStart($composer, -273531113, "CC(remember):Utils.kt#9igjgp");
        boolean invalid$iv = ((($changed & 112) ^ 48) > 32 && $composer.changed(resource)) || ($changed & 48) == 32;
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = SnapshotStateKt.mutableStateOf$default(placeholder, (SnapshotMutationPolicy) null, 2, (Object) null);
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        MutableState state = (MutableState) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        Painter biliImagePainter = BiliImagePainterKt.rememberBiliImagePainter(request, $composer, 0);
        ComposerKt.sourceInformationMarkerStart($composer, -273525355, "CC(remember):Utils.kt#9igjgp");
        boolean invalid$iv2 = $composer.changedInstance(biliImagePainter) | $composer.changed(state);
        Object it$iv2 = $composer.rememberedValue();
        if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
            Object value$iv2 = (Function2) new UtilsKt$getPainter$1$1(biliImagePainter, state, null);
            $composer.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.LaunchedEffect(biliImagePainter, (Function2) it$iv2, $composer, Painter.$stable);
        Painter painter = (Painter) state.getValue();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return painter;
    }

    /* renamed from: inspectInfo-uvyYCjk  reason: not valid java name */
    public static final Map<String, String> m2514inspectInfouvyYCjk(long j) {
        int bits$iv$iv$iv = (int) (j >> 32);
        int bits$iv$iv$iv2 = (int) (4294967295L & j);
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("width", String.valueOf(Float.intBitsToFloat(bits$iv$iv$iv))), TuplesKt.to("height", String.valueOf(Float.intBitsToFloat(bits$iv$iv$iv2)))});
    }

    /* renamed from: inspectInfo-k-4lQ0M  reason: not valid java name */
    public static final Map<String, String> m2513inspectInfok4lQ0M(long j) {
        int bits$iv$iv$iv = (int) (j >> 32);
        int bits$iv$iv$iv2 = (int) (4294967295L & j);
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("x", String.valueOf(Float.intBitsToFloat(bits$iv$iv$iv))), TuplesKt.to("y", String.valueOf(Float.intBitsToFloat(bits$iv$iv$iv2)))});
    }

    public static final Map<String, String> inspectInfo(Rect $this$inspectInfo) {
        Intrinsics.checkNotNullParameter($this$inspectInfo, "<this>");
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("left", String.valueOf($this$inspectInfo.getLeft())), TuplesKt.to("top", String.valueOf($this$inspectInfo.getTop())), TuplesKt.to("right", String.valueOf($this$inspectInfo.getRight())), TuplesKt.to("bottom", String.valueOf($this$inspectInfo.getBottom()))});
    }

    public static final Map<String, String> inspectInfo(SizeSpec $this$inspectInfo) {
        Intrinsics.checkNotNullParameter($this$inspectInfo, "<this>");
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("width", String.valueOf($this$inspectInfo.getWidth())), TuplesKt.to("height", String.valueOf($this$inspectInfo.getHeight()))});
    }

    public static final Map<String, String> inspectInfo(PositionSpec $this$inspectInfo) {
        Intrinsics.checkNotNullParameter($this$inspectInfo, "<this>");
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("x", String.valueOf($this$inspectInfo.getX())), TuplesKt.to("y", String.valueOf($this$inspectInfo.getY())), TuplesKt.to("position", $this$inspectInfo.getPosition().toString())});
    }
}