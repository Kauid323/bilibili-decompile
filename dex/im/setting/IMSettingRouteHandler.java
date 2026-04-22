package im.setting;

import com.bilibili.lib.brouter.uri.Uri;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: IMSettingPage.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦B¢\u0006\u0002\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lim/setting/IMSettingRouteHandler;", "", "invoke", "", SocialConstants.TYPE_REQUEST, "Lcom/bilibili/lib/brouter/uri/Uri;", "(Lcom/bilibili/lib/brouter/uri/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IMSettingRouteHandler {
    Object invoke(Uri uri, Continuation<? super Unit> continuation);
}