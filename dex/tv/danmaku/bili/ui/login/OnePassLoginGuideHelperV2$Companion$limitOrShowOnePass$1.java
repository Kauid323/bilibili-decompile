package tv.danmaku.bili.ui.login;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.login.OnePassLoginGuideHelperV2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OnePassLoginGuideHelperV2.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.login.OnePassLoginGuideHelperV2$Companion", f = "OnePassLoginGuideHelperV2.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2}, l = {BR.followVisible, BR.hallEnterHotText, BR.highPrivilegedUser, BR.isVoiceMsg, BR.leftBtnBackDrawable, BR.matchSex}, m = "limitOrShowOnePass", n = {"fromSpmid", AudioIntentHelper.FROM_ACTIVITY, "fromVideo", "fromSpmid", AudioIntentHelper.FROM_ACTIVITY, "infoLogin", "fromVideo", "showSms", "fromSpmid", AudioIntentHelper.FROM_ACTIVITY, "infoLogin", "pair", "fromVideo", "showSms", "mLoginWay"}, s = {"L$0", "L$1", "Z$0", "L$0", "L$1", "L$2", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "I$0", "I$1"}, v = 1)
public final class OnePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OnePassLoginGuideHelperV2.Companion this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1(OnePassLoginGuideHelperV2.Companion companion, Continuation<? super OnePassLoginGuideHelperV2$Companion$limitOrShowOnePass$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    public final Object invokeSuspend(Object obj) {
        Object limitOrShowOnePass;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        limitOrShowOnePass = this.this$0.limitOrShowOnePass(null, null, false, (Continuation) this);
        return limitOrShowOnePass;
    }
}