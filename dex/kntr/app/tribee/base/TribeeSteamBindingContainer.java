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

/* compiled from: TribeeSteamBindingContainer.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0007J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0007J\b\u0010\u000f\u001a\u00020\fH\u0007J\b\u0010\u0010\u001a\u00020\fH\u0007J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0006H\u0002J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\bH\u0087@¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\bH\u0087@¢\u0006\u0002\u0010\u0014J\u0018\u0010\u0016\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0012\u001a\u00020\u0006H\u0083@¢\u0006\u0002\u0010\u0017R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lkntr/app/tribee/base/TribeeSteamBindingContainer;", "", "<init>", "()V", "channelMap", "", "", "Lkotlinx/coroutines/channels/Channel;", "Lkntr/app/tribee/base/TribeeSteamBindingState;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "put", "", "state", "putSteamUnbindResult", "prepareSteamChannel", "prepareHomeChannel", "prepareChannel", "id", "awaitSteamResult", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitHomeResult", "awaitResult", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeSteamBindingContainer {
    public static final TribeeSteamBindingContainer INSTANCE = new TribeeSteamBindingContainer();
    private static final Map<String, Channel<TribeeSteamBindingState>> channelMap = new LinkedHashMap();
    private static final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));

    private TribeeSteamBindingContainer() {
    }

    public final void put(TribeeSteamBindingState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        Channel steamChannel = channelMap.get("tribee_steam_page");
        Channel homeChannel = channelMap.get("tribee_home_page");
        if (steamChannel != null) {
            BuildersKt.launch$default(scope, (CoroutineContext) null, (CoroutineStart) null, new TribeeSteamBindingContainer$put$1(steamChannel, state, null), 3, (Object) null);
        }
        if (homeChannel != null) {
            BuildersKt.launch$default(scope, (CoroutineContext) null, (CoroutineStart) null, new TribeeSteamBindingContainer$put$2(homeChannel, state, null), 3, (Object) null);
        }
    }

    public final void putSteamUnbindResult(TribeeSteamBindingState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        KLog_androidKt.getKLog().i("TribeeSteamBindingContainer", "Putting steam unbind result: " + state);
        Channel homeChannel = channelMap.get("tribee_home_page");
        if (homeChannel != null) {
            BuildersKt.launch$default(scope, (CoroutineContext) null, (CoroutineStart) null, new TribeeSteamBindingContainer$putSteamUnbindResult$1(homeChannel, state, null), 3, (Object) null);
        }
    }

    public final void prepareSteamChannel() {
        prepareChannel("tribee_steam_page");
    }

    public final void prepareHomeChannel() {
        prepareChannel("tribee_home_page");
    }

    private final void prepareChannel(String id) {
        KLog_androidKt.getKLog().i("TribeeSteamBindingContainer", "Preparing result channel for " + id);
        channelMap.put(id, ChannelKt.Channel$default(1, BufferOverflow.SUSPEND, (Function1) null, 4, (Object) null));
    }

    public final Object awaitSteamResult(Continuation<? super TribeeSteamBindingState> continuation) {
        return awaitResult("tribee_steam_page", continuation);
    }

    public final Object awaitHomeResult(Continuation<? super TribeeSteamBindingState> continuation) {
        return awaitResult("tribee_home_page", continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object awaitResult(String id, Continuation<? super TribeeSteamBindingState> continuation) {
        TribeeSteamBindingContainer$awaitResult$1 tribeeSteamBindingContainer$awaitResult$1;
        Object receive;
        Channel channel;
        if (continuation instanceof TribeeSteamBindingContainer$awaitResult$1) {
            tribeeSteamBindingContainer$awaitResult$1 = (TribeeSteamBindingContainer$awaitResult$1) continuation;
            if ((tribeeSteamBindingContainer$awaitResult$1.label & Integer.MIN_VALUE) != 0) {
                tribeeSteamBindingContainer$awaitResult$1.label -= Integer.MIN_VALUE;
                Object $result = tribeeSteamBindingContainer$awaitResult$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (tribeeSteamBindingContainer$awaitResult$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        KLog_androidKt.getKLog().i("TribeeSteamBindingContainer", "Awaiting steam binding result for " + id);
                        Channel channel2 = channelMap.get(id);
                        if (channel2 != null) {
                            tribeeSteamBindingContainer$awaitResult$1.L$0 = id;
                            tribeeSteamBindingContainer$awaitResult$1.L$1 = channel2;
                            tribeeSteamBindingContainer$awaitResult$1.label = 1;
                            receive = channel2.receive(tribeeSteamBindingContainer$awaitResult$1);
                            if (receive == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            channel = channel2;
                            break;
                        } else {
                            return null;
                        }
                    case 1:
                        channel = (Channel) tribeeSteamBindingContainer$awaitResult$1.L$1;
                        id = (String) tribeeSteamBindingContainer$awaitResult$1.L$0;
                        ResultKt.throwOnFailure($result);
                        receive = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                TribeeSteamBindingState it = (TribeeSteamBindingState) receive;
                SendChannel.DefaultImpls.close$default((SendChannel) channel, (Throwable) null, 1, (Object) null);
                channelMap.remove(id);
                KLog_androidKt.getKLog().i("TribeeSteamBindingContainer", "Received steam binding result for " + id + ": " + it);
                return receive;
            }
        }
        tribeeSteamBindingContainer$awaitResult$1 = new TribeeSteamBindingContainer$awaitResult$1(this, continuation);
        Object $result2 = tribeeSteamBindingContainer$awaitResult$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (tribeeSteamBindingContainer$awaitResult$1.label) {
        }
        TribeeSteamBindingState it2 = (TribeeSteamBindingState) receive;
        SendChannel.DefaultImpls.close$default((SendChannel) channel, (Throwable) null, 1, (Object) null);
        channelMap.remove(id);
        KLog_androidKt.getKLog().i("TribeeSteamBindingContainer", "Received steam binding result for " + id + ": " + it2);
        return receive;
    }
}