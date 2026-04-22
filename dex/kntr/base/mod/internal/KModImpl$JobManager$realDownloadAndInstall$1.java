package kntr.base.mod.internal;

import com.bapis.bilibili.app.resource.v1.KIncrementType;
import java.util.concurrent.locks.ReentrantLock;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.mod.ModEvent;
import kntr.base.mod.internal.KModImpl;
import kntr.base.utils.bspatch.BspatchKt;
import kntr.base.utils.crypto.MD5_androidKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.io.files.FileSystem;
import kotlinx.io.files.FileSystemJvmKt;
import kotlinx.io.files.Path;
import kotlinx.io.files.PathsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KModImpl.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkntr/base/mod/ModEvent$FetchEvent;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.mod.internal.KModImpl$JobManager$realDownloadAndInstall$1", f = "KModImpl.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {277, 301, 309, 339, 355}, m = "invokeSuspend", n = {"$this$flow", "local", "info", "$this$flow", "local", "info", "modItem", "this_$iv", "tmpSubDir$iv", "$completion", "tmpPath", "currentResource", "dpatch", "finalFile", "$i$f$withTmpDir", "$i$a$-withTmpDir-KModImpl$JobManager$realDownloadAndInstall$1$1", "$this$flow", "local", "info", "modItem", "this_$iv", "tmpSubDir$iv", "$completion", "tmpPath", "currentResource", "dpatch", "downloadPath", "finalFile", "$i$f$withTmpDir", "$i$a$-withTmpDir-KModImpl$JobManager$realDownloadAndInstall$1$1", "$this$flow", "local", "info", "modItem", "this_$iv", "tmpSubDir$iv", "$completion", "tmpPath", "currentResource", "dpatch", "finalFile", "$i$f$withTmpDir", "$i$a$-withTmpDir-KModImpl$JobManager$realDownloadAndInstall$1$1", "$this$flow", "local", "info", "modItem", "this_$iv", "tmpSubDir$iv", "$completion", "tmpPath", "currentResource", "dpatch", "newResource", "finalFile", "$i$f$withTmpDir", "$i$a$-withTmpDir-KModImpl$JobManager$realDownloadAndInstall$1$1"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "I$0", "I$1"}, v = 1)
public final class KModImpl$JobManager$realDownloadAndInstall$1 extends SuspendLambda implements Function2<FlowCollector<? super ModEvent.FetchEvent>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Pair<KModImpl.ModResourceImpl, KModImpl.RemoteModInfo> $infoPair;
    final /* synthetic */ boolean $maybeCreate;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$10;
    Object L$11;
    Object L$12;
    Object L$13;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    final /* synthetic */ KModImpl this$0;
    final /* synthetic */ KModImpl.JobManager this$1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KModImpl$JobManager$realDownloadAndInstall$1(Pair<KModImpl.ModResourceImpl, KModImpl.RemoteModInfo> pair, KModImpl kModImpl, KModImpl.JobManager jobManager, boolean z, Continuation<? super KModImpl$JobManager$realDownloadAndInstall$1> continuation) {
        super(2, continuation);
        this.$infoPair = pair;
        this.this$0 = kModImpl;
        this.this$1 = jobManager;
        this.$maybeCreate = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> kModImpl$JobManager$realDownloadAndInstall$1 = new KModImpl$JobManager$realDownloadAndInstall$1(this.$infoPair, this.this$0, this.this$1, this.$maybeCreate, continuation);
        kModImpl$JobManager$realDownloadAndInstall$1.L$0 = obj;
        return kModImpl$JobManager$realDownloadAndInstall$1;
    }

    public final Object invoke(FlowCollector<? super ModEvent.FetchEvent> flowCollector, Continuation<? super Unit> continuation) {
        return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x059d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x059e  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x03cf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x040e A[Catch: all -> 0x0453, TryCatch #16 {all -> 0x0453, blocks: (B:80:0x03c9, B:91:0x03f8, B:90:0x03ee, B:92:0x040e, B:93:0x0452), top: B:190:0x03c9 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Throwable th;
        KModImpl.StorageManager this_$iv;
        Path tmpSubDir$iv;
        KModImpl.ModPoolImpl.ModItem modItem;
        KModImpl.JobManager jobManager;
        Path tmpPath;
        KModImpl.ModResourceImpl currentResource;
        KModImpl.RemoteModInfo.Patch dpatch;
        final Flow $this$map$iv;
        int i;
        KModImpl.RemoteModInfo.Patch dpatch2;
        int $i$f$withTmpDir;
        Continuation $completion;
        Path tmpSubDir$iv2;
        Path tmpSubDir$iv3;
        KModImpl.RemoteModInfo info;
        KModImpl.StorageManager this_$iv2;
        KModImpl kModImpl;
        KModImpl.ModResourceImpl local;
        KModImpl.ModPoolImpl.ModItem modItem2;
        final Flow $this$map$iv2;
        Object obj;
        int $i$f$withTmpDir2;
        KModImpl.RemoteModInfo info2;
        int i2;
        Path tmpPath2;
        Path tmpPath3;
        KModImpl.ModResourceImpl local2;
        Continuation $completion2;
        KModImpl kModImpl2;
        Path finalFile;
        KModImpl.ModResourceImpl currentResource2;
        KModImpl.StorageManager this_$iv3;
        String fileMd5;
        Path finalFile2;
        Object m2636constructorimpl;
        KModImpl.ModResourceImpl local3;
        Continuation $completion3;
        KModImpl.ModResourceImpl local4;
        Path tmpPath4;
        KModImpl.RemoteModInfo info3;
        Object obj2;
        ModEvent.Succeed succeed;
        FlowCollector $this$flow = (FlowCollector) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
        } catch (Throwable th2) {
            th = th2;
        }
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Pair<KModImpl.ModResourceImpl, KModImpl.RemoteModInfo> pair = this.$infoPair;
                KModImpl.ModResourceImpl local5 = pair.component1();
                final KModImpl.RemoteModInfo info4 = pair.component2();
                if (info4 == null) {
                    KModImpl.StorageManager storageManager = this.this$0.storage;
                    Intrinsics.checkNotNull(local5);
                    storageManager.markResourceDeprecated(local5);
                    String poolName = local5.getPoolName();
                    String modName = local5.getModName();
                    String keyOf = this.this$1.keyOf(local5.getPoolName(), local5.getModName());
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$flow);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(local5);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(info4);
                    this.label = 1;
                    return $this$flow.emit(new ModEvent.Failure(poolName, modName, new Throwable(new StringBuilder().append("Mod ").append(keyOf).append(" was removed from remote.").toString())), (Continuation) this) == coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
                }
                modItem = this.this$1.requireLocalItem(info4.getPoolName(), info4.getModName(), this.$maybeCreate);
                this_$iv = this.this$0.storage;
                jobManager = this.this$1;
                KModImpl kModImpl3 = this.this$0;
                ReentrantLock reentrantLock = this_$iv.storageLock;
                reentrantLock.lock();
                boolean z = false;
                try {
                    Path tmpDir = this_$iv.getTmpDir();
                    int i3 = this_$iv.tmpIndex;
                    this_$iv.tmpIndex = i3 + 1;
                    Path tmpSubDir$iv4 = PathsKt.Path(tmpDir, new String[]{"tmp_" + i3});
                    while (FileSystemJvmKt.SystemFileSystem.exists(tmpSubDir$iv4)) {
                        try {
                            Path tmpDir2 = this_$iv.getTmpDir();
                            int i4 = this_$iv.tmpIndex;
                            boolean z2 = z;
                            this_$iv.tmpIndex = i4 + 1;
                            tmpSubDir$iv4 = PathsKt.Path(tmpDir2, new String[]{"tmp_" + i4});
                            z = z2;
                        } catch (Throwable th3) {
                            th = th3;
                            reentrantLock.unlock();
                            throw th;
                        }
                    }
                    FileSystem.-CC.createDirectories$default(FileSystemJvmKt.SystemFileSystem, tmpSubDir$iv4, false, 2, (Object) null);
                    reentrantLock.unlock();
                    tmpSubDir$iv = tmpSubDir$iv4;
                    try {
                        Continuation $completion4 = (Continuation) this;
                        tmpPath = tmpSubDir$iv;
                        currentResource = modItem.getActiveResource();
                        dpatch = info4.getPatchMap().get(KModImpl.RemoteModInfo.Patch.Type.DPatch);
                        Path finalFile3 = PathsKt.Path(tmpPath, new String[]{String.valueOf(info4.getVersion())});
                        try {
                            if (currentResource != null) {
                                try {
                                    if (currentResource.getVersion() == info4.getVersion()) {
                                        try {
                                            ModEvent.Succeed succeed2 = new ModEvent.Succeed(info4.getPoolName(), info4.getModName(), currentResource);
                                            this.L$0 = SpillingKt.nullOutSpilledVariable($this$flow);
                                            this.L$1 = SpillingKt.nullOutSpilledVariable(local5);
                                            this.L$2 = SpillingKt.nullOutSpilledVariable(info4);
                                            this.L$3 = SpillingKt.nullOutSpilledVariable(modItem);
                                            this.L$4 = this_$iv;
                                            this.L$5 = tmpSubDir$iv;
                                            this.L$6 = SpillingKt.nullOutSpilledVariable($completion4);
                                            this.L$7 = SpillingKt.nullOutSpilledVariable(tmpPath);
                                            this.L$8 = SpillingKt.nullOutSpilledVariable(currentResource);
                                            this.L$9 = SpillingKt.nullOutSpilledVariable(dpatch);
                                            this.L$10 = SpillingKt.nullOutSpilledVariable(finalFile3);
                                            this.I$0 = 0;
                                            this.I$1 = 0;
                                            this.label = 2;
                                            if ($this$flow.emit(succeed2, this) == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            KModImpl kModImpl4 = this_$iv.this$0;
                                            try {
                                                Result.Companion companion = Result.Companion;
                                                KModImpl.StorageManager $this$withTmpDir_u24lambda_u241$iv = this_$iv;
                                                ReentrantLock reentrantLock2 = $this$withTmpDir_u24lambda_u241$iv.storageLock;
                                                reentrantLock2.lock();
                                                boolean deleteRecursively = kModImpl4.deleteRecursively(tmpSubDir$iv);
                                                reentrantLock2.unlock();
                                                Result.m2636constructorimpl(Boxing.boxBoolean(deleteRecursively));
                                            } catch (Throwable th4) {
                                                Result.Companion companion2 = Result.Companion;
                                                Result.m2636constructorimpl(ResultKt.createFailure(th4));
                                            }
                                            return Unit.INSTANCE;
                                        } catch (Throwable th5) {
                                            th = th5;
                                        }
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                }
                            }
                            if (info4.getIncrement() != KIncrementType.INCREMENTAL.INSTANCE.getValue() || currentResource == null || dpatch == null) {
                                try {
                                    $this$map$iv = jobManager.download(finalFile3, info4.getUrl(), info4.getTotalMd5());
                                    Flow<ModEvent.Progress> flow = new Flow<ModEvent.Progress>() { // from class: kntr.base.mod.internal.KModImpl$JobManager$realDownloadAndInstall$1$invokeSuspend$lambda$0$$inlined$map$2
                                        public Object collect(FlowCollector collector, Continuation $completion5) {
                                            Object collect = $this$map$iv.collect(new AnonymousClass2(collector, info4), $completion5);
                                            return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                                        }

                                        /* compiled from: Emitters.kt */
                                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                                        /* renamed from: kntr.base.mod.internal.KModImpl$JobManager$realDownloadAndInstall$1$invokeSuspend$lambda$0$$inlined$map$2$2  reason: invalid class name */
                                        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                                        public static final class AnonymousClass2<T> implements FlowCollector {
                                            final /* synthetic */ KModImpl.RemoteModInfo $info$inlined;
                                            final /* synthetic */ FlowCollector $this_unsafeFlow;

                                            /* compiled from: Emitters.kt */
                                            @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                                            @DebugMetadata(c = "kntr.base.mod.internal.KModImpl$JobManager$realDownloadAndInstall$1$invokeSuspend$lambda$0$$inlined$map$2$2", f = "KModImpl.kt", i = {0, 0, 0, 0, 0}, l = {219}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                                            /* renamed from: kntr.base.mod.internal.KModImpl$JobManager$realDownloadAndInstall$1$invokeSuspend$lambda$0$$inlined$map$2$2$1  reason: invalid class name */
                                            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                                            public static final class AnonymousClass1 extends ContinuationImpl {
                                                int I$0;
                                                Object L$0;
                                                Object L$1;
                                                Object L$2;
                                                Object L$3;
                                                int label;
                                                /* synthetic */ Object result;

                                                public AnonymousClass1(Continuation continuation) {
                                                    super(continuation);
                                                }

                                                public final Object invokeSuspend(Object obj) {
                                                    this.result = obj;
                                                    this.label |= Integer.MIN_VALUE;
                                                    return AnonymousClass2.this.emit(null, (Continuation) this);
                                                }
                                            }

                                            public AnonymousClass2(FlowCollector flowCollector, KModImpl.RemoteModInfo remoteModInfo) {
                                                this.$this_unsafeFlow = flowCollector;
                                                this.$info$inlined = remoteModInfo;
                                            }

                                            /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
                                            /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
                                            /* JADX WARN: Removed duplicated region for block: B:13:0x0042  */
                                            /*
                                                Code decompiled incorrectly, please refer to instructions dump.
                                            */
                                            public final Object emit(Object value, Continuation $completion) {
                                                Continuation $continuation;
                                                if ($completion instanceof AnonymousClass1) {
                                                    $continuation = (AnonymousClass1) $completion;
                                                    if (($continuation.label & Integer.MIN_VALUE) != 0) {
                                                        $continuation.label -= Integer.MIN_VALUE;
                                                        Object $result = $continuation.result;
                                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                        switch ($continuation.label) {
                                                            case 0:
                                                                ResultKt.throwOnFailure($result);
                                                                FlowCollector $this$map_u24lambda_u245 = this.$this_unsafeFlow;
                                                                Pair it = (Pair) value;
                                                                ModEvent.Progress progress = new ModEvent.Progress(this.$info$inlined.getPoolName(), this.$info$inlined.getModName(), ((Number) it.getFirst()).longValue(), ((Number) it.getSecond()).longValue());
                                                                $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value);
                                                                $continuation.L$1 = SpillingKt.nullOutSpilledVariable($continuation);
                                                                $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value);
                                                                $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$map_u24lambda_u245);
                                                                $continuation.I$0 = 0;
                                                                $continuation.label = 1;
                                                                if ($this$map_u24lambda_u245.emit(progress, $continuation) != coroutine_suspended) {
                                                                    break;
                                                                } else {
                                                                    return coroutine_suspended;
                                                                }
                                                            case 1:
                                                                int i = $continuation.I$0;
                                                                FlowCollector flowCollector = (FlowCollector) $continuation.L$3;
                                                                Object obj = $continuation.L$2;
                                                                AnonymousClass1 anonymousClass1 = (AnonymousClass1) $continuation.L$1;
                                                                Object obj2 = $continuation.L$0;
                                                                ResultKt.throwOnFailure($result);
                                                                break;
                                                            default:
                                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }
                                                $continuation = new AnonymousClass1($completion);
                                                Object $result2 = $continuation.result;
                                                Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                switch ($continuation.label) {
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }
                                    };
                                    this.L$0 = $this$flow;
                                    this.L$1 = SpillingKt.nullOutSpilledVariable(local5);
                                    this.L$2 = info4;
                                    this.L$3 = modItem;
                                    this.L$4 = this_$iv;
                                    this.L$5 = kModImpl3;
                                    try {
                                        this.L$6 = tmpSubDir$iv;
                                        this.L$7 = SpillingKt.nullOutSpilledVariable($completion4);
                                        this.L$8 = SpillingKt.nullOutSpilledVariable(tmpPath);
                                        this.L$9 = SpillingKt.nullOutSpilledVariable(currentResource);
                                        this.L$10 = SpillingKt.nullOutSpilledVariable(dpatch);
                                        this.L$11 = finalFile3;
                                        this.I$0 = 0;
                                        this.I$1 = 0;
                                        this.label = 4;
                                        Object emitAll = FlowKt.emitAll($this$flow, flow, this);
                                        coroutine_suspended = coroutine_suspended;
                                        if (emitAll == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        i = 0;
                                        dpatch2 = dpatch;
                                        $i$f$withTmpDir = 0;
                                        $completion = $completion4;
                                        tmpSubDir$iv2 = tmpSubDir$iv;
                                        tmpSubDir$iv3 = finalFile3;
                                        info = info4;
                                        this_$iv2 = this_$iv;
                                        kModImpl = kModImpl3;
                                        local = local5;
                                        modItem2 = modItem;
                                        KModImpl.ModPoolImpl.ModItem modItem3 = modItem2;
                                        local4 = local;
                                        local3 = currentResource;
                                        tmpPath4 = tmpPath;
                                        $completion3 = $completion;
                                        tmpSubDir$iv = tmpSubDir$iv2;
                                        this_$iv = this_$iv2;
                                        info3 = info;
                                        kModImpl2 = kModImpl;
                                        modItem = modItem3;
                                        try {
                                            JobKt.ensureActive(getContext());
                                            KModImpl.ModResourceImpl newResource = kModImpl2.storage.install(info3, tmpSubDir$iv3);
                                            JobKt.ensureActive(getContext());
                                            modItem.setActiveResource(newResource);
                                            obj2 = coroutine_suspended;
                                            int i5 = i;
                                            int $i$f$withTmpDir3 = $i$f$withTmpDir;
                                            try {
                                                succeed = new ModEvent.Succeed(info3.getPoolName(), info3.getModName(), newResource);
                                                this.L$0 = SpillingKt.nullOutSpilledVariable($this$flow);
                                                this.L$1 = SpillingKt.nullOutSpilledVariable(local4);
                                                this.L$2 = SpillingKt.nullOutSpilledVariable(info3);
                                                this.L$3 = SpillingKt.nullOutSpilledVariable(modItem);
                                                this.L$4 = this_$iv;
                                                this.L$5 = tmpSubDir$iv;
                                                this.L$6 = SpillingKt.nullOutSpilledVariable($completion3);
                                                this.L$7 = SpillingKt.nullOutSpilledVariable(tmpPath4);
                                                this.L$8 = SpillingKt.nullOutSpilledVariable(local3);
                                                this.L$9 = SpillingKt.nullOutSpilledVariable(dpatch2);
                                                this.L$10 = SpillingKt.nullOutSpilledVariable(newResource);
                                                this.L$11 = SpillingKt.nullOutSpilledVariable(tmpSubDir$iv3);
                                                this.L$12 = null;
                                                this.L$13 = null;
                                                $i$f$withTmpDir = $i$f$withTmpDir3;
                                                this.I$0 = $i$f$withTmpDir;
                                                this.I$1 = i5;
                                                this.label = 5;
                                                if ($this$flow.emit(succeed, this) != obj2) {
                                                    return obj2;
                                                }
                                                KModImpl kModImpl42 = this_$iv.this$0;
                                                Result.Companion companion3 = Result.Companion;
                                                KModImpl.StorageManager $this$withTmpDir_u24lambda_u241$iv2 = this_$iv;
                                                ReentrantLock reentrantLock22 = $this$withTmpDir_u24lambda_u241$iv2.storageLock;
                                                reentrantLock22.lock();
                                                boolean deleteRecursively2 = kModImpl42.deleteRecursively(tmpSubDir$iv);
                                                reentrantLock22.unlock();
                                                Result.m2636constructorimpl(Boxing.boxBoolean(deleteRecursively2));
                                                return Unit.INSTANCE;
                                            } catch (Throwable th7) {
                                                th = th7;
                                            }
                                        } catch (Throwable th8) {
                                            th = th8;
                                        }
                                    } catch (Throwable th9) {
                                        th = th9;
                                        tmpSubDir$iv = tmpSubDir$iv;
                                    }
                                } catch (Throwable th10) {
                                    th = th10;
                                    tmpSubDir$iv = tmpSubDir$iv;
                                }
                            } else {
                                try {
                                    Path downloadPath = PathsKt.Path(tmpPath, new String[]{"_dpatchmod"});
                                    try {
                                        $this$map$iv2 = jobManager.download(downloadPath, dpatch.getUrl(), dpatch.getMd5());
                                        Flow<ModEvent.Progress> flow2 = new Flow<ModEvent.Progress>() { // from class: kntr.base.mod.internal.KModImpl$JobManager$realDownloadAndInstall$1$invokeSuspend$lambda$0$$inlined$map$1
                                            public Object collect(FlowCollector collector, Continuation $completion5) {
                                                Object collect = $this$map$iv2.collect(new AnonymousClass2(collector, info4), $completion5);
                                                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                                            }

                                            /* compiled from: Emitters.kt */
                                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                                            /* renamed from: kntr.base.mod.internal.KModImpl$JobManager$realDownloadAndInstall$1$invokeSuspend$lambda$0$$inlined$map$1$2  reason: invalid class name */
                                            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                                            public static final class AnonymousClass2<T> implements FlowCollector {
                                                final /* synthetic */ KModImpl.RemoteModInfo $info$inlined;
                                                final /* synthetic */ FlowCollector $this_unsafeFlow;

                                                /* compiled from: Emitters.kt */
                                                @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                                                @DebugMetadata(c = "kntr.base.mod.internal.KModImpl$JobManager$realDownloadAndInstall$1$invokeSuspend$lambda$0$$inlined$map$1$2", f = "KModImpl.kt", i = {0, 0, 0, 0, 0}, l = {219}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                                                /* renamed from: kntr.base.mod.internal.KModImpl$JobManager$realDownloadAndInstall$1$invokeSuspend$lambda$0$$inlined$map$1$2$1  reason: invalid class name */
                                                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                                                public static final class AnonymousClass1 extends ContinuationImpl {
                                                    int I$0;
                                                    Object L$0;
                                                    Object L$1;
                                                    Object L$2;
                                                    Object L$3;
                                                    int label;
                                                    /* synthetic */ Object result;

                                                    public AnonymousClass1(Continuation continuation) {
                                                        super(continuation);
                                                    }

                                                    public final Object invokeSuspend(Object obj) {
                                                        this.result = obj;
                                                        this.label |= Integer.MIN_VALUE;
                                                        return AnonymousClass2.this.emit(null, (Continuation) this);
                                                    }
                                                }

                                                public AnonymousClass2(FlowCollector flowCollector, KModImpl.RemoteModInfo remoteModInfo) {
                                                    this.$this_unsafeFlow = flowCollector;
                                                    this.$info$inlined = remoteModInfo;
                                                }

                                                /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
                                                /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
                                                /* JADX WARN: Removed duplicated region for block: B:13:0x0042  */
                                                /*
                                                    Code decompiled incorrectly, please refer to instructions dump.
                                                */
                                                public final Object emit(Object value, Continuation $completion) {
                                                    Continuation $continuation;
                                                    if ($completion instanceof AnonymousClass1) {
                                                        $continuation = (AnonymousClass1) $completion;
                                                        if (($continuation.label & Integer.MIN_VALUE) != 0) {
                                                            $continuation.label -= Integer.MIN_VALUE;
                                                            Object $result = $continuation.result;
                                                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                            switch ($continuation.label) {
                                                                case 0:
                                                                    ResultKt.throwOnFailure($result);
                                                                    FlowCollector $this$map_u24lambda_u245 = this.$this_unsafeFlow;
                                                                    Pair it = (Pair) value;
                                                                    ModEvent.Progress progress = new ModEvent.Progress(this.$info$inlined.getPoolName(), this.$info$inlined.getModName(), ((Number) it.getFirst()).longValue(), ((Number) it.getSecond()).longValue());
                                                                    $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value);
                                                                    $continuation.L$1 = SpillingKt.nullOutSpilledVariable($continuation);
                                                                    $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value);
                                                                    $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$map_u24lambda_u245);
                                                                    $continuation.I$0 = 0;
                                                                    $continuation.label = 1;
                                                                    if ($this$map_u24lambda_u245.emit(progress, $continuation) != coroutine_suspended) {
                                                                        break;
                                                                    } else {
                                                                        return coroutine_suspended;
                                                                    }
                                                                case 1:
                                                                    int i = $continuation.I$0;
                                                                    FlowCollector flowCollector = (FlowCollector) $continuation.L$3;
                                                                    Object obj = $continuation.L$2;
                                                                    AnonymousClass1 anonymousClass1 = (AnonymousClass1) $continuation.L$1;
                                                                    Object obj2 = $continuation.L$0;
                                                                    ResultKt.throwOnFailure($result);
                                                                    break;
                                                                default:
                                                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    }
                                                    $continuation = new AnonymousClass1($completion);
                                                    Object $result2 = $continuation.result;
                                                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                    switch ($continuation.label) {
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }
                                        };
                                        this.L$0 = $this$flow;
                                        this.L$1 = SpillingKt.nullOutSpilledVariable(local5);
                                        this.L$2 = info4;
                                        this.L$3 = modItem;
                                        this.L$4 = this_$iv;
                                        this.L$5 = jobManager;
                                        this.L$6 = kModImpl3;
                                        this.L$7 = tmpSubDir$iv;
                                        try {
                                            this.L$8 = SpillingKt.nullOutSpilledVariable($completion4);
                                            this.L$9 = SpillingKt.nullOutSpilledVariable(tmpPath);
                                            this.L$10 = currentResource;
                                            this.L$11 = SpillingKt.nullOutSpilledVariable(dpatch);
                                            this.L$12 = downloadPath;
                                            this.L$13 = finalFile3;
                                            try {
                                                this.I$0 = 0;
                                                this.I$1 = 0;
                                                this.label = 3;
                                                obj = coroutine_suspended;
                                                if (FlowKt.emitAll($this$flow, flow2, this) == obj) {
                                                    return obj;
                                                }
                                                $i$f$withTmpDir2 = 0;
                                                info2 = info4;
                                                tmpSubDir$iv = tmpSubDir$iv;
                                                i2 = 0;
                                                tmpPath2 = tmpPath;
                                                tmpPath3 = downloadPath;
                                                local2 = local5;
                                                $completion2 = $completion4;
                                                kModImpl2 = kModImpl3;
                                                finalFile = finalFile3;
                                                currentResource2 = currentResource;
                                                this_$iv3 = this_$iv;
                                                try {
                                                    ResultKt.throwOnFailure(BspatchKt.patch$default(currentResource2.getOriginalPath().toString(), finalFile.toString(), tmpPath3.toString(), false, 8, null));
                                                    fileMd5 = MD5_androidKt.encryptFileMd5(finalFile.toString());
                                                    int $i$f$withTmpDir4 = $i$f$withTmpDir2;
                                                    KModImpl.RemoteModInfo.Patch dpatch3 = dpatch;
                                                    try {
                                                        if (StringsKt.equals(fileMd5, info2.getTotalMd5(), true)) {
                                                            throw new IllegalArgumentException(("Patch result md5 mismatch for " + jobManager.keyOf(info2.getPoolName(), info2.getModName()) + ", expect " + info2.getTotalMd5() + ", actual " + fileMd5).toString());
                                                        }
                                                        try {
                                                            Result.Companion companion4 = Result.Companion;
                                                            finalFile2 = finalFile;
                                                            try {
                                                                FileSystem.-CC.delete$default(FileSystemJvmKt.SystemFileSystem, tmpPath3, false, 2, (Object) null);
                                                                m2636constructorimpl = Result.m2636constructorimpl(Unit.INSTANCE);
                                                            } catch (Throwable th11) {
                                                                th = th11;
                                                                Result.Companion companion5 = Result.Companion;
                                                                m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(th));
                                                                Result.m2635boximpl(m2636constructorimpl);
                                                                coroutine_suspended = obj;
                                                                local3 = currentResource2;
                                                                $completion3 = $completion2;
                                                                tmpSubDir$iv3 = finalFile2;
                                                                dpatch2 = dpatch3;
                                                                i = i2;
                                                                local4 = local2;
                                                                $i$f$withTmpDir = $i$f$withTmpDir4;
                                                                this_$iv = this_$iv3;
                                                                tmpPath4 = tmpPath2;
                                                                info3 = info2;
                                                                JobKt.ensureActive(getContext());
                                                                KModImpl.ModResourceImpl newResource2 = kModImpl2.storage.install(info3, tmpSubDir$iv3);
                                                                JobKt.ensureActive(getContext());
                                                                modItem.setActiveResource(newResource2);
                                                                obj2 = coroutine_suspended;
                                                                int i52 = i;
                                                                int $i$f$withTmpDir32 = $i$f$withTmpDir;
                                                                succeed = new ModEvent.Succeed(info3.getPoolName(), info3.getModName(), newResource2);
                                                                this.L$0 = SpillingKt.nullOutSpilledVariable($this$flow);
                                                                this.L$1 = SpillingKt.nullOutSpilledVariable(local4);
                                                                this.L$2 = SpillingKt.nullOutSpilledVariable(info3);
                                                                this.L$3 = SpillingKt.nullOutSpilledVariable(modItem);
                                                                this.L$4 = this_$iv;
                                                                this.L$5 = tmpSubDir$iv;
                                                                this.L$6 = SpillingKt.nullOutSpilledVariable($completion3);
                                                                this.L$7 = SpillingKt.nullOutSpilledVariable(tmpPath4);
                                                                this.L$8 = SpillingKt.nullOutSpilledVariable(local3);
                                                                this.L$9 = SpillingKt.nullOutSpilledVariable(dpatch2);
                                                                this.L$10 = SpillingKt.nullOutSpilledVariable(newResource2);
                                                                this.L$11 = SpillingKt.nullOutSpilledVariable(tmpSubDir$iv3);
                                                                this.L$12 = null;
                                                                this.L$13 = null;
                                                                $i$f$withTmpDir = $i$f$withTmpDir32;
                                                                this.I$0 = $i$f$withTmpDir;
                                                                this.I$1 = i52;
                                                                this.label = 5;
                                                                if ($this$flow.emit(succeed, this) != obj2) {
                                                                }
                                                            }
                                                        } catch (Throwable th12) {
                                                            th = th12;
                                                            finalFile2 = finalFile;
                                                        }
                                                        Result.m2635boximpl(m2636constructorimpl);
                                                        coroutine_suspended = obj;
                                                        local3 = currentResource2;
                                                        $completion3 = $completion2;
                                                        tmpSubDir$iv3 = finalFile2;
                                                        dpatch2 = dpatch3;
                                                        i = i2;
                                                        local4 = local2;
                                                        $i$f$withTmpDir = $i$f$withTmpDir4;
                                                        this_$iv = this_$iv3;
                                                        tmpPath4 = tmpPath2;
                                                        info3 = info2;
                                                        JobKt.ensureActive(getContext());
                                                        KModImpl.ModResourceImpl newResource22 = kModImpl2.storage.install(info3, tmpSubDir$iv3);
                                                        JobKt.ensureActive(getContext());
                                                        modItem.setActiveResource(newResource22);
                                                        obj2 = coroutine_suspended;
                                                        int i522 = i;
                                                        int $i$f$withTmpDir322 = $i$f$withTmpDir;
                                                        succeed = new ModEvent.Succeed(info3.getPoolName(), info3.getModName(), newResource22);
                                                        this.L$0 = SpillingKt.nullOutSpilledVariable($this$flow);
                                                        this.L$1 = SpillingKt.nullOutSpilledVariable(local4);
                                                        this.L$2 = SpillingKt.nullOutSpilledVariable(info3);
                                                        this.L$3 = SpillingKt.nullOutSpilledVariable(modItem);
                                                        this.L$4 = this_$iv;
                                                        this.L$5 = tmpSubDir$iv;
                                                        this.L$6 = SpillingKt.nullOutSpilledVariable($completion3);
                                                        this.L$7 = SpillingKt.nullOutSpilledVariable(tmpPath4);
                                                        this.L$8 = SpillingKt.nullOutSpilledVariable(local3);
                                                        this.L$9 = SpillingKt.nullOutSpilledVariable(dpatch2);
                                                        this.L$10 = SpillingKt.nullOutSpilledVariable(newResource22);
                                                        this.L$11 = SpillingKt.nullOutSpilledVariable(tmpSubDir$iv3);
                                                        this.L$12 = null;
                                                        this.L$13 = null;
                                                        $i$f$withTmpDir = $i$f$withTmpDir322;
                                                        this.I$0 = $i$f$withTmpDir;
                                                        this.I$1 = i522;
                                                        this.label = 5;
                                                        if ($this$flow.emit(succeed, this) != obj2) {
                                                        }
                                                    } catch (Throwable th13) {
                                                        th = th13;
                                                        this_$iv = this_$iv3;
                                                    }
                                                } catch (Throwable th14) {
                                                    th = th14;
                                                    this_$iv = this_$iv3;
                                                }
                                            } catch (Throwable th15) {
                                                th = th15;
                                                tmpSubDir$iv = tmpSubDir$iv;
                                            }
                                        } catch (Throwable th16) {
                                            th = th16;
                                            tmpSubDir$iv = tmpSubDir$iv;
                                        }
                                    } catch (Throwable th17) {
                                        th = th17;
                                        tmpSubDir$iv = tmpSubDir$iv;
                                    }
                                } catch (Throwable th18) {
                                    th = th18;
                                    tmpSubDir$iv = tmpSubDir$iv;
                                }
                            }
                        } catch (Throwable th19) {
                            th = th19;
                            tmpSubDir$iv = tmpSubDir$iv;
                        }
                    } catch (Throwable th20) {
                        th = th20;
                        tmpSubDir$iv = tmpSubDir$iv;
                    }
                } catch (Throwable th21) {
                    th = th21;
                }
                KModImpl kModImpl5 = this_$iv.this$0;
                try {
                    Result.Companion companion6 = Result.Companion;
                    KModImpl.StorageManager $this$withTmpDir_u24lambda_u241$iv3 = this_$iv;
                    ReentrantLock reentrantLock3 = $this$withTmpDir_u24lambda_u241$iv3.storageLock;
                    reentrantLock3.lock();
                    boolean deleteRecursively3 = kModImpl5.deleteRecursively(tmpSubDir$iv);
                    reentrantLock3.unlock();
                    Result.m2636constructorimpl(Boxing.boxBoolean(deleteRecursively3));
                } catch (Throwable th22) {
                    Result.Companion companion7 = Result.Companion;
                    Result.m2636constructorimpl(ResultKt.createFailure(th22));
                }
                throw th;
            case 1:
                KModImpl.RemoteModInfo remoteModInfo = (KModImpl.RemoteModInfo) this.L$2;
                KModImpl.ModResourceImpl modResourceImpl = (KModImpl.ModResourceImpl) this.L$1;
                ResultKt.throwOnFailure($result);
            case 2:
                int i6 = this.I$1;
                int i7 = this.I$0;
                Path path = (Path) this.L$10;
                KModImpl.RemoteModInfo.Patch patch = (KModImpl.RemoteModInfo.Patch) this.L$9;
                KModImpl.ModResourceImpl modResourceImpl2 = (KModImpl.ModResourceImpl) this.L$8;
                Path path2 = (Path) this.L$7;
                Continuation continuation = (Continuation) this.L$6;
                tmpSubDir$iv = (Path) this.L$5;
                this_$iv = (KModImpl.StorageManager) this.L$4;
                KModImpl.ModPoolImpl.ModItem modItem4 = (KModImpl.ModPoolImpl.ModItem) this.L$3;
                KModImpl.RemoteModInfo remoteModInfo2 = (KModImpl.RemoteModInfo) this.L$2;
                KModImpl.ModResourceImpl modResourceImpl3 = (KModImpl.ModResourceImpl) this.L$1;
                ResultKt.throwOnFailure($result);
                KModImpl kModImpl422 = this_$iv.this$0;
                Result.Companion companion32 = Result.Companion;
                KModImpl.StorageManager $this$withTmpDir_u24lambda_u241$iv22 = this_$iv;
                ReentrantLock reentrantLock222 = $this$withTmpDir_u24lambda_u241$iv22.storageLock;
                reentrantLock222.lock();
                boolean deleteRecursively22 = kModImpl422.deleteRecursively(tmpSubDir$iv);
                reentrantLock222.unlock();
                Result.m2636constructorimpl(Boxing.boxBoolean(deleteRecursively22));
                return Unit.INSTANCE;
            case 3:
                int i8 = this.I$1;
                int $i$f$withTmpDir5 = this.I$0;
                finalFile = (Path) this.L$13;
                tmpPath3 = (Path) this.L$12;
                KModImpl.RemoteModInfo.Patch dpatch4 = (KModImpl.RemoteModInfo.Patch) this.L$11;
                currentResource2 = (KModImpl.ModResourceImpl) this.L$10;
                Path tmpPath5 = (Path) this.L$9;
                Continuation $completion5 = (Continuation) this.L$8;
                Path tmpSubDir$iv5 = (Path) this.L$7;
                kModImpl2 = (KModImpl) this.L$6;
                jobManager = (KModImpl.JobManager) this.L$5;
                KModImpl.StorageManager this_$iv4 = (KModImpl.StorageManager) this.L$4;
                KModImpl.ModPoolImpl.ModItem modItem5 = (KModImpl.ModPoolImpl.ModItem) this.L$3;
                i2 = i8;
                info2 = (KModImpl.RemoteModInfo) this.L$2;
                local2 = (KModImpl.ModResourceImpl) this.L$1;
                try {
                    ResultKt.throwOnFailure($result);
                    obj = coroutine_suspended;
                    $i$f$withTmpDir2 = $i$f$withTmpDir5;
                    dpatch = dpatch4;
                    tmpSubDir$iv = tmpSubDir$iv5;
                    $completion2 = $completion5;
                    tmpPath2 = tmpPath5;
                    modItem = modItem5;
                    this_$iv3 = this_$iv4;
                    ResultKt.throwOnFailure(BspatchKt.patch$default(currentResource2.getOriginalPath().toString(), finalFile.toString(), tmpPath3.toString(), false, 8, null));
                    fileMd5 = MD5_androidKt.encryptFileMd5(finalFile.toString());
                    int $i$f$withTmpDir42 = $i$f$withTmpDir2;
                    KModImpl.RemoteModInfo.Patch dpatch32 = dpatch;
                    if (StringsKt.equals(fileMd5, info2.getTotalMd5(), true)) {
                    }
                } catch (Throwable th23) {
                    this_$iv = this_$iv4;
                    tmpSubDir$iv = tmpSubDir$iv5;
                    th = th23;
                    break;
                }
                break;
            case 4:
                i = this.I$1;
                $i$f$withTmpDir = this.I$0;
                tmpSubDir$iv3 = (Path) this.L$11;
                dpatch2 = (KModImpl.RemoteModInfo.Patch) this.L$10;
                currentResource = (KModImpl.ModResourceImpl) this.L$9;
                tmpPath = (Path) this.L$8;
                $completion = (Continuation) this.L$7;
                tmpSubDir$iv2 = (Path) this.L$6;
                kModImpl = (KModImpl) this.L$5;
                this_$iv2 = (KModImpl.StorageManager) this.L$4;
                modItem2 = (KModImpl.ModPoolImpl.ModItem) this.L$3;
                info = (KModImpl.RemoteModInfo) this.L$2;
                local = (KModImpl.ModResourceImpl) this.L$1;
                try {
                    ResultKt.throwOnFailure($result);
                    KModImpl.ModPoolImpl.ModItem modItem32 = modItem2;
                    local4 = local;
                    local3 = currentResource;
                    tmpPath4 = tmpPath;
                    $completion3 = $completion;
                    tmpSubDir$iv = tmpSubDir$iv2;
                    this_$iv = this_$iv2;
                    info3 = info;
                    kModImpl2 = kModImpl;
                    modItem = modItem32;
                    JobKt.ensureActive(getContext());
                    KModImpl.ModResourceImpl newResource222 = kModImpl2.storage.install(info3, tmpSubDir$iv3);
                    JobKt.ensureActive(getContext());
                    modItem.setActiveResource(newResource222);
                    obj2 = coroutine_suspended;
                    int i5222 = i;
                    int $i$f$withTmpDir3222 = $i$f$withTmpDir;
                    succeed = new ModEvent.Succeed(info3.getPoolName(), info3.getModName(), newResource222);
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$flow);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(local4);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(info3);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(modItem);
                    this.L$4 = this_$iv;
                    this.L$5 = tmpSubDir$iv;
                    this.L$6 = SpillingKt.nullOutSpilledVariable($completion3);
                    this.L$7 = SpillingKt.nullOutSpilledVariable(tmpPath4);
                    this.L$8 = SpillingKt.nullOutSpilledVariable(local3);
                    this.L$9 = SpillingKt.nullOutSpilledVariable(dpatch2);
                    this.L$10 = SpillingKt.nullOutSpilledVariable(newResource222);
                    this.L$11 = SpillingKt.nullOutSpilledVariable(tmpSubDir$iv3);
                    this.L$12 = null;
                    this.L$13 = null;
                    $i$f$withTmpDir = $i$f$withTmpDir3222;
                    this.I$0 = $i$f$withTmpDir;
                    this.I$1 = i5222;
                    this.label = 5;
                    if ($this$flow.emit(succeed, this) != obj2) {
                    }
                } catch (Throwable th24) {
                    tmpSubDir$iv = tmpSubDir$iv2;
                    this_$iv = this_$iv2;
                    th = th24;
                    break;
                }
                break;
            case 5:
                int i9 = this.I$1;
                int i10 = this.I$0;
                Path path3 = (Path) this.L$11;
                KModImpl.ModResourceImpl modResourceImpl4 = (KModImpl.ModResourceImpl) this.L$10;
                KModImpl.RemoteModInfo.Patch patch2 = (KModImpl.RemoteModInfo.Patch) this.L$9;
                KModImpl.ModResourceImpl modResourceImpl5 = (KModImpl.ModResourceImpl) this.L$8;
                Path path4 = (Path) this.L$7;
                Continuation continuation2 = (Continuation) this.L$6;
                tmpSubDir$iv = (Path) this.L$5;
                this_$iv = (KModImpl.StorageManager) this.L$4;
                KModImpl.ModPoolImpl.ModItem modItem6 = (KModImpl.ModPoolImpl.ModItem) this.L$3;
                KModImpl.RemoteModInfo remoteModInfo3 = (KModImpl.RemoteModInfo) this.L$2;
                KModImpl.ModResourceImpl modResourceImpl6 = (KModImpl.ModResourceImpl) this.L$1;
                ResultKt.throwOnFailure($result);
                KModImpl kModImpl4222 = this_$iv.this$0;
                Result.Companion companion322 = Result.Companion;
                KModImpl.StorageManager $this$withTmpDir_u24lambda_u241$iv222 = this_$iv;
                ReentrantLock reentrantLock2222 = $this$withTmpDir_u24lambda_u241$iv222.storageLock;
                reentrantLock2222.lock();
                boolean deleteRecursively222 = kModImpl4222.deleteRecursively(tmpSubDir$iv);
                reentrantLock2222.unlock();
                Result.m2636constructorimpl(Boxing.boxBoolean(deleteRecursively222));
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}