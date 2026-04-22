package tv.danmaku.bili.videopage.common.helper;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import bili.resource.playerbaseres.R;
import bolts.Task;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.blrouter.Runtime;
import com.bilibili.lib.router.Router;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.service.report.EventId;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: VideoRouter.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\nH\u0007J@\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\tH\u0007J\"\u0010\u0010\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tH\u0007J@\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\tH\u0007J$\u0010\u0015\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\u0014H\u0007¨\u0006\u0018"}, d2 = {"Ltv/danmaku/bili/videopage/common/helper/VideoRouter;", "", "<init>", "()V", "goToUri", "", "context", "Landroid/content/Context;", "uri", "", "Landroid/net/Uri;", "goToLogin", "toast", "fromId", "fromSpmid", "extend", "gotoAppeal", "avid", "bvid", "checkAndLogin", "", "logout", "revokeApi", "showToast", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class VideoRouter {
    public static final VideoRouter INSTANCE = new VideoRouter();

    @JvmStatic
    public static final boolean checkAndLogin(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return checkAndLogin$default(context, null, null, null, null, 30, null);
    }

    @JvmStatic
    public static final boolean checkAndLogin(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        return checkAndLogin$default(context, str, null, null, null, 28, null);
    }

    @JvmStatic
    public static final boolean checkAndLogin(Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        return checkAndLogin$default(context, str, str2, null, null, 24, null);
    }

    @JvmStatic
    public static final boolean checkAndLogin(Context context, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(context, "context");
        return checkAndLogin$default(context, str, str2, str3, null, 16, null);
    }

    @JvmStatic
    public static final void goToLogin(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        goToLogin$default(context, null, null, null, null, 30, null);
    }

    @JvmStatic
    public static final void goToLogin(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        goToLogin$default(context, str, null, null, null, 28, null);
    }

    @JvmStatic
    public static final void goToLogin(Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        goToLogin$default(context, str, str2, null, null, 24, null);
    }

    @JvmStatic
    public static final void goToLogin(Context context, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(context, "context");
        goToLogin$default(context, str, str2, str3, null, 16, null);
    }

    @JvmStatic
    public static final void logout(Context context, String str) {
        Intrinsics.checkNotNullParameter(str, "revokeApi");
        logout$default(context, str, false, 4, null);
    }

    private VideoRouter() {
    }

    @JvmStatic
    public static final void goToUri(Context context, String uri) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        if (TextUtils.isEmpty(uri)) {
            return;
        }
        RouteRequest request = new RouteRequest.Builder(uri).extras(new Function1() { // from class: tv.danmaku.bili.videopage.common.helper.VideoRouter$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit goToUri$lambda$0;
                goToUri$lambda$0 = VideoRouter.goToUri$lambda$0((MutableBundleLike) obj);
                return goToUri$lambda$0;
            }
        }).build();
        BLRouter.routeTo(request, context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit goToUri$lambda$0(MutableBundleLike $this$extras) {
        Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
        $this$extras.put("bili_only", "0");
        return Unit.INSTANCE;
    }

    @JvmStatic
    public static final void goToUri(Context context, Uri uri) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (uri == null) {
            return;
        }
        String uri2 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "toString(...)");
        goToUri(context, uri2);
    }

    public static /* synthetic */ void goToLogin$default(Context context, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        if ((i & 16) != 0) {
            str4 = null;
        }
        goToLogin(context, str, str2, str3, str4);
    }

    @JvmStatic
    public static final void goToLogin(Context context, String toast, String fromId, String fromSpmid, String extend) {
        Intrinsics.checkNotNullParameter(context, "context");
        Router.RouterProxy proxy = Router.Companion.global().with(context);
        if (!TextUtils.isEmpty(toast)) {
            proxy.with("key_toast", toast);
        }
        proxy.with("key_prompt_scene", fromId);
        proxy.with("from_spmid", fromSpmid);
        proxy.with("extend", extend);
        proxy.open("activity://main/login/");
    }

    @JvmStatic
    public static final void gotoAppeal(Context context, String avid, String bvid) {
        Intrinsics.checkNotNullParameter(avid, "avid");
        Intrinsics.checkNotNullParameter(bvid, "bvid");
        if (context != null && checkAndLogin$default(context, "", EventId.player_neuron_half_menu_item_click, null, null, 24, null)) {
            Uri uri = Uri.parse("https://www.bilibili.com/appeal/").buildUpon().appendQueryParameter("avid", avid).appendQueryParameter("bvid", bvid).build();
            Intrinsics.checkNotNull(uri);
            RouteRequest request = new RouteRequest.Builder(uri).runtime(CollectionsKt.listOf(Runtime.WEB)).build();
            BLRouter.routeTo(request, context);
        }
    }

    public static /* synthetic */ boolean checkAndLogin$default(Context context, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        if ((i & 16) != 0) {
            str4 = null;
        }
        return checkAndLogin(context, str, str2, str3, str4);
    }

    @JvmStatic
    public static final boolean checkAndLogin(Context context, String toast, String fromId, String fromSpmid, String extend) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (BiliAccounts.get(context).isLogin()) {
            return true;
        }
        goToLogin(context, toast, fromId, fromSpmid, extend);
        return false;
    }

    public static /* synthetic */ void logout$default(Context context, String str, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        logout(context, str, z);
    }

    @JvmStatic
    public static final void logout(final Context context, final String revokeApi, boolean showToast) {
        Intrinsics.checkNotNullParameter(revokeApi, "revokeApi");
        if (context == null) {
            return;
        }
        Task.callInBackground(new Callable() { // from class: tv.danmaku.bili.videopage.common.helper.VideoRouter$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Void logout$lambda$0;
                logout$lambda$0 = VideoRouter.logout$lambda$0(context, revokeApi);
                return logout$lambda$0;
            }
        });
        if (showToast) {
            ToastHelper.showToastLong(context, R.string.playerbaseres_global_string_906);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void logout$lambda$0(Context $context, String $revokeApi) {
        BiliAccounts.get($context).logout($revokeApi);
        return null;
    }
}