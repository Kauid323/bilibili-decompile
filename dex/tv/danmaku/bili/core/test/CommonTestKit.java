package tv.danmaku.bili.core.test;

import android.content.Context;
import com.bilibili.doraemonkit.kit.AbstractKit;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.router.ChannelRoutes;

/* compiled from: CommonTestPage.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007¨\u0006\u000f"}, d2 = {"Ltv/danmaku/bili/core/test/CommonTestKit;", "Lcom/bilibili/doraemonkit/kit/AbstractKit;", "<init>", "()V", ChannelRoutes.CHANNEL_NAME, "", "getName", "()I", "icon", "getIcon", "onAppInit", "", "context", "Landroid/content/Context;", "onClick", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@Named("CommonTest")
public final class CommonTestKit extends AbstractKit {
    public static final int $stable = 8;

    public int getName() {
        return R.string.common_test_page_title;
    }

    public int getIcon() {
        return com.bilibili.doraemonkit.R.mipmap.dk_sys_info;
    }

    public void onAppInit(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void onClick(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        BLRouter.routeTo$default(new RouteRequest.Builder("bilibili://test/common_test").build(), (Context) null, 2, (Object) null);
    }
}