package tv.danmaku.bili.fullscreen.service;

import dagger.assisted.AssistedFactory;
import kotlin.Metadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.state.IPhoneOnePassState;
import tv.danmaku.bili.fullscreen.state.PhoneOnePassStateMachine;

/* compiled from: ServiceProvider.kt */
@AssistedFactory
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/fullscreen/service/IPhoneOnePassStateMachineFactory;", "", "create", "Ltv/danmaku/bili/fullscreen/state/PhoneOnePassStateMachine;", "initialState", "Ltv/danmaku/bili/fullscreen/state/IPhoneOnePassState;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface IPhoneOnePassStateMachineFactory {
    PhoneOnePassStateMachine create(IPhoneOnePassState iPhoneOnePassState);
}