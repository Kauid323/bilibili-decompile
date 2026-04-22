package kntr.base.imageloader;

import androidx.compose.runtime.MutableState;
import androidx.lifecycle.Lifecycle;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.ImageState;
import kntr.base.log.ILogger;
import kntr.base.log.KLog_androidKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BiliImage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.imageloader.BiliImageKt$BiliImage$1$1$1$job$1", f = "BiliImage.kt", i = {0, 1, 1}, l = {115, 127}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "source"}, s = {"L$0", "L$0", "L$1"}, v = 1)
public final class BiliImageKt$BiliImage$1$1$1$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ImmutableImageRequest $finalReq;
    final /* synthetic */ MutableState<ImageState> $imageState$delegate;
    final /* synthetic */ Lifecycle $lifecycle;
    final /* synthetic */ String $traceId;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BiliImageKt$BiliImage$1$1$1$job$1(ImmutableImageRequest immutableImageRequest, Lifecycle lifecycle, String str, MutableState<ImageState> mutableState, Continuation<? super BiliImageKt$BiliImage$1$1$1$job$1> continuation) {
        super(2, continuation);
        this.$finalReq = immutableImageRequest;
        this.$lifecycle = lifecycle;
        this.$traceId = str;
        this.$imageState$delegate = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> biliImageKt$BiliImage$1$1$1$job$1 = new BiliImageKt$BiliImage$1$1$1$job$1(this.$finalReq, this.$lifecycle, this.$traceId, this.$imageState$delegate, continuation);
        biliImageKt$BiliImage$1$1$1$job$1.L$0 = obj;
        return biliImageKt$BiliImage$1$1$1$job$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object loadImage;
        ImageSource source;
        ImageException it;
        Throwable th;
        ImageSource source2;
        Image source3;
        Image source4;
        CoroutineScope $this$launch = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.L$0 = $this$launch;
                this.label = 1;
                loadImage = BiliImage_androidKt.loadImage(this.$finalReq, this.$lifecycle, (Continuation) this);
                if (loadImage == coroutine_suspended) {
                    return coroutine_suspended;
                }
                source = (ImageSource) loadImage;
                it = source.getError();
                if (it == null) {
                    String str = this.$traceId;
                    this.$imageState$delegate.setValue(new ImageState.Error(it));
                    ILogger kLog = KLog_androidKt.getKLog();
                    String message = it.getMessage();
                    kLog.e(ApiKt.TAG, str + " - image fetch error: " + message + ", " + it.getCause());
                } else {
                    MutableState<ImageState> mutableState = this.$imageState$delegate;
                    Image it2 = source.getSource();
                    if (it2 != null) {
                        mutableState.setValue(new ImageState.Success(it2));
                    }
                }
                try {
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$launch);
                    this.L$1 = source;
                    this.label = 2;
                    if (DelayKt.awaitCancellation((Continuation) this) != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    source2 = source;
                    throw new KotlinNothingValueException();
                } catch (Exception e) {
                    source2 = source;
                    source4 = source2.getSource();
                    if (source4 != null) {
                        source4.close();
                    }
                    KLog_androidKt.getKLog().d(ApiKt.TAG, this.$traceId + " - image close");
                    return Unit.INSTANCE;
                } catch (Throwable th2) {
                    th = th2;
                    source2 = source;
                    source3 = source2.getSource();
                    if (source3 != null) {
                        source3.close();
                    }
                    KLog_androidKt.getKLog().d(ApiKt.TAG, this.$traceId + " - image close");
                    throw th;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                loadImage = $result;
                source = (ImageSource) loadImage;
                it = source.getError();
                if (it == null) {
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$launch);
                this.L$1 = source;
                this.label = 2;
                if (DelayKt.awaitCancellation((Continuation) this) != coroutine_suspended) {
                }
                break;
            case 2:
                source2 = (ImageSource) this.L$1;
                try {
                    ResultKt.throwOnFailure($result);
                    throw new KotlinNothingValueException();
                } catch (Exception e2) {
                    source4 = source2.getSource();
                    if (source4 != null) {
                    }
                    KLog_androidKt.getKLog().d(ApiKt.TAG, this.$traceId + " - image close");
                    return Unit.INSTANCE;
                } catch (Throwable th3) {
                    th = th3;
                    source3 = source2.getSource();
                    if (source3 != null) {
                    }
                    KLog_androidKt.getKLog().d(ApiKt.TAG, this.$traceId + " - image close");
                    throw th;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}