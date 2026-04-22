package kntr.base.dd;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: IDeviceDecisionProperty.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\fJ\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u001e\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\tH&¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lkntr/base/dd/IDeviceDecisionProperty;", "", "addPropNodes", "", "nodes", "", "Lkntr/base/dd/IDeviceDecisionProperty$Node;", "onPropertyUpdated", "name", "", "get", "extra", "Node", "api_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface IDeviceDecisionProperty {

    /* compiled from: IDeviceDecisionProperty.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lkntr/base/dd/IDeviceDecisionProperty$Node;", "", "name", "", "getName", "()Ljava/lang/String;", "value", "extra", "api_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public interface Node {
        String getName();

        String value(String str);
    }

    void addPropNodes(List<? extends Node> list);

    String get(String str, String str2);

    void onPropertyUpdated(String str);

    /* compiled from: IDeviceDecisionProperty.kt */
    /* renamed from: kntr.base.dd.IDeviceDecisionProperty$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ String get$default(IDeviceDecisionProperty iDeviceDecisionProperty, String str, String str2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str2 = null;
                }
                return iDeviceDecisionProperty.get(str, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: get");
        }
    }

    /* compiled from: IDeviceDecisionProperty.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DefaultImpls {
    }
}