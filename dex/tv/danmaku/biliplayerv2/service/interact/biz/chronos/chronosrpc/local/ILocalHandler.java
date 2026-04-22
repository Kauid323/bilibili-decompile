package tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.service.interact.biz.InteractModeObserver;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: LocalServiceHandler.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\u000e\u001a\u00020\u0005H&J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/local/ILocalHandler;", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/local/ISampleLocalHandler;", "onStart", "", "multiPlayer", "", "onStop", "onBindPlayerContainer", "playerContainer", "Ltv/danmaku/biliplayerv2/PlayerContainer;", "addInteractModeObserver", "observer", "Ltv/danmaku/biliplayerv2/service/interact/biz/InteractModeObserver;", "removeInteractModeObserver", "isInteractiveMode", "getRpcInvokeObserver", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/local/RpcInvokeObserver;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface ILocalHandler extends ISampleLocalHandler {
    void addInteractModeObserver(InteractModeObserver interactModeObserver);

    RpcInvokeObserver getRpcInvokeObserver();

    boolean isInteractiveMode();

    void onBindPlayerContainer(PlayerContainer playerContainer);

    void onStart(boolean z);

    void onStop();

    void removeInteractModeObserver(InteractModeObserver interactModeObserver);

    /* compiled from: LocalServiceHandler.kt */
    /* renamed from: tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.local.ILocalHandler$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ void onStart$default(ILocalHandler iLocalHandler, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onStart");
            }
            if ((i & 1) != 0) {
                z = false;
            }
            iLocalHandler.onStart(z);
        }
    }
}