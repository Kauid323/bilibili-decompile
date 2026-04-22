package kntr.common.photonic.aphro.ui.component;

import android.app.Activity;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.router.Router;
import kntr.common.photonic.AlbumInfo;
import kntr.common.photonic.Asset;
import kntr.common.photonic.aphro.core.AphroAction;
import kntr.common.photonic.aphro.core.AphroState;
import kntr.common.photonic.aphro.ui.preview.ImagePreviewLauncher_androidKt;
import kntr.common.photonic.aphro.ui.preview.ImagePreviewType;
import kntr.common.photonic.aphro.ui.preview.model.PreviewableAssetKt;
import kntr.common.photonic.permission.PlatformContext_androidKt;
import kntr.common.router.RouterKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.uuid.Uuid;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: SelectedList.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\u001aQ\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u000e¨\u0006\u000f²\u0006\u0016\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005X\u008a\u0084\u0002²\u0006\f\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u008a\u008e\u0002"}, d2 = {"SelectedList", "", "state", "Lkntr/common/photonic/aphro/core/AphroState$AphroContent;", "onAction", "Lkotlin/Function1;", "Lkntr/common/photonic/aphro/core/AphroAction;", "modifier", "Landroidx/compose/ui/Modifier;", "hasBorder", "", "hasSelectBorder", "scrollState", "Landroidx/compose/foundation/lazy/LazyListState;", "(Lkntr/common/photonic/aphro/core/AphroState$AphroContent;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/runtime/Composer;II)V", "ui_debug", "handleOnAction", "selectResultMatchKey", ""}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class SelectedListKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectedList$lambda$6(AphroState.AphroContent aphroContent, Function1 function1, Modifier modifier, boolean z, boolean z2, LazyListState lazyListState, int i, int i2, Composer composer, int i3) {
        SelectedList(aphroContent, function1, modifier, z, z2, lazyListState, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SelectedList(final AphroState.AphroContent state, final Function1<? super AphroAction, Unit> function1, Modifier modifier, boolean hasBorder, boolean hasSelectBorder, LazyListState scrollState, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean hasBorder2;
        boolean hasSelectBorder2;
        LazyListState lazyListState;
        boolean hasBorder3;
        LazyListState scrollState2;
        boolean hasSelectBorder3;
        Modifier modifier3;
        Modifier modifier4;
        int $dirty;
        boolean invalid$iv;
        Object value$iv;
        Modifier modifier5;
        int i2;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(function1, "onAction");
        Composer $composer2 = $composer.startRestartGroup(-603386785);
        ComposerKt.sourceInformation($composer2, "C(SelectedList)N(state,onAction,modifier,hasBorder,hasSelectBorder,scrollState)45@1986L30,46@2049L42,47@2108L24,49@2175L399,49@2138L436,66@2800L1542,61@2580L1762:SelectedList.kt#gh748z");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(state) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty2 |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty2 |= 3072;
            hasBorder2 = hasBorder;
        } else if (($changed & 3072) == 0) {
            hasBorder2 = hasBorder;
            $dirty2 |= $composer2.changed(hasBorder2) ? 2048 : 1024;
        } else {
            hasBorder2 = hasBorder;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty2 |= 24576;
            hasSelectBorder2 = hasSelectBorder;
        } else if (($changed & 24576) == 0) {
            hasSelectBorder2 = hasSelectBorder;
            $dirty2 |= $composer2.changed(hasSelectBorder2) ? 16384 : 8192;
        } else {
            hasSelectBorder2 = hasSelectBorder;
        }
        if (($changed & 196608) == 0) {
            if ((i & 32) == 0) {
                lazyListState = scrollState;
                if ($composer2.changed(lazyListState)) {
                    i2 = 131072;
                    $dirty2 |= i2;
                }
            } else {
                lazyListState = scrollState;
            }
            i2 = 65536;
            $dirty2 |= i2;
        } else {
            lazyListState = scrollState;
        }
        if ($composer2.shouldExecute(($dirty2 & 74899) != 74898, $dirty2 & 1)) {
            $composer2.startDefaults();
            ComposerKt.sourceInformation($composer2, "43@1931L23");
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier modifier6 = i3 != 0 ? (Modifier) Modifier.Companion : modifier2;
                if (i4 != 0) {
                    hasBorder2 = true;
                }
                if (i5 != 0) {
                    hasSelectBorder2 = true;
                }
                if ((i & 32) != 0) {
                    modifier4 = modifier6;
                    scrollState2 = LazyListStateKt.rememberLazyListState(0, 0, $composer2, 0, 3);
                    hasBorder3 = hasBorder2;
                    hasSelectBorder3 = hasSelectBorder2;
                    $dirty = $dirty2 & (-458753);
                } else {
                    modifier4 = modifier6;
                    hasBorder3 = hasBorder2;
                    scrollState2 = lazyListState;
                    hasSelectBorder3 = hasSelectBorder2;
                    $dirty = $dirty2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                }
                modifier4 = modifier2;
                hasBorder3 = hasBorder2;
                scrollState2 = lazyListState;
                hasSelectBorder3 = hasSelectBorder2;
                $dirty = $dirty2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-603386785, $dirty, -1, "kntr.common.photonic.aphro.ui.component.SelectedList (SelectedList.kt:44)");
            }
            final State handleOnAction$delegate = SnapshotStateKt.rememberUpdatedState(function1, $composer2, ($dirty >> 3) & 14);
            ComposerKt.sourceInformationMarkerStart($composer2, -34103479, "CC(remember):SelectedList.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                MutableState mutableStateOf$default = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(mutableStateOf$default);
                it$iv = mutableStateOf$default;
            }
            final MutableState selectResultMatchKey$delegate = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
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
            String SelectedList$lambda$2 = SelectedList$lambda$2(selectResultMatchKey$delegate);
            ComposerKt.sourceInformationMarkerStart($composer2, -34099090, "CC(remember):SelectedList.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changed(handleOnAction$delegate);
            Object it$iv2 = $composer2.rememberedValue();
            if (!invalid$iv2 && it$iv2 != Composer.Companion.getEmpty()) {
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.LaunchedEffect(SelectedList$lambda$2, (Function2) it$iv2, $composer2, 0);
                Modifier modifier7 = PaddingKt.padding-VpY3zN4$default(modifier4, 0.0f, Dp.constructor-impl(10), 1, (Object) null);
                PaddingValues paddingValues = PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl(12), 0.0f, 2, (Object) null);
                Arrangement.Horizontal horizontal = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(12));
                ComposerKt.sourceInformationMarkerStart($composer2, -34077947, "CC(remember):SelectedList.kt#9igjgp");
                invalid$iv = (($dirty & 14) != 4) | (($dirty & 7168) != 2048) | ((57344 & $dirty) != 16384) | $composer2.changed(handleOnAction$delegate) | $composer2.changedInstance(scope);
                value$iv = $composer2.rememberedValue();
                if (!invalid$iv || value$iv == Composer.Companion.getEmpty()) {
                    final boolean z = hasBorder3;
                    final boolean z2 = hasSelectBorder3;
                    modifier5 = modifier4;
                    value$iv = new Function1() { // from class: kntr.common.photonic.aphro.ui.component.SelectedListKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            Unit SelectedList$lambda$5$0;
                            SelectedList$lambda$5$0 = SelectedListKt.SelectedList$lambda$5$0(AphroState.AphroContent.this, z, z2, handleOnAction$delegate, scope, selectResultMatchKey$delegate, (LazyListScope) obj);
                            return SelectedList$lambda$5$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                } else {
                    modifier5 = modifier4;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                LazyDslKt.LazyRow(modifier7, scrollState2, paddingValues, false, horizontal, (Alignment.Vertical) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) value$iv, $composer2, (($dirty >> 12) & 112) | 24960, 488);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier5;
            }
            Object value$iv2 = (Function2) new SelectedListKt$SelectedList$1$1(selectResultMatchKey$delegate, handleOnAction$delegate, null);
            $composer2.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(SelectedList$lambda$2, (Function2) it$iv2, $composer2, 0);
            Modifier modifier72 = PaddingKt.padding-VpY3zN4$default(modifier4, 0.0f, Dp.constructor-impl(10), 1, (Object) null);
            PaddingValues paddingValues2 = PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl(12), 0.0f, 2, (Object) null);
            Arrangement.Horizontal horizontal2 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(12));
            ComposerKt.sourceInformationMarkerStart($composer2, -34077947, "CC(remember):SelectedList.kt#9igjgp");
            invalid$iv = (($dirty & 14) != 4) | (($dirty & 7168) != 2048) | ((57344 & $dirty) != 16384) | $composer2.changed(handleOnAction$delegate) | $composer2.changedInstance(scope);
            value$iv = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            final boolean z3 = hasBorder3;
            final boolean z22 = hasSelectBorder3;
            modifier5 = modifier4;
            value$iv = new Function1() { // from class: kntr.common.photonic.aphro.ui.component.SelectedListKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit SelectedList$lambda$5$0;
                    SelectedList$lambda$5$0 = SelectedListKt.SelectedList$lambda$5$0(AphroState.AphroContent.this, z3, z22, handleOnAction$delegate, scope, selectResultMatchKey$delegate, (LazyListScope) obj);
                    return SelectedList$lambda$5$0;
                }
            };
            $composer2.updateRememberedValue(value$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LazyDslKt.LazyRow(modifier72, scrollState2, paddingValues2, false, horizontal2, (Alignment.Vertical) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) value$iv, $composer2, (($dirty >> 12) & 112) | 24960, 488);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier5;
        } else {
            $composer2.skipToGroupEnd();
            hasBorder3 = hasBorder2;
            scrollState2 = lazyListState;
            hasSelectBorder3 = hasSelectBorder2;
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier8 = modifier3;
            final boolean z4 = hasBorder3;
            final boolean z5 = hasSelectBorder3;
            final LazyListState lazyListState2 = scrollState2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.photonic.aphro.ui.component.SelectedListKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit SelectedList$lambda$6;
                    SelectedList$lambda$6 = SelectedListKt.SelectedList$lambda$6(AphroState.AphroContent.this, function1, modifier8, z4, z5, lazyListState2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SelectedList$lambda$6;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1<AphroAction, Unit> SelectedList$lambda$0(State<? extends Function1<? super AphroAction, Unit>> state) {
        Object thisObj$iv = state.getValue();
        return (Function1) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String SelectedList$lambda$2(MutableState<String> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (String) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectedList$lambda$5$0(final AphroState.AphroContent $state, final boolean $hasBorder, final boolean $hasSelectBorder, final State $handleOnAction$delegate, final CoroutineScope $scope, final MutableState $selectResultMatchKey$delegate, LazyListScope $this$LazyRow) {
        Intrinsics.checkNotNullParameter($this$LazyRow, "$this$LazyRow");
        final List items$iv = $state.getCurrentSelected();
        final Function1 key$iv = new Function1() { // from class: kntr.common.photonic.aphro.ui.component.SelectedListKt$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Object SelectedList$lambda$5$0$0;
                SelectedList$lambda$5$0$0 = SelectedListKt.SelectedList$lambda$5$0$0((Asset) obj);
                return SelectedList$lambda$5$0$0;
            }
        };
        final Function1 contentType$iv = new Function1() { // from class: kntr.common.photonic.aphro.ui.component.SelectedListKt$SelectedList$lambda$5$0$$inlined$items$default$1
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return m2277invoke((Asset) p1);
            }

            /* renamed from: invoke  reason: collision with other method in class */
            public final Void m2277invoke(Asset asset) {
                return null;
            }
        };
        $this$LazyRow.items(items$iv.size(), new Function1<Integer, Object>() { // from class: kntr.common.photonic.aphro.ui.component.SelectedListKt$SelectedList$lambda$5$0$$inlined$items$default$2
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).intValue());
            }

            public final Object invoke(int index) {
                return key$iv.invoke(items$iv.get(index));
            }
        }, new Function1<Integer, Object>() { // from class: kntr.common.photonic.aphro.ui.component.SelectedListKt$SelectedList$lambda$5$0$$inlined$items$default$3
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).intValue());
            }

            public final Object invoke(int index) {
                return contentType$iv.invoke(items$iv.get(index));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: kntr.common.photonic.aphro.ui.component.SelectedListKt$SelectedList$lambda$5$0$$inlined$items$default$4
            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
                invoke((LazyItemScope) p1, ((Number) p2).intValue(), (Composer) p3, ((Number) p4).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope $this$items, int it, Composer $composer, int $changed) {
                boolean z;
                boolean invalid$iv;
                ComposerKt.sourceInformation($composer, "CN(it)178@8834L22:LazyDsl.kt#428nma");
                int $dirty = $changed;
                if (($changed & 6) == 0) {
                    $dirty |= $composer.changed($this$items) ? 4 : 2;
                }
                if (($changed & 48) == 0) {
                    $dirty |= $composer.changed(it) ? 32 : 16;
                }
                if (!$composer.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
                    $composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(802480018, $dirty, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                }
                int $changed2 = $dirty & 14;
                final Asset item = (Asset) items$iv.get(it);
                $composer.startReplaceGroup(1433094938);
                ComposerKt.sourceInformation($composer, "CN(item)*71@2946L7,72@2988L20,77@3191L51,78@3275L1036,73@3021L1305:SelectedList.kt#gh748z");
                CompositionLocal this_$iv = RouterKt.getLocalRouter();
                ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume = $composer.consume(this_$iv);
                ComposerKt.sourceInformationMarkerEnd($composer);
                final Router router = (Router) consume;
                final Activity platformContext = PlatformContext_androidKt.getPlatformContext($composer, 0);
                boolean z2 = $hasBorder;
                boolean z3 = $hasSelectBorder;
                ComposerKt.sourceInformationMarkerStart($composer, 184783487, "CC(remember):SelectedList.kt#9igjgp");
                boolean invalid$iv2 = $composer.changed($handleOnAction$delegate) | $composer.changedInstance(item);
                Object value$iv = $composer.rememberedValue();
                if (invalid$iv2 || value$iv == Composer.Companion.getEmpty()) {
                    final State state = $handleOnAction$delegate;
                    value$iv = (Function0) new Function0<Unit>() { // from class: kntr.common.photonic.aphro.ui.component.SelectedListKt$SelectedList$2$1$2$1$1
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m2278invoke();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: collision with other method in class */
                        public final void m2278invoke() {
                            Function1 SelectedList$lambda$0;
                            SelectedList$lambda$0 = SelectedListKt.SelectedList$lambda$0(state);
                            SelectedList$lambda$0.invoke(new AphroAction.UnSelectAsset(Asset.this));
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                }
                Function0 function0 = (Function0) value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, 184787160, "CC(remember):SelectedList.kt#9igjgp");
                boolean invalid$iv3 = $composer.changedInstance($scope) | $composer.changedInstance(router) | $composer.changed($state) | $composer.changedInstance(item) | $composer.changedInstance(platformContext);
                Object value$iv2 = $composer.rememberedValue();
                if (invalid$iv3 || value$iv2 == Composer.Companion.getEmpty()) {
                    final CoroutineScope coroutineScope = $scope;
                    final MutableState mutableState = $selectResultMatchKey$delegate;
                    final AphroState.AphroContent aphroContent = $state;
                    z = z3;
                    invalid$iv = z2;
                    value$iv2 = new Function0<Unit>() { // from class: kntr.common.photonic.aphro.ui.component.SelectedListKt$SelectedList$2$1$2$2$1
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m2279invoke();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: collision with other method in class */
                        public final void m2279invoke() {
                            String key = Uuid.Companion.random().toString();
                            mutableState.setValue(key);
                            BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(router, aphroContent, key, platformContext, item, null), 3, (Object) null);
                        }

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* compiled from: SelectedList.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                        @DebugMetadata(c = "kntr.common.photonic.aphro.ui.component.SelectedListKt$SelectedList$2$1$2$2$1$1", f = "SelectedList.kt", i = {}, l = {83}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                        /* renamed from: kntr.common.photonic.aphro.ui.component.SelectedListKt$SelectedList$2$1$2$2$1$1  reason: invalid class name */
                        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ Asset $item;
                            final /* synthetic */ String $key;
                            final /* synthetic */ Activity $platformContext;
                            final /* synthetic */ Router $router;
                            final /* synthetic */ AphroState.AphroContent $state;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass1(Router router, AphroState.AphroContent aphroContent, String str, Activity activity, Asset asset, Continuation<? super AnonymousClass1> continuation) {
                                super(2, continuation);
                                this.$router = router;
                                this.$state = aphroContent;
                                this.$key = str;
                                this.$platformContext = activity;
                                this.$item = asset;
                            }

                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new AnonymousClass1(this.$router, this.$state, this.$key, this.$platformContext, this.$item, continuation);
                            }

                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                            }

                            public final Object invokeSuspend(Object $result) {
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (this.label) {
                                    case 0:
                                        ResultKt.throwOnFailure($result);
                                        Router router = this.$router;
                                        Iterable $this$map$iv = this.$state.getCurrentSelected();
                                        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                                        for (Object item$iv$iv : $this$map$iv) {
                                            Asset it = (Asset) item$iv$iv;
                                            destination$iv$iv.add(PreviewableAssetKt.asPreviewableAsset$default(it, null, null, false, 7, null));
                                        }
                                        ArrayList arrayList = (List) destination$iv$iv;
                                        List $this$indexOfFirst$iv = this.$state.getCurrentSelected();
                                        Asset asset = this.$item;
                                        int index$iv = 0;
                                        Iterator<Asset> it2 = $this$indexOfFirst$iv.iterator();
                                        while (true) {
                                            if (it2.hasNext()) {
                                                Object item$iv = it2.next();
                                                Asset it3 = (Asset) item$iv;
                                                if (!(it3 == asset)) {
                                                    index$iv++;
                                                }
                                            } else {
                                                index$iv = -1;
                                            }
                                        }
                                        ImagePreviewType.Gallery gallery = new ImagePreviewType.Gallery(this.$state.getCurrentSelected(), this.$state.getUseOriginImage(), this.$state.getOption(), this.$key);
                                        Activity activity = this.$platformContext;
                                        AlbumInfo selectedAlbum = this.$state.getSelectedAlbum();
                                        String id = selectedAlbum != null ? selectedAlbum.getId() : null;
                                        this.label = 1;
                                        if (ImagePreviewLauncher_androidKt.launchImagePreview(router, arrayList, index$iv, gallery, activity, id, (Continuation) this) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        break;
                                    case 1:
                                        ResultKt.throwOnFailure($result);
                                        break;
                                    default:
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                return Unit.INSTANCE;
                            }
                        }
                    };
                    $composer.updateRememberedValue(value$iv2);
                } else {
                    z = z3;
                    invalid$iv = z2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                SelectedBottomRowKt.SelectedMediaItem(invalid$iv, z, item, function0, (Function0) value$iv2, null, false, $composer, ($changed2 << 3) & 896, 96);
                $composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object SelectedList$lambda$5$0$0(Asset it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getIdentifier();
    }
}