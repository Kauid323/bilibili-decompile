package tv.danmaku.bili.ui.answer;

import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.neuron.api.Neurons;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.databinding.BiliAppDialogAnswerFreeBinding;
import tv.danmaku.bili.quick.core.LoginSceneProcessor;
import tv.danmaku.bili.ui.answer.api.AnswerGuideData;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;

/* compiled from: AnswerFreeDialog.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cBS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u000fH\u0016J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Ltv/danmaku/bili/ui/answer/AnswerFreeDialog;", "Ltv/danmaku/bili/ui/answer/AnswerDialogUI;", "context", "Landroid/content/Context;", "answerGuideData", "Ltv/danmaku/bili/ui/answer/api/AnswerGuideData;", "requestCode", "", LoginSceneProcessor.BIZ_KEY, "", "fromSpmid", "extraParams", "", "dismiss", "Lkotlin/Function0;", "", "<init>", "(Landroid/content/Context;Ltv/danmaku/bili/ui/answer/api/AnswerGuideData;ILjava/lang/String;Ljava/lang/String;Ljava/util/Map;Lkotlin/jvm/functions/Function0;)V", "getBusiness", "()Ljava/lang/String;", "getFromSpmid", "mBinding", "Ltv/danmaku/bili/databinding/BiliAppDialogAnswerFreeBinding;", "onCreateView", "Landroid/view/View;", "setUiBeforeShow", "reportClick", "position", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AnswerFreeDialog implements AnswerDialogUI {
    private static final String ANSWER_URL = "https://www.bilibili.com/h5/newbie/entry?navhide=1";
    private final AnswerGuideData answerGuideData;
    private final String business;
    private final Context context;
    private final Function0<Unit> dismiss;
    private final Map<String, String> extraParams;
    private final String fromSpmid;
    private BiliAppDialogAnswerFreeBinding mBinding;
    private final int requestCode;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public AnswerFreeDialog(Context context, AnswerGuideData answerGuideData, int requestCode, String business, String fromSpmid, Map<String, String> map, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(answerGuideData, "answerGuideData");
        Intrinsics.checkNotNullParameter(business, LoginSceneProcessor.BIZ_KEY);
        Intrinsics.checkNotNullParameter(fromSpmid, "fromSpmid");
        Intrinsics.checkNotNullParameter(map, "extraParams");
        Intrinsics.checkNotNullParameter(function0, "dismiss");
        this.context = context;
        this.answerGuideData = answerGuideData;
        this.requestCode = requestCode;
        this.business = business;
        this.fromSpmid = fromSpmid;
        this.extraParams = map;
        this.dismiss = function0;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ AnswerFreeDialog(Context context, AnswerGuideData answerGuideData, int i, String str, String str2, Map map, Function0 function0, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, answerGuideData, i, str, str2, r7, function0);
        Map map2;
        if ((i2 & 32) == 0) {
            map2 = map;
        } else {
            map2 = MapsKt.emptyMap();
        }
    }

    public final String getBusiness() {
        return this.business;
    }

    public final String getFromSpmid() {
        return this.fromSpmid;
    }

    @Override // tv.danmaku.bili.ui.answer.AnswerDialogUI
    public View onCreateView() {
        View view = LayoutInflater.from(this.context).inflate(R.layout.bili_app_dialog_answer_free, (ViewGroup) null);
        this.mBinding = BiliAppDialogAnswerFreeBinding.bind(view);
        Intrinsics.checkNotNull(view);
        return view;
    }

    @Override // tv.danmaku.bili.ui.answer.AnswerDialogUI
    public void setUiBeforeShow() {
        Context resourceContext;
        BiliAppDialogAnswerFreeBinding $this$setUiBeforeShow_u24lambda_u240 = this.mBinding;
        if ($this$setUiBeforeShow_u24lambda_u240 == null) {
            return;
        }
        if (this.answerGuideData.forceNight) {
            Context context = this.context;
            Configuration $this$setUiBeforeShow_u24lambda_u240_u240 = new Configuration(this.context.getResources().getConfiguration());
            $this$setUiBeforeShow_u24lambda_u240_u240.uiMode &= -49;
            $this$setUiBeforeShow_u24lambda_u240_u240.uiMode |= 32;
            resourceContext = context.createConfigurationContext($this$setUiBeforeShow_u24lambda_u240_u240);
        } else {
            resourceContext = this.context;
        }
        $this$setUiBeforeShow_u24lambda_u240.vContainer.setBackground(ContextCompat.getDrawable(resourceContext, R.drawable.bg_dialog_answer));
        $this$setUiBeforeShow_u24lambda_u240.title.setImageDrawable(AppCompatResources.getDrawable(resourceContext, R.drawable.bg_status_notify_alert));
        $this$setUiBeforeShow_u24lambda_u240.content.setTextColor(ContextCompat.getColor(resourceContext, com.bilibili.lib.theme.R.color.Text1));
        TextView textView = $this$setUiBeforeShow_u24lambda_u240.content;
        AnswerGuideData.ActivityMaterial activityMaterial = this.answerGuideData.activityMaterial;
        textView.setText(activityMaterial != null ? activityMaterial.title : null);
        $this$setUiBeforeShow_u24lambda_u240.btnConfirm.setTextColor(ContextCompat.getColor(resourceContext, com.bilibili.lib.theme.R.color.Text_white));
        $this$setUiBeforeShow_u24lambda_u240.btnConfirm.setBackground(ContextCompat.getDrawable(resourceContext, tv.danmaku.biliplayer.baseres.R.drawable.shape_rect_solid_pink_20dp));
        TextView textView2 = $this$setUiBeforeShow_u24lambda_u240.btnConfirm;
        AnswerGuideData.ActivityMaterial activityMaterial2 = this.answerGuideData.activityMaterial;
        textView2.setText(activityMaterial2 != null ? activityMaterial2.button1 : null);
        $this$setUiBeforeShow_u24lambda_u240.btnCancel.setTextColor(ContextCompat.getColor(resourceContext, com.bilibili.lib.theme.R.color.Text2));
        $this$setUiBeforeShow_u24lambda_u240.btnCancel.setBackground(ContextCompat.getDrawable(resourceContext, R.drawable.shape_rect_stroke_line_bold_17dp));
        TextView textView3 = $this$setUiBeforeShow_u24lambda_u240.btnCancel;
        AnswerGuideData.ActivityMaterial activityMaterial3 = this.answerGuideData.activityMaterial;
        textView3.setText(activityMaterial3 != null ? activityMaterial3.button2 : null);
        $this$setUiBeforeShow_u24lambda_u240.btnConfirm.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.answer.AnswerFreeDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnswerFreeDialog.setUiBeforeShow$lambda$0$1(AnswerFreeDialog.this, view);
            }
        });
        $this$setUiBeforeShow_u24lambda_u240.btnCancel.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.answer.AnswerFreeDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnswerFreeDialog.setUiBeforeShow$lambda$0$2(AnswerFreeDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUiBeforeShow$lambda$0$1(AnswerFreeDialog this$0, View it) {
        this$0.reportClick("4");
        AnswerGuideData.ActivityMaterial activityMaterial = this$0.answerGuideData.activityMaterial;
        String str = activityMaterial != null ? activityMaterial.url : null;
        if (str == null) {
            str = "";
        }
        BLRouter.routeTo(new RouteRequest.Builder(str).requestCode(this$0.requestCode).build(), this$0.context);
        this$0.dismiss.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUiBeforeShow$lambda$0$2(AnswerFreeDialog this$0, View it) {
        this$0.reportClick("2");
        this$0.dismiss.invoke();
    }

    private final void reportClick(String position) {
        Map $this$filterKeys$iv = this.extraParams;
        LinkedHashMap result$iv = new LinkedHashMap();
        for (Map.Entry entry$iv : $this$filterKeys$iv.entrySet()) {
            String it = entry$iv.getKey();
            if (!StringsKt.isBlank(it)) {
                result$iv.put(entry$iv.getKey(), entry$iv.getValue());
            }
        }
        LinkedHashMap $this$filterKeys$iv2 = result$iv;
        HashMap extension = new HashMap($this$filterKeys$iv2);
        if (Intrinsics.areEqual(this.business, "yinsitanchuang")) {
            extension.put("ug_test", "privacy_pop_7");
        } else {
            extension.put("re_src", this.business);
        }
        extension.put(FavoritesConstsKt.POS, position);
        extension.put(FavoritesConstsKt.SPMID, this.fromSpmid);
        extension.put("pop_type", AudioIntentHelper.FROM_ACTIVITY);
        Neurons.reportClick(false, "community.public-community.answer-in.all.click", extension);
    }

    /* compiled from: AnswerFreeDialog.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/ui/answer/AnswerFreeDialog$Companion;", "", "<init>", "()V", "ANSWER_URL", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}