package tv.danmaku.biliplayerv2.injection;

import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;
import tv.danmaku.biliplayerv2.service.IPlayerService;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SuppressiblePlayer.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&R\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/injection/SuppressiblePlayer;", "Ltv/danmaku/biliplayerv2/service/IPlayerService;", "doSuppressionWith", "", "suppressor", "", "undoSuppressionOf", "pause", "resume", "allowedToPlayFlow", "Lkotlinx/coroutines/flow/Flow;", "", "getAllowedToPlayFlow", "()Lkotlinx/coroutines/flow/Flow;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface SuppressiblePlayer extends IPlayerService {
    void doSuppressionWith(Object obj);

    Flow<Boolean> getAllowedToPlayFlow();

    void pause();

    void resume();

    void undoSuppressionOf(Object obj);
}