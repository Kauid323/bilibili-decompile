package kntr.common.komponent;

import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyLists.kt */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a`\u0010\u0000\u001a\u00020\u0001\"\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u000223\b\u0004\u0010\u0006\u001a-\u0012\u0004\u0012\u00020\b\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\u000b¢\u0006\u0002\b\fH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\r\u001af\u0010\u000e\u001a\u00020\u0001\"\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u0003*\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u001023\b\u0004\u0010\u0011\u001a-\u0012\u0004\u0012\u00020\b\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\u000b¢\u0006\u0002\b\fH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a{\u0010\u0013\u001a\u00020\u0001\"\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u0003*\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00102H\b\u0004\u0010\u0011\u001aB\u0012\u0004\u0012\u00020\b\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b\u000b¢\u0006\u0002\b\fH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0017\u001a&\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u001a0\u00192\u0010\u0010\u000f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0010H\u0001\u001a(\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u00192\u0010\u0010\u000f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0010H\u0001\u001aQ\u0010\u001c\u001a\u00020\u0001\"\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u00022$\b\u0004\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\u000b¢\u0006\u0002\b\fH\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\r\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001d"}, d2 = {"itemComposableLike", "", "Ui", "Lkntr/common/komponent/UiComposableLike;", "Landroidx/compose/foundation/lazy/LazyListScope;", "item", "content", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/LazyItemScope;", "Lkotlin/ParameterName;", "name", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/LazyListScope;Lkntr/common/komponent/UiComposableLike;Lkotlin/jvm/functions/Function4;)V", "itemsComposableLike", "items", "", "itemContent", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function4;)V", "itemsComposableLikeIndexed", "Lkotlin/Function3;", "", "index", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function5;)V", "keySelector", "Lkotlin/Function1;", "", "contentTypeSelector", "stickyHeaderComposableLike", "komponent_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class LazyListsKt {
    public static final <Ui extends UiComposableLike<?>> void itemComposableLike(LazyListScope $this$itemComposableLike, final Ui ui, final Function4<? super LazyItemScope, ? super Ui, ? super Composer, ? super Integer, Unit> function4) {
        Intrinsics.checkNotNullParameter($this$itemComposableLike, "<this>");
        Intrinsics.checkNotNullParameter(ui, "item");
        Intrinsics.checkNotNullParameter(function4, "content");
        $this$itemComposableLike.item(ui.getKey(), ui.getContentType(), ComposableLambdaKt.composableLambdaInstance(-253424457, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: kntr.common.komponent.LazyListsKt$itemComposableLike$1
            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
                invoke((LazyItemScope) p1, (Composer) p2, ((Number) p3).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope $this$item, Composer $composer, int $changed) {
                Intrinsics.checkNotNullParameter($this$item, "$this$item");
                ComposerKt.sourceInformation($composer, "C12@472L13:LazyLists.kt#vxw63z");
                int $dirty = $changed;
                if (($changed & 6) == 0) {
                    $dirty |= $composer.changed($this$item) ? 4 : 2;
                }
                if (!$composer.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
                    $composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-253424457, $dirty, -1, "kntr.common.komponent.itemComposableLike.<anonymous> (LazyLists.kt:12)");
                }
                function4.invoke($this$item, ui, $composer, Integer.valueOf($dirty & 14));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
    }

    public static final <Ui extends UiComposableLike<?>> void itemsComposableLike(LazyListScope $this$itemsComposableLike, final List<? extends Ui> list, final Function4<? super LazyItemScope, ? super Ui, ? super Composer, ? super Integer, Unit> function4) {
        Intrinsics.checkNotNullParameter($this$itemsComposableLike, "<this>");
        Intrinsics.checkNotNullParameter(list, "items");
        Intrinsics.checkNotNullParameter(function4, "itemContent");
        $this$itemsComposableLike.items(list.size(), keySelector(list), contentTypeSelector(list), ComposableLambdaKt.composableLambdaInstance(-1515008303, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: kntr.common.komponent.LazyListsKt$itemsComposableLike$1
            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
                invoke((LazyItemScope) p1, ((Number) p2).intValue(), (Composer) p3, ((Number) p4).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope $this$items, int index, Composer $composer, int $changed) {
                Intrinsics.checkNotNullParameter($this$items, "$this$items");
                ComposerKt.sourceInformation($composer, "CN(index)25@816L25:LazyLists.kt#vxw63z");
                int $dirty = $changed;
                if (($changed & 6) == 0) {
                    $dirty |= $composer.changed($this$items) ? 4 : 2;
                }
                if (($changed & 48) == 0) {
                    $dirty |= $composer.changed(index) ? 32 : 16;
                }
                if (!$composer.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
                    $composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1515008303, $dirty, -1, "kntr.common.komponent.itemsComposableLike.<anonymous> (LazyLists.kt:25)");
                }
                function4.invoke($this$items, list.get(index), $composer, Integer.valueOf($dirty & 14));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
    }

    public static final <Ui extends UiComposableLike<?>> void itemsComposableLikeIndexed(LazyListScope $this$itemsComposableLikeIndexed, final List<? extends Ui> list, final Function5<? super LazyItemScope, ? super Integer, ? super Ui, ? super Composer, ? super Integer, Unit> function5) {
        Intrinsics.checkNotNullParameter($this$itemsComposableLikeIndexed, "<this>");
        Intrinsics.checkNotNullParameter(list, "items");
        Intrinsics.checkNotNullParameter(function5, "itemContent");
        $this$itemsComposableLikeIndexed.items(list.size(), keySelector(list), contentTypeSelector(list), ComposableLambdaKt.composableLambdaInstance(1890868249, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: kntr.common.komponent.LazyListsKt$itemsComposableLikeIndexed$1
            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
                invoke((LazyItemScope) p1, ((Number) p2).intValue(), (Composer) p3, ((Number) p4).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope $this$items, int index, Composer $composer, int $changed) {
                Intrinsics.checkNotNullParameter($this$items, "$this$items");
                ComposerKt.sourceInformation($composer, "CN(index)38@1191L32:LazyLists.kt#vxw63z");
                int $dirty = $changed;
                if (($changed & 6) == 0) {
                    $dirty |= $composer.changed($this$items) ? 4 : 2;
                }
                if (($changed & 48) == 0) {
                    $dirty |= $composer.changed(index) ? 32 : 16;
                }
                if (!$composer.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
                    $composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1890868249, $dirty, -1, "kntr.common.komponent.itemsComposableLikeIndexed.<anonymous> (LazyLists.kt:38)");
                }
                function5.invoke($this$items, Integer.valueOf(index), list.get(index), $composer, Integer.valueOf(($dirty & 14) | ($dirty & 112)));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
    }

    public static final Function1<Integer, Object> keySelector(final List<? extends UiComposableLike<?>> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        return new Function1() { // from class: kntr.common.komponent.LazyListsKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Object keySelector$lambda$0;
                keySelector$lambda$0 = LazyListsKt.keySelector$lambda$0(list, ((Integer) obj).intValue());
                return keySelector$lambda$0;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object keySelector$lambda$0(List $items, int index) {
        return ((UiComposableLike) $items.get(index)).getKey();
    }

    public static final Function1<Integer, Object> contentTypeSelector(final List<? extends UiComposableLike<?>> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        return new Function1() { // from class: kntr.common.komponent.LazyListsKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Object contentTypeSelector$lambda$0;
                contentTypeSelector$lambda$0 = LazyListsKt.contentTypeSelector$lambda$0(list, ((Integer) obj).intValue());
                return contentTypeSelector$lambda$0;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object contentTypeSelector$lambda$0(List $items, int index) {
        return ((UiComposableLike) $items.get(index)).getContentType();
    }

    public static final <Ui extends UiComposableLike<?>> void stickyHeaderComposableLike(LazyListScope $this$stickyHeaderComposableLike, final Ui ui, final Function4<? super LazyItemScope, ? super Ui, ? super Composer, ? super Integer, Unit> function4) {
        Intrinsics.checkNotNullParameter($this$stickyHeaderComposableLike, "<this>");
        Intrinsics.checkNotNullParameter(ui, "item");
        Intrinsics.checkNotNullParameter(function4, "content");
        $this$stickyHeaderComposableLike.stickyHeader(ui.getKey(), ui.getContentType(), ComposableLambdaKt.composableLambdaInstance(-694940242, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: kntr.common.komponent.LazyListsKt$stickyHeaderComposableLike$1
            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
                invoke((LazyItemScope) p1, ((Number) p2).intValue(), (Composer) p3, ((Number) p4).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope $this$stickyHeader, int it, Composer $composer, int $changed) {
                Intrinsics.checkNotNullParameter($this$stickyHeader, "$this$stickyHeader");
                ComposerKt.sourceInformation($composer, "CN(it)60@1768L13:LazyLists.kt#vxw63z");
                int $dirty = $changed;
                if (($changed & 6) == 0) {
                    $dirty |= $composer.changed($this$stickyHeader) ? 4 : 2;
                }
                if (!$composer.shouldExecute(($dirty & 131) != 130, $dirty & 1)) {
                    $composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-694940242, $dirty, -1, "kntr.common.komponent.stickyHeaderComposableLike.<anonymous> (LazyLists.kt:60)");
                }
                function4.invoke($this$stickyHeader, ui, $composer, Integer.valueOf($dirty & 14));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
    }
}