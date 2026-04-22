package tv.danmaku.bili.ui.login.helper;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import tv.danmaku.bili.BR;

/* compiled from: QuickLoginHelper.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\nJ(\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0004\b\r\u0010\nJ\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0015À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/login/helper/QuickLoginCheckReducer;", "", "check", "Ltv/danmaku/bili/ui/login/helper/AutoLoginCheckResult;", "context", "Landroid/content/Context;", "fromSpmid", "", "data", "Ltv/danmaku/bili/ui/login/helper/AutoLoginData;", "(Landroid/content/Context;Ljava/lang/String;Ltv/danmaku/bili/ui/login/helper/AutoLoginData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "beforeCheck", "Ltv/danmaku/bili/ui/login/helper/Skip;", "beforeCheck-5k-lyPk", "afterCheck", "", "result", "(Ljava/lang/String;Ltv/danmaku/bili/ui/login/helper/AutoLoginCheckResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "TAG", "getTAG", "()Ljava/lang/String;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface QuickLoginCheckReducer {
    Object afterCheck(String str, AutoLoginCheckResult autoLoginCheckResult, Continuation<? super Unit> continuation);

    /* renamed from: beforeCheck-5k-lyPk  reason: not valid java name */
    Object mo1802beforeCheck5klyPk(Context context, String str, AutoLoginData autoLoginData, Continuation<? super Skip> continuation);

    Object check(Context context, String str, AutoLoginData autoLoginData, Continuation<? super AutoLoginCheckResult> continuation);

    String getTAG();

    /* compiled from: QuickLoginHelper.kt */
    /* renamed from: tv.danmaku.bili.ui.login.helper.QuickLoginCheckReducer$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public final /* synthetic */ class CC {
        /* renamed from: beforeCheck-5k-lyPk$suspendImpl  reason: not valid java name */
        public static /* synthetic */ Object m1804beforeCheck5klyPk$suspendImpl(QuickLoginCheckReducer $this, Context context, String fromSpmid, AutoLoginData data, Continuation<? super Skip> continuation) {
            return Skip.m1805boximpl(Skip.m1806constructorimpl(false));
        }

        public static /* synthetic */ Object afterCheck$suspendImpl(QuickLoginCheckReducer $this, String fromSpmid, AutoLoginCheckResult result, Continuation<? super Unit> continuation) {
            return Unit.INSTANCE;
        }

        public static String $default$getTAG(QuickLoginCheckReducer _this) {
            return "QuickLoginCheckReducer";
        }
    }
}