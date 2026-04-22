package kntr.app.ad.domain.click.internal.util;

import android.net.Uri;
import android.text.TextUtils;
import com.bilibili.droid.PackageManagerHelper;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteInfo;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.blrouter.Runtime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kntr.app.ad.common.model.AdWhiteApk;
import kntr.app.ad.domain.click.internal.ClickContext;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: Utils.android.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u0014\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0002\u001a(\u0010\t\u001a\u00020\u0001*\u00020\u00022\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0000\u001a\u0010\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a5\u0010\u0010\u001a\u0004\u0018\u00010\f2\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0010\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0002\u0010\u0012\u001a$\u0010\u0015\u001a\u0004\u0018\u00010\f2\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0002\u001a\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0002\u001a\u001a\u0010\u0017\u001a\u00020\u00012\u0010\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bH\u0002\"\u001a\u0010\u0013\u001a\u00020\u0001*\u0004\u0018\u00010\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"isBxProgram", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "isBiliLink", "context", "Lkntr/app/ad/domain/click/internal/ClickContext;", "getNoneMebRequest", "Lcom/bilibili/lib/blrouter/RouteRequest;", "url", "isInDownloadWhiteList", "whiteList", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/common/model/AdWhiteApk;", "downloadUrlType", RoomRecommendViewModel.EMPTY_CURSOR, "isWXAppInstalled", "getAPKInfo", "whiteApkList", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;)Lkntr/app/ad/common/model/AdWhiteApk;", "isEndWithApk", "(Ljava/lang/String;)Z", "innerGetAPKInfo", "getAuthorityAndPath", "containsPostern", "click_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class Utils_androidKt {
    public static final boolean isBxProgram(String $this$isBxProgram) {
        Object obj;
        String matchRule;
        boolean z;
        Intrinsics.checkNotNullParameter($this$isBxProgram, "<this>");
        if (StringsKt.isBlank($this$isBxProgram)) {
            return false;
        }
        Iterator it = BLRouter.findRoutes(new RouteRequest.Builder($this$isBxProgram).build()).getInfo().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            RouteInfo it2 = (RouteInfo) obj;
            if (it2.getRuntime() == Runtime.MINI) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        RouteInfo routeInfo = (RouteInfo) obj;
        if (routeInfo == null || (matchRule = routeInfo.getMatchRule()) == null) {
            return false;
        }
        return StringsKt.contains$default(matchRule, "applet", false, 2, (Object) null);
    }

    public static final boolean isBiliLink(String $this$isBiliLink, ClickContext context) {
        Intrinsics.checkNotNullParameter($this$isBiliLink, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return getNoneMebRequest($this$isBiliLink) != null;
    }

    private static final RouteRequest getNoneMebRequest(String url) {
        RouteRequest request = new RouteRequest.Builder(url).build();
        List infoList = BLRouter.findRoutes(request).getInfo();
        if (!infoList.isEmpty()) {
            String simpleName = ((RouteInfo) infoList.get(0)).getClazz().getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
            if (StringsKt.contains$default(simpleName, "MWebActivity", false, 2, (Object) null)) {
                return null;
            }
        }
        return request;
    }

    public static /* synthetic */ boolean isInDownloadWhiteList$default(String str, List list, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return isInDownloadWhiteList(str, list, i);
    }

    public static final boolean isInDownloadWhiteList(String $this$isInDownloadWhiteList, List<AdWhiteApk> list, int downloadUrlType) {
        Intrinsics.checkNotNullParameter($this$isInDownloadWhiteList, "<this>");
        return getAPKInfo($this$isInDownloadWhiteList, list, Integer.valueOf(downloadUrlType)) != null;
    }

    public static final boolean isWXAppInstalled(ClickContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return PackageManagerHelper.checkAppInstalled(context.getService().getPlatformContext(), "com.tencent.mm");
    }

    private static final AdWhiteApk getAPKInfo(String url, List<AdWhiteApk> list, Integer downloadUrlType) {
        AdWhiteApk adWhiteApk;
        List notNullWhiteListApk = list != null ? CollectionsKt.filterNotNull(list) : null;
        if (downloadUrlType != null && downloadUrlType.intValue() == 1) {
            if (isEndWithApk(url)) {
                if (notNullWhiteListApk == null) {
                    return null;
                }
                return (AdWhiteApk) CollectionsKt.firstOrNull(notNullWhiteListApk);
            }
            return innerGetAPKInfo(url, notNullWhiteListApk);
        } else if (downloadUrlType != null && downloadUrlType.intValue() == 2) {
            if (isEndWithApk(url)) {
                if (notNullWhiteListApk == null || (adWhiteApk = (AdWhiteApk) CollectionsKt.firstOrNull(notNullWhiteListApk)) == null) {
                    return null;
                }
                return adWhiteApk;
            }
            return innerGetAPKInfo(url, notNullWhiteListApk);
        } else {
            return innerGetAPKInfo(url, notNullWhiteListApk);
        }
    }

    private static final boolean isEndWithApk(String $this$isEndWithApk) {
        Uri parse;
        String path;
        return ($this$isEndWithApk == null || (parse = Uri.parse($this$isEndWithApk)) == null || (path = parse.getPath()) == null || !StringsKt.endsWith$default(path, ".apk", false, 2, (Object) null)) ? false : true;
    }

    private static final AdWhiteApk innerGetAPKInfo(String url, List<AdWhiteApk> list) {
        ArrayList logList = new ArrayList();
        if (list == null || list.isEmpty() || TextUtils.isEmpty(url)) {
            return null;
        }
        String authorityAndPath = getAuthorityAndPath(url);
        if (!TextUtils.isEmpty(authorityAndPath)) {
            for (AdWhiteApk whiteApk : list) {
                logList.add(whiteApk.getBiliURL());
                logList.add(whiteApk.getUrl());
                if (!TextUtils.isEmpty(whiteApk.getUrl()) || !TextUtils.isEmpty(whiteApk.getBiliURL())) {
                    if (Intrinsics.areEqual(authorityAndPath, getAuthorityAndPath(whiteApk.getUrl())) || Intrinsics.areEqual(authorityAndPath, getAuthorityAndPath(whiteApk.getBiliURL()))) {
                        if (TextUtils.isEmpty(whiteApk.getApkName())) {
                            return null;
                        }
                        return whiteApk;
                    }
                }
            }
            if (containsPostern(list)) {
                Intrinsics.checkNotNull(authorityAndPath);
                if (StringsKt.endsWith$default(authorityAndPath, ".apk", false, 2, (Object) null)) {
                    return new AdWhiteApk(-1L, "应用包", url, url, (String) null, RoomRecommendViewModel.EMPTY_CURSOR, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 16336, (DefaultConstructorMarker) null);
                }
            }
        }
        return null;
    }

    private static final String getAuthorityAndPath(String url) {
        String str = url;
        boolean z = false;
        if (str == null || StringsKt.isBlank(str)) {
            return null;
        }
        Uri uri = Uri.parse(url);
        try {
            String authority = uri.getAuthority();
            String path = uri.getPath();
            StringBuilder builder = new StringBuilder();
            String str2 = authority;
            if (!(str2 == null || StringsKt.isBlank(str2))) {
                builder.append(authority);
            }
            String str3 = path;
            if (str3 == null || StringsKt.isBlank(str3)) {
                z = true;
            }
            if (!z) {
                builder.append(path);
            }
            return builder.toString();
        } catch (Exception e) {
            return null;
        }
    }

    private static final boolean containsPostern(List<AdWhiteApk> list) {
        List<AdWhiteApk> notNullWhiteListApk = list != null ? CollectionsKt.filterNotNull(list) : null;
        List list2 = notNullWhiteListApk;
        if (list2 == null || list2.isEmpty()) {
            return false;
        }
        for (AdWhiteApk whiteApk : notNullWhiteListApk) {
            if (Intrinsics.areEqual("*", whiteApk.getUrl())) {
                return true;
            }
        }
        return false;
    }
}