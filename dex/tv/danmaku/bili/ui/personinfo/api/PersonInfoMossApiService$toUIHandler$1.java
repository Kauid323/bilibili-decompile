package tv.danmaku.bili.ui.personinfo.api;

import com.bilibili.base.MainThread;
import com.bilibili.lib.moss.api.MossException;
import com.bilibili.lib.moss.api.MossResponseHandler;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: PersonInfoMossApiService.kt */
@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u0005J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016¨\u0006\n"}, d2 = {"tv/danmaku/bili/ui/personinfo/api/PersonInfoMossApiService$toUIHandler$1", "Lcom/bilibili/lib/moss/api/MossResponseHandler;", "onNext", "", "value", "(Ljava/lang/Object;)V", "onError", "t", "Lcom/bilibili/lib/moss/api/MossException;", "onCompleted", "personinfo_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PersonInfoMossApiService$toUIHandler$1<T> implements MossResponseHandler<T> {
    final /* synthetic */ MossResponseHandler<T> $that;

    public /* synthetic */ void onHeaders(Map map) {
        MossResponseHandler.-CC.$default$onHeaders(this, map);
    }

    public /* synthetic */ long onNextForAck(Object obj) {
        return MossResponseHandler.-CC.$default$onNextForAck(this, obj);
    }

    public /* synthetic */ void onUpstreamAck(Long l) {
        MossResponseHandler.-CC.$default$onUpstreamAck(this, l);
    }

    public /* synthetic */ void onValid() {
        MossResponseHandler.-CC.$default$onValid(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PersonInfoMossApiService$toUIHandler$1(MossResponseHandler<T> mossResponseHandler) {
        this.$that = mossResponseHandler;
    }

    public void onNext(final T t) {
        final MossResponseHandler<T> mossResponseHandler = this.$that;
        MainThread.runOnMainThread(new Function0() { // from class: tv.danmaku.bili.ui.personinfo.api.PersonInfoMossApiService$toUIHandler$1$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit onNext$lambda$0;
                onNext$lambda$0 = PersonInfoMossApiService$toUIHandler$1.onNext$lambda$0(mossResponseHandler, t);
                return onNext$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onNext$lambda$0(MossResponseHandler $that, Object $value) {
        $that.onNext($value);
        return Unit.INSTANCE;
    }

    public void onError(final MossException t) {
        final MossResponseHandler<T> mossResponseHandler = this.$that;
        MainThread.runOnMainThread(new Function0() { // from class: tv.danmaku.bili.ui.personinfo.api.PersonInfoMossApiService$toUIHandler$1$$ExternalSyntheticLambda1
            public final Object invoke() {
                Unit onError$lambda$1;
                onError$lambda$1 = PersonInfoMossApiService$toUIHandler$1.onError$lambda$1(mossResponseHandler, t);
                return onError$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onError$lambda$1(MossResponseHandler $that, MossException $t) {
        $that.onError($t);
        return Unit.INSTANCE;
    }

    public void onCompleted() {
        final MossResponseHandler<T> mossResponseHandler = this.$that;
        MainThread.runOnMainThread(new Function0() { // from class: tv.danmaku.bili.ui.personinfo.api.PersonInfoMossApiService$toUIHandler$1$$ExternalSyntheticLambda2
            public final Object invoke() {
                Unit onCompleted$lambda$2;
                onCompleted$lambda$2 = PersonInfoMossApiService$toUIHandler$1.onCompleted$lambda$2(mossResponseHandler);
                return onCompleted$lambda$2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCompleted$lambda$2(MossResponseHandler $that) {
        $that.onCompleted();
        return Unit.INSTANCE;
    }
}