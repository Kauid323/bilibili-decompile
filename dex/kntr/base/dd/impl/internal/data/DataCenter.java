package kntr.base.dd.impl.internal.data;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.config.SharedPreferences;
import kntr.base.dd.IDeviceDecision;
import kntr.base.dd.impl.IAppDDEnvProvider;
import kntr.base.utils.CoroutineExKt;
import kntr.common.upper.trace.config.AppKey;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.atomicfu.AtomicRef;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: DataCenter.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001$B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0014\u0010\u001d\u001a\u00020\u001e2\n\u0010\u0018\u001a\u00060\u0012j\u0002`\u0013H\u0016J\u0014\u0010\u001f\u001a\u00020\u001c2\n\u0010\u0018\u001a\u00060\u0012j\u0002`\u0013H\u0016J\u0010\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"H\u0016J\f\u0010#\u001a\u00060\u0012j\u0002`\u0013H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0010\u001a\f\u0012\b\u0012\u00060\u0012j\u0002`\u00130\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0018\u001a\u00060\u0012j\u0002`\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006%"}, d2 = {"Lkntr/base/dd/impl/internal/data/DataCenter;", "Lkntr/base/dd/impl/internal/data/IDataCenter;", "presetData", "Lkntr/base/dd/impl/internal/data/DataCenter$PresetData;", "envProvider", "Lkntr/base/dd/impl/IAppDDEnvProvider;", "ioScope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lkntr/base/dd/impl/internal/data/DataCenter$PresetData;Lkntr/base/dd/impl/IAppDDEnvProvider;Lkotlinx/coroutines/CoroutineScope;)V", "flow", "Lkntr/base/dd/impl/internal/data/DateCenterFlow;", "getFlow", "()Lkntr/base/dd/impl/internal/data/DateCenterFlow;", "sp", "Lkntr/base/config/SharedPreferences;", "_env", "Lkotlinx/atomicfu/AtomicRef;", "Lkntr/base/dd/IDeviceDecision$Version$Env;", "Lkntr/base/dd/impl/internal/common/DDEnv;", "mock", "Lkntr/base/dd/impl/internal/data/CoreData;", "test", "prod", "env", "getEnv", "()Lkntr/base/dd/IDeviceDecision$Version$Env;", "currentData", "Lkntr/base/dd/impl/internal/data/ICoreData;", "changeEnv", "", "dataWithEnv", "dataWithType", "dataType", "Lkntr/base/dd/impl/internal/data/CoreDataType;", "readLocalEnv", "PresetData", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DataCenter implements IDataCenter {
    private final AtomicRef<IDeviceDecision.Version.Env> _env;
    private final IAppDDEnvProvider envProvider;
    private final DateCenterFlow flow;
    private final CoroutineScope ioScope;
    private final CoreData mock;
    private final CoreData prod;
    private final SharedPreferences sp;
    private final CoreData test;

    /* compiled from: DataCenter.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[IDeviceDecision.Version.Env.values().length];
            try {
                iArr[IDeviceDecision.Version.Env.Test.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[CoreDataType.values().length];
            try {
                iArr2[CoreDataType.PROD.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr2[CoreDataType.TEST.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public DataCenter(PresetData presetData, IAppDDEnvProvider envProvider, CoroutineScope ioScope) {
        Intrinsics.checkNotNullParameter(presetData, "presetData");
        Intrinsics.checkNotNullParameter(ioScope, "ioScope");
        this.envProvider = envProvider;
        this.ioScope = ioScope;
        this.flow = new DateCenterFlow();
        this.sp = new SharedPreferences("dd_core_data", true);
        this._env = AtomicFU.atomic(readLocalEnv());
        this.mock = new CoreData(CoreDataType.MOCK, this.sp, getFlow(), this.ioScope, null, 16, null);
        this.test = new CoreData(CoreDataType.TEST, this.sp, getFlow(), this.ioScope, null, 16, null);
        this.prod = new CoreData(CoreDataType.PROD, this.sp, getFlow(), this.ioScope, presetData);
        IAppDDEnvProvider provider = this.envProvider;
        if (provider == null) {
            return;
        }
        BuildersKt.launch$default(this.ioScope, (CoroutineContext) null, (CoroutineStart) null, new DataCenter$1$1(provider, this, null), 3, (Object) null);
    }

    public /* synthetic */ DataCenter(PresetData presetData, IAppDDEnvProvider iAppDDEnvProvider, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(presetData, iAppDDEnvProvider, (i & 4) != 0 ? CoroutineExKt.createIOScope() : coroutineScope);
    }

    /* compiled from: DataCenter.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lkntr/base/dd/impl/internal/data/DataCenter$PresetData;", "", "data", "", AppKey.VERSION, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getData", "()Ljava/lang/String;", "getVersion", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class PresetData {
        private final String data;
        private final String version;

        public PresetData() {
            this(null, null, 3, null);
        }

        public static /* synthetic */ PresetData copy$default(PresetData presetData, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = presetData.data;
            }
            if ((i & 2) != 0) {
                str2 = presetData.version;
            }
            return presetData.copy(str, str2);
        }

        public final String component1() {
            return this.data;
        }

        public final String component2() {
            return this.version;
        }

        public final PresetData copy(String str, String str2) {
            return new PresetData(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof PresetData) {
                PresetData presetData = (PresetData) obj;
                return Intrinsics.areEqual(this.data, presetData.data) && Intrinsics.areEqual(this.version, presetData.version);
            }
            return false;
        }

        public int hashCode() {
            return ((this.data == null ? 0 : this.data.hashCode()) * 31) + (this.version != null ? this.version.hashCode() : 0);
        }

        public String toString() {
            String str = this.data;
            return "PresetData(data=" + str + ", version=" + this.version + ")";
        }

        public PresetData(String data, String version) {
            this.data = data;
            this.version = version;
        }

        public /* synthetic */ PresetData(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
        }

        public final String getData() {
            return this.data;
        }

        public final String getVersion() {
            return this.version;
        }
    }

    @Override // kntr.base.dd.impl.internal.data.IDataCenter
    public DateCenterFlow getFlow() {
        return this.flow;
    }

    @Override // kntr.base.dd.impl.internal.data.IDataCenter
    public IDeviceDecision.Version.Env getEnv() {
        return (IDeviceDecision.Version.Env) this._env.getValue();
    }

    @Override // kntr.base.dd.impl.internal.data.IDataCenter
    public ICoreData currentData() {
        return WhenMappings.$EnumSwitchMapping$0[getEnv().ordinal()] == 1 ? this.test : this.prod;
    }

    @Override // kntr.base.dd.impl.internal.data.IDataCenter
    public void changeEnv(IDeviceDecision.Version.Env env) {
        Intrinsics.checkNotNullParameter(env, "env");
        if (!Intrinsics.areEqual(env.getValue(), ((IDeviceDecision.Version.Env) this._env.getValue()).getValue())) {
            this._env.setValue(env);
            this.sp.setString("env", env.getValue());
            getFlow().didUpdatedVersion(new IDeviceDecision.Version(env, String.valueOf(currentData().getVersion())));
            getFlow().didUpdatedNodes(SetsKt.plus(SetsKt.plus(this.prod.nodeKeys(), this.test.nodeKeys()), this.mock.nodeKeys()));
            getFlow().didUpdatedProps(SetsKt.plus(SetsKt.plus(this.prod.propKeys(), this.test.propKeys()), this.mock.propKeys()));
        }
    }

    @Override // kntr.base.dd.impl.internal.data.IDataCenter
    public ICoreData dataWithEnv(IDeviceDecision.Version.Env env) {
        Intrinsics.checkNotNullParameter(env, "env");
        return WhenMappings.$EnumSwitchMapping$0[env.ordinal()] == 1 ? this.test : this.prod;
    }

    @Override // kntr.base.dd.impl.internal.data.IDataCenter
    public ICoreData dataWithType(CoreDataType dataType) {
        Intrinsics.checkNotNullParameter(dataType, "dataType");
        switch (WhenMappings.$EnumSwitchMapping$1[dataType.ordinal()]) {
            case 1:
                return this.prod;
            case 2:
                return this.test;
            default:
                return this.mock;
        }
    }

    private final IDeviceDecision.Version.Env readLocalEnv() {
        IDeviceDecision.Version.Env currentAppEnv;
        IAppDDEnvProvider iAppDDEnvProvider = this.envProvider;
        if (iAppDDEnvProvider == null || (currentAppEnv = iAppDDEnvProvider.currentAppEnv()) == null) {
            IDeviceDecision.Version.Env.Companion companion = IDeviceDecision.Version.Env.Companion;
            String string$default = SharedPreferences.getString$default(this.sp, "env", null, 2, null);
            if (string$default == null) {
                string$default = "";
            }
            return companion.fromString(string$default);
        }
        return currentAppEnv;
    }
}