package tv.danmaku.bili.login;

import android.app.Application;
import com.bilibili.base.BiliContext;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.login.LoginCheckState;
import tv.danmaku.bili.quick.core.OnePassLoginError;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OnePassLoginCheckViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.login.OnePassLoginCheckViewModel$load$2", f = "OnePassLoginCheckViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OnePassLoginCheckViewModel$load$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ OnePassLoginCheckViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnePassLoginCheckViewModel$load$2(OnePassLoginCheckViewModel onePassLoginCheckViewModel, Continuation<? super OnePassLoginCheckViewModel$load$2> continuation) {
        super(2, continuation);
        this.this$0 = onePassLoginCheckViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OnePassLoginCheckViewModel$load$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r6v1, types: [tv.danmaku.bili.login.OnePassLoginCheckViewModel$load$2$invokeSuspend$$inlined$parseJson$1] */
    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                Application application = BiliContext.application();
                File file = new File(application != null ? application.getCacheDir() : null, "OnePassLoginErrorManager.txt");
                FileInputStream fis = new FileInputStream(file);
                BufferedReader bufferReader = new BufferedReader(new InputStreamReader(fis));
                String text = TextStreamsKt.readText(bufferReader);
                List lines = StringsKt.split$default(text, new String[]{"\n"}, false, 0, 6, (Object) null);
                ArrayList list = new ArrayList();
                for (int i = lines.size() - 2; -1 < i; i--) {
                    Gson $this$parseJson$iv = com.bilibili.lib.gson.Gson.Companion.get();
                    String json$iv = (String) lines.get(i);
                    list.add($this$parseJson$iv.fromJson(json$iv, new TypeToken<OnePassLoginError>() { // from class: tv.danmaku.bili.login.OnePassLoginCheckViewModel$load$2$invokeSuspend$$inlined$parseJson$1
                    }.getType()));
                }
                mutableStateFlow = this.this$0._state;
                mutableStateFlow.setValue(new LoginCheckState.Loaded(list));
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}