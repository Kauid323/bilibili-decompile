package im.base.namerender;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import com.bapis.bilibili.account.service.v1.KColor;
import com.bapis.bilibili.account.service.v1.KColorsInfo;
import com.bapis.bilibili.account.service.v1.KNameRender;
import com.bapis.bilibili.account.service.v1.KRenderSchemeEnum;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeDayNight;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NameRenderPainter.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001a\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006*\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0003\u001a\u0019\u0010\u000b\u001a\u00020\u0007*\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0003¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"rememberNameRenderBrush", "Landroidx/compose/ui/graphics/Brush;", "render", "Lcom/bapis/bilibili/account/service/v1/KNameRender;", "(Lcom/bapis/bilibili/account/service/v1/KNameRender;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Brush;", "toColorList", "", "Landroidx/compose/ui/graphics/Color;", "Lcom/bapis/bilibili/account/service/v1/KColorsInfo;", "theme", "Lcom/bilibili/compose/theme/ThemeDayNight;", "forTheme", "Lcom/bapis/bilibili/account/service/v1/KColor;", "(Lcom/bapis/bilibili/account/service/v1/KColor;Lcom/bilibili/compose/theme/ThemeDayNight;)J", "base-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class NameRenderPainterKt {

    /* compiled from: NameRenderPainter.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ThemeDayNight.values().length];
            try {
                iArr[ThemeDayNight.Day.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ThemeDayNight.Night.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final Brush rememberNameRenderBrush(KNameRender render, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(render, "render");
        $composer.startReplaceGroup(-410618464);
        ComposerKt.sourceInformation($composer, "C(rememberNameRenderBrush)N(render)20@779L7,22@817L91,25@935L107:NameRenderPainter.kt#vm1owk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-410618464, $changed, -1, "im.base.namerender.rememberNameRenderBrush (NameRenderPainter.kt:16)");
        }
        if (Intrinsics.areEqual(render.getRenderScheme(), KRenderSchemeEnum.DEFAULT.INSTANCE)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer.endReplaceGroup();
            return null;
        }
        CompositionLocal this_$iv = BiliThemeKt.getLocalDayNightTheme();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Enum r2 = (ThemeDayNight) consume;
        ComposerKt.sourceInformationMarkerStart($composer, 532654491, "CC(remember):NameRenderPainter.kt#9igjgp");
        boolean invalid$iv = $composer.changed(r2.ordinal()) | $composer.changed(render);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            KColorsInfo colorsInfo = render.getColorsInfo();
            Object value$iv = colorsInfo != null ? toColorList(colorsInfo, r2) : null;
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        List colorConfig = (List) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (colorConfig == null) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer.endReplaceGroup();
            return null;
        }
        ComposerKt.sourceInformationMarkerStart($composer, 532658283, "CC(remember):NameRenderPainter.kt#9igjgp");
        boolean invalid$iv2 = $composer.changed(colorConfig);
        Object it$iv2 = $composer.rememberedValue();
        if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
            Object value$iv2 = Brush.Companion.horizontalGradient-8A-3gB4$default(Brush.Companion, colorConfig, (float) CropImageView.DEFAULT_ASPECT_RATIO, (float) CropImageView.DEFAULT_ASPECT_RATIO, 0, 14, (Object) null);
            $composer.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
        }
        Brush brush = (Brush) it$iv2;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return brush;
    }

    private static final List<Color> toColorList(KColorsInfo $this$toColorList, ThemeDayNight theme) {
        Iterable $this$map$iv = $this$toColorList.getColor();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            KColor it = (KColor) item$iv$iv;
            destination$iv$iv.add(Color.box-impl(forTheme(it, theme)));
        }
        return (List) destination$iv$iv;
    }

    private static final long forTheme(KColor $this$forTheme, ThemeDayNight theme) {
        String colorString;
        switch (WhenMappings.$EnumSwitchMapping$0[theme.ordinal()]) {
            case 1:
                colorString = $this$forTheme.getColorDay();
                break;
            case 2:
                colorString = $this$forTheme.getColorNight();
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return ComposeColorParserKt.parseColor(colorString);
    }
}