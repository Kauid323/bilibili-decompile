package tv.danmaku.bili.ui.favorites.viewmodel;

import com.bilibili.okretro.BaseResponse;
import com.bilibili.okretro.GeneralResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.state.FolderEvent;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FolderListViewModel.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/bilibili/okretro/GeneralResponse;", "Lcom/bilibili/okretro/BaseResponse;", "it", ""}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.FolderListViewModel$setTop$3", f = "FolderListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class FolderListViewModel$setTop$3 extends SuspendLambda implements Function3<FlowCollector<? super GeneralResponse<BaseResponse>>, Throwable, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FolderListViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FolderListViewModel$setTop$3(FolderListViewModel folderListViewModel, Continuation<? super FolderListViewModel$setTop$3> continuation) {
        super(3, continuation);
        this.this$0 = folderListViewModel;
    }

    public final Object invoke(FlowCollector<? super GeneralResponse<BaseResponse>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        FolderListViewModel$setTop$3 folderListViewModel$setTop$3 = new FolderListViewModel$setTop$3(this.this$0, continuation);
        folderListViewModel$setTop$3.L$0 = th;
        return folderListViewModel$setTop$3.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                Throwable it = (Throwable) this.L$0;
                BLog.i("FolderListViewModel", "set Top failed:" + it.getMessage());
                this.this$0.sendEffect(new AnonymousClass1(null));
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FolderListViewModel.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Ltv/danmaku/bili/ui/favorites/state/FolderEvent;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.FolderListViewModel$setTop$3$1", f = "FolderListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.ui.favorites.viewmodel.FolderListViewModel$setTop$3$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super FolderEvent>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        public final Object invoke(Continuation<? super FolderEvent> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    return new FolderEvent.ShowAddTopToast(false);
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}