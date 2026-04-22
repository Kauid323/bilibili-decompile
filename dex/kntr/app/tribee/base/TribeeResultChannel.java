package kntr.app.tribee.base;

import java.util.LinkedHashMap;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.SendChannel;

/* compiled from: TribeeResultChannel.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\bH\u0007J\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006J\u0018\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\u0006H\u0087@¢\u0006\u0002\u0010\u0011R\"\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkntr/app/tribee/base/TribeeResultChannel;", "", "<init>", "()V", "channelMap", "", "", "Lkotlinx/coroutines/channels/Channel;", "Lkntr/app/tribee/base/TribeeResultContent;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "setResult", "", "resultKey", "result", "prepareChannel", "awaitResult", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeResultChannel {
    public static final TribeeResultChannel INSTANCE = new TribeeResultChannel();
    private static final Map<String, Channel<TribeeResultContent>> channelMap = new LinkedHashMap();
    private static final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));

    private TribeeResultChannel() {
    }

    public final void setResult(String resultKey, TribeeResultContent result) {
        Intrinsics.checkNotNullParameter(resultKey, "resultKey");
        KLog_androidKt.getKLog().i("TribeeResultChannel", "Setting result channel of " + resultKey + ", has value " + (result != null));
        Channel channel = channelMap.get(resultKey);
        if (channel != null) {
            BuildersKt.launch$default(scope, (CoroutineContext) null, (CoroutineStart) null, new TribeeResultChannel$setResult$1(channel, result, null), 3, (Object) null);
        }
    }

    public final void prepareChannel(String resultKey) {
        Intrinsics.checkNotNullParameter(resultKey, "resultKey");
        KLog_androidKt.getKLog().i("TribeeResultChannel", "Preparing result channel of " + resultKey);
        channelMap.put(resultKey, ChannelKt.Channel$default(1, BufferOverflow.SUSPEND, (Function1) null, 4, (Object) null));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object awaitResult(String resultKey, Continuation<? super TribeeResultContent> continuation) {
        TribeeResultChannel$awaitResult$1 tribeeResultChannel$awaitResult$1;
        Object receive;
        SendChannel sendChannel;
        TribeeResultContent tribeeResultContent;
        if (continuation instanceof TribeeResultChannel$awaitResult$1) {
            tribeeResultChannel$awaitResult$1 = (TribeeResultChannel$awaitResult$1) continuation;
            if ((tribeeResultChannel$awaitResult$1.label & Integer.MIN_VALUE) != 0) {
                tribeeResultChannel$awaitResult$1.label -= Integer.MIN_VALUE;
                Object $result = tribeeResultChannel$awaitResult$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (tribeeResultChannel$awaitResult$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        KLog_androidKt.getKLog().i("TribeeResultChannel", "Awaiting result channel of " + resultKey);
                        SendChannel sendChannel2 = (Channel) channelMap.get(resultKey);
                        if (sendChannel2 != null) {
                            tribeeResultChannel$awaitResult$1.L$0 = resultKey;
                            tribeeResultChannel$awaitResult$1.L$1 = sendChannel2;
                            tribeeResultChannel$awaitResult$1.label = 1;
                            receive = sendChannel2.receive(tribeeResultChannel$awaitResult$1);
                            if (receive == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            sendChannel = sendChannel2;
                            tribeeResultContent = (TribeeResultContent) receive;
                            if (tribeeResultContent == null) {
                                KLog_androidKt.getKLog().i("TribeeResultChannel", "Received result channel of " + resultKey);
                                SendChannel.DefaultImpls.close$default(sendChannel, (Throwable) null, 1, (Object) null);
                                channelMap.remove(resultKey);
                                return tribeeResultContent;
                            }
                            sendChannel2 = sendChannel;
                        }
                        return null;
                    case 1:
                        sendChannel = (Channel) tribeeResultChannel$awaitResult$1.L$1;
                        resultKey = (String) tribeeResultChannel$awaitResult$1.L$0;
                        ResultKt.throwOnFailure($result);
                        receive = $result;
                        tribeeResultContent = (TribeeResultContent) receive;
                        if (tribeeResultContent == null) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        tribeeResultChannel$awaitResult$1 = new TribeeResultChannel$awaitResult$1(this, continuation);
        Object $result2 = tribeeResultChannel$awaitResult$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (tribeeResultChannel$awaitResult$1.label) {
        }
    }
}