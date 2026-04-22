package tv.danmaku.bili.ui.answer;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.base.util.ContextUtilKt;
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
import tv.danmaku.bili.databinding.BiliAppDialogAnswerBinding;
import tv.danmaku.bili.quick.core.LoginSceneProcessor;
import tv.danmaku.bili.ui.answer.api.AnswerGuideData;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;
import tv.danmaku.bili.ui.main2.mine.modularvip.MineVipServiceKt;

/* compiled from: AnswerRequiredDialog.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eBe\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000f\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\f¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0011H\u0016J\u0010\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Ltv/danmaku/bili/ui/answer/AnswerRequiredDialog;", "Ltv/danmaku/bili/ui/answer/AnswerDialogUI;", "context", "Landroid/content/Context;", "answerGuideData", "Ltv/danmaku/bili/ui/answer/api/AnswerGuideData;", "requestCode", "", LoginSceneProcessor.BIZ_KEY, "", "fromSpmid", "interceptInvitationEvent", "Lkotlin/Function0;", "", "extraParams", "", "dismiss", "", "<init>", "(Landroid/content/Context;Ltv/danmaku/bili/ui/answer/api/AnswerGuideData;ILjava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Ljava/util/Map;Lkotlin/jvm/functions/Function0;)V", "getBusiness", "()Ljava/lang/String;", "getFromSpmid", "mBinding", "Ltv/danmaku/bili/databinding/BiliAppDialogAnswerBinding;", "onCreateView", "Landroid/view/View;", "setUiBeforeShow", "reportClick", "position", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AnswerRequiredDialog implements AnswerDialogUI {
    private static final String ANSWER_URL = "https://www.bilibili.com/h5/newbie/entry?navhide=1";
    private final AnswerGuideData answerGuideData;
    private final String business;
    private final Context context;
    private final Function0<Unit> dismiss;
    private final Map<String, String> extraParams;
    private final String fromSpmid;
    private final Function0<Boolean> interceptInvitationEvent;
    private BiliAppDialogAnswerBinding mBinding;
    private final int requestCode;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public AnswerRequiredDialog(Context context, AnswerGuideData answerGuideData, int requestCode, String business, String fromSpmid, Function0<Boolean> function0, Map<String, String> map, Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(answerGuideData, "answerGuideData");
        Intrinsics.checkNotNullParameter(business, LoginSceneProcessor.BIZ_KEY);
        Intrinsics.checkNotNullParameter(fromSpmid, "fromSpmid");
        Intrinsics.checkNotNullParameter(map, "extraParams");
        Intrinsics.checkNotNullParameter(function02, "dismiss");
        this.context = context;
        this.answerGuideData = answerGuideData;
        this.requestCode = requestCode;
        this.business = business;
        this.fromSpmid = fromSpmid;
        this.interceptInvitationEvent = function0;
        this.extraParams = map;
        this.dismiss = function02;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ AnswerRequiredDialog(Context context, AnswerGuideData answerGuideData, int i, String str, String str2, Function0 function0, Map map, Function0 function02, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, answerGuideData, i, str, str2, r7, r8, function02);
        Function0 function03;
        Map map2;
        if ((i2 & 32) == 0) {
            function03 = function0;
        } else {
            function03 = null;
        }
        if ((i2 & 64) == 0) {
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
        View view = LayoutInflater.from(this.context).inflate(R.layout.bili_app_dialog_answer, (ViewGroup) null);
        this.mBinding = BiliAppDialogAnswerBinding.bind(view);
        Intrinsics.checkNotNull(view);
        return view;
    }

    @Override // tv.danmaku.bili.ui.answer.AnswerDialogUI
    public void setUiBeforeShow() {
        Context resourceContext;
        int i;
        int i2;
        String string;
        String str;
        String str2;
        String str3;
        String str4;
        int i3;
        BiliAppDialogAnswerBinding $this$setUiBeforeShow_u24lambda_u240 = this.mBinding;
        if ($this$setUiBeforeShow_u24lambda_u240 == null) {
            return;
        }
        View $this$setVisibleOrGone_u24default$iv = $this$setUiBeforeShow_u24lambda_u240.btnInviteCode;
        String str5 = this.answerGuideData.buttonInviteCode;
        boolean show$iv = str5 != null && (StringsKt.isBlank(str5) ^ true);
        if ($this$setVisibleOrGone_u24default$iv != null) {
            if (show$iv) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            $this$setVisibleOrGone_u24default$iv.setVisibility(i3);
        }
        if (!show$iv || $this$setVisibleOrGone_u24default$iv != null) {
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
        $this$setUiBeforeShow_u24lambda_u240.btnToAnswer.setTextColor(ContextCompat.getColor(resourceContext, com.bilibili.lib.theme.R.color.Brand_pink));
        $this$setUiBeforeShow_u24lambda_u240.btnCancel.setTextColor(ContextCompat.getColor(resourceContext, com.bilibili.lib.theme.R.color.Text2));
        $this$setUiBeforeShow_u24lambda_u240.title.setTextColor(ContextCompat.getColor(resourceContext, com.bilibili.lib.theme.R.color.Text1));
        $this$setUiBeforeShow_u24lambda_u240.content.setTextColor(ContextCompat.getColor(resourceContext, com.bilibili.lib.theme.R.color.Text2));
        TextView textView = $this$setUiBeforeShow_u24lambda_u240.btnToAnswer;
        View view = $this$setUiBeforeShow_u24lambda_u240.btnInviteCode;
        Intrinsics.checkNotNullExpressionValue(view, "btnInviteCode");
        View $this$isGone$iv = view;
        View $this$isGone$iv2 = $this$isGone$iv.getVisibility() == 8 ? 1 : null;
        if ($this$isGone$iv2 != null) {
            i = tv.danmaku.biliplayer.baseres.R.drawable.shape_rect_solid_pink_20dp;
        } else {
            i = tv.danmaku.biliplayer.baseres.R.drawable.shape_rect_stroke_pink_20dp;
        }
        textView.setBackground(ContextCompat.getDrawable(resourceContext, i));
        TextView textView2 = $this$setUiBeforeShow_u24lambda_u240.btnToAnswer;
        View view2 = $this$setUiBeforeShow_u24lambda_u240.btnInviteCode;
        Intrinsics.checkNotNullExpressionValue(view2, "btnInviteCode");
        View $this$isGone$iv3 = view2;
        View $this$isGone$iv4 = $this$isGone$iv3.getVisibility() == 8 ? 1 : null;
        if ($this$isGone$iv4 != null) {
            i2 = com.bilibili.lib.theme.R.color.Wh0_u;
        } else {
            i2 = com.bilibili.lib.theme.R.color.Brand_pink;
        }
        textView2.setTextColor(ContextCompat.getColor(resourceContext, i2));
        $this$setUiBeforeShow_u24lambda_u240.btnInviteCode.setBackground(ContextCompat.getDrawable(resourceContext, tv.danmaku.biliplayer.baseres.R.drawable.shape_rect_solid_pink_20dp));
        $this$setUiBeforeShow_u24lambda_u240.btnInviteCode.setText(this.answerGuideData.buttonInviteCode);
        TextView textView3 = $this$setUiBeforeShow_u24lambda_u240.btnToAnswer;
        String takeIfNotBlank = ListExtentionsKt.takeIfNotBlank(this.answerGuideData.buttonConfirm);
        if (takeIfNotBlank != null) {
            str = takeIfNotBlank;
        } else {
            View view3 = $this$setUiBeforeShow_u24lambda_u240.btnInviteCode;
            Intrinsics.checkNotNullExpressionValue(view3, "btnInviteCode");
            View $this$isVisible$iv = view3;
            if ($this$isVisible$iv.getVisibility() == 0) {
                string = this.context.getString(bili.resource.playerbaseres.R.string.playerbaseres_global_string_34);
            } else {
                string = this.context.getString(bili.resource.homepage.R.string.homepage_global_string_352);
            }
            Intrinsics.checkNotNull(string);
            str = string;
        }
        textView3.setText(str);
        TextView textView4 = $this$setUiBeforeShow_u24lambda_u240.btnCancel;
        String takeIfNotBlank2 = ListExtentionsKt.takeIfNotBlank(this.answerGuideData.buttonCancel);
        if (takeIfNotBlank2 != null) {
            str2 = takeIfNotBlank2;
        } else {
            String string2 = this.context.getString(bili.resource.homepage.R.string.homepage_global_string_284);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            str2 = string2;
        }
        textView4.setText(str2);
        TextView textView5 = $this$setUiBeforeShow_u24lambda_u240.title;
        String takeIfNotBlank3 = ListExtentionsKt.takeIfNotBlank(this.answerGuideData.title);
        if (takeIfNotBlank3 != null) {
            str3 = takeIfNotBlank3;
        } else {
            String string3 = this.context.getString(bili.resource.homepage.R.string.homepage_global_string_281);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            str3 = string3;
        }
        textView5.setText(str3);
        TextView textView6 = $this$setUiBeforeShow_u24lambda_u240.content;
        String takeIfNotBlank4 = ListExtentionsKt.takeIfNotBlank(this.answerGuideData.desc);
        if (takeIfNotBlank4 != null) {
            str4 = takeIfNotBlank4;
        } else {
            String string4 = this.context.getString(bili.resource.homepage.R.string.homepage_global_string_351);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            str4 = string4;
        }
        textView6.setText(str4);
        $this$setUiBeforeShow_u24lambda_u240.btnToAnswer.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.answer.AnswerRequiredDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                AnswerRequiredDialog.setUiBeforeShow$lambda$0$1(AnswerRequiredDialog.this, view4);
            }
        });
        $this$setUiBeforeShow_u24lambda_u240.btnCancel.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.answer.AnswerRequiredDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                AnswerRequiredDialog.setUiBeforeShow$lambda$0$2(AnswerRequiredDialog.this, view4);
            }
        });
        $this$setUiBeforeShow_u24lambda_u240.btnInviteCode.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.answer.AnswerRequiredDialog$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                AnswerRequiredDialog.setUiBeforeShow$lambda$0$3(AnswerRequiredDialog.this, view4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUiBeforeShow$lambda$0$1(AnswerRequiredDialog this$0, View it) {
        String it2 = ListExtentionsKt.takeIfNotBlank(this$0.answerGuideData.link);
        if (it2 == null) {
            it2 = "https://www.bilibili.com/h5/newbie/entry?navhide=1";
        }
        this$0.reportClick("1");
        BLRouter.routeTo(new RouteRequest.Builder(it2).requestCode(this$0.requestCode).build(), this$0.context);
        this$0.dismiss.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUiBeforeShow$lambda$0$2(AnswerRequiredDialog this$0, View it) {
        this$0.reportClick("2");
        this$0.dismiss.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUiBeforeShow$lambda$0$3(AnswerRequiredDialog this$0, View it) {
        Activity activity;
        if ((this$0.interceptInvitationEvent == null || !((Boolean) this$0.interceptInvitationEvent.invoke()).booleanValue()) && (activity = ContextUtilKt.findActivityOrNull(this$0.context)) != null) {
            ShareToGetInvitationCodeUtil.INSTANCE.share(activity, this$0.fromSpmid);
        }
        this$0.reportClick("3");
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
        extension.put("pop_type", MineVipServiceKt.VIP_REPORT_VALUE_NORMAL);
        Neurons.reportClick(false, "community.public-community.answer-in.all.click", extension);
    }

    /* compiled from: AnswerRequiredDialog.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/ui/answer/AnswerRequiredDialog$Companion;", "", "<init>", "()V", "ANSWER_URL", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}