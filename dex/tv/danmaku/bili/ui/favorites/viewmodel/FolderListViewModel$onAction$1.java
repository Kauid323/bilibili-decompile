package tv.danmaku.bili.ui.favorites.viewmodel;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.state.FolderAction;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FolderListViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.FolderListViewModel$onAction$1", f = "FolderListViewModel.kt", i = {}, l = {BR.coverWidth, BR.currentBannerItemPos}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class FolderListViewModel$onAction$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FolderAction $action;
    int label;
    final /* synthetic */ FolderListViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FolderListViewModel$onAction$1(FolderAction folderAction, FolderListViewModel folderListViewModel, Continuation<? super FolderListViewModel$onAction$1> continuation) {
        super(2, continuation);
        this.$action = folderAction;
        this.this$0 = folderListViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FolderListViewModel$onAction$1(this.$action, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object top;
        Object folderList;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                FolderAction folderAction = this.$action;
                if (folderAction instanceof FolderAction.Load) {
                    this.label = 1;
                    folderList = this.this$0.getFolderList(((FolderAction.Load) this.$action).isRefresh(), (Continuation) this);
                    if (folderList == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (folderAction instanceof FolderAction.ToTop) {
                    this.label = 2;
                    top = this.this$0.setTop(((FolderAction.ToTop) this.$action).getData(), (Continuation) this);
                    if (top == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (folderAction instanceof FolderAction.SwitchLayoutType) {
                    this.this$0.updateFolderLayoutType();
                    break;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            case 2:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}