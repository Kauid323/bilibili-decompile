package tv.danmaku.bili.fullscreen.service;

import dagger.assisted.AssistedFactory;
import java.util.List;
import kotlin.Metadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.route.ValidLoginType;
import tv.danmaku.bili.fullscreen.state.FullscreenLoginStateMachine;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginState;

/* compiled from: ServiceProvider.kt */
@AssistedFactory
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/fullscreen/service/IFullscreenLoginStateMachineFactory;", "", "create", "Ltv/danmaku/bili/fullscreen/state/FullscreenLoginStateMachine;", "validTypes", "", "Ltv/danmaku/bili/fullscreen/route/ValidLoginType;", "initial", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginState;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface IFullscreenLoginStateMachineFactory {
    FullscreenLoginStateMachine create(List<? extends ValidLoginType> list, IFullscreenLoginState iFullscreenLoginState);
}