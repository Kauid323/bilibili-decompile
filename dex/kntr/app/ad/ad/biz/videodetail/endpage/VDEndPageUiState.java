package kntr.app.ad.ad.biz.videodetail.endpage;

import BottomSheetItemData$;
import kntr.app.ad.common.model.AdButton;
import kntr.app.ad.common.model.AdFeedbackPanel;
import kntr.app.ad.common.model.AdRcmdReasonStyle;
import kntr.app.ad.common.model.AdTagStyle;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VDEndPageStore.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0003\u0006\u0007\b¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lkntr/app/ad/ad/biz/videodetail/endpage/VDEndPageUiState;", RoomRecommendViewModel.EMPTY_CURSOR, "Idle", "Content", "IconText", "Empty", "Lkntr/app/ad/ad/biz/videodetail/endpage/VDEndPageUiState$Content;", "Lkntr/app/ad/ad/biz/videodetail/endpage/VDEndPageUiState$Empty;", "Lkntr/app/ad/ad/biz/videodetail/endpage/VDEndPageUiState$Idle;", "videodetail_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface VDEndPageUiState {

    /* compiled from: VDEndPageStore.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/ad/ad/biz/videodetail/endpage/VDEndPageUiState$Idle;", "Lkntr/app/ad/ad/biz/videodetail/endpage/VDEndPageUiState;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "videodetail_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Idle implements VDEndPageUiState {
        public static final int $stable = 0;
        public static final Idle INSTANCE = new Idle();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Idle) {
                Idle idle = (Idle) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 487081286;
        }

        public String toString() {
            return "Idle";
        }

        private Idle() {
        }
    }

    /* compiled from: VDEndPageStore.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b)\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0011HÆ\u0003J\t\u00109\u001a\u00020\u0011HÆ\u0003J\t\u0010:\u001a\u00020\u0011HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0017HÆ\u0003J©\u0001\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u0017HÆ\u0001J\u0013\u0010?\u001a\u00020\u00172\b\u0010@\u001a\u0004\u0018\u00010AHÖ\u0003J\t\u0010B\u001a\u00020CHÖ\u0001J\t\u0010D\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001bR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001bR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0012\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b*\u0010)R\u0011\u0010\u0013\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b+\u0010)R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001bR\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001bR\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010.¨\u0006E"}, d2 = {"Lkntr/app/ad/ad/biz/videodetail/endpage/VDEndPageUiState$Content;", "Lkntr/app/ad/ad/biz/videodetail/endpage/VDEndPageUiState;", "firstCoverUrl", RoomRecommendViewModel.EMPTY_CURSOR, "adTagStyle", "Lkntr/app/ad/common/model/AdTagStyle;", "adTagStyleFullScreen", "title", "button", "Lkntr/app/ad/common/model/AdButton;", "rcmdReasonStyle", "Lkntr/app/ad/common/model/AdRcmdReasonStyle;", "desc", "feedbackPanel", "Lkntr/app/ad/common/model/AdFeedbackPanel;", "authorName", "vt", "Lkntr/app/ad/ad/biz/videodetail/endpage/VDEndPageUiState$IconText;", "danmaku", "liveIconText", "areaName", "coverRightText", "isLiving", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;Lkntr/app/ad/common/model/AdTagStyle;Lkntr/app/ad/common/model/AdTagStyle;Ljava/lang/String;Lkntr/app/ad/common/model/AdButton;Lkntr/app/ad/common/model/AdRcmdReasonStyle;Ljava/lang/String;Lkntr/app/ad/common/model/AdFeedbackPanel;Ljava/lang/String;Lkntr/app/ad/ad/biz/videodetail/endpage/VDEndPageUiState$IconText;Lkntr/app/ad/ad/biz/videodetail/endpage/VDEndPageUiState$IconText;Lkntr/app/ad/ad/biz/videodetail/endpage/VDEndPageUiState$IconText;Ljava/lang/String;Ljava/lang/String;Z)V", "getFirstCoverUrl", "()Ljava/lang/String;", "getAdTagStyle", "()Lkntr/app/ad/common/model/AdTagStyle;", "getAdTagStyleFullScreen", "getTitle", "getButton", "()Lkntr/app/ad/common/model/AdButton;", "getRcmdReasonStyle", "()Lkntr/app/ad/common/model/AdRcmdReasonStyle;", "getDesc", "getFeedbackPanel", "()Lkntr/app/ad/common/model/AdFeedbackPanel;", "getAuthorName", "getVt", "()Lkntr/app/ad/ad/biz/videodetail/endpage/VDEndPageUiState$IconText;", "getDanmaku", "getLiveIconText", "getAreaName", "getCoverRightText", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "equals", "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "videodetail_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Content implements VDEndPageUiState {
        public static final int $stable = 8;
        private final AdTagStyle adTagStyle;
        private final AdTagStyle adTagStyleFullScreen;
        private final String areaName;
        private final String authorName;
        private final AdButton button;
        private final String coverRightText;
        private final IconText danmaku;
        private final String desc;
        private final AdFeedbackPanel feedbackPanel;
        private final String firstCoverUrl;
        private final boolean isLiving;
        private final IconText liveIconText;
        private final AdRcmdReasonStyle rcmdReasonStyle;
        private final String title;
        private final IconText vt;

        public final String component1() {
            return this.firstCoverUrl;
        }

        public final IconText component10() {
            return this.vt;
        }

        public final IconText component11() {
            return this.danmaku;
        }

        public final IconText component12() {
            return this.liveIconText;
        }

        public final String component13() {
            return this.areaName;
        }

        public final String component14() {
            return this.coverRightText;
        }

        public final boolean component15() {
            return this.isLiving;
        }

        public final AdTagStyle component2() {
            return this.adTagStyle;
        }

        public final AdTagStyle component3() {
            return this.adTagStyleFullScreen;
        }

        public final String component4() {
            return this.title;
        }

        public final AdButton component5() {
            return this.button;
        }

        public final AdRcmdReasonStyle component6() {
            return this.rcmdReasonStyle;
        }

        public final String component7() {
            return this.desc;
        }

        public final AdFeedbackPanel component8() {
            return this.feedbackPanel;
        }

        public final String component9() {
            return this.authorName;
        }

        public final Content copy(String str, AdTagStyle adTagStyle, AdTagStyle adTagStyle2, String str2, AdButton adButton, AdRcmdReasonStyle adRcmdReasonStyle, String str3, AdFeedbackPanel adFeedbackPanel, String str4, IconText iconText, IconText iconText2, IconText iconText3, String str5, String str6, boolean z) {
            Intrinsics.checkNotNullParameter(str, "firstCoverUrl");
            Intrinsics.checkNotNullParameter(str2, "title");
            Intrinsics.checkNotNullParameter(str3, "desc");
            Intrinsics.checkNotNullParameter(str4, "authorName");
            Intrinsics.checkNotNullParameter(iconText, "vt");
            Intrinsics.checkNotNullParameter(iconText2, "danmaku");
            Intrinsics.checkNotNullParameter(iconText3, "liveIconText");
            Intrinsics.checkNotNullParameter(str5, "areaName");
            Intrinsics.checkNotNullParameter(str6, "coverRightText");
            return new Content(str, adTagStyle, adTagStyle2, str2, adButton, adRcmdReasonStyle, str3, adFeedbackPanel, str4, iconText, iconText2, iconText3, str5, str6, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Content) {
                Content content = (Content) obj;
                return Intrinsics.areEqual(this.firstCoverUrl, content.firstCoverUrl) && Intrinsics.areEqual(this.adTagStyle, content.adTagStyle) && Intrinsics.areEqual(this.adTagStyleFullScreen, content.adTagStyleFullScreen) && Intrinsics.areEqual(this.title, content.title) && Intrinsics.areEqual(this.button, content.button) && Intrinsics.areEqual(this.rcmdReasonStyle, content.rcmdReasonStyle) && Intrinsics.areEqual(this.desc, content.desc) && Intrinsics.areEqual(this.feedbackPanel, content.feedbackPanel) && Intrinsics.areEqual(this.authorName, content.authorName) && Intrinsics.areEqual(this.vt, content.vt) && Intrinsics.areEqual(this.danmaku, content.danmaku) && Intrinsics.areEqual(this.liveIconText, content.liveIconText) && Intrinsics.areEqual(this.areaName, content.areaName) && Intrinsics.areEqual(this.coverRightText, content.coverRightText) && this.isLiving == content.isLiving;
            }
            return false;
        }

        public int hashCode() {
            return (((((((((((((((((((((((((((this.firstCoverUrl.hashCode() * 31) + (this.adTagStyle == null ? 0 : this.adTagStyle.hashCode())) * 31) + (this.adTagStyleFullScreen == null ? 0 : this.adTagStyleFullScreen.hashCode())) * 31) + this.title.hashCode()) * 31) + (this.button == null ? 0 : this.button.hashCode())) * 31) + (this.rcmdReasonStyle == null ? 0 : this.rcmdReasonStyle.hashCode())) * 31) + this.desc.hashCode()) * 31) + (this.feedbackPanel != null ? this.feedbackPanel.hashCode() : 0)) * 31) + this.authorName.hashCode()) * 31) + this.vt.hashCode()) * 31) + this.danmaku.hashCode()) * 31) + this.liveIconText.hashCode()) * 31) + this.areaName.hashCode()) * 31) + this.coverRightText.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isLiving);
        }

        public String toString() {
            String str = this.firstCoverUrl;
            AdTagStyle adTagStyle = this.adTagStyle;
            AdTagStyle adTagStyle2 = this.adTagStyleFullScreen;
            String str2 = this.title;
            AdButton adButton = this.button;
            AdRcmdReasonStyle adRcmdReasonStyle = this.rcmdReasonStyle;
            String str3 = this.desc;
            AdFeedbackPanel adFeedbackPanel = this.feedbackPanel;
            String str4 = this.authorName;
            IconText iconText = this.vt;
            IconText iconText2 = this.danmaku;
            IconText iconText3 = this.liveIconText;
            String str5 = this.areaName;
            String str6 = this.coverRightText;
            return "Content(firstCoverUrl=" + str + ", adTagStyle=" + adTagStyle + ", adTagStyleFullScreen=" + adTagStyle2 + ", title=" + str2 + ", button=" + adButton + ", rcmdReasonStyle=" + adRcmdReasonStyle + ", desc=" + str3 + ", feedbackPanel=" + adFeedbackPanel + ", authorName=" + str4 + ", vt=" + iconText + ", danmaku=" + iconText2 + ", liveIconText=" + iconText3 + ", areaName=" + str5 + ", coverRightText=" + str6 + ", isLiving=" + this.isLiving + ")";
        }

        public Content(String firstCoverUrl, AdTagStyle adTagStyle, AdTagStyle adTagStyleFullScreen, String title, AdButton button, AdRcmdReasonStyle rcmdReasonStyle, String desc, AdFeedbackPanel feedbackPanel, String authorName, IconText vt, IconText danmaku, IconText liveIconText, String areaName, String coverRightText, boolean isLiving) {
            Intrinsics.checkNotNullParameter(firstCoverUrl, "firstCoverUrl");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(desc, "desc");
            Intrinsics.checkNotNullParameter(authorName, "authorName");
            Intrinsics.checkNotNullParameter(vt, "vt");
            Intrinsics.checkNotNullParameter(danmaku, "danmaku");
            Intrinsics.checkNotNullParameter(liveIconText, "liveIconText");
            Intrinsics.checkNotNullParameter(areaName, "areaName");
            Intrinsics.checkNotNullParameter(coverRightText, "coverRightText");
            this.firstCoverUrl = firstCoverUrl;
            this.adTagStyle = adTagStyle;
            this.adTagStyleFullScreen = adTagStyleFullScreen;
            this.title = title;
            this.button = button;
            this.rcmdReasonStyle = rcmdReasonStyle;
            this.desc = desc;
            this.feedbackPanel = feedbackPanel;
            this.authorName = authorName;
            this.vt = vt;
            this.danmaku = danmaku;
            this.liveIconText = liveIconText;
            this.areaName = areaName;
            this.coverRightText = coverRightText;
            this.isLiving = isLiving;
        }

        public final String getFirstCoverUrl() {
            return this.firstCoverUrl;
        }

        public final AdTagStyle getAdTagStyle() {
            return this.adTagStyle;
        }

        public final AdTagStyle getAdTagStyleFullScreen() {
            return this.adTagStyleFullScreen;
        }

        public final String getTitle() {
            return this.title;
        }

        public final AdButton getButton() {
            return this.button;
        }

        public final AdRcmdReasonStyle getRcmdReasonStyle() {
            return this.rcmdReasonStyle;
        }

        public final String getDesc() {
            return this.desc;
        }

        public final AdFeedbackPanel getFeedbackPanel() {
            return this.feedbackPanel;
        }

        public final String getAuthorName() {
            return this.authorName;
        }

        public final IconText getVt() {
            return this.vt;
        }

        public final IconText getDanmaku() {
            return this.danmaku;
        }

        public final IconText getLiveIconText() {
            return this.liveIconText;
        }

        public final String getAreaName() {
            return this.areaName;
        }

        public final String getCoverRightText() {
            return this.coverRightText;
        }

        public final boolean isLiving() {
            return this.isLiving;
        }
    }

    /* compiled from: VDEndPageStore.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lkntr/app/ad/ad/biz/videodetail/endpage/VDEndPageUiState$IconText;", RoomRecommendViewModel.EMPTY_CURSOR, "vIcon", RoomRecommendViewModel.EMPTY_CURSOR, "vText", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getVIcon", "()Ljava/lang/String;", "getVText", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "videodetail_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class IconText {
        public static final int $stable = 0;
        private final String vIcon;
        private final String vText;

        public static /* synthetic */ IconText copy$default(IconText iconText, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = iconText.vIcon;
            }
            if ((i & 2) != 0) {
                str2 = iconText.vText;
            }
            return iconText.copy(str, str2);
        }

        public final String component1() {
            return this.vIcon;
        }

        public final String component2() {
            return this.vText;
        }

        public final IconText copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "vIcon");
            Intrinsics.checkNotNullParameter(str2, "vText");
            return new IconText(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof IconText) {
                IconText iconText = (IconText) obj;
                return Intrinsics.areEqual(this.vIcon, iconText.vIcon) && Intrinsics.areEqual(this.vText, iconText.vText);
            }
            return false;
        }

        public int hashCode() {
            return (this.vIcon.hashCode() * 31) + this.vText.hashCode();
        }

        public String toString() {
            String str = this.vIcon;
            return "IconText(vIcon=" + str + ", vText=" + this.vText + ")";
        }

        public IconText(String vIcon, String vText) {
            Intrinsics.checkNotNullParameter(vIcon, "vIcon");
            Intrinsics.checkNotNullParameter(vText, "vText");
            this.vIcon = vIcon;
            this.vText = vText;
        }

        public final String getVIcon() {
            return this.vIcon;
        }

        public final String getVText() {
            return this.vText;
        }
    }

    /* compiled from: VDEndPageStore.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/ad/ad/biz/videodetail/endpage/VDEndPageUiState$Empty;", "Lkntr/app/ad/ad/biz/videodetail/endpage/VDEndPageUiState;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "videodetail_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Empty implements VDEndPageUiState {
        public static final int $stable = 0;
        public static final Empty INSTANCE = new Empty();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Empty) {
                Empty empty = (Empty) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -2083770853;
        }

        public String toString() {
            return "Empty";
        }

        private Empty() {
        }
    }
}