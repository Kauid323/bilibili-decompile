package im.direct.notification.interactive;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.BuildersKt;

/* compiled from: GetStringById.android.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"getStringById", "", "imResID", "", "interactive_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class GetStringById_androidKt {
    public static final String getStringById(int imResID) {
        switch (imResID) {
            case 441:
                String res = (String) BuildersKt.runBlocking$default((CoroutineContext) null, new GetStringById_androidKt$getStringById$res$1(null), 1, (Object) null);
                return res;
            case 880:
                String res2 = (String) BuildersKt.runBlocking$default((CoroutineContext) null, new GetStringById_androidKt$getStringById$res$2(null), 1, (Object) null);
                return res2;
            case 881:
                String res3 = (String) BuildersKt.runBlocking$default((CoroutineContext) null, new GetStringById_androidKt$getStringById$res$3(null), 1, (Object) null);
                return res3;
            case 882:
                String res4 = (String) BuildersKt.runBlocking$default((CoroutineContext) null, new GetStringById_androidKt$getStringById$res$4(null), 1, (Object) null);
                return res4;
            case 883:
                String res5 = (String) BuildersKt.runBlocking$default((CoroutineContext) null, new GetStringById_androidKt$getStringById$res$5(null), 1, (Object) null);
                return res5;
            default:
                return "";
        }
    }
}