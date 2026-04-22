package kntr.app.tribee.consume;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.ImageBitmapKt;
import androidx.compose.ui.graphics.PixelMap;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.bapis.bilibili.app.dynamic.v2.KColor;
import com.bapis.bilibili.app.dynamic.v2.KGlobalPermissionType;
import com.bapis.bilibili.app.dynamic.v2.KLightDarkIcon;
import com.bapis.bilibili.app.dynamic.v2.KTitleTagPic;
import com.bapis.bilibili.app.dynamic.v2.KTribeeCategory;
import com.bapis.bilibili.app.dynamic.v2.KTribeeContent;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeAchievementItem;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.ThemeDayNight;
import com.bilibili.lib.brouter.uri.Uri;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.account.AccountState;
import kntr.base.account.KAccountStoreKt;
import kntr.base.log.ILogger;
import kntr.base.log.KLog_androidKt;
import kntr.base.moss.api.KBusinessException;
import kntr.base.moss.api.KNetworkException;
import kntr.base.router.Router;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.datetime.Clock;

/* compiled from: TribeeExtensions.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0006\u0010\u0007\u001a\u00020\b\u001a\u0014\u0010\t\u001a\u00020\u0001*\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f\u001a\u0014\u0010\t\u001a\u00020\u0001*\u0004\u0018\u00010\r2\u0006\u0010\u000b\u001a\u00020\f\u001a\u0014\u0010\u000e\u001a\u00020\u0001*\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\f\u001a\u001b\u0010\u0010\u001a\u00020\u0011*\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007¢\u0006\u0002\u0010\u0014\u001a\u0014\u0010\u0015\u001a\u00020\u0001*\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0001\u001a\u0014\u0010\u0018\u001a\u00020\u0019*\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u001a\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e\u001a\f\u0010\u001f\u001a\u0004\u0018\u00010 *\u00020\u0001\u001a\n\u0010!\u001a\u00020\u001c*\u00020\"\u001a\u0010\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$*\u00020&\u001a\u000f\u0010'\u001a\u00020%*\u00020(¢\u0006\u0002\u0010)\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0011\u0010*\u001a\u00020+¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-¨\u0006."}, d2 = {"TAG", "", "PAGE_SIZE", "", "SPMID", "PAGE_PV", "TRIBEE_STEAM_HOME_URL", "getCurrentTimeMillis", "", "getUrl", "Lcom/bapis/bilibili/app/dynamic/v2/KLightDarkIcon;", "themeDayNight", "Lcom/bilibili/compose/theme/ThemeDayNight;", "Lcom/bapis/bilibili/app/dynamic/v2/KTitleTagPic;", "getColor", "Lcom/bapis/bilibili/app/dynamic/v2/KColor;", "Placeholder", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/bapis/bilibili/app/dynamic/v2/KTitleTagPic;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "toDisplayString", "", "default", "plus", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeContent;", "next", "checkAndLogin", "", "router", "Lkntr/base/router/Router;", "toUriOrNull", "Lcom/bilibili/lib/brouter/uri/Uri;", "enableJoin", "Lcom/bapis/bilibili/app/dynamic/v2/KGlobalPermissionType;", "getBorderColorList", "", "Landroidx/compose/ui/graphics/Color;", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeAchievementItem;", "getAverageColor", "Landroidx/compose/ui/graphics/ImageBitmap;", "(Landroidx/compose/ui/graphics/ImageBitmap;)J", "DEFAULT_CATEGORY", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeCategory;", "getDEFAULT_CATEGORY", "()Lcom/bapis/bilibili/app/dynamic/v2/KTribeeCategory;", "consume_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeExtensionsKt {
    private static final KTribeeCategory DEFAULT_CATEGORY = new KTribeeCategory(0, "全部", true, 1, (DefaultConstructorMarker) null);
    public static final String PAGE_PV = "tribee.main-page.0.0.pv";
    public static final int PAGE_SIZE = 20;
    public static final String SPMID = "tribee.main-page.0.0";
    public static final String TAG = "Tribee";
    public static final String TRIBEE_STEAM_HOME_URL = "bilibili://tribee/steam/home";

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Placeholder$lambda$3(KTitleTagPic kTitleTagPic, Modifier modifier, int i, int i2, Composer composer, int i3) {
        Placeholder(kTitleTagPic, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final long getCurrentTimeMillis() {
        return Clock.System.INSTANCE.now().toEpochMilliseconds();
    }

    public static final String getUrl(KLightDarkIcon $this$getUrl, ThemeDayNight themeDayNight) {
        Intrinsics.checkNotNullParameter(themeDayNight, "themeDayNight");
        return $this$getUrl == null ? "" : themeDayNight == ThemeDayNight.Night ? $this$getUrl.getDarkMode() : $this$getUrl.getLightMode();
    }

    public static final String getUrl(KTitleTagPic $this$getUrl, ThemeDayNight themeDayNight) {
        Intrinsics.checkNotNullParameter(themeDayNight, "themeDayNight");
        return $this$getUrl == null ? "" : themeDayNight == ThemeDayNight.Night ? $this$getUrl.getDarkUrl() : $this$getUrl.getLightUrl();
    }

    public static final String getColor(KColor $this$getColor, ThemeDayNight themeDayNight) {
        Intrinsics.checkNotNullParameter(themeDayNight, "themeDayNight");
        return $this$getColor == null ? "" : themeDayNight == ThemeDayNight.Night ? $this$getColor.getDark() : $this$getColor.getLight();
    }

    public static final void Placeholder(final KTitleTagPic $this$Placeholder, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$Placeholder, "<this>");
        Composer $composer2 = $composer.startRestartGroup(1035456541);
        ComposerKt.sourceInformation($composer2, "C(Placeholder)N(modifier)65@2528L7,66@2627L7,68@2748L6,61@2414L886:TribeeExtensions.kt#kyvdlt");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance($this$Placeholder) ? 4 : 2;
        }
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if ($composer2.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            Modifier modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1035456541, $dirty, -1, "kntr.app.tribee.consume.Placeholder (TribeeExtensions.kt:60)");
            }
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density $this$Placeholder_u24lambda_u240 = (Density) consume;
            float f = $this$Placeholder_u24lambda_u240.toDp-u2uoSUM((int) $this$Placeholder.getWidth());
            CompositionLocal this_$iv2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(this_$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density $this$Placeholder_u24lambda_u241 = (Density) consume2;
            Modifier modifier$iv = BackgroundKt.background-bw27NRU(SizeKt.size-VpY3zN4(modifier3, f, $this$Placeholder_u24lambda_u241.toDp-u2uoSUM((int) $this$Placeholder.getHeight())), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGraph_bg_regular_float-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(2)));
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier modifier4 = modifier3;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i4 = ((0 >> 6) & 112) | 6;
            BoxScope $this$Placeholder_u24lambda_u242 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -1092975914, "C:TribeeExtensions.kt#kyvdlt");
            if (Intrinsics.areEqual($this$Placeholder.getType(), KTitleTagPic.KTitleTagPicType.TOP.INSTANCE)) {
                $composer2.startReplaceGroup(-1092883628);
                ComposerKt.sourceInformation($composer2, "75@3015L24,76@3078L6,74@2966L267");
                IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_to_top_up_line_500($composer2, 6), (String) null, $this$Placeholder_u24lambda_u242.align(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), Alignment.Companion.getCenter()), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU(), $composer2, Painter.$stable | 48, 0);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(-1092590864);
                $composer2.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.consume.TribeeExtensionsKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit Placeholder$lambda$3;
                    Placeholder$lambda$3 = TribeeExtensionsKt.Placeholder$lambda$3($this$Placeholder, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return Placeholder$lambda$3;
                }
            });
        }
    }

    public static /* synthetic */ String toDisplayString$default(Throwable th, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        return toDisplayString(th, str);
    }

    public static final String toDisplayString(Throwable $this$toDisplayString, String str) {
        String str2;
        Intrinsics.checkNotNullParameter($this$toDisplayString, "<this>");
        Intrinsics.checkNotNullParameter(str, "default");
        if (!($this$toDisplayString instanceof KBusinessException)) {
            if ($this$toDisplayString instanceof KNetworkException) {
                str2 = StringsKt.isBlank(str) ? null : str;
                return str2 == null ? "似乎已断开与互联网的连接" : str2;
            }
            return str;
        }
        String message = $this$toDisplayString.getMessage();
        if (message == null) {
            str2 = StringsKt.isBlank(str) ? null : str;
            return str2 == null ? "似乎已断开与互联网的连接" : str2;
        }
        return message;
    }

    public static final KTribeeContent plus(KTribeeContent $this$plus, KTribeeContent next) {
        List dynList;
        Intrinsics.checkNotNullParameter($this$plus, "<this>");
        if (next == null || (dynList = CollectionsKt.plus($this$plus.getDynList(), next.getDynList())) == null) {
            dynList = $this$plus.getDynList();
        }
        return $this$plus.copy(dynList, next != null ? next.getNextPage() : null);
    }

    public static final boolean checkAndLogin(Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        if (KAccountStoreKt.getAccountHolder().getState().getValue() instanceof AccountState.Logged) {
            return false;
        }
        router.launch(Uri.Companion.parse("bilibili://login"));
        return true;
    }

    public static final Uri toUriOrNull(String $this$toUriOrNull) {
        Intrinsics.checkNotNullParameter($this$toUriOrNull, "<this>");
        return Uri.Companion.parseOrNull($this$toUriOrNull);
    }

    public static final boolean enableJoin(KGlobalPermissionType $this$enableJoin) {
        Intrinsics.checkNotNullParameter($this$enableJoin, "<this>");
        return Intrinsics.areEqual($this$enableJoin, KGlobalPermissionType.WHITELIST.INSTANCE) || Intrinsics.areEqual($this$enableJoin, KGlobalPermissionType.QUALIFIED.INSTANCE) || Intrinsics.areEqual($this$enableJoin, KGlobalPermissionType.QUALIFIED_BUT_BANNED.INSTANCE);
    }

    public static final List<Color> getBorderColorList(KTribeeSteamHomeAchievementItem $this$getBorderColorList) {
        Intrinsics.checkNotNullParameter($this$getBorderColorList, "<this>");
        if (Intrinsics.areEqual($this$getBorderColorList.getType(), KTribeeSteamHomeAchievementItem.KAchievementType.ACHIEVEMENT_HIDDEN.INSTANCE)) {
            return CollectionsKt.listOf(new Color[]{Color.box-impl(ColorKt.Color(4294951506L)), Color.box-impl(ColorKt.Color(4294956942L)), Color.box-impl(ColorKt.Color(4294962377L)), Color.box-impl(ColorKt.Color(4293105936L))});
        }
        return CollectionsKt.listOf(new Color[]{Color.box-impl(ColorKt.Color(4292006610L)), Color.box-impl(ColorKt.Color(4294967295L)), Color.box-impl(ColorKt.Color(4290690750L)), Color.box-impl(ColorKt.Color(4288124823L))});
    }

    public static final long getAverageColor(ImageBitmap $this$getAverageColor) {
        Intrinsics.checkNotNullParameter($this$getAverageColor, "<this>");
        PixelMap pixelMap = ImageBitmapKt.toPixelMap$default($this$getAverageColor, 0, 0, 0, 0, (int[]) null, 0, 0, 127, (Object) null);
        int pixelCount = pixelMap.getWidth() * pixelMap.getHeight();
        float r = 0.0f;
        float g = 0.0f;
        float b = 0.0f;
        int width = pixelMap.getWidth();
        for (int x = 0; x < width; x++) {
            int height = pixelMap.getHeight();
            for (int y = 0; y < height; y++) {
                long color = pixelMap.get-WaAFU9c(x, y);
                r += Color.getRed-impl(color);
                g += Color.getGreen-impl(color);
                b += Color.getBlue-impl(color);
            }
        }
        long color2 = ColorKt.Color$default(r / pixelCount, g / pixelCount, b / pixelCount, 0.0f, (ColorSpace) null, 24, (Object) null);
        ILogger kLog = KLog_androidKt.getKLog();
        String str = Color.toString-impl(color2);
        int width2 = pixelMap.getWidth();
        kLog.i(TAG, "Average color: " + str + ", pixelCount: " + pixelCount + ", width: " + width2 + ", height: " + pixelMap.getHeight());
        return color2;
    }

    public static final KTribeeCategory getDEFAULT_CATEGORY() {
        return DEFAULT_CATEGORY;
    }
}