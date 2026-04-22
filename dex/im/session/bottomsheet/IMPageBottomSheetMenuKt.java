package im.session.bottomsheet;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
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
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.framework.exposure.core.collecter.ComposeExposureLayoutInfoCollectorKt;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.smtt.sdk.TbsListener;
import com.yalantis.ucrop.view.CropImageView;
import im.session.IMActionExposureThreeDotItem;
import im.session.common.IMSessionPageState;
import im.session.common.SimpleExposureEntry;
import im.session.model.IMThreeDotItem;
import io.grpc.internal.GrpcUtil;
import java.util.List;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kntr.base.imageloader.ImmutableImageRequest;
import kntr.common.bilitheme.compose.bottomsheet.BottomSheetScope;
import kntr.common.bilitheme.compose.bottomsheet.ComposeBottomsheetKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: IMPageBottomSheetMenu.kt */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¢\u0006\u0002\u0010\u0007\u001a+\u0010\b\u001a\u00020\u0001*\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0001¢\u0006\u0002\u0010\r\u001aQ\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"IMPageBottomSheetMenu", "", "items", "", "Lim/session/model/IMThreeDotItem;", "pageState", "Lim/session/common/IMSessionPageState;", "(Ljava/util/List;Lim/session/common/IMSessionPageState;Landroidx/compose/runtime/Composer;I)V", "IMPageBottomSheetMenuItem", "Lkntr/common/bilitheme/compose/bottomsheet/BottomSheetScope;", "item", "isLast", "", "(Lkntr/common/bilitheme/compose/bottomsheet/BottomSheetScope;Lim/session/model/IMThreeDotItem;Lim/session/common/IMSessionPageState;ZLandroidx/compose/runtime/Composer;II)V", "BottomSheetColumnItem", "iconUrl", "", "title", "unread", "modifier", "Landroidx/compose/ui/Modifier;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "color", "Landroidx/compose/ui/graphics/Color;", "BottomSheetColumnItem-cd68TDI", "(Ljava/lang/String;Ljava/lang/String;ZLandroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/painter/Painter;JZLandroidx/compose/runtime/Composer;II)V", "session-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IMPageBottomSheetMenuKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomSheetColumnItem_cd68TDI$lambda$2(String str, String str2, boolean z, Modifier modifier, Painter painter, long j, boolean z2, int i2, int i3, Composer composer, int i4) {
        m3248BottomSheetColumnItemcd68TDI(str, str2, z, modifier, painter, j, z2, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMPageBottomSheetMenu$lambda$2(List list, IMSessionPageState iMSessionPageState, int i2, Composer composer, int i3) {
        IMPageBottomSheetMenu(list, iMSessionPageState, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMPageBottomSheetMenuItem$lambda$2(BottomSheetScope bottomSheetScope, IMThreeDotItem iMThreeDotItem, IMSessionPageState iMSessionPageState, boolean z, int i2, int i3, Composer composer, int i4) {
        IMPageBottomSheetMenuItem(bottomSheetScope, iMThreeDotItem, iMSessionPageState, z, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    public static final void IMPageBottomSheetMenu(final List<IMThreeDotItem> list, final IMSessionPageState pageState, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(list, "items");
        Intrinsics.checkNotNullParameter(pageState, "pageState");
        Composer $composer2 = $composer.startRestartGroup(-313957866);
        ComposerKt.sourceInformation($composer2, "C(IMPageBottomSheetMenu)N(items,pageState)49@2094L29,49@2067L288:IMPageBottomSheetMenu.kt#dcxxbm");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(list) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(pageState) ? 32 : 16;
        }
        if (!$composer2.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-313957866, $dirty, -1, "im.session.bottomsheet.IMPageBottomSheetMenu (IMPageBottomSheetMenu.kt:48)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -1065794317, "CC(remember):IMPageBottomSheetMenu.kt#9igjgp");
            boolean invalid$iv = ($dirty & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) == 32;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = (KFunction) new IMPageBottomSheetMenuKt$IMPageBottomSheetMenu$1$1(pageState);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Function0 onDismiss$iv = (KFunction) it$iv;
            ComposerKt.sourceInformationMarkerStart($composer2, -1330546869, "CC(BottomSheetColumnContainer)N(onDismiss,modifier,content)154@5815L207,154@5771L251:ComposeBottomsheet.kt#18ljev");
            final Modifier modifier$iv = Modifier.Companion;
            ComposeBottomsheetKt.BottomSheetContainer-lVb_Clg(onDismiss$iv, (Function0) null, 0L, false, false, false, (PaddingValues) null, ComposableLambdaKt.rememberComposableLambda(1454232538, true, new Function3<BottomSheetScope, Composer, Integer, Unit>() { // from class: im.session.bottomsheet.IMPageBottomSheetMenuKt$IMPageBottomSheetMenu$$inlined$BottomSheetColumnContainer$1
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
                    invoke((BottomSheetScope) p1, (Composer) p2, ((Number) p3).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(BottomSheetScope $this$BottomSheetContainer, Composer $composer3, int $changed2) {
                    Function0 factory$iv$iv$iv;
                    Intrinsics.checkNotNullParameter($this$BottomSheetContainer, "$this$BottomSheetContainer");
                    ComposerKt.sourceInformation($composer3, "C155@5825L191:ComposeBottomsheet.kt#18ljev");
                    int $dirty2 = $changed2;
                    if (($changed2 & 6) == 0) {
                        $dirty2 |= $composer3.changed($this$BottomSheetContainer) ? 4 : 2;
                    }
                    if ($composer3.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1454232538, $dirty2, -1, "kntr.common.bilitheme.compose.bottomsheet.BottomSheetColumnContainer.<anonymous> (ComposeBottomsheet.kt:155)");
                        }
                        Modifier modifier$iv2 = ClipKt.clip(SizeKt.fillMaxWidth$default(modifier$iv, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8)));
                        boolean z = false;
                        ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                        MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
                        int $changed$iv$iv = (0 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                        CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
                        Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!($composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer3.startReusableNode();
                        if ($composer3.getInserting()) {
                            factory$iv$iv$iv = factory$iv$iv$iv2;
                            $composer3.createNode(factory$iv$iv$iv);
                        } else {
                            factory$iv$iv$iv = factory$iv$iv$iv2;
                            $composer3.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                        int i2 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                        ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                        int i3 = ((0 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, 639823158, "C160@5994L9:ComposeBottomsheet.kt#18ljev");
                        int $changed3 = $dirty2 & 14;
                        $composer3.startReplaceGroup(313515203);
                        ComposerKt.sourceInformation($composer3, "C:IMPageBottomSheetMenu.kt#dcxxbm");
                        $composer3.startReplaceGroup(-1652454406);
                        ComposerKt.sourceInformation($composer3, "*53@2272L67");
                        Iterable $this$forEachIndexed$iv = list;
                        int index$iv = 0;
                        for (Object item$iv : $this$forEachIndexed$iv) {
                            int index$iv2 = index$iv + 1;
                            if (index$iv < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            IMThreeDotItem threeDotItem = (IMThreeDotItem) item$iv;
                            int index = index$iv;
                            Iterable $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                            boolean z2 = z;
                            boolean isLast = index == CollectionsKt.getLastIndex(list);
                            IMPageBottomSheetMenuKt.IMPageBottomSheetMenuItem($this$BottomSheetContainer, threeDotItem, pageState, isLast, $composer3, $changed3 & 14, 0);
                            index$iv = index$iv2;
                            $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                            z = z2;
                        }
                        $composer3.endReplaceGroup();
                        $composer3.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), $composer2, (0 & 14) | 12582912, (int) TbsListener.ErrorCode.PV_UPLOAD_ERROR);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: im.session.bottomsheet.IMPageBottomSheetMenuKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit IMPageBottomSheetMenu$lambda$2;
                    IMPageBottomSheetMenu$lambda$2 = IMPageBottomSheetMenuKt.IMPageBottomSheetMenu$lambda$2(list, pageState, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return IMPageBottomSheetMenu$lambda$2;
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x012a, code lost:
        if (r15 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0180, code lost:
        if (r15 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L63;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void IMPageBottomSheetMenuItem(final BottomSheetScope $this$IMPageBottomSheetMenuItem, final IMThreeDotItem item, final IMSessionPageState pageState, boolean isLast, Composer $composer, final int $changed, final int i2) {
        boolean isLast2;
        Intrinsics.checkNotNullParameter($this$IMPageBottomSheetMenuItem, "<this>");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(pageState, "pageState");
        Composer $composer2 = $composer.startRestartGroup(1275374063);
        ComposerKt.sourceInformation($composer2, "C(IMPageBottomSheetMenuItem)N(item,pageState,isLast)64@2538L24,71@2747L170,77@2985L120,65@2567L589:IMPageBottomSheetMenu.kt#dcxxbm");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed($this$IMPageBottomSheetMenuItem) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(item) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(pageState) ? 256 : 128;
        }
        int i3 = i2 & 4;
        if (i3 != 0) {
            $dirty |= 3072;
            isLast2 = isLast;
        } else if (($changed & 3072) == 0) {
            isLast2 = isLast;
            $dirty |= $composer2.changed(isLast2) ? 2048 : 1024;
        } else {
            isLast2 = isLast;
        }
        if ($composer2.shouldExecute(($dirty & 1171) != 1170, $dirty & 1)) {
            boolean isLast3 = i3 != 0 ? false : isLast2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1275374063, $dirty, -1, "im.session.bottomsheet.IMPageBottomSheetMenuItem (IMPageBottomSheetMenu.kt:63)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer2, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer2.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2);
                $composer2.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            final CoroutineScope scope = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            String icon = item.getIcon();
            String title = item.getTitle();
            boolean hasRedDot = item.getHasRedDot();
            Modifier modifier = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart($composer2, 1568807097, "CC(remember):IMPageBottomSheetMenu.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(scope) | (($dirty & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) == 32) | (($dirty & 896) == 256) | (($dirty & 14) == 4);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = new Function0() { // from class: im.session.bottomsheet.IMPageBottomSheetMenuKt$$ExternalSyntheticLambda4
                public final Object invoke() {
                    Unit IMPageBottomSheetMenuItem$lambda$0$0;
                    IMPageBottomSheetMenuItem$lambda$0$0 = IMPageBottomSheetMenuKt.IMPageBottomSheetMenuItem$lambda$0$0(scope, item, pageState, $this$IMPageBottomSheetMenuItem);
                    return IMPageBottomSheetMenuItem$lambda$0$0;
                }
            };
            $composer2.updateRememberedValue(value$iv);
            it$iv = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier2 = ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 1568814663, "CC(remember):IMPageBottomSheetMenu.kt#9igjgp");
            boolean invalid$iv2 = (($dirty & 896) == 256) | (($dirty & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) == 32);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv2 = new Function0() { // from class: im.session.bottomsheet.IMPageBottomSheetMenuKt$$ExternalSyntheticLambda5
                public final Object invoke() {
                    Unit IMPageBottomSheetMenuItem$lambda$1$0;
                    IMPageBottomSheetMenuItem$lambda$1$0 = IMPageBottomSheetMenuKt.IMPageBottomSheetMenuItem$lambda$1$0(IMSessionPageState.this, item);
                    return IMPageBottomSheetMenuItem$lambda$1$0;
                }
            };
            $composer2.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            m3248BottomSheetColumnItemcd68TDI(icon, title, hasRedDot, ComposeExposureLayoutInfoCollectorKt.collectExposureLayoutInfo(modifier2, new SimpleExposureEntry(0L, (Function0) it$iv2, 1, null)), null, 0L, isLast3, $composer2, ($dirty << 9) & 3670016, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            isLast2 = isLast3;
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final boolean z = isLast2;
            endRestartGroup.updateScope(new Function2() { // from class: im.session.bottomsheet.IMPageBottomSheetMenuKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit IMPageBottomSheetMenuItem$lambda$2;
                    IMPageBottomSheetMenuItem$lambda$2 = IMPageBottomSheetMenuKt.IMPageBottomSheetMenuItem$lambda$2($this$IMPageBottomSheetMenuItem, item, pageState, z, $changed, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return IMPageBottomSheetMenuItem$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMPageBottomSheetMenuItem$lambda$0$0(CoroutineScope $scope, IMThreeDotItem $item, IMSessionPageState $pageState, BottomSheetScope $this_IMPageBottomSheetMenuItem) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new IMPageBottomSheetMenuKt$IMPageBottomSheetMenuItem$1$1$1($item, $pageState, $this_IMPageBottomSheetMenuItem, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMPageBottomSheetMenuItem$lambda$1$0(IMSessionPageState $pageState, IMThreeDotItem $item) {
        $pageState.getEventHandler().getActionHandler().invoke(new IMActionExposureThreeDotItem($item));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:106:0x0194, code lost:
        if (r8 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0522, code lost:
        if (r12 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L84;
     */
    /* renamed from: BottomSheetColumnItem-cd68TDI  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3248BottomSheetColumnItemcd68TDI(final String iconUrl, final String title, final boolean unread, Modifier modifier, Painter painter, long j, boolean isLast, Composer $composer, final int $changed, final int i2) {
        Modifier modifier2;
        long j2;
        boolean isLast2;
        Composer $composer2;
        Modifier modifier3;
        long j3;
        Painter painter2;
        Modifier modifier4;
        Painter painter3;
        int $dirty;
        long j4;
        final boolean isLast3;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Painter painter4;
        int i3;
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(title, "title");
        Composer $composer3 = $composer.startRestartGroup(-1190881548);
        ComposerKt.sourceInformation($composer3, "C(BottomSheetColumnItem)N(iconUrl,title,unread,modifier,painter,color:c#ui.graphics.Color,isLast)95@3513L6,101@3678L444,111@4152L6,96@3537L2227:IMPageBottomSheetMenu.kt#dcxxbm");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changed(iconUrl) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer3.changed(title) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer3.changed(unread) ? 256 : 128;
        }
        int i4 = i2 & 8;
        if (i4 != 0) {
            $dirty2 |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int i5 = i2 & 16;
        if (i5 != 0) {
            $dirty2 |= 24576;
        } else if (($changed & 24576) == 0) {
            $dirty2 |= (32768 & $changed) == 0 ? $composer3.changed(painter) : $composer3.changedInstance(painter) ? 16384 : GrpcUtil.DEFAULT_MAX_HEADER_LIST_SIZE;
        }
        if ((196608 & $changed) == 0) {
            if ((i2 & 32) == 0) {
                j2 = j;
                if ($composer3.changed(j2)) {
                    i3 = WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
                    $dirty2 |= i3;
                }
            } else {
                j2 = j;
            }
            i3 = WXMediaMessage.THUMB_LENGTH_LIMIT;
            $dirty2 |= i3;
        } else {
            j2 = j;
        }
        int i6 = i2 & 64;
        if (i6 != 0) {
            $dirty2 |= 1572864;
            isLast2 = isLast;
        } else if ((1572864 & $changed) == 0) {
            isLast2 = isLast;
            $dirty2 |= $composer3.changed(isLast2) ? 1048576 : 524288;
        } else {
            isLast2 = isLast;
        }
        if ($composer3.shouldExecute(($dirty2 & 599187) != 599186, $dirty2 & 1)) {
            $composer3.startDefaults();
            ComposerKt.sourceInformation($composer3, "92@3390L6");
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                modifier4 = i4 != 0 ? (Modifier) Modifier.Companion : modifier2;
                painter3 = i5 != 0 ? null : painter;
                if ((i2 & 32) != 0) {
                    $dirty2 &= -458753;
                    j2 = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getGraph_white-0d7_KjU();
                }
                if (i6 != 0) {
                    $dirty = $dirty2;
                    isLast3 = false;
                    j4 = j2;
                } else {
                    $dirty = $dirty2;
                    j4 = j2;
                    isLast3 = isLast2;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i2 & 32) != 0) {
                    $dirty2 &= -458753;
                }
                painter3 = painter;
                $dirty = $dirty2;
                modifier4 = modifier2;
                j4 = j2;
                isLast3 = isLast2;
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1190881548, $dirty, -1, "im.session.bottomsheet.BottomSheetColumnItem (IMPageBottomSheetMenu.kt:94)");
            }
            final long dividerColor = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getLine_regular-0d7_KjU();
            Modifier modifier5 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier4, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), Dp.constructor-impl(52));
            ComposerKt.sourceInformationMarkerStart($composer3, -1975850256, "CC(remember):IMPageBottomSheetMenu.kt#9igjgp");
            Modifier modifier6 = modifier4;
            boolean invalid$iv = ((3670016 & $dirty) == 1048576) | $composer3.changed(dividerColor);
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = new Function1() { // from class: im.session.bottomsheet.IMPageBottomSheetMenuKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    Unit BottomSheetColumnItem_cd68TDI$lambda$0$0;
                    BottomSheetColumnItem_cd68TDI$lambda$0$0 = IMPageBottomSheetMenuKt.BottomSheetColumnItem_cd68TDI$lambda$0$0(isLast3, dividerColor, (ContentDrawScope) obj);
                    return BottomSheetColumnItem_cd68TDI$lambda$0$0;
                }
            };
            $composer3.updateRememberedValue(value$iv);
            it$iv = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv = PaddingKt.padding-3ABfNKs(BackgroundKt.background-bw27NRU$default(DrawModifierKt.drawWithContent(modifier5, (Function1) it$iv), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg1_float-0d7_KjU(), (Shape) null, 2, (Object) null), Dp.constructor-impl(16));
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            boolean isLast4 = isLast3;
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8));
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
            int $changed$iv$iv = (432 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            $composer2 = $composer3;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i7 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i8 = ((432 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1131365302, "C116@4341L1206,149@5618L9,150@5663L6,147@5556L202:IMPageBottomSheetMenu.kt#dcxxbm");
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Modifier modifier$iv2 = Modifier.Companion;
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv2 = (0 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer3.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i9 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i10 = ((0 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            BoxScope $this$BottomSheetColumnItem_cd68TDI_u24lambda_u241_u240 = boxScope;
            ComposerKt.sourceInformationMarkerStart($composer3, -502239009, "C:IMPageBottomSheetMenu.kt#dcxxbm");
            if (painter3 != null) {
                $composer3.startReplaceGroup(-502231074);
                ComposerKt.sourceInformation($composer3, "118@4398L186");
                IconKt.Icon-ww6aTOc(painter3, (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), j4, $composer3, Painter.$stable | 432 | (($dirty >> 12) & 14) | (($dirty >> 6) & 7168), 0);
                $composer3.endReplaceGroup();
                painter4 = painter3;
            } else {
                $composer3.startReplaceGroup(-502023312);
                ComposerKt.sourceInformation($composer3, "125@4622L264");
                $composer3.startReplaceGroup(-1678759551);
                ComposerKt.sourceInformation($composer3, "*128@4774L6");
                ImageRequest $this$BottomSheetColumnItem_cd68TDI_u24lambda_u241_u240_u240 = new ImageRequest(iconUrl);
                ColorFilter.Companion companion = ColorFilter.Companion;
                BiliTheme biliTheme = BiliTheme.INSTANCE;
                int $i$f$asRequest = BiliTheme.$stable;
                $this$BottomSheetColumnItem_cd68TDI_u24lambda_u241_u240_u240.colorFilter(ColorFilter.Companion.tint-xETnrds$default(companion, biliTheme.getColors($composer3, $i$f$asRequest).getText1-0d7_KjU(), 0, 2, (Object) null));
                ImmutableImageRequest build = $this$BottomSheetColumnItem_cd68TDI_u24lambda_u241_u240_u240.build();
                $composer3.endReplaceGroup();
                painter4 = painter3;
                BiliImageKt.BiliImage(build, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), (String) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function2) null, (Function4) null, $composer3, 48, (int) TbsListener.ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_OPENINQB);
                $composer3.endReplaceGroup();
            }
            if (unread) {
                $composer3.startReplaceGroup(-501695084);
                ComposerKt.sourceInformation($composer3, "134@4974L7,140@5226L38,141@5333L6,143@5465L6,135@5028L495");
                CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
                j3 = j4;
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume = $composer3.consume(this_$iv);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Density $this$BottomSheetColumnItem_cd68TDI_u24lambda_u241_u240_u241 = (Density) consume;
                final int offset = MathKt.roundToInt($this$BottomSheetColumnItem_cd68TDI_u24lambda_u241_u240_u241.toPx-0680j_4(Dp.constructor-impl(2)));
                Modifier align = $this$BottomSheetColumnItem_cd68TDI_u24lambda_u241_u240.align(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), Alignment.Companion.getTopEnd());
                ComposerKt.sourceInformationMarkerStart($composer3, -1678742640, "CC(remember):IMPageBottomSheetMenu.kt#9igjgp");
                boolean invalid$iv2 = $composer3.changed(offset);
                Object it$iv2 = $composer3.rememberedValue();
                if (invalid$iv2) {
                }
                Object value$iv2 = new Function1() { // from class: im.session.bottomsheet.IMPageBottomSheetMenuKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        IntOffset BottomSheetColumnItem_cd68TDI$lambda$1$0$2$0;
                        BottomSheetColumnItem_cd68TDI$lambda$1$0$2$0 = IMPageBottomSheetMenuKt.BottomSheetColumnItem_cd68TDI$lambda$1$0$2$0(offset, (Density) obj);
                        return BottomSheetColumnItem_cd68TDI$lambda$1$0$2$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                BoxKt.Box(BackgroundKt.background-bw27NRU(PaddingKt.padding-3ABfNKs(BorderKt.border-xT4_qwU(OffsetKt.offset(align, (Function1) it$iv2), Dp.constructor-impl(1), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg1-0d7_KjU(), RoundedCornerShapeKt.getCircleShape()), Dp.constructor-impl(1)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getStress_red-0d7_KjU(), RoundedCornerShapeKt.getCircleShape()), $composer3, 0);
            } else {
                j3 = j4;
                $composer3.startReplaceGroup(-506600648);
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            TextKt.Text-Nvy7gAk(title, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT14(), $composer3, ($dirty >> 3) & 14, 24960, 110586);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier6;
            isLast2 = isLast4;
            painter2 = painter4;
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            j3 = j2;
            painter2 = painter;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier7 = modifier3;
            final Painter painter5 = painter2;
            final long j5 = j3;
            final boolean z = isLast2;
            endRestartGroup.updateScope(new Function2() { // from class: im.session.bottomsheet.IMPageBottomSheetMenuKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit BottomSheetColumnItem_cd68TDI$lambda$2;
                    BottomSheetColumnItem_cd68TDI$lambda$2 = IMPageBottomSheetMenuKt.BottomSheetColumnItem_cd68TDI$lambda$2(iconUrl, title, unread, modifier7, painter5, j5, z, $changed, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return BottomSheetColumnItem_cd68TDI$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomSheetColumnItem_cd68TDI$lambda$0$0(boolean $isLast, long $dividerColor, ContentDrawScope $this$drawWithContent) {
        Intrinsics.checkNotNullParameter($this$drawWithContent, "$this$drawWithContent");
        $this$drawWithContent.drawContent();
        if (!$isLast) {
            float x$iv = $this$drawWithContent.toPx-0680j_4(Dp.constructor-impl(44));
            int bits$iv$iv$iv = (int) ($this$drawWithContent.getSize-NH-jbRc() & 4294967295L);
            float y$iv = Float.intBitsToFloat(bits$iv$iv$iv) - $this$drawWithContent.toPx-0680j_4(Dp.constructor-impl((float) 0.5d));
            long v1$iv$iv = Float.floatToRawIntBits(x$iv);
            long v2$iv$iv = Float.floatToRawIntBits(y$iv);
            long offset = Offset.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L));
            int bits$iv$iv$iv2 = (int) ($this$drawWithContent.getSize-NH-jbRc() >> 32);
            float width$iv = Float.intBitsToFloat(bits$iv$iv$iv2) - $this$drawWithContent.toPx-0680j_4(Dp.constructor-impl(44));
            float height$iv = $this$drawWithContent.toPx-0680j_4(Dp.constructor-impl((float) 0.5d));
            long v1$iv$iv2 = Float.floatToRawIntBits(width$iv);
            long v2$iv$iv2 = Float.floatToRawIntBits(height$iv);
            DrawScope.-CC.drawRect-n-J9OG0$default((DrawScope) $this$drawWithContent, $dividerColor, offset, Size.constructor-impl((v1$iv$iv2 << 32) | (4294967295L & v2$iv$iv2)), (float) CropImageView.DEFAULT_ASPECT_RATIO, (DrawStyle) null, (ColorFilter) null, 0, (int) TbsListener.ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntOffset BottomSheetColumnItem_cd68TDI$lambda$1$0$2$0(int $offset, Density $this$offset) {
        Intrinsics.checkNotNullParameter($this$offset, "$this$offset");
        int y$iv = -$offset;
        return IntOffset.box-impl(IntOffset.constructor-impl(($offset << 32) | (y$iv & 4294967295L)));
    }
}