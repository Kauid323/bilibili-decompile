package kntr.base.dd.impl.internal.data;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.config.SharedPreferences;
import kntr.base.dd.impl.internal.common.DDConst;
import kntr.base.dd.impl.internal.model.DDModel;
import kntr.base.dd.impl.internal.model.DDModelKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.atomicfu.AtomicLong;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CoreData.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.dd.impl.internal.data.CoreData$save$1", f = "CoreData.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class CoreData$save$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DDModel $model;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CoreData this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoreData$save$1(CoreData coreData, DDModel dDModel, Continuation<? super CoreData$save$1> continuation) {
        super(2, continuation);
        this.this$0 = coreData;
        this.$model = dDModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> coreData$save$1 = new CoreData$save$1(this.this$0, this.$model, continuation);
        coreData$save$1.L$0 = obj;
        return coreData$save$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ec A[LOOP:0: B:7:0x0025->B:36:0x00ec, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e9 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        AtomicLong $this$update$iv;
        CoroutineScope $this$launch;
        DDModel dDModel;
        Object m2636constructorimpl;
        Throwable it;
        SharedPreferences sharedPreferences;
        String str;
        String str2;
        SharedPreferences sharedPreferences2;
        String str3;
        SharedPreferences sharedPreferences3;
        String str4;
        CoroutineScope $this$launch2 = (CoroutineScope) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                $this$update$iv = this.this$0.saveCnt;
                DDModel dDModel2 = this.$model;
                CoreData coreData = this.this$0;
                while (true) {
                    long cur$iv = $this$update$iv.getValue();
                    long newCnt = 1 + cur$iv;
                    DDModel currentModel = dDModel2 == null ? coreData.createCurrentModel() : dDModel2;
                    try {
                        Result.Companion companion = Result.Companion;
                        String encoded = DDModelKt.encodeDDModelToString(currentModel);
                        if (encoded != null) {
                            sharedPreferences2 = coreData.sp;
                            str3 = coreData.kDataCacheKey;
                            $this$launch = $this$launch2;
                            try {
                                sharedPreferences2.setString(str3, encoded);
                                sharedPreferences3 = coreData.sp;
                                str4 = coreData.kVersionCacheKey;
                                sharedPreferences3.setString(str4, String.valueOf(currentModel.getVersion()));
                            } catch (Throwable th) {
                                th = th;
                                dDModel = dDModel2;
                                Result.Companion companion2 = Result.Companion;
                                m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(th));
                                it = Result.m2639exceptionOrNullimpl(m2636constructorimpl);
                                if (it != null) {
                                }
                                if ($this$update$iv.compareAndSet(cur$iv, newCnt)) {
                                }
                            }
                        } else {
                            $this$launch = $this$launch2;
                        }
                        sharedPreferences = coreData.sp;
                        str = coreData.kSaveCacheKey;
                        str2 = coreData.processName;
                        dDModel = dDModel2;
                        try {
                            sharedPreferences.setString(str, str2 + ":" + newCnt);
                            m2636constructorimpl = Result.m2636constructorimpl(Unit.INSTANCE);
                        } catch (Throwable th2) {
                            th = th2;
                            Result.Companion companion22 = Result.Companion;
                            m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(th));
                            it = Result.m2639exceptionOrNullimpl(m2636constructorimpl);
                            if (it != null) {
                            }
                            if ($this$update$iv.compareAndSet(cur$iv, newCnt)) {
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        $this$launch = $this$launch2;
                        dDModel = dDModel2;
                    }
                    it = Result.m2639exceptionOrNullimpl(m2636constructorimpl);
                    if (it != null) {
                        DDConst.logE$default(DDConst.INSTANCE, "DDCoreData save failed: " + it.getMessage(), null, 2, null);
                    }
                    if ($this$update$iv.compareAndSet(cur$iv, newCnt)) {
                        return Unit.INSTANCE;
                    }
                    dDModel2 = dDModel;
                    $this$launch2 = $this$launch;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}