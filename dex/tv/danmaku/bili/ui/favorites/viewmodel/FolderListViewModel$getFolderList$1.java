package tv.danmaku.bili.ui.favorites.viewmodel;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.hotlist.model.HotListDataPacker;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FolderListViewModel.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.FolderListViewModel", f = "FolderListViewModel.kt", i = {0, 1, 1}, l = {BR.bottomDisplay2, BR.cardHeight}, m = "getFolderList", n = {HotListDataPacker.METHOD_REFRESH, "$this$suspendThen$iv", HotListDataPacker.METHOD_REFRESH}, s = {"Z$0", "L$0", "Z$0"}, v = 1)
public final class FolderListViewModel$getFolderList$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FolderListViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FolderListViewModel$getFolderList$1(FolderListViewModel folderListViewModel, Continuation<? super FolderListViewModel$getFolderList$1> continuation) {
        super(continuation);
        this.this$0 = folderListViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        Object folderList;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        folderList = this.this$0.getFolderList(false, (Continuation) this);
        return folderList;
    }
}