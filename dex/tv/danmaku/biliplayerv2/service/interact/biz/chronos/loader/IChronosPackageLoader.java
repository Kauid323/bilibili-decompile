package tv.danmaku.biliplayerv2.service.interact.biz.chronos.loader;

import bolts.CancellationToken;
import bolts.Task;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.PackageResult;
import tv.danmaku.biliplayerv2.service.interact.biz.model.viewprogress.uniteviewprogress.ViewProgressDetail;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IChronosPackageLoader.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/loader/IChronosPackageLoader;", "", "getLoadTask", "Lbolts/Task;", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/PackageResult;", "viewProgressDetail", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/viewprogress/uniteviewprogress/ViewProgressDetail;", "ct", "Lbolts/CancellationToken;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IChronosPackageLoader {
    Task<PackageResult> getLoadTask(ViewProgressDetail viewProgressDetail, CancellationToken cancellationToken);
}