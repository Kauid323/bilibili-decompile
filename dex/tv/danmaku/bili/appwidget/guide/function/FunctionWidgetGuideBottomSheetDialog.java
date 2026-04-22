package tv.danmaku.bili.appwidget.guide.function;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.bapis.bilibili.app.show.mixture.v1.WidgetGuideReply;
import com.bilibili.app.comm.list.common.R;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.ImageRequestBuilder;
import com.bilibili.lib.image2.bean.ScaleType;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.moduleservice.appwidget.GuideScene;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.guide.IWidgetGuideDialog;
import tv.danmaku.bili.appwidget.guide.utils.AutoAddWidgetSceneExtKt;
import tv.danmaku.bili.appwidget.guide.utils.ReportHelperKt;
import tv.danmaku.bili.databinding.BiliAppWidgetGuideDialogBinding;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* compiled from: FunctionWidgetGuideBottomSheetDialog.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0001,B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J&\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u0012H\u0016J\u0012\u0010\u001d\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J \u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010#\u001a\u00020\u000bH\u0016J\b\u0010$\u001a\u00020\u000bH\u0016J\b\u0010%\u001a\u00020\u000bH\u0016J\u0010\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020\u000bH\u0016J*\u0010*\u001a\u00020\u000b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b0\rH\u0016J\b\u0010+\u001a\u00020\u000bH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Ltv/danmaku/bili/appwidget/guide/function/FunctionWidgetGuideBottomSheetDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Ltv/danmaku/bili/appwidget/guide/IWidgetGuideDialog;", "<init>", "()V", "binding", "Ltv/danmaku/bili/databinding/BiliAppWidgetGuideDialogBinding;", "reply", "Lcom/bapis/bilibili/app/show/mixture/v1/WidgetGuideReply;", "onConfirm", "Lkotlin/Function0;", "", "onCancel", "Lkotlin/Function1;", "", "tryToAdd", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onSaveInstanceState", "outState", "onViewStateRestored", "showDialog", AudioIntentHelper.FROM_ACTIVITY, "Landroidx/fragment/app/FragmentActivity;", "scene", "Lcom/bilibili/moduleservice/appwidget/GuideScene;", "hideDialog", "dismiss", "dismissAllowingStateLoss", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onDestroyView", "setAction", "setupView", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FunctionWidgetGuideBottomSheetDialog extends BottomSheetDialogFragment implements IWidgetGuideDialog {
    private static final String TAG = "FunctionWidgetGuideBottomSheetDialog";
    private BiliAppWidgetGuideDialogBinding binding;
    private Function1<? super Boolean, Unit> onCancel;
    private Function0<Unit> onConfirm;
    private WidgetGuideReply reply;
    private boolean tryToAdd;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, R.style.ListBottomSheetDialogTheme);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this.binding = BiliAppWidgetGuideDialogBinding.inflate(inflater);
        BiliAppWidgetGuideDialogBinding biliAppWidgetGuideDialogBinding = this.binding;
        return (View) (biliAppWidgetGuideDialogBinding != null ? biliAppWidgetGuideDialogBinding.getRoot() : null);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setupView();
    }

    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        this.tryToAdd = true;
    }

    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState != null) {
            dismiss();
        }
    }

    @Override // tv.danmaku.bili.appwidget.guide.IWidgetGuideDialog
    public void showDialog(FragmentActivity activity, GuideScene scene, WidgetGuideReply reply) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(reply, "reply");
        this.reply = reply;
        show(activity.getSupportFragmentManager(), TAG);
        ReportHelperKt.reportGuidePopShow(AutoAddWidgetSceneExtKt.spmid(scene), AutoAddWidgetSceneExtKt.type(scene));
    }

    @Override // tv.danmaku.bili.appwidget.guide.IWidgetGuideDialog
    public void hideDialog() {
        dismiss();
    }

    public void dismiss() {
        if (getFragmentManager() == null) {
            BLog.e(TAG, "dismiss fragmentManager is null");
            return;
        }
        try {
            super.dismiss();
        } catch (Exception e) {
            BLog.e(TAG, "dismiss error " + e);
        }
    }

    public void dismissAllowingStateLoss() {
        if (getFragmentManager() == null) {
            BLog.e(TAG, "dismissAllowingStateLoss fragmentManager is null");
            return;
        }
        try {
            super.dismissAllowingStateLoss();
        } catch (Exception e) {
            BLog.e(TAG, "dismissAllowingStateLoss error " + e);
        }
    }

    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        Function1<? super Boolean, Unit> function1 = this.onCancel;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(!this.tryToAdd));
        }
        this.tryToAdd = false;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
        this.onConfirm = null;
        this.onCancel = null;
    }

    @Override // tv.danmaku.bili.appwidget.guide.IWidgetGuideDialog
    public void setAction(Function0<Unit> function0, Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function0, "onConfirm");
        Intrinsics.checkNotNullParameter(function1, "onCancel");
        this.onConfirm = function0;
        this.onCancel = function1;
    }

    private final void setupView() {
        WidgetGuideReply it;
        String titleText;
        BiliAppWidgetGuideDialogBinding $this$setupView_u24lambda_u240 = this.binding;
        if ($this$setupView_u24lambda_u240 != null && (it = this.reply) != null) {
            String title = it.getTip().getTitle();
            if (title == null || StringsKt.isBlank(title)) {
                titleText = getString(bili.resource.homepage.R.string.homepage_global_string_170);
            } else {
                titleText = it.getTip().getTitle();
            }
            ListExtentionsKt.setText($this$setupView_u24lambda_u240.title, titleText);
            ListExtentionsKt.setText($this$setupView_u24lambda_u240.subtitle, it.getTip().getSubtitle());
            ImageRequestBuilder with = BiliImageLoader.INSTANCE.with(getLifecycle());
            ScaleType scaleType = ScaleType.CENTER_CROP;
            Intrinsics.checkNotNullExpressionValue(scaleType, "CENTER_CROP");
            ImageRequestBuilder url = with.actualImageScaleType(scaleType).url(it.getTip().getImage());
            ScaleType scaleType2 = ScaleType.CENTER_CROP;
            Intrinsics.checkNotNullExpressionValue(scaleType2, "CENTER_CROP");
            ImageRequestBuilder actualImageScaleType = url.actualImageScaleType(scaleType2);
            BiliImageView biliImageView = $this$setupView_u24lambda_u240.ivGuide;
            Intrinsics.checkNotNullExpressionValue(biliImageView, "ivGuide");
            actualImageScaleType.into(biliImageView);
            $this$setupView_u24lambda_u240.negativeButton.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.appwidget.guide.function.FunctionWidgetGuideBottomSheetDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FunctionWidgetGuideBottomSheetDialog.this.dismiss();
                }
            });
            $this$setupView_u24lambda_u240.positiveButton.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.appwidget.guide.function.FunctionWidgetGuideBottomSheetDialog$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FunctionWidgetGuideBottomSheetDialog.setupView$lambda$0$0$1(FunctionWidgetGuideBottomSheetDialog.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupView$lambda$0$0$1(FunctionWidgetGuideBottomSheetDialog this$0, View it) {
        this$0.tryToAdd = true;
        this$0.dismiss();
        Function0<Unit> function0 = this$0.onConfirm;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* compiled from: FunctionWidgetGuideBottomSheetDialog.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/appwidget/guide/function/FunctionWidgetGuideBottomSheetDialog$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Ltv/danmaku/bili/appwidget/guide/function/FunctionWidgetGuideBottomSheetDialog;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FunctionWidgetGuideBottomSheetDialog newInstance() {
            return new FunctionWidgetGuideBottomSheetDialog();
        }
    }
}