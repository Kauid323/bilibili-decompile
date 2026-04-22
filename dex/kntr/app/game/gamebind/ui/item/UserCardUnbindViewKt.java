package kntr.app.game.gamebind.ui.item;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import com.bilibili.biligame.kntr.common.util.StringExtKt;
import com.bilibili.compose.theme.BiliColorsSourceKt;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.game.base.ui.font.GameFontWeight_androidKt;
import kntr.app.game.base.ui.util.ColorExtKt;
import kntr.app.game.base.ui.widget.BiligameImageKt;
import kntr.app.game.gamebind.bean.UnbindRoleItem;
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
import org.jetbrains.compose.resources.StringResourcesKt;
import srcs.app.game.game.bind.ui.generated.resources.Res;
import srcs.app.game.game.bind.ui.generated.resources.String0_commonMainKt;

/* compiled from: UserCardUnbindView.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a3\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"UserCardUnbindView", RoomRecommendViewModel.EMPTY_CURSOR, "unbindRoleItem", "Lkntr/app/game/gamebind/bean/UnbindRoleItem;", "onItemClick", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/game/gamebind/bean/UnbindRoleItem;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "game-bind-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class UserCardUnbindViewKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UserCardUnbindView$lambda$2(UnbindRoleItem unbindRoleItem, Function1 function1, Modifier modifier, int i, int i2, Composer composer, int i3) {
        UserCardUnbindView(unbindRoleItem, function1, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void UserCardUnbindView(final UnbindRoleItem unbindRoleItem, final Function1<? super UnbindRoleItem, Unit> function1, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        Function0 factory$iv$iv$iv5;
        Intrinsics.checkNotNullParameter(unbindRoleItem, "unbindRoleItem");
        Intrinsics.checkNotNullParameter(function1, "onItemClick");
        Composer $composer3 = $composer.startRestartGroup(-821721511);
        ComposerKt.sourceInformation($composer3, "C(UserCardUnbindView)N(unbindRoleItem,onItemClick,modifier)57@2190L121,51@1998L5032:UserCardUnbindView.kt#2zw2i8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(unbindRoleItem) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-821721511, $dirty2, -1, "kntr.app.game.gamebind.ui.item.UserCardUnbindView (UserCardUnbindView.kt:50)");
            }
            Modifier clip = ClipKt.clip(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8)));
            ComposerKt.sourceInformationMarkerStart($composer3, 599621330, "CC(remember):UserCardUnbindView.kt#9igjgp");
            boolean invalid$iv = (($dirty2 & 112) == 32) | $composer3.changedInstance(unbindRoleItem);
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.app.game.gamebind.ui.item.UserCardUnbindViewKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit UserCardUnbindView$lambda$0$0;
                        UserCardUnbindView$lambda$0$0 = UserCardUnbindViewKt.UserCardUnbindView$lambda$0$0(function1, unbindRoleItem);
                        return UserCardUnbindView$lambda$0$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv = ClickableKt.clickable-oSLSa3U$default(clip, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            modifier3 = modifier4;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv6;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv6;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i4 = ((0 >> 6) & 112) | 6;
            BoxScope $this$UserCardUnbindView_u24lambda_u241 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -491070226, "C122@4775L2249:UserCardUnbindView.kt#2zw2i8");
            Modifier bgModifier = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(106));
            String backgroundImage = unbindRoleItem.getBackgroundImage();
            if (backgroundImage == null || StringsKt.isBlank(backgroundImage)) {
                $composer3.startReplaceGroup(-491059067);
                ComposerKt.sourceInformation($composer3, RoomRecommendViewModel.EMPTY_CURSOR);
                long bgColor = ColorExtKt.m1088toColor4WTKRHQ$default(unbindRoleItem.getBackgroundColor(), 0L, 1, null);
                $composer2 = $composer3;
                if (Color.equals-impl0(bgColor, Color.Companion.getTransparent-0d7_KjU())) {
                    $composer3.startReplaceGroup(-490974840);
                    ComposerKt.sourceInformation($composer3, "66@2579L347");
                    BoxKt.Box(BackgroundKt.background$default(bgModifier, Brush.Companion.horizontalGradient-8A-3gB4$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(ColorKt.Color(4286212434L)), Color.box-impl(ColorKt.Color(4283384885L))}), 0.0f, 0.0f, 0, 14, (Object) null), (Shape) null, 0.0f, 6, (Object) null), $composer3, 6);
                    $composer3.endReplaceGroup();
                } else {
                    $composer3.startReplaceGroup(-490578877);
                    ComposerKt.sourceInformation($composer3, "77@3013L403,85@3433L331");
                    ComposerKt.sourceInformationMarkerStart($composer3, 122723922, "CC(remember):UserCardUnbindView.kt#9igjgp");
                    boolean invalid$iv2 = $composer3.changed(bgColor);
                    Object it$iv2 = $composer3.rememberedValue();
                    if (!invalid$iv2 && it$iv2 != Composer.Companion.getEmpty()) {
                        Pair pair = (Pair) it$iv2;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        long startColor = ((Color) pair.component1()).unbox-impl();
                        long endColor = ((Color) pair.component2()).unbox-impl();
                        BoxKt.Box(BackgroundKt.background$default(bgModifier, Brush.Companion.horizontalGradient-8A-3gB4$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(startColor), Color.box-impl(endColor)}), 0.0f, 0.0f, 0, 14, (Object) null), (Shape) null, 0.0f, 6, (Object) null), $composer3, 0);
                        $composer3.endReplaceGroup();
                    }
                    float[] hsl = ColorExtKt.m1086argbToHsl8_81llA(bgColor);
                    Object value$iv2 = hsl[2] > 0.2f ? TuplesKt.to(Color.box-impl(Color.Companion.hsl-JlNiLsg$default(Color.Companion, hsl[0], 0.2f, hsl[2], 0.0f, (Rgb) null, 24, (Object) null)), Color.box-impl(Color.Companion.hsl-JlNiLsg$default(Color.Companion, hsl[0], 0.2f, hsl[2] - 0.2f, 0.0f, (Rgb) null, 24, (Object) null))) : TuplesKt.to(Color.box-impl(Color.Companion.hsl-JlNiLsg$default(Color.Companion, hsl[0], 0.2f, hsl[2] + 0.2f, 0.0f, (Rgb) null, 24, (Object) null)), Color.box-impl(Color.Companion.hsl-JlNiLsg$default(Color.Companion, hsl[0], 0.2f, hsl[2], 0.0f, (Rgb) null, 24, (Object) null)));
                    $composer3.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                    Pair pair2 = (Pair) it$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    long startColor2 = ((Color) pair2.component1()).unbox-impl();
                    long endColor2 = ((Color) pair2.component2()).unbox-impl();
                    BoxKt.Box(BackgroundKt.background$default(bgModifier, Brush.Companion.horizontalGradient-8A-3gB4$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(startColor2), Color.box-impl(endColor2)}), 0.0f, 0.0f, 0, 14, (Object) null), (Shape) null, 0.0f, 6, (Object) null), $composer3, 0);
                    $composer3.endReplaceGroup();
                }
                $composer3.endReplaceGroup();
            } else {
                $composer2 = $composer3;
                $composer3.startReplaceGroup(-489746155);
                ComposerKt.sourceInformation($composer3, "96@3808L270,104@4091L251");
                String $this$asRequest$iv = unbindRoleItem.getBackgroundImage();
                Intrinsics.checkNotNull($this$asRequest$iv);
                ImageRequest $this$UserCardUnbindView_u24lambda_u241_u241 = new ImageRequest($this$asRequest$iv);
                ImageRequest.requestAutoCrop$default($this$UserCardUnbindView_u24lambda_u241_u241, false, 1, (Object) null);
                BiliImageKt.BiliImage($this$UserCardUnbindView_u24lambda_u241_u241.build(), bgModifier, "background", (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function2) null, (Function4) null, $composer3, 432, 504);
                BoxKt.Box(BackgroundKt.background$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(bgModifier, 0.0f, 1, (Object) null), Dp.constructor-impl(40)), Brush.Companion.verticalGradient-8A-3gB4$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(ColorKt.Color(1711276032)), Color.box-impl(ColorKt.Color(0))}), 0.0f, 0.0f, 0, 14, (Object) null), (Shape) null, 0.0f, 6, (Object) null), $composer3, 6);
                $composer3.endReplaceGroup();
            }
            String roleImage = unbindRoleItem.getRoleImage();
            boolean hasRoleImage = !(roleImage == null || StringsKt.isBlank(roleImage));
            if (hasRoleImage) {
                $composer3.startReplaceGroup(-489104827);
                ComposerKt.sourceInformation($composer3, "113@4462L294");
                String $this$asRequest_u24default$iv = unbindRoleItem.getRoleImage();
                if ($this$asRequest_u24default$iv == null) {
                    $this$asRequest_u24default$iv = RoomRecommendViewModel.EMPTY_CURSOR;
                }
                ImageRequest imageRequest = new ImageRequest($this$asRequest_u24default$iv);
                Unit unit = Unit.INSTANCE;
                BiliImageKt.BiliImage(imageRequest.build(), $this$UserCardUnbindView_u24lambda_u241.align(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(76)), Alignment.Companion.getBottomEnd()), "roleImage", (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function2) null, (Function4) null, $composer3, 384, 504);
            } else {
                $composer3.startReplaceGroup(-493528093);
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier modifier$iv$iv = Modifier.Companion;
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv2 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv$iv);
            Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv7;
                $composer3.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv7;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i6 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 333649764, "C123@4796L888,146@5697L1317:UserCardUnbindView.kt#2zw2i8");
            Modifier modifier$iv2 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(10), Dp.constructor-impl(6), Dp.constructor-impl(56), 0.0f, 8, (Object) null), 0.0f, 1, (Object) null), Dp.constructor-impl(20));
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((390 >> 3) & 14) | ((390 >> 3) & 112));
            int $changed$iv$iv3 = (390 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv8;
                $composer3.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv8;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i7 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i8 = ((390 >> 6) & 112) | 6;
            RowScope $this$UserCardUnbindView_u24lambda_u241_u242_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -1701372490, "C131@5106L160,140@5503L9,136@5283L387:UserCardUnbindView.kt#2zw2i8");
            BiligameImageKt.m1121BiligameImageo3XDK20(StringExtKt.handleUrl(unbindRoleItem.getIcon()), Dp.constructor-impl(20), Dp.constructor-impl(4), null, null, $composer3, 432, 24);
            TextKt.Text-Nvy7gAk(unbindRoleItem.getGameName(), $this$UserCardUnbindView_u24lambda_u241_u242_u240.weight(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(6), 0.0f, 0.0f, 0.0f, 14, (Object) null), 1.0f, false), BiliColorsSourceKt.getDayColors().getWh0-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, GameFontWeight_androidKt.getGameFontBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT12(), $composer3, 0, 24960, 110520);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv3 = BackgroundKt.background$default(SizeKt.fillMaxWidth$default(SizeKt.height-3ABfNKs(PaddingKt.padding-qDBjuR0(Modifier.Companion, Dp.constructor-impl(10), Dp.constructor-impl(10), hasRoleImage ? Dp.constructor-impl(64) : Dp.constructor-impl(10), Dp.constructor-impl(10)), Dp.constructor-impl(60)), 0.0f, 1, (Object) null), new SolidColor(ColorKt.Color(3221225471L), (DefaultConstructorMarker) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8)), 0.0f, 4, (Object) null);
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getCenter();
            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv4 = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv4 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
            Function0 factory$iv$iv$iv9 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv4 = factory$iv$iv$iv9;
                $composer3.createNode(factory$iv$iv$iv4);
            } else {
                factory$iv$iv$iv4 = factory$iv$iv$iv9;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
            int i9 = ($changed$iv$iv$iv4 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i10 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 322226684, "C160@6338L45,161@6423L9,159@6305L214,165@6644L6,164@6536L464:UserCardUnbindView.kt#2zw2i8");
            TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getBiligame_bind_tips(Res.string.INSTANCE), $composer3, 0), (Modifier) null, Color.copy-wmQWz5c$default(BiliColorsSourceKt.getDayColors().getText2-0d7_KjU(), 0.8f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT14(), $composer3, 0, 0, 131066);
            Modifier modifier$iv4 = BackgroundKt.background-bw27NRU(SizeKt.size-VpY3zN4(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(16), 0.0f, 0.0f, 0.0f, 14, (Object) null), Dp.constructor-impl(72), Dp.constructor-impl(24)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getPi5-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape(50));
            Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv5 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv5 = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv5 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer3, modifier$iv4);
            Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv5 = factory$iv$iv$iv10;
                $composer3.createNode(factory$iv$iv$iv5);
            } else {
                factory$iv$iv$iv5 = factory$iv$iv$iv10;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
            int i11 = ($changed$iv$iv$iv5 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i12 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -724184511, "C169@6815L40,170@6899L9,168@6778L204:UserCardUnbindView.kt#2zw2i8");
            TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getBiligame_bind(Res.string.INSTANCE), $composer3, 0), (Modifier) null, BiliColorsSourceKt.getDayColors().getWh0-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT14(), $composer3, 0, 0, 131066);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.gamebind.ui.item.UserCardUnbindViewKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit UserCardUnbindView$lambda$2;
                    UserCardUnbindView$lambda$2 = UserCardUnbindViewKt.UserCardUnbindView$lambda$2(UnbindRoleItem.this, function1, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return UserCardUnbindView$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UserCardUnbindView$lambda$0$0(Function1 $onItemClick, UnbindRoleItem $unbindRoleItem) {
        $onItemClick.invoke($unbindRoleItem);
        BindActionKt.goBindGame($unbindRoleItem, false);
        return Unit.INSTANCE;
    }
}