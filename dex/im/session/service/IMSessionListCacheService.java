package im.session.service;

import im.base.IMLog;
import im.session.log.LogTagKt;
import im.session.model.IMSessionPageData;
import kntr.base.account.AccountState;
import kntr.base.account.KAccountStore;
import kntr.base.config.IPlatformConfig;
import kntr.base.config.KConfig;
import kntr.base.utils.CoroutineExJvmKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.datetime.Clock;
import kotlinx.datetime.Instant;

/* compiled from: IMSessionCacheService.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u0010\u0015J\u000e\u0010\u0016\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0012H\u0086@¢\u0006\u0002\u0010\u0017J\u000f\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0002\u0010\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000e¨\u0006\u001c"}, d2 = {"Lim/session/service/IMSessionListCacheService;", "", "accountStore", "Lkntr/base/account/KAccountStore;", "dataCacheService", "Lim/session/service/IMSessionDataCacheService;", "<init>", "(Lkntr/base/account/KAccountStore;Lim/session/service/IMSessionDataCacheService;)V", "lastSaveInstant", "Lkotlinx/datetime/Instant;", "thresholdConfig", "", "saveThreshold", "Lkotlin/time/Duration;", "J", "save", "", "pageData", "Lim/session/model/IMSessionPageData;", "isForce", "", "(Lim/session/model/IMSessionPageData;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delete", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "currentUserID", "", "()Ljava/lang/Long;", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMSessionListCacheService {
    private final KAccountStore accountStore;
    private final IMSessionDataCacheService dataCacheService;
    private Instant lastSaveInstant;
    private final long saveThreshold;
    private final String thresholdConfig;

    public IMSessionListCacheService(KAccountStore accountStore, IMSessionDataCacheService dataCacheService) {
        long duration;
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(accountStore, "accountStore");
        Intrinsics.checkNotNullParameter(dataCacheService, "dataCacheService");
        this.accountStore = accountStore;
        this.dataCacheService = dataCacheService;
        this.thresholdConfig = IPlatformConfig.-CC.config$default(KConfig.INSTANCE, "im_session_cache_threshold", (String) null, 2, (Object) null);
        String str = this.thresholdConfig;
        if (str != null && (intOrNull = StringsKt.toIntOrNull(str)) != null) {
            int it = intOrNull.intValue();
            Integer num = it > 0 ? intOrNull : null;
            if (num != null) {
                Duration.Companion companion = Duration.Companion;
                duration = DurationKt.toDuration(num.intValue(), DurationUnit.SECONDS);
                this.saveThreshold = duration;
            }
        }
        Duration.Companion companion2 = Duration.Companion;
        duration = DurationKt.toDuration(1, DurationUnit.SECONDS);
        this.saveThreshold = duration;
    }

    public static /* synthetic */ Object save$default(IMSessionListCacheService iMSessionListCacheService, IMSessionPageData iMSessionPageData, boolean z, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return iMSessionListCacheService.save(iMSessionPageData, z, continuation);
    }

    public final Object save(IMSessionPageData pageData, boolean isForce, Continuation<? super Unit> continuation) {
        if (!IMSessionCacheServiceKt.access$isValidForSave(pageData)) {
            return Unit.INSTANCE;
        }
        Long userID = currentUserID();
        if (userID == null) {
            return Unit.INSTANCE;
        }
        IMLog.Companion.i(LogTagKt.getCacheLogTag(), "准备缓存会话列表数据, userID: " + userID);
        Instant currentInstant = Clock.System.INSTANCE.now();
        Instant lastInstant = this.lastSaveInstant;
        if (!isForce && lastInstant != null && Duration.compareTo-LRDsOJo(currentInstant.minus-5sfh64U(lastInstant), this.saveThreshold) < 0) {
            IMLog.Companion.i(LogTagKt.getCacheLogTag(), "过于频繁缓存会话列表数据, 跳过此次行为");
            return Unit.INSTANCE;
        }
        IMLog.Companion.i(LogTagKt.getCacheLogTag(), "开始缓存会话列表数据, userID: " + userID);
        this.lastSaveInstant = Clock.System.INSTANCE.now();
        Object withContext = BuildersKt.withContext(CoroutineExJvmKt.getIoContext(), new IMSessionListCacheService$save$2(userID, this, pageData, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object delete(Continuation<? super Unit> continuation) {
        Long userID = currentUserID();
        if (userID == null) {
            return Unit.INSTANCE;
        }
        Object withContext = BuildersKt.withContext(CoroutineExJvmKt.getIoContext(), new IMSessionListCacheService$delete$2(userID, this, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object load(Continuation<? super IMSessionPageData> continuation) {
        Long userID = currentUserID();
        if (userID == null) {
            return null;
        }
        IMLog.Companion.i(LogTagKt.getCacheLogTag(), "开始读取会话列表缓存, userID: " + userID);
        return BuildersKt.withContext(CoroutineExJvmKt.getIoContext(), new IMSessionListCacheService$load$2(userID, this, null), continuation);
    }

    private final Long currentUserID() {
        AccountState.Logged logged = (AccountState) this.accountStore.getState().getValue();
        if (logged instanceof AccountState.Idle) {
            return null;
        }
        if (logged instanceof AccountState.Logged) {
            return Long.valueOf(logged.getUserInfo().getMid());
        }
        throw new NoWhenBranchMatchedException();
    }
}