package kntr.app.mall.product.details.page.vm;

import androidx.activity.OnBackPressedDispatcher;
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.pager.PagerStateKt;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bilibili.lib.brouter.uri.Builder;
import com.bilibili.lib.brouter.uri.Uri;
import io.ktor.http.Parameters;
import io.ktor.http.URLUtilsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kntr.app.mall.product.details.page.api.Client;
import kntr.app.mall.product.details.page.api.CommentInfoApiService;
import kntr.app.mall.product.details.page.api.CouponListApiService;
import kntr.app.mall.product.details.page.api.CouponListResponse;
import kntr.app.mall.product.details.page.api.FeedBlastApiService;
import kntr.app.mall.product.details.page.api.IPFeedRecommendV2ApiService;
import kntr.app.mall.product.details.page.api.LiveInfoApiService;
import kntr.app.mall.product.details.page.api.ProductShopApiService;
import kntr.app.mall.product.details.page.api.ProductShopDetailsShopItem;
import kntr.app.mall.product.details.page.api.ReserveApiService;
import kntr.app.mall.product.details.page.api.model.ActAtmosphereVO;
import kntr.app.mall.product.details.page.api.model.ActionIconModel;
import kntr.app.mall.product.details.page.api.model.ActivityInfoFloor;
import kntr.app.mall.product.details.page.api.model.AdvStateFloor;
import kntr.app.mall.product.details.page.api.model.AtmospherePriceFloor;
import kntr.app.mall.product.details.page.api.model.AttrFloor;
import kntr.app.mall.product.details.page.api.model.BasicInfoFloor;
import kntr.app.mall.product.details.page.api.model.CalendarRemindModel;
import kntr.app.mall.product.details.page.api.model.CommentFloor;
import kntr.app.mall.product.details.page.api.model.CountDownInfoVO;
import kntr.app.mall.product.details.page.api.model.CouponInfoFloor;
import kntr.app.mall.product.details.page.api.model.CouponInfoModel;
import kntr.app.mall.product.details.page.api.model.CouponPackageInfoModel;
import kntr.app.mall.product.details.page.api.model.CourseInfoFloor;
import kntr.app.mall.product.details.page.api.model.CrowdfundingAtmosFloor;
import kntr.app.mall.product.details.page.api.model.CrowdfundingProgressFloor;
import kntr.app.mall.product.details.page.api.model.CrowdfundingStairsFloor;
import kntr.app.mall.product.details.page.api.model.DeliveryInfoFloor;
import kntr.app.mall.product.details.page.api.model.DetailDescFloor;
import kntr.app.mall.product.details.page.api.model.FeedsModel;
import kntr.app.mall.product.details.page.api.model.FileInfoFloor;
import kntr.app.mall.product.details.page.api.model.FooterFloor;
import kntr.app.mall.product.details.page.api.model.HeaderFloor;
import kntr.app.mall.product.details.page.api.model.IpBrandFloor;
import kntr.app.mall.product.details.page.api.model.LabelObject;
import kntr.app.mall.product.details.page.api.model.MallRecommendItem;
import kntr.app.mall.product.details.page.api.model.MergeAtmospherePriceFloor;
import kntr.app.mall.product.details.page.api.model.ProductDetailsResponse;
import kntr.app.mall.product.details.page.api.model.RecFloor;
import kntr.app.mall.product.details.page.api.model.RecommendVO;
import kntr.app.mall.product.details.page.api.model.ReportInfo;
import kntr.app.mall.product.details.page.api.model.SeriesFloor;
import kntr.app.mall.product.details.page.api.model.ServiceDescFloor;
import kntr.app.mall.product.details.page.api.model.ServiceFloor;
import kntr.app.mall.product.details.page.api.model.ShareExtra;
import kntr.app.mall.product.details.page.api.model.ShopInfoFloor;
import kntr.app.mall.product.details.page.api.model.ShopItem;
import kntr.app.mall.product.details.page.api.model.SkuInfoFloor;
import kntr.app.mall.product.details.page.api.model.WishInfo;
import kntr.app.mall.product.details.page.kmm.ProductDetailsPageUpCouponDisplayModel;
import kntr.app.mall.product.details.page.ui.container.TopTabItem;
import kntr.app.mall.product.details.page.ui.scale.UiScaleModel;
import kntr.app.mall.product.details.page.utils.ConstsKt;
import kntr.app.mall.product.details.page.utils.DateFormatKt;
import kntr.app.mall.product.details.page.utils.TrackConsts;
import kntr.app.mall.product.details.page.utils.UserInfoKt;
import kntr.app.mall.product.details.page.vm.ContentModule;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.account.model.UserInfo;
import kntr.base.appinfo.KAppInfo;
import kntr.base.config.KConfig;
import kntr.base.config.SharedPreferences;
import kntr.base.device.DeviceType;
import kntr.base.device.KDevice;
import kntr.base.log.KLog_androidKt;
import kntr.base.neuron.KNeuron;
import kntr.base.router.Router;
import kntr.common.router.UrisKt;
import kntr.watch.later.watchlater.edit.MediaAttrUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

/* compiled from: PageViewModel.kt */
@Metadata(d1 = {"\u0000ø\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001BÔ\u0002\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b0\u0005\u0012\u0010\u0010\n\u001a\f\u0012\b\u0012\u00060\u000bj\u0002`\f0\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000e\u0012B\u0010\u0015\u001a>\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u000e0\u0016\u0012o\u0010\u001d\u001ak\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001c\u0012+\u0012)\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001b0\u001a\u0012\u0004\u0012\u00020 0\u001f¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020 0\u001e¢\u0006\u0004\b\"\u0010#J\u000f\u0010\u0082\u0002\u001a\u00020 H\u0000¢\u0006\u0003\b\u0083\u0002J\u0018\u0010\u0084\u0002\u001a\u00020 2\u0007\u0010\u0085\u0002\u001a\u000206H\u0000¢\u0006\u0003\b\u0086\u0002J\u0018\u0010\u0087\u0002\u001a\u00020 2\u0007\u0010\u0088\u0002\u001a\u00020DH\u0000¢\u0006\u0003\b\u0089\u0002J\u0018\u0010\u008a\u0002\u001a\u00020 2\u0007\u0010\u008b\u0002\u001a\u000206H\u0000¢\u0006\u0003\b\u008c\u0002J\u0018\u0010\u008d\u0002\u001a\u00020 2\u0007\u0010\u008b\u0002\u001a\u000206H\u0000¢\u0006\u0003\b\u008e\u0002J\u001b\u0010\u008f\u0002\u001a\u00020 2\n\u0010\u0090\u0002\u001a\u0005\u0018\u00010 \u0001H\u0000¢\u0006\u0003\b\u0091\u0002J\u0018\u0010\u0092\u0002\u001a\u00020 2\u0007\u0010\u008b\u0002\u001a\u000206H\u0000¢\u0006\u0003\b\u0093\u0002J\u0018\u0010\u0094\u0002\u001a\u00020 2\u0007\u0010\u0095\u0002\u001a\u00020DH\u0000¢\u0006\u0003\b\u0096\u0002J\u0018\u0010\u0097\u0002\u001a\u00020 2\u0007\u0010\u008b\u0002\u001a\u000206H\u0000¢\u0006\u0003\b\u0098\u0002J\u0018\u0010\u0099\u0002\u001a\u00020 2\u0007\u0010\u008b\u0002\u001a\u000206H\u0000¢\u0006\u0003\b\u009a\u0002JJ\u0010\u009b\u0002\u001a\u00020 2\u000f\u0010\u009c\u0002\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010|2\t\b\u0002\u0010\u0095\u0002\u001a\u00020D2\u001d\b\u0002\u0010\u009d\u0002\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0005\u0012\u00030\u009e\u0002\u0012\u0005\u0012\u00030\u009e\u00020\b0|H\u0000¢\u0006\u0003\b\u009f\u0002J;\u0010 \u0002\u001a\u00020 2\u000b\b\u0002\u0010¡\u0002\u001a\u0004\u0018\u00010\u000e2\f\b\u0002\u0010¢\u0002\u001a\u0005\u0018\u00010£\u00022\f\b\u0002\u0010¤\u0002\u001a\u0005\u0018\u00010£\u0002H\u0000¢\u0006\u0006\b¥\u0002\u0010¦\u0002J\u000f\u0010§\u0002\u001a\u00020 H\u0000¢\u0006\u0003\b¨\u0002J\u0011\u0010©\u0002\u001a\u0004\u0018\u00010\u000eH\u0000¢\u0006\u0003\bª\u0002J\u0010\u0010«\u0002\u001a\u00030\u009e\u0002H\u0000¢\u0006\u0003\b¬\u0002J\u0018\u0010\u00ad\u0002\u001a\u00020 2\u0007\u0010\u0095\u0002\u001a\u00020DH\u0000¢\u0006\u0003\b®\u0002J\u000f\u0010¯\u0002\u001a\u00020 H\u0000¢\u0006\u0003\b°\u0002J\u001e\u0010±\u0002\u001a\u00020 2\r\u0010²\u0002\u001a\b\u0012\u0004\u0012\u00020\u001b0|H\u0000¢\u0006\u0003\b³\u0002J\u000f\u0010´\u0002\u001a\u00020DH\u0000¢\u0006\u0003\bµ\u0002J\u001a\u0010¶\u0002\u001a\u0004\u0018\u00010\u000e2\u0007\u0010·\u0002\u001a\u00020DH\u0000¢\u0006\u0003\b¸\u0002J,\u0010¹\u0002\u001a\u00020 2\u0007\u0010º\u0002\u001a\u00020D2\b\u0010»\u0002\u001a\u00030¼\u00022\b\u0010½\u0002\u001a\u00030¾\u0002H\u0000¢\u0006\u0003\b¿\u0002J\t\u0010À\u0002\u001a\u00020 H\u0002J\t\u0010Á\u0002\u001a\u00020 H\u0002J\u0013\u0010Â\u0002\u001a\u00020 2\b\u0010Ã\u0002\u001a\u00030Ä\u0002H\u0002J\t\u0010Å\u0002\u001a\u00020 H\u0002J\u000f\u0010Æ\u0002\u001a\u00020 H\u0000¢\u0006\u0003\bÇ\u0002J\u0014\u0010È\u0002\u001a\u00020 2\t\b\u0002\u0010É\u0002\u001a\u000206H\u0002J'\u0010Ê\u0002\u001a\u00020 2\u0006\u0010K\u001a\u00020J2\t\u0010Ë\u0002\u001a\u0004\u0018\u00010P2\t\u0010Ì\u0002\u001a\u0004\u0018\u00010^H\u0002J\t\u0010Í\u0002\u001a\u00020 H\u0002J\u001c\u0010Î\u0002\u001a\u0005\u0018\u00010\u0082\u00012\b\u0010Ï\u0002\u001a\u00030\u0081\u0001H\u0000¢\u0006\u0003\bÐ\u0002J$\u0010Ñ\u0002\u001a\b\u0012\u0004\u0012\u00020\u001b0|2\r\u0010Ò\u0002\u001a\b\u0012\u0004\u0012\u00020}0|H\u0000¢\u0006\u0003\bÓ\u0002J'\u0010Ô\u0002\u001a\u00020T2\u0012\b\u0002\u0010Õ\u0002\u001a\u000b\u0012\u0005\u0012\u00030Ö\u0002\u0018\u00010|H\u0080@¢\u0006\u0006\b×\u0002\u0010Ø\u0002J\u000f\u0010Ù\u0002\u001a\u00020 H\u0000¢\u0006\u0003\bÚ\u0002J\u000f\u0010Û\u0002\u001a\u00020 H\u0000¢\u0006\u0003\bÜ\u0002J\u0018\u0010Ý\u0002\u001a\u00020 2\u0007\u0010Þ\u0002\u001a\u00020\u000eH\u0000¢\u0006\u0003\bß\u0002J\u001a\u0010à\u0002\u001a\u00020 2\t\u0010á\u0002\u001a\u0004\u0018\u00010\u000eH\u0000¢\u0006\u0003\bâ\u0002J\u000f\u0010ã\u0002\u001a\u00020 H\u0000¢\u0006\u0003\bä\u0002J\u0019\u0010å\u0002\u001a\u00020 2\b\u0010æ\u0002\u001a\u00030ç\u0002H\u0000¢\u0006\u0003\bè\u0002J\u000f\u0010é\u0002\u001a\u00020 H\u0000¢\u0006\u0003\bê\u0002J\u0019\u0010ë\u0002\u001a\u00020 2\b\u0010ì\u0002\u001a\u00030í\u0002H\u0000¢\u0006\u0003\bî\u0002J\u001a\u0010ï\u0002\u001a\u00020 2\t\u0010ð\u0002\u001a\u0004\u0018\u00010\u000eH\u0000¢\u0006\u0003\bñ\u0002J\u000f\u0010ò\u0002\u001a\u00020 H\u0000¢\u0006\u0003\bó\u0002J\u000f\u0010ô\u0002\u001a\u00020 H\u0000¢\u0006\u0003\bõ\u0002J\u000f\u0010ö\u0002\u001a\u00020 H\u0000¢\u0006\u0003\b÷\u0002J\u001b\u0010ø\u0002\u001a\u00020 2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0000¢\u0006\u0003\bù\u0002J(\u0010ú\u0002\u001a\u00020 2\u000e\u0010û\u0002\u001a\t\u0012\u0005\u0012\u00030ü\u00020|2\u0007\u0010ý\u0002\u001a\u000206H\u0000¢\u0006\u0003\bþ\u0002J\"\u0010ÿ\u0002\u001a\u00020 2\b\u0010\u0080\u0003\u001a\u00030ü\u00022\u0007\u0010ý\u0002\u001a\u000206H\u0000¢\u0006\u0003\b\u0081\u0003J \u0010\u0082\u0003\u001a\u00020 2\u0006\u00105\u001a\u0002062\u0007\u0010ý\u0002\u001a\u000206H\u0000¢\u0006\u0003\b\u0083\u0003J\u0019\u0010\u0084\u0003\u001a\u00020 2\b\u0010æ\u0002\u001a\u00030å\u0001H\u0000¢\u0006\u0003\b\u0085\u0003J\u0019\u0010\u0086\u0003\u001a\u00020 2\b\u0010æ\u0002\u001a\u00030å\u0001H\u0000¢\u0006\u0003\b\u0087\u0003J\u0019\u0010\u0088\u0003\u001a\u00020 2\b\u0010æ\u0002\u001a\u00030\u0089\u0003H\u0000¢\u0006\u0003\b\u008a\u0003J\u0019\u0010\u008b\u0003\u001a\u00020 2\b\u0010æ\u0002\u001a\u00030\u0089\u0003H\u0000¢\u0006\u0003\b\u008c\u0003J\"\u0010\u008d\u0003\u001a\u00020 2\b\u0010æ\u0002\u001a\u00030ü\u00022\u0007\u0010\u0095\u0002\u001a\u00020DH\u0000¢\u0006\u0003\b\u008e\u0003J\"\u0010\u008f\u0003\u001a\u00020 2\b\u0010æ\u0002\u001a\u00030ü\u00022\u0007\u0010\u0095\u0002\u001a\u00020DH\u0000¢\u0006\u0003\b\u0090\u0003J\u000f\u0010\u0091\u0003\u001a\u00020 H\u0000¢\u0006\u0003\b\u0092\u0003J\u000f\u0010\u0093\u0003\u001a\u00020 H\u0000¢\u0006\u0003\b\u0094\u0003J\u0019\u0010\u0095\u0003\u001a\u00020 2\b\u0010\u0096\u0003\u001a\u00030\u0097\u0003H\u0000¢\u0006\u0003\b\u0098\u0003J\u0019\u0010\u0099\u0003\u001a\u00020 2\b\u0010\u009a\u0003\u001a\u00030\u009b\u0003H\u0000¢\u0006\u0003\b\u009c\u0003J\u0019\u0010\u009d\u0003\u001a\u00020 2\b\u0010\u009a\u0003\u001a\u00030\u009b\u0003H\u0000¢\u0006\u0003\b\u009e\u0003J\u0019\u0010\u009f\u0003\u001a\u00020 2\b\u0010\u009a\u0003\u001a\u00030 \u0003H\u0000¢\u0006\u0003\b¡\u0003J\u0019\u0010¢\u0003\u001a\u00020 2\b\u0010\u009a\u0003\u001a\u00030 \u0003H\u0000¢\u0006\u0003\b£\u0003J\u0012\u0010¤\u0003\u001a\u00020\u000e2\u0007\u0010Þ\u0002\u001a\u00020\u000eH\u0002J\u001b\u0010¥\u0003\u001a\u00020 2\n\u0010\u0090\u0002\u001a\u0005\u0018\u00010 \u0001H\u0000¢\u0006\u0003\b¦\u0003J\u001d\u0010§\u0003\u001a\u0002062\b\u0010¨\u0003\u001a\u00030©\u0003H\u0080@¢\u0006\u0006\bª\u0003\u0010«\u0003J\u001d\u0010¬\u0003\u001a\u00030ç\u00012\u0007\u0010\u00ad\u0003\u001a\u00020DH\u0080@¢\u0006\u0006\b®\u0003\u0010¯\u0003J7\u0010°\u0003\u001a\u0002062\b\u0010±\u0003\u001a\u00030²\u00032\u000b\b\u0002\u0010³\u0003\u001a\u0004\u0018\u00010\u000e2\u000b\b\u0002\u0010´\u0003\u001a\u0004\u0018\u00010\u000eH\u0080@¢\u0006\u0006\bµ\u0003\u0010¶\u0003J\u001a\u0010·\u0003\u001a\u00020 2\t\u0010Þ\u0002\u001a\u0004\u0018\u00010\u000eH\u0000¢\u0006\u0003\b¸\u0003J\u000f\u0010¹\u0003\u001a\u00020 H\u0000¢\u0006\u0003\bº\u0003JB\u0010»\u0003\u001a\u00020 2\n\u0010¼\u0003\u001a\u0005\u0018\u00010Ô\u00012\n\u0010½\u0003\u001a\u0005\u0018\u00010Ô\u00012\n\u0010¾\u0003\u001a\u0005\u0018\u00010Ô\u00012\n\u0010¿\u0003\u001a\u0005\u0018\u00010Ô\u0001H\u0000¢\u0006\u0006\bÀ\u0003\u0010Á\u0003J\u0019\u0010Â\u0003\u001a\u00020 2\b\u0010Ã\u0003\u001a\u00030Ä\u0003H\u0000¢\u0006\u0003\bÅ\u0003J\u0012\u0010Æ\u0003\u001a\u00020 2\u0007\u0010É\u0002\u001a\u000206H\u0002J\u000f\u0010Ç\u0003\u001a\u00020 H\u0000¢\u0006\u0003\bÈ\u0003J\u0018\u0010É\u0003\u001a\u00020 2\u0007\u0010Ê\u0003\u001a\u00020\u000eH\u0000¢\u0006\u0003\bË\u0003J\t\u0010Ì\u0003\u001a\u00020 H\u0002J\t\u0010Í\u0003\u001a\u00020 H\u0002J.\u0010Î\u0003\u001a\b\u0012\u0004\u0012\u00020}0|2\u0007\u0010Ï\u0003\u001a\u00020J2\t\u0010Ë\u0002\u001a\u0004\u0018\u00010P2\t\u0010Ì\u0002\u001a\u0004\u0018\u00010^H\u0002J\u0012\u0010Ð\u0003\u001a\u00020 2\u0007\u0010Ï\u0003\u001a\u00020JH\u0002J\u0012\u0010Ñ\u0003\u001a\u00020 2\u0007\u0010Ï\u0003\u001a\u00020JH\u0002J\u001f\u0010Ò\u0003\u001a\u00020 2\u0007\u0010Ï\u0003\u001a\u00020J2\u000b\b\u0002\u0010Ó\u0003\u001a\u0004\u0018\u00010fH\u0002J\t\u0010Ô\u0003\u001a\u00020 H\u0002JB\u0010Õ\u0003\u001a\u00030¨\u00012\u0007\u0010Ö\u0003\u001a\u00020\u000e2\u0007\u0010×\u0003\u001a\u00020D2\u001e\u0010Ø\u0003\u001a\u0019\b\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020 0Ù\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u001fH\u0002¢\u0006\u0003\u0010Ú\u0003J\u0012\u0010Û\u0003\u001a\u00020 2\u0007\u0010Ï\u0003\u001a\u00020JH\u0002J\u000f\u0010Ü\u0003\u001a\u00020 H\u0000¢\u0006\u0003\bÝ\u0003J\"\u0010Þ\u0003\u001a\u00020 2\b\u0010Ï\u0003\u001a\u00030ç\u00012\u0007\u0010\u00ad\u0003\u001a\u00020DH\u0000¢\u0006\u0003\bß\u0003J\u000f\u0010à\u0003\u001a\u000206H\u0000¢\u0006\u0003\bá\u0003J\u001b\u0010à\u0003\u001a\u0002062\n\u0010â\u0003\u001a\u0005\u0018\u00010ã\u0003H\u0000¢\u0006\u0003\bá\u0003J$\u0010ä\u0003\u001a\u000b\u0012\u0005\u0012\u00030ü\u0002\u0018\u00010|2\n\u0010â\u0003\u001a\u0005\u0018\u00010ã\u0003H\u0000¢\u0006\u0003\bå\u0003J\u000f\u0010æ\u0003\u001a\u000206H\u0000¢\u0006\u0003\bç\u0003J\u000f\u0010è\u0003\u001a\u000206H\u0000¢\u0006\u0003\bé\u0003J\u000f\u0010ê\u0003\u001a\u000206H\u0000¢\u0006\u0003\bë\u0003J&\u0010ì\u0003\u001a\u0010\u0012\u0005\u0012\u00030\u0081\u0001\u0012\u0005\u0012\u00030\u0082\u00010\u001a2\r\u0010Ò\u0002\u001a\b\u0012\u0004\u0012\u00020}0|H\u0002J\t\u0010í\u0003\u001a\u00020 H\u0014J\t\u0010î\u0003\u001a\u00020 H\u0002J\u001e\u0010ï\u0003\u001a\u00020\u000e2\n\u0010ð\u0003\u001a\u0005\u0018\u00010Ô\u0001H\u0000¢\u0006\u0006\bñ\u0003\u0010ò\u0003J\u001e\u0010ó\u0003\u001a\u00020 2\n\u0010ð\u0003\u001a\u0005\u0018\u00010Ô\u0001H\u0000¢\u0006\u0006\bô\u0003\u0010Ø\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\f\u0012\b\u0012\u00060\u000bj\u0002`\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u000eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010%R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010%R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u000eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010%R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000RJ\u0010\u0015\u001a>\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u000e0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000Rw\u0010\u001d\u001ak\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001c\u0012+\u0012)\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001b0\u001a\u0012\u0004\u0012\u00020 0\u001f¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020 0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\u00020+X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u000e\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\u000202X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0013\u00105\u001a\u0004\u0018\u0001068F¢\u0006\u0006\u001a\u0004\b5\u00107R\u0011\u00108\u001a\u0002068F¢\u0006\u0006\u001a\u0004\b9\u0010:R\u001b\u0010;\u001a\u00020<8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\b=\u0010>R\u000e\u0010A\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020D0CX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020D0\u001a8F¢\u0006\u0006\u001a\u0004\bF\u0010GR\u0016\u0010H\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010J0IX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010K\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010J0L¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u0016\u0010O\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010P0IX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010Q\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010P0L¢\u0006\b\n\u0000\u001a\u0004\bR\u0010NR\u0016\u0010S\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010T0IX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010U\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010T0L¢\u0006\b\n\u0000\u001a\u0004\bV\u0010NR\u0016\u0010W\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0IX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010X\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0L¢\u0006\b\n\u0000\u001a\u0004\bY\u0010NR\u0016\u0010Z\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0IX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010[\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0L¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010NR\u0016\u0010]\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010^0IX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010_\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010^0L¢\u0006\b\n\u0000\u001a\u0004\b`\u0010NR\u0016\u0010a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010b0IX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010b0L¢\u0006\b\n\u0000\u001a\u0004\bd\u0010NR\u0016\u0010e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010f0IX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010g\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010f0L¢\u0006\b\n\u0000\u001a\u0004\bh\u0010NR\u0014\u0010i\u001a\b\u0012\u0004\u0012\u00020j0IX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010k\u001a\b\u0012\u0004\u0012\u00020j0L¢\u0006\b\n\u0000\u001a\u0004\bl\u0010NR\u0014\u0010m\u001a\b\u0012\u0004\u0012\u0002060IX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010n\u001a\b\u0012\u0004\u0012\u0002060L¢\u0006\b\n\u0000\u001a\u0004\bn\u0010NR\u0016\u0010o\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010p0IX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010q\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010p0LX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\br\u0010NR\u0016\u0010s\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010t0IX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010u\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010t0LX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bv\u0010NR\u0016\u0010w\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010x0IX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010y\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010x0LX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bz\u0010NR\u001a\u0010{\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020}0|0IX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010~\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020}0|0LX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u007f\u0010NR\u001d\u0010\u0080\u0001\u001a\u0010\u0012\u0005\u0012\u00030\u0081\u0001\u0012\u0005\u0012\u00030\u0082\u00010CX\u0082\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u0002060IX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0084\u0001\u001a\b\u0012\u0004\u0012\u0002060L¢\u0006\t\n\u0000\u001a\u0005\b\u0085\u0001\u0010NR\u0017\u0010\u0086\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0IX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0087\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0L¢\u0006\t\n\u0000\u001a\u0005\b\u0088\u0001\u0010NR\u0015\u0010\u0089\u0001\u001a\b\u0012\u0004\u0012\u00020D0IX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u008a\u0001\u001a\b\u0012\u0004\u0012\u00020D0L¢\u0006\t\n\u0000\u001a\u0005\b\u008b\u0001\u0010NR\u0018\u0010\u008c\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010\u008d\u00010IX\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u008e\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010\u008d\u00010LX\u0080\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u008f\u0001\u0010NR\u0015\u0010\u0090\u0001\u001a\b\u0012\u0004\u0012\u0002060IX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0091\u0001\u001a\b\u0012\u0004\u0012\u0002060L¢\u0006\t\n\u0000\u001a\u0005\b\u0092\u0001\u0010NR\u0015\u0010\u0093\u0001\u001a\b\u0012\u0004\u0012\u00020D0IX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0094\u0001\u001a\b\u0012\u0004\u0012\u00020D0L¢\u0006\t\n\u0000\u001a\u0005\b\u0095\u0001\u0010NR\u0015\u0010\u0096\u0001\u001a\b\u0012\u0004\u0012\u0002060IX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0097\u0001\u001a\b\u0012\u0004\u0012\u0002060L¢\u0006\t\n\u0000\u001a\u0005\b\u0098\u0001\u0010NR\u0015\u0010\u0099\u0001\u001a\b\u0012\u0004\u0012\u0002060IX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u009a\u0001\u001a\b\u0012\u0004\u0012\u0002060L¢\u0006\t\n\u0000\u001a\u0005\b\u009b\u0001\u0010NR\u0015\u0010\u009c\u0001\u001a\b\u0012\u0004\u0012\u0002060IX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u009d\u0001\u001a\b\u0012\u0004\u0012\u0002060L¢\u0006\t\n\u0000\u001a\u0005\b\u009e\u0001\u0010NR\u0018\u0010\u009f\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010 \u00010IX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010¡\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010 \u00010L¢\u0006\t\n\u0000\u001a\u0005\b¢\u0001\u0010NR\u0018\u0010£\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010¤\u00010IX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010¥\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010¤\u00010L¢\u0006\t\n\u0000\u001a\u0005\b¦\u0001\u0010NR&\u0010§\u0001\u001a\t\u0012\u0005\u0012\u00030¨\u00010|X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b©\u0001\u0010ª\u0001\"\u0006\b«\u0001\u0010¬\u0001R\u0018\u0010\u00ad\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010®\u00010IX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010¯\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010®\u00010L¢\u0006\t\n\u0000\u001a\u0005\b°\u0001\u0010NR\u0018\u0010±\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010®\u00010IX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010²\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010®\u00010L¢\u0006\t\n\u0000\u001a\u0005\b³\u0001\u0010NR$\u0010´\u0001\u001a\u0004\u0018\u00010DX\u0086\u000e¢\u0006\u0015\n\u0003\u0010¹\u0001\u001a\u0006\bµ\u0001\u0010¶\u0001\"\u0006\b·\u0001\u0010¸\u0001R$\u0010º\u0001\u001a\u0004\u0018\u00010DX\u0086\u000e¢\u0006\u0015\n\u0003\u0010¹\u0001\u001a\u0006\b»\u0001\u0010¶\u0001\"\u0006\b¼\u0001\u0010¸\u0001R$\u0010½\u0001\u001a\u0004\u0018\u00010DX\u0086\u000e¢\u0006\u0015\n\u0003\u0010¹\u0001\u001a\u0006\b¾\u0001\u0010¶\u0001\"\u0006\b¿\u0001\u0010¸\u0001R$\u0010À\u0001\u001a\u0004\u0018\u00010DX\u0086\u000e¢\u0006\u0015\n\u0003\u0010¹\u0001\u001a\u0006\bÁ\u0001\u0010¶\u0001\"\u0006\bÂ\u0001\u0010¸\u0001R \u0010Ã\u0001\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\bÄ\u0001\u0010%\"\u0006\bÅ\u0001\u0010Æ\u0001R$\u0010Ç\u0001\u001a\u0004\u0018\u00010DX\u0086\u000e¢\u0006\u0015\n\u0003\u0010¹\u0001\u001a\u0006\bÈ\u0001\u0010¶\u0001\"\u0006\bÉ\u0001\u0010¸\u0001R$\u0010Ê\u0001\u001a\u0004\u0018\u00010DX\u0086\u000e¢\u0006\u0015\n\u0003\u0010¹\u0001\u001a\u0006\bË\u0001\u0010¶\u0001\"\u0006\bÌ\u0001\u0010¸\u0001R$\u0010Í\u0001\u001a\u0004\u0018\u00010DX\u0086\u000e¢\u0006\u0015\n\u0003\u0010¹\u0001\u001a\u0006\bÎ\u0001\u0010¶\u0001\"\u0006\bÏ\u0001\u0010¸\u0001R\u001e\u0010Ð\u0001\u001a\u00020\u000eX\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\bÑ\u0001\u0010%\"\u0006\bÒ\u0001\u0010Æ\u0001R%\u0010Ó\u0001\u001a\u0005\u0018\u00010Ô\u0001X\u0086\u000e¢\u0006\u0015\n\u0003\u0010Ù\u0001\u001a\u0006\bÕ\u0001\u0010Ö\u0001\"\u0006\b×\u0001\u0010Ø\u0001R\u0015\u0010Ú\u0001\u001a\b\u0012\u0004\u0012\u0002060IX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010Û\u0001\u001a\b\u0012\u0004\u0012\u0002060L¢\u0006\t\n\u0000\u001a\u0005\bÜ\u0001\u0010NR\u0015\u0010Ý\u0001\u001a\b\u0012\u0004\u0012\u0002060IX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010Þ\u0001\u001a\b\u0012\u0004\u0012\u0002060L¢\u0006\t\n\u0000\u001a\u0005\bß\u0001\u0010NR\u0018\u0010à\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010á\u00010IX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010â\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010á\u00010L¢\u0006\t\n\u0000\u001a\u0005\bã\u0001\u0010NR\u001c\u0010ä\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030å\u00010|0IX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010æ\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010ç\u00010IX\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010è\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030å\u00010|0LX\u0080\u0004¢\u0006\t\n\u0000\u001a\u0005\bé\u0001\u0010NR\u001f\u0010ê\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010ç\u00010LX\u0080\u0004¢\u0006\t\n\u0000\u001a\u0005\bë\u0001\u0010NR\u0015\u0010ì\u0001\u001a\b\u0012\u0004\u0012\u00020D0IX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010í\u0001\u001a\b\u0012\u0004\u0012\u00020D0L¢\u0006\t\n\u0000\u001a\u0005\bî\u0001\u0010NR\u0015\u0010ï\u0001\u001a\b\u0012\u0004\u0012\u0002060IX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010ð\u0001\u001a\b\u0012\u0004\u0012\u0002060L¢\u0006\t\n\u0000\u001a\u0005\bñ\u0001\u0010NR\u0018\u0010ò\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010ó\u00010IX\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010ô\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010ó\u00010LX\u0080\u0004¢\u0006\t\n\u0000\u001a\u0005\bõ\u0001\u0010NR\u0016\u0010ö\u0001\u001a\t\u0012\u0005\u0012\u00030÷\u00010IX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010ø\u0001\u001a\t\u0012\u0005\u0012\u00030÷\u00010LX\u0080\u0004¢\u0006\t\n\u0000\u001a\u0005\bù\u0001\u0010NR\u0018\u0010ú\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010û\u00010IX\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010ü\u0001\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010û\u00010LX\u0080\u0004¢\u0006\t\n\u0000\u001a\u0005\bý\u0001\u0010NR\u0010\u0010þ\u0001\u001a\u00030Ô\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010ÿ\u0001\u001a\u0005\u0018\u00010\u0080\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0081\u0002\u001a\u0004\u0018\u00010^X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006õ\u0003"}, d2 = {"Lkntr/app/mall/product/details/page/vm/PageViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lkntr/app/mall/product/details/page/vm/ApiRepository;", "routerProvider", "Lkotlin/Function0;", "Lkntr/base/router/Router;", "screenSizeProvider", "Lkotlin/Pair;", "Landroidx/compose/ui/unit/Dp;", "backPressedDispatcherProvider", "Landroidx/activity/OnBackPressedDispatcher;", "Lkntr/common/trio/pagecontroller/OnBackPressedDispatcher;", "itemsId", "", "msource", "track_id", "from", "is_ad", "detailPreload", "originUrl", "valueBridge", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "key", "", "", "data", "bridgeCall", "Lkotlin/Function3;", "Lkotlin/Function1;", "", "callback", "<init>", "(Lkntr/app/mall/product/details/page/vm/ApiRepository;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;)V", "getItemsId$product_details_page_debug", "()Ljava/lang/String;", "getMsource$product_details_page_debug", "getTrack_id$product_details_page_debug", "getFrom$product_details_page_debug", "is_ad$product_details_page_debug", "wrapper", "Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;", "getWrapper$product_details_page_debug", "()Lkntr/app/mall/product/details/page/vm/PageViewModelWrapper;", "urlParams", "Lio/ktor/http/Parameters;", "fromSpmid", "actionHandler", "Lkntr/app/mall/product/details/page/vm/PageActionHandler;", "getActionHandler$product_details_page_debug", "()Lkntr/app/mall/product/details/page/vm/PageActionHandler;", "isFromTMFeed", "", "()Ljava/lang/Boolean;", "useUpSay", "getUseUpSay", "()Z", "sp", "Lkntr/base/config/SharedPreferences;", "getSp", "()Lkntr/base/config/SharedPreferences;", "sp$delegate", "Lkotlin/Lazy;", "isProcessingShare", "_listKeyToIndexMap", "", "", "listKeyToIndexMap", "getListKeyToIndexMap", "()Ljava/util/Map;", "_productDetailsResponse", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkntr/app/mall/product/details/page/api/model/ProductDetailsResponse;", "productDetailsResponse", "Lkotlinx/coroutines/flow/StateFlow;", "getProductDetailsResponse", "()Lkotlinx/coroutines/flow/StateFlow;", "_commentApiResponse", "Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse;", "commentApiResponse", "getCommentApiResponse", "_couponApiResponse", "Lkntr/app/mall/product/details/page/api/CouponListResponse;", "couponApiResponse", "getCouponApiResponse", "_videoUrlState", "videoUrlState", "getVideoUrlState", "_upSayVideoUrlState", "upSayVideoUrlState", "getUpSayVideoUrlState", "_shopApiResponse", "Lkntr/app/mall/product/details/page/api/ProductShopApiService$ProductShopDetailsResponse;", "shopApiResponse", "getShopApiResponse", "_liveApiResponse", "Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoResponse;", "liveApiResponse", "getLiveApiResponse", "_ipFeedRecommendFlow", "Lkntr/app/mall/product/details/page/api/IPFeedRecommendV2ApiService$Response;", "ipFeedRecommendFlow", "getIpFeedRecommendFlow", "_wishInfo", "Lkntr/app/mall/product/details/page/api/model/WishInfo;", "wishInfo", "getWishInfo", "_isUserTriggeredWishAction", "isUserTriggeredWishAction", "mDeliveryInfoContainerState", "Lkntr/app/mall/product/details/page/vm/DeliveryInfoContainerState;", "deliveryInfoContainerState", "getDeliveryInfoContainerState$product_details_page_debug", "mTopContainerState", "Lkntr/app/mall/product/details/page/vm/TopContainerState;", "topContainerState", "getTopContainerState$product_details_page_debug", "mBottomContainerState", "Lkntr/app/mall/product/details/page/vm/BottomContainerState;", "bottomContainerState", "getBottomContainerState$product_details_page_debug", "mContentModules", "", "Lkntr/app/mall/product/details/page/vm/ContentModule;", "contentModules", "getContentModules$product_details_page_debug", "moduleViewModels", "Lkntr/app/mall/product/details/page/vm/FloorType;", "Lkntr/app/mall/product/details/page/vm/ModuleViewModel;", "_loadingState", "loadingState", "getLoadingState", "_errorState", "errorState", "getErrorState", "_selectedTabIndex", "selectedTabIndex", "getSelectedTabIndex", "mImagePreviewState", "Lkntr/app/mall/product/details/page/vm/ImagePreviewState;", "imagePreviewState", "getImagePreviewState$product_details_page_debug", "_showHeaderFullScreenPreview", "showHeaderFullScreenPreview", "getShowHeaderFullScreenPreview", "_headerSkuSelectedIndex", "headerSkuSelectedIndex", "getHeaderSkuSelectedIndex", "_showActivityCouponSheet", "showActivityCouponSheet", "getShowActivityCouponSheet", "_showSkuSwitch", "showSkuSwitch", "getShowSkuSwitch", "_showBenefitBottomSheet", "showBenefitBottomSheet", "getShowBenefitBottomSheet", "_fileInfoSelectedSku", "Lkntr/app/mall/product/details/page/api/model/SkuInfoFloor$ItemsSkuListVO$ItemsSkuListItem;", "fileInfoSelectedSku", "getFileInfoSelectedSku", "_fileInfo", "Lkntr/app/mall/product/details/page/api/model/FileInfoFloor$FileInfo;", "fileInfo", "getFileInfo", "fullscreenTopTabItems", "Lkntr/app/mall/product/details/page/ui/container/TopTabItem;", "getFullscreenTopTabItems$product_details_page_debug", "()Ljava/util/List;", "setFullscreenTopTabItems$product_details_page_debug", "(Ljava/util/List;)V", "_bannerPagerState", "Landroidx/compose/foundation/pager/PagerState;", "bannerPagerState", "getBannerPagerState", "_bannerPreviewPagerState", "bannerPreviewPagerState", "getBannerPreviewPagerState", "bannerVideoIndex", "getBannerVideoIndex", "()Ljava/lang/Integer;", "setBannerVideoIndex", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "bannerFirstItemCount", "getBannerFirstItemCount", "setBannerFirstItemCount", "bannerImagesStartIndex", "getBannerImagesStartIndex", "setBannerImagesStartIndex", "bannerSkuIndex", "getBannerSkuIndex", "setBannerSkuIndex", "bannerSkuName", "getBannerSkuName", "setBannerSkuName", "(Ljava/lang/String;)V", "bannerCommentOrUpSayIndex", "getBannerCommentOrUpSayIndex", "setBannerCommentOrUpSayIndex", "bannerIpFeedRecommendIndex", "getBannerIpFeedRecommendIndex", "setBannerIpFeedRecommendIndex", "bannerDetailPreviewIndex", "getBannerDetailPreviewIndex", "setBannerDetailPreviewIndex", "statusBarHeight", "getStatusBarHeight", "setStatusBarHeight", "merchantId", "", "getMerchantId", "()Ljava/lang/Long;", "setMerchantId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "_showCouponReserveResultDialog", "showCouponReserveResultDialog", "getShowCouponReserveResultDialog", "_showLikedCollectionLayer", "showLikedCollectionLayer", "getShowLikedCollectionLayer", "_reserveCouponResult", "Lkntr/app/mall/product/details/page/api/ReserveApiService$ReserveResultResponse$ReserveResultData;", "reserveCouponResult", "getReserveCouponResult", "mFeedBlastState", "Lkntr/app/mall/product/details/page/api/model/MallRecommendItem;", "mLastFeedBlastData", "Lkntr/app/mall/product/details/page/api/model/FeedsModel;", "feedBlastState", "getFeedBlastState$product_details_page_debug", "lastFeedBlastData", "getLastFeedBlastData$product_details_page_debug", "_topContainerHeightFlow", "topContainerHeightFlow", "getTopContainerHeightFlow", "_retainPopupVisibleFlow", "retainPopupVisibleFlow", "getRetainPopupVisibleFlow", "mImageBottomSheetStateFlow", "Lkntr/app/mall/product/details/page/vm/ImageBottomSheetState;", "imageBottomSheetStateFlow", "getImageBottomSheetStateFlow$product_details_page_debug", "mUiScaleModelFlow", "Lkntr/app/mall/product/details/page/ui/scale/UiScaleModel;", "uiScaleModelFlow", "getUiScaleModelFlow$product_details_page_debug", "mUpCouponAutoFetchDisplayStateFlow", "Lkntr/app/mall/product/details/page/kmm/ProductDetailsPageUpCouponDisplayModel;", "upCouponAutoFetchDisplayStateFlow", "getUpCouponAutoFetchDisplayStateFlow$product_details_page_debug", "lastWishClickTime", "hideWishLayerJob", "Lkotlinx/coroutines/Job;", "lastShopResponse", "hideAutoFetchedUpCoupon", "hideAutoFetchedUpCoupon$product_details_page_debug", "updateRetainPopupVisible", "visible", "updateRetainPopupVisible$product_details_page_debug", "updateTopContainerHeight", "height", "updateTopContainerHeight$product_details_page_debug", "updateCouponReserveResultDialogState", "show", "updateCouponReserveResultDialogState$product_details_page_debug", "updateSkuSwitchState", "updateSkuSwitchState$product_details_page_debug", "updateFileInfoSelectedSku", "sku", "updateFileInfoSelectedSku$product_details_page_debug", "updateActivityCouponSheetState", "updateActivityCouponSheetState$product_details_page_debug", "updateHeaderSkuSelectedIndex", "index", "updateHeaderSkuSelectedIndex$product_details_page_debug", "toggleHeaderFullScreenPreview", "toggleHeaderFullScreenPreview$product_details_page_debug", "toggleBenefitBottomSheet", "toggleBenefitBottomSheet$product_details_page_debug", "updateImagePreview", "imageUrls", "imageSizes", "", "updateImagePreview$product_details_page_debug", "showImageBottomSheet", "imageUrl", "imageWidth", "", "imageHeight", "showImageBottomSheet$product_details_page_debug", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;)V", "hideImageBottomSheet", "hideImageBottomSheet$product_details_page_debug", "getVideoUrl", "getVideoUrl$product_details_page_debug", "getGlobalScale", "getGlobalScale$product_details_page_debug", "updateSelectedTab", "updateSelectedTab$product_details_page_debug", "updateUiScale", "updateUiScale$product_details_page_debug", "rebuildKeyToIndexMap", "groupedContent", "rebuildKeyToIndexMap$product_details_page_debug", "getHeaderPageCount", "getHeaderPageCount$product_details_page_debug", "getCurrentSkuName", "skuIndex", "getCurrentSkuName$product_details_page_debug", "scrollToTab", "tabIndex", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "listState", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "scrollToTab$product_details_page_debug", "observeAccountState", "onLogout", "onLoggedOrUpdated", "userInfo", "Lkntr/base/account/model/UserInfo;", "firstLoadProduct", "reloadProductDetails", "reloadProductDetails$product_details_page_debug", "loadProductDetails", "isFirst", "fetchDataSuccess", "commentResponse", "shopResponse", "fetchDataSuccessAfter", "getModuleViewModel", "floorType", "getModuleViewModel$product_details_page_debug", "groupModules", "modules", "groupModules$product_details_page_debug", "getUserCouponList", "couponList", "Lkntr/app/mall/product/details/page/api/model/CouponInfoFloor$CouponInfo;", "getUserCouponList$product_details_page_debug", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showDeliveryFloatingLayer", "showDeliveryFloatingLayer$product_details_page_debug", "showSkuFloatingLayer", "showSkuFloatingLayer$product_details_page_debug", "bridgeShowHalfWebView", "url", "bridgeShowHalfWebView$product_details_page_debug", "handleSearch", "searchText", "handleSearch$product_details_page_debug", "handleBackAction", "handleBackAction$product_details_page_debug", "handleShopItemClick", "item", "Lkntr/app/mall/product/details/page/api/ProductShopDetailsShopItem;", "handleShopItemClick$product_details_page_debug", "handleGoToCommentList", "handleGoToCommentList$product_details_page_debug", "handleGoToCommentDetail", "comment", "Lkntr/app/mall/product/details/page/api/CommentInfoApiService$CommentInfoResponse$CommentInfoData$CommentModel;", "handleGoToCommentDetail$product_details_page_debug", "handleCommentTagId", "tagId", "handleCommentTagId$product_details_page_debug", "handleShopJump", "handleShopJump$product_details_page_debug", "handleCommentPublishGuideClick", "handleCommentPublishGuideClick$product_details_page_debug", "reportShopFloorShow", "reportShopFloorShow$product_details_page_debug", "reportShopItemClick", "reportShopItemClick$product_details_page_debug", "reportIpRecommendShow", "recommendItems", "Lkntr/app/mall/product/details/page/api/model/ShopItem;", "isInPreview", "reportIpRecommendShow$product_details_page_debug", "reportIpRecommendItemClick", "clickedItem", "reportIpRecommendItemClick$product_details_page_debug", "reportIpRecommendDetailMoreClick", "reportIpRecommendDetailMoreClick$product_details_page_debug", "reportFbCardShow", "reportFbCardShow$product_details_page_debug", "reportFbCardClick", "reportFbCardClick$product_details_page_debug", "reportCrowdfundingProgressItemShow", "Lkntr/app/mall/product/details/page/api/model/CrowdfundingProgressFloor$ProgressItem;", "reportCrowdfundingProgressItemShow$product_details_page_debug", "reportCrowdfundingProgressItemClick", "reportCrowdfundingProgressItemClick$product_details_page_debug", "reportRecFloorItemShow", "reportRecFloorItemShow$product_details_page_debug", "reportRecFloorItemClick", "reportRecFloorItemClick$product_details_page_debug", "reportRecFloorT3MoreClick", "reportRecFloorT3MoreClick$product_details_page_debug", "reportRecFloorT3MoreShow", "reportRecFloorT3MoreShow$product_details_page_debug", "handleLiveInfoJump", "liveInfo", "Lkntr/app/mall/product/details/page/api/LiveInfoApiService$LiveInfoData;", "handleLiveInfoJump$product_details_page_debug", "handleHeaderButtonClick", "model", "Lkntr/app/mall/product/details/page/api/model/ActionIconModel;", "handleHeaderButtonClick$product_details_page_debug", "handleFooterButtonClick", "handleFooterButtonClick$product_details_page_debug", "handleAddButton", "Lkntr/app/mall/product/details/page/api/model/FooterFloor$PurchaseButton;", "handleAddButton$product_details_page_debug", "handlePurchaseButton", "handlePurchaseButton$product_details_page_debug", "addSpecIdWithJumpUrl", "handleNewFileInfoSku", "handleNewFileInfoSku$product_details_page_debug", "getCoupon", "coupon", "Lkntr/app/mall/product/details/page/api/CouponListResponse$CouponListItem;", "getCoupon$product_details_page_debug", "(Lkntr/app/mall/product/details/page/api/CouponListResponse$CouponListItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadFeedBlast", "pageNum", "loadFeedBlast$product_details_page_debug", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addRemindSuspend", "calendarModel", "Lkntr/app/mall/product/details/page/api/model/CalendarRemindModel;", "successMsg", "failMsg", "addRemindSuspend$product_details_page_debug", "(Lkntr/app/mall/product/details/page/api/model/CalendarRemindModel;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleJumpUrl", "handleJumpUrl$product_details_page_debug", "handleHeaderSkuClick", "handleHeaderSkuClick$product_details_page_debug", "handleVideoDetail", "itemId", "courseId", "lessonId", "sectionId", "handleVideoDetail$product_details_page_debug", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "handleLabelObjectClick", "labelObject", "Lkntr/app/mall/product/details/page/api/model/LabelObject;", "handleLabelObjectClick$product_details_page_debug", "reportLoadFinished", "reportUpCouponSheetShow", "reportUpCouponSheetShow$product_details_page_debug", "showToast", "toast", "showToast$product_details_page_debug", "handleShare", "handleReserve", "mapResponseToContentModules", "response", "updateDeliveryContainer", "updateTopContainer", "updateBannerContainer", "ipFeedRecommendResponse", "updateFileInfoByProductDetailsResponse", "createTabItem", "title", "itemKey", "onClick", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/String;ILkotlin/jvm/functions/Function1;)Lkntr/app/mall/product/details/page/ui/container/TopTabItem;", "updateBottomContainer", "clearFeedBlast", "clearFeedBlast$product_details_page_debug", "addMoreFeedBlast", "addMoreFeedBlast$product_details_page_debug", "shouldShowIpFeedRecommend", "shouldShowIpFeedRecommend$product_details_page_debug", "ipFeedRecommendModel", "Lkntr/app/mall/product/details/page/api/IPFeedRecommendV2ApiService$RecommendData;", "ipItemsFeed", "ipItemsFeed$product_details_page_debug", "showTopTabCommentItem", "showTopTabCommentItem$product_details_page_debug", "showTopTabFeedBlastItem", "showTopTabFeedBlastItem$product_details_page_debug", "showTopTabDetailItem", "showTopTabDetailItem$product_details_page_debug", "generateModuleViewModels", "onCleared", "handleAutoFetchedCoupons", "getAutoFetchedUpCouponPopupDisplayTS", "upId", "getAutoFetchedUpCouponPopupDisplayTS$product_details_page_debug", "(Ljava/lang/Long;)Ljava/lang/String;", "markAutoFetchedUpCouponPopupDisplayed", "markAutoFetchedUpCouponPopupDisplayed$product_details_page_debug", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class PageViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow<PagerState> _bannerPagerState;
    private final MutableStateFlow<PagerState> _bannerPreviewPagerState;
    private final MutableStateFlow<CommentInfoApiService.CommentInfoResponse> _commentApiResponse;
    private final MutableStateFlow<CouponListResponse> _couponApiResponse;
    private final MutableStateFlow<String> _errorState;
    private final MutableStateFlow<FileInfoFloor.FileInfo> _fileInfo;
    private final MutableStateFlow<SkuInfoFloor.ItemsSkuListVO.ItemsSkuListItem> _fileInfoSelectedSku;
    private final MutableStateFlow<Integer> _headerSkuSelectedIndex;
    private final MutableStateFlow<IPFeedRecommendV2ApiService.Response> _ipFeedRecommendFlow;
    private final MutableStateFlow<Boolean> _isUserTriggeredWishAction;
    private Map<String, Integer> _listKeyToIndexMap;
    private final MutableStateFlow<LiveInfoApiService.LiveInfoResponse> _liveApiResponse;
    private final MutableStateFlow<Boolean> _loadingState;
    private final MutableStateFlow<ProductDetailsResponse> _productDetailsResponse;
    private final MutableStateFlow<ReserveApiService.ReserveResultResponse.ReserveResultData> _reserveCouponResult;
    private final MutableStateFlow<Boolean> _retainPopupVisibleFlow;
    private final MutableStateFlow<Integer> _selectedTabIndex;
    private final MutableStateFlow<ProductShopApiService.ProductShopDetailsResponse> _shopApiResponse;
    private final MutableStateFlow<Boolean> _showActivityCouponSheet;
    private final MutableStateFlow<Boolean> _showBenefitBottomSheet;
    private final MutableStateFlow<Boolean> _showCouponReserveResultDialog;
    private final MutableStateFlow<Boolean> _showHeaderFullScreenPreview;
    private final MutableStateFlow<Boolean> _showLikedCollectionLayer;
    private final MutableStateFlow<Boolean> _showSkuSwitch;
    private final MutableStateFlow<Integer> _topContainerHeightFlow;
    private final MutableStateFlow<String> _upSayVideoUrlState;
    private final MutableStateFlow<String> _videoUrlState;
    private final MutableStateFlow<WishInfo> _wishInfo;
    private final PageActionHandler actionHandler;
    private final Function0<OnBackPressedDispatcher> backPressedDispatcherProvider;
    private Integer bannerCommentOrUpSayIndex;
    private Integer bannerDetailPreviewIndex;
    private Integer bannerFirstItemCount;
    private Integer bannerImagesStartIndex;
    private Integer bannerIpFeedRecommendIndex;
    private final StateFlow<PagerState> bannerPagerState;
    private final StateFlow<PagerState> bannerPreviewPagerState;
    private Integer bannerSkuIndex;
    private String bannerSkuName;
    private Integer bannerVideoIndex;
    private final StateFlow<BottomContainerState> bottomContainerState;
    private final Function3<String, Map<String, ? extends Object>, Function1<? super Map<String, ? extends Object>, Unit>, Unit> bridgeCall;
    private final StateFlow<CommentInfoApiService.CommentInfoResponse> commentApiResponse;
    private final StateFlow<List<ContentModule>> contentModules;
    private final StateFlow<CouponListResponse> couponApiResponse;
    private final StateFlow<DeliveryInfoContainerState> deliveryInfoContainerState;
    private final String detailPreload;
    private final StateFlow<String> errorState;
    private final StateFlow<List<MallRecommendItem>> feedBlastState;
    private final StateFlow<FileInfoFloor.FileInfo> fileInfo;
    private final StateFlow<SkuInfoFloor.ItemsSkuListVO.ItemsSkuListItem> fileInfoSelectedSku;
    private final String from;
    private final String fromSpmid;
    private List<? extends TopTabItem> fullscreenTopTabItems;
    private final StateFlow<Integer> headerSkuSelectedIndex;
    private Job hideWishLayerJob;
    private final StateFlow<ImageBottomSheetState> imageBottomSheetStateFlow;
    private final StateFlow<ImagePreviewState> imagePreviewState;
    private final StateFlow<IPFeedRecommendV2ApiService.Response> ipFeedRecommendFlow;
    private boolean isProcessingShare;
    private final StateFlow<Boolean> isUserTriggeredWishAction;
    private final String is_ad;
    private final String itemsId;
    private final StateFlow<FeedsModel> lastFeedBlastData;
    private ProductShopApiService.ProductShopDetailsResponse lastShopResponse;
    private long lastWishClickTime;
    private final StateFlow<LiveInfoApiService.LiveInfoResponse> liveApiResponse;
    private final StateFlow<Boolean> loadingState;
    private final MutableStateFlow<BottomContainerState> mBottomContainerState;
    private final MutableStateFlow<List<ContentModule>> mContentModules;
    private final MutableStateFlow<DeliveryInfoContainerState> mDeliveryInfoContainerState;
    private final MutableStateFlow<List<MallRecommendItem>> mFeedBlastState;
    private final MutableStateFlow<ImageBottomSheetState> mImageBottomSheetStateFlow;
    private final MutableStateFlow<ImagePreviewState> mImagePreviewState;
    private final MutableStateFlow<FeedsModel> mLastFeedBlastData;
    private final MutableStateFlow<TopContainerState> mTopContainerState;
    private final MutableStateFlow<UiScaleModel> mUiScaleModelFlow;
    private final MutableStateFlow<ProductDetailsPageUpCouponDisplayModel> mUpCouponAutoFetchDisplayStateFlow;
    private Long merchantId;
    private final Map<FloorType, ModuleViewModel> moduleViewModels;
    private final String msource;
    private final String originUrl;
    private final StateFlow<ProductDetailsResponse> productDetailsResponse;
    private final ApiRepository repository;
    private final StateFlow<ReserveApiService.ReserveResultResponse.ReserveResultData> reserveCouponResult;
    private final StateFlow<Boolean> retainPopupVisibleFlow;
    private final Function0<Router> routerProvider;
    private final Function0<Pair<Dp, Dp>> screenSizeProvider;
    private final StateFlow<Integer> selectedTabIndex;
    private final StateFlow<ProductShopApiService.ProductShopDetailsResponse> shopApiResponse;
    private final StateFlow<Boolean> showActivityCouponSheet;
    private final StateFlow<Boolean> showBenefitBottomSheet;
    private final StateFlow<Boolean> showCouponReserveResultDialog;
    private final StateFlow<Boolean> showHeaderFullScreenPreview;
    private final StateFlow<Boolean> showLikedCollectionLayer;
    private final StateFlow<Boolean> showSkuSwitch;
    private final Lazy sp$delegate;
    private String statusBarHeight;
    private final StateFlow<Integer> topContainerHeightFlow;
    private final StateFlow<TopContainerState> topContainerState;
    private final String track_id;
    private final StateFlow<UiScaleModel> uiScaleModelFlow;
    private final StateFlow<ProductDetailsPageUpCouponDisplayModel> upCouponAutoFetchDisplayStateFlow;
    private final StateFlow<String> upSayVideoUrlState;
    private final Parameters urlParams;
    private final Function2<String, Map<String, ? extends Object>, String> valueBridge;
    private final StateFlow<String> videoUrlState;
    private final StateFlow<WishInfo> wishInfo;
    private final PageViewModelWrapper wrapper;

    /* compiled from: PageViewModel.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DeviceType.values().length];
            try {
                iArr[DeviceType.iOS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[DeviceType.Android.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[DeviceType.HarmonyOS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PageViewModel(ApiRepository repository, Function0<Router> function0, Function0<Pair<Dp, Dp>> function02, Function0<OnBackPressedDispatcher> function03, String itemsId, String msource, String track_id, String from, String is_ad, String detailPreload, String originUrl, Function2<? super String, ? super Map<String, ? extends Object>, String> function2, Function3<? super String, ? super Map<String, ? extends Object>, ? super Function1<? super Map<String, ? extends Object>, Unit>, Unit> function3) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        Intrinsics.checkNotNullParameter(function0, "routerProvider");
        Intrinsics.checkNotNullParameter(function02, "screenSizeProvider");
        Intrinsics.checkNotNullParameter(function03, "backPressedDispatcherProvider");
        Intrinsics.checkNotNullParameter(function2, "valueBridge");
        Intrinsics.checkNotNullParameter(function3, "bridgeCall");
        this.repository = repository;
        this.routerProvider = function0;
        this.screenSizeProvider = function02;
        this.backPressedDispatcherProvider = function03;
        this.itemsId = itemsId;
        this.msource = msource;
        this.track_id = track_id;
        this.from = from;
        this.is_ad = is_ad;
        this.detailPreload = detailPreload;
        this.originUrl = originUrl;
        this.valueBridge = function2;
        this.bridgeCall = function3;
        this.wrapper = new PageViewModelWrapper(this);
        String str = this.originUrl;
        this.urlParams = URLUtilsKt.Url(str == null ? "" : str).getParameters();
        this.fromSpmid = this.urlParams.get("fromSpmid");
        this.actionHandler = new PageActionHandler(this.routerProvider, this.itemsId, this.track_id, this.msource, this.from, this.is_ad, this.fromSpmid, null, 128, null);
        this.sp$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.mall.product.details.page.vm.PageViewModel$$ExternalSyntheticLambda3
            public final Object invoke() {
                SharedPreferences sp_delegate$lambda$0;
                sp_delegate$lambda$0 = PageViewModel.sp_delegate$lambda$0();
                return sp_delegate$lambda$0;
            }
        });
        this._listKeyToIndexMap = new LinkedHashMap();
        this._productDetailsResponse = StateFlowKt.MutableStateFlow((Object) null);
        this.productDetailsResponse = FlowKt.asStateFlow(this._productDetailsResponse);
        this._commentApiResponse = StateFlowKt.MutableStateFlow((Object) null);
        this.commentApiResponse = FlowKt.asStateFlow(this._commentApiResponse);
        this._couponApiResponse = StateFlowKt.MutableStateFlow((Object) null);
        this.couponApiResponse = FlowKt.asStateFlow(this._couponApiResponse);
        this._videoUrlState = StateFlowKt.MutableStateFlow((Object) null);
        this.videoUrlState = FlowKt.asStateFlow(this._videoUrlState);
        this._upSayVideoUrlState = StateFlowKt.MutableStateFlow((Object) null);
        this.upSayVideoUrlState = FlowKt.asStateFlow(this._upSayVideoUrlState);
        this._shopApiResponse = StateFlowKt.MutableStateFlow((Object) null);
        this.shopApiResponse = FlowKt.asStateFlow(this._shopApiResponse);
        this._liveApiResponse = StateFlowKt.MutableStateFlow((Object) null);
        this.liveApiResponse = FlowKt.asStateFlow(this._liveApiResponse);
        this._ipFeedRecommendFlow = StateFlowKt.MutableStateFlow((Object) null);
        this.ipFeedRecommendFlow = FlowKt.asStateFlow(this._ipFeedRecommendFlow);
        this._wishInfo = StateFlowKt.MutableStateFlow(new WishInfo(null, null, 3, null));
        this.wishInfo = FlowKt.asStateFlow(this._wishInfo);
        this._isUserTriggeredWishAction = StateFlowKt.MutableStateFlow(false);
        this.isUserTriggeredWishAction = FlowKt.asStateFlow(this._isUserTriggeredWishAction);
        this.mDeliveryInfoContainerState = StateFlowKt.MutableStateFlow((Object) null);
        this.deliveryInfoContainerState = FlowKt.asStateFlow(this.mDeliveryInfoContainerState);
        this.mTopContainerState = StateFlowKt.MutableStateFlow((Object) null);
        this.topContainerState = FlowKt.asStateFlow(this.mTopContainerState);
        this.mBottomContainerState = StateFlowKt.MutableStateFlow((Object) null);
        this.bottomContainerState = FlowKt.asStateFlow(this.mBottomContainerState);
        this.mContentModules = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this.contentModules = FlowKt.asStateFlow(this.mContentModules);
        this.moduleViewModels = new LinkedHashMap();
        this._loadingState = StateFlowKt.MutableStateFlow(false);
        this.loadingState = FlowKt.asStateFlow(this._loadingState);
        this._errorState = StateFlowKt.MutableStateFlow((Object) null);
        this.errorState = FlowKt.asStateFlow(this._errorState);
        this._selectedTabIndex = StateFlowKt.MutableStateFlow(0);
        this.selectedTabIndex = FlowKt.asStateFlow(this._selectedTabIndex);
        this.mImagePreviewState = StateFlowKt.MutableStateFlow((Object) null);
        this.imagePreviewState = FlowKt.asStateFlow(this.mImagePreviewState);
        this._showHeaderFullScreenPreview = StateFlowKt.MutableStateFlow(false);
        this.showHeaderFullScreenPreview = FlowKt.asStateFlow(this._showHeaderFullScreenPreview);
        this._headerSkuSelectedIndex = StateFlowKt.MutableStateFlow(0);
        this.headerSkuSelectedIndex = FlowKt.asStateFlow(this._headerSkuSelectedIndex);
        this._showActivityCouponSheet = StateFlowKt.MutableStateFlow(false);
        this.showActivityCouponSheet = FlowKt.asStateFlow(this._showActivityCouponSheet);
        this._showSkuSwitch = StateFlowKt.MutableStateFlow(false);
        this.showSkuSwitch = FlowKt.asStateFlow(this._showSkuSwitch);
        this._showBenefitBottomSheet = StateFlowKt.MutableStateFlow(false);
        this.showBenefitBottomSheet = FlowKt.asStateFlow(this._showBenefitBottomSheet);
        this._fileInfoSelectedSku = StateFlowKt.MutableStateFlow((Object) null);
        this.fileInfoSelectedSku = FlowKt.asStateFlow(this._fileInfoSelectedSku);
        this._fileInfo = StateFlowKt.MutableStateFlow((Object) null);
        this.fileInfo = FlowKt.asStateFlow(this._fileInfo);
        this.fullscreenTopTabItems = CollectionsKt.emptyList();
        this._bannerPagerState = StateFlowKt.MutableStateFlow((Object) null);
        this.bannerPagerState = FlowKt.asStateFlow(this._bannerPagerState);
        this._bannerPreviewPagerState = StateFlowKt.MutableStateFlow((Object) null);
        this.bannerPreviewPagerState = FlowKt.asStateFlow(this._bannerPreviewPagerState);
        this.statusBarHeight = (String) this.valueBridge.invoke("statusBarHeight", MapsKt.emptyMap());
        this._showCouponReserveResultDialog = StateFlowKt.MutableStateFlow(false);
        this.showCouponReserveResultDialog = FlowKt.asStateFlow(this._showCouponReserveResultDialog);
        this._showLikedCollectionLayer = StateFlowKt.MutableStateFlow(false);
        this.showLikedCollectionLayer = FlowKt.asStateFlow(this._showLikedCollectionLayer);
        this._reserveCouponResult = StateFlowKt.MutableStateFlow((Object) null);
        this.reserveCouponResult = FlowKt.asStateFlow(this._reserveCouponResult);
        this.mFeedBlastState = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this.mLastFeedBlastData = StateFlowKt.MutableStateFlow((Object) null);
        this.feedBlastState = FlowKt.asStateFlow(this.mFeedBlastState);
        this.lastFeedBlastData = FlowKt.asStateFlow(this.mLastFeedBlastData);
        this._topContainerHeightFlow = StateFlowKt.MutableStateFlow(0);
        this.topContainerHeightFlow = FlowKt.asStateFlow(this._topContainerHeightFlow);
        this._retainPopupVisibleFlow = StateFlowKt.MutableStateFlow(false);
        this.retainPopupVisibleFlow = FlowKt.asStateFlow(this._retainPopupVisibleFlow);
        this.mImageBottomSheetStateFlow = StateFlowKt.MutableStateFlow((Object) null);
        this.imageBottomSheetStateFlow = FlowKt.asStateFlow(this.mImageBottomSheetStateFlow);
        this.mUiScaleModelFlow = StateFlowKt.MutableStateFlow(new UiScaleModel(1.0f));
        this.uiScaleModelFlow = FlowKt.asStateFlow(this.mUiScaleModelFlow);
        this.mUpCouponAutoFetchDisplayStateFlow = StateFlowKt.MutableStateFlow((Object) null);
        this.upCouponAutoFetchDisplayStateFlow = FlowKt.asStateFlow(this.mUpCouponAutoFetchDisplayStateFlow);
        boolean shouldScaleUi = KConfig.INSTANCE.ff("dd_mall_product_detail_use_scale", true);
        if (shouldScaleUi) {
            updateUiScale$product_details_page_debug();
        }
        firstLoadProduct();
        observeAccountState();
    }

    public /* synthetic */ PageViewModel(ApiRepository apiRepository, Function0 function0, Function0 function02, Function0 function03, String str, String str2, String str3, String str4, String str5, String str6, String str7, Function2 function2, Function3 function3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(apiRepository, function0, function02, function03, (i & 16) != 0 ? null : str, (i & 32) != 0 ? null : str2, (i & 64) != 0 ? null : str3, (i & 128) != 0 ? null : str4, (i & 256) != 0 ? null : str5, (i & 512) != 0 ? null : str6, (i & 1024) != 0 ? null : str7, function2, function3);
    }

    public final String getItemsId$product_details_page_debug() {
        return this.itemsId;
    }

    public final String getMsource$product_details_page_debug() {
        return this.msource;
    }

    public final String getTrack_id$product_details_page_debug() {
        return this.track_id;
    }

    public final String getFrom$product_details_page_debug() {
        return this.from;
    }

    public final String is_ad$product_details_page_debug() {
        return this.is_ad;
    }

    public final PageViewModelWrapper getWrapper$product_details_page_debug() {
        return this.wrapper;
    }

    public final PageActionHandler getActionHandler$product_details_page_debug() {
        return this.actionHandler;
    }

    public final Boolean isFromTMFeed() {
        ProductDetailsResponse.ProductDetailsData data;
        ProductDetailsResponse productDetailsResponse = (ProductDetailsResponse) this._productDetailsResponse.getValue();
        if (productDetailsResponse == null || (data = productDetailsResponse.getData()) == null) {
            return null;
        }
        return data.getFromTm();
    }

    public final boolean getUseUpSay() {
        BasicInfoFloor.NewUpSayModel newUpSayModel;
        Integer type;
        ProductDetailsResponse.ProductDetailsData data;
        BasicInfoFloor basicInfoFloorVO;
        ProductDetailsResponse productDetailsResponse = (ProductDetailsResponse) this._productDetailsResponse.getValue();
        if (productDetailsResponse == null || (data = productDetailsResponse.getData()) == null || (basicInfoFloorVO = data.getBasicInfoFloorVO()) == null) {
            newUpSayModel = null;
        } else {
            newUpSayModel = basicInfoFloorVO.getNewUpSayVO();
        }
        return (newUpSayModel == null || (type = newUpSayModel.getType()) == null || type.intValue() != 2) ? false : true;
    }

    public final SharedPreferences getSp() {
        return (SharedPreferences) this.sp$delegate.getValue();
    }

    public static final SharedPreferences sp_delegate$lambda$0() {
        return new SharedPreferences("kntr_mall_product_details_page_sp", false, 2, null);
    }

    public final Map<String, Integer> getListKeyToIndexMap() {
        return this._listKeyToIndexMap;
    }

    public final StateFlow<ProductDetailsResponse> getProductDetailsResponse() {
        return this.productDetailsResponse;
    }

    public final StateFlow<CommentInfoApiService.CommentInfoResponse> getCommentApiResponse() {
        return this.commentApiResponse;
    }

    public final StateFlow<CouponListResponse> getCouponApiResponse() {
        return this.couponApiResponse;
    }

    public final StateFlow<String> getVideoUrlState() {
        return this.videoUrlState;
    }

    public final StateFlow<String> getUpSayVideoUrlState() {
        return this.upSayVideoUrlState;
    }

    public final StateFlow<ProductShopApiService.ProductShopDetailsResponse> getShopApiResponse() {
        return this.shopApiResponse;
    }

    public final StateFlow<LiveInfoApiService.LiveInfoResponse> getLiveApiResponse() {
        return this.liveApiResponse;
    }

    public final StateFlow<IPFeedRecommendV2ApiService.Response> getIpFeedRecommendFlow() {
        return this.ipFeedRecommendFlow;
    }

    public final StateFlow<WishInfo> getWishInfo() {
        return this.wishInfo;
    }

    public final StateFlow<Boolean> isUserTriggeredWishAction() {
        return this.isUserTriggeredWishAction;
    }

    public final StateFlow<DeliveryInfoContainerState> getDeliveryInfoContainerState$product_details_page_debug() {
        return this.deliveryInfoContainerState;
    }

    public final StateFlow<TopContainerState> getTopContainerState$product_details_page_debug() {
        return this.topContainerState;
    }

    public final StateFlow<BottomContainerState> getBottomContainerState$product_details_page_debug() {
        return this.bottomContainerState;
    }

    public final StateFlow<List<ContentModule>> getContentModules$product_details_page_debug() {
        return this.contentModules;
    }

    public final StateFlow<Boolean> getLoadingState() {
        return this.loadingState;
    }

    public final StateFlow<String> getErrorState() {
        return this.errorState;
    }

    public final StateFlow<Integer> getSelectedTabIndex() {
        return this.selectedTabIndex;
    }

    public final StateFlow<ImagePreviewState> getImagePreviewState$product_details_page_debug() {
        return this.imagePreviewState;
    }

    public final StateFlow<Boolean> getShowHeaderFullScreenPreview() {
        return this.showHeaderFullScreenPreview;
    }

    public final StateFlow<Integer> getHeaderSkuSelectedIndex() {
        return this.headerSkuSelectedIndex;
    }

    public final StateFlow<Boolean> getShowActivityCouponSheet() {
        return this.showActivityCouponSheet;
    }

    public final StateFlow<Boolean> getShowSkuSwitch() {
        return this.showSkuSwitch;
    }

    public final StateFlow<Boolean> getShowBenefitBottomSheet() {
        return this.showBenefitBottomSheet;
    }

    public final StateFlow<SkuInfoFloor.ItemsSkuListVO.ItemsSkuListItem> getFileInfoSelectedSku() {
        return this.fileInfoSelectedSku;
    }

    public final StateFlow<FileInfoFloor.FileInfo> getFileInfo() {
        return this.fileInfo;
    }

    public final List<TopTabItem> getFullscreenTopTabItems$product_details_page_debug() {
        return this.fullscreenTopTabItems;
    }

    public final void setFullscreenTopTabItems$product_details_page_debug(List<? extends TopTabItem> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.fullscreenTopTabItems = list;
    }

    public final StateFlow<PagerState> getBannerPagerState() {
        return this.bannerPagerState;
    }

    public final StateFlow<PagerState> getBannerPreviewPagerState() {
        return this.bannerPreviewPagerState;
    }

    public final Integer getBannerVideoIndex() {
        return this.bannerVideoIndex;
    }

    public final void setBannerVideoIndex(Integer num) {
        this.bannerVideoIndex = num;
    }

    public final Integer getBannerFirstItemCount() {
        return this.bannerFirstItemCount;
    }

    public final void setBannerFirstItemCount(Integer num) {
        this.bannerFirstItemCount = num;
    }

    public final Integer getBannerImagesStartIndex() {
        return this.bannerImagesStartIndex;
    }

    public final void setBannerImagesStartIndex(Integer num) {
        this.bannerImagesStartIndex = num;
    }

    public final Integer getBannerSkuIndex() {
        return this.bannerSkuIndex;
    }

    public final void setBannerSkuIndex(Integer num) {
        this.bannerSkuIndex = num;
    }

    public final String getBannerSkuName() {
        return this.bannerSkuName;
    }

    public final void setBannerSkuName(String str) {
        this.bannerSkuName = str;
    }

    public final Integer getBannerCommentOrUpSayIndex() {
        return this.bannerCommentOrUpSayIndex;
    }

    public final void setBannerCommentOrUpSayIndex(Integer num) {
        this.bannerCommentOrUpSayIndex = num;
    }

    public final Integer getBannerIpFeedRecommendIndex() {
        return this.bannerIpFeedRecommendIndex;
    }

    public final void setBannerIpFeedRecommendIndex(Integer num) {
        this.bannerIpFeedRecommendIndex = num;
    }

    public final Integer getBannerDetailPreviewIndex() {
        return this.bannerDetailPreviewIndex;
    }

    public final void setBannerDetailPreviewIndex(Integer num) {
        this.bannerDetailPreviewIndex = num;
    }

    public final String getStatusBarHeight() {
        return this.statusBarHeight;
    }

    public final void setStatusBarHeight(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.statusBarHeight = str;
    }

    public final Long getMerchantId() {
        return this.merchantId;
    }

    public final void setMerchantId(Long l) {
        this.merchantId = l;
    }

    public final StateFlow<Boolean> getShowCouponReserveResultDialog() {
        return this.showCouponReserveResultDialog;
    }

    public final StateFlow<Boolean> getShowLikedCollectionLayer() {
        return this.showLikedCollectionLayer;
    }

    public final StateFlow<ReserveApiService.ReserveResultResponse.ReserveResultData> getReserveCouponResult() {
        return this.reserveCouponResult;
    }

    public final StateFlow<List<MallRecommendItem>> getFeedBlastState$product_details_page_debug() {
        return this.feedBlastState;
    }

    public final StateFlow<FeedsModel> getLastFeedBlastData$product_details_page_debug() {
        return this.lastFeedBlastData;
    }

    public final StateFlow<Integer> getTopContainerHeightFlow() {
        return this.topContainerHeightFlow;
    }

    public final StateFlow<Boolean> getRetainPopupVisibleFlow() {
        return this.retainPopupVisibleFlow;
    }

    public final StateFlow<ImageBottomSheetState> getImageBottomSheetStateFlow$product_details_page_debug() {
        return this.imageBottomSheetStateFlow;
    }

    public final StateFlow<UiScaleModel> getUiScaleModelFlow$product_details_page_debug() {
        return this.uiScaleModelFlow;
    }

    public final StateFlow<ProductDetailsPageUpCouponDisplayModel> getUpCouponAutoFetchDisplayStateFlow$product_details_page_debug() {
        return this.upCouponAutoFetchDisplayStateFlow;
    }

    public final void hideAutoFetchedUpCoupon$product_details_page_debug() {
        Object prevValue$iv;
        MutableStateFlow $this$update$iv = this.mUpCouponAutoFetchDisplayStateFlow;
        do {
            prevValue$iv = $this$update$iv.getValue();
            ProductDetailsPageUpCouponDisplayModel productDetailsPageUpCouponDisplayModel = (ProductDetailsPageUpCouponDisplayModel) prevValue$iv;
        } while (!$this$update$iv.compareAndSet(prevValue$iv, (Object) null));
    }

    public final void updateRetainPopupVisible$product_details_page_debug(boolean visible) {
        Object prevValue$iv;
        Object nextValue$iv;
        MutableStateFlow $this$update$iv = this._retainPopupVisibleFlow;
        do {
            prevValue$iv = $this$update$iv.getValue();
            ((Boolean) prevValue$iv).booleanValue();
            nextValue$iv = Boolean.valueOf(visible);
        } while (!$this$update$iv.compareAndSet(prevValue$iv, nextValue$iv));
    }

    public final void updateTopContainerHeight$product_details_page_debug(int height) {
        Object prevValue$iv;
        Object nextValue$iv;
        MutableStateFlow $this$update$iv = this._topContainerHeightFlow;
        do {
            prevValue$iv = $this$update$iv.getValue();
            ((Number) prevValue$iv).intValue();
            nextValue$iv = Integer.valueOf(height);
        } while (!$this$update$iv.compareAndSet(prevValue$iv, nextValue$iv));
    }

    public final void updateCouponReserveResultDialogState$product_details_page_debug(boolean show) {
        Object prevValue$iv;
        Object nextValue$iv;
        MutableStateFlow $this$update$iv = this._showCouponReserveResultDialog;
        do {
            prevValue$iv = $this$update$iv.getValue();
            ((Boolean) prevValue$iv).booleanValue();
            nextValue$iv = Boolean.valueOf(show);
        } while (!$this$update$iv.compareAndSet(prevValue$iv, nextValue$iv));
    }

    public final void updateSkuSwitchState$product_details_page_debug(boolean show) {
        Object prevValue$iv;
        Object nextValue$iv;
        MutableStateFlow $this$update$iv = this._showSkuSwitch;
        do {
            prevValue$iv = $this$update$iv.getValue();
            ((Boolean) prevValue$iv).booleanValue();
            nextValue$iv = Boolean.valueOf(show);
        } while (!$this$update$iv.compareAndSet(prevValue$iv, nextValue$iv));
    }

    public final void updateFileInfoSelectedSku$product_details_page_debug(SkuInfoFloor.ItemsSkuListVO.ItemsSkuListItem sku) {
        Object prevValue$iv;
        MutableStateFlow $this$update$iv = this._fileInfoSelectedSku;
        do {
            prevValue$iv = $this$update$iv.getValue();
            SkuInfoFloor.ItemsSkuListVO.ItemsSkuListItem itemsSkuListItem = (SkuInfoFloor.ItemsSkuListVO.ItemsSkuListItem) prevValue$iv;
        } while (!$this$update$iv.compareAndSet(prevValue$iv, sku));
    }

    public final void updateActivityCouponSheetState$product_details_page_debug(boolean show) {
        Object prevValue$iv;
        Object nextValue$iv;
        MutableStateFlow $this$update$iv = this._showActivityCouponSheet;
        do {
            prevValue$iv = $this$update$iv.getValue();
            ((Boolean) prevValue$iv).booleanValue();
            nextValue$iv = Boolean.valueOf(show);
        } while (!$this$update$iv.compareAndSet(prevValue$iv, nextValue$iv));
    }

    public final void updateHeaderSkuSelectedIndex$product_details_page_debug(int index) {
        Object prevValue$iv;
        Object nextValue$iv;
        MutableStateFlow $this$update$iv = this._headerSkuSelectedIndex;
        do {
            prevValue$iv = $this$update$iv.getValue();
            ((Number) prevValue$iv).intValue();
            nextValue$iv = Integer.valueOf(index);
        } while (!$this$update$iv.compareAndSet(prevValue$iv, nextValue$iv));
    }

    public final void toggleHeaderFullScreenPreview$product_details_page_debug(boolean show) {
        this._showHeaderFullScreenPreview.setValue(Boolean.valueOf(show));
    }

    public final void toggleBenefitBottomSheet$product_details_page_debug(boolean show) {
        this._showBenefitBottomSheet.setValue(Boolean.valueOf(show));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateImagePreview$product_details_page_debug$default(PageViewModel pageViewModel, List list, int i, List list2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            list2 = CollectionsKt.emptyList();
        }
        pageViewModel.updateImagePreview$product_details_page_debug(list, i, list2);
    }

    public final void updateImagePreview$product_details_page_debug(List<String> list, int index, List<Pair<Float, Float>> list2) {
        Object prevValue$iv;
        Object nextValue$iv;
        Object prevValue$iv2;
        Intrinsics.checkNotNullParameter(list2, "imageSizes");
        PageActionHandler.trackEvent$product_details_page_debug$default(this.actionHandler, TrackConsts.MALL_MALL_DETAIL_COMMENTPIC_0_CLICK, null, false, false, 14, null);
        List<String> list3 = list;
        if (list3 == null || list3.isEmpty()) {
            MutableStateFlow $this$update$iv = this.mImagePreviewState;
            do {
                prevValue$iv2 = $this$update$iv.getValue();
                ImagePreviewState imagePreviewState = (ImagePreviewState) prevValue$iv2;
            } while (!$this$update$iv.compareAndSet(prevValue$iv2, (Object) null));
            return;
        }
        MutableStateFlow $this$update$iv2 = this.mImagePreviewState;
        do {
            prevValue$iv = $this$update$iv2.getValue();
            ImagePreviewState imagePreviewState2 = (ImagePreviewState) prevValue$iv;
            nextValue$iv = new ImagePreviewState(list, index, list2);
        } while (!$this$update$iv2.compareAndSet(prevValue$iv, nextValue$iv));
    }

    public static /* synthetic */ void showImageBottomSheet$product_details_page_debug$default(PageViewModel pageViewModel, String str, Double d, Double d2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            d = null;
        }
        if ((i & 4) != 0) {
            d2 = null;
        }
        pageViewModel.showImageBottomSheet$product_details_page_debug(str, d, d2);
    }

    public final void showImageBottomSheet$product_details_page_debug(String imageUrl, Double imageWidth, Double imageHeight) {
        Object prevValue$iv;
        Object nextValue$iv;
        String str = imageUrl;
        if (!(str == null || str.length() == 0)) {
            if (imageWidth != null && imageWidth.doubleValue() > 0.0d) {
                if (imageHeight != null && imageHeight.doubleValue() > 0.0d) {
                    MutableStateFlow $this$update$iv = this.mImageBottomSheetStateFlow;
                    do {
                        prevValue$iv = $this$update$iv.getValue();
                        ImageBottomSheetState imageBottomSheetState = (ImageBottomSheetState) prevValue$iv;
                        nextValue$iv = new ImageBottomSheetState(true, imageUrl, imageWidth.doubleValue(), imageHeight.doubleValue());
                    } while (!$this$update$iv.compareAndSet(prevValue$iv, nextValue$iv));
                }
            }
        }
    }

    public final void hideImageBottomSheet$product_details_page_debug() {
        Object prevValue$iv;
        Object nextValue$iv;
        MutableStateFlow $this$update$iv = this.mImageBottomSheetStateFlow;
        do {
            prevValue$iv = $this$update$iv.getValue();
            ImageBottomSheetState prev = (ImageBottomSheetState) prevValue$iv;
            nextValue$iv = prev != null ? ImageBottomSheetState.copy$default(prev, false, null, 0.0d, 0.0d, 14, null) : null;
        } while (!$this$update$iv.compareAndSet(prevValue$iv, nextValue$iv));
    }

    public final String getVideoUrl$product_details_page_debug() {
        String videoUrl;
        ProductDetailsResponse.ProductDetailsData data;
        BasicInfoFloor basicInfoFloorVO;
        ProductDetailsResponse productDetailsResponse = (ProductDetailsResponse) this._productDetailsResponse.getValue();
        if (productDetailsResponse == null || (data = productDetailsResponse.getData()) == null || (basicInfoFloorVO = data.getBasicInfoFloorVO()) == null) {
            videoUrl = null;
        } else {
            videoUrl = basicInfoFloorVO.getVideoUrl$product_details_page_debug();
        }
        String str = videoUrl;
        if (str == null || str.length() == 0) {
            return null;
        }
        return videoUrl;
    }

    public final float getGlobalScale$product_details_page_debug() {
        float screenWidthDp = ((Dp) ((Pair) this.screenSizeProvider.invoke()).component1()).unbox-impl();
        float scale = screenWidthDp / 375.0f;
        return scale;
    }

    public final void updateSelectedTab$product_details_page_debug(int index) {
        if (index != ((Number) this._selectedTabIndex.getValue()).intValue()) {
            this._selectedTabIndex.setValue(Integer.valueOf(index));
        }
    }

    public final void updateUiScale$product_details_page_debug() {
        Object prevValue$iv;
        Object nextValue$iv;
        float screenWidthDp = ((Dp) ((Pair) this.screenSizeProvider.invoke()).component1()).unbox-impl();
        float scale = screenWidthDp / ((float) ConstsKt.DEFAULT_UI_SCREEN_WIDTH);
        MutableStateFlow $this$update$iv = this.mUiScaleModelFlow;
        do {
            prevValue$iv = $this$update$iv.getValue();
            UiScaleModel uiScaleModel = (UiScaleModel) prevValue$iv;
            nextValue$iv = new UiScaleModel(scale);
        } while (!$this$update$iv.compareAndSet(prevValue$iv, nextValue$iv));
    }

    public final void rebuildKeyToIndexMap$product_details_page_debug(List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(list, "groupedContent");
        this._listKeyToIndexMap.clear();
        this._listKeyToIndexMap.putAll(ContentModuleKt.buildKeyToIndexMap$default(list, false, 2, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int getHeaderPageCount$product_details_page_debug() {
        boolean showUpSayOrComment;
        List<String> imageList;
        ProductDetailsResponse response = (ProductDetailsResponse) this._productDetailsResponse.getValue();
        ProductDetailsResponse.ProductDetailsData data = response != null ? response.getData() : null;
        BasicInfoFloor basicInfoFloor = data != null ? data.getBasicInfoFloorVO() : null;
        boolean hasVideo = basicInfoFloor != null ? basicInfoFloor.hasVideo$product_details_page_debug() : false;
        IPFeedRecommendV2ApiService.Response response2 = (IPFeedRecommendV2ApiService.Response) this._ipFeedRecommendFlow.getValue();
        IPFeedRecommendV2ApiService.RecommendData ipRecommendModel = response2 != null ? response2.getData() : null;
        boolean shouldShowIpFeedRecommend$product_details_page_debug = shouldShowIpFeedRecommend$product_details_page_debug(ipRecommendModel);
        SkuInfoFloor skuInfoFloor = data != null ? data.getSkuInfoFloorVO() : null;
        boolean hasSku = skuInfoFloor != null && skuInfoFloor.shouldShowHeaderSku$product_details_page_debug();
        CommentInfoApiService.CommentInfoResponse commentInfoResponse = (CommentInfoApiService.CommentInfoResponse) this._commentApiResponse.getValue();
        CommentInfoApiService.CommentInfoResponse.CommentInfoData commentFloor = commentInfoResponse != null ? commentInfoResponse.getData() : null;
        if (!getUseUpSay()) {
            if (((commentFloor == null || !commentFloor.shouldShowHeaderComment$product_details_page_debug()) ? null : 1) == null) {
                showUpSayOrComment = false;
                int imageCount = (basicInfoFloor != null || (imageList = basicInfoFloor.getImageList()) == null) ? 0 : imageList.size();
                int pageCount = (!hasVideo ? 1 : 0) + imageCount + (!hasSku ? 1 : 0) + (showUpSayOrComment ? 1 : 0) + (shouldShowIpFeedRecommend$product_details_page_debug ? 1 : 0);
                return pageCount;
            }
        }
        showUpSayOrComment = true;
        if (basicInfoFloor != null) {
        }
        int pageCount2 = (!hasVideo ? 1 : 0) + imageCount + (!hasSku ? 1 : 0) + (showUpSayOrComment ? 1 : 0) + (shouldShowIpFeedRecommend$product_details_page_debug ? 1 : 0);
        return pageCount2;
    }

    public final String getCurrentSkuName$product_details_page_debug(int skuIndex) {
        List specInfoList;
        List<SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem.SpecValueListItem> specValueVOList;
        SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem.SpecValueListItem specValueListItem;
        ProductDetailsResponse.ProductDetailsData data;
        SkuInfoFloor skuInfoFloorVO;
        SkuInfoFloor.ItemsSkuListVO itemsSkuListVO;
        ProductDetailsResponse productDetailsResponse = (ProductDetailsResponse) this._productDetailsResponse.getValue();
        if (productDetailsResponse == null || (data = productDetailsResponse.getData()) == null || (skuInfoFloorVO = data.getSkuInfoFloorVO()) == null || (itemsSkuListVO = skuInfoFloorVO.getItemsSkuListVO()) == null) {
            specInfoList = null;
        } else {
            specInfoList = itemsSkuListVO.getSpecInfoList();
        }
        SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem specInfo = specInfoList != null ? (SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem) CollectionsKt.firstOrNull(specInfoList) : null;
        if (specInfo == null || (specValueVOList = specInfo.getSpecValueVOList()) == null || (specValueListItem = specValueVOList.get(skuIndex)) == null) {
            return null;
        }
        return specValueListItem.getSpecValueName();
    }

    public final void scrollToTab$product_details_page_debug(int tabIndex, CoroutineScope coroutineScope, LazyStaggeredGridState listState) {
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(listState, "listState");
        BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new PageViewModel$scrollToTab$1(tabIndex, this, listState, null), 3, (Object) null);
    }

    private final void observeAccountState() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new PageViewModel$observeAccountState$1(this, null), 3, (Object) null);
    }

    public final void onLogout() {
    }

    public final void onLoggedOrUpdated(UserInfo userInfo) {
        reloadProductDetails$product_details_page_debug();
    }

    private final void firstLoadProduct() {
        loadProductDetails(true);
    }

    public final void reloadProductDetails$product_details_page_debug() {
        loadProductDetails(false);
    }

    static /* synthetic */ void loadProductDetails$default(PageViewModel pageViewModel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        pageViewModel.loadProductDetails(z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x002c, code lost:
        if ((r2.length() > 0) == true) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void loadProductDetails(boolean isFirst) {
        Object prevValue$iv;
        if (((Boolean) this._loadingState.getValue()).booleanValue()) {
            return;
        }
        boolean z = true;
        this._loadingState.setValue(true);
        if (isFirst) {
            String str = this.detailPreload;
            if (str != null) {
            }
            z = false;
            if (z) {
                Json this_$iv = Client.INSTANCE.getJson();
                String string$iv = this.detailPreload;
                this_$iv.getSerializersModule();
                ProductDetailsResponse preloadedResponse = (ProductDetailsResponse) this_$iv.decodeFromString(ProductDetailsResponse.Companion.serializer(), string$iv);
                Integer code = preloadedResponse.getCode();
                if (code != null && code.intValue() == 0) {
                    KLog_androidKt.getKLog().i("PageViewModel", "使用预加载数据");
                    MutableStateFlow $this$update$iv = this._productDetailsResponse;
                    do {
                        prevValue$iv = $this$update$iv.getValue();
                        ProductDetailsResponse productDetailsResponse = (ProductDetailsResponse) prevValue$iv;
                    } while (!$this$update$iv.compareAndSet(prevValue$iv, preloadedResponse));
                    fetchDataSuccess(preloadedResponse, null, this.lastShopResponse);
                } else {
                    KLog_androidKt.getKLog().e("PageViewModel", "预加载数据错误: " + preloadedResponse.getMessage());
                }
            }
        }
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new PageViewModel$loadProductDetails$2(this, isFirst, null), 3, (Object) null);
    }

    public final void fetchDataSuccess(ProductDetailsResponse productDetailsResponse, CommentInfoApiService.CommentInfoResponse commentResponse, ProductShopApiService.ProductShopDetailsResponse shopResponse) {
        ActionIconModel actionIconModel;
        Object prevValue$iv;
        Object prevValue$iv2;
        Object prevValue$iv3;
        String message;
        String it;
        FooterFloor footerFloorVO;
        List<ActionIconModel> footer;
        Object obj;
        boolean z;
        this._isUserTriggeredWishAction.setValue(false);
        MutableStateFlow $this$update$iv = this._wishInfo;
        while (true) {
            Object prevValue$iv4 = $this$update$iv.getValue();
            WishInfo wishInfo = (WishInfo) prevValue$iv4;
            ProductDetailsResponse.ProductDetailsData data = productDetailsResponse.getData();
            if (data == null || (footerFloorVO = data.getFooterFloorVO()) == null || (footer = footerFloorVO.getFooter()) == null) {
                actionIconModel = null;
            } else {
                Iterator<T> it2 = footer.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it2.next();
                    ActionIconModel it3 = (ActionIconModel) obj;
                    Integer type = it3.getType();
                    if (type != null && type.intValue() == 6) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (z) {
                        break;
                    }
                }
                actionIconModel = (ActionIconModel) obj;
            }
            ActionIconModel likeModel = actionIconModel;
            Object nextValue$iv = new WishInfo(likeModel != null ? likeModel.getActive() : null, likeModel != null ? likeModel.getCount() : null);
            if ($this$update$iv.compareAndSet(prevValue$iv4, nextValue$iv)) {
                break;
            }
        }
        updateFileInfoByProductDetailsResponse();
        updateDeliveryContainer(productDetailsResponse);
        updateBannerContainer$default(this, productDetailsResponse, null, 2, null);
        updateTopContainer(productDetailsResponse);
        updateBottomContainer(productDetailsResponse);
        List newContentModules = mapResponseToContentModules(productDetailsResponse, commentResponse, shopResponse);
        MutableStateFlow $this$update$iv2 = this.mContentModules;
        do {
            prevValue$iv = $this$update$iv2.getValue();
            List list = (List) prevValue$iv;
        } while (!$this$update$iv2.compareAndSet(prevValue$iv, newContentModules));
        this.moduleViewModels.clear();
        Map newModuleViewModels = generateModuleViewModels(newContentModules);
        this.moduleViewModels.putAll(newModuleViewModels);
        MutableStateFlow $this$update$iv3 = this._loadingState;
        do {
            prevValue$iv2 = $this$update$iv3.getValue();
            ((Boolean) prevValue$iv2).booleanValue();
        } while (!$this$update$iv3.compareAndSet(prevValue$iv2, false));
        MutableStateFlow $this$update$iv4 = this._errorState;
        do {
            prevValue$iv3 = $this$update$iv4.getValue();
            String str = (String) prevValue$iv3;
            Integer code = productDetailsResponse.getCode();
            if (code == null || code.intValue() != 0) {
                message = productDetailsResponse.getMessage();
            } else {
                message = null;
            }
            it = message;
        } while (!$this$update$iv4.compareAndSet(prevValue$iv3, it));
    }

    public final void fetchDataSuccessAfter() {
        String ipRightId;
        ProductDetailsResponse.ProductDetailsData data;
        IpBrandFloor ipBrandFloorVO;
        List<IpBrandFloor.IpRightInfo> ipRightList;
        IpBrandFloor.IpRightInfo ipRightInfo;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new PageViewModel$fetchDataSuccessAfter$1(this, null), 3, (Object) null);
        ProductDetailsResponse productDetailsResponse = (ProductDetailsResponse) this._productDetailsResponse.getValue();
        if (productDetailsResponse == null || (data = productDetailsResponse.getData()) == null || (ipBrandFloorVO = data.getIpBrandFloorVO()) == null || (ipRightList = ipBrandFloorVO.getIpRightList()) == null || (ipRightInfo = (IpBrandFloor.IpRightInfo) CollectionsKt.firstOrNull(ipRightList)) == null) {
            ipRightId = null;
        } else {
            ipRightId = ipRightInfo.getIpRightId();
        }
        if (ipRightId != null) {
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new PageViewModel$fetchDataSuccessAfter$2$1(ipRightId, this, null), 3, (Object) null);
        }
        handleAutoFetchedCoupons();
    }

    public final ModuleViewModel getModuleViewModel$product_details_page_debug(FloorType floorType) {
        Intrinsics.checkNotNullParameter(floorType, "floorType");
        return this.moduleViewModels.get(floorType);
    }

    public final List<Object> groupModules$product_details_page_debug(List<? extends ContentModule> list) {
        Intrinsics.checkNotNullParameter(list, "modules");
        Set firstGroupTypes = SetsKt.setOf(new String[]{FloorType.CROWDFUNDING_ATMOSPHERE.getKey(), FloorType.MERGE_ATMOSPHERE_PRICE.getKey(), FloorType.BASIC_INFO.getKey(), FloorType.COUPON_INFO.getKey()});
        Set secondGroupTypes = SetsKt.setOf(new String[]{FloorType.ADV_STATE.getKey(), FloorType.DELIVERY_INFO.getKey(), FloorType.SERVICE.getKey(), FloorType.ATTR.getKey(), FloorType.SKU_INFO.getKey(), FloorType.IP_BRAND.getKey()});
        List firstGroup = new ArrayList();
        List secondGroup = new ArrayList();
        List<Pair> otherModulesWithIndex = new ArrayList();
        List<? extends ContentModule> $this$forEachIndexed$iv = list;
        int index = 0;
        for (Object item$iv : $this$forEachIndexed$iv) {
            int index$iv = index + 1;
            if (index < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ContentModule module = (ContentModule) item$iv;
            String key = module.getFloorType().getKey();
            if (firstGroupTypes.contains(key)) {
                firstGroup.add(module);
            } else if (secondGroupTypes.contains(key)) {
                secondGroup.add(module);
            } else {
                otherModulesWithIndex.add(TuplesKt.to(Integer.valueOf(index), module));
            }
            index = index$iv;
        }
        int index$iv2 = 0;
        Iterator<? extends ContentModule> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                Object item$iv2 = it.next();
                ContentModule it2 = (ContentModule) item$iv2;
                if (firstGroupTypes.contains(it2.getFloorType().getKey())) {
                    break;
                }
                index$iv2++;
            } else {
                index$iv2 = -1;
                break;
            }
        }
        int firstGroupFirstIndex = index$iv2;
        int index$iv3 = 0;
        Iterator<? extends ContentModule> it3 = list.iterator();
        while (true) {
            if (it3.hasNext()) {
                Object item$iv3 = it3.next();
                ContentModule it4 = (ContentModule) item$iv3;
                if (secondGroupTypes.contains(it4.getFloorType().getKey())) {
                    break;
                }
                index$iv3++;
            } else {
                index$iv3 = -1;
                break;
            }
        }
        int secondGroupFirstIndex = index$iv3;
        List beforeFirstGroup = new ArrayList();
        List betweenGroups = new ArrayList();
        List afterSecondGroup = new ArrayList();
        for (Pair pair : otherModulesWithIndex) {
            int index2 = ((Number) pair.component1()).intValue();
            ContentModule module2 = (ContentModule) pair.component2();
            if (firstGroupFirstIndex != -1 && index2 < firstGroupFirstIndex) {
                beforeFirstGroup.add(module2);
            } else if (secondGroupFirstIndex != -1 && index2 > secondGroupFirstIndex) {
                afterSecondGroup.add(module2);
            } else {
                betweenGroups.add(module2);
            }
        }
        List result = new ArrayList();
        result.addAll(beforeFirstGroup);
        if (!firstGroup.isEmpty()) {
            result.add(new ModuleGroup(firstGroup, "FIRST_GROUP"));
        }
        result.addAll(betweenGroups);
        if (!secondGroup.isEmpty()) {
            result.add(new ModuleGroup(secondGroup, "SECOND_GROUP"));
        }
        result.addAll(afterSecondGroup);
        return result;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object getUserCouponList$product_details_page_debug$default(PageViewModel pageViewModel, List list, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            list = null;
        }
        return pageViewModel.getUserCouponList$product_details_page_debug(list, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getUserCouponList$product_details_page_debug(List<CouponInfoFloor.CouponInfo> list, Continuation<? super CouponListResponse> continuation) {
        PageViewModel$getUserCouponList$1 pageViewModel$getUserCouponList$1;
        Object mallKntrGetCouponList$product_details_page_debug;
        String sourceId;
        String str = "";
        if (continuation instanceof PageViewModel$getUserCouponList$1) {
            pageViewModel$getUserCouponList$1 = (PageViewModel$getUserCouponList$1) continuation;
            if ((pageViewModel$getUserCouponList$1.label & Integer.MIN_VALUE) != 0) {
                pageViewModel$getUserCouponList$1.label -= Integer.MIN_VALUE;
                Object $result = pageViewModel$getUserCouponList$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (pageViewModel$getUserCouponList$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        try {
                            List sourceIdList = new ArrayList();
                            Ref.ObjectRef sourceId2 = new Ref.ObjectRef();
                            sourceId2.element = "";
                            if (list != null) {
                                for (CouponInfoFloor.CouponInfo coupon : list) {
                                    String sourceAuthorityId = coupon.getSourceAuthorityId();
                                    if (sourceAuthorityId != null) {
                                        Boxing.boxBoolean(sourceIdList.add(sourceAuthorityId));
                                    }
                                }
                                CouponInfoFloor.CouponInfo couponInfo = (CouponInfoFloor.CouponInfo) CollectionsKt.firstOrNull(list);
                                if (couponInfo != null && (sourceId = couponInfo.getSourceId()) != null) {
                                    str = sourceId;
                                }
                                sourceId2.element = str;
                            }
                            CouponListApiService couponListApiService = CouponListApiService.INSTANCE;
                            String valueOf = String.valueOf(UserInfoKt.getUserId());
                            String str2 = (String) sourceId2.element;
                            pageViewModel$getUserCouponList$1.L$0 = SpillingKt.nullOutSpilledVariable(list);
                            pageViewModel$getUserCouponList$1.L$1 = SpillingKt.nullOutSpilledVariable(sourceIdList);
                            pageViewModel$getUserCouponList$1.L$2 = SpillingKt.nullOutSpilledVariable(sourceId2);
                            pageViewModel$getUserCouponList$1.label = 1;
                            mallKntrGetCouponList$product_details_page_debug = couponListApiService.mallKntrGetCouponList$product_details_page_debug((r13 & 1) != 0 ? null : valueOf, (r13 & 2) != 0 ? null : null, (r13 & 4) != 0 ? CollectionsKt.emptyList() : sourceIdList, (r13 & 8) != 0 ? "" : str2, pageViewModel$getUserCouponList$1);
                            if (mallKntrGetCouponList$product_details_page_debug == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            CouponListResponse response = (CouponListResponse) mallKntrGetCouponList$product_details_page_debug;
                            return response;
                        } catch (Exception e) {
                            e = e;
                            showToast$product_details_page_debug("前方拥堵，前稍后再试");
                            return new CouponListResponse(-1L, "获取优惠券列表失败: " + e.getMessage(), 0, (List) null, 12, (DefaultConstructorMarker) null);
                        }
                    case 1:
                        Ref.ObjectRef objectRef = (Ref.ObjectRef) pageViewModel$getUserCouponList$1.L$2;
                        List list2 = (List) pageViewModel$getUserCouponList$1.L$1;
                        List list3 = (List) pageViewModel$getUserCouponList$1.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            mallKntrGetCouponList$product_details_page_debug = $result;
                            CouponListResponse response2 = (CouponListResponse) mallKntrGetCouponList$product_details_page_debug;
                            return response2;
                        } catch (Exception e2) {
                            e = e2;
                            showToast$product_details_page_debug("前方拥堵，前稍后再试");
                            return new CouponListResponse(-1L, "获取优惠券列表失败: " + e.getMessage(), 0, (List) null, 12, (DefaultConstructorMarker) null);
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        pageViewModel$getUserCouponList$1 = new PageViewModel$getUserCouponList$1(this, continuation);
        Object $result2 = pageViewModel$getUserCouponList$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (pageViewModel$getUserCouponList$1.label) {
        }
    }

    public final void showDeliveryFloatingLayer$product_details_page_debug() {
        Integer addId;
        ContentModule.DeliveryInfoModule data;
        DeliveryInfoFloor data2;
        DeliveryInfoFloor.UserDefAddrVO userDefAddrVO;
        DeliveryInfoContainerState deliveryInfoContainerState = (DeliveryInfoContainerState) this.mDeliveryInfoContainerState.getValue();
        if (deliveryInfoContainerState == null || (data = deliveryInfoContainerState.getData()) == null || (data2 = data.getData()) == null || (userDefAddrVO = data2.getUserDefAddrVO()) == null) {
            addId = null;
        } else {
            addId = userDefAddrVO.getAddId();
        }
        this.bridgeCall.invoke("showAddress", MapsKt.mapOf(TuplesKt.to("data", MapsKt.mapOf(new Pair[]{TuplesKt.to("deliverId", addId), TuplesKt.to("distId", addId), TuplesKt.to("url", "https://mall.bilibili.com/detail.html")}))), new Function1() { // from class: kntr.app.mall.product.details.page.vm.PageViewModel$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit showDeliveryFloatingLayer$lambda$0;
                showDeliveryFloatingLayer$lambda$0 = PageViewModel.showDeliveryFloatingLayer$lambda$0(PageViewModel.this, (Map) obj);
                return showDeliveryFloatingLayer$lambda$0;
            }
        });
    }

    public static final Unit showDeliveryFloatingLayer$lambda$0(PageViewModel this$0, Map result) {
        ContentModule.DeliveryInfoModule data;
        DeliveryInfoFloor infoModel;
        DeliveryInfoFloor newFloor;
        Object prevValue$iv;
        Object nextValue$iv;
        Intrinsics.checkNotNullParameter(result, "result");
        Object obj = result.get("data");
        String it = obj instanceof String ? (String) obj : null;
        if (it != null) {
            Json this_$iv = Client.INSTANCE.getJson();
            String string$iv = it;
            this_$iv.getSerializersModule();
            DeliveryInfoFloor.UserDefAddrVO chooseAddress = (DeliveryInfoFloor.UserDefAddrVO) this_$iv.decodeFromString(DeliveryInfoFloor.UserDefAddrVO.Companion.serializer(), string$iv);
            DeliveryInfoContainerState deliveryInfoContainerState = (DeliveryInfoContainerState) this$0.mDeliveryInfoContainerState.getValue();
            if (deliveryInfoContainerState != null && (data = deliveryInfoContainerState.getData()) != null && (infoModel = data.getData()) != null) {
                newFloor = infoModel.copy((i & 1) != 0 ? infoModel.floorKey : null, (i & 2) != 0 ? infoModel.floorIcon : null, (i & 4) != 0 ? infoModel.bgImgUrl : null, (i & 8) != 0 ? infoModel.addrText : null, (i & 16) != 0 ? infoModel.addressModuleData : null, (i & 32) != 0 ? infoModel.canOpenAddr : null, (i & 64) != 0 ? infoModel.itemsDeliveryInfo : null, (i & 128) != 0 ? infoModel.userDefAddrVO : chooseAddress);
                MutableStateFlow $this$update$iv = this$0.mDeliveryInfoContainerState;
                do {
                    prevValue$iv = $this$update$iv.getValue();
                    DeliveryInfoContainerState deliveryInfoContainerState2 = (DeliveryInfoContainerState) prevValue$iv;
                    nextValue$iv = new DeliveryInfoContainerState(new ContentModule.DeliveryInfoModule(newFloor));
                } while (!$this$update$iv.compareAndSet(prevValue$iv, nextValue$iv));
                KLog_androidKt.getKLog().e("na_detail_showAddress", "Result: " + it);
            }
        }
        return Unit.INSTANCE;
    }

    public final void showSkuFloatingLayer$product_details_page_debug() {
        ProductDetailsResponse.ProductDetailsData data;
        SkuInfoFloor skuInfo;
        SkuInfoFloor.ItemsSkuListVO itemsSkuListVO;
        String it;
        ProductDetailsResponse productDetailsResponse = (ProductDetailsResponse) this._productDetailsResponse.getValue();
        if (productDetailsResponse != null && (data = productDetailsResponse.getData()) != null && (skuInfo = data.getSkuInfoFloorVO()) != null && (itemsSkuListVO = skuInfo.getItemsSkuListVO()) != null && (it = itemsSkuListVO.getSkuPanelUrl()) != null) {
            bridgeShowHalfWebView$product_details_page_debug(addSpecIdWithJumpUrl(it));
        }
    }

    public final void bridgeShowHalfWebView$product_details_page_debug(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.bridgeCall.invoke("showHalf", MapsKt.mapOf(TuplesKt.to("url", url)), new Function1() { // from class: kntr.app.mall.product.details.page.vm.PageViewModel$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit bridgeShowHalfWebView$lambda$0;
                bridgeShowHalfWebView$lambda$0 = PageViewModel.bridgeShowHalfWebView$lambda$0((Map) obj);
                return bridgeShowHalfWebView$lambda$0;
            }
        });
    }

    public static final Unit bridgeShowHalfWebView$lambda$0(Map map) {
        Intrinsics.checkNotNullParameter(map, "<unused var>");
        return Unit.INSTANCE;
    }

    public final void handleSearch$product_details_page_debug(String searchText) {
        this.actionHandler.handleSearch$product_details_page_debug(searchText);
    }

    public final void handleBackAction$product_details_page_debug() {
        OnBackPressedDispatcher backPressedDispatcher = (OnBackPressedDispatcher) this.backPressedDispatcherProvider.invoke();
        backPressedDispatcher.onBackPressed();
    }

    public final void handleShopItemClick$product_details_page_debug(ProductShopDetailsShopItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.actionHandler.handleShopItemClick$product_details_page_debug(item);
    }

    public final void handleGoToCommentList$product_details_page_debug() {
        String itemsId = this.itemsId;
        PageActionHandler.trackEvent$product_details_page_debug$default(this.actionHandler, TrackConsts.MALL_MALL_DETAIL_COMMENTMORE_0_CLICK, null, false, false, 14, null);
        this.actionHandler.handleGoToCommentList$product_details_page_debug(itemsId);
    }

    public final void handleGoToCommentDetail$product_details_page_debug(CommentInfoApiService.CommentInfoResponse.CommentInfoData.CommentModel comment) {
        Intrinsics.checkNotNullParameter(comment, "comment");
        String itemsId = this.itemsId;
        this.actionHandler.handleGoToCommentDetail$product_details_page_debug(itemsId, comment);
    }

    public final void handleCommentTagId$product_details_page_debug(String tagId) {
        Long shopId;
        ProductDetailsResponse.ProductDetailsData data;
        BasicInfoFloor basicInfoFloorVO;
        ProductDetailsResponse productDetailsResponse = (ProductDetailsResponse) this._productDetailsResponse.getValue();
        if (productDetailsResponse == null || (data = productDetailsResponse.getData()) == null || (basicInfoFloorVO = data.getBasicInfoFloorVO()) == null) {
            shopId = null;
        } else {
            shopId = basicInfoFloorVO.getShopId();
        }
        String jumpUrl = "https://mall.bilibili.com/neul/index.html?page=mall_commentlist&noTitleBar=1&goFrom=na&shopId=" + (shopId == null ? "" : shopId) + "&itemsId=" + this.itemsId + "&recId=&ugcId=&from=&subTagId=" + (tagId != null ? tagId : "");
        this.actionHandler.pushTo$product_details_page_debug(jumpUrl);
    }

    public final void handleShopJump$product_details_page_debug() {
        String jumpUrl;
        ActionIconModel actionIconModel;
        List<ActionIconModel> footer;
        Object obj;
        ActionIconModel it;
        ProductDetailsResponse.ProductDetailsData data;
        ProductDetailsResponse.ProductDetailsData data2;
        ShopInfoFloor shopInfoFloorVO;
        ShopInfoFloor.ShopInfoVO shopInfoVO;
        ProductDetailsResponse productResponse = (ProductDetailsResponse) this._productDetailsResponse.getValue();
        if (productResponse == null || (data2 = productResponse.getData()) == null || (shopInfoFloorVO = data2.getShopInfoFloorVO()) == null || (shopInfoVO = shopInfoFloorVO.getShopInfoVO()) == null) {
            jumpUrl = null;
        } else {
            jumpUrl = shopInfoVO.getShopJumpLink();
        }
        String str = jumpUrl;
        boolean z = false;
        if (!(str == null || str.length() == 0)) {
            this.actionHandler.pushTo$product_details_page_debug(jumpUrl);
            return;
        }
        FooterFloor footerFloor = (productResponse == null || (data = productResponse.getData()) == null) ? null : data.getFooterFloorVO();
        if (footerFloor == null || (footer = footerFloor.getFooter()) == null) {
            actionIconModel = null;
        } else {
            Iterator<T> it2 = footer.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it2.next();
                ActionIconModel it3 = (ActionIconModel) obj;
                Integer type = it3.getType();
                if (type != null && type.intValue() == 4) {
                    it = 1;
                    continue;
                } else {
                    it = null;
                    continue;
                }
                if (it != null) {
                    break;
                }
            }
            actionIconModel = (ActionIconModel) obj;
        }
        ActionIconModel shopInfo = actionIconModel;
        String jumpUrl2 = shopInfo != null ? shopInfo.getJumpUrl() : null;
        String str2 = jumpUrl2;
        if (str2 == null || str2.length() == 0) {
            z = true;
        }
        if (!z) {
            this.actionHandler.pushTo$product_details_page_debug(jumpUrl2);
        }
    }

    public final void handleCommentPublishGuideClick$product_details_page_debug() {
        Router router = (Router) this.routerProvider.invoke();
        if (!UserInfoKt.isUserLoggedIn()) {
            router.launch(UrisKt.toUri("bilibili://login"));
            return;
        }
        Function3<String, Map<String, ? extends Object>, Function1<? super Map<String, ? extends Object>, Unit>, Unit> function3 = this.bridgeCall;
        Pair[] pairArr = new Pair[12];
        pairArr[0] = TuplesKt.to("mode", "lite");
        pairArr[1] = TuplesKt.to("titleMode", "text");
        pairArr[2] = TuplesKt.to("titleText", "发表评论");
        String str = this.itemsId;
        if (str == null) {
            str = "";
        }
        pairArr[3] = TuplesKt.to("productid", str);
        pairArr[4] = TuplesKt.to("enableUploadImage", true);
        pairArr[5] = TuplesKt.to("enablePub", true);
        pairArr[6] = TuplesKt.to("placeHolder", "快与同好分享你的感受及购物心得吧～");
        pairArr[7] = TuplesKt.to("commentTips", "友善讨论 社区留香");
        pairArr[8] = TuplesKt.to("selectedPub", true);
        pairArr[9] = TuplesKt.to("minTextLength", 3);
        pairArr[10] = TuplesKt.to("textLimit", Integer.valueOf((int) MediaAttrUtils.TYPE_PAY_SEASON));
        pairArr[11] = TuplesKt.to("enableEmoji", false);
        function3.invoke("showEditor", MapsKt.mapOf(TuplesKt.to("data", MapsKt.mapOf(pairArr))), new Function1() { // from class: kntr.app.mall.product.details.page.vm.PageViewModel$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit handleCommentPublishGuideClick$lambda$0;
                handleCommentPublishGuideClick$lambda$0 = PageViewModel.handleCommentPublishGuideClick$lambda$0(PageViewModel.this, (Map) obj);
                return handleCommentPublishGuideClick$lambda$0;
            }
        });
    }

    public static final Unit handleCommentPublishGuideClick$lambda$0(PageViewModel this$0, Map result) {
        Intrinsics.checkNotNullParameter(result, "result");
        KLog_androidKt.getKLog().i("PageViewModel", "评论发布结果: " + result);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this$0), (CoroutineContext) null, (CoroutineStart) null, new PageViewModel$handleCommentPublishGuideClick$1$1(this$0, result, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    public final void reportShopFloorShow$product_details_page_debug() {
        PageActionHandler.trackEvent$product_details_page_debug$default(this.actionHandler, TrackConsts.MALL_MALL_DETAIL_UPSTORE_RELATED_LIKE_SHOW, MapsKt.emptyMap(), false, false, 8, null);
    }

    public static /* synthetic */ void reportShopItemClick$product_details_page_debug$default(PageViewModel pageViewModel, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        pageViewModel.reportShopItemClick$product_details_page_debug(str);
    }

    public final void reportShopItemClick$product_details_page_debug(String itemsId) {
        PageActionHandler.trackEvent$product_details_page_debug$default(this.actionHandler, TrackConsts.MALL_MALL_DETAIL_UPSTORE_RELATED_LIKE_CLICK, MapsKt.mapOf(TuplesKt.to("items_id", itemsId == null ? "" : itemsId)), true, false, 8, null);
    }

    public final void reportIpRecommendShow$product_details_page_debug(List<ShopItem> list, boolean isInPreview) {
        Intrinsics.checkNotNullParameter(list, "recommendItems");
        List<ShopItem> $this$mapNotNull$iv = list;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            ShopItem it = (ShopItem) element$iv$iv$iv;
            Long itemsId = it.getItemsId();
            String valueOf = itemsId != null ? String.valueOf(itemsId.longValue()) : null;
            if (valueOf != null) {
                destination$iv$iv.add(valueOf);
            }
        }
        String recItemIds = CollectionsKt.joinToString$default((List) destination$iv$iv, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        String showType = isInPreview ? "1" : "0";
        PageActionHandler.trackEvent$product_details_page_debug$default(this.actionHandler, TrackConsts.MALL_MALL_DETAIL_MAIN_PICTURE_IPRELATE_SHOW, MapsKt.mapOf(new Pair[]{TuplesKt.to("rec_item_id", recItemIds), TuplesKt.to("show_type", showType)}), false, false, 8, null);
    }

    public final void reportIpRecommendItemClick$product_details_page_debug(ShopItem clickedItem, boolean isInPreview) {
        Intrinsics.checkNotNullParameter(clickedItem, "clickedItem");
        String showType = isInPreview ? "1" : "0";
        PageActionHandler pageActionHandler = this.actionHandler;
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to("show_type", showType);
        Long itemsId = clickedItem.getItemsId();
        pairArr[1] = TuplesKt.to("rec_item_id", (itemsId == null || (r3 = String.valueOf(itemsId.longValue())) == null) ? "" : "");
        PageActionHandler.trackEvent$product_details_page_debug$default(pageActionHandler, TrackConsts.MALL_MALL_DETAIL_MAIN_PICTURE_IPRELATE_CLICK, MapsKt.mapOf(pairArr), true, false, 8, null);
    }

    public final void reportIpRecommendDetailMoreClick$product_details_page_debug(boolean isFromTMFeed, boolean isInPreview) {
        String gotoType = isFromTMFeed ? "t3" : "detail";
        String showType = isInPreview ? "1" : "0";
        PageActionHandler.trackEvent$product_details_page_debug$default(this.actionHandler, TrackConsts.MALL_MALL_DETAIL_MAIN_PICTURE_DETAILMORE_CLICK, MapsKt.mapOf(new Pair[]{TuplesKt.to("show_type", showType), TuplesKt.to("goto_type", gotoType)}), true, false, 8, null);
    }

    public final void reportFbCardShow$product_details_page_debug(MallRecommendItem item) {
        String logData;
        Intrinsics.checkNotNullParameter(item, "item");
        HashMap map = new HashMap();
        HashMap hashMap = map;
        Long itemId = item.getItemId();
        String str = "";
        hashMap.put("itemId", (itemId == null || (r2 = String.valueOf(itemId.longValue())) == null) ? "" : "");
        HashMap hashMap2 = map;
        String itemType = item.getItemType();
        if (itemType == null) {
            itemType = "";
        }
        hashMap2.put("type", itemType);
        HashMap hashMap3 = map;
        ReportInfo reportInfo = item.getReportInfo();
        if (reportInfo != null && (logData = reportInfo.getLogData()) != null) {
            str = logData;
        }
        hashMap3.put("report_info", str);
        Map $this$forEach$iv = item.getReportParams();
        if ($this$forEach$iv != null) {
            for (Map.Entry element$iv : $this$forEach$iv.entrySet()) {
                String key = element$iv.getKey();
                String value = element$iv.getValue();
                if (value != null) {
                    map.put(key, value);
                }
            }
        }
        KNeuron.INSTANCE.reportExposure(false, TrackConsts.MALL_FB_FB_CARD_0_SHOW, map);
    }

    public final void reportFbCardClick$product_details_page_debug(MallRecommendItem item) {
        String logData;
        Intrinsics.checkNotNullParameter(item, "item");
        HashMap map = new HashMap();
        HashMap hashMap = map;
        Long itemId = item.getItemId();
        String str = "";
        hashMap.put("itemId", (itemId == null || (r2 = String.valueOf(itemId.longValue())) == null) ? "" : "");
        HashMap hashMap2 = map;
        String itemType = item.getItemType();
        if (itemType == null) {
            itemType = "";
        }
        hashMap2.put("type", itemType);
        HashMap hashMap3 = map;
        ReportInfo reportInfo = item.getReportInfo();
        if (reportInfo != null && (logData = reportInfo.getLogData()) != null) {
            str = logData;
        }
        hashMap3.put("report_info", str);
        Map $this$forEach$iv = item.getReportParams();
        if ($this$forEach$iv != null) {
            for (Map.Entry element$iv : $this$forEach$iv.entrySet()) {
                String key = element$iv.getKey();
                String value = element$iv.getValue();
                if (value != null) {
                    map.put(key, value);
                }
            }
        }
        KNeuron.INSTANCE.reportClick(false, TrackConsts.MALL_FB_FB_CARD_0_CLICK, map);
    }

    public final void reportCrowdfundingProgressItemShow$product_details_page_debug(CrowdfundingProgressFloor.ProgressItem item) {
        String valueOf;
        Intrinsics.checkNotNullParameter(item, "item");
        Long contentId = item.getContentId();
        String videoIcon = item.getVideoIcon();
        boolean isVideo = !(videoIcon == null || videoIcon.length() == 0);
        Pair[] pairArr = new Pair[8];
        String str = this.itemsId;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        pairArr[0] = TuplesKt.to("itemsId", str);
        String str3 = this.from;
        if (str3 == null) {
            str3 = "";
        }
        pairArr[1] = TuplesKt.to("from", str3);
        String str4 = this.fromSpmid;
        if (str4 == null) {
            str4 = "";
        }
        pairArr[2] = TuplesKt.to("from_spmid", str4);
        String str5 = this.msource;
        if (str5 == null) {
            str5 = "";
        }
        pairArr[3] = TuplesKt.to("msource", str5);
        Long l = this.merchantId;
        pairArr[4] = TuplesKt.to("merchant_id", (l == null || (r2 = String.valueOf(l.longValue())) == null) ? "" : "");
        String str6 = this.track_id;
        if (str6 == null) {
            str6 = "";
        }
        pairArr[5] = TuplesKt.to("track_id", str6);
        pairArr[6] = TuplesKt.to("content_type", isVideo ? "1" : "2");
        if (contentId != null && (valueOf = String.valueOf(contentId.longValue())) != null) {
            str2 = valueOf;
        }
        pairArr[7] = TuplesKt.to("content_id", str2);
        Map params = MapsKt.mapOf(pairArr);
        PageActionHandler.trackEvent$product_details_page_debug$default(this.actionHandler, TrackConsts.MALL_MALL_DETAIL_CROWDFUNDING_PROGRESS_CONTENT_ALL_SHOW, params, false, false, 8, null);
    }

    public final void reportCrowdfundingProgressItemClick$product_details_page_debug(CrowdfundingProgressFloor.ProgressItem item) {
        String valueOf;
        Intrinsics.checkNotNullParameter(item, "item");
        Long contentId = item.getContentId();
        String videoIcon = item.getVideoIcon();
        boolean isVideo = !(videoIcon == null || videoIcon.length() == 0);
        Pair[] pairArr = new Pair[8];
        String str = this.itemsId;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        pairArr[0] = TuplesKt.to("itemsId", str);
        String str3 = this.from;
        if (str3 == null) {
            str3 = "";
        }
        pairArr[1] = TuplesKt.to("from", str3);
        String str4 = this.fromSpmid;
        if (str4 == null) {
            str4 = "";
        }
        pairArr[2] = TuplesKt.to("from_spmid", str4);
        String str5 = this.msource;
        if (str5 == null) {
            str5 = "";
        }
        pairArr[3] = TuplesKt.to("msource", str5);
        Long l = this.merchantId;
        pairArr[4] = TuplesKt.to("merchant_id", (l == null || (r2 = String.valueOf(l.longValue())) == null) ? "" : "");
        String str6 = this.track_id;
        if (str6 == null) {
            str6 = "";
        }
        pairArr[5] = TuplesKt.to("track_id", str6);
        pairArr[6] = TuplesKt.to("content_type", isVideo ? "1" : "2");
        if (contentId != null && (valueOf = String.valueOf(contentId.longValue())) != null) {
            str2 = valueOf;
        }
        pairArr[7] = TuplesKt.to("content_id", str2);
        Map params = MapsKt.mapOf(pairArr);
        PageActionHandler.trackEvent$product_details_page_debug$default(this.actionHandler, TrackConsts.MALL_MALL_DETAIL_CROWDFUNDING_PROGRESS_CONTENT_MORE_CLICK, params, true, false, 8, null);
    }

    public final void reportRecFloorItemShow$product_details_page_debug(ShopItem item, int index) {
        Map destination$iv$iv$iv;
        String jsonElement;
        Intrinsics.checkNotNullParameter(item, "item");
        PageActionHandler pageActionHandler = this.actionHandler;
        Pair[] pairArr = new Pair[3];
        Long itemsId = item.getItemsId();
        pairArr[0] = TuplesKt.to("productid", (itemsId == null || (r4 = String.valueOf(itemsId.longValue())) == null) ? "" : "");
        pairArr[1] = TuplesKt.to("module_index", String.valueOf(index));
        Long merchantId = item.getMerchantId();
        String valueOf = merchantId != null ? String.valueOf(merchantId.longValue()) : null;
        if (valueOf == null) {
            valueOf = "";
        }
        pairArr[2] = TuplesKt.to("merchant_id", valueOf);
        Map mutableMapOf = MapsKt.mutableMapOf(pairArr);
        Map reportParams = item.getReportParams();
        if (reportParams == null) {
            destination$iv$iv$iv = MapsKt.emptyMap();
        } else {
            Map $this$mapValues$iv = reportParams;
            Map destination$iv$iv = new LinkedHashMap(MapsKt.mapCapacity($this$mapValues$iv.size()));
            Iterable $this$associateByTo$iv$iv$iv = $this$mapValues$iv.entrySet();
            destination$iv$iv$iv = destination$iv$iv;
            for (Object element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
                Map.Entry it$iv$iv = (Map.Entry) element$iv$iv$iv;
                Object key = it$iv$iv.getKey();
                JsonPrimitive jsonPrimitive = (JsonElement) ((Map.Entry) element$iv$iv$iv).getValue();
                if (jsonPrimitive instanceof JsonPrimitive) {
                    jsonElement = JsonElementKt.getContentOrNull(jsonPrimitive);
                    if (jsonElement == null) {
                        jsonElement = "";
                    }
                } else {
                    jsonElement = jsonPrimitive.toString();
                }
                destination$iv$iv$iv.put(key, jsonElement);
            }
        }
        PageActionHandler.trackEvent$product_details_page_debug$default(pageActionHandler, TrackConsts.MALL_MALL_DETAIL_RELATED_LIKE_0_SHOW, MapsKt.plus(mutableMapOf, destination$iv$iv$iv), false, false, 8, null);
    }

    public final void reportRecFloorItemClick$product_details_page_debug(ShopItem item, int index) {
        Map destination$iv$iv$iv;
        String jsonElement;
        Intrinsics.checkNotNullParameter(item, "item");
        PageActionHandler pageActionHandler = this.actionHandler;
        Pair[] pairArr = new Pair[3];
        Long itemsId = item.getItemsId();
        pairArr[0] = TuplesKt.to("productid", (itemsId == null || (r4 = String.valueOf(itemsId.longValue())) == null) ? "" : "");
        pairArr[1] = TuplesKt.to("module_index", String.valueOf(index));
        Long merchantId = item.getMerchantId();
        String valueOf = merchantId != null ? String.valueOf(merchantId.longValue()) : null;
        if (valueOf == null) {
            valueOf = "";
        }
        pairArr[2] = TuplesKt.to("merchant_id", valueOf);
        Map mutableMapOf = MapsKt.mutableMapOf(pairArr);
        Map reportParams = item.getReportParams();
        if (reportParams == null) {
            destination$iv$iv$iv = MapsKt.emptyMap();
        } else {
            Map $this$mapValues$iv = reportParams;
            Map destination$iv$iv = new LinkedHashMap(MapsKt.mapCapacity($this$mapValues$iv.size()));
            Iterable $this$associateByTo$iv$iv$iv = $this$mapValues$iv.entrySet();
            destination$iv$iv$iv = destination$iv$iv;
            for (Object element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
                Map.Entry it$iv$iv = (Map.Entry) element$iv$iv$iv;
                Object key = it$iv$iv.getKey();
                JsonPrimitive jsonPrimitive = (JsonElement) ((Map.Entry) element$iv$iv$iv).getValue();
                if (jsonPrimitive instanceof JsonPrimitive) {
                    jsonElement = JsonElementKt.getContentOrNull(jsonPrimitive);
                    if (jsonElement == null) {
                        jsonElement = "";
                    }
                } else {
                    jsonElement = jsonPrimitive.toString();
                }
                destination$iv$iv$iv.put(key, jsonElement);
            }
        }
        PageActionHandler.trackEvent$product_details_page_debug$default(pageActionHandler, TrackConsts.MALL_MALL_DETAIL_RELATED_LIKE_0_CLICK, MapsKt.plus(mutableMapOf, destination$iv$iv$iv), true, false, 8, null);
    }

    public final void reportRecFloorT3MoreClick$product_details_page_debug() {
        PageActionHandler.trackEvent$product_details_page_debug$default(this.actionHandler, TrackConsts.MALL_MALL_DETAIL_RELATED_LIKE_T3_MORE_CLICK, MapsKt.emptyMap(), true, false, 8, null);
    }

    public final void reportRecFloorT3MoreShow$product_details_page_debug() {
        PageActionHandler.trackEvent$product_details_page_debug$default(this.actionHandler, TrackConsts.MALL_MALL_DETAIL_RELATED_LIKE_T3_MORE_SHOW, MapsKt.emptyMap(), false, false, 8, null);
    }

    public final void handleLiveInfoJump$product_details_page_debug(LiveInfoApiService.LiveInfoData liveInfo) {
        Intrinsics.checkNotNullParameter(liveInfo, "liveInfo");
        String jumpUrl = liveInfo.getJumpUrl();
        String str = jumpUrl;
        if (!(str == null || str.length() == 0)) {
            this.actionHandler.pushTo$product_details_page_debug(jumpUrl);
        }
    }

    public final void handleHeaderButtonClick$product_details_page_debug(ActionIconModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        Integer type = model.getType();
        if (type != null && type.intValue() == 0) {
            handleBackAction$product_details_page_debug();
        } else if (type != null && type.intValue() == 1) {
            KLog_androidKt.getKLog().e("PageViewModel", "Should not handle search here");
        } else if (type != null && type.intValue() == 2) {
            if (model.getJumpUrl() != null) {
                this.actionHandler.pushTo$product_details_page_debug(model.getJumpUrl());
                return;
            }
            KLog_androidKt.getKLog().e("PageViewModel", "Jump URL is null for type: " + model.getType());
        } else if (type != null && type.intValue() == 3) {
            handleShare();
        } else {
            KLog_androidKt.getKLog().e("PageViewModel", "Unknown header button type: " + model.getType());
        }
    }

    public final void handleFooterButtonClick$product_details_page_debug(ActionIconModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        Integer type = model.getType();
        if ((type != null && type.intValue() == 4) || (type != null && type.intValue() == 5)) {
            if (model.getJumpUrl() != null) {
                this.actionHandler.pushTo$product_details_page_debug(model.getJumpUrl());
            } else {
                KLog_androidKt.getKLog().e("PageViewModel", "Jump URL is null for type: " + model.getType());
            }
        } else if (type != null && type.intValue() == 6) {
            long currentTime = DateFormatKt.getCurrentTimeMillis();
            if (currentTime - this.lastWishClickTime < 2000) {
                return;
            }
            this.lastWishClickTime = currentTime;
            Router router = (Router) this.routerProvider.invoke();
            if (!UserInfoKt.isUserLoggedIn()) {
                router.launch(UrisKt.toUri("bilibili://login"));
                return;
            }
            boolean isWished = Intrinsics.areEqual(((WishInfo) this._wishInfo.getValue()).getActive(), true);
            if (!isWished) {
                this._isUserTriggeredWishAction.setValue(true);
            }
            byte wishType = isWished ? (byte) 2 : (byte) 1;
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new PageViewModel$handleFooterButtonClick$1(this, wishType, isWished, null), 3, (Object) null);
        }
    }

    public final void handleAddButton$product_details_page_debug(FooterFloor.PurchaseButton model) {
        Intrinsics.checkNotNullParameter(model, "model");
        if (!UserInfoKt.isUserLoggedIn()) {
            Router router = (Router) this.routerProvider.invoke();
            router.launch(UrisKt.toUri("bilibili://login"));
            return;
        }
        Integer addCartType = model.getAddCartType();
        String addCartUrl = model.getAddCartJumpUrl();
        PageActionHandler.trackEvent$product_details_page_debug$default(this.actionHandler, TrackConsts.MALL_MALL_DETAIL_BUTTON_ADDCART_0_CLICK, null, false, false, 14, null);
        if (addCartType != null && addCartType.intValue() == 1) {
            if (addCartUrl != null) {
                this.actionHandler.pushTo$product_details_page_debug(addCartUrl);
            }
        } else if (addCartType != null && addCartType.intValue() == 2) {
            if (addCartUrl != null) {
                bridgeShowHalfWebView$product_details_page_debug(addSpecIdWithJumpUrl(addCartUrl));
            }
        } else if (addCartType != null && addCartType.intValue() == 3) {
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new PageViewModel$handleAddButton$3(model, this, null), 3, (Object) null);
        } else {
            KLog_androidKt.getKLog().e("PageViewModel", "Unknown add cart type: " + addCartType);
        }
    }

    public final void handlePurchaseButton$product_details_page_debug(FooterFloor.PurchaseButton model) {
        Intrinsics.checkNotNullParameter(model, "model");
        PageActionHandler.trackEvent$product_details_page_debug$default(this.actionHandler, TrackConsts.MALL_MALL_DETAIL_BUTTON_BUYNOW_0_CLICK, null, false, false, 14, null);
        if (!UserInfoKt.isUserLoggedIn()) {
            Router router = (Router) this.routerProvider.invoke();
            router.launch(UrisKt.toUri("bilibili://login"));
            return;
        }
        Integer jumpType = model.getJumpType();
        String jumpUrl = model.getJumpUrl();
        if (jumpType != null && jumpType.intValue() == 1) {
            if (jumpUrl != null) {
                this.actionHandler.pushTo$product_details_page_debug(jumpUrl);
            }
        } else if (jumpType != null && jumpType.intValue() == 2) {
            if (jumpUrl != null) {
                bridgeShowHalfWebView$product_details_page_debug(addSpecIdWithJumpUrl(jumpUrl));
            }
        } else if (jumpType != null && jumpType.intValue() == 3) {
            KLog_androidKt.getKLog().e("PageViewModel", "不可点击");
        } else if (jumpType != null && jumpType.intValue() == 4) {
            StringFormat $this$encodeToString$iv = Json.Default;
            Object value$iv = model.getRealtimeRequest();
            $this$encodeToString$iv.getSerializersModule();
            String realtimeRequestJson = $this$encodeToString$iv.encodeToString(BuiltinSerializersKt.getNullable(JsonObject.Companion.serializer()), value$iv);
            StringFormat $this$encodeToString$iv2 = Json.Default;
            Object value$iv2 = model.getSourceQuery();
            $this$encodeToString$iv2.getSerializersModule();
            String sourceQueryJson = $this$encodeToString$iv2.encodeToString(BuiltinSerializersKt.getNullable(JsonObject.Companion.serializer()), value$iv2);
            KLog_androidKt.getKLog().e("purchase", "Result: " + realtimeRequestJson + ", " + sourceQueryJson);
            this.bridgeCall.invoke("purchase", MapsKt.mapOf(new Pair[]{TuplesKt.to("realtimeRequest", realtimeRequestJson), TuplesKt.to("sourceQuery", sourceQueryJson)}), new Function1() { // from class: kntr.app.mall.product.details.page.vm.PageViewModel$$ExternalSyntheticLambda6
                public final Object invoke(Object obj) {
                    Unit handlePurchaseButton$lambda$2;
                    handlePurchaseButton$lambda$2 = PageViewModel.handlePurchaseButton$lambda$2((Map) obj);
                    return handlePurchaseButton$lambda$2;
                }
            });
        } else if (jumpType != null && jumpType.intValue() == 5) {
            CalendarRemindModel calendarModel = model.getCalendarRemind();
            if (calendarModel == null) {
                KLog_androidKt.getKLog().e("PageViewModel", "Remind time or message is null");
            } else {
                BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new PageViewModel$handlePurchaseButton$4(this, calendarModel, null), 3, (Object) null);
            }
        } else if (jumpType != null && jumpType.intValue() == 6) {
            handleReserve();
        } else if (jumpType != null && jumpType.intValue() == 7) {
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new PageViewModel$handlePurchaseButton$5(model, this, null), 3, (Object) null);
        } else if (jumpType == null || jumpType.intValue() != 8) {
            KLog_androidKt.getKLog().e("PageViewModel", "Unknown purchase button type: " + jumpType);
        } else {
            CalendarRemindModel calendarModel2 = model.getCalendarRemind();
            if (calendarModel2 == null) {
                return;
            }
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new PageViewModel$handlePurchaseButton$6(this, calendarModel2, model, null), 3, (Object) null);
        }
    }

    public static final Unit handlePurchaseButton$lambda$2(Map result) {
        Intrinsics.checkNotNullParameter(result, "result");
        KLog_androidKt.getKLog().i("purchase", "Result: " + result);
        return Unit.INSTANCE;
    }

    private final String addSpecIdWithJumpUrl(String url) {
        List specInfoList;
        List<SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem.SpecValueListItem> specValueVOList;
        SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem.SpecValueListItem specValueListItem;
        ProductDetailsResponse.ProductDetailsData data;
        SkuInfoFloor skuInfoFloorVO;
        SkuInfoFloor.ItemsSkuListVO itemsSkuListVO;
        int skuIndex = ((Number) this.headerSkuSelectedIndex.getValue()).intValue();
        ProductDetailsResponse productDetailsResponse = (ProductDetailsResponse) this._productDetailsResponse.getValue();
        Long specId = null;
        if (productDetailsResponse == null || (data = productDetailsResponse.getData()) == null || (skuInfoFloorVO = data.getSkuInfoFloorVO()) == null || (itemsSkuListVO = skuInfoFloorVO.getItemsSkuListVO()) == null) {
            specInfoList = null;
        } else {
            specInfoList = itemsSkuListVO.getSpecInfoList();
        }
        SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem specInfo = specInfoList != null ? (SkuInfoFloor.ItemsSkuListVO.SpecInfoListItem) CollectionsKt.firstOrNull(specInfoList) : null;
        if (specInfo != null && (specValueVOList = specInfo.getSpecValueVOList()) != null && (specValueListItem = specValueVOList.get(skuIndex)) != null) {
            specId = specValueListItem.getSpecId();
        }
        if (specId != null) {
            long it = specId.longValue();
            Uri uri = UrisKt.toUri(url);
            Iterable $this$associateWith$iv = uri.getQueryParameterNames();
            Map result$iv = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateWith$iv, 10)), 16));
            Map destination$iv$iv = result$iv;
            for (Object element$iv$iv : $this$associateWith$iv) {
                int skuIndex2 = skuIndex;
                String it2 = (String) element$iv$iv;
                destination$iv$iv.put(element$iv$iv, uri.getQueryParameter(it2));
                skuIndex = skuIndex2;
            }
            Map originalParams = MapsKt.toMutableMap(destination$iv$iv);
            CharSequence charSequence = (CharSequence) originalParams.get("specId");
            if (charSequence == null || charSequence.length() == 0) {
                originalParams.put("specId", String.valueOf(it));
            }
            Builder newUri = uri.buildUpon().clearQuery();
            for (Map.Entry entry : originalParams.entrySet()) {
                String key = (String) entry.getKey();
                String value = (String) entry.getValue();
                newUri.appendQueryParameter(key, value);
            }
            return newUri.build().toString();
        }
        return url;
    }

    public final void handleNewFileInfoSku$product_details_page_debug(SkuInfoFloor.ItemsSkuListVO.ItemsSkuListItem sku) {
        if (sku == null) {
            return;
        }
        Long id = sku.getId();
        SkuInfoFloor.ItemsSkuListVO.ItemsSkuListItem itemsSkuListItem = (SkuInfoFloor.ItemsSkuListVO.ItemsSkuListItem) this._fileInfoSelectedSku.getValue();
        if (Intrinsics.areEqual(id, itemsSkuListItem != null ? itemsSkuListItem.getId() : null)) {
            return;
        }
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new PageViewModel$handleNewFileInfoSku$1(this, sku, null), 3, (Object) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x014f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getCoupon$product_details_page_debug(CouponListResponse.CouponListItem coupon, Continuation<? super Boolean> continuation) {
        PageViewModel$getCoupon$1 pageViewModel$getCoupon$1;
        String platform;
        Object mallKntrReceiveCoupon$product_details_page_debug;
        String message;
        if (continuation instanceof PageViewModel$getCoupon$1) {
            pageViewModel$getCoupon$1 = (PageViewModel$getCoupon$1) continuation;
            if ((pageViewModel$getCoupon$1.label & Integer.MIN_VALUE) != 0) {
                pageViewModel$getCoupon$1.label -= Integer.MIN_VALUE;
                Object $result = pageViewModel$getCoupon$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (pageViewModel$getCoupon$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        switch (WhenMappings.$EnumSwitchMapping$0[KDevice.INSTANCE.getDeviceType().ordinal()]) {
                            case 1:
                                platform = "ios";
                                break;
                            case 2:
                                platform = "android";
                                break;
                            case 3:
                                platform = "harmonyos";
                                break;
                            default:
                                throw new NoWhenBranchMatchedException();
                        }
                        Map params = MapsKt.mapOf(new Pair[]{TuplesKt.to("deviceId", KDevice.INSTANCE.getBuvid()), TuplesKt.to("fromPage", Boxing.boxInt(2)), TuplesKt.to("deviceInfo", MapsKt.mapOf(new Pair[]{TuplesKt.to("build", ""), TuplesKt.to("info", KAppInfo.INSTANCE.getMobiApp()), TuplesKt.to("platform", platform), TuplesKt.to("ua", "")})), TuplesKt.to("sourceId", coupon.getSourceId()), TuplesKt.to("sourceAuthorityId", coupon.getSourceAuthorityId()), TuplesKt.to("sourceActivityId", coupon.getSourceId()), TuplesKt.to("needDeviceCheck", Boxing.boxBoolean(false)), TuplesKt.to("sourceBizId", Boxing.boxLong(DateFormatKt.getCurrentTimeMillis()))});
                        try {
                            CouponListApiService couponListApiService = CouponListApiService.INSTANCE;
                            pageViewModel$getCoupon$1.L$0 = SpillingKt.nullOutSpilledVariable(coupon);
                            pageViewModel$getCoupon$1.L$1 = SpillingKt.nullOutSpilledVariable(platform);
                            pageViewModel$getCoupon$1.L$2 = SpillingKt.nullOutSpilledVariable(params);
                            pageViewModel$getCoupon$1.label = 1;
                            mallKntrReceiveCoupon$product_details_page_debug = couponListApiService.mallKntrReceiveCoupon$product_details_page_debug(params, pageViewModel$getCoupon$1);
                            if (mallKntrReceiveCoupon$product_details_page_debug == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            CouponListApiService.CouponReceiveResposne response = (CouponListApiService.CouponReceiveResposne) mallKntrReceiveCoupon$product_details_page_debug;
                            showToast$product_details_page_debug(response.getMessage());
                            return Boxing.boxBoolean(true);
                        } catch (Exception e) {
                            e = e;
                            message = e.getMessage();
                            if (message == null) {
                                message = "领取失败";
                            }
                            showToast$product_details_page_debug(message);
                            return Boxing.boxBoolean(false);
                        }
                    case 1:
                        Map map = (Map) pageViewModel$getCoupon$1.L$2;
                        String str = (String) pageViewModel$getCoupon$1.L$1;
                        CouponListResponse.CouponListItem couponListItem = (CouponListResponse.CouponListItem) pageViewModel$getCoupon$1.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            mallKntrReceiveCoupon$product_details_page_debug = $result;
                            CouponListApiService.CouponReceiveResposne response2 = (CouponListApiService.CouponReceiveResposne) mallKntrReceiveCoupon$product_details_page_debug;
                            showToast$product_details_page_debug(response2.getMessage());
                            return Boxing.boxBoolean(true);
                        } catch (Exception e2) {
                            e = e2;
                            message = e.getMessage();
                            if (message == null) {
                            }
                            showToast$product_details_page_debug(message);
                            return Boxing.boxBoolean(false);
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        pageViewModel$getCoupon$1 = new PageViewModel$getCoupon$1(this, continuation);
        Object $result2 = pageViewModel$getCoupon$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (pageViewModel$getCoupon$1.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object loadFeedBlast$product_details_page_debug(int pageNum, Continuation<? super FeedsModel> continuation) {
        PageViewModel$loadFeedBlast$1 pageViewModel$loadFeedBlast$1;
        Object kntrLoadFeedBlast$product_details_page_debug;
        if (continuation instanceof PageViewModel$loadFeedBlast$1) {
            pageViewModel$loadFeedBlast$1 = (PageViewModel$loadFeedBlast$1) continuation;
            if ((pageViewModel$loadFeedBlast$1.label & Integer.MIN_VALUE) != 0) {
                pageViewModel$loadFeedBlast$1.label -= Integer.MIN_VALUE;
                Object $result = pageViewModel$loadFeedBlast$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (pageViewModel$loadFeedBlast$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        FeedBlastApiService feedBlastApiService = FeedBlastApiService.INSTANCE;
                        Integer boxInt = Boxing.boxInt(pageNum);
                        String str = this.itemsId;
                        pageViewModel$loadFeedBlast$1.I$0 = pageNum;
                        pageViewModel$loadFeedBlast$1.label = 1;
                        kntrLoadFeedBlast$product_details_page_debug = feedBlastApiService.kntrLoadFeedBlast$product_details_page_debug(boxInt, str, pageViewModel$loadFeedBlast$1);
                        if (kntrLoadFeedBlast$product_details_page_debug == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        int pageNum2 = pageViewModel$loadFeedBlast$1.I$0;
                        ResultKt.throwOnFailure($result);
                        kntrLoadFeedBlast$product_details_page_debug = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                FeedsModel model = (FeedsModel) kntrLoadFeedBlast$product_details_page_debug;
                return model;
            }
        }
        pageViewModel$loadFeedBlast$1 = new PageViewModel$loadFeedBlast$1(this, continuation);
        Object $result2 = pageViewModel$loadFeedBlast$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (pageViewModel$loadFeedBlast$1.label) {
        }
        FeedsModel model2 = (FeedsModel) kntrLoadFeedBlast$product_details_page_debug;
        return model2;
    }

    public static /* synthetic */ Object addRemindSuspend$product_details_page_debug$default(PageViewModel pageViewModel, CalendarRemindModel calendarRemindModel, String str, String str2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        return pageViewModel.addRemindSuspend$product_details_page_debug(calendarRemindModel, str, str2, continuation);
    }

    public final Object addRemindSuspend$product_details_page_debug(CalendarRemindModel calendarModel, String successMsg, String failMsg, Continuation<? super Boolean> continuation) {
        CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuation cont = cancellableContinuationImpl;
        Pair[] pairArr = new Pair[6];
        String name = calendarModel.getName();
        if (name == null) {
            name = "";
        }
        pairArr[0] = TuplesKt.to("title", name);
        String jumpUrl = calendarModel.getJumpUrl();
        if (jumpUrl == null) {
            jumpUrl = "";
        }
        pairArr[1] = TuplesKt.to("url", jumpUrl);
        Long saleStartTime = calendarModel.getSaleStartTime();
        pairArr[2] = TuplesKt.to("startAt", Boxing.boxLong(saleStartTime != null ? saleStartTime.longValue() : 0L));
        Long saleEndTime = calendarModel.getSaleEndTime();
        pairArr[3] = TuplesKt.to("endAt", Boxing.boxLong(saleEndTime != null ? saleEndTime.longValue() : 0L));
        pairArr[4] = TuplesKt.to("successMsg", successMsg == null ? "" : successMsg);
        pairArr[5] = TuplesKt.to("failMsg", failMsg != null ? failMsg : "");
        Map data = MapsKt.mapOf(pairArr);
        this.bridgeCall.invoke("addRemind", data, new Function1<Map<String, ? extends Object>, Unit>() { // from class: kntr.app.mall.product.details.page.vm.PageViewModel$addRemindSuspend$2$1
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                invoke((Map) p1);
                return Unit.INSTANCE;
            }

            public final void invoke(Map<String, ? extends Object> map) {
                Intrinsics.checkNotNullParameter(map, "result");
                Object obj = map.get("code");
                Integer num = obj instanceof Integer ? (Integer) obj : null;
                int code = num != null ? num.intValue() : -1;
                boolean success = code == 0;
                Result.Companion companion = Result.Companion;
                cont.resumeWith(Result.m2636constructorimpl(Boolean.valueOf(success)));
                KLog_androidKt.getKLog().i("addRemindSuspend", "Result: " + map);
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public final void handleJumpUrl$product_details_page_debug(String url) {
        String str = url;
        if (str == null || str.length() == 0) {
            return;
        }
        this.actionHandler.pushTo$product_details_page_debug(url);
    }

    public final void handleHeaderSkuClick$product_details_page_debug() {
        showSkuFloatingLayer$product_details_page_debug();
    }

    public final void handleVideoDetail$product_details_page_debug(Long itemId, Long courseId, Long lessonId, Long sectionId) {
        this.actionHandler.handleVideoDetail$product_details_page_debug(itemId, courseId, lessonId, sectionId);
    }

    public final void handleLabelObjectClick$product_details_page_debug(LabelObject labelObject) {
        Intrinsics.checkNotNullParameter(labelObject, "labelObject");
        Integer actionType = labelObject.getActionType();
        if (actionType != null && actionType.intValue() == 1) {
            String it = labelObject.getTargetUrl();
            if (it != null) {
                handleJumpUrl$product_details_page_debug(it);
            }
        } else if (actionType != null && actionType.intValue() == 2) {
            String it2 = labelObject.getTargetUrl();
            if (it2 != null) {
                bridgeShowHalfWebView$product_details_page_debug(it2);
            }
        } else if (actionType != null && actionType.intValue() == 3) {
            String imageUrl = labelObject.getShowImgUrl();
            Double imageWidth = labelObject.getShowImgUrlWidth();
            Double imageHeight = labelObject.getShowImgUrlHeight();
            showImageBottomSheet$product_details_page_debug(imageUrl, imageWidth, imageHeight);
        } else if (actionType == null) {
            KLog_androidKt.getKLog().i("PageViewModel", "Label object action type is null");
        } else {
            KLog_androidKt.getKLog().e("PageViewModel", "Unknown label object action type: " + actionType);
        }
    }

    public final void reportLoadFinished(boolean isFirst) {
        int i;
        boolean hasMoreSku;
        LabelObject labelObject;
        ProductDetailsResponse.ProductDetailsData data;
        BasicInfoFloor basicInfoFloorVO;
        Boolean couponReceiveAble;
        ProductDetailsResponse.ProductDetailsData data2;
        BasicInfoFloor basicInfoFloorVO2;
        Boolean reserveAble;
        ProductDetailsResponse.ProductDetailsData data3;
        BasicInfoFloor basicInfoFloorVO3;
        Integer itemsStatus;
        ProductDetailsResponse.ProductDetailsData data4;
        BasicInfoFloor basicInfoFloorVO4;
        ProductDetailsResponse.ProductDetailsData data5;
        DeliveryInfoFloor deliveryInfoFloorVO;
        DeliveryInfoFloor.ItemsDeliveryInfo itemsDeliveryInfo;
        ProductDetailsResponse.ProductDetailsData data6;
        SkuInfoFloor skuInfoFloorVO;
        SkuInfoFloor.ItemsSkuListVO itemsSkuListVO;
        List<SkuInfoFloor.ItemsSkuListVO.ItemsSkuListItem> itemsSkuList;
        ProductDetailsResponse.ProductDetailsData data7;
        BasicInfoFloor basicInfoFloorVO5;
        if (!isFirst) {
            return;
        }
        ProductDetailsResponse productDetailsResponse = (ProductDetailsResponse) this.productDetailsResponse.getValue();
        boolean hasVideo = (productDetailsResponse == null || (data7 = productDetailsResponse.getData()) == null || (basicInfoFloorVO5 = data7.getBasicInfoFloorVO()) == null) ? false : basicInfoFloorVO5.hasVideo$product_details_page_debug();
        ProductDetailsResponse productDetailsResponse2 = (ProductDetailsResponse) this.productDetailsResponse.getValue();
        if (productDetailsResponse2 != null && (data6 = productDetailsResponse2.getData()) != null && (skuInfoFloorVO = data6.getSkuInfoFloorVO()) != null && (itemsSkuListVO = skuInfoFloorVO.getItemsSkuListVO()) != null && (itemsSkuList = itemsSkuListVO.getItemsSkuList()) != null) {
            i = itemsSkuList.size();
        } else {
            i = 0;
        }
        if (i <= 1) {
            hasMoreSku = false;
        } else {
            hasMoreSku = true;
        }
        List $this$reportLoadFinished_u24lambda_u240 = CollectionsKt.createListBuilder();
        ProductDetailsResponse productDetailsResponse3 = (ProductDetailsResponse) this.productDetailsResponse.getValue();
        if ((productDetailsResponse3 == null || (data5 = productDetailsResponse3.getData()) == null || (deliveryInfoFloorVO = data5.getDeliveryInfoFloorVO()) == null || (itemsDeliveryInfo = deliveryInfoFloorVO.getItemsDeliveryInfo()) == null) ? false : Intrinsics.areEqual(itemsDeliveryInfo.getFreeDelivery(), true)) {
            $this$reportLoadFinished_u24lambda_u240.add("free-shipping");
        }
        ProductDetailsResponse productDetailsResponse4 = (ProductDetailsResponse) this.productDetailsResponse.getValue();
        if (productDetailsResponse4 == null || (data4 = productDetailsResponse4.getData()) == null || (basicInfoFloorVO4 = data4.getBasicInfoFloorVO()) == null) {
            labelObject = null;
        } else {
            labelObject = basicInfoFloorVO4.getServiceRightTag();
        }
        if (labelObject != null) {
            $this$reportLoadFinished_u24lambda_u240.add("carriage-insurance");
        }
        String serviceRightsString = CollectionsKt.joinToString$default(CollectionsKt.build($this$reportLoadFinished_u24lambda_u240), ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        Pair[] pairArr = new Pair[8];
        ProductDetailsResponse productDetailsResponse5 = (ProductDetailsResponse) this.productDetailsResponse.getValue();
        pairArr[0] = TuplesKt.to("itemsStatus", String.valueOf((productDetailsResponse5 == null || (data3 = productDetailsResponse5.getData()) == null || (basicInfoFloorVO3 = data3.getBasicInfoFloorVO()) == null || (itemsStatus = basicInfoFloorVO3.getItemsStatus()) == null) ? 0 : itemsStatus.intValue()));
        ProductDetailsResponse productDetailsResponse6 = (ProductDetailsResponse) this.productDetailsResponse.getValue();
        pairArr[1] = TuplesKt.to("reserveAble", String.valueOf((productDetailsResponse6 == null || (data2 = productDetailsResponse6.getData()) == null || (basicInfoFloorVO2 = data2.getBasicInfoFloorVO()) == null || (reserveAble = basicInfoFloorVO2.getReserveAble()) == null) ? false : reserveAble.booleanValue()));
        ProductDetailsResponse productDetailsResponse7 = (ProductDetailsResponse) this.productDetailsResponse.getValue();
        pairArr[2] = TuplesKt.to("couponReceiveAble", String.valueOf((productDetailsResponse7 == null || (data = productDetailsResponse7.getData()) == null || (basicInfoFloorVO = data.getBasicInfoFloorVO()) == null || (couponReceiveAble = basicInfoFloorVO.getCouponReceiveAble()) == null) ? false : couponReceiveAble.booleanValue()));
        pairArr[3] = TuplesKt.to("service_rights", serviceRightsString);
        pairArr[4] = TuplesKt.to("type", hasVideo ? "2" : "1");
        pairArr[5] = TuplesKt.to("sku_type", hasMoreSku ? "2" : "1");
        pairArr[6] = TuplesKt.to("showSku", hasMoreSku ? "1" : "0");
        Object obj = this.is_ad;
        if (obj == null) {
            obj = false;
        }
        pairArr[7] = TuplesKt.to("is_ad", obj.toString());
        Map extra = MapsKt.mapOf(pairArr);
        PageActionHandler.trackEvent$product_details_page_debug$default(this.actionHandler, TrackConsts.MALL_MALL_DETAIL_MALL_DETAIL_SHOW_0_SHOW, extra, false, false, 8, null);
    }

    public final void reportUpCouponSheetShow$product_details_page_debug() {
        Iterable validCouponInfoList;
        ProductDetailsResponse.ProductDetailsData data;
        Integer cmcContentType;
        ProductDetailsResponse productDetailsResponse = (ProductDetailsResponse) this._productDetailsResponse.getValue();
        String str = null;
        String cmcContentType2 = (productDetailsResponse == null || (data = productDetailsResponse.getData()) == null || (cmcContentType = data.getCmcContentType()) == null) ? null : String.valueOf(cmcContentType.intValue());
        if (cmcContentType2 == null) {
            cmcContentType2 = "";
        }
        ProductDetailsPageUpCouponDisplayModel productDetailsPageUpCouponDisplayModel = (ProductDetailsPageUpCouponDisplayModel) this.mUpCouponAutoFetchDisplayStateFlow.getValue();
        if (productDetailsPageUpCouponDisplayModel != null && (validCouponInfoList = productDetailsPageUpCouponDisplayModel.getValidCouponInfoList()) != null) {
            Iterable $this$mapNotNull$iv = validCouponInfoList;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                CouponInfoModel it = (CouponInfoModel) element$iv$iv$iv;
                String sourceAuthorityId = it.getSourceAuthorityId();
                if (sourceAuthorityId != null) {
                    destination$iv$iv.add(sourceAuthorityId);
                }
            }
            str = CollectionsKt.joinToString$default((List) destination$iv$iv, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        }
        String couponIds = str != null ? str : "";
        PageActionHandler.trackEvent$product_details_page_debug$default(this.actionHandler, TrackConsts.MALL_UP_COUPON_COUPON_0_SHOW, MapsKt.mapOf(new Pair[]{TuplesKt.to("coupon_id", couponIds), TuplesKt.to("channels", cmcContentType2)}), false, false, 8, null);
    }

    public final void showToast$product_details_page_debug(String toast) {
        Intrinsics.checkNotNullParameter(toast, "toast");
        this.valueBridge.invoke("showToast", MapsKt.mapOf(TuplesKt.to("toast", toast)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:119:0x007d, code lost:
        if (r6 == null) goto L66;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void handleShare() {
        ActionIconModel actionIconModel;
        String templateId;
        Long mid;
        String imageUrl;
        ContentModule.HeaderModule data;
        HeaderFloor data2;
        List<ActionIconModel> header;
        Object obj;
        ActionIconModel it;
        if (this.isProcessingShare) {
            return;
        }
        this.isProcessingShare = true;
        TopContainerState topContainerState = (TopContainerState) this.mTopContainerState.getValue();
        if (topContainerState == null || (data = topContainerState.getData()) == null || (data2 = data.getData()) == null || (header = data2.getHeader()) == null) {
            actionIconModel = null;
        } else {
            Iterator<T> it2 = header.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it2.next();
                ActionIconModel it3 = (ActionIconModel) obj;
                Integer type = it3.getType();
                if (type != null && type.intValue() == 3) {
                    it = 1;
                    continue;
                } else {
                    it = null;
                    continue;
                }
                if (it != null) {
                    break;
                }
            }
            actionIconModel = (ActionIconModel) obj;
        }
        ActionIconModel shareHeader = actionIconModel;
        ShareExtra shareExtra = shareHeader != null ? shareHeader.getShareExtra() : null;
        if (shareHeader != null && (templateId = shareHeader.getShareTemplateId()) != null) {
            if (!(templateId.length() > 0)) {
                templateId = null;
            }
        }
        templateId = "merchantShare";
        Pair[] pairArr = new Pair[6];
        String str = "";
        pairArr[0] = TuplesKt.to("title", (shareExtra == null || (r9 = shareExtra.getTitle()) == null) ? "" : "");
        pairArr[1] = TuplesKt.to("url", (shareExtra == null || (r3 = shareExtra.getUrl()) == null) ? "" : "");
        pairArr[2] = TuplesKt.to("text", (shareExtra == null || (r0 = shareExtra.getText()) == null) ? "" : "");
        pairArr[3] = TuplesKt.to("type", "");
        if (shareExtra != null && (imageUrl = shareExtra.getImageUrl()) != null) {
            str = imageUrl;
        }
        pairArr[4] = TuplesKt.to("imageUrl", str);
        pairArr[5] = TuplesKt.to("mid", String.valueOf((shareExtra == null || (mid = shareExtra.getMid()) == null) ? 0L : mid.longValue()));
        Map extParams = MapsKt.mapOf(pairArr);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new PageViewModel$handleShare$1(templateId, this, extParams, null), 3, (Object) null);
    }

    private final void handleReserve() {
        ProductDetailsResponse.ProductDetailsData productDetailsData;
        String str;
        FooterFloor.ActionInfoVO actionInfoVO;
        ProductDetailsResponse productDetailsResponse = (ProductDetailsResponse) this._productDetailsResponse.getValue();
        if (productDetailsResponse == null || (productDetailsData = productDetailsResponse.getData()) == null) {
            return;
        }
        Integer autoOnSaleTime = productDetailsData.getAutoOnSaleTime();
        String itemsId = this.itemsId;
        String trackId = this.track_id;
        FooterFloor footerFloorVO = productDetailsData.getFooterFloorVO();
        FooterFloor.ReserveCouponInfo reserveCouponInfo = (footerFloorVO == null || (actionInfoVO = footerFloorVO.getActionInfoVO()) == null) ? null : actionInfoVO.getReserveCouponInfo();
        String sourceId = (reserveCouponInfo == null || (r2 = reserveCouponInfo.getSourceId()) == null) ? "" : "";
        String sourceAuthorityId = (reserveCouponInfo == null || (r2 = reserveCouponInfo.getSourceAuthorityId()) == null) ? "" : "";
        String activityId = (reserveCouponInfo == null || (r2 = reserveCouponInfo.getSourceActivityId()) == null) ? "" : "";
        Pair[] pairArr = new Pair[7];
        Pair[] pairArr2 = new Pair[4];
        pairArr2[0] = TuplesKt.to("build", "");
        pairArr2[1] = TuplesKt.to("info", KAppInfo.INSTANCE.getMobiApp());
        switch (WhenMappings.$EnumSwitchMapping$0[KDevice.INSTANCE.getDeviceType().ordinal()]) {
            case 1:
                str = "ios";
                break;
            case 2:
                str = "android";
                break;
            case 3:
                str = "harmonyos";
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        pairArr2[2] = TuplesKt.to("platform", str);
        pairArr2[3] = TuplesKt.to("ua", "");
        pairArr[0] = TuplesKt.to("deviceInfo", MapsKt.mapOf(pairArr2));
        pairArr[1] = TuplesKt.to("deviceId", KDevice.INSTANCE.getBuvid());
        pairArr[2] = TuplesKt.to("sourceId", sourceId);
        pairArr[3] = TuplesKt.to("sourceAuthorityId", sourceAuthorityId);
        pairArr[4] = TuplesKt.to("sourceActivityId", activityId);
        pairArr[5] = TuplesKt.to("needDeviceCheck", false);
        pairArr[6] = TuplesKt.to("sourceBizId", Long.valueOf(DateFormatKt.getCurrentTimeMillis()));
        Map receiveCouponCmd = MapsKt.mapOf(pairArr);
        Pair[] pairArr3 = new Pair[7];
        pairArr3[0] = TuplesKt.to("voteType", 1);
        pairArr3[1] = TuplesKt.to("subjectId", itemsId);
        pairArr3[2] = TuplesKt.to("onSaleTime", autoOnSaleTime);
        pairArr3[3] = TuplesKt.to("subjectType", 18);
        pairArr3[4] = TuplesKt.to("trackId", trackId);
        BasicInfoFloor basicInfoFloorVO = productDetailsData.getBasicInfoFloorVO();
        pairArr3[5] = TuplesKt.to("shopId", basicInfoFloorVO != null ? basicInfoFloorVO.getShopId() : null);
        pairArr3[6] = TuplesKt.to("channels", 1);
        Map reserveReq = MapsKt.mapOf(pairArr3);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new PageViewModel$handleReserve$1(itemsId, reserveReq, receiveCouponCmd, this, null), 3, (Object) null);
    }

    private final List<ContentModule> mapResponseToContentModules(ProductDetailsResponse response, CommentInfoApiService.CommentInfoResponse commentResponse, ProductShopApiService.ProductShopDetailsResponse shopResponse) {
        List keys;
        Iterable $this$forEach$iv;
        boolean z;
        Iterator it;
        ProductShopApiService.ProductShopDetailsResponse.ProductShopDetailsData it2;
        CountDownInfoVO countDownInfoVO;
        MergeAtmospherePriceFloor.MergePriceInfo.RightVO rightVO;
        MergeAtmospherePriceFloor.MergePriceInfo.RightVO.RightBottomVO rightBottomVO;
        if (response.getData() == null) {
            return CollectionsKt.emptyList();
        }
        List modules = new ArrayList();
        List keys2 = response.getData().getFloorKeys();
        if (keys2 != null) {
            List $this$forEach$iv2 = keys2;
            boolean z2 = false;
            Iterator it3 = $this$forEach$iv2.iterator();
            while (it3.hasNext()) {
                Object element$iv = it3.next();
                String key = (String) element$iv;
                if (Intrinsics.areEqual(key, FloorType.BASIC_INFO.getKey())) {
                    BasicInfoFloor it4 = response.getData().getBasicInfoFloorVO();
                    if (it4 != null) {
                        modules.add(new ContentModule.BasicInfoModule(it4));
                    }
                    keys = keys2;
                    $this$forEach$iv = $this$forEach$iv2;
                    z = z2;
                    it = it3;
                } else if (Intrinsics.areEqual(key, FloorType.ATMOSPHERE_PRICE.getKey())) {
                    AtmospherePriceFloor atmosphereFloor = response.getData().getAtmospherePriceFloorVO();
                    if (atmosphereFloor == null) {
                        keys = keys2;
                        $this$forEach$iv = $this$forEach$iv2;
                        z = z2;
                        it = it3;
                    } else {
                        modules.add(new ContentModule.AtmospherePriceModule(atmosphereFloor));
                        ActAtmosphereVO atmosphereVO = atmosphereFloor.getActAtmosphereVO();
                        boolean isShowCountDown = atmosphereVO != null ? Intrinsics.areEqual(atmosphereVO.getShowCountDown(), true) : false;
                        Long serverTime = atmosphereVO != null ? atmosphereVO.getServerTime() : null;
                        Long endTime = atmosphereVO != null ? atmosphereVO.getAtmosEndTime() : null;
                        if (!isShowCountDown || serverTime == null) {
                            keys = keys2;
                            z = z2;
                            it = it3;
                            $this$forEach$iv = $this$forEach$iv2;
                        } else {
                            keys = keys2;
                            if (endTime == null || serverTime.longValue() < endTime.longValue()) {
                                $this$forEach$iv = $this$forEach$iv2;
                                z = z2;
                                it = it3;
                            } else {
                                $this$forEach$iv = $this$forEach$iv2;
                                z = z2;
                                it = it3;
                                KLog_androidKt.getKLog().e("manlu", "检测到氛围倒计时结束，serverTime: " + serverTime + ", endTime: " + endTime + "，准备重新请求接口");
                                BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new PageViewModel$mapResponseToContentModules$1$2$1(this, null), 3, (Object) null);
                            }
                        }
                    }
                } else {
                    keys = keys2;
                    $this$forEach$iv = $this$forEach$iv2;
                    z = z2;
                    it = it3;
                    if (Intrinsics.areEqual(key, FloorType.MERGE_ATMOSPHERE_PRICE.getKey())) {
                        MergeAtmospherePriceFloor mergeFloor = response.getData().getMergeAtmospherePriceFloorVO();
                        if (mergeFloor != null) {
                            modules.add(new ContentModule.MergeAtmospherePriceModule(mergeFloor));
                            MergeAtmospherePriceFloor.MergePriceInfo mergePriceInfoVO = mergeFloor.getMergePriceInfoVO();
                            if (mergePriceInfoVO == null || (rightVO = mergePriceInfoVO.getRightVO()) == null || (rightBottomVO = rightVO.getRightBottomVO()) == null) {
                                countDownInfoVO = null;
                            } else {
                                countDownInfoVO = rightBottomVO.getCountDownInfoVO();
                            }
                            boolean isShowCountDown2 = countDownInfoVO != null ? Intrinsics.areEqual(countDownInfoVO.getShowCountDown(), true) : false;
                            Long leftTime = countDownInfoVO != null ? countDownInfoVO.getLeftTime() : null;
                            if (isShowCountDown2 && leftTime != null && leftTime.longValue() <= 0) {
                                KLog_androidKt.getKLog().e("manlu", "检测到倒计时结束，leftTime: " + leftTime + "，准备重新请求接口");
                                BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new PageViewModel$mapResponseToContentModules$1$3$1(this, null), 3, (Object) null);
                            }
                        }
                    } else if (Intrinsics.areEqual(key, FloorType.COUPON_INFO.getKey())) {
                        CouponInfoFloor it5 = response.getData().getCouponInfoFloorVO();
                        if (it5 != null) {
                            modules.add(new ContentModule.CouponInfoModule(it5));
                        }
                    } else if (Intrinsics.areEqual(key, FloorType.ACTIVITY_INFO.getKey())) {
                        ActivityInfoFloor it6 = response.getData().getActivityInfoFloorVO();
                        if (it6 != null) {
                            modules.add(new ContentModule.ActivityInfoModule(it6));
                        }
                    } else if (Intrinsics.areEqual(key, FloorType.ADV_STATE.getKey())) {
                        AdvStateFloor it7 = response.getData().getAdvStateFloorVO();
                        if (it7 != null) {
                            modules.add(new ContentModule.AdvStateModule(it7));
                        }
                    } else if (Intrinsics.areEqual(key, FloorType.ATTR.getKey())) {
                        AttrFloor it8 = response.getData().getAttrFloorVO();
                        if (it8 != null) {
                            modules.add(new ContentModule.AttrModule(it8));
                        }
                    } else if (Intrinsics.areEqual(key, FloorType.COMMENT.getKey())) {
                        CommentInfoApiService.CommentInfoResponse.CommentInfoData commentApiData = commentResponse != null ? commentResponse.getData() : null;
                        CommentFloor productApiData = response.getData().getCommentFloorVO();
                        ContentModule.CommentModule module = new ContentModule.CommentModule(commentApiData, productApiData);
                        if (module.shouldAddCommentModule$product_details_page_debug()) {
                            modules.add(module);
                        }
                    } else if (Intrinsics.areEqual(key, FloorType.SHOP.getKey())) {
                        if (shopResponse != null && (it2 = shopResponse.getData()) != null) {
                            modules.add(new ContentModule.ShopModule(it2));
                        }
                    } else if (Intrinsics.areEqual(key, FloorType.SHOP_INFO.getKey())) {
                        ShopInfoFloor it9 = response.getData().getShopInfoFloorVO();
                        if (it9 != null) {
                            modules.add(new ContentModule.ShopInfoModule(it9));
                        }
                    } else if (Intrinsics.areEqual(key, FloorType.DELIVERY_INFO.getKey())) {
                        DeliveryInfoFloor it10 = response.getData().getDeliveryInfoFloorVO();
                        if (it10 != null) {
                            modules.add(new ContentModule.DeliveryInfoModule(it10));
                        }
                    } else if (Intrinsics.areEqual(key, FloorType.SERVICE.getKey())) {
                        ServiceFloor it11 = response.getData().getServiceFloorVO();
                        if (it11 != null) {
                            modules.add(new ContentModule.ServiceModule(it11));
                        }
                    } else if (Intrinsics.areEqual(key, FloorType.SKU_INFO.getKey())) {
                        SkuInfoFloor it12 = response.getData().getSkuInfoFloorVO();
                        if (it12 != null) {
                            modules.add(new ContentModule.SkuInfoModule(it12));
                        }
                    } else if (Intrinsics.areEqual(key, FloorType.FILE_INFO.getKey())) {
                        FileInfoFloor it13 = response.getData().getFileInfoFloorVO();
                        if (it13 != null) {
                            modules.add(new ContentModule.FileInfoModule(it13));
                        }
                    } else if (Intrinsics.areEqual(key, FloorType.COURSE_INFO.getKey())) {
                        CourseInfoFloor it14 = response.getData().getCourseInfoFloorVO();
                        if (it14 != null) {
                            modules.add(new ContentModule.CourseInfoModule(it14));
                        }
                    } else if (Intrinsics.areEqual(key, FloorType.DETAIL_DESC.getKey())) {
                        DetailDescFloor it15 = response.getData().getDetailDescFloorVO();
                        if (it15 != null) {
                            modules.add(new ContentModule.DetailDescModule(it15));
                        }
                    } else if (Intrinsics.areEqual(key, FloorType.SERVICE_DESC.getKey())) {
                        ServiceDescFloor it16 = response.getData().getServiceDescFloorVO();
                        if (it16 != null) {
                            modules.add(new ContentModule.ServiceDescModule(it16));
                        }
                    } else if (Intrinsics.areEqual(key, FloorType.IP_BRAND.getKey())) {
                        IpBrandFloor it17 = response.getData().getIpBrandFloorVO();
                        if (it17 != null) {
                            modules.add(new ContentModule.IpBrandModule(it17));
                        }
                    } else if (Intrinsics.areEqual(key, FloorType.SERIES.getKey())) {
                        SeriesFloor it18 = response.getData().getSeriesFloorVO();
                        if (it18 != null) {
                            modules.add(new ContentModule.SeriesModule(it18));
                        }
                    } else if (Intrinsics.areEqual(key, FloorType.REC.getKey())) {
                        RecFloor it19 = response.getData().getRecFloorVO();
                        if (it19 != null) {
                            modules.add(new ContentModule.RecModule(it19));
                        }
                    } else if (Intrinsics.areEqual(key, FloorType.CROWDFUNDING_ATMOSPHERE.getKey())) {
                        CrowdfundingAtmosFloor it20 = response.getData().getCrowdfundingAtmosFloorVO();
                        if (it20 != null) {
                            modules.add(new ContentModule.CrowdfundingAtmosModule(it20));
                        }
                    } else if (Intrinsics.areEqual(key, FloorType.CROWDFUNDING_PROGRESS.getKey())) {
                        CrowdfundingProgressFloor it21 = response.getData().getCrowdfundingProgressFloorVO();
                        if (it21 != null) {
                            modules.add(new ContentModule.CrowdfundingProgressModule(it21));
                        }
                    } else if (Intrinsics.areEqual(key, FloorType.CROWDFUNDING_STAIRS.getKey())) {
                        CrowdfundingStairsFloor it22 = response.getData().getCrowdfundingStairsFloorVO();
                        if (it22 != null) {
                            modules.add(new ContentModule.CrowdfundingStairsModule(it22));
                        }
                    } else {
                        KLog_androidKt.getKLog().i("PageViewModel", "Unknown floor type: " + key);
                    }
                }
                $this$forEach$iv2 = $this$forEach$iv;
                keys2 = keys;
                z2 = z;
                it3 = it;
            }
        }
        return CollectionsKt.toList(modules);
    }

    private final void updateDeliveryContainer(ProductDetailsResponse response) {
        Object prevValue$iv;
        Object nextValue$iv;
        ProductDetailsResponse.ProductDetailsData data = response.getData();
        if ((data != null ? data.getDeliveryInfoFloorVO() : null) == null) {
            return;
        }
        MutableStateFlow $this$update$iv = this.mDeliveryInfoContainerState;
        do {
            prevValue$iv = $this$update$iv.getValue();
            DeliveryInfoContainerState deliveryInfoContainerState = (DeliveryInfoContainerState) prevValue$iv;
            nextValue$iv = new DeliveryInfoContainerState(new ContentModule.DeliveryInfoModule(response.getData().getDeliveryInfoFloorVO()));
        } while (!$this$update$iv.compareAndSet(prevValue$iv, nextValue$iv));
    }

    private final void updateTopContainer(ProductDetailsResponse response) {
        Object prevValue$iv;
        Object nextValue$iv;
        ProductDetailsResponse.ProductDetailsData data = response.getData();
        if ((data != null ? data.getHeaderFloorVO() : null) == null) {
            return;
        }
        MutableStateFlow $this$update$iv = this.mTopContainerState;
        do {
            prevValue$iv = $this$update$iv.getValue();
            TopContainerState topContainerState = (TopContainerState) prevValue$iv;
            nextValue$iv = new TopContainerState(new ContentModule.HeaderModule(response.getData().getHeaderFloorVO()));
        } while (!$this$update$iv.compareAndSet(prevValue$iv, nextValue$iv));
    }

    static /* synthetic */ void updateBannerContainer$default(PageViewModel pageViewModel, ProductDetailsResponse productDetailsResponse, IPFeedRecommendV2ApiService.Response response, int i, Object obj) {
        if ((i & 2) != 0) {
            response = null;
        }
        pageViewModel.updateBannerContainer(productDetailsResponse, response);
    }

    /* JADX WARN: Removed duplicated region for block: B:154:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x022b A[LOOP:0: B:213:0x01b6->B:233:0x022b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:235:0x01f2 A[EDGE_INSN: B:235:0x01f2->B:222:0x01f2 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updateBannerContainer(ProductDetailsResponse response, IPFeedRecommendV2ApiService.Response ipFeedRecommendResponse) {
        BasicInfoFloor basicInfoFloor;
        List imageList;
        int currentIndex;
        Integer num;
        Integer num2;
        int currentIndex2;
        Integer valueOf;
        Integer num3;
        Integer num4;
        int it;
        Integer num5;
        Integer num6;
        Integer num7;
        Integer num8;
        List topTabItems;
        int i;
        MutableStateFlow $this$update$iv;
        Object prevValue$iv;
        PagerState previousState;
        int preservedPage;
        MutableStateFlow $this$update$iv2;
        Object prevValue$iv2;
        PagerState previousState2;
        int preservedPage2;
        String title;
        String specName;
        ProductDetailsResponse.ProductDetailsData data = response.getData();
        if (data == null || (basicInfoFloor = data.getBasicInfoFloorVO()) == null || (imageList = basicInfoFloor.getImageList()) == null) {
            return;
        }
        int imageCount = imageList.size();
        SkuInfoFloor skuInfoFloor = response.getData().getSkuInfoFloorVO();
        CommentInfoApiService.CommentInfoResponse commentInfoResponse = (CommentInfoApiService.CommentInfoResponse) this._commentApiResponse.getValue();
        CommentInfoApiService.CommentInfoResponse.CommentInfoData commentInfoFloor = commentInfoResponse != null ? commentInfoResponse.getData() : null;
        IPFeedRecommendV2ApiService.RecommendData ipFeedRecommendModel = ipFeedRecommendResponse != null ? ipFeedRecommendResponse.getData() : null;
        if ((Boolean.valueOf(basicInfoFloor.hasVideo$product_details_page_debug()).booleanValue() ? basicInfoFloor : null) == null) {
            currentIndex = 0;
            num = null;
        } else {
            currentIndex = 0 + 1;
            num = 0;
        }
        this.bannerVideoIndex = num;
        this.bannerImagesStartIndex = Integer.valueOf(currentIndex);
        int currentIndex3 = currentIndex + imageCount;
        if (skuInfoFloor != null) {
            if ((Boolean.valueOf(skuInfoFloor.shouldShowHeaderSku$product_details_page_debug()).booleanValue() ? skuInfoFloor : null) != null) {
                num2 = Integer.valueOf(currentIndex3);
                currentIndex3++;
                this.bannerSkuIndex = num2;
                this.bannerSkuName = skuInfoFloor == null ? skuInfoFloor.getFirstSpecName$product_details_page_debug() : null;
                if (!getUseUpSay()) {
                    if (!(commentInfoFloor != null && commentInfoFloor.shouldShowHeaderComment$product_details_page_debug())) {
                        currentIndex2 = currentIndex3;
                        valueOf = null;
                        this.bannerCommentOrUpSayIndex = valueOf;
                        if (ipFeedRecommendModel != null) {
                            IPFeedRecommendV2ApiService.RecommendData it2 = ipFeedRecommendModel;
                            if ((Boolean.valueOf(shouldShowIpFeedRecommend$product_details_page_debug(it2)).booleanValue() ? ipFeedRecommendModel : null) != null) {
                                int i2 = currentIndex2 + 1;
                                num3 = Integer.valueOf(currentIndex2);
                                this.bannerIpFeedRecommendIndex = num3;
                                num4 = this.bannerVideoIndex;
                                if (num4 == null) {
                                    num4.intValue();
                                    it = 1;
                                } else {
                                    it = 0;
                                }
                                this.bannerFirstItemCount = Integer.valueOf(it + imageCount);
                                List $this$updateBannerContainer_u24lambda_u247 = CollectionsKt.createListBuilder();
                                num5 = this.bannerFirstItemCount;
                                if (num5 != null) {
                                    int itemKey = num5.intValue();
                                    $this$updateBannerContainer_u24lambda_u247.add(createTabItem("商品", itemKey - 1, new PageViewModel$updateBannerContainer$topTabItems$1$1$1(this, null)));
                                }
                                num6 = this.bannerSkuIndex;
                                if (num6 == null) {
                                    int index = num6.intValue();
                                    if (skuInfoFloor != null && (specName = skuInfoFloor.getFirstSpecName$product_details_page_debug()) != null) {
                                        $this$updateBannerContainer_u24lambda_u247.add(createTabItem(specName, index, new PageViewModel$updateBannerContainer$topTabItems$1$2$1$1(this, index, null)));
                                    }
                                }
                                num7 = this.bannerCommentOrUpSayIndex;
                                if (num7 != null) {
                                    int index2 = num7.intValue();
                                    if (getUseUpSay()) {
                                        title = "UP说";
                                    } else {
                                        title = "晒图";
                                    }
                                    $this$updateBannerContainer_u24lambda_u247.add(createTabItem(title, index2, new PageViewModel$updateBannerContainer$topTabItems$1$3$1(this, index2, null)));
                                }
                                num8 = this.bannerIpFeedRecommendIndex;
                                if (num8 != null) {
                                    int index3 = num8.intValue();
                                    $this$updateBannerContainer_u24lambda_u247.add(createTabItem("推荐", index3, new PageViewModel$updateBannerContainer$topTabItems$1$4$1(this, index3, null)));
                                }
                                topTabItems = CollectionsKt.build($this$updateBannerContainer_u24lambda_u247);
                                this.fullscreenTopTabItems = topTabItems;
                                if (!getUseUpSay() && this.bannerCommentOrUpSayIndex != null) {
                                    Integer num9 = this.bannerCommentOrUpSayIndex;
                                    i = num9 != null ? num9.intValue() : 0;
                                } else {
                                    i = 0;
                                }
                                int initialPage = i;
                                $this$update$iv = this._bannerPagerState;
                                while (true) {
                                    prevValue$iv = $this$update$iv.getValue();
                                    previousState = (PagerState) prevValue$iv;
                                    if (previousState == null) {
                                        preservedPage = previousState.getCurrentPage();
                                        if (preservedPage >= getHeaderPageCount$product_details_page_debug()) {
                                            preservedPage = getHeaderPageCount$product_details_page_debug() - 1;
                                        }
                                    } else {
                                        preservedPage = initialPage;
                                    }
                                    List topTabItems2 = topTabItems;
                                    List imageList2 = imageList;
                                    int imageCount2 = imageCount;
                                    if (!$this$update$iv.compareAndSet(prevValue$iv, PagerStateKt.PagerState$default(preservedPage, 0.0f, new Function0() { // from class: kntr.app.mall.product.details.page.vm.PageViewModel$$ExternalSyntheticLambda4
                                        public final Object invoke() {
                                            int headerPageCount$product_details_page_debug;
                                            headerPageCount$product_details_page_debug = PageViewModel.this.getHeaderPageCount$product_details_page_debug();
                                            return Integer.valueOf(headerPageCount$product_details_page_debug);
                                        }
                                    }, 2, (Object) null))) {
                                        break;
                                    }
                                    topTabItems = topTabItems2;
                                    imageList = imageList2;
                                    imageCount = imageCount2;
                                }
                                $this$update$iv2 = this._bannerPreviewPagerState;
                                do {
                                    prevValue$iv2 = $this$update$iv2.getValue();
                                    previousState2 = (PagerState) prevValue$iv2;
                                    if (previousState2 == null) {
                                        preservedPage2 = previousState2.getCurrentPage();
                                        if (preservedPage2 >= getHeaderPageCount$product_details_page_debug()) {
                                            preservedPage2 = getHeaderPageCount$product_details_page_debug() - 1;
                                        }
                                    } else {
                                        preservedPage2 = initialPage;
                                    }
                                } while (!$this$update$iv2.compareAndSet(prevValue$iv2, PagerStateKt.PagerState$default(preservedPage2, 0.0f, new Function0() { // from class: kntr.app.mall.product.details.page.vm.PageViewModel$$ExternalSyntheticLambda5
                                    public final Object invoke() {
                                        int headerPageCount$product_details_page_debug;
                                        headerPageCount$product_details_page_debug = PageViewModel.this.getHeaderPageCount$product_details_page_debug();
                                        return Integer.valueOf(headerPageCount$product_details_page_debug);
                                    }
                                }, 2, (Object) null)));
                            }
                        }
                        num3 = null;
                        this.bannerIpFeedRecommendIndex = num3;
                        num4 = this.bannerVideoIndex;
                        if (num4 == null) {
                        }
                        this.bannerFirstItemCount = Integer.valueOf(it + imageCount);
                        List $this$updateBannerContainer_u24lambda_u2472 = CollectionsKt.createListBuilder();
                        num5 = this.bannerFirstItemCount;
                        if (num5 != null) {
                        }
                        num6 = this.bannerSkuIndex;
                        if (num6 == null) {
                        }
                        num7 = this.bannerCommentOrUpSayIndex;
                        if (num7 != null) {
                        }
                        num8 = this.bannerIpFeedRecommendIndex;
                        if (num8 != null) {
                        }
                        topTabItems = CollectionsKt.build($this$updateBannerContainer_u24lambda_u2472);
                        this.fullscreenTopTabItems = topTabItems;
                        if (!getUseUpSay()) {
                        }
                        i = 0;
                        int initialPage2 = i;
                        $this$update$iv = this._bannerPagerState;
                        while (true) {
                            prevValue$iv = $this$update$iv.getValue();
                            previousState = (PagerState) prevValue$iv;
                            if (previousState == null) {
                            }
                            List topTabItems22 = topTabItems;
                            List imageList22 = imageList;
                            int imageCount22 = imageCount;
                            if (!$this$update$iv.compareAndSet(prevValue$iv, PagerStateKt.PagerState$default(preservedPage, 0.0f, new Function0() { // from class: kntr.app.mall.product.details.page.vm.PageViewModel$$ExternalSyntheticLambda4
                                public final Object invoke() {
                                    int headerPageCount$product_details_page_debug;
                                    headerPageCount$product_details_page_debug = PageViewModel.this.getHeaderPageCount$product_details_page_debug();
                                    return Integer.valueOf(headerPageCount$product_details_page_debug);
                                }
                            }, 2, (Object) null))) {
                            }
                            topTabItems = topTabItems22;
                            imageList = imageList22;
                            imageCount = imageCount22;
                        }
                        $this$update$iv2 = this._bannerPreviewPagerState;
                        do {
                            prevValue$iv2 = $this$update$iv2.getValue();
                            previousState2 = (PagerState) prevValue$iv2;
                            if (previousState2 == null) {
                            }
                        } while (!$this$update$iv2.compareAndSet(prevValue$iv2, PagerStateKt.PagerState$default(preservedPage2, 0.0f, new Function0() { // from class: kntr.app.mall.product.details.page.vm.PageViewModel$$ExternalSyntheticLambda5
                            public final Object invoke() {
                                int headerPageCount$product_details_page_debug;
                                headerPageCount$product_details_page_debug = PageViewModel.this.getHeaderPageCount$product_details_page_debug();
                                return Integer.valueOf(headerPageCount$product_details_page_debug);
                            }
                        }, 2, (Object) null)));
                    }
                }
                currentIndex2 = currentIndex3 + 1;
                valueOf = Integer.valueOf(currentIndex3);
                this.bannerCommentOrUpSayIndex = valueOf;
                if (ipFeedRecommendModel != null) {
                }
                num3 = null;
                this.bannerIpFeedRecommendIndex = num3;
                num4 = this.bannerVideoIndex;
                if (num4 == null) {
                }
                this.bannerFirstItemCount = Integer.valueOf(it + imageCount);
                List $this$updateBannerContainer_u24lambda_u24722 = CollectionsKt.createListBuilder();
                num5 = this.bannerFirstItemCount;
                if (num5 != null) {
                }
                num6 = this.bannerSkuIndex;
                if (num6 == null) {
                }
                num7 = this.bannerCommentOrUpSayIndex;
                if (num7 != null) {
                }
                num8 = this.bannerIpFeedRecommendIndex;
                if (num8 != null) {
                }
                topTabItems = CollectionsKt.build($this$updateBannerContainer_u24lambda_u24722);
                this.fullscreenTopTabItems = topTabItems;
                if (!getUseUpSay()) {
                }
                i = 0;
                int initialPage22 = i;
                $this$update$iv = this._bannerPagerState;
                while (true) {
                    prevValue$iv = $this$update$iv.getValue();
                    previousState = (PagerState) prevValue$iv;
                    if (previousState == null) {
                    }
                    List topTabItems222 = topTabItems;
                    List imageList222 = imageList;
                    int imageCount222 = imageCount;
                    if (!$this$update$iv.compareAndSet(prevValue$iv, PagerStateKt.PagerState$default(preservedPage, 0.0f, new Function0() { // from class: kntr.app.mall.product.details.page.vm.PageViewModel$$ExternalSyntheticLambda4
                        public final Object invoke() {
                            int headerPageCount$product_details_page_debug;
                            headerPageCount$product_details_page_debug = PageViewModel.this.getHeaderPageCount$product_details_page_debug();
                            return Integer.valueOf(headerPageCount$product_details_page_debug);
                        }
                    }, 2, (Object) null))) {
                    }
                    topTabItems = topTabItems222;
                    imageList = imageList222;
                    imageCount = imageCount222;
                }
                $this$update$iv2 = this._bannerPreviewPagerState;
                do {
                    prevValue$iv2 = $this$update$iv2.getValue();
                    previousState2 = (PagerState) prevValue$iv2;
                    if (previousState2 == null) {
                    }
                } while (!$this$update$iv2.compareAndSet(prevValue$iv2, PagerStateKt.PagerState$default(preservedPage2, 0.0f, new Function0() { // from class: kntr.app.mall.product.details.page.vm.PageViewModel$$ExternalSyntheticLambda5
                    public final Object invoke() {
                        int headerPageCount$product_details_page_debug;
                        headerPageCount$product_details_page_debug = PageViewModel.this.getHeaderPageCount$product_details_page_debug();
                        return Integer.valueOf(headerPageCount$product_details_page_debug);
                    }
                }, 2, (Object) null)));
            }
        }
        num2 = null;
        this.bannerSkuIndex = num2;
        this.bannerSkuName = skuInfoFloor == null ? skuInfoFloor.getFirstSpecName$product_details_page_debug() : null;
        if (!getUseUpSay()) {
        }
        currentIndex2 = currentIndex3 + 1;
        valueOf = Integer.valueOf(currentIndex3);
        this.bannerCommentOrUpSayIndex = valueOf;
        if (ipFeedRecommendModel != null) {
        }
        num3 = null;
        this.bannerIpFeedRecommendIndex = num3;
        num4 = this.bannerVideoIndex;
        if (num4 == null) {
        }
        this.bannerFirstItemCount = Integer.valueOf(it + imageCount);
        List $this$updateBannerContainer_u24lambda_u247222 = CollectionsKt.createListBuilder();
        num5 = this.bannerFirstItemCount;
        if (num5 != null) {
        }
        num6 = this.bannerSkuIndex;
        if (num6 == null) {
        }
        num7 = this.bannerCommentOrUpSayIndex;
        if (num7 != null) {
        }
        num8 = this.bannerIpFeedRecommendIndex;
        if (num8 != null) {
        }
        topTabItems = CollectionsKt.build($this$updateBannerContainer_u24lambda_u247222);
        this.fullscreenTopTabItems = topTabItems;
        if (!getUseUpSay()) {
        }
        i = 0;
        int initialPage222 = i;
        $this$update$iv = this._bannerPagerState;
        while (true) {
            prevValue$iv = $this$update$iv.getValue();
            previousState = (PagerState) prevValue$iv;
            if (previousState == null) {
            }
            List topTabItems2222 = topTabItems;
            List imageList2222 = imageList;
            int imageCount2222 = imageCount;
            if (!$this$update$iv.compareAndSet(prevValue$iv, PagerStateKt.PagerState$default(preservedPage, 0.0f, new Function0() { // from class: kntr.app.mall.product.details.page.vm.PageViewModel$$ExternalSyntheticLambda4
                public final Object invoke() {
                    int headerPageCount$product_details_page_debug;
                    headerPageCount$product_details_page_debug = PageViewModel.this.getHeaderPageCount$product_details_page_debug();
                    return Integer.valueOf(headerPageCount$product_details_page_debug);
                }
            }, 2, (Object) null))) {
            }
            topTabItems = topTabItems2222;
            imageList = imageList2222;
            imageCount = imageCount2222;
        }
        $this$update$iv2 = this._bannerPreviewPagerState;
        do {
            prevValue$iv2 = $this$update$iv2.getValue();
            previousState2 = (PagerState) prevValue$iv2;
            if (previousState2 == null) {
            }
        } while (!$this$update$iv2.compareAndSet(prevValue$iv2, PagerStateKt.PagerState$default(preservedPage2, 0.0f, new Function0() { // from class: kntr.app.mall.product.details.page.vm.PageViewModel$$ExternalSyntheticLambda5
            public final Object invoke() {
                int headerPageCount$product_details_page_debug;
                headerPageCount$product_details_page_debug = PageViewModel.this.getHeaderPageCount$product_details_page_debug();
                return Integer.valueOf(headerPageCount$product_details_page_debug);
            }
        }, 2, (Object) null)));
    }

    private final void updateFileInfoByProductDetailsResponse() {
        Object prevValue$iv;
        SkuInfoFloor.ItemsSkuListVO.ItemsSkuListItem it;
        Object prevValue$iv2;
        FileInfoFloor.FileInfo it2;
        ProductDetailsResponse.ProductDetailsData data;
        SkuInfoFloor.ItemsSkuListVO itemsSkuListVO;
        List<SkuInfoFloor.ItemsSkuListVO.ItemsSkuListItem> itemsSkuList;
        ProductDetailsResponse.ProductDetailsData data2;
        ProductDetailsResponse productDetailsResponse = (ProductDetailsResponse) this._productDetailsResponse.getValue();
        SkuInfoFloor skuInfoFloor = (productDetailsResponse == null || (data2 = productDetailsResponse.getData()) == null) ? null : data2.getSkuInfoFloorVO();
        MutableStateFlow $this$update$iv = this._fileInfoSelectedSku;
        do {
            prevValue$iv = $this$update$iv.getValue();
            SkuInfoFloor.ItemsSkuListVO.ItemsSkuListItem itemsSkuListItem = (SkuInfoFloor.ItemsSkuListVO.ItemsSkuListItem) prevValue$iv;
            it = (skuInfoFloor == null || (itemsSkuListVO = skuInfoFloor.getItemsSkuListVO()) == null || (itemsSkuList = itemsSkuListVO.getItemsSkuList()) == null) ? null : (SkuInfoFloor.ItemsSkuListVO.ItemsSkuListItem) CollectionsKt.firstOrNull(itemsSkuList);
        } while (!$this$update$iv.compareAndSet(prevValue$iv, it));
        ProductDetailsResponse productDetailsResponse2 = (ProductDetailsResponse) this._productDetailsResponse.getValue();
        FileInfoFloor fileInfoFloor = (productDetailsResponse2 == null || (data = productDetailsResponse2.getData()) == null) ? null : data.getFileInfoFloorVO();
        MutableStateFlow $this$update$iv2 = this._fileInfo;
        do {
            prevValue$iv2 = $this$update$iv2.getValue();
            FileInfoFloor.FileInfo fileInfo = (FileInfoFloor.FileInfo) prevValue$iv2;
            it2 = fileInfoFloor != null ? fileInfoFloor.getFileInfoVOs() : null;
        } while (!$this$update$iv2.compareAndSet(prevValue$iv2, it2));
    }

    private final TopTabItem createTabItem(String title, int itemKey, Function1<? super Continuation<? super Unit>, ? extends Object> function1) {
        return new PageViewModel$createTabItem$1(itemKey, title, this, function1);
    }

    private final void updateBottomContainer(ProductDetailsResponse response) {
        Object prevValue$iv;
        Object nextValue$iv;
        ProductDetailsResponse.ProductDetailsData data = response.getData();
        if ((data != null ? data.getFooterFloorVO() : null) == null) {
            return;
        }
        FooterFloor footerFloor = response.getData().getFooterFloorVO();
        FooterFloor.PurchaseButton purchaseButton = footerFloor.getPurchaseButton();
        CountDownInfoVO countDownInfo = purchaseButton != null ? purchaseButton.getButtonSubCountDownInfo() : null;
        boolean isShowCountDown = countDownInfo != null ? Intrinsics.areEqual(countDownInfo.getShowCountDown(), true) : false;
        Long leftTime = countDownInfo != null ? countDownInfo.getLeftTime() : null;
        if (isShowCountDown && leftTime != null && leftTime.longValue() <= 0) {
            KLog_androidKt.getKLog().e("manlu", "检测到底部按钮倒计时结束，leftTime: " + leftTime + "，准备重新请求接口");
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new PageViewModel$updateBottomContainer$1(this, null), 3, (Object) null);
        }
        MutableStateFlow $this$update$iv = this.mBottomContainerState;
        do {
            prevValue$iv = $this$update$iv.getValue();
            BottomContainerState bottomContainerState = (BottomContainerState) prevValue$iv;
            nextValue$iv = new BottomContainerState(new ContentModule.FooterModule(footerFloor));
        } while (!$this$update$iv.compareAndSet(prevValue$iv, nextValue$iv));
    }

    public final void clearFeedBlast$product_details_page_debug() {
        Object prevValue$iv;
        List it;
        Object prevValue$iv2;
        MutableStateFlow $this$update$iv = this.mFeedBlastState;
        do {
            prevValue$iv = $this$update$iv.getValue();
            List list = (List) prevValue$iv;
            it = CollectionsKt.emptyList();
        } while (!$this$update$iv.compareAndSet(prevValue$iv, it));
        MutableStateFlow $this$update$iv2 = this.mLastFeedBlastData;
        do {
            prevValue$iv2 = $this$update$iv2.getValue();
            FeedsModel feedsModel = (FeedsModel) prevValue$iv2;
        } while (!$this$update$iv2.compareAndSet(prevValue$iv2, (Object) null));
    }

    public final void addMoreFeedBlast$product_details_page_debug(FeedsModel response, int pageNum) {
        Collection destination$iv$iv;
        Object prevValue$iv;
        List newList;
        Object prevValue$iv2;
        Iterable itemList;
        Intrinsics.checkNotNullParameter(response, "response");
        RecommendVO vo = response.getVo();
        if (vo == null || (itemList = vo.getItemList()) == null) {
            destination$iv$iv = null;
        } else {
            Iterable $this$map$iv = itemList;
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                MallRecommendItem it = (MallRecommendItem) item$iv$iv;
                it.setPageNum(Integer.valueOf(pageNum));
                destination$iv$iv2.add(it);
            }
            destination$iv$iv = (List) destination$iv$iv2;
        }
        Collection newData = destination$iv$iv;
        MutableStateFlow $this$update$iv = this.mFeedBlastState;
        do {
            prevValue$iv = $this$update$iv.getValue();
            List oldFeedBlast = (List) prevValue$iv;
            newList = CollectionsKt.toMutableList(oldFeedBlast);
            if (newData != null) {
                newList.addAll(newData);
            }
        } while (!$this$update$iv.compareAndSet(prevValue$iv, newList));
        MutableStateFlow $this$update$iv2 = this.mLastFeedBlastData;
        do {
            prevValue$iv2 = $this$update$iv2.getValue();
            FeedsModel feedsModel = (FeedsModel) prevValue$iv2;
        } while (!$this$update$iv2.compareAndSet(prevValue$iv2, response));
    }

    public final boolean shouldShowIpFeedRecommend$product_details_page_debug() {
        IPFeedRecommendV2ApiService.Response response = (IPFeedRecommendV2ApiService.Response) this.ipFeedRecommendFlow.getValue();
        return shouldShowIpFeedRecommend$product_details_page_debug(response != null ? response.getData() : null);
    }

    public final boolean shouldShowIpFeedRecommend$product_details_page_debug(IPFeedRecommendV2ApiService.RecommendData ipFeedRecommendModel) {
        if (ipFeedRecommendModel == null) {
            return false;
        }
        List list = ipItemsFeed$product_details_page_debug(ipFeedRecommendModel);
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        return list.size() > 3;
    }

    public final List<ShopItem> ipItemsFeed$product_details_page_debug(IPFeedRecommendV2ApiService.RecommendData ipFeedRecommendModel) {
        Iterable list;
        if (ipFeedRecommendModel == null || (list = ipFeedRecommendModel.getList()) == null) {
            return null;
        }
        Iterable $this$filter$iv = list;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            ShopItem shopItem = (ShopItem) element$iv$iv;
            String str = this.itemsId;
            Long itemsId = shopItem.getItemsId();
            if (!Intrinsics.areEqual(str, itemsId != null ? String.valueOf(itemsId.longValue()) : null)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return (List) destination$iv$iv;
    }

    public final boolean showTopTabCommentItem$product_details_page_debug() {
        Object obj;
        List commentList;
        CommentFloor productApiData;
        Long totalCount;
        ContentModule it;
        Iterator it2 = ((Iterable) this.contentModules.getValue()).iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            ContentModule it3 = (ContentModule) obj;
            if (it3.getFloorType() == FloorType.COMMENT) {
                it = 1;
                continue;
            } else {
                it = null;
                continue;
            }
            if (it != null) {
                break;
            }
        }
        ContentModule.CommentModule commentModule = (ContentModule.CommentModule) obj;
        CommentInfoApiService.CommentInfoResponse.CommentInfoData commentData = commentModule != null ? commentModule.getCommentApiData() : null;
        long commentCount = (commentData == null || (totalCount = commentData.getTotalCount()) == null) ? 0L : totalCount.longValue();
        if (commentData == null || (commentList = commentData.getCombinedCommentList$product_details_page_debug()) == null) {
            commentList = CollectionsKt.emptyList();
        }
        if (commentCount > 0 || !commentList.isEmpty()) {
            return true;
        }
        return (commentModule == null || (productApiData = commentModule.getProductApiData()) == null) ? false : Intrinsics.areEqual(productApiData.getShowPreBuyComment(), true);
    }

    public final boolean showTopTabFeedBlastItem$product_details_page_debug() {
        List feedBlastState = (List) this.mFeedBlastState.getValue();
        return !feedBlastState.isEmpty();
    }

    public final boolean showTopTabDetailItem$product_details_page_debug() {
        boolean z;
        Object obj;
        ContentModule it;
        Iterator it2 = ((Iterable) this.contentModules.getValue()).iterator();
        while (true) {
            z = false;
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            ContentModule it3 = (ContentModule) obj;
            if (it3.getFloorType() == FloorType.DETAIL_DESC) {
                it = 1;
                continue;
            } else {
                it = null;
                continue;
            }
            if (it != null) {
                break;
            }
        }
        ContentModule detailModule = (ContentModule) obj;
        ContentModule.DetailDescModule detailDescModule = (ContentModule.DetailDescModule) detailModule;
        DetailDescFloor detailData = detailDescModule != null ? detailDescModule.getData() : null;
        List<DetailDescFloor.Content> contents = detailData != null ? detailData.getContents() : null;
        if (contents == null || contents.isEmpty()) {
            z = true;
        }
        boolean showDetail = !z;
        return showDetail;
    }

    private final Map<FloorType, ModuleViewModel> generateModuleViewModels(List<? extends ContentModule> list) {
        Map viewModels = new LinkedHashMap();
        List<? extends ContentModule> $this$forEach$iv = list;
        for (Object element$iv : $this$forEach$iv) {
            ContentModule module = (ContentModule) element$iv;
            ModuleViewModel viewModel = ModuleViewModelFactory.INSTANCE.createModuleViewModel$product_details_page_debug(module);
            if (viewModel != null) {
                viewModels.put(module.getFloorType(), viewModel);
            }
        }
        return MapsKt.toMap(viewModels);
    }

    protected void onCleared() {
        Job job = this.hideWishLayerJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.hideWishLayerJob = null;
        super.onCleared();
        KLog_androidKt.getKLog().i("PageViewModel", "onCleared");
    }

    private final void handleAutoFetchedCoupons() {
        CouponPackageInfoModel couponPackageInfoModel;
        Object prevValue$iv;
        Object nextValue$iv;
        CouponPackageInfoModel.CouponPackagePopInfoModel.UserInfo relatedUpInfo;
        Object obj;
        CouponPackageInfoModel it;
        ProductDetailsResponse.ProductDetailsData data;
        FooterFloor footerFloorVO;
        ProductDetailsResponse productDetailsResponse = (ProductDetailsResponse) this._productDetailsResponse.getValue();
        List couponPackageInfos = (productDetailsResponse == null || (data = productDetailsResponse.getData()) == null || (footerFloorVO = data.getFooterFloorVO()) == null) ? null : footerFloorVO.getCouponPackageInfos();
        if (couponPackageInfos != null) {
            Iterator<T> it2 = couponPackageInfos.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it2.next();
                Byte showCouponType = ((CouponPackageInfoModel) obj).getShowCouponType();
                if (showCouponType == null || showCouponType.byteValue() != 10) {
                    it = null;
                    continue;
                } else {
                    it = 1;
                    continue;
                }
                if (it != null) {
                    break;
                }
            }
            couponPackageInfoModel = (CouponPackageInfoModel) obj;
        } else {
            couponPackageInfoModel = null;
        }
        CouponPackageInfoModel upCouponPackageInfo = couponPackageInfoModel;
        if (upCouponPackageInfo != null) {
            CouponPackageInfoModel.CouponPackagePopInfoModel packagePopInfoVO = upCouponPackageInfo.getPackagePopInfoVO();
            Long upId = (packagePopInfoVO == null || (relatedUpInfo = packagePopInfoVO.getRelatedUpInfo()) == null) ? null : relatedUpInfo.getMid();
            Long longOrNull = StringsKt.toLongOrNull(getAutoFetchedUpCouponPopupDisplayTS$product_details_page_debug(upId));
            long lastShowTS = longOrNull != null ? longOrNull.longValue() : 0L;
            long currentTS = DateFormatKt.getCurrentTimeMillis();
            int dayInterval = DateFormatKt.dayInterval$default(lastShowTS, currentTS, null, 4, null);
            int i = 2;
            if (Intrinsics.areEqual(upCouponPackageInfo.getReceived(), true) && Intrinsics.areEqual(upCouponPackageInfo.getPopup(), true) && dayInterval >= 1) {
                MutableStateFlow $this$update$iv = this.mUpCouponAutoFetchDisplayStateFlow;
                do {
                    prevValue$iv = $this$update$iv.getValue();
                    ProductDetailsPageUpCouponDisplayModel productDetailsPageUpCouponDisplayModel = (ProductDetailsPageUpCouponDisplayModel) prevValue$iv;
                    nextValue$iv = new ProductDetailsPageUpCouponDisplayModel(upCouponPackageInfo.getPackagePopInfoVO(), (List) null, 2, (DefaultConstructorMarker) null);
                } while (!$this$update$iv.compareAndSet(prevValue$iv, nextValue$iv));
            } else if (Intrinsics.areEqual(upCouponPackageInfo.getAutoReceive(), true)) {
                CouponPackageInfoModel.CouponPackagePopInfoModel packagePopInfoVO2 = upCouponPackageInfo.getPackagePopInfoVO();
                Iterable couponInfoList = packagePopInfoVO2 != null ? packagePopInfoVO2.getCouponInfoList() : null;
                List<CouponInfoModel> list = (Collection) couponInfoList;
                if (list == null || list.isEmpty()) {
                    return;
                }
                Iterable $this$map$iv = couponInfoList;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    CouponInfoModel it3 = (CouponInfoModel) item$iv$iv;
                    Pair[] pairArr = new Pair[i];
                    pairArr[0] = TuplesKt.to("sourceId", it3.getSourceId());
                    pairArr[1] = TuplesKt.to("sourceAuthorityId", it3.getSourceAuthorityId());
                    destination$iv$iv.add(MapsKt.mapOf(pairArr));
                    $this$map$iv = $this$map$iv;
                    i = 2;
                }
                List sourceInfos = (List) destination$iv$iv;
                BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new PageViewModel$handleAutoFetchedCoupons$2(upCouponPackageInfo, sourceInfos, dayInterval, this, null), 3, (Object) null);
            }
        }
    }

    public final String getAutoFetchedUpCouponPopupDisplayTS$product_details_page_debug(Long upId) {
        String lastShowTS;
        Long currentUserId = UserInfoKt.getUserId();
        return (currentUserId == null || currentUserId.longValue() == 0 || (lastShowTS = getSp().getString(new StringBuilder().append("LAST_UP_COUPON_POPUP_DISPLAY_TS_").append(currentUserId).append("_").append(upId).toString(), "0")) == null) ? "0" : lastShowTS;
    }

    public final void markAutoFetchedUpCouponPopupDisplayed$product_details_page_debug(Long upId) {
        Long currentUserId = UserInfoKt.getUserId();
        if (currentUserId == null || currentUserId.longValue() == 0) {
            return;
        }
        long currentTS = DateFormatKt.getCurrentTimeMillis();
        getSp().setString("LAST_UP_COUPON_POPUP_DISPLAY_TS_" + currentUserId + "_" + upId, String.valueOf(currentTS));
    }
}