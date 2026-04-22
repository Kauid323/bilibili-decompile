package tv.danmaku.bili.ui.garb.api;

import android.util.ArrayMap;
import com.bilibili.lib.neuron.api.Neurons;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;

/* compiled from: NftReporterHelper.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000f\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bJ&\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bJF\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u0019JF\u0010%\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u0019J>\u0010'\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bJ>\u0010(\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bJ(\u0010)\u001a\u00020\u00172\b\u0010*\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u0019J\u000e\u0010-\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0019J\u000e\u0010.\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0019J\u0006\u0010/\u001a\u00020\u0017J\u000e\u00100\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0019J(\u00101\u001a\u00020\u00172\b\u0010*\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u0019J\u000e\u00102\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0019R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Ltv/danmaku/bili/ui/garb/api/NftReporterHelper;", "", "<init>", "()V", "NFT_CARD_SHARE_BACK_SHOW", "", "NFT_CARD_SHARE_BACK_CLICK", "NFT_CARD_SHARE_CLICK", "NFT_CARD_SHOW", "NFT_CARD_OTHER_BUTTON_CLICK", "NFT_CARD_EDIT_BUTTON_CLICK", "NFT_CARD_AVATAR_DETAIL_SHOW", "NFT_CARD_AVATAR_DETAIL_CLICK", "NFT_CARD_GUEST_AVATAR_DETAIL_CLICK", "NFT_CARD_AVATAR_DETAIL_FLOAT_PANEL_SHOW", "NFT_CARD_AVATAR_DETIAL_FLOAT_PANEL_CLICK", "NFT_CARD_CHANGE_AVATAR_SUCCESS", "NFT_CARD_HEADER_DETAIL_FLOAT_PANEL_SHOW", "NFT_CARD_HEADER_DETAIL_FLOAT_PANEL_CLICK", "NFT_CARD_HEADER_DETAIL_SHOW", "NFT_CARD_HEADER_DETAIL_CLICK", "NFT_CARD_CHANGE_HEADER_SUCCESS", "reportNftCardScanPageExposure", "", "actId", "", "cardTypeId", "", "mid", "reportNftCardScanPageButtonClick", "sourcePage", "reportNftCardExposure", "from", "fromId", "fSource", "hasGained", "", "reportNftCardBottomButtonClick", "buttonType", "reportNftCardShareButtonClick", "reportNftCardMenuButtonClick", "reportAvatarDetailShow", "itemId", AuthResultCbHelper.ARGS_STATE, "type", "reportAvatarDetailClick", "reportGuestAvatarDetailClick", "reportAvatarFloatPanelShow", "reportAvatarFloatPanelClick", "reportHeaderDetailShow", "reportHeaderDetailClick", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class NftReporterHelper {
    public static final int $stable = 0;
    public static final NftReporterHelper INSTANCE = new NftReporterHelper();
    private static final String NFT_CARD_AVATAR_DETAIL_CLICK = "main.space.profile.button.click";
    private static final String NFT_CARD_AVATAR_DETAIL_FLOAT_PANEL_SHOW = "main.space.change-profile-panel.0.show";
    private static final String NFT_CARD_AVATAR_DETAIL_SHOW = "main.space.profile.0.show";
    private static final String NFT_CARD_AVATAR_DETIAL_FLOAT_PANEL_CLICK = "main.space.change-profile-panel.button.click";
    private static final String NFT_CARD_CHANGE_AVATAR_SUCCESS = "main.space.change-profile.success.show";
    private static final String NFT_CARD_CHANGE_HEADER_SUCCESS = "main.space.change-topimage.success.show";
    private static final String NFT_CARD_EDIT_BUTTON_CLICK = "main.collect-card.activity-page.card-edith-button.click";
    private static final String NFT_CARD_GUEST_AVATAR_DETAIL_CLICK = "main.space.profile-guest.button.click";
    private static final String NFT_CARD_HEADER_DETAIL_CLICK = "main.space.topimage.button.click";
    private static final String NFT_CARD_HEADER_DETAIL_FLOAT_PANEL_CLICK = "main.space.topimage-panel.button.click";
    private static final String NFT_CARD_HEADER_DETAIL_FLOAT_PANEL_SHOW = "main.space.topimage.panel.show";
    private static final String NFT_CARD_HEADER_DETAIL_SHOW = "main.space.topimage.0.show";
    private static final String NFT_CARD_OTHER_BUTTON_CLICK = "main.collect-card.activity-page.card-other-button.click";
    private static final String NFT_CARD_SHARE_BACK_CLICK = "main.collect-card.activity-page.share-back-button.click";
    private static final String NFT_CARD_SHARE_BACK_SHOW = "main.collect-card.activity-page.share-back.show";
    private static final String NFT_CARD_SHARE_CLICK = "main.collect-card.share.share-button.click";
    private static final String NFT_CARD_SHOW = "main.collect-card.activity-page.card.show";

    private NftReporterHelper() {
    }

    public final void reportNftCardScanPageExposure(int actId, long cardTypeId, long mid) {
        ArrayMap params = new ArrayMap();
        params.put("item_id", String.valueOf(actId));
        params.put("item_subid", String.valueOf(cardTypeId));
        params.put("mid", String.valueOf(mid));
        Neurons.reportExposure$default(false, NFT_CARD_SHARE_BACK_SHOW, params, (List) null, 8, (Object) null);
    }

    public final void reportNftCardScanPageButtonClick(int actId, long cardTypeId, int sourcePage, long mid) {
        ArrayMap params = new ArrayMap();
        params.put("item_id", String.valueOf(actId));
        params.put("item_subid", String.valueOf(cardTypeId));
        params.put("source_page", String.valueOf(sourcePage));
        params.put("mid", String.valueOf(mid));
        Neurons.reportClick(false, NFT_CARD_SHARE_BACK_CLICK, params);
    }

    public final void reportNftCardExposure(int actId, long cardTypeId, String from, String fromId, String fSource, long mid, boolean hasGained, int sourcePage) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(fromId, "fromId");
        Intrinsics.checkNotNullParameter(fSource, "fSource");
        ArrayMap params = new ArrayMap();
        params.put("from", from);
        params.put("from_id", fromId);
        params.put("f_source", fSource);
        params.put("item_id", String.valueOf(actId));
        params.put("item_subid", String.valueOf(cardTypeId));
        params.put("mid", String.valueOf(mid));
        params.put("status", hasGained ? "1" : "2");
        params.put("source_page", String.valueOf(sourcePage));
        Neurons.reportExposure$default(false, NFT_CARD_SHOW, params, (List) null, 8, (Object) null);
    }

    public final void reportNftCardBottomButtonClick(int actId, long cardTypeId, String from, String fromId, String fSource, int buttonType, long mid, int sourcePage) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(fromId, "fromId");
        Intrinsics.checkNotNullParameter(fSource, "fSource");
        ArrayMap params = new ArrayMap();
        params.put("from", from);
        params.put("from_id", fromId);
        params.put("f_source", fSource);
        params.put("item_id", String.valueOf(actId));
        params.put("item_subid", String.valueOf(cardTypeId));
        params.put("button_type", String.valueOf(buttonType));
        params.put("mid", String.valueOf(mid));
        params.put("source_page", String.valueOf(sourcePage));
        Neurons.reportClick(false, NFT_CARD_OTHER_BUTTON_CLICK, params);
    }

    public final void reportNftCardShareButtonClick(int actId, long cardTypeId, String from, String fromId, String fSource, int sourcePage, long mid) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(fromId, "fromId");
        Intrinsics.checkNotNullParameter(fSource, "fSource");
        ArrayMap params = new ArrayMap();
        params.put("from", from);
        params.put("from_id", fromId);
        params.put("f_source", fSource);
        params.put("item_id", String.valueOf(actId));
        params.put("item_subid", String.valueOf(cardTypeId));
        params.put("source_page", String.valueOf(sourcePage));
        params.put("mid", String.valueOf(mid));
        Neurons.reportClick(false, NFT_CARD_SHARE_CLICK, params);
    }

    public final void reportNftCardMenuButtonClick(int actId, long cardTypeId, String from, String fromId, String fSource, int buttonType, long mid) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(fromId, "fromId");
        Intrinsics.checkNotNullParameter(fSource, "fSource");
        ArrayMap params = new ArrayMap();
        params.put("from", from);
        params.put("from_id", fromId);
        params.put("f_source", fSource);
        params.put("item_id", String.valueOf(actId));
        params.put("item_subid", String.valueOf(cardTypeId));
        params.put("button_type", String.valueOf(buttonType));
        params.put("mid", String.valueOf(mid));
        Neurons.reportClick(false, NFT_CARD_EDIT_BUTTON_CLICK, params);
    }

    public final void reportAvatarDetailShow(String itemId, long mid, int state, int type) {
        ArrayMap params = new ArrayMap();
        params.put("item_id", itemId);
        params.put("f_source", "social");
        params.put("from", "profile");
        params.put("from_id", String.valueOf(mid));
        params.put(AuthResultCbHelper.ARGS_STATE, String.valueOf(state));
        params.put("profile_type", String.valueOf(type));
        Neurons.reportExposure$default(false, NFT_CARD_AVATAR_DETAIL_SHOW, params, (List) null, 8, (Object) null);
    }

    public final void reportAvatarDetailClick(int buttonType) {
        ArrayMap params = new ArrayMap();
        params.put("button_type", String.valueOf(buttonType));
        Neurons.reportClick(false, NFT_CARD_AVATAR_DETAIL_CLICK, params);
    }

    public final void reportGuestAvatarDetailClick(int buttonType) {
        ArrayMap params = new ArrayMap();
        params.put("button_type", String.valueOf(buttonType));
        Neurons.reportClick(false, NFT_CARD_GUEST_AVATAR_DETAIL_CLICK, params);
    }

    public final void reportAvatarFloatPanelShow() {
        ArrayMap params = new ArrayMap();
        Neurons.reportExposure$default(false, NFT_CARD_AVATAR_DETAIL_FLOAT_PANEL_SHOW, params, (List) null, 8, (Object) null);
    }

    public final void reportAvatarFloatPanelClick(int buttonType) {
        ArrayMap params = new ArrayMap();
        params.put("button_type", String.valueOf(buttonType));
        Neurons.reportClick(false, NFT_CARD_AVATAR_DETIAL_FLOAT_PANEL_CLICK, params);
    }

    public final void reportHeaderDetailShow(String itemId, long mid, int state, int type) {
        ArrayMap params = new ArrayMap();
        params.put("item_id", itemId);
        params.put("f_source", "social");
        params.put("from", "profile");
        params.put("from_id", String.valueOf(mid));
        params.put(AuthResultCbHelper.ARGS_STATE, String.valueOf(state));
        params.put("topimage_type", String.valueOf(type));
        Neurons.reportExposure$default(false, NFT_CARD_HEADER_DETAIL_SHOW, params, (List) null, 8, (Object) null);
    }

    public final void reportHeaderDetailClick(int buttonType) {
        ArrayMap params = new ArrayMap();
        params.put("button_type", String.valueOf(buttonType));
        Neurons.reportClick(false, NFT_CARD_HEADER_DETAIL_CLICK, params);
    }
}