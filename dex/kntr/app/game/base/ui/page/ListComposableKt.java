package kntr.app.game.base.ui.page;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListItemInfo;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kntr.app.game.base.router.RouterHelperKt;
import kntr.app.game.base.viewmodel.BaseListViewModel;
import kntr.app.game.base.viewmodel.PageLoadMoreState;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
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
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* compiled from: ListComposable.kt */
@Metadata(d1 = {"\u0000~\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0092\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u000b2:\b\u0002\u0010\u0019\u001a4\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020 \u0018\u00010\u001a2:\b\u0002\u0010!\u001a4\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001f\u0012\u0006\u0012\u0004\u0018\u00010 0\u001a2\"\b\u0002\u0010\"\u001a\u001c\u0012\u0004\u0012\u00020#\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020$\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001a2[\u0010%\u001aW\u0012\u0004\u0012\u00020'\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00010&¢\u0006\u0002\b(¢\u0006\u0002\b)H\u0007¢\u0006\u0002\u0010*\"\u000e\u0010+\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006,²\u0006\n\u0010-\u001a\u00020\u000bX\u008a\u0084\u0002"}, d2 = {"ListComposable", RoomRecommendViewModel.EMPTY_CURSOR, "Item", "VM", "Lkntr/app/game/base/viewmodel/BaseListViewModel;", "viewModel", RouterHelperKt.PARAM_SOURCE_FROM, RoomRecommendViewModel.EMPTY_CURSOR, "modifier", "Landroidx/compose/ui/Modifier;", "refreshEnable", RoomRecommendViewModel.EMPTY_CURSOR, "lazyLoad", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "itemKey", "Lkotlin/Function2;", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlin/ParameterName;", "name", "index", "item", RoomRecommendViewModel.EMPTY_CURSOR, "itemContentType", "onDataChange", "Lkotlinx/coroutines/CoroutineScope;", RoomRecommendViewModel.EMPTY_CURSOR, "itemContent", "Lkotlin/Function4;", "Landroidx/compose/foundation/lazy/LazyItemScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Lkntr/app/game/base/viewmodel/BaseListViewModel;Ljava/lang/String;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function6;Landroidx/compose/runtime/Composer;III)V", "FOOTER_KEY", "base-ui_debug", "reachEnd"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ListComposableKt {
    private static final String FOOTER_KEY = "footer";

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ListComposable$lambda$4(BaseListViewModel baseListViewModel, String str, Modifier modifier, boolean z, boolean z2, LazyListState lazyListState, PaddingValues paddingValues, boolean z3, Arrangement.Vertical vertical, Alignment.Horizontal horizontal, FlingBehavior flingBehavior, boolean z4, Function2 function2, Function2 function22, Function2 function23, Function6 function6, int i, int i2, int i3, Composer composer, int i4) {
        ListComposable(baseListViewModel, str, modifier, z, z2, lazyListState, paddingValues, z3, vertical, horizontal, flingBehavior, z4, function2, function22, function23, function6, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int ListComposable$lambda$0$0(int index, Object item) {
        return index;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v7 */
    public static final <Item, VM extends BaseListViewModel<Item>> void ListComposable(final VM vm, final String sourceFrom, Modifier modifier, boolean refreshEnable, boolean lazyLoad, LazyListState lazyListState, PaddingValues contentPadding, boolean reverseLayout, Arrangement.Vertical verticalArrangement, Alignment.Horizontal horizontalAlignment, FlingBehavior flingBehavior, boolean userScrollEnabled, Function2<? super Integer, ? super Item, ? extends Object> function2, Function2<? super Integer, ? super Item, ? extends Object> function22, Function2<? super CoroutineScope, ? super List<? extends Item>, Unit> function23, final Function6<? super LazyItemScope, ? super Item, ? super VM, ? super Integer, ? super Composer, ? super Integer, Unit> function6, Composer $composer, final int $changed, final int $changed1, final int i) {
        Composer $composer2;
        Modifier modifier2;
        boolean refreshEnable2;
        boolean reverseLayout2;
        LazyListState lazyListState2;
        PaddingValues contentPadding2;
        boolean reverseLayout3;
        Arrangement.Vertical verticalArrangement2;
        Alignment.Horizontal horizontalAlignment2;
        FlingBehavior flingBehavior2;
        boolean userScrollEnabled2;
        Function2 itemContentType;
        Function2 onDataChange;
        Function2 onDataChange2;
        Modifier modifier3;
        LazyListState lazyListState3;
        LazyListState lazyListState4;
        PaddingValues contentPadding3;
        Arrangement.Vertical verticalArrangement3;
        int $dirty;
        FlingBehavior flingBehavior3;
        FlingBehavior flingBehavior4;
        boolean userScrollEnabled3;
        Function2 itemKey;
        Function2 itemKey2;
        Function2 itemContentType2;
        LazyListState lazyListState5;
        boolean reverseLayout4;
        FlingBehavior flingBehavior5;
        boolean userScrollEnabled4;
        Function2 itemKey3;
        Function2 onDataChange3;
        Function2 itemContentType3;
        int $dirty1;
        PaddingValues contentPadding4;
        Alignment.Horizontal horizontalAlignment3;
        boolean refreshEnable3;
        Arrangement.Vertical verticalArrangement4;
        boolean lazyLoad2;
        Modifier modifier4;
        int $dirty2;
        int i2;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(vm, "viewModel");
        Intrinsics.checkNotNullParameter(function6, "itemContent");
        Composer $composer3 = $composer.startRestartGroup(2028861606);
        ComposerKt.sourceInformation($composer3, "C(ListComposable)N(viewModel,sourceFrom,modifier,refreshEnable,lazyLoad,lazyListState,contentPadding,reverseLayout,verticalArrangement,horizontalAlignment,flingBehavior,userScrollEnabled,itemKey,itemContentType,onDataChange,itemContent)62@2781L24,64@2833L156,76@3148L1802,71@2994L1956:ListComposable.kt#m4iljm");
        int $dirty3 = $changed;
        int $dirty12 = $changed1;
        if (($changed & 6) == 0) {
            $dirty3 |= ($changed & 8) == 0 ? $composer3.changed(vm) : $composer3.changedInstance(vm) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty3 |= $composer3.changed(sourceFrom) ? 32 : 16;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty3 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty3 |= $composer3.changed(modifier) ? 256 : 128;
        }
        int i6 = i & 8;
        if (i6 != 0) {
            $dirty3 |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty3 |= $composer3.changed(refreshEnable) ? 2048 : 1024;
        }
        int i7 = i & 16;
        if (i7 != 0) {
            $dirty3 |= 24576;
        } else if (($changed & 24576) == 0) {
            $dirty3 |= $composer3.changed(lazyLoad) ? 16384 : 8192;
        }
        if (($changed & 196608) == 0) {
            if ((i & 32) == 0 && $composer3.changed(lazyListState)) {
                i4 = 131072;
                $dirty3 |= i4;
            }
            i4 = 65536;
            $dirty3 |= i4;
        }
        int i8 = i & 64;
        if (i8 != 0) {
            $dirty3 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty3 |= $composer3.changed(contentPadding) ? 1048576 : 524288;
        }
        int i9 = i & 128;
        if (i9 != 0) {
            $dirty3 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty3 |= $composer3.changed(reverseLayout) ? 8388608 : 4194304;
        }
        if (($changed & 100663296) == 0) {
            if ((i & 256) == 0 && $composer3.changed(verticalArrangement)) {
                i3 = 67108864;
                $dirty3 |= i3;
            }
            i3 = 33554432;
            $dirty3 |= i3;
        }
        int i10 = i & 512;
        if (i10 != 0) {
            $dirty3 |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty3 |= $composer3.changed(horizontalAlignment) ? 536870912 : 268435456;
        }
        if (($changed1 & 6) == 0) {
            if ((i & 1024) == 0 && $composer3.changed(flingBehavior)) {
                i2 = 4;
                $dirty12 |= i2;
            }
            i2 = 2;
            $dirty12 |= i2;
        }
        int i11 = i & 2048;
        if (i11 != 0) {
            $dirty12 |= 48;
        } else if (($changed1 & 48) == 0) {
            $dirty12 |= $composer3.changed(userScrollEnabled) ? 32 : 16;
        }
        int i12 = i & 4096;
        if (i12 != 0) {
            $dirty12 |= 384;
        } else if (($changed1 & 384) == 0) {
            $dirty12 |= $composer3.changedInstance(function2) ? 256 : 128;
        }
        int i13 = i & 8192;
        if (i13 != 0) {
            $dirty12 |= 3072;
        } else if (($changed1 & 3072) == 0) {
            $dirty12 |= $composer3.changedInstance(function22) ? 2048 : 1024;
        }
        int i14 = i & 16384;
        if (i14 != 0) {
            $dirty12 |= 24576;
        } else if (($changed1 & 24576) == 0) {
            $dirty12 |= $composer3.changedInstance(function23) ? 16384 : 8192;
        }
        if (($changed1 & 196608) == 0) {
            $dirty12 |= $composer3.changedInstance(function6) ? 131072 : 65536;
        }
        if ($composer3.shouldExecute((($dirty3 & 306783379) == 306783378 && (74899 & $dirty12) == 74898) ? false : true, $dirty3 & 1)) {
            $composer3.startDefaults();
            ComposerKt.sourceInformation($composer3, "50@2051L23,55@2397L15,57@2503L24,58@2585L16");
            if (($changed & 1) == 0 || $composer3.getDefaultsInvalid()) {
                Modifier modifier5 = i5 != 0 ? (Modifier) Modifier.Companion : modifier;
                boolean refreshEnable4 = i6 != 0 ? true : refreshEnable;
                boolean lazyLoad3 = i7 != 0 ? false : lazyLoad;
                if ((i & 32) != 0) {
                    modifier3 = modifier5;
                    lazyListState3 = LazyListStateKt.rememberLazyListState(0, 0, $composer3, 0, 3);
                    $dirty3 &= -458753;
                } else {
                    modifier3 = modifier5;
                    lazyListState3 = lazyListState;
                }
                if (i8 != 0) {
                    lazyListState4 = lazyListState3;
                    contentPadding3 = PaddingKt.PaddingValues-0680j_4(Dp.constructor-impl(0));
                } else {
                    lazyListState4 = lazyListState3;
                    contentPadding3 = contentPadding;
                }
                boolean reverseLayout5 = i9 != 0 ? false : reverseLayout;
                if ((i & 256) != 0) {
                    Arrangement arrangement = Arrangement.INSTANCE;
                    verticalArrangement3 = !reverseLayout5 ? arrangement.getTop() : arrangement.getBottom();
                    $dirty3 &= -234881025;
                } else {
                    verticalArrangement3 = verticalArrangement;
                }
                Alignment.Horizontal horizontalAlignment4 = i10 != 0 ? Alignment.Companion.getStart() : horizontalAlignment;
                boolean reverseLayout6 = reverseLayout5;
                if ((i & 1024) != 0) {
                    $dirty = $dirty3;
                    flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior($composer3, ScrollableDefaults.$stable);
                    $dirty12 &= -15;
                } else {
                    $dirty = $dirty3;
                    flingBehavior3 = flingBehavior;
                }
                boolean userScrollEnabled5 = i11 != 0 ? true : userScrollEnabled;
                if (i12 != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer3, -179126946, "CC(remember):ListComposable.kt#9igjgp");
                    flingBehavior4 = flingBehavior3;
                    Object it$iv = $composer3.rememberedValue();
                    userScrollEnabled3 = userScrollEnabled5;
                    if (it$iv == Composer.Companion.getEmpty()) {
                        Object value$iv = new Function2() { // from class: kntr.app.game.base.ui.page.ListComposableKt$$ExternalSyntheticLambda3
                            public final Object invoke(Object obj, Object obj2) {
                                int ListComposable$lambda$0$0;
                                ListComposable$lambda$0$0 = ListComposableKt.ListComposable$lambda$0$0(((Integer) obj).intValue(), obj2);
                                return Integer.valueOf(ListComposable$lambda$0$0);
                            }
                        };
                        $composer3.updateRememberedValue(value$iv);
                        it$iv = value$iv;
                    }
                    itemKey = (Function2) it$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                } else {
                    flingBehavior4 = flingBehavior3;
                    userScrollEnabled3 = userScrollEnabled5;
                    itemKey = function2;
                }
                if (i13 != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer3, -179124330, "CC(remember):ListComposable.kt#9igjgp");
                    Object it$iv2 = $composer3.rememberedValue();
                    itemKey2 = itemKey;
                    if (it$iv2 == Composer.Companion.getEmpty()) {
                        Object value$iv2 = (Function2) new Function2() { // from class: kntr.app.game.base.ui.page.ListComposableKt$ListComposable$2$1
                            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                                return invoke(((Number) p1).intValue(), (int) p2);
                            }

                            public final Void invoke(int i15, Item item) {
                                return null;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv2);
                        it$iv2 = value$iv2;
                    }
                    itemContentType2 = it$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                } else {
                    itemKey2 = itemKey;
                    itemContentType2 = function22;
                }
                if (i14 != 0) {
                    lazyListState5 = lazyListState4;
                    reverseLayout4 = reverseLayout6;
                    flingBehavior5 = flingBehavior4;
                    userScrollEnabled4 = userScrollEnabled3;
                    itemKey3 = itemKey2;
                    itemContentType3 = itemContentType2;
                    onDataChange3 = null;
                    $dirty1 = $dirty12;
                    contentPadding4 = contentPadding3;
                    horizontalAlignment3 = horizontalAlignment4;
                    refreshEnable3 = refreshEnable4;
                    verticalArrangement4 = verticalArrangement3;
                    lazyLoad2 = lazyLoad3;
                    modifier4 = modifier3;
                    $dirty2 = $dirty;
                } else {
                    lazyListState5 = lazyListState4;
                    reverseLayout4 = reverseLayout6;
                    flingBehavior5 = flingBehavior4;
                    userScrollEnabled4 = userScrollEnabled3;
                    itemKey3 = itemKey2;
                    onDataChange3 = function23;
                    itemContentType3 = itemContentType2;
                    $dirty1 = $dirty12;
                    contentPadding4 = contentPadding3;
                    horizontalAlignment3 = horizontalAlignment4;
                    refreshEnable3 = refreshEnable4;
                    verticalArrangement4 = verticalArrangement3;
                    lazyLoad2 = lazyLoad3;
                    modifier4 = modifier3;
                    $dirty2 = $dirty;
                }
            } else {
                $composer3.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty3 &= -458753;
                }
                if ((i & 256) != 0) {
                    $dirty3 &= -234881025;
                }
                if ((i & 1024) != 0) {
                    modifier4 = modifier;
                    refreshEnable3 = refreshEnable;
                    lazyLoad2 = lazyLoad;
                    lazyListState5 = lazyListState;
                    contentPadding4 = contentPadding;
                    reverseLayout4 = reverseLayout;
                    verticalArrangement4 = verticalArrangement;
                    horizontalAlignment3 = horizontalAlignment;
                    flingBehavior5 = flingBehavior;
                    userScrollEnabled4 = userScrollEnabled;
                    itemKey3 = function2;
                    itemContentType3 = function22;
                    onDataChange3 = function23;
                    $dirty1 = $dirty12 & (-15);
                    $dirty2 = $dirty3;
                } else {
                    modifier4 = modifier;
                    refreshEnable3 = refreshEnable;
                    lazyLoad2 = lazyLoad;
                    lazyListState5 = lazyListState;
                    contentPadding4 = contentPadding;
                    reverseLayout4 = reverseLayout;
                    verticalArrangement4 = verticalArrangement;
                    horizontalAlignment3 = horizontalAlignment;
                    flingBehavior5 = flingBehavior;
                    userScrollEnabled4 = userScrollEnabled;
                    itemKey3 = function2;
                    itemContentType3 = function22;
                    onDataChange3 = function23;
                    $dirty2 = $dirty3;
                    $dirty1 = $dirty12;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2028861606, $dirty2, $dirty1, "kntr.app.game.base.ui.page.ListComposable (ListComposable.kt:61)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer3, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer3.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer3);
                $composer3.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            final CoroutineScope scope = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -179116254, "CC(remember):ListComposable.kt#9igjgp");
            Object it$iv3 = $composer3.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function0() { // from class: kntr.app.game.base.ui.page.ListComposableKt$$ExternalSyntheticLambda4
                    public final Object invoke() {
                        Job ListComposable$lambda$2$0;
                        ListComposable$lambda$2$0 = ListComposableKt.ListComposable$lambda$2$0(scope, vm);
                        return ListComposable$lambda$2$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            final Function0 loadMore = (Function0) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final Modifier modifier6 = modifier4;
            final LazyListState lazyListState6 = lazyListState5;
            final PaddingValues paddingValues = contentPadding4;
            final boolean z = reverseLayout4;
            final Arrangement.Vertical vertical = verticalArrangement4;
            final Alignment.Horizontal horizontal = horizontalAlignment3;
            final FlingBehavior flingBehavior6 = flingBehavior5;
            final boolean z2 = userScrollEnabled4;
            final Function2 function24 = itemKey3;
            final Function2 function25 = itemContentType3;
            final int $dirty4 = $dirty2;
            final Function2 function26 = onDataChange3;
            $composer2 = $composer3;
            LoadComposableKt.LoadComposable(vm, sourceFrom, null, refreshEnable3, lazyLoad2, ComposableLambdaKt.rememberComposableLambda(1920382923, true, new Function5() { // from class: kntr.app.game.base.ui.page.ListComposableKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
                    Unit ListComposable$lambda$3;
                    ListComposable$lambda$3 = ListComposableKt.ListComposable$lambda$3(modifier6, lazyListState6, paddingValues, z, vertical, horizontal, flingBehavior6, z2, function24, function25, function6, function26, $dirty4, loadMore, (List) obj, (BaseListViewModel) obj2, (PageLoadMoreState) obj3, (Composer) obj4, ((Integer) obj5).intValue());
                    return ListComposable$lambda$3;
                }
            }, $composer2, 54), $composer2, ($dirty4 & 8) | 196608 | ($dirty4 & 14) | ($dirty4 & 112) | ($dirty4 & 7168) | (57344 & $dirty4), 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            reverseLayout3 = reverseLayout4;
            userScrollEnabled2 = userScrollEnabled4;
            reverseLayout2 = lazyLoad2;
            horizontalAlignment2 = horizontalAlignment3;
            onDataChange2 = onDataChange3;
            contentPadding2 = contentPadding4;
            onDataChange = itemContentType3;
            refreshEnable2 = refreshEnable3;
            itemContentType = itemKey3;
            flingBehavior2 = flingBehavior5;
            verticalArrangement2 = verticalArrangement4;
            lazyListState2 = lazyListState5;
            modifier2 = modifier4;
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            refreshEnable2 = refreshEnable;
            reverseLayout2 = lazyLoad;
            lazyListState2 = lazyListState;
            contentPadding2 = contentPadding;
            reverseLayout3 = reverseLayout;
            verticalArrangement2 = verticalArrangement;
            horizontalAlignment2 = horizontalAlignment;
            flingBehavior2 = flingBehavior;
            userScrollEnabled2 = userScrollEnabled;
            itemContentType = function2;
            onDataChange = function22;
            onDataChange2 = function23;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier7 = modifier2;
            final boolean z3 = refreshEnable2;
            final boolean z4 = reverseLayout2;
            final LazyListState lazyListState7 = lazyListState2;
            final PaddingValues paddingValues2 = contentPadding2;
            final boolean z5 = reverseLayout3;
            final Arrangement.Vertical vertical2 = verticalArrangement2;
            final Alignment.Horizontal horizontal2 = horizontalAlignment2;
            final FlingBehavior flingBehavior7 = flingBehavior2;
            final boolean z6 = userScrollEnabled2;
            final Function2 function27 = itemContentType;
            final Function2 function28 = onDataChange;
            final Function2 function29 = onDataChange2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.base.ui.page.ListComposableKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit ListComposable$lambda$4;
                    ListComposable$lambda$4 = ListComposableKt.ListComposable$lambda$4(BaseListViewModel.this, sourceFrom, modifier7, z3, z4, lazyListState7, paddingValues2, z5, vertical2, horizontal2, flingBehavior7, z6, function27, function28, function29, function6, $changed, $changed1, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ListComposable$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Job ListComposable$lambda$2$0(CoroutineScope $scope, BaseListViewModel $viewModel) {
        return BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new ListComposableKt$ListComposable$loadMore$1$1$1($viewModel, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0157, code lost:
        if (r42.changedInstance(r41) != false) goto L30;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit ListComposable$lambda$3(Modifier $modifier, final LazyListState $lazyListState, PaddingValues $contentPadding, boolean $reverseLayout, Arrangement.Vertical $verticalArrangement, Alignment.Horizontal $horizontalAlignment, FlingBehavior $flingBehavior, boolean $userScrollEnabled, final Function2 $itemKey, final Function2 $itemContentType, final Function6 $itemContent, Function2 $onDataChange, final int $$dirty, final Function0 $loadMore, final List list, final BaseListViewModel viewModel, final PageLoadMoreState loadMoreState, Composer $composer, int $changed) {
        State reachEnd$delegate;
        String str;
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(loadMoreState, "loadMoreState");
        ComposerKt.sourceInformation($composer, "CN(list,viewModel,loadMoreState)77@3208L206,93@3673L546,84@3423L796,107@4325L508,107@4281L552,120@4888L56,120@4867L77:ListComposable.kt#m4iljm");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1920382923, $changed, -1, "kntr.app.game.base.ui.page.ListComposable.<anonymous> (ListComposable.kt:77)");
        }
        int size = list.size();
        ComposerKt.sourceInformationMarkerStart($composer, -1347946151, "CC(remember):ListComposable.kt#9igjgp");
        boolean invalid$iv = $composer.changed(size);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = SnapshotStateKt.derivedStateOf(new Function0() { // from class: kntr.app.game.base.ui.page.ListComposableKt$$ExternalSyntheticLambda0
                public final Object invoke() {
                    boolean ListComposable$lambda$3$0$0;
                    ListComposable$lambda$3$0$0 = ListComposableKt.ListComposable$lambda$3$0$0($lazyListState);
                    return Boolean.valueOf(ListComposable$lambda$3$0$0);
                }
            });
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        State reachEnd$delegate2 = (State) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, -1347930931, "CC(remember):ListComposable.kt#9igjgp");
        boolean z = true;
        boolean invalid$iv2 = $composer.changedInstance(list) | $composer.changed($itemKey) | $composer.changed($itemContentType) | $composer.changed($itemContent) | (((($changed & 112) ^ 48) > 32 && $composer.changedInstance(viewModel)) || ($changed & 48) == 32) | (((($changed & 896) ^ 384) > 256 && $composer.changedInstance(loadMoreState)) || ($changed & 384) == 256);
        Object value$iv2 = $composer.rememberedValue();
        if (invalid$iv2 || value$iv2 == Composer.Companion.getEmpty()) {
            reachEnd$delegate = reachEnd$delegate2;
            str = "CC(remember):ListComposable.kt#9igjgp";
            value$iv2 = new Function1() { // from class: kntr.app.game.base.ui.page.ListComposableKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    Unit ListComposable$lambda$3$2$0;
                    ListComposable$lambda$3$2$0 = ListComposableKt.ListComposable$lambda$3$2$0(list, $itemKey, $itemContentType, $itemContent, viewModel, $$dirty, loadMoreState, $loadMore, (LazyListScope) obj);
                    return ListComposable$lambda$3$2$0;
                }
            };
            $composer.updateRememberedValue(value$iv2);
        } else {
            reachEnd$delegate = reachEnd$delegate2;
            str = "CC(remember):ListComposable.kt#9igjgp";
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        LazyDslKt.LazyColumn($modifier, $lazyListState, $contentPadding, $reverseLayout, $verticalArrangement, $horizontalAlignment, $flingBehavior, $userScrollEnabled, (OverscrollEffect) null, (Function1) value$iv2, $composer, 0, 256);
        Boolean valueOf = Boolean.valueOf(ListComposable$lambda$3$1(reachEnd$delegate));
        Object orNull = CollectionsKt.getOrNull(list, 0);
        String str2 = str;
        ComposerKt.sourceInformationMarkerStart($composer, -1347910105, str2);
        State reachEnd$delegate3 = reachEnd$delegate;
        boolean changed = $composer.changed(reachEnd$delegate3);
        if ((($changed & 896) ^ 384) <= 256) {
        }
        if (($changed & 384) != 256) {
            z = false;
        }
        boolean invalid$iv3 = changed | z | $composer.changedInstance(list) | $composer.changed($lazyListState);
        Object value$iv3 = $composer.rememberedValue();
        if (invalid$iv3 || value$iv3 == Composer.Companion.getEmpty()) {
            value$iv3 = new ListComposableKt$ListComposable$3$2$1(loadMoreState, $loadMore, list, $lazyListState, reachEnd$delegate3, null);
            $composer.updateRememberedValue(value$iv3);
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.LaunchedEffect(valueOf, orNull, (Function2) value$iv3, $composer, 0);
        ComposerKt.sourceInformationMarkerStart($composer, -1347892541, str2);
        boolean invalid$iv4 = $composer.changed($onDataChange) | $composer.changedInstance(list);
        Object it$iv2 = $composer.rememberedValue();
        if (invalid$iv4 || it$iv2 == Composer.Companion.getEmpty()) {
            Object value$iv4 = (Function2) new ListComposableKt$ListComposable$3$3$1($onDataChange, list, null);
            $composer.updateRememberedValue(value$iv4);
            it$iv2 = value$iv4;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.LaunchedEffect(list, (Function2) it$iv2, $composer, $changed & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ListComposable$lambda$3$1(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ListComposable$lambda$3$0$0(LazyListState $lazyListState) {
        LazyListItemInfo lazyListItemInfo = (LazyListItemInfo) CollectionsKt.lastOrNull($lazyListState.getLayoutInfo().getVisibleItemsInfo());
        return Intrinsics.areEqual(lazyListItemInfo != null ? lazyListItemInfo.getKey() : null, FOOTER_KEY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ListComposable$lambda$3$2$0(final List $list, final Function2 $itemKey, final Function2 $itemContentType, final Function6 $itemContent, final BaseListViewModel $viewModel, final int $$dirty, final PageLoadMoreState $loadMoreState, final Function0 $loadMore, LazyListScope $this$LazyColumn) {
        Function1<Integer, Object> function1;
        Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
        int size = $list.size();
        if ($itemKey != null) {
            function1 = new Function1<Integer, Object>() { // from class: kntr.app.game.base.ui.page.ListComposableKt$ListComposable$lambda$3$2$0$$inlined$itemsIndexed$1
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    return invoke(((Number) p1).intValue());
                }

                public final Object invoke(int index) {
                    return $itemKey.invoke(Integer.valueOf(index), $list.get(index));
                }
            };
        } else {
            function1 = null;
        }
        $this$LazyColumn.items(size, function1, new Function1<Integer, Object>() { // from class: kntr.app.game.base.ui.page.ListComposableKt$ListComposable$lambda$3$2$0$$inlined$itemsIndexed$2
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).intValue());
            }

            public final Object invoke(int index) {
                return $itemContentType.invoke(Integer.valueOf(index), $list.get(index));
            }
        }, ComposableLambdaKt.composableLambdaInstance(2039820996, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: kntr.app.game.base.ui.page.ListComposableKt$ListComposable$lambda$3$2$0$$inlined$itemsIndexed$3
            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
                invoke((LazyItemScope) p1, ((Number) p2).intValue(), (Composer) p3, ((Number) p4).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope $this$items, int it, Composer $composer, int $changed) {
                ComposerKt.sourceInformation($composer, "CN(it)214@10668L26:LazyDsl.kt#428nma");
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
                    ComposerKt.traceEventStart(2039820996, $dirty, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:214)");
                }
                Object item = $list.get(it);
                int $changed2 = ($dirty & 14) | ($dirty & 112);
                $composer.startReplaceGroup(860780113);
                ComposerKt.sourceInformation($composer, "CN(index,item)*95@3765L35:ListComposable.kt#m4iljm");
                $itemContent.invoke($this$items, item, $viewModel, Integer.valueOf(it), $composer, Integer.valueOf(($changed2 & 14) | (($changed2 >> 3) & 112) | (($$dirty & 8) << 6) | (($changed2 << 6) & 7168)));
                $composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        $this$LazyColumn.item(FOOTER_KEY, "FOOTER", ComposableLambdaKt.composableLambdaInstance(-535225568, true, new Function3() { // from class: kntr.app.game.base.ui.page.ListComposableKt$$ExternalSyntheticLambda7
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit ListComposable$lambda$3$2$0$1;
                ListComposable$lambda$3$2$0$1 = ListComposableKt.ListComposable$lambda$3$2$0$1(PageLoadMoreState.this, $loadMore, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return ListComposable$lambda$3$2$0$1;
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ListComposable$lambda$3$2$0$1(PageLoadMoreState $loadMoreState, final Function0 $loadMore, LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C:ListComposable.kt#m4iljm");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-535225568, $changed, -1, "kntr.app.game.base.ui.page.ListComposable.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ListComposable.kt:98)");
            }
            if (Intrinsics.areEqual($loadMoreState, PageLoadMoreState.Companion.getIdle())) {
                $composer.startReplaceGroup(1044307469);
                ComposerKt.sourceInformation($composer, "99@3961L13");
                FooterLoadingViewKt.LoadingMore(null, $composer, 0, 1);
                $composer.endReplaceGroup();
            } else if (Intrinsics.areEqual($loadMoreState, PageLoadMoreState.Companion.getLoading())) {
                $composer.startReplaceGroup(1044309485);
                ComposerKt.sourceInformation($composer, "100@4024L13");
                FooterLoadingViewKt.LoadingMore(null, $composer, 0, 1);
                $composer.endReplaceGroup();
            } else if (Intrinsics.areEqual($loadMoreState, PageLoadMoreState.Companion.getNoMore())) {
                $composer.startReplaceGroup(1044311471);
                ComposerKt.sourceInformation($composer, "101@4086L15");
                FooterLoadingViewKt.LoadMoreEmpty(null, $composer, 0, 1);
                $composer.endReplaceGroup();
            } else {
                if (Intrinsics.areEqual($loadMoreState, PageLoadMoreState.Companion.getError())) {
                    $composer.startReplaceGroup(1044313500);
                    ComposerKt.sourceInformation($composer, "102@4163L14,102@4149L28");
                    ComposerKt.sourceInformationMarkerStart($composer, 1044313934, "CC(remember):ListComposable.kt#9igjgp");
                    Object it$iv = $composer.rememberedValue();
                    if (it$iv == Composer.Companion.getEmpty()) {
                        Object value$iv = new Function0() { // from class: kntr.app.game.base.ui.page.ListComposableKt$$ExternalSyntheticLambda2
                            public final Object invoke() {
                                Unit ListComposable$lambda$3$2$0$1$0$0;
                                ListComposable$lambda$3$2$0$1$0$0 = ListComposableKt.ListComposable$lambda$3$2$0$1$0$0($loadMore);
                                return ListComposable$lambda$3$2$0$1$0$0;
                            }
                        };
                        $composer.updateRememberedValue(value$iv);
                        it$iv = value$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    FooterLoadingViewKt.LoadMoreError(null, (Function0) it$iv, $composer, 48, 1);
                } else {
                    $composer.startReplaceGroup(-1990137534);
                }
                $composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ListComposable$lambda$3$2$0$1$0$0(Function0 $loadMore) {
        $loadMore.invoke();
        return Unit.INSTANCE;
    }
}