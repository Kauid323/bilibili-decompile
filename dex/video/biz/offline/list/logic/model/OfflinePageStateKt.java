package video.biz.offline.list.logic.model;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.model.model.AuthCode;
import video.biz.offline.list.logic.model.DialogType;

/* compiled from: OfflinePageState.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0006\u0010\u0007\u001a\u00020\u0006\u001a\u0006\u0010\b\u001a\u00020\u0006\u001a\u0006\u0010\t\u001a\u00020\u0006\"\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"dialogType", "Lvideo/biz/offline/list/logic/model/DialogType;", "Lvideo/biz/offline/base/model/model/AuthCode;", "aid", "", "offlineHomePageInitialState", "Lvideo/biz/offline/list/logic/model/OfflinePageState;", "offlineDownloadingPageInitialState", "offlineCompletedPageInitialState", "offlineSearchPageInitialState", "offlinePageErrorState", "getOfflinePageErrorState", "()Lvideo/biz/offline/list/logic/model/OfflinePageState;", "logic_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflinePageStateKt {
    private static final OfflinePageState offlinePageErrorState = new OfflinePageState(null, null, DataState.ERROR, null, null, null, null, null, 251, null);

    /* compiled from: OfflinePageState.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AuthCode.values().length];
            try {
                iArr[AuthCode.EpOffline.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[AuthCode.EpFreeQnVip.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[AuthCode.EpVip.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[AuthCode.EpPayOrVip.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[AuthCode.EpPayOrVipFirst.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[AuthCode.EpPay.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[AuthCode.EpPayFirst.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[AuthCode.EpPayPack.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[AuthCode.EpTicketWhite.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final DialogType dialogType(AuthCode $this$dialogType, long aid) {
        Intrinsics.checkNotNullParameter($this$dialogType, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[$this$dialogType.ordinal()]) {
            case 1:
                return DialogType.ResourceInvalid.INSTANCE;
            case 2:
            case 3:
                return DialogType.VipOnlyAlert.INSTANCE;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return new DialogType.VipExpiredAlert(aid);
            default:
                return DialogType.None.INSTANCE;
        }
    }

    public static final OfflinePageState offlineHomePageInitialState() {
        return new OfflinePageState(null, null, null, null, new OfflinePageConfig(null, CollectionsKt.listOf(new OfflinePageOperation[]{OfflinePageOperation.DANMAKU_TEXT, OfflinePageOperation.DELETE_TEXT}), 0, 5, null), null, null, null, 239, null);
    }

    public static final OfflinePageState offlineDownloadingPageInitialState() {
        return new OfflinePageState(null, null, null, null, new OfflinePageConfig(null, CollectionsKt.listOf(OfflinePageOperation.DELETE_TEXT), 0, 5, null), null, null, null, 239, null);
    }

    public static final OfflinePageState offlineCompletedPageInitialState() {
        return new OfflinePageState(null, null, null, null, new OfflinePageConfig(null, CollectionsKt.listOf(new OfflinePageOperation[]{OfflinePageOperation.DANMAKU_TEXT, OfflinePageOperation.DELETE_TEXT}), 0, 5, null), null, null, null, 239, null);
    }

    public static final OfflinePageState offlineSearchPageInitialState() {
        return new OfflinePageState(null, null, null, null, new OfflinePageConfig(CollectionsKt.emptyList(), CollectionsKt.emptyList(), 0, 4, null), null, null, null, 239, null);
    }

    public static final OfflinePageState getOfflinePageErrorState() {
        return offlinePageErrorState;
    }
}