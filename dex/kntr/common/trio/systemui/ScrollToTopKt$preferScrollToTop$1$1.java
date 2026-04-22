package kntr.common.trio.systemui;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.ScrollExtensionsKt;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ScrollToTop.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.trio.systemui.ScrollToTopKt$preferScrollToTop$1$1", f = "ScrollToTop.kt", i = {}, l = {32}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ScrollToTopKt$preferScrollToTop$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<LayoutCoordinates> $layoutCoordinates$delegate;
    final /* synthetic */ Flow<Unit> $scrollToTopRequestFlow;
    final /* synthetic */ ScrollableState $state;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollToTopKt$preferScrollToTop$1$1(Flow<Unit> flow, ScrollableState scrollableState, MutableState<LayoutCoordinates> mutableState, Continuation<? super ScrollToTopKt$preferScrollToTop$1$1> continuation) {
        super(2, continuation);
        this.$scrollToTopRequestFlow = flow;
        this.$state = scrollableState;
        this.$layoutCoordinates$delegate = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ScrollToTopKt$preferScrollToTop$1$1(this.$scrollToTopRequestFlow, this.$state, this.$layoutCoordinates$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ScrollToTop.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* renamed from: kntr.common.trio.systemui.ScrollToTopKt$preferScrollToTop$1$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class AnonymousClass1<T> implements FlowCollector {
        final /* synthetic */ MutableState<LayoutCoordinates> $layoutCoordinates$delegate;
        final /* synthetic */ ScrollableState $state;

        AnonymousClass1(ScrollableState scrollableState, MutableState<LayoutCoordinates> mutableState) {
            this.$state = scrollableState;
            this.$layoutCoordinates$delegate = mutableState;
        }

        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
            return emit((Unit) value, (Continuation<? super Unit>) $completion);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0050  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0069  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0080  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x019a A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:53:0x019b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object emit(Unit it, Continuation<? super Unit> continuation) {
            ScrollToTopKt$preferScrollToTop$1$1$1$emit$1 scrollToTopKt$preferScrollToTop$1$1$1$emit$1;
            LayoutCoordinates snapLayoutCoordinates;
            Rect parentBounds;
            Rect itemBounds;
            int i;
            int idx;
            LayoutCoordinates snapLayoutCoordinates2;
            Unit it2;
            if (continuation instanceof ScrollToTopKt$preferScrollToTop$1$1$1$emit$1) {
                scrollToTopKt$preferScrollToTop$1$1$1$emit$1 = (ScrollToTopKt$preferScrollToTop$1$1$1$emit$1) continuation;
                if ((scrollToTopKt$preferScrollToTop$1$1$1$emit$1.label & Integer.MIN_VALUE) != 0) {
                    scrollToTopKt$preferScrollToTop$1$1$1$emit$1.label -= Integer.MIN_VALUE;
                    Object $result = scrollToTopKt$preferScrollToTop$1$1$1$emit$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (scrollToTopKt$preferScrollToTop$1$1$1$emit$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            snapLayoutCoordinates = ScrollToTopKt.preferScrollToTop$lambda$1(this.$layoutCoordinates$delegate);
                            if (snapLayoutCoordinates != null) {
                                LayoutCoordinates parentCoordinates = snapLayoutCoordinates.getParentCoordinates();
                                int i2 = 0;
                                parentBounds = parentCoordinates != null ? LayoutCoordinatesKt.boundsInWindow$default(parentCoordinates, false, 1, (Object) null) : null;
                                itemBounds = LayoutCoordinatesKt.boundsInWindow$default(snapLayoutCoordinates, false, 1, (Object) null);
                                if (parentBounds != null && parentBounds.overlaps(itemBounds)) {
                                    i2 = 1;
                                }
                                i = i2;
                                if (i != 0) {
                                    ScrollableState scrollableState = this.$state;
                                    if (scrollableState instanceof ScrollState) {
                                        scrollToTopKt$preferScrollToTop$1$1$1$emit$1.L$0 = SpillingKt.nullOutSpilledVariable(it);
                                        scrollToTopKt$preferScrollToTop$1$1$1$emit$1.L$1 = SpillingKt.nullOutSpilledVariable(snapLayoutCoordinates);
                                        scrollToTopKt$preferScrollToTop$1$1$1$emit$1.L$2 = SpillingKt.nullOutSpilledVariable(parentBounds);
                                        scrollToTopKt$preferScrollToTop$1$1$1$emit$1.L$3 = SpillingKt.nullOutSpilledVariable(itemBounds);
                                        scrollToTopKt$preferScrollToTop$1$1$1$emit$1.I$0 = i;
                                        scrollToTopKt$preferScrollToTop$1$1$1$emit$1.label = 1;
                                        return ScrollExtensionsKt.animateScrollBy$default(this.$state, ((float) this.$state.getValue()) * (-1.0f), (AnimationSpec) null, scrollToTopKt$preferScrollToTop$1$1$1$emit$1, 2, (Object) null) == coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
                                    }
                                    boolean isVisible = scrollableState instanceof LazyListState;
                                    if (isVisible) {
                                        idx = this.$state.getFirstVisibleItemIndex();
                                        if (idx < 100) {
                                            scrollToTopKt$preferScrollToTop$1$1$1$emit$1.L$0 = SpillingKt.nullOutSpilledVariable(it);
                                            scrollToTopKt$preferScrollToTop$1$1$1$emit$1.L$1 = SpillingKt.nullOutSpilledVariable(snapLayoutCoordinates);
                                            scrollToTopKt$preferScrollToTop$1$1$1$emit$1.L$2 = SpillingKt.nullOutSpilledVariable(parentBounds);
                                            scrollToTopKt$preferScrollToTop$1$1$1$emit$1.L$3 = SpillingKt.nullOutSpilledVariable(itemBounds);
                                            scrollToTopKt$preferScrollToTop$1$1$1$emit$1.I$0 = i;
                                            scrollToTopKt$preferScrollToTop$1$1$1$emit$1.I$1 = idx;
                                            scrollToTopKt$preferScrollToTop$1$1$1$emit$1.label = 2;
                                            return LazyListState.animateScrollToItem$default(this.$state, 0, 0, scrollToTopKt$preferScrollToTop$1$1$1$emit$1, 2, (Object) null) == coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
                                        }
                                        scrollToTopKt$preferScrollToTop$1$1$1$emit$1.L$0 = SpillingKt.nullOutSpilledVariable(it);
                                        scrollToTopKt$preferScrollToTop$1$1$1$emit$1.L$1 = SpillingKt.nullOutSpilledVariable(snapLayoutCoordinates);
                                        scrollToTopKt$preferScrollToTop$1$1$1$emit$1.L$2 = SpillingKt.nullOutSpilledVariable(parentBounds);
                                        scrollToTopKt$preferScrollToTop$1$1$1$emit$1.L$3 = SpillingKt.nullOutSpilledVariable(itemBounds);
                                        scrollToTopKt$preferScrollToTop$1$1$1$emit$1.I$0 = i;
                                        scrollToTopKt$preferScrollToTop$1$1$1$emit$1.I$1 = idx;
                                        scrollToTopKt$preferScrollToTop$1$1$1$emit$1.label = 3;
                                        if (LazyListState.scrollToItem$default(this.$state, 99, 0, scrollToTopKt$preferScrollToTop$1$1$1$emit$1, 2, (Object) null) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        snapLayoutCoordinates2 = snapLayoutCoordinates;
                                        it2 = it;
                                        scrollToTopKt$preferScrollToTop$1$1$1$emit$1.L$0 = SpillingKt.nullOutSpilledVariable(it2);
                                        scrollToTopKt$preferScrollToTop$1$1$1$emit$1.L$1 = SpillingKt.nullOutSpilledVariable(snapLayoutCoordinates2);
                                        scrollToTopKt$preferScrollToTop$1$1$1$emit$1.L$2 = SpillingKt.nullOutSpilledVariable(parentBounds);
                                        scrollToTopKt$preferScrollToTop$1$1$1$emit$1.L$3 = SpillingKt.nullOutSpilledVariable(itemBounds);
                                        scrollToTopKt$preferScrollToTop$1$1$1$emit$1.I$0 = i;
                                        scrollToTopKt$preferScrollToTop$1$1$1$emit$1.I$1 = idx;
                                        scrollToTopKt$preferScrollToTop$1$1$1$emit$1.label = 4;
                                        if (LazyListState.animateScrollToItem$default(this.$state, 0, 0, scrollToTopKt$preferScrollToTop$1$1$1$emit$1, 2, (Object) null) != coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    }
                                    KLog_androidKt.getKLog().e("kntr.common.trio.systemuicontroller", "Unsupported ScrollableState type: " + this.$state);
                                }
                            }
                            return Unit.INSTANCE;
                        case 1:
                            int idx2 = scrollToTopKt$preferScrollToTop$1$1$1$emit$1.I$0;
                            Rect rect = (Rect) scrollToTopKt$preferScrollToTop$1$1$1$emit$1.L$3;
                            Rect rect2 = (Rect) scrollToTopKt$preferScrollToTop$1$1$1$emit$1.L$2;
                            LayoutCoordinates layoutCoordinates = (LayoutCoordinates) scrollToTopKt$preferScrollToTop$1$1$1$emit$1.L$1;
                            Unit unit = (Unit) scrollToTopKt$preferScrollToTop$1$1$1$emit$1.L$0;
                            ResultKt.throwOnFailure($result);
                        case 2:
                        case 4:
                            int idx3 = scrollToTopKt$preferScrollToTop$1$1$1$emit$1.I$1;
                            int i3 = scrollToTopKt$preferScrollToTop$1$1$1$emit$1.I$0;
                            Rect rect3 = (Rect) scrollToTopKt$preferScrollToTop$1$1$1$emit$1.L$3;
                            Rect rect4 = (Rect) scrollToTopKt$preferScrollToTop$1$1$1$emit$1.L$2;
                            LayoutCoordinates layoutCoordinates2 = (LayoutCoordinates) scrollToTopKt$preferScrollToTop$1$1$1$emit$1.L$1;
                            Unit unit2 = (Unit) scrollToTopKt$preferScrollToTop$1$1$1$emit$1.L$0;
                            ResultKt.throwOnFailure($result);
                        case 3:
                            int idx4 = scrollToTopKt$preferScrollToTop$1$1$1$emit$1.I$1;
                            int i4 = scrollToTopKt$preferScrollToTop$1$1$1$emit$1.I$0;
                            ResultKt.throwOnFailure($result);
                            idx = idx4;
                            i = i4;
                            itemBounds = (Rect) scrollToTopKt$preferScrollToTop$1$1$1$emit$1.L$3;
                            parentBounds = (Rect) scrollToTopKt$preferScrollToTop$1$1$1$emit$1.L$2;
                            snapLayoutCoordinates2 = (LayoutCoordinates) scrollToTopKt$preferScrollToTop$1$1$1$emit$1.L$1;
                            it2 = (Unit) scrollToTopKt$preferScrollToTop$1$1$1$emit$1.L$0;
                            scrollToTopKt$preferScrollToTop$1$1$1$emit$1.L$0 = SpillingKt.nullOutSpilledVariable(it2);
                            scrollToTopKt$preferScrollToTop$1$1$1$emit$1.L$1 = SpillingKt.nullOutSpilledVariable(snapLayoutCoordinates2);
                            scrollToTopKt$preferScrollToTop$1$1$1$emit$1.L$2 = SpillingKt.nullOutSpilledVariable(parentBounds);
                            scrollToTopKt$preferScrollToTop$1$1$1$emit$1.L$3 = SpillingKt.nullOutSpilledVariable(itemBounds);
                            scrollToTopKt$preferScrollToTop$1$1$1$emit$1.I$0 = i;
                            scrollToTopKt$preferScrollToTop$1$1$1$emit$1.I$1 = idx;
                            scrollToTopKt$preferScrollToTop$1$1$1$emit$1.label = 4;
                            if (LazyListState.animateScrollToItem$default(this.$state, 0, 0, scrollToTopKt$preferScrollToTop$1$1$1$emit$1, 2, (Object) null) != coroutine_suspended) {
                            }
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            scrollToTopKt$preferScrollToTop$1$1$1$emit$1 = new ScrollToTopKt$preferScrollToTop$1$1$1$emit$1(this, continuation);
            Object $result2 = scrollToTopKt$preferScrollToTop$1$1$1$emit$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (scrollToTopKt$preferScrollToTop$1$1$1$emit$1.label) {
            }
        }
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (this.$scrollToTopRequestFlow.collect(new AnonymousClass1(this.$state, this.$layoutCoordinates$delegate), (Continuation) this) == coroutine_suspended) {
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