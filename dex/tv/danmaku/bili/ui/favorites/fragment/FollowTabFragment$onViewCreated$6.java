package tv.danmaku.bili.ui.favorites.fragment;

import com.bilibili.app.comm.list.common.widget.PromoToast;
import com.bilibili.magicasakura.widgets.TintConstraintLayout;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.fragment.FollowTabFragment$onViewCreated$6;
import tv.danmaku.bili.ui.favorites.state.FollowEvent;

/* compiled from: FollowTabFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.favorites.fragment.FollowTabFragment$onViewCreated$6", f = "FollowTabFragment.kt", i = {}, l = {BR.dynamicDamakuNum}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class FollowTabFragment$onViewCreated$6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FollowTabFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FollowTabFragment$onViewCreated$6(FollowTabFragment followTabFragment, Continuation<? super FollowTabFragment$onViewCreated$6> continuation) {
        super(2, continuation);
        this.this$0 = followTabFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FollowTabFragment$onViewCreated$6(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FollowTabFragment.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* renamed from: tv.danmaku.bili.ui.favorites.fragment.FollowTabFragment$onViewCreated$6$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass1<T> implements FlowCollector {
        final /* synthetic */ FollowTabFragment this$0;

        AnonymousClass1(FollowTabFragment followTabFragment) {
            this.this$0 = followTabFragment;
        }

        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
            return emit((FollowEvent) value, (Continuation<? super Unit>) $completion);
        }

        public final Object emit(FollowEvent it, Continuation<? super Unit> continuation) {
            if (it instanceof FollowEvent.ShowDeletedToast) {
                PromoToast.showMidToast(this.this$0.getActivity(), ((FollowEvent.ShowDeletedToast) it).getSuccess() ? "删除成功" : "删除失败");
            } else if (!Intrinsics.areEqual(it, FollowEvent.ScrollToTop.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            } else {
                TintConstraintLayout root = this.this$0.getBinding().getRoot();
                final FollowTabFragment followTabFragment = this.this$0;
                Boxing.boxBoolean(root.post(new Runnable() { // from class: tv.danmaku.bili.ui.favorites.fragment.FollowTabFragment$onViewCreated$6$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        FollowTabFragment$onViewCreated$6.AnonymousClass1.emit$lambda$0(FollowTabFragment.this);
                    }
                }));
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void emit$lambda$0(FollowTabFragment this$0) {
            this$0.getBinding().recyclerView.scrollToPosition(0);
        }
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (this.this$0.getViewModel().getUiEventFlow().collect(new AnonymousClass1(this.this$0), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        throw new KotlinNothingValueException();
    }
}