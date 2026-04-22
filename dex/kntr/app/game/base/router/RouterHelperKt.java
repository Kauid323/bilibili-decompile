package kntr.app.game.base.router;

import com.bilibili.biligame.kntr.common.bean.KBiligame;
import com.bilibili.biligame.kntr.common.service.GameApiService;
import com.bilibili.biligame.kntr.common.util.KBiligameExtKt;
import com.bilibili.biligame.kntr.common.util.KBiligameExt_androidKt;
import com.bilibili.biligame.kntr.common.util.KtJsonKt;
import com.bilibili.biligame.kntr.common.util.UtilsKt;
import com.bilibili.lib.brouter.uri.Builder;
import com.bilibili.lib.brouter.uri.Uri;
import java.util.Map;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.game.base.bridge.GameRouterBridge;
import kntr.app.game.base.bridge.KntrGameTeenagerModeService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.router.GlobalRouterKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: RouterHelper.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\\\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00072\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b\u001af\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00072\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b\u001a\"\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001\u001a\u0006\u0010\u0013\u001a\u00020\u0003\u001a(\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u00012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"PARAM_SOURCE_FROM", RoomRecommendViewModel.EMPTY_CURSOR, "openGameDetail", RoomRecommendViewModel.EMPTY_CURSOR, "gameBaseId", RoomRecommendViewModel.EMPTY_CURSOR, "share", RoomRecommendViewModel.EMPTY_CURSOR, "tabIndex", "isAutoDownload", "params", RoomRecommendViewModel.EMPTY_CURSOR, "reportExtra", "handleGameDetail", "game", "Lcom/bilibili/biligame/kntr/common/bean/KBiligame;", "from", "openSmallGame", "smallGameLink", "login", "openUrl", "url", "base_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class RouterHelperKt {
    public static final String PARAM_SOURCE_FROM = "sourceFrom";

    public static /* synthetic */ void openGameDetail$default(int i, boolean z, int i2, boolean z2, Map map, Map map2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = false;
        }
        if ((i3 & 4) != 0) {
            i2 = -1;
        }
        if ((i3 & 8) != 0) {
            z2 = false;
        }
        if ((i3 & 16) != 0) {
            map = null;
        }
        if ((i3 & 32) != 0) {
            map2 = null;
        }
        openGameDetail(i, z, i2, z2, map, map2);
    }

    public static final void openGameDetail(int gameBaseId, boolean share, int tabIndex, boolean isAutoDownload, Map<String, String> map, Map<String, String> map2) {
        if (KntrGameTeenagerModeService.INSTANCE.isEnable() && KntrGameTeenagerModeService.INSTANCE.isForbiddenDetailPage()) {
            KntrGameTeenagerModeService.INSTANCE.openInterceptPage();
            return;
        }
        Map $this$openGameDetail_u24lambda_u240 = MapsKt.createMapBuilder();
        $this$openGameDetail_u24lambda_u240.put(ReportBuildInParam.ID, String.valueOf(gameBaseId));
        if (share) {
            $this$openGameDetail_u24lambda_u240.put("autoShare", "1");
        }
        if (tabIndex != -1) {
            $this$openGameDetail_u24lambda_u240.put("tab", String.valueOf(tabIndex));
        }
        if (isAutoDownload) {
            $this$openGameDetail_u24lambda_u240.put("auto-D", "1");
        }
        if (map != null) {
            $this$openGameDetail_u24lambda_u240.putAll(map);
        }
        if (map2 != null) {
            String str = (String) $this$openGameDetail_u24lambda_u240.put("reportExtra", KtJsonKt.mapToJsonString(map2));
        }
        if (tabIndex != 2) {
            $this$openGameDetail_u24lambda_u240.put("biz_scene", "game_center");
        }
        Map map3 = MapsKt.build($this$openGameDetail_u24lambda_u240);
        openUrl("bilibili://game_center/detail", map3);
    }

    public static /* synthetic */ void handleGameDetail$default(KBiligame kBiligame, int i, boolean z, int i2, boolean z2, Map map, Map map2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = -1;
        }
        if ((i3 & 16) != 0) {
            z2 = false;
        }
        if ((i3 & 32) != 0) {
            map = null;
        }
        if ((i3 & 64) != 0) {
            map2 = null;
        }
        handleGameDetail(kBiligame, i, z, i2, z2, map, map2);
    }

    public static final void handleGameDetail(KBiligame game, int from, boolean share, int tabIndex, boolean isAutoDownload, Map<String, String> map, Map<String, String> map2) {
        Intrinsics.checkNotNullParameter(game, "game");
        if (KBiligameExtKt.isSmallGame(game)) {
            openSmallGame(game.getGameBaseId(), game.getSmallGameLink(), String.valueOf(from));
        } else if (KBiligameExtKt.isOpenWiki(game)) {
            openUrl$default(game.getProtocolLink(), null, 2, null);
        } else if (KBiligameExtKt.isBookSkipGame(game)) {
            openUrl$default(KBiligameExt_androidKt.getBookLink(game), null, 2, null);
        } else {
            openGameDetail(game.getGameBaseId(), share, tabIndex, isAutoDownload, map, map2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0060, code lost:
        if (r8 == false) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0051 A[Catch: all -> 0x00aa, TryCatch #0 {all -> 0x00aa, blocks: (B:20:0x0032, B:22:0x0045, B:28:0x0051, B:30:0x0056, B:36:0x0062, B:38:0x006b, B:44:0x0077, B:45:0x007e, B:47:0x0083, B:53:0x008f, B:55:0x0094, B:59:0x009d, B:60:0x00a0), top: B:65:0x0032 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0077 A[Catch: all -> 0x00aa, TryCatch #0 {all -> 0x00aa, blocks: (B:20:0x0032, B:22:0x0045, B:28:0x0051, B:30:0x0056, B:36:0x0062, B:38:0x006b, B:44:0x0077, B:45:0x007e, B:47:0x0083, B:53:0x008f, B:55:0x0094, B:59:0x009d, B:60:0x00a0), top: B:65:0x0032 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0083 A[Catch: all -> 0x00aa, TryCatch #0 {all -> 0x00aa, blocks: (B:20:0x0032, B:22:0x0045, B:28:0x0051, B:30:0x0056, B:36:0x0062, B:38:0x006b, B:44:0x0077, B:45:0x007e, B:47:0x0083, B:53:0x008f, B:55:0x0094, B:59:0x009d, B:60:0x00a0), top: B:65:0x0032 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x008f A[Catch: all -> 0x00aa, TryCatch #0 {all -> 0x00aa, blocks: (B:20:0x0032, B:22:0x0045, B:28:0x0051, B:30:0x0056, B:36:0x0062, B:38:0x006b, B:44:0x0077, B:45:0x007e, B:47:0x0083, B:53:0x008f, B:55:0x0094, B:59:0x009d, B:60:0x00a0), top: B:65:0x0032 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void openSmallGame(int gameBaseId, String smallGameLink, String from) {
        Uri uri;
        String sessionId;
        String miniFrom;
        String str;
        boolean z;
        String str2;
        boolean z2;
        String str3;
        boolean z3;
        boolean z4;
        String str4 = smallGameLink;
        boolean z5 = false;
        if (str4 == null || StringsKt.isBlank(str4)) {
            return;
        }
        if (!UtilsKt.isLogin()) {
            login();
        } else if (KntrGameTeenagerModeService.INSTANCE.isForbiddenSmall()) {
            KntrGameTeenagerModeService.INSTANCE.openSmallInterceptPage();
        } else {
            String finalLink = smallGameLink;
            try {
                uri = Uri.Companion.parse(smallGameLink);
                sessionId = uri.getQueryParameter("_biliSessionId");
                miniFrom = uri.getQueryParameter("_biliFrom");
                str = sessionId;
            } catch (Throwable th) {
            }
            if (str != null && !StringsKt.isBlank(str)) {
                z = false;
                if (!z) {
                    String str5 = miniFrom;
                    if (str5 != null && !StringsKt.isBlank(str5)) {
                        z4 = false;
                    }
                    z4 = true;
                }
                Builder build = uri.buildUpon();
                str2 = sessionId;
                if (str2 != null && !StringsKt.isBlank(str2)) {
                    z2 = false;
                    if (z2) {
                        build.appendQueryParameter("_biliSessionId", UtilsKt.randomUUID());
                    }
                    str3 = miniFrom;
                    if (str3 != null && !StringsKt.isBlank(str3)) {
                        z3 = false;
                        if (z3) {
                            String str6 = from;
                            if (str6 == null || StringsKt.isBlank(str6)) {
                                z5 = true;
                            }
                            if (!z5) {
                                build.appendQueryParameter("_biliFrom", from);
                            }
                        }
                        finalLink = build.build().toString();
                        openUrl$default(finalLink, null, 2, null);
                        GameApiService.INSTANCE.reportPlayedGame(String.valueOf(gameBaseId));
                    }
                    z3 = true;
                    if (z3) {
                    }
                    finalLink = build.build().toString();
                    openUrl$default(finalLink, null, 2, null);
                    GameApiService.INSTANCE.reportPlayedGame(String.valueOf(gameBaseId));
                }
                z2 = true;
                if (z2) {
                }
                str3 = miniFrom;
                if (str3 != null) {
                    z3 = false;
                    if (z3) {
                    }
                    finalLink = build.build().toString();
                    openUrl$default(finalLink, null, 2, null);
                    GameApiService.INSTANCE.reportPlayedGame(String.valueOf(gameBaseId));
                }
                z3 = true;
                if (z3) {
                }
                finalLink = build.build().toString();
                openUrl$default(finalLink, null, 2, null);
                GameApiService.INSTANCE.reportPlayedGame(String.valueOf(gameBaseId));
            }
            z = true;
            if (!z) {
            }
            Builder build2 = uri.buildUpon();
            str2 = sessionId;
            if (str2 != null) {
                z2 = false;
                if (z2) {
                }
                str3 = miniFrom;
                if (str3 != null) {
                }
                z3 = true;
                if (z3) {
                }
                finalLink = build2.build().toString();
                openUrl$default(finalLink, null, 2, null);
                GameApiService.INSTANCE.reportPlayedGame(String.valueOf(gameBaseId));
            }
            z2 = true;
            if (z2) {
            }
            str3 = miniFrom;
            if (str3 != null) {
            }
            z3 = true;
            if (z3) {
            }
            finalLink = build2.build().toString();
            openUrl$default(finalLink, null, 2, null);
            GameApiService.INSTANCE.reportPlayedGame(String.valueOf(gameBaseId));
        }
    }

    public static final void login() {
        GlobalRouterKt.getGlobalRouter().launch(Uri.Companion.parse("bilibili://login"));
    }

    public static /* synthetic */ void openUrl$default(String str, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = null;
        }
        openUrl(str, map);
    }

    public static final void openUrl(String url, Map<String, String> map) {
        String str = url;
        if (str == null || StringsKt.isBlank(str)) {
            return;
        }
        Uri baseUri = Uri.Companion.parse(url);
        Map commonParams = GameRouterBridge.INSTANCE.getCommonRouterParams(url);
        Map mergedParams = MapsKt.plus(commonParams == null ? MapsKt.emptyMap() : commonParams, map == null ? MapsKt.emptyMap() : map);
        if (GameRouterBridge.INSTANCE.isAppStoreUrl(url)) {
            GameRouterBridge.INSTANCE.openAppStorePage(url, mergedParams);
        } else if (mergedParams.isEmpty()) {
            GlobalRouterKt.getGlobalRouter().launch(baseUri);
        } else {
            Builder uriBuilder = baseUri.buildUpon();
            for (Map.Entry element$iv : mergedParams.entrySet()) {
                String key = element$iv.getKey();
                String value = element$iv.getValue();
                String queryParameter = baseUri.getQueryParameter(key);
                if (queryParameter == null || StringsKt.isBlank(queryParameter)) {
                    uriBuilder.appendQueryParameter(key, value);
                }
            }
            GlobalRouterKt.getGlobalRouter().launch(uriBuilder.build());
        }
    }
}