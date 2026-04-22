package kntr.app.live.room.multivideo.poll;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ILivePollConnection.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002BG\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u001c\u0010\t\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001b\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J$\u0010\u001e\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00020\nHÆ\u0003¢\u0006\u0002\u0010\u0017J\t\u0010\u001f\u001a\u00020\rHÆ\u0003J\\\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u001e\b\u0002\u0010\t\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020\r2\b\u0010#\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R)\u0010\t\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006'"}, d2 = {"Lkntr/app/live/room/multivideo/poll/LivePollParam;", "T", RoomRecommendViewModel.EMPTY_CURSOR, "bizName", RoomRecommendViewModel.EMPTY_CURSOR, "delay", RoomRecommendViewModel.EMPTY_CURSOR, "scope", "Lkotlinx/coroutines/CoroutineScope;", "fetcher", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "scatter", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;JLkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function1;Z)V", "getBizName", "()Ljava/lang/String;", "getDelay", "()J", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "getFetcher", "()Lkotlin/jvm/functions/Function1;", "Lkotlin/jvm/functions/Function1;", "getScatter", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;JLkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function1;Z)Lkntr/app/live/room/multivideo/poll/LivePollParam;", "equals", "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "multivideo_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LivePollParam<T> {
    private final String bizName;
    private final long delay;
    private final Function1<Continuation<? super T>, Object> fetcher;
    private final boolean scatter;
    private final CoroutineScope scope;

    public static /* synthetic */ LivePollParam copy$default(LivePollParam livePollParam, String str, long j2, CoroutineScope coroutineScope, Function1 function1, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = livePollParam.bizName;
        }
        if ((i & 2) != 0) {
            j2 = livePollParam.delay;
        }
        long j3 = j2;
        if ((i & 4) != 0) {
            coroutineScope = livePollParam.scope;
        }
        CoroutineScope coroutineScope2 = coroutineScope;
        Function1<Continuation<? super T>, Object> function12 = function1;
        if ((i & 8) != 0) {
            function12 = livePollParam.fetcher;
        }
        Function1 function13 = function12;
        if ((i & 16) != 0) {
            z = livePollParam.scatter;
        }
        return livePollParam.copy(str, j3, coroutineScope2, function13, z);
    }

    public final String component1() {
        return this.bizName;
    }

    public final long component2() {
        return this.delay;
    }

    public final CoroutineScope component3() {
        return this.scope;
    }

    public final Function1<Continuation<? super T>, Object> component4() {
        return this.fetcher;
    }

    public final boolean component5() {
        return this.scatter;
    }

    public final LivePollParam<T> copy(String str, long j2, CoroutineScope coroutineScope, Function1<? super Continuation<? super T>, ? extends Object> function1, boolean z) {
        Intrinsics.checkNotNullParameter(str, "bizName");
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        Intrinsics.checkNotNullParameter(function1, "fetcher");
        return new LivePollParam<>(str, j2, coroutineScope, function1, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LivePollParam) {
            LivePollParam livePollParam = (LivePollParam) obj;
            return Intrinsics.areEqual(this.bizName, livePollParam.bizName) && this.delay == livePollParam.delay && Intrinsics.areEqual(this.scope, livePollParam.scope) && Intrinsics.areEqual(this.fetcher, livePollParam.fetcher) && this.scatter == livePollParam.scatter;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.bizName.hashCode() * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.delay)) * 31) + this.scope.hashCode()) * 31) + this.fetcher.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.scatter);
    }

    public String toString() {
        String str = this.bizName;
        long j2 = this.delay;
        CoroutineScope coroutineScope = this.scope;
        Function1<Continuation<? super T>, Object> function1 = this.fetcher;
        return "LivePollParam(bizName=" + str + ", delay=" + j2 + ", scope=" + coroutineScope + ", fetcher=" + function1 + ", scatter=" + this.scatter + ")";
    }

    public LivePollParam(String bizName, long delay, CoroutineScope scope, Function1<? super Continuation<? super T>, ? extends Object> function1, boolean scatter) {
        Intrinsics.checkNotNullParameter(bizName, "bizName");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(function1, "fetcher");
        this.bizName = bizName;
        this.delay = delay;
        this.scope = scope;
        this.fetcher = function1;
        this.scatter = scatter;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ LivePollParam(String str, long j2, CoroutineScope coroutineScope, Function1 function1, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j2, coroutineScope, function1, r6);
        boolean z2;
        if ((i & 16) == 0) {
            z2 = z;
        } else {
            z2 = true;
        }
    }

    public final String getBizName() {
        return this.bizName;
    }

    public final long getDelay() {
        return this.delay;
    }

    public final CoroutineScope getScope() {
        return this.scope;
    }

    public final Function1<Continuation<? super T>, Object> getFetcher() {
        return this.fetcher;
    }

    public final boolean getScatter() {
        return this.scatter;
    }
}