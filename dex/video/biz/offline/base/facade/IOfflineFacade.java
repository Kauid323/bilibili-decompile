package video.biz.offline.base.facade;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.facade.protocol.IDataStorage;
import video.biz.offline.base.facade.protocol.IOperation;

/* compiled from: IOfflineFacade.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0004H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lvideo/biz/offline/base/facade/IOfflineFacade;", "Lvideo/biz/offline/base/facade/protocol/IDataStorage;", "Lvideo/biz/offline/base/facade/protocol/IOperation;", "init", "", "release", "facade_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IOfflineFacade extends IDataStorage, IOperation {
    void init();

    void release();
}