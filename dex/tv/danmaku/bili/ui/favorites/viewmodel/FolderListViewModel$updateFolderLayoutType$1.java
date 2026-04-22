package tv.danmaku.bili.ui.favorites.viewmodel;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.state.FolderEvent;
import tv.danmaku.bili.ui.favorites.util.FavoritesFolderUtilsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FolderListViewModel.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Ltv/danmaku/bili/ui/favorites/state/FolderEvent;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.FolderListViewModel$updateFolderLayoutType$1", f = "FolderListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class FolderListViewModel$updateFolderLayoutType$1 extends SuspendLambda implements Function1<Continuation<? super FolderEvent>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FolderListViewModel$updateFolderLayoutType$1(Continuation<? super FolderListViewModel$updateFolderLayoutType$1> continuation) {
        super(1, continuation);
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new FolderListViewModel$updateFolderLayoutType$1(continuation);
    }

    public final Object invoke(Continuation<? super FolderEvent> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                return new FolderEvent.UpdateLayoutType(FavoritesFolderUtilsKt.compactLayoutType());
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}