package tv.danmaku.bili.appwidget.hotlist;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import tv.danmaku.bili.BR;

/* compiled from: StateNotice.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001b\u0010\u0000\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"USER_DATA_INSTANCE", "Ltv/danmaku/bili/appwidget/hotlist/StateNotice;", "getUSER_DATA_INSTANCE", "()Ltv/danmaku/bili/appwidget/hotlist/StateNotice;", "USER_DATA_INSTANCE$delegate", "Lkotlin/Lazy;", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class StateNoticeKt {
    private static final Lazy USER_DATA_INSTANCE$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.appwidget.hotlist.StateNoticeKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            StateNotice USER_DATA_INSTANCE_delegate$lambda$0;
            USER_DATA_INSTANCE_delegate$lambda$0 = StateNoticeKt.USER_DATA_INSTANCE_delegate$lambda$0();
            return USER_DATA_INSTANCE_delegate$lambda$0;
        }
    });

    public static final StateNotice getUSER_DATA_INSTANCE() {
        return (StateNotice) USER_DATA_INSTANCE$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StateNotice USER_DATA_INSTANCE_delegate$lambda$0() {
        return new StateNotice();
    }
}