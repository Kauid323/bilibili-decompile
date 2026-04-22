package video.biz.offline.base.facade.protocol;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.infra.download.PauseType;

/* compiled from: IOperation.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0016\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH§@¢\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010H&J\u0016\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H§@¢\u0006\u0002\u0010\u0014¨\u0006\u0015À\u0006\u0003"}, d2 = {"Lvideo/biz/offline/base/facade/protocol/IOperationList;", "", "start", "", "key", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startAll", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pause", "pauseAll", "type", "Lvideo/biz/offline/base/infra/download/PauseType;", "(Lvideo/biz/offline/base/infra/download/PauseType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDanmaku", "keys", "", "setMaxConcurrent", "max", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "facade_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IOperationList {
    Object pause(String str, Continuation<? super Unit> continuation);

    Object pauseAll(PauseType pauseType, Continuation<? super Unit> continuation);

    Object setMaxConcurrent(int i, Continuation<? super Unit> continuation);

    Object start(String str, Continuation<? super Unit> continuation);

    Object startAll(Continuation<? super Unit> continuation);

    void updateDanmaku(List<String> list);
}