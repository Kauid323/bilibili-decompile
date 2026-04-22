package tv.danmaku.bili.fullscreen.state;

import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: SmsLoginPageState.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u00012\u00020\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\u0007\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/ISmsLoginLoadingState;", "Ltv/danmaku/bili/fullscreen/state/ISmsLoginPageState;", "Ltv/danmaku/bili/fullscreen/state/NetCodeEnableState;", "input", "Ltv/danmaku/bili/fullscreen/state/SmsLoginInput;", "getInput", "()Ltv/danmaku/bili/fullscreen/state/SmsLoginInput;", "Ltv/danmaku/bili/fullscreen/state/SmsLoginLoadingCountingState;", "Ltv/danmaku/bili/fullscreen/state/SmsLoginLoadingIdleState;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface ISmsLoginLoadingState extends ISmsLoginPageState, NetCodeEnableState {
    SmsLoginInput getInput();
}