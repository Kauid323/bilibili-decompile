package kntr.app.tribee.publish.core.v2.serviceImpl;

import javax.inject.Inject;
import kntr.app.tribee.publish.core.v2.di.TribeePublishDraftBaseDir;
import kntr.app.tribee.publish.core.v2.di.TribeePublishScope;
import kntr.app.tribee.publish.core.v2.model.TribeeInfo;
import kntr.app.tribee.publish.core.v2.service.TribeeDraftContent;
import kntr.app.tribee.publish.core.v2.service.TribeePublishDraftService;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.account.AccountState;
import kntr.base.account.KAccountStore;
import kntr.base.account.model.UserInfo;
import kntr.base.log.KLog_androidKt;
import kntr.base.utils.CoroutineExJvmKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.io.files.FileSystemJvmKt;
import kotlinx.io.files.Path;
import kotlinx.io.files.PathsKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;

/* compiled from: TribeeDraftServiceImpl.kt */
@TribeePublishScope
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0010J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096@¢\u0006\u0002\u0010\u0015J \u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00172\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0004\b\u0018\u0010\u0010J\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0010J\u0015\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0001¢\u0006\u0002\b\u001bJ\u0015\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lkntr/app/tribee/publish/core/v2/serviceImpl/TribeeDraftServiceImpl;", "Lkntr/app/tribee/publish/core/v2/service/TribeePublishDraftService;", "accountStore", "Lkntr/base/account/KAccountStore;", "baseDir", "Lkotlinx/io/files/Path;", "<init>", "(Lkntr/base/account/KAccountStore;Lkotlinx/io/files/Path;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "json", "Lkotlinx/serialization/json/Json;", "checkDraft", "", "tribeeInfo", "Lkntr/app/tribee/publish/core/v2/model/TribeeInfo;", "(Lkntr/app/tribee/publish/core/v2/model/TribeeInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveDraft", "", "content", "Lkntr/app/tribee/publish/core/v2/service/TribeeDraftContent;", "(Lkntr/app/tribee/publish/core/v2/model/TribeeInfo;Lkntr/app/tribee/publish/core/v2/service/TribeeDraftContent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadDraft", "Lkotlin/Result;", "loadDraft-gIAlu-s", "moveBakDraft", "getDraftPath", "getDraftPath$core_debug", "getBakPath", "getBakPath$core_debug", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeDraftServiceImpl implements TribeePublishDraftService {
    private final KAccountStore accountStore;
    private final Path baseDir;
    private final Json json;
    private final CoroutineScope scope;

    @Inject
    public TribeeDraftServiceImpl(KAccountStore accountStore, @TribeePublishDraftBaseDir Path baseDir) {
        Intrinsics.checkNotNullParameter(accountStore, "accountStore");
        Intrinsics.checkNotNullParameter(baseDir, "baseDir");
        this.accountStore = accountStore;
        this.baseDir = baseDir;
        this.scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(CoroutineExJvmKt.getIoContext()));
        this.json = JsonKt.Json$default((Json) null, new Function1() { // from class: kntr.app.tribee.publish.core.v2.serviceImpl.TribeeDraftServiceImpl$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit json$lambda$0;
                json$lambda$0 = TribeeDraftServiceImpl.json$lambda$0((JsonBuilder) obj);
                return json$lambda$0;
            }
        }, 1, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit json$lambda$0(JsonBuilder $this$Json) {
        Intrinsics.checkNotNullParameter($this$Json, "$this$Json");
        $this$Json.setIgnoreUnknownKeys(true);
        $this$Json.setLenient(true);
        return Unit.INSTANCE;
    }

    @Override // kntr.app.tribee.publish.core.v2.service.TribeePublishDraftService
    public Object checkDraft(TribeeInfo tribeeInfo, Continuation<? super Boolean> continuation) {
        return Boxing.boxBoolean(FileSystemJvmKt.SystemFileSystem.exists(getDraftPath$core_debug(tribeeInfo)));
    }

    @Override // kntr.app.tribee.publish.core.v2.service.TribeePublishDraftService
    public Object saveDraft(TribeeInfo tribeeInfo, TribeeDraftContent content, Continuation<? super Unit> continuation) {
        Object join = BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new TribeeDraftServiceImpl$saveDraft$2(this, tribeeInfo, content, null), 3, (Object) null).join(continuation);
        return join == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? join : Unit.INSTANCE;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(2:3|(8:5|6|7|8|15|16|(1:18)|19))|28|6|7|8|15|16|(0)|19) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x009b, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x009c, code lost:
        r3 = kotlin.Result.Companion;
        r2 = kotlin.Result.m2636constructorimpl(kotlin.ResultKt.createFailure(r2));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ac  */
    @Override // kntr.app.tribee.publish.core.v2.service.TribeePublishDraftService
    /* renamed from: loadDraft-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo880loadDraftgIAlus(TribeeInfo tribeeInfo, Continuation<? super Result<TribeeDraftContent>> continuation) {
        TribeeDraftServiceImpl$loadDraft$1 tribeeDraftServiceImpl$loadDraft$1;
        Throwable it;
        Object await;
        if (continuation instanceof TribeeDraftServiceImpl$loadDraft$1) {
            tribeeDraftServiceImpl$loadDraft$1 = (TribeeDraftServiceImpl$loadDraft$1) continuation;
            if ((tribeeDraftServiceImpl$loadDraft$1.label & Integer.MIN_VALUE) != 0) {
                tribeeDraftServiceImpl$loadDraft$1.label -= Integer.MIN_VALUE;
                Object $result = tribeeDraftServiceImpl$loadDraft$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (tribeeDraftServiceImpl$loadDraft$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        KLog_androidKt.getKLog().i("TribeeDraft", "Start load draft in " + tribeeInfo);
                        Deferred deferred = BuildersKt.async$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new TribeeDraftServiceImpl$loadDraft$deferred$1(this, tribeeInfo, null), 3, (Object) null);
                        Result.Companion companion = Result.Companion;
                        TribeeDraftServiceImpl $this$loadDraft_gIAlu_s_u24lambda_u240 = this;
                        tribeeDraftServiceImpl$loadDraft$1.L$0 = tribeeInfo;
                        tribeeDraftServiceImpl$loadDraft$1.L$1 = SpillingKt.nullOutSpilledVariable(deferred);
                        tribeeDraftServiceImpl$loadDraft$1.L$2 = SpillingKt.nullOutSpilledVariable($this$loadDraft_gIAlu_s_u24lambda_u240);
                        tribeeDraftServiceImpl$loadDraft$1.I$0 = 0;
                        tribeeDraftServiceImpl$loadDraft$1.label = 1;
                        await = deferred.await(tribeeDraftServiceImpl$loadDraft$1);
                        if (await != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        int i = tribeeDraftServiceImpl$loadDraft$1.I$0;
                        TribeeDraftServiceImpl tribeeDraftServiceImpl = (TribeeDraftServiceImpl) tribeeDraftServiceImpl$loadDraft$1.L$2;
                        Deferred deferred2 = (Deferred) tribeeDraftServiceImpl$loadDraft$1.L$1;
                        tribeeInfo = (TribeeInfo) tribeeDraftServiceImpl$loadDraft$1.L$0;
                        ResultKt.throwOnFailure($result);
                        await = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Object m2636constructorimpl = Result.m2636constructorimpl((TribeeDraftContent) await);
                it = Result.m2639exceptionOrNullimpl(m2636constructorimpl);
                if (it != null) {
                    JobKt.ensureActive(tribeeDraftServiceImpl$loadDraft$1.getContext());
                    KLog_androidKt.getKLog().e("TribeeDraft", "Fail to load draft in " + tribeeInfo, it.getCause());
                }
                return m2636constructorimpl;
            }
        }
        tribeeDraftServiceImpl$loadDraft$1 = new TribeeDraftServiceImpl$loadDraft$1(this, continuation);
        Object $result2 = tribeeDraftServiceImpl$loadDraft$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (tribeeDraftServiceImpl$loadDraft$1.label) {
        }
        Object m2636constructorimpl2 = Result.m2636constructorimpl((TribeeDraftContent) await);
        it = Result.m2639exceptionOrNullimpl(m2636constructorimpl2);
        if (it != null) {
        }
        return m2636constructorimpl2;
    }

    @Override // kntr.app.tribee.publish.core.v2.service.TribeePublishDraftService
    public Object moveBakDraft(TribeeInfo tribeeInfo, Continuation<? super Path> continuation) {
        Path path = getDraftPath$core_debug(tribeeInfo);
        if (!FileSystemJvmKt.SystemFileSystem.exists(path)) {
            KLog_androidKt.getKLog().i("TribeeDraft", "No draft found in " + tribeeInfo + " when move bak draft");
            return null;
        }
        Path bakPath = getBakPath$core_debug(tribeeInfo);
        try {
            FileSystemJvmKt.SystemFileSystem.atomicMove(path, bakPath);
            return bakPath;
        } catch (Exception e) {
            KLog_androidKt.getKLog().e("TribeeDraft", "Move draft to bak failed", e);
            return null;
        }
    }

    public final Path getDraftPath$core_debug(TribeeInfo tribeeInfo) {
        UserInfo userInfo;
        Intrinsics.checkNotNullParameter(tribeeInfo, "tribeeInfo");
        Object value = this.accountStore.getState().getValue();
        AccountState.Logged logged = value instanceof AccountState.Logged ? (AccountState.Logged) value : null;
        long mid = (logged == null || (userInfo = logged.getUserInfo()) == null) ? 0L : userInfo.getMid();
        return PathsKt.Path(this.baseDir, new String[]{String.valueOf(mid), String.valueOf(tribeeInfo.getTribeeId()), "draft-v2.json"});
    }

    public final Path getBakPath$core_debug(TribeeInfo tribeeInfo) {
        UserInfo userInfo;
        Intrinsics.checkNotNullParameter(tribeeInfo, "tribeeInfo");
        Object value = this.accountStore.getState().getValue();
        AccountState.Logged logged = value instanceof AccountState.Logged ? (AccountState.Logged) value : null;
        long mid = (logged == null || (userInfo = logged.getUserInfo()) == null) ? 0L : userInfo.getMid();
        return PathsKt.Path(this.baseDir, new String[]{String.valueOf(mid), String.valueOf(tribeeInfo.getTribeeId()), "draft.bak"});
    }
}