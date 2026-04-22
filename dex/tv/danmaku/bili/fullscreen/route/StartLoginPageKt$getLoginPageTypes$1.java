package tv.danmaku.bili.fullscreen.route;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StartLoginPage.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.route.StartLoginPageKt", f = "StartLoginPage.kt", i = {0, 0, 0, 1, 1}, l = {BR.bgAlpha, BR.bgSrcVisible}, m = "getLoginPageTypes", n = {"context", FavoritesConstsKt.SPMID, "topMostType", "topMostType", "types"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1"}, v = 1)
public final class StartLoginPageKt$getLoginPageTypes$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StartLoginPageKt$getLoginPageTypes$1(Continuation<? super StartLoginPageKt$getLoginPageTypes$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return StartLoginPageKt.getLoginPageTypes(null, null, null, null, null, (Continuation) this);
    }
}