package ability;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: ILiveGiftGlobalService.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\bf\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0016\u0010\b\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nH&J\u0012\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0005H&J\u001e\u0010\r\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0016\u0010\u0010\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nH&J\b\u0010\u0011\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0013À\u0006\u0001"}, d2 = {"Lability/ILiveGiftGlobalService;", "", "toast", "", "stringId", "", "message", "", "postOnUiThread", "block", "Lkotlin/Function0;", "jumpToLogin", "requestCode", "postDelayedOnUiThread", "delay", "", "removeCallbacks", "removeAllMsgs", "Companion", "giftCommon_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ILiveGiftGlobalService {
    public static final Companion Companion = Companion.$$INSTANCE;

    void jumpToLogin(int i);

    void postDelayedOnUiThread(Function0<Unit> function0, long j);

    void postOnUiThread(Function0<Unit> function0);

    void removeAllMsgs();

    void removeCallbacks(Function0<Unit> function0);

    void toast(int i);

    void toast(String str);

    /* compiled from: ILiveGiftGlobalService.kt */
    /* renamed from: ability.ILiveGiftGlobalService$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
    public final /* synthetic */ class CC {
        static {
            Companion companion = ILiveGiftGlobalService.Companion;
        }

        public static /* synthetic */ void jumpToLogin$default(ILiveGiftGlobalService iLiveGiftGlobalService, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: jumpToLogin");
            }
            if ((i2 & 1) != 0) {
                i = 678;
            }
            iLiveGiftGlobalService.jumpToLogin(i);
        }
    }

    /* compiled from: ILiveGiftGlobalService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lability/ILiveGiftGlobalService$Companion;", "", "<init>", "()V", "LIVE_ROOM_REQUEST_CODE_LOGIN", "", "giftCommon_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e/20260223054750bbd572dd-878c-43b9-8c29-f87ce196de8e.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final int LIVE_ROOM_REQUEST_CODE_LOGIN = 678;

        private Companion() {
        }
    }
}