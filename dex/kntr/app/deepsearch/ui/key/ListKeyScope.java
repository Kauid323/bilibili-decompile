package kntr.app.deepsearch.ui.key;

import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.bapis.bilibili.app.search.deepsearch.v1.KChatHistoryItem;
import com.bapis.bilibili.broadcast.message.deepsearch.KDeepSearchResponse;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.StringsKt;

/* compiled from: Key.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007JC\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00012\"\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00130\u0017¢\u0006\u0002\b\u0019¢\u0006\u0002\b\u001a¢\u0006\u0002\u0010\u001bJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÂ\u0003J\u001d\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\t\u0010#\u001a\u00020\fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006$"}, d2 = {"Lkntr/app/deepsearch/ui/key/ListKeyScope;", RoomRecommendViewModel.EMPTY_CURSOR, "lazyListScope", "Landroidx/compose/foundation/lazy/LazyListScope;", "startIndex", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Landroidx/compose/foundation/lazy/LazyListScope;I)V", "getLazyListScope", "()Landroidx/compose/foundation/lazy/LazyListScope;", "position", "fallbackId", RoomRecommendViewModel.EMPTY_CURSOR, "getFallbackId", "()Ljava/lang/String;", "endIndex", "getEndIndex", "()I", "item", RoomRecommendViewModel.EMPTY_CURSOR, "Lcom/bapis/bilibili/app/search/deepsearch/v1/KChatHistoryItem;", "contentType", "content", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/LazyItemScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Lcom/bapis/bilibili/app/search/deepsearch/v1/KChatHistoryItem;Ljava/lang/Object;Lkotlin/jvm/functions/Function4;)V", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "compose_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ListKeyScope {
    public static final int $stable = 8;
    private final String fallbackId;
    private final LazyListScope lazyListScope;
    private int position;
    private final int startIndex;

    private final int component2() {
        return this.startIndex;
    }

    public static /* synthetic */ ListKeyScope copy$default(ListKeyScope listKeyScope, LazyListScope lazyListScope, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            lazyListScope = listKeyScope.lazyListScope;
        }
        if ((i2 & 2) != 0) {
            i = listKeyScope.startIndex;
        }
        return listKeyScope.copy(lazyListScope, i);
    }

    public final LazyListScope component1() {
        return this.lazyListScope;
    }

    public final ListKeyScope copy(LazyListScope lazyListScope, int i) {
        Intrinsics.checkNotNullParameter(lazyListScope, "lazyListScope");
        return new ListKeyScope(lazyListScope, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ListKeyScope) {
            ListKeyScope listKeyScope = (ListKeyScope) obj;
            return Intrinsics.areEqual(this.lazyListScope, listKeyScope.lazyListScope) && this.startIndex == listKeyScope.startIndex;
        }
        return false;
    }

    public int hashCode() {
        return (this.lazyListScope.hashCode() * 31) + this.startIndex;
    }

    public String toString() {
        LazyListScope lazyListScope = this.lazyListScope;
        return "ListKeyScope(lazyListScope=" + lazyListScope + ", startIndex=" + this.startIndex + ")";
    }

    public ListKeyScope(LazyListScope lazyListScope, int startIndex) {
        Intrinsics.checkNotNullParameter(lazyListScope, "lazyListScope");
        this.lazyListScope = lazyListScope;
        this.startIndex = startIndex;
        this.fallbackId = String.valueOf(Random.Default.nextLong(Long.MAX_VALUE));
    }

    public /* synthetic */ ListKeyScope(LazyListScope lazyListScope, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(lazyListScope, (i2 & 2) != 0 ? 0 : i);
    }

    public final LazyListScope getLazyListScope() {
        return this.lazyListScope;
    }

    public final String getFallbackId() {
        return this.fallbackId;
    }

    public final int getEndIndex() {
        return this.startIndex + this.position;
    }

    public static /* synthetic */ void item$default(ListKeyScope listKeyScope, KChatHistoryItem kChatHistoryItem, Object obj, Function4 function4, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = null;
        }
        listKeyScope.item(kChatHistoryItem, obj, function4);
    }

    public final void item(KChatHistoryItem item, Object contentType, final Function4<? super LazyItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(function4, "content");
        final int index = this.startIndex + this.position;
        LazyListScope lazyListScope = this.lazyListScope;
        int i = this.position;
        this.position = i + 1;
        KDeepSearchResponse content = item.getContent();
        String queryId = content != null ? content.getQueryId() : null;
        String it = queryId;
        boolean z = false;
        if (it != null && (!StringsKt.isBlank(it))) {
            z = true;
        }
        String str = z ? queryId : null;
        if (str == null) {
            str = this.fallbackId;
        }
        lazyListScope.item(Key_androidKt.key(i, str), contentType, ComposableLambdaKt.composableLambdaInstance(-1128631528, true, new Function3() { // from class: kntr.app.deepsearch.ui.key.ListKeyScope$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit item$lambda$1;
                item$lambda$1 = ListKeyScope.item$lambda$1(function4, index, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return item$lambda$1;
            }
        }));
    }

    public static final Unit item$lambda$1(Function4 $content, int $index, LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C38@1103L14:Key.kt#rck5c5");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed($this$item) ? 4 : 2;
        }
        if (!$composer.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1128631528, $dirty, -1, "kntr.app.deepsearch.ui.key.ListKeyScope.item.<anonymous> (Key.kt:38)");
            }
            $content.invoke($this$item, Integer.valueOf($index), $composer, Integer.valueOf($dirty & 14));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}