package kntr.app.ad.domain.report.vendor;

import com.bapis.bilibili.app.dynamic.v2.AdditionVote2;
import kntr.app.ad.domain.report.internal.ReportRecord;
import kntr.app.ad.domain.report.internal.cache.IReportStorageManager;
import kntr.app.ad.domain.report.internal.upload.IReportUploader;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BaseReporter.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.ad.domain.report.vendor.BaseReporter$handleReport$1", f = "BaseReporter.kt", i = {1}, l = {AdditionVote2.VOTE_OWNER_MID_FIELD_NUMBER, 32}, m = "invokeSuspend", n = {"success"}, s = {"Z$0"}, v = 1)
public final class BaseReporter$handleReport$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Integer, String, Unit> $failureAction;
    final /* synthetic */ ReportRecord $record;
    final /* synthetic */ Function1<String, Unit> $startAction;
    final /* synthetic */ Function0<Unit> $successAction;
    boolean Z$0;
    int label;
    final /* synthetic */ BaseReporter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BaseReporter$handleReport$1(BaseReporter baseReporter, ReportRecord reportRecord, Function1<? super String, Unit> function1, Function0<Unit> function0, Function2<? super Integer, ? super String, Unit> function2, Continuation<? super BaseReporter$handleReport$1> continuation) {
        super(2, continuation);
        this.this$0 = baseReporter;
        this.$record = reportRecord;
        this.$startAction = function1;
        this.$successAction = function0;
        this.$failureAction = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BaseReporter$handleReport$1(this.this$0, this.$record, this.$startAction, this.$successAction, this.$failureAction, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IReportUploader iReportUploader;
        Object upload;
        IReportStorageManager iReportStorageManager;
        boolean success;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                iReportUploader = this.this$0.uploader;
                this.label = 1;
                upload = iReportUploader.upload(this.$record, true, this.$startAction, this.$successAction, this.$failureAction, (Continuation) this);
                if (upload == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                upload = $result;
                break;
            case 2:
                success = this.Z$0;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        boolean success2 = ((Boolean) upload).booleanValue();
        KLog_androidKt.getKLog().d("AdReport", "BaseReporter handleReport upload success=" + (success2) + ", record=" + this.$record);
        if (!success2) {
            KLog_androidKt.getKLog().d("AdReport", "BaseReporter handleReport saveOrUpdate record=" + this.$record);
            iReportStorageManager = this.this$0.storageManager;
            this.Z$0 = success2;
            this.label = 2;
            if (iReportStorageManager.saveOrUpdate(this.$record, (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            success = success2;
        }
        return Unit.INSTANCE;
    }
}