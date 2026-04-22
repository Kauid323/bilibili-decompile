package kntr.app.tribee.repost.track;

import java.util.LinkedHashMap;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.neuron.KNeuron;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeeRepostTrack.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001\u001a'\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u0001¢\u0006\u0002\u0010\u000b\u001aF\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0001\u001a\u001e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001\u001a.\u0010\u0016\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001\u001a\u0016\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u0001\u001a\u0016\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u0001\u001a\u000e\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001\u001a\u001e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"REPOST_PAGE_PV", "", "TRIBEE_REPOST_PAGE_SPMID", "pageExposure", "", "originDynamicId", "switchClick", "position", "Lkntr/app/tribee/repost/track/SwitchTrackPosition;", "switchChecked", "", "(Lkntr/app/tribee/repost/track/SwitchTrackPosition;Ljava/lang/Boolean;Ljava/lang/String;)V", "pageConfirmClick", "tribeeId", "", "tribeeName", "partitionId", "partitionName", "enableRepostToFollowing", "enableRepostWithSource", "remainRepostTimes", "selectTribeeBottomSheetItemExposure", "selectTribeeBottomSheetItemClick", "repostToFollowingBottomSheetExposure", "trackType", "Lkntr/app/tribee/repost/track/RepostToFollowingBottomSheetTrackType;", "repostToFollowingBottomSheetConfirmClick", "addTitleBottomSheetExposure", "addTitleBottomSheetConfirmClick", "repost_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeRepostTrackKt {
    public static final String REPOST_PAGE_PV = "dt.share-to-tribee.0.0.pv";
    public static final String TRIBEE_REPOST_PAGE_SPMID = "dt.share-to-tribee";

    /* compiled from: TribeeRepostTrack.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[SwitchTrackPosition.values().length];
            try {
                iArr[SwitchTrackPosition.Unknown.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[SwitchTrackPosition.SelectTribee.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[SwitchTrackPosition.SwitchRepostToFollowing.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[SwitchTrackPosition.EditText.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[SwitchTrackPosition.SwitchRepostWithSource.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[RepostToFollowingBottomSheetTrackType.values().length];
            try {
                iArr2[RepostToFollowingBottomSheetTrackType.Unknown.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr2[RepostToFollowingBottomSheetTrackType.Intro.ordinal()] = 2;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr2[RepostToFollowingBottomSheetTrackType.Edit.ordinal()] = 3;
            } catch (NoSuchFieldError e8) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static final void pageExposure(String originDynamicId) {
        Intrinsics.checkNotNullParameter(originDynamicId, "originDynamicId");
        Map params = new LinkedHashMap();
        params.put("dynamic_id", originDynamicId);
        params.put("spmid", TRIBEE_REPOST_PAGE_SPMID);
        KNeuron.INSTANCE.reportExposure(false, "dt.share-to-tribee.0.0.show", params);
    }

    public static /* synthetic */ void switchClick$default(SwitchTrackPosition switchTrackPosition, Boolean bool, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            bool = null;
        }
        switchClick(switchTrackPosition, bool, str);
    }

    public static final void switchClick(SwitchTrackPosition position, Boolean switchChecked, String originDynamicId) {
        Intrinsics.checkNotNullParameter(position, "position");
        Intrinsics.checkNotNullParameter(originDynamicId, "originDynamicId");
        int pos = 0;
        switch (WhenMappings.$EnumSwitchMapping$0[position.ordinal()]) {
            case 1:
                break;
            case 2:
                pos = 1;
                break;
            case 3:
                pos = 2;
                break;
            case 4:
                pos = 3;
                break;
            case 5:
                pos = 4;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        Map params = new LinkedHashMap();
        params.put("pos", String.valueOf(pos));
        if (switchChecked != null) {
            params.put("action", switchChecked.booleanValue() ? "1" : "0");
        }
        params.put("dynamic_id", originDynamicId);
        params.put("spmid", TRIBEE_REPOST_PAGE_SPMID);
        KNeuron.INSTANCE.reportClick(false, "dt.share-to-tribee.switch.0.click", params);
    }

    public static final void pageConfirmClick(long tribeeId, String tribeeName, long partitionId, String partitionName, boolean enableRepostToFollowing, boolean enableRepostWithSource, long remainRepostTimes, String originDynamicId) {
        Intrinsics.checkNotNullParameter(tribeeName, "tribeeName");
        Intrinsics.checkNotNullParameter(partitionName, "partitionName");
        Intrinsics.checkNotNullParameter(originDynamicId, "originDynamicId");
        Map params = new LinkedHashMap();
        params.put("tribee_id", String.valueOf(tribeeId));
        params.put("tribee_Name", tribeeName);
        params.put("tribee_sub_id", String.valueOf(partitionId));
        params.put("tribee_sub_name", partitionName);
        params.put("is_send", enableRepostToFollowing ? "1" : "0");
        params.put("is_mark", enableRepostWithSource ? "1" : "0");
        params.put("left_times", String.valueOf(remainRepostTimes));
        params.put("dynamic_id", originDynamicId);
        params.put("spmid", TRIBEE_REPOST_PAGE_SPMID);
        KNeuron.INSTANCE.reportClick(false, "dt.share-to-tribee.submit.0.click", params);
    }

    public static final void selectTribeeBottomSheetItemExposure(long tribeeId, String tribeeName, String originDynamicId) {
        Intrinsics.checkNotNullParameter(tribeeName, "tribeeName");
        Intrinsics.checkNotNullParameter(originDynamicId, "originDynamicId");
        Map params = new LinkedHashMap();
        params.put("tribee_id", String.valueOf(tribeeId));
        params.put("tribee_Name", tribeeName);
        params.put("dynamic_id", originDynamicId);
        params.put("spmid", TRIBEE_REPOST_PAGE_SPMID);
        KNeuron.INSTANCE.reportExposure(false, "dt.share-to-tribee.list-float.0.show", params);
    }

    public static final void selectTribeeBottomSheetItemClick(long tribeeId, String tribeeName, long partitionId, String partitionName, String originDynamicId) {
        Intrinsics.checkNotNullParameter(tribeeName, "tribeeName");
        Intrinsics.checkNotNullParameter(partitionName, "partitionName");
        Intrinsics.checkNotNullParameter(originDynamicId, "originDynamicId");
        Map params = new LinkedHashMap();
        params.put("tribee_id", String.valueOf(tribeeId));
        params.put("tribee_Name", tribeeName);
        params.put("tribee_sub_id", String.valueOf(partitionId));
        params.put("tribee_sub_name", partitionName);
        params.put("dynamic_id", originDynamicId);
        params.put("spmid", TRIBEE_REPOST_PAGE_SPMID);
        KNeuron.INSTANCE.reportClick(false, "dt.share-to-tribee.list-float.0.click", params);
    }

    public static final void repostToFollowingBottomSheetExposure(RepostToFollowingBottomSheetTrackType trackType, String originDynamicId) {
        Intrinsics.checkNotNullParameter(trackType, "trackType");
        Intrinsics.checkNotNullParameter(originDynamicId, "originDynamicId");
        int type = 0;
        switch (WhenMappings.$EnumSwitchMapping$1[trackType.ordinal()]) {
            case 1:
                break;
            case 2:
                type = 1;
                break;
            case 3:
                type = 2;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        Map params = new LinkedHashMap();
        params.put("type", String.valueOf(type));
        params.put("dynamic_id", originDynamicId);
        params.put("spmid", TRIBEE_REPOST_PAGE_SPMID);
        KNeuron.INSTANCE.reportExposure(false, "dt.share-to-tribee.dynamic-float.0.show", params);
    }

    public static final void repostToFollowingBottomSheetConfirmClick(RepostToFollowingBottomSheetTrackType trackType, String originDynamicId) {
        Intrinsics.checkNotNullParameter(trackType, "trackType");
        Intrinsics.checkNotNullParameter(originDynamicId, "originDynamicId");
        int type = 0;
        switch (WhenMappings.$EnumSwitchMapping$1[trackType.ordinal()]) {
            case 1:
                break;
            case 2:
                type = 1;
                break;
            case 3:
                type = 2;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        Map params = new LinkedHashMap();
        params.put("type", String.valueOf(type));
        params.put("dynamic_id", originDynamicId);
        params.put("spmid", TRIBEE_REPOST_PAGE_SPMID);
        KNeuron.INSTANCE.reportClick(false, "dt.share-to-tribee.dynamic-float.0.click", params);
    }

    public static final void addTitleBottomSheetExposure(String originDynamicId) {
        Intrinsics.checkNotNullParameter(originDynamicId, "originDynamicId");
        Map params = new LinkedHashMap();
        params.put("dynamic_id", originDynamicId);
        params.put("spmid", TRIBEE_REPOST_PAGE_SPMID);
        KNeuron.INSTANCE.reportExposure(false, "dt.share-to-tribee.title-float.0.show", params);
    }

    public static final void addTitleBottomSheetConfirmClick(long tribeeId, long partitionId, String originDynamicId) {
        Intrinsics.checkNotNullParameter(originDynamicId, "originDynamicId");
        Map params = new LinkedHashMap();
        params.put("tribee_id", String.valueOf(tribeeId));
        params.put("tribee_sub_id", String.valueOf(partitionId));
        params.put("dynamic_id", originDynamicId);
        params.put("spmid", TRIBEE_REPOST_PAGE_SPMID);
        KNeuron.INSTANCE.reportClick(false, "dt.share-to-tribee.title-float.0.click", params);
    }
}