package tv.danmaku.bili.ui.garb.nft;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.TimeoutKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.garb.nft.CardDataState;
import tv.danmaku.bili.ui.garb.nft.model.DLCCardDrawModel;
import tv.danmaku.bili.ui.garb.nft.util.DLCResDownloader;

/* compiled from: DLCDrawCardDataManager.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0012H\u0086@¢\u0006\u0002\u0010\u0015J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u0082@¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0014H\u0082@¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Ltv/danmaku/bili/ui/garb/nft/DLCDrawCardDataManager;", "", "fromResultView", "", "<init>", "(Z)V", "getFromResultView", "()Z", "setFromResultView", "resDownloader", "Ltv/danmaku/bili/ui/garb/nft/util/DLCResDownloader;", "getResDownloader", "()Ltv/danmaku/bili/ui/garb/nft/util/DLCResDownloader;", "resDownloader$delegate", "Lkotlin/Lazy;", "resSuccCount", "", "drawCardItem", "Ltv/danmaku/bili/ui/garb/nft/model/DLCCardDrawModel;", "requestData", "Ltv/danmaku/bili/ui/garb/nft/CardDataState;", "(Ltv/danmaku/bili/ui/garb/nft/model/DLCCardDrawModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadRes", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestDLCData", "setDrawCardItem", "", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DLCDrawCardDataManager {
    private static final long TIMEOUT = 3000;
    private DLCCardDrawModel drawCardItem;
    private boolean fromResultView;
    private final Lazy resDownloader$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.garb.nft.DLCDrawCardDataManager$$ExternalSyntheticLambda0
        public final Object invoke() {
            DLCResDownloader resDownloader_delegate$lambda$0;
            resDownloader_delegate$lambda$0 = DLCDrawCardDataManager.resDownloader_delegate$lambda$0();
            return resDownloader_delegate$lambda$0;
        }
    });
    private int resSuccCount;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final String TAG = Reflection.getOrCreateKotlinClass(DLCDrawCardDataManager.class).getSimpleName();

    public DLCDrawCardDataManager(boolean fromResultView) {
        this.fromResultView = fromResultView;
    }

    public final boolean getFromResultView() {
        return this.fromResultView;
    }

    public final void setFromResultView(boolean z) {
        this.fromResultView = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DLCResDownloader getResDownloader() {
        return (DLCResDownloader) this.resDownloader$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DLCResDownloader resDownloader_delegate$lambda$0() {
        return new DLCResDownloader();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object requestData(DLCCardDrawModel drawCardItem, Continuation<? super CardDataState> continuation) {
        DLCDrawCardDataManager$requestData$1 dLCDrawCardDataManager$requestData$1;
        Ref.ObjectRef state;
        if (continuation instanceof DLCDrawCardDataManager$requestData$1) {
            dLCDrawCardDataManager$requestData$1 = (DLCDrawCardDataManager$requestData$1) continuation;
            if ((dLCDrawCardDataManager$requestData$1.label & Integer.MIN_VALUE) != 0) {
                dLCDrawCardDataManager$requestData$1.label -= Integer.MIN_VALUE;
                Object $result = dLCDrawCardDataManager$requestData$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (dLCDrawCardDataManager$requestData$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        setDrawCardItem(drawCardItem);
                        state = new Ref.ObjectRef();
                        state.element = CardDataState.Timeout.INSTANCE;
                        dLCDrawCardDataManager$requestData$1.L$0 = state;
                        dLCDrawCardDataManager$requestData$1.label = 1;
                        if (CoroutineScopeKt.coroutineScope(new DLCDrawCardDataManager$requestData$2(state, this, null), dLCDrawCardDataManager$requestData$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        state = (Ref.ObjectRef) dLCDrawCardDataManager$requestData$1.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return state.element;
            }
        }
        dLCDrawCardDataManager$requestData$1 = new DLCDrawCardDataManager$requestData$1(this, continuation);
        Object $result2 = dLCDrawCardDataManager$requestData$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (dLCDrawCardDataManager$requestData$1.label) {
        }
        return state.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object downloadRes(Continuation<? super Boolean> continuation) {
        return TimeoutKt.withTimeoutOrNull(3000L, new DLCDrawCardDataManager$downloadRes$2(this, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object requestDLCData(Continuation<? super CardDataState> continuation) {
        return TimeoutKt.withTimeoutOrNull(3000L, new DLCDrawCardDataManager$requestDLCData$2(this, null), continuation);
    }

    private final void setDrawCardItem(DLCCardDrawModel drawCardItem) {
        this.drawCardItem = drawCardItem;
    }

    /* compiled from: DLCDrawCardDataManager.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/ui/garb/nft/DLCDrawCardDataManager$Companion;", "", "<init>", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "TIMEOUT", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG() {
            return DLCDrawCardDataManager.TAG;
        }
    }
}