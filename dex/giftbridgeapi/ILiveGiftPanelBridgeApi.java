package giftbridgeapi;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bilibili.bililive.biz.uicommon.gift.LiveOpenGiftPanelParam;
import com.bilibili.bililive.componentbridge.BridgeInterface;
import kotlin.Metadata;

/* compiled from: ILiveGiftPanelBridgeApi.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \r2\u00020\u0001:\u0001\rJ$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&J\b\u0010\f\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Lgiftbridgeapi/ILiveGiftPanelBridgeApi;", "Lcom/bilibili/bililive/componentbridge/BridgeInterface;", "showPanel", "", "hostFragment", "Landroidx/fragment/app/Fragment;", "layoutId", "", "openGiftPanelParam", "Lcom/bilibili/bililive/biz/uicommon/gift/LiveOpenGiftPanelParam;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "hidePanel", "Companion", "giftCommon_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ILiveGiftPanelBridgeApi extends BridgeInterface {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final String MSG_NO_GIFT_PANEL_VISIBILITY_CHANGED = "gift_panel_visibility_changed";
    public static final String MSG_ON_GIFT_PANEL_HEIGHT_CHANGED = "on_gift_panel_height_changed";
    public static final String MSG_ON_SET_MIC_AREA_MIC_USER_SELECT_STATUS = "on_set_mic_area_mic_user_select_status";

    void hidePanel();

    void showPanel(Fragment fragment, int i2, LiveOpenGiftPanelParam liveOpenGiftPanelParam);

    void showPanel(FragmentManager fragmentManager, int i2, LiveOpenGiftPanelParam liveOpenGiftPanelParam);

    /* compiled from: ILiveGiftPanelBridgeApi.kt */
    /* renamed from: giftbridgeapi.ILiveGiftPanelBridgeApi$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public final /* synthetic */ class CC {
        static {
            Companion companion = ILiveGiftPanelBridgeApi.Companion;
        }

        public static /* synthetic */ void showPanel$default(ILiveGiftPanelBridgeApi iLiveGiftPanelBridgeApi, Fragment fragment, int i2, LiveOpenGiftPanelParam liveOpenGiftPanelParam, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showPanel");
            }
            if ((i3 & 4) != 0) {
                liveOpenGiftPanelParam = null;
            }
            iLiveGiftPanelBridgeApi.showPanel(fragment, i2, liveOpenGiftPanelParam);
        }

        public static /* synthetic */ void showPanel$default(ILiveGiftPanelBridgeApi iLiveGiftPanelBridgeApi, FragmentManager fragmentManager, int i2, LiveOpenGiftPanelParam liveOpenGiftPanelParam, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showPanel");
            }
            if ((i3 & 4) != 0) {
                liveOpenGiftPanelParam = null;
            }
            iLiveGiftPanelBridgeApi.showPanel(fragmentManager, i2, liveOpenGiftPanelParam);
        }
    }

    /* compiled from: ILiveGiftPanelBridgeApi.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lgiftbridgeapi/ILiveGiftPanelBridgeApi$Companion;", "", "<init>", "()V", "MSG_ON_SET_MIC_AREA_MIC_USER_SELECT_STATUS", "", "MSG_ON_GIFT_PANEL_HEIGHT_CHANGED", "MSG_NO_GIFT_PANEL_VISIBILITY_CHANGED", "giftCommon_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String MSG_NO_GIFT_PANEL_VISIBILITY_CHANGED = "gift_panel_visibility_changed";
        public static final String MSG_ON_GIFT_PANEL_HEIGHT_CHANGED = "on_gift_panel_height_changed";
        public static final String MSG_ON_SET_MIC_AREA_MIC_USER_SELECT_STATUS = "on_set_mic_area_mic_user_select_status";

        private Companion() {
        }
    }
}