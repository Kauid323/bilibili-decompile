package tv.danmaku.bili.ui.splash.brand.uiv2.setting;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import tv.danmaku.bili.ui.splash.brand.config.BrandSplashStorage;
import tv.danmaku.bili.ui.splash.brand.model.BrandSplash;
import tv.danmaku.bili.ui.splash.brand.model.BrandSplashKt;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashExitDialog;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSetOption;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSettingExitOption;
import tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel;
import tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.FloatUiState;
import tv.danmaku.bili.widget.dialog.BiliCommonDialog;
import tv.danmaku.bili.widget.dialog.CustomButtonInfo;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BrandSplashSettingFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.splash.brand.uiv2.setting.BrandSplashSettingFragment$onBackPressed$1", f = "BrandSplashSettingFragment.kt", i = {1, 1}, l = {345, 352}, m = "invokeSuspend", n = {"selectedSet", "localSet"}, s = {"L$0", "L$1"}, v = 1)
final class BrandSplashSettingFragment$onBackPressed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BrandSplashSetOption $option;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ BrandSplashSettingFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BrandSplashSettingFragment$onBackPressed$1(BrandSplashSettingFragment brandSplashSettingFragment, BrandSplashSetOption brandSplashSetOption, Continuation<? super BrandSplashSettingFragment$onBackPressed$1> continuation) {
        super(2, continuation);
        this.this$0 = brandSplashSettingFragment;
        this.$option = brandSplashSetOption;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BrandSplashSettingFragment$onBackPressed$1(this.this$0, this.$option, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0064 A[LOOP:0: B:12:0x005e->B:14:0x0064, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x009f A[LOOP:1: B:16:0x0099->B:18:0x009f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        BrandSplashSettingViewModel vm;
        Object first;
        Set selectedSet;
        final Set localSet;
        BrandSplashSettingViewModel vm2;
        Object $result2;
        BrandSplashSettingExitOption exitOption;
        String text;
        FragmentActivity activity;
        FragmentManager it;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z = false;
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                vm = this.this$0.getVm();
                this.label = 1;
                first = FlowKt.first(vm.getSelectedSplash(), (Continuation) this);
                if (first == coroutine_suspended) {
                    return coroutine_suspended;
                }
                Iterable $this$map$iv = (Iterable) first;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    BrandSplash it2 = (BrandSplash) item$iv$iv;
                    destination$iv$iv.add(BrandSplashKt.getUniqueId(it2));
                }
                selectedSet = CollectionsKt.toSet((List) destination$iv$iv);
                Iterable $this$map$iv2 = BrandSplashStorage.readCustomBrands$default(BrandSplashStorage.INSTANCE, false, 1, null);
                Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                for (Object item$iv$iv2 : $this$map$iv2) {
                    BrandSplash it3 = (BrandSplash) item$iv$iv2;
                    destination$iv$iv2.add(BrandSplashKt.getUniqueId(it3));
                }
                localSet = CollectionsKt.toSet((List) destination$iv$iv2);
                if (!localSet.isEmpty() && selectedSet.isEmpty()) {
                    BrandSplashStorage.INSTANCE.setCustomMode(false);
                    FragmentActivity activity2 = this.this$0.getActivity();
                    if (activity2 != null) {
                        activity2.finish();
                    }
                    return Unit.INSTANCE;
                }
                if (Intrinsics.areEqual(selectedSet, localSet)) {
                    vm2 = this.this$0.getVm();
                    this.L$0 = selectedSet;
                    this.L$1 = localSet;
                    this.label = 2;
                    Object first2 = FlowKt.first(vm2.getFloatUiState(), (Continuation) this);
                    if (first2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result2 = first2;
                    if (!((FloatUiState) $result2).getSaveButtonEnable()) {
                        FragmentActivity activity3 = this.this$0.getActivity();
                        if (activity3 != null) {
                            activity3.finish();
                        }
                        return Unit.INSTANCE;
                    }
                }
                if (selectedSet.isEmpty()) {
                    BrandSplashExitDialog exitDialog = this.$option.getExitDialog();
                    exitOption = exitDialog != null ? exitDialog.getEmpty() : null;
                } else {
                    BrandSplashExitDialog exitDialog2 = this.$option.getExitDialog();
                    exitOption = exitDialog2 != null ? exitDialog2.getSelected() : null;
                }
                text = exitOption != null ? exitOption.getText() : null;
                if (!(text != null || StringsKt.isBlank(text))) {
                    String yes = exitOption != null ? exitOption.getYes() : null;
                    if (!(yes == null || StringsKt.isBlank(yes))) {
                        String no = exitOption != null ? exitOption.getNo() : null;
                        if (!((no == null || StringsKt.isBlank(no)) ? true : true)) {
                            FragmentActivity activity4 = this.this$0.getActivity();
                            if (activity4 != null && (it = activity4.getSupportFragmentManager()) != null) {
                                final BrandSplashSettingFragment brandSplashSettingFragment = this.this$0;
                                Context requireContext = brandSplashSettingFragment.requireContext();
                                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                                BiliCommonDialog.Builder buttonStyle = new BiliCommonDialog.Builder(requireContext).setButtonStyle(1);
                                String text2 = exitOption != null ? exitOption.getText() : null;
                                Intrinsics.checkNotNull(text2);
                                BiliCommonDialog.Builder contentText = buttonStyle.setContentText(text2);
                                String yes2 = exitOption.getYes();
                                Intrinsics.checkNotNull(yes2);
                                BiliCommonDialog.Builder positiveButton$default = BiliCommonDialog.Builder.setPositiveButton$default(contentText, yes2, new BiliCommonDialog.OnDialogTextClickListener() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.BrandSplashSettingFragment$onBackPressed$1$$ExternalSyntheticLambda0
                                    @Override // tv.danmaku.bili.widget.dialog.BiliCommonDialog.OnDialogTextClickListener
                                    public final void onDialogTextClicked(View view2, BiliCommonDialog biliCommonDialog) {
                                        BrandSplashSettingFragment$onBackPressed$1.invokeSuspend$lambda$2$0(localSet, brandSplashSettingFragment, view2, biliCommonDialog);
                                    }
                                }, true, (CustomButtonInfo) null, 8, (Object) null);
                                String no2 = exitOption.getNo();
                                Intrinsics.checkNotNull(no2);
                                BiliCommonDialog.Builder.setNegativeButton$default(positiveButton$default, no2, (BiliCommonDialog.OnDialogTextClickListener) null, true, (CustomButtonInfo) null, 8, (Object) null).build().show(it, "splash-selected-exit-dialog");
                            }
                            return Unit.INSTANCE;
                        }
                    }
                }
                activity = this.this$0.getActivity();
                if (activity != null) {
                    activity.finish();
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                first = $result;
                Iterable $this$map$iv3 = (Iterable) first;
                Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                while (r11.hasNext()) {
                }
                selectedSet = CollectionsKt.toSet((List) destination$iv$iv3);
                Iterable $this$map$iv22 = BrandSplashStorage.readCustomBrands$default(BrandSplashStorage.INSTANCE, false, 1, null);
                Collection destination$iv$iv22 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv22, 10));
                while (r11.hasNext()) {
                }
                localSet = CollectionsKt.toSet((List) destination$iv$iv22);
                if (!localSet.isEmpty()) {
                    break;
                }
                if (Intrinsics.areEqual(selectedSet, localSet)) {
                }
                if (selectedSet.isEmpty()) {
                }
                text = exitOption != null ? exitOption.getText() : null;
                if (text != null) {
                    break;
                }
                if (!(text != null || StringsKt.isBlank(text))) {
                }
                activity = this.this$0.getActivity();
                if (activity != null) {
                }
                return Unit.INSTANCE;
            case 2:
                $result2 = $result;
                selectedSet = (Set) this.L$0;
                ResultKt.throwOnFailure($result2);
                localSet = (Set) this.L$1;
                if (!((FloatUiState) $result2).getSaveButtonEnable()) {
                }
                if (selectedSet.isEmpty()) {
                }
                text = exitOption != null ? exitOption.getText() : null;
                if (!(text != null || StringsKt.isBlank(text))) {
                }
                activity = this.this$0.getActivity();
                if (activity != null) {
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$2$0(Set $localSet, BrandSplashSettingFragment this$0, View view2, BiliCommonDialog dialog) {
        if ($localSet.isEmpty()) {
            BrandSplashStorage.INSTANCE.setCustomMode(false);
        }
        dialog.dismiss();
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}