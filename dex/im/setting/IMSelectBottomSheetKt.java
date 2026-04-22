package im.setting;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
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
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import com.bapis.bilibili.app.im.v1.KRedirectWindowSelect;
import com.bapis.bilibili.app.im.v1.KSelectItem;
import com.bapis.bilibili.app.im.v1.KSetting;
import com.bapis.bilibili.app.im.v1.KSettingRedirect;
import com.bilibili.compose.theme.BiliTheme;
import com.tencent.smtt.sdk.TbsListener;
import com.yalantis.ucrop.view.CropImageView;
import im.setting.model.SettingItem;
import io.ktor.client.utils.CIOKt;
import kntr.common.bilitheme.compose.bottomsheet.BottomSheetScope;
import kntr.common.bilitheme.compose.bottomsheet.ComposeBottomsheetKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMSelectBottomSheet.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006\u001a-\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0001¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"IMSelectBottomSheet", "", "setting", "Lim/setting/model/SettingItem$Setting;", "eventHandler", "Lim/setting/IMSettingEventHandler;", "(Lim/setting/model/SettingItem$Setting;Lim/setting/IMSettingEventHandler;Landroidx/compose/runtime/Composer;I)V", "IMWindowSettingSelectItem", "item", "Lcom/bapis/bilibili/app/im/v1/KRedirectWindowSelect;", "isLoading", "", "onAction", "Lim/setting/IMSettingActionHandler;", "(Lim/setting/model/SettingItem$Setting;Lcom/bapis/bilibili/app/im/v1/KRedirectWindowSelect;ZLim/setting/IMSettingActionHandler;Landroidx/compose/runtime/Composer;I)V", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IMSelectBottomSheetKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMSelectBottomSheet$lambda$0(SettingItem.Setting setting, IMSettingEventHandler iMSettingEventHandler, int i2, Composer composer, int i3) {
        IMSelectBottomSheet(setting, iMSettingEventHandler, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMSelectBottomSheet$lambda$1(SettingItem.Setting setting, IMSettingEventHandler iMSettingEventHandler, int i2, Composer composer, int i3) {
        IMSelectBottomSheet(setting, iMSettingEventHandler, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMSelectBottomSheet$lambda$4(SettingItem.Setting setting, IMSettingEventHandler iMSettingEventHandler, int i2, Composer composer, int i3) {
        IMSelectBottomSheet(setting, iMSettingEventHandler, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMWindowSettingSelectItem$lambda$1(SettingItem.Setting setting, KRedirectWindowSelect kRedirectWindowSelect, boolean z, IMSettingActionHandler iMSettingActionHandler, int i2, Composer composer, int i3) {
        IMWindowSettingSelectItem(setting, kRedirectWindowSelect, z, iMSettingActionHandler, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    public static final void IMSelectBottomSheet(final SettingItem.Setting setting, final IMSettingEventHandler eventHandler, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(setting, "setting");
        Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
        Composer $composer2 = $composer.startRestartGroup(-1664532564);
        ComposerKt.sourceInformation($composer2, "C(IMSelectBottomSheet)N(setting,eventHandler)31@1093L64,30@1045L514:IMSelectBottomSheet.kt#w7mava");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(setting) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(eventHandler) ? 32 : 16;
        }
        if (!$composer2.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1664532564, $dirty, -1, "im.setting.IMSelectBottomSheet (IMSelectBottomSheet.kt:25)");
            }
            KSetting.KRedirect content = setting.getSetting().getContent();
            if (content instanceof KSetting.KRedirect) {
                final KSettingRedirect.IContent content2 = content.getValue().getContent();
                if (content2 instanceof KSettingRedirect.KWindowSelect) {
                    ComposerKt.sourceInformationMarkerStart($composer2, -1887949108, "CC(remember):IMSelectBottomSheet.kt#9igjgp");
                    boolean invalid$iv = ($dirty & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) == 32;
                    Object it$iv = $composer2.rememberedValue();
                    if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                        Object value$iv = new Function0() { // from class: im.setting.IMSelectBottomSheetKt$$ExternalSyntheticLambda2
                            public final Object invoke() {
                                Unit IMSelectBottomSheet$lambda$2$0;
                                IMSelectBottomSheet$lambda$2$0 = IMSelectBottomSheetKt.IMSelectBottomSheet$lambda$2$0(IMSettingEventHandler.this);
                                return IMSelectBottomSheet$lambda$2$0;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv);
                        it$iv = value$iv;
                    }
                    Function0 onDismiss$iv = (Function0) it$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerStart($composer2, -1330546869, "CC(BottomSheetColumnContainer)N(onDismiss,modifier,content)154@5815L207,154@5771L251:ComposeBottomsheet.kt#18ljev");
                    final Modifier modifier$iv = Modifier.Companion;
                    ComposeBottomsheetKt.BottomSheetContainer-lVb_Clg(onDismiss$iv, (Function0) null, 0L, false, false, false, (PaddingValues) null, ComposableLambdaKt.rememberComposableLambda(1454232538, true, new Function3<BottomSheetScope, Composer, Integer, Unit>() { // from class: im.setting.IMSelectBottomSheetKt$IMSelectBottomSheet$$inlined$BottomSheetColumnContainer$1
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
                                int i4 = $dirty2 & 14;
                                $composer3.startReplaceGroup(20404809);
                                ComposerKt.sourceInformation($composer3, "C35@1251L9,36@1297L6,33@1175L213,40@1398L155:IMSelectBottomSheet.kt#w7mava");
                                TextKt.Text-Nvy7gAk(content2.getValue().getTitle(), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, Dp.constructor-impl(8), (float) CropImageView.DEFAULT_ASPECT_RATIO, Dp.constructor-impl(12), 5, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getGa10-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT14b(), $composer3, 48, 0, 131064);
                                IMSelectBottomSheetKt.IMWindowSettingSelectItem(setting, content2.getValue(), setting.isLoading(), eventHandler.getActionHandler(), $composer3, 0);
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
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                        endRestartGroup.updateScope(new Function2() { // from class: im.setting.IMSelectBottomSheetKt$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj, Object obj2) {
                                Unit IMSelectBottomSheet$lambda$1;
                                IMSelectBottomSheet$lambda$1 = IMSelectBottomSheetKt.IMSelectBottomSheet$lambda$1(SettingItem.Setting.this, eventHandler, $changed, (Composer) obj, ((Integer) obj2).intValue());
                                return IMSelectBottomSheet$lambda$1;
                            }
                        });
                        return;
                    }
                    return;
                }
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
                if (endRestartGroup2 != null) {
                    endRestartGroup2.updateScope(new Function2() { // from class: im.setting.IMSelectBottomSheetKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj, Object obj2) {
                            Unit IMSelectBottomSheet$lambda$0;
                            IMSelectBottomSheet$lambda$0 = IMSelectBottomSheetKt.IMSelectBottomSheet$lambda$0(SettingItem.Setting.this, eventHandler, $changed, (Composer) obj, ((Integer) obj2).intValue());
                            return IMSelectBottomSheet$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
        }
        ScopeUpdateScope endRestartGroup3 = $composer2.endRestartGroup();
        if (endRestartGroup3 != null) {
            endRestartGroup3.updateScope(new Function2() { // from class: im.setting.IMSelectBottomSheetKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit IMSelectBottomSheet$lambda$4;
                    IMSelectBottomSheet$lambda$4 = IMSelectBottomSheetKt.IMSelectBottomSheet$lambda$4(SettingItem.Setting.this, eventHandler, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return IMSelectBottomSheet$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMSelectBottomSheet$lambda$2$0(IMSettingEventHandler $eventHandler) {
        $eventHandler.getActionHandler().invoke(IMSettingCloseSelectWindowAction.INSTANCE);
        return Unit.INSTANCE;
    }

    public static final void IMWindowSettingSelectItem(final SettingItem.Setting item, final KRedirectWindowSelect setting, final boolean isLoading, final IMSettingActionHandler onAction, Composer $composer, final int $changed) {
        long j;
        Iterable $this$forEachIndexed$iv;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(setting, "setting");
        Intrinsics.checkNotNullParameter(onAction, "onAction");
        Composer $composer2 = $composer.startRestartGroup(-1029609510);
        ComposerKt.sourceInformation($composer2, "C(IMWindowSettingSelectItem)N(item,setting,isLoading,onAction)*66@2134L6,67@2205L98,60@1868L467:IMSelectBottomSheet.kt#w7mava");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(item) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(setting) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(isLoading) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= ($changed & CIOKt.DEFAULT_HTTP_BUFFER_SIZE) == 0 ? $composer2.changed(onAction) : $composer2.changedInstance(onAction) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        int i2 = 0;
        int i3 = 1;
        if (!$composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1029609510, $dirty2, -1, "im.setting.IMWindowSettingSelectItem (IMSelectBottomSheet.kt:55)");
            }
            Iterable $this$forEachIndexed$iv2 = setting.getItem();
            int index$iv = 0;
            for (Object item$iv : $this$forEachIndexed$iv2) {
                int index$iv2 = index$iv + 1;
                if (index$iv < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                final KSelectItem it = (KSelectItem) item$iv;
                int index = index$iv;
                if (index != 0) {
                    $composer2.startReplaceGroup(-210510867);
                    ComposerKt.sourceInformation($composer2, "58@1833L16");
                    IMSettingItemKt.SettingDivider($composer2, i2);
                } else {
                    $composer2.startReplaceGroup(-212317547);
                }
                $composer2.endReplaceGroup();
                String text = it.getText();
                if (it.getSelected()) {
                    $composer2.startReplaceGroup(-1946448841);
                    ComposerKt.sourceInformation($composer2, "62@1953L6");
                    j = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU();
                } else {
                    $composer2.startReplaceGroup(-1946447790);
                    ComposerKt.sourceInformation($composer2, "62@1986L6");
                    j = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU();
                }
                $composer2.endReplaceGroup();
                Modifier modifier = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxWidth$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, i3, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBg1_float-0d7_KjU(), (Shape) null, 2, (Object) null);
                boolean z = !isLoading;
                ComposerKt.sourceInformationMarkerStart($composer2, -1946440913, "CC(remember):IMSelectBottomSheet.kt#9igjgp");
                int i4 = ((($dirty2 & 7168) == 2048 || (($dirty2 & CIOKt.DEFAULT_HTTP_BUFFER_SIZE) != 0 && $composer2.changedInstance(onAction))) ? i3 : 0) | (($dirty2 & 14) == 4 ? i3 : 0) | ($composer2.changedInstance(it) ? 1 : 0);
                Object it$iv = $composer2.rememberedValue();
                if (i4 != 0 || it$iv == Composer.Companion.getEmpty()) {
                    $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                    Object value$iv = new Function0() { // from class: im.setting.IMSelectBottomSheetKt$$ExternalSyntheticLambda4
                        public final Object invoke() {
                            Unit IMWindowSettingSelectItem$lambda$0$0$0;
                            IMWindowSettingSelectItem$lambda$0$0$0 = IMSelectBottomSheetKt.IMWindowSettingSelectItem$lambda$0$0$0(IMSettingActionHandler.this, item, it);
                            return IMWindowSettingSelectItem$lambda$0$0$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                } else {
                    $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                IMSettingItemKt.m3390IMSettingTitlessW7UJKQ(text, j, PaddingKt.padding-3ABfNKs(ClickableKt.clickable-oSLSa3U$default(modifier, z, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 14, (Object) null), Dp.constructor-impl(16)), null, $composer2, 0, 8);
                i3 = 1;
                index$iv = index$iv2;
                $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                i2 = 0;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: im.setting.IMSelectBottomSheetKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit IMWindowSettingSelectItem$lambda$1;
                    IMWindowSettingSelectItem$lambda$1 = IMSelectBottomSheetKt.IMWindowSettingSelectItem$lambda$1(SettingItem.Setting.this, setting, isLoading, onAction, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return IMWindowSettingSelectItem$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMWindowSettingSelectItem$lambda$0$0$0(IMSettingActionHandler $onAction, SettingItem.Setting $item, KSelectItem $it) {
        $onAction.invoke(new IMSettingSelectAction($item, $it.getItemType()));
        return Unit.INSTANCE;
    }
}