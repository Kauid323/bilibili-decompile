package env;

import com.bilibili.bililive.infra.widget.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: LiveGiftABTest.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0001\rB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lenv/LiveGiftABTest;", "", "<init>", "()V", "isMatchNewGiftPanel", "", "isShieldGiftPanelTopBar", "()Z", "setShieldGiftPanelTopBar", "(Z)V", "setMatchNewGiftPanel", "", "abTest", "Companion", "giftCommon_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LiveGiftABTest {
    public static final Companion Companion = new Companion(null);
    private static volatile LiveGiftABTest instance;
    private boolean isMatchNewGiftPanel;
    private boolean isShieldGiftPanelTopBar;

    public /* synthetic */ LiveGiftABTest(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private LiveGiftABTest() {
    }

    public final boolean isShieldGiftPanelTopBar() {
        return this.isShieldGiftPanelTopBar;
    }

    public final void setShieldGiftPanelTopBar(boolean z) {
        this.isShieldGiftPanelTopBar = z;
    }

    public final boolean isMatchNewGiftPanel() {
        if (BuildConfig.DEBUG) {
            return this.isMatchNewGiftPanel;
        }
        return false;
    }

    public final void setMatchNewGiftPanel(boolean abTest) {
        this.isMatchNewGiftPanel = abTest;
    }

    /* compiled from: LiveGiftABTest.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00058F@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lenv/LiveGiftABTest$Companion;", "", "<init>", "()V", "value", "Lenv/LiveGiftABTest;", "instance", "getInstance", "()Lenv/LiveGiftABTest;", "giftCommon_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LiveGiftABTest getInstance() {
            LiveGiftABTest it;
            LiveGiftABTest liveGiftABTest = LiveGiftABTest.instance;
            if (liveGiftABTest == null) {
                synchronized (this) {
                    it = LiveGiftABTest.instance;
                    if (it == null) {
                        it = new LiveGiftABTest(null);
                        LiveGiftABTest.instance = it;
                    }
                }
                return it;
            }
            return liveGiftABTest;
        }
    }
}