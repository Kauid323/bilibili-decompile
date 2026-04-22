package kntr.app.appwidget.guide.ui;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import java.util.List;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* compiled from: AppWidgetGuidePopupState.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\\\u0010\r\u001a\u00020\u000e2\u0010\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0017H\u0080@¢\u0006\u0004\b\u001c\u0010\u001dR/\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00058F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u001e"}, d2 = {"Lkntr/app/appwidget/guide/ui/AppWidgetGuidePopupState;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "<set-?>", "Lkntr/app/appwidget/guide/ui/PopupData;", "currentPopupData", "getCurrentPopupData", "()Lkntr/app/appwidget/guide/ui/PopupData;", "setCurrentPopupData", "(Lkntr/app/appwidget/guide/ui/PopupData;)V", "currentPopupData$delegate", "Landroidx/compose/runtime/MutableState;", "showPopup", "Lkntr/app/appwidget/guide/ui/PopupResult;", "avatar", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "title", "subtitle", "forceDark", RoomRecommendViewModel.EMPTY_CURSOR, "offset", RoomRecommendViewModel.EMPTY_CURSOR, "duration", RoomRecommendViewModel.EMPTY_CURSOR, "outsideTouchable", "style", "showPopup$guide_debug", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ZIJZILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "guide_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AppWidgetGuidePopupState {
    public static final int $stable = 0;
    private final MutableState currentPopupData$delegate = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCurrentPopupData(PopupData popupData) {
        MutableState $this$setValue$iv = this.currentPopupData$delegate;
        $this$setValue$iv.setValue(popupData);
    }

    public final PopupData getCurrentPopupData() {
        State $this$getValue$iv = this.currentPopupData$delegate;
        return (PopupData) $this$getValue$iv.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object showPopup$guide_debug(List<String> list, String title, String subtitle, boolean forceDark, int offset, long duration, boolean outsideTouchable, int style, Continuation<? super PopupResult> continuation) {
        AppWidgetGuidePopupState$showPopup$1 appWidgetGuidePopupState$showPopup$1;
        AppWidgetGuidePopupState$showPopup$1 appWidgetGuidePopupState$showPopup$12;
        if (continuation instanceof AppWidgetGuidePopupState$showPopup$1) {
            appWidgetGuidePopupState$showPopup$1 = (AppWidgetGuidePopupState$showPopup$1) continuation;
            if ((appWidgetGuidePopupState$showPopup$1.label & Integer.MIN_VALUE) != 0) {
                appWidgetGuidePopupState$showPopup$1.label -= Integer.MIN_VALUE;
                appWidgetGuidePopupState$showPopup$12 = appWidgetGuidePopupState$showPopup$1;
                Object $result = appWidgetGuidePopupState$showPopup$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (appWidgetGuidePopupState$showPopup$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        try {
                            appWidgetGuidePopupState$showPopup$12.L$0 = list;
                            appWidgetGuidePopupState$showPopup$12.L$1 = title;
                            appWidgetGuidePopupState$showPopup$12.L$2 = subtitle;
                            appWidgetGuidePopupState$showPopup$12.Z$0 = forceDark;
                            appWidgetGuidePopupState$showPopup$12.I$0 = offset;
                            appWidgetGuidePopupState$showPopup$12.J$0 = duration;
                            appWidgetGuidePopupState$showPopup$12.Z$1 = outsideTouchable;
                            appWidgetGuidePopupState$showPopup$12.I$1 = style;
                            appWidgetGuidePopupState$showPopup$12.I$2 = 0;
                            appWidgetGuidePopupState$showPopup$12.label = 1;
                            Continuation uCont$iv = (Continuation) appWidgetGuidePopupState$showPopup$12;
                            boolean z = true;
                            try {
                                CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(uCont$iv), 1);
                                cancellableContinuationImpl.initCancellability();
                                CancellableContinuation continuation2 = cancellableContinuationImpl;
                                if (!outsideTouchable) {
                                    z = false;
                                }
                                setCurrentPopupData(new PopupDataImpl(list, title, subtitle, forceDark, offset, duration, style, z, continuation2));
                                $result = cancellableContinuationImpl.getResult();
                                if ($result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                    DebugProbesKt.probeCoroutineSuspended((Continuation) appWidgetGuidePopupState$showPopup$12);
                                }
                                if ($result == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                try {
                                    PopupResult popupResult = (PopupResult) $result;
                                    setCurrentPopupData(null);
                                    return popupResult;
                                } catch (Throwable th) {
                                    th = th;
                                    setCurrentPopupData(null);
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                setCurrentPopupData(null);
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    case 1:
                        int i = appWidgetGuidePopupState$showPopup$12.I$2;
                        int i2 = appWidgetGuidePopupState$showPopup$12.I$1;
                        boolean z2 = appWidgetGuidePopupState$showPopup$12.Z$1;
                        long j2 = appWidgetGuidePopupState$showPopup$12.J$0;
                        int i3 = appWidgetGuidePopupState$showPopup$12.I$0;
                        boolean z3 = appWidgetGuidePopupState$showPopup$12.Z$0;
                        String str = (String) appWidgetGuidePopupState$showPopup$12.L$2;
                        String str2 = (String) appWidgetGuidePopupState$showPopup$12.L$1;
                        List list2 = (List) appWidgetGuidePopupState$showPopup$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            PopupResult popupResult2 = (PopupResult) $result;
                            setCurrentPopupData(null);
                            return popupResult2;
                        } catch (Throwable th4) {
                            th = th4;
                            setCurrentPopupData(null);
                            throw th;
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        appWidgetGuidePopupState$showPopup$1 = new AppWidgetGuidePopupState$showPopup$1(this, continuation);
        appWidgetGuidePopupState$showPopup$12 = appWidgetGuidePopupState$showPopup$1;
        Object $result2 = appWidgetGuidePopupState$showPopup$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (appWidgetGuidePopupState$showPopup$12.label) {
        }
    }
}