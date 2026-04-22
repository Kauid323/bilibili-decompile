package kntr.app.game.steam.chart;

import androidx.compose.runtime.MutableState;
import java.util.List;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.time.TimeSource;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BarChart.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.game.steam.chart.BarChartKt$BarChart$3$1", f = "BarChart.kt", i = {}, l = {92}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class BarChartKt$BarChart$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $isUpdating;
    final /* synthetic */ MutableState<TimeSource.Monotonic.ValueTimeMark> $lastUpdateMark;
    final /* synthetic */ MutableState<List<BarData>> $pendingData;
    final /* synthetic */ MutableState<List<BarData>> $stableData;
    final /* synthetic */ TimeSource.Monotonic $timeSource;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BarChartKt$BarChart$3$1(MutableState<List<BarData>> mutableState, MutableState<List<BarData>> mutableState2, MutableState<Boolean> mutableState3, MutableState<TimeSource.Monotonic.ValueTimeMark> mutableState4, TimeSource.Monotonic monotonic, Continuation<? super BarChartKt$BarChart$3$1> continuation) {
        super(2, continuation);
        this.$pendingData = mutableState;
        this.$stableData = mutableState2;
        this.$isUpdating = mutableState3;
        this.$lastUpdateMark = mutableState4;
        this.$timeSource = monotonic;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BarChartKt$BarChart$3$1(this.$pendingData, this.$stableData, this.$isUpdating, this.$lastUpdateMark, this.$timeSource, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
        */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0034  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x0027 -> B:11:0x002a). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 1
            switch(r1) {
                case 0: goto L17;
                case 1: goto L12;
                default: goto La;
            }
        La:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L12:
            kotlin.ResultKt.throwOnFailure(r8)
            r1 = r7
            goto L2a
        L17:
            kotlin.ResultKt.throwOnFailure(r8)
            r1 = r7
        L1b:
            r3 = r1
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r1.label = r2
            r4 = 500(0x1f4, double:2.47E-321)
            java.lang.Object r3 = kotlinx.coroutines.DelayKt.delay(r4, r3)
            if (r3 != r0) goto L2a
            return r0
        L2a:
            androidx.compose.runtime.MutableState<java.util.List<kntr.app.game.steam.chart.BarData>> r3 = r1.$pendingData
            java.lang.Object r3 = r3.getValue()
            java.util.List r3 = (java.util.List) r3
            if (r3 == 0) goto L1b
            androidx.compose.runtime.MutableState<java.util.List<kntr.app.game.steam.chart.BarData>> r4 = r1.$stableData
            java.lang.Object r4 = r4.getValue()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r4)
            if (r4 != 0) goto L1b
            androidx.compose.runtime.MutableState<java.lang.Boolean> r4 = r1.$isUpdating
            java.lang.Object r4 = r4.getValue()
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 != 0) goto L1b
            androidx.compose.runtime.MutableState<java.lang.Boolean> r4 = r1.$isUpdating
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            r4.setValue(r5)
            androidx.compose.runtime.MutableState<java.util.List<kntr.app.game.steam.chart.BarData>> r4 = r1.$stableData
            r4.setValue(r3)
            androidx.compose.runtime.MutableState<java.util.List<kntr.app.game.steam.chart.BarData>> r4 = r1.$pendingData
            r5 = 0
            r4.setValue(r5)
            androidx.compose.runtime.MutableState<kotlin.time.TimeSource$Monotonic$ValueTimeMark> r4 = r1.$lastUpdateMark
            kotlin.time.TimeSource$Monotonic r5 = r1.$timeSource
            long r5 = r5.markNow-z9LOYto()
            kotlin.time.TimeSource$Monotonic$ValueTimeMark r5 = kotlin.time.TimeSource.Monotonic.ValueTimeMark.box-impl(r5)
            r4.setValue(r5)
            androidx.compose.runtime.MutableState<java.lang.Boolean> r4 = r1.$isUpdating
            r5 = 0
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            r4.setValue(r5)
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: kntr.app.game.steam.chart.BarChartKt$BarChart$3$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}