package tv.danmaku.bili.utils;

import android.net.Uri;
import com.bilibili.lib.blconfig.ConfigManager;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.app.AppConfig;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: UriSpmidModuleHelper.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\u0002J$\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0007J&\u0010\n\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0007J\u001a\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0007J\u001c\u0010\u0010\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/utils/UriSpmidModuleHelper;", "", "<init>", "()V", "DEFAULT_FOLLOWING_FROM_MODULE_REG", "", "getFollowingFromModuleReg", "isFromModuleNeeded", "", "uri", "appendFromSpmidAndFromModule", "Landroid/net/Uri;", RankRouter.RankConst.TYPE_ORIGINAL, "spmid", "moduleId", "originalUrl", "appendFromSpmid", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class UriSpmidModuleHelper {
    public static final int $stable = 0;
    private static final String DEFAULT_FOLLOWING_FROM_MODULE_REG = "(^(https?:)?//([w-]+.)?bilibili.com/blackboard/)|(bilibili://following/activity_landing/(\\d+))";
    public static final UriSpmidModuleHelper INSTANCE = new UriSpmidModuleHelper();

    private UriSpmidModuleHelper() {
    }

    private final String getFollowingFromModuleReg() {
        return (String) ConfigManager.Companion.config().get("following.url_from_source_reg", DEFAULT_FOLLOWING_FROM_MODULE_REG);
    }

    private final boolean isFromModuleNeeded(String uri) {
        String $this$isFromModuleNeeded_u24lambda_u240 = getFollowingFromModuleReg();
        if ($this$isFromModuleNeeded_u24lambda_u240 != null) {
            try {
                Pattern reg = Pattern.compile($this$isFromModuleNeeded_u24lambda_u240, 2);
                return reg.matcher(uri).find();
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    @JvmStatic
    public static final Uri appendFromSpmidAndFromModule(Uri original, String spmid, String moduleId) {
        Intrinsics.checkNotNullParameter(original, RankRouter.RankConst.TYPE_ORIGINAL);
        if (AppConfig.isBiliDomain(original)) {
            Uri.Builder $this$appendFromSpmidAndFromModule_u24lambda_u240 = original.buildUpon();
            String queryParameter = original.getQueryParameter("from_spmid");
            boolean z = false;
            String str = spmid;
            if ((queryParameter == null || queryParameter.length() == 0) & (!(str == null || str.length() == 0))) {
                $this$appendFromSpmidAndFromModule_u24lambda_u240.appendQueryParameter("from_spmid", spmid);
            }
            String queryParameter2 = original.getQueryParameter(tv.danmaku.bili.videopage.common.helper.UriSpmidModuleHelperKt.URI_PARAM_FROM_MODULE);
            boolean z2 = queryParameter2 == null || queryParameter2.length() == 0;
            String str2 = moduleId;
            if (str2 == null || str2.length() == 0) {
                z = true;
            }
            boolean z3 = z2 & (!z);
            UriSpmidModuleHelper uriSpmidModuleHelper = INSTANCE;
            String uri = original.toString();
            Intrinsics.checkNotNullExpressionValue(uri, "toString(...)");
            if (z3 & uriSpmidModuleHelper.isFromModuleNeeded(uri)) {
                $this$appendFromSpmidAndFromModule_u24lambda_u240.appendQueryParameter(tv.danmaku.bili.videopage.common.helper.UriSpmidModuleHelperKt.URI_PARAM_FROM_MODULE, moduleId);
            }
            Uri build = $this$appendFromSpmidAndFromModule_u24lambda_u240.build();
            Intrinsics.checkNotNullExpressionValue(build, "run(...)");
            return build;
        }
        return original;
    }

    @JvmStatic
    public static final String appendFromSpmidAndFromModule(String originalUrl, String spmid, String moduleId) {
        String str = originalUrl;
        boolean z = false;
        if (str == null || str.length() == 0) {
            return "";
        }
        Uri original = Uri.parse(originalUrl);
        if (!AppConfig.isBiliDomain(original)) {
            return originalUrl == null ? "" : originalUrl;
        }
        Uri.Builder $this$appendFromSpmidAndFromModule_u24lambda_u241 = original.buildUpon();
        String queryParameter = original.getQueryParameter("from_spmid");
        String str2 = spmid;
        if ((queryParameter == null || queryParameter.length() == 0) & (!(str2 == null || str2.length() == 0))) {
            $this$appendFromSpmidAndFromModule_u24lambda_u241.appendQueryParameter("from_spmid", spmid);
        }
        String queryParameter2 = original.getQueryParameter(tv.danmaku.bili.videopage.common.helper.UriSpmidModuleHelperKt.URI_PARAM_FROM_MODULE);
        boolean z2 = queryParameter2 == null || queryParameter2.length() == 0;
        String str3 = moduleId;
        if (str3 == null || str3.length() == 0) {
            z = true;
        }
        boolean z3 = (!z) & z2;
        UriSpmidModuleHelper uriSpmidModuleHelper = INSTANCE;
        String uri = original.toString();
        Intrinsics.checkNotNullExpressionValue(uri, "toString(...)");
        if (z3 & uriSpmidModuleHelper.isFromModuleNeeded(uri)) {
            $this$appendFromSpmidAndFromModule_u24lambda_u241.appendQueryParameter(tv.danmaku.bili.videopage.common.helper.UriSpmidModuleHelperKt.URI_PARAM_FROM_MODULE, moduleId);
        }
        String uri2 = $this$appendFromSpmidAndFromModule_u24lambda_u241.build().toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "run(...)");
        return uri2;
    }

    @JvmStatic
    public static final Uri appendFromSpmid(Uri original, String spmid) {
        Intrinsics.checkNotNullParameter(original, RankRouter.RankConst.TYPE_ORIGINAL);
        if (AppConfig.isBiliDomain(original)) {
            Uri.Builder $this$appendFromSpmid_u24lambda_u240 = original.buildUpon();
            String queryParameter = original.getQueryParameter("from_spmid");
            boolean z = false;
            boolean z2 = queryParameter == null || queryParameter.length() == 0;
            String str = spmid;
            if (str == null || str.length() == 0) {
                z = true;
            }
            if (z2 & (!z)) {
                $this$appendFromSpmid_u24lambda_u240.appendQueryParameter("from_spmid", spmid);
            }
            Uri build = $this$appendFromSpmid_u24lambda_u240.build();
            Intrinsics.checkNotNullExpressionValue(build, "run(...)");
            return build;
        }
        return original;
    }

    @JvmStatic
    public static final String appendFromSpmid(String original, String spmid) {
        String str = original;
        boolean z = false;
        if (str == null || str.length() == 0) {
            return "";
        }
        Uri uri = Uri.parse(original);
        if (!AppConfig.isBiliDomain(uri)) {
            return original == null ? "" : original;
        }
        Uri.Builder $this$appendFromSpmid_u24lambda_u241 = uri.buildUpon();
        String queryParameter = uri.getQueryParameter("from_spmid");
        boolean z2 = queryParameter == null || queryParameter.length() == 0;
        String str2 = spmid;
        if (str2 == null || str2.length() == 0) {
            z = true;
        }
        if ((!z) & z2) {
            $this$appendFromSpmid_u24lambda_u241.appendQueryParameter("from_spmid", spmid);
        }
        String uri2 = $this$appendFromSpmid_u24lambda_u241.build().toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "run(...)");
        return uri2;
    }
}