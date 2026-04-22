package video.biz.offline.base.infra.storage.db;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import tv.danmaku.biliplayerv2.service.interact.biz.sender.ChronosDanmakuSender;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.infra.utils.DataLog;
import video.biz.offline.base.model.dao.OfflineVideoDao;
import video.biz.offline.base.model.db.AppDatabase;
import video.biz.offline.base.model.db.OfflineDatabaseKt;
import video.biz.offline.base.model.db.OfflineDatabase_androidKt;
import video.biz.offline.base.model.entity.OfflineAuthUpdate;
import video.biz.offline.base.model.entity.OfflineVideoEntity;

/* compiled from: DBDataStorage.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0087@¢\u0006\u0002\u0010\rJ\u0014\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tH\u0007J\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0087@¢\u0006\u0002\u0010\u0010J$\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J$\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0087@¢\u0006\u0002\u0010\u0017J$\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0087@¢\u0006\u0002\u0010\u0017J$\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u001c\u001a\u00020\u0013H\u0087@¢\u0006\u0002\u0010\u001dJ\u001c\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0006\u0010\u001c\u001a\u00020\u0013H\u0007J\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010 \u001a\u00020\u0015H\u0087@¢\u0006\u0002\u0010!J\"\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00150\nH\u0087@¢\u0006\u0002\u0010\rJ,\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020)H\u0087@¢\u0006\u0002\u0010*J\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0087@¢\u0006\u0002\u0010\u0010J\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0087@¢\u0006\u0002\u0010\u0010J\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0014\u001a\u00020\u0015H\u0087@¢\u0006\u0002\u0010!J\"\u0010.\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00150\nH\u0087@¢\u0006\u0002\u0010\rJ\u001c\u00100\u001a\u0002012\f\u00102\u001a\b\u0012\u0004\u0012\u0002030\nH\u0087@¢\u0006\u0002\u0010\rJ\u001c\u00104\u001a\u0002012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0087@¢\u0006\u0002\u0010\rJ\r\u00105\u001a\u000201H\u0000¢\u0006\u0002\b6J\u0010\u00107\u001a\u000201H\u0080@¢\u0006\u0004\b8\u0010\u0010J,\u00109\u001a\u0004\u0018\u0001H:\"\u0004\b\u0000\u0010:2\u0006\u0010;\u001a\u00020\u00152\f\u0010<\u001a\b\u0012\u0004\u0012\u0002H:0=H\u0082\b¢\u0006\u0002\u0010>J\u001f\u0010?\u001a\u0002012\u0006\u0010;\u001a\u00020\u00152\f\u0010<\u001a\b\u0012\u0004\u0012\u0002010=H\u0082\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lvideo/biz/offline/base/infra/storage/db/DBDataStorage;", "", "<init>", "()V", "db", "Lvideo/biz/offline/base/model/db/AppDatabase;", "dao", "Lvideo/biz/offline/base/model/dao/OfflineVideoDao;", "addVideos", "Lkotlinx/coroutines/flow/Flow;", "", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "videos", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllVideosFlow", "getAllVideos", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVideosFlowByGroupId", "groupId", "", ChronosDanmakuSender.KEY_MARK_DANMAKU, "", "getVideosByGroupId", "(JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVideosByVideoId", "videoId", "getVideosFlowByVideoId", "getVideosByPageId", "pageId", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVideosFlowByPageId", "getVideoByKey", "key", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVideosByKeys", "keys", "getUnDownloadVideos", "includePause", "", "includeError", "limit", "", "(ZZILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDownloadedVideos", "getDownloadingVideos", "search", "removeVideo", "ids", "updateAuthCode", "", "list", "Lvideo/biz/offline/base/model/entity/OfflineAuthUpdate;", "updateVideo", "resetDB", "resetDB$infra_debug", "clearDBRecords", "clearDBRecords$infra_debug", "safeCall", "T", "logTag", "block", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "safeCallUnit", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DBDataStorage {
    public static final int $stable = 8;
    private final AppDatabase db = OfflineDatabaseKt.getOfflineDB();
    private final OfflineVideoDao dao = this.db.videoDao();

    /* JADX WARN: Can't wrap try/catch for region: R(21:1|(2:3|(19:5|6|7|8|14|15|(1:17)|18|(2:21|19)|22|23|24|25|26|(1:28)|29|(1:31)|32|(2:34|35)(1:36)))|48|6|7|8|14|15|(0)|18|(1:19)|22|23|24|25|26|(0)|29|(0)|32|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x009d, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x009e, code lost:
        r3 = kotlin.Result.Companion;
        r2 = kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(r2));
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x011a, code lost:
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x011b, code lost:
        r9 = kotlin.Result.Companion;
        r8 = kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(r8));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ee A[LOOP:0: B:28:0x00e8->B:30:0x00ee, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object addVideos(List<OfflineVideoEntity> list, Continuation<? super Flow<? extends List<OfflineVideoEntity>>> continuation) {
        DBDataStorage$addVideos$1 dBDataStorage$addVideos$1;
        Throwable it$iv;
        Object obj;
        Throwable it$iv2;
        String logTag$iv;
        if (continuation instanceof DBDataStorage$addVideos$1) {
            dBDataStorage$addVideos$1 = (DBDataStorage$addVideos$1) continuation;
            if ((dBDataStorage$addVideos$1.label & Integer.MIN_VALUE) != 0) {
                dBDataStorage$addVideos$1.label -= Integer.MIN_VALUE;
                Object $result = dBDataStorage$addVideos$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (dBDataStorage$addVideos$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        new DataLog().debug("DBStorage addVideos: " + list);
                        logTag$iv = "addVideos insert";
                        Result.Companion companion = Result.Companion;
                        DBDataStorage $this$safeCallUnit_u24lambda_u240$iv = this;
                        OfflineVideoDao offlineVideoDao = this.dao;
                        dBDataStorage$addVideos$1.L$0 = list;
                        dBDataStorage$addVideos$1.L$1 = SpillingKt.nullOutSpilledVariable(this);
                        dBDataStorage$addVideos$1.L$2 = "addVideos insert";
                        dBDataStorage$addVideos$1.L$3 = SpillingKt.nullOutSpilledVariable($this$safeCallUnit_u24lambda_u240$iv);
                        dBDataStorage$addVideos$1.I$0 = 0;
                        dBDataStorage$addVideos$1.I$1 = 0;
                        dBDataStorage$addVideos$1.I$2 = 0;
                        dBDataStorage$addVideos$1.label = 1;
                        if (offlineVideoDao.insert(list, dBDataStorage$addVideos$1) != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        int i = dBDataStorage$addVideos$1.I$2;
                        int i2 = dBDataStorage$addVideos$1.I$1;
                        int i3 = dBDataStorage$addVideos$1.I$0;
                        DBDataStorage dBDataStorage = (DBDataStorage) dBDataStorage$addVideos$1.L$3;
                        logTag$iv = (String) dBDataStorage$addVideos$1.L$2;
                        DBDataStorage dBDataStorage2 = (DBDataStorage) dBDataStorage$addVideos$1.L$1;
                        list = (List) dBDataStorage$addVideos$1.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Object obj2 = Result.constructor-impl(Unit.INSTANCE);
                it$iv = Result.exceptionOrNull-impl(obj2);
                if (it$iv != null) {
                    new DataLog().error("DBDataStorage " + logTag$iv + " error", it$iv);
                }
                Iterable $this$map$iv = list;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    OfflineVideoEntity it = (OfflineVideoEntity) item$iv$iv;
                    destination$iv$iv.add(it.getKey());
                }
                List keys = (List) destination$iv$iv;
                Result.Companion companion2 = Result.Companion;
                DBDataStorage dBDataStorage3 = this;
                obj = Result.constructor-impl(this.dao.getVideoFlowsByKeys(keys));
                it$iv2 = Result.exceptionOrNull-impl(obj);
                if (it$iv2 != null) {
                    new DataLog().error("DBDataStorage addVideos getVideoFlowsByKeys error", it$iv2);
                }
                if (Result.isFailure-impl(obj)) {
                    obj = null;
                }
                Flow flow = (Flow) obj;
                return flow != null ? FlowKt.emptyFlow() : flow;
            }
        }
        dBDataStorage$addVideos$1 = new DBDataStorage$addVideos$1(this, continuation);
        Object $result2 = dBDataStorage$addVideos$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (dBDataStorage$addVideos$1.label) {
        }
        Object obj22 = Result.constructor-impl(Unit.INSTANCE);
        it$iv = Result.exceptionOrNull-impl(obj22);
        if (it$iv != null) {
        }
        Iterable $this$map$iv2 = list;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        while (r9.hasNext()) {
        }
        List keys2 = (List) destination$iv$iv2;
        Result.Companion companion22 = Result.Companion;
        DBDataStorage dBDataStorage32 = this;
        obj = Result.constructor-impl(this.dao.getVideoFlowsByKeys(keys2));
        it$iv2 = Result.exceptionOrNull-impl(obj);
        if (it$iv2 != null) {
        }
        if (Result.isFailure-impl(obj)) {
        }
        Flow flow2 = (Flow) obj;
        if (flow2 != null) {
        }
    }

    public final Flow<List<OfflineVideoEntity>> getAllVideosFlow() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            DBDataStorage dBDataStorage = this;
            obj = Result.constructor-impl(this.dao.getAllAsFlow());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable it$iv = Result.exceptionOrNull-impl(obj);
        if (it$iv != null) {
            new DataLog().error("DBDataStorage getAllVideosFlow error", it$iv);
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        Flow<List<OfflineVideoEntity>> flow = (Flow) obj;
        return flow == null ? FlowKt.emptyFlow() : flow;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:1|(2:3|(11:5|6|7|8|15|16|(1:18)|19|(1:21)|22|(2:24|25)(1:26)))|35|6|7|8|15|16|(0)|19|(0)|22|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x007c, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007d, code lost:
        r3 = kotlin.Result.Companion;
        r2 = kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(r2));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getAllVideos(Continuation<? super List<OfflineVideoEntity>> continuation) {
        DBDataStorage$getAllVideos$1 dBDataStorage$getAllVideos$1;
        Object obj;
        Throwable it$iv;
        String logTag$iv;
        Object all;
        if (continuation instanceof DBDataStorage$getAllVideos$1) {
            dBDataStorage$getAllVideos$1 = (DBDataStorage$getAllVideos$1) continuation;
            if ((dBDataStorage$getAllVideos$1.label & Integer.MIN_VALUE) != 0) {
                dBDataStorage$getAllVideos$1.label -= Integer.MIN_VALUE;
                Object $result = dBDataStorage$getAllVideos$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (dBDataStorage$getAllVideos$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        logTag$iv = "getAllVideos";
                        Result.Companion companion = Result.Companion;
                        DBDataStorage $this$safeCall_u24lambda_u240$iv = this;
                        OfflineVideoDao offlineVideoDao = this.dao;
                        dBDataStorage$getAllVideos$1.L$0 = SpillingKt.nullOutSpilledVariable(this);
                        dBDataStorage$getAllVideos$1.L$1 = logTag$iv;
                        dBDataStorage$getAllVideos$1.L$2 = SpillingKt.nullOutSpilledVariable($this$safeCall_u24lambda_u240$iv);
                        dBDataStorage$getAllVideos$1.I$0 = 0;
                        dBDataStorage$getAllVideos$1.I$1 = 0;
                        dBDataStorage$getAllVideos$1.I$2 = 0;
                        dBDataStorage$getAllVideos$1.label = 1;
                        all = offlineVideoDao.getAll(dBDataStorage$getAllVideos$1);
                        if (all != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        int i = dBDataStorage$getAllVideos$1.I$2;
                        int i2 = dBDataStorage$getAllVideos$1.I$1;
                        int i3 = dBDataStorage$getAllVideos$1.I$0;
                        DBDataStorage dBDataStorage = (DBDataStorage) dBDataStorage$getAllVideos$1.L$2;
                        logTag$iv = (String) dBDataStorage$getAllVideos$1.L$1;
                        DBDataStorage dBDataStorage2 = (DBDataStorage) dBDataStorage$getAllVideos$1.L$0;
                        ResultKt.throwOnFailure($result);
                        all = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj = Result.constructor-impl((List) all);
                it$iv = Result.exceptionOrNull-impl(obj);
                if (it$iv != null) {
                    new DataLog().error("DBDataStorage " + logTag$iv + " error", it$iv);
                }
                if (Result.isFailure-impl(obj)) {
                    obj = null;
                }
                List list = (List) obj;
                return list != null ? CollectionsKt.emptyList() : list;
            }
        }
        dBDataStorage$getAllVideos$1 = new DBDataStorage$getAllVideos$1(this, continuation);
        Object $result2 = dBDataStorage$getAllVideos$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (dBDataStorage$getAllVideos$1.label) {
        }
        obj = Result.constructor-impl((List) all);
        it$iv = Result.exceptionOrNull-impl(obj);
        if (it$iv != null) {
        }
        if (Result.isFailure-impl(obj)) {
        }
        List list2 = (List) obj;
        if (list2 != null) {
        }
    }

    public final Flow<List<OfflineVideoEntity>> getVideosFlowByGroupId(long groupId, String keyword) {
        Object obj;
        Intrinsics.checkNotNullParameter(keyword, ChronosDanmakuSender.KEY_MARK_DANMAKU);
        new DataLog().debug("DBStorage getVideoStatesByGroupId: " + groupId);
        try {
            Result.Companion companion = Result.Companion;
            DBDataStorage dBDataStorage = this;
            obj = Result.constructor-impl(this.dao.getVideoFlowsByGroupId(groupId, keyword));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable it$iv = Result.exceptionOrNull-impl(obj);
        if (it$iv != null) {
            new DataLog().error("DBDataStorage getVideosFlowByGroupId error", it$iv);
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        Flow<List<OfflineVideoEntity>> flow = (Flow) obj;
        return flow == null ? FlowKt.emptyFlow() : flow;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:1|(2:3|(11:5|6|7|8|15|16|(1:18)|19|(1:21)|22|(2:24|25)(1:26)))|35|6|7|8|15|16|(0)|19|(0)|22|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x008a, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x008b, code lost:
        r3 = kotlin.Result.Companion;
        r2 = kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(r2));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getVideosByGroupId(long groupId, String keyword, Continuation<? super List<OfflineVideoEntity>> continuation) {
        DBDataStorage$getVideosByGroupId$1 dBDataStorage$getVideosByGroupId$1;
        Object obj;
        Throwable it$iv;
        String logTag$iv;
        Object videosByGroupId;
        if (continuation instanceof DBDataStorage$getVideosByGroupId$1) {
            dBDataStorage$getVideosByGroupId$1 = (DBDataStorage$getVideosByGroupId$1) continuation;
            if ((dBDataStorage$getVideosByGroupId$1.label & Integer.MIN_VALUE) != 0) {
                dBDataStorage$getVideosByGroupId$1.label -= Integer.MIN_VALUE;
                Object $result = dBDataStorage$getVideosByGroupId$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (dBDataStorage$getVideosByGroupId$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        logTag$iv = "getVideosByGroupId";
                        Result.Companion companion = Result.Companion;
                        DBDataStorage $this$safeCall_u24lambda_u240$iv = this;
                        OfflineVideoDao offlineVideoDao = this.dao;
                        dBDataStorage$getVideosByGroupId$1.L$0 = SpillingKt.nullOutSpilledVariable(keyword);
                        dBDataStorage$getVideosByGroupId$1.L$1 = SpillingKt.nullOutSpilledVariable(this);
                        dBDataStorage$getVideosByGroupId$1.L$2 = "getVideosByGroupId";
                        dBDataStorage$getVideosByGroupId$1.L$3 = SpillingKt.nullOutSpilledVariable($this$safeCall_u24lambda_u240$iv);
                        dBDataStorage$getVideosByGroupId$1.J$0 = groupId;
                        dBDataStorage$getVideosByGroupId$1.I$0 = 0;
                        dBDataStorage$getVideosByGroupId$1.I$1 = 0;
                        dBDataStorage$getVideosByGroupId$1.I$2 = 0;
                        dBDataStorage$getVideosByGroupId$1.label = 1;
                        videosByGroupId = offlineVideoDao.getVideosByGroupId(groupId, keyword, dBDataStorage$getVideosByGroupId$1);
                        if (videosByGroupId != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        int i = dBDataStorage$getVideosByGroupId$1.I$2;
                        int i2 = dBDataStorage$getVideosByGroupId$1.I$1;
                        int i3 = dBDataStorage$getVideosByGroupId$1.I$0;
                        long groupId2 = dBDataStorage$getVideosByGroupId$1.J$0;
                        DBDataStorage dBDataStorage = (DBDataStorage) dBDataStorage$getVideosByGroupId$1.L$3;
                        logTag$iv = (String) dBDataStorage$getVideosByGroupId$1.L$2;
                        DBDataStorage dBDataStorage2 = (DBDataStorage) dBDataStorage$getVideosByGroupId$1.L$1;
                        String str = (String) dBDataStorage$getVideosByGroupId$1.L$0;
                        ResultKt.throwOnFailure($result);
                        videosByGroupId = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj = Result.constructor-impl((List) videosByGroupId);
                it$iv = Result.exceptionOrNull-impl(obj);
                if (it$iv != null) {
                    new DataLog().error("DBDataStorage " + logTag$iv + " error", it$iv);
                }
                if (Result.isFailure-impl(obj)) {
                    obj = null;
                }
                List list = (List) obj;
                return list != null ? CollectionsKt.emptyList() : list;
            }
        }
        dBDataStorage$getVideosByGroupId$1 = new DBDataStorage$getVideosByGroupId$1(this, continuation);
        Object $result2 = dBDataStorage$getVideosByGroupId$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (dBDataStorage$getVideosByGroupId$1.label) {
        }
        obj = Result.constructor-impl((List) videosByGroupId);
        it$iv = Result.exceptionOrNull-impl(obj);
        if (it$iv != null) {
        }
        if (Result.isFailure-impl(obj)) {
        }
        List list2 = (List) obj;
        if (list2 != null) {
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:1|(2:3|(11:5|6|7|8|15|16|(1:18)|19|(1:21)|22|(2:24|25)(1:26)))|35|6|7|8|15|16|(0)|19|(0)|22|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x008a, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x008b, code lost:
        r3 = kotlin.Result.Companion;
        r2 = kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(r2));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getVideosByVideoId(long videoId, String keyword, Continuation<? super List<OfflineVideoEntity>> continuation) {
        DBDataStorage$getVideosByVideoId$1 dBDataStorage$getVideosByVideoId$1;
        Object obj;
        Throwable it$iv;
        String logTag$iv;
        Object videosByVideoId;
        if (continuation instanceof DBDataStorage$getVideosByVideoId$1) {
            dBDataStorage$getVideosByVideoId$1 = (DBDataStorage$getVideosByVideoId$1) continuation;
            if ((dBDataStorage$getVideosByVideoId$1.label & Integer.MIN_VALUE) != 0) {
                dBDataStorage$getVideosByVideoId$1.label -= Integer.MIN_VALUE;
                Object $result = dBDataStorage$getVideosByVideoId$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (dBDataStorage$getVideosByVideoId$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        logTag$iv = "getVideosByVideoId";
                        Result.Companion companion = Result.Companion;
                        DBDataStorage $this$safeCall_u24lambda_u240$iv = this;
                        OfflineVideoDao offlineVideoDao = this.dao;
                        dBDataStorage$getVideosByVideoId$1.L$0 = SpillingKt.nullOutSpilledVariable(keyword);
                        dBDataStorage$getVideosByVideoId$1.L$1 = SpillingKt.nullOutSpilledVariable(this);
                        dBDataStorage$getVideosByVideoId$1.L$2 = "getVideosByVideoId";
                        dBDataStorage$getVideosByVideoId$1.L$3 = SpillingKt.nullOutSpilledVariable($this$safeCall_u24lambda_u240$iv);
                        dBDataStorage$getVideosByVideoId$1.J$0 = videoId;
                        dBDataStorage$getVideosByVideoId$1.I$0 = 0;
                        dBDataStorage$getVideosByVideoId$1.I$1 = 0;
                        dBDataStorage$getVideosByVideoId$1.I$2 = 0;
                        dBDataStorage$getVideosByVideoId$1.label = 1;
                        videosByVideoId = offlineVideoDao.getVideosByVideoId(videoId, keyword, dBDataStorage$getVideosByVideoId$1);
                        if (videosByVideoId != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        int i = dBDataStorage$getVideosByVideoId$1.I$2;
                        int i2 = dBDataStorage$getVideosByVideoId$1.I$1;
                        int i3 = dBDataStorage$getVideosByVideoId$1.I$0;
                        long videoId2 = dBDataStorage$getVideosByVideoId$1.J$0;
                        DBDataStorage dBDataStorage = (DBDataStorage) dBDataStorage$getVideosByVideoId$1.L$3;
                        logTag$iv = (String) dBDataStorage$getVideosByVideoId$1.L$2;
                        DBDataStorage dBDataStorage2 = (DBDataStorage) dBDataStorage$getVideosByVideoId$1.L$1;
                        String str = (String) dBDataStorage$getVideosByVideoId$1.L$0;
                        ResultKt.throwOnFailure($result);
                        videosByVideoId = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj = Result.constructor-impl((List) videosByVideoId);
                it$iv = Result.exceptionOrNull-impl(obj);
                if (it$iv != null) {
                    new DataLog().error("DBDataStorage " + logTag$iv + " error", it$iv);
                }
                if (Result.isFailure-impl(obj)) {
                    obj = null;
                }
                List list = (List) obj;
                return list != null ? CollectionsKt.emptyList() : list;
            }
        }
        dBDataStorage$getVideosByVideoId$1 = new DBDataStorage$getVideosByVideoId$1(this, continuation);
        Object $result2 = dBDataStorage$getVideosByVideoId$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (dBDataStorage$getVideosByVideoId$1.label) {
        }
        obj = Result.constructor-impl((List) videosByVideoId);
        it$iv = Result.exceptionOrNull-impl(obj);
        if (it$iv != null) {
        }
        if (Result.isFailure-impl(obj)) {
        }
        List list2 = (List) obj;
        if (list2 != null) {
        }
    }

    public final Flow<List<OfflineVideoEntity>> getVideosFlowByVideoId(long videoId, String keyword) {
        Object obj;
        Intrinsics.checkNotNullParameter(keyword, ChronosDanmakuSender.KEY_MARK_DANMAKU);
        try {
            Result.Companion companion = Result.Companion;
            DBDataStorage dBDataStorage = this;
            obj = Result.constructor-impl(this.dao.getVideosFlowByVideoId(videoId, keyword));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable it$iv = Result.exceptionOrNull-impl(obj);
        if (it$iv != null) {
            new DataLog().error("DBDataStorage getVideosFlowByVideoId error", it$iv);
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        Flow<List<OfflineVideoEntity>> flow = (Flow) obj;
        return flow == null ? FlowKt.emptyFlow() : flow;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:1|(2:3|(11:5|6|7|8|15|16|(1:18)|19|(1:21)|22|(2:24|25)(1:26)))|35|6|7|8|15|16|(0)|19|(0)|22|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0080, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0081, code lost:
        r3 = kotlin.Result.Companion;
        r2 = kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(r2));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getVideosByPageId(long pageId, Continuation<? super List<OfflineVideoEntity>> continuation) {
        DBDataStorage$getVideosByPageId$1 dBDataStorage$getVideosByPageId$1;
        Object obj;
        Throwable it$iv;
        String logTag$iv;
        Object videosByPageId;
        if (continuation instanceof DBDataStorage$getVideosByPageId$1) {
            dBDataStorage$getVideosByPageId$1 = (DBDataStorage$getVideosByPageId$1) continuation;
            if ((dBDataStorage$getVideosByPageId$1.label & Integer.MIN_VALUE) != 0) {
                dBDataStorage$getVideosByPageId$1.label -= Integer.MIN_VALUE;
                Object $result = dBDataStorage$getVideosByPageId$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (dBDataStorage$getVideosByPageId$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        logTag$iv = "getVideosByPageId";
                        Result.Companion companion = Result.Companion;
                        DBDataStorage $this$safeCall_u24lambda_u240$iv = this;
                        OfflineVideoDao offlineVideoDao = this.dao;
                        dBDataStorage$getVideosByPageId$1.L$0 = SpillingKt.nullOutSpilledVariable(this);
                        dBDataStorage$getVideosByPageId$1.L$1 = logTag$iv;
                        dBDataStorage$getVideosByPageId$1.L$2 = SpillingKt.nullOutSpilledVariable($this$safeCall_u24lambda_u240$iv);
                        dBDataStorage$getVideosByPageId$1.J$0 = pageId;
                        dBDataStorage$getVideosByPageId$1.I$0 = 0;
                        dBDataStorage$getVideosByPageId$1.I$1 = 0;
                        dBDataStorage$getVideosByPageId$1.I$2 = 0;
                        dBDataStorage$getVideosByPageId$1.label = 1;
                        videosByPageId = offlineVideoDao.getVideosByPageId(pageId, dBDataStorage$getVideosByPageId$1);
                        if (videosByPageId != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        int i = dBDataStorage$getVideosByPageId$1.I$2;
                        int i2 = dBDataStorage$getVideosByPageId$1.I$1;
                        int i3 = dBDataStorage$getVideosByPageId$1.I$0;
                        long pageId2 = dBDataStorage$getVideosByPageId$1.J$0;
                        DBDataStorage dBDataStorage = (DBDataStorage) dBDataStorage$getVideosByPageId$1.L$2;
                        logTag$iv = (String) dBDataStorage$getVideosByPageId$1.L$1;
                        DBDataStorage dBDataStorage2 = (DBDataStorage) dBDataStorage$getVideosByPageId$1.L$0;
                        ResultKt.throwOnFailure($result);
                        videosByPageId = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj = Result.constructor-impl((List) videosByPageId);
                it$iv = Result.exceptionOrNull-impl(obj);
                if (it$iv != null) {
                    new DataLog().error("DBDataStorage " + logTag$iv + " error", it$iv);
                }
                if (Result.isFailure-impl(obj)) {
                    obj = null;
                }
                List list = (List) obj;
                return list != null ? CollectionsKt.emptyList() : list;
            }
        }
        dBDataStorage$getVideosByPageId$1 = new DBDataStorage$getVideosByPageId$1(this, continuation);
        Object $result2 = dBDataStorage$getVideosByPageId$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (dBDataStorage$getVideosByPageId$1.label) {
        }
        obj = Result.constructor-impl((List) videosByPageId);
        it$iv = Result.exceptionOrNull-impl(obj);
        if (it$iv != null) {
        }
        if (Result.isFailure-impl(obj)) {
        }
        List list2 = (List) obj;
        if (list2 != null) {
        }
    }

    public final Flow<List<OfflineVideoEntity>> getVideosFlowByPageId(long pageId) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            DBDataStorage dBDataStorage = this;
            obj = Result.constructor-impl(this.dao.getVideosFlowByPageId(pageId));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable it$iv = Result.exceptionOrNull-impl(obj);
        if (it$iv != null) {
            new DataLog().error("DBDataStorage getVideosFlowByPageId error", it$iv);
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        Flow<List<OfflineVideoEntity>> flow = (Flow) obj;
        return flow == null ? FlowKt.emptyFlow() : flow;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(2:3|(9:5|6|7|8|15|16|(1:18)|19|(1:21)(1:22)))|31|6|7|8|15|16|(0)|19|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0086, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0087, code lost:
        r3 = kotlin.Result.Companion;
        r2 = kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(r2));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bf A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getVideoByKey(String key, Continuation<? super OfflineVideoEntity> continuation) {
        DBDataStorage$getVideoByKey$1 dBDataStorage$getVideoByKey$1;
        Object obj;
        Throwable it$iv;
        String logTag$iv;
        Object videoByKey;
        if (continuation instanceof DBDataStorage$getVideoByKey$1) {
            dBDataStorage$getVideoByKey$1 = (DBDataStorage$getVideoByKey$1) continuation;
            if ((dBDataStorage$getVideoByKey$1.label & Integer.MIN_VALUE) != 0) {
                dBDataStorage$getVideoByKey$1.label -= Integer.MIN_VALUE;
                Object $result = dBDataStorage$getVideoByKey$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (dBDataStorage$getVideoByKey$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        logTag$iv = "getVideoByKey";
                        Result.Companion companion = Result.Companion;
                        DBDataStorage $this$safeCall_u24lambda_u240$iv = this;
                        OfflineVideoDao offlineVideoDao = this.dao;
                        dBDataStorage$getVideoByKey$1.L$0 = SpillingKt.nullOutSpilledVariable(key);
                        dBDataStorage$getVideoByKey$1.L$1 = SpillingKt.nullOutSpilledVariable(this);
                        dBDataStorage$getVideoByKey$1.L$2 = "getVideoByKey";
                        dBDataStorage$getVideoByKey$1.L$3 = SpillingKt.nullOutSpilledVariable($this$safeCall_u24lambda_u240$iv);
                        dBDataStorage$getVideoByKey$1.I$0 = 0;
                        dBDataStorage$getVideoByKey$1.I$1 = 0;
                        dBDataStorage$getVideoByKey$1.I$2 = 0;
                        dBDataStorage$getVideoByKey$1.label = 1;
                        videoByKey = offlineVideoDao.getVideoByKey(key, dBDataStorage$getVideoByKey$1);
                        if (videoByKey != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        int i = dBDataStorage$getVideoByKey$1.I$2;
                        int i2 = dBDataStorage$getVideoByKey$1.I$1;
                        int i3 = dBDataStorage$getVideoByKey$1.I$0;
                        DBDataStorage dBDataStorage = (DBDataStorage) dBDataStorage$getVideoByKey$1.L$3;
                        logTag$iv = (String) dBDataStorage$getVideoByKey$1.L$2;
                        DBDataStorage dBDataStorage2 = (DBDataStorage) dBDataStorage$getVideoByKey$1.L$1;
                        String str = (String) dBDataStorage$getVideoByKey$1.L$0;
                        ResultKt.throwOnFailure($result);
                        videoByKey = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj = Result.constructor-impl((OfflineVideoEntity) videoByKey);
                it$iv = Result.exceptionOrNull-impl(obj);
                if (it$iv != null) {
                    new DataLog().error("DBDataStorage " + logTag$iv + " error", it$iv);
                }
                if (Result.isFailure-impl(obj)) {
                    return obj;
                }
                return null;
            }
        }
        dBDataStorage$getVideoByKey$1 = new DBDataStorage$getVideoByKey$1(this, continuation);
        Object $result2 = dBDataStorage$getVideoByKey$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (dBDataStorage$getVideoByKey$1.label) {
        }
        obj = Result.constructor-impl((OfflineVideoEntity) videoByKey);
        it$iv = Result.exceptionOrNull-impl(obj);
        if (it$iv != null) {
        }
        if (Result.isFailure-impl(obj)) {
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:1|(2:3|(11:5|6|7|8|15|16|(1:18)|19|(1:21)|22|(2:24|25)(1:26)))|35|6|7|8|15|16|(0)|19|(0)|22|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0086, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0087, code lost:
        r3 = kotlin.Result.Companion;
        r2 = kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(r2));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getVideosByKeys(List<String> list, Continuation<? super List<OfflineVideoEntity>> continuation) {
        DBDataStorage$getVideosByKeys$1 dBDataStorage$getVideosByKeys$1;
        Object obj;
        Throwable it$iv;
        String logTag$iv;
        Object videosByKeys;
        if (continuation instanceof DBDataStorage$getVideosByKeys$1) {
            dBDataStorage$getVideosByKeys$1 = (DBDataStorage$getVideosByKeys$1) continuation;
            if ((dBDataStorage$getVideosByKeys$1.label & Integer.MIN_VALUE) != 0) {
                dBDataStorage$getVideosByKeys$1.label -= Integer.MIN_VALUE;
                Object $result = dBDataStorage$getVideosByKeys$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (dBDataStorage$getVideosByKeys$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        logTag$iv = "getVideosByKeys";
                        Result.Companion companion = Result.Companion;
                        DBDataStorage $this$safeCall_u24lambda_u240$iv = this;
                        OfflineVideoDao offlineVideoDao = this.dao;
                        dBDataStorage$getVideosByKeys$1.L$0 = SpillingKt.nullOutSpilledVariable(list);
                        dBDataStorage$getVideosByKeys$1.L$1 = SpillingKt.nullOutSpilledVariable(this);
                        dBDataStorage$getVideosByKeys$1.L$2 = "getVideosByKeys";
                        dBDataStorage$getVideosByKeys$1.L$3 = SpillingKt.nullOutSpilledVariable($this$safeCall_u24lambda_u240$iv);
                        dBDataStorage$getVideosByKeys$1.I$0 = 0;
                        dBDataStorage$getVideosByKeys$1.I$1 = 0;
                        dBDataStorage$getVideosByKeys$1.I$2 = 0;
                        dBDataStorage$getVideosByKeys$1.label = 1;
                        videosByKeys = offlineVideoDao.getVideosByKeys(list, dBDataStorage$getVideosByKeys$1);
                        if (videosByKeys != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        int i = dBDataStorage$getVideosByKeys$1.I$2;
                        int i2 = dBDataStorage$getVideosByKeys$1.I$1;
                        int i3 = dBDataStorage$getVideosByKeys$1.I$0;
                        DBDataStorage dBDataStorage = (DBDataStorage) dBDataStorage$getVideosByKeys$1.L$3;
                        logTag$iv = (String) dBDataStorage$getVideosByKeys$1.L$2;
                        DBDataStorage dBDataStorage2 = (DBDataStorage) dBDataStorage$getVideosByKeys$1.L$1;
                        List list2 = (List) dBDataStorage$getVideosByKeys$1.L$0;
                        ResultKt.throwOnFailure($result);
                        videosByKeys = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj = Result.constructor-impl((List) videosByKeys);
                it$iv = Result.exceptionOrNull-impl(obj);
                if (it$iv != null) {
                    new DataLog().error("DBDataStorage " + logTag$iv + " error", it$iv);
                }
                if (Result.isFailure-impl(obj)) {
                    obj = null;
                }
                List list3 = (List) obj;
                return list3 != null ? CollectionsKt.emptyList() : list3;
            }
        }
        dBDataStorage$getVideosByKeys$1 = new DBDataStorage$getVideosByKeys$1(this, continuation);
        Object $result2 = dBDataStorage$getVideosByKeys$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (dBDataStorage$getVideosByKeys$1.label) {
        }
        obj = Result.constructor-impl((List) videosByKeys);
        it$iv = Result.exceptionOrNull-impl(obj);
        if (it$iv != null) {
        }
        if (Result.isFailure-impl(obj)) {
        }
        List list32 = (List) obj;
        if (list32 != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getUnDownloadVideos(boolean includePause, boolean includeError, int limit, Continuation<? super List<OfflineVideoEntity>> continuation) {
        DBDataStorage$getUnDownloadVideos$1 dBDataStorage$getUnDownloadVideos$1;
        DBDataStorage$getUnDownloadVideos$1 dBDataStorage$getUnDownloadVideos$12;
        String logTag$iv;
        Object unDownloadFilterVideos;
        Object obj;
        Throwable it$iv;
        if (continuation instanceof DBDataStorage$getUnDownloadVideos$1) {
            dBDataStorage$getUnDownloadVideos$1 = (DBDataStorage$getUnDownloadVideos$1) continuation;
            if ((dBDataStorage$getUnDownloadVideos$1.label & Integer.MIN_VALUE) != 0) {
                dBDataStorage$getUnDownloadVideos$1.label -= Integer.MIN_VALUE;
                dBDataStorage$getUnDownloadVideos$12 = dBDataStorage$getUnDownloadVideos$1;
                Object $result = dBDataStorage$getUnDownloadVideos$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (dBDataStorage$getUnDownloadVideos$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        List filterState = CollectionsKt.mutableListOf(new Integer[]{Boxing.boxInt(OfflineVideoEntity.State.COMPLETED.INSTANCE.getStateValue())});
                        if (!includePause) {
                            filterState.add(Boxing.boxInt(new OfflineVideoEntity.State.PAUSED(0L, 0L).getStateValue()));
                        }
                        if (!includeError) {
                            filterState.add(Boxing.boxInt(new OfflineVideoEntity.State.ERROR(0).getStateValue()));
                        }
                        logTag$iv = "getUnDownloadVideos";
                        try {
                            Result.Companion companion = Result.Companion;
                            DBDataStorage $this$safeCall_u24lambda_u240$iv = this;
                            OfflineVideoDao offlineVideoDao = this.dao;
                            dBDataStorage$getUnDownloadVideos$12.L$0 = SpillingKt.nullOutSpilledVariable(filterState);
                            dBDataStorage$getUnDownloadVideos$12.L$1 = SpillingKt.nullOutSpilledVariable(this);
                            dBDataStorage$getUnDownloadVideos$12.L$2 = "getUnDownloadVideos";
                            dBDataStorage$getUnDownloadVideos$12.L$3 = SpillingKt.nullOutSpilledVariable($this$safeCall_u24lambda_u240$iv);
                            dBDataStorage$getUnDownloadVideos$12.Z$0 = includePause;
                            dBDataStorage$getUnDownloadVideos$12.Z$1 = includeError;
                            dBDataStorage$getUnDownloadVideos$12.I$0 = limit;
                            dBDataStorage$getUnDownloadVideos$12.I$1 = 0;
                            dBDataStorage$getUnDownloadVideos$12.I$2 = 0;
                            dBDataStorage$getUnDownloadVideos$12.I$3 = 0;
                            dBDataStorage$getUnDownloadVideos$12.label = 1;
                            unDownloadFilterVideos = offlineVideoDao.getUnDownloadFilterVideos(limit, filterState, dBDataStorage$getUnDownloadVideos$12);
                        } catch (Throwable th) {
                            th = th;
                            Result.Companion companion2 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                            it$iv = Result.exceptionOrNull-impl(obj);
                            if (it$iv != null) {
                            }
                            if (Result.isFailure-impl(obj)) {
                            }
                            List list = (List) obj;
                            if (list != null) {
                            }
                        }
                        if (unDownloadFilterVideos == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj = Result.constructor-impl((List) unDownloadFilterVideos);
                        it$iv = Result.exceptionOrNull-impl(obj);
                        if (it$iv != null) {
                            new DataLog().error("DBDataStorage " + logTag$iv + " error", it$iv);
                        }
                        if (Result.isFailure-impl(obj)) {
                            obj = null;
                        }
                        List list2 = (List) obj;
                        return list2 != null ? CollectionsKt.emptyList() : list2;
                    case 1:
                        int i = dBDataStorage$getUnDownloadVideos$12.I$3;
                        int i2 = dBDataStorage$getUnDownloadVideos$12.I$2;
                        int i3 = dBDataStorage$getUnDownloadVideos$12.I$1;
                        int i4 = dBDataStorage$getUnDownloadVideos$12.I$0;
                        boolean z = dBDataStorage$getUnDownloadVideos$12.Z$1;
                        boolean z2 = dBDataStorage$getUnDownloadVideos$12.Z$0;
                        DBDataStorage dBDataStorage = (DBDataStorage) dBDataStorage$getUnDownloadVideos$12.L$3;
                        logTag$iv = (String) dBDataStorage$getUnDownloadVideos$12.L$2;
                        DBDataStorage dBDataStorage2 = (DBDataStorage) dBDataStorage$getUnDownloadVideos$12.L$1;
                        List list3 = (List) dBDataStorage$getUnDownloadVideos$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            unDownloadFilterVideos = $result;
                            obj = Result.constructor-impl((List) unDownloadFilterVideos);
                        } catch (Throwable th2) {
                            th = th2;
                            Result.Companion companion22 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                            it$iv = Result.exceptionOrNull-impl(obj);
                            if (it$iv != null) {
                            }
                            if (Result.isFailure-impl(obj)) {
                            }
                            List list22 = (List) obj;
                            if (list22 != null) {
                            }
                        }
                        it$iv = Result.exceptionOrNull-impl(obj);
                        if (it$iv != null) {
                        }
                        if (Result.isFailure-impl(obj)) {
                        }
                        List list222 = (List) obj;
                        if (list222 != null) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        dBDataStorage$getUnDownloadVideos$1 = new DBDataStorage$getUnDownloadVideos$1(this, continuation);
        dBDataStorage$getUnDownloadVideos$12 = dBDataStorage$getUnDownloadVideos$1;
        Object $result2 = dBDataStorage$getUnDownloadVideos$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (dBDataStorage$getUnDownloadVideos$12.label) {
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:1|(2:3|(11:5|6|7|8|15|16|(1:18)|19|(1:21)|22|(2:24|25)(1:26)))|35|6|7|8|15|16|(0)|19|(0)|22|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x007c, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007d, code lost:
        r3 = kotlin.Result.Companion;
        r2 = kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(r2));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getDownloadedVideos(Continuation<? super List<OfflineVideoEntity>> continuation) {
        DBDataStorage$getDownloadedVideos$1 dBDataStorage$getDownloadedVideos$1;
        Object obj;
        Throwable it$iv;
        String logTag$iv;
        Object downloadedVideos;
        if (continuation instanceof DBDataStorage$getDownloadedVideos$1) {
            dBDataStorage$getDownloadedVideos$1 = (DBDataStorage$getDownloadedVideos$1) continuation;
            if ((dBDataStorage$getDownloadedVideos$1.label & Integer.MIN_VALUE) != 0) {
                dBDataStorage$getDownloadedVideos$1.label -= Integer.MIN_VALUE;
                Object $result = dBDataStorage$getDownloadedVideos$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (dBDataStorage$getDownloadedVideos$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        logTag$iv = "getDownloadedVideos";
                        Result.Companion companion = Result.Companion;
                        DBDataStorage $this$safeCall_u24lambda_u240$iv = this;
                        OfflineVideoDao offlineVideoDao = this.dao;
                        dBDataStorage$getDownloadedVideos$1.L$0 = SpillingKt.nullOutSpilledVariable(this);
                        dBDataStorage$getDownloadedVideos$1.L$1 = logTag$iv;
                        dBDataStorage$getDownloadedVideos$1.L$2 = SpillingKt.nullOutSpilledVariable($this$safeCall_u24lambda_u240$iv);
                        dBDataStorage$getDownloadedVideos$1.I$0 = 0;
                        dBDataStorage$getDownloadedVideos$1.I$1 = 0;
                        dBDataStorage$getDownloadedVideos$1.I$2 = 0;
                        dBDataStorage$getDownloadedVideos$1.label = 1;
                        downloadedVideos = offlineVideoDao.getDownloadedVideos(dBDataStorage$getDownloadedVideos$1);
                        if (downloadedVideos != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        int i = dBDataStorage$getDownloadedVideos$1.I$2;
                        int i2 = dBDataStorage$getDownloadedVideos$1.I$1;
                        int i3 = dBDataStorage$getDownloadedVideos$1.I$0;
                        DBDataStorage dBDataStorage = (DBDataStorage) dBDataStorage$getDownloadedVideos$1.L$2;
                        logTag$iv = (String) dBDataStorage$getDownloadedVideos$1.L$1;
                        DBDataStorage dBDataStorage2 = (DBDataStorage) dBDataStorage$getDownloadedVideos$1.L$0;
                        ResultKt.throwOnFailure($result);
                        downloadedVideos = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj = Result.constructor-impl((List) downloadedVideos);
                it$iv = Result.exceptionOrNull-impl(obj);
                if (it$iv != null) {
                    new DataLog().error("DBDataStorage " + logTag$iv + " error", it$iv);
                }
                if (Result.isFailure-impl(obj)) {
                    obj = null;
                }
                List list = (List) obj;
                return list != null ? CollectionsKt.emptyList() : list;
            }
        }
        dBDataStorage$getDownloadedVideos$1 = new DBDataStorage$getDownloadedVideos$1(this, continuation);
        Object $result2 = dBDataStorage$getDownloadedVideos$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (dBDataStorage$getDownloadedVideos$1.label) {
        }
        obj = Result.constructor-impl((List) downloadedVideos);
        it$iv = Result.exceptionOrNull-impl(obj);
        if (it$iv != null) {
        }
        if (Result.isFailure-impl(obj)) {
        }
        List list2 = (List) obj;
        if (list2 != null) {
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:1|(2:3|(11:5|6|7|8|15|16|(1:18)|19|(1:21)|22|(2:24|25)(1:26)))|35|6|7|8|15|16|(0)|19|(0)|22|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x007c, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007d, code lost:
        r3 = kotlin.Result.Companion;
        r2 = kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(r2));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getDownloadingVideos(Continuation<? super List<OfflineVideoEntity>> continuation) {
        DBDataStorage$getDownloadingVideos$1 dBDataStorage$getDownloadingVideos$1;
        Object obj;
        Throwable it$iv;
        String logTag$iv;
        Object downloadingVideos;
        if (continuation instanceof DBDataStorage$getDownloadingVideos$1) {
            dBDataStorage$getDownloadingVideos$1 = (DBDataStorage$getDownloadingVideos$1) continuation;
            if ((dBDataStorage$getDownloadingVideos$1.label & Integer.MIN_VALUE) != 0) {
                dBDataStorage$getDownloadingVideos$1.label -= Integer.MIN_VALUE;
                Object $result = dBDataStorage$getDownloadingVideos$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (dBDataStorage$getDownloadingVideos$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        logTag$iv = "getDownloadingVideos";
                        Result.Companion companion = Result.Companion;
                        DBDataStorage $this$safeCall_u24lambda_u240$iv = this;
                        OfflineVideoDao offlineVideoDao = this.dao;
                        dBDataStorage$getDownloadingVideos$1.L$0 = SpillingKt.nullOutSpilledVariable(this);
                        dBDataStorage$getDownloadingVideos$1.L$1 = logTag$iv;
                        dBDataStorage$getDownloadingVideos$1.L$2 = SpillingKt.nullOutSpilledVariable($this$safeCall_u24lambda_u240$iv);
                        dBDataStorage$getDownloadingVideos$1.I$0 = 0;
                        dBDataStorage$getDownloadingVideos$1.I$1 = 0;
                        dBDataStorage$getDownloadingVideos$1.I$2 = 0;
                        dBDataStorage$getDownloadingVideos$1.label = 1;
                        downloadingVideos = offlineVideoDao.getDownloadingVideos(dBDataStorage$getDownloadingVideos$1);
                        if (downloadingVideos != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        int i = dBDataStorage$getDownloadingVideos$1.I$2;
                        int i2 = dBDataStorage$getDownloadingVideos$1.I$1;
                        int i3 = dBDataStorage$getDownloadingVideos$1.I$0;
                        DBDataStorage dBDataStorage = (DBDataStorage) dBDataStorage$getDownloadingVideos$1.L$2;
                        logTag$iv = (String) dBDataStorage$getDownloadingVideos$1.L$1;
                        DBDataStorage dBDataStorage2 = (DBDataStorage) dBDataStorage$getDownloadingVideos$1.L$0;
                        ResultKt.throwOnFailure($result);
                        downloadingVideos = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj = Result.constructor-impl((List) downloadingVideos);
                it$iv = Result.exceptionOrNull-impl(obj);
                if (it$iv != null) {
                    new DataLog().error("DBDataStorage " + logTag$iv + " error", it$iv);
                }
                if (Result.isFailure-impl(obj)) {
                    obj = null;
                }
                List list = (List) obj;
                return list != null ? CollectionsKt.emptyList() : list;
            }
        }
        dBDataStorage$getDownloadingVideos$1 = new DBDataStorage$getDownloadingVideos$1(this, continuation);
        Object $result2 = dBDataStorage$getDownloadingVideos$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (dBDataStorage$getDownloadingVideos$1.label) {
        }
        obj = Result.constructor-impl((List) downloadingVideos);
        it$iv = Result.exceptionOrNull-impl(obj);
        if (it$iv != null) {
        }
        if (Result.isFailure-impl(obj)) {
        }
        List list2 = (List) obj;
        if (list2 != null) {
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:1|(2:3|(11:5|6|7|8|15|16|(1:18)|19|(1:21)|22|(2:24|25)(1:26)))|35|6|7|8|15|16|(0)|19|(0)|22|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0087, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0088, code lost:
        r3 = kotlin.Result.Companion;
        r2 = kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(r2));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object search(String keyword, Continuation<? super List<OfflineVideoEntity>> continuation) {
        DBDataStorage$search$1 dBDataStorage$search$1;
        Object obj;
        Throwable it$iv;
        String logTag$iv;
        Object search;
        if (continuation instanceof DBDataStorage$search$1) {
            dBDataStorage$search$1 = (DBDataStorage$search$1) continuation;
            if ((dBDataStorage$search$1.label & Integer.MIN_VALUE) != 0) {
                dBDataStorage$search$1.label -= Integer.MIN_VALUE;
                Object $result = dBDataStorage$search$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (dBDataStorage$search$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        logTag$iv = "search";
                        Result.Companion companion = Result.Companion;
                        DBDataStorage $this$safeCall_u24lambda_u240$iv = this;
                        OfflineVideoDao offlineVideoDao = this.dao;
                        dBDataStorage$search$1.L$0 = SpillingKt.nullOutSpilledVariable(keyword);
                        dBDataStorage$search$1.L$1 = SpillingKt.nullOutSpilledVariable(this);
                        dBDataStorage$search$1.L$2 = "search";
                        dBDataStorage$search$1.L$3 = SpillingKt.nullOutSpilledVariable($this$safeCall_u24lambda_u240$iv);
                        dBDataStorage$search$1.I$0 = 0;
                        dBDataStorage$search$1.I$1 = 0;
                        dBDataStorage$search$1.I$2 = 0;
                        dBDataStorage$search$1.label = 1;
                        search = offlineVideoDao.search(keyword, dBDataStorage$search$1);
                        if (search != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        int i = dBDataStorage$search$1.I$2;
                        int i2 = dBDataStorage$search$1.I$1;
                        int i3 = dBDataStorage$search$1.I$0;
                        DBDataStorage dBDataStorage = (DBDataStorage) dBDataStorage$search$1.L$3;
                        logTag$iv = (String) dBDataStorage$search$1.L$2;
                        DBDataStorage dBDataStorage2 = (DBDataStorage) dBDataStorage$search$1.L$1;
                        String str = (String) dBDataStorage$search$1.L$0;
                        ResultKt.throwOnFailure($result);
                        search = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj = Result.constructor-impl((List) search);
                it$iv = Result.exceptionOrNull-impl(obj);
                if (it$iv != null) {
                    new DataLog().error("DBDataStorage " + logTag$iv + " error", it$iv);
                }
                if (Result.isFailure-impl(obj)) {
                    obj = null;
                }
                List list = (List) obj;
                return list != null ? CollectionsKt.emptyList() : list;
            }
        }
        dBDataStorage$search$1 = new DBDataStorage$search$1(this, continuation);
        Object $result2 = dBDataStorage$search$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (dBDataStorage$search$1.label) {
        }
        obj = Result.constructor-impl((List) search);
        it$iv = Result.exceptionOrNull-impl(obj);
        if (it$iv != null) {
        }
        if (Result.isFailure-impl(obj)) {
        }
        List list2 = (List) obj;
        if (list2 != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object removeVideo(List<String> list, Continuation<? super List<OfflineVideoEntity>> continuation) {
        DBDataStorage$removeVideo$1 dBDataStorage$removeVideo$1;
        DBDataStorage$removeVideo$1 dBDataStorage$removeVideo$12;
        Object coroutine_suspended;
        String logTag$iv;
        DBDataStorage this_$iv;
        Object videosByKeys;
        DBDataStorage $this$safeCall_u24lambda_u240$iv;
        int i;
        int $i$f$safeCall;
        int $i$f$safeCall2;
        OfflineVideoDao offlineVideoDao;
        List list2;
        Object obj;
        Throwable it$iv;
        List ids = list;
        if (continuation instanceof DBDataStorage$removeVideo$1) {
            dBDataStorage$removeVideo$1 = (DBDataStorage$removeVideo$1) continuation;
            if ((dBDataStorage$removeVideo$1.label & Integer.MIN_VALUE) != 0) {
                dBDataStorage$removeVideo$1.label -= Integer.MIN_VALUE;
                dBDataStorage$removeVideo$12 = dBDataStorage$removeVideo$1;
                Object $result = dBDataStorage$removeVideo$12.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (dBDataStorage$removeVideo$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        logTag$iv = "removeVideo";
                        this_$iv = this;
                        try {
                            Result.Companion companion = Result.Companion;
                            DBDataStorage $this$safeCall_u24lambda_u240$iv2 = this_$iv;
                            OfflineVideoDao offlineVideoDao2 = this.dao;
                            dBDataStorage$removeVideo$12.L$0 = ids;
                            dBDataStorage$removeVideo$12.L$1 = SpillingKt.nullOutSpilledVariable(this_$iv);
                            dBDataStorage$removeVideo$12.L$2 = "removeVideo";
                            dBDataStorage$removeVideo$12.L$3 = SpillingKt.nullOutSpilledVariable($this$safeCall_u24lambda_u240$iv2);
                            dBDataStorage$removeVideo$12.I$0 = 0;
                            dBDataStorage$removeVideo$12.I$1 = 0;
                            dBDataStorage$removeVideo$12.I$2 = 0;
                            dBDataStorage$removeVideo$12.label = 1;
                            videosByKeys = offlineVideoDao2.getVideosByKeys(ids, dBDataStorage$removeVideo$12);
                            if (videosByKeys != coroutine_suspended) {
                                $this$safeCall_u24lambda_u240$iv = $this$safeCall_u24lambda_u240$iv2;
                                i = 0;
                                $i$f$safeCall = 0;
                                $i$f$safeCall2 = 0;
                                break;
                            } else {
                                return coroutine_suspended;
                            }
                        } catch (Throwable th) {
                            th = th;
                            Result.Companion companion2 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                            it$iv = Result.exceptionOrNull-impl(obj);
                            if (it$iv != null) {
                            }
                            if (Result.isFailure-impl(obj)) {
                            }
                            List list3 = (List) obj;
                            if (list3 == null) {
                            }
                        }
                        break;
                    case 1:
                        i = dBDataStorage$removeVideo$12.I$2;
                        $i$f$safeCall2 = dBDataStorage$removeVideo$12.I$1;
                        $i$f$safeCall = dBDataStorage$removeVideo$12.I$0;
                        $this$safeCall_u24lambda_u240$iv = (DBDataStorage) dBDataStorage$removeVideo$12.L$3;
                        logTag$iv = (String) dBDataStorage$removeVideo$12.L$2;
                        this_$iv = (DBDataStorage) dBDataStorage$removeVideo$12.L$1;
                        ids = (List) dBDataStorage$removeVideo$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            videosByKeys = $result;
                            break;
                        } catch (Throwable th2) {
                            th = th2;
                            Result.Companion companion22 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                            it$iv = Result.exceptionOrNull-impl(obj);
                            if (it$iv != null) {
                            }
                            if (Result.isFailure-impl(obj)) {
                            }
                            List list32 = (List) obj;
                            if (list32 == null) {
                            }
                        }
                        break;
                    case 2:
                        int i2 = dBDataStorage$removeVideo$12.I$2;
                        int i3 = dBDataStorage$removeVideo$12.I$1;
                        int i4 = dBDataStorage$removeVideo$12.I$0;
                        list2 = (List) dBDataStorage$removeVideo$12.L$4;
                        DBDataStorage dBDataStorage = (DBDataStorage) dBDataStorage$removeVideo$12.L$3;
                        logTag$iv = (String) dBDataStorage$removeVideo$12.L$2;
                        DBDataStorage dBDataStorage2 = (DBDataStorage) dBDataStorage$removeVideo$12.L$1;
                        ids = (List) dBDataStorage$removeVideo$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            new DataLog().info("DBStorage removeVideo " + ids);
                            obj = Result.constructor-impl(list2);
                        } catch (Throwable th3) {
                            th = th3;
                            Result.Companion companion222 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                            it$iv = Result.exceptionOrNull-impl(obj);
                            if (it$iv != null) {
                            }
                            if (Result.isFailure-impl(obj)) {
                            }
                            List list322 = (List) obj;
                            if (list322 == null) {
                            }
                        }
                        it$iv = Result.exceptionOrNull-impl(obj);
                        if (it$iv != null) {
                            new DataLog().error("DBDataStorage " + logTag$iv + " error", it$iv);
                        }
                        if (Result.isFailure-impl(obj)) {
                            obj = null;
                        }
                        List list3222 = (List) obj;
                        return list3222 == null ? CollectionsKt.emptyList() : list3222;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                List toRemove = (List) videosByKeys;
                offlineVideoDao = this.dao;
                dBDataStorage$removeVideo$12.L$0 = ids;
                dBDataStorage$removeVideo$12.L$1 = SpillingKt.nullOutSpilledVariable(this_$iv);
                dBDataStorage$removeVideo$12.L$2 = logTag$iv;
                dBDataStorage$removeVideo$12.L$3 = SpillingKt.nullOutSpilledVariable($this$safeCall_u24lambda_u240$iv);
                dBDataStorage$removeVideo$12.L$4 = toRemove;
                dBDataStorage$removeVideo$12.I$0 = $i$f$safeCall;
                dBDataStorage$removeVideo$12.I$1 = $i$f$safeCall2;
                dBDataStorage$removeVideo$12.I$2 = i;
                dBDataStorage$removeVideo$12.label = 2;
                if (offlineVideoDao.deleteByKeys(ids, dBDataStorage$removeVideo$12) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                list2 = toRemove;
                new DataLog().info("DBStorage removeVideo " + ids);
                obj = Result.constructor-impl(list2);
                it$iv = Result.exceptionOrNull-impl(obj);
                if (it$iv != null) {
                }
                if (Result.isFailure-impl(obj)) {
                }
                List list32222 = (List) obj;
                if (list32222 == null) {
                }
            }
        }
        dBDataStorage$removeVideo$1 = new DBDataStorage$removeVideo$1(this, continuation);
        dBDataStorage$removeVideo$12 = dBDataStorage$removeVideo$1;
        Object $result2 = dBDataStorage$removeVideo$12.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (dBDataStorage$removeVideo$12.label) {
        }
        List toRemove2 = (List) videosByKeys;
        offlineVideoDao = this.dao;
        dBDataStorage$removeVideo$12.L$0 = ids;
        dBDataStorage$removeVideo$12.L$1 = SpillingKt.nullOutSpilledVariable(this_$iv);
        dBDataStorage$removeVideo$12.L$2 = logTag$iv;
        dBDataStorage$removeVideo$12.L$3 = SpillingKt.nullOutSpilledVariable($this$safeCall_u24lambda_u240$iv);
        dBDataStorage$removeVideo$12.L$4 = toRemove2;
        dBDataStorage$removeVideo$12.I$0 = $i$f$safeCall;
        dBDataStorage$removeVideo$12.I$1 = $i$f$safeCall2;
        dBDataStorage$removeVideo$12.I$2 = i;
        dBDataStorage$removeVideo$12.label = 2;
        if (offlineVideoDao.deleteByKeys(ids, dBDataStorage$removeVideo$12) != coroutine_suspended) {
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(2:3|(9:5|6|7|8|14|15|(1:17)|18|19))|32|6|7|8|14|15|(0)|18|19) */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0047, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0092, code lost:
        r3 = kotlin.Result.Companion;
        r2 = kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(r2));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object updateAuthCode(List<OfflineAuthUpdate> list, Continuation<? super Unit> continuation) {
        DBDataStorage$updateAuthCode$1 dBDataStorage$updateAuthCode$1;
        Throwable it$iv;
        String logTag$iv;
        if (continuation instanceof DBDataStorage$updateAuthCode$1) {
            dBDataStorage$updateAuthCode$1 = (DBDataStorage$updateAuthCode$1) continuation;
            if ((dBDataStorage$updateAuthCode$1.label & Integer.MIN_VALUE) != 0) {
                dBDataStorage$updateAuthCode$1.label -= Integer.MIN_VALUE;
                Object $result = dBDataStorage$updateAuthCode$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (dBDataStorage$updateAuthCode$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (!list.isEmpty()) {
                            logTag$iv = "updateAuthCode";
                            Result.Companion companion = Result.Companion;
                            DBDataStorage $this$safeCallUnit_u24lambda_u240$iv = this;
                            OfflineVideoDao offlineVideoDao = this.dao;
                            dBDataStorage$updateAuthCode$1.L$0 = SpillingKt.nullOutSpilledVariable(list);
                            dBDataStorage$updateAuthCode$1.L$1 = SpillingKt.nullOutSpilledVariable(this);
                            dBDataStorage$updateAuthCode$1.L$2 = "updateAuthCode";
                            dBDataStorage$updateAuthCode$1.L$3 = SpillingKt.nullOutSpilledVariable($this$safeCallUnit_u24lambda_u240$iv);
                            dBDataStorage$updateAuthCode$1.I$0 = 0;
                            dBDataStorage$updateAuthCode$1.I$1 = 0;
                            dBDataStorage$updateAuthCode$1.I$2 = 0;
                            dBDataStorage$updateAuthCode$1.label = 1;
                            if (offlineVideoDao.updateVerificationCodeBatch(list, dBDataStorage$updateAuthCode$1) != coroutine_suspended) {
                                break;
                            } else {
                                return coroutine_suspended;
                            }
                        } else {
                            return Unit.INSTANCE;
                        }
                    case 1:
                        int i = dBDataStorage$updateAuthCode$1.I$2;
                        int i2 = dBDataStorage$updateAuthCode$1.I$1;
                        int i3 = dBDataStorage$updateAuthCode$1.I$0;
                        DBDataStorage dBDataStorage = (DBDataStorage) dBDataStorage$updateAuthCode$1.L$3;
                        logTag$iv = (String) dBDataStorage$updateAuthCode$1.L$2;
                        DBDataStorage dBDataStorage2 = (DBDataStorage) dBDataStorage$updateAuthCode$1.L$1;
                        List list2 = (List) dBDataStorage$updateAuthCode$1.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Object obj = Result.constructor-impl(Unit.INSTANCE);
                it$iv = Result.exceptionOrNull-impl(obj);
                if (it$iv != null) {
                    new DataLog().error("DBDataStorage " + logTag$iv + " error", it$iv);
                }
                return Unit.INSTANCE;
            }
        }
        dBDataStorage$updateAuthCode$1 = new DBDataStorage$updateAuthCode$1(this, continuation);
        Object $result2 = dBDataStorage$updateAuthCode$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (dBDataStorage$updateAuthCode$1.label) {
        }
        Object obj2 = Result.constructor-impl(Unit.INSTANCE);
        it$iv = Result.exceptionOrNull-impl(obj2);
        if (it$iv != null) {
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(2:3|(9:5|6|7|8|14|15|(1:17)|18|19))|32|6|7|8|14|15|(0)|18|19) */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0047, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0092, code lost:
        r3 = kotlin.Result.Companion;
        r2 = kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(r2));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object updateVideo(List<OfflineVideoEntity> list, Continuation<? super Unit> continuation) {
        DBDataStorage$updateVideo$1 dBDataStorage$updateVideo$1;
        Throwable it$iv;
        String logTag$iv;
        if (continuation instanceof DBDataStorage$updateVideo$1) {
            dBDataStorage$updateVideo$1 = (DBDataStorage$updateVideo$1) continuation;
            if ((dBDataStorage$updateVideo$1.label & Integer.MIN_VALUE) != 0) {
                dBDataStorage$updateVideo$1.label -= Integer.MIN_VALUE;
                Object $result = dBDataStorage$updateVideo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (dBDataStorage$updateVideo$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (!list.isEmpty()) {
                            logTag$iv = "updateVideo batch";
                            Result.Companion companion = Result.Companion;
                            DBDataStorage $this$safeCallUnit_u24lambda_u240$iv = this;
                            OfflineVideoDao offlineVideoDao = this.dao;
                            dBDataStorage$updateVideo$1.L$0 = SpillingKt.nullOutSpilledVariable(list);
                            dBDataStorage$updateVideo$1.L$1 = SpillingKt.nullOutSpilledVariable(this);
                            dBDataStorage$updateVideo$1.L$2 = "updateVideo batch";
                            dBDataStorage$updateVideo$1.L$3 = SpillingKt.nullOutSpilledVariable($this$safeCallUnit_u24lambda_u240$iv);
                            dBDataStorage$updateVideo$1.I$0 = 0;
                            dBDataStorage$updateVideo$1.I$1 = 0;
                            dBDataStorage$updateVideo$1.I$2 = 0;
                            dBDataStorage$updateVideo$1.label = 1;
                            if (offlineVideoDao.update(list, (Continuation<? super Unit>) dBDataStorage$updateVideo$1) != coroutine_suspended) {
                                break;
                            } else {
                                return coroutine_suspended;
                            }
                        } else {
                            return Unit.INSTANCE;
                        }
                    case 1:
                        int i = dBDataStorage$updateVideo$1.I$2;
                        int i2 = dBDataStorage$updateVideo$1.I$1;
                        int i3 = dBDataStorage$updateVideo$1.I$0;
                        DBDataStorage dBDataStorage = (DBDataStorage) dBDataStorage$updateVideo$1.L$3;
                        logTag$iv = (String) dBDataStorage$updateVideo$1.L$2;
                        DBDataStorage dBDataStorage2 = (DBDataStorage) dBDataStorage$updateVideo$1.L$1;
                        List list2 = (List) dBDataStorage$updateVideo$1.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Object obj = Result.constructor-impl(Unit.INSTANCE);
                it$iv = Result.exceptionOrNull-impl(obj);
                if (it$iv != null) {
                    new DataLog().error("DBDataStorage " + logTag$iv + " error", it$iv);
                }
                return Unit.INSTANCE;
            }
        }
        dBDataStorage$updateVideo$1 = new DBDataStorage$updateVideo$1(this, continuation);
        Object $result2 = dBDataStorage$updateVideo$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (dBDataStorage$updateVideo$1.label) {
        }
        Object obj2 = Result.constructor-impl(Unit.INSTANCE);
        it$iv = Result.exceptionOrNull-impl(obj2);
        if (it$iv != null) {
        }
        return Unit.INSTANCE;
    }

    public final void resetDB$infra_debug() {
        Object obj;
        new DataLog().info("DBStorage resetDB");
        try {
            Result.Companion companion = Result.Companion;
            DBDataStorage dBDataStorage = this;
            OfflineDatabase_androidKt.deleteDB();
            obj = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable it$iv = Result.exceptionOrNull-impl(obj);
        if (it$iv != null) {
            new DataLog().error("DBDataStorage resetDB error", it$iv);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(2:3|(9:5|6|7|8|14|15|(1:17)|18|19))|28|6|7|8|14|15|(0)|18|19) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0086, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0087, code lost:
        r3 = kotlin.Result.Companion;
        r2 = kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(r2));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object clearDBRecords$infra_debug(Continuation<? super Unit> continuation) {
        DBDataStorage$clearDBRecords$1 dBDataStorage$clearDBRecords$1;
        Throwable it$iv;
        String logTag$iv;
        if (continuation instanceof DBDataStorage$clearDBRecords$1) {
            dBDataStorage$clearDBRecords$1 = (DBDataStorage$clearDBRecords$1) continuation;
            if ((dBDataStorage$clearDBRecords$1.label & Integer.MIN_VALUE) != 0) {
                dBDataStorage$clearDBRecords$1.label -= Integer.MIN_VALUE;
                Object $result = dBDataStorage$clearDBRecords$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (dBDataStorage$clearDBRecords$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        new DataLog().info("DBStorage clearDBRecords");
                        logTag$iv = "clearDBRecords";
                        Result.Companion companion = Result.Companion;
                        DBDataStorage $this$safeCallUnit_u24lambda_u240$iv = this;
                        OfflineVideoDao offlineVideoDao = this.dao;
                        dBDataStorage$clearDBRecords$1.L$0 = SpillingKt.nullOutSpilledVariable(this);
                        dBDataStorage$clearDBRecords$1.L$1 = logTag$iv;
                        dBDataStorage$clearDBRecords$1.L$2 = SpillingKt.nullOutSpilledVariable($this$safeCallUnit_u24lambda_u240$iv);
                        dBDataStorage$clearDBRecords$1.I$0 = 0;
                        dBDataStorage$clearDBRecords$1.I$1 = 0;
                        dBDataStorage$clearDBRecords$1.I$2 = 0;
                        dBDataStorage$clearDBRecords$1.label = 1;
                        if (offlineVideoDao.deleteAll(dBDataStorage$clearDBRecords$1) != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        int i = dBDataStorage$clearDBRecords$1.I$2;
                        int i2 = dBDataStorage$clearDBRecords$1.I$1;
                        int i3 = dBDataStorage$clearDBRecords$1.I$0;
                        DBDataStorage dBDataStorage = (DBDataStorage) dBDataStorage$clearDBRecords$1.L$2;
                        logTag$iv = (String) dBDataStorage$clearDBRecords$1.L$1;
                        DBDataStorage dBDataStorage2 = (DBDataStorage) dBDataStorage$clearDBRecords$1.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Object obj = Result.constructor-impl(Unit.INSTANCE);
                it$iv = Result.exceptionOrNull-impl(obj);
                if (it$iv != null) {
                    new DataLog().error("DBDataStorage " + logTag$iv + " error", it$iv);
                }
                return Unit.INSTANCE;
            }
        }
        dBDataStorage$clearDBRecords$1 = new DBDataStorage$clearDBRecords$1(this, continuation);
        Object $result2 = dBDataStorage$clearDBRecords$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (dBDataStorage$clearDBRecords$1.label) {
        }
        Object obj2 = Result.constructor-impl(Unit.INSTANCE);
        it$iv = Result.exceptionOrNull-impl(obj2);
        if (it$iv != null) {
        }
        return Unit.INSTANCE;
    }

    private final <T> T safeCall(String logTag, Function0<? extends T> function0) {
        T t;
        try {
            Result.Companion companion = Result.Companion;
            DBDataStorage dBDataStorage = this;
            t = (T) Result.constructor-impl(function0.invoke());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            t = (T) Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable it = Result.exceptionOrNull-impl(t);
        if (it != null) {
            new DataLog().error("DBDataStorage " + logTag + " error", it);
        }
        if (Result.isFailure-impl(t)) {
            return null;
        }
        return t;
    }

    private final void safeCallUnit(String logTag, Function0<Unit> function0) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            DBDataStorage dBDataStorage = this;
            function0.invoke();
            obj = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable it = Result.exceptionOrNull-impl(obj);
        if (it != null) {
            new DataLog().error("DBDataStorage " + logTag + " error", it);
        }
    }
}