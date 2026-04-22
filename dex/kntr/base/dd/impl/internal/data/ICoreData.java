package kntr.base.dd.impl.internal.data;

import java.util.Map;
import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.dd.impl.internal.model.DDModel;
import kntr.base.dd.impl.internal.model.DDNode;
import kntr.base.dd.impl.internal.model.DDProp;
import kntr.common.upper.trace.config.AppKey;
import kotlin.Metadata;

/* compiled from: ICoreData.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bH&J\u0014\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000bH&J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001e\u0010\u0016\u001a\u00020\u00112\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0018H&J\u001e\u0010\u0019\u001a\u00020\u00112\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0018H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u001aÀ\u0006\u0003"}, d2 = {"Lkntr/base/dd/impl/internal/data/ICoreData;", "", AppKey.VERSION, "", "getVersion", "()J", "node", "Lkntr/base/dd/impl/internal/model/DDNode;", "key", "", "nodeKeys", "", "prop", "Lkntr/base/dd/impl/internal/model/DDProp;", "propKeys", "track", "updateWithModel", "", "model", "Lkntr/base/dd/impl/internal/model/DDModel;", "fallbackWithModel", "updateWithNode", "updateNodeValues", "values", "", "updatePropValues", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface ICoreData {
    void fallbackWithModel(DDModel dDModel);

    long getVersion();

    DDNode node(String str);

    Set<String> nodeKeys();

    DDProp prop(String str);

    Set<String> propKeys();

    DDNode track(String str);

    void updateNodeValues(Map<String, String> map);

    void updatePropValues(Map<String, String> map);

    void updateWithModel(DDModel dDModel);

    void updateWithNode(DDNode dDNode);
}