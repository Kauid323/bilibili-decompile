package kntr.app.tribee.publish.ui.v2.internal;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import com.bapis.bilibili.dynamic.common.KTribeeCategory;
import kntr.app.tribee.publish.core.v2.TribeePublishAction;
import kntr.app.tribee.publish.core.v2.model.TribeeInfo;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroStore;
import kntr.common.ouro.preview.component.ToolbarItem;
import kntr.common.ouro.preview.component.ToolbarKt;
import kntr.common.ouro.preview.component.ToolbarTrackEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: TribeeToolbar.kt */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0087\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000e2&\u0010\u000f\u001a\"\b\u0001\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0010j\u0002`\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0001¢\u0006\u0002\u0010\u0017¨\u0006\u0018"}, d2 = {"TribeeToolbar", "", "tribeeInfo", "Lkntr/app/tribee/publish/core/v2/model/TribeeInfo;", "ouroStore", "Lkntr/common/ouro/core/OuroStore;", "showSyncToFollowing", "", "syncToFollowing", "selectedCategory", "Lcom/bapis/bilibili/dynamic/common/KTribeeCategory;", "activeItem", "Lkntr/common/ouro/preview/component/ToolbarItem;", "onClickItem", "Lkotlin/Function1;", "onTribeeAction", "Lkotlin/Function2;", "Lkntr/app/tribee/publish/core/v2/TribeePublishAction;", "Lkotlin/coroutines/Continuation;", "", "Lkntr/app/tribee/publish/ui/v2/TribeeActionHandler;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/tribee/publish/core/v2/model/TribeeInfo;Lkntr/common/ouro/core/OuroStore;ZZLcom/bapis/bilibili/dynamic/common/KTribeeCategory;Lkntr/common/ouro/preview/component/ToolbarItem;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeToolbarKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeToolbar$lambda$1(TribeeInfo tribeeInfo, OuroStore ouroStore, boolean z, boolean z2, KTribeeCategory kTribeeCategory, ToolbarItem toolbarItem, Function1 function1, Function2 function2, Modifier modifier, int i, int i2, Composer composer, int i3) {
        TribeeToolbar(tribeeInfo, ouroStore, z, z2, kTribeeCategory, toolbarItem, function1, function2, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void TribeeToolbar(final TribeeInfo tribeeInfo, final OuroStore ouroStore, final boolean showSyncToFollowing, final boolean syncToFollowing, final KTribeeCategory selectedCategory, final ToolbarItem activeItem, final Function1<? super ToolbarItem, Unit> function1, final Function2<? super TribeePublishAction, ? super Continuation<? super Unit>, ? extends Object> function2, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(tribeeInfo, "tribeeInfo");
        Intrinsics.checkNotNullParameter(ouroStore, "ouroStore");
        Intrinsics.checkNotNullParameter(function1, "onClickItem");
        Intrinsics.checkNotNullParameter(function2, "onTribeeAction");
        Composer $composer2 = $composer.startRestartGroup(1919951335);
        ComposerKt.sourceInformation($composer2, "C(TribeeToolbar)N(tribeeInfo,ouroStore,showSyncToFollowing,syncToFollowing,selectedCategory,activeItem,onClickItem,onTribeeAction,modifier)32@1250L24,34@1280L1301:TribeeToolbar.kt#vjrpu9");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(tribeeInfo) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(ouroStore) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(showSyncToFollowing) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(syncToFollowing) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer2.changedInstance(selectedCategory) ? 16384 : 8192;
        }
        if (($changed & 196608) == 0) {
            $dirty |= $composer2.changed(activeItem == null ? -1 : activeItem.ordinal()) ? 131072 : 65536;
        }
        if ((1572864 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 1048576 : 524288;
        }
        if ((12582912 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 8388608 : 4194304;
        }
        int i2 = i & 256;
        if (i2 != 0) {
            $dirty |= 100663296;
            modifier2 = modifier;
        } else if ((100663296 & $changed) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 67108864 : 33554432;
        } else {
            modifier2 = modifier;
        }
        if ($composer2.shouldExecute(($dirty & 38347923) != 38347922, $dirty & 1)) {
            modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1919951335, $dirty, -1, "kntr.app.tribee.publish.ui.v2.internal.TribeeToolbar (TribeeToolbar.kt:31)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer2, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object value$iv$iv = $composer2.rememberedValue();
            if (value$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2);
                $composer2.updateRememberedValue(value$iv$iv);
            }
            final CoroutineScope scope = (CoroutineScope) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            int $changed$iv = ($dirty >> 24) & 14;
            Modifier modifier$iv = modifier3;
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
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
            ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = (($changed$iv >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -286781271, "C35@1318L310,48@1846L718,43@1637L938:TribeeToolbar.kt#vjrpu9");
            Modifier materialized$iv$iv2 = SizeKt.fillMaxWidth$default(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(41)), 0.0f, 1, (Object) null);
            int $dirty2 = $dirty;
            TribeeInfoKt.TribeeInfo(tribeeInfo, selectedCategory, showSyncToFollowing, syncToFollowing, function2, materialized$iv$iv2, $composer2, ($dirty & 14) | 196608 | (($dirty >> 9) & 112) | ($dirty & 896) | ($dirty & 7168) | (($dirty >> 9) & 57344), 0);
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(48)), 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, -1256160641, "CC(remember):TribeeToolbar.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(scope) | $composer2.changedInstance(function2);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: kntr.app.tribee.publish.ui.v2.internal.TribeeToolbarKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        Unit TribeeToolbar$lambda$0$0$0;
                        TribeeToolbar$lambda$0$0$0 = TribeeToolbarKt.TribeeToolbar$lambda$0$0$0(scope, function2, (ToolbarTrackEvent) obj);
                        return TribeeToolbar$lambda$0$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ToolbarKt.Toolbar(ouroStore, activeItem, function1, fillMaxWidth$default, (Function1) it$iv, $composer2, (($dirty2 >> 3) & 14) | 3072 | (($dirty2 >> 12) & 112) | (($dirty2 >> 12) & 896), 0);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.publish.ui.v2.internal.TribeeToolbarKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeToolbar$lambda$1;
                    TribeeToolbar$lambda$1 = TribeeToolbarKt.TribeeToolbar$lambda$1(TribeeInfo.this, ouroStore, showSyncToFollowing, syncToFollowing, selectedCategory, activeItem, function1, function2, modifier4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeToolbar$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeToolbar$lambda$0$0$0(CoroutineScope $scope, Function2 $onTribeeAction, ToolbarTrackEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new TribeeToolbarKt$TribeeToolbar$1$1$1$1($onTribeeAction, it, null), 3, (Object) null);
        return Unit.INSTANCE;
    }
}