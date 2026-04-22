package tv.danmaku.bili.ui.favorites;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.appcompat.R;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bilibili.adcommon.utils.ext.AdExtensions;
import com.bilibili.app.comm.list.common.utils.UriSafeKt;
import com.bilibili.app.comm.list.widget.statement.ErrorState;
import com.bilibili.app.comm.list.widget.statement.PlaceHolderState;
import com.bilibili.app.comm.list.widget.statement.StatePageKt;
import com.bilibili.app.comm.list.widget.text.MessageString;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.base.viewbinding.ViewBindingProperty;
import com.bilibili.base.viewbinding.full.CreateMethod;
import com.bilibili.base.viewbinding.full.ReflectionActivityViewBindings;
import com.bilibili.base.viewbinding.internal.UtilsKt;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.BaseAppCompatActivity;
import com.bilibili.lib.ui.garb.Garb;
import com.bilibili.lib.ui.garb.GarbManager;
import com.bilibili.lib.ui.util.StatusBarCompat;
import com.bilibili.magicasakura.utils.ThemeUtils;
import com.bilibili.moduleservice.appwidget.AutoAddAppWidgetService;
import com.bilibili.moduleservice.appwidget.GuideScene;
import com.bilibili.moduleservice.appwidget.IFunctionWidgetGuide;
import com.bilibili.pvtracker.IPvTracker;
import com.bilibili.pvtracker.PageViewTracker;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.databinding.BiliAppActivityCollectionV2Binding;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.favorite.BaseFavoritesFragment;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;
import tv.danmaku.bili.ui.favorites.model.Tab;
import tv.danmaku.bili.ui.favorites.state.FavPageState;
import tv.danmaku.bili.ui.favorites.state.FavoritesPageAction;
import tv.danmaku.bili.ui.favorites.viewmodel.FavoritesActivityViewModel;
import tv.danmaku.bili.ui.main2.reporter.MineReporter;

/* compiled from: FavoritesActivityV2.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u0017H\u0002J\b\u0010\u001b\u001a\u00020\u0017H\u0002J\b\u0010\u001c\u001a\u00020\u0017H\u0002J\u0012\u0010\u001d\u001a\u00020\u00172\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\u001b\u0010 \u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0002\u0010#J\u001b\u0010$\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0002\u0010#J\u0014\u0010%\u001a\u00020\u0017*\u00020&2\u0006\u0010'\u001a\u00020(H\u0002J\u001a\u0010)\u001a\u0004\u0018\u00010**\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0002J\b\u0010-\u001a\u00020*H\u0016J\b\u0010.\u001a\u00020\u0019H\u0016J\u000e\u0010/\u001a\u00020\u00172\u0006\u00100\u001a\u000201J\u001a\u0010/\u001a\u00020\u00172\b\b\u0002\u00102\u001a\u0002032\b\b\u0002\u00104\u001a\u000205J\u0006\u00106\u001a\u00020\u0017J\b\u00107\u001a\u00020\u0017H\u0016R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u00068"}, d2 = {"Ltv/danmaku/bili/ui/favorites/FavoritesActivityV2;", "Lcom/bilibili/lib/ui/BaseAppCompatActivity;", "Lcom/bilibili/pvtracker/IPvTracker;", "Lcom/bilibili/moduleservice/appwidget/IFunctionWidgetGuide;", "<init>", "()V", "binding", "Ltv/danmaku/bili/databinding/BiliAppActivityCollectionV2Binding;", "getBinding", "()Ltv/danmaku/bili/databinding/BiliAppActivityCollectionV2Binding;", "binding$delegate", "Lcom/bilibili/base/viewbinding/ViewBindingProperty;", "viewModel", "Ltv/danmaku/bili/ui/favorites/viewmodel/FavoritesActivityViewModel;", "getViewModel", "()Ltv/danmaku/bili/ui/favorites/viewmodel/FavoritesActivityViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "defaultTabId", "", "getDefaultTabId", "()I", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "parseParams", "initUI", "collectFlow", "tintStatusBar", AudioIntentHelper.FROM_ACTIVITY, "Landroid/app/Activity;", "getToolbarBgColor", "garb", "Lcom/bilibili/lib/ui/garb/Garb;", "(Lcom/bilibili/lib/ui/garb/Garb;)Ljava/lang/Integer;", "getToolbarTextColor", "setTabSelected", "Landroid/view/View;", "selected", "", "appendParams", "", BaseFavoritesFragment.TAB, "Ltv/danmaku/bili/ui/favorites/model/Tab;", "getPvEventId", "getPvExtra", "showErrorView", "pageState", "Ltv/danmaku/bili/ui/favorites/state/FavPageState;", "placeState", "Lcom/bilibili/app/comm/list/widget/statement/PlaceHolderState;", AuthResultCbHelper.ARGS_STATE, "Lcom/bilibili/app/comm/list/widget/statement/ErrorState;", "hideErrorView", "onBackPressed", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FavoritesActivityV2 extends BaseAppCompatActivity implements IPvTracker, IFunctionWidgetGuide {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(FavoritesActivityV2.class, "binding", "getBinding()Ltv/danmaku/bili/databinding/BiliAppActivityCollectionV2Binding;", 0))};
    public static final int $stable = 8;
    private final ViewBindingProperty binding$delegate;
    private final Lazy viewModel$delegate;

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public /* synthetic */ boolean appendEndExtra() {
        return IPvTracker.-CC.$default$appendEndExtra(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    public /* synthetic */ String getUniqueKey() {
        return IPvTracker.-CC.$default$getUniqueKey(this);
    }

    public /* synthetic */ boolean shouldReport() {
        return IPvTracker.-CC.$default$shouldReport(this);
    }

    public FavoritesActivityV2() {
        ComponentActivity $this$viewBinding_u24default$iv = (ComponentActivity) this;
        CreateMethod createMethod$iv = CreateMethod.INFLATE;
        Function1 onViewDestroyed$iv = UtilsKt.emptyVbCallback();
        this.binding$delegate = ReflectionActivityViewBindings.inflateViewBindingActivity($this$viewBinding_u24default$iv, BiliAppActivityCollectionV2Binding.class, createMethod$iv, onViewDestroyed$iv);
        final ComponentActivity $this$viewModels_u24default$iv = (ComponentActivity) this;
        Function0 factoryPromise$iv = new Function0<ViewModelProvider.Factory>() { // from class: tv.danmaku.bili.ui.favorites.FavoritesActivityV2$special$$inlined$viewModels$default$1
            /* renamed from: invoke */
            public final ViewModelProvider.Factory m1593invoke() {
                return $this$viewModels_u24default$iv.getDefaultViewModelProviderFactory();
            }
        };
        this.viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(FavoritesActivityViewModel.class), new Function0<ViewModelStore>() { // from class: tv.danmaku.bili.ui.favorites.FavoritesActivityV2$special$$inlined$viewModels$default$2
            /* renamed from: invoke */
            public final ViewModelStore m1594invoke() {
                return $this$viewModels_u24default$iv.getViewModelStore();
            }
        }, factoryPromise$iv, new Function0<CreationExtras>() { // from class: tv.danmaku.bili.ui.favorites.FavoritesActivityV2$special$$inlined$viewModels$default$3
            /* renamed from: invoke */
            public final CreationExtras m1595invoke() {
                CreationExtras creationExtras;
                Function0 function0 = r1;
                return (function0 == null || (creationExtras = (CreationExtras) function0.invoke()) == null) ? $this$viewModels_u24default$iv.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BiliAppActivityCollectionV2Binding getBinding() {
        return (BiliAppActivityCollectionV2Binding) this.binding$delegate.getValue(this, $$delegatedProperties[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FavoritesActivityViewModel getViewModel() {
        return (FavoritesActivityViewModel) this.viewModel$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getDefaultTabId() {
        String queryParameter;
        Uri data = getIntent().getData();
        int i = 0;
        if (data != null && (queryParameter = data.getQueryParameter("default_tab_id")) != null) {
            i = AdExtensions.toIntOrDefault(queryParameter, 0);
        }
        int paramsDefaultTabId = i;
        if (paramsDefaultTabId != 0) {
            return paramsDefaultTabId;
        }
        return getViewModel().getCurDefaultTabId();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        parseParams();
        setContentView((View) getBinding().getRoot());
        tintStatusBar((Activity) this);
        initUI();
        BLRouter $this$iv = BLRouter.INSTANCE;
        AutoAddAppWidgetService autoAddAppWidgetService = (AutoAddAppWidgetService) $this$iv.get(AutoAddAppWidgetService.class, MineReporter.MINE_ICON_TYPE_DEFAULT);
        if (autoAddAppWidgetService != null) {
            autoAddAppWidgetService.startFunctionWidgetGuide((FragmentActivity) this, new GuideScene.Favorites(FavoritesConstsKt.PV_MAIN_FAVORITES_PAGE));
        }
    }

    private final void parseParams() {
        Uri $this$parseParams_u24lambda_u240 = getIntent().getData();
        if ($this$parseParams_u24lambda_u240 != null) {
            FavoritesActivityViewModel viewModel = getViewModel();
            String queryParameter = $this$parseParams_u24lambda_u240.getQueryParameter("from_spmid");
            if (queryParameter == null) {
                queryParameter = "";
            }
            viewModel.setFromSpmid(queryParameter);
        }
    }

    private final void initUI() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new FavoritesActivityV2$initUI$1(this, null), 3, (Object) null);
        BiliAppActivityCollectionV2Binding $this$initUI_u24lambda_u240 = getBinding();
        Integer toolbarBgColor$default = getToolbarBgColor$default(this, null, 1, null);
        if (toolbarBgColor$default != null) {
            $this$initUI_u24lambda_u240.toolBarContainer.setBackgroundColor(toolbarBgColor$default.intValue());
        }
        Integer toolbarTextColor$default = getToolbarTextColor$default(this, null, 1, null);
        if (toolbarTextColor$default != null) {
            int it = toolbarTextColor$default.intValue();
            $this$initUI_u24lambda_u240.manageTitle.setTextColor(it);
            $this$initUI_u24lambda_u240.cancelManage.setTextColor(it);
            $this$initUI_u24lambda_u240.toolBarTitle.setTextColor(it);
            $this$initUI_u24lambda_u240.tabLayout.setSelectedTabIndicatorColor(it);
            $this$initUI_u24lambda_u240.navTopBar.setIconTintColorWithGarb(it);
        }
        $this$initUI_u24lambda_u240.viewPager.setOffscreenPageLimit(-1);
        $this$initUI_u24lambda_u240.navTopBar.setNavigationOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.favorites.FavoritesActivityV2$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FavoritesActivityV2.this.onBackPressed();
            }
        });
        collectFlow();
    }

    private final void collectFlow() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new FavoritesActivityV2$collectFlow$1(this, null), 3, (Object) null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new FavoritesActivityV2$collectFlow$2(this, null), 3, (Object) null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new FavoritesActivityV2$collectFlow$3(this, null), 3, (Object) null);
    }

    private final void tintStatusBar(Activity activity) {
        if (activity == null) {
            return;
        }
        StatusBarCompat.tintStatusBar(activity, ThemeUtils.getThemeAttrColor(activity, R.attr.colorPrimary));
        Garb garb = GarbManager.getCurGarb();
        if (garb.isPure() || garb.isPrimaryOnly()) {
            StatusBarCompat.tintStatusBar(activity, ThemeUtils.getThemeAttrColor(activity, R.attr.colorPrimary));
        } else {
            StatusBarCompat.tintStatusBar(activity, garb.getSecondaryPageColor(), garb.isDarkMode() ? 1 : 2);
        }
    }

    static /* synthetic */ Integer getToolbarBgColor$default(FavoritesActivityV2 favoritesActivityV2, Garb garb, int i, Object obj) {
        if ((i & 1) != 0) {
            garb = null;
        }
        return favoritesActivityV2.getToolbarBgColor(garb);
    }

    private final Integer getToolbarBgColor(Garb garb) {
        int colorById;
        Garb realGarb = garb == null ? GarbManager.getCurGarb() : garb;
        Garb it = realGarb;
        if (!it.isPure() && !it.isPrimaryOnly()) {
            colorById = it.getSecondaryPageColor();
        } else if (it.isPure() && !it.isWhite() && !it.isNight()) {
            colorById = ThemeUtils.getColorById((Context) this, com.bilibili.app.comm.baseres.R.color.theme_color_primary_tr_background);
        } else {
            return null;
        }
        return Integer.valueOf(colorById);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Integer getToolbarTextColor$default(FavoritesActivityV2 favoritesActivityV2, Garb garb, int i, Object obj) {
        if ((i & 1) != 0) {
            garb = null;
        }
        return favoritesActivityV2.getToolbarTextColor(garb);
    }

    private final Integer getToolbarTextColor(Garb garb) {
        Garb realGarb = garb == null ? GarbManager.getCurGarb() : garb;
        Garb it = realGarb;
        if (!it.isPure() && !it.isPrimaryOnly()) {
            return Integer.valueOf(it.getFontColor());
        }
        if (it.isPure() && !it.isWhite() && !it.isNight()) {
            return Integer.valueOf(ThemeUtils.getColorById((Context) this, com.bilibili.app.comm.baseres.R.color.theme_color_primary_tr_title));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTabSelected(View $this$setTabSelected, boolean selected) {
        View badge;
        TextView text = (TextView) $this$setTabSelected.findViewById(tv.danmaku.bili.R.id.tab_title);
        if (text == null || (badge = $this$setTabSelected.findViewById(tv.danmaku.bili.R.id.badge)) == null) {
            return;
        }
        if (selected) {
            Integer toolbarTextColor$default = getToolbarTextColor$default(this, null, 1, null);
            text.setTextColor(toolbarTextColor$default != null ? toolbarTextColor$default.intValue() : ThemeUtils.getColorById($this$setTabSelected.getContext(), com.bilibili.lib.theme.R.color.Brand_pink));
            text.setTypeface(null, 1);
            text.setAlpha(1.0f);
            if (badge.getVisibility() == 0) {
                ListExtentionsKt.gone(badge);
                return;
            }
            return;
        }
        Integer toolbarTextColor$default2 = getToolbarTextColor$default(this, null, 1, null);
        text.setTextColor(toolbarTextColor$default2 != null ? toolbarTextColor$default2.intValue() : ThemeUtils.getColorById($this$setTabSelected.getContext(), com.bilibili.lib.theme.R.color.Text1));
        text.setAlpha(0.68f);
        text.setTypeface(null, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String appendParams(String $this$appendParams, Tab tab) {
        String str = $this$appendParams;
        if ((str == null || StringsKt.isBlank(str)) || tab == null) {
            return $this$appendParams;
        }
        Uri.Builder builder = Uri.parse($this$appendParams).buildUpon();
        Intrinsics.checkNotNull(builder);
        UriSafeKt.safetyAppendQueryParameter(builder, FavoritesConstsKt.KEY_FAV_TAB_ID, String.valueOf(tab.getTabId()));
        UriSafeKt.safetyAppendQueryParameter(builder, FavoritesConstsKt.KEY_RED_DOT, String.valueOf(tab.getRedDot()));
        String tabName = tab.getTabName();
        if (tabName == null) {
            tabName = "";
        }
        UriSafeKt.safetyAppendQueryParameter(builder, "tab_name", tabName);
        return builder.toString();
    }

    public String getPvEventId() {
        return FavoritesConstsKt.PV_MAIN_FAVORITES_PAGE;
    }

    public Bundle getPvExtra() {
        Bundle $this$getPvExtra_u24lambda_u240 = new Bundle();
        $this$getPvExtra_u24lambda_u240.putString(FavoritesConstsKt.ACTION_ID, PageViewTracker.getInstance().currentPolarisActionId());
        return $this$getPvExtra_u24lambda_u240;
    }

    public final void showErrorView(FavPageState pageState) {
        Intrinsics.checkNotNullParameter(pageState, "pageState");
        if (Intrinsics.areEqual(pageState, FavPageState.Success.INSTANCE)) {
            ListExtentionsKt.gone(getBinding().toolBarTitle);
            hideErrorView();
        } else if (Intrinsics.areEqual(pageState, FavPageState.Init.INSTANCE)) {
            ListExtentionsKt.visible(getBinding().toolBarTitle);
            showErrorView$default(this, PlaceHolderState.LoadingHolder.INSTANCE, null, 2, null);
        } else if (Intrinsics.areEqual(pageState, FavPageState.NetworkError.INSTANCE)) {
            ListExtentionsKt.visible(getBinding().toolBarTitle);
            showErrorView$default(this, null, new ErrorState.NetworkError(0, (MessageString) null, new MessageString.ResourceString(bili.resource.common.R.string.common_global_string_16), new MessageString.ResourceString(bili.resource.common.R.string.common_global_string_213), false, 19, (DefaultConstructorMarker) null), 1, null);
        } else {
            ListExtentionsKt.visible(getBinding().toolBarTitle);
            showErrorView$default(this, null, new ErrorState.OtherError(0, (MessageString) null, new MessageString.ResourceString(bili.resource.common.R.string.common_global_string_164), new MessageString.ResourceString(bili.resource.common.R.string.common_global_string_213), false, 19, (DefaultConstructorMarker) null), 1, null);
        }
    }

    public static /* synthetic */ void showErrorView$default(FavoritesActivityV2 favoritesActivityV2, PlaceHolderState placeHolderState, ErrorState errorState, int i, Object obj) {
        if ((i & 1) != 0) {
            placeHolderState = (PlaceHolderState) PlaceHolderState.ErrorHolder.INSTANCE;
        }
        if ((i & 2) != 0) {
            errorState = (ErrorState) new ErrorState.OtherError(0, (MessageString) null, (MessageString) null, (MessageString) null, false, 31, (DefaultConstructorMarker) null);
        }
        favoritesActivityV2.showErrorView(placeHolderState, errorState);
    }

    public final void showErrorView(final PlaceHolderState placeState, final ErrorState state) {
        Intrinsics.checkNotNullParameter(placeState, "placeState");
        Intrinsics.checkNotNullParameter(state, AuthResultCbHelper.ARGS_STATE);
        ListExtentionsKt.visible(getBinding().errorView);
        getBinding().errorView.setContent(ComposableLambdaKt.composableLambdaInstance(-273028371, true, new Function2() { // from class: tv.danmaku.bili.ui.favorites.FavoritesActivityV2$$ExternalSyntheticLambda2
            public final Object invoke(Object obj, Object obj2) {
                Unit showErrorView$lambda$0;
                showErrorView$lambda$0 = FavoritesActivityV2.showErrorView$lambda$0(placeState, state, this, (Composer) obj, ((Integer) obj2).intValue());
                return showErrorView$lambda$0;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showErrorView$lambda$0(final PlaceHolderState $placeState, final ErrorState $state, final FavoritesActivityV2 this$0, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C390@15881L199,390@15871L209:FavoritesActivityV2.kt#57ex5w");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-273028371, $changed, -1, "tv.danmaku.bili.ui.favorites.FavoritesActivityV2.showErrorView.<anonymous> (FavoritesActivityV2.kt:390)");
            }
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(-754670427, true, new Function2() { // from class: tv.danmaku.bili.ui.favorites.FavoritesActivityV2$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit showErrorView$lambda$0$0;
                    showErrorView$lambda$0$0 = FavoritesActivityV2.showErrorView$lambda$0$0($placeState, $state, this$0, (Composer) obj, ((Integer) obj2).intValue());
                    return showErrorView$lambda$0$0;
                }
            }, $composer, 54), $composer, (int) BR.negativeBtnVisible, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showErrorView$lambda$0$0(PlaceHolderState $placeState, ErrorState $state, final FavoritesActivityV2 this$0, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C391@15960L106,391@15899L167:FavoritesActivityV2.kt#57ex5w");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-754670427, $changed, -1, "tv.danmaku.bili.ui.favorites.FavoritesActivityV2.showErrorView.<anonymous>.<anonymous> (FavoritesActivityV2.kt:391)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, 611195311, "CC(remember):FavoritesActivityV2.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance(this$0);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: tv.danmaku.bili.ui.favorites.FavoritesActivityV2$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        Unit showErrorView$lambda$0$0$0$0;
                        showErrorView$lambda$0$0$0$0 = FavoritesActivityV2.showErrorView$lambda$0$0$0$0(FavoritesActivityV2.this);
                        return showErrorView$lambda$0$0$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            StatePageKt.StatePage($placeState, $state, (Function0) it$iv, $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showErrorView$lambda$0$0$0$0(FavoritesActivityV2 this$0) {
        this$0.getViewModel().sendAction(new FavoritesPageAction.GetTabData(this$0.getDefaultTabId()));
        return Unit.INSTANCE;
    }

    public final void hideErrorView() {
        ListExtentionsKt.gone(getBinding().errorView);
    }

    public void onBackPressed() {
        BLRouter $this$iv = BLRouter.INSTANCE;
        AutoAddAppWidgetService autoAddAppWidgetService = (AutoAddAppWidgetService) $this$iv.get(AutoAddAppWidgetService.class, MineReporter.MINE_ICON_TYPE_DEFAULT);
        boolean z = false;
        if (autoAddAppWidgetService != null && !autoAddAppWidgetService.closeFunctionWidgetGuide((FragmentActivity) this, new GuideScene.Favorites(FavoritesConstsKt.PV_MAIN_FAVORITES_PAGE))) {
            z = true;
        }
        if (z) {
            super.onBackPressed();
        }
    }
}