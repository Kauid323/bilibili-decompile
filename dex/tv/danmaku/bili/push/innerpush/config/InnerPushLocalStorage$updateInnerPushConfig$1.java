package tv.danmaku.bili.push.innerpush.config;

import android.content.SharedPreferences;
import com.google.gson.Gson;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.push.innerpush.model.InnerPushConfig;
import tv.danmaku.bili.push.innerpush.service.InnerPushServiceHelperKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InnerPushLocalStorage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.push.innerpush.config.InnerPushLocalStorage$updateInnerPushConfig$1", f = "InnerPushLocalStorage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class InnerPushLocalStorage$updateInnerPushConfig$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public InnerPushLocalStorage$updateInnerPushConfig$1(Continuation<? super InnerPushLocalStorage$updateInnerPushConfig$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InnerPushLocalStorage$updateInnerPushConfig$1(continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        SharedPreferences pref;
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putString;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                InnerPushConfig config = InnerPushServiceHelperKt.requestInnerPushConfig();
                if (config == null) {
                    return Unit.INSTANCE;
                }
                String configStr = new Gson().toJson(config);
                BLog.i("[InnerPush]InnerPushLocalStorage", "updateInnerPushConfig, config = " + configStr);
                if (configStr == null) {
                    return Unit.INSTANCE;
                }
                pref = InnerPushLocalStorageKt.getPref();
                if (pref != null && (edit = pref.edit()) != null && (putString = edit.putString(InnerPushLocalStorage.PREF_INNER_PUSH_CONFIG_KEY, configStr)) != null) {
                    putString.apply();
                }
                InnerPushLocalStorage innerPushLocalStorage = InnerPushLocalStorage.INSTANCE;
                InnerPushLocalStorage.pushConfig = config;
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}