package tv.danmaku.bili.ui.main2.mine;

import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.lib.homepage.mine.MenuGroup;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HomeUserCenterFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$scrollToAdapterPosition$2", f = "HomeUserCenterFragment.kt", i = {}, l = {2314}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class HomeUserCenterFragment$scrollToAdapterPosition$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $locationItemId;
    final /* synthetic */ IndexedValue<MenuGroup> $menuGroupWithIndex;
    final /* synthetic */ RecyclerView $outerRecyclerView;
    int label;
    final /* synthetic */ HomeUserCenterFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeUserCenterFragment$scrollToAdapterPosition$2(HomeUserCenterFragment homeUserCenterFragment, RecyclerView recyclerView, IndexedValue<? extends MenuGroup> indexedValue, long j, Continuation<? super HomeUserCenterFragment$scrollToAdapterPosition$2> continuation) {
        super(2, continuation);
        this.this$0 = homeUserCenterFragment;
        this.$outerRecyclerView = recyclerView;
        this.$menuGroupWithIndex = indexedValue;
        this.$locationItemId = j;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeUserCenterFragment$scrollToAdapterPosition$2(this.this$0, this.$outerRecyclerView, this.$menuGroupWithIndex, this.$locationItemId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HomeUserCenterFragment.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @DebugMetadata(c = "tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$scrollToAdapterPosition$2$1", f = "HomeUserCenterFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$scrollToAdapterPosition$2$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<Integer, Continuation<? super Boolean>, Object> {
        /* synthetic */ int I$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.I$0 = ((Number) obj).intValue();
            return anonymousClass1;
        }

        public final Object invoke(int i, Continuation<? super Boolean> continuation) {
            return create(Integer.valueOf(i), continuation).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke(((Number) obj).intValue(), (Continuation) obj2);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    int it = this.I$0;
                    return Boxing.boxBoolean(it != 0);
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final Object invokeSuspend(Object $result) {
        Flow scrollStateFlow;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                scrollStateFlow = this.this$0.scrollStateFlow(this.$outerRecyclerView);
                this.label = 1;
                if (FlowKt.takeWhile(scrollStateFlow, new AnonymousClass1(null)).collect(new AnonymousClass2(this.$menuGroupWithIndex, this.$locationItemId, this.$outerRecyclerView, this.this$0), (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HomeUserCenterFragment.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* renamed from: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$scrollToAdapterPosition$2$2  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass2<T> implements FlowCollector {
        final /* synthetic */ long $locationItemId;
        final /* synthetic */ IndexedValue<MenuGroup> $menuGroupWithIndex;
        final /* synthetic */ RecyclerView $outerRecyclerView;
        final /* synthetic */ HomeUserCenterFragment this$0;

        AnonymousClass2(IndexedValue<? extends MenuGroup> indexedValue, long j, RecyclerView recyclerView, HomeUserCenterFragment homeUserCenterFragment) {
            this.$menuGroupWithIndex = indexedValue;
            this.$locationItemId = j;
            this.$outerRecyclerView = recyclerView;
            this.this$0 = homeUserCenterFragment;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0039  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x005d  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x00dd  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x00e6 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:60:0x00e7  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object emit(int i, Continuation<? super Unit> continuation) {
            HomeUserCenterFragment$scrollToAdapterPosition$2$2$emit$1 homeUserCenterFragment$scrollToAdapterPosition$2$2$emit$1;
            AnonymousClass2 anonymousClass2;
            List $this$indexOfFirst$iv;
            RecyclerView menuRecyclerView;
            int i2;
            Object showTribeeRevisitPop;
            RecyclerView.LayoutManager layoutManager;
            View findViewByPosition;
            if (continuation instanceof HomeUserCenterFragment$scrollToAdapterPosition$2$2$emit$1) {
                homeUserCenterFragment$scrollToAdapterPosition$2$2$emit$1 = (HomeUserCenterFragment$scrollToAdapterPosition$2$2$emit$1) continuation;
                if ((homeUserCenterFragment$scrollToAdapterPosition$2$2$emit$1.label & Integer.MIN_VALUE) != 0) {
                    homeUserCenterFragment$scrollToAdapterPosition$2$2$emit$1.label -= Integer.MIN_VALUE;
                    Object $result = homeUserCenterFragment$scrollToAdapterPosition$2$2$emit$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (homeUserCenterFragment$scrollToAdapterPosition$2$2$emit$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            anonymousClass2 = this;
                            homeUserCenterFragment$scrollToAdapterPosition$2$2$emit$1.label = 1;
                            if (DelayKt.delay(200L, homeUserCenterFragment$scrollToAdapterPosition$2$2$emit$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $this$indexOfFirst$iv = ((MenuGroup) anonymousClass2.$menuGroupWithIndex.getValue()).itemList;
                            if ($this$indexOfFirst$iv != null) {
                                long j = anonymousClass2.$locationItemId;
                                int index$iv = 0;
                                Iterator it = $this$indexOfFirst$iv.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        Object item$iv = it.next();
                                        MenuGroup.Item item = (MenuGroup.Item) item$iv;
                                        MenuGroup.Item item2 = item.id == j ? 1 : null;
                                        if (item2 == null) {
                                            index$iv++;
                                        }
                                    } else {
                                        index$iv = -1;
                                    }
                                }
                                RecyclerView recyclerView = anonymousClass2.$outerRecyclerView;
                                IndexedValue<MenuGroup> indexedValue = anonymousClass2.$menuGroupWithIndex;
                                HomeUserCenterFragment homeUserCenterFragment = anonymousClass2.this$0;
                                int locationPosition = index$iv;
                                RecyclerView.LayoutManager layoutManager2 = recyclerView.getLayoutManager();
                                if (layoutManager2 == null || (findViewByPosition = layoutManager2.findViewByPosition(indexedValue.getIndex())) == null) {
                                    menuRecyclerView = null;
                                } else {
                                    menuRecyclerView = (RecyclerView) findViewByPosition.findViewById(R.id.item_recycle);
                                }
                                View popAnchor = (menuRecyclerView == null || (layoutManager = menuRecyclerView.getLayoutManager()) == null) ? null : layoutManager.findViewByPosition(locationPosition);
                                if (popAnchor != null) {
                                    Object $this$asTo$iv = menuRecyclerView.getLayoutManager();
                                    if ($this$asTo$iv != null) {
                                        GridLayoutManager gridLayoutManager = (GridLayoutManager) ($this$asTo$iv instanceof GridLayoutManager ? $this$asTo$iv : null);
                                        if (gridLayoutManager != null) {
                                            i2 = gridLayoutManager.getSpanCount();
                                            boolean z = locationPosition >= i2 / 2;
                                            homeUserCenterFragment$scrollToAdapterPosition$2$2$emit$1.label = 2;
                                            showTribeeRevisitPop = homeUserCenterFragment.showTribeeRevisitPop(popAnchor, z, homeUserCenterFragment$scrollToAdapterPosition$2$2$emit$1);
                                            if (showTribeeRevisitPop != coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                        }
                                    }
                                    i2 = 4;
                                    if (locationPosition >= i2 / 2) {
                                    }
                                    homeUserCenterFragment$scrollToAdapterPosition$2$2$emit$1.label = 2;
                                    showTribeeRevisitPop = homeUserCenterFragment.showTribeeRevisitPop(popAnchor, z, homeUserCenterFragment$scrollToAdapterPosition$2$2$emit$1);
                                    if (showTribeeRevisitPop != coroutine_suspended) {
                                    }
                                }
                            }
                            return Unit.INSTANCE;
                        case 1:
                            anonymousClass2 = this;
                            ResultKt.throwOnFailure($result);
                            $this$indexOfFirst$iv = ((MenuGroup) anonymousClass2.$menuGroupWithIndex.getValue()).itemList;
                            if ($this$indexOfFirst$iv != null) {
                            }
                            return Unit.INSTANCE;
                        case 2:
                            ResultKt.throwOnFailure($result);
                            return Unit.INSTANCE;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            homeUserCenterFragment$scrollToAdapterPosition$2$2$emit$1 = new HomeUserCenterFragment$scrollToAdapterPosition$2$2$emit$1(this, continuation);
            Object $result2 = homeUserCenterFragment$scrollToAdapterPosition$2$2$emit$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (homeUserCenterFragment$scrollToAdapterPosition$2$2$emit$1.label) {
            }
        }

        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
            return emit(((Number) value).intValue(), $completion);
        }
    }
}