package kntr.app.ad.domain.click.internal;

import kntr.app.ad.domain.report.internal.ReportBuildInEvent;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* compiled from: ClickReport.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b \b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"¨\u0006#"}, d2 = {"Lkntr/app/ad/domain/click/internal/ActionUiEvent;", RoomRecommendViewModel.EMPTY_CURSOR, "value", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "AUTH_FAIL", "AUTH_SUCCESS", "NA_CALLUP_SUC", "H5_CALLUP_SUC", "NA_CALLUP_FAIL", "H5_CALLUP_FAIL", "CALLUP_FAIL_NA_AUTH_FAIL", "CALLUP_FAIL_H5_AUTH_FAIL", "CALLUP_FAIL_NA_NOT_INSTALL", "CALLUP_FAIL_H5_NOT_INSTALL", "CALLUP_FAIL_NA_USER_CANCEL", "CALLUP_FAIL_H5_USER_CANCEL", "CALLUP_SUC_NA_POPUP_SHOW_AGREE", "CALLUP_SUC_H5_POPUP_SHOW_AGREE", "NA_CALLUP_APP_STAY_TIME", "H5_CALLUP_APP_STAY_TIME", "OPEN_APP_URL", "OPEN_STORE_DIRECT", "OPEN_STORE_DIRECT_FAIL", "WX_MINI_CALLUP_SUC", "WX_MINI_CALLUP_FAILED", "BUTTON_CLICK", "JUMP_URL_ERROR", "MINI_JUMP_URL", "HTTP_JUMP_URL", "ROUTE_AD_CALLUP", "ROUTE_AD_BROWSER", "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum ActionUiEvent {
    AUTH_FAIL("auth_fail"),
    AUTH_SUCCESS("auth_success"),
    NA_CALLUP_SUC("NA_callup_suc"),
    H5_CALLUP_SUC("H5_callup_suc"),
    NA_CALLUP_FAIL("NA_callup_fail"),
    H5_CALLUP_FAIL("H5_callup_fail"),
    CALLUP_FAIL_NA_AUTH_FAIL("callup_fail_NA_auth_fail"),
    CALLUP_FAIL_H5_AUTH_FAIL("callup_fail_H5_auth_fail"),
    CALLUP_FAIL_NA_NOT_INSTALL("callup_fail_NA_not_install"),
    CALLUP_FAIL_H5_NOT_INSTALL("callup_fail_h5_not_install"),
    CALLUP_FAIL_NA_USER_CANCEL("callup_fail_NA_user_cancel"),
    CALLUP_FAIL_H5_USER_CANCEL("callup_fail_H5_user_cancel"),
    CALLUP_SUC_NA_POPUP_SHOW_AGREE("callup_suc_NA_popup_show_agree"),
    CALLUP_SUC_H5_POPUP_SHOW_AGREE("callup_suc_h5_popup_show_agree"),
    NA_CALLUP_APP_STAY_TIME("na_callup_app_stay_time"),
    H5_CALLUP_APP_STAY_TIME("h5_callup_app_stay_time"),
    OPEN_APP_URL("open_app_url"),
    OPEN_STORE_DIRECT("open_store_direct"),
    OPEN_STORE_DIRECT_FAIL("open_store_direct_fail"),
    WX_MINI_CALLUP_SUC("wx_mini_callup_suc"),
    WX_MINI_CALLUP_FAILED("wx_mini_callup_failed"),
    BUTTON_CLICK(ReportBuildInEvent.BUTTON_CLICK),
    JUMP_URL_ERROR("jump_url_error"),
    MINI_JUMP_URL("mini_jump_url"),
    HTTP_JUMP_URL("http_jump_url"),
    ROUTE_AD_CALLUP("route_ad_callup"),
    ROUTE_AD_BROWSER("route_ad_browser");
    
    private final String value;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<ActionUiEvent> getEntries() {
        return $ENTRIES;
    }

    ActionUiEvent(String value) {
        this.value = value;
    }

    public final String getValue() {
        return this.value;
    }
}