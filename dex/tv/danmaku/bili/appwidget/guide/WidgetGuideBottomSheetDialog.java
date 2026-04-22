package tv.danmaku.bili.appwidget.guide;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import com.bapis.bilibili.app.show.mixture.v1.GuideCard;
import com.bapis.bilibili.app.show.mixture.v1.GuideItem;
import com.bilibili.app.comm.list.common.R;
import com.bilibili.magicasakura.widgets.TintTextView;
import com.bilibili.moduleservice.appwidget.GuideScene;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.guide.utils.AutoAddWidgetSceneExtKt;
import tv.danmaku.bili.appwidget.guide.utils.ReportHelperKt;
import tv.danmaku.bili.databinding.BiliAppWidgetGuideBottomSheetDialogFragmentBinding;
import tv.danmaku.bili.ui.main2.CommonMenuBottomSheetKt;

/* compiled from: WidgetGuideBottomSheetDialog.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J&\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\rH\u0016J\b\u0010\u0018\u001a\u00020\u000bH\u0016J\u001e\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\u001d\u001a\u00020\u000b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0002J\u0012\u0010!\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Ltv/danmaku/bili/appwidget/guide/WidgetGuideBottomSheetDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "guideInfo", "Lcom/bapis/bilibili/app/show/mixture/v1/GuideItem;", "scene", "Lcom/bilibili/moduleservice/appwidget/GuideScene;", "binding", "Ltv/danmaku/bili/databinding/BiliAppWidgetGuideBottomSheetDialogFragmentBinding;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onSaveInstanceState", "outState", "onDestroyView", "showWidgetGuide", "manager", "Landroidx/fragment/app/FragmentManager;", "guideItem", "showBanner", CommonMenuBottomSheetKt.KEY_ITEMS, "", "Lcom/bapis/bilibili/app/show/mixture/v1/GuideCard;", "restoreSavedState", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class WidgetGuideBottomSheetDialog extends BottomSheetDialogFragment {
    private static final String KEY_GUIDE_INFO = "guide_info";
    private static final String TAG = "WidgetGuideBottomSheetDialog";
    private BiliAppWidgetGuideBottomSheetDialogFragmentBinding binding;
    private GuideItem guideInfo;
    private GuideScene scene;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, R.style.ListBottomSheetDialogTheme);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this.binding = BiliAppWidgetGuideBottomSheetDialogFragmentBinding.inflate(inflater);
        BiliAppWidgetGuideBottomSheetDialogFragmentBinding biliAppWidgetGuideBottomSheetDialogFragmentBinding = this.binding;
        return (View) (biliAppWidgetGuideBottomSheetDialogFragmentBinding != null ? biliAppWidgetGuideBottomSheetDialogFragmentBinding.getRoot() : null);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        restoreSavedState(savedInstanceState);
        BiliAppWidgetGuideBottomSheetDialogFragmentBinding $this$onViewCreated_u24lambda_u240 = this.binding;
        if ($this$onViewCreated_u24lambda_u240 != null) {
            GuideItem widgetGuide = this.guideInfo;
            if (widgetGuide != null) {
                TintTextView tintTextView = $this$onViewCreated_u24lambda_u240.title;
                String title = widgetGuide.getTitle();
                if (title == null) {
                    title = "";
                }
                tintTextView.setText(title);
                List<GuideCard> cardList = widgetGuide.getCardList();
                Intrinsics.checkNotNullExpressionValue(cardList, "getCardList(...)");
                showBanner(cardList);
            }
            $this$onViewCreated_u24lambda_u240.negativeButton.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.appwidget.guide.WidgetGuideBottomSheetDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    WidgetGuideBottomSheetDialog.onViewCreated$lambda$0$1(WidgetGuideBottomSheetDialog.this, view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0$1(WidgetGuideBottomSheetDialog this$0, View it) {
        this$0.dismiss();
        GuideScene guideScene = this$0.scene;
        String spmid = guideScene != null ? AutoAddWidgetSceneExtKt.spmid(guideScene) : null;
        GuideScene guideScene2 = this$0.scene;
        String type = guideScene2 != null ? AutoAddWidgetSceneExtKt.type(guideScene2) : null;
        GuideScene guideScene3 = this$0.scene;
        ReportHelperKt.reportGuideWindowClick(spmid, type, guideScene3 != null ? AutoAddWidgetSceneExtKt.contentId(guideScene3) : null);
    }

    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        GuideItem it = this.guideInfo;
        if (it != null) {
            try {
                outState.putByteArray(KEY_GUIDE_INFO, it.toByteArray());
            } catch (Exception e) {
                BLog.e(TAG, "onSaveInstanceState error: " + e);
            }
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }

    public final void showWidgetGuide(FragmentManager manager, GuideItem guideItem, GuideScene scene) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        Intrinsics.checkNotNullParameter(guideItem, "guideItem");
        Intrinsics.checkNotNullParameter(scene, "scene");
        try {
            this.guideInfo = guideItem;
            this.scene = scene;
            show(manager, TAG);
        } catch (IllegalStateException e) {
            BLog.e(TAG, "show widget guide bottom sheet dialog failed");
        }
    }

    private final void showBanner(List<GuideCard> list) {
        BiliAppWidgetGuideBottomSheetDialogFragmentBinding $this$showBanner_u24lambda_u240 = this.binding;
        if ($this$showBanner_u24lambda_u240 != null) {
            if (list.size() == 1) {
                $this$showBanner_u24lambda_u240.indicator.setVisibility(8);
            } else {
                $this$showBanner_u24lambda_u240.indicator.setVisibility(0);
            }
            $this$showBanner_u24lambda_u240.banner.setIndicator($this$showBanner_u24lambda_u240.bannerIndicator);
            SwipeImageWithTitleAdapter adapter = new SwipeImageWithTitleAdapter(list);
            $this$showBanner_u24lambda_u240.banner.getViewPager2().setOffscreenPageLimit(list.size());
            $this$showBanner_u24lambda_u240.banner.setAutoLoop(false);
            $this$showBanner_u24lambda_u240.banner.setLoop(false);
            $this$showBanner_u24lambda_u240.banner.setAdapter(adapter);
        }
    }

    private final void restoreSavedState(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            byte[] byteArray = savedInstanceState.getByteArray(KEY_GUIDE_INFO);
            try {
                GuideItem guideInfo = GuideItem.parseFrom(byteArray);
                this.guideInfo = guideInfo;
            } catch (Exception e) {
                BLog.e(TAG, "restoreSavedState error: " + e);
            }
        }
    }

    /* compiled from: WidgetGuideBottomSheetDialog.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Ltv/danmaku/bili/appwidget/guide/WidgetGuideBottomSheetDialog$Companion;", "", "<init>", "()V", "TAG", "", "KEY_GUIDE_INFO", "newInstance", "Ltv/danmaku/bili/appwidget/guide/WidgetGuideBottomSheetDialog;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final WidgetGuideBottomSheetDialog newInstance() {
            return new WidgetGuideBottomSheetDialog();
        }
    }
}