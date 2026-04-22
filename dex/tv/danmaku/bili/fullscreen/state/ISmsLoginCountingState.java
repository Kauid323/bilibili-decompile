package tv.danmaku.bili.fullscreen.state;

import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: SmsLoginPageState.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\bH&R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0082\u0001\u0002\r\u000eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/fullscreen/state/ISmsLoginCountingState;", "Ltv/danmaku/bili/fullscreen/state/ISmsLoginPageState;", "Ltv/danmaku/bili/fullscreen/state/NetCodeEnableState;", "input", "Ltv/danmaku/bili/fullscreen/state/SmsLoginInput;", "getInput", "()Ltv/danmaku/bili/fullscreen/state/SmsLoginInput;", "countDown", "", "getCountDown", "()I", "countDownTo", "count", "Ltv/danmaku/bili/fullscreen/state/SmsLoginLoadingCountingState;", "Ltv/danmaku/bili/fullscreen/state/SmsLoginPageInputCountingState;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface ISmsLoginCountingState extends ISmsLoginPageState, NetCodeEnableState {
    ISmsLoginCountingState countDownTo(int i);

    int getCountDown();

    SmsLoginInput getInput();
}