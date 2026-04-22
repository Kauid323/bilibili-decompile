package tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bilibili.app.comm.list.common.widget.PromoToast;
import com.bilibili.base.BiliContext;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import com.bilibili.okretro.ServiceGenerator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.splash.brand.config.BrandSplashStorage;
import tv.danmaku.bili.ui.splash.brand.model.BrandSplash;
import tv.danmaku.bili.ui.splash.brand.model.BrandSplashKt;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSection;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSetOption;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSettingConfig;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSettingData;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSettingPageMore;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSettingTab;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSettingVipConfig;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSource;
import tv.danmaku.bili.ui.splash.brand.reporter.BrandSplashReporter;
import tv.danmaku.bili.ui.splash.brand.service.BrandSplashService;
import tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.model.CustomModeState;
import tv.danmaku.bili.ui.splash.utils.LoadingState;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: BrandSplashSettingViewModel.kt */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0001iB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010F\u001a\u00020GH\u0082@¢\u0006\u0002\u0010HJ\u0006\u0010I\u001a\u00020GJ\u0010\u0010J\u001a\u00020G2\u0006\u0010K\u001a\u00020\fH\u0002J\u000e\u0010L\u001a\u00020G2\u0006\u0010M\u001a\u00020\u000fJ\u0016\u0010N\u001a\u00020G2\u0006\u0010O\u001a\u00020\u00142\u0006\u0010P\u001a\u00020QJ\u0010\u0010R\u001a\u00020G2\u0006\u0010P\u001a\u00020QH\u0002J\u0016\u0010S\u001a\u00020G2\u0006\u0010O\u001a\u00020\u00142\u0006\u0010T\u001a\u00020\fJ\u0010\u0010U\u001a\u00020G2\u0006\u0010M\u001a\u00020\u000fH\u0002J\u001e\u0010V\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020W0!\u0018\u00010\u001d2\b\u0010X\u001a\u0004\u0018\u00010YJ\u0012\u0010Z\u001a\u00020G2\b\u0010O\u001a\u0004\u0018\u00010#H\u0002J\u001c\u0010[\u001a\u00020G2\f\u0010\\\u001a\b\u0012\u0004\u0012\u0002070!H\u0082@¢\u0006\u0002\u0010]J\u0006\u0010^\u001a\u00020GJ\u0018\u0010_\u001a\u00020G2\b\u0010X\u001a\u0004\u0018\u00010Y2\u0006\u0010`\u001a\u00020aJ*\u0010b\u001a\u0004\u0018\u00010#2\f\u0010\\\u001a\b\u0012\u0004\u0012\u0002070!2\b\u0010`\u001a\u0004\u0018\u00010a2\u0006\u0010X\u001a\u00020YH\u0002J\u0016\u0010c\u001a\u00020G2\u0006\u0010d\u001a\u00020\u00142\u0006\u0010e\u001a\u00020\u0014J\u0018\u0010f\u001a\u00020G2\u0006\u0010d\u001a\u00020\u00142\u0006\u0010e\u001a\u00020\u0014H\u0002J,\u0010g\u001a\b\u0012\u0004\u0012\u00020,0!2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020,0!2\u0006\u0010d\u001a\u00020\u00142\u0006\u0010e\u001a\u00020\u0014H\u0002J\u0006\u0010h\u001a\u00020GR\"\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\bR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\bR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\bR\u0019\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\bR\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\bR\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\f0\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140!0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\bR\u001d\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140!0\u001d¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001fR&\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140!0\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001f\"\u0004\b)\u0010*R\u001d\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0!0\u001d¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001fR\u001d\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0!0\u001d¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001fR\u001d\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140!0\u001d¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001fR\u001d\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140!0\u001d¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001fR\u001a\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140!0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002070!0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R \u00108\u001a\b\u0012\u0004\u0012\u00020\f0\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\b\"\u0004\b:\u0010\nR\u0017\u0010;\u001a\b\u0012\u0004\u0012\u00020<0\u001d¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\u001fR\u001a\u0010>\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u0014\u0010C\u001a\b\u0012\u0004\u0012\u00020\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010D\u001a\b\u0012\u0004\u0012\u00020\f0\u001d¢\u0006\b\n\u0000\u001a\u0004\bE\u0010\u001f¨\u0006j"}, d2 = {"Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/vm/BrandSplashSettingViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "loadingState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ltv/danmaku/bili/ui/splash/utils/LoadingState;", "getLoadingState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "setLoadingState", "(Lkotlinx/coroutines/flow/MutableStateFlow;)V", "loadingMore", "", "isFloatSelectWindowSelect", "customModeState", "Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/vm/model/CustomModeState;", "getCustomModeState", "fullPreviewMode", "getFullPreviewMode", "previewPageEntryItem", "Ltv/danmaku/bili/ui/splash/brand/model/BrandSplash;", "getPreviewPageEntryItem", "searchPageViewModel", "Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/vm/BrandSplashSettingViewModel$SearchPageViewModel;", "getSearchPageViewModel", "()Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/vm/BrandSplashSettingViewModel$SearchPageViewModel;", "brandSplashFromRouter", "getBrandSplashFromRouter", "floatButtonShowState", "Lkotlinx/coroutines/flow/Flow;", "getFloatButtonShowState", "()Lkotlinx/coroutines/flow/Flow;", "savedCustomSplash", "", "brandSplashData", "Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSettingData;", "getBrandSplashData", "allBrandSplash", "getAllBrandSplash", "previewBrandSplashListFlow", "getPreviewBrandSplashListFlow", "setPreviewBrandSplashListFlow", "(Lkotlinx/coroutines/flow/Flow;)V", "tabs", "Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSettingTab;", "getTabs", "options", "Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSettingConfig;", "getOptions", "selectedSplash", "getSelectedSplash", "selectedDisplayedSplash", "getSelectedDisplayedSplash", "ordinarySplash", "vipSplash", "Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSection;", "unSaveState", "getUnSaveState", "setUnSaveState", "floatUiState", "Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/vm/FloatUiState;", "getFloatUiState", "disableSelect", "getDisableSelect", "()Z", "setDisableSelect", "(Z)V", "_disableSelectFlow", "disableSelectFlow", "getDisableSelectFlow", "initSelectState", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "autoOpenFloat", "updateDisableState", "disable", "updateCustomSwitchState", "state", "selectCard", "data", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "handleByVip", "openPreviewPage", "isFromSearchPage", "handleSwitchChangeToSaveList", "getSplashBySource", "", "source", "", "updateRemoteSelectedState", "updateNewReceiveSectionSelectedState", "newSections", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadTabs", "loadMore", "page", "Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSettingPageMore;", "copyBrandSplashData", "updateItem", "old", "new", "updateSavedList", "updateInTab", "saveCustomSplash", "SearchPageViewModel", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BrandSplashSettingViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow<Boolean> _disableSelectFlow;
    private final Flow<List<BrandSplash>> allBrandSplash;
    private boolean disableSelect;
    private final Flow<Boolean> disableSelectFlow;
    private final Flow<FloatUiState> floatUiState;
    private boolean loadingMore;
    private final Flow<List<BrandSplashSettingConfig>> options;
    private final Flow<List<BrandSplash>> ordinarySplash;
    private Flow<? extends List<BrandSplash>> previewBrandSplashListFlow;
    private final Flow<List<BrandSplash>> selectedDisplayedSplash;
    private final Flow<List<BrandSplash>> selectedSplash;
    private final Flow<List<BrandSplashSettingTab>> tabs;
    private MutableStateFlow<Boolean> unSaveState;
    private final Flow<List<BrandSplashSection>> vipSplash;
    private MutableStateFlow<LoadingState> loadingState = StateFlowKt.MutableStateFlow(LoadingState.Loading.INSTANCE);
    private final MutableStateFlow<Boolean> isFloatSelectWindowSelect = StateFlowKt.MutableStateFlow(false);
    private final MutableStateFlow<CustomModeState> customModeState = StateFlowKt.MutableStateFlow(new CustomModeState(BrandSplashStorage.INSTANCE.isCustomMode(), false, null, 4, null));
    private final MutableStateFlow<Boolean> fullPreviewMode = StateFlowKt.MutableStateFlow(false);
    private final MutableStateFlow<BrandSplash> previewPageEntryItem = StateFlowKt.MutableStateFlow((Object) null);
    private final SearchPageViewModel searchPageViewModel = new SearchPageViewModel(ViewModelKt.getViewModelScope(this), new Function1() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel$$ExternalSyntheticLambda0
        public final Object invoke(Object obj) {
            Unit searchPageViewModel$lambda$0;
            searchPageViewModel$lambda$0 = BrandSplashSettingViewModel.searchPageViewModel$lambda$0(BrandSplashSettingViewModel.this, (List) obj);
            return searchPageViewModel$lambda$0;
        }
    });
    private final MutableStateFlow<BrandSplash> brandSplashFromRouter = StateFlowKt.MutableStateFlow((Object) null);
    private final Flow<Boolean> floatButtonShowState = FlowKt.combine(this.loadingState, this.customModeState, this.fullPreviewMode, this.previewPageEntryItem, new BrandSplashSettingViewModel$floatButtonShowState$1(null));
    private final MutableStateFlow<List<BrandSplash>> savedCustomSplash = StateFlowKt.MutableStateFlow(BrandSplashStorage.readCustomBrands$default(BrandSplashStorage.INSTANCE, false, 1, null));
    private final MutableStateFlow<BrandSplashSettingData> brandSplashData = StateFlowKt.MutableStateFlow((Object) null);

    /* JADX WARN: Multi-variable type inference failed */
    public BrandSplashSettingViewModel() {
        final Flow $this$map$iv = this.brandSplashData;
        this.allBrandSplash = new Flow<List<? extends BrandSplash>>() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel$special$$inlined$map$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
            /* renamed from: tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel$special$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
                @DebugMetadata(c = "tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel$special$$inlined$map$1$2", f = "BrandSplashSettingViewModel.kt", i = {}, l = {219}, m = "emit", n = {}, s = {}, v = 1)
                /* renamed from: tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel$special$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, (Continuation) this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object value, Continuation $completion) {
                    Continuation $continuation;
                    List<BrandSplashSettingTab> emptyList;
                    if ($completion instanceof AnonymousClass1) {
                        $continuation = (AnonymousClass1) $completion;
                        if (($continuation.label & Integer.MIN_VALUE) != 0) {
                            $continuation.label -= Integer.MIN_VALUE;
                            Object $result = $continuation.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch ($continuation.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    FlowCollector flowCollector = this.$this_unsafeFlow;
                                    BrandSplashSettingData settingData = (BrandSplashSettingData) value;
                                    if (settingData == null || (emptyList = settingData.getTabs()) == null) {
                                        emptyList = CollectionsKt.emptyList();
                                    }
                                    List list = SequencesKt.toList(SequencesKt.flatMapIterable(SequencesKt.flatMapIterable(CollectionsKt.asSequence(emptyList), new Function1<BrandSplashSettingTab, Iterable<? extends BrandSplashSection>>() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel$allBrandSplash$1$1
                                        public final Iterable<BrandSplashSection> invoke(BrandSplashSettingTab it) {
                                            Intrinsics.checkNotNullParameter(it, "it");
                                            List<BrandSplashSection> sections = it.getSections();
                                            if (sections == null) {
                                                sections = CollectionsKt.emptyList();
                                            }
                                            return sections;
                                        }
                                    }), new Function1<BrandSplashSection, Iterable<? extends BrandSplash>>() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel$allBrandSplash$1$2
                                        public final Iterable<BrandSplash> invoke(BrandSplashSection it) {
                                            Intrinsics.checkNotNullParameter(it, "it");
                                            List<BrandSplash> list2 = it.getList();
                                            if (list2 == null) {
                                                list2 = CollectionsKt.emptyList();
                                            }
                                            return list2;
                                        }
                                    }));
                                    $continuation.label = 1;
                                    if (flowCollector.emit(list, $continuation) != coroutine_suspended) {
                                        break;
                                    } else {
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
                    $continuation = new AnonymousClass1($completion);
                    Object $result2 = $continuation.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch ($continuation.label) {
                    }
                    return Unit.INSTANCE;
                }
            }

            public Object collect(FlowCollector collector, Continuation $completion) {
                Object collect = $this$map$iv.collect(new AnonymousClass2(collector), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        };
        this.previewBrandSplashListFlow = this.allBrandSplash;
        final Flow $this$map$iv2 = this.brandSplashData;
        this.tabs = new Flow<List<? extends BrandSplashSettingTab>>() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel$special$$inlined$map$2
            public Object collect(FlowCollector collector, Continuation $completion) {
                Object collect = $this$map$iv2.collect(new AnonymousClass2(collector), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
            /* renamed from: tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel$special$$inlined$map$2$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
                @DebugMetadata(c = "tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel$special$$inlined$map$2$2", f = "BrandSplashSettingViewModel.kt", i = {}, l = {219}, m = "emit", n = {}, s = {}, v = 1)
                /* renamed from: tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel$special$$inlined$map$2$2$1  reason: invalid class name */
                /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, (Continuation) this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object value, Continuation $completion) {
                    Continuation $continuation;
                    List emptyList;
                    List<BrandSplashSettingTab> tabs;
                    if ($completion instanceof AnonymousClass1) {
                        $continuation = (AnonymousClass1) $completion;
                        if (($continuation.label & Integer.MIN_VALUE) != 0) {
                            $continuation.label -= Integer.MIN_VALUE;
                            Object $result = $continuation.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch ($continuation.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    FlowCollector flowCollector = this.$this_unsafeFlow;
                                    BrandSplashSettingData it = (BrandSplashSettingData) value;
                                    if (it == null || (tabs = it.getTabs()) == null || (emptyList = CollectionsKt.toMutableList(tabs)) == null) {
                                        emptyList = CollectionsKt.emptyList();
                                    }
                                    $continuation.label = 1;
                                    if (flowCollector.emit(emptyList, $continuation) != coroutine_suspended) {
                                        break;
                                    } else {
                                        return coroutine_suspended;
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
                    $continuation = new AnonymousClass1($completion);
                    Object $result2 = $continuation.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch ($continuation.label) {
                    }
                    return Unit.INSTANCE;
                }
            }
        };
        final Flow $this$map$iv3 = this.brandSplashData;
        this.options = new Flow<List<? extends BrandSplashSettingConfig>>() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel$special$$inlined$map$3
            public Object collect(FlowCollector collector, Continuation $completion) {
                Object collect = $this$map$iv3.collect(new AnonymousClass2(collector), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
            /* renamed from: tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel$special$$inlined$map$3$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
                @DebugMetadata(c = "tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel$special$$inlined$map$3$2", f = "BrandSplashSettingViewModel.kt", i = {}, l = {219}, m = "emit", n = {}, s = {}, v = 1)
                /* renamed from: tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel$special$$inlined$map$3$2$1  reason: invalid class name */
                /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, (Continuation) this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object value, Continuation $completion) {
                    Continuation $continuation;
                    List<BrandSplashSettingConfig> emptyList;
                    BrandSplashSetOption setOption;
                    if ($completion instanceof AnonymousClass1) {
                        $continuation = (AnonymousClass1) $completion;
                        if (($continuation.label & Integer.MIN_VALUE) != 0) {
                            $continuation.label -= Integer.MIN_VALUE;
                            Object $result = $continuation.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch ($continuation.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    FlowCollector flowCollector = this.$this_unsafeFlow;
                                    BrandSplashSettingData it = (BrandSplashSettingData) value;
                                    if (it == null || (setOption = it.getSetOption()) == null || (emptyList = setOption.getConfig()) == null) {
                                        emptyList = CollectionsKt.emptyList();
                                    }
                                    $continuation.label = 1;
                                    if (flowCollector.emit(emptyList, $continuation) != coroutine_suspended) {
                                        break;
                                    } else {
                                        return coroutine_suspended;
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
                    $continuation = new AnonymousClass1($completion);
                    Object $result2 = $continuation.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch ($continuation.label) {
                    }
                    return Unit.INSTANCE;
                }
            }
        };
        this.selectedSplash = FlowKt.combine(this.allBrandSplash, this.savedCustomSplash, new BrandSplashSettingViewModel$selectedSplash$1(null));
        this.selectedDisplayedSplash = FlowKt.combine(this.selectedSplash, this.brandSplashFromRouter, new BrandSplashSettingViewModel$selectedDisplayedSplash$1(null));
        final Flow $this$map$iv4 = this.tabs;
        final Flow $this$map$iv5 = new Flow<List<? extends BrandSplashSettingTab>>() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel$special$$inlined$map$4
            public Object collect(FlowCollector collector, Continuation $completion) {
                Object collect = $this$map$iv4.collect(new AnonymousClass2(collector), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
            /* renamed from: tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel$special$$inlined$map$4$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
                @DebugMetadata(c = "tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel$special$$inlined$map$4$2", f = "BrandSplashSettingViewModel.kt", i = {}, l = {219}, m = "emit", n = {}, s = {}, v = 1)
                /* renamed from: tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel$special$$inlined$map$4$2$1  reason: invalid class name */
                /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, (Continuation) this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
                /* JADX WARN: Removed duplicated region for block: B:12:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x0037  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object value, Continuation $completion) {
                    Continuation $continuation;
                    if ($completion instanceof AnonymousClass1) {
                        $continuation = (AnonymousClass1) $completion;
                        if (($continuation.label & Integer.MIN_VALUE) != 0) {
                            $continuation.label -= Integer.MIN_VALUE;
                            Object $result = $continuation.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch ($continuation.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    FlowCollector flowCollector = this.$this_unsafeFlow;
                                    Iterable it = (List) value;
                                    Iterable $this$filterTo$iv$iv = it;
                                    Collection destination$iv$iv = new ArrayList();
                                    for (T t : $this$filterTo$iv$iv) {
                                        BrandSplashSettingTab tab = (BrandSplashSettingTab) t;
                                        if (Intrinsics.areEqual(tab.getSource(), BrandSplashSource.BRAND.getValue())) {
                                            destination$iv$iv.add(t);
                                        }
                                    }
                                    $continuation.label = 1;
                                    if (flowCollector.emit((List) destination$iv$iv, $continuation) != coroutine_suspended) {
                                        break;
                                    } else {
                                        return coroutine_suspended;
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
                    $continuation = new AnonymousClass1($completion);
                    Object $result2 = $continuation.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch ($continuation.label) {
                    }
                    return Unit.INSTANCE;
                }
            }
        };
        this.ordinarySplash = new Flow<List<? extends BrandSplash>>() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel$special$$inlined$map$5
            public Object collect(FlowCollector collector, Continuation $completion) {
                Object collect = $this$map$iv5.collect(new AnonymousClass2(collector), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
            /* renamed from: tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel$special$$inlined$map$5$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
                @DebugMetadata(c = "tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel$special$$inlined$map$5$2", f = "BrandSplashSettingViewModel.kt", i = {}, l = {219}, m = "emit", n = {}, s = {}, v = 1)
                /* renamed from: tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel$special$$inlined$map$5$2$1  reason: invalid class name */
                /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, (Continuation) this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object value, Continuation $completion) {
                    Continuation $continuation;
                    if ($completion instanceof AnonymousClass1) {
                        $continuation = (AnonymousClass1) $completion;
                        if (($continuation.label & Integer.MIN_VALUE) != 0) {
                            $continuation.label -= Integer.MIN_VALUE;
                            Object $result = $continuation.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch ($continuation.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    FlowCollector flowCollector = this.$this_unsafeFlow;
                                    Iterable it = (List) value;
                                    Iterable $this$flatMapTo$iv$iv = it;
                                    Collection destination$iv$iv = new ArrayList();
                                    for (Object element$iv$iv : $this$flatMapTo$iv$iv) {
                                        BrandSplashSettingTab tab = (BrandSplashSettingTab) element$iv$iv;
                                        Iterable sections = tab.getSections();
                                        if (sections == null) {
                                            sections = CollectionsKt.emptyList();
                                        }
                                        Iterable list$iv$iv = sections;
                                        CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
                                    }
                                    Iterable $this$flatMapTo$iv$iv2 = (List) destination$iv$iv;
                                    Collection destination$iv$iv2 = new ArrayList();
                                    for (Object element$iv$iv2 : $this$flatMapTo$iv$iv2) {
                                        BrandSplashSection section = (BrandSplashSection) element$iv$iv2;
                                        Iterable list = section.getList();
                                        if (list == null) {
                                            list = CollectionsKt.emptyList();
                                        }
                                        Iterable list$iv$iv2 = list;
                                        CollectionsKt.addAll(destination$iv$iv2, list$iv$iv2);
                                    }
                                    $continuation.label = 1;
                                    if (flowCollector.emit((List) destination$iv$iv2, $continuation) != coroutine_suspended) {
                                        break;
                                    } else {
                                        return coroutine_suspended;
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
                    $continuation = new AnonymousClass1($completion);
                    Object $result2 = $continuation.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch ($continuation.label) {
                    }
                    return Unit.INSTANCE;
                }
            }
        };
        final Flow $this$map$iv6 = this.tabs;
        final Flow $this$map$iv7 = new Flow<List<? extends BrandSplashSettingTab>>() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel$special$$inlined$map$6
            public Object collect(FlowCollector collector, Continuation $completion) {
                Object collect = $this$map$iv6.collect(new AnonymousClass2(collector), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
            /* renamed from: tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel$special$$inlined$map$6$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
                @DebugMetadata(c = "tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel$special$$inlined$map$6$2", f = "BrandSplashSettingViewModel.kt", i = {}, l = {219}, m = "emit", n = {}, s = {}, v = 1)
                /* renamed from: tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel$special$$inlined$map$6$2$1  reason: invalid class name */
                /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, (Continuation) this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
                /* JADX WARN: Removed duplicated region for block: B:12:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x0037  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object value, Continuation $completion) {
                    Continuation $continuation;
                    if ($completion instanceof AnonymousClass1) {
                        $continuation = (AnonymousClass1) $completion;
                        if (($continuation.label & Integer.MIN_VALUE) != 0) {
                            $continuation.label -= Integer.MIN_VALUE;
                            Object $result = $continuation.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch ($continuation.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    FlowCollector flowCollector = this.$this_unsafeFlow;
                                    Iterable it = (List) value;
                                    Iterable $this$filterTo$iv$iv = it;
                                    Collection destination$iv$iv = new ArrayList();
                                    for (T t : $this$filterTo$iv$iv) {
                                        BrandSplashSettingTab tab = (BrandSplashSettingTab) t;
                                        if (Intrinsics.areEqual(tab.getSource(), BrandSplashSource.VIP.getValue())) {
                                            destination$iv$iv.add(t);
                                        }
                                    }
                                    $continuation.label = 1;
                                    if (flowCollector.emit((List) destination$iv$iv, $continuation) != coroutine_suspended) {
                                        break;
                                    } else {
                                        return coroutine_suspended;
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
                    $continuation = new AnonymousClass1($completion);
                    Object $result2 = $continuation.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch ($continuation.label) {
                    }
                    return Unit.INSTANCE;
                }
            }
        };
        this.vipSplash = new Flow<List<? extends BrandSplashSection>>() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel$special$$inlined$map$7
            public Object collect(FlowCollector collector, Continuation $completion) {
                Object collect = $this$map$iv7.collect(new AnonymousClass2(collector), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
            /* renamed from: tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel$special$$inlined$map$7$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
                @DebugMetadata(c = "tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel$special$$inlined$map$7$2", f = "BrandSplashSettingViewModel.kt", i = {}, l = {219}, m = "emit", n = {}, s = {}, v = 1)
                /* renamed from: tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel$special$$inlined$map$7$2$1  reason: invalid class name */
                /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, (Continuation) this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object value, Continuation $completion) {
                    Continuation $continuation;
                    if ($completion instanceof AnonymousClass1) {
                        $continuation = (AnonymousClass1) $completion;
                        if (($continuation.label & Integer.MIN_VALUE) != 0) {
                            $continuation.label -= Integer.MIN_VALUE;
                            Object $result = $continuation.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch ($continuation.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    FlowCollector flowCollector = this.$this_unsafeFlow;
                                    Iterable it = (List) value;
                                    Iterable $this$flatMapTo$iv$iv = it;
                                    Collection destination$iv$iv = new ArrayList();
                                    for (Object element$iv$iv : $this$flatMapTo$iv$iv) {
                                        BrandSplashSettingTab tab = (BrandSplashSettingTab) element$iv$iv;
                                        Iterable sections = tab.getSections();
                                        if (sections == null) {
                                            sections = CollectionsKt.emptyList();
                                        }
                                        Iterable list$iv$iv = sections;
                                        CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
                                    }
                                    $continuation.label = 1;
                                    if (flowCollector.emit((List) destination$iv$iv, $continuation) != coroutine_suspended) {
                                        break;
                                    } else {
                                        return coroutine_suspended;
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
                    $continuation = new AnonymousClass1($completion);
                    Object $result2 = $continuation.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch ($continuation.label) {
                    }
                    return Unit.INSTANCE;
                }
            }
        };
        this.unSaveState = StateFlowKt.MutableStateFlow(false);
        this.floatUiState = FlowKt.onEach(FlowKt.combine(this.selectedSplash, this.unSaveState, new BrandSplashSettingViewModel$floatUiState$1(null)), new BrandSplashSettingViewModel$floatUiState$2(null));
        this._disableSelectFlow = StateFlowKt.MutableStateFlow(false);
        this.disableSelectFlow = this._disableSelectFlow;
    }

    public final MutableStateFlow<LoadingState> getLoadingState() {
        return this.loadingState;
    }

    public final void setLoadingState(MutableStateFlow<LoadingState> mutableStateFlow) {
        Intrinsics.checkNotNullParameter(mutableStateFlow, "<set-?>");
        this.loadingState = mutableStateFlow;
    }

    public final MutableStateFlow<Boolean> isFloatSelectWindowSelect() {
        return this.isFloatSelectWindowSelect;
    }

    public final MutableStateFlow<CustomModeState> getCustomModeState() {
        return this.customModeState;
    }

    public final MutableStateFlow<Boolean> getFullPreviewMode() {
        return this.fullPreviewMode;
    }

    public final MutableStateFlow<BrandSplash> getPreviewPageEntryItem() {
        return this.previewPageEntryItem;
    }

    public final SearchPageViewModel getSearchPageViewModel() {
        return this.searchPageViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit searchPageViewModel$lambda$0(BrandSplashSettingViewModel this$0, List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this$0), (CoroutineContext) null, (CoroutineStart) null, new BrandSplashSettingViewModel$searchPageViewModel$1$1(this$0, it, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    public final MutableStateFlow<BrandSplash> getBrandSplashFromRouter() {
        return this.brandSplashFromRouter;
    }

    public final Flow<Boolean> getFloatButtonShowState() {
        return EnhancedUnmodifiabilityKt.unmodifiable(this.floatButtonShowState);
    }

    public final MutableStateFlow<BrandSplashSettingData> getBrandSplashData() {
        return this.brandSplashData;
    }

    public final Flow<List<BrandSplash>> getAllBrandSplash() {
        return EnhancedUnmodifiabilityKt.unmodifiable(this.allBrandSplash);
    }

    public final Flow<List<BrandSplash>> getPreviewBrandSplashListFlow() {
        return EnhancedUnmodifiabilityKt.unmodifiable(this.previewBrandSplashListFlow);
    }

    public final void setPreviewBrandSplashListFlow(Flow<? extends List<BrandSplash>> flow) {
        Intrinsics.checkNotNullParameter(flow, "<set-?>");
        this.previewBrandSplashListFlow = flow;
    }

    public final Flow<List<BrandSplashSettingTab>> getTabs() {
        return EnhancedUnmodifiabilityKt.unmodifiable(this.tabs);
    }

    public final Flow<List<BrandSplashSettingConfig>> getOptions() {
        return EnhancedUnmodifiabilityKt.unmodifiable(this.options);
    }

    public final Flow<List<BrandSplash>> getSelectedSplash() {
        return EnhancedUnmodifiabilityKt.unmodifiable(this.selectedSplash);
    }

    public final Flow<List<BrandSplash>> getSelectedDisplayedSplash() {
        return EnhancedUnmodifiabilityKt.unmodifiable(this.selectedDisplayedSplash);
    }

    public final MutableStateFlow<Boolean> getUnSaveState() {
        return this.unSaveState;
    }

    public final void setUnSaveState(MutableStateFlow<Boolean> mutableStateFlow) {
        Intrinsics.checkNotNullParameter(mutableStateFlow, "<set-?>");
        this.unSaveState = mutableStateFlow;
    }

    public final Flow<FloatUiState> getFloatUiState() {
        return EnhancedUnmodifiabilityKt.unmodifiable(this.floatUiState);
    }

    public final boolean getDisableSelect() {
        return this.disableSelect;
    }

    public final void setDisableSelect(boolean z) {
        this.disableSelect = z;
    }

    public final Flow<Boolean> getDisableSelectFlow() {
        return EnhancedUnmodifiabilityKt.unmodifiable(this.disableSelectFlow);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object initSelectState(Continuation<? super Unit> continuation) {
        Object collectLatest = FlowKt.collectLatest(this.selectedSplash, new BrandSplashSettingViewModel$initSelectState$2(this, null), continuation);
        return collectLatest == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collectLatest : Unit.INSTANCE;
    }

    public final void autoOpenFloat() {
        this.customModeState.setValue(new CustomModeState(true, false, null, 4, null));
        this.isFloatSelectWindowSelect.setValue(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateDisableState(boolean disable) {
        Iterable tabs;
        BrandSplashSettingData brandSplashSettingData;
        List tabs2;
        boolean z;
        List list;
        List $this$updateDisableState_u24lambda_u240_u240_u240;
        List tabs3;
        boolean z2;
        List list2;
        List $this$updateDisableState_u24lambda_u240_u240_u240_u240_u240;
        BrandSplash copy;
        List<BrandSplashSettingTab> tabs4;
        BrandSplashSettingData brandSplashSettingData2 = (BrandSplashSettingData) this.brandSplashData.getValue();
        if (brandSplashSettingData2 == null || (tabs4 = brandSplashSettingData2.getTabs()) == null || (tabs = CollectionsKt.toMutableList(tabs4)) == null) {
            tabs = CollectionsKt.emptyList();
        }
        MutableStateFlow<BrandSplashSettingData> mutableStateFlow = this.brandSplashData;
        BrandSplashSettingData brandSplashSettingData3 = (BrandSplashSettingData) this.brandSplashData.getValue();
        if (brandSplashSettingData3 != null) {
            List $this$updateDisableState_u24lambda_u240 = CollectionsKt.toMutableList(tabs);
            boolean z3 = false;
            Iterable $this$forEachIndexed$iv = tabs;
            int index = 0;
            for (Object item$iv : $this$forEachIndexed$iv) {
                int index$iv = index + 1;
                if (index < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                BrandSplashSettingTab tab = (BrandSplashSettingTab) item$iv;
                List<BrandSplashSection> sections = tab.getSections();
                if (sections == null || ($this$updateDisableState_u24lambda_u240_u240_u240 = CollectionsKt.toMutableList(sections)) == null) {
                    tabs2 = tabs;
                    z = z3;
                    list = null;
                } else {
                    Iterable sections2 = tab.getSections();
                    if (sections2 == null) {
                        tabs2 = tabs;
                        z = z3;
                    } else {
                        Iterable $this$forEachIndexed$iv2 = sections2;
                        int index$iv2 = 0;
                        for (Object item$iv2 : $this$forEachIndexed$iv2) {
                            int index$iv3 = index$iv2 + 1;
                            if (index$iv2 < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            BrandSplashSection section = (BrandSplashSection) item$iv2;
                            int index2 = index$iv2;
                            List<BrandSplash> list3 = section.getList();
                            if (list3 == null || ($this$updateDisableState_u24lambda_u240_u240_u240_u240_u240 = CollectionsKt.toMutableList(list3)) == null) {
                                tabs3 = tabs;
                                z2 = z3;
                                list2 = null;
                            } else {
                                Iterable list4 = section.getList();
                                if (list4 == null) {
                                    tabs3 = tabs;
                                    z2 = z3;
                                } else {
                                    Iterable $this$forEachIndexed$iv3 = list4;
                                    int index$iv4 = 0;
                                    for (Object item$iv3 : $this$forEachIndexed$iv3) {
                                        int index$iv5 = index$iv4 + 1;
                                        if (index$iv4 < 0) {
                                            CollectionsKt.throwIndexOverflow();
                                        }
                                        BrandSplash splash = (BrandSplash) item$iv3;
                                        copy = splash.copy((r30 & 1) != 0 ? splash.id : 0L, (r30 & 2) != 0 ? splash.thumb : null, (r30 & 4) != 0 ? splash.thumbHash : null, (r30 & 8) != 0 ? splash.thumbName : null, (r30 & 16) != 0 ? splash.logoUrl : null, (r30 & 32) != 0 ? splash.logoHash : null, (r30 & 64) != 0 ? splash.mode : null, (r30 & 128) != 0 ? splash.source : null, (r30 & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) != 0 ? splash.showLogo : false, (r30 & 512) != 0 ? splash.isSelected : false, (r30 & 1024) != 0 ? splash.isDisabled : disable && !splash.isSelected(), (r30 & IjkMediaMeta.FF_PROFILE_H264_INTRA) != 0 ? splash.isCustomModeOn : false, (r30 & 4096) != 0 ? splash.isToBeSet : false);
                                        $this$updateDisableState_u24lambda_u240_u240_u240_u240_u240.set(index$iv4, copy);
                                        index$iv4 = index$iv5;
                                        tabs = tabs;
                                        z3 = z3;
                                    }
                                    tabs3 = tabs;
                                    z2 = z3;
                                }
                                Unit unit = Unit.INSTANCE;
                                list2 = $this$updateDisableState_u24lambda_u240_u240_u240_u240_u240;
                            }
                            $this$updateDisableState_u24lambda_u240_u240_u240.set(index2, BrandSplashSection.copy$default(section, null, null, list2, null, null, 27, null));
                            index$iv2 = index$iv3;
                            tabs = tabs3;
                            z3 = z2;
                        }
                        tabs2 = tabs;
                        z = z3;
                    }
                    Unit unit2 = Unit.INSTANCE;
                    list = $this$updateDisableState_u24lambda_u240_u240_u240;
                }
                $this$updateDisableState_u24lambda_u240.set(index, BrandSplashSettingTab.copy$default(tab, null, null, list, null, 11, null));
                index = index$iv;
                tabs = tabs2;
                z3 = z;
            }
            Unit unit3 = Unit.INSTANCE;
            brandSplashSettingData = BrandSplashSettingData.copy$default(brandSplashSettingData3, $this$updateDisableState_u24lambda_u240, null, 2, null);
        } else {
            brandSplashSettingData = null;
        }
        mutableStateFlow.setValue(brandSplashSettingData);
        this.searchPageViewModel.updateDisableState(disable);
    }

    public final void updateCustomSwitchState(CustomModeState state) {
        Iterable tabs;
        BrandSplashSettingData brandSplashSettingData;
        List tabs2;
        List list;
        List $this$updateCustomSwitchState_u24lambda_u240_u240_u240;
        List tabs3;
        List list2;
        List $this$updateCustomSwitchState_u24lambda_u240_u240_u240_u240_u240;
        boolean isSelected;
        BrandSplash copy;
        List<BrandSplashSettingTab> tabs4;
        Intrinsics.checkNotNullParameter(state, "state");
        handleSwitchChangeToSaveList(state);
        BrandSplashSettingData brandSplashSettingData2 = (BrandSplashSettingData) this.brandSplashData.getValue();
        if (brandSplashSettingData2 == null || (tabs4 = brandSplashSettingData2.getTabs()) == null || (tabs = CollectionsKt.toMutableList(tabs4)) == null) {
            tabs = CollectionsKt.emptyList();
        }
        MutableStateFlow<BrandSplashSettingData> mutableStateFlow = this.brandSplashData;
        BrandSplashSettingData brandSplashSettingData3 = (BrandSplashSettingData) this.brandSplashData.getValue();
        if (brandSplashSettingData3 != null) {
            List $this$updateCustomSwitchState_u24lambda_u240 = CollectionsKt.toMutableList(tabs);
            Iterable $this$forEachIndexed$iv = tabs;
            int index = 0;
            for (Object item$iv : $this$forEachIndexed$iv) {
                int index$iv = index + 1;
                if (index < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                BrandSplashSettingTab tab = (BrandSplashSettingTab) item$iv;
                List<BrandSplashSection> sections = tab.getSections();
                if (sections == null || ($this$updateCustomSwitchState_u24lambda_u240_u240_u240 = CollectionsKt.toMutableList(sections)) == null) {
                    tabs2 = tabs;
                    list = null;
                } else {
                    Iterable sections2 = tab.getSections();
                    if (sections2 == null) {
                        tabs2 = tabs;
                    } else {
                        Iterable $this$forEachIndexed$iv2 = sections2;
                        int index$iv2 = 0;
                        for (Object item$iv2 : $this$forEachIndexed$iv2) {
                            int index$iv3 = index$iv2 + 1;
                            if (index$iv2 < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            BrandSplashSection section = (BrandSplashSection) item$iv2;
                            int index2 = index$iv2;
                            List<BrandSplash> list3 = section.getList();
                            if (list3 == null || ($this$updateCustomSwitchState_u24lambda_u240_u240_u240_u240_u240 = CollectionsKt.toMutableList(list3)) == null) {
                                tabs3 = tabs;
                                list2 = null;
                            } else {
                                Iterable list4 = section.getList();
                                if (list4 == null) {
                                    tabs3 = tabs;
                                } else {
                                    Iterable $this$forEachIndexed$iv3 = list4;
                                    int index$iv4 = 0;
                                    for (Object item$iv3 : $this$forEachIndexed$iv3) {
                                        int index$iv5 = index$iv4 + 1;
                                        if (index$iv4 < 0) {
                                            CollectionsKt.throwIndexOverflow();
                                        }
                                        BrandSplash splash = (BrandSplash) item$iv3;
                                        if (state.getCustomMode() && state.isFromPreviewPage() && Intrinsics.areEqual(BrandSplashKt.getUniqueId(splash), state.getPreviewPageChangeId())) {
                                            isSelected = true;
                                        } else {
                                            isSelected = (state.getCustomMode() && state.isFromPreviewPage()) ? false : splash.isSelected();
                                        }
                                        copy = splash.copy((r30 & 1) != 0 ? splash.id : 0L, (r30 & 2) != 0 ? splash.thumb : null, (r30 & 4) != 0 ? splash.thumbHash : null, (r30 & 8) != 0 ? splash.thumbName : null, (r30 & 16) != 0 ? splash.logoUrl : null, (r30 & 32) != 0 ? splash.logoHash : null, (r30 & 64) != 0 ? splash.mode : null, (r30 & 128) != 0 ? splash.source : null, (r30 & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) != 0 ? splash.showLogo : false, (r30 & 512) != 0 ? splash.isSelected : isSelected, (r30 & 1024) != 0 ? splash.isDisabled : false, (r30 & IjkMediaMeta.FF_PROFILE_H264_INTRA) != 0 ? splash.isCustomModeOn : state.getCustomMode(), (r30 & 4096) != 0 ? splash.isToBeSet : false);
                                        List tabs5 = tabs;
                                        int index3 = index$iv4;
                                        $this$updateCustomSwitchState_u24lambda_u240_u240_u240_u240_u240.set(index3, copy);
                                        index$iv4 = index$iv5;
                                        tabs = tabs5;
                                    }
                                    tabs3 = tabs;
                                }
                                Unit unit = Unit.INSTANCE;
                                list2 = $this$updateCustomSwitchState_u24lambda_u240_u240_u240_u240_u240;
                            }
                            $this$updateCustomSwitchState_u24lambda_u240_u240_u240.set(index2, BrandSplashSection.copy$default(section, null, null, list2, null, null, 27, null));
                            index$iv2 = index$iv3;
                            tabs = tabs3;
                        }
                        tabs2 = tabs;
                    }
                    Unit unit2 = Unit.INSTANCE;
                    list = $this$updateCustomSwitchState_u24lambda_u240_u240_u240;
                }
                $this$updateCustomSwitchState_u24lambda_u240.set(index, BrandSplashSettingTab.copy$default(tab, null, null, list, null, 11, null));
                index = index$iv;
                tabs = tabs2;
            }
            Unit unit3 = Unit.INSTANCE;
            brandSplashSettingData = BrandSplashSettingData.copy$default(brandSplashSettingData3, $this$updateCustomSwitchState_u24lambda_u240, null, 2, null);
        } else {
            brandSplashSettingData = null;
        }
        mutableStateFlow.setValue(brandSplashSettingData);
        if (!state.getCustomMode()) {
            this.unSaveState.setValue(true);
        }
    }

    public final void selectCard(BrandSplash data, FragmentManager fragmentManager) {
        BrandSplashSettingVipConfig brandSplashSettingVipConfig;
        BrandSplash copy;
        BrandSplashSetOption setOption;
        BrandSplashSetOption setOption2;
        String it;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        if (data.isDisabled()) {
            BrandSplashSettingData brandSplashSettingData = (BrandSplashSettingData) this.brandSplashData.getValue();
            if (brandSplashSettingData != null && (setOption2 = brandSplashSettingData.getSetOption()) != null && (it = setOption2.getOverflowToast()) != null) {
                if (!(it.length() > 0)) {
                    it = null;
                }
                if (it != null) {
                    PromoToast.showBottomToast(BiliContext.application(), it);
                    return;
                }
                return;
            }
            return;
        }
        BrandSplashSettingData brandSplashSettingData2 = (BrandSplashSettingData) this.brandSplashData.getValue();
        if (brandSplashSettingData2 == null || (setOption = brandSplashSettingData2.getSetOption()) == null || (brandSplashSettingVipConfig = setOption.getVipConfig()) == null) {
            brandSplashSettingVipConfig = new BrandSplashSettingVipConfig(false, false, false, 7, null);
        }
        BrandSplashSettingVipConfig vipConfig = brandSplashSettingVipConfig;
        if ((Intrinsics.areEqual(data.getSource(), BrandSplashSource.VIP.getValue()) || Intrinsics.areEqual(data.getSource(), BrandSplashSource.DLC.getValue())) && vipConfig.getLocked()) {
            if (vipConfig.getVipForbidden()) {
                PromoToast.showMidToast(BiliContext.application(), "用户账号异常，暂时无法使用权益");
                return;
            } else if (vipConfig.getVipOrderPromotion()) {
                handleByVip(fragmentManager);
                return;
            } else {
                BLog.e("[BrandSplash]BrandSplashCardTypeHolder", "handleSelectButtonClicked, id = " + data.getId() + " , locked = true。 status error");
                return;
            }
        }
        BrandSplashReporter brandSplashReporter = BrandSplashReporter.INSTANCE;
        long id = data.getId();
        String source = data.getSource();
        if (source == null) {
            source = "";
        }
        brandSplashReporter.reportCustomBrandSplashClicked(id, source, !data.isSelected());
        copy = data.copy((r30 & 1) != 0 ? data.id : 0L, (r30 & 2) != 0 ? data.thumb : null, (r30 & 4) != 0 ? data.thumbHash : null, (r30 & 8) != 0 ? data.thumbName : null, (r30 & 16) != 0 ? data.logoUrl : null, (r30 & 32) != 0 ? data.logoHash : null, (r30 & 64) != 0 ? data.mode : null, (r30 & 128) != 0 ? data.source : null, (r30 & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) != 0 ? data.showLogo : false, (r30 & 512) != 0 ? data.isSelected : !data.isSelected(), (r30 & 1024) != 0 ? data.isDisabled : false, (r30 & IjkMediaMeta.FF_PROFILE_H264_INTRA) != 0 ? data.isCustomModeOn : false, (r30 & 4096) != 0 ? data.isToBeSet : false);
        updateItem(data, copy);
        this.unSaveState.setValue(true);
    }

    private final void handleByVip(FragmentManager fragmentManager) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new BrandSplashSettingViewModel$handleByVip$1(fragmentManager, this, null), 3, (Object) null);
    }

    public final void openPreviewPage(BrandSplash data, boolean isFromSearchPage) {
        Flow<List<? extends BrandSplash>> flow;
        BrandSplash copy;
        Intrinsics.checkNotNullParameter(data, "data");
        BrandSplashReporter brandSplashReporter = BrandSplashReporter.INSTANCE;
        long id = data.getId();
        String source = data.getSource();
        if (source == null) {
            source = "";
        }
        brandSplashReporter.reportEnterPreviewPage(id, source, BrandSplashStorage.INSTANCE.isCustomMode());
        if (isFromSearchPage) {
            final Flow $this$map$iv = this.searchPageViewModel.getSearchResultData();
            flow = new Flow<List<? extends BrandSplash>>() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel$openPreviewPage$$inlined$map$1
                public Object collect(FlowCollector collector, Continuation $completion) {
                    Object collect = $this$map$iv.collect(new AnonymousClass2(collector), $completion);
                    return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                }

                /* compiled from: Emitters.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
                /* renamed from: tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel$openPreviewPage$$inlined$map$1$2  reason: invalid class name */
                /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    /* compiled from: Emitters.kt */
                    @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
                    @DebugMetadata(c = "tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel$openPreviewPage$$inlined$map$1$2", f = "BrandSplashSettingViewModel.kt", i = {}, l = {219}, m = "emit", n = {}, s = {}, v = 1)
                    /* renamed from: tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel$openPreviewPage$$inlined$map$1$2$1  reason: invalid class name */
                    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        Object L$0;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, (Continuation) this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector) {
                        this.$this_unsafeFlow = flowCollector;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
                    /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object emit(Object value, Continuation $completion) {
                        Continuation $continuation;
                        List emptyList;
                        if ($completion instanceof AnonymousClass1) {
                            $continuation = (AnonymousClass1) $completion;
                            if (($continuation.label & Integer.MIN_VALUE) != 0) {
                                $continuation.label -= Integer.MIN_VALUE;
                                Object $result = $continuation.result;
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch ($continuation.label) {
                                    case 0:
                                        ResultKt.throwOnFailure($result);
                                        FlowCollector flowCollector = this.$this_unsafeFlow;
                                        Iterable sectionData = (List) value;
                                        if (sectionData != null) {
                                            Iterable $this$flatMapTo$iv$iv = sectionData;
                                            Collection destination$iv$iv = new ArrayList();
                                            for (Object element$iv$iv : $this$flatMapTo$iv$iv) {
                                                BrandSplashSection it = (BrandSplashSection) element$iv$iv;
                                                Iterable list = it.getList();
                                                if (list == null) {
                                                    list = CollectionsKt.emptyList();
                                                }
                                                Iterable list$iv$iv = list;
                                                CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
                                            }
                                            emptyList = (List) destination$iv$iv;
                                        } else {
                                            emptyList = CollectionsKt.emptyList();
                                        }
                                        $continuation.label = 1;
                                        if (flowCollector.emit(emptyList, $continuation) != coroutine_suspended) {
                                            break;
                                        } else {
                                            return coroutine_suspended;
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
                        $continuation = new AnonymousClass1($completion);
                        Object $result2 = $continuation.result;
                        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch ($continuation.label) {
                        }
                        return Unit.INSTANCE;
                    }
                }
            };
        } else {
            flow = this.allBrandSplash;
        }
        this.previewBrandSplashListFlow = flow;
        MutableStateFlow<BrandSplash> mutableStateFlow = this.previewPageEntryItem;
        copy = data.copy((r30 & 1) != 0 ? data.id : 0L, (r30 & 2) != 0 ? data.thumb : null, (r30 & 4) != 0 ? data.thumbHash : null, (r30 & 8) != 0 ? data.thumbName : null, (r30 & 16) != 0 ? data.logoUrl : null, (r30 & 32) != 0 ? data.logoHash : null, (r30 & 64) != 0 ? data.mode : null, (r30 & 128) != 0 ? data.source : null, (r30 & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) != 0 ? data.showLogo : false, (r30 & 512) != 0 ? data.isSelected : false, (r30 & 1024) != 0 ? data.isDisabled : false, (r30 & IjkMediaMeta.FF_PROFILE_H264_INTRA) != 0 ? data.isCustomModeOn : false, (r30 & 4096) != 0 ? data.isToBeSet : false);
        mutableStateFlow.setValue(copy);
    }

    private final void handleSwitchChangeToSaveList(CustomModeState state) {
        boolean isSelected;
        BrandSplash copy;
        if (state.getCustomMode() && state.isFromPreviewPage()) {
            this.savedCustomSplash.setValue(CollectionsKt.emptyList());
        }
        MutableStateFlow<List<BrandSplash>> mutableStateFlow = this.savedCustomSplash;
        Iterable $this$map$iv = (Iterable) this.savedCustomSplash.getValue();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            BrandSplash splash = (BrandSplash) item$iv$iv;
            if (state.getCustomMode() && state.isFromPreviewPage() && Intrinsics.areEqual(BrandSplashKt.getUniqueId(splash), state.getPreviewPageChangeId())) {
                isSelected = true;
            } else {
                isSelected = (state.getCustomMode() && state.isFromPreviewPage()) ? false : splash.isSelected();
            }
            boolean isSelected2 = isSelected;
            copy = splash.copy((r30 & 1) != 0 ? splash.id : 0L, (r30 & 2) != 0 ? splash.thumb : null, (r30 & 4) != 0 ? splash.thumbHash : null, (r30 & 8) != 0 ? splash.thumbName : null, (r30 & 16) != 0 ? splash.logoUrl : null, (r30 & 32) != 0 ? splash.logoHash : null, (r30 & 64) != 0 ? splash.mode : null, (r30 & 128) != 0 ? splash.source : null, (r30 & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) != 0 ? splash.showLogo : false, (r30 & 512) != 0 ? splash.isSelected : isSelected2, (r30 & 1024) != 0 ? splash.isDisabled : false, (r30 & IjkMediaMeta.FF_PROFILE_H264_INTRA) != 0 ? splash.isCustomModeOn : state.getCustomMode(), (r30 & 4096) != 0 ? splash.isToBeSet : false);
            destination$iv$iv.add(copy);
        }
        mutableStateFlow.setValue(CollectionsKt.toList((List) destination$iv$iv));
    }

    public final Flow<List<Object>> getSplashBySource(String source) {
        if (Intrinsics.areEqual(source, BrandSplashSource.BRAND.getValue())) {
            return EnhancedUnmodifiabilityKt.unmodifiable(this.ordinarySplash);
        }
        if (Intrinsics.areEqual(source, BrandSplashSource.VIP.getValue())) {
            return EnhancedUnmodifiabilityKt.unmodifiable(this.vipSplash);
        }
        return EnhancedUnmodifiabilityKt.unmodifiable((Flow) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateRemoteSelectedState(BrandSplashSettingData data) {
        if (data == null) {
            return;
        }
        boolean isOnCustomMode = BrandSplashStorage.INSTANCE.isCustomMode();
        Iterable $this$map$iv = (Iterable) this.savedCustomSplash.getValue();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            BrandSplash it = (BrandSplash) item$iv$iv;
            destination$iv$iv.add(BrandSplashKt.getUniqueId(it));
        }
        Set saveCustomSplashSet = CollectionsKt.toSet((List) destination$iv$iv);
        Iterable $this$forEach$iv = data.getTabs();
        for (Object element$iv : $this$forEach$iv) {
            BrandSplashSettingTab tab = (BrandSplashSettingTab) element$iv;
            Iterable sections = tab.getSections();
            if (sections != null) {
                Iterable $this$forEach$iv2 = sections;
                for (Object element$iv2 : $this$forEach$iv2) {
                    BrandSplashSection section = (BrandSplashSection) element$iv2;
                    Iterable list = section.getList();
                    if (list != null) {
                        Iterable $this$forEach$iv3 = list;
                        for (Object element$iv3 : $this$forEach$iv3) {
                            BrandSplash splash = (BrandSplash) element$iv3;
                            splash.setCustomModeOn(isOnCustomMode);
                            splash.setSelected(saveCustomSplashSet.contains(BrandSplashKt.getUniqueId(splash)));
                            isOnCustomMode = isOnCustomMode;
                        }
                    }
                    isOnCustomMode = isOnCustomMode;
                }
            }
            isOnCustomMode = isOnCustomMode;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0076 A[LOOP:0: B:18:0x0070->B:20:0x0076, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object updateNewReceiveSectionSelectedState(List<BrandSplashSection> list, Continuation<? super Unit> continuation) {
        BrandSplashSettingViewModel$updateNewReceiveSectionSelectedState$1 brandSplashSettingViewModel$updateNewReceiveSectionSelectedState$1;
        Object first;
        boolean isOnCustomMode;
        Iterable newSections;
        BrandSplashSettingViewModel brandSplashSettingViewModel;
        Iterable newSections2 = EnhancedUnmodifiabilityKt.unmodifiable(list);
        if (continuation instanceof BrandSplashSettingViewModel$updateNewReceiveSectionSelectedState$1) {
            brandSplashSettingViewModel$updateNewReceiveSectionSelectedState$1 = (BrandSplashSettingViewModel$updateNewReceiveSectionSelectedState$1) continuation;
            if ((brandSplashSettingViewModel$updateNewReceiveSectionSelectedState$1.label & Integer.MIN_VALUE) != 0) {
                brandSplashSettingViewModel$updateNewReceiveSectionSelectedState$1.label -= Integer.MIN_VALUE;
                Object $result = brandSplashSettingViewModel$updateNewReceiveSectionSelectedState$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (brandSplashSettingViewModel$updateNewReceiveSectionSelectedState$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        boolean isOnCustomMode2 = BrandSplashStorage.INSTANCE.isCustomMode();
                        Flow<List<BrandSplash>> flow = this.selectedSplash;
                        brandSplashSettingViewModel$updateNewReceiveSectionSelectedState$1.L$0 = newSections2;
                        brandSplashSettingViewModel$updateNewReceiveSectionSelectedState$1.Z$0 = isOnCustomMode2;
                        brandSplashSettingViewModel$updateNewReceiveSectionSelectedState$1.label = 1;
                        first = FlowKt.first(flow, brandSplashSettingViewModel$updateNewReceiveSectionSelectedState$1);
                        if (first != coroutine_suspended) {
                            isOnCustomMode = isOnCustomMode2;
                            newSections = newSections2;
                            brandSplashSettingViewModel = this;
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        brandSplashSettingViewModel = this;
                        isOnCustomMode = brandSplashSettingViewModel$updateNewReceiveSectionSelectedState$1.Z$0;
                        newSections = (List) brandSplashSettingViewModel$updateNewReceiveSectionSelectedState$1.L$0;
                        ResultKt.throwOnFailure($result);
                        first = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Iterable $this$map$iv = (Iterable) first;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    BrandSplash it = (BrandSplash) item$iv$iv;
                    destination$iv$iv.add(BrandSplashKt.getUniqueId(it));
                }
                Set saveCustomSplashSet = CollectionsKt.toSet((List) destination$iv$iv);
                Iterable $this$forEach$iv = newSections;
                for (Object element$iv : $this$forEach$iv) {
                    BrandSplashSection section = (BrandSplashSection) element$iv;
                    Iterable list2 = section.getList();
                    if (list2 != null) {
                        Iterable $this$forEach$iv2 = list2;
                        for (Object element$iv2 : $this$forEach$iv2) {
                            BrandSplash splash = (BrandSplash) element$iv2;
                            splash.setCustomModeOn(isOnCustomMode);
                            splash.setSelected(saveCustomSplashSet.contains(BrandSplashKt.getUniqueId(splash)));
                            splash.setDisabled(splash.isSelected() ? false : brandSplashSettingViewModel.disableSelect);
                        }
                    }
                }
                return Unit.INSTANCE;
            }
        }
        brandSplashSettingViewModel$updateNewReceiveSectionSelectedState$1 = new BrandSplashSettingViewModel$updateNewReceiveSectionSelectedState$1(this, continuation);
        Object $result2 = brandSplashSettingViewModel$updateNewReceiveSectionSelectedState$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (brandSplashSettingViewModel$updateNewReceiveSectionSelectedState$1.label) {
        }
        Iterable $this$map$iv2 = (Iterable) first;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        while (r8.hasNext()) {
        }
        Set saveCustomSplashSet2 = CollectionsKt.toSet((List) destination$iv$iv2);
        Iterable $this$forEach$iv3 = newSections;
        while (r6.hasNext()) {
        }
        return Unit.INSTANCE;
    }

    public final void loadTabs() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new BrandSplashSettingViewModel$loadTabs$1(this, null), 3, (Object) null);
    }

    public final void loadMore(String source, BrandSplashSettingPageMore page) {
        Intrinsics.checkNotNullParameter(page, "page");
        BLog.i("[BrandSplash]BrandSplashSettingViewModel", "loadMore, source = " + source);
        if (this.loadingMore) {
            return;
        }
        this.loadingMore = true;
        if (source == null) {
            return;
        }
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new BrandSplashSettingViewModel$loadMore$1(source, page, this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BrandSplashSettingData copyBrandSplashData(List<BrandSplashSection> list, BrandSplashSettingPageMore page, String source) {
        Iterable tabs;
        BrandSplashSettingData data;
        List<BrandSplashSettingTab> tabs2;
        List arrayList;
        List tabs3;
        List list2;
        List $this$copyBrandSplashData_u24lambda_u240_u240_u240;
        List tabs4;
        List list3;
        List $this$copyBrandSplashData_u24lambda_u240_u240_u240_u240_u240;
        BrandSplash copy;
        List<BrandSplashSettingTab> tabs5;
        List newSections = EnhancedUnmodifiabilityKt.unmodifiable(list);
        Object obj = null;
        if (page == null) {
            return null;
        }
        BrandSplashSettingData brandSplashSettingData = (BrandSplashSettingData) this.brandSplashData.getValue();
        if (brandSplashSettingData == null || (tabs5 = brandSplashSettingData.getTabs()) == null || (tabs = CollectionsKt.toMutableList(tabs5)) == null) {
            tabs = CollectionsKt.emptyList();
        }
        BrandSplashSettingData brandSplashSettingData2 = (BrandSplashSettingData) this.brandSplashData.getValue();
        if (brandSplashSettingData2 == null) {
            data = null;
        } else {
            List $this$copyBrandSplashData_u24lambda_u240 = CollectionsKt.toMutableList(tabs);
            Iterable $this$forEachIndexed$iv = tabs;
            int index$iv = 0;
            for (Object item$iv : $this$forEachIndexed$iv) {
                int index$iv2 = index$iv + 1;
                if (index$iv < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                BrandSplashSettingTab tab = (BrandSplashSettingTab) item$iv;
                List<BrandSplashSection> sections = tab.getSections();
                if (sections == null || ($this$copyBrandSplashData_u24lambda_u240_u240_u240 = CollectionsKt.toMutableList(sections)) == null) {
                    tabs3 = tabs;
                    list2 = null;
                } else {
                    Iterable sections2 = tab.getSections();
                    if (sections2 != null) {
                        Iterable $this$forEachIndexed$iv2 = sections2;
                        int index$iv3 = 0;
                        for (Object item$iv2 : $this$forEachIndexed$iv2) {
                            int index$iv4 = index$iv3 + 1;
                            if (index$iv3 < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            BrandSplashSection section = (BrandSplashSection) item$iv2;
                            List<BrandSplash> list4 = section.getList();
                            if (list4 == null || ($this$copyBrandSplashData_u24lambda_u240_u240_u240_u240_u240 = CollectionsKt.toMutableList(list4)) == null) {
                                tabs4 = tabs;
                                list3 = null;
                            } else {
                                Iterable list5 = section.getList();
                                if (list5 == null) {
                                    tabs4 = tabs;
                                } else {
                                    Iterable $this$forEachIndexed$iv3 = list5;
                                    int index$iv5 = 0;
                                    for (Object item$iv3 : $this$forEachIndexed$iv3) {
                                        int index$iv6 = index$iv5 + 1;
                                        if (index$iv5 < 0) {
                                            CollectionsKt.throwIndexOverflow();
                                        }
                                        BrandSplash splash = (BrandSplash) item$iv3;
                                        copy = splash.copy((r30 & 1) != 0 ? splash.id : 0L, (r30 & 2) != 0 ? splash.thumb : null, (r30 & 4) != 0 ? splash.thumbHash : null, (r30 & 8) != 0 ? splash.thumbName : null, (r30 & 16) != 0 ? splash.logoUrl : null, (r30 & 32) != 0 ? splash.logoHash : null, (r30 & 64) != 0 ? splash.mode : null, (r30 & 128) != 0 ? splash.source : null, (r30 & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) != 0 ? splash.showLogo : false, (r30 & 512) != 0 ? splash.isSelected : false, (r30 & 1024) != 0 ? splash.isDisabled : false, (r30 & IjkMediaMeta.FF_PROFILE_H264_INTRA) != 0 ? splash.isCustomModeOn : false, (r30 & 4096) != 0 ? splash.isToBeSet : false);
                                        List tabs6 = tabs;
                                        int index = index$iv5;
                                        $this$copyBrandSplashData_u24lambda_u240_u240_u240_u240_u240.set(index, copy);
                                        index$iv5 = index$iv6;
                                        tabs = tabs6;
                                    }
                                    tabs4 = tabs;
                                }
                                Unit unit = Unit.INSTANCE;
                                list3 = $this$copyBrandSplashData_u24lambda_u240_u240_u240_u240_u240;
                            }
                            int index2 = index$iv3;
                            $this$copyBrandSplashData_u24lambda_u240_u240_u240.set(index2, BrandSplashSection.copy$default(section, null, null, list3, null, null, 27, null));
                            index$iv3 = index$iv4;
                            tabs = tabs4;
                        }
                        tabs3 = tabs;
                    } else {
                        tabs3 = tabs;
                    }
                    Unit unit2 = Unit.INSTANCE;
                    list2 = $this$copyBrandSplashData_u24lambda_u240_u240_u240;
                }
                $this$copyBrandSplashData_u24lambda_u240.set(index$iv, BrandSplashSettingTab.copy$default(tab, null, null, list2, null, 11, null));
                index$iv = index$iv2;
                tabs = tabs3;
            }
            obj = null;
            data = BrandSplashSettingData.copy$default(brandSplashSettingData2, $this$copyBrandSplashData_u24lambda_u240, null, 2, null);
        }
        if (data != null && (tabs2 = data.getTabs()) != null) {
            Iterator<T> it = tabs2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                BrandSplashSettingTab it2 = (BrandSplashSettingTab) next;
                if (Intrinsics.areEqual(it2.getSource(), source)) {
                    obj = next;
                    break;
                }
            }
            BrandSplashSettingTab oldTab = (BrandSplashSettingTab) obj;
            if (oldTab != null) {
                List<BrandSplashSection> sections3 = oldTab.getSections();
                if (sections3 == null || (arrayList = CollectionsKt.toMutableList(sections3)) == null) {
                    arrayList = new ArrayList();
                }
                List $this$copyBrandSplashData_u24lambda_u242_u240 = arrayList;
                $this$copyBrandSplashData_u24lambda_u242_u240.addAll(newSections);
                oldTab.setSections(arrayList);
                oldTab.setPage(page);
            }
        }
        return data;
    }

    public final void updateItem(BrandSplash old, BrandSplash brandSplash) {
        List<BrandSplashSettingTab> emptyList;
        Intrinsics.checkNotNullParameter(old, "old");
        Intrinsics.checkNotNullParameter(brandSplash, "new");
        if (Intrinsics.areEqual(old, brandSplash)) {
            return;
        }
        BrandSplashSettingData oldData = (BrandSplashSettingData) this.brandSplashData.getValue();
        if (oldData == null || (emptyList = oldData.getTabs()) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        List newTabs = updateInTab(emptyList, old, brandSplash);
        this.brandSplashData.setValue(oldData != null ? BrandSplashSettingData.copy$default(oldData, newTabs, null, 2, null) : null);
        this.searchPageViewModel.updateResult(old, brandSplash);
        updateSavedList(old, brandSplash);
    }

    private final void updateSavedList(BrandSplash old, BrandSplash brandSplash) {
        Iterable $this$any$iv = (Iterable) this.savedCustomSplash.getValue();
        boolean z = false;
        if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
            Iterator it = $this$any$iv.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object element$iv = it.next();
                if (Intrinsics.areEqual(BrandSplashKt.getUniqueId((BrandSplash) element$iv), BrandSplashKt.getUniqueId(brandSplash))) {
                    z = true;
                    break;
                }
            }
        }
        if (z) {
            MutableStateFlow<List<BrandSplash>> mutableStateFlow = this.savedCustomSplash;
            Iterable $this$map$iv = CollectionsKt.toList((Iterable) this.savedCustomSplash.getValue());
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                BrandSplash it2 = (BrandSplash) item$iv$iv;
                destination$iv$iv.add(Intrinsics.areEqual(BrandSplashKt.getUniqueId(it2), BrandSplashKt.getUniqueId(old)) ? brandSplash.copy((r30 & 1) != 0 ? brandSplash.id : 0L, (r30 & 2) != 0 ? brandSplash.thumb : null, (r30 & 4) != 0 ? brandSplash.thumbHash : null, (r30 & 8) != 0 ? brandSplash.thumbName : null, (r30 & 16) != 0 ? brandSplash.logoUrl : null, (r30 & 32) != 0 ? brandSplash.logoHash : null, (r30 & 64) != 0 ? brandSplash.mode : null, (r30 & 128) != 0 ? brandSplash.source : null, (r30 & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) != 0 ? brandSplash.showLogo : false, (r30 & 512) != 0 ? brandSplash.isSelected : false, (r30 & 1024) != 0 ? brandSplash.isDisabled : false, (r30 & IjkMediaMeta.FF_PROFILE_H264_INTRA) != 0 ? brandSplash.isCustomModeOn : false, (r30 & 4096) != 0 ? brandSplash.isToBeSet : false) : it2.copy((r30 & 1) != 0 ? it2.id : 0L, (r30 & 2) != 0 ? it2.thumb : null, (r30 & 4) != 0 ? it2.thumbHash : null, (r30 & 8) != 0 ? it2.thumbName : null, (r30 & 16) != 0 ? it2.logoUrl : null, (r30 & 32) != 0 ? it2.logoHash : null, (r30 & 64) != 0 ? it2.mode : null, (r30 & 128) != 0 ? it2.source : null, (r30 & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) != 0 ? it2.showLogo : false, (r30 & 512) != 0 ? it2.isSelected : false, (r30 & 1024) != 0 ? it2.isDisabled : false, (r30 & IjkMediaMeta.FF_PROFILE_H264_INTRA) != 0 ? it2.isCustomModeOn : false, (r30 & 4096) != 0 ? it2.isToBeSet : false));
            }
            mutableStateFlow.setValue((List) destination$iv$iv);
            return;
        }
        MutableStateFlow<List<BrandSplash>> mutableStateFlow2 = this.savedCustomSplash;
        ArrayList $this$updateSavedList_u24lambda_u242 = new ArrayList();
        $this$updateSavedList_u24lambda_u242.add(brandSplash);
        $this$updateSavedList_u24lambda_u242.addAll((Collection) this.savedCustomSplash.getValue());
        mutableStateFlow2.setValue($this$updateSavedList_u24lambda_u242);
    }

    private final List<BrandSplashSettingTab> updateInTab(List<BrandSplashSettingTab> list, BrandSplash old, BrandSplash brandSplash) {
        Iterable tabs = EnhancedUnmodifiabilityKt.unmodifiable(list);
        List $this$updateInTab_u24lambda_u240 = CollectionsKt.toMutableList((Collection) tabs);
        Iterable $this$forEachIndexed$iv = tabs;
        int index = 0;
        for (Object item$iv : $this$forEachIndexed$iv) {
            int index$iv = index + 1;
            if (index < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            BrandSplashSettingTab tab = (BrandSplashSettingTab) item$iv;
            List<BrandSplashSection> sections = tab.getSections();
            if (sections == null) {
                sections = CollectionsKt.emptyList();
            }
            $this$updateInTab_u24lambda_u240.set(index, BrandSplashSettingTab.copy$default(tab, null, null, BrandSplashSettingViewModelKt.updateInSection(sections, old, brandSplash), null, 11, null));
            index = index$iv;
        }
        return EnhancedUnmodifiabilityKt.unmodifiable($this$updateInTab_u24lambda_u240);
    }

    public final void saveCustomSplash() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new BrandSplashSettingViewModel$saveCustomSplash$1(this, null), 3, (Object) null);
    }

    /* compiled from: BrandSplashSettingViewModel.kt */
    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B8\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012'\u0010\u0004\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0005¢\u0006\u0004\b\f\u0010\rJ\u0016\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"J\u000e\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u0012J\u0006\u0010&\u001a\u00020\u000bJ\u0006\u0010'\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\u0004\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001a\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u001b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Ltv/danmaku/bili/ui/splash/brand/uiv2/setting/vm/BrandSplashSettingViewModel$SearchPageViewModel;", "", "viewModelScope", "Lkotlinx/coroutines/CoroutineScope;", "updateNewReceiveSectionSelectedState", "Lkotlin/Function1;", "", "Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSection;", "Lkotlin/ParameterName;", "name", "newSections", "", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function1;)V", "service", "Ltv/danmaku/bili/ui/splash/brand/service/BrandSplashService;", "searchFragmentShowing", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "getSearchFragmentShowing", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "searchTerm", "", "getSearchTerm", "lastPageMore", "Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSettingPageMore;", "_searchResultData", "searchResultData", "Lkotlinx/coroutines/flow/Flow;", "getSearchResultData", "()Lkotlinx/coroutines/flow/Flow;", "searchPageLoading", "updateResult", "old", "Ltv/danmaku/bili/ui/splash/brand/model/BrandSplash;", "new", "updateDisableState", "disable", "clear", "search", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class SearchPageViewModel {
        public static final int $stable = 8;
        private final MutableStateFlow<List<BrandSplashSection>> _searchResultData;
        private BrandSplashSettingPageMore lastPageMore;
        private final MutableStateFlow<Boolean> searchFragmentShowing;
        private boolean searchPageLoading;
        private final Flow<List<BrandSplashSection>> searchResultData;
        private final MutableStateFlow<String> searchTerm;
        private final BrandSplashService service;
        private final Function1<List<BrandSplashSection>, Unit> updateNewReceiveSectionSelectedState;
        private final CoroutineScope viewModelScope;

        /* JADX WARN: Multi-variable type inference failed */
        public SearchPageViewModel(CoroutineScope viewModelScope, Function1<? super List<BrandSplashSection>, Unit> function1) {
            Intrinsics.checkNotNullParameter(viewModelScope, "viewModelScope");
            Intrinsics.checkNotNullParameter(function1, "updateNewReceiveSectionSelectedState");
            this.viewModelScope = viewModelScope;
            this.updateNewReceiveSectionSelectedState = function1;
            Object createService = ServiceGenerator.createService(BrandSplashService.class);
            Intrinsics.checkNotNullExpressionValue(createService, "createService(...)");
            this.service = (BrandSplashService) createService;
            this.searchFragmentShowing = StateFlowKt.MutableStateFlow(false);
            this.searchTerm = StateFlowKt.MutableStateFlow("");
            this._searchResultData = StateFlowKt.MutableStateFlow((Object) null);
            this.searchResultData = this._searchResultData;
        }

        public final MutableStateFlow<Boolean> getSearchFragmentShowing() {
            return this.searchFragmentShowing;
        }

        public final MutableStateFlow<String> getSearchTerm() {
            return this.searchTerm;
        }

        public final Flow<List<BrandSplashSection>> getSearchResultData() {
            return EnhancedUnmodifiabilityKt.unmodifiable(this.searchResultData);
        }

        public final void updateResult(BrandSplash old, BrandSplash brandSplash) {
            Intrinsics.checkNotNullParameter(old, "old");
            Intrinsics.checkNotNullParameter(brandSplash, "new");
            List it = (List) this._searchResultData.getValue();
            if (it != null) {
                this._searchResultData.setValue(BrandSplashSettingViewModelKt.updateInSection(it, old, brandSplash));
            }
        }

        public final void updateDisableState(boolean disable) {
            List list;
            List $this$updateDisableState_u24lambda_u240;
            List list2;
            List $this$updateDisableState_u24lambda_u240_u240_u240;
            BrandSplash copy;
            MutableStateFlow<List<BrandSplashSection>> mutableStateFlow = this._searchResultData;
            List list3 = (List) this._searchResultData.getValue();
            if (list3 == null || ($this$updateDisableState_u24lambda_u240 = CollectionsKt.toMutableList(list3)) == null) {
                list = null;
            } else {
                List $this$forEachIndexed$iv = $this$updateDisableState_u24lambda_u240;
                int index$iv = 0;
                for (Object item$iv : $this$forEachIndexed$iv) {
                    int index$iv2 = index$iv + 1;
                    if (index$iv < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    BrandSplashSection section = (BrandSplashSection) item$iv;
                    List<BrandSplash> list4 = section.getList();
                    if (list4 == null || ($this$updateDisableState_u24lambda_u240_u240_u240 = CollectionsKt.toMutableList(list4)) == null) {
                        list2 = null;
                    } else {
                        Iterable list5 = section.getList();
                        if (list5 != null) {
                            Iterable $this$forEachIndexed$iv2 = list5;
                            int index$iv3 = 0;
                            for (Object item$iv2 : $this$forEachIndexed$iv2) {
                                int index$iv4 = index$iv3 + 1;
                                if (index$iv3 < 0) {
                                    CollectionsKt.throwIndexOverflow();
                                }
                                BrandSplash splash = (BrandSplash) item$iv2;
                                copy = splash.copy((r30 & 1) != 0 ? splash.id : 0L, (r30 & 2) != 0 ? splash.thumb : null, (r30 & 4) != 0 ? splash.thumbHash : null, (r30 & 8) != 0 ? splash.thumbName : null, (r30 & 16) != 0 ? splash.logoUrl : null, (r30 & 32) != 0 ? splash.logoHash : null, (r30 & 64) != 0 ? splash.mode : null, (r30 & 128) != 0 ? splash.source : null, (r30 & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) != 0 ? splash.showLogo : false, (r30 & 512) != 0 ? splash.isSelected : false, (r30 & 1024) != 0 ? splash.isDisabled : disable && !splash.isSelected(), (r30 & IjkMediaMeta.FF_PROFILE_H264_INTRA) != 0 ? splash.isCustomModeOn : false, (r30 & 4096) != 0 ? splash.isToBeSet : false);
                                int index = index$iv3;
                                $this$updateDisableState_u24lambda_u240_u240_u240.set(index, copy);
                                index$iv3 = index$iv4;
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                        list2 = $this$updateDisableState_u24lambda_u240_u240_u240;
                    }
                    $this$updateDisableState_u24lambda_u240.set(index$iv, BrandSplashSection.copy$default(section, null, null, list2, null, null, 27, null));
                    index$iv = index$iv2;
                }
                list = $this$updateDisableState_u24lambda_u240;
            }
            mutableStateFlow.setValue(list);
        }

        public final void clear() {
            this._searchResultData.setValue((Object) null);
            this.searchTerm.setValue("");
            this.lastPageMore = null;
            this.searchPageLoading = false;
        }

        public final void search() {
            if (this.searchPageLoading) {
                return;
            }
            BrandSplashSettingPageMore brandSplashSettingPageMore = this.lastPageMore;
            boolean z = false;
            if (brandSplashSettingPageMore != null && brandSplashSettingPageMore.getHasMore()) {
                z = true;
            }
            if (z) {
                return;
            }
            this.searchPageLoading = true;
            BuildersKt.launch$default(this.viewModelScope, (CoroutineContext) null, (CoroutineStart) null, new BrandSplashSettingViewModel$SearchPageViewModel$search$1(this, null), 3, (Object) null);
        }
    }
}