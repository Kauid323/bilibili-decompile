package tv.danmaku.bili.ui.answer;

import android.content.Context;
import android.view.View;
import android.view.Window;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.quick.core.LoginSceneProcessor;
import tv.danmaku.bili.ui.answer.api.AnswerGuideData;
import tv.danmaku.bili.widget.BaseDialog;

/* compiled from: AnswerDialog.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0002R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Ltv/danmaku/bili/ui/answer/AnswerDialog;", "Ltv/danmaku/bili/widget/BaseDialog;", "context", "Landroid/content/Context;", "answerGuideData", "Ltv/danmaku/bili/ui/answer/api/AnswerGuideData;", "requestCode", "", LoginSceneProcessor.BIZ_KEY, "", "fromSpmid", "interceptInvitationEvent", "Lkotlin/Function0;", "", "extraParams", "", "<init>", "(Landroid/content/Context;Ltv/danmaku/bili/ui/answer/api/AnswerGuideData;ILjava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Ljava/util/Map;)V", "ui", "Ltv/danmaku/bili/ui/answer/AnswerDialogUI;", "onCreateView", "Landroid/view/View;", "setUiBeforeShow", "", "safelyDismiss", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AnswerDialog extends BaseDialog<AnswerDialog> {
    public static final int $stable = 8;
    private AnswerDialogUI ui;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnswerDialog(Context context, AnswerGuideData answerGuideData, int requestCode, String business, String fromSpmid, Function0<Boolean> function0, Map<String, String> map) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(answerGuideData, "answerGuideData");
        Intrinsics.checkNotNullParameter(business, LoginSceneProcessor.BIZ_KEY);
        Intrinsics.checkNotNullParameter(fromSpmid, "fromSpmid");
        Intrinsics.checkNotNullParameter(map, "extraParams");
        this.ui = answerGuideData.activityType == 1 ? new AnswerFreeDialog(context, answerGuideData, requestCode, business, fromSpmid, map, new Function0() { // from class: tv.danmaku.bili.ui.answer.AnswerDialog$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit _init_$lambda$0;
                _init_$lambda$0 = AnswerDialog._init_$lambda$0(AnswerDialog.this);
                return _init_$lambda$0;
            }
        }) : new AnswerRequiredDialog(context, answerGuideData, requestCode, business, fromSpmid, function0, map, new Function0() { // from class: tv.danmaku.bili.ui.answer.AnswerDialog$$ExternalSyntheticLambda1
            public final Object invoke() {
                Unit _init_$lambda$1;
                _init_$lambda$1 = AnswerDialog._init_$lambda$1(AnswerDialog.this);
                return _init_$lambda$1;
            }
        });
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ AnswerDialog(Context context, AnswerGuideData answerGuideData, int i, String str, String str2, Function0 function0, Map map, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, answerGuideData, i, str, str2, r7, r8);
        Function0 function02;
        Map map2;
        if ((i2 & 32) == 0) {
            function02 = function0;
        } else {
            function02 = null;
        }
        if ((i2 & 64) == 0) {
            map2 = map;
        } else {
            map2 = MapsKt.emptyMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(AnswerDialog this$0) {
        this$0.safelyDismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$1(AnswerDialog this$0) {
        this$0.safelyDismiss();
        return Unit.INSTANCE;
    }

    public View onCreateView() {
        View onCreateView = this.ui.onCreateView();
        Window window = getWindow();
        if (window != null) {
            window.setDimAmount(0.5f);
        }
        return onCreateView;
    }

    public void setUiBeforeShow() {
        setCanceledOnTouchOutside(true);
        widthScale(0.0f);
        this.ui.setUiBeforeShow();
    }

    private final void safelyDismiss() {
        try {
            dismiss();
        } catch (Exception e) {
            BLog.w("answer_dialog", e);
        }
    }
}