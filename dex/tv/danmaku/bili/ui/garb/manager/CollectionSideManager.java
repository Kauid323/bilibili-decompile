package tv.danmaku.bili.ui.garb.manager;

import ComposableSingletons$CustomBottomSheetKt$;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import com.bili.digital.common.data.BiliCollectionPreferenceData;
import com.bilibili.app.authorspace.ui.nft.utils.SpaceNftUtils;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.ImageRequestBuilder;
import com.bilibili.lib.image2.bean.ScaleType;
import com.bilibili.ogv.infra.compose.DrawableResourceKt;
import com.bilibili.ogv.infra.ui.DimensionKt;
import com.bilibili.okretro.BiliApiDataCallback;
import com.bilibili.okretro.ServiceGenerator;
import com.bilibili.okretro.response.BiliApiResponse;
import com.bilibili.okretro.response.BiliApiResponseKt;
import com.bilibili.xpref.Xpref;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.databinding.BiliAppDialogDigitalCollectionRoomBinding;
import tv.danmaku.bili.ui.garb.api.BiliNftApiManager;
import tv.danmaku.bili.ui.garb.api.CollectionReporterHelper;
import tv.danmaku.bili.ui.garb.api.CollectionSetting;
import tv.danmaku.bili.ui.garb.api.collection.AllCollectionSettingJumpUrlPageFrom;
import tv.danmaku.bili.ui.garb.api.collection.BiliCollectionGlobalInfoSideBarData;
import tv.danmaku.bili.ui.garb.api.collection.TopCollectionSettingJumpUrlPageFrom;

/* compiled from: CollectionSideManager.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 32\u00020\u0001:\u000234B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010 \u001a\u00020!2\b\u0010\u0015\u001a\u0004\u0018\u00010\t2\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020\rJ\u0010\u0010%\u001a\u00020!2\u0006\u0010\u0015\u001a\u00020\tH\u0002J\u0018\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\u000bH\u0002J\b\u0010)\u001a\u00020!H\u0002J\u000e\u0010*\u001a\u00020!2\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010+\u001a\u00020!J\u0006\u0010,\u001a\u00020!J\u001f\u0010-\u001a\u00020!2\u0006\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u000200H\u0003¢\u0006\u0002\u00101J\b\u00102\u001a\u00020!H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R/\u0010\u0015\u001a\u0004\u0018\u00010\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\t8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065²\u0006\n\u0010.\u001a\u00020\u000bX\u008a\u008e\u0002"}, d2 = {"Ltv/danmaku/bili/ui/garb/manager/CollectionSideManager;", "", "binding", "Ltv/danmaku/bili/databinding/BiliAppDialogDigitalCollectionRoomBinding;", "<init>", "(Ltv/danmaku/bili/databinding/BiliAppDialogDigitalCollectionRoomBinding;)V", "getBinding", "()Ltv/danmaku/bili/databinding/BiliAppDialogDigitalCollectionRoomBinding;", "mData", "Ltv/danmaku/bili/ui/garb/api/collection/BiliCollectionGlobalInfoSideBarData;", "isShow", "", "avatarUrl", "", "coroutineScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "getCoroutineScope", "()Landroidx/lifecycle/LifecycleCoroutineScope;", "coroutineScope$delegate", "Lkotlin/Lazy;", "<set-?>", "data", "getData", "()Ltv/danmaku/bili/ui/garb/api/collection/BiliCollectionGlobalInfoSideBarData;", "setData", "(Ltv/danmaku/bili/ui/garb/api/collection/BiliCollectionGlobalInfoSideBarData;)V", "data$delegate", "Landroidx/compose/runtime/MutableState;", "menuTagData", "", "", "Ltv/danmaku/bili/ui/garb/manager/CollectionSideManager$MenuTagData;", "initData", "", "preference", "Lcom/bili/digital/common/data/BiliCollectionPreferenceData;", "url", "initMenuTagDisplayable", "setMenuTagDisplayable", "containerId", "displayable", "updateUI", "refreshCollectionVisible", "closeDrawer", "initView", "NftContainerUI", "newTagVisible", "modifier", "Landroidx/compose/ui/Modifier;", "(ZLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "refreshRealGiftUI", "Companion", "MenuTagData", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class CollectionSideManager {
    public static final String APP_WIDGET_BADGE_SHOWED_KEY = "app_widget_badge_showed_key";
    public static final String SPLASH_SETTING_BADGE_SHOWED_KEY = "splash_setting_badge_showed_key";
    private String avatarUrl;
    private final BiliAppDialogDigitalCollectionRoomBinding binding;
    private final Lazy coroutineScope$delegate;
    private final MutableState data$delegate;
    private boolean isShow;
    private BiliCollectionGlobalInfoSideBarData mData;
    private final Map<Integer, MenuTagData> menuTagData;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NftContainerUI$lambda$1(CollectionSideManager collectionSideManager, boolean z, Modifier modifier, int i, int i2, Composer composer, int i3) {
        collectionSideManager.NftContainerUI(z, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public CollectionSideManager(BiliAppDialogDigitalCollectionRoomBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
        this.isShow = true;
        this.avatarUrl = "";
        this.coroutineScope$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.garb.manager.CollectionSideManager$$ExternalSyntheticLambda26
            public final Object invoke() {
                LifecycleCoroutineScope coroutineScope_delegate$lambda$0;
                coroutineScope_delegate$lambda$0 = CollectionSideManager.coroutineScope_delegate$lambda$0(CollectionSideManager.this);
                return coroutineScope_delegate$lambda$0;
            }
        });
        this.data$delegate = SnapshotStateKt.mutableStateOf$default(this.mData, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.menuTagData = MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(R.id.collection_theme_container), new MenuTagData(new Function1() { // from class: tv.danmaku.bili.ui.garb.manager.CollectionSideManager$$ExternalSyntheticLambda28
            public final Object invoke(Object obj) {
                boolean menuTagData$lambda$0;
                menuTagData$lambda$0 = CollectionSideManager.menuTagData$lambda$0((BiliCollectionGlobalInfoSideBarData) obj);
                return Boolean.valueOf(menuTagData$lambda$0);
            }
        }, null)), TuplesKt.to(Integer.valueOf(R.id.collection_emoticon_container), new MenuTagData(new Function1() { // from class: tv.danmaku.bili.ui.garb.manager.CollectionSideManager$$ExternalSyntheticLambda29
            public final Object invoke(Object obj) {
                boolean menuTagData$lambda$1;
                menuTagData$lambda$1 = CollectionSideManager.menuTagData$lambda$1((BiliCollectionGlobalInfoSideBarData) obj);
                return Boolean.valueOf(menuTagData$lambda$1);
            }
        }, null)), TuplesKt.to(Integer.valueOf(R.id.collection_space_background_container), new MenuTagData(new Function1() { // from class: tv.danmaku.bili.ui.garb.manager.CollectionSideManager$$ExternalSyntheticLambda30
            public final Object invoke(Object obj) {
                boolean menuTagData$lambda$2;
                menuTagData$lambda$2 = CollectionSideManager.menuTagData$lambda$2((BiliCollectionGlobalInfoSideBarData) obj);
                return Boolean.valueOf(menuTagData$lambda$2);
            }
        }, null)), TuplesKt.to(Integer.valueOf(R.id.collection_avatar_pendant_container), new MenuTagData(new Function1() { // from class: tv.danmaku.bili.ui.garb.manager.CollectionSideManager$$ExternalSyntheticLambda31
            public final Object invoke(Object obj) {
                boolean menuTagData$lambda$3;
                menuTagData$lambda$3 = CollectionSideManager.menuTagData$lambda$3((BiliCollectionGlobalInfoSideBarData) obj);
                return Boolean.valueOf(menuTagData$lambda$3);
            }
        }, null)), TuplesKt.to(Integer.valueOf(R.id.collection_startup_container), new MenuTagData(new Function1() { // from class: tv.danmaku.bili.ui.garb.manager.CollectionSideManager$$ExternalSyntheticLambda33
            public final Object invoke(Object obj) {
                boolean menuTagData$lambda$4;
                menuTagData$lambda$4 = CollectionSideManager.menuTagData$lambda$4((BiliCollectionGlobalInfoSideBarData) obj);
                return Boolean.valueOf(menuTagData$lambda$4);
            }
        }, null)), TuplesKt.to(Integer.valueOf(R.id.collection_comment_background_container), new MenuTagData(new Function1() { // from class: tv.danmaku.bili.ui.garb.manager.CollectionSideManager$$ExternalSyntheticLambda34
            public final Object invoke(Object obj) {
                boolean menuTagData$lambda$5;
                menuTagData$lambda$5 = CollectionSideManager.menuTagData$lambda$5((BiliCollectionGlobalInfoSideBarData) obj);
                return Boolean.valueOf(menuTagData$lambda$5);
            }
        }, "card_bg")), TuplesKt.to(Integer.valueOf(R.id.collection_dynamic_card_container), new MenuTagData(new Function1() { // from class: tv.danmaku.bili.ui.garb.manager.CollectionSideManager$$ExternalSyntheticLambda35
            public final Object invoke(Object obj) {
                boolean menuTagData$lambda$6;
                menuTagData$lambda$6 = CollectionSideManager.menuTagData$lambda$6((BiliCollectionGlobalInfoSideBarData) obj);
                return Boolean.valueOf(menuTagData$lambda$6);
            }
        }, "card")), TuplesKt.to(Integer.valueOf(R.id.collection_comb_container), new MenuTagData(new Function1() { // from class: tv.danmaku.bili.ui.garb.manager.CollectionSideManager$$ExternalSyntheticLambda36
            public final Object invoke(Object obj) {
                boolean menuTagData$lambda$7;
                menuTagData$lambda$7 = CollectionSideManager.menuTagData$lambda$7((BiliCollectionGlobalInfoSideBarData) obj);
                return Boolean.valueOf(menuTagData$lambda$7);
            }
        }, null)), TuplesKt.to(Integer.valueOf(R.id.collection_loading_container), new MenuTagData(new Function1() { // from class: tv.danmaku.bili.ui.garb.manager.CollectionSideManager$$ExternalSyntheticLambda37
            public final Object invoke(Object obj) {
                boolean menuTagData$lambda$8;
                menuTagData$lambda$8 = CollectionSideManager.menuTagData$lambda$8((BiliCollectionGlobalInfoSideBarData) obj);
                return Boolean.valueOf(menuTagData$lambda$8);
            }
        }, null)), TuplesKt.to(Integer.valueOf(R.id.collection_progress_bar_container), new MenuTagData(new Function1() { // from class: tv.danmaku.bili.ui.garb.manager.CollectionSideManager$$ExternalSyntheticLambda27
            public final Object invoke(Object obj) {
                boolean menuTagData$lambda$9;
                menuTagData$lambda$9 = CollectionSideManager.menuTagData$lambda$9((BiliCollectionGlobalInfoSideBarData) obj);
                return Boolean.valueOf(menuTagData$lambda$9);
            }
        }, null))});
    }

    public final BiliAppDialogDigitalCollectionRoomBinding getBinding() {
        return this.binding;
    }

    private final LifecycleCoroutineScope getCoroutineScope() {
        return (LifecycleCoroutineScope) this.coroutineScope$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LifecycleCoroutineScope coroutineScope_delegate$lambda$0(CollectionSideManager this$0) {
        View root = this$0.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get(root);
        if (lifecycleOwner != null) {
            return LifecycleOwnerKt.getLifecycleScope(lifecycleOwner);
        }
        return null;
    }

    private final BiliCollectionGlobalInfoSideBarData getData() {
        State $this$getValue$iv = this.data$delegate;
        return (BiliCollectionGlobalInfoSideBarData) $this$getValue$iv.getValue();
    }

    private final void setData(BiliCollectionGlobalInfoSideBarData biliCollectionGlobalInfoSideBarData) {
        MutableState $this$setValue$iv = this.data$delegate;
        $this$setValue$iv.setValue(biliCollectionGlobalInfoSideBarData);
    }

    /* compiled from: CollectionSideManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Ltv/danmaku/bili/ui/garb/manager/CollectionSideManager$Companion;", "", "<init>", "()V", "SPLASH_SETTING_BADGE_SHOWED_KEY", "", "APP_WIDGET_BADGE_SHOWED_KEY", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean menuTagData$lambda$0(BiliCollectionGlobalInfoSideBarData $this$MenuTagData) {
        Intrinsics.checkNotNullParameter($this$MenuTagData, "$this$MenuTagData");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean menuTagData$lambda$1(BiliCollectionGlobalInfoSideBarData $this$MenuTagData) {
        Intrinsics.checkNotNullParameter($this$MenuTagData, "$this$MenuTagData");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean menuTagData$lambda$2(BiliCollectionGlobalInfoSideBarData $this$MenuTagData) {
        Intrinsics.checkNotNullParameter($this$MenuTagData, "$this$MenuTagData");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean menuTagData$lambda$3(BiliCollectionGlobalInfoSideBarData $this$MenuTagData) {
        Intrinsics.checkNotNullParameter($this$MenuTagData, "$this$MenuTagData");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean menuTagData$lambda$4(BiliCollectionGlobalInfoSideBarData $this$MenuTagData) {
        Intrinsics.checkNotNullParameter($this$MenuTagData, "$this$MenuTagData");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean menuTagData$lambda$5(BiliCollectionGlobalInfoSideBarData $this$MenuTagData) {
        Intrinsics.checkNotNullParameter($this$MenuTagData, "$this$MenuTagData");
        return $this$MenuTagData.getCardBackgroundHasNew();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean menuTagData$lambda$6(BiliCollectionGlobalInfoSideBarData $this$MenuTagData) {
        Intrinsics.checkNotNullParameter($this$MenuTagData, "$this$MenuTagData");
        return $this$MenuTagData.getCardHasNew();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean menuTagData$lambda$7(BiliCollectionGlobalInfoSideBarData $this$MenuTagData) {
        Intrinsics.checkNotNullParameter($this$MenuTagData, "$this$MenuTagData");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean menuTagData$lambda$8(BiliCollectionGlobalInfoSideBarData $this$MenuTagData) {
        Intrinsics.checkNotNullParameter($this$MenuTagData, "$this$MenuTagData");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean menuTagData$lambda$9(BiliCollectionGlobalInfoSideBarData $this$MenuTagData) {
        Intrinsics.checkNotNullParameter($this$MenuTagData, "$this$MenuTagData");
        return false;
    }

    /* compiled from: CollectionSideManager.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B,\u0012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\r\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u000fR\"\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Ltv/danmaku/bili/ui/garb/manager/CollectionSideManager$MenuTagData;", "", "tagDisplayable", "Lkotlin/Function1;", "Ltv/danmaku/bili/ui/garb/api/collection/BiliCollectionGlobalInfoSideBarData;", "", "Lkotlin/ExtensionFunctionType;", "removingLabelRequestParam", "", "<init>", "(Lkotlin/jvm/functions/Function1;Ljava/lang/String;)V", "getTagDisplayable", "()Lkotlin/jvm/functions/Function1;", "reportTagRemoved", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class MenuTagData {
        public static final int $stable = 0;
        private final String removingLabelRequestParam;
        private final Function1<BiliCollectionGlobalInfoSideBarData, Boolean> tagDisplayable;

        /* JADX WARN: Multi-variable type inference failed */
        public MenuTagData(Function1<? super BiliCollectionGlobalInfoSideBarData, Boolean> function1, String removingLabelRequestParam) {
            Intrinsics.checkNotNullParameter(function1, "tagDisplayable");
            this.tagDisplayable = function1;
            this.removingLabelRequestParam = removingLabelRequestParam;
        }

        public /* synthetic */ MenuTagData(Function1 function1, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(function1, (i & 2) != 0 ? null : str);
        }

        public final Function1<BiliCollectionGlobalInfoSideBarData, Boolean> getTagDisplayable() {
            return this.tagDisplayable;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object reportTagRemoved(Continuation<? super Unit> continuation) {
            CollectionSideManager$MenuTagData$reportTagRemoved$1 collectionSideManager$MenuTagData$reportTagRemoved$1;
            Object reportMenuTagRemove;
            if (continuation instanceof CollectionSideManager$MenuTagData$reportTagRemoved$1) {
                collectionSideManager$MenuTagData$reportTagRemoved$1 = (CollectionSideManager$MenuTagData$reportTagRemoved$1) continuation;
                if ((collectionSideManager$MenuTagData$reportTagRemoved$1.label & Integer.MIN_VALUE) != 0) {
                    collectionSideManager$MenuTagData$reportTagRemoved$1.label -= Integer.MIN_VALUE;
                    Object $result = collectionSideManager$MenuTagData$reportTagRemoved$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (collectionSideManager$MenuTagData$reportTagRemoved$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            if (this.removingLabelRequestParam != null) {
                                String str = this.removingLabelRequestParam;
                                collectionSideManager$MenuTagData$reportTagRemoved$1.label = 1;
                                reportMenuTagRemove = ((DigitalTagService) ServiceGenerator.createService(DigitalTagService.class)).reportMenuTagRemove(str, collectionSideManager$MenuTagData$reportTagRemoved$1);
                                if (reportMenuTagRemove == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                Result.box-impl(BiliApiResponseKt.asResult((BiliApiResponse) reportMenuTagRemove));
                                break;
                            }
                            break;
                        case 1:
                            ResultKt.throwOnFailure($result);
                            reportMenuTagRemove = $result;
                            Result.box-impl(BiliApiResponseKt.asResult((BiliApiResponse) reportMenuTagRemove));
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    return Unit.INSTANCE;
                }
            }
            collectionSideManager$MenuTagData$reportTagRemoved$1 = new CollectionSideManager$MenuTagData$reportTagRemoved$1(this, continuation);
            Object $result2 = collectionSideManager$MenuTagData$reportTagRemoved$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (collectionSideManager$MenuTagData$reportTagRemoved$1.label) {
            }
            return Unit.INSTANCE;
        }
    }

    public final void initData(BiliCollectionGlobalInfoSideBarData data, BiliCollectionPreferenceData preference, String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.mData = data;
        setData(data);
        this.isShow = preference != null ? preference.getCollectionPublic() : true;
        this.avatarUrl = url;
        updateUI();
        if (data != null) {
            initMenuTagDisplayable(data);
        }
    }

    private final void initMenuTagDisplayable(BiliCollectionGlobalInfoSideBarData data) {
        Map $this$forEach$iv = this.menuTagData;
        for (Map.Entry element$iv : $this$forEach$iv.entrySet()) {
            int containerId = element$iv.getKey().intValue();
            MenuTagData menuTagData = element$iv.getValue();
            if (((Boolean) menuTagData.getTagDisplayable().invoke(data)).booleanValue()) {
                setMenuTagDisplayable(containerId, true);
            }
        }
    }

    private final void setMenuTagDisplayable(int containerId, boolean displayable) {
        Context context = this.binding.getRoot().getContext();
        ConstraintLayout $this$setMenuTagDisplayable_u24lambda_u240 = this.binding.getRoot().findViewById(containerId);
        View tagText = $this$setMenuTagDisplayable_u24lambda_u240.findViewWithTag("menu_tag");
        if (!displayable) {
            if (tagText != null) {
                $this$setMenuTagDisplayable_u24lambda_u240.removeView(tagText);
                CoroutineScope coroutineScope = getCoroutineScope();
                if (coroutineScope != null) {
                    BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new CollectionSideManager$setMenuTagDisplayable$1$1(this, containerId, null), 3, (Object) null);
                }
            }
        } else if (tagText == null) {
            TextView $this$setMenuTagDisplayable_u24lambda_u240_u240 = new TextView(context);
            $this$setMenuTagDisplayable_u24lambda_u240_u240.setTag("menu_tag");
            ConstraintLayout.LayoutParams $this$setMenuTagDisplayable_u24lambda_u240_u240_u240 = new ConstraintLayout.LayoutParams(-2, -2);
            View childAt = $this$setMenuTagDisplayable_u24lambda_u240.getChildAt(1);
            int menuTextViewId = childAt != null ? childAt.getId() : 0;
            $this$setMenuTagDisplayable_u24lambda_u240_u240_u240.startToEnd = menuTextViewId;
            $this$setMenuTagDisplayable_u24lambda_u240_u240_u240.topToTop = menuTextViewId;
            $this$setMenuTagDisplayable_u24lambda_u240_u240_u240.bottomToBottom = menuTextViewId;
            Intrinsics.checkNotNull(context);
            $this$setMenuTagDisplayable_u24lambda_u240_u240_u240.leftMargin = DimensionKt.dpToPxSize(10.0f, context);
            $this$setMenuTagDisplayable_u24lambda_u240_u240.setLayoutParams((ViewGroup.LayoutParams) $this$setMenuTagDisplayable_u24lambda_u240_u240_u240);
            $this$setMenuTagDisplayable_u24lambda_u240_u240.setText("新");
            $this$setMenuTagDisplayable_u24lambda_u240_u240.setTextSize(8.0f);
            $this$setMenuTagDisplayable_u24lambda_u240_u240.setTextColor(-1);
            ShapeDrawable $this$setMenuTagDisplayable_u24lambda_u240_u240_u241 = new ShapeDrawable();
            $this$setMenuTagDisplayable_u24lambda_u240_u240_u241.setShape(new RoundRectShape(new float[]{2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f}, null, null));
            $this$setMenuTagDisplayable_u24lambda_u240_u240_u241.getPaint().setColor(ContextCompat.getColor(context, com.bilibili.lib.theme.R.color.Brand_pink));
            $this$setMenuTagDisplayable_u24lambda_u240_u240.setBackground($this$setMenuTagDisplayable_u24lambda_u240_u240_u241);
            $this$setMenuTagDisplayable_u24lambda_u240_u240.setPadding(DimensionKt.dpToPxSize(3.0f, context), DimensionKt.dpToPxSize(2.0f, context), DimensionKt.dpToPxSize(3.0f, context), DimensionKt.dpToPxSize(2.0f, context));
            $this$setMenuTagDisplayable_u24lambda_u240.addView($this$setMenuTagDisplayable_u24lambda_u240_u240);
        }
    }

    private final void updateUI() {
        refreshCollectionVisible(this.isShow);
        BiliImageLoader biliImageLoader = BiliImageLoader.INSTANCE;
        Context context = this.binding.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        ImageRequestBuilder.placeholderImageResId$default(biliImageLoader.with(context).url(this.avatarUrl), com.bilibili.app.comm.baseres.R.drawable.ic_default_avatar, (ScaleType) null, 2, (Object) null).into(this.binding.collectionMySetting.getImageView());
        refreshRealGiftUI();
    }

    public final void refreshCollectionVisible(boolean isShow) {
        Drawable drawable;
        AppCompatImageView appCompatImageView = this.binding.collectionEye;
        if (isShow) {
            drawable = this.binding.getRoot().getContext().getResources().getDrawable(R.drawable.collection_eye);
        } else {
            drawable = this.binding.getRoot().getContext().getResources().getDrawable(R.drawable.collection_eye_off);
        }
        appCompatImageView.setImageDrawable(drawable);
    }

    public final void closeDrawer() {
        this.binding.collectionDrawerlayout.closeDrawer(8388613);
    }

    public final void initView() {
        this.binding.collectionMenuButton.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.manager.CollectionSideManager$$ExternalSyntheticLambda21
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CollectionSideManager.initView$lambda$0(CollectionSideManager.this, view);
            }
        });
        BiliImageLoader biliImageLoader = BiliImageLoader.INSTANCE;
        Context context = this.binding.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        ImageRequestBuilder.placeholderImageResId$default(biliImageLoader.with(context).url(this.avatarUrl), com.bilibili.app.comm.baseres.R.drawable.ic_default_avatar, (ScaleType) null, 2, (Object) null).into(this.binding.collectionMySetting.getImageView());
        this.binding.collectionEye.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.manager.CollectionSideManager$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CollectionSideManager.initView$lambda$1(CollectionSideManager.this, view);
            }
        });
        this.binding.collectionTopRightArrow.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.manager.CollectionSideManager$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CollectionSideManager.initView$lambda$2(CollectionSideManager.this, view);
            }
        });
        this.binding.collectionTopSettingContainer.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.manager.CollectionSideManager$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CollectionSideManager.initView$lambda$3(CollectionSideManager.this, view);
            }
        });
        this.binding.collectionAllSettingsRightArrow.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.manager.CollectionSideManager$$ExternalSyntheticLambda17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CollectionSideManager.initView$lambda$4(CollectionSideManager.this, view);
            }
        });
        this.binding.collectionAllSettingsContainer.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.manager.CollectionSideManager$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CollectionSideManager.initView$lambda$5(CollectionSideManager.this, view);
            }
        });
        this.binding.collectionMyDressAll.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.manager.CollectionSideManager$$ExternalSyntheticLambda19
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CollectionSideManager.initView$lambda$6(CollectionSideManager.this, view);
            }
        });
        this.binding.collectionMyDressAllRightArrow.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.manager.CollectionSideManager$$ExternalSyntheticLambda20
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CollectionSideManager.initView$lambda$7(CollectionSideManager.this, view);
            }
        });
        this.binding.collectionThemeRightArrow.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.manager.CollectionSideManager$$ExternalSyntheticLambda22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CollectionSideManager.initView$lambda$8(CollectionSideManager.this, view);
            }
        });
        this.binding.collectionThemeContainer.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.manager.CollectionSideManager$$ExternalSyntheticLambda23
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CollectionSideManager.initView$lambda$9(CollectionSideManager.this, view);
            }
        });
        this.binding.collectionEmoticonRightArrow.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.manager.CollectionSideManager$$ExternalSyntheticLambda32
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CollectionSideManager.initView$lambda$10(CollectionSideManager.this, view);
            }
        });
        this.binding.collectionEmoticonContainer.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.manager.CollectionSideManager$$ExternalSyntheticLambda39
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CollectionSideManager.initView$lambda$11(CollectionSideManager.this, view);
            }
        });
        this.binding.collectionSpaceBackgroundRightArrow.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.manager.CollectionSideManager$$ExternalSyntheticLambda40
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CollectionSideManager.initView$lambda$12(CollectionSideManager.this, view);
            }
        });
        this.binding.collectionSpaceBackgroundContainer.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.manager.CollectionSideManager$$ExternalSyntheticLambda41
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CollectionSideManager.initView$lambda$13(CollectionSideManager.this, view);
            }
        });
        this.binding.collectionAvatarPendantRightArrow.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.manager.CollectionSideManager$$ExternalSyntheticLambda42
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CollectionSideManager.initView$lambda$14(CollectionSideManager.this, view);
            }
        });
        this.binding.collectionAvatarPendantContainer.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.manager.CollectionSideManager$$ExternalSyntheticLambda43
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CollectionSideManager.initView$lambda$15(CollectionSideManager.this, view);
            }
        });
        this.binding.collectionStartupRightArrow.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.manager.CollectionSideManager$$ExternalSyntheticLambda44
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CollectionSideManager.initView$lambda$16(CollectionSideManager.this, view);
            }
        });
        Context context2 = this.binding.collectionStartupBadge.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        final SharedPreferences sharedPreferences = Xpref.getDefaultSharedPreferences(context2);
        boolean badgeShowed = sharedPreferences.getBoolean(SPLASH_SETTING_BADGE_SHOWED_KEY, false);
        this.binding.collectionStartupBadge.setVisibility(!badgeShowed ? 0 : 8);
        this.binding.collectionStartupContainer.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.manager.CollectionSideManager$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CollectionSideManager.initView$lambda$17(CollectionSideManager.this, sharedPreferences, view);
            }
        });
        boolean appWidgetBadgeShowed = sharedPreferences.getBoolean(APP_WIDGET_BADGE_SHOWED_KEY, false);
        this.binding.collectionAppWidgetBadge.setVisibility(appWidgetBadgeShowed ? 8 : 0);
        this.binding.collectionAppWidgetContainer.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.manager.CollectionSideManager$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CollectionSideManager.initView$lambda$18(CollectionSideManager.this, sharedPreferences, view);
            }
        });
        this.binding.collectionNftContainer.setContent(ComposableLambdaKt.composableLambdaInstance(732493645, true, new Function2() { // from class: tv.danmaku.bili.ui.garb.manager.CollectionSideManager$$ExternalSyntheticLambda2
            public final Object invoke(Object obj, Object obj2) {
                Unit initView$lambda$19;
                initView$lambda$19 = CollectionSideManager.initView$lambda$19(CollectionSideManager.this, (Composer) obj, ((Integer) obj2).intValue());
                return initView$lambda$19;
            }
        }));
        this.binding.collectionCommentBackgroundRightArrow.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.manager.CollectionSideManager$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CollectionSideManager.initView$lambda$20(CollectionSideManager.this, view);
            }
        });
        this.binding.collectionCommentBackgroundContainer.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.manager.CollectionSideManager$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CollectionSideManager.initView$lambda$21(CollectionSideManager.this, view);
            }
        });
        this.binding.collectionDynamicCardRightArrow.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.manager.CollectionSideManager$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CollectionSideManager.initView$lambda$22(CollectionSideManager.this, view);
            }
        });
        this.binding.collectionDynamicCardContainer.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.manager.CollectionSideManager$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CollectionSideManager.initView$lambda$23(CollectionSideManager.this, view);
            }
        });
        this.binding.collectionCombRightArrow.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.manager.CollectionSideManager$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CollectionSideManager.initView$lambda$24(CollectionSideManager.this, view);
            }
        });
        this.binding.collectionCombContainer.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.manager.CollectionSideManager$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CollectionSideManager.initView$lambda$25(CollectionSideManager.this, view);
            }
        });
        this.binding.collectionLoadingRightArrow.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.manager.CollectionSideManager$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CollectionSideManager.initView$lambda$26(CollectionSideManager.this, view);
            }
        });
        this.binding.collectionLoadingContainer.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.manager.CollectionSideManager$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CollectionSideManager.initView$lambda$27(CollectionSideManager.this, view);
            }
        });
        this.binding.collectionProgressBarRightArrow.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.manager.CollectionSideManager$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CollectionSideManager.initView$lambda$28(CollectionSideManager.this, view);
            }
        });
        this.binding.collectionProgressBarContainer.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.manager.CollectionSideManager$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CollectionSideManager.initView$lambda$29(CollectionSideManager.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(CollectionSideManager this$0, View it) {
        this$0.binding.collectionDrawerlayout.openDrawer(8388613);
        CollectionReporterHelper.INSTANCE.reportCollectionSettingClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(final CollectionSideManager this$0, View it) {
        BiliNftApiManager.INSTANCE.setCollectionVisible(!this$0.isShow, new BiliApiDataCallback<CollectionSetting>() { // from class: tv.danmaku.bili.ui.garb.manager.CollectionSideManager$initView$2$1
            public void onError(Throwable t) {
                ToastHelper.showToast(CollectionSideManager.this.getBinding().getRoot().getContext(), "设置失败，请稍后重试", 0);
            }

            public void onDataSuccess(CollectionSetting data) {
                boolean z;
                boolean z2;
                boolean z3;
                CollectionSideManager collectionSideManager = CollectionSideManager.this;
                z = CollectionSideManager.this.isShow;
                collectionSideManager.isShow = !z;
                CollectionSideManager collectionSideManager2 = CollectionSideManager.this;
                z2 = CollectionSideManager.this.isShow;
                collectionSideManager2.refreshCollectionVisible(z2);
                Context context = CollectionSideManager.this.getBinding().getRoot().getContext();
                z3 = CollectionSideManager.this.isShow;
                ToastHelper.showToast(context, z3 ? "已取消隐藏收藏馆主页内容" : "已隐藏收藏馆主页内容", 0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(CollectionSideManager this$0, View it) {
        String it2;
        BiliCollectionGlobalInfoSideBarData biliCollectionGlobalInfoSideBarData = this$0.mData;
        if (biliCollectionGlobalInfoSideBarData != null && (it2 = biliCollectionGlobalInfoSideBarData.getTopSettingJumpUrl()) != null) {
            SpaceNftUtils.INSTANCE.routeWithMap(it2, MapsKt.mapOf(TuplesKt.to("page_from", TopCollectionSettingJumpUrlPageFrom.DRAWER_BAR_SETTING_BUTTON.getReportValue())), this$0.binding.getRoot().getContext());
        }
        CollectionReporterHelper.INSTANCE.reportCollectionSettingItemClick(101);
        this$0.closeDrawer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(CollectionSideManager this$0, View it) {
        String it2;
        BiliCollectionGlobalInfoSideBarData biliCollectionGlobalInfoSideBarData = this$0.mData;
        if (biliCollectionGlobalInfoSideBarData != null && (it2 = biliCollectionGlobalInfoSideBarData.getTopSettingJumpUrl()) != null) {
            SpaceNftUtils.INSTANCE.routeWithMap(it2, MapsKt.mapOf(TuplesKt.to("page_from", TopCollectionSettingJumpUrlPageFrom.DRAWER_BAR_SETTING_BUTTON.getReportValue())), this$0.binding.getRoot().getContext());
        }
        CollectionReporterHelper.INSTANCE.reportCollectionSettingItemClick(101);
        this$0.closeDrawer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4(CollectionSideManager this$0, View it) {
        String it2;
        BiliCollectionGlobalInfoSideBarData biliCollectionGlobalInfoSideBarData = this$0.mData;
        if (biliCollectionGlobalInfoSideBarData != null && (it2 = biliCollectionGlobalInfoSideBarData.getAllSettingJumpUrl()) != null) {
            SpaceNftUtils.INSTANCE.routeWithMap(it2, MapsKt.mapOf(TuplesKt.to("page_from", AllCollectionSettingJumpUrlPageFrom.DRAWER_BAR_SETTING_BUTTON.getReportValue())), this$0.binding.getRoot().getContext());
        }
        CollectionReporterHelper.INSTANCE.reportCollectionSettingItemClick(102);
        this$0.closeDrawer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$5(CollectionSideManager this$0, View it) {
        String it2;
        BiliCollectionGlobalInfoSideBarData biliCollectionGlobalInfoSideBarData = this$0.mData;
        if (biliCollectionGlobalInfoSideBarData != null && (it2 = biliCollectionGlobalInfoSideBarData.getAllSettingJumpUrl()) != null) {
            SpaceNftUtils.INSTANCE.routeWithMap(it2, MapsKt.mapOf(TuplesKt.to("page_from", AllCollectionSettingJumpUrlPageFrom.DRAWER_BAR_SETTING_BUTTON.getReportValue())), this$0.binding.getRoot().getContext());
        }
        CollectionReporterHelper.INSTANCE.reportCollectionSettingItemClick(102);
        this$0.closeDrawer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$6(CollectionSideManager this$0, View it) {
        String it2;
        BiliCollectionGlobalInfoSideBarData biliCollectionGlobalInfoSideBarData = this$0.mData;
        if (biliCollectionGlobalInfoSideBarData != null && (it2 = biliCollectionGlobalInfoSideBarData.getGarbAllJumpUrl()) != null) {
            SpaceNftUtils.INSTANCE.routeTo(it2, this$0.binding.getRoot().getContext());
        }
        CollectionReporterHelper.INSTANCE.reportCollectionSettingAllClick();
        this$0.closeDrawer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$7(CollectionSideManager this$0, View it) {
        String it2;
        BiliCollectionGlobalInfoSideBarData biliCollectionGlobalInfoSideBarData = this$0.mData;
        if (biliCollectionGlobalInfoSideBarData != null && (it2 = biliCollectionGlobalInfoSideBarData.getGarbAllJumpUrl()) != null) {
            SpaceNftUtils.INSTANCE.routeTo(it2, this$0.binding.getRoot().getContext());
        }
        CollectionReporterHelper.INSTANCE.reportCollectionSettingAllClick();
        this$0.closeDrawer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$8(CollectionSideManager this$0, View it) {
        String it2;
        BiliCollectionGlobalInfoSideBarData biliCollectionGlobalInfoSideBarData = this$0.mData;
        if (biliCollectionGlobalInfoSideBarData != null && (it2 = biliCollectionGlobalInfoSideBarData.getSkinJumpUrl()) != null) {
            Map map = new LinkedHashMap();
            map.put("from", "collect_asset");
            map.put("f_source", "collection");
            SpaceNftUtils.INSTANCE.routeWithMap(it2, map, this$0.binding.getRoot().getContext());
        }
        CollectionReporterHelper.INSTANCE.reportCollectionSettingItemClick(9);
        this$0.closeDrawer();
        this$0.setMenuTagDisplayable(this$0.binding.collectionThemeContainer.getId(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$9(CollectionSideManager this$0, View it) {
        String it2;
        BiliCollectionGlobalInfoSideBarData biliCollectionGlobalInfoSideBarData = this$0.mData;
        if (biliCollectionGlobalInfoSideBarData != null && (it2 = biliCollectionGlobalInfoSideBarData.getSkinJumpUrl()) != null) {
            Map map = new LinkedHashMap();
            map.put("from", "collect_asset");
            map.put("f_source", "collection");
            SpaceNftUtils.INSTANCE.routeWithMap(it2, map, this$0.binding.getRoot().getContext());
        }
        CollectionReporterHelper.INSTANCE.reportCollectionSettingItemClick(9);
        this$0.closeDrawer();
        this$0.setMenuTagDisplayable(this$0.binding.collectionThemeContainer.getId(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$10(CollectionSideManager this$0, View it) {
        String it2;
        BiliCollectionGlobalInfoSideBarData biliCollectionGlobalInfoSideBarData = this$0.mData;
        if (biliCollectionGlobalInfoSideBarData != null && (it2 = biliCollectionGlobalInfoSideBarData.getEmojiPackageJumpUrl()) != null) {
            Map map = new LinkedHashMap();
            map.put("from", "collect_asset");
            map.put("f_source", "collection");
            SpaceNftUtils.INSTANCE.routeWithMap(it2, map, this$0.binding.getRoot().getContext());
        }
        CollectionReporterHelper.INSTANCE.reportCollectionSettingItemClick(5);
        this$0.closeDrawer();
        this$0.setMenuTagDisplayable(this$0.binding.collectionEmoticonContainer.getId(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$11(CollectionSideManager this$0, View it) {
        String it2;
        BiliCollectionGlobalInfoSideBarData biliCollectionGlobalInfoSideBarData = this$0.mData;
        if (biliCollectionGlobalInfoSideBarData != null && (it2 = biliCollectionGlobalInfoSideBarData.getEmojiPackageJumpUrl()) != null) {
            Map map = new LinkedHashMap();
            map.put("from", "collect_asset");
            map.put("f_source", "collection");
            SpaceNftUtils.INSTANCE.routeWithMap(it2, map, this$0.binding.getRoot().getContext());
        }
        CollectionReporterHelper.INSTANCE.reportCollectionSettingItemClick(5);
        this$0.closeDrawer();
        this$0.setMenuTagDisplayable(this$0.binding.collectionEmoticonContainer.getId(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$12(CollectionSideManager this$0, View it) {
        String it2;
        BiliCollectionGlobalInfoSideBarData biliCollectionGlobalInfoSideBarData = this$0.mData;
        if (biliCollectionGlobalInfoSideBarData != null && (it2 = biliCollectionGlobalInfoSideBarData.getSpaceBackgroundJumpUrl()) != null) {
            Map map = new LinkedHashMap();
            map.put("from", "collect_asset");
            map.put("f_source", "collection");
            SpaceNftUtils.INSTANCE.routeWithMap(it2, map, this$0.binding.getRoot().getContext());
        }
        CollectionReporterHelper.INSTANCE.reportCollectionSettingItemClick(7);
        this$0.closeDrawer();
        this$0.setMenuTagDisplayable(this$0.binding.collectionSpaceBackgroundContainer.getId(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$13(CollectionSideManager this$0, View it) {
        String it2;
        BiliCollectionGlobalInfoSideBarData biliCollectionGlobalInfoSideBarData = this$0.mData;
        if (biliCollectionGlobalInfoSideBarData != null && (it2 = biliCollectionGlobalInfoSideBarData.getSpaceBackgroundJumpUrl()) != null) {
            Map map = new LinkedHashMap();
            map.put("from", "collect_asset");
            map.put("f_source", "collection");
            SpaceNftUtils.INSTANCE.routeWithMap(it2, map, this$0.binding.getRoot().getContext());
        }
        CollectionReporterHelper.INSTANCE.reportCollectionSettingItemClick(7);
        this$0.closeDrawer();
        this$0.setMenuTagDisplayable(this$0.binding.collectionSpaceBackgroundContainer.getId(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$14(CollectionSideManager this$0, View it) {
        String it2;
        BiliCollectionGlobalInfoSideBarData biliCollectionGlobalInfoSideBarData = this$0.mData;
        if (biliCollectionGlobalInfoSideBarData != null && (it2 = biliCollectionGlobalInfoSideBarData.getPendantJumpUrl()) != null) {
            Map map = new LinkedHashMap();
            map.put("from", "collect_asset");
            map.put("f_source", "collection");
            SpaceNftUtils.INSTANCE.routeWithMap(it2, map, this$0.binding.getRoot().getContext());
        }
        CollectionReporterHelper.INSTANCE.reportCollectionSettingItemClick(1);
        this$0.closeDrawer();
        this$0.setMenuTagDisplayable(this$0.binding.collectionAvatarPendantContainer.getId(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$15(CollectionSideManager this$0, View it) {
        String it2;
        BiliCollectionGlobalInfoSideBarData biliCollectionGlobalInfoSideBarData = this$0.mData;
        if (biliCollectionGlobalInfoSideBarData != null && (it2 = biliCollectionGlobalInfoSideBarData.getPendantJumpUrl()) != null) {
            Map map = new LinkedHashMap();
            map.put("from", "collect_asset");
            map.put("f_source", "collection");
            SpaceNftUtils.INSTANCE.routeWithMap(it2, map, this$0.binding.getRoot().getContext());
        }
        CollectionReporterHelper.INSTANCE.reportCollectionSettingItemClick(1);
        this$0.closeDrawer();
        this$0.setMenuTagDisplayable(this$0.binding.collectionAvatarPendantContainer.getId(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$16(CollectionSideManager this$0, View it) {
        String it2;
        BiliCollectionGlobalInfoSideBarData biliCollectionGlobalInfoSideBarData = this$0.mData;
        if (biliCollectionGlobalInfoSideBarData != null && (it2 = biliCollectionGlobalInfoSideBarData.getSplashJumpUrl()) != null) {
            Map map = new LinkedHashMap();
            map.put("from", "collect_asset");
            map.put("f_source", "collection");
            SpaceNftUtils.INSTANCE.routeWithMap(it2, map, this$0.binding.getRoot().getContext());
        }
        CollectionReporterHelper.INSTANCE.reportCollectionSettingItemClick(12);
        this$0.closeDrawer();
        this$0.setMenuTagDisplayable(this$0.binding.collectionStartupContainer.getId(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$17(CollectionSideManager this$0, SharedPreferences $sharedPreferences, View it) {
        String it2;
        BiliCollectionGlobalInfoSideBarData biliCollectionGlobalInfoSideBarData = this$0.mData;
        if (biliCollectionGlobalInfoSideBarData != null && (it2 = biliCollectionGlobalInfoSideBarData.getSplashJumpUrl()) != null) {
            Map map = new LinkedHashMap();
            map.put("from", "collect_asset");
            map.put("f_source", "collection");
            SpaceNftUtils.INSTANCE.routeWithMap(it2, map, this$0.binding.getRoot().getContext());
        }
        if (this$0.binding.collectionStartup.getVisibility() == 0) {
            this$0.binding.collectionStartupBadge.setVisibility(8);
            $sharedPreferences.edit().putBoolean(SPLASH_SETTING_BADGE_SHOWED_KEY, true).apply();
        }
        CollectionReporterHelper.INSTANCE.reportCollectionSettingItemClick(12);
        this$0.closeDrawer();
        this$0.setMenuTagDisplayable(this$0.binding.collectionStartupContainer.getId(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$18(CollectionSideManager this$0, SharedPreferences $sharedPreferences, View it) {
        String it2;
        BiliCollectionGlobalInfoSideBarData biliCollectionGlobalInfoSideBarData = this$0.mData;
        if (biliCollectionGlobalInfoSideBarData != null && (it2 = biliCollectionGlobalInfoSideBarData.getWidgetJumpUrl()) != null) {
            Map map = new LinkedHashMap();
            map.put("from", "collect_asset");
            map.put("f_source", "collection");
            SpaceNftUtils.INSTANCE.routeWithMap(it2, map, this$0.binding.getRoot().getContext());
        }
        this$0.binding.collectionAppWidgetBadge.setVisibility(8);
        $sharedPreferences.edit().putBoolean(APP_WIDGET_BADGE_SHOWED_KEY, true).apply();
        CollectionReporterHelper.INSTANCE.reportCollectionSettingItemClick(103);
        this$0.closeDrawer();
        this$0.setMenuTagDisplayable(this$0.binding.collectionStartupContainer.getId(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$19(final CollectionSideManager this$0, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C522@20376L1200,522@20366L1210:CollectionSideManager.kt#q2wzc4");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(732493645, $changed, -1, "tv.danmaku.bili.ui.garb.manager.CollectionSideManager.initView.<anonymous> (CollectionSideManager.kt:522)");
            }
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(1133739669, true, new Function2() { // from class: tv.danmaku.bili.ui.garb.manager.CollectionSideManager$$ExternalSyntheticLambda25
                public final Object invoke(Object obj, Object obj2) {
                    Unit initView$lambda$19$0;
                    initView$lambda$19$0 = CollectionSideManager.initView$lambda$19$0(CollectionSideManager.this, (Composer) obj, ((Integer) obj2).intValue());
                    return initView$lambda$19$0;
                }
            }, $composer, 54), $composer, (int) BR.negativeBtnVisible, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$19$0(final CollectionSideManager this$0, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C523@20419L59,525@20584L922,524@20499L1059:CollectionSideManager.kt#q2wzc4");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1133739669, $changed, -1, "tv.danmaku.bili.ui.garb.manager.CollectionSideManager.initView.<anonymous>.<anonymous> (CollectionSideManager.kt:523)");
            }
            BiliCollectionGlobalInfoSideBarData data = this$0.getData();
            ComposerKt.sourceInformationMarkerStart($composer, -1397869840, "CC(remember):CollectionSideManager.kt#9igjgp");
            boolean invalid$iv = $composer.changed(data);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                BiliCollectionGlobalInfoSideBarData data2 = this$0.getData();
                Object value$iv = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(data2 != null ? data2.getNftHasNew() : false), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final MutableState newTagVisible$delegate = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            boolean initView$lambda$19$0$1 = initView$lambda$19$0$1(newTagVisible$delegate);
            Modifier modifier = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart($composer, -1397863697, "CC(remember):CollectionSideManager.kt#9igjgp");
            boolean invalid$iv2 = $composer.changed(newTagVisible$delegate) | $composer.changedInstance(this$0);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: tv.danmaku.bili.ui.garb.manager.CollectionSideManager$$ExternalSyntheticLambda10
                    public final Object invoke() {
                        Unit initView$lambda$19$0$3$0;
                        initView$lambda$19$0$3$0 = CollectionSideManager.initView$lambda$19$0$3$0(CollectionSideManager.this, newTagVisible$delegate);
                        return initView$lambda$19$0$3$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            this$0.NftContainerUI(initView$lambda$19$0$1, PaddingKt.padding-VpY3zN4$default(ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null), 0.0f, Dp.constructor-impl(10), 1, (Object) null), $composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final boolean initView$lambda$19$0$1(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private static final void initView$lambda$19$0$2(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$19$0$3$0(CollectionSideManager this$0, MutableState $newTagVisible$delegate) {
        String it;
        initView$lambda$19$0$2($newTagVisible$delegate, false);
        BiliCollectionGlobalInfoSideBarData data = this$0.getData();
        if (data != null && (it = data.getNftJumpUrl()) != null) {
            Map map = new LinkedHashMap();
            map.put("from", "collect_asset");
            map.put("f_source", "collection");
            SpaceNftUtils.INSTANCE.routeWithMap(it, map, this$0.binding.getRoot().getContext());
        }
        CollectionReporterHelper.INSTANCE.reportCollectionSettingItemClick(BR.commentCountText);
        this$0.closeDrawer();
        CoroutineScope coroutineScope = this$0.getCoroutineScope();
        if (coroutineScope != null) {
            BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new CollectionSideManager$initView$20$1$1$1$2(null), 3, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$20(CollectionSideManager this$0, View it) {
        String it2;
        BiliCollectionGlobalInfoSideBarData biliCollectionGlobalInfoSideBarData = this$0.mData;
        if (biliCollectionGlobalInfoSideBarData != null && (it2 = biliCollectionGlobalInfoSideBarData.getCardBackgroundJumpUrl()) != null) {
            Map map = new LinkedHashMap();
            map.put("from", "collect_asset");
            map.put("f_source", "collection");
            SpaceNftUtils.INSTANCE.routeWithMap(it2, map, this$0.binding.getRoot().getContext());
        }
        CollectionReporterHelper.INSTANCE.reportCollectionSettingItemClick(8);
        this$0.closeDrawer();
        this$0.setMenuTagDisplayable(this$0.binding.collectionCommentBackgroundContainer.getId(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$21(CollectionSideManager this$0, View it) {
        String it2;
        BiliCollectionGlobalInfoSideBarData biliCollectionGlobalInfoSideBarData = this$0.mData;
        if (biliCollectionGlobalInfoSideBarData != null && (it2 = biliCollectionGlobalInfoSideBarData.getCardBackgroundJumpUrl()) != null) {
            Map map = new LinkedHashMap();
            map.put("from", "collect_asset");
            map.put("f_source", "collection");
            SpaceNftUtils.INSTANCE.routeWithMap(it2, map, this$0.binding.getRoot().getContext());
        }
        CollectionReporterHelper.INSTANCE.reportCollectionSettingItemClick(8);
        this$0.closeDrawer();
        this$0.setMenuTagDisplayable(this$0.binding.collectionCommentBackgroundContainer.getId(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$22(CollectionSideManager this$0, View it) {
        String it2;
        BiliCollectionGlobalInfoSideBarData biliCollectionGlobalInfoSideBarData = this$0.mData;
        if (biliCollectionGlobalInfoSideBarData != null && (it2 = biliCollectionGlobalInfoSideBarData.getCardJumpUrl()) != null) {
            Map map = new LinkedHashMap();
            map.put("from", "collect_asset");
            map.put("f_source", "collection");
            SpaceNftUtils.INSTANCE.routeWithMap(it2, map, this$0.binding.getRoot().getContext());
        }
        CollectionReporterHelper.INSTANCE.reportCollectionSettingItemClick(2);
        this$0.closeDrawer();
        this$0.setMenuTagDisplayable(this$0.binding.collectionDynamicCardContainer.getId(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$23(CollectionSideManager this$0, View it) {
        String it2;
        BiliCollectionGlobalInfoSideBarData biliCollectionGlobalInfoSideBarData = this$0.mData;
        if (biliCollectionGlobalInfoSideBarData != null && (it2 = biliCollectionGlobalInfoSideBarData.getCardJumpUrl()) != null) {
            Map map = new LinkedHashMap();
            map.put("from", "collect_asset");
            map.put("f_source", "collection");
            SpaceNftUtils.INSTANCE.routeWithMap(it2, map, this$0.binding.getRoot().getContext());
        }
        CollectionReporterHelper.INSTANCE.reportCollectionSettingItemClick(2);
        this$0.closeDrawer();
        this$0.setMenuTagDisplayable(this$0.binding.collectionDynamicCardContainer.getId(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$24(CollectionSideManager this$0, View it) {
        String it2;
        BiliCollectionGlobalInfoSideBarData biliCollectionGlobalInfoSideBarData = this$0.mData;
        if (biliCollectionGlobalInfoSideBarData != null && (it2 = biliCollectionGlobalInfoSideBarData.getThumbUpJumpUrl()) != null) {
            Map map = new LinkedHashMap();
            map.put("from", "collect_asset");
            map.put("f_source", "collection");
            SpaceNftUtils.INSTANCE.routeWithMap(it2, map, this$0.binding.getRoot().getContext());
        }
        CollectionReporterHelper.INSTANCE.reportCollectionSettingItemClick(3);
        this$0.closeDrawer();
        this$0.setMenuTagDisplayable(this$0.binding.collectionCombContainer.getId(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$25(CollectionSideManager this$0, View it) {
        String it2;
        BiliCollectionGlobalInfoSideBarData biliCollectionGlobalInfoSideBarData = this$0.mData;
        if (biliCollectionGlobalInfoSideBarData != null && (it2 = biliCollectionGlobalInfoSideBarData.getThumbUpJumpUrl()) != null) {
            Map map = new LinkedHashMap();
            map.put("from", "collect_asset");
            map.put("f_source", "collection");
            SpaceNftUtils.INSTANCE.routeWithMap(it2, map, this$0.binding.getRoot().getContext());
        }
        CollectionReporterHelper.INSTANCE.reportCollectionSettingItemClick(3);
        this$0.closeDrawer();
        this$0.setMenuTagDisplayable(this$0.binding.collectionCombContainer.getId(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$26(CollectionSideManager this$0, View it) {
        String it2;
        BiliCollectionGlobalInfoSideBarData biliCollectionGlobalInfoSideBarData = this$0.mData;
        if (biliCollectionGlobalInfoSideBarData != null && (it2 = biliCollectionGlobalInfoSideBarData.getLoadingJumpUrl()) != null) {
            Map map = new LinkedHashMap();
            map.put("from", "collect_asset");
            map.put("f_source", "collection");
            SpaceNftUtils.INSTANCE.routeWithMap(it2, map, this$0.binding.getRoot().getContext());
        }
        CollectionReporterHelper.INSTANCE.reportCollectionSettingItemClick(10);
        this$0.closeDrawer();
        this$0.setMenuTagDisplayable(this$0.binding.collectionLoadingContainer.getId(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$27(CollectionSideManager this$0, View it) {
        String it2;
        BiliCollectionGlobalInfoSideBarData biliCollectionGlobalInfoSideBarData = this$0.mData;
        if (biliCollectionGlobalInfoSideBarData != null && (it2 = biliCollectionGlobalInfoSideBarData.getLoadingJumpUrl()) != null) {
            Map map = new LinkedHashMap();
            map.put("from", "collect_asset");
            map.put("f_source", "collection");
            SpaceNftUtils.INSTANCE.routeWithMap(it2, map, this$0.binding.getRoot().getContext());
        }
        CollectionReporterHelper.INSTANCE.reportCollectionSettingItemClick(10);
        this$0.closeDrawer();
        this$0.setMenuTagDisplayable(this$0.binding.collectionLoadingContainer.getId(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$28(CollectionSideManager this$0, View it) {
        String it2;
        BiliCollectionGlobalInfoSideBarData biliCollectionGlobalInfoSideBarData = this$0.mData;
        if (biliCollectionGlobalInfoSideBarData != null && (it2 = biliCollectionGlobalInfoSideBarData.getPlayIconJumpUrl()) != null) {
            Map map = new LinkedHashMap();
            map.put("from", "collect_asset");
            map.put("f_source", "collection");
            SpaceNftUtils.INSTANCE.routeWithMap(it2, map, this$0.binding.getRoot().getContext());
        }
        CollectionReporterHelper.INSTANCE.reportCollectionSettingItemClick(11);
        this$0.closeDrawer();
        this$0.setMenuTagDisplayable(this$0.binding.collectionProgressBarContainer.getId(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$29(CollectionSideManager this$0, View it) {
        String it2;
        BiliCollectionGlobalInfoSideBarData biliCollectionGlobalInfoSideBarData = this$0.mData;
        if (biliCollectionGlobalInfoSideBarData != null && (it2 = biliCollectionGlobalInfoSideBarData.getPlayIconJumpUrl()) != null) {
            Map map = new LinkedHashMap();
            map.put("from", "collect_asset");
            map.put("f_source", "collection");
            SpaceNftUtils.INSTANCE.routeWithMap(it2, map, this$0.binding.getRoot().getContext());
        }
        CollectionReporterHelper.INSTANCE.reportCollectionSettingItemClick(11);
        this$0.closeDrawer();
        this$0.setMenuTagDisplayable(this$0.binding.collectionProgressBarContainer.getId(), false);
    }

    private final void NftContainerUI(final boolean newTagVisible, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(721601594);
        ComposerKt.sourceInformation($composer2, "C(NftContainerUI)N(newTagVisible,modifier)690@27167L1381:CollectionSideManager.kt#q2wzc4");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(newTagVisible) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(721601594, $dirty2, -1, "tv.danmaku.bili.ui.garb.manager.CollectionSideManager.NftContainerUI (CollectionSideManager.kt:689)");
            }
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            int $changed$iv = (($dirty2 >> 3) & 14) | BR.negativeBtnVisible;
            Modifier modifier$iv = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & BR.containerVisible));
            int $changed$iv$iv = ($changed$iv << 3) & BR.containerVisible;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            modifier3 = modifier4;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i4 = (($changed$iv >> 6) & BR.containerVisible) | 6;
            RowScope $this$NftContainerUI_u24lambda_u240 = rowScope;
            ComposerKt.sourceInformationMarkerStart($composer2, -119792727, "C692@27287L66,691@27254L206,696@27473L40,699@27597L9,700@27646L6,697@27526L153,717@28281L38,719@28365L66,718@28332L206:CollectionSideManager.kt#q2wzc4");
            ImageKt.Image(DrawableResourceKt.rememberDrawableResourcePainter(R.drawable.collection_nft, $composer2, 0), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer2, Painter.$stable | BR.pendentVisible, 120);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(10)), $composer2, 6);
            TextKt.Text--4IGK_g("数字资产", (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGraph_white-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT14(), $composer2, 6, 0, 65530);
            if (newTagVisible) {
                $composer2.startReplaceGroup(-119361921);
                ComposerKt.sourceInformation($composer2, "703@27729L39,708@27946L6,712@28130L6,704@27785L469");
                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(5)), $composer2, 6);
                TextKt.Text--4IGK_g("新", PaddingKt.padding-3ABfNKs(BackgroundKt.background-bw27NRU(Modifier.Companion, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(2))), Dp.constructor-impl(3)), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGraph_white-0d7_KjU(), TextUnitKt.getSp(8), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer2, 3078, 0, 130544);
            } else {
                $composer2.startReplaceGroup(-146869492);
            }
            $composer2.endReplaceGroup();
            SpacerKt.Spacer(RowScope.-CC.weight$default($this$NftContainerUI_u24lambda_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer2, 0);
            ImageKt.Image(DrawableResourceKt.rememberDrawableResourcePainter(R.drawable.collection_right_arrow, $composer2, 0), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer2, Painter.$stable | BR.pendentVisible, 120);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.ui.garb.manager.CollectionSideManager$$ExternalSyntheticLambda24
                public final Object invoke(Object obj, Object obj2) {
                    Unit NftContainerUI$lambda$1;
                    NftContainerUI$lambda$1 = CollectionSideManager.NftContainerUI$lambda$1(CollectionSideManager.this, newTagVisible, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return NftContainerUI$lambda$1;
                }
            });
        }
    }

    private final void refreshRealGiftUI() {
        BiliCollectionGlobalInfoSideBarData biliCollectionGlobalInfoSideBarData = this.mData;
        final String realGiftJumpUrl = (biliCollectionGlobalInfoSideBarData == null || (realGiftJumpUrl = biliCollectionGlobalInfoSideBarData.getRealGiftJumpUrl()) == null) ? "" : "";
        BiliCollectionGlobalInfoSideBarData biliCollectionGlobalInfoSideBarData2 = this.mData;
        boolean realGiftNewShowing = biliCollectionGlobalInfoSideBarData2 != null ? biliCollectionGlobalInfoSideBarData2.getRealGiftNewShowing() : false;
        if (!StringsKt.isBlank(realGiftJumpUrl)) {
            this.binding.collectionRealGiftContainer.setVisibility(0);
            this.binding.collectionRealGiftContainer.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.garb.manager.CollectionSideManager$$ExternalSyntheticLambda38
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CollectionSideManager.refreshRealGiftUI$lambda$0(realGiftJumpUrl, this, view);
                }
            });
            this.binding.collectionRealGiftBadge.setVisibility(realGiftNewShowing ? 0 : 8);
            return;
        }
        this.binding.collectionRealGiftContainer.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshRealGiftUI$lambda$0(String $realGiftJumpUrl, CollectionSideManager this$0, View it) {
        Map map = new LinkedHashMap();
        map.put("from", "collect_asset");
        map.put("f_source", "collection");
        SpaceNftUtils.INSTANCE.routeWithMap($realGiftJumpUrl, map, this$0.binding.getRoot().getContext());
        CollectionReporterHelper.INSTANCE.reportCollectionSettingItemClick(BR.comment);
        this$0.closeDrawer();
    }
}