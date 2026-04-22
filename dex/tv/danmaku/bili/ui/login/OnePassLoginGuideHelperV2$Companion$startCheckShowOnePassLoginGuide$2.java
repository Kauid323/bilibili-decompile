package tv.danmaku.bili.ui.login;

import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.login.OnePassLoginGuideHelperV2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OnePassLoginGuideHelperV2.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.login.OnePassLoginGuideHelperV2$Companion", f = "OnePassLoginGuideHelperV2.kt", i = {0}, l = {776}, m = "startCheckShowOnePassLoginGuide", n = {"isStartUpFragment"}, s = {"Z$0"}, v = 1)
public final class OnePassLoginGuideHelperV2$Companion$startCheckShowOnePassLoginGuide$2 extends ContinuationImpl {
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OnePassLoginGuideHelperV2.Companion this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnePassLoginGuideHelperV2$Companion$startCheckShowOnePassLoginGuide$2(OnePassLoginGuideHelperV2.Companion companion, Continuation<? super OnePassLoginGuideHelperV2$Companion$startCheckShowOnePassLoginGuide$2> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.startCheckShowOnePassLoginGuide((String) null, false, (FragmentActivity) null, (Function1<? super Integer, Boolean>) null, (Continuation) this);
    }
}