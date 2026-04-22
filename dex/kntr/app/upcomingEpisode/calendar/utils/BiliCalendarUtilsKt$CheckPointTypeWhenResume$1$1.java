package kntr.app.upcomingEpisode.calendar.utils;

import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.RepeatOnLifecycleKt;
import com.bapis.bilibili.community.interfacess.watch.v1.KCalendarPointType;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upcomingEpisode.list.model.CalendarCard;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.datetime.LocalDate;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BiliCalendarUtils.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.upcomingEpisode.calendar.utils.BiliCalendarUtilsKt$CheckPointTypeWhenResume$1$1", f = "BiliCalendarUtils.kt", i = {}, l = {196}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class BiliCalendarUtilsKt$CheckPointTypeWhenResume$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SnapshotStateMap<LocalDate, SnapshotStateList<CalendarCard>> $cardListMap;
    final /* synthetic */ LifecycleOwner $lifecycle;
    final /* synthetic */ SnapshotStateMap<LocalDate, KCalendarPointType> $pointTypeMap;
    final /* synthetic */ LocalDate $selection;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BiliCalendarUtilsKt$CheckPointTypeWhenResume$1$1(LifecycleOwner lifecycleOwner, LocalDate localDate, SnapshotStateMap<LocalDate, KCalendarPointType> snapshotStateMap, SnapshotStateMap<LocalDate, SnapshotStateList<CalendarCard>> snapshotStateMap2, Continuation<? super BiliCalendarUtilsKt$CheckPointTypeWhenResume$1$1> continuation) {
        super(2, continuation);
        this.$lifecycle = lifecycleOwner;
        this.$selection = localDate;
        this.$pointTypeMap = snapshotStateMap;
        this.$cardListMap = snapshotStateMap2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BiliCalendarUtilsKt$CheckPointTypeWhenResume$1$1(this.$lifecycle, this.$selection, this.$pointTypeMap, this.$cardListMap, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BiliCalendarUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @DebugMetadata(c = "kntr.app.upcomingEpisode.calendar.utils.BiliCalendarUtilsKt$CheckPointTypeWhenResume$1$1$1", f = "BiliCalendarUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: kntr.app.upcomingEpisode.calendar.utils.BiliCalendarUtilsKt$CheckPointTypeWhenResume$1$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SnapshotStateMap<LocalDate, SnapshotStateList<CalendarCard>> $cardListMap;
        final /* synthetic */ SnapshotStateMap<LocalDate, KCalendarPointType> $pointTypeMap;
        final /* synthetic */ LocalDate $selection;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(LocalDate localDate, SnapshotStateMap<LocalDate, KCalendarPointType> snapshotStateMap, SnapshotStateMap<LocalDate, SnapshotStateList<CalendarCard>> snapshotStateMap2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$selection = localDate;
            this.$pointTypeMap = snapshotStateMap;
            this.$cardListMap = snapshotStateMap2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$selection, this.$pointTypeMap, this.$cardListMap, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    BiliCalendarUtilsKt.checkPointType(this.$selection, this.$pointTypeMap, this.$cardListMap);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(this.$lifecycle, Lifecycle.State.RESUMED, new AnonymousClass1(this.$selection, this.$pointTypeMap, this.$cardListMap, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}