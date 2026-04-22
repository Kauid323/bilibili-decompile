package kntr.app.ad.domain.click.internal.interop;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.bilibili.droid.RomUtils;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.privacy.PrivacyHelper;
import java.util.List;
import java.util.Map;
import kntr.app.ad.common.model.AdWhiteApk;
import kntr.app.ad.domain.click.internal.ActionUiExtra;
import kntr.app.ad.domain.click.internal.ClickContext;
import kntr.app.ad.domain.click.internal.action.results.CallUpFailureReason;
import kntr.app.ad.domain.click.internal.action.results.CallUpResult;
import kntr.app.ad.domain.click.internal.action.results.EasyResult;
import kntr.app.ad.domain.click.internal.action.results.FailureReason;
import kntr.app.ad.domain.click.internal.util.MarketHelper;
import kntr.app.ad.domain.click.internal.util.MarketResponse;
import kntr.app.ad.domain.click.internal.util.UtilsKt;
import kntr.app.ad.domain.click.internal.util.XIAOMIMarket;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: AppStore.android.kt */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001aZ\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\rH\u0080@¢\u0006\u0002\u0010\u000e\u001a0\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007H\u0080@¢\u0006\u0002\u0010\u0011\u001a\u001a\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u001a\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0002\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0005H\u0002¨\u0006\u0017"}, d2 = {"openAppScore", "Lkntr/app/ad/domain/click/internal/action/results/EasyResult;", "context", "Lkntr/app/ad/domain/click/internal/ClickContext;", "url", RoomRecommendViewModel.EMPTY_CURSOR, "downloadWhiteList", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/common/model/AdWhiteApk;", "storeLink", "isFirstJump", RoomRecommendViewModel.EMPTY_CURSOR, "intermediates", RoomRecommendViewModel.EMPTY_CURSOR, "(Lkntr/app/ad/domain/click/internal/ClickContext;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;ZLjava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callUpAppStore", "Lkntr/app/ad/domain/click/internal/action/results/CallUpResult;", "(Lkntr/app/ad/domain/click/internal/ClickContext;Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isApkInstalled", "Landroid/content/Context;", "pkgName", "getPackageInfo", "Landroid/content/pm/PackageInfo;", "click_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AppStore_androidKt {
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object openAppScore(ClickContext context, String url, List<AdWhiteApk> list, final String storeLink, boolean isFirstJump, Map<String, String> map, Continuation<? super EasyResult> continuation) {
        XIAOMIMarket market;
        Function1 intentAction;
        MarketResponse result;
        AdWhiteApk findFirstSuitableWhileApk;
        String pkgName = (list == null || (findFirstSuitableWhileApk = UtilsKt.findFirstSuitableWhileApk(list)) == null) ? null : findFirstSuitableWhileApk.getApkName();
        String str = pkgName;
        boolean z = false;
        if (str == null || StringsKt.isBlank(str)) {
            return new EasyResult.Failure(new FailureReason.InputError("白名单不合法，没有找到有效包名"));
        }
        if (isApkInstalled(context.getService().getPlatformContext(), pkgName)) {
            return new EasyResult.Failure(new FailureReason.InputError("已下载，不再打开商店"));
        }
        boolean isXM = RomUtils.isMiuiRom();
        if (isXM) {
            String str2 = storeLink;
            if (str2 == null || StringsKt.isBlank(str2)) {
                z = true;
            }
            if (!z) {
                market = new XIAOMIMarket() { // from class: kntr.app.ad.domain.click.internal.interop.AppStore_androidKt$openAppScore$2
                    @Override // kntr.app.ad.domain.click.internal.util.AbsMarket
                    public String marketProtocol(String appPkg) {
                        Intrinsics.checkNotNullParameter(appPkg, "appPkg");
                        return storeLink;
                    }
                };
                intentAction = new Function1() { // from class: kntr.app.ad.domain.click.internal.interop.AppStore_androidKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        Unit openAppScore$lambda$0;
                        openAppScore$lambda$0 = AppStore_androidKt.openAppScore$lambda$0((Intent) obj);
                        return openAppScore$lambda$0;
                    }
                };
                context.getService().addOpenApkInfoIfNeed();
                context.getStage().info("即将打开商店...");
                result = MarketHelper.INSTANCE.launchAppDetail(context.getService().getPlatformContext(), pkgName, market, intentAction);
                map.put(ActionUiExtra.URL.getValue(), result.getUrl());
                map.put(ActionUiExtra.IS_FIRST_JUMP.getValue(), String.valueOf(isFirstJump));
                if (!(result instanceof MarketResponse.Success)) {
                    return EasyResult.Success.INSTANCE;
                }
                return new EasyResult.Failure(new FailureReason.InternalError(null, 1, null));
            }
        }
        market = MarketHelper.INSTANCE.getSystemMarket();
        intentAction = new Function1() { // from class: kntr.app.ad.domain.click.internal.interop.AppStore_androidKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit openAppScore$lambda$1;
                openAppScore$lambda$1 = AppStore_androidKt.openAppScore$lambda$1((Intent) obj);
                return openAppScore$lambda$1;
            }
        };
        context.getService().addOpenApkInfoIfNeed();
        context.getStage().info("即将打开商店...");
        result = MarketHelper.INSTANCE.launchAppDetail(context.getService().getPlatformContext(), pkgName, market, intentAction);
        map.put(ActionUiExtra.URL.getValue(), result.getUrl());
        map.put(ActionUiExtra.IS_FIRST_JUMP.getValue(), String.valueOf(isFirstJump));
        if (!(result instanceof MarketResponse.Success)) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit openAppScore$lambda$0(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "<this>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit openAppScore$lambda$1(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "<this>");
        intent.setFlags(268468224);
        return Unit.INSTANCE;
    }

    public static final Object callUpAppStore(ClickContext context, String url, List<AdWhiteApk> list, Continuation<? super CallUpResult> continuation) {
        return new CallUpResult.Failure(CallUpFailureReason.UnSupported.INSTANCE);
    }

    public static final boolean isApkInstalled(Context context, String pkgName) {
        return (pkgName == null || getPackageInfo(context, pkgName) == null) ? false : true;
    }

    private static final PackageInfo getPackageInfo(Context context, String pkgName) {
        if (TextUtils.isEmpty(pkgName) || context == null) {
            return null;
        }
        PackageManager pm = context.getPackageManager();
        try {
            return __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getPackageInfo(pm, pkgName, 0);
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0045, code lost:
        if (kotlin.text.StringsKt.contains$default(r5, r9, false, 2, (java.lang.Object) null) == true) goto L19;
     */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static PackageInfo __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getPackageInfo(PackageManager pm, String pkg, int flag) {
        boolean agreeGetPackageInfo;
        Intrinsics.checkNotNullParameter(pm, "pm");
        Intrinsics.checkNotNullParameter(pkg, "pkg");
        boolean inPkgWhiteLst = true;
        try {
            agreeGetPackageInfo = ConfigManager.Companion.ab2().getWithDefault("ff.privacy.hook.agree.get_package_info", true);
        } catch (Exception e) {
            agreeGetPackageInfo = true;
        }
        if (!PrivacyHelper.INSTANCE.checkPrivacy$privacy_debug("pm_get_package_info") || !agreeGetPackageInfo) {
            try {
                String str = (String) ConfigManager.Companion.config().get("privacy.pkg_info_whitelist", (Object) null);
                if (str != null) {
                }
                inPkgWhiteLst = false;
            } catch (Exception e2) {
            }
            if (!inPkgWhiteLst) {
                if (Intrinsics.areEqual(pkg, FoundationAlias.getFapps().getAppId())) {
                    PackageInfo fake = pm.getPackageArchiveInfo(FoundationAlias.getFapp().getPackageCodePath(), 0);
                    if (fake == null) {
                        PackageInfo it = new PackageInfo();
                        it.versionCode = 2233;
                        return it;
                    }
                    return fake;
                }
                throw new PackageManager.NameNotFoundException(pkg);
            }
        }
        PackageInfo packageInfo = pm.getPackageInfo(pkg, Integer.valueOf(flag).intValue());
        if (packageInfo instanceof PackageInfo) {
            return packageInfo;
        }
        return null;
    }
}