package kntr.app.game.gamebind.ui.item;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyKt;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontVariation;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import com.bilibili.biligame.kntr.common.util.StringExtKt;
import com.bilibili.compose.theme.BiliColorsSourceKt;
import com.bilibili.compose.theme.BiliTextStyleSourceKt;
import com.bilibili.compose.theme.BiliTheme;
import java.util.List;
import kntr.app.game.base.router.RouterHelperKt;
import kntr.app.game.base.ui.ExposerKt;
import kntr.app.game.base.ui.font.GameFontWeight_androidKt;
import kntr.app.game.base.ui.util.ColorExtKt;
import kntr.app.game.base.ui.widget.BiligameImageKt;
import kntr.app.game.gamebind.bean.RoleInfo;
import kntr.app.game.gamebind.bean.RoleItem;
import kntr.app.game.gamebind.ui.BindActionKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.compose.resources.DrawableResource;
import org.jetbrains.compose.resources.FontResources_androidKt;
import org.jetbrains.compose.resources.ImageResourcesKt;
import srcs.app.game.base.ui.generated.resources.Font0_commonMainKt;
import srcs.app.game.base.ui.generated.resources.Res;
import srcs.app.game.game.bind.ui.generated.resources.Drawable0_commonMainKt;
import srcs.app.game.game.bind.ui.generated.resources.Res;

/* compiled from: RoleItemView.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0081\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\u001c\b\u0002\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000eH\u0007¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"RoleItemView", RoomRecommendViewModel.EMPTY_CURSOR, "role", "Lkntr/app/game/gamebind/bean/RoleItem;", "modifier", "Landroidx/compose/ui/Modifier;", "isMySelf", RoomRecommendViewModel.EMPTY_CURSOR, RouterHelperKt.PARAM_SOURCE_FROM, RoomRecommendViewModel.EMPTY_CURSOR, "onItemClick", "Lkotlin/Function1;", "onMenuClick", "onItemExpose", "Lkotlin/Function2;", "(Lkntr/app/game/gamebind/bean/RoleItem;Landroidx/compose/ui/Modifier;ZLjava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "game-bind-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class RoleItemViewKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RoleItemView$lambda$4(RoleItem roleItem, Modifier modifier, boolean z, String str, Function1 function1, Function1 function12, Function2 function2, int i, int i2, Composer composer, int i3) {
        RoleItemView(roleItem, modifier, z, str, function1, function12, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RoleItemView$lambda$0$0(RoleItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:134:0x0210, code lost:
        if (r5 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x079a, code lost:
        if (r8 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x086f, code lost:
        if (r0 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:296:0x0f99, code lost:
        if (r1.isEmpty() == false) goto L187;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:322:0x1187  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x1192  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x11fa  */
    /* JADX WARN: Removed duplicated region for block: B:358:0x11fc A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v93 */
    /* JADX WARN: Type inference failed for: r4v100 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void RoleItemView(final RoleItem role, Modifier modifier, boolean isMySelf, String sourceFrom, Function1<? super RoleItem, Unit> function1, Function1<? super RoleItem, Unit> function12, Function2<? super RoleItem, ? super Boolean, Unit> function2, Composer $composer, final int $changed, final int i) {
        final String sourceFrom2;
        final Function1 onMenuClick;
        final Function2 onItemExpose;
        int $dirty;
        Composer $composer$iv$iv$iv;
        Modifier modifier2;
        boolean isMySelf2;
        Function1 onItemClick;
        String sourceFrom3;
        final Function1 onItemClick2;
        Function0 factory$iv$iv$iv;
        Composer $composer$iv;
        Composer $composer$iv$iv;
        Composer $composer$iv$iv$iv2;
        Composer $composer$iv2;
        String str;
        String str2;
        boolean hasRoleImage;
        String str3;
        String str4;
        Composer $composer$iv3;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        List it;
        Composer $composer$iv4;
        Composer $composer2;
        Composer $composer$iv$iv$iv3;
        Composer $composer$iv5;
        Composer $composer$iv$iv2;
        Unit unit;
        Function0 factory$iv$iv$iv5;
        boolean z;
        String text;
        Function0 factory$iv$iv$iv6;
        Function0 factory$iv$iv$iv7;
        Intrinsics.checkNotNullParameter(role, "role");
        Composer $composer3 = $composer.startRestartGroup(369130873);
        ComposerKt.sourceInformation($composer3, "C(RoleItemView)N(role,modifier,isMySelf,sourceFrom,onItemClick,onMenuClick,onItemExpose)62@2599L2,72@2907L110,76@3062L99,76@3036L125,66@2715L10209:RoleItemView.kt#2zw2i8");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changedInstance(role) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer3.changed(modifier) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty2 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty2 |= $composer3.changed(isMySelf) ? 256 : 128;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty2 |= 3072;
            sourceFrom2 = sourceFrom;
        } else if (($changed & 3072) == 0) {
            sourceFrom2 = sourceFrom;
            $dirty2 |= $composer3.changed(sourceFrom2) ? 2048 : 1024;
        } else {
            sourceFrom2 = sourceFrom;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty2 |= 24576;
        } else if (($changed & 24576) == 0) {
            $dirty2 |= $composer3.changedInstance(function1) ? 16384 : 8192;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty2 |= 196608;
            onMenuClick = function12;
        } else if (($changed & 196608) == 0) {
            onMenuClick = function12;
            $dirty2 |= $composer3.changedInstance(onMenuClick) ? 131072 : 65536;
        } else {
            onMenuClick = function12;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty2 |= 1572864;
            onItemExpose = function2;
        } else if (($changed & 1572864) == 0) {
            onItemExpose = function2;
            $dirty2 |= $composer3.changedInstance(onItemExpose) ? 1048576 : 524288;
        } else {
            onItemExpose = function2;
        }
        if ($composer3.shouldExecute(($dirty2 & 599187) != 599186, $dirty2 & 1)) {
            Modifier modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier;
            final boolean isMySelf3 = i3 != 0 ? true : isMySelf;
            if (i4 != 0) {
                sourceFrom2 = null;
            }
            if (i5 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, -1747511077, "CC(remember):RoleItemView.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function1() { // from class: kntr.app.game.gamebind.ui.item.RoleItemViewKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            Unit RoleItemView$lambda$0$0;
                            RoleItemView$lambda$0$0 = RoleItemViewKt.RoleItemView$lambda$0$0((RoleItem) obj);
                            return RoleItemView$lambda$0$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function1 onItemClick3 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                onItemClick2 = onItemClick3;
            } else {
                onItemClick2 = function1;
            }
            if (i6 != 0) {
                onMenuClick = null;
            }
            if (i7 != 0) {
                onItemExpose = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(369130873, $dirty2, -1, "kntr.app.game.gamebind.ui.item.RoleItemView (RoleItemView.kt:65)");
            }
            Modifier clip = ClipKt.clip(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8)));
            ComposerKt.sourceInformationMarkerStart($composer3, -1747501113, "CC(remember):RoleItemView.kt#9igjgp");
            boolean invalid$iv = ((57344 & $dirty2) == 16384) | $composer3.changedInstance(role) | (($dirty2 & 7168) == 2048);
            Object it$iv2 = $composer3.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: kntr.app.game.gamebind.ui.item.RoleItemViewKt$$ExternalSyntheticLambda2
                    public final Object invoke() {
                        Unit RoleItemView$lambda$1$0;
                        RoleItemView$lambda$1$0 = RoleItemViewKt.RoleItemView$lambda$1$0(onItemClick2, role, sourceFrom2);
                        return RoleItemView$lambda$1$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier4 = ClickableKt.clickable-oSLSa3U$default(clip, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null);
            String id = role.getId();
            ComposerKt.sourceInformationMarkerStart($composer3, -1747496164, "CC(remember):RoleItemView.kt#9igjgp");
            boolean invalid$iv2 = ((3670016 & $dirty2) == 1048576) | $composer3.changedInstance(role) | (($dirty2 & 896) == 256) | ((458752 & $dirty2) == 131072);
            Object it$iv3 = $composer3.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv3 = new Function0() { // from class: kntr.app.game.gamebind.ui.item.RoleItemViewKt$$ExternalSyntheticLambda3
                public final Object invoke() {
                    Unit RoleItemView$lambda$2$0;
                    RoleItemView$lambda$2$0 = RoleItemViewKt.RoleItemView$lambda$2$0(onItemExpose, role, isMySelf3, onMenuClick);
                    return RoleItemView$lambda$2$0;
                }
            };
            $composer3.updateRememberedValue(value$iv3);
            it$iv3 = value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            isMySelf2 = isMySelf3;
            sourceFrom3 = sourceFrom2;
            onItemClick = onItemClick2;
            Modifier modifier$iv = ExposerKt.reportOnExposure(modifier4, id, null, null, null, (Function0) it$iv3, $composer3, 0, 14);
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            Function2 onItemExpose2 = onItemExpose;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv8;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv8;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            modifier2 = modifier3;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i8 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i9 = ((0 >> 6) & 112) | 6;
            BoxScope $this$RoleItemView_u24lambda_u243 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 679928453, "C180@7106L5812:RoleItemView.kt#2zw2i8");
            Modifier bgModifier = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(106));
            String backgroundImage = role.getBackgroundImage();
            if (backgroundImage == null || StringsKt.isBlank(backgroundImage)) {
                $composer3.startReplaceGroup(679772987);
                ComposerKt.sourceInformation($composer3, RoomRecommendViewModel.EMPTY_CURSOR);
                $composer$iv = $composer3;
                $composer$iv$iv = $composer3;
                $composer$iv$iv$iv2 = $composer3;
                long bgColor = ColorExtKt.m1088toColor4WTKRHQ$default(role.getBackgroundColor(), 0L, 1, null);
                $composer$iv2 = $composer3;
                if (Color.equals-impl0(bgColor, Color.Companion.getTransparent-0d7_KjU())) {
                    $composer3.startReplaceGroup(679847604);
                    ComposerKt.sourceInformation($composer3, "84@3408L347");
                    BoxKt.Box(BackgroundKt.background$default(bgModifier, Brush.Companion.horizontalGradient-8A-3gB4$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(ColorKt.Color(4286212434L)), Color.box-impl(ColorKt.Color(4283384885L))}), 0.0f, 0.0f, 0, 14, (Object) null), (Shape) null, 0.0f, 6, (Object) null), $composer3, 6);
                    $composer3.endReplaceGroup();
                    str = "CC(remember):RoleItemView.kt#9igjgp";
                } else {
                    $composer3.startReplaceGroup(680243567);
                    ComposerKt.sourceInformation($composer3, "95@3842L403,103@4262L331");
                    str = "CC(remember):RoleItemView.kt#9igjgp";
                    ComposerKt.sourceInformationMarkerStart($composer3, -1917717594, str);
                    boolean invalid$iv3 = $composer3.changed(bgColor);
                    Object it$iv4 = $composer3.rememberedValue();
                    if (!invalid$iv3 && it$iv4 != Composer.Companion.getEmpty()) {
                        Pair pair = (Pair) it$iv4;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        long startColor = ((Color) pair.component1()).unbox-impl();
                        long endColor = ((Color) pair.component2()).unbox-impl();
                        BoxKt.Box(BackgroundKt.background$default(bgModifier, Brush.Companion.horizontalGradient-8A-3gB4$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(startColor), Color.box-impl(endColor)}), 0.0f, 0.0f, 0, 14, (Object) null), (Shape) null, 0.0f, 6, (Object) null), $composer3, 0);
                        $composer3.endReplaceGroup();
                    }
                    float[] hsl = ColorExtKt.m1086argbToHsl8_81llA(bgColor);
                    Object value$iv4 = hsl[2] > 0.2f ? TuplesKt.to(Color.box-impl(Color.Companion.hsl-JlNiLsg$default(Color.Companion, hsl[0], 0.2f, hsl[2], 0.0f, (Rgb) null, 24, (Object) null)), Color.box-impl(Color.Companion.hsl-JlNiLsg$default(Color.Companion, hsl[0], 0.2f, hsl[2] - 0.2f, 0.0f, (Rgb) null, 24, (Object) null))) : TuplesKt.to(Color.box-impl(Color.Companion.hsl-JlNiLsg$default(Color.Companion, hsl[0], 0.2f, hsl[2] + 0.2f, 0.0f, (Rgb) null, 24, (Object) null)), Color.box-impl(Color.Companion.hsl-JlNiLsg$default(Color.Companion, hsl[0], 0.2f, hsl[2], 0.0f, (Rgb) null, 24, (Object) null)));
                    $composer3.updateRememberedValue(value$iv4);
                    it$iv4 = value$iv4;
                    Pair pair2 = (Pair) it$iv4;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    long startColor2 = ((Color) pair2.component1()).unbox-impl();
                    long endColor2 = ((Color) pair2.component2()).unbox-impl();
                    BoxKt.Box(BackgroundKt.background$default(bgModifier, Brush.Companion.horizontalGradient-8A-3gB4$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(startColor2), Color.box-impl(endColor2)}), 0.0f, 0.0f, 0, 14, (Object) null), (Shape) null, 0.0f, 6, (Object) null), $composer3, 0);
                    $composer3.endReplaceGroup();
                }
                $composer3.endReplaceGroup();
            } else {
                $composer$iv = $composer3;
                $composer$iv$iv = $composer3;
                $composer$iv$iv$iv2 = $composer3;
                $composer$iv2 = $composer3;
                str = "CC(remember):RoleItemView.kt#9igjgp";
                $composer3.startReplaceGroup(681077994);
                ComposerKt.sourceInformation($composer3, "114@4637L325,124@4975L251");
                String $this$asRequest$iv = StringExtKt.handleUrl(role.getBackgroundImage());
                ImageRequest $this$RoleItemView_u24lambda_u243_u241 = new ImageRequest($this$asRequest$iv);
                ImageRequest.requestAutoCrop$default($this$RoleItemView_u24lambda_u243_u241, false, 1, (Object) null);
                BiliImageKt.BiliImage($this$RoleItemView_u24lambda_u243_u241.build(), bgModifier, "background", (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function2) null, ComposableSingletons$RoleItemViewKt.INSTANCE.m1247getLambda$313045440$game_bind_ui_debug(), $composer3, 100663728, 248);
                BoxKt.Box(BackgroundKt.background$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(bgModifier, 0.0f, 1, (Object) null), Dp.constructor-impl(40)), Brush.Companion.verticalGradient-8A-3gB4$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(ColorKt.Color(1711276032)), Color.box-impl(ColorKt.Color(0))}), 0.0f, 0.0f, 0, 14, (Object) null), (Shape) null, 0.0f, 6, (Object) null), $composer3, 6);
                $composer3.endReplaceGroup();
            }
            String roleImage = role.getRoleImage();
            boolean hasRoleImage2 = !(roleImage == null || StringsKt.isBlank(roleImage));
            if (hasRoleImage2) {
                $composer3.startReplaceGroup(681762009);
                ComposerKt.sourceInformation($composer3, "133@5336L286");
                String $this$asRequest_u24default$iv = StringExtKt.handleUrl(role.getRoleImage());
                ImageRequest imageRequest = new ImageRequest($this$asRequest_u24default$iv);
                Unit unit2 = Unit.INSTANCE;
                BiliImageKt.BiliImage(imageRequest.build(), $this$RoleItemView_u24lambda_u243.align(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(76)), Alignment.Companion.getBottomEnd()), "roleImage", (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function2) null, (Function4) null, $composer3, 384, 504);
            } else {
                $composer3.startReplaceGroup(676471983);
            }
            $composer3.endReplaceGroup();
            if (isMySelf2) {
                $composer3.startReplaceGroup(682127437);
                ComposerKt.sourceInformation($composer3, "143@5669L1418");
                Modifier modifier$iv2 = $this$RoleItemView_u24lambda_u243.align(SizeKt.height-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(8), Dp.constructor-impl(8), 0.0f, 9, (Object) null), Dp.constructor-impl(20)), Alignment.Companion.getTopEnd());
                ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
                int $i$f$Row = ((0 >> 3) & 14) | ((0 >> 3) & 112);
                MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, $i$f$Row);
                int $changed$iv$iv2 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
                $composer$iv3 = $composer$iv2;
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
                Function0 factory$iv$iv$iv9 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                str4 = RoomRecommendViewModel.EMPTY_CURSOR;
                hasRoleImage = hasRoleImage2;
                ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    factory$iv$iv$iv7 = factory$iv$iv$iv9;
                    $composer3.createNode(factory$iv$iv$iv7);
                } else {
                    factory$iv$iv$iv7 = factory$iv$iv$iv9;
                    $composer3.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
                str3 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                str2 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i10 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope = RowScopeInstance.INSTANCE;
                int i11 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -307244102, "C151@5943L293,159@6290L25,158@6253L327:RoleItemView.kt#2zw2i8");
                int visible = role.getVisible();
                ComposerKt.sourceInformationMarkerStart($composer3, 1237015137, str);
                boolean invalid$iv4 = $composer3.changed(visible);
                Object it$iv5 = $composer3.rememberedValue();
                if (invalid$iv4) {
                }
                Object value$iv5 = role.getVisible() == 1 ? Drawable0_commonMainKt.getBiligame_vector_ic_eye_open(Res.drawable.INSTANCE) : Drawable0_commonMainKt.getBiligame_vector_ic_eye_close(Res.drawable.INSTANCE);
                $composer3.updateRememberedValue(value$iv5);
                it$iv5 = value$iv5;
                DrawableResource resource = (DrawableResource) it$iv5;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ImageKt.Image(ImageResourcesKt.painterResource(resource, $composer3, 0), "eye", PaddingKt.padding-3ABfNKs(SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, Dp.constructor-impl(6), 0.0f, 11, (Object) null), Dp.constructor-impl(20)), Dp.constructor-impl(2)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer3, Painter.$stable | 432, 120);
                if (onMenuClick != null) {
                    $composer3.startReplaceGroup(-306537365);
                    ComposerKt.sourceInformation($composer3, "169@6685L53,173@6910L21,168@6644L411");
                    Painter painterResource = ImageResourcesKt.painterResource(Drawable0_commonMainKt.getBiligame_vector_ic_more(Res.drawable.INSTANCE), $composer3, 0);
                    Modifier modifier5 = SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20));
                    ComposerKt.sourceInformationMarkerStart($composer3, 1237045809, str);
                    boolean invalid$iv5 = $composer3.changedInstance(role) | ((458752 & $dirty2) == 131072);
                    $dirty = $dirty2;
                    Object value$iv6 = $composer3.rememberedValue();
                    if (invalid$iv5) {
                    }
                    value$iv6 = new Function0() { // from class: kntr.app.game.gamebind.ui.item.RoleItemViewKt$$ExternalSyntheticLambda4
                        public final Object invoke() {
                            Unit RoleItemView$lambda$3$2$1$0;
                            RoleItemView$lambda$3$2$1$0 = RoleItemViewKt.RoleItemView$lambda$3$2$1$0(onMenuClick, role);
                            return RoleItemView$lambda$3$2$1$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv6);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ImageKt.Image(painterResource, "more", PaddingKt.padding-3ABfNKs(ClickableKt.clickable-oSLSa3U$default(modifier5, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) value$iv6, 15, (Object) null), Dp.constructor-impl(2)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer3, Painter.$stable | 48, 120);
                } else {
                    $dirty = $dirty2;
                    $composer3.startReplaceGroup(-313141946);
                }
                $composer3.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
            } else {
                $dirty = $dirty2;
                str2 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                hasRoleImage = hasRoleImage2;
                str3 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                str4 = RoomRecommendViewModel.EMPTY_CURSOR;
                $composer$iv3 = $composer$iv2;
                $composer3.startReplaceGroup(676471983);
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier modifier$iv3 = Modifier.Companion;
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv3 = (0 << 3) & 112;
            String str5 = str2;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, str5);
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
            Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            Composer $composer$iv$iv$iv4 = $composer3;
            String str6 = str3;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv4, -553112988, str6);
            if (!($composer$iv$iv$iv4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv$iv$iv4.startReusableNode();
            if ($composer$iv$iv$iv4.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv10;
                $composer$iv$iv$iv4.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv10;
                $composer$iv$iv$iv4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer$iv$iv$iv4);
            Function1 onMenuClick2 = onMenuClick;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i12 = ($changed$iv$iv$iv3 >> 6) & 14;
            Composer $composer$iv6 = $composer$iv$iv$iv4;
            ComposerKt.sourceInformationMarkerStart($composer$iv6, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i13 = ((0 >> 6) & 112) | 6;
            Composer $composer4 = $composer$iv6;
            ComposerKt.sourceInformationMarkerStart($composer4, 1804527921, "C181@7127L2786,249@9927L2981:RoleItemView.kt#2zw2i8");
            Modifier modifier$iv4 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(10), Dp.constructor-impl(8), isMySelf2 ? Dp.constructor-impl(56) : Dp.constructor-impl(10), 0.0f, 8, (Object) null), 0.0f, 1, (Object) null), Dp.constructor-impl(20));
            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer4, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv4 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, str5);
            int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv4 = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer4, modifier$iv4);
            Function0 factory$iv$iv$iv11 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
            $composer$iv$iv$iv = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, str6);
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv11;
                $composer4.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv11;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
            int i14 = ($changed$iv$iv$iv4 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i15 = ((384 >> 6) & 112) | 6;
            RowScope $this$RoleItemView_u24lambda_u243_u243_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer4, -83673051, "C191@7598L154,200@7979L9,196@7769L377:RoleItemView.kt#2zw2i8");
            String roleName = role.getRoleName();
            boolean hasRoleName = !(roleName == null || StringsKt.isBlank(roleName));
            String sectionName = role.getSectionName();
            boolean hasServerTitle = !(sectionName == null || StringsKt.isBlank(sectionName));
            BiligameImageKt.m1121BiligameImageo3XDK20(StringExtKt.handleUrl(role.getGameIcon()), Dp.constructor-impl(20), Dp.constructor-impl(4), null, null, $composer4, 432, 24);
            TextKt.Text-Nvy7gAk(role.getGameName(), $this$RoleItemView_u24lambda_u243_u243_u240.weight(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(6), 0.0f, 0.0f, 0.0f, 14, (Object) null), 1.0f, false), BiliColorsSourceKt.getDayColors().getWh0-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, GameFontWeight_androidKt.getGameFontBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT12(), $composer4, 0, 24960, 110520);
            if (hasRoleName || hasServerTitle) {
                $composer4.startReplaceGroup(-83006614);
                ComposerKt.sourceInformation($composer4, "207@8221L311");
                BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(6), 0.0f, 0.0f, 0.0f, 14, (Object) null), Dp.constructor-impl((float) 0.5d)), Dp.constructor-impl(10)), ColorKt.Color(872415231), (Shape) null, 2, (Object) null), $composer4, 6);
                $composer4.endReplaceGroup();
            } else {
                $composer4.startReplaceGroup(-91151895);
                $composer4.endReplaceGroup();
            }
            if (hasRoleName) {
                $composer4.startReplaceGroup(-82599615);
                ComposerKt.sourceInformation($composer4, "224@8930L9,217@8606L456");
                String roleName2 = role.getRoleName();
                TextKt.Text-Nvy7gAk(roleName2 == null ? str4 : roleName2, AlphaKt.alpha(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(6), 0.0f, 0.0f, 0.0f, 14, (Object) null), 0.8f), BiliColorsSourceKt.getDayColors().getWh0-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT12(), $composer4, 48, 24960, 110584);
            } else {
                $composer4.startReplaceGroup(-91151895);
            }
            $composer4.endReplaceGroup();
            if (hasServerTitle) {
                $composer4.startReplaceGroup(-82061052);
                ComposerKt.sourceInformation($composer4, "242@9749L9,231@9140L741");
                String sectionName2 = role.getSectionName();
                TextKt.Text-Nvy7gAk(sectionName2 == null ? str4 : sectionName2, SizeKt.widthIn-VpY3zN4$default(PaddingKt.padding-VpY3zN4(BackgroundKt.background$default(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(4), 0.0f, 0.0f, 0.0f, 14, (Object) null), new SolidColor(ColorKt.Color(452984831), (DefaultConstructorMarker) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(20)), 0.0f, 4, (Object) null), Dp.constructor-impl(6), Dp.constructor-impl(2)), Dp.constructor-impl(20), 0.0f, 2, (Object) null), ColorKt.Color(3439329279L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT10(), $composer4, 384, 24960, 110584);
            } else {
                $composer4.startReplaceGroup(-91151895);
            }
            $composer4.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Modifier modifier$iv5 = BackgroundKt.background$default(SizeKt.fillMaxWidth$default(SizeKt.height-3ABfNKs(PaddingKt.padding-qDBjuR0(Modifier.Companion, Dp.constructor-impl(10), Dp.constructor-impl(8), hasRoleImage ? Dp.constructor-impl(64) : Dp.constructor-impl(10), Dp.constructor-impl(10)), Dp.constructor-impl(60)), 0.0f, 1, (Object) null), new SolidColor(ColorKt.Color(3221225471L), (DefaultConstructorMarker) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8)), 0.0f, 4, (Object) null);
            Alignment.Vertical verticalAlignment$iv3 = Alignment.Companion.getCenterVertically();
            Composer $composer$iv7 = $composer4;
            ComposerKt.sourceInformationMarkerStart($composer$iv7, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv5 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3, verticalAlignment$iv3, $composer$iv7, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv5 = (384 << 3) & 112;
            Composer $composer$iv$iv3 = $composer$iv7;
            MeasurePolicy measurePolicy$iv$iv = measurePolicy$iv5;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv3, -1159599143, str5);
            int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv$iv3, 0));
            CompositionLocalMap localMap$iv$iv5 = $composer$iv$iv3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer$iv$iv3, modifier$iv5);
            Function0 factory$iv$iv$iv12 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv3, -553112988, str6);
            if (!($composer$iv$iv3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv$iv3.startReusableNode();
            if ($composer$iv$iv3.getInserting()) {
                factory$iv$iv$iv4 = factory$iv$iv$iv12;
                $composer$iv$iv3.createNode(factory$iv$iv$iv4);
            } else {
                factory$iv$iv$iv4 = factory$iv$iv$iv12;
                $composer$iv$iv3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer$iv$iv3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
            int i16 = ($changed$iv$iv$iv5 >> 6) & 14;
            boolean z2 = false;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i17 = ((384 >> 6) & 112) | 6;
            RowScope $this$RoleItemView_u24lambda_u243_u243_u241 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv3, -1247354675, "C:RoleItemView.kt#2zw2i8");
            List<RoleInfo> roleInfos = role.getRoleInfos();
            if (roleInfos != null) {
                it = CollectionsKt.take(roleInfos, hasRoleImage ? 4 : 5);
                if (it != null) {
                }
            }
            it = null;
            if (it == null) {
                $composer$iv$iv3.startReplaceGroup(-1247308022);
                $composer$iv$iv3.endReplaceGroup();
                $composer$iv4 = $composer$iv7;
                $composer2 = $composer4;
                $composer$iv$iv$iv3 = $composer$iv$iv$iv4;
                $composer$iv5 = $composer$iv6;
                $composer$iv$iv2 = $composer$iv$iv3;
                unit = null;
            } else {
                $composer$iv$iv3.startReplaceGroup(-1247308021);
                ComposerKt.sourceInformation($composer$iv$iv3, "*262@10583L1349");
                List $this$forEach$iv = it;
                boolean z3 = false;
                for (Object element$iv : $this$forEach$iv) {
                    RoleInfo it2 = (RoleInfo) element$iv;
                    Iterable $this$forEach$iv2 = $this$forEach$iv;
                    boolean z4 = z3;
                    int $changed$iv$iv$iv6 = $changed$iv$iv$iv5;
                    MeasurePolicy measurePolicy$iv$iv2 = measurePolicy$iv$iv;
                    boolean z5 = z2;
                    Modifier modifier$iv6 = SizeKt.height-3ABfNKs(PaddingKt.padding-VpY3zN4$default(RowScope.-CC.weight$default($this$RoleItemView_u24lambda_u243_u243_u241, Modifier.Companion, 1.0f, false, 2, (Object) null), Dp.constructor-impl(4), 0.0f, 2, (Object) null), Dp.constructor-impl(32));
                    Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getCenterHorizontally();
                    ComposerKt.sourceInformationMarkerStart($composer$iv$iv3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
                    MeasurePolicy measurePolicy$iv6 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer$iv$iv3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                    int $changed$iv$iv6 = (384 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer$iv$iv3, -1159599143, str5);
                    int compositeKeyHash$iv$iv6 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv$iv3, 0));
                    CompositionLocalMap localMap$iv$iv6 = $composer$iv$iv3.getCurrentCompositionLocalMap();
                    Composer $composer$iv$iv$iv5 = $composer$iv$iv$iv4;
                    Modifier materialized$iv$iv6 = ComposedModifierKt.materializeModifier($composer$iv$iv3, modifier$iv6);
                    Function0 factory$iv$iv$iv13 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv7 = (($changed$iv$iv6 << 6) & 896) | 6;
                    Composer $composer$iv8 = $composer$iv6;
                    Composer $composer$iv$iv$iv6 = $composer4;
                    ComposerKt.sourceInformationMarkerStart($composer$iv$iv3, -553112988, str6);
                    if (!($composer$iv$iv3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer$iv$iv3.startReusableNode();
                    if ($composer$iv$iv3.getInserting()) {
                        factory$iv$iv$iv5 = factory$iv$iv$iv13;
                        $composer$iv$iv3.createNode(factory$iv$iv$iv5);
                    } else {
                        factory$iv$iv$iv5 = factory$iv$iv$iv13;
                        $composer$iv$iv3.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv6 = Updater.constructor-impl($composer$iv$iv3);
                    Composer $composer$iv9 = $composer$iv7;
                    Composer $composer$iv$iv4 = $composer$iv$iv3;
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, measurePolicy$iv6, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, localMap$iv$iv6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv6, Integer.valueOf(compositeKeyHash$iv$iv6), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv6, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, materialized$iv$iv6, ComposeUiNode.Companion.getSetModifier());
                    int i18 = ($changed$iv$iv$iv7 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer$iv$iv3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    int i19 = ((384 >> 6) & 112) | 6;
                    ColumnScope $this$RoleItemView_u24lambda_u243_u243_u241_u241_u240 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer$iv$iv3, -410275661, "C273@11102L68,270@10939L532,279@11496L38,280@11559L351:RoleItemView.kt#2zw2i8");
                    String value = it2.getValue();
                    if (value == null) {
                        value = "--";
                    }
                    long j2 = BiliColorsSourceKt.getDayColors().getGa10-0d7_KjU();
                    FontFamily FontFamily = FontFamilyKt.FontFamily(new Font[]{FontResources_androidKt.Font-r4zq5rk(Font0_commonMainKt.getXx_bin_bold(Res.font.INSTANCE), (FontWeight) null, 0, (FontVariation.Settings) null, $composer$iv$iv3, 0, 14)});
                    TextStyle t12b = BiliTextStyleSourceKt.getTextStyles().getT12b();
                    int i20 = TextOverflow.Companion.getEllipsis-gIe3tQ8();
                    Modifier modifier6 = Modifier.Companion;
                    String value2 = it2.getValue();
                    if (value2 != null && StringExtKt.isDigitOnly(value2)) {
                        z = true;
                        TextKt.Text-Nvy7gAk(value, PaddingKt.padding-qDBjuR0$default(modifier6, 0.0f, !z ? Dp.constructor-impl(3) : Dp.constructor-impl(0), 0.0f, 0.0f, 13, (Object) null), j2, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, FontFamily, 0L, (TextDecoration) null, (TextAlign) null, 0L, i20, false, 1, 0, (Function1) null, t12b, $composer$iv$iv3, 0, 24960, 110456);
                        SpacerKt.Spacer(ColumnScope.-CC.weight$default($this$RoleItemView_u24lambda_u243_u243_u241_u241_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer$iv$iv3, 0);
                        text = it2.getText();
                        if (text != null) {
                            text = "--";
                        }
                        TextKt.Text-Nvy7gAk(text, AlphaKt.alpha(Modifier.Companion, 0.4f), BiliColorsSourceKt.getDayColors().getBa0-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTextStyleSourceKt.getTextStyles().getT10(), $composer$iv$iv3, 48, 24960, 110584);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv$iv3);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv$iv3);
                        $composer$iv$iv3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer$iv$iv3);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv$iv3);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv$iv3);
                        $this$forEach$iv = $this$forEach$iv2;
                        measurePolicy$iv$iv = measurePolicy$iv$iv2;
                        z2 = z5;
                        z3 = z4;
                        $changed$iv$iv$iv5 = $changed$iv$iv$iv6;
                        $composer$iv$iv$iv4 = $composer$iv$iv$iv5;
                        $composer4 = $composer$iv$iv$iv6;
                        $composer$iv6 = $composer$iv8;
                        $composer$iv$iv3 = $composer$iv$iv4;
                        $composer$iv7 = $composer$iv9;
                    }
                    z = false;
                    TextKt.Text-Nvy7gAk(value, PaddingKt.padding-qDBjuR0$default(modifier6, 0.0f, !z ? Dp.constructor-impl(3) : Dp.constructor-impl(0), 0.0f, 0.0f, 13, (Object) null), j2, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, FontFamily, 0L, (TextDecoration) null, (TextAlign) null, 0L, i20, false, 1, 0, (Function1) null, t12b, $composer$iv$iv3, 0, 24960, 110456);
                    SpacerKt.Spacer(ColumnScope.-CC.weight$default($this$RoleItemView_u24lambda_u243_u243_u241_u241_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer$iv$iv3, 0);
                    text = it2.getText();
                    if (text != null) {
                    }
                    TextKt.Text-Nvy7gAk(text, AlphaKt.alpha(Modifier.Companion, 0.4f), BiliColorsSourceKt.getDayColors().getBa0-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTextStyleSourceKt.getTextStyles().getT10(), $composer$iv$iv3, 48, 24960, 110584);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv3);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv3);
                    $composer$iv$iv3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv3);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv3);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv3);
                    $this$forEach$iv = $this$forEach$iv2;
                    measurePolicy$iv$iv = measurePolicy$iv$iv2;
                    z2 = z5;
                    z3 = z4;
                    $changed$iv$iv$iv5 = $changed$iv$iv$iv6;
                    $composer$iv$iv$iv4 = $composer$iv$iv$iv5;
                    $composer4 = $composer$iv$iv$iv6;
                    $composer$iv6 = $composer$iv8;
                    $composer$iv$iv3 = $composer$iv$iv4;
                    $composer$iv7 = $composer$iv9;
                }
                $composer$iv4 = $composer$iv7;
                $composer2 = $composer4;
                $composer$iv$iv$iv3 = $composer$iv$iv$iv4;
                $composer$iv5 = $composer$iv6;
                $composer$iv$iv2 = $composer$iv$iv3;
                $composer$iv$iv3.endReplaceGroup();
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                $composer$iv$iv3.startReplaceGroup(-1245932396);
                ComposerKt.sourceInformation($composer$iv$iv3, str4);
                RowScope it3 = $this$RoleItemView_u24lambda_u243_u243_u241;
                boolean z6 = false;
                $composer$iv$iv3.startReplaceGroup(1760924738);
                ComposerKt.sourceInformation($composer$iv$iv3, "*291@12022L832");
                int i21 = 0;
                while (i21 < 3) {
                    RowScope $this$RoleItemView_u24lambda_u243_u243_u2412 = $this$RoleItemView_u24lambda_u243_u243_u241;
                    Modifier modifier$iv7 = $this$RoleItemView_u24lambda_u243_u243_u241.align(RowScope.-CC.weight$default($this$RoleItemView_u24lambda_u243_u243_u2412, Modifier.Companion, 1.0f, false, 2, (Object) null), Alignment.Companion.getCenterVertically());
                    Alignment.Horizontal horizontalAlignment$iv3 = Alignment.Companion.getCenterHorizontally();
                    ComposerKt.sourceInformationMarkerStart($composer$iv$iv3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    Arrangement.Vertical verticalArrangement$iv3 = Arrangement.INSTANCE.getTop();
                    MeasurePolicy measurePolicy$iv7 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv3, horizontalAlignment$iv3, $composer$iv$iv3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                    int $changed$iv$iv7 = (384 << 3) & 112;
                    RowScope it4 = it3;
                    ComposerKt.sourceInformationMarkerStart($composer$iv$iv3, -1159599143, str5);
                    int compositeKeyHash$iv$iv7 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv$iv3, 0));
                    CompositionLocalMap localMap$iv$iv7 = $composer$iv$iv3.getCurrentCompositionLocalMap();
                    String str7 = str5;
                    boolean z7 = z6;
                    Modifier materialized$iv$iv7 = ComposedModifierKt.materializeModifier($composer$iv$iv3, modifier$iv7);
                    Function0 factory$iv$iv$iv14 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv8 = (($changed$iv$iv7 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer$iv$iv3, -553112988, str6);
                    if (!($composer$iv$iv3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer$iv$iv3.startReusableNode();
                    if ($composer$iv$iv3.getInserting()) {
                        factory$iv$iv$iv6 = factory$iv$iv$iv14;
                        $composer$iv$iv3.createNode(factory$iv$iv$iv6);
                    } else {
                        factory$iv$iv$iv6 = factory$iv$iv$iv14;
                        $composer$iv$iv3.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv7 = Updater.constructor-impl($composer$iv$iv3);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv7, measurePolicy$iv7, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv7, localMap$iv$iv7, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv7, Integer.valueOf(compositeKeyHash$iv$iv7), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv7, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv7, materialized$iv$iv7, ComposeUiNode.Companion.getSetModifier());
                    int i22 = ($changed$iv$iv$iv8 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer$iv$iv3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
                    int i23 = ((384 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer$iv$iv3, -1811039075, "C298@12366L462:RoleItemView.kt#2zw2i8");
                    TextKt.Text-Nvy7gAk("--", PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(4), Dp.constructor-impl(4), Dp.constructor-impl(4), 0.0f, 8, (Object) null), BiliColorsSourceKt.getDayColors().getGa10-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, GameFontWeight_androidKt.getGameFontBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTextStyleSourceKt.getTextStyles().getT12(), $composer$iv$iv3, 54, 24960, 110520);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv3);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv3);
                    $composer$iv$iv3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv3);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv3);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv3);
                    i21++;
                    it3 = it4;
                    z6 = z7;
                    $this$RoleItemView_u24lambda_u243_u243_u241 = $this$RoleItemView_u24lambda_u243_u243_u2412;
                    str5 = str7;
                    str6 = str6;
                }
                $composer$iv$iv3.endReplaceGroup();
                Unit unit3 = Unit.INSTANCE;
                $composer$iv$iv3.endReplaceGroup();
            } else {
                $composer$iv$iv3.startReplaceGroup(1760878070);
                $composer$iv$iv3.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv3);
            $composer$iv$iv3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv4);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv5);
            $composer$iv$iv$iv3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            $composer$iv$iv$iv2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            onItemExpose = onItemExpose2;
            onMenuClick = onMenuClick2;
        } else {
            $dirty = $dirty2;
            $composer$iv$iv$iv = $composer3;
            $composer$iv$iv$iv.skipToGroupEnd();
            modifier2 = modifier;
            isMySelf2 = isMySelf;
            onItemClick = function1;
            sourceFrom3 = sourceFrom2;
        }
        ScopeUpdateScope endRestartGroup = $composer$iv$iv$iv.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier7 = modifier2;
            final boolean z8 = isMySelf2;
            final String str8 = sourceFrom3;
            final Function1 function13 = onItemClick;
            final Function1 function14 = onMenuClick;
            final Function2 function22 = onItemExpose;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.gamebind.ui.item.RoleItemViewKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit RoleItemView$lambda$4;
                    RoleItemView$lambda$4 = RoleItemViewKt.RoleItemView$lambda$4(RoleItem.this, modifier7, z8, str8, function13, function14, function22, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return RoleItemView$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RoleItemView$lambda$1$0(Function1 $onItemClick, RoleItem $role, String $sourceFrom) {
        $onItemClick.invoke($role);
        BindActionKt.openRoleDetail($role, $sourceFrom);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RoleItemView$lambda$2$0(Function2 $onItemExpose, RoleItem $role, boolean $isMySelf, Function1 $onMenuClick) {
        if ($onItemExpose != null) {
            $onItemExpose.invoke($role, Boolean.valueOf($isMySelf && $onMenuClick != null));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RoleItemView$lambda$3$2$1$0(Function1 $onMenuClick, RoleItem $role) {
        $onMenuClick.invoke($role);
        return Unit.INSTANCE;
    }
}