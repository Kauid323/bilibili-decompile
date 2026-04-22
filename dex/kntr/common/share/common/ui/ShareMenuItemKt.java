package kntr.common.share.common.ui;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
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
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kntr.common.share.common.ui.ShareChannelList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ShareMenuItem.kt */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a?\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\tH\u0007¢\u0006\u0002\u0010\n\u001a;\u0010\u000b\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010\u0011\u001a5\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007¢\u0006\u0004\b\u0018\u0010\u0019\u001aA\u0010\u001a\u001a\u00020\u00012\b\u0010\u001b\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"ShareMenuItem", "", "item", "Lkntr/common/share/common/ui/ShareChannelList$Item;", "modifier", "Landroidx/compose/ui/Modifier;", "slot", "Lkntr/common/share/common/ui/ShareMenuItemSlot;", "onClick", "Lkotlin/Function1;", "(Lkntr/common/share/common/ui/ShareChannelList$Item;Landroidx/compose/ui/Modifier;Lkntr/common/share/common/ui/ShareMenuItemSlot;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "ShareMenuIcon", "icon", "Landroidx/compose/ui/graphics/ImageBitmap;", "iconUrl", "", "contentDescription", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/ImageBitmap;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "ShareMenuItemName", "text", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontColor", "Landroidx/compose/ui/graphics/Color;", "ShareMenuItemName-YEplvsA", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "ShareMenuItemCorner", "cornerText", "radius", "Landroidx/compose/ui/unit/Dp;", "ShareMenuItemCorner-QZjSdIA", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;FJJLandroidx/compose/runtime/Composer;II)V", "common-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ShareMenuItemKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShareMenuIcon$lambda$1(Modifier modifier, ImageBitmap imageBitmap, String str, String str2, int i, int i2, Composer composer, int i3) {
        ShareMenuIcon(modifier, imageBitmap, str, str2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShareMenuItem$lambda$4(ShareChannelList.Item item, Modifier modifier, ShareMenuItemSlot shareMenuItemSlot, Function1 function1, int i, int i2, Composer composer, int i3) {
        ShareMenuItem(item, modifier, shareMenuItemSlot, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShareMenuItemCorner_QZjSdIA$lambda$1(String str, Modifier modifier, float f, long j, long j2, int i, int i2, Composer composer, int i3) {
        m2367ShareMenuItemCornerQZjSdIA(str, modifier, f, j, j2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShareMenuItemName_YEplvsA$lambda$0(String str, Modifier modifier, long j, long j2, int i, int i2, Composer composer, int i3) {
        m2368ShareMenuItemNameYEplvsA(str, modifier, j, j2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShareMenuItem$lambda$0$0(ShareChannelList.Item it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v1 */
    public static final void ShareMenuItem(final ShareChannelList.Item item, Modifier modifier, ShareMenuItemSlot slot, Function1<? super ShareChannelList.Item, Unit> function1, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        ShareMenuItemSlot shareMenuItemSlot;
        final Function1 onClick;
        Composer $composer2;
        Modifier modifier3;
        ShareMenuItemSlot slot2;
        Modifier modifier4;
        ShareMenuItemSlot slot3;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        int i2;
        Intrinsics.checkNotNullParameter(item, "item");
        Composer $composer3 = $composer.startRestartGroup(-1616854564);
        ComposerKt.sourceInformation($composer3, "C(ShareMenuItem)N(item,modifier,slot,onClick)60@2292L39,61@2351L17,55@2140L652:ShareMenuItem.kt#y4rqem");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(item) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                shareMenuItemSlot = slot;
                if ($composer3.changed(shareMenuItemSlot)) {
                    i2 = 256;
                    $dirty |= i2;
                }
            } else {
                shareMenuItemSlot = slot;
            }
            i2 = 128;
            $dirty |= i2;
        } else {
            shareMenuItemSlot = slot;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            onClick = function1;
        } else if (($changed & 3072) == 0) {
            onClick = function1;
            $dirty |= $composer3.changedInstance(onClick) ? 2048 : 1024;
        } else {
            onClick = function1;
        }
        if ($composer3.shouldExecute(($dirty & 1171) != 1170, $dirty & 1)) {
            $composer3.startDefaults();
            ComposerKt.sourceInformation($composer3, "53@2128L2");
            if (($changed & 1) != 0 && !$composer3.getDefaultsInvalid()) {
                $composer3.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                modifier4 = modifier2;
                slot3 = shareMenuItemSlot;
            } else {
                if (i3 != 0) {
                    modifier4 = (Modifier) Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if ((i & 4) == 0) {
                    slot3 = shareMenuItemSlot;
                } else {
                    slot3 = new ShareMenuItemSlot(null, null, null, 7, null);
                    $dirty &= -897;
                }
                if (i4 != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer3, 980931070, "CC(remember):ShareMenuItem.kt#9igjgp");
                    Object it$iv = $composer3.rememberedValue();
                    if (it$iv == Composer.Companion.getEmpty()) {
                        Object value$iv = new Function1() { // from class: kntr.common.share.common.ui.ShareMenuItemKt$$ExternalSyntheticLambda3
                            public final Object invoke(Object obj) {
                                Unit ShareMenuItem$lambda$0$0;
                                ShareMenuItem$lambda$0$0 = ShareMenuItemKt.ShareMenuItem$lambda$0$0((ShareChannelList.Item) obj);
                                return ShareMenuItem$lambda$0$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv);
                        it$iv = value$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    onClick = it$iv;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1616854564, $dirty, -1, "kntr.common.share.common.ui.ShareMenuItem (ShareMenuItem.kt:54)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, 980936355, "CC(remember):ShareMenuItem.kt#9igjgp");
            Object it$iv2 = $composer3.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = InteractionSourceKt.MutableInteractionSource();
                $composer3.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, 980938221, "CC(remember):ShareMenuItem.kt#9igjgp");
            boolean invalid$iv = $composer3.changedInstance(item) | (($dirty & 7168) == 2048);
            Object it$iv3 = $composer3.rememberedValue();
            if (invalid$iv || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function0() { // from class: kntr.common.share.common.ui.ShareMenuItemKt$$ExternalSyntheticLambda4
                    public final Object invoke() {
                        Unit ShareMenuItem$lambda$2$0;
                        ShareMenuItem$lambda$2$0 = ShareMenuItemKt.ShareMenuItem$lambda$2$0(onClick, item);
                        return ShareMenuItem$lambda$2$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv = ClickableKt.clickable-O2vRcR0$default(modifier4, mutableInteractionSource, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv3, 28, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            modifier3 = modifier4;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            Function1 onClick2 = onClick;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i6 = ((0 >> 6) & 112) | 6;
            BoxScope $this$ShareMenuItem_u24lambda_u243 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 951639261, "C63@2386L267,72@2662L124:ShareMenuItem.kt#y4rqem");
            Modifier modifier$iv2 = $this$ShareMenuItem_u24lambda_u243.align(Modifier.Companion, Alignment.Companion.getCenter());
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv2 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            $composer2 = $composer3;
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer3.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i7 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i8 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1563240704, "C69@2581L29,70@2628L15:ShareMenuItem.kt#y4rqem");
            slot3.getIcon().invoke(item.getIcon(), item.getIconUrl(), $composer3, 0);
            slot3.getName().invoke(item.getName(), $composer3, 0);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv3 = $this$ShareMenuItem_u24lambda_u243.align(Modifier.Companion, Alignment.Companion.getTopEnd());
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv3 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $i$f$Box = $changed$iv$iv3 << 6;
            int $changed$iv$iv$iv3 = ($i$f$Box & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv6;
                $composer3.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv6;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i9 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i10 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1073362473, "C75@2753L23:ShareMenuItem.kt#y4rqem");
            slot2 = slot3;
            slot3.getCorner().invoke(item.getCornerText(), $composer3, 0);
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
            onClick = onClick2;
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            slot2 = shareMenuItemSlot;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final ShareMenuItemSlot shareMenuItemSlot2 = slot2;
            final Function1 function12 = onClick;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.share.common.ui.ShareMenuItemKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit ShareMenuItem$lambda$4;
                    ShareMenuItem$lambda$4 = ShareMenuItemKt.ShareMenuItem$lambda$4(ShareChannelList.Item.this, modifier5, shareMenuItemSlot2, function12, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ShareMenuItem$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShareMenuItem$lambda$2$0(Function1 $onClick, ShareChannelList.Item $item) {
        $onClick.invoke($item);
        return Unit.INSTANCE;
    }

    public static final void ShareMenuIcon(Modifier modifier, ImageBitmap icon, String iconUrl, String contentDescription, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        ImageBitmap imageBitmap;
        String iconUrl2;
        String contentDescription2;
        Modifier modifier3;
        ImageBitmap icon2;
        Modifier modifier4;
        ImageBitmap icon3;
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(950740675);
        ComposerKt.sourceInformation($composer2, "C(ShareMenuIcon)N(modifier,icon,iconUrl,contentDescription)87@2970L575:ShareMenuItem.kt#y4rqem");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            imageBitmap = icon;
        } else if (($changed & 48) == 0) {
            imageBitmap = icon;
            $dirty |= $composer2.changedInstance(imageBitmap) ? 32 : 16;
        } else {
            imageBitmap = icon;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
            iconUrl2 = iconUrl;
        } else if (($changed & 384) == 0) {
            iconUrl2 = iconUrl;
            $dirty |= $composer2.changed(iconUrl2) ? 256 : 128;
        } else {
            iconUrl2 = iconUrl;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
            contentDescription2 = contentDescription;
        } else if (($changed & 3072) == 0) {
            contentDescription2 = contentDescription;
            $dirty |= $composer2.changed(contentDescription2) ? 2048 : 1024;
        } else {
            contentDescription2 = contentDescription;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            icon2 = imageBitmap;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 == 0) {
                icon3 = imageBitmap;
            } else {
                icon3 = null;
            }
            if (i4 != 0) {
                iconUrl2 = null;
            }
            if (i5 != 0) {
                contentDescription2 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(950740675, $dirty2, -1, "kntr.common.share.common.ui.ShareMenuIcon (ShareMenuItem.kt:86)");
            }
            Modifier modifier$iv = ClipKt.clip(SizeKt.size-3ABfNKs(modifier4, Dp.constructor-impl(44)), RoundedCornerShapeKt.getCircleShape());
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            modifier3 = modifier4;
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
            int i6 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i7 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323028353, "C:ShareMenuItem.kt#y4rqem");
            if (icon3 != null) {
                $composer2.startReplaceGroup(-1323017008);
                ComposerKt.sourceInformation($composer2, "94@3128L209");
                ImageKt.Image-5h-nEew(icon3, contentDescription2, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), (Alignment) null, ContentScale.Companion.getCrop(), 0.0f, (ColorFilter) null, 0, $composer2, (($dirty2 >> 3) & 14) | 24960 | (($dirty2 >> 6) & 112), 232);
                $composer2.endReplaceGroup();
            } else {
                String str = iconUrl2;
                if (str == null || StringsKt.isBlank(str)) {
                    $composer2.startReplaceGroup(-1326114311);
                } else {
                    $composer2.startReplaceGroup(-1322752547);
                    ComposerKt.sourceInformation($composer2, "101@3397L132");
                    BiliImageKt.BiliImage(new ImageRequest(iconUrl2).build(), SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), null, null, null, null, null, null, null, $composer2, 48, 508);
                }
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
            icon2 = icon3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final ImageBitmap imageBitmap2 = icon2;
            final String str2 = iconUrl2;
            final String str3 = contentDescription2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.share.common.ui.ShareMenuItemKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit ShareMenuIcon$lambda$1;
                    ShareMenuIcon$lambda$1 = ShareMenuItemKt.ShareMenuIcon$lambda$1(modifier5, imageBitmap2, str2, str3, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ShareMenuIcon$lambda$1;
                }
            });
        }
    }

    /* renamed from: ShareMenuItemName-YEplvsA  reason: not valid java name */
    public static final void m2368ShareMenuItemNameYEplvsA(final String text, Modifier modifier, long j, long j2, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long j3;
        long j4;
        Composer $composer2;
        Modifier modifier3;
        long j5;
        long j6;
        Modifier modifier4;
        long j7;
        int $dirty;
        int i2;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer $composer3 = $composer.startRestartGroup(-1405554373);
        ComposerKt.sourceInformation($composer3, "C(ShareMenuItemName)N(text,modifier,fontSize:c#ui.unit.TextUnit,fontColor:c#ui.graphics.Color)116@3724L338:ShareMenuItem.kt#y4rqem");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changed(text) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty2 |= 384;
            j3 = j;
        } else if (($changed & 384) == 0) {
            j3 = j;
            $dirty2 |= $composer3.changed(j3) ? 256 : 128;
        } else {
            j3 = j;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                j4 = j2;
                if ($composer3.changed(j4)) {
                    i2 = 2048;
                    $dirty2 |= i2;
                }
            } else {
                j4 = j2;
            }
            i2 = 1024;
            $dirty2 |= i2;
        } else {
            j4 = j2;
        }
        if ($composer3.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer3.startDefaults();
            ComposerKt.sourceInformation($composer3, "114@3702L6");
            if (($changed & 1) != 0 && !$composer3.getDefaultsInvalid()) {
                $composer3.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                }
                modifier3 = modifier2;
                j5 = j3;
                j6 = j4;
                $dirty = $dirty2;
            } else {
                if (i3 != 0) {
                    modifier4 = (Modifier) Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 == 0) {
                    j7 = j3;
                } else {
                    j7 = TextUnitKt.getSp(12);
                }
                if ((i & 8) == 0) {
                    $dirty = $dirty2;
                    modifier3 = modifier4;
                    j5 = j7;
                    j6 = j4;
                } else {
                    modifier3 = modifier4;
                    j5 = j7;
                    j6 = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText2-0d7_KjU();
                    $dirty = $dirty2 & (-7169);
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1405554373, $dirty, -1, "kntr.common.share.common.ui.ShareMenuItemName (ShareMenuItem.kt:115)");
            }
            $composer2 = $composer3;
            TextKt.Text-Nvy7gAk(text, SizeKt.wrapContentHeight$default(PaddingKt.padding-qDBjuR0$default(modifier3, 0.0f, Dp.constructor-impl(6), 0.0f, 0.0f, 13, (Object) null), (Alignment.Vertical) null, false, 3, (Object) null), j6, (TextAutoSize) null, j5, (FontStyle) null, FontWeight.Companion.getNormal(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, j5, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer2, ($dirty & 14) | 1572864 | (($dirty >> 3) & 896) | (57344 & ($dirty << 6)), (($dirty >> 3) & 112) | 24960, 239528);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            j5 = j3;
            j6 = j4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final long j8 = j5;
            final long j9 = j6;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.share.common.ui.ShareMenuItemKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit ShareMenuItemName_YEplvsA$lambda$0;
                    ShareMenuItemName_YEplvsA$lambda$0 = ShareMenuItemKt.ShareMenuItemName_YEplvsA$lambda$0(text, modifier5, j8, j9, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ShareMenuItemName_YEplvsA$lambda$0;
                }
            });
        }
    }

    /* renamed from: ShareMenuItemCorner-QZjSdIA  reason: not valid java name */
    public static final void m2367ShareMenuItemCornerQZjSdIA(final String cornerText, Modifier modifier, float f, long j, long j2, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        float f2;
        long j3;
        long j4;
        Composer $composer2;
        Modifier modifier3;
        float f3;
        long j5;
        Modifier modifier4;
        long j6;
        Modifier modifier5;
        int $dirty;
        int i2;
        Composer $composer3 = $composer.startRestartGroup(-1712266535);
        ComposerKt.sourceInformation($composer3, "C(ShareMenuItemCorner)N(cornerText,modifier,radius:c#ui.unit.Dp,fontSize:c#ui.unit.TextUnit,fontColor:c#ui.graphics.Color):ShareMenuItem.kt#y4rqem");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changed(cornerText) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty2 |= 384;
            f2 = f;
        } else if (($changed & 384) == 0) {
            f2 = f;
            $dirty2 |= $composer3.changed(f2) ? 256 : 128;
        } else {
            f2 = f;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty2 |= 3072;
            j3 = j;
        } else if (($changed & 3072) == 0) {
            j3 = j;
            $dirty2 |= $composer3.changed(j3) ? 2048 : 1024;
        } else {
            j3 = j;
        }
        if (($changed & 24576) == 0) {
            if ((i & 16) == 0) {
                j4 = j2;
                if ($composer3.changed(j4)) {
                    i2 = 16384;
                    $dirty2 |= i2;
                }
            } else {
                j4 = j2;
            }
            i2 = 8192;
            $dirty2 |= i2;
        } else {
            j4 = j2;
        }
        boolean z = true;
        if ($composer3.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            $composer3.startDefaults();
            ComposerKt.sourceInformation($composer3, "137@4250L6");
            if (($changed & 1) != 0 && !$composer3.getDefaultsInvalid()) {
                $composer3.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                $dirty = $dirty2;
                f3 = f2;
                j5 = j3;
                j6 = j4;
                modifier5 = modifier2;
            } else {
                if (i3 != 0) {
                    modifier4 = (Modifier) Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    f2 = Dp.constructor-impl(8);
                }
                if (i5 != 0) {
                    j3 = TextUnitKt.getSp(9);
                }
                if ((i & 16) == 0) {
                    f3 = f2;
                    j5 = j3;
                    j6 = j4;
                    modifier5 = modifier4;
                    $dirty = $dirty2;
                } else {
                    j6 = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU();
                    f3 = f2;
                    j5 = j3;
                    modifier5 = modifier4;
                    $dirty = $dirty2 & (-57345);
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1712266535, $dirty, -1, "kntr.common.share.common.ui.ShareMenuItemCorner (ShareMenuItem.kt:138)");
            }
            String str = cornerText;
            if (str != null && str.length() != 0) {
                z = false;
            }
            if (z) {
                modifier3 = modifier5;
                $composer2 = $composer3;
                $composer2.startReplaceGroup(1190184041);
                $composer2.endReplaceGroup();
            } else {
                $composer3.startReplaceGroup(1194484950);
                ComposerKt.sourceInformation($composer3, "146@4556L6,149@4685L6,140@4315L931");
                Modifier modifier$iv = BorderKt.border-xT4_qwU(BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.wrapContentSize$default(OffsetKt.offset-VpY3zN4(modifier5, Dp.constructor-impl(2), Dp.constructor-impl(-6)), (Alignment) null, false, 3, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(f3)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg1_float-0d7_KjU(), (Shape) null, 2, (Object) null), Dp.constructor-impl((float) 0.5d), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getLine_regular-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(f3));
                Alignment contentAlignment$iv = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv = (48 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
                Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    $composer3.createNode(factory$iv$iv$iv);
                } else {
                    $composer3.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                int i6 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i7 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, 849566389, "C154@4862L374:ShareMenuItem.kt#y4rqem");
                modifier3 = modifier5;
                TextKt.Text-Nvy7gAk(cornerText, PaddingKt.padding-VpY3zN4(Modifier.Companion, Dp.constructor-impl(1), Dp.constructor-impl(1)), j6, (TextAutoSize) null, j5, (FontStyle) null, FontWeight.Companion.getNormal(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, j5, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer3, ($dirty & 14) | 1572912 | (($dirty >> 6) & 896) | (($dirty << 3) & 57344), (($dirty >> 6) & 112) | 24960, 239528);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endReplaceGroup();
                $composer2 = $composer3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            j4 = j6;
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            f3 = f2;
            j5 = j3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final float f4 = f3;
            final long j7 = j5;
            final long j8 = j4;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.share.common.ui.ShareMenuItemKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ShareMenuItemCorner_QZjSdIA$lambda$1;
                    ShareMenuItemCorner_QZjSdIA$lambda$1 = ShareMenuItemKt.ShareMenuItemCorner_QZjSdIA$lambda$1(cornerText, modifier6, f4, j7, j8, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ShareMenuItemCorner_QZjSdIA$lambda$1;
                }
            });
        }
    }
}