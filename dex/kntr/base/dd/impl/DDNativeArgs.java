package kntr.base.dd.impl;

import com.bilibili.lib.foundation.FoundationAlias;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.dd.IDeviceDecisionProperty;
import kntr.base.dd.impl.internal.common.DDConst;
import kntr.base.dd.impl.internal.common.Utils;
import kntr.base.dd.impl.internal.common.Utils$Companion$decodeFromString$json$1;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonKt;
import okio.BufferedSource;
import okio.Okio;

/* compiled from: DDProvider.android.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u0003H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0016\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0014\u0010\u000e\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\tR\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\t¨\u0006\u001f"}, d2 = {"Lkntr/base/dd/impl/DDNativeArgs;", "Lkntr/base/dd/impl/IDDConstArgs;", "envProvider", "Lkntr/base/dd/impl/IAppDDEnvProvider;", "<init>", "(Lkntr/base/dd/impl/IAppDDEnvProvider;)V", "cacheDirectory", "", "getCacheDirectory", "()Ljava/lang/String;", "appKey", "getAppKey", "host", "getHost", "processName", "getProcessName", "observableNames", "", "getObservableNames", "()Ljava/util/List;", "defaultProps", "Lkntr/base/dd/IDeviceDecisionProperty$Node;", "getDefaultProps", "presetData", "getPresetData", "presetVersion", "getPresetVersion", "isMainProcess", "", "canPerformUpdate", "appEnvProvider", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
final class DDNativeArgs implements IDDConstArgs {
    private final String appKey;
    private final String cacheDirectory;
    private final List<IDeviceDecisionProperty.Node> defaultProps;
    private final IAppDDEnvProvider envProvider;
    private final String host;
    private final List<String> observableNames;
    private final String presetData;
    private final String presetVersion;
    private final String processName;

    public DDNativeArgs(IAppDDEnvProvider envProvider) {
        String str;
        BufferedSource bufferedSource;
        Throwable th;
        String message;
        Object obj;
        Object obj2;
        Long l;
        this.envProvider = envProvider;
        String absolutePath = new File(FoundationAlias.getFapp().getFilesDir(), DDProvider_androidKt.DEVICE_DECISION_CACHE_DIR).getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        this.cacheDirectory = absolutePath;
        this.appKey = FoundationAlias.getFapps().getFawkesAppKey();
        String processName = FoundationAlias.getFapps().getProcessName();
        this.processName = StringsKt.isBlank(processName) ? DDProvider_androidKt.getCurrentProcessName() : processName;
        this.observableNames = CollectionsKt.listOf("mid");
        this.defaultProps = CollectionsKt.listOf(new IDeviceDecisionProperty.Node[]{new AppVersionPropsNode(FoundationAlias.getFapps().getVersionCode()), new BrandPropsNode(), new ChannelPropsNode(FoundationAlias.getFapps().getChannel()), new ModelPropsNode(), new SystemVersionPropsNode()});
        String str2 = null;
        try {
            InputStream open = FoundationAlias.getFapp().getAssets().open("device_decision/prod/dd.json");
            Intrinsics.checkNotNullExpressionValue(open, "open(...)");
            BufferedSource bufferedSource2 = (Closeable) Okio.buffer(Okio.source(open));
            BufferedSource it = bufferedSource2;
            str = it.readUtf8();
            CloseableKt.closeFinally(bufferedSource2, (Throwable) null);
        } catch (Exception e) {
            str = null;
        }
        this.presetData = str;
        try {
            InputStream open2 = FoundationAlias.getFapp().getAssets().open("device_decision/prod/vers.json");
            Intrinsics.checkNotNullExpressionValue(open2, "open(...)");
            bufferedSource = (Closeable) Okio.buffer(Okio.source(open2));
        } catch (Exception e2) {
        }
        try {
            BufferedSource it2 = bufferedSource;
            Utils.Companion companion = Utils.Companion;
            String string$iv = it2.readUtf8();
            try {
                if (string$iv == null) {
                    obj2 = null;
                } else {
                    try {
                        try {
                            Json json$iv = JsonKt.Json$default((Json) null, Utils$Companion$decodeFromString$json$1.INSTANCE, 1, (Object) null);
                            json$iv.getSerializersModule();
                            obj = json$iv.decodeFromString(BuiltinSerializersKt.getNullable(new LinkedHashMapSerializer(StringSerializer.INSTANCE, LongSerializer.INSTANCE)), string$iv);
                        } catch (Throwable th2) {
                            th = th2;
                            throw th;
                        }
                    } catch (Exception e$iv) {
                        try {
                            DDConst.logE$default(DDConst.INSTANCE, "decodeFromString error ," + (e$iv.getMessage() == null ? "undefined" : message), null, 2, null);
                            obj = null;
                        } catch (Throwable th3) {
                            th = th3;
                            th = th;
                            throw th;
                        }
                    }
                    obj2 = obj;
                }
                Map map = (Map) obj2;
                String valueOf = (map == null || (l = (Long) map.get("dd_header_ver")) == null) ? null : String.valueOf(l.longValue());
                CloseableKt.closeFinally(bufferedSource, (Throwable) null);
                str2 = valueOf;
                this.presetVersion = str2;
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    @Override // kntr.base.dd.impl.IDDConstArgs
    public String getCacheDirectory() {
        return this.cacheDirectory;
    }

    @Override // kntr.base.dd.impl.IDDConstArgs
    public String getAppKey() {
        return this.appKey;
    }

    @Override // kntr.base.dd.impl.IDDConstArgs
    public String getHost() {
        return this.host;
    }

    @Override // kntr.base.dd.impl.IDDConstArgs
    public String getProcessName() {
        return this.processName;
    }

    @Override // kntr.base.dd.impl.IDDConstArgs
    public List<String> getObservableNames() {
        return this.observableNames;
    }

    @Override // kntr.base.dd.impl.IDDConstArgs
    public List<IDeviceDecisionProperty.Node> getDefaultProps() {
        return this.defaultProps;
    }

    @Override // kntr.base.dd.impl.IDDConstArgs
    public String getPresetData() {
        return this.presetData;
    }

    @Override // kntr.base.dd.impl.IDDConstArgs
    public String getPresetVersion() {
        return this.presetVersion;
    }

    @Override // kntr.base.dd.impl.IDDConstArgs
    public boolean isMainProcess() {
        return Intrinsics.areEqual(getProcessName(), FoundationAlias.getFapp().getPackageName());
    }

    @Override // kntr.base.dd.impl.IDDConstArgs
    public boolean canPerformUpdate() {
        return isMainProcess() || StringsKt.endsWith$default(getProcessName(), ":safemode", false, 2, (Object) null);
    }

    @Override // kntr.base.dd.impl.IDDConstArgs
    public IAppDDEnvProvider appEnvProvider() {
        return this.envProvider;
    }
}