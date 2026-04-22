package tv.danmaku.bili.fullscreen.route;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StartLoginPage.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.route.StartLoginPageKt", f = "StartLoginPage.kt", i = {0, 0}, l = {BR.buttonWidths}, m = "getAllLoginPageTypes", n = {"displays", "preferredType"}, s = {"L$0", "L$1"}, v = 1)
public final class StartLoginPageKt$getAllLoginPageTypes$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StartLoginPageKt$getAllLoginPageTypes$1(Continuation<? super StartLoginPageKt$getAllLoginPageTypes$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return StartLoginPageKt.getAllLoginPageTypes(null, null, (Continuation) this);
    }
}