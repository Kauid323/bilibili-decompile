package tv.danmaku.bili.ui.main;

import android.net.Uri;
import com.bilibili.base.util.GlobalNetworkController;
import com.bilibili.homepage.UserProtocolDialogListener;
import com.bilibili.opd.app.bizcommon.hybridruntime.web.FlutterWebModCheckerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main.deeplink.RedirectDeeplinkHelper;
import tv.danmaku.bili.ui.video.main.UtilKt;
import tv.danmaku.bili.utils.NetworkController;

/* compiled from: InterceptUserProtocolActivity.kt */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"tv/danmaku/bili/ui/main/InterceptUserProtocolActivity$onCreate$1", "Lcom/bilibili/homepage/UserProtocolDialogListener;", "onAgree", "", "onCancel", "isFirstStep", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class InterceptUserProtocolActivity$onCreate$1 implements UserProtocolDialogListener {
    final /* synthetic */ Uri $uri;
    final /* synthetic */ InterceptUserProtocolActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public InterceptUserProtocolActivity$onCreate$1(Uri $uri, InterceptUserProtocolActivity $receiver) {
        this.$uri = $uri;
        this.this$0 = $receiver;
    }

    public void onAgree() {
        if (!GlobalNetworkController.Companion.isNetworkAllowed()) {
            NetworkController.Companion.setNetworkAllow(true);
        }
        if (RedirectDeeplinkHelper.canDirect(this.$uri)) {
            String uri = this.$uri.toString();
            final Uri uri2 = this.$uri;
            final InterceptUserProtocolActivity interceptUserProtocolActivity = this.this$0;
            RedirectDeeplinkHelper.fetchRedirectDeeplink(uri, new Function1() { // from class: tv.danmaku.bili.ui.main.InterceptUserProtocolActivity$onCreate$1$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit onAgree$lambda$0;
                    onAgree$lambda$0 = InterceptUserProtocolActivity$onCreate$1.onAgree$lambda$0(uri2, interceptUserProtocolActivity, (String) obj);
                    return onAgree$lambda$0;
                }
            });
        } else {
            UtilKt.deepLinkTrack("InterceptUserProtocolActivity can't fetchRedirectDeeplink uri = " + this.$uri);
            this.this$0.routeToTarget(null, this.$uri);
        }
        this.this$0.finish();
        this.this$0.onDismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onAgree$lambda$0(Uri $uri, InterceptUserProtocolActivity this$0, String it) {
        Uri targetUri = $uri;
        if (FlutterWebModCheckerKt.isNotNullAndNotEmpty(it)) {
            Uri parse = Uri.parse(it);
            Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
            targetUri = parse;
        }
        this$0.routeToTarget($uri, targetUri);
        return Unit.INSTANCE;
    }

    public void onCancel(boolean isFirstStep) {
    }
}