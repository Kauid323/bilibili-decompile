package tv.danmaku.biliplayerv2.service;

import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.flow.StateFlow;
import tv.danmaku.biliplayerv2.ControlContainerType;
import tv.danmaku.biliplayerv2.service.interact.biz.model.ChronosThumbnailInfo;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SeekService.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H&J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH&J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH&J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0013H&J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0013H&J!\u0010\u0015\u001a\u00020\u00072\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u0017\"\u00020\u0018H&¢\u0006\u0002\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0004H&J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0004H&J\b\u0010\u001e\u001a\u00020\u0004H&J\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0004H&J\b\u0010 \u001a\u00020\u0004H&J\u0010\u0010!\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\"H&J\u0010\u0010#\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\"H&J\u0010\u0010$\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0004H&J\b\u0010%\u001a\u00020\u0004H&J\b\u0010&\u001a\u00020\u0007H&J\b\u0010'\u001a\u00020\u0007H&J\b\u0010(\u001a\u00020\u0004H&J\u0010\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020+H&J\u0010\u0010,\u001a\u00020\u00072\u0006\u0010*\u001a\u00020+H&J\u0018\u0010-\u001a\u00020\u00072\u000e\u0010.\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010/H&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u00061À\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/ISeekService;", "Ltv/danmaku/biliplayerv2/service/IPlayerService;", "isDraggingByUserFlow", "Lkotlinx/coroutines/flow/StateFlow;", "", "()Lkotlinx/coroutines/flow/StateFlow;", "setDraggingByUser", "", "fromUser", "setDraggingProgress", "progress", "", "duration", "refreshPlayerProgress", "registerPlayerProgressObserver", "observer", "Ltv/danmaku/biliplayerv2/service/PlayerProgressObserver;", "unregisterPlayerProgressObserver", "registerDraggingProgress", "Ltv/danmaku/biliplayerv2/service/DraggingProgressObserver;", "unregisterDraggingProgress", "setShowSimpleProgressControlTypes", "types", "", "Ltv/danmaku/biliplayerv2/ControlContainerType;", "([Ltv/danmaku/biliplayerv2/ControlContainerType;)V", "setProgressMutuallyExclusive", "exclusive", "setSeekEnable", "enable", "isSeekEnable", "setSeekGestureEnable", "isSeekGestureEnable", "addSeekGestureEnableObserver", "Ltv/danmaku/biliplayerv2/service/SeekGestureEnableObserver;", "removeSeekGestureEnableObserver", "setThumbnailEnable", "isThumbnailEnable", "tryToShowSimpleProgress", "hideSimpleProgress", "isSimpleProgressShowing", "addSimpleProgressCondition", "condition", "Ltv/danmaku/biliplayerv2/service/SimpleProgressCondition;", "removeSimpleProgressCondition", "updateHeaderTailPoints", "headerTailPoints", "", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/ChronosThumbnailInfo$WatchPoint;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface ISeekService extends IPlayerService {
    void addSeekGestureEnableObserver(SeekGestureEnableObserver seekGestureEnableObserver);

    void addSimpleProgressCondition(SimpleProgressCondition simpleProgressCondition);

    void hideSimpleProgress();

    StateFlow<Boolean> isDraggingByUserFlow();

    boolean isSeekEnable();

    boolean isSeekGestureEnable();

    boolean isSimpleProgressShowing();

    boolean isThumbnailEnable();

    void refreshPlayerProgress(int i, int i2);

    void registerDraggingProgress(DraggingProgressObserver draggingProgressObserver);

    void registerPlayerProgressObserver(PlayerProgressObserver playerProgressObserver);

    void removeSeekGestureEnableObserver(SeekGestureEnableObserver seekGestureEnableObserver);

    void removeSimpleProgressCondition(SimpleProgressCondition simpleProgressCondition);

    void setDraggingByUser(boolean z);

    void setDraggingProgress(int i, int i2);

    void setProgressMutuallyExclusive(boolean z);

    void setSeekEnable(boolean z);

    void setSeekGestureEnable(boolean z);

    void setShowSimpleProgressControlTypes(ControlContainerType... controlContainerTypeArr);

    void setThumbnailEnable(boolean z);

    void tryToShowSimpleProgress();

    void unregisterDraggingProgress(DraggingProgressObserver draggingProgressObserver);

    void unregisterPlayerProgressObserver(PlayerProgressObserver playerProgressObserver);

    void updateHeaderTailPoints(List<ChronosThumbnailInfo.WatchPoint> list);
}