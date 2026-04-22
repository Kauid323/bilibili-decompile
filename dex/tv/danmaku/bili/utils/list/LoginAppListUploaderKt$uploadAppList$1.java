package tv.danmaku.bili.utils.list;

import android.net.Uri;
import com.bilibili.lib.neuron.api.Neurons;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONArray;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LoginAppListUploader.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.utils.list.LoginAppListUploaderKt$uploadAppList$1", f = "LoginAppListUploader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class LoginAppListUploaderKt$uploadAppList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LoginAppListUploaderKt$uploadAppList$1(Continuation<? super LoginAppListUploaderKt$uploadAppList$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LoginAppListUploaderKt$uploadAppList$1(continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        String cryptString;
        JSONArray installedAppsAsJsonArray;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                try {
                    installedAppsAsJsonArray = LoginAppListUploaderKt.getInstalledAppsAsJsonArray();
                    cryptString = LoginAppListUploaderKt.getLimitedSizeString(installedAppsAsJsonArray);
                } catch (Exception e) {
                    BLog.e("LoginAppListUploader", "getLimitedSizeStringError", e);
                    cryptString = "";
                }
                Map extra = MapsKt.mapOf(TuplesKt.to("applist", Uri.encode(cryptString)));
                Neurons.report$default(true, 4, "main.login.applist.sys", extra, (String) null, 0, 48, (Object) null);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}