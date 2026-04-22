package tv.danmaku.biliplayerv2.router;

import android.content.Context;
import android.net.Uri;
import com.bilibili.app.comm.servercomm.ServerClock;
import com.bilibili.base.util.ContextUtilKt;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.blrouter.RouteRequestKt;
import com.bilibili.moduleservice.account.AccountService;
import com.bilibili.moduleservice.main.MainCommonService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.bili.utils.LoginSceneProcessor;
import tv.danmaku.biliplayerv2.router.PlayerRouteUris;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PlayerRouteUris.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Ltv/danmaku/biliplayerv2/router/PlayerRouteUris;", "", "<init>", "()V", "Routers", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PlayerRouteUris {
    public static final PlayerRouteUris INSTANCE = new PlayerRouteUris();

    /* compiled from: PlayerRouteUris.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\t\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u00142\b\b\u0002\u0010'\u001a\u00020\u0014J\u0018\u0010(\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010)\u001a\u00020\u0014J\"\u0010*\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00052\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0014J*\u0010,\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u00142\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0014J\u001a\u0010.\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0014J\u0016\u00100\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0005J\u001e\u00101\u001a\u00020 2\u0006\u00102\u001a\u00020\"2\u0006\u00103\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u0014J\u0018\u00105\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u00106\u001a\u00020\u0014H\u0007J\u001e\u00107\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u00108\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0005J\u0006\u00109\u001a\u00020:J&\u0010;\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010<\u001a\u00020\u00142\u0006\u0010=\u001a\u00020\u00142\u0006\u0010>\u001a\u00020\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0014X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0014X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0014X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0014X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0014X\u0086T¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Ltv/danmaku/biliplayerv2/router/PlayerRouteUris$Routers;", "", "<init>", "()V", "REQUEST_CODE_DEFAULT", "", "REQUEST_CODE_BIND_PHONE", "REQUEST_CODE_LOGIN_SEND_DANMAKU", "REQUEST_CODE_LOGIN_PAY_COIN", "REQUEST_CODE_LOGIN_CHARGE", "REQUEST_CODE_LOGIN_DANMAKU_MANAGER", "REQUEST_CODE_LOGIN_DANMAKU_BLOCK_KEYWORD_ADD", "REQUEST_CODE_LOGIN_DANMAKU_BLOCK_KEYWORD_SYNC", "REQUEST_CODE_LOGIN_DANMAKU_REPLY", "REQEUST_CODE_FAVORITE", "REQUEST_CODE_ANSWER", "TYPE_DIALOG_PHONE_BIND", "TYPE_DIALOG_LOGIN", "REQUEST_CODE_AUTHOR_SPACE", "ROUTE_URI_LOGIN_DIALOG", "", "ROUTE_URI_LOGIN_MAIN", "ROUTE_URI_AUTHOR_SPACE", "ROUTE_URI_VIP_BUY", "LOGIN_ROUTE", "KEY_LOGIN_ROUTE", "KEY_APP_ID", "KEY_APP_SUBID", "KEY_SOURCE_FROM", "ANSWER_DEFAULT_URL", "ANSWER_KEY_DYNAMIC_URL", "gotoAuthorSpace", "", "context", "Landroid/content/Context;", "requestCode", "authorId", "authorName", "avid", "anchorTab", "logout", "revokeApi", "login", "fromId", "loginDanmaku", LoginSceneProcessor.SCENE_KEY, "toMainLogin", "toast", "gotoDanmakuAnswer", "gotoAuthority", "activity", "code", "msg", "gotoAssignUrl", "target", "openActivityForResult", "type", "now", "", "gotoBuyVip", "appId", "appSubId", "sourceFrom", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Routers {
        public static final String ANSWER_DEFAULT_URL = "https://www.bilibili.com/h5/newbie/entry?navhide=1";
        public static final String ANSWER_KEY_DYNAMIC_URL = "key_dynamic_url";
        public static final Routers INSTANCE = new Routers();
        public static final String KEY_APP_ID = "appId";
        public static final String KEY_APP_SUBID = "appSubId";
        private static final String KEY_LOGIN_ROUTE = "loginRoute";
        public static final String KEY_SOURCE_FROM = "source_from";
        private static final String LOGIN_ROUTE = "activity://login/player";
        public static final int REQEUST_CODE_FAVORITE = 2351;
        public static final int REQUEST_CODE_ANSWER = 2350;
        public static final int REQUEST_CODE_AUTHOR_SPACE = 10;
        public static final int REQUEST_CODE_BIND_PHONE = 2333;
        public static final int REQUEST_CODE_DEFAULT = 1024;
        public static final int REQUEST_CODE_LOGIN_CHARGE = 2336;
        public static final int REQUEST_CODE_LOGIN_DANMAKU_BLOCK_KEYWORD_ADD = 2338;
        public static final int REQUEST_CODE_LOGIN_DANMAKU_BLOCK_KEYWORD_SYNC = 2339;
        public static final int REQUEST_CODE_LOGIN_DANMAKU_MANAGER = 2337;
        public static final int REQUEST_CODE_LOGIN_DANMAKU_REPLY = 2340;
        public static final int REQUEST_CODE_LOGIN_PAY_COIN = 2335;
        public static final int REQUEST_CODE_LOGIN_SEND_DANMAKU = 2334;
        private static final String ROUTE_URI_AUTHOR_SPACE = "bilibili://space/:mid/";
        private static final String ROUTE_URI_LOGIN_DIALOG = "activity://main/login-dialog/";
        private static final String ROUTE_URI_LOGIN_MAIN = "activity://main/login/";
        public static final String ROUTE_URI_VIP_BUY = "activity://main/vip-buy";
        private static final int TYPE_DIALOG_LOGIN = 200;
        public static final int TYPE_DIALOG_PHONE_BIND = 100;

        private Routers() {
        }

        public static /* synthetic */ void gotoAuthorSpace$default(Routers routers, Context context, int i, String str, String str2, String str3, String str4, int i2, Object obj) {
            String str5;
            if ((i2 & 32) == 0) {
                str5 = str4;
            } else {
                str5 = "video";
            }
            routers.gotoAuthorSpace(context, i, str, str2, str3, str5);
        }

        public final void gotoAuthorSpace(Context context, int requestCode, String authorId, String authorName, String avid, String anchorTab) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(authorId, "authorId");
            Intrinsics.checkNotNullParameter(authorName, "authorName");
            Intrinsics.checkNotNullParameter(avid, "avid");
            Intrinsics.checkNotNullParameter(anchorTab, "anchorTab");
            Uri parse = Uri.parse(ROUTE_URI_AUTHOR_SPACE);
            Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
            RouteRequest.Builder builder = new RouteRequest.Builder(parse);
            builder.getExtras().put(RankRouter.BundleKey.AUTHOR_SPACE_MID, authorId);
            builder.getExtras().put("name", authorName);
            builder.getExtras().put("defaultTab", anchorTab);
            builder.getExtras().put("avid", avid);
            builder.requestCode(requestCode > 0 ? requestCode : 1024);
            BLRouter.routeTo(builder.build(), context);
        }

        public final void logout(Context context, String revokeApi) {
            AccountService accountService;
            Intrinsics.checkNotNullParameter(revokeApi, "revokeApi");
            if (context != null && (accountService = (AccountService) BLRouter.INSTANCE.get(AccountService.class, "default")) != null) {
                accountService.logout(revokeApi);
            }
        }

        public static /* synthetic */ void login$default(Routers routers, Context context, int i, String str, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                str = null;
            }
            routers.login(context, i, str);
        }

        public final void login(Context context, int requestCode, String fromId) {
            Intrinsics.checkNotNullParameter(context, "context");
            Uri parse = Uri.parse(ROUTE_URI_LOGIN_DIALOG);
            Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
            RouteRequest.Builder builder = new RouteRequest.Builder(parse);
            builder.getExtras().put("key_prompt_scene", fromId == null ? "" : fromId);
            builder.addFlag(65536);
            builder.requestCode(requestCode > 0 ? requestCode : 1024);
            BLRouter.routeTo(builder.build(), context);
        }

        public static /* synthetic */ void loginDanmaku$default(Routers routers, Context context, int i, String str, String str2, int i2, Object obj) {
            if ((i2 & 8) != 0) {
                str2 = null;
            }
            routers.loginDanmaku(context, i, str, str2);
        }

        public final void loginDanmaku(Context context, int requestCode, String scene, String fromId) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(scene, LoginSceneProcessor.SCENE_KEY);
            Uri parse = Uri.parse(ROUTE_URI_LOGIN_DIALOG);
            Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
            RouteRequest.Builder builder = new RouteRequest.Builder(parse);
            builder.getExtras().put(LoginSceneProcessor.SCENE_KEY, scene);
            builder.getExtras().put("key_prompt_scene", fromId == null ? "" : fromId);
            builder.addFlag(65536);
            builder.requestCode(requestCode > 0 ? requestCode : 1024);
            BLRouter.routeTo(builder.build(), context);
        }

        public static /* synthetic */ void toMainLogin$default(Routers routers, Context context, String str, int i, Object obj) {
            if ((i & 2) != 0) {
                str = null;
            }
            routers.toMainLogin(context, str);
        }

        public final void toMainLogin(Context context, String toast) {
            Intrinsics.checkNotNullParameter(context, "context");
            Uri parse = Uri.parse(ROUTE_URI_LOGIN_MAIN);
            Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
            RouteRequest.Builder builder = new RouteRequest.Builder(parse);
            String str = toast;
            if (!(str == null || str.length() == 0)) {
                builder.getExtras().put("key_toast", toast);
            }
            BLRouter.routeTo(builder.build(), context);
        }

        public final void gotoDanmakuAnswer(Context context, int requestCode) {
            Intrinsics.checkNotNullParameter(context, "context");
            Uri parse = Uri.parse("activity://main/go-to-answer");
            Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
            RouteRequest.Builder builder = new RouteRequest.Builder(parse);
            builder.extras(new Function1() { // from class: tv.danmaku.biliplayerv2.router.PlayerRouteUris$Routers$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit gotoDanmakuAnswer$lambda$0;
                    gotoDanmakuAnswer$lambda$0 = PlayerRouteUris.Routers.gotoDanmakuAnswer$lambda$0((MutableBundleLike) obj);
                    return gotoDanmakuAnswer$lambda$0;
                }
            });
            builder.requestCode(requestCode > 0 ? requestCode : 1024);
            BLRouter.routeTo(builder.build(), context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit gotoDanmakuAnswer$lambda$0(MutableBundleLike $this$extras) {
            Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
            $this$extras.put(ANSWER_KEY_DYNAMIC_URL, ANSWER_DEFAULT_URL);
            return Unit.INSTANCE;
        }

        public final void gotoAuthority(Context activity, int code, String msg) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(msg, "msg");
            MainCommonService mainCommonService = (MainCommonService) BLRouter.INSTANCE.get(MainCommonService.class, "default");
            if (mainCommonService != null) {
                mainCommonService.showAuthorityDialog(ContextUtilKt.findActivityOrNull(activity), msg, code);
            }
        }

        @JvmStatic
        public static final void gotoAssignUrl(Context context, String target) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(target, "target");
            BLRouter.routeTo(RouteRequestKt.toRouteRequest(target), context);
        }

        public final void openActivityForResult(Context context, int type, int requestCode) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (100 == type) {
                AccountService accountService = (AccountService) BLRouter.INSTANCE.get(AccountService.class, "default");
                if (accountService != null) {
                    accountService.bindPhone(context);
                }
            } else if (200 == type) {
                Uri parse = Uri.parse(ROUTE_URI_LOGIN_DIALOG);
                Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
                RouteRequest.Builder builder = new RouteRequest.Builder(parse);
                builder.addFlag(65536);
                builder.requestCode(requestCode > 0 ? requestCode : 1024);
                BLRouter.routeTo(builder.build(), context);
            }
        }

        public final long now() {
            return ServerClock.now();
        }

        public final void gotoBuyVip(Context context, final String appId, final String appSubId, final String sourceFrom) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(appId, "appId");
            Intrinsics.checkNotNullParameter(appSubId, "appSubId");
            Intrinsics.checkNotNullParameter(sourceFrom, "sourceFrom");
            Uri parse = Uri.parse(ROUTE_URI_VIP_BUY);
            Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
            RouteRequest routeRequest = new RouteRequest.Builder(parse).extras(new Function1() { // from class: tv.danmaku.biliplayerv2.router.PlayerRouteUris$Routers$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    Unit gotoBuyVip$lambda$0;
                    gotoBuyVip$lambda$0 = PlayerRouteUris.Routers.gotoBuyVip$lambda$0(appId, appSubId, sourceFrom, (MutableBundleLike) obj);
                    return gotoBuyVip$lambda$0;
                }
            }).build();
            BLRouter.routeTo(routeRequest, context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit gotoBuyVip$lambda$0(String $appId, String $appSubId, String $sourceFrom, MutableBundleLike $this$extras) {
            Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
            $this$extras.put("appId", $appId);
            $this$extras.put("appSubId", $appSubId);
            $this$extras.put("source_from", $sourceFrom);
            return Unit.INSTANCE;
        }
    }

    private PlayerRouteUris() {
    }
}