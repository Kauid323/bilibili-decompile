package kntr.base.dd.impl;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.dd.IDeviceDecisionProperty;
import kotlin.Metadata;

/* compiled from: DDProvider.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0012\u0010\n\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0014\u0010\f\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005R\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014¨\u0006\u001cÀ\u0006\u0003"}, d2 = {"Lkntr/base/dd/impl/IDDConstArgs;", "", "presetData", "", "getPresetData", "()Ljava/lang/String;", "presetVersion", "getPresetVersion", "cacheDirectory", "getCacheDirectory", "appKey", "getAppKey", "host", "getHost", "processName", "getProcessName", "defaultProps", "", "Lkntr/base/dd/IDeviceDecisionProperty$Node;", "getDefaultProps", "()Ljava/util/List;", "observableNames", "getObservableNames", "isMainProcess", "", "canPerformUpdate", "appEnvProvider", "Lkntr/base/dd/impl/IAppDDEnvProvider;", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface IDDConstArgs {
    IAppDDEnvProvider appEnvProvider();

    boolean canPerformUpdate();

    String getAppKey();

    String getCacheDirectory();

    List<IDeviceDecisionProperty.Node> getDefaultProps();

    String getHost();

    List<String> getObservableNames();

    String getPresetData();

    String getPresetVersion();

    String getProcessName();

    boolean isMainProcess();

    /* compiled from: DDProvider.kt */
    /* renamed from: kntr.base.dd.impl.IDDConstArgs$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public final /* synthetic */ class CC {
        public static boolean $default$isMainProcess(IDDConstArgs _this) {
            return true;
        }

        public static boolean $default$canPerformUpdate(IDDConstArgs _this) {
            return true;
        }

        public static IAppDDEnvProvider $default$appEnvProvider(IDDConstArgs _this) {
            return null;
        }
    }

    /* compiled from: DDProvider.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static boolean isMainProcess(IDDConstArgs $this) {
            return CC.$default$isMainProcess($this);
        }

        @Deprecated
        public static boolean canPerformUpdate(IDDConstArgs $this) {
            return CC.$default$canPerformUpdate($this);
        }

        @Deprecated
        public static IAppDDEnvProvider appEnvProvider(IDDConstArgs $this) {
            return CC.$default$appEnvProvider($this);
        }
    }
}