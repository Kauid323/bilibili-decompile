package kntr.app.ad.ad.biz.pegasus;

import kntr.app.ad.domain.click.ClickArg;
import kntr.app.ad.domain.click.ClickService;
import kntr.app.ad.domain.click.Clicker;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* compiled from: AdPegasusCardViewModel.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lkntr/app/ad/ad/biz/pegasus/AdPegasusCardViewModel;", RoomRecommendViewModel.EMPTY_CURSOR, "clickerService", "Lkntr/app/ad/domain/click/ClickService;", "<init>", "(Lkntr/app/ad/domain/click/ClickService;)V", "getClickerService", "()Lkntr/app/ad/domain/click/ClickService;", "setClickerService", "scope", "Lkotlinx/coroutines/CoroutineScope;", "clicker", "Lkntr/app/ad/domain/click/Clicker;", "getClicker", "()Lkntr/app/ad/domain/click/Clicker;", "clicker$delegate", "Lkotlin/Lazy;", "onClickCard", RoomRecommendViewModel.EMPTY_CURSOR, "arg", "Lkntr/app/ad/domain/click/ClickArg;", "pegasus_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AdPegasusCardViewModel {
    private ClickService clickerService;
    private final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
    private final Lazy clicker$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.ad.ad.biz.pegasus.AdPegasusCardViewModel$$ExternalSyntheticLambda0
        public final Object invoke() {
            Clicker clicker_delegate$lambda$0;
            clicker_delegate$lambda$0 = AdPegasusCardViewModel.clicker_delegate$lambda$0(AdPegasusCardViewModel.this);
            return clicker_delegate$lambda$0;
        }
    });

    public AdPegasusCardViewModel(ClickService clickerService) {
        this.clickerService = clickerService;
    }

    public final ClickService getClickerService() {
        return this.clickerService;
    }

    public final void setClickerService(ClickService clickService) {
        this.clickerService = clickService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Clicker getClicker() {
        return (Clicker) this.clicker$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Clicker clicker_delegate$lambda$0(AdPegasusCardViewModel this$0) {
        ClickService it = this$0.clickerService;
        if (it != null) {
            return new Clicker(it);
        }
        return null;
    }

    public final void onClickCard(ClickArg arg) {
        Intrinsics.checkNotNullParameter(arg, "arg");
        BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new AdPegasusCardViewModel$onClickCard$1(this, arg, null), 3, (Object) null);
    }
}