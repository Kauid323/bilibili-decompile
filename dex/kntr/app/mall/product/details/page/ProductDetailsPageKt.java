package kntr.app.mall.product.details.page;

import androidx.activity.OnBackPressedDispatcher;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import io.ktor.http.Parameters;
import io.ktor.http.URLBuilder;
import io.ktor.http.URLUtilsKt;
import java.util.Map;
import kntr.app.mall.product.details.page.api.model.ProductDetailsResponse;
import kntr.app.mall.product.details.page.ui.scale.UiScaleModel;
import kntr.app.mall.product.details.page.ui.screen.ContentScreenKt;
import kntr.app.mall.product.details.page.ui.screen.ErrorScreenKt;
import kntr.app.mall.product.details.page.ui.screen.LoadingScreenKt;
import kntr.app.mall.product.details.page.utils.ScreenKt;
import kntr.app.mall.product.details.page.vm.PageViewModel;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kntr.base.router.Router;
import kntr.common.pv.PvEventTrigger;
import kntr.common.pv.compose.PvTriggerEntranceKt;
import kntr.common.router.RouterKt;
import kntr.common.trio.pagecontroller.LocalOnBackPressedDispatcher;
import kntr.common.trio.systemui.SystemUIKt;
import kntr.common.trio.systemui.SystemUI_androidKt;
import kntr.common.trio.systemui.SystemUiController;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.flow.SharedFlow;

/* compiled from: ProductDetailsPage.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a\u008c\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052B\u0010\u0006\u001a>\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00050\u00072o\u0010\u000e\u001ak\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\r\u0012+\u0012)\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0004\u0012\u00020\u00030\u0010¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00030\u000f2*\b\u0002\u0010\u0012\u001a$\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u0005\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b0\u0014\u0018\u00010\u00132\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00030\u0010H\u0007¢\u0006\u0002\u0010\u0017\u001aä\u0002\u0010\u0018\u001a\u00020\u00032B\u0010\u0006\u001a>\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00050\u00072o\u0010\u000e\u001ak\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\r\u0012+\u0012)\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0004\u0012\u00020\u00030\u0010¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00030\u000f2*\b\u0002\u0010\u0012\u001a$\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u0005\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b0\u0014\u0018\u00010\u00132\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00052\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00030\u0010H\u0001¢\u0006\u0002\u0010!\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\"²\u0006\n\u0010#\u001a\u00020\u0001X\u008a\u0084\u0002²\u0006\f\u0010$\u001a\u0004\u0018\u00010\u0005X\u008a\u0084\u0002"}, d2 = {"NOT_KNTR_SHELL", "", "ProductBindDetailsPage", "", "url", "", "valueBridge", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "key", "", "", "data", "bridgeCall", "Lkotlin/Function3;", "Lkotlin/Function1;", "callback", "eventFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "Lkotlin/Pair;", "onViewModelCreate", "Lkntr/app/mall/product/details/page/vm/PageViewModel;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlinx/coroutines/flow/SharedFlow;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "ProductDetailsPage", "itemsId", "msource", "track_id", "from", "is_ad", "detailPreload", "originUrl", "fromSpmId", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlinx/coroutines/flow/SharedFlow;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "product-details-page_debug", "loadingState", "errorState"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ProductDetailsPageKt {
    public static final boolean NOT_KNTR_SHELL = true;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductBindDetailsPage$lambda$2(String str, Function2 function2, Function3 function3, SharedFlow sharedFlow, Function1 function1, int i, int i2, Composer composer, int i3) {
        ProductBindDetailsPage(str, function2, function3, sharedFlow, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductDetailsPage$lambda$10(Function2 function2, Function3 function3, SharedFlow sharedFlow, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Function1 function1, int i, int i2, int i3, Composer composer, int i4) {
        ProductDetailsPage(function2, function3, sharedFlow, str, str2, str3, str4, str5, str6, str7, str8, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductBindDetailsPage$lambda$0$0(PageViewModel pageViewModel) {
        Intrinsics.checkNotNullParameter(pageViewModel, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v6 */
    public static final void ProductBindDetailsPage(final String url, final Function2<? super String, ? super Map<String, ? extends Object>, String> function2, final Function3<? super String, ? super Map<String, ? extends Object>, ? super Function1<? super Map<String, ? extends Object>, Unit>, Unit> function3, SharedFlow<? extends Pair<String, ? extends Map<String, ? extends Object>>> sharedFlow, Function1<? super PageViewModel, Unit> function1, Composer $composer, final int $changed, final int i) {
        SharedFlow sharedFlow2;
        Function1 onViewModelCreate;
        SharedFlow eventFlow;
        SharedFlow eventFlow2;
        Function1 onViewModelCreate2;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(function2, "valueBridge");
        Intrinsics.checkNotNullParameter(function3, "bridgeCall");
        Composer $composer2 = $composer.startRestartGroup(-242771571);
        ComposerKt.sourceInformation($composer2, "C(ProductBindDetailsPage)N(url,valueBridge,bridgeCall,eventFlow,onViewModelCreate)56@2860L8,71@3322L397:ProductDetailsPage.kt#lbyouy");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(url) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty |= 3072;
            sharedFlow2 = sharedFlow;
        } else if (($changed & 3072) == 0) {
            sharedFlow2 = sharedFlow;
            $dirty |= $composer2.changedInstance(sharedFlow2) ? 2048 : 1024;
        } else {
            sharedFlow2 = sharedFlow;
        }
        int i3 = i & 16;
        if (i3 != 0) {
            $dirty |= 24576;
            onViewModelCreate = function1;
        } else if (($changed & 24576) == 0) {
            onViewModelCreate = function1;
            $dirty |= $composer2.changedInstance(onViewModelCreate) ? 16384 : 8192;
        } else {
            onViewModelCreate = function1;
        }
        if (!$composer2.shouldExecute(($dirty & 9363) != 9362, $dirty & 1)) {
            $composer2.skipToGroupEnd();
            eventFlow = sharedFlow2;
        } else {
            if (i2 != 0) {
                eventFlow2 = null;
            } else {
                eventFlow2 = sharedFlow2;
            }
            if (i3 == 0) {
                onViewModelCreate2 = onViewModelCreate;
            } else {
                ComposerKt.sourceInformationMarkerStart($composer2, -1375235211, "CC(remember):ProductDetailsPage.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function1() { // from class: kntr.app.mall.product.details.page.ProductDetailsPageKt$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj) {
                            Unit ProductBindDetailsPage$lambda$0$0;
                            ProductBindDetailsPage$lambda$0$0 = ProductDetailsPageKt.ProductBindDetailsPage$lambda$0$0((PageViewModel) obj);
                            return ProductBindDetailsPage$lambda$0$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                onViewModelCreate2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-242771571, $dirty, -1, "kntr.app.mall.product.details.page.ProductBindDetailsPage (ProductDetailsPage.kt:57)");
            }
            Parameters params = URLUtilsKt.Url(url).getParameters();
            String itemsId = params.get("itemsId");
            String trackId = params.get("track_id");
            String msource = params.get("msource");
            String from = params.get("from");
            String isAd = params.get("is_ad");
            String detailPreload = params.get("detailPreload");
            String fromSpmId = params.get("fromSpmId");
            URLBuilder $this$ProductBindDetailsPage_u24lambda_u241 = URLUtilsKt.URLBuilder(URLUtilsKt.Url(url));
            $this$ProductBindDetailsPage_u24lambda_u241.getParameters().remove("detailPreload");
            String originUrl = $this$ProductBindDetailsPage_u24lambda_u241.buildString();
            ProductDetailsPage(function2, function3, eventFlow2, itemsId, msource, trackId, from, isAd, detailPreload, originUrl, fromSpmId, onViewModelCreate2, $composer2, (($dirty >> 3) & 14) | (($dirty >> 3) & 112) | (($dirty >> 3) & 896), ($dirty >> 9) & 112, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            eventFlow = eventFlow2;
            onViewModelCreate = onViewModelCreate2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final SharedFlow sharedFlow3 = eventFlow;
            final Function1 function12 = onViewModelCreate;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ProductDetailsPageKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit ProductBindDetailsPage$lambda$2;
                    ProductBindDetailsPage$lambda$2 = ProductDetailsPageKt.ProductBindDetailsPage$lambda$2(url, function2, function3, sharedFlow3, function12, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ProductBindDetailsPage$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductDetailsPage$lambda$0$0(PageViewModel pageViewModel) {
        Intrinsics.checkNotNullParameter(pageViewModel, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:263:0x051a, code lost:
        if (r11 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L148;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:278:0x05b6  */
    /* JADX WARN: Type inference failed for: r5v19 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ProductDetailsPage(final Function2<? super String, ? super Map<String, ? extends Object>, String> function2, final Function3<? super String, ? super Map<String, ? extends Object>, ? super Function1<? super Map<String, ? extends Object>, Unit>, Unit> function3, SharedFlow<? extends Pair<String, ? extends Map<String, ? extends Object>>> sharedFlow, String itemsId, String msource, String track_id, String from, String is_ad, String detailPreload, String originUrl, String fromSpmId, Function1<? super PageViewModel, Unit> function1, Composer $composer, final int $changed, final int $changed1, final int i) {
        int $dirty;
        Composer $composer2;
        SharedFlow eventFlow;
        String itemsId2;
        String msource2;
        String track_id2;
        String from2;
        String is_ad2;
        String detailPreload2;
        String originUrl2;
        String fromSpmId2;
        Function1 onViewModelCreate;
        Function1 onViewModelCreate2;
        int $dirty2;
        Ref.BooleanRef pageFirstLoad;
        PvEventTrigger pvTrigger;
        Function1 onViewModelCreate3;
        String str;
        SharedFlow eventFlow2;
        Composer $composer3;
        Function1 onViewModelCreate4;
        Intrinsics.checkNotNullParameter(function2, "valueBridge");
        Intrinsics.checkNotNullParameter(function3, "bridgeCall");
        Composer $composer4 = $composer.startRestartGroup(-1305561861);
        ComposerKt.sourceInformation($composer4, "C(ProductDetailsPage)N(valueBridge,bridgeCall,eventFlow,itemsId,msource,track_id,from,is_ad,detailPreload,originUrl,fromSpmId,onViewModelCreate)100@4290L8,102@4324L49,200@8543L7,201@8612L7,202@8642L16,203@8682L17,205@8757L440,205@8747L450,222@9249L16,223@9313L16,225@9384L48,225@9335L97,229@9459L745,229@9438L766,249@10251L7,251@10292L310,260@10641L512,260@10608L545,275@11207L16,276@11238L975,276@11228L985,311@12245L210,311@12219L236:ProductDetailsPage.kt#lbyouy");
        int $dirty3 = $changed;
        int $dirty1 = $changed1;
        if (($changed & 6) == 0) {
            $dirty3 |= $composer4.changedInstance(function2) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty3 |= $composer4.changedInstance(function3) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty3 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty3 |= $composer4.changedInstance(sharedFlow) ? 256 : 128;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty3 |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty3 |= $composer4.changed(itemsId) ? 2048 : 1024;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty3 |= 24576;
        } else if (($changed & 24576) == 0) {
            $dirty3 |= $composer4.changed(msource) ? 16384 : 8192;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty3 |= 196608;
        } else if (($changed & 196608) == 0) {
            $dirty3 |= $composer4.changed(track_id) ? 131072 : 65536;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty3 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty3 |= $composer4.changed(from) ? 1048576 : 524288;
        }
        int i7 = i & 128;
        if (i7 != 0) {
            $dirty3 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty3 |= $composer4.changed(is_ad) ? 8388608 : 4194304;
        }
        int i8 = i & 256;
        if (i8 != 0) {
            $dirty3 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty3 |= $composer4.changed(detailPreload) ? 67108864 : 33554432;
        }
        int i9 = i & 512;
        if (i9 != 0) {
            $dirty3 |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty3 |= $composer4.changed(originUrl) ? 536870912 : 268435456;
        }
        int i10 = i & 1024;
        if (i10 != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 6) == 0) {
            $dirty1 |= $composer4.changed(fromSpmId) ? 4 : 2;
        }
        int i11 = i & 2048;
        if (i11 != 0) {
            $dirty1 |= 48;
        } else if (($changed1 & 48) == 0) {
            $dirty1 |= $composer4.changedInstance(function1) ? 32 : 16;
        }
        if ($composer4.shouldExecute((($dirty3 & 306783379) == 306783378 && ($dirty1 & 19) == 18) ? false : true, $dirty3 & 1)) {
            SharedFlow eventFlow3 = i2 != 0 ? null : sharedFlow;
            itemsId2 = i3 != 0 ? null : itemsId;
            String msource3 = i4 != 0 ? null : msource;
            track_id2 = i5 != 0 ? null : track_id;
            from2 = i6 != 0 ? null : from;
            is_ad2 = i7 != 0 ? null : is_ad;
            detailPreload2 = i8 != 0 ? null : detailPreload;
            originUrl2 = i9 != 0 ? null : originUrl;
            fromSpmId2 = i10 != 0 ? null : fromSpmId;
            if (i11 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer4, -514480509, "CC(remember):ProductDetailsPage.kt#9igjgp");
                Object it$iv = $composer4.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function1() { // from class: kntr.app.mall.product.details.page.ProductDetailsPageKt$$ExternalSyntheticLambda8
                        public final Object invoke(Object obj) {
                            Unit ProductDetailsPage$lambda$0$0;
                            ProductDetailsPage$lambda$0$0 = ProductDetailsPageKt.ProductDetailsPage$lambda$0$0((PageViewModel) obj);
                            return ProductDetailsPage$lambda$0$0;
                        }
                    };
                    $composer4.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function1 onViewModelCreate5 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer4);
                onViewModelCreate2 = onViewModelCreate5;
            } else {
                onViewModelCreate2 = function1;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1305561861, $dirty3, $dirty1, "kntr.app.mall.product.details.page.ProductDetailsPage (ProductDetailsPage.kt:101)");
            }
            PvEventTrigger pvTrigger2 = PvTriggerEntranceKt.rememberPvEventTrigger("mall.mall-detail.0.0.pv", $composer4, 6);
            Ref.BooleanRef pageFirstLoad2 = new Ref.BooleanRef();
            pageFirstLoad2.element = true;
            final ProductDetailsPageKt$ProductDetailsPage$repository$1 repository = new ProductDetailsPageKt$ProductDetailsPage$repository$1(itemsId2, msource3, track_id2, from2, is_ad2, fromSpmId2, function2, function3);
            CompositionLocal this_$iv = RouterKt.getLocalRouter();
            int $dirty12 = $dirty1;
            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer4.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            final Router router = (Router) consume;
            final OnBackPressedDispatcher backPressedDispatcher = LocalOnBackPressedDispatcher.INSTANCE.getCurrent($composer4, LocalOnBackPressedDispatcher.$stable);
            final float screenWidth = ScreenKt.getScreenWidth($composer4, 0);
            final float screenHeight = ScreenKt.getScreenHeight($composer4, 0);
            ComposerKt.sourceInformationMarkerStart($composer4, -514337133, "CC(remember):ProductDetailsPage.kt#9igjgp");
            SharedFlow eventFlow4 = eventFlow3;
            boolean invalid$iv = $composer4.changed(repository) | $composer4.changedInstance(router) | $composer4.changed(screenWidth) | $composer4.changed(screenHeight) | $composer4.changedInstance(backPressedDispatcher) | (($dirty3 & 7168) == 2048) | ((57344 & $dirty3) == 16384) | ((458752 & $dirty3) == 131072) | ((3670016 & $dirty3) == 1048576) | ((29360128 & $dirty3) == 8388608) | ((234881024 & $dirty3) == 67108864) | ((1879048192 & $dirty3) == 536870912) | (($dirty3 & 14) == 4) | (($dirty3 & 112) == 32);
            Object value$iv2 = $composer4.rememberedValue();
            if (invalid$iv || value$iv2 == Composer.Companion.getEmpty()) {
                $dirty2 = $dirty3;
                final String str2 = itemsId2;
                final String str3 = msource3;
                final String str4 = track_id2;
                pageFirstLoad = pageFirstLoad2;
                final String str5 = from2;
                pvTrigger = pvTrigger2;
                final String str6 = is_ad2;
                final String str7 = detailPreload2;
                onViewModelCreate3 = onViewModelCreate2;
                final String str8 = originUrl2;
                str = "CC(remember):ProductDetailsPage.kt#9igjgp";
                eventFlow2 = eventFlow4;
                $composer3 = $composer4;
                value$iv2 = new Function1() { // from class: kntr.app.mall.product.details.page.ProductDetailsPageKt$$ExternalSyntheticLambda9
                    public final Object invoke(Object obj) {
                        PageViewModel ProductDetailsPage$lambda$1$0;
                        ProductDetailsPage$lambda$1$0 = ProductDetailsPageKt.ProductDetailsPage$lambda$1$0(ProductDetailsPageKt$ProductDetailsPage$repository$1.this, str2, str3, str4, str5, str6, str7, str8, function2, function3, router, screenWidth, screenHeight, backPressedDispatcher, (CreationExtras) obj);
                        return ProductDetailsPage$lambda$1$0;
                    }
                };
                $composer4.updateRememberedValue(value$iv2);
            } else {
                str = "CC(remember):ProductDetailsPage.kt#9igjgp";
                $dirty2 = $dirty3;
                pageFirstLoad = pageFirstLoad2;
                pvTrigger = pvTrigger2;
                onViewModelCreate3 = onViewModelCreate2;
                $composer3 = $composer4;
                eventFlow2 = eventFlow4;
            }
            Function1 initializer$iv = (Function1) value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Composer $composer$iv = $composer3;
            $composer$iv.startReplaceableGroup(419377738);
            ComposerKt.sourceInformation($composer$iv, "CC(viewModel)P(2,1)*124@5789L7,129@5965L288:ViewModel.kt#3tja67");
            HasDefaultViewModelProviderFactory current = LocalViewModelStoreOwner.INSTANCE.getCurrent($composer$iv, 6);
            if (current == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
            }
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(PageViewModel.class);
            InitializerViewModelFactoryBuilder $this$viewModel_u24lambda_u243$iv = new InitializerViewModelFactoryBuilder();
            $this$viewModel_u24lambda_u243$iv.addInitializer(Reflection.getOrCreateKotlinClass(PageViewModel.class), initializer$iv);
            ViewModel viewModel = ViewModelKt.viewModel(orCreateKotlinClass, current, (String) null, $this$viewModel_u24lambda_u243$iv.build(), current instanceof HasDefaultViewModelProviderFactory ? current.getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, $composer$iv, ((0 << 3) & 112) | ((0 << 3) & 896), 0);
            $composer$iv.endReplaceableGroup();
            final PageViewModel pageViewModel = (PageViewModel) viewModel;
            $composer2 = $composer3;
            final State loadingState$delegate = SnapshotStateKt.collectAsState(pageViewModel.getLoadingState(), (CoroutineContext) null, $composer2, 0, 1);
            final State errorState$delegate = SnapshotStateKt.collectAsState(pageViewModel.getErrorState(), (CoroutineContext) null, $composer2, 0, 1);
            String str9 = str;
            ComposerKt.sourceInformationMarkerStart($composer2, -514317461, str9);
            boolean invalid$iv2 = (($dirty12 & 112) == 32) | $composer2.changedInstance(pageViewModel);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                onViewModelCreate4 = onViewModelCreate3;
                Object value$iv3 = (Function2) new ProductDetailsPageKt$ProductDetailsPage$2$1(onViewModelCreate4, pageViewModel, null);
                $composer2.updateRememberedValue(value$iv3);
                it$iv2 = value$iv3;
            } else {
                onViewModelCreate4 = onViewModelCreate3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(pageViewModel, onViewModelCreate4, (Function2) it$iv2, $composer2, $dirty12 & 112);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -514314364, str9);
            $dirty = $dirty2;
            PvEventTrigger pvTrigger3 = pvTrigger;
            boolean invalid$iv3 = (($dirty & 7168) == 2048) | ((3670016 & $dirty) == 1048576) | ((57344 & $dirty) == 16384) | ((458752 & $dirty) == 131072) | ((29360128 & $dirty) == 8388608) | $composer2.changedInstance(pvTrigger3);
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv3 || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv4 = (Function2) new ProductDetailsPageKt$ProductDetailsPage$3$1(itemsId2, from2, msource3, track_id2, is_ad2, pvTrigger3, null);
                $composer2.updateRememberedValue(value$iv4);
                it$iv3 = value$iv4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(unit, (Function2) it$iv3, $composer2, 6);
            CompositionLocal this_$iv2 = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(this_$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final LifecycleOwner lifecycleOwner = (LifecycleOwner) consume2;
            final Ref.BooleanRef pageFirstLoad3 = pageFirstLoad;
            final State currentRefresh = SnapshotStateKt.rememberUpdatedState(new Function0() { // from class: kntr.app.mall.product.details.page.ProductDetailsPageKt$$ExternalSyntheticLambda10
                public final Object invoke() {
                    Unit ProductDetailsPage$lambda$6;
                    ProductDetailsPage$lambda$6 = ProductDetailsPageKt.ProductDetailsPage$lambda$6(pageFirstLoad3, pageViewModel);
                    return ProductDetailsPage$lambda$6;
                }
            }, $composer2, 0);
            ComposerKt.sourceInformationMarkerStart($composer2, -514276773, str9);
            boolean invalid$iv4 = $composer2.changed(currentRefresh) | $composer2.changedInstance(lifecycleOwner);
            Object it$iv4 = $composer2.rememberedValue();
            if (invalid$iv4) {
            }
            Object value$iv5 = new Function1() { // from class: kntr.app.mall.product.details.page.ProductDetailsPageKt$$ExternalSyntheticLambda11
                public final Object invoke(Object obj) {
                    DisposableEffectResult ProductDetailsPage$lambda$7$0;
                    ProductDetailsPage$lambda$7$0 = ProductDetailsPageKt.ProductDetailsPage$lambda$7$0(lifecycleOwner, currentRefresh, (DisposableEffectScope) obj);
                    return ProductDetailsPage$lambda$7$0;
                }
            };
            $composer2.updateRememberedValue(value$iv5);
            it$iv4 = value$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.DisposableEffect(lifecycleOwner, (Function1) it$iv4, $composer2, 0);
            final State scaleModel = SnapshotStateKt.collectAsState(pageViewModel.getUiScaleModelFlow$product_details_page_debug(), (CoroutineContext) null, $composer2, 0, 1);
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(-1985123773, true, new Function2() { // from class: kntr.app.mall.product.details.page.ProductDetailsPageKt$$ExternalSyntheticLambda12
                public final Object invoke(Object obj, Object obj2) {
                    Unit ProductDetailsPage$lambda$8;
                    ProductDetailsPage$lambda$8 = ProductDetailsPageKt.ProductDetailsPage$lambda$8(scaleModel, pageViewModel, loadingState$delegate, errorState$delegate, (Composer) obj, ((Integer) obj2).intValue());
                    return ProductDetailsPage$lambda$8;
                }
            }, $composer2, 54), $composer2, 384, 3);
            ComposerKt.sourceInformationMarkerStart($composer2, -514225747, str9);
            SharedFlow eventFlow5 = eventFlow2;
            boolean invalid$iv5 = $composer2.changedInstance(eventFlow5) | $composer2.changedInstance(pageViewModel);
            Object it$iv5 = $composer2.rememberedValue();
            if (!invalid$iv5 && it$iv5 != Composer.Companion.getEmpty()) {
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.LaunchedEffect(eventFlow5, (Function2) it$iv5, $composer2, ($dirty >> 6) & 14);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                onViewModelCreate = onViewModelCreate4;
                msource2 = msource3;
                eventFlow = eventFlow5;
            }
            Object value$iv6 = (Function2) new ProductDetailsPageKt$ProductDetailsPage$6$1(eventFlow5, pageViewModel, null);
            $composer2.updateRememberedValue(value$iv6);
            it$iv5 = value$iv6;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(eventFlow5, (Function2) it$iv5, $composer2, ($dirty >> 6) & 14);
            if (ComposerKt.isTraceInProgress()) {
            }
            onViewModelCreate = onViewModelCreate4;
            msource2 = msource3;
            eventFlow = eventFlow5;
        } else {
            $dirty = $dirty3;
            $composer2 = $composer4;
            $composer2.skipToGroupEnd();
            eventFlow = sharedFlow;
            itemsId2 = itemsId;
            msource2 = msource;
            track_id2 = track_id;
            from2 = from;
            is_ad2 = is_ad;
            detailPreload2 = detailPreload;
            originUrl2 = originUrl;
            fromSpmId2 = fromSpmId;
            onViewModelCreate = function1;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final SharedFlow sharedFlow2 = eventFlow;
            final String str10 = itemsId2;
            final String str11 = msource2;
            final String str12 = track_id2;
            final String str13 = from2;
            final String str14 = is_ad2;
            final String str15 = detailPreload2;
            final String str16 = originUrl2;
            final String str17 = fromSpmId2;
            final Function1 function12 = onViewModelCreate;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ProductDetailsPageKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit ProductDetailsPage$lambda$10;
                    ProductDetailsPage$lambda$10 = ProductDetailsPageKt.ProductDetailsPage$lambda$10(function2, function3, sharedFlow2, str10, str11, str12, str13, str14, str15, str16, str17, function12, $changed, $changed1, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ProductDetailsPage$lambda$10;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PageViewModel ProductDetailsPage$lambda$1$0(ProductDetailsPageKt$ProductDetailsPage$repository$1 $repository, String $itemsId, String $msource, String $track_id, String $from, String $is_ad, String $detailPreload, String $originUrl, Function2 $valueBridge, Function3 $bridgeCall, final Router $router, final float $screenWidth, final float $screenHeight, final OnBackPressedDispatcher $backPressedDispatcher, CreationExtras $this$viewModel) {
        Intrinsics.checkNotNullParameter($this$viewModel, "$this$viewModel");
        return new PageViewModel($repository, new Function0() { // from class: kntr.app.mall.product.details.page.ProductDetailsPageKt$$ExternalSyntheticLambda5
            public final Object invoke() {
                Router ProductDetailsPage$lambda$1$0$0;
                ProductDetailsPage$lambda$1$0$0 = ProductDetailsPageKt.ProductDetailsPage$lambda$1$0$0(Router.this);
                return ProductDetailsPage$lambda$1$0$0;
            }
        }, new Function0() { // from class: kntr.app.mall.product.details.page.ProductDetailsPageKt$$ExternalSyntheticLambda6
            public final Object invoke() {
                Pair ProductDetailsPage$lambda$1$0$1;
                ProductDetailsPage$lambda$1$0$1 = ProductDetailsPageKt.ProductDetailsPage$lambda$1$0$1($screenWidth, $screenHeight);
                return ProductDetailsPage$lambda$1$0$1;
            }
        }, new Function0() { // from class: kntr.app.mall.product.details.page.ProductDetailsPageKt$$ExternalSyntheticLambda7
            public final Object invoke() {
                OnBackPressedDispatcher ProductDetailsPage$lambda$1$0$2;
                ProductDetailsPage$lambda$1$0$2 = ProductDetailsPageKt.ProductDetailsPage$lambda$1$0$2($backPressedDispatcher);
                return ProductDetailsPage$lambda$1$0$2;
            }
        }, $itemsId, $msource, $track_id, $from, $is_ad, $detailPreload, $originUrl, $valueBridge, $bridgeCall);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Router ProductDetailsPage$lambda$1$0$0(Router $router) {
        return $router;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair ProductDetailsPage$lambda$1$0$1(float $screenWidth, float $screenHeight) {
        return new Pair(Dp.box-impl($screenWidth), Dp.box-impl($screenHeight));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OnBackPressedDispatcher ProductDetailsPage$lambda$1$0$2(OnBackPressedDispatcher $backPressedDispatcher) {
        return $backPressedDispatcher;
    }

    private static final boolean ProductDetailsPage$lambda$2(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    private static final String ProductDetailsPage$lambda$3(State<String> state) {
        Object thisObj$iv = state.getValue();
        return (String) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductDetailsPage$lambda$6(Ref.BooleanRef $pageFirstLoad, PageViewModel $pageViewModel) {
        KLog_androidKt.getKLog().e("wbw_detail_good", "Result: onResume, pageFirsLoad: " + $pageFirstLoad.element);
        if ($pageFirstLoad.element) {
            $pageFirstLoad.element = false;
            return Unit.INSTANCE;
        }
        $pageViewModel.reloadProductDetails$product_details_page_debug();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult ProductDetailsPage$lambda$7$0(final LifecycleOwner $lifecycleOwner, final State $currentRefresh, DisposableEffectScope $this$DisposableEffect) {
        Intrinsics.checkNotNullParameter($this$DisposableEffect, "$this$DisposableEffect");
        final LifecycleObserver lifecycleObserver = new LifecycleEventObserver() { // from class: kntr.app.mall.product.details.page.ProductDetailsPageKt$$ExternalSyntheticLambda4
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                ProductDetailsPageKt.ProductDetailsPage$lambda$7$0$0($currentRefresh, lifecycleOwner, event);
            }
        };
        $lifecycleOwner.getLifecycle().addObserver(lifecycleObserver);
        return new DisposableEffectResult() { // from class: kntr.app.mall.product.details.page.ProductDetailsPageKt$ProductDetailsPage$lambda$7$0$$inlined$onDispose$1
            public void dispose() {
                KLog_androidKt.getKLog().e("wbw_detail_good", "Result: onDispose");
                $lifecycleOwner.getLifecycle().removeObserver(lifecycleObserver);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ProductDetailsPage$lambda$7$0$0(State $currentRefresh, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<unused var>");
        Intrinsics.checkNotNullParameter(event, "event");
        KLog_androidKt.getKLog().e("wbw_detail_LifecycleEventObserver", "LifecycleEventObserver: " + event);
        if (event == Lifecycle.Event.ON_RESUME) {
            ((Function0) $currentRefresh.getValue()).invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00ad, code lost:
        if (r1 == false) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit ProductDetailsPage$lambda$8(State $scaleModel, final PageViewModel $pageViewModel, State $loadingState$delegate, State $errorState$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C277@11265L28,278@11313L20:ProductDetailsPage.kt#lbyouy");
        boolean z = true;
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1985123773, $changed, -1, "kntr.app.mall.product.details.page.ProductDetailsPage.<anonymous> (ProductDetailsPage.kt:277)");
            }
            SystemUiController controller = SystemUI_androidKt.rememberSystemUiController($composer, 0);
            SystemUIKt.setStatusBarByGarb(controller, $composer, 0);
            if (!ProductDetailsPage$lambda$2($loadingState$delegate) && ProductDetailsPage$lambda$3($errorState$delegate) != null) {
                $composer.startReplaceGroup(-1417423239);
                ComposerKt.sourceInformation($composer, "285@11545L84,283@11450L198");
                float scale = ((UiScaleModel) $scaleModel.getValue()).getScale();
                ComposerKt.sourceInformationMarkerStart($composer, -738456521, "CC(remember):ProductDetailsPage.kt#9igjgp");
                boolean invalid$iv = $composer.changedInstance($pageViewModel);
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ProductDetailsPageKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            Unit ProductDetailsPage$lambda$8$0$0;
                            ProductDetailsPage$lambda$8$0$0 = ProductDetailsPageKt.ProductDetailsPage$lambda$8$0$0(PageViewModel.this);
                            return ProductDetailsPage$lambda$8$0$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                ErrorScreenKt.ErrorScreen(scale, null, (Function0) it$iv, $composer, 0, 2);
                $composer.endReplaceGroup();
            } else {
                if (ProductDetailsPage$lambda$2($loadingState$delegate)) {
                    if (ProductDetailsPage$lambda$3($errorState$delegate) == null) {
                        ProductDetailsResponse productDetailsResponse = (ProductDetailsResponse) $pageViewModel.getProductDetailsResponse().getValue();
                        if (productDetailsResponse == null || !productDetailsResponse.isValid$product_details_page_debug()) {
                            z = false;
                        }
                    }
                    $composer.startReplaceGroup(-1416966485);
                    ComposerKt.sourceInformation($composer, "297@11914L84");
                    LoadingScreenKt.LoadingScreen(((UiScaleModel) $scaleModel.getValue()).getScale(), null, $composer, 0, 2);
                    $composer.endReplaceGroup();
                }
                $composer.startReplaceGroup(-1416782004);
                ComposerKt.sourceInformation($composer, "304@12100L83");
                ContentScreenKt.ContentScreen($pageViewModel, null, $composer, 0, 2);
                $composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductDetailsPage$lambda$8$0$0(PageViewModel $pageViewModel) {
        $pageViewModel.reloadProductDetails$product_details_page_debug();
        return Unit.INSTANCE;
    }
}