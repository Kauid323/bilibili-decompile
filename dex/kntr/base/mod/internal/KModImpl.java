package kntr.base.mod.internal;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import com.bapis.bilibili.app.resource.v1.KCompressType;
import com.bapis.bilibili.app.resource.v1.KEnvType;
import com.bapis.bilibili.app.resource.v1.KHost;
import com.bapis.bilibili.app.resource.v1.KIncrementType;
import com.bapis.bilibili.app.resource.v1.KListReply;
import com.bapis.bilibili.app.resource.v1.KListReq;
import com.bapis.bilibili.app.resource.v1.KModuleMoss;
import com.bapis.bilibili.app.resource.v1.KModuleReply;
import com.bapis.bilibili.app.resource.v1.KPatchInfo;
import com.bapis.bilibili.app.resource.v1.KPoolReply;
import com.bapis.bilibili.app.resource.v1.KVersionListReq;
import com.bapis.bilibili.app.resource.v1.KVersionReq;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.locks.ReentrantLock;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.KDownloader.KDownloader.IDownloader;
import kntr.base.log.KLog_androidKt;
import kntr.base.mod.KMod;
import kntr.base.mod.KModOptions;
import kntr.base.mod.ModEvent;
import kntr.base.mod.ModPool;
import kntr.base.mod.ModResource;
import kntr.base.mod.internal.KModImpl;
import kntr.base.moss.api.KCallOptions;
import kntr.base.neuron.IPlatformNeuron;
import kntr.base.utils.zip.ZipKt;
import kntr.common.upper.trace.config.AppKey;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.io.CoreKt;
import kotlinx.io.Sink;
import kotlinx.io.Source;
import kotlinx.io.Utf8Kt;
import kotlinx.io.files.FileMetadata;
import kotlinx.io.files.FileSystem;
import kotlinx.io.files.FileSystemJvmKt;
import kotlinx.io.files.Path;
import kotlinx.io.files.PathsJvmKt;
import kotlinx.io.files.PathsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;

/* compiled from: KModImpl.kt */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001:\u00071234567B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010 \u001a\u00060\u001cR\u00020\u00002\u0006\u0010!\u001a\u00020\u001bH\u0096\u0002J\b\u0010\"\u001a\u00020#H\u0016J\u000e\u0010$\u001a\u00020%H\u0086@¢\u0006\u0002\u0010&J0\u0010'\u001a\u001a\u0012\u0004\u0012\u00020\u001b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020)0(0(2\u0006\u0010!\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\u001bH\u0002J\f\u0010+\u001a\u00020,*\u00020-H\u0002J\f\u0010.\u001a\u00020,*\u00020/H\u0002J\f\u00100\u001a\u00020,*\u00020/H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00060\u0011R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00060\u0013R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u001b\u0012\b\u0012\u00060\u001cR\u00020\u00000\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u00060\u001ej\u0002`\u001fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lkntr/base/mod/internal/KModImpl;", "Lkntr/base/mod/KMod;", "downloader", "Lkntr/base/KDownloader/KDownloader/IDownloader;", "neuron", "Lkntr/base/neuron/IPlatformNeuron;", "options", "Lkntr/base/mod/KModOptions;", "<init>", "(Lkntr/base/KDownloader/KDownloader/IDownloader;Lkntr/base/neuron/IPlatformNeuron;Lkntr/base/mod/KModOptions;)V", "getDownloader", "()Lkntr/base/KDownloader/KDownloader/IDownloader;", "getNeuron", "()Lkntr/base/neuron/IPlatformNeuron;", "getOptions", "()Lkntr/base/mod/KModOptions;", "jobManager", "Lkntr/base/mod/internal/KModImpl$JobManager;", "storage", "Lkntr/base/mod/internal/KModImpl$StorageManager;", "eventFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "Lkntr/base/mod/ModEvent;", "getEventFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "pools", "", "", "Lkntr/base/mod/internal/KModImpl$ModPoolImpl;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/atomicfu/locks/ReentrantLock;", "get", "poolName", "updateAll", "Lkotlinx/coroutines/Job;", "startUp", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLocalResources", "", "Lkntr/base/mod/internal/KModImpl$ModResourceImpl;", "modName", "isTerminal", "", "Lkntr/base/mod/ModEvent$FetchEvent;", "deleteRecursively", "Lkotlinx/io/files/Path;", "clearDirectory", "ModPoolImpl", "JobManager", "RemoteModInfo", "StorageManager", "LocalModInfo", "ModResourceImpl", "Constants", "mod_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KModImpl implements KMod {
    private final IDownloader downloader;
    private final JobManager jobManager;
    private final ReentrantLock lock;
    private final IPlatformNeuron neuron;
    private final KModOptions options;
    private final Map<String, ModPoolImpl> pools;
    private final StorageManager storage;

    public KModImpl(IDownloader downloader, IPlatformNeuron neuron, KModOptions options) {
        Intrinsics.checkNotNullParameter(downloader, "downloader");
        Intrinsics.checkNotNullParameter(neuron, "neuron");
        Intrinsics.checkNotNullParameter(options, "options");
        this.downloader = downloader;
        this.neuron = neuron;
        this.options = options;
        this.jobManager = new JobManager(this, this.downloader, this.neuron, this.options);
        this.storage = new StorageManager(this, PathsJvmKt.Path(this.options.getRootDir()));
        this.pools = new LinkedHashMap();
        this.lock = new ReentrantLock();
    }

    public final IDownloader getDownloader() {
        return this.downloader;
    }

    public final IPlatformNeuron getNeuron() {
        return this.neuron;
    }

    public final KModOptions getOptions() {
        return this.options;
    }

    @Override // kntr.base.mod.KMod
    public SharedFlow<ModEvent> getEventFlow() {
        return this.jobManager.getEventFlow();
    }

    @Override // kntr.base.mod.KMod
    public ModPoolImpl get(String poolName) {
        ModPoolImpl modPoolImpl;
        Intrinsics.checkNotNullParameter(poolName, "poolName");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Map $this$getOrPut$iv = this.pools;
            ModPoolImpl modPoolImpl2 = $this$getOrPut$iv.get(poolName);
            if (modPoolImpl2 == null) {
                modPoolImpl = new ModPoolImpl(this, poolName);
                $this$getOrPut$iv.put(poolName, modPoolImpl);
            } else {
                modPoolImpl = modPoolImpl2;
            }
            return modPoolImpl;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kntr.base.mod.KMod
    public Job updateAll() {
        return JobManager.fetchAll$default(this.jobManager, null, 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object startUp(Continuation<? super Unit> continuation) {
        KModImpl$startUp$1 kModImpl$startUp$1;
        Object startUp;
        Map<String, ModPoolImpl> map;
        if (continuation instanceof KModImpl$startUp$1) {
            kModImpl$startUp$1 = (KModImpl$startUp$1) continuation;
            if ((kModImpl$startUp$1.label & Integer.MIN_VALUE) != 0) {
                kModImpl$startUp$1.label -= Integer.MIN_VALUE;
                Object $result = kModImpl$startUp$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (kModImpl$startUp$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Map<String, ModPoolImpl> map2 = this.pools;
                        StorageManager storageManager = this.storage;
                        kModImpl$startUp$1.L$0 = map2;
                        kModImpl$startUp$1.label = 1;
                        startUp = storageManager.startUp(kModImpl$startUp$1);
                        if (startUp == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        map = map2;
                        break;
                    case 1:
                        map = (Map) kModImpl$startUp$1.L$0;
                        ResultKt.throwOnFailure($result);
                        startUp = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                map.putAll((Map) startUp);
                return Unit.INSTANCE;
            }
        }
        kModImpl$startUp$1 = new KModImpl$startUp$1(this, continuation);
        Object $result2 = kModImpl$startUp$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (kModImpl$startUp$1.label) {
        }
        map.putAll((Map) startUp);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a1, code lost:
        if (r11 == null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00c1, code lost:
        if (r11 == null) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Map<String, Map<String, ModResourceImpl>> getLocalResources(String poolName, String modName) {
        Map it;
        ModResourceImpl it2;
        Map map;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        boolean z = false;
        try {
            boolean z2 = true;
            if (poolName.length() == 0) {
                Map $this$mapValues$iv = this.pools;
                Iterable $this$associateByTo$iv$iv$iv = $this$mapValues$iv.entrySet();
                Map destination$iv$iv$iv = new LinkedHashMap(MapsKt.mapCapacity($this$mapValues$iv.size()));
                for (Object element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
                    Map.Entry it$iv$iv = (Map.Entry) element$iv$iv$iv;
                    destination$iv$iv$iv.put(it$iv$iv.getKey(), ((ModPoolImpl) ((Map.Entry) element$iv$iv$iv).getValue()).getSnapshot());
                    z = z;
                    $this$mapValues$iv = $this$mapValues$iv;
                }
                map = destination$iv$iv$iv;
            } else {
                if (modName.length() <= 0) {
                    z2 = false;
                }
                if (z2) {
                    ModPoolImpl modPoolImpl = this.pools.get(poolName);
                    if (modPoolImpl != null && (it2 = modPoolImpl.get(modName)) != null) {
                        Map mapOf = MapsKt.mapOf(TuplesKt.to(poolName, MapsKt.mapOf(TuplesKt.to(modName, it2))));
                        map = mapOf;
                    }
                    map = MapsKt.emptyMap();
                } else {
                    ModPoolImpl modPoolImpl2 = this.pools.get(poolName);
                    if (modPoolImpl2 != null && (it = modPoolImpl2.getSnapshot()) != null) {
                        Map mapOf2 = MapsKt.mapOf(TuplesKt.to(poolName, it));
                        map = mapOf2;
                    }
                    map = MapsKt.emptyMap();
                }
            }
            return map;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* compiled from: KModImpl.kt */
    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0004\u0018\u00002\u00020\u0001:\u0001$B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001f\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u0013\u0010\u0019\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001a\u001a\u00020\u0003H\u0096\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u0003H\u0016J\u0016\u0010\u001d\u001a\n0\u0010R\u00060\u0000R\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0003J\u0018\u0010\u001e\u001a\f\u0018\u00010\u0010R\u00060\u0000R\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0003J\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\u001a\u001a\u00020\u0003H\u0016J\b\u0010\"\u001a\u00020#H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\"\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n0\u0010R\u00060\u0000R\u00020\u00110\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00060\u0013j\u0002`\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006%"}, d2 = {"Lkntr/base/mod/internal/KModImpl$ModPoolImpl;", "Lkntr/base/mod/ModPool;", "poolName", "", "<init>", "(Lkntr/base/mod/internal/KModImpl;Ljava/lang/String;)V", "path", "Lkotlinx/io/files/Path;", "resources", "", "Lkntr/base/mod/internal/KModImpl$ModResourceImpl;", "(Lkntr/base/mod/internal/KModImpl;Lkotlinx/io/files/Path;Ljava/util/List;)V", "getPoolName", "()Ljava/lang/String;", "mods", "", "Lkntr/base/mod/internal/KModImpl$ModPoolImpl$ModItem;", "Lkntr/base/mod/internal/KModImpl;", "poolLock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/atomicfu/locks/ReentrantLock;", "snapshot", "", "getSnapshot", "()Ljava/util/Map;", "get", "modName", "delete", "", "getOrCreateMod", "getItem", "fetchRemote", "Lkotlinx/coroutines/flow/Flow;", "Lkntr/base/mod/ModEvent$FetchEvent;", "updatePool", "Lkotlinx/coroutines/Job;", "ModItem", "mod_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public final class ModPoolImpl implements ModPool {
        private final Map<String, ModItem> mods;
        private final ReentrantLock poolLock;
        private final String poolName;
        final /* synthetic */ KModImpl this$0;

        public ModPoolImpl(KModImpl this$0, String poolName) {
            Intrinsics.checkNotNullParameter(poolName, "poolName");
            this.this$0 = this$0;
            this.poolName = poolName;
            this.mods = new LinkedHashMap();
            this.poolLock = new ReentrantLock();
        }

        @Override // kntr.base.mod.ModPool
        public String getPoolName() {
            return this.poolName;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public ModPoolImpl(KModImpl this$0, Path path, List<ModResourceImpl> list) {
            this(this$0, path.getName());
            Intrinsics.checkNotNullParameter(path, "path");
            Intrinsics.checkNotNullParameter(list, "resources");
            List<ModResourceImpl> $this$forEach$iv = list;
            for (Object element$iv : $this$forEach$iv) {
                ModResourceImpl it = (ModResourceImpl) element$iv;
                ModItem modItem = new ModItem(this, it.getModName(), it);
                this.mods.put(it.getModName(), modItem);
            }
        }

        @Override // kntr.base.mod.ModPool
        public Map<String, ModResourceImpl> getSnapshot() {
            boolean z;
            Pair pair;
            ReentrantLock reentrantLock = this.poolLock;
            reentrantLock.lock();
            boolean z2 = false;
            try {
                Map $this$mapNotNull$iv = this.mods;
                Collection destination$iv$iv = new ArrayList();
                for (Map.Entry element$iv$iv$iv : $this$mapNotNull$iv.entrySet()) {
                    ModResourceImpl resource = element$iv$iv$iv.getValue().getActiveResource();
                    if (resource == null) {
                        z = z2;
                        pair = null;
                    } else {
                        z = z2;
                        pair = TuplesKt.to(element$iv$iv$iv.getKey(), resource);
                    }
                    if (pair != null) {
                        destination$iv$iv.add(pair);
                    }
                    z2 = z;
                }
                return MapsKt.toMap((List) destination$iv$iv);
            } finally {
                reentrantLock.unlock();
            }
        }

        @Override // kntr.base.mod.ModPool
        public ModResourceImpl get(String modName) {
            Intrinsics.checkNotNullParameter(modName, "modName");
            ReentrantLock reentrantLock = this.poolLock;
            reentrantLock.lock();
            try {
                ModItem modItem = this.mods.get(modName);
                return modItem != null ? modItem.getActiveResource() : null;
            } finally {
                reentrantLock.unlock();
            }
        }

        @Override // kntr.base.mod.ModPool
        public boolean delete(String modName) {
            Intrinsics.checkNotNullParameter(modName, "modName");
            ReentrantLock reentrantLock = this.poolLock;
            KModImpl kModImpl = this.this$0;
            reentrantLock.lock();
            try {
                ModItem modItem = this.mods.remove(modName);
                if (modItem == null) {
                    reentrantLock.unlock();
                    return true;
                }
                modItem.cancel();
                boolean deleteMod = kModImpl.storage.deleteMod(getPoolName(), modName);
                reentrantLock.unlock();
                this.this$0.jobManager.getEventFlow().tryEmit(new ModEvent.Deleted(getPoolName(), modName));
                return deleteMod;
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }

        public final ModItem getOrCreateMod(String modName) {
            ModItem modItem;
            Intrinsics.checkNotNullParameter(modName, "modName");
            ReentrantLock reentrantLock = this.poolLock;
            reentrantLock.lock();
            try {
                Map $this$getOrPut$iv = this.mods;
                ModItem modItem2 = $this$getOrPut$iv.get(modName);
                if (modItem2 == null) {
                    modItem = new ModItem(this, modName, null, 2, null);
                    $this$getOrPut$iv.put(modName, modItem);
                } else {
                    modItem = modItem2;
                }
                return modItem;
            } finally {
                reentrantLock.unlock();
            }
        }

        public final ModItem getItem(String modName) {
            Intrinsics.checkNotNullParameter(modName, "modName");
            ReentrantLock reentrantLock = this.poolLock;
            reentrantLock.lock();
            try {
                return this.mods.get(modName);
            } finally {
                reentrantLock.unlock();
            }
        }

        @Override // kntr.base.mod.ModPool
        public Flow<ModEvent.FetchEvent> fetchRemote(String modName) {
            Intrinsics.checkNotNullParameter(modName, "modName");
            return FlowKt.flow(new KModImpl$ModPoolImpl$fetchRemote$1(this, modName, null));
        }

        @Override // kntr.base.mod.ModPool
        public Job updatePool() {
            return this.this$0.jobManager.fetchAll(getPoolName());
        }

        /* compiled from: KModImpl.kt */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\u0006\u0010\u0013\u001a\u00020\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\t¨\u0006\u0015"}, d2 = {"Lkntr/base/mod/internal/KModImpl$ModPoolImpl$ModItem;", "", "modName", "", "activeResource", "Lkntr/base/mod/internal/KModImpl$ModResourceImpl;", "<init>", "(Lkntr/base/mod/internal/KModImpl$ModPoolImpl;Ljava/lang/String;Lkntr/base/mod/internal/KModImpl$ModResourceImpl;)V", "getModName", "()Ljava/lang/String;", "getActiveResource", "()Lkntr/base/mod/internal/KModImpl$ModResourceImpl;", "setActiveResource", "(Lkntr/base/mod/internal/KModImpl$ModResourceImpl;)V", "poolName", "getPoolName", "getOrCreateWorkFlow", "Lkotlinx/coroutines/flow/Flow;", "Lkntr/base/mod/ModEvent$FetchEvent;", "cancel", "", "mod_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public final class ModItem {
            private ModResourceImpl activeResource;
            private final String modName;
            final /* synthetic */ ModPoolImpl this$0;

            public ModItem(ModPoolImpl this$0, String modName, ModResourceImpl activeResource) {
                Intrinsics.checkNotNullParameter(modName, "modName");
                this.this$0 = this$0;
                this.modName = modName;
                this.activeResource = activeResource;
            }

            public /* synthetic */ ModItem(ModPoolImpl modPoolImpl, String str, ModResourceImpl modResourceImpl, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(modPoolImpl, str, (i & 2) != 0 ? null : modResourceImpl);
            }

            public final String getModName() {
                return this.modName;
            }

            public final ModResourceImpl getActiveResource() {
                return this.activeResource;
            }

            public final void setActiveResource(ModResourceImpl modResourceImpl) {
                this.activeResource = modResourceImpl;
            }

            public final String getPoolName() {
                return this.this$0.getPoolName();
            }

            public final Flow<ModEvent.FetchEvent> getOrCreateWorkFlow() {
                return this.this$0.this$0.jobManager.fetchAndDownload(getPoolName(), this.modName);
            }

            public final void cancel() {
                this.this$0.this$0.jobManager.cancelItem(getPoolName(), this.modName);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: KModImpl.kt */
    @Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001:\u0001BB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u0019J\u0016\u0010&\u001a\u00020'2\u0006\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u0019J\u001e\u0010(\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u0019H\u0002J(\u0010)\u001a\n0*R\u00060+R\u00020\u001b2\u0006\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u00192\u0006\u0010,\u001a\u00020-H\u0002J0\u0010.\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0016\u0010/\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u000101\u0012\u0006\u0012\u0004\u0018\u000102002\b\b\u0002\u0010,\u001a\u00020-H\u0002J\u0010\u00103\u001a\u0002042\b\b\u0002\u0010$\u001a\u00020\u0019J\u0018\u00105\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u0019H\u0002J2\u00106\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u000207000\"2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u00192\u0006\u0010;\u001a\u00020\u0019H\u0002J0\u0010<\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u000101\u0012\u0006\u0012\u0004\u0018\u000102\u0018\u0001002\u0006\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u0019H\u0082@¢\u0006\u0002\u0010=J>\u0010>\u001a*\u0012\u0004\u0012\u00020\u0019\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0019\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u000101\u0012\u0006\u0012\u0004\u0018\u000102000?0?2\u0006\u0010$\u001a\u00020\u0019H\u0082@¢\u0006\u0002\u0010@JF\u0010A\u001a*\u0012\u0004\u0012\u00020\u0019\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0019\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u000101\u0012\u0006\u0012\u0004\u0018\u000102000?0?2\u0006\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u0019H\u0082@¢\u0006\u0002\u0010=R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R%\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0012\f\u0012\n0\u001aR\u00060\u0000R\u00020\u001b0\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0012\u0010\u001e\u001a\u00060\u001fj\u0002` X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lkntr/base/mod/internal/KModImpl$JobManager;", "", "downloader", "Lkntr/base/KDownloader/KDownloader/IDownloader;", "neuron", "Lkntr/base/neuron/IPlatformNeuron;", "options", "Lkntr/base/mod/KModOptions;", "<init>", "(Lkntr/base/mod/internal/KModImpl;Lkntr/base/KDownloader/KDownloader/IDownloader;Lkntr/base/neuron/IPlatformNeuron;Lkntr/base/mod/KModOptions;)V", "getDownloader", "()Lkntr/base/KDownloader/KDownloader/IDownloader;", "getOptions", "()Lkntr/base/mod/KModOptions;", "managerScope", "Lkotlinx/coroutines/CoroutineScope;", "getManagerScope", "()Lkotlinx/coroutines/CoroutineScope;", "eventFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkntr/base/mod/ModEvent;", "getEventFlow", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "currentJobs", "", "", "Lkntr/base/mod/internal/KModImpl$JobManager$DownloadAndInstallFlowHolder;", "Lkntr/base/mod/internal/KModImpl;", "getCurrentJobs", "()Ljava/util/Map;", "jobLock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/atomicfu/locks/ReentrantLock;", "fetchAndDownload", "Lkotlinx/coroutines/flow/Flow;", "Lkntr/base/mod/ModEvent$FetchEvent;", "poolName", "modName", "cancelItem", "", "realFetchAndDownload", "requireLocalItem", "Lkntr/base/mod/internal/KModImpl$ModPoolImpl$ModItem;", "Lkntr/base/mod/internal/KModImpl$ModPoolImpl;", "maybeCreate", "", "realDownloadAndInstall", "infoPair", "Lkotlin/Pair;", "Lkntr/base/mod/internal/KModImpl$ModResourceImpl;", "Lkntr/base/mod/internal/KModImpl$RemoteModInfo;", "fetchAll", "Lkotlinx/coroutines/Job;", "keyOf", "download", "", "path", "Lkotlinx/io/files/Path;", "url", "md5", "requestSingleMod", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestAllMods", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestMossMod", "DownloadAndInstallFlowHolder", "mod_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public final class JobManager {
        private final Map<String, DownloadAndInstallFlowHolder> currentJobs;
        private final IDownloader downloader;
        private final MutableSharedFlow<ModEvent> eventFlow;
        private final ReentrantLock jobLock;
        private final CoroutineScope managerScope;
        private final KModOptions options;
        final /* synthetic */ KModImpl this$0;

        public JobManager(KModImpl this$0, IDownloader downloader, IPlatformNeuron neuron, KModOptions options) {
            Intrinsics.checkNotNullParameter(downloader, "downloader");
            Intrinsics.checkNotNullParameter(neuron, "neuron");
            Intrinsics.checkNotNullParameter(options, "options");
            this.this$0 = this$0;
            this.downloader = downloader;
            this.options = options;
            this.managerScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
            this.eventFlow = SharedFlowKt.MutableSharedFlow(0, 64, BufferOverflow.SUSPEND);
            this.currentJobs = new LinkedHashMap();
            this.jobLock = new ReentrantLock();
        }

        public final IDownloader getDownloader() {
            return this.downloader;
        }

        public final KModOptions getOptions() {
            return this.options;
        }

        public final CoroutineScope getManagerScope() {
            return this.managerScope;
        }

        public final MutableSharedFlow<ModEvent> getEventFlow() {
            return this.eventFlow;
        }

        public final Map<String, DownloadAndInstallFlowHolder> getCurrentJobs() {
            return this.currentJobs;
        }

        public final Flow<ModEvent.FetchEvent> fetchAndDownload(String poolName, String modName) {
            Intrinsics.checkNotNullParameter(poolName, "poolName");
            Intrinsics.checkNotNullParameter(modName, "modName");
            return FlowKt.flow(new KModImpl$JobManager$fetchAndDownload$1(this, poolName, modName, null));
        }

        public final void cancelItem(String poolName, String modName) {
            Intrinsics.checkNotNullParameter(poolName, "poolName");
            Intrinsics.checkNotNullParameter(modName, "modName");
            String key = keyOf(poolName, modName);
            ReentrantLock reentrantLock = this.jobLock;
            reentrantLock.lock();
            try {
                DownloadAndInstallFlowHolder downloadAndInstallFlowHolder = this.currentJobs.get(key);
                if (downloadAndInstallFlowHolder != null) {
                    downloadAndInstallFlowHolder.cancel();
                }
            } finally {
                reentrantLock.unlock();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Flow<ModEvent.FetchEvent> realFetchAndDownload(String poolName, String modName) {
            return FlowKt.flow(new KModImpl$JobManager$realFetchAndDownload$1(this, poolName, modName, null));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ModPoolImpl.ModItem requireLocalItem(String poolName, String modName, boolean maybeCreate) {
            ModPoolImpl pool = this.this$0.get(poolName);
            ModPoolImpl.ModItem item = pool.getItem(modName);
            if (item != null) {
                return item;
            }
            JobManager $this$requireLocalItem_u24lambda_u240 = this;
            if (maybeCreate) {
                return pool.getOrCreateMod(modName);
            }
            throw new IllegalStateException(("Local Mod " + $this$requireLocalItem_u24lambda_u240.keyOf(poolName, modName) + " has been deleted.").toString());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Flow realDownloadAndInstall$default(JobManager jobManager, Pair pair, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return jobManager.realDownloadAndInstall(pair, z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Flow<ModEvent.FetchEvent> realDownloadAndInstall(Pair<ModResourceImpl, RemoteModInfo> pair, boolean maybeCreate) {
            return FlowKt.flow(new KModImpl$JobManager$realDownloadAndInstall$1(pair, this.this$0, this, maybeCreate, null));
        }

        public static /* synthetic */ Job fetchAll$default(JobManager jobManager, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = "";
            }
            return jobManager.fetchAll(str);
        }

        public final Job fetchAll(String poolName) {
            Intrinsics.checkNotNullParameter(poolName, "poolName");
            return BuildersKt.launch$default(this.managerScope, (CoroutineContext) null, (CoroutineStart) null, new KModImpl$JobManager$fetchAll$1(this, poolName, this.this$0, null), 3, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String keyOf(String poolName, String modName) {
            return poolName + "::" + modName;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Flow<Pair<Long, Long>> download(Path path, String url, String md5) {
            return FlowKt.flow(new KModImpl$JobManager$download$1(this, url, path, md5, null));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x003b  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0063 A[ORIG_RETURN, RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object requestSingleMod(String poolName, String modName, Continuation<? super Pair<ModResourceImpl, RemoteModInfo>> continuation) {
            KModImpl$JobManager$requestSingleMod$1 kModImpl$JobManager$requestSingleMod$1;
            Object requestMossMod;
            Map map;
            if (continuation instanceof KModImpl$JobManager$requestSingleMod$1) {
                kModImpl$JobManager$requestSingleMod$1 = (KModImpl$JobManager$requestSingleMod$1) continuation;
                if ((kModImpl$JobManager$requestSingleMod$1.label & Integer.MIN_VALUE) != 0) {
                    kModImpl$JobManager$requestSingleMod$1.label -= Integer.MIN_VALUE;
                    Object $result = kModImpl$JobManager$requestSingleMod$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (kModImpl$JobManager$requestSingleMod$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            kModImpl$JobManager$requestSingleMod$1.L$0 = poolName;
                            kModImpl$JobManager$requestSingleMod$1.L$1 = modName;
                            kModImpl$JobManager$requestSingleMod$1.label = 1;
                            requestMossMod = requestMossMod(poolName, modName, kModImpl$JobManager$requestSingleMod$1);
                            if (requestMossMod == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            break;
                        case 1:
                            modName = (String) kModImpl$JobManager$requestSingleMod$1.L$1;
                            poolName = (String) kModImpl$JobManager$requestSingleMod$1.L$0;
                            ResultKt.throwOnFailure($result);
                            requestMossMod = $result;
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    map = (Map) ((Map) requestMossMod).get(poolName);
                    if (map == null) {
                        return (Pair) map.get(modName);
                    }
                    return null;
                }
            }
            kModImpl$JobManager$requestSingleMod$1 = new KModImpl$JobManager$requestSingleMod$1(this, continuation);
            Object $result2 = kModImpl$JobManager$requestSingleMod$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (kModImpl$JobManager$requestSingleMod$1.label) {
            }
            map = (Map) ((Map) requestMossMod).get(poolName);
            if (map == null) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Object requestAllMods(String poolName, Continuation<? super Map<String, ? extends Map<String, Pair<ModResourceImpl, RemoteModInfo>>>> continuation) {
            return requestMossMod(poolName, "", continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:10:0x0030  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0038  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0052  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x0207  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x020c  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x020f  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x0214  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x0261  */
        /* JADX WARN: Removed duplicated region for block: B:61:0x0375  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object requestMossMod(String poolName, String modName, Continuation<? super Map<String, ? extends Map<String, Pair<ModResourceImpl, RemoteModInfo>>>> continuation) {
            KModImpl$JobManager$requestMossMod$1 kModImpl$JobManager$requestMossMod$1;
            KModImpl$JobManager$requestMossMod$1 kModImpl$JobManager$requestMossMod$12;
            String str;
            KModImpl$JobManager$requestMossMod$1 kModImpl$JobManager$requestMossMod$13;
            String poolName2;
            Object obj;
            Map locals;
            String modName2;
            Map $this$mapNotNull$iv;
            Object obj2;
            KVersionListReq kVersionListReq;
            Map remotes;
            Iterable $this$associateWith$iv;
            Map $i$f$associateWith;
            Map locals2;
            LinkedHashMap result$iv;
            if (continuation instanceof KModImpl$JobManager$requestMossMod$1) {
                kModImpl$JobManager$requestMossMod$1 = (KModImpl$JobManager$requestMossMod$1) continuation;
                if ((kModImpl$JobManager$requestMossMod$1.label & Integer.MIN_VALUE) != 0) {
                    kModImpl$JobManager$requestMossMod$1.label -= Integer.MIN_VALUE;
                    kModImpl$JobManager$requestMossMod$12 = kModImpl$JobManager$requestMossMod$1;
                    Object $result = kModImpl$JobManager$requestMossMod$12.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    KVersionListReq kVersionListReq2 = null;
                    switch (kModImpl$JobManager$requestMossMod$12.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            Map locals3 = this.this$0.getLocalResources(poolName, modName);
                            KModuleMoss kModuleMoss = new KModuleMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
                            Map $this$mapNotNull$iv2 = locals3;
                            Collection destination$iv$iv = new ArrayList();
                            for (Map.Entry element$iv$iv$iv : $this$mapNotNull$iv2.entrySet()) {
                                String poolName3 = (String) element$iv$iv$iv.getKey();
                                Map mods = (Map) element$iv$iv$iv.getValue();
                                if (mods.isEmpty()) {
                                    $this$mapNotNull$iv = $this$mapNotNull$iv2;
                                    obj2 = coroutine_suspended;
                                    kVersionListReq = kVersionListReq2;
                                } else {
                                    $this$mapNotNull$iv = $this$mapNotNull$iv2;
                                    Collection destination$iv$iv2 = new ArrayList(mods.size());
                                    for (Map.Entry item$iv$iv : mods.entrySet()) {
                                        ModResourceImpl it = (ModResourceImpl) item$iv$iv.getValue();
                                        destination$iv$iv2.add(new KVersionReq((String) item$iv$iv.getKey(), it.getVersion(), 0L, false, it.getInfo().getModuleId()));
                                        coroutine_suspended = coroutine_suspended;
                                    }
                                    obj2 = coroutine_suspended;
                                    kVersionListReq = new KVersionListReq(poolName3, (List) destination$iv$iv2);
                                }
                                if (kVersionListReq != null) {
                                    destination$iv$iv.add(kVersionListReq);
                                }
                                $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                                coroutine_suspended = obj2;
                                kVersionListReq2 = null;
                            }
                            Object obj3 = coroutine_suspended;
                            List it2 = (List) destination$iv$iv;
                            KLog_androidKt.getKLog().i("KModJobManager", "Moss Mod request locals:\n" + CollectionsKt.joinToString$default(it2, "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: kntr.base.mod.internal.KModImpl$JobManager$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj4) {
                                    CharSequence requestMossMod$lambda$1$0;
                                    requestMossMod$lambda$1$0 = KModImpl.JobManager.requestMossMod$lambda$1$0((KVersionListReq) obj4);
                                    return requestMossMod$lambda$1$0;
                                }
                            }, 30, (Object) null));
                            Unit unit = Unit.INSTANCE;
                            str = "KModJobManager";
                            KListReq kListReq = new KListReq(poolName, modName, it2, (KEnvType) (this.options.getDebug() ? KEnvType.TEST.INSTANCE : KEnvType.RELEASE.INSTANCE), 0, 0, 0, 0L, poolName.length() == 0 ? 2 : 0, 0L, false, false, "default", false, 8320, (DefaultConstructorMarker) null);
                            kModImpl$JobManager$requestMossMod$13 = kModImpl$JobManager$requestMossMod$12;
                            kModImpl$JobManager$requestMossMod$13.L$0 = SpillingKt.nullOutSpilledVariable(poolName);
                            kModImpl$JobManager$requestMossMod$13.L$1 = SpillingKt.nullOutSpilledVariable(modName);
                            kModImpl$JobManager$requestMossMod$13.L$2 = locals3;
                            kModImpl$JobManager$requestMossMod$13.label = 1;
                            Object list = kModuleMoss.list(kListReq, kModImpl$JobManager$requestMossMod$13);
                            if (list != obj3) {
                                poolName2 = poolName;
                                obj = list;
                                locals = locals3;
                                modName2 = modName;
                                break;
                            } else {
                                return obj3;
                            }
                        case 1:
                            poolName2 = (String) kModImpl$JobManager$requestMossMod$12.L$0;
                            ResultKt.throwOnFailure($result);
                            str = "KModJobManager";
                            locals = (Map) kModImpl$JobManager$requestMossMod$12.L$2;
                            modName2 = (String) kModImpl$JobManager$requestMossMod$12.L$1;
                            kModImpl$JobManager$requestMossMod$13 = kModImpl$JobManager$requestMossMod$12;
                            obj = $result;
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    KListReply r = (KListReply) obj;
                    KHost host = r.getHost();
                    String str2 = str;
                    KLog_androidKt.getKLog().i(str2, "Moss Mod response host: boss=" + (host == null ? host.getBoss() : null) + ", bfs=" + (host == null ? host.getBfs() : null));
                    Iterable<KPoolReply> $this$associate$iv = r.getPools();
                    Map destination$iv$iv3 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associate$iv, 10)), 16));
                    for (KPoolReply pool : $this$associate$iv) {
                        String name = pool.getName();
                        Iterable<KModuleReply> $this$associate$iv2 = pool.getModules();
                        String modName3 = modName2;
                        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associate$iv2, 10)), 16);
                        Map destination$iv$iv4 = new LinkedHashMap(capacity$iv);
                        for (KModuleReply it3 : $this$associate$iv2) {
                            int capacity$iv2 = capacity$iv;
                            KModImpl$JobManager$requestMossMod$1 kModImpl$JobManager$requestMossMod$14 = kModImpl$JobManager$requestMossMod$13;
                            Pair pair = TuplesKt.to(it3.getName(), RemoteModInfo.Companion.create(it3, pool.getName(), host));
                            destination$iv$iv4.put(pair.getFirst(), pair.getSecond());
                            capacity$iv = capacity$iv2;
                            r = r;
                            poolName2 = poolName2;
                            kModImpl$JobManager$requestMossMod$13 = kModImpl$JobManager$requestMossMod$14;
                        }
                        Pair pair2 = TuplesKt.to(name, destination$iv$iv4);
                        destination$iv$iv3.put(pair2.getFirst(), pair2.getSecond());
                        modName2 = modName3;
                    }
                    Map remotes2 = destination$iv$iv3;
                    KLog_androidKt.getKLog().i(str2, "Moss Mod response mods:\n" + CollectionsKt.joinToString$default(remotes2.entrySet(), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: kntr.base.mod.internal.KModImpl$JobManager$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj4) {
                            CharSequence requestMossMod$lambda$3;
                            requestMossMod$lambda$3 = KModImpl.JobManager.requestMossMod$lambda$3((Map.Entry) obj4);
                            return requestMossMod$lambda$3;
                        }
                    }, 30, (Object) null));
                    Iterable $this$associateWith$iv2 = SetsKt.plus(locals.keySet(), remotes2.keySet());
                    Map destination$iv$iv$iv = null;
                    Map destination$iv$iv5 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateWith$iv2, 10)), 16));
                    for (Object element$iv$iv : $this$associateWith$iv2) {
                        String it4 = (String) element$iv$iv;
                        Map localMods = (Map) locals.get(it4);
                        Map remoteMods = (Map) remotes2.get(it4);
                        if (localMods == null) {
                            Intrinsics.checkNotNull(remoteMods);
                            remotes = remotes2;
                            $this$associateWith$iv = $this$associateWith$iv2;
                            Map destination$iv$iv6 = new LinkedHashMap(MapsKt.mapCapacity(remoteMods.size()));
                            Map $this$mapValuesTo$iv$iv = remoteMods;
                            Iterable $this$associateByTo$iv$iv$iv = $this$mapValuesTo$iv$iv.entrySet();
                            for (Object element$iv$iv$iv2 : $this$associateByTo$iv$iv$iv) {
                                Map.Entry it$iv$iv = (Map.Entry) element$iv$iv$iv2;
                                destination$iv$iv6.put(it$iv$iv.getKey(), TuplesKt.to(null, ((Map.Entry) element$iv$iv$iv2).getValue()));
                                destination$iv$iv6 = destination$iv$iv6;
                                $this$mapValuesTo$iv$iv = $this$mapValuesTo$iv$iv;
                                destination$iv$iv$iv = destination$iv$iv$iv;
                            }
                            $i$f$associateWith = destination$iv$iv$iv;
                            result$iv = destination$iv$iv6;
                            locals2 = locals;
                        } else {
                            remotes = remotes2;
                            $this$associateWith$iv = $this$associateWith$iv2;
                            $i$f$associateWith = destination$iv$iv$iv;
                            if (remoteMods == null) {
                                Map $this$mapValues$iv = localMods;
                                boolean z = false;
                                Map destination$iv$iv$iv2 = new LinkedHashMap(MapsKt.mapCapacity($this$mapValues$iv.size()));
                                Iterable $this$associateByTo$iv$iv$iv2 = $this$mapValues$iv.entrySet();
                                for (Object element$iv$iv$iv3 : $this$associateByTo$iv$iv$iv2) {
                                    Map.Entry it$iv$iv2 = (Map.Entry) element$iv$iv$iv3;
                                    destination$iv$iv$iv2.put(it$iv$iv2.getKey(), TuplesKt.to(((Map.Entry) element$iv$iv$iv3).getValue(), null));
                                    $this$mapValues$iv = $this$mapValues$iv;
                                    z = z;
                                    destination$iv$iv$iv2 = destination$iv$iv$iv2;
                                }
                                result$iv = destination$iv$iv$iv2;
                                locals2 = locals;
                            } else {
                                Iterable $this$associateWith$iv3 = SetsKt.plus(localMods.keySet(), remoteMods.keySet());
                                LinkedHashMap result$iv2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateWith$iv3, 10)), 16));
                                LinkedHashMap linkedHashMap = result$iv2;
                                for (Object element$iv$iv2 : $this$associateWith$iv3) {
                                    Iterable $this$associateWith$iv4 = $this$associateWith$iv3;
                                    String it5 = (String) element$iv$iv2;
                                    linkedHashMap.put(element$iv$iv2, TuplesKt.to(localMods.get(it5), remoteMods.get(it5)));
                                    $this$associateWith$iv3 = $this$associateWith$iv4;
                                    result$iv2 = result$iv2;
                                    locals = locals;
                                }
                                locals2 = locals;
                                result$iv = linkedHashMap;
                            }
                        }
                        destination$iv$iv5.put(element$iv$iv, result$iv);
                        remotes2 = remotes;
                        $this$associateWith$iv2 = $this$associateWith$iv;
                        locals = locals2;
                        destination$iv$iv$iv = $i$f$associateWith;
                    }
                    return destination$iv$iv5;
                }
            }
            kModImpl$JobManager$requestMossMod$1 = new KModImpl$JobManager$requestMossMod$1(this, continuation);
            kModImpl$JobManager$requestMossMod$12 = kModImpl$JobManager$requestMossMod$1;
            Object $result2 = kModImpl$JobManager$requestMossMod$12.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            KVersionListReq kVersionListReq22 = null;
            switch (kModImpl$JobManager$requestMossMod$12.label) {
            }
            KListReply r2 = (KListReply) obj;
            KHost host2 = r2.getHost();
            if (host2 == null) {
            }
            String str22 = str;
            KLog_androidKt.getKLog().i(str22, "Moss Mod response host: boss=" + (host2 == null ? host2.getBoss() : null) + ", bfs=" + (host2 == null ? host2.getBfs() : null));
            Iterable<KPoolReply> $this$associate$iv3 = r2.getPools();
            Map destination$iv$iv32 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associate$iv3, 10)), 16));
            while (r16.hasNext()) {
            }
            Map remotes22 = destination$iv$iv32;
            KLog_androidKt.getKLog().i(str22, "Moss Mod response mods:\n" + CollectionsKt.joinToString$default(remotes22.entrySet(), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: kntr.base.mod.internal.KModImpl$JobManager$$ExternalSyntheticLambda1
                public final Object invoke(Object obj4) {
                    CharSequence requestMossMod$lambda$3;
                    requestMossMod$lambda$3 = KModImpl.JobManager.requestMossMod$lambda$3((Map.Entry) obj4);
                    return requestMossMod$lambda$3;
                }
            }, 30, (Object) null));
            Iterable $this$associateWith$iv22 = SetsKt.plus(locals.keySet(), remotes22.keySet());
            Map destination$iv$iv$iv3 = null;
            Map destination$iv$iv52 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateWith$iv22, 10)), 16));
            while (r9.hasNext()) {
            }
            return destination$iv$iv52;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CharSequence requestMossMod$lambda$1$0(KVersionListReq it) {
            Intrinsics.checkNotNullParameter(it, "it");
            String poolName = it.getPoolName();
            return poolName + ": " + CollectionsKt.joinToString$default(it.getVersions(), (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: kntr.base.mod.internal.KModImpl$JobManager$$ExternalSyntheticLambda3
                public final Object invoke(Object obj) {
                    CharSequence requestMossMod$lambda$1$0$0;
                    requestMossMod$lambda$1$0$0 = KModImpl.JobManager.requestMossMod$lambda$1$0$0((KVersionReq) obj);
                    return requestMossMod$lambda$1$0$0;
                }
            }, 31, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CharSequence requestMossMod$lambda$1$0$0(KVersionReq m) {
            Intrinsics.checkNotNullParameter(m, "m");
            String moduleName = m.getModuleName();
            return moduleName + "@" + m.getVersion();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CharSequence requestMossMod$lambda$3(Map.Entry it) {
            Intrinsics.checkNotNullParameter(it, "it");
            Object key = it.getKey();
            return key + "\n " + CollectionsKt.joinToString$default(((Map) it.getValue()).entrySet(), "\n", "  ", (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: kntr.base.mod.internal.KModImpl$JobManager$$ExternalSyntheticLambda2
                public final Object invoke(Object obj) {
                    CharSequence requestMossMod$lambda$3$0;
                    requestMossMod$lambda$3$0 = KModImpl.JobManager.requestMossMod$lambda$3$0((Map.Entry) obj);
                    return requestMossMod$lambda$3$0;
                }
            }, 28, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CharSequence requestMossMod$lambda$3$0(Map.Entry it) {
            Intrinsics.checkNotNullParameter(it, "it");
            RemoteModInfo mod = (RemoteModInfo) it.getValue();
            String modName = mod.getModName();
            long version = mod.getVersion();
            String url = mod.getUrl();
            int increment = mod.getIncrement();
            return modName + "@" + version + " " + url + " " + increment + " " + mod.getTotalMd5();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: KModImpl.kt */
        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0016\u001a\u00020\u0014J\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lkntr/base/mod/internal/KModImpl$JobManager$DownloadAndInstallFlowHolder;", "", "poolName", "", "modName", "realFlow", "Lkotlinx/coroutines/flow/Flow;", "Lkntr/base/mod/ModEvent$FetchEvent;", "<init>", "(Lkntr/base/mod/internal/KModImpl$JobManager;Ljava/lang/String;Ljava/lang/String;Lkotlinx/coroutines/flow/Flow;)V", "getPoolName", "()Ljava/lang/String;", "getModName", "getRealFlow", "()Lkotlinx/coroutines/flow/Flow;", "stateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "job", "Lkotlinx/coroutines/Job;", "onStart", "", "onStop", "cancel", "subscribeFlow", "Lkotlinx/coroutines/flow/StateFlow;", "mod_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public final class DownloadAndInstallFlowHolder {
            private final Job job;
            private final String modName;
            private final String poolName;
            private final Flow<ModEvent.FetchEvent> realFlow;
            private final MutableStateFlow<ModEvent.FetchEvent> stateFlow;
            final /* synthetic */ JobManager this$0;

            /* JADX WARN: Multi-variable type inference failed */
            public DownloadAndInstallFlowHolder(JobManager this$0, String poolName, String modName, Flow<? extends ModEvent.FetchEvent> flow) {
                Intrinsics.checkNotNullParameter(poolName, "poolName");
                Intrinsics.checkNotNullParameter(modName, "modName");
                Intrinsics.checkNotNullParameter(flow, "realFlow");
                this.this$0 = this$0;
                this.poolName = poolName;
                this.modName = modName;
                this.realFlow = flow;
                this.stateFlow = StateFlowKt.MutableStateFlow(new ModEvent.Initial(this.poolName, this.modName));
                this.job = BuildersKt.launch$default(this.this$0.getManagerScope(), Dispatchers.getDefault().limitedParallelism(1), (CoroutineStart) null, new KModImpl$JobManager$DownloadAndInstallFlowHolder$job$1(this, null), 2, (Object) null);
            }

            public final String getPoolName() {
                return this.poolName;
            }

            public final String getModName() {
                return this.modName;
            }

            public final Flow<ModEvent.FetchEvent> getRealFlow() {
                return this.realFlow;
            }

            public final void onStart() {
                BuildersKt.launch$default(this.this$0.getManagerScope(), (CoroutineContext) null, (CoroutineStart) null, new KModImpl$JobManager$DownloadAndInstallFlowHolder$onStart$1(this, this.this$0.this$0, this.this$0, null), 3, (Object) null);
            }

            public final void onStop() {
                ReentrantLock reentrantLock = this.this$0.jobLock;
                JobManager jobManager = this.this$0;
                reentrantLock.lock();
                try {
                    jobManager.getCurrentJobs().remove(jobManager.keyOf(this.poolName, this.modName));
                    reentrantLock.unlock();
                    Job.DefaultImpls.cancel$default(this.job, (CancellationException) null, 1, (Object) null);
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    throw th;
                }
            }

            public final void cancel() {
                onStop();
            }

            public final StateFlow<ModEvent.FetchEvent> subscribeFlow() {
                return this.stateFlow;
            }
        }
    }

    /* compiled from: KModImpl.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\bE\b\u0086\b\u0018\u0000 a2\u00020\u0001:\u0002`aBë\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0015\u001a\u00020\u0011\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0018\u001a\u00020\t\u0012\b\b\u0002\u0010\u0019\u001a\u00020\t\u0012\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u000b\u0012\b\b\u0002\u0010 \u001a\u00020\u0003\u0012\b\b\u0002\u0010!\u001a\u00020\u0003¢\u0006\u0004\b\"\u0010#J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\tHÆ\u0003J\t\u0010H\u001a\u00020\u000bHÆ\u0003J\t\u0010I\u001a\u00020\tHÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\t\u0010L\u001a\u00020\tHÆ\u0003J\t\u0010M\u001a\u00020\u0011HÆ\u0003J\t\u0010N\u001a\u00020\u0011HÆ\u0003J\t\u0010O\u001a\u00020\u0011HÆ\u0003J\t\u0010P\u001a\u00020\u0011HÆ\u0003J\t\u0010Q\u001a\u00020\u0011HÆ\u0003J\t\u0010R\u001a\u00020\u0011HÆ\u0003J\t\u0010S\u001a\u00020\u000bHÆ\u0003J\t\u0010T\u001a\u00020\tHÆ\u0003J\t\u0010U\u001a\u00020\tHÆ\u0003J\u0015\u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001bHÆ\u0003J\t\u0010W\u001a\u00020\u0011HÆ\u0003J\t\u0010X\u001a\u00020\u000bHÆ\u0003J\t\u0010Y\u001a\u00020\u0003HÆ\u0003J\t\u0010Z\u001a\u00020\u0003HÆ\u0003J\u008f\u0002\u0010[\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u00112\b\b\u0002\u0010\u0016\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\t2\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b2\b\b\u0002\u0010\u001e\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u000b2\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\\\u001a\u00020\u000b2\b\u0010]\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010^\u001a\u00020\tHÖ\u0001J\t\u0010_\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010%R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010%R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010%R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010,R\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b-\u0010+R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010%R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010%R\u0011\u0010\u000f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b0\u0010+R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u0010\u0012\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b3\u00102R\u0011\u0010\u0013\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b4\u00102R\u0011\u0010\u0014\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b5\u00102R\u0011\u0010\u0015\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b6\u00102R\u0011\u0010\u0016\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b7\u00102R\u0011\u0010\u0017\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b8\u0010,R\u0011\u0010\u0018\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b9\u0010+R\u0011\u0010\u0019\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b:\u0010+R\u001d\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0011\u0010\u001e\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b=\u00102R\u0011\u0010\u001f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b>\u0010,R\u0011\u0010 \u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u0010%R\u0011\u0010!\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b@\u0010%R\u0011\u0010A\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\bA\u0010,¨\u0006b"}, d2 = {"Lkntr/base/mod/internal/KModImpl$RemoteModInfo;", "", "poolName", "", "modName", "url", "md5", "totalMd5", "increment", "", "isWifi", "", "level", "filename", "fileType", "compressType", "publishTime", "", "poolId", "moduleId", AppKey.VERSION, "fileId", "fileSize", "zipCheck", "downloadType", "experimentalType", "patchMap", "", "Lkntr/base/mod/internal/KModImpl$RemoteModInfo$Patch$Type;", "Lkntr/base/mod/internal/KModImpl$RemoteModInfo$Patch;", "supportType", "passwordRequired", "password", "region", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZILjava/lang/String;Ljava/lang/String;IJJJJJJZIILjava/util/Map;JZLjava/lang/String;Ljava/lang/String;)V", "getPoolName", "()Ljava/lang/String;", "getModName", "getUrl", "getMd5", "getTotalMd5", "getIncrement", "()I", "()Z", "getLevel", "getFilename", "getFileType", "getCompressType", "getPublishTime", "()J", "getPoolId", "getModuleId", "getVersion", "getFileId", "getFileSize", "getZipCheck", "getDownloadType", "getExperimentalType", "getPatchMap", "()Ljava/util/Map;", "getSupportType", "getPasswordRequired", "getPassword", "getRegion", "isAutoDownload", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "copy", "equals", "other", "hashCode", "toString", "Patch", "Companion", "mod_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class RemoteModInfo {
        public static final Companion Companion = new Companion(null);
        private final int compressType;
        private final int downloadType;
        private final int experimentalType;
        private final long fileId;
        private final long fileSize;
        private final String fileType;
        private final String filename;
        private final int increment;
        private final boolean isWifi;
        private final int level;
        private final String md5;
        private final String modName;
        private final long moduleId;
        private final String password;
        private final boolean passwordRequired;
        private final Map<Patch.Type, Patch> patchMap;
        private final long poolId;
        private final String poolName;
        private final long publishTime;
        private final String region;
        private final long supportType;
        private final String totalMd5;
        private final String url;
        private final long version;
        private final boolean zipCheck;

        public final String component1() {
            return this.poolName;
        }

        public final String component10() {
            return this.fileType;
        }

        public final int component11() {
            return this.compressType;
        }

        public final long component12() {
            return this.publishTime;
        }

        public final long component13() {
            return this.poolId;
        }

        public final long component14() {
            return this.moduleId;
        }

        public final long component15() {
            return this.version;
        }

        public final long component16() {
            return this.fileId;
        }

        public final long component17() {
            return this.fileSize;
        }

        public final boolean component18() {
            return this.zipCheck;
        }

        public final int component19() {
            return this.downloadType;
        }

        public final String component2() {
            return this.modName;
        }

        public final int component20() {
            return this.experimentalType;
        }

        public final Map<Patch.Type, Patch> component21() {
            return this.patchMap;
        }

        public final long component22() {
            return this.supportType;
        }

        public final boolean component23() {
            return this.passwordRequired;
        }

        public final String component24() {
            return this.password;
        }

        public final String component25() {
            return this.region;
        }

        public final String component3() {
            return this.url;
        }

        public final String component4() {
            return this.md5;
        }

        public final String component5() {
            return this.totalMd5;
        }

        public final int component6() {
            return this.increment;
        }

        public final boolean component7() {
            return this.isWifi;
        }

        public final int component8() {
            return this.level;
        }

        public final String component9() {
            return this.filename;
        }

        public final RemoteModInfo copy(String str, String str2, String str3, String str4, String str5, int i, boolean z, int i2, String str6, String str7, int i3, long j, long j2, long j3, long j4, long j5, long j6, boolean z2, int i4, int i5, Map<Patch.Type, Patch> map, long j7, boolean z3, String str8, String str9) {
            Intrinsics.checkNotNullParameter(str, "poolName");
            Intrinsics.checkNotNullParameter(str2, "modName");
            Intrinsics.checkNotNullParameter(str3, "url");
            Intrinsics.checkNotNullParameter(str4, "md5");
            Intrinsics.checkNotNullParameter(str5, "totalMd5");
            Intrinsics.checkNotNullParameter(str6, "filename");
            Intrinsics.checkNotNullParameter(str7, "fileType");
            Intrinsics.checkNotNullParameter(map, "patchMap");
            Intrinsics.checkNotNullParameter(str8, "password");
            Intrinsics.checkNotNullParameter(str9, "region");
            return new RemoteModInfo(str, str2, str3, str4, str5, i, z, i2, str6, str7, i3, j, j2, j3, j4, j5, j6, z2, i4, i5, map, j7, z3, str8, str9);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof RemoteModInfo) {
                RemoteModInfo remoteModInfo = (RemoteModInfo) obj;
                return Intrinsics.areEqual(this.poolName, remoteModInfo.poolName) && Intrinsics.areEqual(this.modName, remoteModInfo.modName) && Intrinsics.areEqual(this.url, remoteModInfo.url) && Intrinsics.areEqual(this.md5, remoteModInfo.md5) && Intrinsics.areEqual(this.totalMd5, remoteModInfo.totalMd5) && this.increment == remoteModInfo.increment && this.isWifi == remoteModInfo.isWifi && this.level == remoteModInfo.level && Intrinsics.areEqual(this.filename, remoteModInfo.filename) && Intrinsics.areEqual(this.fileType, remoteModInfo.fileType) && this.compressType == remoteModInfo.compressType && this.publishTime == remoteModInfo.publishTime && this.poolId == remoteModInfo.poolId && this.moduleId == remoteModInfo.moduleId && this.version == remoteModInfo.version && this.fileId == remoteModInfo.fileId && this.fileSize == remoteModInfo.fileSize && this.zipCheck == remoteModInfo.zipCheck && this.downloadType == remoteModInfo.downloadType && this.experimentalType == remoteModInfo.experimentalType && Intrinsics.areEqual(this.patchMap, remoteModInfo.patchMap) && this.supportType == remoteModInfo.supportType && this.passwordRequired == remoteModInfo.passwordRequired && Intrinsics.areEqual(this.password, remoteModInfo.password) && Intrinsics.areEqual(this.region, remoteModInfo.region);
            }
            return false;
        }

        public int hashCode() {
            return (((((((((((((((((((((((((((((((((((((((((((((((this.poolName.hashCode() * 31) + this.modName.hashCode()) * 31) + this.url.hashCode()) * 31) + this.md5.hashCode()) * 31) + this.totalMd5.hashCode()) * 31) + this.increment) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isWifi)) * 31) + this.level) * 31) + this.filename.hashCode()) * 31) + this.fileType.hashCode()) * 31) + this.compressType) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.publishTime)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.poolId)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.moduleId)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.version)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.fileId)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.fileSize)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.zipCheck)) * 31) + this.downloadType) * 31) + this.experimentalType) * 31) + this.patchMap.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.supportType)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.passwordRequired)) * 31) + this.password.hashCode()) * 31) + this.region.hashCode();
        }

        public String toString() {
            String str = this.poolName;
            String str2 = this.modName;
            String str3 = this.url;
            String str4 = this.md5;
            String str5 = this.totalMd5;
            int i = this.increment;
            boolean z = this.isWifi;
            int i2 = this.level;
            String str6 = this.filename;
            String str7 = this.fileType;
            int i3 = this.compressType;
            long j = this.publishTime;
            long j2 = this.poolId;
            long j3 = this.moduleId;
            long j4 = this.version;
            long j5 = this.fileId;
            long j6 = this.fileSize;
            boolean z2 = this.zipCheck;
            int i4 = this.downloadType;
            int i5 = this.experimentalType;
            Map<Patch.Type, Patch> map = this.patchMap;
            long j7 = this.supportType;
            boolean z3 = this.passwordRequired;
            String str8 = this.password;
            return "RemoteModInfo(poolName=" + str + ", modName=" + str2 + ", url=" + str3 + ", md5=" + str4 + ", totalMd5=" + str5 + ", increment=" + i + ", isWifi=" + z + ", level=" + i2 + ", filename=" + str6 + ", fileType=" + str7 + ", compressType=" + i3 + ", publishTime=" + j + ", poolId=" + j2 + ", moduleId=" + j3 + ", version=" + j4 + ", fileId=" + j5 + ", fileSize=" + j6 + ", zipCheck=" + z2 + ", downloadType=" + i4 + ", experimentalType=" + i5 + ", patchMap=" + map + ", supportType=" + j7 + ", passwordRequired=" + z3 + ", password=" + str8 + ", region=" + this.region + ")";
        }

        public RemoteModInfo(String poolName, String modName, String url, String md5, String totalMd5, int increment, boolean isWifi, int level, String filename, String fileType, int compressType, long publishTime, long poolId, long moduleId, long version, long fileId, long fileSize, boolean zipCheck, int downloadType, int experimentalType, Map<Patch.Type, Patch> map, long supportType, boolean passwordRequired, String password, String region) {
            Intrinsics.checkNotNullParameter(poolName, "poolName");
            Intrinsics.checkNotNullParameter(modName, "modName");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(md5, "md5");
            Intrinsics.checkNotNullParameter(totalMd5, "totalMd5");
            Intrinsics.checkNotNullParameter(filename, "filename");
            Intrinsics.checkNotNullParameter(fileType, "fileType");
            Intrinsics.checkNotNullParameter(map, "patchMap");
            Intrinsics.checkNotNullParameter(password, "password");
            Intrinsics.checkNotNullParameter(region, "region");
            this.poolName = poolName;
            this.modName = modName;
            this.url = url;
            this.md5 = md5;
            this.totalMd5 = totalMd5;
            this.increment = increment;
            this.isWifi = isWifi;
            this.level = level;
            this.filename = filename;
            this.fileType = fileType;
            this.compressType = compressType;
            this.publishTime = publishTime;
            this.poolId = poolId;
            this.moduleId = moduleId;
            this.version = version;
            this.fileId = fileId;
            this.fileSize = fileSize;
            this.zipCheck = zipCheck;
            this.downloadType = downloadType;
            this.experimentalType = experimentalType;
            this.patchMap = map;
            this.supportType = supportType;
            this.passwordRequired = passwordRequired;
            this.password = password;
            this.region = region;
        }

        public /* synthetic */ RemoteModInfo(String str, String str2, String str3, String str4, String str5, int i, boolean z, int i2, String str6, String str7, int i3, long j, long j2, long j3, long j4, long j5, long j6, boolean z2, int i4, int i5, Map map, long j7, boolean z3, String str8, String str9, int i6, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, str4, str5, i, z, i2, str6, str7, i3, j, j2, j3, j4, j5, j6, (i6 & 131072) != 0 ? true : z2, (i6 & 262144) != 0 ? 0 : i4, (i6 & 524288) != 0 ? 0 : i5, (i6 & 1048576) != 0 ? MapsKt.emptyMap() : map, (i6 & 2097152) != 0 ? 0L : j7, (i6 & 4194304) != 0 ? false : z3, (i6 & 8388608) != 0 ? "" : str8, (i6 & 16777216) != 0 ? "" : str9);
        }

        public final String getPoolName() {
            return this.poolName;
        }

        public final String getModName() {
            return this.modName;
        }

        public final String getUrl() {
            return this.url;
        }

        public final String getMd5() {
            return this.md5;
        }

        public final String getTotalMd5() {
            return this.totalMd5;
        }

        public final int getIncrement() {
            return this.increment;
        }

        public final boolean isWifi() {
            return this.isWifi;
        }

        public final int getLevel() {
            return this.level;
        }

        public final String getFilename() {
            return this.filename;
        }

        public final String getFileType() {
            return this.fileType;
        }

        public final int getCompressType() {
            return this.compressType;
        }

        public final long getPublishTime() {
            return this.publishTime;
        }

        public final long getPoolId() {
            return this.poolId;
        }

        public final long getModuleId() {
            return this.moduleId;
        }

        public final long getVersion() {
            return this.version;
        }

        public final long getFileId() {
            return this.fileId;
        }

        public final long getFileSize() {
            return this.fileSize;
        }

        public final boolean getZipCheck() {
            return this.zipCheck;
        }

        public final int getDownloadType() {
            return this.downloadType;
        }

        public final int getExperimentalType() {
            return this.experimentalType;
        }

        public final Map<Patch.Type, Patch> getPatchMap() {
            return this.patchMap;
        }

        public final long getSupportType() {
            return this.supportType;
        }

        public final boolean getPasswordRequired() {
            return this.passwordRequired;
        }

        public final String getPassword() {
            return this.password;
        }

        public final String getRegion() {
            return this.region;
        }

        public final boolean isAutoDownload() {
            return this.level != 3;
        }

        /* compiled from: KModImpl.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0018B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lkntr/base/mod/internal/KModImpl$RemoteModInfo$Patch;", "", "url", "", "md5", "size", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V", "getUrl", "()Ljava/lang/String;", "getMd5", "getSize", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Type", "mod_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Patch {
            private final String md5;
            private final long size;
            private final String url;

            public static /* synthetic */ Patch copy$default(Patch patch, String str, String str2, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = patch.url;
                }
                if ((i & 2) != 0) {
                    str2 = patch.md5;
                }
                if ((i & 4) != 0) {
                    j = patch.size;
                }
                return patch.copy(str, str2, j);
            }

            public final String component1() {
                return this.url;
            }

            public final String component2() {
                return this.md5;
            }

            public final long component3() {
                return this.size;
            }

            public final Patch copy(String str, String str2, long j) {
                Intrinsics.checkNotNullParameter(str, "url");
                Intrinsics.checkNotNullParameter(str2, "md5");
                return new Patch(str, str2, j);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Patch) {
                    Patch patch = (Patch) obj;
                    return Intrinsics.areEqual(this.url, patch.url) && Intrinsics.areEqual(this.md5, patch.md5) && this.size == patch.size;
                }
                return false;
            }

            public int hashCode() {
                return (((this.url.hashCode() * 31) + this.md5.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.size);
            }

            public String toString() {
                String str = this.url;
                String str2 = this.md5;
                return "Patch(url=" + str + ", md5=" + str2 + ", size=" + this.size + ")";
            }

            public Patch(String url, String md5, long size) {
                Intrinsics.checkNotNullParameter(url, "url");
                Intrinsics.checkNotNullParameter(md5, "md5");
                this.url = url;
                this.md5 = md5;
                this.size = size;
            }

            public final String getUrl() {
                return this.url;
            }

            public final String getMd5() {
                return this.md5;
            }

            public final long getSize() {
                return this.size;
            }

            /* compiled from: KModImpl.kt */
            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lkntr/base/mod/internal/KModImpl$RemoteModInfo$Patch$Type;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SPatch", "DPatch", "SPatchBz", "mod_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public enum Type {
                SPatch(".sdiff"),
                DPatch(".bspatch"),
                SPatchBz(".sdiff");
                
                private final String value;
                private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

                public static EnumEntries<Type> getEntries() {
                    return $ENTRIES;
                }

                Type(String value) {
                    this.value = value;
                }

                public final String getValue() {
                    return this.value;
                }
            }
        }

        /* compiled from: KModImpl.kt */
        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0016\u0010\f\u001a\u00020\t*\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\"\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e*\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002¨\u0006\u0011"}, d2 = {"Lkntr/base/mod/internal/KModImpl$RemoteModInfo$Companion;", "", "<init>", "()V", "create", "Lkntr/base/mod/internal/KModImpl$RemoteModInfo;", "reply", "Lcom/bapis/bilibili/app/resource/v1/KModuleReply;", "poolName", "", "host", "Lcom/bapis/bilibili/app/resource/v1/KHost;", "mergeUrl", "adaptPatchMap", "", "Lkntr/base/mod/internal/KModImpl$RemoteModInfo$Patch$Type;", "Lkntr/base/mod/internal/KModImpl$RemoteModInfo$Patch;", "mod_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final RemoteModInfo create(KModuleReply reply, String poolName, KHost host) {
                Intrinsics.checkNotNullParameter(reply, "reply");
                Intrinsics.checkNotNullParameter(poolName, "poolName");
                String name = reply.getName();
                String mergeUrl = mergeUrl(reply.getUrl(), host);
                String md5 = reply.getMd5();
                String totalMd5 = reply.getTotalMd5();
                int value = reply.getIncrement().getValue();
                boolean isWifi = reply.isWifi();
                int value2 = reply.getLevel().getValue();
                String filename = reply.getFilename();
                if (filename.length() == 0) {
                    long version = reply.getVersion();
                    String fileType = reply.getFileType();
                    if (fileType.length() == 0) {
                        fileType = "zip";
                    }
                    filename = version + "." + ((Object) fileType);
                }
                String str = filename;
                String fileType2 = reply.getFileType();
                int value3 = reply.getCompress().getValue();
                long publishTime = reply.getPublishTime();
                long poolId = reply.getPoolId();
                long moduleId = reply.getModuleId();
                long version2 = reply.getVersion();
                long fileId = reply.getFileId();
                long fileSize = reply.getFileSize();
                boolean zipCheck = reply.getZipCheck();
                int downloadStrategy = (int) reply.getDownloadStrategy();
                int experimentStrategy = (int) reply.getExperimentStrategy();
                Map<Patch.Type, Patch> adaptPatchMap = adaptPatchMap(reply, host);
                long supportType = reply.getSupportType();
                boolean passwordRequired = reply.getPasswordRequired();
                String password = reply.getPassword();
                String region = reply.getRegion();
                if (region.length() == 0) {
                    region = "default";
                }
                return new RemoteModInfo(poolName, name, mergeUrl, md5, totalMd5, value, isWifi, value2, str, fileType2, value3, publishTime, poolId, moduleId, version2, fileId, fileSize, zipCheck, downloadStrategy, experimentStrategy, adaptPatchMap, supportType, passwordRequired, password, region);
            }

            private final String mergeUrl(String $this$mergeUrl, KHost host) {
                if (host != null) {
                    if (StringsKt.startsWith($this$mergeUrl, Constants.SCHEME_BOSS, true)) {
                        return StringsKt.replaceFirst($this$mergeUrl, Constants.SCHEME_BOSS, host.getBoss(), true);
                    }
                    if (StringsKt.startsWith($this$mergeUrl, Constants.SCHEME_BFS, true)) {
                        return StringsKt.replaceFirst($this$mergeUrl, Constants.SCHEME_BFS, host.getBfs(), true);
                    }
                }
                return $this$mergeUrl;
            }

            private final Map<Patch.Type, Patch> adaptPatchMap(KModuleReply $this$adaptPatchMap, KHost host) {
                Map map = new LinkedHashMap();
                KPatchInfo it = (KPatchInfo) $this$adaptPatchMap.getPatchMap().get("sdiff");
                if (it != null) {
                    map.put(Patch.Type.SPatch, new Patch(RemoteModInfo.Companion.mergeUrl(it.getUrl(), host), it.getMd5(), it.getSize()));
                }
                KPatchInfo it2 = (KPatchInfo) $this$adaptPatchMap.getPatchMap().get("bspatch");
                if (it2 != null) {
                    map.put(Patch.Type.DPatch, new Patch(RemoteModInfo.Companion.mergeUrl(it2.getUrl(), host), it2.getMd5(), it2.getSize()));
                }
                KPatchInfo it3 = (KPatchInfo) $this$adaptPatchMap.getPatchMap().get("bz");
                if (it3 != null) {
                    map.put(Patch.Type.SPatchBz, new Patch(RemoteModInfo.Companion.mergeUrl(it3.getUrl(), host), it3.getMd5(), it3.getSize()));
                }
                if (Intrinsics.areEqual($this$adaptPatchMap.getIncrement(), KIncrementType.INCREMENTAL.INSTANCE) && map.get(Patch.Type.DPatch) == null) {
                    map.put(Patch.Type.DPatch, new Patch(mergeUrl($this$adaptPatchMap.getUrl(), host), $this$adaptPatchMap.getMd5(), $this$adaptPatchMap.getFileSize()));
                }
                return map;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: KModImpl.kt */
    @Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014J\u001e\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u0014\u0012\b\u0012\u00060\u0018R\u00020\u00190\u0017H\u0086@¢\u0006\u0002\u0010\u001aJ\"\u0010\u001b\u001a\u00060\u0018R\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010\u001fJ\u0016\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0003J\f\u0010%\u001a\u00020\u0003*\u00020\u0003H\u0002J\u0018\u0010&\u001a\u0004\u0018\u00010!2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u0003JA\u0010(\u001a\u00020)21\u0010*\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0/\u0012\u0006\u0012\u0004\u0018\u00010\u00010+H\u0086H¢\u0006\u0002\u00100J\u000e\u00101\u001a\u00020)2\u0006\u00102\u001a\u00020!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00060\u000fj\u0002`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lkntr/base/mod/internal/KModImpl$StorageManager;", "", "root", "Lkotlinx/io/files/Path;", "<init>", "(Lkntr/base/mod/internal/KModImpl;Lkotlinx/io/files/Path;)V", "getRoot", "()Lkotlinx/io/files/Path;", "modsDir", "getModsDir", "tmpDir", "getTmpDir", "tmpIndex", "", "storageLock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/atomicfu/locks/ReentrantLock;", "deleteMod", "", "poolName", "", "modName", "startUp", "", "Lkntr/base/mod/internal/KModImpl$ModPoolImpl;", "Lkntr/base/mod/internal/KModImpl;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadPool", "scope", "Lkotlinx/coroutines/CoroutineScope;", "poolRoot", "(Lkotlinx/coroutines/CoroutineScope;Lkotlinx/io/files/Path;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "install", "Lkntr/base/mod/internal/KModImpl$ModResourceImpl;", "info", "Lkntr/base/mod/internal/KModImpl$RemoteModInfo;", "finalFile", "metaInfo", "loadModResource", "modPath", "withTmpDir", "", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "tmpPath", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markResourceDeprecated", "local", "mod_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public final class StorageManager {
        private final Path modsDir;
        private final Path root;
        private final ReentrantLock storageLock;
        final /* synthetic */ KModImpl this$0;
        private final Path tmpDir;
        private int tmpIndex;

        public StorageManager(KModImpl this$0, Path root) {
            Intrinsics.checkNotNullParameter(root, "root");
            this.this$0 = this$0;
            this.root = root;
            this.modsDir = PathsKt.Path(this.root, new String[]{"mods"});
            this.tmpDir = PathsKt.Path(this.root, new String[]{"tmp"});
            this.storageLock = new ReentrantLock();
        }

        public final Path getRoot() {
            return this.root;
        }

        public final Path getModsDir() {
            return this.modsDir;
        }

        public final Path getTmpDir() {
            return this.tmpDir;
        }

        public final boolean deleteMod(String poolName, String modName) {
            Intrinsics.checkNotNullParameter(poolName, "poolName");
            Intrinsics.checkNotNullParameter(modName, "modName");
            Path modPath = PathsKt.Path(this.modsDir, new String[]{poolName, modName});
            return this.this$0.deleteRecursively(modPath);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00ac A[LOOP:0: B:25:0x00a6->B:27:0x00ac, LOOP_END] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object startUp(Continuation<? super Map<String, ModPoolImpl>> continuation) {
            KModImpl$StorageManager$startUp$1 kModImpl$StorageManager$startUp$1;
            Object coroutineScope;
            if (continuation instanceof KModImpl$StorageManager$startUp$1) {
                kModImpl$StorageManager$startUp$1 = (KModImpl$StorageManager$startUp$1) continuation;
                if ((kModImpl$StorageManager$startUp$1.label & Integer.MIN_VALUE) != 0) {
                    kModImpl$StorageManager$startUp$1.label -= Integer.MIN_VALUE;
                    Object $result = kModImpl$StorageManager$startUp$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (kModImpl$StorageManager$startUp$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            FileSystem.-CC.createDirectories$default(FileSystemJvmKt.SystemFileSystem, this.root, false, 2, (Object) null);
                            FileSystem.-CC.createDirectories$default(FileSystemJvmKt.SystemFileSystem, this.modsDir, false, 2, (Object) null);
                            FileMetadata tmpMeta = FileSystemJvmKt.SystemFileSystem.metadataOrNull(this.tmpDir);
                            if (tmpMeta != null && tmpMeta.isDirectory()) {
                                Boxing.boxBoolean(this.this$0.clearDirectory(this.tmpDir));
                            } else {
                                FileSystem.-CC.createDirectories$default(FileSystemJvmKt.SystemFileSystem, this.tmpDir, false, 2, (Object) null);
                            }
                            kModImpl$StorageManager$startUp$1.L$0 = SpillingKt.nullOutSpilledVariable(tmpMeta);
                            kModImpl$StorageManager$startUp$1.label = 1;
                            coroutineScope = CoroutineScopeKt.coroutineScope(new KModImpl$StorageManager$startUp$2(this, null), kModImpl$StorageManager$startUp$1);
                            if (coroutineScope != coroutine_suspended) {
                                break;
                            } else {
                                return coroutine_suspended;
                            }
                            break;
                        case 1:
                            FileMetadata fileMetadata = (FileMetadata) kModImpl$StorageManager$startUp$1.L$0;
                            ResultKt.throwOnFailure($result);
                            coroutineScope = $result;
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Iterable $this$associateBy$iv = (Iterable) coroutineScope;
                    int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16);
                    Map destination$iv$iv = new LinkedHashMap(capacity$iv);
                    for (Object element$iv$iv : $this$associateBy$iv) {
                        ModPoolImpl it = (ModPoolImpl) element$iv$iv;
                        destination$iv$iv.put(it.getPoolName(), element$iv$iv);
                    }
                    return destination$iv$iv;
                }
            }
            kModImpl$StorageManager$startUp$1 = new KModImpl$StorageManager$startUp$1(this, continuation);
            Object $result2 = kModImpl$StorageManager$startUp$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (kModImpl$StorageManager$startUp$1.label) {
            }
            Iterable $this$associateBy$iv2 = (Iterable) coroutineScope;
            int capacity$iv2 = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv2, 10)), 16);
            Map destination$iv$iv2 = new LinkedHashMap(capacity$iv2);
            while (r9.hasNext()) {
            }
            return destination$iv$iv2;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0032  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0047  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object loadPool(CoroutineScope scope, Path poolRoot, Continuation<? super ModPoolImpl> continuation) {
            KModImpl$StorageManager$loadPool$1 kModImpl$StorageManager$loadPool$1;
            Object awaitAll;
            Path poolRoot2 = poolRoot;
            if (continuation instanceof KModImpl$StorageManager$loadPool$1) {
                kModImpl$StorageManager$loadPool$1 = (KModImpl$StorageManager$loadPool$1) continuation;
                if ((kModImpl$StorageManager$loadPool$1.label & Integer.MIN_VALUE) != 0) {
                    kModImpl$StorageManager$loadPool$1.label -= Integer.MIN_VALUE;
                    Object $result = kModImpl$StorageManager$loadPool$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (kModImpl$StorageManager$loadPool$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            String poolName = poolRoot.getName();
                            Iterable $this$map$iv = FileSystemJvmKt.SystemFileSystem.list(poolRoot2);
                            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                            for (Object item$iv$iv : $this$map$iv) {
                                Path it = (Path) item$iv$iv;
                                destination$iv$iv.add(BuildersKt.async$default(scope, (CoroutineContext) null, (CoroutineStart) null, new KModImpl$StorageManager$loadPool$resources$1$1(this, poolName, it, null), 3, (Object) null));
                                $result = $result;
                            }
                            kModImpl$StorageManager$loadPool$1.L$0 = SpillingKt.nullOutSpilledVariable(scope);
                            kModImpl$StorageManager$loadPool$1.L$1 = poolRoot2;
                            kModImpl$StorageManager$loadPool$1.L$2 = SpillingKt.nullOutSpilledVariable(poolName);
                            kModImpl$StorageManager$loadPool$1.label = 1;
                            awaitAll = AwaitKt.awaitAll((List) destination$iv$iv, kModImpl$StorageManager$loadPool$1);
                            if (awaitAll != coroutine_suspended) {
                                break;
                            } else {
                                return coroutine_suspended;
                            }
                        case 1:
                            String str = (String) kModImpl$StorageManager$loadPool$1.L$2;
                            poolRoot2 = (Path) kModImpl$StorageManager$loadPool$1.L$1;
                            CoroutineScope coroutineScope = (CoroutineScope) kModImpl$StorageManager$loadPool$1.L$0;
                            ResultKt.throwOnFailure($result);
                            awaitAll = $result;
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    List resources = CollectionsKt.filterNotNull((Iterable) awaitAll);
                    return new ModPoolImpl(this.this$0, poolRoot2, resources);
                }
            }
            kModImpl$StorageManager$loadPool$1 = new KModImpl$StorageManager$loadPool$1(this, continuation);
            Object $result2 = kModImpl$StorageManager$loadPool$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (kModImpl$StorageManager$loadPool$1.label) {
            }
            List resources2 = CollectionsKt.filterNotNull((Iterable) awaitAll);
            return new ModPoolImpl(this.this$0, poolRoot2, resources2);
        }

        public final ModResourceImpl install(RemoteModInfo info, Path finalFile) {
            String str;
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(finalFile, "finalFile");
            if (info.getCompressType() == KCompressType.UNZIP.INSTANCE.getValue()) {
                str = "unzipped";
            } else {
                str = null;
            }
            String unzipDirName = str;
            Path curTmpDir = finalFile.getParent();
            Intrinsics.checkNotNull(curTmpDir);
            if (unzipDirName != null) {
                Path unzipDir = PathsKt.Path(curTmpDir, new String[]{unzipDirName});
                ResultKt.throwOnFailure(ZipKt.unzip(finalFile.toString(), unzipDir.toString(), true));
            }
            LocalModInfo local = new LocalModInfo(info.getPoolName(), info.getModName(), info.getModuleId(), info.getVersion(), info.getTotalMd5(), info.getFileSize(), finalFile.getName(), info.getRegion(), unzipDirName, false);
            Path modPath = PathsKt.Path(this.modsDir, new String[]{info.getPoolName(), info.getModName()});
            FileSystem.-CC.createDirectories$default(FileSystemJvmKt.SystemFileSystem, modPath, false, 2, (Object) null);
            ModResourceImpl resource = new ModResourceImpl(modPath, local);
            FileSystemJvmKt.SystemFileSystem.atomicMove(curTmpDir, resource.getVersionDir());
            Path metaInfo = metaInfo(modPath);
            try {
                Sink sink = (AutoCloseable) CoreKt.buffered(FileSystem.-CC.sink$default(FileSystemJvmKt.SystemFileSystem, metaInfo, false, 2, (Object) null));
                Sink it = sink;
                StringFormat $this$encodeToString$iv = Json.Default;
                $this$encodeToString$iv.getSerializersModule();
                String str2 = $this$encodeToString$iv.encodeToString(LocalModInfo.Companion.serializer(), local);
                Utf8Kt.writeString$default(it, str2, 0, 0, 6, (Object) null);
                Unit unit = Unit.INSTANCE;
                AutoCloseableKt.closeFinally(sink, (Throwable) null);
                return resource;
            } catch (Exception e) {
                this.this$0.deleteRecursively(resource.getVersionDir());
                throw e;
            }
        }

        private final Path metaInfo(Path $this$metaInfo) {
            return PathsKt.Path($this$metaInfo, new String[]{Constants.META_FILE});
        }

        public final ModResourceImpl loadModResource(String poolName, Path modPath) {
            Intrinsics.checkNotNullParameter(poolName, "poolName");
            Intrinsics.checkNotNullParameter(modPath, "modPath");
            FileMetadata metadataOrNull = FileSystemJvmKt.SystemFileSystem.metadataOrNull(modPath);
            if (metadataOrNull == null) {
                return null;
            }
            FileMetadata meta = metadataOrNull;
            boolean z = false;
            if (!meta.isDirectory()) {
                FileSystem.-CC.delete$default(FileSystemJvmKt.SystemFileSystem, modPath, false, 2, (Object) null);
                return null;
            }
            Path metaInfo = metaInfo(modPath);
            if (!FileSystemJvmKt.SystemFileSystem.exists(metaInfo)) {
                this.this$0.deleteRecursively(modPath);
                return null;
            }
            try {
                Source it = (AutoCloseable) CoreKt.buffered(FileSystemJvmKt.SystemFileSystem.source(metaInfo));
                try {
                    Json this_$iv = Json.Default;
                    String string$iv = Utf8Kt.readString(it);
                    this_$iv.getSerializersModule();
                    LocalModInfo it2 = (LocalModInfo) this_$iv.decodeFromString(LocalModInfo.Companion.serializer(), string$iv);
                    AutoCloseableKt.closeFinally(it, (Throwable) null);
                    if (Intrinsics.areEqual(it2.getPoolName(), poolName)) {
                        try {
                            if (Intrinsics.areEqual(it2.getModName(), modPath.getName())) {
                                z = true;
                            }
                        } catch (Exception e) {
                            e = e;
                            KLog_androidKt.getKLog().e("KModStorage", "loadModResource fail to read meta info", e);
                            this.this$0.deleteRecursively(modPath);
                            return null;
                        }
                    }
                    if (!z) {
                        throw new IllegalArgumentException(("Mod meta info mismatch for " + poolName + "::$" + modPath.getName() + ", meta: " + it2).toString());
                    } else if (it2.getDeletedFromRemote()) {
                        this.this$0.deleteRecursively(modPath);
                        return null;
                    } else {
                        ModResourceImpl it3 = new ModResourceImpl(modPath, it2);
                        KModImpl kModImpl = this.this$0;
                        Path versionDir = it3.getVersionDir();
                        try {
                            Result.Companion companion = Result.Companion;
                            StorageManager storageManager = this;
                            Iterable $this$forEach$iv = FileSystemJvmKt.SystemFileSystem.list(modPath);
                            for (Object element$iv : $this$forEach$iv) {
                                Path it4 = (Path) element$iv;
                                FileMetadata meta2 = meta;
                                try {
                                    if (!Intrinsics.areEqual(it4, versionDir) && !Intrinsics.areEqual(it4, metaInfo)) {
                                        kModImpl.deleteRecursively(it4);
                                    }
                                    meta = meta2;
                                } catch (Throwable th) {
                                    th = th;
                                    Result.Companion companion2 = Result.Companion;
                                    Result.m2636constructorimpl(ResultKt.createFailure(th));
                                    return it3;
                                }
                            }
                            Result.m2636constructorimpl(Unit.INSTANCE);
                        } catch (Throwable th2) {
                            th = th2;
                        }
                        return it3;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Exception e3) {
                e = e3;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0043  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object withTmpDir(Function2<? super Path, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
            KModImpl$StorageManager$withTmpDir$1 kModImpl$StorageManager$withTmpDir$1;
            Path tmpSubDir;
            Throwable th;
            if (continuation instanceof KModImpl$StorageManager$withTmpDir$1) {
                kModImpl$StorageManager$withTmpDir$1 = (KModImpl$StorageManager$withTmpDir$1) continuation;
                if ((kModImpl$StorageManager$withTmpDir$1.label & Integer.MIN_VALUE) != 0) {
                    kModImpl$StorageManager$withTmpDir$1.label -= Integer.MIN_VALUE;
                    Object $result = kModImpl$StorageManager$withTmpDir$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (kModImpl$StorageManager$withTmpDir$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            ReentrantLock reentrantLock = this.storageLock;
                            reentrantLock.lock();
                            try {
                                Path tmpDir = getTmpDir();
                                int i = this.tmpIndex;
                                this.tmpIndex = i + 1;
                                Path tmpSubDir2 = PathsKt.Path(tmpDir, new String[]{"tmp_" + i});
                                while (FileSystemJvmKt.SystemFileSystem.exists(tmpSubDir2)) {
                                    Path tmpDir2 = getTmpDir();
                                    int i2 = this.tmpIndex;
                                    this.tmpIndex = i2 + 1;
                                    tmpSubDir2 = PathsKt.Path(tmpDir2, new String[]{"tmp_" + i2});
                                }
                                FileSystem.-CC.createDirectories$default(FileSystemJvmKt.SystemFileSystem, tmpSubDir2, false, 2, (Object) null);
                                InlineMarker.finallyStart(1);
                                reentrantLock.unlock();
                                InlineMarker.finallyEnd(1);
                                Path tmpSubDir3 = tmpSubDir2;
                                try {
                                    kModImpl$StorageManager$withTmpDir$1.L$0 = SpillingKt.nullOutSpilledVariable(function2);
                                    kModImpl$StorageManager$withTmpDir$1.L$1 = tmpSubDir3;
                                    kModImpl$StorageManager$withTmpDir$1.I$0 = 0;
                                    kModImpl$StorageManager$withTmpDir$1.label = 1;
                                    if (function2.invoke(tmpSubDir3, kModImpl$StorageManager$withTmpDir$1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    tmpSubDir = tmpSubDir3;
                                    InlineMarker.finallyStart(1);
                                    KModImpl kModImpl = this.this$0;
                                    try {
                                        Result.Companion companion = Result.Companion;
                                        ReentrantLock reentrantLock2 = this.storageLock;
                                        reentrantLock2.lock();
                                        boolean deleteRecursively = kModImpl.deleteRecursively(tmpSubDir);
                                        InlineMarker.finallyStart(1);
                                        reentrantLock2.unlock();
                                        InlineMarker.finallyEnd(1);
                                        Result.m2636constructorimpl(Boxing.boxBoolean(deleteRecursively));
                                    } catch (Throwable th2) {
                                        Result.Companion companion2 = Result.Companion;
                                        Result.m2636constructorimpl(ResultKt.createFailure(th2));
                                    }
                                    InlineMarker.finallyEnd(1);
                                    return Unit.INSTANCE;
                                } catch (Throwable th3) {
                                    tmpSubDir = tmpSubDir3;
                                    th = th3;
                                    InlineMarker.finallyStart(1);
                                    KModImpl kModImpl2 = this.this$0;
                                    try {
                                        Result.Companion companion3 = Result.Companion;
                                        ReentrantLock reentrantLock3 = this.storageLock;
                                        reentrantLock3.lock();
                                        boolean deleteRecursively2 = kModImpl2.deleteRecursively(tmpSubDir);
                                        InlineMarker.finallyStart(1);
                                        reentrantLock3.unlock();
                                        InlineMarker.finallyEnd(1);
                                        Result.m2636constructorimpl(Boxing.boxBoolean(deleteRecursively2));
                                    } catch (Throwable th4) {
                                        Result.Companion companion4 = Result.Companion;
                                        Result.m2636constructorimpl(ResultKt.createFailure(th4));
                                    }
                                    InlineMarker.finallyEnd(1);
                                    throw th;
                                }
                            } catch (Throwable th5) {
                                InlineMarker.finallyStart(1);
                                reentrantLock.unlock();
                                InlineMarker.finallyEnd(1);
                                throw th5;
                            }
                        case 1:
                            int i3 = kModImpl$StorageManager$withTmpDir$1.I$0;
                            tmpSubDir = (Path) kModImpl$StorageManager$withTmpDir$1.L$1;
                            Function2 function22 = (Function2) kModImpl$StorageManager$withTmpDir$1.L$0;
                            try {
                                ResultKt.throwOnFailure($result);
                                InlineMarker.finallyStart(1);
                                KModImpl kModImpl3 = this.this$0;
                                Result.Companion companion5 = Result.Companion;
                                ReentrantLock reentrantLock22 = this.storageLock;
                                reentrantLock22.lock();
                                boolean deleteRecursively3 = kModImpl3.deleteRecursively(tmpSubDir);
                                InlineMarker.finallyStart(1);
                                reentrantLock22.unlock();
                                InlineMarker.finallyEnd(1);
                                Result.m2636constructorimpl(Boxing.boxBoolean(deleteRecursively3));
                                InlineMarker.finallyEnd(1);
                                return Unit.INSTANCE;
                            } catch (Throwable th6) {
                                th = th6;
                                InlineMarker.finallyStart(1);
                                KModImpl kModImpl22 = this.this$0;
                                Result.Companion companion32 = Result.Companion;
                                ReentrantLock reentrantLock32 = this.storageLock;
                                reentrantLock32.lock();
                                boolean deleteRecursively22 = kModImpl22.deleteRecursively(tmpSubDir);
                                InlineMarker.finallyStart(1);
                                reentrantLock32.unlock();
                                InlineMarker.finallyEnd(1);
                                Result.m2636constructorimpl(Boxing.boxBoolean(deleteRecursively22));
                                InlineMarker.finallyEnd(1);
                                throw th;
                            }
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            kModImpl$StorageManager$withTmpDir$1 = new KModImpl$StorageManager$withTmpDir$1(this, continuation);
            Object $result2 = kModImpl$StorageManager$withTmpDir$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (kModImpl$StorageManager$withTmpDir$1.label) {
            }
        }

        private final Object withTmpDir$$forInline(Function2<? super Path, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
            ReentrantLock reentrantLock = this.storageLock;
            reentrantLock.lock();
            try {
                Path tmpDir = getTmpDir();
                int i = this.tmpIndex;
                this.tmpIndex = i + 1;
                Path tmpSubDir = PathsKt.Path(tmpDir, new String[]{"tmp_" + i});
                while (FileSystemJvmKt.SystemFileSystem.exists(tmpSubDir)) {
                    Path tmpDir2 = getTmpDir();
                    int i2 = this.tmpIndex;
                    this.tmpIndex = i2 + 1;
                    tmpSubDir = PathsKt.Path(tmpDir2, new String[]{"tmp_" + i2});
                }
                FileSystem.-CC.createDirectories$default(FileSystemJvmKt.SystemFileSystem, tmpSubDir, false, 2, (Object) null);
                InlineMarker.finallyStart(1);
                reentrantLock.unlock();
                InlineMarker.finallyEnd(1);
                Path tmpSubDir2 = tmpSubDir;
                try {
                    function2.invoke(tmpSubDir2, continuation);
                    InlineMarker.finallyStart(1);
                    KModImpl kModImpl = this.this$0;
                    try {
                        Result.Companion companion = Result.Companion;
                        StorageManager $this$withTmpDir_u24lambda_u241 = this;
                        ReentrantLock reentrantLock2 = $this$withTmpDir_u24lambda_u241.storageLock;
                        reentrantLock2.lock();
                        Boolean valueOf = Boolean.valueOf(kModImpl.deleteRecursively(tmpSubDir2));
                        InlineMarker.finallyStart(1);
                        reentrantLock2.unlock();
                        InlineMarker.finallyEnd(1);
                        Boolean bool = valueOf;
                        Result.m2636constructorimpl(Boolean.valueOf(valueOf.booleanValue()));
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.Companion;
                        Result.m2636constructorimpl(ResultKt.createFailure(th));
                    }
                    InlineMarker.finallyEnd(1);
                    return Unit.INSTANCE;
                } catch (Throwable th2) {
                    InlineMarker.finallyStart(1);
                    KModImpl kModImpl2 = this.this$0;
                    try {
                        Result.Companion companion3 = Result.Companion;
                        StorageManager $this$withTmpDir_u24lambda_u2412 = this;
                        ReentrantLock reentrantLock3 = $this$withTmpDir_u24lambda_u2412.storageLock;
                        reentrantLock3.lock();
                        Boolean valueOf2 = Boolean.valueOf(kModImpl2.deleteRecursively(tmpSubDir2));
                        InlineMarker.finallyStart(1);
                        reentrantLock3.unlock();
                        InlineMarker.finallyEnd(1);
                        Boolean bool2 = valueOf2;
                        Result.m2636constructorimpl(Boolean.valueOf(valueOf2.booleanValue()));
                    } catch (Throwable th3) {
                        Result.Companion companion4 = Result.Companion;
                        Result.m2636constructorimpl(ResultKt.createFailure(th3));
                    }
                    InlineMarker.finallyEnd(1);
                    throw th2;
                }
            } catch (Throwable th4) {
                InlineMarker.finallyStart(1);
                reentrantLock.unlock();
                InlineMarker.finallyEnd(1);
                throw th4;
            }
        }

        public final void markResourceDeprecated(ModResourceImpl local) {
            Intrinsics.checkNotNullParameter(local, "local");
            Path metaInfo = metaInfo(PathsKt.Path(this.modsDir, new String[]{local.getPoolName(), local.getModName()}));
            try {
                Result.Companion companion = Result.Companion;
                StorageManager storageManager = this;
                Sink sink = (AutoCloseable) CoreKt.buffered(FileSystem.-CC.sink$default(FileSystemJvmKt.SystemFileSystem, metaInfo, false, 2, (Object) null));
                Sink it = sink;
                StringFormat $this$encodeToString$iv = Json.Default;
                Object value$iv = LocalModInfo.copy$default(local.getInfo(), null, null, 0L, 0L, null, 0L, null, null, null, true, 511, null);
                $this$encodeToString$iv.getSerializersModule();
                Utf8Kt.writeString$default(it, $this$encodeToString$iv.encodeToString(LocalModInfo.Companion.serializer(), value$iv), 0, 0, 6, (Object) null);
                Unit unit = Unit.INSTANCE;
                AutoCloseableKt.closeFinally(sink, (Throwable) null);
                Result.m2636constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.m2636constructorimpl(ResultKt.createFailure(th));
            }
        }
    }

    /* compiled from: KModImpl.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ;2\u00020\u0001:\u0002:;BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010Bw\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u000f\u0010\u0015J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0006HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u000eHÆ\u0003Jo\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u0010.\u001a\u00020\u000e2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\u0012HÖ\u0001J\t\u00101\u001a\u00020\u0003HÖ\u0001J%\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u00002\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H\u0001¢\u0006\u0002\b9R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u0006<"}, d2 = {"Lkntr/base/mod/internal/KModImpl$LocalModInfo;", "", "poolName", "", "modName", "moduleId", "", AppKey.VERSION, "md5", "size", "fileName", "region", "unzipDirName", "deletedFromRemote", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;JJLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getPoolName", "()Ljava/lang/String;", "getModName", "getModuleId", "()J", "getVersion", "getMd5", "getSize", "getFileName", "getRegion", "getUnzipDirName", "getDeletedFromRemote", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$mod_debug", "$serializer", "Companion", "mod_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class LocalModInfo {
        public static final Companion Companion = new Companion(null);
        private final boolean deletedFromRemote;
        private final String fileName;
        private final String md5;
        private final String modName;
        private final long moduleId;
        private final String poolName;
        private final String region;
        private final long size;
        private final String unzipDirName;
        private final long version;

        public static /* synthetic */ LocalModInfo copy$default(LocalModInfo localModInfo, String str, String str2, long j, long j2, String str3, long j3, String str4, String str5, String str6, boolean z, int i, Object obj) {
            return localModInfo.copy((i & 1) != 0 ? localModInfo.poolName : str, (i & 2) != 0 ? localModInfo.modName : str2, (i & 4) != 0 ? localModInfo.moduleId : j, (i & 8) != 0 ? localModInfo.version : j2, (i & 16) != 0 ? localModInfo.md5 : str3, (i & 32) != 0 ? localModInfo.size : j3, (i & 64) != 0 ? localModInfo.fileName : str4, (i & 128) != 0 ? localModInfo.region : str5, (i & 256) != 0 ? localModInfo.unzipDirName : str6, (i & 512) != 0 ? localModInfo.deletedFromRemote : z);
        }

        public final String component1() {
            return this.poolName;
        }

        public final boolean component10() {
            return this.deletedFromRemote;
        }

        public final String component2() {
            return this.modName;
        }

        public final long component3() {
            return this.moduleId;
        }

        public final long component4() {
            return this.version;
        }

        public final String component5() {
            return this.md5;
        }

        public final long component6() {
            return this.size;
        }

        public final String component7() {
            return this.fileName;
        }

        public final String component8() {
            return this.region;
        }

        public final String component9() {
            return this.unzipDirName;
        }

        public final LocalModInfo copy(String str, String str2, long j, long j2, String str3, long j3, String str4, String str5, String str6, boolean z) {
            Intrinsics.checkNotNullParameter(str, "poolName");
            Intrinsics.checkNotNullParameter(str2, "modName");
            Intrinsics.checkNotNullParameter(str3, "md5");
            Intrinsics.checkNotNullParameter(str4, "fileName");
            Intrinsics.checkNotNullParameter(str5, "region");
            return new LocalModInfo(str, str2, j, j2, str3, j3, str4, str5, str6, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LocalModInfo) {
                LocalModInfo localModInfo = (LocalModInfo) obj;
                return Intrinsics.areEqual(this.poolName, localModInfo.poolName) && Intrinsics.areEqual(this.modName, localModInfo.modName) && this.moduleId == localModInfo.moduleId && this.version == localModInfo.version && Intrinsics.areEqual(this.md5, localModInfo.md5) && this.size == localModInfo.size && Intrinsics.areEqual(this.fileName, localModInfo.fileName) && Intrinsics.areEqual(this.region, localModInfo.region) && Intrinsics.areEqual(this.unzipDirName, localModInfo.unzipDirName) && this.deletedFromRemote == localModInfo.deletedFromRemote;
            }
            return false;
        }

        public int hashCode() {
            return (((((((((((((((((this.poolName.hashCode() * 31) + this.modName.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.moduleId)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.version)) * 31) + this.md5.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.size)) * 31) + this.fileName.hashCode()) * 31) + this.region.hashCode()) * 31) + (this.unzipDirName == null ? 0 : this.unzipDirName.hashCode())) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.deletedFromRemote);
        }

        public String toString() {
            String str = this.poolName;
            String str2 = this.modName;
            long j = this.moduleId;
            long j2 = this.version;
            String str3 = this.md5;
            long j3 = this.size;
            String str4 = this.fileName;
            String str5 = this.region;
            String str6 = this.unzipDirName;
            return "LocalModInfo(poolName=" + str + ", modName=" + str2 + ", moduleId=" + j + ", version=" + j2 + ", md5=" + str3 + ", size=" + j3 + ", fileName=" + str4 + ", region=" + str5 + ", unzipDirName=" + str6 + ", deletedFromRemote=" + this.deletedFromRemote + ")";
        }

        /* compiled from: KModImpl.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/base/mod/internal/KModImpl$LocalModInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/base/mod/internal/KModImpl$LocalModInfo;", "mod_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<LocalModInfo> serializer() {
                return KModImpl$LocalModInfo$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ LocalModInfo(int seen0, String poolName, String modName, long moduleId, long version, String md5, long size, String fileName, String region, String unzipDirName, boolean deletedFromRemote, SerializationConstructorMarker serializationConstructorMarker) {
            if (1023 != (seen0 & 1023)) {
                PluginExceptionsKt.throwMissingFieldException(seen0, 1023, KModImpl$LocalModInfo$$serializer.INSTANCE.getDescriptor());
            }
            this.poolName = poolName;
            this.modName = modName;
            this.moduleId = moduleId;
            this.version = version;
            this.md5 = md5;
            this.size = size;
            this.fileName = fileName;
            this.region = region;
            this.unzipDirName = unzipDirName;
            this.deletedFromRemote = deletedFromRemote;
        }

        public LocalModInfo(String poolName, String modName, long moduleId, long version, String md5, long size, String fileName, String region, String unzipDirName, boolean deletedFromRemote) {
            Intrinsics.checkNotNullParameter(poolName, "poolName");
            Intrinsics.checkNotNullParameter(modName, "modName");
            Intrinsics.checkNotNullParameter(md5, "md5");
            Intrinsics.checkNotNullParameter(fileName, "fileName");
            Intrinsics.checkNotNullParameter(region, "region");
            this.poolName = poolName;
            this.modName = modName;
            this.moduleId = moduleId;
            this.version = version;
            this.md5 = md5;
            this.size = size;
            this.fileName = fileName;
            this.region = region;
            this.unzipDirName = unzipDirName;
            this.deletedFromRemote = deletedFromRemote;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$mod_debug(LocalModInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.poolName);
            output.encodeStringElement(serialDesc, 1, self.modName);
            output.encodeLongElement(serialDesc, 2, self.moduleId);
            output.encodeLongElement(serialDesc, 3, self.version);
            output.encodeStringElement(serialDesc, 4, self.md5);
            output.encodeLongElement(serialDesc, 5, self.size);
            output.encodeStringElement(serialDesc, 6, self.fileName);
            output.encodeStringElement(serialDesc, 7, self.region);
            output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.unzipDirName);
            output.encodeBooleanElement(serialDesc, 9, self.deletedFromRemote);
        }

        public final String getPoolName() {
            return this.poolName;
        }

        public final String getModName() {
            return this.modName;
        }

        public final long getModuleId() {
            return this.moduleId;
        }

        public final long getVersion() {
            return this.version;
        }

        public final String getMd5() {
            return this.md5;
        }

        public final long getSize() {
            return this.size;
        }

        public final String getFileName() {
            return this.fileName;
        }

        public final String getRegion() {
            return this.region;
        }

        public final String getUnzipDirName() {
            return this.unzipDirName;
        }

        public final boolean getDeletedFromRemote() {
            return this.deletedFromRemote;
        }
    }

    /* compiled from: KModImpl.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001d\u001a\u00020\u000eH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\fR\u0011\u0010\u0015\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\fR\u0014\u0010\u0017\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0010¨\u0006\u001e"}, d2 = {"Lkntr/base/mod/internal/KModImpl$ModResourceImpl;", "Lkntr/base/mod/ModResource;", "modDir", "Lkotlinx/io/files/Path;", "info", "Lkntr/base/mod/internal/KModImpl$LocalModInfo;", "<init>", "(Lkotlinx/io/files/Path;Lkntr/base/mod/internal/KModImpl$LocalModInfo;)V", "getInfo", "()Lkntr/base/mod/internal/KModImpl$LocalModInfo;", "versionDir", "getVersionDir", "()Lkotlinx/io/files/Path;", "poolName", "", "getPoolName", "()Ljava/lang/String;", "modName", "getModName", "path", "getPath", "originalPath", "getOriginalPath", AppKey.VERSION, "", "getVersion", "()J", "region", "getRegion", "toString", "mod_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ModResourceImpl implements ModResource {
        private final LocalModInfo info;
        private final Path path;
        private final Path versionDir;

        public ModResourceImpl(Path modDir, LocalModInfo info) {
            Intrinsics.checkNotNullParameter(modDir, "modDir");
            Intrinsics.checkNotNullParameter(info, "info");
            this.info = info;
            this.versionDir = PathsKt.Path(modDir, new String[]{String.valueOf(getVersion())});
            Path path = this.versionDir;
            String unzipDirName = this.info.getUnzipDirName();
            this.path = PathsKt.Path(path, new String[]{unzipDirName == null ? this.info.getFileName() : unzipDirName});
        }

        public final LocalModInfo getInfo() {
            return this.info;
        }

        public final Path getVersionDir() {
            return this.versionDir;
        }

        @Override // kntr.base.mod.ModResource
        public String getPoolName() {
            return this.info.getPoolName();
        }

        @Override // kntr.base.mod.ModResource
        public String getModName() {
            return this.info.getModName();
        }

        @Override // kntr.base.mod.ModResource
        public Path getPath() {
            return this.path;
        }

        public final Path getOriginalPath() {
            return PathsKt.Path(this.versionDir, new String[]{this.info.getFileName()});
        }

        @Override // kntr.base.mod.ModResource
        public long getVersion() {
            return this.info.getVersion();
        }

        @Override // kntr.base.mod.ModResource
        public String getRegion() {
            return this.info.getRegion();
        }

        public String toString() {
            LocalModInfo localModInfo = this.info;
            return "ModResourceImpl(info=" + localModInfo + ", versionDir=" + this.versionDir + ")";
        }
    }

    /* compiled from: KModImpl.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkntr/base/mod/internal/KModImpl$Constants;", "", "<init>", "()V", "MC_MODULE_LIST_API_LITE_NONE", "", "MC_MODULE_LIST_API_LITE2_RES", "MOD_LEVEL_LOW", "SCHEME_BOSS", "", "SCHEME_BFS", "META_FILE", "mod_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    private static final class Constants {
        public static final Constants INSTANCE = new Constants();
        public static final int MC_MODULE_LIST_API_LITE2_RES = 2;
        public static final int MC_MODULE_LIST_API_LITE_NONE = 0;
        public static final String META_FILE = "info.json";
        public static final int MOD_LEVEL_LOW = 3;
        public static final String SCHEME_BFS = "bfs://";
        public static final String SCHEME_BOSS = "boss://";

        private Constants() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isTerminal(ModEvent.FetchEvent $this$isTerminal) {
        return ($this$isTerminal instanceof ModEvent.Succeed) || ($this$isTerminal instanceof ModEvent.Failure);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean deleteRecursively(Path $this$deleteRecursively) {
        try {
            FileMetadata meta = FileSystemJvmKt.SystemFileSystem.metadataOrNull($this$deleteRecursively);
            if (meta == null) {
                return true;
            }
            if (meta.isDirectory()) {
                clearDirectory($this$deleteRecursively);
            }
            FileSystem.-CC.delete$default(FileSystemJvmKt.SystemFileSystem, $this$deleteRecursively, false, 2, (Object) null);
            return true;
        } catch (IOException e) {
            KLog_androidKt.getKLog().e("KModImpl", "deleteRecursively fail for " + $this$deleteRecursively + ".", e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean clearDirectory(Path $this$clearDirectory) {
        try {
            Iterable $this$forEach$iv = FileSystemJvmKt.SystemFileSystem.list($this$clearDirectory);
            for (Object element$iv : $this$forEach$iv) {
                Path it = (Path) element$iv;
                FileMetadata meta = FileSystemJvmKt.SystemFileSystem.metadataOrNull(it);
                if (meta != null) {
                    if (meta.isDirectory()) {
                        clearDirectory(it);
                    }
                    FileSystem.-CC.delete$default(FileSystemJvmKt.SystemFileSystem, it, false, 2, (Object) null);
                }
            }
            return true;
        } catch (IOException e) {
            KLog_androidKt.getKLog().e("KModImpl", "clearDirectory fail for " + $this$clearDirectory + ".", e);
            return false;
        }
    }
}