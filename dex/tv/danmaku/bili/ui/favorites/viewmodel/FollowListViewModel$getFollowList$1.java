package tv.danmaku.bili.ui.favorites.viewmodel;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.hotlist.model.HotListDataPacker;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FollowListViewModel.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.FollowListViewModel", f = "FollowListViewModel.kt", i = {0, 0, 1, 1}, l = {BR.bottomDisplay1, BR.constraintSetModifier}, m = "getFollowList", n = {"firstLoad", HotListDataPacker.METHOD_REFRESH, "$this$suspendThen$iv", "firstLoad"}, s = {"Z$0", "Z$1", "L$0", "Z$0"}, v = 1)
public final class FollowListViewModel$getFollowList$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    boolean Z$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FollowListViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FollowListViewModel$getFollowList$1(FollowListViewModel followListViewModel, Continuation<? super FollowListViewModel$getFollowList$1> continuation) {
        super(continuation);
        this.this$0 = followListViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        Object followList;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        followList = this.this$0.getFollowList(false, false, (Continuation) this);
        return followList;
    }
}