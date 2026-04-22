package kntr.base.localization;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* compiled from: ScopeUtils.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\"\u001b\u0010\u0000\u001a\u00020\u00018@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003\"\u001b\u0010\u0006\u001a\u00020\u00018@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\u0007\u0010\u0003¨\u0006\t"}, d2 = {"DefaultScope", "Lkotlinx/coroutines/CoroutineScope;", "getDefaultScope", "()Lkotlinx/coroutines/CoroutineScope;", "DefaultScope$delegate", "Lkotlin/Lazy;", "MainScope", "getMainScope", "MainScope$delegate", "localization_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ScopeUtilsKt {
    private static final Lazy DefaultScope$delegate = LazyKt.lazy(new Function0() { // from class: kntr.base.localization.ScopeUtilsKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            CoroutineScope DefaultScope_delegate$lambda$0;
            DefaultScope_delegate$lambda$0 = ScopeUtilsKt.DefaultScope_delegate$lambda$0();
            return DefaultScope_delegate$lambda$0;
        }
    });
    private static final Lazy MainScope$delegate = LazyKt.lazy(new Function0() { // from class: kntr.base.localization.ScopeUtilsKt$$ExternalSyntheticLambda1
        public final Object invoke() {
            CoroutineScope MainScope_delegate$lambda$0;
            MainScope_delegate$lambda$0 = ScopeUtilsKt.MainScope_delegate$lambda$0();
            return MainScope_delegate$lambda$0;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final CoroutineScope DefaultScope_delegate$lambda$0() {
        return CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getDefault()));
    }

    public static final CoroutineScope getDefaultScope() {
        return (CoroutineScope) DefaultScope$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CoroutineScope MainScope_delegate$lambda$0() {
        return CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate()));
    }

    public static final CoroutineScope getMainScope() {
        return (CoroutineScope) MainScope$delegate.getValue();
    }
}