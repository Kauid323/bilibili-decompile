package tv.danmaku.bili.ui.splash.brand.uiv2.setting.preview;

import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.app.comm.list.common.widget.PromoToast;
import com.bilibili.base.BiliContext;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.splash.brand.model.BrandSplash;
import tv.danmaku.bili.ui.splash.brand.model.BrandSplashKt;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSetOption;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSettingData;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSettingVipConfig;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSource;
import tv.danmaku.bili.ui.splash.brand.reporter.BrandSplashReporter;
import tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel;
import tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.model.CustomModeState;
import tv.danmaku.bili.ui.splash.databinding.BiliAppListBrandSplashPreviewFragmentBinding;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BrandSplashPreviewFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.splash.brand.uiv2.setting.preview.BrandSplashPreviewFragment$handleSelectButtonClicked$1", f = "BrandSplashPreviewFragment.kt", i = {}, l = {159}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class BrandSplashPreviewFragment$handleSelectButtonClicked$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BrandSplashPreviewFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BrandSplashPreviewFragment$handleSelectButtonClicked$1(BrandSplashPreviewFragment brandSplashPreviewFragment, Continuation<? super BrandSplashPreviewFragment$handleSelectButtonClicked$1> continuation) {
        super(2, continuation);
        this.this$0 = brandSplashPreviewFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BrandSplashPreviewFragment$handleSelectButtonClicked$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        BiliAppListBrandSplashPreviewFragmentBinding binding;
        BiliAppListBrandSplashPreviewFragmentBinding binding2;
        List<BrandSplash> dataList;
        BrandSplash data;
        BrandSplashSettingViewModel vm;
        BrandSplashSettingVipConfig vipConfig;
        Object handleByVip;
        BrandSplashSettingViewModel vm2;
        BrandSplashSettingViewModel vm3;
        BrandSplashSettingViewModel vm4;
        BrandSplash copy;
        BrandSplashSettingViewModel vm5;
        BrandSplashSettingViewModel vm6;
        BrandSplashSettingViewModel vm7;
        BrandSplashSetOption setOption;
        BrandSplashSettingViewModel vm8;
        BrandSplashSetOption setOption2;
        String it;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                binding = this.this$0.getBinding();
                int pos = binding.brandSplashPreviewVp.getCurrentItem();
                binding2 = this.this$0.getBinding();
                RecyclerView.Adapter adapter = binding2.brandSplashPreviewVp.getAdapter();
                BrandSplashPreviewAdapter brandSplashPreviewAdapter = adapter instanceof BrandSplashPreviewAdapter ? (BrandSplashPreviewAdapter) adapter : null;
                if (brandSplashPreviewAdapter == null || (dataList = brandSplashPreviewAdapter.getDataList()) == null || (data = dataList.get(pos)) == null) {
                    return Unit.INSTANCE;
                }
                if (data.isDisabled()) {
                    vm8 = this.this$0.getVm();
                    BrandSplashSettingData brandSplashSettingData = (BrandSplashSettingData) vm8.getBrandSplashData().getValue();
                    if (brandSplashSettingData != null && (setOption2 = brandSplashSettingData.getSetOption()) != null && (it = setOption2.getOverflowToast()) != null) {
                        String it2 = it.length() > 0 ? it : null;
                        if (it2 != null) {
                            PromoToast.showMidToast(BiliContext.application(), it2);
                        }
                    }
                    return Unit.INSTANCE;
                }
                vm = this.this$0.getVm();
                BrandSplashSettingData brandSplashSettingData2 = (BrandSplashSettingData) vm.getBrandSplashData().getValue();
                if (brandSplashSettingData2 == null || (setOption = brandSplashSettingData2.getSetOption()) == null || (vipConfig = setOption.getVipConfig()) == null) {
                    vipConfig = new BrandSplashSettingVipConfig(false, false, false, 7, null);
                }
                if ((!Intrinsics.areEqual(data.getSource(), BrandSplashSource.VIP.getValue()) && !Intrinsics.areEqual(data.getSource(), BrandSplashSource.DLC.getValue())) || !vipConfig.getLocked()) {
                    vm2 = this.this$0.getVm();
                    if (!((CustomModeState) vm2.getCustomModeState().getValue()).getCustomMode()) {
                        vm6 = this.this$0.getVm();
                        MutableStateFlow<CustomModeState> customModeState = vm6.getCustomModeState();
                        vm7 = this.this$0.getVm();
                        BrandSplash brandSplash = (BrandSplash) vm7.getPreviewPageEntryItem().getValue();
                        customModeState.setValue(new CustomModeState(true, true, brandSplash != null ? BrandSplashKt.getUniqueId(brandSplash) : null));
                    }
                    BrandSplashReporter brandSplashReporter = BrandSplashReporter.INSTANCE;
                    long id = data.getId();
                    String source = data.getSource();
                    if (source == null) {
                        source = "";
                    }
                    brandSplashReporter.reportCustomBrandSplashClicked(id, source, !data.isSelected());
                    vm3 = this.this$0.getVm();
                    vm3.getPreviewPageEntryItem().setValue(data);
                    vm4 = this.this$0.getVm();
                    copy = data.copy((r30 & 1) != 0 ? data.id : 0L, (r30 & 2) != 0 ? data.thumb : null, (r30 & 4) != 0 ? data.thumbHash : null, (r30 & 8) != 0 ? data.thumbName : null, (r30 & 16) != 0 ? data.logoUrl : null, (r30 & 32) != 0 ? data.logoHash : null, (r30 & 64) != 0 ? data.mode : null, (r30 & 128) != 0 ? data.source : null, (r30 & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) != 0 ? data.showLogo : false, (r30 & 512) != 0 ? data.isSelected : !data.isSelected(), (r30 & 1024) != 0 ? data.isDisabled : false, (r30 & IjkMediaMeta.FF_PROFILE_H264_INTRA) != 0 ? data.isCustomModeOn : false, (r30 & 4096) != 0 ? data.isToBeSet : false);
                    vm4.updateItem(data, copy);
                    vm5 = this.this$0.getVm();
                    vm5.getUnSaveState().setValue(Boxing.boxBoolean(true));
                    return Unit.INSTANCE;
                } else if (vipConfig.getVipForbidden()) {
                    PromoToast.showMidToast(BiliContext.application(), "用户账号异常，暂时无法使用权益");
                    return Unit.INSTANCE;
                } else if (vipConfig.getVipOrderPromotion()) {
                    this.label = 1;
                    handleByVip = this.this$0.handleByVip((Continuation) this);
                    if (handleByVip != coroutine_suspended) {
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                } else {
                    BLog.e("[brandSplash]BrandSplashPreviewFragment", "handleSelectButtonClicked, id = " + data.getId() + " , locked = true。 status error");
                    return Unit.INSTANCE;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}