package kntr.base.dd.impl.internal.update;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.dd.IDeviceDecision;
import kntr.base.dd.impl.internal.file.DDFileSystem;
import kntr.base.dd.impl.internal.update.UpdateEngine;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.io.files.Path;
import kotlinx.io.files.PathsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UpdateEngine.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Lkotlinx/io/files/Path;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.dd.impl.internal.update.UpdateEngine$patchOldData$2$1", f = "UpdateEngine.kt", i = {0, 0, 0, 0, 0}, l = {182}, m = "invokeSuspend", n = {"type", "it", "$this$invokeSuspend_u24lambda_u240_u240", "$i$a$-takeIf-UpdateEngine$patchOldData$2$1$1", "$i$a$-runCatching-UpdateEngine$patchOldData$2$1$1$1"}, s = {"L$0", "L$2", "L$3", "I$0", "I$1"}, v = 1)
public final class UpdateEngine$patchOldData$2$1 extends SuspendLambda implements Function1<Continuation<? super Path>, Object> {
    final /* synthetic */ IDeviceDecision.Version.Env $env;
    final /* synthetic */ UpdateInfoModel $info;
    final /* synthetic */ String $patchURL;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ UpdateEngine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpdateEngine$patchOldData$2$1(UpdateEngine updateEngine, IDeviceDecision.Version.Env env, UpdateInfoModel updateInfoModel, String str, Continuation<? super UpdateEngine$patchOldData$2$1> continuation) {
        super(1, continuation);
        this.this$0 = updateEngine;
        this.$env = env;
        this.$info = updateInfoModel;
        this.$patchURL = str;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new UpdateEngine$patchOldData$2$1(this.this$0, this.$env, this.$info, this.$patchURL, continuation);
    }

    public final Object invoke(Continuation<? super Path> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00ac A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        DDFileSystem dDFileSystem;
        Path it;
        Object m2636constructorimpl;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                UpdateEngine.FileType type = UpdateEngine.FileType.Patch;
                dDFileSystem = this.this$0.fs;
                it = PathsKt.Path(type.path(dDFileSystem, this.$env), new String[]{this.$info.getVersion() + ".patch"});
                UpdateEngine $this$invokeSuspend_u24lambda_u240_u240 = this.this$0;
                String str = this.$patchURL;
                try {
                    Result.Companion companion = Result.Companion;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(type);
                    this.L$1 = it;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(it);
                    this.L$3 = SpillingKt.nullOutSpilledVariable($this$invokeSuspend_u24lambda_u240_u240);
                    this.I$0 = 0;
                    this.I$1 = 0;
                    this.label = 1;
                } catch (Throwable th) {
                    th = th;
                    Result.Companion companion2 = Result.Companion;
                    m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(th));
                    if (Result.m2643isSuccessimpl(m2636constructorimpl)) {
                    }
                }
                if (UpdateEngine.download$default($this$invokeSuspend_u24lambda_u240_u240, type, str, it, null, this, 8, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                m2636constructorimpl = Result.m2636constructorimpl(Unit.INSTANCE);
                if (Result.m2643isSuccessimpl(m2636constructorimpl)) {
                    return null;
                }
                return it;
            case 1:
                int i = this.I$1;
                int i2 = this.I$0;
                UpdateEngine updateEngine = (UpdateEngine) this.L$3;
                Path path = (Path) this.L$2;
                it = (Path) this.L$1;
                UpdateEngine.FileType fileType = (UpdateEngine.FileType) this.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    m2636constructorimpl = Result.m2636constructorimpl(Unit.INSTANCE);
                } catch (Throwable th2) {
                    th = th2;
                    Result.Companion companion22 = Result.Companion;
                    m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(th));
                    if (Result.m2643isSuccessimpl(m2636constructorimpl)) {
                    }
                }
                if (Result.m2643isSuccessimpl(m2636constructorimpl)) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}