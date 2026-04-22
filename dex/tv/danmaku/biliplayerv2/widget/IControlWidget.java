package tv.danmaku.biliplayerv2.widget;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IControlWidget.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0007H\u0017J\b\u0010\u000b\u001a\u00020\u0007H\u0017J\u000e\u0010\f\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\rR\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/widget/IControlWidget;", "Ltv/danmaku/biliplayerv2/widget/IWidget;", "membersInjector", "", "getMembersInjector", "()Z", "bindPlayerContainer", "", "playerContainer", "Ltv/danmaku/biliplayerv2/PlayerContainer;", "onWidgetActive", "onWidgetInactive", "bindToView", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IControlWidget extends IWidget {
    @Override // tv.danmaku.biliplayerv2.widget.IWidget
    void bindPlayerContainer(PlayerContainer playerContainer);

    Object bindToView(Continuation<? super Unit> continuation);

    boolean getMembersInjector();

    @Deprecated(message = "use bindToView instead")
    void onWidgetActive();

    @Deprecated(message = "use bindToView instead")
    void onWidgetInactive();

    /* compiled from: IControlWidget.kt */
    /* renamed from: tv.danmaku.biliplayerv2.widget.IControlWidget$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        public static boolean $default$getMembersInjector(IControlWidget _this) {
            return false;
        }

        @Deprecated(message = "use bindToView instead")
        public static void $default$onWidgetActive(IControlWidget _this) {
        }

        @Deprecated(message = "use bindToView instead")
        public static void $default$onWidgetInactive(IControlWidget _this) {
        }

        public static /* synthetic */ Object bindToView$suspendImpl(IControlWidget $this, Continuation<? super Unit> continuation) {
            return Unit.INSTANCE;
        }
    }
}