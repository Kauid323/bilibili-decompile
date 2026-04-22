package tv.danmaku.bili.ui.main2.mine.fansachievement;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FansAchievementHelper.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.main2.mine.fansachievement.FansAchievementHelper", f = "FansAchievementHelper.kt", i = {}, l = {BR.btnBgColor}, m = "reportDisplay", n = {}, s = {}, v = 1)
public final class FansAchievementHelper$reportDisplay$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FansAchievementHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FansAchievementHelper$reportDisplay$1(FansAchievementHelper fansAchievementHelper, Continuation<? super FansAchievementHelper$reportDisplay$1> continuation) {
        super(continuation);
        this.this$0 = fansAchievementHelper;
    }

    public final Object invokeSuspend(Object obj) {
        Object reportDisplay;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        reportDisplay = this.this$0.reportDisplay(null, (Continuation) this);
        return reportDisplay;
    }
}