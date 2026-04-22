package tv.danmaku.bili.ui.clipboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.bilibili.homepage.InterestChoseService;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.opd.app.bizcommon.hybridruntime.utils.ProcessUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.clipboard.ClipboardResp;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ClipboardChecker.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.clipboard.ClipboardChecker$observer$1$1", f = "ClipboardChecker.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ClipboardChecker$observer$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $coldStart;
    final /* synthetic */ RecognizeResult $result;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClipboardChecker$observer$1$1(RecognizeResult recognizeResult, boolean z, Continuation<? super ClipboardChecker$observer$1$1> continuation) {
        super(2, continuation);
        this.$result = recognizeResult;
        this.$coldStart = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ClipboardChecker$observer$1$1(this.$result, this.$coldStart, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        MutableStateFlow $this$update$iv;
        Object prevValue$iv;
        Object nextValue$iv;
        Integer num;
        Observer observer;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                InterestChoseService interestChoseService = (InterestChoseService) BLRouter.INSTANCE.get(InterestChoseService.class, "InterestChoseService");
                LiveData interestChoseLiveData = interestChoseService != null ? interestChoseService.getChoseLiveData() : null;
                if (this.$result != null) {
                    $this$update$iv = ClipboardChecker._recognize;
                    RecognizeResult recognizeResult = this.$result;
                    do {
                        prevValue$iv = $this$update$iv.getValue();
                        ClipboardResp clipboardResp = (ClipboardResp) prevValue$iv;
                        nextValue$iv = (ClipboardResp) new ClipboardResp.Success(recognizeResult);
                    } while (!$this$update$iv.compareAndSet(prevValue$iv, nextValue$iv));
                    if (interestChoseLiveData == null || (((num = (Integer) interestChoseLiveData.getValue()) != null && num.intValue() == 1) || interestChoseLiveData.getValue() == null || ProcessUtils.isWebProcess() || !this.$coldStart)) {
                        ClipboardChecker.INSTANCE.dealWithResult(this.$result);
                    } else {
                        ClipboardChecker.INSTANCE.logI(ClipboardChecker.TAG, "enter interest choose");
                        observer = ClipboardChecker.interestChooserOb;
                        if (observer != null) {
                            ClipboardChecker.INSTANCE.logI(ClipboardChecker.TAG, "interestChooserOb has set");
                        } else {
                            ClipboardChecker clipboardChecker = ClipboardChecker.INSTANCE;
                            final RecognizeResult recognizeResult2 = this.$result;
                            ClipboardChecker.interestChooserOb = new Observer() { // from class: tv.danmaku.bili.ui.clipboard.ClipboardChecker$observer$1$1$$ExternalSyntheticLambda0
                                public final void onChanged(Object obj2) {
                                    ClipboardChecker$observer$1$1.invokeSuspend$lambda$1(RecognizeResult.this, ((Integer) obj2).intValue());
                                }
                            };
                            interestChoseLiveData.observeForever(new ClipboardChecker$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: tv.danmaku.bili.ui.clipboard.ClipboardChecker$observer$1$1$$ExternalSyntheticLambda1
                                public final Object invoke(Object obj2) {
                                    Unit invokeSuspend$lambda$2;
                                    invokeSuspend$lambda$2 = ClipboardChecker$observer$1$1.invokeSuspend$lambda$2((Integer) obj2);
                                    return invokeSuspend$lambda$2;
                                }
                            }));
                        }
                    }
                } else {
                    ClipboardChecker.INSTANCE.logI(ClipboardChecker.TAG, "observe data is null");
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$1(RecognizeResult $result, int value) {
        if (value == 1) {
            ClipboardChecker.INSTANCE.dealWithResult($result);
        } else {
            ClipboardChecker.INSTANCE.logI(ClipboardChecker.TAG, "interest chose unfinished");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$2(Integer it) {
        Observer unused;
        unused = ClipboardChecker.interestChooserOb;
        return Unit.INSTANCE;
    }
}