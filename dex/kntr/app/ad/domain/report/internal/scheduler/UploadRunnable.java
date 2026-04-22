package kntr.app.ad.domain.report.internal.scheduler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kntr.app.ad.domain.report.internal.ReportConfig;
import kntr.app.ad.domain.report.internal.ReportRecord;
import kntr.app.ad.domain.report.internal.cache.IReportStorageManager;
import kntr.app.ad.domain.report.internal.upload.IReportUploader;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: UploadRunnable.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0012\u001a\u00020\u0013H\u0080@¢\u0006\u0004\b\u0014\u0010\u0015J\u001e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\tH\u0082@¢\u0006\u0002\u0010\u001aJ$\u0010\u0016\u001a\u00020\u00132\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u001c2\u0006\u0010\u0019\u001a\u00020\tH\u0082@¢\u0006\u0002\u0010\u001dJ2\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001f0\u001c0\u001c\"\u0004\b\u0000\u0010\u001f*\b\u0012\u0004\u0012\u0002H\u001f0\u001c2\u0006\u0010 \u001a\u00020!H\u0082@¢\u0006\u0002\u0010\"R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lkntr/app/ad/domain/report/internal/scheduler/UploadRunnable;", RoomRecommendViewModel.EMPTY_CURSOR, "persistence", "Lkntr/app/ad/domain/report/internal/cache/IReportStorageManager;", "dataUploader", "Lkntr/app/ad/domain/report/internal/upload/IReportUploader;", "config", "Lkntr/app/ad/domain/report/internal/ReportConfig;", "supportBatch", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Lkntr/app/ad/domain/report/internal/cache/IReportStorageManager;Lkntr/app/ad/domain/report/internal/upload/IReportUploader;Lkntr/app/ad/domain/report/internal/ReportConfig;Z)V", "isFromStartUp", "()Z", "setFromStartUp", "(Z)V", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "run", RoomRecommendViewModel.EMPTY_CURSOR, "run$report_debug", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumeBatch", "data", "Lkntr/app/ad/domain/report/internal/ReportRecord;", "needRetry", "(Lkntr/app/ad/domain/report/internal/ReportRecord;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dataList", RoomRecommendViewModel.EMPTY_CURSOR, "(Ljava/util/List;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "splitList", "T", "pageSize", RoomRecommendViewModel.EMPTY_CURSOR, "(Ljava/util/List;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "report_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UploadRunnable {
    private final ReportConfig config;
    private final IReportUploader dataUploader;
    private boolean isFromStartUp;
    private final Mutex mutex;
    private final IReportStorageManager persistence;
    private final boolean supportBatch;

    public UploadRunnable(IReportStorageManager persistence, IReportUploader dataUploader, ReportConfig config, boolean supportBatch) {
        Intrinsics.checkNotNullParameter(persistence, "persistence");
        Intrinsics.checkNotNullParameter(dataUploader, "dataUploader");
        Intrinsics.checkNotNullParameter(config, "config");
        this.persistence = persistence;
        this.dataUploader = dataUploader;
        this.config = config;
        this.supportBatch = supportBatch;
        this.isFromStartUp = true;
        this.mutex = MutexKt.Mutex$default(false, 1, (Object) null);
    }

    public final boolean isFromStartUp() {
        return this.isFromStartUp;
    }

    public final void setFromStartUp(boolean z) {
        this.isFromStartUp = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0126  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x0116 -> B:40:0x011f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object run$report_debug(Continuation<? super Unit> continuation) {
        UploadRunnable$run$1 uploadRunnable$run$1;
        Object load;
        List list;
        List $this$forEach$iv;
        Iterable $this$forEach$iv2;
        int $i$f$forEach;
        Iterator it;
        UploadRunnable uploadRunnable;
        UploadRunnable uploadRunnable2;
        List dataList;
        Iterable $this$forEach$iv3;
        Iterator it2;
        int $i$f$forEach2;
        if (continuation instanceof UploadRunnable$run$1) {
            uploadRunnable$run$1 = (UploadRunnable$run$1) continuation;
            if ((uploadRunnable$run$1.label & Integer.MIN_VALUE) != 0) {
                uploadRunnable$run$1.label -= Integer.MIN_VALUE;
                Object $result = uploadRunnable$run$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                boolean z = true;
                switch (uploadRunnable$run$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        KLog_androidKt.getKLog().d("AdReport", "UploadRunnable run isFromStartUp=" + this.isFromStartUp);
                        IReportStorageManager iReportStorageManager = this.persistence;
                        boolean z2 = this.isFromStartUp;
                        uploadRunnable$run$1.label = 1;
                        load = iReportStorageManager.load(z2, uploadRunnable$run$1);
                        if (load == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        List dataList2 = (List) load;
                        KLog_androidKt.getKLog().d("AdReport", "UploadRunnable run loaded dataList size=" + (dataList2 == null ? Boxing.boxInt(dataList2.size()) : null));
                        list = dataList2;
                        if (list != null && !list.isEmpty()) {
                            z = false;
                        }
                        if (!z) {
                            return Unit.INSTANCE;
                        }
                        if (this.supportBatch) {
                            KLog_androidKt.getKLog().d("AdReport", "UploadRunnable run consume batch");
                            uploadRunnable$run$1.L$0 = SpillingKt.nullOutSpilledVariable(dataList2);
                            uploadRunnable$run$1.label = 3;
                            return consumeBatch((List<ReportRecord>) dataList2, false, (Continuation<? super Unit>) uploadRunnable$run$1) == coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
                        }
                        KLog_androidKt.getKLog().d("AdReport", "UploadRunnable run consume one by one");
                        List $this$forEach$iv4 = dataList2;
                        Iterator it3 = $this$forEach$iv4.iterator();
                        $this$forEach$iv = dataList2;
                        $this$forEach$iv2 = $this$forEach$iv4;
                        $i$f$forEach = 0;
                        it = it3;
                        uploadRunnable = this;
                        if (it.hasNext()) {
                            Object element$iv = it.next();
                            ReportRecord it4 = (ReportRecord) element$iv;
                            uploadRunnable$run$1.L$0 = SpillingKt.nullOutSpilledVariable($this$forEach$iv);
                            uploadRunnable$run$1.L$1 = SpillingKt.nullOutSpilledVariable($this$forEach$iv2);
                            uploadRunnable$run$1.L$2 = it;
                            uploadRunnable$run$1.L$3 = SpillingKt.nullOutSpilledVariable(element$iv);
                            uploadRunnable$run$1.L$4 = SpillingKt.nullOutSpilledVariable(it4);
                            uploadRunnable$run$1.I$0 = $i$f$forEach;
                            uploadRunnable$run$1.I$1 = 0;
                            uploadRunnable$run$1.label = 2;
                            if (uploadRunnable.consumeBatch(it4, false, (Continuation<? super Unit>) uploadRunnable$run$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            int i = $i$f$forEach;
                            uploadRunnable2 = uploadRunnable;
                            dataList = $this$forEach$iv;
                            $this$forEach$iv3 = $this$forEach$iv2;
                            it2 = it;
                            $i$f$forEach2 = i;
                            uploadRunnable = uploadRunnable2;
                            $i$f$forEach = $i$f$forEach2;
                            it = it2;
                            $this$forEach$iv2 = $this$forEach$iv3;
                            $this$forEach$iv = dataList;
                            if (it.hasNext()) {
                                return Unit.INSTANCE;
                            }
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        load = $result;
                        List dataList22 = (List) load;
                        KLog_androidKt.getKLog().d("AdReport", "UploadRunnable run loaded dataList size=" + (dataList22 == null ? Boxing.boxInt(dataList22.size()) : null));
                        list = dataList22;
                        if (list != null) {
                            z = false;
                            break;
                        }
                        if (!z) {
                        }
                        break;
                    case 2:
                        int i2 = uploadRunnable$run$1.I$1;
                        int $i$f$forEach3 = uploadRunnable$run$1.I$0;
                        ReportRecord reportRecord = (ReportRecord) uploadRunnable$run$1.L$4;
                        Object obj = uploadRunnable$run$1.L$3;
                        ResultKt.throwOnFailure($result);
                        dataList = (List) uploadRunnable$run$1.L$0;
                        $this$forEach$iv3 = (Iterable) uploadRunnable$run$1.L$1;
                        it2 = (Iterator) uploadRunnable$run$1.L$2;
                        $i$f$forEach2 = $i$f$forEach3;
                        uploadRunnable2 = this;
                        uploadRunnable = uploadRunnable2;
                        $i$f$forEach = $i$f$forEach2;
                        it = it2;
                        $this$forEach$iv2 = $this$forEach$iv3;
                        $this$forEach$iv = dataList;
                        if (it.hasNext()) {
                        }
                        break;
                    case 3:
                        List list2 = (List) uploadRunnable$run$1.L$0;
                        ResultKt.throwOnFailure($result);
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        uploadRunnable$run$1 = new UploadRunnable$run$1(this, continuation);
        Object $result2 = uploadRunnable$run$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z3 = true;
        switch (uploadRunnable$run$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object consumeBatch(ReportRecord data, boolean needRetry, Continuation<? super Unit> continuation) {
        Continuation<? super Unit> uploadRunnable$consumeBatch$1;
        Object upload$default;
        boolean status;
        if (continuation instanceof UploadRunnable$consumeBatch$1) {
            uploadRunnable$consumeBatch$1 = (UploadRunnable$consumeBatch$1) continuation;
            if ((uploadRunnable$consumeBatch$1.label & Integer.MIN_VALUE) != 0) {
                uploadRunnable$consumeBatch$1.label -= Integer.MIN_VALUE;
                Object $result = uploadRunnable$consumeBatch$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (uploadRunnable$consumeBatch$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        IReportUploader iReportUploader = this.dataUploader;
                        uploadRunnable$consumeBatch$1.L$0 = data;
                        uploadRunnable$consumeBatch$1.Z$0 = needRetry;
                        uploadRunnable$consumeBatch$1.label = 1;
                        upload$default = IReportUploader.CC.upload$default(iReportUploader, data, needRetry, null, null, null, uploadRunnable$consumeBatch$1, 28, null);
                        if (upload$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        status = ((Boolean) upload$default).booleanValue();
                        KLog_androidKt.getKLog().d("AdReport", "UploadRunnable consumeBatch status=" + status + ", data=" + data);
                        if (status) {
                            KLog_androidKt.getKLog().d("AdReport", "UploadRunnable consumeBatch saveOrUpdate data=" + data);
                            IReportStorageManager iReportStorageManager = this.persistence;
                            uploadRunnable$consumeBatch$1.L$0 = SpillingKt.nullOutSpilledVariable(data);
                            uploadRunnable$consumeBatch$1.Z$0 = needRetry;
                            uploadRunnable$consumeBatch$1.Z$1 = status;
                            uploadRunnable$consumeBatch$1.label = 3;
                            if (iReportStorageManager.saveOrUpdate(data, uploadRunnable$consumeBatch$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            KLog_androidKt.getKLog().d("AdReport", "UploadRunnable consumeBatch abandon data=" + data);
                            IReportStorageManager iReportStorageManager2 = this.persistence;
                            uploadRunnable$consumeBatch$1.L$0 = SpillingKt.nullOutSpilledVariable(data);
                            uploadRunnable$consumeBatch$1.Z$0 = needRetry;
                            uploadRunnable$consumeBatch$1.Z$1 = status;
                            uploadRunnable$consumeBatch$1.label = 2;
                            if (iReportStorageManager2.abandon(data, uploadRunnable$consumeBatch$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        return Unit.INSTANCE;
                    case 1:
                        needRetry = uploadRunnable$consumeBatch$1.Z$0;
                        data = (ReportRecord) uploadRunnable$consumeBatch$1.L$0;
                        ResultKt.throwOnFailure($result);
                        upload$default = $result;
                        status = ((Boolean) upload$default).booleanValue();
                        KLog_androidKt.getKLog().d("AdReport", "UploadRunnable consumeBatch status=" + status + ", data=" + data);
                        if (status) {
                        }
                        return Unit.INSTANCE;
                    case 2:
                    case 3:
                        boolean z = uploadRunnable$consumeBatch$1.Z$1;
                        boolean needRetry2 = uploadRunnable$consumeBatch$1.Z$0;
                        ReportRecord reportRecord = (ReportRecord) uploadRunnable$consumeBatch$1.L$0;
                        ResultKt.throwOnFailure($result);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        uploadRunnable$consumeBatch$1 = new UploadRunnable$consumeBatch$1(this, continuation);
        Object $result2 = uploadRunnable$consumeBatch$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (uploadRunnable$consumeBatch$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x02b4  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x017b -> B:28:0x01a0). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x0211 -> B:42:0x0298). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x026e -> B:41:0x0286). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object consumeBatch(List<ReportRecord> list, boolean needRetry, Continuation<? super Unit> continuation) {
        UploadRunnable$consumeBatch$2 uploadRunnable$consumeBatch$2;
        Object obj;
        boolean needRetry2;
        Iterable dataList;
        Iterator it;
        Continuation $completion;
        int i;
        List batch;
        Iterable $this$forEach$iv;
        boolean needRetry3;
        Object $this$forEach$iv2;
        int $i$f$forEach;
        Iterator it2;
        Object obj2;
        Object element$iv;
        UploadRunnable uploadRunnable;
        Object $result;
        int $i$f$forEach2;
        boolean status;
        int $i$f$forEach3;
        int $i$f$forEach4;
        boolean status2;
        Object element$iv2;
        Iterator it3;
        Iterator it4;
        Object element$iv3;
        List $this$forEach$iv3;
        List $this$forEach$iv4;
        UploadRunnable uploadRunnable2;
        Continuation $completion2;
        Continuation $continuation;
        Object element$iv4;
        boolean status3;
        UploadRunnable$consumeBatch$2 uploadRunnable$consumeBatch$22;
        boolean needRetry4;
        int $i$f$forEach5;
        UploadRunnable uploadRunnable3;
        List batch2;
        Iterable $this$forEach$iv5;
        Iterator it5;
        boolean needRetry5;
        int i2;
        Continuation $completion3;
        int $i$f$forEach6;
        int $i$f$forEach7;
        boolean status4;
        if (continuation instanceof UploadRunnable$consumeBatch$2) {
            uploadRunnable$consumeBatch$2 = (UploadRunnable$consumeBatch$2) continuation;
            if ((uploadRunnable$consumeBatch$2.label & Integer.MIN_VALUE) != 0) {
                uploadRunnable$consumeBatch$2.label -= Integer.MIN_VALUE;
                Object $result2 = uploadRunnable$consumeBatch$2.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (uploadRunnable$consumeBatch$2.label) {
                    case 0:
                        ResultKt.throwOnFailure($result2);
                        int max_batch_page_size = this.config.getMAX_BATCH_PAGE_SIZE();
                        uploadRunnable$consumeBatch$2.L$0 = SpillingKt.nullOutSpilledVariable(list);
                        uploadRunnable$consumeBatch$2.Z$0 = needRetry;
                        uploadRunnable$consumeBatch$2.label = 1;
                        Object splitList = splitList(list, max_batch_page_size, uploadRunnable$consumeBatch$2);
                        if (splitList == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj = splitList;
                        needRetry2 = needRetry;
                        dataList = list;
                        Iterable $this$forEach$iv6 = (Iterable) obj;
                        Iterable dataList2 = dataList;
                        Object $this$forEach$iv7 = $this$forEach$iv6;
                        int $i$f$forEach8 = 0;
                        it = $this$forEach$iv6.iterator();
                        UploadRunnable uploadRunnable4 = this;
                        boolean needRetry6 = needRetry2;
                        $completion = continuation;
                        if (it.hasNext()) {
                            Object element$iv5 = it.next();
                            batch = (List) element$iv5;
                            i = 0;
                            IReportUploader iReportUploader = uploadRunnable4.dataUploader;
                            uploadRunnable$consumeBatch$2.L$0 = SpillingKt.nullOutSpilledVariable(dataList2);
                            uploadRunnable$consumeBatch$2.L$1 = SpillingKt.nullOutSpilledVariable($this$forEach$iv7);
                            uploadRunnable$consumeBatch$2.L$2 = it;
                            uploadRunnable$consumeBatch$2.L$3 = SpillingKt.nullOutSpilledVariable(element$iv5);
                            uploadRunnable$consumeBatch$2.L$4 = batch;
                            uploadRunnable$consumeBatch$2.L$5 = null;
                            uploadRunnable$consumeBatch$2.L$6 = null;
                            uploadRunnable$consumeBatch$2.L$7 = null;
                            uploadRunnable$consumeBatch$2.L$8 = null;
                            uploadRunnable$consumeBatch$2.Z$0 = needRetry6;
                            uploadRunnable$consumeBatch$2.I$0 = $i$f$forEach8;
                            uploadRunnable$consumeBatch$2.I$1 = 0;
                            uploadRunnable$consumeBatch$2.label = 2;
                            Object upload = iReportUploader.upload(batch, needRetry6, uploadRunnable$consumeBatch$2);
                            if (upload == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            Object obj3 = coroutine_suspended;
                            $result = $result2;
                            $result2 = upload;
                            $this$forEach$iv = dataList2;
                            $this$forEach$iv2 = $this$forEach$iv7;
                            it2 = it;
                            element$iv = element$iv5;
                            uploadRunnable = uploadRunnable4;
                            needRetry3 = needRetry6;
                            $i$f$forEach = $i$f$forEach8;
                            obj2 = obj3;
                            boolean status5 = ((Boolean) $result2).booleanValue();
                            List list2 = batch;
                            UploadRunnable$consumeBatch$2 uploadRunnable$consumeBatch$23 = uploadRunnable$consumeBatch$2;
                            $continuation = $completion;
                            element$iv4 = element$iv;
                            status3 = status5;
                            uploadRunnable$consumeBatch$22 = uploadRunnable$consumeBatch$23;
                            UploadRunnable uploadRunnable5 = uploadRunnable;
                            needRetry4 = needRetry3;
                            $i$f$forEach5 = 0;
                            $this$forEach$iv4 = list2;
                            it4 = list2.iterator();
                            $this$forEach$iv3 = batch;
                            element$iv3 = $this$forEach$iv2;
                            it3 = it2;
                            uploadRunnable3 = uploadRunnable5;
                            if (!it4.hasNext()) {
                                Object element$iv6 = it4.next();
                                ReportRecord data = (ReportRecord) element$iv6;
                                Continuation $completion4 = $continuation;
                                if (status3) {
                                    Object $result3 = $result;
                                    IReportStorageManager iReportStorageManager = uploadRunnable3.persistence;
                                    UploadRunnable uploadRunnable6 = uploadRunnable3;
                                    uploadRunnable$consumeBatch$22.L$0 = SpillingKt.nullOutSpilledVariable($this$forEach$iv);
                                    uploadRunnable$consumeBatch$22.L$1 = SpillingKt.nullOutSpilledVariable(element$iv3);
                                    uploadRunnable$consumeBatch$22.L$2 = it3;
                                    uploadRunnable$consumeBatch$22.L$3 = SpillingKt.nullOutSpilledVariable(element$iv4);
                                    uploadRunnable$consumeBatch$22.L$4 = SpillingKt.nullOutSpilledVariable($this$forEach$iv3);
                                    uploadRunnable$consumeBatch$22.L$5 = SpillingKt.nullOutSpilledVariable($this$forEach$iv4);
                                    uploadRunnable$consumeBatch$22.L$6 = it4;
                                    uploadRunnable$consumeBatch$22.L$7 = SpillingKt.nullOutSpilledVariable(element$iv6);
                                    uploadRunnable$consumeBatch$22.L$8 = SpillingKt.nullOutSpilledVariable(data);
                                    uploadRunnable$consumeBatch$22.Z$0 = needRetry4;
                                    uploadRunnable$consumeBatch$22.I$0 = $i$f$forEach;
                                    uploadRunnable$consumeBatch$22.I$1 = i;
                                    uploadRunnable$consumeBatch$22.Z$1 = status3;
                                    uploadRunnable$consumeBatch$22.I$2 = $i$f$forEach5;
                                    uploadRunnable$consumeBatch$22.I$3 = 0;
                                    uploadRunnable$consumeBatch$22.label = 3;
                                    if (iReportStorageManager.abandon(data, uploadRunnable$consumeBatch$22) == obj2) {
                                        return obj2;
                                    }
                                    element$iv2 = element$iv4;
                                    uploadRunnable$consumeBatch$2 = uploadRunnable$consumeBatch$22;
                                    coroutine_suspended = obj2;
                                    $i$f$forEach2 = $i$f$forEach5;
                                    $i$f$forEach3 = i;
                                    $completion2 = $completion4;
                                    $result2 = $result3;
                                    uploadRunnable2 = uploadRunnable6;
                                    boolean z = needRetry4;
                                    $i$f$forEach4 = $i$f$forEach;
                                    status = status3;
                                    status2 = z;
                                    uploadRunnable3 = uploadRunnable2;
                                    element$iv4 = element$iv2;
                                    i = $i$f$forEach3;
                                    $i$f$forEach5 = $i$f$forEach2;
                                    obj2 = coroutine_suspended;
                                    $result = $result2;
                                    uploadRunnable$consumeBatch$22 = uploadRunnable$consumeBatch$2;
                                    $continuation = $completion2;
                                    boolean z2 = status2;
                                    status3 = status;
                                    $i$f$forEach = $i$f$forEach4;
                                    needRetry4 = z2;
                                    if (!it4.hasNext()) {
                                        Continuation $completion5 = $continuation;
                                        Object $result4 = $result;
                                        $completion = $completion5;
                                        uploadRunnable4 = uploadRunnable3;
                                        uploadRunnable$consumeBatch$2 = uploadRunnable$consumeBatch$22;
                                        coroutine_suspended = obj2;
                                        $i$f$forEach8 = $i$f$forEach;
                                        needRetry6 = needRetry4;
                                        it = it3;
                                        $this$forEach$iv7 = element$iv3;
                                        dataList2 = $this$forEach$iv;
                                        $result2 = $result4;
                                        if (it.hasNext()) {
                                            return Unit.INSTANCE;
                                        }
                                    }
                                } else {
                                    Object $result5 = $result;
                                    UploadRunnable uploadRunnable7 = uploadRunnable3;
                                    IReportStorageManager iReportStorageManager2 = uploadRunnable7.persistence;
                                    uploadRunnable$consumeBatch$22.L$0 = SpillingKt.nullOutSpilledVariable($this$forEach$iv);
                                    uploadRunnable$consumeBatch$22.L$1 = SpillingKt.nullOutSpilledVariable(element$iv3);
                                    uploadRunnable$consumeBatch$22.L$2 = it3;
                                    uploadRunnable$consumeBatch$22.L$3 = SpillingKt.nullOutSpilledVariable(element$iv4);
                                    uploadRunnable$consumeBatch$22.L$4 = SpillingKt.nullOutSpilledVariable($this$forEach$iv3);
                                    uploadRunnable$consumeBatch$22.L$5 = SpillingKt.nullOutSpilledVariable($this$forEach$iv4);
                                    uploadRunnable$consumeBatch$22.L$6 = it4;
                                    uploadRunnable$consumeBatch$22.L$7 = SpillingKt.nullOutSpilledVariable(element$iv6);
                                    uploadRunnable$consumeBatch$22.L$8 = SpillingKt.nullOutSpilledVariable(data);
                                    uploadRunnable$consumeBatch$22.Z$0 = needRetry4;
                                    uploadRunnable$consumeBatch$22.I$0 = $i$f$forEach;
                                    uploadRunnable$consumeBatch$22.I$1 = i;
                                    uploadRunnable$consumeBatch$22.Z$1 = status3;
                                    uploadRunnable$consumeBatch$22.I$2 = $i$f$forEach5;
                                    uploadRunnable$consumeBatch$22.I$3 = 0;
                                    uploadRunnable$consumeBatch$22.label = 4;
                                    if (iReportStorageManager2.saveOrUpdate(data, uploadRunnable$consumeBatch$22) == obj2) {
                                        return obj2;
                                    }
                                    uploadRunnable3 = uploadRunnable7;
                                    coroutine_suspended = obj2;
                                    batch2 = $this$forEach$iv3;
                                    uploadRunnable$consumeBatch$2 = uploadRunnable$consumeBatch$22;
                                    $this$forEach$iv5 = $this$forEach$iv4;
                                    $result2 = $result5;
                                    it5 = it3;
                                    needRetry5 = needRetry4;
                                    i2 = i;
                                    $completion3 = $completion4;
                                    boolean z3 = status3;
                                    $i$f$forEach6 = $i$f$forEach;
                                    $i$f$forEach7 = $i$f$forEach5;
                                    status4 = z3;
                                    obj2 = coroutine_suspended;
                                    i = i2;
                                    needRetry4 = needRetry5;
                                    it3 = it5;
                                    $this$forEach$iv4 = $this$forEach$iv5;
                                    $this$forEach$iv3 = batch2;
                                    $result = $result2;
                                    uploadRunnable$consumeBatch$22 = uploadRunnable$consumeBatch$2;
                                    $continuation = $completion3;
                                    boolean z4 = status4;
                                    $i$f$forEach5 = $i$f$forEach7;
                                    $i$f$forEach = $i$f$forEach6;
                                    status3 = z4;
                                    if (!it4.hasNext()) {
                                    }
                                }
                            }
                        }
                    case 1:
                        needRetry2 = uploadRunnable$consumeBatch$2.Z$0;
                        dataList = (List) uploadRunnable$consumeBatch$2.L$0;
                        ResultKt.throwOnFailure($result2);
                        obj = $result2;
                        Iterable $this$forEach$iv62 = (Iterable) obj;
                        Iterable dataList22 = dataList;
                        Object $this$forEach$iv72 = $this$forEach$iv62;
                        int $i$f$forEach82 = 0;
                        it = $this$forEach$iv62.iterator();
                        UploadRunnable uploadRunnable42 = this;
                        boolean needRetry62 = needRetry2;
                        $completion = continuation;
                        if (it.hasNext()) {
                        }
                        break;
                    case 2:
                        int i3 = uploadRunnable$consumeBatch$2.I$1;
                        int $i$f$forEach9 = uploadRunnable$consumeBatch$2.I$0;
                        boolean needRetry7 = uploadRunnable$consumeBatch$2.Z$0;
                        Object element$iv7 = uploadRunnable$consumeBatch$2.L$3;
                        Iterable dataList3 = (List) uploadRunnable$consumeBatch$2.L$0;
                        ResultKt.throwOnFailure($result2);
                        i = i3;
                        batch = (List) uploadRunnable$consumeBatch$2.L$4;
                        $this$forEach$iv = dataList3;
                        $completion = continuation;
                        needRetry3 = needRetry7;
                        $this$forEach$iv2 = (Iterable) uploadRunnable$consumeBatch$2.L$1;
                        $i$f$forEach = $i$f$forEach9;
                        it2 = (Iterator) uploadRunnable$consumeBatch$2.L$2;
                        obj2 = coroutine_suspended;
                        element$iv = element$iv7;
                        uploadRunnable = this;
                        $result = $result2;
                        boolean status52 = ((Boolean) $result2).booleanValue();
                        List list22 = batch;
                        UploadRunnable$consumeBatch$2 uploadRunnable$consumeBatch$232 = uploadRunnable$consumeBatch$2;
                        $continuation = $completion;
                        element$iv4 = element$iv;
                        status3 = status52;
                        uploadRunnable$consumeBatch$22 = uploadRunnable$consumeBatch$232;
                        UploadRunnable uploadRunnable52 = uploadRunnable;
                        needRetry4 = needRetry3;
                        $i$f$forEach5 = 0;
                        $this$forEach$iv4 = list22;
                        it4 = list22.iterator();
                        $this$forEach$iv3 = batch;
                        element$iv3 = $this$forEach$iv2;
                        it3 = it2;
                        uploadRunnable3 = uploadRunnable52;
                        if (!it4.hasNext()) {
                        }
                        break;
                    case 3:
                        int i4 = uploadRunnable$consumeBatch$2.I$3;
                        $i$f$forEach2 = uploadRunnable$consumeBatch$2.I$2;
                        status = uploadRunnable$consumeBatch$2.Z$1;
                        $i$f$forEach3 = uploadRunnable$consumeBatch$2.I$1;
                        $i$f$forEach4 = uploadRunnable$consumeBatch$2.I$0;
                        status2 = uploadRunnable$consumeBatch$2.Z$0;
                        ReportRecord reportRecord = (ReportRecord) uploadRunnable$consumeBatch$2.L$8;
                        Object obj4 = uploadRunnable$consumeBatch$2.L$7;
                        List batch3 = (List) uploadRunnable$consumeBatch$2.L$4;
                        Object element$iv8 = uploadRunnable$consumeBatch$2.L$3;
                        Iterator it6 = (Iterator) uploadRunnable$consumeBatch$2.L$2;
                        Object $this$forEach$iv8 = (Iterable) uploadRunnable$consumeBatch$2.L$1;
                        Iterable dataList4 = (List) uploadRunnable$consumeBatch$2.L$0;
                        ResultKt.throwOnFailure($result2);
                        element$iv2 = element$iv8;
                        it3 = it6;
                        it4 = (Iterator) uploadRunnable$consumeBatch$2.L$6;
                        element$iv3 = $this$forEach$iv8;
                        $this$forEach$iv3 = batch3;
                        $this$forEach$iv = dataList4;
                        $this$forEach$iv4 = (Iterable) uploadRunnable$consumeBatch$2.L$5;
                        uploadRunnable2 = this;
                        $completion2 = continuation;
                        uploadRunnable3 = uploadRunnable2;
                        element$iv4 = element$iv2;
                        i = $i$f$forEach3;
                        $i$f$forEach5 = $i$f$forEach2;
                        obj2 = coroutine_suspended;
                        $result = $result2;
                        uploadRunnable$consumeBatch$22 = uploadRunnable$consumeBatch$2;
                        $continuation = $completion2;
                        boolean z22 = status2;
                        status3 = status;
                        $i$f$forEach = $i$f$forEach4;
                        needRetry4 = z22;
                        if (!it4.hasNext()) {
                        }
                        break;
                    case 4:
                        int i5 = uploadRunnable$consumeBatch$2.I$3;
                        $i$f$forEach7 = uploadRunnable$consumeBatch$2.I$2;
                        status4 = uploadRunnable$consumeBatch$2.Z$1;
                        i2 = uploadRunnable$consumeBatch$2.I$1;
                        $i$f$forEach6 = uploadRunnable$consumeBatch$2.I$0;
                        boolean needRetry8 = uploadRunnable$consumeBatch$2.Z$0;
                        ReportRecord reportRecord2 = (ReportRecord) uploadRunnable$consumeBatch$2.L$8;
                        Object obj5 = uploadRunnable$consumeBatch$2.L$7;
                        List batch4 = (List) uploadRunnable$consumeBatch$2.L$4;
                        Object element$iv9 = uploadRunnable$consumeBatch$2.L$3;
                        it5 = (Iterator) uploadRunnable$consumeBatch$2.L$2;
                        Object $this$forEach$iv9 = (Iterable) uploadRunnable$consumeBatch$2.L$1;
                        Iterable dataList5 = (List) uploadRunnable$consumeBatch$2.L$0;
                        ResultKt.throwOnFailure($result2);
                        batch2 = batch4;
                        element$iv3 = $this$forEach$iv9;
                        it4 = (Iterator) uploadRunnable$consumeBatch$2.L$6;
                        $this$forEach$iv5 = (Iterable) uploadRunnable$consumeBatch$2.L$5;
                        $this$forEach$iv = dataList5;
                        element$iv4 = element$iv9;
                        needRetry5 = needRetry8;
                        uploadRunnable3 = this;
                        $completion3 = continuation;
                        obj2 = coroutine_suspended;
                        i = i2;
                        needRetry4 = needRetry5;
                        it3 = it5;
                        $this$forEach$iv4 = $this$forEach$iv5;
                        $this$forEach$iv3 = batch2;
                        $result = $result2;
                        uploadRunnable$consumeBatch$22 = uploadRunnable$consumeBatch$2;
                        $continuation = $completion3;
                        boolean z42 = status4;
                        $i$f$forEach5 = $i$f$forEach7;
                        $i$f$forEach = $i$f$forEach6;
                        status3 = z42;
                        if (!it4.hasNext()) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        uploadRunnable$consumeBatch$2 = new UploadRunnable$consumeBatch$2(this, continuation);
        Object $result22 = uploadRunnable$consumeBatch$2.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (uploadRunnable$consumeBatch$2.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0087 A[Catch: all -> 0x00c8, TryCatch #0 {all -> 0x00c8, blocks: (B:18:0x0070, B:19:0x0081, B:21:0x0087, B:23:0x008f, B:24:0x0092, B:26:0x009a, B:28:0x00a8), top: B:37:0x0070 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <T> Object splitList(List<? extends T> list, int pageSize, Continuation<? super List<? extends List<? extends T>>> continuation) {
        UploadRunnable$splitList$1 uploadRunnable$splitList$1;
        UploadRunnable$splitList$1 uploadRunnable$splitList$12;
        List $this$splitList;
        int $i$f$withLock;
        Mutex $this$withLock_u24default$iv;
        Mutex $this$withLock_u24default$iv2;
        boolean z;
        try {
            if (continuation instanceof UploadRunnable$splitList$1) {
                uploadRunnable$splitList$1 = (UploadRunnable$splitList$1) continuation;
                if ((uploadRunnable$splitList$1.label & Integer.MIN_VALUE) != 0) {
                    uploadRunnable$splitList$1.label -= Integer.MIN_VALUE;
                    uploadRunnable$splitList$12 = uploadRunnable$splitList$1;
                    Object $result = uploadRunnable$splitList$12.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (uploadRunnable$splitList$12.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            Mutex $this$withLock_u24default$iv3 = this.mutex;
                            $this$splitList = list;
                            uploadRunnable$splitList$12.L$0 = $this$splitList;
                            uploadRunnable$splitList$12.L$1 = $this$withLock_u24default$iv3;
                            uploadRunnable$splitList$12.I$0 = pageSize;
                            uploadRunnable$splitList$12.I$1 = 0;
                            uploadRunnable$splitList$12.label = 1;
                            if ($this$withLock_u24default$iv3.lock((Object) null, uploadRunnable$splitList$12) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $i$f$withLock = pageSize;
                            $this$withLock_u24default$iv = $this$withLock_u24default$iv3;
                            $this$withLock_u24default$iv2 = null;
                            break;
                        case 1:
                            int i = uploadRunnable$splitList$12.I$1;
                            $i$f$withLock = uploadRunnable$splitList$12.I$0;
                            $this$splitList = (List) uploadRunnable$splitList$12.L$0;
                            ResultKt.throwOnFailure($result);
                            $this$withLock_u24default$iv = (Mutex) uploadRunnable$splitList$12.L$1;
                            $this$withLock_u24default$iv2 = null;
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    boolean z2 = false;
                    List listArray = new ArrayList();
                    ArrayList arrayList = null;
                    List $this$forEachIndexed$iv = $this$splitList;
                    int index$iv = 0;
                    for (T t : $this$forEachIndexed$iv) {
                        int index$iv2 = index$iv + 1;
                        if (index$iv < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (index$iv % $i$f$withLock == 0) {
                            arrayList = new ArrayList();
                            listArray.add(arrayList);
                        }
                        if (arrayList != null) {
                            z = z2;
                            Boxing.boxBoolean(arrayList.add(t));
                        } else {
                            z = z2;
                        }
                        z2 = z;
                        index$iv = index$iv2;
                    }
                    return listArray;
                }
            }
            List listArray2 = new ArrayList();
            ArrayList arrayList2 = null;
            List $this$forEachIndexed$iv2 = $this$splitList;
            int index$iv3 = 0;
            while (r15.hasNext()) {
            }
            return listArray2;
        } finally {
            $this$withLock_u24default$iv.unlock($this$withLock_u24default$iv2);
        }
        uploadRunnable$splitList$1 = new UploadRunnable$splitList$1(this, continuation);
        uploadRunnable$splitList$12 = uploadRunnable$splitList$1;
        Object $result2 = uploadRunnable$splitList$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (uploadRunnable$splitList$12.label) {
        }
        boolean z22 = false;
    }
}