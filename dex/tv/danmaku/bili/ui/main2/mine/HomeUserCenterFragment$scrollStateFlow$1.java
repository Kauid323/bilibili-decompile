package tv.danmaku.bili.ui.main2.mine;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HomeUserCenterFragment.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", ""}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$scrollStateFlow$1", f = "HomeUserCenterFragment.kt", i = {}, l = {2300}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class HomeUserCenterFragment$scrollStateFlow$1 extends SuspendLambda implements Function2<ProducerScope<? super Integer>, Continuation<? super Unit>, Object> {
    final /* synthetic */ RecyclerView $this_scrollStateFlow;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeUserCenterFragment$scrollStateFlow$1(RecyclerView recyclerView, Continuation<? super HomeUserCenterFragment$scrollStateFlow$1> continuation) {
        super(2, continuation);
        this.$this_scrollStateFlow = recyclerView;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> homeUserCenterFragment$scrollStateFlow$1 = new HomeUserCenterFragment$scrollStateFlow$1(this.$this_scrollStateFlow, continuation);
        homeUserCenterFragment$scrollStateFlow$1.L$0 = obj;
        return homeUserCenterFragment$scrollStateFlow$1;
    }

    public final Object invoke(ProducerScope<? super Integer> producerScope, Continuation<? super Unit> continuation) {
        return create(producerScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$scrollStateFlow$1$listener$1] */
    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final ProducerScope $this$callbackFlow = (ProducerScope) this.L$0;
                final ?? r2 = new RecyclerView.OnScrollListener() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$scrollStateFlow$1$listener$1
                    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                        $this$callbackFlow.trySend-JP2dKIU(Integer.valueOf(newState));
                    }
                };
                this.$this_scrollStateFlow.addOnScrollListener((RecyclerView.OnScrollListener) r2);
                final RecyclerView recyclerView = this.$this_scrollStateFlow;
                this.label = 1;
                if (ProduceKt.awaitClose($this$callbackFlow, new Function0() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$scrollStateFlow$1$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = HomeUserCenterFragment$scrollStateFlow$1.invokeSuspend$lambda$0(recyclerView, r2);
                        return invokeSuspend$lambda$0;
                    }
                }, (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(RecyclerView $this_scrollStateFlow, HomeUserCenterFragment$scrollStateFlow$1$listener$1 $listener) {
        $this_scrollStateFlow.removeOnScrollListener($listener);
        return Unit.INSTANCE;
    }
}