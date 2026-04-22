package kntr.app.game.gamebind.ui;

import com.bilibili.biligame.kntr.common.bean.KBiligame;
import com.bilibili.lib.brouter.uri.Builder;
import com.bilibili.lib.brouter.uri.Uri;
import io.ktor.http.CodecsKt;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.game.base.router.RouterHelperKt;
import kntr.app.game.gamebind.bean.AuthorizeParams;
import kntr.app.game.gamebind.bean.AuthorizeParamsKt;
import kntr.app.game.gamebind.bean.RoleItem;
import kntr.app.game.gamebind.bean.UnbindRoleItem;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.router.Router;
import kntr.common.router.GlobalRouterKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.Json;

/* compiled from: BindAction.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\u001a\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t\u001a\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f\u001a\u0017\u0010\u0010\u001a\u00020\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013\u001a\u001a\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0001\u001a\u000e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"ROUTER_PATH_ROLE_BIND_AUTH", RoomRecommendViewModel.EMPTY_CURSOR, "ROUTER_PATH_CPS_ROLE_DETAIL", "AUTHORIZE_PARAMS", "goBindGame", RoomRecommendViewModel.EMPTY_CURSOR, "unbindRole", "Lkntr/app/game/gamebind/bean/UnbindRoleItem;", "fromRoleList", RoomRecommendViewModel.EMPTY_CURSOR, "reAuthorize", "roleItem", "Lkntr/app/game/gamebind/bean/RoleItem;", "launchAuthorizePage", "params", "Lkntr/app/game/gamebind/bean/AuthorizeParams;", "openBindList", ReportBuildInParam.MID, RoomRecommendViewModel.EMPTY_CURSOR, "(Ljava/lang/Long;)V", "openRoleDetail", RouterHelperKt.PARAM_SOURCE_FROM, "roleItemJson", "game-bind-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BindActionKt {
    public static final String AUTHORIZE_PARAMS = "authorize_params";
    public static final String ROUTER_PATH_CPS_ROLE_DETAIL = "cps_role_detail";
    public static final String ROUTER_PATH_ROLE_BIND_AUTH = "role_bind_auth";

    public static /* synthetic */ void goBindGame$default(UnbindRoleItem unbindRoleItem, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        goBindGame(unbindRoleItem, z);
    }

    public static final void goBindGame(UnbindRoleItem unbindRole, boolean fromRoleList) {
        Intrinsics.checkNotNullParameter(unbindRole, "unbindRole");
        AuthorizeParams params = AuthorizeParamsKt.fromUnbindRoleItem(unbindRole, fromRoleList);
        launchAuthorizePage(params);
    }

    public static final void reAuthorize(RoleItem roleItem) {
        Intrinsics.checkNotNullParameter(roleItem, "roleItem");
        String valueOf = String.valueOf(roleItem.getGameBaseId());
        String gameName = roleItem.getGameName();
        String gameIcon = roleItem.getGameIcon();
        int distributorChannelId = roleItem.getDistributorChannelId();
        String distributorChannelName = roleItem.getDistributorChannelName();
        if (distributorChannelName == null) {
            distributorChannelName = RoomRecommendViewModel.EMPTY_CURSOR;
        }
        AuthorizeParams params = new AuthorizeParams(valueOf, gameName, gameIcon, distributorChannelId, distributorChannelName, roleItem.getAuthStatus(), true, roleItem.getBindMethodType(), (KBiligame) null, false, 512, (DefaultConstructorMarker) null);
        launchAuthorizePage(params);
    }

    public static final void launchAuthorizePage(AuthorizeParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        Router globalRouter = GlobalRouterKt.getGlobalRouter();
        Builder $this$launchAuthorizePage_u24lambda_u240 = Uri.Companion.parse("bilibili://game_center/role_bind_auth").buildUpon();
        $this$launchAuthorizePage_u24lambda_u240.appendQueryParameter(AUTHORIZE_PARAMS, Json.Default.encodeToString(AuthorizeParams.Companion.serializer(), params));
        globalRouter.launch($this$launchAuthorizePage_u24lambda_u240.build());
    }

    public static /* synthetic */ void openBindList$default(Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            l = null;
        }
        openBindList(l);
    }

    public static final void openBindList(Long mid) {
        Router globalRouter = GlobalRouterKt.getGlobalRouter();
        Builder $this$openBindList_u24lambda_u240 = Uri.Companion.parse("bilibili://game_center/bind_list").buildUpon();
        if (mid != null) {
            $this$openBindList_u24lambda_u240.appendQueryParameter(ReportBuildInParam.MID, String.valueOf(mid.longValue()));
        }
        globalRouter.launch($this$openBindList_u24lambda_u240.build());
    }

    public static /* synthetic */ void openRoleDetail$default(RoleItem roleItem, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        openRoleDetail(roleItem, str);
    }

    public static final void openRoleDetail(RoleItem roleItem, String sourceFrom) {
        Intrinsics.checkNotNullParameter(roleItem, "roleItem");
        if (roleItem.getAuthStatus() == 0) {
            reAuthorize(roleItem);
            return;
        }
        String url = roleItem.getDetailUrl();
        String str = url;
        if (str == null || StringsKt.isBlank(str)) {
            return;
        }
        StringBuilder $this$openRoleDetail_u24lambda_u240 = new StringBuilder();
        String urlWithEncodedHash = StringsKt.replace$default(url, "#", "%23", false, 4, (Object) null);
        $this$openRoleDetail_u24lambda_u240.append(urlWithEncodedHash);
        char separator = StringsKt.contains$default(urlWithEncodedHash, '?', false, 2, (Object) null) ? '&' : '?';
        $this$openRoleDetail_u24lambda_u240.append(separator);
        $this$openRoleDetail_u24lambda_u240.append("bind_game_id=" + roleItem.getGameBaseId());
        $this$openRoleDetail_u24lambda_u240.append("&bind_game_name=" + CodecsKt.encodeURLParameter$default(roleItem.getGameName(), false, 1, (Object) null));
        String str2 = sourceFrom;
        if (!(str2 == null || StringsKt.isBlank(str2))) {
            $this$openRoleDetail_u24lambda_u240.append("&sourceFrom=" + CodecsKt.encodeURLParameter$default(sourceFrom, false, 1, (Object) null));
        }
        String urlWithParams = StringsKt.replace$default($this$openRoleDetail_u24lambda_u240.toString(), "%23", "#", false, 4, (Object) null);
        System.out.println((Object) ("openRoleDetail - 原始URL: " + url));
        System.out.println((Object) ("openRoleDetail - 拼接后URL: " + urlWithParams));
        System.out.println((Object) ("openRoleDetail - gameBaseId: " + roleItem.getGameBaseId() + ", gameName: " + roleItem.getGameName() + ", sourceFrom: " + sourceFrom));
        if (roleItem.getBindMethodType() == 2) {
            Router globalRouter = GlobalRouterKt.getGlobalRouter();
            Builder $this$openRoleDetail_u24lambda_u241 = Uri.Companion.parse("bilibili://game_center/cps_role_detail").buildUpon();
            $this$openRoleDetail_u24lambda_u241.appendQueryParameter("url", urlWithParams);
            globalRouter.launch($this$openRoleDetail_u24lambda_u241.build());
            return;
        }
        GlobalRouterKt.getGlobalRouter().launch(Uri.Companion.parse(urlWithParams));
    }

    public static final void openRoleDetail(String roleItemJson) {
        Intrinsics.checkNotNullParameter(roleItemJson, "roleItemJson");
        RoleItem roleItem = RoleItem.Companion.decodeFromString(roleItemJson);
        if (roleItem == null) {
            return;
        }
        openRoleDetail$default(roleItem, null, 2, null);
    }
}