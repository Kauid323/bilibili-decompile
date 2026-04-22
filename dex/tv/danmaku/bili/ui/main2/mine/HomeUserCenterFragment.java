package tv.danmaku.bili.ui.main2.mine;

import ComposableSingletons$CustomBottomSheetKt$;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDelegateImpl$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.widget.PopupWindowCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import bili.resource.common.R;
import com.alibaba.fastjson.JSONObject;
import com.bapis.bilibili.dagw.component.avatar.v1.LayerTagConfig;
import com.bilibili.adcommon.utils.ext.ViewExtKt;
import com.bilibili.app.authorspace.SpaceRouter;
import com.bilibili.app.comm.list.avatarcommon.changeavatar.AvatarChooser;
import com.bilibili.app.comm.list.avatarcommon.changeavatar.AvatarUploader;
import com.bilibili.app.comm.list.common.avatar.AvatarUtils;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.app.comm.restrict.RestrictedMode;
import com.bilibili.app.comm.restrict.RestrictedType;
import com.bilibili.app.comm.vipconfig.VipThemeConfigManager;
import com.bilibili.app.comm.vipconfig.VipThemeInfo;
import com.bilibili.app.provider.UtilKt;
import com.bilibili.base.BiliContext;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.baseres.LevelImageUtilV2;
import com.bilibili.boxing.Boxing;
import com.bilibili.boxing.model.entity.impl.ImageMedia;
import com.bilibili.compose.image.BiliImageKt;
import com.bilibili.compose.image.BiliImageState;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import com.bilibili.droid.ActivityUtils;
import com.bilibili.droid.ScreenUtil;
import com.bilibili.droid.ToastHelper;
import com.bilibili.droid.WindowManagerHelper;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.exposer.ExposeClient;
import com.bilibili.exposer.ListExposer;
import com.bilibili.exposer.child.RecyclerViewItemConvert;
import com.bilibili.kaptbundle.BuildConfig;
import com.bilibili.lib.accountinfo.model.OfficialVerify;
import com.bilibili.lib.accountinfo.model.VipUserInfo;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.accounts.subscribe.PassportObserver;
import com.bilibili.lib.accounts.subscribe.Topic;
import com.bilibili.lib.avatar.AvatarShowParam;
import com.bilibili.lib.avatar.NFTInfo;
import com.bilibili.lib.avatar.ZoomingType;
import com.bilibili.lib.avatar.layers.AvatarLayer;
import com.bilibili.lib.avatar.layers.LayerAvatarView;
import com.bilibili.lib.avatar.layers.model.AvatarItem;
import com.bilibili.lib.avatar.layers.model.layers.ConfigKey;
import com.bilibili.lib.avatar.layers.plugin.AvatarPluginPainter;
import com.bilibili.lib.avatar.layers.plugin.IAvatarPluginFactory;
import com.bilibili.lib.avatar.layers.plugin.PluginBuilderKey;
import com.bilibili.lib.badge.Badge;
import com.bilibili.lib.badge.BadgeManager;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blconfig.Contract;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteInterceptor;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.blrouter.RouteRequestKt;
import com.bilibili.lib.blrouter.RouteResponse;
import com.bilibili.lib.blrouter.ServicesProvider;
import com.bilibili.lib.homepage.badge.IBadgeServer;
import com.bilibili.lib.homepage.mine.MenuGroup;
import com.bilibili.lib.homepage.mine.MenuItemTip;
import com.bilibili.lib.homepage.startdust.IPageFragment;
import com.bilibili.lib.homepage.startdust.OnPageSelectChangeListener;
import com.bilibili.lib.homepage.startdust.PageReSelectedParams;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.DrawableAcquireRequestBuilder;
import com.bilibili.lib.image2.ImageRequestBuilder;
import com.bilibili.lib.image2.bean.AnimationListener;
import com.bilibili.lib.image2.bean.BiliAnimatable;
import com.bilibili.lib.image2.bean.BiliAnimatedDrawable;
import com.bilibili.lib.image2.bean.ImageDataSource;
import com.bilibili.lib.image2.bean.ImageInfo;
import com.bilibili.lib.image2.bean.ImageLoadingListener;
import com.bilibili.lib.image2.bean.ImageTintableCallback;
import com.bilibili.lib.image2.bean.ScaleType;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.projection.ProjectionClient;
import com.bilibili.lib.projection.ProjectionClientConfig;
import com.bilibili.lib.projection.ProjectionService;
import com.bilibili.lib.projection.helper.ProjectionOperationConfigHelper;
import com.bilibili.lib.projection.internal.utils.ProjectionClientUtilsKt;
import com.bilibili.lib.projection.internal.widget.PopupGuideBubble;
import com.bilibili.lib.ui.BaseFragment;
import com.bilibili.lib.ui.IDrawerHost;
import com.bilibili.lib.ui.garb.Garb;
import com.bilibili.lib.ui.garb.GarbManager;
import com.bilibili.lib.ui.garb.GarbWatcher;
import com.bilibili.lib.ui.mixin.Flag;
import com.bilibili.lib.ui.mixin.IFragmentShowHide;
import com.bilibili.lib.ui.mixin.IFragmentShowHideKt;
import com.bilibili.lib.ui.theme.ThemeWatcher;
import com.bilibili.lib.ui.util.MultipleThemeUtils;
import com.bilibili.lib.ui.util.StatusBarCompat;
import com.bilibili.magicasakura.widgets.TintImageView;
import com.bilibili.magicasakura.widgets.TintProgressDialog;
import com.bilibili.magicasakura.widgets.Tintable;
import com.bilibili.moduleservice.main.MainCommonService;
import com.bilibili.moduleservice.main.RelationService;
import com.bilibili.playset.MultiTypeListDetailActivityKt;
import com.bilibili.playset.PlaySetErrorHelper;
import com.bilibili.pvtracker.IPvTracker;
import com.bilibili.pvtracker.PageViewTracker;
import com.bilibili.teenagersmode.TeenagersMode;
import com.bilibili.xpref.Xpref;
import com.google.accompanist.drawablepainter.DrawablePainterKt;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.concurrent.CancellationException;
import kntr.base.localization.NumberFormat_androidKt;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.MainActivityV2;
import tv.danmaku.bili.appwidget.hotlist.model.HotListDataPacker;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;
import tv.danmaku.bili.core.test.FdDebugActivity;
import tv.danmaku.bili.databinding.BiliLayoutMineVipModuleRefactoringBinding;
import tv.danmaku.bili.inner.InnerLoginFragmentKt;
import tv.danmaku.bili.qrcode.QrCodeHelper;
import tv.danmaku.bili.quick.core.OnePassLoginReportManagerKt;
import tv.danmaku.bili.router.MainRouteUris;
import tv.danmaku.bili.ui.DisplayUtils;
import tv.danmaku.bili.ui.IntentHelper;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.login.LoginReporterV2;
import tv.danmaku.bili.ui.loginv2.LoginOriginalActivityV2;
import tv.danmaku.bili.ui.main2.AccountMineInfoManager;
import tv.danmaku.bili.ui.main2.AccountMineRequestResource;
import tv.danmaku.bili.ui.main2.ILoginDispatcher;
import tv.danmaku.bili.ui.main2.ILoginDispatcherKt;
import tv.danmaku.bili.ui.main2.api.AccountMine;
import tv.danmaku.bili.ui.main2.mine.HomeUserCenterAction;
import tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment;
import tv.danmaku.bili.ui.main2.mine.fansachievement.FansAchievementHelper;
import tv.danmaku.bili.ui.main2.mine.holder.MineNotUpperModuleHolder;
import tv.danmaku.bili.ui.main2.mine.modularvip.MineVipModuleManager;
import tv.danmaku.bili.ui.main2.mine.modularvip.MineVipServiceKt;
import tv.danmaku.bili.ui.main2.mine.widgets.ChameleonAnswerView;
import tv.danmaku.bili.ui.main2.mine.widgets.MineAvatarDrawPlugin;
import tv.danmaku.bili.ui.main2.mine.widgets.MineAvatarFrameLayout;
import tv.danmaku.bili.ui.main2.mine.widgets.MineGlobalLinkEntranceView;
import tv.danmaku.bili.ui.main2.mine.widgets.MultipleThemeImageView;
import tv.danmaku.bili.ui.main2.mine.widgets.MultipleThemeTextView;
import tv.danmaku.bili.ui.main2.mine.widgets.NickNameTextView;
import tv.danmaku.bili.ui.main2.reporter.MineReporter;
import tv.danmaku.bili.ui.main2.reporter.NavigationReporter;
import tv.danmaku.bili.ui.main2.resource.DefaultResourceResolver;
import tv.danmaku.bili.ui.main2.userprotocol.UserProtocolHelper;
import tv.danmaku.bili.ui.notice.NoticeExtKt;
import tv.danmaku.bili.ui.notice.api.BiliNotice;
import tv.danmaku.bili.utils.NavigationFragmentAnimatorHelper;
import tv.danmaku.bili.widget.swiperefresh.TintSwipeRefreshLayout;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: HomeUserCenterFragment.kt */
@Metadata(d1 = {"\u0000Æ\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 ð\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t:\bí\u0002î\u0002ï\u0002ð\u0002B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010¹\u0001\u001a\u00030º\u00012\n\u0010»\u0001\u001a\u0005\u0018\u00010¼\u0001H\u0016J,\u0010½\u0001\u001a\u0004\u0018\u00010\u00182\b\u0010¾\u0001\u001a\u00030¿\u00012\t\u0010À\u0001\u001a\u0004\u0018\u00010\u00112\n\u0010»\u0001\u001a\u0005\u0018\u00010¼\u0001H\u0016J\u0015\u0010Á\u0001\u001a\u00030º\u00012\t\b\u0002\u0010Â\u0001\u001a\u00020$H\u0002J\n\u0010Ã\u0001\u001a\u00030º\u0001H\u0002J\u001e\u0010Ä\u0001\u001a\u00030º\u00012\u0007\u0010Å\u0001\u001a\u00020$2\t\b\u0002\u0010Â\u0001\u001a\u00020$H\u0002J\n\u0010Æ\u0001\u001a\u00030º\u0001H\u0002J\t\u0010Ç\u0001\u001a\u00020$H\u0002J\n\u0010È\u0001\u001a\u00030º\u0001H\u0002J\n\u0010É\u0001\u001a\u00030º\u0001H\u0002J\n\u0010Ê\u0001\u001a\u00030º\u0001H\u0002J\n\u0010Ë\u0001\u001a\u00030º\u0001H\u0002J\n\u0010Ì\u0001\u001a\u00030º\u0001H\u0002J\n\u0010Í\u0001\u001a\u00030º\u0001H\u0002J\n\u0010Î\u0001\u001a\u00030º\u0001H\u0002J\u0016\u0010Ï\u0001\u001a\u00030º\u00012\n\u0010Ð\u0001\u001a\u0005\u0018\u00010Ñ\u0001H\u0002J\n\u0010Ò\u0001\u001a\u00030º\u0001H\u0002J\u001f\u0010Ó\u0001\u001a\u00030º\u00012\u0007\u0010Ô\u0001\u001a\u00020\u00182\n\u0010»\u0001\u001a\u0005\u0018\u00010¼\u0001H\u0016J\u0016\u0010Õ\u0001\u001a\u00030º\u00012\n\u0010»\u0001\u001a\u0005\u0018\u00010¼\u0001H\u0016J\n\u0010Ö\u0001\u001a\u00030º\u0001H\u0016J\n\u0010×\u0001\u001a\u00030º\u0001H\u0016J\n\u0010Ø\u0001\u001a\u00030º\u0001H\u0016J\n\u0010Ù\u0001\u001a\u00030º\u0001H\u0016J\n\u0010Ú\u0001\u001a\u00030º\u0001H\u0016J\n\u0010Û\u0001\u001a\u00030º\u0001H\u0002J \u0010Ü\u0001\u001a\u00030º\u00012\t\u0010Ý\u0001\u001a\u0004\u0018\u00010h2\t\b\u0002\u0010Þ\u0001\u001a\u00020$H\u0002J\u001e\u0010ß\u0001\u001a\u00030º\u00012\t\u0010Ý\u0001\u001a\u0004\u0018\u00010h2\u0007\u0010à\u0001\u001a\u00020$H\u0002J\n\u0010á\u0001\u001a\u00030º\u0001H\u0002J\n\u0010â\u0001\u001a\u00030º\u0001H\u0002J\u0015\u0010ã\u0001\u001a\n\u0012\u0005\u0012\u00030º\u00010ä\u0001*\u00020|H\u0002J\u0015\u0010å\u0001\u001a\u00030º\u00012\t\u0010Ý\u0001\u001a\u0004\u0018\u00010hH\u0002J\u0015\u0010æ\u0001\u001a\u00030º\u00012\t\u0010Ý\u0001\u001a\u0004\u0018\u00010hH\u0002J\u0015\u0010ç\u0001\u001a\u00030º\u00012\t\u0010Ý\u0001\u001a\u0004\u0018\u00010hH\u0002J\u0012\u0010è\u0001\u001a\u00020,2\u0007\u0010é\u0001\u001a\u00020$H\u0002J\u0018\u0010ê\u0001\u001a\u00020,*\u00030ë\u00012\b\u0010ì\u0001\u001a\u00030\u0096\u0001H\u0002J\u0015\u0010í\u0001\u001a\u00030º\u00012\t\u0010î\u0001\u001a\u0004\u0018\u00010,H\u0002J\n\u0010ï\u0001\u001a\u00030º\u0001H\u0002J\u0015\u0010ð\u0001\u001a\u00030º\u00012\t\u0010Ý\u0001\u001a\u0004\u0018\u00010hH\u0002J\u0012\u0010ú\u0001\u001a\u00020$2\u0007\u0010û\u0001\u001a\u00020\u007fH\u0002J.\u0010ü\u0001\u001a\u00030º\u00012\b\u0010ý\u0001\u001a\u00030þ\u00012\r\u0010ÿ\u0001\u001a\b\u0012\u0004\u0012\u00020\u007f0~2\t\u0010Ý\u0001\u001a\u0004\u0018\u00010hH\u0002J\u0007\u0010\u0080\u0002\u001a\u00020$J\u001a\u0010\u0081\u0002\u001a\u00030º\u0001*\u00030¯\u00012\t\b\u0002\u0010\u0082\u0002\u001a\u00020$H\u0002J\n\u0010\u0083\u0002\u001a\u00030º\u0001H\u0016J\n\u0010\u0084\u0002\u001a\u00030º\u0001H\u0016J#\u0010\u0085\u0002\u001a\u00030º\u00012\u0017\u0010\u0086\u0002\u001a\u0012\u0012\u0004\u0012\u00020,\u0012\u0005\u0012\u00030\u0088\u0002\u0018\u00010\u0087\u0002H\u0016J-\u0010\u0089\u0002\u001a\u00030º\u00012\b\u0010ý\u0001\u001a\u00030þ\u00012\u0017\u0010\u0086\u0002\u001a\u0012\u0012\u0004\u0012\u00020,\u0012\u0005\u0012\u00030\u0088\u0002\u0018\u00010\u0087\u0002H\u0002J\n\u0010\u008a\u0002\u001a\u00030¼\u0001H\u0016J\t\u0010\u008b\u0002\u001a\u00020,H\u0016J\u0015\u0010\u008c\u0002\u001a\u00030º\u00012\t\u0010\u008d\u0002\u001a\u0004\u0018\u00010\u0018H\u0016J\n\u0010\u008e\u0002\u001a\u00030º\u0001H\u0002J\n\u0010\u008f\u0002\u001a\u00030º\u0001H\u0002J\n\u0010\u0090\u0002\u001a\u00030º\u0001H\u0002J9\u0010\u0091\u0002\u001a\u0005\u0018\u0001H\u0092\u0002\"\u0005\b\u0000\u0010\u0092\u00022\u001d\u0010\u0093\u0002\u001a\u0018\u0012\u0004\u0012\u00020b\u0012\u0007\u0012\u0005\u0018\u0001H\u0092\u00020\u0094\u0002¢\u0006\u0003\b\u0095\u0002H\u0082\b¢\u0006\u0003\u0010\u0096\u0002J\u0016\u0010\u0097\u0002\u001a\u00030º\u00012\n\u0010\u0098\u0002\u001a\u0005\u0018\u00010\u0099\u0002H\u0016J\n\u0010\u009a\u0002\u001a\u00030º\u0001H\u0016J\u0014\u0010\u009b\u0002\u001a\u00030º\u00012\b\u0010\u009c\u0002\u001a\u00030\u009d\u0002H\u0016J\u0014\u0010\u009e\u0002\u001a\u00030º\u00012\b\u0010\u009f\u0002\u001a\u00030\u009d\u0002H\u0002J\u001e\u0010 \u0002\u001a\u00030¡\u00022\b\u0010¢\u0002\u001a\u00030\u0094\u00012\b\u0010ý\u0001\u001a\u00030þ\u0001H\u0002J \u0010£\u0002\u001a\u00030º\u00012\t\u0010Ý\u0001\u001a\u0004\u0018\u00010h2\t\b\u0002\u0010Þ\u0001\u001a\u00020$H\u0002J\n\u0010¤\u0002\u001a\u00030º\u0001H\u0002J\n\u0010¥\u0002\u001a\u00030º\u0001H\u0002J\n\u0010¦\u0002\u001a\u00030º\u0001H\u0002J\n\u0010§\u0002\u001a\u00030º\u0001H\u0002J\u0014\u0010¨\u0002\u001a\u00020$2\t\b\u0002\u0010©\u0002\u001a\u00020$H\u0002J\t\u0010ª\u0002\u001a\u00020$H\u0002J\u0016\u0010«\u0002\u001a\u00030º\u00012\n\u0010¬\u0002\u001a\u0005\u0018\u00010\u00ad\u0002H\u0002J\u0013\u0010®\u0002\u001a\u00030º\u00012\t\b\u0002\u0010¯\u0002\u001a\u00020$J\n\u0010°\u0002\u001a\u00030º\u0001H\u0002J\u0013\u0010±\u0002\u001a\u00030º\u00012\t\b\u0002\u0010¯\u0002\u001a\u00020$J\u001c\u0010²\u0002\u001a\u00020,2\b\u0010³\u0002\u001a\u00030´\u00022\u0007\u0010µ\u0002\u001a\u00020hH\u0002J\u0013\u0010¶\u0002\u001a\u00030º\u00012\u0007\u0010µ\u0002\u001a\u00020hH\u0002J\u0013\u0010·\u0002\u001a\u00030º\u00012\u0007\u0010µ\u0002\u001a\u00020hH\u0002J\u0013\u0010¸\u0002\u001a\u00030º\u00012\u0007\u0010µ\u0002\u001a\u00020hH\u0002J\u0013\u0010¹\u0002\u001a\u00030º\u00012\u0007\u0010µ\u0002\u001a\u00020hH\u0002J6\u0010º\u0002\u001a\u00030º\u00012\u0007\u0010»\u0002\u001a\u00020,2\u0007\u0010¼\u0002\u001a\u00020,2\u0018\u0010½\u0002\u001a\u0013\u0012\u0005\u0012\u00030\u0085\u0001\u0012\u0007\u0012\u0005\u0018\u00010º\u00010\u0094\u0002H\u0002J\u0015\u0010¾\u0002\u001a\n\u0012\u0005\u0012\u00030\u0085\u00010ä\u0001*\u00020zH\u0002J%\u0010¿\u0002\u001a\u00030º\u00012\b\u0010À\u0002\u001a\u00030\u0085\u00012\b\u0010Á\u0002\u001a\u00030\u0096\u0001H\u0082@¢\u0006\u0003\u0010Â\u0002J#\u0010Ã\u0002\u001a\u00030º\u00012\u0007\u0010Ä\u0002\u001a\u00020\u00182\u0007\u0010Å\u0002\u001a\u00020$H\u0082@¢\u0006\u0003\u0010Æ\u0002J\n\u0010Ç\u0002\u001a\u00030º\u0001H\u0002J\n\u0010È\u0002\u001a\u00030º\u0001H\u0002J\u0013\u0010Í\u0002\u001a\u00030º\u00012\u0007\u0010Î\u0002\u001a\u00020$H\u0002J\u001f\u0010Ï\u0002\u001a\u00030º\u00012\t\u0010Ð\u0002\u001a\u0004\u0018\u00010,2\b\u0010Ñ\u0002\u001a\u00030\u0092\u0001H\u0002J\u0014\u0010Ò\u0002\u001a\u00030\u0092\u00012\b\u0010ý\u0001\u001a\u00030þ\u0001H\u0002J+\u0010Ó\u0002\u001a\u0005\u0018\u00010Ô\u00022\b\u0010ý\u0001\u001a\u00030þ\u00012\t\u0010Ð\u0002\u001a\u0004\u0018\u00010,2\b\u0010Ñ\u0002\u001a\u00030\u0092\u0001H\u0002J\u0015\u0010Õ\u0002\u001a\u00030º\u00012\t\u0010µ\u0002\u001a\u0004\u0018\u00010hH\u0002J\n\u0010Ù\u0002\u001a\u00030¼\u0001H\u0002J\n\u0010Ý\u0002\u001a\u00030º\u0001H\u0002J\n\u0010Þ\u0002\u001a\u00030º\u0001H\u0002J\u0015\u0010ß\u0002\u001a\u00030º\u00012\t\u0010Ô\u0001\u001a\u0004\u0018\u00010\u0018H\u0002J\u0014\u0010à\u0002\u001a\u00030º\u00012\b\u0010á\u0002\u001a\u00030â\u0002H\u0016J\u0014\u0010ã\u0002\u001a\u00030º\u00012\b\u0010á\u0002\u001a\u00030â\u0002H\u0016J\n\u0010ä\u0002\u001a\u00030º\u0001H\u0002J*\u0010å\u0002\u001a\u00030º\u00012\b\u0010æ\u0002\u001a\u00030\u0085\u00012\b\u0010ç\u0002\u001a\u00030\u0085\u00012\n\u0010è\u0002\u001a\u0005\u0018\u00010é\u0002H\u0016J\u0014\u0010ê\u0002\u001a\u00030º\u00012\b\u0010ë\u0002\u001a\u00030ì\u0002H\u0016R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010G\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010I\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010J\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010K\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010L\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010M\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010N\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010O\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010P\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Q\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010R\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010S\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010T\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010U\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010V\u001a\u0004\u0018\u00010WX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010X\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Y\u001a\u0004\u0018\u00010ZX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010[\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\\\u001a\u0004\u0018\u00010]X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010^\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010_\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010`\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010a\u001a\u00020b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\be\u0010f\u001a\u0004\bc\u0010dR\u0013\u0010g\u001a\u0004\u0018\u00010h8F¢\u0006\u0006\u001a\u0004\bi\u0010jR\u001a\u0010k\u001a\u00020lX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\u001b\u0010q\u001a\u00020r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bu\u0010f\u001a\u0004\bs\u0010tR\u000e\u0010v\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010w\u001a\u0004\u0018\u00010xX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010y\u001a\u0004\u0018\u00010zX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010{\u001a\u0004\u0018\u00010|X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010}\u001a\b\u0012\u0004\u0012\u00020\u007f0~X\u0082\u000e¢\u0006\u0002\n\u0000R/\u0010\u0080\u0001\u001a\"\u0012\u0004\u0012\u00020,\u0012\u0005\u0012\u00030\u0082\u00010\u0081\u0001j\u0010\u0012\u0004\u0012\u00020,\u0012\u0005\u0012\u00030\u0082\u0001`\u0083\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\u0084\u0001\u001a\"\u0012\u0004\u0012\u00020,\u0012\u0005\u0012\u00030\u0085\u00010\u0081\u0001j\u0010\u0012\u0004\u0012\u00020,\u0012\u0005\u0012\u00030\u0085\u0001`\u0083\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0087\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R\u0012\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008d\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008f\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0090\u0001\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0092\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0094\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0095\u0001\u001a\u00030\u0096\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0097\u0001\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0098\u0001\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0099\u0001\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u009a\u0001\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u009b\u0001\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u009c\u0001\u001a\u00030\u009d\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u009e\u0001\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u009f\u0001\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010 \u0001\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010¡\u0001\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010¢\u0001\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010£\u0001\u001a\u000b\u0012\u0004\u0012\u00020z\u0018\u00010¤\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010¥\u0001\u001a\u0005\u0018\u00010¦\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010§\u0001\u001a\u0005\u0018\u00010¦\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010¨\u0001\u001a\u0005\u0018\u00010©\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010ª\u0001\u001a\u0005\u0018\u00010«\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010¬\u0001\u001a\u0013\u0012\u000e\u0012\f\u0012\u0005\u0012\u00030¯\u0001\u0018\u00010®\u00010\u00ad\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010°\u0001\u001a\u0005\u0018\u00010±\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010²\u0001\u001a\u0005\u0018\u00010³\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010´\u0001\u001a\u00030µ\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b¸\u0001\u0010f\u001a\u0006\b¶\u0001\u0010·\u0001R\u0012\u0010ñ\u0001\u001a\u0005\u0018\u00010ò\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010ó\u0001\u001a\u00020$X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bô\u0001\u0010õ\u0001\"\u0006\bö\u0001\u0010÷\u0001R\u0010\u0010ø\u0001\u001a\u00030ù\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010É\u0002\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bÌ\u0002\u0010f\u001a\u0006\bÊ\u0002\u0010Ë\u0002R\u000f\u0010Ö\u0002\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010×\u0002\u001a\u00030Ø\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010Ú\u0002\u001a\u00030Û\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010Ü\u0002\u001a\u00030\u0082\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006ñ\u0002"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/HomeUserCenterFragment;", "Lcom/bilibili/lib/ui/BaseFragment;", "Lcom/bilibili/lib/homepage/startdust/OnPageSelectChangeListener;", "Lcom/bilibili/pvtracker/IPvTracker;", "Landroid/view/View$OnClickListener;", "Lcom/bilibili/lib/accounts/subscribe/PassportObserver;", "Lcom/bilibili/lib/ui/garb/GarbWatcher$Observer;", "Lcom/bilibili/lib/ui/theme/ThemeWatcher$Observer;", "Lcom/bilibili/lib/homepage/startdust/IPageFragment;", "Lcom/bilibili/lib/ui/mixin/IFragmentShowHide;", "<init>", "()V", "mMediaPlayer", "Ltv/danmaku/ijk/media/player/IjkMediaPlayer;", "mSurface", "Landroid/view/Surface;", "mViewContainer", "Landroid/view/ViewGroup;", "mRootView", "Landroid/widget/FrameLayout;", "mHeaderView", "fragmentContainerView", "Landroidx/fragment/app/FragmentContainerView;", "mMintTopLayout", "Landroid/view/View;", "mMineGarbLayout", "mMineGarbBgImageVew", "Landroid/widget/ImageView;", "mMineGarbBgAnimatorView", "Landroid/view/TextureView;", "mMineScan", "mMineGlobalLinkEntrance", "Ltv/danmaku/bili/ui/main2/mine/widgets/MineGlobalLinkEntranceView;", "mGlobalLinkBubble", "Lcom/bilibili/lib/projection/internal/widget/PopupGuideBubble;", "mGlobalLinkGuideBubbleNeedShow", "", "mGlobalLinkGuideBubbleNeedInit", "mMineThemeIcon", "Lcom/bilibili/lib/image2/view/BiliImageView;", "mMineThemeStoreView", "Ltv/danmaku/bili/ui/main2/mine/widgets/MultipleThemeImageView;", "mMineDayNightSetting", "mGarbEntranceUrl", "", "mAnswerView", "Ltv/danmaku/bili/ui/main2/mine/widgets/ChameleonAnswerView;", "topLeftCompose", "Landroidx/compose/ui/platform/ComposeView;", "mAvatar", "Ltv/danmaku/bili/ui/main2/mine/widgets/MineAvatarFrameLayout;", "mLayerAvatar", "Lcom/bilibili/lib/avatar/layers/LayerAvatarView;", "mUserInfoLayout", "mUserInfo", "mNickName", "Ltv/danmaku/bili/ui/main2/mine/widgets/NickNameTextView;", "mUserHandle", "Landroid/widget/TextView;", "mNickNameGuideView", "mLevelLabel", "mMemberPopWindow", "Landroid/widget/PopupWindow;", "levelPopWindow", "levelPopWindowShowingFlag", "editImage", "mLevelSeniorEntranceLabel", "mLevelSeniorEntranceArrow", "mLevelSeniorEntranceText", "mLevelSeniorEntrance", "mRankStatus", "mVipStatus", "mVipStatusImage", "mAccountStatus", "mUserBpCount", "mUserCoinCount", "mGotoSpace", "mClickLogin", "mAmountLayout", "mFollowingLayout", "mFollowingCount", "mAttentionLayout", "mAttentionCount", "mFansLayout", "mFansCount", "mFansBubble", "mFansAchieveMedal", "Landroid/widget/LinearLayout;", "mFansAchieveMedalText", "mFansAchieveMedalImage", "Lcom/bilibili/magicasakura/widgets/TintImageView;", "mFansAchieveBadge", "mAnimatorHelper", "Ltv/danmaku/bili/utils/NavigationFragmentAnimatorHelper;", "mFansDesc", "mSplitLine1", "mSplitLine2", "viewModel", "Ltv/danmaku/bili/ui/main2/mine/HomeUserCenterViewModel;", "getViewModel", "()Ltv/danmaku/bili/ui/main2/mine/HomeUserCenterViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "mMineInfo", "Ltv/danmaku/bili/ui/main2/api/AccountMine;", "getMMineInfo", "()Ltv/danmaku/bili/ui/main2/api/AccountMine;", "mUperModuleInfo", "Ltv/danmaku/bili/ui/main2/api/AccountMine$AccountUperInfo;", "getMUperModuleInfo", "()Ltv/danmaku/bili/ui/main2/api/AccountMine$AccountUperInfo;", "setMUperModuleInfo", "(Ltv/danmaku/bili/ui/main2/api/AccountMine$AccountUperInfo;)V", "mGameCenter", "Ltv/danmaku/bili/ui/main2/mine/MineGameCenterHelper;", "getMGameCenter", "()Ltv/danmaku/bili/ui/main2/mine/MineGameCenterHelper;", "mGameCenter$delegate", "mIsFragmentSelected", "mRefreshLayout", "Ltv/danmaku/bili/widget/swiperefresh/TintSwipeRefreshLayout;", "mRecycleView", "Landroidx/recyclerview/widget/RecyclerView;", "mAdapter", "Ltv/danmaku/bili/ui/main2/mine/HomeUserCenterAdapter;", "mSectionListV2", "", "Lcom/bilibili/lib/homepage/mine/MenuGroup;", "mListenerMap", "Ljava/util/HashMap;", "Lcom/bilibili/lib/badge/BadgeManager$OnChangedListener;", "Lkotlin/collections/HashMap;", "mRegisterMap", "", "noticeResult", "Ltv/danmaku/bili/ui/notice/api/BiliNotice;", "getNoticeResult", "()Ltv/danmaku/bili/ui/notice/api/BiliNotice;", "setNoticeResult", "(Ltv/danmaku/bili/ui/notice/api/BiliNotice;)V", "mNavigationLoginDispatcher", "Ltv/danmaku/bili/ui/main2/ILoginDispatcher;", "mPageManager", "Ltv/danmaku/bili/ui/main2/mine/MinePageManager;", "mNeedRefresh", "mVipThemeInfo", "Lcom/bilibili/app/comm/vipconfig/VipThemeInfo;", "mMineGarbBgDrawable", "Landroid/graphics/drawable/BitmapDrawable;", "mCurrentGarbId", "", "mIsUpperTipsShow", "mUpperReportType", "mLiveReportType", "mHasUpdatedUserInfo", "mIsMineShowing", "mScrollReporter", "Ltv/danmaku/bili/ui/main2/mine/HomeUserCenterReporter;", "globalLinkShowing", "memberBubbleShowing", "hardCoreAniShowing", "infoEditUrl", "infoEditOnClick", "exposeClient", "Lcom/bilibili/exposer/ExposeClient;", "displayStrategiesReportJob", "Lkotlinx/coroutines/Job;", "vipEntranceExposureJob", "mineVipModuleManager", "Ltv/danmaku/bili/ui/main2/mine/modularvip/MineVipModuleManager;", "fansAchievementHelper", "Ltv/danmaku/bili/ui/main2/mine/fansachievement/FansAchievementHelper;", "mGameDateObserver", "Landroidx/lifecycle/Observer;", "", "Lcom/bilibili/lib/homepage/mine/MenuGroup$Item;", "mProjectionService", "Lcom/bilibili/lib/projection/ProjectionService;", "mProjectionClient", "Lcom/bilibili/lib/projection/ProjectionClient;", "pendingTaskUtil", "Ltv/danmaku/bili/ui/main2/mine/MinePagePendingTaskUtil;", "getPendingTaskUtil", "()Ltv/danmaku/bili/ui/main2/mine/MinePagePendingTaskUtil;", "pendingTaskUtil$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "showForceLoginFragment", "fromPageSelected", "dismissForceLoginFragment", "changeForceLoginFragmentVisibility", "isLogin", "initBottomContent", "isTeenagerMode", "initAccountLayout", "initUserInfoLayout", "initTopView", "configHeaderView", "initProjectionLink", "configGlobalLinkBubble", "initGlobalLinkGuideBubble", "setGlobalLinkGuideBubbleCallback", "bubble", "Ltv/danmaku/bili/ui/main2/api/AccountMine$BiliLinkBubble;", "showGlobalLinkGuideBubble", "onViewCreated", "view", "onActivityCreated", "onResume", "onPause", "onDestroy", "onDestroyView", "onStop", "removerBadge", "onUserStatusLoaded", "mineInfo", "isFromCache", "renderVipEntrance", "fromCache", "resetVipReportJob", "vipEntranceRealExposure", "adapterDataChangedFlow", "Lkotlinx/coroutines/flow/Flow;", "onMenuUpdate", "renderAnswer", "renderUserInfo", "setEditUrlShowHint", "showHint", "getGuideBubbleKey", "Ltv/danmaku/bili/ui/main2/api/AccountMine$GuideBubble;", "mid", "memberReminderBubble", "content", "dismissMemberBubble", "renderProjectionBLinkEntrance", "oldMineInfo", "Lcom/alibaba/fastjson/JSONObject;", "shouldFilter", "getShouldFilter", "()Z", "setShouldFilter", "(Z)V", "mMineChangeListener", "Ltv/danmaku/bili/ui/main2/AccountMineInfoManager$OnDataChangedListener;", "disableCreationModule", "menuGroup", "buildMineMenu", "context", "Landroid/content/Context;", "menuList", "hasLive", "registerToListenerMap", "redDotWithListener", "onPageReSelected", "onPageUnselected", "onPageSelected", "extras", "", "", "checkLocateTask", "getPvExtra", "getPvEventId", "onClick", "v", "reportMinePageGlobalLinkClick", "submitGlobalLinkAct", "hideGlobalLinkBubble", "runIfViewModel", "T", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "onChange", "topic", "Lcom/bilibili/lib/accounts/subscribe/Topic;", "onThemeChanged", "onSkinChange", "skin", "Lcom/bilibili/lib/ui/garb/Garb;", "setHeadAnimator", "garb", "getSquaredMatrix2", "Landroid/graphics/Matrix;", "bgDrawable", "renderMine", "toFans", "handleFansRedDot", "toAttention", "toFollowing", "checkRestrictMode", "showToast", "checkTeenRestrictMode", "renderGarbEntrance", "garbEntrance", "Ltv/danmaku/bili/ui/main2/api/AccountMine$GarbEntrance;", "switchNightClick", "booleanReport", "switchDailyNightIcon", "onClickThemeStore", "getDisplayRank", AudioIntentHelper.FROM_ACTIVITY, "Landroid/app/Activity;", "mine", ReportUtilKt.POS_UPDATE, "showVIPStatusLabel", "showUserLevel", "showNonSeniorUserLevel", "seniorFlashPop", "iconUrl", "whichFlash", "seniorFlashOnFinish", "scrollStateFlow", "scrollToAdapterPosition", "menuGroupType", "locationItemId", "(IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showTribeeRevisitPop", "popAnchor", "anchorInRight", "(Landroid/view/View;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "seniorFlashPopHide", "seniorLevelShow", "seniorClickListener", "getSeniorClickListener", "()Landroid/view/View$OnClickListener;", "seniorClickListener$delegate", "setSplitLine", "isPure", "setVipStatusMode", "labelName", "vipThemeInfo", "getVipThemeInfo", "getVipThemeDetailInfo", "Lcom/bilibili/app/comm/vipconfig/VipThemeInfo$VipThemeDetailInfo;", "setAvatar", "mLoginClickListener", "mUploadCallback", "Lcom/bilibili/app/comm/list/avatarcommon/changeavatar/AvatarUploader$UploadCallback;", "createPvArgs", "mMineItemClickListener", "Ltv/danmaku/bili/ui/main2/mine/IMineItemClickListener;", "mMineBadgeListener", "tryNotifyTips", "setGarbIconColor", "refreshView", "onFragmentHide", "lastFlag", "Lcom/bilibili/lib/ui/mixin/Flag;", "onFragmentShow", "setStatusBarMode", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "RecycleViewScrollListen", "HomeMineTab", "HomeUserCenterBadge", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class HomeUserCenterFragment extends BaseFragment implements OnPageSelectChangeListener, IPvTracker, View.OnClickListener, PassportObserver, GarbWatcher.Observer, ThemeWatcher.Observer, IPageFragment, IFragmentShowHide {
    public static final String FF_KEY_GLOBALLINK_ENTRANCE_ENABLE = "nva.biz.global.link.enable";
    public static final String KEY_GLOBAL_LINK_ENTRACE_SHOWN = "key_global_link_entrance_shown";
    public static final String KEY_SENIOR_GATE_SHOWN = "key_senior_gate_shown";
    public static final String KEY_SENIOR_VIP_SHOWN = "key_senior_vip_shown";
    public static final String KEY_SHOW_GLOBALLINK_BUBBLE = "key_show_globallink_bubble";
    public static final String KEY_TRIBEE_REVISIT_GUIDE_SHOWN = "key_tribee_revisit_guide_shown";
    public static final String KEY_VIP_LABEL_GIF_SHOWN = "key_vip_label_gif_shown";
    public static final String NAVIGATION_EVENT_ID = "main.my-information.0.0.pv";
    public static final float PENDANT_AVATAR_BORDER_WIDTH = 2.0f;
    private static final String QR_ENTRANCE_CLICK = "main.my-information.qr-scan.0.click";
    public static final int REQUEST_CODE_LOGIN = 1001;
    private static final String TAG = "HomeUserCenterFragment";
    private Job displayStrategiesReportJob;
    private View editImage;
    private ExposeClient<RecyclerView> exposeClient;
    private FansAchievementHelper fansAchievementHelper;
    private FragmentContainerView fragmentContainerView;
    private boolean globalLinkShowing;
    private boolean hardCoreAniShowing;
    private final View.OnClickListener infoEditOnClick;
    private String infoEditUrl;
    private PopupWindow levelPopWindow;
    private boolean levelPopWindowShowingFlag;
    private TextView mAccountStatus;
    private HomeUserCenterAdapter mAdapter;
    private ViewGroup mAmountLayout;
    private NavigationFragmentAnimatorHelper mAnimatorHelper;
    private ChameleonAnswerView mAnswerView;
    private TextView mAttentionCount;
    private View mAttentionLayout;
    private MineAvatarFrameLayout mAvatar;
    private TextView mClickLogin;
    private long mCurrentGarbId;
    private View mFansAchieveBadge;
    private LinearLayout mFansAchieveMedal;
    private TintImageView mFansAchieveMedalImage;
    private TextView mFansAchieveMedalText;
    private TextView mFansBubble;
    private TextView mFansCount;
    private View mFansDesc;
    private View mFansLayout;
    private TextView mFollowingCount;
    private View mFollowingLayout;
    private final Lazy mGameCenter$delegate;
    private final Observer<List<MenuGroup.Item>> mGameDateObserver;
    private String mGarbEntranceUrl;
    private PopupGuideBubble mGlobalLinkBubble;
    private boolean mGlobalLinkGuideBubbleNeedInit = true;
    private boolean mGlobalLinkGuideBubbleNeedShow;
    private View mGotoSpace;
    private boolean mHasUpdatedUserInfo;
    private ViewGroup mHeaderView;
    private boolean mIsFragmentSelected;
    private boolean mIsMineShowing;
    private boolean mIsUpperTipsShow;
    private LayerAvatarView mLayerAvatar;
    private ImageView mLevelLabel;
    private View mLevelSeniorEntrance;
    private ImageView mLevelSeniorEntranceArrow;
    private ImageView mLevelSeniorEntranceLabel;
    private TextView mLevelSeniorEntranceText;
    private final HashMap<String, BadgeManager.OnChangedListener> mListenerMap;
    private String mLiveReportType;
    private final View.OnClickListener mLoginClickListener;
    private IjkMediaPlayer mMediaPlayer;
    private PopupWindow mMemberPopWindow;
    private final BadgeManager.OnChangedListener mMineBadgeListener;
    private final AccountMineInfoManager.OnDataChangedListener mMineChangeListener;
    private MultipleThemeImageView mMineDayNightSetting;
    private TextureView mMineGarbBgAnimatorView;
    private BitmapDrawable mMineGarbBgDrawable;
    private ImageView mMineGarbBgImageVew;
    private FrameLayout mMineGarbLayout;
    private MineGlobalLinkEntranceView mMineGlobalLinkEntrance;
    private final IMineItemClickListener mMineItemClickListener;
    private View mMineScan;
    private BiliImageView mMineThemeIcon;
    private MultipleThemeImageView mMineThemeStoreView;
    private View mMintTopLayout;
    private ILoginDispatcher mNavigationLoginDispatcher;
    private boolean mNeedRefresh;
    private NickNameTextView mNickName;
    private View mNickNameGuideView;
    private MinePageManager mPageManager;
    private ProjectionClient mProjectionClient;
    private ProjectionService mProjectionService;
    private TextView mRankStatus;
    private RecyclerView mRecycleView;
    private TintSwipeRefreshLayout mRefreshLayout;
    private final HashMap<String, Integer> mRegisterMap;
    private FrameLayout mRootView;
    private HomeUserCenterReporter mScrollReporter;
    private List<MenuGroup> mSectionListV2;
    private View mSplitLine1;
    private View mSplitLine2;
    private Surface mSurface;
    private AccountMine.AccountUperInfo mUperModuleInfo;
    private final AvatarUploader.UploadCallback mUploadCallback;
    private String mUpperReportType;
    private TextView mUserBpCount;
    private TextView mUserCoinCount;
    private TextView mUserHandle;
    private View mUserInfo;
    private View mUserInfoLayout;
    private ViewGroup mViewContainer;
    private TextView mVipStatus;
    private ComposeView mVipStatusImage;
    private VipThemeInfo mVipThemeInfo;
    private boolean memberBubbleShowing;
    private MineVipModuleManager mineVipModuleManager;
    private BiliNotice noticeResult;
    private JSONObject oldMineInfo;
    private final Lazy pendingTaskUtil$delegate;
    private final Lazy seniorClickListener$delegate;
    private boolean shouldFilter;
    private ComposeView topLeftCompose;
    private final Lazy viewModel$delegate;
    private Job vipEntranceExposureJob;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: HomeUserCenterFragment.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Topic.values().length];
            try {
                iArr[Topic.SIGN_IN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Topic.SIGN_OUT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[Topic.ACCOUNT_INFO_UPDATE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[Topic.ACCOUNT_SWITCH.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ boolean appendEndExtra() {
        return IPvTracker.-CC.$default$appendEndExtra(this);
    }

    public /* synthetic */ int getContentBottomPadding(Context context) {
        return IPageFragment.-CC.$default$getContentBottomPadding(this, context);
    }

    public /* synthetic */ String getUniqueKey() {
        return IPvTracker.-CC.$default$getUniqueKey(this);
    }

    public /* synthetic */ void onPageReSelected(PageReSelectedParams pageReSelectedParams) {
        OnPageSelectChangeListener.-CC.$default$onPageReSelected(this, pageReSelectedParams);
    }

    public /* synthetic */ boolean shouldReport() {
        return IPvTracker.-CC.$default$shouldReport(this);
    }

    private static void __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookPopupWindowDismiss(Object popup) {
        Intrinsics.checkNotNullParameter(popup, "popup");
        if (Intrinsics.areEqual(ConfigManager.Companion.ab().get("bgthread_ui_access_detect_enable", true), true)) {
            Thread thread = Thread.currentThread();
            if (!Intrinsics.areEqual(thread, Looper.getMainLooper().getThread())) {
                IllegalStateException exp = new IllegalStateException("PopupWindow.dismiss() called from non-UI thread: " + thread + ", 请联系 Jackin");
                BLog.e("BgThreadUIAccess", "PopupWindow.dismiss() called from non-UI thread: " + thread, exp);
                Neurons.trackT(false, "app.bgthread.ui.access", MapsKt.mapOf(new Pair[]{TuplesKt.to("stacktrace", ExceptionsKt.stackTraceToString(exp)), TuplesKt.to("threadName", thread.getName())}), 1, new AppCompatDelegateImpl$.ExternalSyntheticLambda0());
                if (BuildConfig.DEBUG) {
                    throw exp;
                }
            }
        }
        ((PopupWindow) popup).dismiss();
    }

    public HomeUserCenterFragment() {
        final Fragment $this$viewModels_u24default$iv = (Fragment) this;
        final Function0 ownerProducer$iv = new Function0<Fragment>() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$special$$inlined$viewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final Fragment m2071invoke() {
                return $this$viewModels_u24default$iv;
            }
        };
        final Lazy owner$delegate$iv = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$special$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelStoreOwner m2073invoke() {
                return (ViewModelStoreOwner) ownerProducer$iv.invoke();
            }
        });
        this.viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy($this$viewModels_u24default$iv, Reflection.getOrCreateKotlinClass(HomeUserCenterViewModel.class), new Function0<ViewModelStore>() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelStore m2074invoke() {
                return FragmentViewModelLazyKt.access$viewModels$lambda-1(owner$delegate$iv).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$special$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final CreationExtras m2075invoke() {
                CreationExtras creationExtras;
                Function0 function0 = r2;
                if (function0 != null && (creationExtras = (CreationExtras) function0.invoke()) != null) {
                    return creationExtras;
                }
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = FragmentViewModelLazyKt.access$viewModels$lambda-1(owner$delegate$iv);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory2 = hasDefaultViewModelProviderFactory instanceof HasDefaultViewModelProviderFactory ? hasDefaultViewModelProviderFactory : null;
                return hasDefaultViewModelProviderFactory2 != null ? hasDefaultViewModelProviderFactory2.getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$special$$inlined$viewModels$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelProvider.Factory m2076invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory;
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = FragmentViewModelLazyKt.access$viewModels$lambda-1(owner$delegate$iv);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory2 = hasDefaultViewModelProviderFactory instanceof HasDefaultViewModelProviderFactory ? hasDefaultViewModelProviderFactory : null;
                if (hasDefaultViewModelProviderFactory2 != null && (defaultViewModelProviderFactory = hasDefaultViewModelProviderFactory2.getDefaultViewModelProviderFactory()) != null) {
                    return defaultViewModelProviderFactory;
                }
                return $this$viewModels_u24default$iv.getDefaultViewModelProviderFactory();
            }
        });
        this.mUperModuleInfo = new AccountMine.AccountUperInfo();
        final Fragment $this$viewModels_u24default$iv2 = (Fragment) this;
        final Function0 ownerProducer$iv2 = new Function0<Fragment>() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$special$$inlined$viewModels$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final Fragment m2077invoke() {
                return $this$viewModels_u24default$iv2;
            }
        };
        final Lazy owner$delegate$iv2 = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$special$$inlined$viewModels$default$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelStoreOwner m2078invoke() {
                return (ViewModelStoreOwner) ownerProducer$iv2.invoke();
            }
        });
        this.mGameCenter$delegate = FragmentViewModelLazyKt.createViewModelLazy($this$viewModels_u24default$iv2, Reflection.getOrCreateKotlinClass(MineGameCenterHelper.class), new Function0<ViewModelStore>() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$special$$inlined$viewModels$default$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelStore m2079invoke() {
                return FragmentViewModelLazyKt.access$viewModels$lambda-1(owner$delegate$iv2).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$special$$inlined$viewModels$default$9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final CreationExtras m2080invoke() {
                CreationExtras creationExtras;
                Function0 function0 = r2;
                if (function0 != null && (creationExtras = (CreationExtras) function0.invoke()) != null) {
                    return creationExtras;
                }
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = FragmentViewModelLazyKt.access$viewModels$lambda-1(owner$delegate$iv2);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory2 = hasDefaultViewModelProviderFactory instanceof HasDefaultViewModelProviderFactory ? hasDefaultViewModelProviderFactory : null;
                return hasDefaultViewModelProviderFactory2 != null ? hasDefaultViewModelProviderFactory2.getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$special$$inlined$viewModels$default$10
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelProvider.Factory m2072invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory;
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = FragmentViewModelLazyKt.access$viewModels$lambda-1(owner$delegate$iv2);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory2 = hasDefaultViewModelProviderFactory instanceof HasDefaultViewModelProviderFactory ? hasDefaultViewModelProviderFactory : null;
                if (hasDefaultViewModelProviderFactory2 != null && (defaultViewModelProviderFactory = hasDefaultViewModelProviderFactory2.getDefaultViewModelProviderFactory()) != null) {
                    return defaultViewModelProviderFactory;
                }
                return $this$viewModels_u24default$iv2.getDefaultViewModelProviderFactory();
            }
        });
        this.mSectionListV2 = new ArrayList();
        this.mListenerMap = new HashMap<>();
        this.mRegisterMap = new HashMap<>();
        this.mNeedRefresh = true;
        this.mUpperReportType = MineReporter.PUBLISH_NOT_SHOW;
        this.mLiveReportType = "";
        this.mScrollReporter = new HomeUserCenterReporter();
        this.infoEditUrl = "activity://personinfo/info";
        this.infoEditOnClick = new View.OnClickListener() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeUserCenterFragment.infoEditOnClick$lambda$0(HomeUserCenterFragment.this, view);
            }
        };
        this.mGameDateObserver = new Observer() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$$ExternalSyntheticLambda5
            public final void onChanged(Object obj) {
                HomeUserCenterFragment.mGameDateObserver$lambda$0(HomeUserCenterFragment.this, (List) obj);
            }
        };
        this.pendingTaskUtil$delegate = MultiTypeListDetailActivityKt.lazyUnsafe(new Function0() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$$ExternalSyntheticLambda6
            public final Object invoke() {
                MinePagePendingTaskUtil pendingTaskUtil_delegate$lambda$0;
                pendingTaskUtil_delegate$lambda$0 = HomeUserCenterFragment.pendingTaskUtil_delegate$lambda$0();
                return pendingTaskUtil_delegate$lambda$0;
            }
        });
        this.shouldFilter = true;
        this.mMineChangeListener = new AccountMineInfoManager.OnDataChangedListener() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$$ExternalSyntheticLambda7
            @Override // tv.danmaku.bili.ui.main2.AccountMineInfoManager.OnDataChangedListener
            public final void onChanged(AccountMine accountMine, AccountMineRequestResource accountMineRequestResource) {
                HomeUserCenterFragment.mMineChangeListener$lambda$0(HomeUserCenterFragment.this, accountMine, accountMineRequestResource);
            }
        };
        this.seniorClickListener$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$$ExternalSyntheticLambda8
            public final Object invoke() {
                HomeUserCenterFragment$seniorClickListener$2$1 seniorClickListener_delegate$lambda$0;
                seniorClickListener_delegate$lambda$0 = HomeUserCenterFragment.seniorClickListener_delegate$lambda$0(HomeUserCenterFragment.this);
                return seniorClickListener_delegate$lambda$0;
            }
        });
        this.mLoginClickListener = new View.OnClickListener() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeUserCenterFragment.mLoginClickListener$lambda$0(HomeUserCenterFragment.this, view);
            }
        };
        this.mUploadCallback = new AvatarUploader.UploadCallback() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$mUploadCallback$1
            private final int ERROR_CODE_MODIFY_FORBIDDEN = 10000;
            private TintProgressDialog mProgressDialog;

            public final TintProgressDialog getMProgressDialog() {
                return this.mProgressDialog;
            }

            public final void setMProgressDialog(TintProgressDialog tintProgressDialog) {
                this.mProgressDialog = tintProgressDialog;
            }

            public void onUploadBegin() {
                boolean activityDie;
                activityDie = HomeUserCenterFragment.this.activityDie();
                if (!activityDie) {
                    FragmentActivity activity = HomeUserCenterFragment.this.getActivity();
                    Intrinsics.checkNotNull(activity);
                    this.mProgressDialog = TintProgressDialog.show(HomeUserCenterFragment.this.getActivity(), (CharSequence) null, activity.getString(R.string.common_global_string_227), true);
                    TintProgressDialog tintProgressDialog = this.mProgressDialog;
                    if (tintProgressDialog != null) {
                        tintProgressDialog.setCanceledOnTouchOutside(false);
                    }
                }
            }

            public void onUploadFailed(int code, String msg) {
                boolean activityDie;
                String errorStr = msg;
                activityDie = HomeUserCenterFragment.this.activityDie();
                if (activityDie) {
                    return;
                }
                TintProgressDialog tintProgressDialog = this.mProgressDialog;
                if (tintProgressDialog != null) {
                    tintProgressDialog.dismiss();
                }
                if (PlaySetErrorHelper.isRealName(code)) {
                    Activity activity = HomeUserCenterFragment.this.getActivity();
                    Intrinsics.checkNotNull(activity);
                    Intrinsics.checkNotNull(errorStr);
                    PlaySetErrorHelper.showDialog(activity, code, errorStr);
                    return;
                }
                if (TextUtils.isEmpty(errorStr)) {
                    FragmentActivity activity2 = HomeUserCenterFragment.this.getActivity();
                    Intrinsics.checkNotNull(activity2);
                    errorStr = activity2.getString(R.string.common_global_string_196);
                    if (code == -653) {
                        FragmentActivity activity3 = HomeUserCenterFragment.this.getActivity();
                        Intrinsics.checkNotNull(activity3);
                        errorStr = activity3.getString(bili.resource.space.R.string.space_global_string_240);
                    } else if (code == this.ERROR_CODE_MODIFY_FORBIDDEN) {
                        FragmentActivity activity4 = HomeUserCenterFragment.this.getActivity();
                        Intrinsics.checkNotNull(activity4);
                        errorStr = activity4.getString(bili.resource.space.R.string.space_global_string_155);
                    }
                }
                ToastHelper.showToastShort(HomeUserCenterFragment.this.getActivity(), errorStr);
            }

            public void onUploadSuccess(String url) {
                boolean activityDie;
                MineAvatarFrameLayout mineAvatarFrameLayout;
                activityDie = HomeUserCenterFragment.this.activityDie();
                if (activityDie) {
                    return;
                }
                TintProgressDialog tintProgressDialog = this.mProgressDialog;
                if (tintProgressDialog != null) {
                    tintProgressDialog.dismiss();
                }
                AccountMine it = HomeUserCenterFragment.this.getMMineInfo();
                if (it != null) {
                    HomeUserCenterFragment homeUserCenterFragment = HomeUserCenterFragment.this;
                    it.face = url == null ? "" : url;
                    it.showFaceGuide = false;
                    mineAvatarFrameLayout = homeUserCenterFragment.mAvatar;
                    if (mineAvatarFrameLayout != null) {
                        mineAvatarFrameLayout.show(url, false);
                    }
                }
            }
        };
        this.mMineItemClickListener = new IMineItemClickListener() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$mMineItemClickListener$1
            @Override // tv.danmaku.bili.ui.main2.mine.IMineItemClickListener
            public void onMineItemClick(MenuGroup.Item item) {
                MineGameCenterHelper mGameCenter;
                MinePageManager minePageManager;
                HashMap hashMap;
                Intrinsics.checkNotNullParameter(item, "item");
                mGameCenter = HomeUserCenterFragment.this.getMGameCenter();
                mGameCenter.onItemClicked(item);
                minePageManager = HomeUserCenterFragment.this.mPageManager;
                if (minePageManager != null) {
                    minePageManager.onMineMenuItemClick(item);
                }
                hashMap = HomeUserCenterFragment.this.mRegisterMap;
                hashMap.put(item.uri, 0);
            }

            @Override // tv.danmaku.bili.ui.main2.mine.IMineItemClickListener
            public void onNoticeItemClickClose() {
                List list;
                List list2;
                List list3;
                HomeUserCenterAdapter homeUserCenterAdapter;
                list = HomeUserCenterFragment.this.mSectionListV2;
                if (list.size() > 0) {
                    list2 = HomeUserCenterFragment.this.mSectionListV2;
                    if (((MenuGroup) list2.get(0)).viewType == 1) {
                        list3 = HomeUserCenterFragment.this.mSectionListV2;
                        list3.remove(0);
                        homeUserCenterAdapter = HomeUserCenterFragment.this.mAdapter;
                        if (homeUserCenterAdapter != null) {
                            homeUserCenterAdapter.notifyItemRemoved(0);
                        }
                    }
                }
            }

            @Override // tv.danmaku.bili.ui.main2.mine.IMineItemClickListener
            public void onNoticeItemClickClose(int pos, MenuGroup menuGroup, MenuGroup.Item item) {
                HomeUserCenterAdapter homeUserCenterAdapter;
                HomeUserCenterAdapter homeUserCenterAdapter2;
                HomeUserCenterAdapter homeUserCenterAdapter3;
                List<MenuGroup> data;
                if (menuGroup == null || item == null) {
                    return;
                }
                NoticeExtKt.closeAsNotice(item);
                HomeUserCenterFragment.this.setShouldFilter(NoticeExtKt.findFirstNotice(menuGroup) == null);
                if (pos >= 0) {
                    homeUserCenterAdapter = HomeUserCenterFragment.this.mAdapter;
                    if (pos < (homeUserCenterAdapter != null ? homeUserCenterAdapter.getItemCount() : 0)) {
                        homeUserCenterAdapter2 = HomeUserCenterFragment.this.mAdapter;
                        if (homeUserCenterAdapter2 != null && (data = homeUserCenterAdapter2.getData()) != null) {
                            data.remove(pos);
                        }
                        homeUserCenterAdapter3 = HomeUserCenterFragment.this.mAdapter;
                        if (homeUserCenterAdapter3 != null) {
                            homeUserCenterAdapter3.notifyItemRemoved(pos);
                        }
                    }
                }
            }

            @Override // tv.danmaku.bili.ui.main2.mine.IMineItemClickListener
            public void onSilenceItemClick() {
            }
        };
        this.mMineBadgeListener = new BadgeManager.OnChangedListener() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$mMineBadgeListener$1
            public void onChanged(String key, Badge badge) {
                HashMap hashMap;
                List<MenuGroup> list;
                HashMap hashMap2;
                HomeUserCenterAdapter homeUserCenterAdapter;
                int i = 0;
                BLog.dfmt("HomeUserCenterFragment", "receive badge: %s " + key, badge);
                if (!TextUtils.isEmpty(key) && badge != null) {
                    hashMap = HomeUserCenterFragment.this.mRegisterMap;
                    Intrinsics.checkNotNull(key);
                    Integer num = (Integer) hashMap.get(key);
                    int i2 = badge.msgCount;
                    if (num == null || num.intValue() != i2) {
                        list = HomeUserCenterFragment.this.mSectionListV2;
                        for (MenuGroup menuGroup : list) {
                            int index = i;
                            i++;
                            List it = menuGroup.itemList;
                            if (it != null) {
                                HomeUserCenterFragment homeUserCenterFragment = HomeUserCenterFragment.this;
                                Iterator it2 = it.iterator();
                                while (true) {
                                    if (it2.hasNext()) {
                                        MenuGroup.Item item = (MenuGroup.Item) it2.next();
                                        if (TextUtils.equals(item.uri, key)) {
                                            item.localRedDot = badge.msgCount;
                                            hashMap2 = homeUserCenterFragment.mRegisterMap;
                                            hashMap2.put(key, Integer.valueOf(badge.msgCount));
                                            homeUserCenterAdapter = homeUserCenterFragment.mAdapter;
                                            if (homeUserCenterAdapter != null) {
                                                homeUserCenterAdapter.notifyItemChanged(index);
                                            }
                                            BLog.d("HomeUserCenterFragment", "notifyItemChanged: %s " + index);
                                            MineReporter.reportMineItemShowWithRedDot(item, index, Integer.valueOf(item.localRedDot), item.title, null, "onChanged");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HomeUserCenterViewModel getViewModel() {
        return (HomeUserCenterViewModel) this.viewModel$delegate.getValue();
    }

    public final AccountMine getMMineInfo() {
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
            HomeUserCenterViewModel $this$_get_mMineInfo__u24lambda_u240 = getViewModel();
            return $this$_get_mMineInfo__u24lambda_u240.getMineInfo();
        }
        return null;
    }

    public final AccountMine.AccountUperInfo getMUperModuleInfo() {
        return this.mUperModuleInfo;
    }

    public final void setMUperModuleInfo(AccountMine.AccountUperInfo accountUperInfo) {
        Intrinsics.checkNotNullParameter(accountUperInfo, "<set-?>");
        this.mUperModuleInfo = accountUperInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MineGameCenterHelper getMGameCenter() {
        return (MineGameCenterHelper) this.mGameCenter$delegate.getValue();
    }

    public final BiliNotice getNoticeResult() {
        return this.noticeResult;
    }

    public final void setNoticeResult(BiliNotice biliNotice) {
        this.noticeResult = biliNotice;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void infoEditOnClick$lambda$0(HomeUserCenterFragment this$0, View it) {
        BLRouter.routeTo(RouteRequestKt.toRouteRequest(this$0.infoEditUrl), (Fragment) this$0);
        this$0.setEditUrlShowHint(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mGameDateObserver$lambda$0(HomeUserCenterFragment this$0, List items) {
        if (items == null) {
            return;
        }
        BLog.i(TAG, "game center sync => " + MineGameCenterHelperKt.toDesc(items));
        HomeUserCenterAdapter $this$mGameDateObserver_u24lambda_u240_u240 = this$0.mAdapter;
        if ($this$mGameDateObserver_u24lambda_u240_u240 != null) {
            List $this$indexOfFirst$iv = $this$mGameDateObserver_u24lambda_u240_u240.getData();
            int index$iv = 0;
            Iterator<MenuGroup> it = $this$indexOfFirst$iv.iterator();
            while (true) {
                if (it.hasNext()) {
                    Object item$iv = it.next();
                    MenuGroup it2 = (MenuGroup) item$iv;
                    if (it2.moduleType == 2) {
                        break;
                    }
                    index$iv++;
                } else {
                    index$iv = -1;
                    break;
                }
            }
            int idx = index$iv;
            MenuGroup $this$mGameDateObserver_u24lambda_u240_u240_u241 = (MenuGroup) CollectionsKt.getOrNull($this$mGameDateObserver_u24lambda_u240_u240.getData(), idx);
            if ($this$mGameDateObserver_u24lambda_u240_u240_u241 != null) {
                $this$mGameDateObserver_u24lambda_u240_u240_u241.itemList = items;
                if (items.isEmpty()) {
                    $this$mGameDateObserver_u24lambda_u240_u240.getData().remove($this$mGameDateObserver_u24lambda_u240_u240_u241);
                    $this$mGameDateObserver_u24lambda_u240_u240.notifyItemRemoved(idx);
                    return;
                }
                List $this$forEach$iv = items;
                for (Object element$iv : $this$forEach$iv) {
                    MenuGroup.Item it3 = (MenuGroup.Item) element$iv;
                    this$0.registerToListenerMap(it3, false);
                }
                $this$mGameDateObserver_u24lambda_u240_u240.notifyItemChanged(idx, new Object());
                this$0.mScrollReporter.notifyDataChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MinePagePendingTaskUtil getPendingTaskUtil() {
        return (MinePagePendingTaskUtil) this.pendingTaskUtil$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MinePagePendingTaskUtil pendingTaskUtil_delegate$lambda$0() {
        return new MinePagePendingTaskUtil();
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context activity = getActivity();
        BiliAccounts.get(activity).subscribeAllWithSwitch(this);
        this.mNavigationLoginDispatcher = ILoginDispatcherKt.getLoginDispatcher(getContext());
        getMGameCenter().getGameData().observe((LifecycleOwner) this, this.mGameDateObserver);
        if (activity instanceof MainActivityV2) {
            this.mPageManager = new MinePageManager(activity);
        }
        HomeUserCenterViewModelKt.mineLog("onCreate");
        getViewModel().onAction(HomeUserCenterAction.Init.INSTANCE);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this.mViewContainer = container;
        View inflate = inflater.inflate(tv.danmaku.bili.R.layout.bili_layout_main_user_center, container, false);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.FrameLayout");
        this.mRootView = (FrameLayout) inflate;
        initTopView();
        initUserInfoLayout();
        initAccountLayout();
        initBottomContent();
        initProjectionLink();
        HomeUserCenterViewModelKt.mineLog("onCreateView");
        return this.mRootView;
    }

    static /* synthetic */ void showForceLoginFragment$default(HomeUserCenterFragment homeUserCenterFragment, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        homeUserCenterFragment.showForceLoginFragment(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showForceLoginFragment(boolean fromPageSelected) {
        Fragment fragment;
        FragmentContainerView fragmentContainerView = this.fragmentContainerView;
        if (fragmentContainerView != null) {
            int fragmentContainerId = fragmentContainerView.getId();
            Fragment forceLoginFragment = getChildFragmentManager().findFragmentByTag(Reflection.getOrCreateKotlinClass(HomeUserCenterForceLoginFragment.class).getSimpleName());
            FragmentManager $this$commit$iv = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue($this$commit$iv, "getChildFragmentManager(...)");
            FragmentTransaction transaction$iv = $this$commit$iv.beginTransaction();
            boolean z = false;
            if (forceLoginFragment != null && forceLoginFragment.isAdded()) {
                z = true;
            }
            if (z) {
                transaction$iv.show(forceLoginFragment);
            } else {
                if (forceLoginFragment == null) {
                    HomeUserCenterForceLoginFragment $this$showForceLoginFragment_u24lambda_u240_u240_u240 = new HomeUserCenterForceLoginFragment();
                    Bundle it = new Bundle();
                    it.putBoolean(InnerLoginFragmentKt.KEY_ENABLE_AUTO_FULLSCREEN_LOGIN, fromPageSelected);
                    $this$showForceLoginFragment_u24lambda_u240_u240_u240.setArguments(it);
                    Unit unit = Unit.INSTANCE;
                    fragment = (Fragment) $this$showForceLoginFragment_u24lambda_u240_u240_u240;
                } else {
                    fragment = forceLoginFragment;
                }
                transaction$iv.add(fragmentContainerId, fragment, Reflection.getOrCreateKotlinClass(HomeUserCenterForceLoginFragment.class).getSimpleName());
            }
            transaction$iv.commitAllowingStateLoss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dismissForceLoginFragment() {
        Fragment forceLoginFragment = getChildFragmentManager().findFragmentByTag(Reflection.getOrCreateKotlinClass(HomeUserCenterForceLoginFragment.class).getSimpleName());
        FragmentManager $this$commit$iv = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue($this$commit$iv, "getChildFragmentManager(...)");
        FragmentTransaction transaction$iv = $this$commit$iv.beginTransaction();
        boolean z = false;
        if (forceLoginFragment != null && forceLoginFragment.isAdded()) {
            z = true;
        }
        if (z) {
            transaction$iv.remove(forceLoginFragment);
        }
        transaction$iv.commitAllowingStateLoss();
    }

    static /* synthetic */ void changeForceLoginFragmentVisibility$default(HomeUserCenterFragment homeUserCenterFragment, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        homeUserCenterFragment.changeForceLoginFragmentVisibility(z, z2);
    }

    private final void changeForceLoginFragmentVisibility(boolean isLogin, boolean fromPageSelected) {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new HomeUserCenterFragment$changeForceLoginFragmentVisibility$1(this, isLogin, fromPageSelected, null), 3, (Object) null);
    }

    private final void initBottomContent() {
        final FrameLayout $this$initBottomContent_u24lambda_u240 = this.mRootView;
        if ($this$initBottomContent_u24lambda_u240 != null) {
            this.mRefreshLayout = $this$initBottomContent_u24lambda_u240.findViewById(tv.danmaku.bili.R.id.refresh_layout);
            TintSwipeRefreshLayout tintSwipeRefreshLayout = this.mRefreshLayout;
            if (tintSwipeRefreshLayout != null) {
                tintSwipeRefreshLayout.setColorSchemeResources(new int[]{com.bilibili.app.comm.baseres.R.color.theme_color_secondary});
            }
            TintSwipeRefreshLayout tintSwipeRefreshLayout2 = this.mRefreshLayout;
            if (tintSwipeRefreshLayout2 != null) {
                tintSwipeRefreshLayout2.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$$ExternalSyntheticLambda1
                    public final void onRefresh() {
                        HomeUserCenterFragment.initBottomContent$lambda$0$0(HomeUserCenterFragment.this);
                    }
                });
            }
            this.mRecycleView = $this$initBottomContent_u24lambda_u240.findViewById(tv.danmaku.bili.R.id.mine_recycle);
            final Context context = $this$initBottomContent_u24lambda_u240.getContext();
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context) { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$initBottomContent$1$linearLayoutManager$1
                public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
                    final Context context2 = $this$initBottomContent_u24lambda_u240.getContext();
                    RecyclerView.SmoothScroller smoothScroller = new LinearSmoothScroller(context2) { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$initBottomContent$1$linearLayoutManager$1$smoothScrollToPosition$linearSmoothScroller$1
                        protected int getVerticalSnapPreference() {
                            return -1;
                        }
                    };
                    smoothScroller.setTargetPosition(position);
                    startSmoothScroll(smoothScroller);
                }
            };
            layoutManager.setOrientation(1);
            this.mAdapter = new HomeUserCenterAdapter(this, this.mMineItemClickListener);
            RecyclerView $this$initBottomContent_u24lambda_u240_u241 = this.mRecycleView;
            if ($this$initBottomContent_u24lambda_u240_u241 != null) {
                $this$initBottomContent_u24lambda_u240_u241.setItemAnimator((RecyclerView.ItemAnimator) null);
                $this$initBottomContent_u24lambda_u240_u241.setLayoutManager(layoutManager);
                $this$initBottomContent_u24lambda_u240_u241.setAdapter(this.mAdapter);
                HomeUserCenterAdapter homeUserCenterAdapter = this.mAdapter;
                if (homeUserCenterAdapter != null) {
                    homeUserCenterAdapter.setData(this.mSectionListV2);
                }
                int contentPadding = $this$initBottomContent_u24lambda_u240_u241.getContext().getResources().getDimensionPixelOffset(com.bilibili.lib.homepage.R.dimen.bottom_navigation_height_with_bg);
                $this$initBottomContent_u24lambda_u240_u241.setPadding(0, 0, 0, contentPadding);
                $this$initBottomContent_u24lambda_u240_u241.setClipToPadding(false);
                this.exposeClient = ListExposer.Companion.with($this$initBottomContent_u24lambda_u240_u241).supportChildExpose(true).setItemConvert(new RecyclerViewItemConvert()).clipBottom(contentPadding).build();
                $this$initBottomContent_u24lambda_u240_u241.addOnScrollListener(new RecycleViewScrollListen());
                this.mScrollReporter.setRecyclerView($this$initBottomContent_u24lambda_u240_u241);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initBottomContent$lambda$0$0(HomeUserCenterFragment this$0) {
        AccountMineInfoManager.getInstance().refreshInfo((Context) this$0.getActivity(), IFragmentShowHideKt.isFragmentShown((Fragment) this$0), AccountMineRequestResource.REFRESH, this$0.mMineChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HomeUserCenterFragment.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/HomeUserCenterFragment$RecycleViewScrollListen;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "<init>", "(Ltv/danmaku/bili/ui/main2/mine/HomeUserCenterFragment;)V", "currentState", "", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public final class RecycleViewScrollListen extends RecyclerView.OnScrollListener {
        private boolean currentState;

        public RecycleViewScrollListen() {
        }

        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            int state;
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx, dy);
            int childCount = recyclerView.getChildCount();
            for (int index = 0; index < childCount; index++) {
                RecyclerView.ViewHolder viewHolder = recyclerView.getChildViewHolder(recyclerView.getChildAt(index));
                if ((viewHolder instanceof MineNotUpperModuleHolder) && (state = ((MineNotUpperModuleHolder) viewHolder).onUpperTipsViewShow()) != 0) {
                    HomeUserCenterFragment.this.mIsUpperTipsShow = state == 1;
                    if (this.currentState != HomeUserCenterFragment.this.mIsUpperTipsShow) {
                        if (HomeUserCenterFragment.this.mIsUpperTipsShow) {
                            MineReporter.reportMineUpperTipsShow();
                        }
                        this.currentState = HomeUserCenterFragment.this.mIsUpperTipsShow;
                    }
                }
            }
        }
    }

    private final boolean isTeenagerMode() {
        return TeenagersMode.getInstance().getEntranceState("vip") == 0 || RestrictedMode.isEnable(RestrictedType.LESSONS, "vip");
    }

    private final void initAccountLayout() {
        FrameLayout $this$initAccountLayout_u24lambda_u240 = this.mRootView;
        if ($this$initAccountLayout_u24lambda_u240 != null) {
            this.mAmountLayout = (ViewGroup) $this$initAccountLayout_u24lambda_u240.findViewById(tv.danmaku.bili.R.id.amount_layout);
            this.mFollowingLayout = $this$initAccountLayout_u24lambda_u240.findViewById(tv.danmaku.bili.R.id.following_layout);
            this.mFollowingCount = (TextView) $this$initAccountLayout_u24lambda_u240.findViewById(tv.danmaku.bili.R.id.following_count);
            this.mAttentionLayout = $this$initAccountLayout_u24lambda_u240.findViewById(tv.danmaku.bili.R.id.attention_layout);
            this.mAttentionCount = (TextView) $this$initAccountLayout_u24lambda_u240.findViewById(tv.danmaku.bili.R.id.attention_count);
            this.mFansLayout = $this$initAccountLayout_u24lambda_u240.findViewById(tv.danmaku.bili.R.id.fans_layout);
            this.mFansCount = (TextView) $this$initAccountLayout_u24lambda_u240.findViewById(tv.danmaku.bili.R.id.fans_count);
            this.mFansBubble = (TextView) $this$initAccountLayout_u24lambda_u240.findViewById(tv.danmaku.bili.R.id.mine_fans_bubble);
            this.mFansAchieveMedal = (LinearLayout) $this$initAccountLayout_u24lambda_u240.findViewById(tv.danmaku.bili.R.id.mine_fans_achievement_medal);
            this.mFansAchieveMedalText = (TextView) $this$initAccountLayout_u24lambda_u240.findViewById(tv.danmaku.bili.R.id.mine_fans_achievement_text);
            this.mFansAchieveMedalImage = $this$initAccountLayout_u24lambda_u240.findViewById(tv.danmaku.bili.R.id.mine_fans_achievement_image);
            this.mFansAchieveBadge = $this$initAccountLayout_u24lambda_u240.findViewById(tv.danmaku.bili.R.id.mine_fans_achievement_badge);
            this.mFansDesc = $this$initAccountLayout_u24lambda_u240.findViewById(tv.danmaku.bili.R.id.fans_dec);
            this.mSplitLine1 = $this$initAccountLayout_u24lambda_u240.findViewById(tv.danmaku.bili.R.id.line1);
            this.mSplitLine2 = $this$initAccountLayout_u24lambda_u240.findViewById(tv.danmaku.bili.R.id.line2);
            this.mAnimatorHelper = new NavigationFragmentAnimatorHelper();
            NavigationFragmentAnimatorHelper navigationFragmentAnimatorHelper = this.mAnimatorHelper;
            if (navigationFragmentAnimatorHelper != null) {
                TextView textView = this.mFansBubble;
                Intrinsics.checkNotNull(textView);
                navigationFragmentAnimatorHelper.bindViews(textView);
            }
        }
        View view = this.mFollowingLayout;
        if (view != null) {
            view.setOnClickListener(this);
        }
        View view2 = this.mAttentionLayout;
        if (view2 != null) {
            view2.setOnClickListener(this);
        }
        View view3 = this.mFansLayout;
        if (view3 != null) {
            view3.setOnClickListener(this);
        }
    }

    private final void initUserInfoLayout() {
        View guideView;
        FrameLayout $this$initUserInfoLayout_u24lambda_u240 = this.mRootView;
        if ($this$initUserInfoLayout_u24lambda_u240 != null) {
            this.mUserInfoLayout = $this$initUserInfoLayout_u24lambda_u240.findViewById(tv.danmaku.bili.R.id.mine_user_info_layout);
            this.mAvatar = (MineAvatarFrameLayout) $this$initUserInfoLayout_u24lambda_u240.findViewById(tv.danmaku.bili.R.id.avatar_layout);
            this.mLayerAvatar = $this$initUserInfoLayout_u24lambda_u240.findViewById(tv.danmaku.bili.R.id.layer_avatar);
            setAvatar(null);
            this.mUserInfo = $this$initUserInfoLayout_u24lambda_u240.findViewById(tv.danmaku.bili.R.id.mine_user_info);
            this.mNickName = (NickNameTextView) $this$initUserInfoLayout_u24lambda_u240.findViewById(tv.danmaku.bili.R.id.nick_name);
            this.mUserHandle = (TextView) $this$initUserInfoLayout_u24lambda_u240.findViewById(tv.danmaku.bili.R.id.user_handle);
            this.mNickNameGuideView = $this$initUserInfoLayout_u24lambda_u240.findViewById(tv.danmaku.bili.R.id.nick_view_guide);
            View view = this.mNickNameGuideView;
            if (view != null) {
                view.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$$ExternalSyntheticLambda13
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        HomeUserCenterFragment.initUserInfoLayout$lambda$0$0(HomeUserCenterFragment.this, view2);
                    }
                });
            }
            this.mLevelLabel = (ImageView) $this$initUserInfoLayout_u24lambda_u240.findViewById(tv.danmaku.bili.R.id.level_label);
            View $this$initUserInfoLayout_u24lambda_u240_u241 = $this$initUserInfoLayout_u24lambda_u240.findViewById(tv.danmaku.bili.R.id.edit_information);
            $this$initUserInfoLayout_u24lambda_u240_u241.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$$ExternalSyntheticLambda14
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    HomeUserCenterFragment.initUserInfoLayout$lambda$0$1$0(HomeUserCenterFragment.this, view2);
                }
            });
            this.editImage = $this$initUserInfoLayout_u24lambda_u240_u241;
            this.mLevelSeniorEntranceLabel = (ImageView) $this$initUserInfoLayout_u24lambda_u240.findViewById(tv.danmaku.bili.R.id.level_senior_entrance_label);
            this.mLevelSeniorEntranceArrow = (ImageView) $this$initUserInfoLayout_u24lambda_u240.findViewById(tv.danmaku.bili.R.id.level_senior_entrance_arrow);
            this.mLevelSeniorEntranceText = (TextView) $this$initUserInfoLayout_u24lambda_u240.findViewById(tv.danmaku.bili.R.id.level_senior_entrance_text);
            this.mLevelSeniorEntrance = $this$initUserInfoLayout_u24lambda_u240.findViewById(tv.danmaku.bili.R.id.level_senior_entrance);
            this.mRankStatus = (TextView) $this$initUserInfoLayout_u24lambda_u240.findViewById(tv.danmaku.bili.R.id.rank_status);
            this.mVipStatus = (TextView) $this$initUserInfoLayout_u24lambda_u240.findViewById(tv.danmaku.bili.R.id.vip_status);
            this.mVipStatusImage = $this$initUserInfoLayout_u24lambda_u240.findViewById(tv.danmaku.bili.R.id.vip_status_image);
            this.mAccountStatus = (TextView) $this$initUserInfoLayout_u24lambda_u240.findViewById(tv.danmaku.bili.R.id.account_status);
            this.mUserBpCount = (TextView) $this$initUserInfoLayout_u24lambda_u240.findViewById(tv.danmaku.bili.R.id.user_bp_count);
            this.mUserCoinCount = (TextView) $this$initUserInfoLayout_u24lambda_u240.findViewById(tv.danmaku.bili.R.id.user_coin_count);
            this.mGotoSpace = $this$initUserInfoLayout_u24lambda_u240.findViewById(tv.danmaku.bili.R.id.tv_go_to_space);
            this.mClickLogin = (TextView) $this$initUserInfoLayout_u24lambda_u240.findViewById(tv.danmaku.bili.R.id.tv_login);
            MineAvatarFrameLayout mineAvatarFrameLayout = this.mAvatar;
            if (mineAvatarFrameLayout == null || (guideView = mineAvatarFrameLayout.getGuideView()) == null) {
                return;
            }
            guideView.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$$ExternalSyntheticLambda15
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    HomeUserCenterFragment.initUserInfoLayout$lambda$0$2(HomeUserCenterFragment.this, view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initUserInfoLayout$lambda$0$0(HomeUserCenterFragment this$0, View it) {
        BLRouter.routeTo(new RouteRequest.Builder("bilibili://personinfo/modify-name").extras(new Function1() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$$ExternalSyntheticLambda18
            public final Object invoke(Object obj) {
                Unit initUserInfoLayout$lambda$0$0$0;
                initUserInfoLayout$lambda$0$0$0 = HomeUserCenterFragment.initUserInfoLayout$lambda$0$0$0((MutableBundleLike) obj);
                return initUserInfoLayout$lambda$0$0$0;
            }
        }).requestCode(17).build(), (Fragment) this$0);
        MineReporter.INSTANCE.reportClick(MineReporter.MINE_NICK_NAME_GUIDE_CLICK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initUserInfoLayout$lambda$0$0$0(MutableBundleLike $this$extras) {
        Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
        $this$extras.put("key_modify_name_from", LoginReporterV2.Show.SMS_LOGIN_DIALOG_FROM_USER_CENTER);
        $this$extras.put("key_modify_name_scene", "3");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initUserInfoLayout$lambda$0$1$0(HomeUserCenterFragment this$0, View it) {
        this$0.infoEditOnClick.onClick(it);
        MineReporter.INSTANCE.reportClick(MineReporter.MINE_EDIT_INFO_ICON_CLICK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initUserInfoLayout$lambda$0$2(HomeUserCenterFragment this$0, View it) {
        AvatarChooser avatarChooser = new AvatarChooser(this$0.getActivity(), (Fragment) this$0, true, this$0.mUploadCallback);
        avatarChooser.showAll(true, new AvatarChooser.OnItemClickListener() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$$ExternalSyntheticLambda0
            public final void onItemClick(AvatarChooser.PhotoSource photoSource) {
                HomeUserCenterFragment.initUserInfoLayout$lambda$0$2$0(photoSource);
            }
        });
        MineReporter.INSTANCE.reportClick(MineReporter.MINE_AVATAR_GUIDE_CLICK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initUserInfoLayout$lambda$0$2$0(AvatarChooser.PhotoSource it) {
    }

    private final void initTopView() {
        FrameLayout $this$initTopView_u24lambda_u240 = this.mRootView;
        if ($this$initTopView_u24lambda_u240 != null) {
            this.mHeaderView = (ViewGroup) $this$initTopView_u24lambda_u240.findViewById(tv.danmaku.bili.R.id.head_layout);
            this.fragmentContainerView = $this$initTopView_u24lambda_u240.findViewById(tv.danmaku.bili.R.id.fragment_container);
            this.mMintTopLayout = $this$initTopView_u24lambda_u240.findViewById(tv.danmaku.bili.R.id.mine_top_view);
            this.mMineGarbLayout = (FrameLayout) $this$initTopView_u24lambda_u240.findViewById(tv.danmaku.bili.R.id.main_top_layout);
            this.mMineGarbBgImageVew = (ImageView) $this$initTopView_u24lambda_u240.findViewById(tv.danmaku.bili.R.id.main_top_bg_imageview);
            this.mMineScan = $this$initTopView_u24lambda_u240.findViewById(tv.danmaku.bili.R.id.mine_scan);
            this.mMineGlobalLinkEntrance = (MineGlobalLinkEntranceView) $this$initTopView_u24lambda_u240.findViewById(tv.danmaku.bili.R.id.mine_global_link_entrance);
            MineGlobalLinkEntranceView mineGlobalLinkEntranceView = this.mMineGlobalLinkEntrance;
            if (mineGlobalLinkEntranceView != null) {
                mineGlobalLinkEntranceView.setVisibility(8);
            }
            this.mMineThemeIcon = $this$initTopView_u24lambda_u240.findViewById(tv.danmaku.bili.R.id.mine_theme_icon);
            this.mMineThemeStoreView = (MultipleThemeImageView) $this$initTopView_u24lambda_u240.findViewById(tv.danmaku.bili.R.id.mine_theme_store_view);
            this.mMineDayNightSetting = (MultipleThemeImageView) $this$initTopView_u24lambda_u240.findViewById(tv.danmaku.bili.R.id.mine_day_night_setting);
            this.mAnswerView = (ChameleonAnswerView) $this$initTopView_u24lambda_u240.findViewById(tv.danmaku.bili.R.id.answer_entry);
            this.topLeftCompose = $this$initTopView_u24lambda_u240.findViewById(tv.danmaku.bili.R.id.left_top_compose);
            $this$initTopView_u24lambda_u240.findViewById(tv.danmaku.bili.R.id.mine_theme_layout).setOnClickListener(this);
            configHeaderView();
        }
        View view = this.mMineScan;
        if (view != null) {
            view.setOnClickListener(this);
        }
        MineGlobalLinkEntranceView mineGlobalLinkEntranceView2 = this.mMineGlobalLinkEntrance;
        if (mineGlobalLinkEntranceView2 != null) {
            mineGlobalLinkEntranceView2.setOnClickListener(this);
        }
        MultipleThemeImageView multipleThemeImageView = this.mMineDayNightSetting;
        if (multipleThemeImageView != null) {
            multipleThemeImageView.setOnClickListener(this);
        }
        switchDailyNightIcon();
    }

    private final void configHeaderView() {
        ViewTreeObserver viewTreeObserver;
        ViewGroup viewGroup = this.mHeaderView;
        if (viewGroup == null || (viewTreeObserver = viewGroup.getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$configHeaderView$1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                ViewGroup viewGroup2;
                ViewTreeObserver viewTreeObserver2;
                viewGroup2 = HomeUserCenterFragment.this.mHeaderView;
                if (viewGroup2 == null || (viewTreeObserver2 = viewGroup2.getViewTreeObserver()) == null) {
                    return;
                }
                viewTreeObserver2.removeOnGlobalLayoutListener(this);
            }
        });
    }

    private final void initProjectionLink() {
        ProjectionClient projectionClient;
        if (this.mProjectionClient != null || this.mViewContainer == null) {
            return;
        }
        this.mProjectionService = (ProjectionService) BLRouter.get$default(BLRouter.INSTANCE, ProjectionService.class, (String) null, 2, (Object) null);
        ProjectionClientConfig config = ProjectionClientConfig.Companion.obtain(6);
        ProjectionService projectionService = this.mProjectionService;
        this.mProjectionClient = projectionService != null ? projectionService.newClient(config) : null;
        ViewGroup it = this.mViewContainer;
        if (it != null && (projectionClient = this.mProjectionClient) != null) {
            projectionClient.attach(it);
        }
        MineGlobalLinkEntranceView mineGlobalLinkEntranceView = this.mMineGlobalLinkEntrance;
        if (mineGlobalLinkEntranceView != null) {
            mineGlobalLinkEntranceView.setProjectionClient(this.mProjectionClient);
        }
    }

    private final void configGlobalLinkBubble() {
        MineGlobalLinkEntranceView it = this.mMineGlobalLinkEntrance;
        if (this.mGlobalLinkGuideBubbleNeedInit && it != null && it.getVisibility() == 0 && ProjectionClientUtilsKt.getGuideBubbleFirstShow(3)) {
            ProjectionClient projectionClient = this.mProjectionClient;
            if ((projectionClient != null ? projectionClient.getCastableDeviceNum() : 0) <= 0) {
                return;
            }
            this.globalLinkShowing = true;
            initGlobalLinkGuideBubble();
            AccountMine mMineInfo = getMMineInfo();
            setGlobalLinkGuideBubbleCallback(mMineInfo != null ? mMineInfo.biliLinkBubble : null);
            showGlobalLinkGuideBubble();
        }
    }

    private final void initGlobalLinkGuideBubble() {
        View popupView = View.inflate(getContext(), tv.danmaku.biliscreencast.R.layout.bili_projection_globallink_guide_bubble, null);
        MineGlobalLinkEntranceView mineGlobalLinkEntranceView = this.mMineGlobalLinkEntrance;
        Intrinsics.checkNotNull(mineGlobalLinkEntranceView);
        PopupGuideBubble $this$initGlobalLinkGuideBubble_u24lambda_u240 = new PopupGuideBubble(popupView, mineGlobalLinkEntranceView, 3, 1, 0, 0, 48, (DefaultConstructorMarker) null);
        $this$initGlobalLinkGuideBubble_u24lambda_u240.setFocusable(false);
        $this$initGlobalLinkGuideBubble_u24lambda_u240.setOutsideTouchable(true);
        $this$initGlobalLinkGuideBubble_u24lambda_u240.setClickListener(new View.OnTouchListener() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$$ExternalSyntheticLambda24
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean initGlobalLinkGuideBubble$lambda$0$0;
                initGlobalLinkGuideBubble$lambda$0$0 = HomeUserCenterFragment.initGlobalLinkGuideBubble$lambda$0$0(HomeUserCenterFragment.this, view, motionEvent);
                return initGlobalLinkGuideBubble$lambda$0$0;
            }
        });
        this.mGlobalLinkBubble = $this$initGlobalLinkGuideBubble_u24lambda_u240;
        this.mGlobalLinkGuideBubbleNeedInit = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initGlobalLinkGuideBubble$lambda$0$0(HomeUserCenterFragment this$0, View v, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(v, "v");
        this$0.hideGlobalLinkBubble();
        return v.performClick();
    }

    private final void setGlobalLinkGuideBubbleCallback(final AccountMine.BiliLinkBubble bubble) {
        PopupGuideBubble popupGuideBubble;
        if (bubble != null && (popupGuideBubble = this.mGlobalLinkBubble) != null) {
            popupGuideBubble.setGuideBubbleCallback(new PopupGuideBubble.GuideBubbleCallback() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$setGlobalLinkGuideBubbleCallback$1
                public boolean onBubbleNeedShow() {
                    boolean z;
                    z = HomeUserCenterFragment.this.mGlobalLinkGuideBubbleNeedShow;
                    return z;
                }

                public void onBubblePicLoad() {
                    PopupGuideBubble popupGuideBubble2;
                    View contentView;
                    BiliImageView bubblePic;
                    popupGuideBubble2 = HomeUserCenterFragment.this.mGlobalLinkBubble;
                    if (popupGuideBubble2 == null || (contentView = popupGuideBubble2.getContentView()) == null || (bubblePic = contentView.findViewById(tv.danmaku.biliscreencast.R.id.mine_global_link_bubble_pic)) == null) {
                        return;
                    }
                    String url = bubble.pic;
                    Context it = HomeUserCenterFragment.this.getContext();
                    if (it != null) {
                        String str = url;
                        if (str == null || StringsKt.isBlank(str)) {
                            bubblePic.setBackground(ResourcesCompat.getDrawable(it.getResources(), tv.danmaku.biliscreencast.R.drawable.projection_globallink_guide_icon, it.getTheme()));
                        } else {
                            BiliImageLoader.INSTANCE.with(it).url(url).into(bubblePic);
                        }
                    }
                }

                public void onBubbleTextLoad() {
                    PopupGuideBubble popupGuideBubble2;
                    View contentView;
                    TextView bubbleText;
                    popupGuideBubble2 = HomeUserCenterFragment.this.mGlobalLinkBubble;
                    if (popupGuideBubble2 == null || (contentView = popupGuideBubble2.getContentView()) == null || (bubbleText = (TextView) contentView.findViewById(tv.danmaku.biliscreencast.R.id.mine_global_link_bubble_text)) == null) {
                        return;
                    }
                    String txt = bubble.desc;
                    Context it = HomeUserCenterFragment.this.getContext();
                    if (it != null) {
                        String str = txt;
                        bubbleText.setText(str == null || StringsKt.isBlank(str) ? it.getString(bili.resource.homepage.R.string.homepage_global_string_30) : txt);
                    }
                }

                public void onBubbleShowSuccess(boolean isFirstShow) {
                    MineReporter.reportMineGlobalLinkBubbleShow(Integer.valueOf(bubble.id), ProjectionClientUtilsKt.getGuideBubbleFirstShow(0) ? "1" : "0");
                    HomeUserCenterFragment.this.globalLinkShowing = false;
                }

                public void onBubbleShowFailed() {
                    HomeUserCenterFragment.this.globalLinkShowing = false;
                }

                public void onBubbleDismiss() {
                    HomeUserCenterFragment.this.globalLinkShowing = false;
                }
            });
        }
    }

    private final void showGlobalLinkGuideBubble() {
        this.mGlobalLinkGuideBubbleNeedShow = true;
        PopupGuideBubble popupGuideBubble = this.mGlobalLinkBubble;
        if (popupGuideBubble != null) {
            PopupGuideBubble.show$default(popupGuideBubble, -45, -20, 0L, 4, (Object) null);
        }
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View it = this.mMintTopLayout;
        if (it != null) {
            ViewGroup.LayoutParams layoutParams = it.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = StatusBarCompat.getStatusBarHeight(view.getContext());
            it.setLayoutParams(marginLayoutParams);
        }
        View it2 = view.findViewById(tv.danmaku.bili.R.id.mine_vip_layout_refactoring);
        if (it2 != null) {
            BiliLayoutMineVipModuleRefactoringBinding bind = BiliLayoutMineVipModuleRefactoringBinding.bind(it2);
            Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            this.mineVipModuleManager = new MineVipModuleManager(bind, viewLifecycleOwner);
        }
        MineVipModuleManager mineVipModuleManager = this.mineVipModuleManager;
        if (mineVipModuleManager != null) {
            mineVipModuleManager.onTeenagerMode(isTeenagerMode());
        }
        ThemeWatcher.getInstance().subscribe(this);
        GarbWatcher.INSTANCE.subscribe(this);
        onSkinChange(GarbManager.getCurGarb());
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner2), (CoroutineContext) null, (CoroutineStart) null, new HomeUserCenterFragment$onViewCreated$3(this, null), 3, (Object) null);
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner3), (CoroutineContext) null, (CoroutineStart) null, new HomeUserCenterFragment$onViewCreated$4(this, null), 3, (Object) null);
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner4), (CoroutineContext) null, (CoroutineStart) null, new HomeUserCenterFragment$onViewCreated$5(this, null), 3, (Object) null);
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner5), (CoroutineContext) null, (CoroutineStart) null, new HomeUserCenterFragment$onViewCreated$6(this, null), 3, (Object) null);
        HomeUserCenterViewModelKt.mineLog("onViewCreated");
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        HomeUserCenterViewModelKt.mineLog("onActivityCreated");
    }

    public void onResume() {
        super.onResume();
        if (this.mIsFragmentSelected) {
            MineVipModuleManager mineVipModuleManager = this.mineVipModuleManager;
            if (mineVipModuleManager != null) {
                mineVipModuleManager.reportExposure();
            }
            if (this.mIsUpperTipsShow) {
                MineReporter.reportMineUpperTipsShow();
            }
            if (!this.mNeedRefresh) {
                this.mNeedRefresh = true;
            } else {
                AccountMineInfoManager.getInstance().refreshInfo((Context) getActivity(), IFragmentShowHideKt.isFragmentShown((Fragment) this), AccountMineRequestResource.RESUME, this.mMineChangeListener);
            }
        }
    }

    public void onPause() {
        super.onPause();
        MineVipModuleManager mineVipModuleManager = this.mineVipModuleManager;
        if (mineVipModuleManager != null) {
            mineVipModuleManager.onPageInvisible();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        BiliAccounts.get(getActivity()).unsubscribeAllWithSwitch(this);
    }

    public void onDestroyView() {
        super.onDestroyView();
        resetVipReportJob();
        ThemeWatcher.getInstance().unSubscribe(this);
        GarbWatcher.INSTANCE.unSubscribe(this);
        FansAchievementHelper fansAchievementHelper = this.fansAchievementHelper;
        if (fansAchievementHelper != null) {
            fansAchievementHelper.dismiss();
        }
        this.fansAchievementHelper = null;
        NavigationFragmentAnimatorHelper navigationFragmentAnimatorHelper = this.mAnimatorHelper;
        if (navigationFragmentAnimatorHelper != null) {
            navigationFragmentAnimatorHelper.cancelBubbleAnimator();
        }
        AccountMineInfoManager.getInstance().cancelRefresh();
        this.mRegisterMap.clear();
        MinePageManager minePageManager = this.mPageManager;
        if (minePageManager != null) {
            minePageManager.onMineMenuDestroy();
        }
        MineGlobalLinkEntranceView mineGlobalLinkEntranceView = this.mMineGlobalLinkEntrance;
        if (mineGlobalLinkEntranceView != null) {
            mineGlobalLinkEntranceView.clearProjectionCallback();
        }
        removerBadge();
        ProjectionClient projectionClient = this.mProjectionClient;
        if (projectionClient != null) {
            projectionClient.detach();
        }
        ProjectionClient projectionClient2 = this.mProjectionClient;
        if (projectionClient2 != null) {
            projectionClient2.release();
        }
        this.mProjectionClient = null;
        this.topLeftCompose = null;
    }

    public void onStop() {
        super.onStop();
        resetVipReportJob();
    }

    private final void removerBadge() {
        for (String str : this.mListenerMap.keySet()) {
            Intrinsics.checkNotNullExpressionValue(str, "next(...)");
            String key = str;
            BadgeManager.OnChangedListener it = this.mListenerMap.get(key);
            if (it != null) {
                BadgeManager.getInstance().unregister(key, it);
            }
        }
        this.mListenerMap.clear();
    }

    static /* synthetic */ void onUserStatusLoaded$default(HomeUserCenterFragment homeUserCenterFragment, AccountMine accountMine, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        homeUserCenterFragment.onUserStatusLoaded(accountMine, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onUserStatusLoaded(AccountMine mineInfo, boolean isFromCache) {
        renderUserInfo(mineInfo);
        renderProjectionBLinkEntrance(mineInfo);
        renderMine(mineInfo, isFromCache);
        renderVipEntrance(mineInfo, isFromCache);
        renderGarbEntrance(mineInfo != null ? mineInfo.garbEntrance : null);
    }

    private final void renderVipEntrance(AccountMine mineInfo, boolean fromCache) {
        resetVipReportJob();
        vipEntranceRealExposure();
        MineVipModuleManager mineVipModuleManager = this.mineVipModuleManager;
        if (mineVipModuleManager != null) {
            mineVipModuleManager.update(mineInfo, fromCache);
        }
    }

    private final void resetVipReportJob() {
        Job job = this.displayStrategiesReportJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.displayStrategiesReportJob = null;
        Job job2 = this.vipEntranceExposureJob;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        this.vipEntranceExposureJob = null;
    }

    private final void vipEntranceRealExposure() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        this.vipEntranceExposureJob = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new HomeUserCenterFragment$vipEntranceRealExposure$1(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Flow<Unit> adapterDataChangedFlow(HomeUserCenterAdapter $this$adapterDataChangedFlow) {
        return FlowKt.callbackFlow(new HomeUserCenterFragment$adapterDataChangedFlow$1($this$adapterDataChangedFlow, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onMenuUpdate(AccountMine mineInfo) {
        Context it;
        List<MenuGroup> defaultMineSections;
        if (this.mPageManager != null && (it = getContext()) != null) {
            if (mineInfo == null || (defaultMineSections = mineInfo.sectionListV2) == null) {
                defaultMineSections = AccountMineInfoManager.defaultMineSections(it);
                Intrinsics.checkNotNullExpressionValue(defaultMineSections, "defaultMineSections(...)");
            }
            buildMineMenu(it, defaultMineSections, mineInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderAnswer(AccountMine mineInfo) {
        Boolean bool;
        AccountMine.Answer $this$renderAnswer_u24lambda_u241;
        AccountMine.Answer answer;
        ChameleonAnswerView chameleonAnswerView = this.mAnswerView;
        if (chameleonAnswerView != null) {
            chameleonAnswerView.setVisibility(8);
        }
        AccountMine.ActivityAnswer activityAnswer = null;
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
            HomeUserCenterViewModel $this$renderAnswer_u24lambda_u240 = getViewModel();
            bool = Boolean.valueOf(((AccountMineData) $this$renderAnswer_u24lambda_u240.getMineData().getValue()).getShowTeenagersAgeSetting());
        } else {
            bool = null;
        }
        boolean showTeensAge = bool != null ? bool.booleanValue() : false;
        if (!showTeensAge) {
            if (mineInfo != null && (answer = mineInfo.answer) != null) {
                activityAnswer = answer.activityAnswer;
            }
            if (activityAnswer == null && mineInfo != null && ($this$renderAnswer_u24lambda_u241 = mineInfo.answer) != null) {
                ChameleonAnswerView chameleonAnswerView2 = this.mAnswerView;
                if (chameleonAnswerView2 != null) {
                    chameleonAnswerView2.setVisibility(0);
                }
                ChameleonAnswerView chameleonAnswerView3 = this.mAnswerView;
                if (chameleonAnswerView3 != null) {
                    chameleonAnswerView3.update($this$renderAnswer_u24lambda_u241.progress, $this$renderAnswer_u24lambda_u241.url, $this$renderAnswer_u24lambda_u241.text);
                }
                Neurons.reportExposure$default(false, "main.my-information.answer-in-guide.0.show", MapsKt.mapOf(TuplesKt.to("type", MineVipServiceKt.VIP_REPORT_VALUE_NORMAL)), (List) null, 8, (Object) null);
            }
        }
    }

    private final void renderUserInfo(AccountMine mineInfo) {
        if (mineInfo == null || !BiliAccounts.get(getActivity()).isLogin()) {
            View view = this.mUserInfo;
            if (view != null) {
                view.setVisibility(4);
            }
            TextView textView = this.mClickLogin;
            if (textView != null) {
                textView.setVisibility(0);
            }
            setAvatar(null);
            seniorFlashPopHide();
        } else {
            View view2 = this.mUserInfo;
            if (view2 != null) {
                view2.setVisibility(0);
            }
            TextView textView2 = this.mClickLogin;
            if (textView2 != null) {
                textView2.setVisibility(4);
            }
            update(mineInfo);
        }
        View view3 = this.mUserInfoLayout;
        if (view3 != null) {
            view3.setOnClickListener(this.mLoginClickListener);
        }
        MineAvatarFrameLayout mineAvatarFrameLayout = this.mAvatar;
        if (mineAvatarFrameLayout != null) {
            mineAvatarFrameLayout.setOnClickListener(this.mLoginClickListener);
        }
        LayerAvatarView layerAvatarView = this.mLayerAvatar;
        if (layerAvatarView != null) {
            layerAvatarView.setOnClickListener(this.mLoginClickListener);
        }
    }

    private final String setEditUrlShowHint(boolean showHint) {
        String builder = Uri.parse("activity://personinfo/info").buildUpon().appendQueryParameter("from_campus_user", String.valueOf(showHint)).toString();
        Intrinsics.checkNotNullExpressionValue(builder, "toString(...)");
        this.infoEditUrl = builder;
        return this.infoEditUrl;
    }

    private final String getGuideBubbleKey(AccountMine.GuideBubble $this$getGuideBubbleKey, long mid) {
        return HomeUserCenterFragmentKt.KEY_BUBBLE_SHOWN + $this$getGuideBubbleKey.id + HomeUserCenterFragmentKt.KEY_BUBBLE_USER + mid;
    }

    private final void memberReminderBubble(final String content) {
        final Context context;
        final View $this$doOnPreDraw$iv;
        String str = content;
        boolean z = true;
        if ((str == null || StringsKt.isBlank(str)) || (context = getContext()) == null) {
            return;
        }
        View view = this.mLevelSeniorEntrance;
        if (view == null || view.getVisibility() != 0) {
            z = false;
        }
        if (!z || ($this$doOnPreDraw$iv = this.mLevelSeniorEntrance) == null) {
            return;
        }
        OneShotPreDrawListener.add($this$doOnPreDraw$iv, new Runnable() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$memberReminderBubble$$inlined$doOnPreDraw$1
            @Override // java.lang.Runnable
            public final void run() {
                View $this$memberReminderBubble_u24lambda_u240_u240;
                final PopupWindow pop;
                int width;
                View view2 = $this$doOnPreDraw$iv;
                $this$memberReminderBubble_u24lambda_u240_u240 = this.mLevelSeniorEntrance;
                if ($this$memberReminderBubble_u24lambda_u240_u240 == null) {
                    return;
                }
                View contentView = LayoutInflater.from(context).inflate(tv.danmaku.bili.R.layout.bili_layout_mine_member_bubble, (ViewGroup) null);
                View findViewById = contentView.findViewById(tv.danmaku.bili.R.id.text);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
                MultipleThemeTextView text = (MultipleThemeTextView) findViewById;
                View findViewById2 = contentView.findViewById(tv.danmaku.bili.R.id.arrow);
                Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
                ImageView arrow = (ImageView) findViewById2;
                text.setText(content);
                this.mMemberPopWindow = new PopupWindow(contentView, -2, -2);
                contentView.measure(0, 0);
                pop = this.mMemberPopWindow;
                if (pop == null) {
                    return;
                }
                int[] location = new int[2];
                $this$memberReminderBubble_u24lambda_u240_u240.getLocationOnScreen(location);
                ConstraintLayout.LayoutParams layoutParams = arrow.getLayoutParams();
                ConstraintLayout.LayoutParams lp = layoutParams instanceof ConstraintLayout.LayoutParams ? layoutParams : null;
                if (lp != null) {
                    if (location[0] + ($this$memberReminderBubble_u24lambda_u240_u240.getWidth() / 2) >= ScreenUtil.getScreenWidth(context) - (contentView.getMeasuredWidth() / 2)) {
                        width = (location[0] + ($this$memberReminderBubble_u24lambda_u240_u240.getWidth() / 2)) - (ScreenUtil.getScreenWidth(context) - (contentView.getMeasuredWidth() / 2));
                    } else {
                        width = 0;
                    }
                    lp.setMarginStart(width);
                }
                arrow.setLayoutParams((ViewGroup.LayoutParams) lp);
                pop.showAtLocation($this$memberReminderBubble_u24lambda_u240_u240, 0, (location[0] + ($this$memberReminderBubble_u24lambda_u240_u240.getWidth() / 2)) - (contentView.getMeasuredWidth() / 2), location[1] - contentView.getMeasuredHeight());
                final HomeUserCenterFragment homeUserCenterFragment = this;
                pop.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$memberReminderBubble$1$1$1$1
                    @Override // android.widget.PopupWindow.OnDismissListener
                    public final void onDismiss() {
                        HomeUserCenterFragment.this.memberBubbleShowing = false;
                    }
                });
                this.memberBubbleShowing = true;
                final HomeUserCenterFragment homeUserCenterFragment2 = this;
                $this$memberReminderBubble_u24lambda_u240_u240.postDelayed(new Runnable() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$memberReminderBubble$1$1$1$2
                    private static void __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookPopupWindowDismiss(Object popup) {
                        Intrinsics.checkNotNullParameter(popup, "popup");
                        if (Intrinsics.areEqual(ConfigManager.Companion.ab().get("bgthread_ui_access_detect_enable", true), true)) {
                            Thread thread = Thread.currentThread();
                            if (!Intrinsics.areEqual(thread, Looper.getMainLooper().getThread())) {
                                IllegalStateException exp = new IllegalStateException("PopupWindow.dismiss() called from non-UI thread: " + thread + ", 请联系 Jackin");
                                BLog.e("BgThreadUIAccess", "PopupWindow.dismiss() called from non-UI thread: " + thread, exp);
                                Neurons.trackT(false, "app.bgthread.ui.access", MapsKt.mapOf(new Pair[]{TuplesKt.to("stacktrace", ExceptionsKt.stackTraceToString(exp)), TuplesKt.to("threadName", thread.getName())}), 1, new AppCompatDelegateImpl$.ExternalSyntheticLambda0());
                                if (BuildConfig.DEBUG) {
                                    throw exp;
                                }
                            }
                        }
                        ((PopupWindow) popup).dismiss();
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        if (pop.isShowing()) {
                            __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookPopupWindowDismiss(pop);
                        }
                        homeUserCenterFragment2.memberBubbleShowing = false;
                    }
                }, FdDebugActivity.UPDATE_DELAY_TIME);
            }
        });
    }

    private final void dismissMemberBubble() {
        PopupWindow it = this.mMemberPopWindow;
        if (it != null && it.isShowing()) {
            __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookPopupWindowDismiss(it);
        }
        this.memberBubbleShowing = false;
    }

    private final void renderProjectionBLinkEntrance(AccountMine mineInfo) {
        boolean z = false;
        if (TeenagersMode.getInstance().isEnable()) {
            MineGlobalLinkEntranceView mineGlobalLinkEntranceView = this.mMineGlobalLinkEntrance;
            if (mineGlobalLinkEntranceView != null) {
                mineGlobalLinkEntranceView.setVisibility(8);
            }
        } else {
            Application it = BiliContext.application();
            if (it != null && Xpref.getDefaultSharedPreferences(it).contains(KEY_GLOBAL_LINK_ENTRACE_SHOWN)) {
                MineGlobalLinkEntranceView mineGlobalLinkEntranceView2 = this.mMineGlobalLinkEntrance;
                if (mineGlobalLinkEntranceView2 != null) {
                    mineGlobalLinkEntranceView2.setVisibility(0);
                }
            } else {
                if ((mineInfo != null && mineInfo.enableBiliLink) || Intrinsics.areEqual(Contract.-CC.get$default(ConfigManager.Companion.ab(), FF_KEY_GLOBALLINK_ENTRANCE_ENABLE, (Object) null, 2, (Object) null), true)) {
                    MineGlobalLinkEntranceView mineGlobalLinkEntranceView3 = this.mMineGlobalLinkEntrance;
                    if (mineGlobalLinkEntranceView3 != null) {
                        mineGlobalLinkEntranceView3.setVisibility(0);
                    }
                } else {
                    MineGlobalLinkEntranceView mineGlobalLinkEntranceView4 = this.mMineGlobalLinkEntrance;
                    if (mineGlobalLinkEntranceView4 != null) {
                        mineGlobalLinkEntranceView4.setVisibility(8);
                    }
                }
            }
        }
        MineGlobalLinkEntranceView mineGlobalLinkEntranceView5 = this.mMineGlobalLinkEntrance;
        if (mineGlobalLinkEntranceView5 != null && mineGlobalLinkEntranceView5.getVisibility() == 0) {
            z = true;
        }
        if (z) {
            Application it2 = BiliContext.application();
            if (it2 != null) {
                Xpref.getDefaultSharedPreferences(it2).edit().putBoolean(KEY_GLOBAL_LINK_ENTRACE_SHOWN, true).apply();
            }
            configGlobalLinkBubble();
        }
    }

    public final boolean getShouldFilter() {
        return this.shouldFilter;
    }

    public final void setShouldFilter(boolean z) {
        this.shouldFilter = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mMineChangeListener$lambda$0(HomeUserCenterFragment this$0, AccountMine info, AccountMineRequestResource res) {
        List<MenuItemTip> list;
        Intrinsics.checkNotNullParameter(res, "res");
        TintSwipeRefreshLayout tintSwipeRefreshLayout = this$0.mRefreshLayout;
        if (tintSwipeRefreshLayout != null) {
            tintSwipeRefreshLayout.setRefreshing(false);
        }
        JSONObject infoJson = info != null ? info.toJsonObject() : null;
        BLog.i(TAG, "HomeUserCenter data is " + infoJson);
        if (!this$0.activityDie() && Intrinsics.areEqual(this$0.oldMineInfo, infoJson) && this$0.getPendingTaskUtil().hasWaitingTasks()) {
            LifecycleOwner viewLifecycleOwner = this$0.getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new HomeUserCenterFragment$mMineChangeListener$1$1(this$0, null), 3, (Object) null);
        }
        if ((this$0.activityDie() || Intrinsics.areEqual(this$0.oldMineInfo, infoJson)) && this$0.shouldFilter) {
            if (res.getShowNextTips()) {
                this$0.tryNotifyTips();
            }
            this$0.renderVipEntrance(info, false);
            return;
        }
        if (info != null && (list = info.gameTips) != null) {
            AccountMine mMineInfo = this$0.getMMineInfo();
            MineExtentionsKt.makeLocalPropertiesSameWith(list, mMineInfo != null ? mMineInfo.gameTips : null);
        }
        this$0.shouldFilter = true;
        this$0.oldMineInfo = infoJson;
        HomeUserCenterViewModelKt.mineLog("onchange");
        if (!this$0.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
            return;
        }
        HomeUserCenterViewModel $this$mMineChangeListener_u24lambda_u240_u240 = this$0.getViewModel();
        $this$mMineChangeListener_u24lambda_u240_u240.onAction(new HomeUserCenterAction.Update(info, false, 2, null));
    }

    private final boolean disableCreationModule(MenuGroup menuGroup) {
        if (BiliAccounts.get(getContext()).isLogin() && !TeenagersMode.getInstance().isEnable("upper") && !RestrictedMode.isEnable(RestrictedType.LESSONS, "uper") && ((this.mUperModuleInfo.showCreative || this.mUperModuleInfo.showVideoUp) && menuGroup.button != null)) {
            MenuGroup.MineButton mineButton = menuGroup.button;
            if (!TextUtils.isEmpty(mineButton != null ? mineButton.jumpUrl : null)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:175:0x033d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void buildMineMenu(Context context, List<MenuGroup> list, AccountMine mineInfo) {
        MinePage minePage;
        AccountMine.LiveTip liveTip;
        AccountMine.LiveTip liveTip2;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Iterable $this$onEach_u24lambda_u240$iv;
        boolean z5;
        Pair pair;
        MenuItemTip menuItemTip;
        MenuItemTip findValidOrNull;
        List<MenuItemTip> list2;
        AccountMine accountMine = mineInfo;
        removerBadge();
        MenuGroup noticeModule = null;
        boolean z6 = false;
        if (this.mSectionListV2.size() > 0 && this.mSectionListV2.get(0).viewType == 1) {
            noticeModule = this.mSectionListV2.get(0);
        }
        this.mSectionListV2.clear();
        List<MenuGroup> list3 = list;
        boolean z7 = false;
        Iterable $this$onEach_u24lambda_u240$iv2 = list3;
        boolean z8 = false;
        for (Object element$iv : $this$onEach_u24lambda_u240$iv2) {
            MenuGroup it = (MenuGroup) element$iv;
            if (it.moduleType != 2) {
                z3 = z6;
                z4 = z7;
                $this$onEach_u24lambda_u240$iv = $this$onEach_u24lambda_u240$iv2;
                z5 = z8;
            } else {
                List $this$buildMineMenu_u24lambda_u240_u240 = getMGameCenter().syncWithGameCenter(it.itemList);
                if ($this$buildMineMenu_u24lambda_u240_u240 != null) {
                    z4 = z7;
                    BLog.i(TAG, "game center list => " + MineGameCenterHelperKt.toDesc($this$buildMineMenu_u24lambda_u240_u240));
                } else {
                    z4 = z7;
                    $this$buildMineMenu_u24lambda_u240_u240 = null;
                }
                it.itemList = $this$buildMineMenu_u24lambda_u240_u240;
                it.menuItemTips = (accountMine == null || (list2 = accountMine.gameTips) == null) ? null : CollectionsKt.sorted(list2);
                List $this$findNext$iv = it.menuItemTips;
                if ($this$findNext$iv == null) {
                    $this$onEach_u24lambda_u240$iv = $this$onEach_u24lambda_u240$iv2;
                    z5 = z8;
                    z3 = false;
                } else {
                    int current$iv = NoticeExtKt.getLastMenuItemIndex($this$findNext$iv);
                    if ($this$findNext$iv.size() == 0) {
                        $this$onEach_u24lambda_u240$iv = $this$onEach_u24lambda_u240$iv2;
                        z5 = z8;
                        pair = null;
                    } else {
                        List $this$findValidNext$iv$iv = $this$findNext$iv;
                        List arrayList = $this$findValidNext$iv$iv instanceof RandomAccess ? $this$findValidNext$iv$iv : new ArrayList($this$findValidNext$iv$iv);
                        int p$iv$iv = RangesKt.coerceAtLeast(current$iv, -1);
                        $this$onEach_u24lambda_u240$iv = $this$onEach_u24lambda_u240$iv2;
                        int offset$iv$iv = 1;
                        z5 = z8;
                        int size = $this$findValidNext$iv$iv.size();
                        if (1 <= size) {
                            while (true) {
                                List $this$findValidNext$iv$iv2 = $this$findValidNext$iv$iv;
                                int index$iv$iv = (p$iv$iv + offset$iv$iv) % $this$findValidNext$iv$iv.size();
                                int p$iv$iv2 = p$iv$iv;
                                Object node$iv$iv = CollectionsKt.getOrNull(arrayList, index$iv$iv);
                                if (node$iv$iv != null) {
                                    MenuItemTip it$iv = (MenuItemTip) node$iv$iv;
                                    if (it$iv.checkValid() && !NoticeExtKt.isClosed(it$iv)) {
                                        pair = TuplesKt.to(Integer.valueOf(index$iv$iv), node$iv$iv);
                                        break;
                                    }
                                }
                                if (offset$iv$iv == size) {
                                    break;
                                }
                                offset$iv$iv++;
                                p$iv$iv = p$iv$iv2;
                                $this$findValidNext$iv$iv = $this$findValidNext$iv$iv2;
                            }
                        }
                        pair = null;
                    }
                    if (pair != null) {
                        Pair it$iv2 = pair;
                        int idx = ((Number) it$iv2.getFirst()).intValue();
                        List list4 = it.menuItemTips;
                        boolean z9 = (list4 == null || (findValidOrNull = NoticeExtKt.findValidOrNull(list4)) == null || findValidOrNull.getExposed()) ? false : true;
                        boolean $this$buildMineMenu_u24lambda_u240_u241_u240 = !z9;
                        BLog.i(TAG, "moveCursor=" + $this$buildMineMenu_u24lambda_u240_u241_u240 + ", cursor=" + idx + ", onChanged");
                        if (!z9) {
                            NoticeExtKt.setCurrent($this$findNext$iv, (Integer) it$iv2.getFirst());
                        }
                        menuItemTip = (MenuItemTip) it$iv2.getSecond();
                    } else {
                        menuItemTip = null;
                    }
                    if (menuItemTip != null) {
                        z3 = false;
                        menuItemTip.setExposed(false);
                    } else {
                        z3 = false;
                    }
                }
            }
            z6 = z3;
            z7 = z4;
            $this$onEach_u24lambda_u240$iv2 = $this$onEach_u24lambda_u240$iv;
            z8 = z5;
            accountMine = mineInfo;
        }
        boolean z10 = z6;
        List<MenuGroup> displayMenuList = list3;
        if (noticeModule != null) {
            MenuGroup $this$buildMineMenu_u24lambda_u241 = noticeModule;
            this.mSectionListV2.add($this$buildMineMenu_u24lambda_u241);
        }
        AccountMine mMineInfo = getMMineInfo();
        if ((mMineInfo == null || mMineInfo.silence != 1) ? z10 : true) {
            MenuGroup silence = new MenuGroup();
            silence.viewType = 2;
            this.mSectionListV2.add(silence);
        }
        this.mSectionListV2.addAll(displayMenuList);
        boolean hasSetting = false;
        MenuGroup upperMenuGroup = null;
        for (MenuGroup menuGroup : displayMenuList) {
            if (menuGroup.gwType == 1) {
                menuGroup.viewType = 10;
            } else if (menuGroup.moduleType == 1 || TextUtils.equals(menuGroup.title, context.getString(bili.resource.others.R.string.others_global_string_38))) {
                AccountMine.AccountUperInfo $this$buildMineMenu_u24lambda_u242 = this.mUperModuleInfo;
                AccountMine mMineInfo2 = getMMineInfo();
                $this$buildMineMenu_u24lambda_u242.showCreative = (mMineInfo2 == null || mMineInfo2.showCreative != 1) ? z10 : true;
                AccountMine mMineInfo3 = getMMineInfo();
                $this$buildMineMenu_u24lambda_u242.showVideoUp = (mMineInfo3 == null || mMineInfo3.showVideoup != 1) ? z10 : true;
                $this$buildMineMenu_u24lambda_u242.enableCreationModule = !disableCreationModule(menuGroup);
                if (!this.mUperModuleInfo.enableCreationModule) {
                    this.mSectionListV2.remove(menuGroup);
                    this.mUpperReportType = MineReporter.PUBLISH_NOT_SHOW;
                } else {
                    if (!this.mUperModuleInfo.showCreative && this.mUperModuleInfo.showVideoUp) {
                        menuGroup.viewType = 5;
                    } else {
                        menuGroup.viewType = 4;
                    }
                    if (menuGroup.viewType == 4) {
                        this.mUpperReportType = MineReporter.PUBLISH_TYPE_UPPER;
                        this.mLiveReportType = hasLive() ? "11" : MineReporter.LIVE_TYPE_UPPER_NO_LIVE;
                        upperMenuGroup = menuGroup;
                    }
                }
            } else if (menuGroup.moduleType == 2) {
                menuGroup.viewType = 7;
            } else if (menuGroup.moduleType == 3) {
                MenuGroup.Item it2 = NoticeExtKt.findFirstNotice(menuGroup);
                if (it2 != null) {
                    MenuGroup.CommonOpItem commonOpItem = it2.commonOpItem;
                    Integer valueOf = commonOpItem != null ? Integer.valueOf(commonOpItem.linkType) : null;
                    menuGroup.viewType = (valueOf != null && valueOf.intValue() == 0) ? 9 : 8;
                } else {
                    HomeUserCenterFragment $this$buildMineMenu_u24lambda_u244 = this;
                    $this$buildMineMenu_u24lambda_u244.mSectionListV2.remove(menuGroup);
                }
            } else {
                menuGroup.viewType = 3;
            }
            List it3 = menuGroup.itemList;
            if (it3 != null) {
                for (Object obj : it3) {
                    Intrinsics.checkNotNullExpressionValue(obj, "next(...)");
                    MenuGroup.Item item = (MenuGroup.Item) obj;
                    if (TextUtils.equals(item.uri, AccountMineInfoManager.PAGE_SETTING)) {
                        hasSetting = true;
                    }
                    registerToListenerMap(item, menuGroup.moduleType != 2);
                }
            }
            if (menuGroup.gwType == 0) {
                Iterable iterable = menuGroup.itemList;
                if (iterable != null) {
                    Iterable $this$all$iv = iterable;
                    if (!($this$all$iv instanceof Collection) || !((Collection) $this$all$iv).isEmpty()) {
                        Iterator it4 = $this$all$iv.iterator();
                        while (true) {
                            if (it4.hasNext()) {
                                Object element$iv2 = it4.next();
                                MenuGroup.Item it5 = (MenuGroup.Item) element$iv2;
                                if (it5.localShow) {
                                    z2 = false;
                                    break;
                                }
                            } else {
                                z2 = true;
                                break;
                            }
                        }
                    } else {
                        z2 = true;
                    }
                    if (z2) {
                        z = true;
                        if (z) {
                            this.mSectionListV2.remove(menuGroup);
                        }
                    }
                }
                z = false;
                if (z) {
                }
            }
            z10 = false;
        }
        if (upperMenuGroup != null) {
            AccountMine mMineInfo4 = getMMineInfo();
            if ((mMineInfo4 == null || (liveTip2 = mMineInfo4.liveTip) == null || !liveTip2.isValid()) ? false : true) {
                Integer valueOf2 = Integer.valueOf(this.mSectionListV2.indexOf(upperMenuGroup));
                int it6 = valueOf2.intValue();
                int it7 = it6 >= 0 ? 1 : 0;
                if (it7 == 0) {
                    valueOf2 = null;
                }
                if (valueOf2 != null) {
                    int it8 = valueOf2.intValue();
                    MenuGroup liveTipMenuGroup = new MenuGroup();
                    liveTipMenuGroup.viewType = 6;
                    liveTipMenuGroup.itemList = new ArrayList();
                    List list5 = liveTipMenuGroup.itemList;
                    if (list5 != null) {
                        MenuGroup.Item $this$buildMineMenu_u24lambda_u248_u240 = new MenuGroup.Item();
                        AccountMine mMineInfo5 = getMMineInfo();
                        $this$buildMineMenu_u24lambda_u248_u240.id = (mMineInfo5 == null || (liveTip = mMineInfo5.liveTip) == null) ? 0L : liveTip.id;
                        $this$buildMineMenu_u24lambda_u248_u240.localDefault = true;
                        list5.add($this$buildMineMenu_u24lambda_u248_u240);
                    }
                    this.mSectionListV2.add(it8 + 1, liveTipMenuGroup);
                }
            }
        }
        if (!hasSetting) {
            MenuGroup.Item setting = new MenuGroup.Item();
            setting.id = 10L;
            setting.title = context.getString(bili.resource.settings.R.string.settings_global_string_256);
            setting.uri = AccountMineInfoManager.PAGE_SETTING;
            setting.iconResId = tv.danmaku.bili.R.drawable.ic_mine_setting;
            setting.visible = 1;
            setting.localDefault = true;
            BadgeManager.getInstance().register(setting.uri, this.mMineBadgeListener);
            this.mListenerMap.put(setting.uri, this.mMineBadgeListener);
            Integer num = this.mRegisterMap.get(setting.uri);
            setting.localRedDot = num != null ? num.intValue() : 0;
            MinePageManager minePageManager = this.mPageManager;
            if (minePageManager != null) {
                String str = setting.uri;
                Intrinsics.checkNotNullExpressionValue(str, AudioIntentHelper.ARGS_URI);
                minePage = minePageManager.findTarget(str);
            } else {
                minePage = null;
            }
            MinePage pageInfo = minePage;
            if (pageInfo != null) {
                MinePageManager minePageManager2 = this.mPageManager;
                if (minePageManager2 != null) {
                    minePageManager2.updateSinglePage(pageInfo, setting);
                }
            } else {
                MinePageManager minePageManager3 = this.mPageManager;
                if (minePageManager3 != null) {
                    minePageManager3.createSinglePage(setting);
                }
            }
            List list6 = this.mSectionListV2.get(this.mSectionListV2.size() - 1).itemList;
            if (list6 != null) {
                list6.add(setting);
            }
        }
        HomeUserCenterAdapter homeUserCenterAdapter = this.mAdapter;
        if (homeUserCenterAdapter != null) {
            homeUserCenterAdapter.notifyDataSetChanged();
        }
        this.mScrollReporter.notifyDataChanged();
    }

    public final boolean hasLive() {
        AccountMine mMineInfo = getMMineInfo();
        return (mMineInfo != null ? mMineInfo.firstLiveTime : 0L) > 0;
    }

    static /* synthetic */ void registerToListenerMap$default(HomeUserCenterFragment homeUserCenterFragment, MenuGroup.Item item, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        homeUserCenterFragment.registerToListenerMap(item, z);
    }

    private final void registerToListenerMap(MenuGroup.Item $this$registerToListenerMap, boolean redDotWithListener) {
        MinePage pageInfo;
        if (redDotWithListener) {
            BadgeManager.getInstance().register($this$registerToListenerMap.uri, this.mMineBadgeListener);
            this.mListenerMap.put($this$registerToListenerMap.uri, this.mMineBadgeListener);
            Integer num = this.mRegisterMap.get($this$registerToListenerMap.uri);
            $this$registerToListenerMap.localRedDot = num != null ? num.intValue() : 0;
        }
        MinePageManager minePageManager = this.mPageManager;
        if (minePageManager != null) {
            String str = $this$registerToListenerMap.uri;
            Intrinsics.checkNotNullExpressionValue(str, AudioIntentHelper.ARGS_URI);
            pageInfo = minePageManager.findTarget(str);
        } else {
            pageInfo = null;
        }
        if (pageInfo != null) {
            MinePageManager minePageManager2 = this.mPageManager;
            if (minePageManager2 != null) {
                minePageManager2.updateSinglePage(pageInfo, $this$registerToListenerMap);
                return;
            }
            return;
        }
        MinePageManager minePageManager3 = this.mPageManager;
        if (minePageManager3 != null) {
            minePageManager3.createSinglePage($this$registerToListenerMap);
        }
    }

    /* compiled from: HomeUserCenterFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/HomeUserCenterFragment$HomeMineTab;", "Lcom/bilibili/lib/blrouter/RouteInterceptor;", "<init>", "()V", UserProtocolHelper.UserDialogDismissWatcher.FROM_INTERCEPT, "Lcom/bilibili/lib/blrouter/RouteResponse;", "chain", "Lcom/bilibili/lib/blrouter/RouteInterceptor$Chain;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class HomeMineTab implements RouteInterceptor {
        public static final int $stable = 0;

        public RouteResponse intercept(RouteInterceptor.Chain chain) {
            Intrinsics.checkNotNullParameter(chain, "chain");
            RouteRequest request = chain.getRequest().newBuilder().extras(new Function1() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$HomeMineTab$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit intercept$lambda$0;
                    intercept$lambda$0 = HomeUserCenterFragment.HomeMineTab.intercept$lambda$0((MutableBundleLike) obj);
                    return intercept$lambda$0;
                }
            }).build();
            return chain.next(request);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit intercept$lambda$0(MutableBundleLike $this$extras) {
            Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
            Bundle args = new Bundle();
            args.putBoolean("key_main_tab_toolbar_scroll", false);
            args.putBoolean("key_main_toolbar_show_appbar_layout", false);
            args.putBoolean("key_main_toolbar_show_avatar", false);
            args.putBoolean("key_main_toolbar_show_garb_bg", false);
            args.putParcelable("key_main_tab_badge_server", new HomeUserCenterBadge());
            $this$extras.put("key_main_tab_config", args);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: HomeUserCenterFragment.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00112\u00020\u00012\u00020\u0002:\u0001\u0011B\u0007¢\u0006\u0004\b\u0003\u0010\u0004B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0003\u0010\u0007J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/HomeUserCenterFragment$HomeUserCenterBadge;", "Lcom/bilibili/lib/homepage/badge/IBadgeServer;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", HotListDataPacker.METHOD_REFRESH, "", "context", "Landroid/content/Context;", "writeToParcel", "dest", "flags", "", "describeContents", "CREATOR", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class HomeUserCenterBadge implements IBadgeServer, Parcelable {
        public static final int $stable = 0;
        public static final CREATOR CREATOR = new CREATOR(null);

        public HomeUserCenterBadge() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public HomeUserCenterBadge(Parcel parcel) {
            this();
            Intrinsics.checkNotNullParameter(parcel, "parcel");
        }

        public void refresh(Context context) {
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        /* compiled from: HomeUserCenterFragment.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/HomeUserCenterFragment$HomeUserCenterBadge$CREATOR;", "Landroid/os/Parcelable$Creator;", "Ltv/danmaku/bili/ui/main2/mine/HomeUserCenterFragment$HomeUserCenterBadge;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Ltv/danmaku/bili/ui/main2/mine/HomeUserCenterFragment$HomeUserCenterBadge;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static final class CREATOR implements Parcelable.Creator<HomeUserCenterBadge> {
            public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private CREATOR() {
            }

            @Override // android.os.Parcelable.Creator
            public HomeUserCenterBadge createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new HomeUserCenterBadge(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public HomeUserCenterBadge[] newArray(int size) {
                return new HomeUserCenterBadge[size];
            }
        }
    }

    public void onPageReSelected() {
        AccountMineInfoManager.getInstance().refreshInfo((Context) getActivity(), IFragmentShowHideKt.isFragmentShown((Fragment) this), AccountMineRequestResource.RESELECTED, this.mMineChangeListener);
    }

    public void onPageUnselected() {
        resetVipReportJob();
        this.mIsFragmentSelected = false;
        MineVipModuleManager mineVipModuleManager = this.mineVipModuleManager;
        if (mineVipModuleManager != null) {
            mineVipModuleManager.onPageInvisible();
        }
        ProjectionClient projectionClient = this.mProjectionClient;
        if (projectionClient != null) {
            projectionClient.detach();
        }
        ProjectionClient projectionClient2 = this.mProjectionClient;
        if (projectionClient2 != null) {
            projectionClient2.release();
        }
        this.mProjectionClient = null;
        dismissMemberBubble();
        FansAchievementHelper fansAchievementHelper = this.fansAchievementHelper;
        if (fansAchievementHelper != null) {
            fansAchievementHelper.dismiss();
        }
        seniorFlashPopHide();
    }

    public void onPageSelected(Map<String, Object> map) {
        this.mIsFragmentSelected = true;
        MineVipModuleManager mineVipModuleManager = this.mineVipModuleManager;
        if (mineVipModuleManager != null) {
            mineVipModuleManager.reportExposure();
        }
        if (this.mIsUpperTipsShow) {
            MineReporter.reportMineUpperTipsShow();
        }
        Context it = getContext();
        if (it != null) {
            checkLocateTask(it, map);
        }
        AccountMineInfoManager.getInstance().refreshInfo((Context) getActivity(), IFragmentShowHideKt.isFragmentShown((Fragment) this), AccountMineRequestResource.SELECTED, this.mMineChangeListener);
        if (getContext() != null && !BiliAccounts.get(getContext()).isLogin()) {
            changeForceLoginFragmentVisibility(false, true);
        }
        setStatusBarMode();
        BadgeManager.getInstance().update(DefaultResourceResolver.USER_CENTER, Badge.NONE);
        initProjectionLink();
        seniorLevelShow();
    }

    private final void checkLocateTask(Context context, Map<String, Object> map) {
        String locateServiceId;
        Object $this$asTo$iv;
        Long longOrNull;
        Object $this$asTo$iv2;
        Object $this$asTo$iv3;
        if (!BiliGlobalPreferenceHelper.getInstance(context).optBoolean(KEY_TRIBEE_REVISIT_GUIDE_SHOWN, false)) {
            if (map == null || ($this$asTo$iv3 = map.get("locate_service_id")) == null) {
                locateServiceId = null;
            } else {
                if (!($this$asTo$iv3 instanceof String)) {
                    $this$asTo$iv3 = null;
                }
                locateServiceId = (String) $this$asTo$iv3;
            }
            if (locateServiceId == null) {
                locateServiceId = "";
            }
            if (map == null || ($this$asTo$iv2 = map.get("locate_service_type")) == null) {
                $this$asTo$iv = null;
            } else {
                if (!($this$asTo$iv2 instanceof String)) {
                    $this$asTo$iv2 = null;
                }
                $this$asTo$iv = (String) $this$asTo$iv2;
            }
            String locateServiceType = $this$asTo$iv != null ? $this$asTo$iv : "";
            if (!StringsKt.isBlank(locateServiceId) && !StringsKt.isBlank((CharSequence) locateServiceType) && Intrinsics.areEqual(locateServiceType, "tribee") && (longOrNull = StringsKt.toLongOrNull(locateServiceId)) != null) {
                long id = longOrNull.longValue();
                MinePagePendingTaskUtil pendingTaskUtil = getPendingTaskUtil();
                final HomeUserCenterFragment$checkLocateTask$1$2 homeUserCenterFragment$checkLocateTask$1$2 = new HomeUserCenterFragment$checkLocateTask$1$2(this, id, null);
                pendingTaskUtil.registerTask(new PendingTask(homeUserCenterFragment$checkLocateTask$1$2) { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$checkLocateTask$1$1
                    @Override // tv.danmaku.bili.ui.main2.mine.PendingTask
                    public boolean ifRemoveInList() {
                        return getTaskStatusFlow().getValue() == TaskStatus.SUCCESSFUL || getTaskStatusFlow().getValue() == TaskStatus.FAILED;
                    }
                });
            }
        }
    }

    public Bundle getPvExtra() {
        return createPvArgs();
    }

    public String getPvEventId() {
        return NAVIGATION_EVENT_ID;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Integer valueOf = v != null ? Integer.valueOf(v.getId()) : null;
        int i = tv.danmaku.bili.R.id.mine_day_night_setting;
        if (valueOf != null && valueOf.intValue() == i) {
            switchNightClick$default(this, false, 1, null);
            return;
        }
        int i2 = tv.danmaku.bili.R.id.mine_theme_layout;
        if (valueOf != null && valueOf.intValue() == i2) {
            onClickThemeStore$default(this, false, 1, null);
            return;
        }
        int i3 = tv.danmaku.bili.R.id.mine_scan;
        if (valueOf != null && valueOf.intValue() == i3) {
            Uri parse = Uri.parse(QrCodeHelper.URI_SCAN);
            Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
            RouteRequest routeRequest = new RouteRequest.Builder(parse).build();
            BLRouter.routeTo(routeRequest, getActivity());
            Neurons.reportClick$default(false, QR_ENTRANCE_CLICK, (Map) null, 4, (Object) null);
            return;
        }
        int i4 = tv.danmaku.bili.R.id.mine_global_link_entrance;
        if (valueOf != null && valueOf.intValue() == i4) {
            ProjectionClient projectionClient = this.mProjectionClient;
            if (projectionClient != null) {
                projectionClient.startGlobalLink();
            }
            reportMinePageGlobalLinkClick();
            submitGlobalLinkAct();
            return;
        }
        int i5 = tv.danmaku.bili.R.id.following_layout;
        if (valueOf != null && valueOf.intValue() == i5) {
            toFollowing();
            return;
        }
        int i6 = tv.danmaku.bili.R.id.attention_layout;
        if (valueOf != null && valueOf.intValue() == i6) {
            toAttention();
            return;
        }
        int i7 = tv.danmaku.bili.R.id.fans_layout;
        if (valueOf != null && valueOf.intValue() == i7) {
            toFans();
        }
    }

    private final void reportMinePageGlobalLinkClick() {
        AccountMine.BiliLinkBubble biliLinkBubble;
        ProjectionClient projectionClient = this.mProjectionClient;
        AccountMine mMineInfo = getMMineInfo();
        MineReporter.reportMineGlobalLinkClick(projectionClient, (mMineInfo == null || (biliLinkBubble = mMineInfo.biliLinkBubble) == null) ? null : Integer.valueOf(biliLinkBubble.id), ProjectionClientUtilsKt.getGuideBubbleFirstShow(0) ? "1" : "0");
    }

    private final void submitGlobalLinkAct() {
        AccountMine mMineInfo;
        AccountMine.BiliLinkBubble biliLinkBubble;
        if (ProjectionClientUtilsKt.getGuideBubbleFirstShow(3)) {
            AccountMine mMineInfo2 = getMMineInfo();
            if ((mMineInfo2 != null ? mMineInfo2.biliLinkBubble : null) == null || (mMineInfo = getMMineInfo()) == null || (biliLinkBubble = mMineInfo.biliLinkBubble) == null) {
                return;
            }
            int id = biliLinkBubble.id;
            ProjectionOperationConfigHelper.INSTANCE.submitGlobalLinkActClick(id);
        }
    }

    private final void hideGlobalLinkBubble() {
        PopupGuideBubble popupGuideBubble;
        boolean z = false;
        this.mGlobalLinkGuideBubbleNeedShow = false;
        PopupGuideBubble popupGuideBubble2 = this.mGlobalLinkBubble;
        if (popupGuideBubble2 != null && popupGuideBubble2.isShowing()) {
            z = true;
        }
        if (!z || (popupGuideBubble = this.mGlobalLinkBubble) == null) {
            return;
        }
        popupGuideBubble.dismiss();
    }

    private final <T> T runIfViewModel(Function1<? super HomeUserCenterViewModel, ? extends T> function1) {
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
            return (T) function1.invoke(getViewModel());
        }
        return null;
    }

    public void onChange(Topic topic) {
        this.fansAchievementHelper = null;
        switch (topic == null ? -1 : WhenMappings.$EnumSwitchMapping$0[topic.ordinal()]) {
            case 1:
                this.mHasUpdatedUserInfo = false;
                MinePageManager minePageManager = this.mPageManager;
                if (minePageManager != null) {
                    minePageManager.onLoginStateChanged();
                }
                AccountMineInfoManager.getInstance().refreshInfo((Context) getActivity(), IFragmentShowHideKt.isFragmentShown((Fragment) this), AccountMineRequestResource.SIGN, this.mMineChangeListener);
                ILoginDispatcher iLoginDispatcher = this.mNavigationLoginDispatcher;
                if (iLoginDispatcher != null) {
                    iLoginDispatcher.clearQuickLoginCount();
                }
                TextView textView = this.mClickLogin;
                if (textView != null) {
                    ViewExtKt.gone(textView);
                }
                changeForceLoginFragmentVisibility$default(this, true, false, 2, null);
                return;
            case 2:
                changeForceLoginFragmentVisibility$default(this, false, false, 2, null);
                if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
                    HomeUserCenterViewModel $this$onChange_u24lambda_u240 = getViewModel();
                    this.oldMineInfo = null;
                    $this$onChange_u24lambda_u240.onAction(new HomeUserCenterAction.ClearForLogStatusChanged(Topic.SIGN_OUT));
                }
                AccountMineInfoManager.getInstance().clear();
                MinePageManager minePageManager2 = this.mPageManager;
                if (minePageManager2 != null) {
                    minePageManager2.onLoginStateChanged();
                }
                AccountMineInfoManager.getInstance().refreshInfo((Context) getActivity(), IFragmentShowHideKt.isFragmentShown((Fragment) this), AccountMineRequestResource.UNSIGN, this.mMineChangeListener);
                return;
            case 3:
                HandlerThreads.postDelayed(0, new Runnable() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$$ExternalSyntheticLambda23
                    @Override // java.lang.Runnable
                    public final void run() {
                        HomeUserCenterFragment.onChange$lambda$1(HomeUserCenterFragment.this);
                    }
                }, 1000L);
                return;
            case 4:
                if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
                    HomeUserCenterViewModel $this$onChange_u24lambda_u242 = getViewModel();
                    this.oldMineInfo = null;
                    $this$onChange_u24lambda_u242.onAction(new HomeUserCenterAction.ClearForLogStatusChanged(Topic.ACCOUNT_SWITCH));
                }
                MinePageManager minePageManager3 = this.mPageManager;
                if (minePageManager3 != null) {
                    minePageManager3.onLoginStateChanged();
                }
                AccountMineInfoManager.getInstance().refreshInfo((Context) getActivity(), IFragmentShowHideKt.isFragmentShown((Fragment) this), AccountMineRequestResource.ACCOUNT_UPDATE, this.mMineChangeListener);
                ILoginDispatcher iLoginDispatcher2 = this.mNavigationLoginDispatcher;
                if (iLoginDispatcher2 != null) {
                    iLoginDispatcher2.clearQuickLoginCount();
                }
                TextView textView2 = this.mClickLogin;
                if (textView2 != null) {
                    ViewExtKt.gone(textView2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onChange$lambda$1(HomeUserCenterFragment this$0) {
        AccountMineInfoManager.getInstance().refreshInfo((Context) this$0.getActivity(), IFragmentShowHideKt.isFragmentShown((Fragment) this$0), AccountMineRequestResource.ACCOUNT_UPDATE, this$0.mMineChangeListener);
    }

    public void onThemeChanged() {
        switchDailyNightIcon();
        HomeUserCenterAdapter homeUserCenterAdapter = this.mAdapter;
        if (homeUserCenterAdapter != null) {
            homeUserCenterAdapter.onThemeChanged();
        }
        MineVipModuleManager mineVipModuleManager = this.mineVipModuleManager;
        if (mineVipModuleManager != null) {
            mineVipModuleManager.onThemeChange();
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(23:26|(3:28|(1:30)(1:135)|(21:32|(4:34|(3:36|(1:38)(1:52)|(2:40|(3:42|(3:44|(1:46)(1:50)|(1:48))|51)))|53|(0))|54|(3:56|(1:58)(1:133)|(17:60|(1:62)(1:132)|63|(4:65|(1:67)(1:126)|68|(10:70|(8:72|(1:74)|(4:76|(1:78)|79|(1:81))(2:113|(1:115))|82|(1:84)|85|(1:87)|88)(7:116|(1:118)|119|(1:121)|122|(1:124)|125)|89|(1:112)(1:93)|(3:95|(1:101)|102)|103|104|(1:106)|107|(2:109|110)(1:111)))|127|128|129|(0)(0)|89|(1:91)|112|(0)|103|104|(0)|107|(0)(0)))|134|(0)(0)|63|(0)|127|128|129|(0)(0)|89|(0)|112|(0)|103|104|(0)|107|(0)(0)))|136|(0)|54|(0)|134|(0)(0)|63|(0)|127|128|129|(0)(0)|89|(0)|112|(0)|103|104|(0)|107|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00b8, code lost:
        if (r0 == false) goto L54;
     */
    /* JADX WARN: Removed duplicated region for block: B:105:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:164:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0123  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSkinChange(Garb skin) {
        boolean isGarbChanged;
        VipUserInfo vipUserInfo;
        VipUserInfo.VipLabel label;
        AccountMine p0;
        boolean z;
        String headMineSquaredBgPath;
        boolean z2;
        boolean isSquaredBg;
        String bgPath;
        BitmapDrawable bgDrawable;
        TextView textView;
        VipUserInfo vipUserInfo2;
        VipUserInfo.VipLabel label2;
        boolean z3;
        boolean z4;
        Intrinsics.checkNotNullParameter(skin, "skin");
        Context context = getContext();
        if (context == null) {
            return;
        }
        Garb mineGarb = GarbManager.getGarbWithNightMode(context);
        if (mineGarb.getId() != this.mCurrentGarbId) {
            this.mCurrentGarbId = mineGarb.getId();
            isGarbChanged = true;
        } else {
            isGarbChanged = false;
        }
        String str = null;
        if (isGarbChanged) {
            Surface $this$onSkinChange_u24lambda_u240 = this.mSurface;
            if ($this$onSkinChange_u24lambda_u240 != null) {
                $this$onSkinChange_u24lambda_u240.release();
                this.mSurface = null;
            }
            IjkMediaPlayer $this$onSkinChange_u24lambda_u241 = this.mMediaPlayer;
            if ($this$onSkinChange_u24lambda_u241 != null) {
                $this$onSkinChange_u24lambda_u241.release();
                this.mMediaPlayer = null;
            }
            TextureView it = this.mMineGarbBgAnimatorView;
            if (it != null) {
                FrameLayout frameLayout = this.mMineGarbLayout;
                if (frameLayout != null) {
                    frameLayout.removeView(it);
                }
                this.mMineGarbBgAnimatorView = null;
            }
        }
        setSplitLine(mineGarb.isPure());
        if (!mineGarb.isPure() && !mineGarb.isPrimaryOnly()) {
            String headMineBgPath = mineGarb.getHeadMineBgPath();
            if (headMineBgPath != null) {
                if (headMineBgPath.length() == 0) {
                    z = true;
                    if (z) {
                        String headMineSquaredBgPath2 = mineGarb.getHeadMineSquaredBgPath();
                        if (headMineSquaredBgPath2 != null) {
                            if (headMineSquaredBgPath2.length() == 0) {
                                z3 = true;
                                if (z3) {
                                    String headMineBgAnimatorPath = mineGarb.getHeadMineBgAnimatorPath();
                                    if (headMineBgAnimatorPath != null) {
                                        if (headMineBgAnimatorPath.length() == 0) {
                                            z4 = true;
                                        }
                                    }
                                    z4 = false;
                                }
                            }
                        }
                        z3 = false;
                        if (z3) {
                        }
                    }
                    headMineSquaredBgPath = mineGarb.getHeadMineSquaredBgPath();
                    if (headMineSquaredBgPath != null) {
                        if (headMineSquaredBgPath.length() > 0) {
                            z2 = true;
                            if (z2) {
                                String bgPath2 = mineGarb.getHeadMineSquaredBgPath();
                                isSquaredBg = true;
                                bgPath = bgPath2;
                            } else {
                                String bgPath3 = mineGarb.getHeadMineBgPath();
                                isSquaredBg = false;
                                bgPath = bgPath3;
                            }
                            bgDrawable = null;
                            if (this.mMineGarbBgImageVew != null) {
                                String str2 = bgPath;
                                ImageView imageView = this.mMineGarbBgImageVew;
                                if (TextUtils.equals(str2, (CharSequence) (imageView != null ? imageView.getTag() : null))) {
                                    bgDrawable = this.mMineGarbBgDrawable;
                                    if (bgDrawable == null) {
                                        ImageView imageView2 = this.mMineGarbBgImageVew;
                                        if (imageView2 != null) {
                                            imageView2.setVisibility(0);
                                        }
                                        if (isSquaredBg) {
                                            ImageView imageView3 = this.mMineGarbBgImageVew;
                                            if (imageView3 != null) {
                                                imageView3.setImageMatrix(getSquaredMatrix2(bgDrawable, context));
                                            }
                                            ImageView imageView4 = this.mMineGarbBgImageVew;
                                            if (imageView4 != null) {
                                                imageView4.setScaleType(ImageView.ScaleType.MATRIX);
                                            }
                                        } else {
                                            ImageView imageView5 = this.mMineGarbBgImageVew;
                                            if (imageView5 != null) {
                                                imageView5.setScaleType(ImageView.ScaleType.CENTER_CROP);
                                            }
                                        }
                                        ImageView imageView6 = this.mMineGarbBgImageVew;
                                        if (imageView6 != null) {
                                            imageView6.setImageDrawable(bgDrawable);
                                        }
                                        ImageView imageView7 = this.mMineGarbBgImageVew;
                                        if (imageView7 != null) {
                                            imageView7.setTag(bgPath);
                                        }
                                        this.mMineGarbBgDrawable = bgDrawable;
                                    } else {
                                        ImageView imageView8 = this.mMineGarbBgImageVew;
                                        if (imageView8 != null) {
                                            imageView8.setVisibility(8);
                                        }
                                        FrameLayout frameLayout2 = this.mMineGarbLayout;
                                        if (frameLayout2 != null) {
                                            frameLayout2.setBackgroundResource(com.bilibili.app.comm.baseres.R.color.theme_color_primary_tr_background);
                                        }
                                        ImageView imageView9 = this.mMineGarbBgImageVew;
                                        if (imageView9 != null) {
                                            imageView9.setTag("");
                                        }
                                        this.mMineGarbBgDrawable = null;
                                    }
                                    textView = this.mVipStatus;
                                    if (textView == null && textView.getVisibility() == 0) {
                                        AccountMine mMineInfo = getMMineInfo();
                                        if (mMineInfo != null && (vipUserInfo2 = mMineInfo.vip) != null && (label2 = vipUserInfo2.getLabel()) != null) {
                                            str = label2.getLabelTheme();
                                        }
                                        setVipStatusMode(str, getVipThemeInfo(context));
                                    }
                                    setHeadAnimator(mineGarb);
                                    refreshView(getView());
                                    setAvatar(getMMineInfo());
                                    p0 = getMMineInfo();
                                    if (p0 != null) {
                                        showNonSeniorUserLevel(p0);
                                    }
                                    if (!getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
                                        return;
                                    }
                                    HomeUserCenterViewModel $this$onSkinChange_u24lambda_u243 = getViewModel();
                                    $this$onSkinChange_u24lambda_u243.onAction(new HomeUserCenterAction.OnSkinChanged(mineGarb));
                                    return;
                                }
                            }
                            File file = new File(URI.create(bgPath));
                            Bitmap bitmap = BitmapFactory.decodeFile(file.getPath());
                            bgDrawable = new BitmapDrawable(context.getResources(), bitmap);
                            if (bgDrawable == null) {
                            }
                            textView = this.mVipStatus;
                            if (textView == null && textView.getVisibility() == 0) {
                            }
                            setHeadAnimator(mineGarb);
                            refreshView(getView());
                            setAvatar(getMMineInfo());
                            p0 = getMMineInfo();
                            if (p0 != null) {
                            }
                            if (!getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
                            }
                        }
                    }
                    z2 = false;
                    if (z2) {
                    }
                    bgDrawable = null;
                    if (this.mMineGarbBgImageVew != null) {
                    }
                    File file2 = new File(URI.create(bgPath));
                    Bitmap bitmap2 = BitmapFactory.decodeFile(file2.getPath());
                    bgDrawable = new BitmapDrawable(context.getResources(), bitmap2);
                    if (bgDrawable == null) {
                    }
                    textView = this.mVipStatus;
                    if (textView == null && textView.getVisibility() == 0) {
                    }
                    setHeadAnimator(mineGarb);
                    refreshView(getView());
                    setAvatar(getMMineInfo());
                    p0 = getMMineInfo();
                    if (p0 != null) {
                    }
                    if (!getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
                    }
                }
            }
            z = false;
            if (z) {
            }
            headMineSquaredBgPath = mineGarb.getHeadMineSquaredBgPath();
            if (headMineSquaredBgPath != null) {
            }
            z2 = false;
            if (z2) {
            }
            bgDrawable = null;
            if (this.mMineGarbBgImageVew != null) {
            }
            File file22 = new File(URI.create(bgPath));
            Bitmap bitmap22 = BitmapFactory.decodeFile(file22.getPath());
            bgDrawable = new BitmapDrawable(context.getResources(), bitmap22);
            if (bgDrawable == null) {
            }
            textView = this.mVipStatus;
            if (textView == null && textView.getVisibility() == 0) {
            }
            setHeadAnimator(mineGarb);
            refreshView(getView());
            setAvatar(getMMineInfo());
            p0 = getMMineInfo();
            if (p0 != null) {
            }
            if (!getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
            }
        }
        ImageView imageView10 = this.mMineGarbBgImageVew;
        if (imageView10 != null) {
            imageView10.setVisibility(8);
        }
        FrameLayout frameLayout3 = this.mMineGarbLayout;
        if (frameLayout3 != null) {
            frameLayout3.setBackgroundResource(com.bilibili.app.comm.baseres.R.color.theme_color_primary_tr_background);
        }
        TextView textView2 = this.mVipStatus;
        if (textView2 != null && textView2.getVisibility() == 0) {
            AccountMine mMineInfo2 = getMMineInfo();
            if (mMineInfo2 != null && (vipUserInfo = mMineInfo2.vip) != null && (label = vipUserInfo.getLabel()) != null) {
                str = label.getLabelTheme();
            }
            setVipStatusMode(str, getVipThemeInfo(context));
        }
        setStatusBarMode();
        refreshView(getView());
        setAvatar(getMMineInfo());
        p0 = getMMineInfo();
        if (p0 != null) {
        }
        if (!getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
        }
    }

    private final void setHeadAnimator(final Garb garb) {
        if (this.mMediaPlayer != null || this.mMineGarbBgAnimatorView != null || this.mSurface != null) {
            return;
        }
        BLog.d(TAG, "HEAD" + garb.getHeadMineBgAnimatorPath());
        String headMineBgAnimatorPath = garb.getHeadMineBgAnimatorPath();
        boolean z = false;
        if (headMineBgAnimatorPath != null) {
            if (headMineBgAnimatorPath.length() > 0) {
                z = true;
            }
        }
        if (z) {
            try {
                BLog.i(TAG, "player init");
                this.mMediaPlayer = new IjkMediaPlayer(getContext());
                IjkMediaPlayer ijkMediaPlayer = this.mMediaPlayer;
                if (ijkMediaPlayer != null) {
                    ijkMediaPlayer.setOption(4, "start-on-prepared", 1L);
                }
                IjkMediaPlayer ijkMediaPlayer2 = this.mMediaPlayer;
                if (ijkMediaPlayer2 != null) {
                    Context context = getContext();
                    String headMineBgAnimatorPath2 = garb.getHeadMineBgAnimatorPath();
                    Intrinsics.checkNotNull(headMineBgAnimatorPath2);
                    ijkMediaPlayer2.setDataSource(context, Uri.parse(headMineBgAnimatorPath2));
                }
                IjkMediaPlayer ijkMediaPlayer3 = this.mMediaPlayer;
                if (ijkMediaPlayer3 != null) {
                    ijkMediaPlayer3.setVolume(0.0f, 0.0f);
                }
                IjkMediaPlayer ijkMediaPlayer4 = this.mMediaPlayer;
                if (ijkMediaPlayer4 != null) {
                    ijkMediaPlayer4.prepareAsync();
                }
                IjkMediaPlayer ijkMediaPlayer5 = this.mMediaPlayer;
                if (ijkMediaPlayer5 != null) {
                    ijkMediaPlayer5.setOnInfoListener(new IMediaPlayer.OnInfoListener() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$setHeadAnimator$1
                        /* JADX WARN: Code restructure failed: missing block: B:4:0x0003, code lost:
                            r0 = r2.this$0.mMineGarbBgAnimatorView;
                         */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public boolean onInfo(IMediaPlayer p0, int what, int extra, Bundle bundle) {
                            TextureView textureView;
                            if (what != 3 || textureView == null) {
                                return true;
                            }
                            textureView.setAlpha(1.0f);
                            return true;
                        }
                    });
                }
                IjkMediaPlayer ijkMediaPlayer6 = this.mMediaPlayer;
                if (ijkMediaPlayer6 != null) {
                    ijkMediaPlayer6.setOnVideoSizeChangedListener(new IMediaPlayer.OnVideoSizeChangedListener() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$setHeadAnimator$2
                        public void onVideoSizeChanged(IMediaPlayer p0, int videoWidth, int videoHeight, int videoSarNum, int videoSarDen) {
                            TextureView textureView;
                            TextureView textureView2;
                            FrameLayout frameLayout;
                            TextureView textureView3;
                            TextureView textureView4;
                            TextureView textureView5;
                            Context ctx = HomeUserCenterFragment.this.getContext();
                            if (ctx == null) {
                                return;
                            }
                            textureView = HomeUserCenterFragment.this.mMineGarbBgAnimatorView;
                            if (textureView == null) {
                                HomeUserCenterFragment.this.mMineGarbBgAnimatorView = new TextureView(ctx);
                                float videoScale = ((videoHeight * 1.0f) / videoWidth) * 1.0f;
                                float viewHeight = WindowManagerHelper.getDisplayWidth(ctx) * videoScale;
                                ViewGroup.LayoutParams viewGroupParams = new ViewGroup.LayoutParams(WindowManagerHelper.getDisplayWidth(ctx), (int) viewHeight);
                                textureView2 = HomeUserCenterFragment.this.mMineGarbBgAnimatorView;
                                if (textureView2 != null) {
                                    textureView2.setLayoutParams(viewGroupParams);
                                }
                                frameLayout = HomeUserCenterFragment.this.mMineGarbLayout;
                                if (frameLayout != null) {
                                    textureView5 = HomeUserCenterFragment.this.mMineGarbBgAnimatorView;
                                    frameLayout.addView(textureView5);
                                }
                                textureView3 = HomeUserCenterFragment.this.mMineGarbBgAnimatorView;
                                if (textureView3 != null) {
                                    textureView3.setAlpha(0.0f);
                                }
                                textureView4 = HomeUserCenterFragment.this.mMineGarbBgAnimatorView;
                                if (textureView4 != null) {
                                    final HomeUserCenterFragment homeUserCenterFragment = HomeUserCenterFragment.this;
                                    textureView4.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$setHeadAnimator$2$onVideoSizeChanged$1
                                        @Override // android.view.TextureView.SurfaceTextureListener
                                        public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
                                            IjkMediaPlayer ijkMediaPlayer7;
                                            Surface surface2;
                                            Intrinsics.checkNotNullParameter(surface, "surface");
                                            HomeUserCenterFragment.this.mSurface = new Surface(surface);
                                            ijkMediaPlayer7 = HomeUserCenterFragment.this.mMediaPlayer;
                                            if (ijkMediaPlayer7 != null) {
                                                surface2 = HomeUserCenterFragment.this.mSurface;
                                                ijkMediaPlayer7.setSurface(surface2);
                                            }
                                        }

                                        @Override // android.view.TextureView.SurfaceTextureListener
                                        public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
                                            Intrinsics.checkNotNullParameter(surface, "surface");
                                        }

                                        @Override // android.view.TextureView.SurfaceTextureListener
                                        public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
                                            Surface $this$onSurfaceTextureDestroyed_u24lambda_u240;
                                            IjkMediaPlayer $this$onSurfaceTextureDestroyed_u24lambda_u241;
                                            Intrinsics.checkNotNullParameter(surface, "surface");
                                            $this$onSurfaceTextureDestroyed_u24lambda_u240 = HomeUserCenterFragment.this.mSurface;
                                            if ($this$onSurfaceTextureDestroyed_u24lambda_u240 != null) {
                                                HomeUserCenterFragment homeUserCenterFragment2 = HomeUserCenterFragment.this;
                                                $this$onSurfaceTextureDestroyed_u24lambda_u240.release();
                                                homeUserCenterFragment2.mSurface = null;
                                            }
                                            $this$onSurfaceTextureDestroyed_u24lambda_u241 = HomeUserCenterFragment.this.mMediaPlayer;
                                            if ($this$onSurfaceTextureDestroyed_u24lambda_u241 != null) {
                                                HomeUserCenterFragment homeUserCenterFragment3 = HomeUserCenterFragment.this;
                                                $this$onSurfaceTextureDestroyed_u24lambda_u241.release();
                                                homeUserCenterFragment3.mMediaPlayer = null;
                                                return true;
                                            }
                                            return true;
                                        }

                                        @Override // android.view.TextureView.SurfaceTextureListener
                                        public void onSurfaceTextureUpdated(SurfaceTexture surface) {
                                            Intrinsics.checkNotNullParameter(surface, "surface");
                                        }
                                    });
                                }
                            }
                        }
                    });
                }
                IjkMediaPlayer ijkMediaPlayer7 = this.mMediaPlayer;
                if (ijkMediaPlayer7 != null) {
                    ijkMediaPlayer7.setOnCompletionListener(new IMediaPlayer.OnCompletionListener() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$$ExternalSyntheticLambda22
                        public final void onCompletion(IMediaPlayer iMediaPlayer) {
                            HomeUserCenterFragment.setHeadAnimator$lambda$0(HomeUserCenterFragment.this, garb, iMediaPlayer);
                        }
                    });
                }
            } catch (Exception e) {
                BLog.i(TAG, "mine ijk error is" + e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setHeadAnimator$lambda$0(HomeUserCenterFragment this$0, Garb $garb, IMediaPlayer it) {
        IjkMediaPlayer ijkMediaPlayer;
        if (this$0.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED)) {
            BLog.i(TAG, "player is restart");
            if (!$garb.isMineAnimateLoop() || (ijkMediaPlayer = this$0.mMediaPlayer) == null) {
                return;
            }
            ijkMediaPlayer.start();
            return;
        }
        IjkMediaPlayer $this$setHeadAnimator_u24lambda_u240_u240 = this$0.mMediaPlayer;
        if ($this$setHeadAnimator_u24lambda_u240_u240 != null) {
            BLog.i(TAG, "player is restart when pause， release it");
            $this$setHeadAnimator_u24lambda_u240_u240.release();
            this$0.mMediaPlayer = null;
        }
    }

    private final Matrix getSquaredMatrix2(BitmapDrawable bgDrawable, Context context) {
        Matrix matrix = new Matrix();
        try {
            int bitmapWidth = bgDrawable.getIntrinsicWidth();
            int contentWidth = context.getResources().getDisplayMetrics().widthPixels;
            float sampleSizeW = ((contentWidth * 1.0f) / bitmapWidth) * 1.0f;
            matrix.setScale(sampleSizeW, sampleSizeW, 0.0f, 0.0f);
        } catch (Exception e) {
        }
        return matrix;
    }

    static /* synthetic */ void renderMine$default(HomeUserCenterFragment homeUserCenterFragment, AccountMine accountMine, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        homeUserCenterFragment.renderMine(accountMine, z);
    }

    private final void renderMine(AccountMine mineInfo, boolean isFromCache) {
        String following;
        String attention;
        String fans;
        int i;
        if (mineInfo != null && BiliAccounts.get(getActivity()).isLogin()) {
            following = NumberFormat_androidKt.format$default(Long.valueOf(mineInfo.dynamic), "0", 0, 2, (Object) null);
            attention = NumberFormat_androidKt.format$default(Long.valueOf(mineInfo.following), "0", 0, 2, (Object) null);
            fans = NumberFormat_androidKt.format$default(Long.valueOf(mineInfo.follower), "0", 0, 2, (Object) null);
        } else {
            following = "-";
            attention = "-";
            fans = "-";
            NavigationFragmentAnimatorHelper navigationFragmentAnimatorHelper = this.mAnimatorHelper;
            if (navigationFragmentAnimatorHelper != null) {
                navigationFragmentAnimatorHelper.onResetIncreaseFans();
            }
        }
        TextView textView = this.mFollowingCount;
        if (textView != null) {
            textView.setText(following);
        }
        TextView textView2 = this.mAttentionCount;
        if (textView2 != null) {
            textView2.setText(attention);
        }
        TextView textView3 = this.mFansCount;
        if (textView3 != null) {
            textView3.setText(fans);
        }
        AccountMine.FansEffect fansEffect = mineInfo != null ? mineInfo.fansEffect : null;
        if (fansEffect != null && !isFromCache) {
            Context it = getContext();
            if (it != null) {
                if (this.fansAchievementHelper == null) {
                    LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
                    Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
                    this.fansAchievementHelper = new FansAchievementHelper(it, LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), this.mFansCount, this.mFansAchieveMedal, this.mFansAchieveMedalText, this.mFansAchieveMedalImage, this.mFansAchieveBadge, this.mFansLayout);
                }
                switch (fansEffect.showType) {
                    case 1:
                        FansAchievementHelper fansAchievementHelper = this.fansAchievementHelper;
                        if (fansAchievementHelper != null) {
                            fansAchievementHelper.showBadge();
                            break;
                        }
                        break;
                    case 2:
                        FansAchievementHelper fansAchievementHelper2 = this.fansAchievementHelper;
                        if (fansAchievementHelper2 != null) {
                            fansAchievementHelper2.showAchievementAnimationAsPopup(fansEffect, (int) mineInfo.follower);
                            break;
                        }
                        break;
                    default:
                        FansAchievementHelper fansAchievementHelper3 = this.fansAchievementHelper;
                        if (fansAchievementHelper3 != null) {
                            FansAchievementHelper.showButton$default(fansAchievementHelper3, fansEffect, false, 2, null);
                            break;
                        }
                        break;
                }
                TextView textView4 = this.mFansBubble;
                if (textView4 != null) {
                    textView4.setVisibility(8);
                    return;
                }
                return;
            }
            return;
        }
        View view = this.mFansAchieveBadge;
        if (view != null) {
            i = 8;
            view.setVisibility(8);
        } else {
            i = 8;
        }
        LinearLayout linearLayout = this.mFansAchieveMedal;
        if (linearLayout != null) {
            linearLayout.setVisibility(i);
        }
        int increaseFans = mineInfo != null ? mineInfo.newFollowers : 0;
        if (increaseFans > 0 && this.mIsFragmentSelected && !isFromCache) {
            NavigationFragmentAnimatorHelper navigationFragmentAnimatorHelper2 = this.mAnimatorHelper;
            if (navigationFragmentAnimatorHelper2 != null) {
                navigationFragmentAnimatorHelper2.setIncreaseFansForH5(increaseFans);
            }
            if (increaseFans > 999) {
                increaseFans = 999;
            }
            String fansIncrease = NumberFormat_androidKt.format$default(Integer.valueOf(increaseFans), "0", 0, 2, (Object) null);
            TextView textView5 = this.mFansBubble;
            if (textView5 != null) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = getString(bili.resource.homepage.R.string.homepage_global_string_387);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                String format = String.format(string, Arrays.copyOf(new Object[]{fansIncrease}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                textView5.setText(format);
            }
            NavigationReporter.reportFansIncreaseBubbleShow();
            NavigationFragmentAnimatorHelper navigationFragmentAnimatorHelper3 = this.mAnimatorHelper;
            if (navigationFragmentAnimatorHelper3 != null) {
                navigationFragmentAnimatorHelper3.startBubbleAnimator(mineInfo != null ? mineInfo.newFollowersTime : 0L);
            }
        }
    }

    private final void toFans() {
        Context activity = getActivity();
        if (activity == null) {
            return;
        }
        MineReporter.reportTopTabBarClick("粉丝", "4");
        Uri uri = null;
        if (checkRestrictMode$default(this, false, 1, null)) {
            return;
        }
        if (BiliAccounts.get(activity).isLogin()) {
            handleFansRedDot();
            RelationService relationService = (RelationService) ServicesProvider.DefaultImpls.get$default(BLRouter.INSTANCE.getServices(RelationService.class), (String) null, 1, (Object) null);
            if (relationService != null) {
                long mid = BiliAccounts.get(activity).mid();
                NavigationFragmentAnimatorHelper navigationFragmentAnimatorHelper = this.mAnimatorHelper;
                uri = relationService.getFanListUri(mid, navigationFragmentAnimatorHelper != null ? navigationFragmentAnimatorHelper.getIncreaseFansForH5() : 0);
            }
            Uri fans = uri;
            if (fans != null) {
                IntentHelper.intentTo(activity, fans);
            }
            NavigationFragmentAnimatorHelper navigationFragmentAnimatorHelper2 = this.mAnimatorHelper;
            if (navigationFragmentAnimatorHelper2 != null) {
                navigationFragmentAnimatorHelper2.setIncreaseFansForH5(0);
                return;
            }
            return;
        }
        RouteRequest routeReq = new RouteRequest.Builder("activity://main/login/").build();
        BLRouter.routeTo(routeReq, (Fragment) this);
    }

    private final void handleFansRedDot() {
        AccountMine mMineInfo;
        AccountMine.FansEffect effect;
        View view = this.mFansAchieveBadge;
        boolean z = false;
        if (view != null && view.getVisibility() == 0) {
            z = true;
        }
        if (z && (mMineInfo = getMMineInfo()) != null && (effect = mMineInfo.fansEffect) != null) {
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new HomeUserCenterFragment$handleFansRedDot$1$1(effect, this, null), 3, (Object) null);
        }
    }

    private final void toAttention() {
        Context activity = getActivity();
        if (activity == null) {
            return;
        }
        MineReporter.reportTopTabBarClick("关注", "3");
        if (checkRestrictMode$default(this, false, 1, null)) {
            return;
        }
        if (BiliAccounts.get(activity).isLogin()) {
            RelationService relationService = (RelationService) ServicesProvider.DefaultImpls.get$default(BLRouter.INSTANCE.getServices(RelationService.class), (String) null, 1, (Object) null);
            Uri follow = relationService != null ? relationService.getAttentionListUri(BiliAccounts.get(activity).mid()) : null;
            if (follow != null) {
                IntentHelper.intentTo(activity, follow);
                return;
            }
            return;
        }
        RouteRequest routerReq = new RouteRequest.Builder("activity://main/login/").build();
        BLRouter.routeTo(routerReq, (Fragment) this);
    }

    private final void toFollowing() {
        String name;
        Context activity = getActivity();
        if (activity == null) {
            return;
        }
        MineReporter.reportTopTabBarClick("动态", "2");
        if (checkTeenRestrictMode()) {
            return;
        }
        if (BiliAccounts.get(activity).isLogin()) {
            long mid = BiliAccounts.get(activity).mid();
            if (getMMineInfo() == null) {
                name = null;
            } else {
                AccountMine mMineInfo = getMMineInfo();
                Intrinsics.checkNotNull(mMineInfo);
                name = mMineInfo.name;
            }
            SpaceRouter.startSpace(activity, mid, name, "dynamic");
            return;
        }
        RouteRequest request = new RouteRequest.Builder("activity://main/login/").build();
        BLRouter.routeTo(request, (Fragment) this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean checkRestrictMode$default(HomeUserCenterFragment homeUserCenterFragment, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return homeUserCenterFragment.checkRestrictMode(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean checkRestrictMode(boolean showToast) {
        if (RestrictedMode.isEnable(RestrictedType.TEENAGERS)) {
            if (showToast) {
                ToastHelper.showToastShort(getContext(), bili.resource.homepage.R.string.homepage_global_string_32);
                return true;
            }
            return true;
        } else if (RestrictedMode.isEnable(RestrictedType.LESSONS)) {
            if (showToast) {
                ToastHelper.showToastShort(getContext(), bili.resource.homepage.R.string.homepage_global_string_47);
                return true;
            }
            return true;
        } else {
            return false;
        }
    }

    private final boolean checkTeenRestrictMode() {
        if (RestrictedMode.isEnable(RestrictedType.TEENAGERS)) {
            ToastHelper.showToastShort(getContext(), bili.resource.homepage.R.string.homepage_global_string_32);
            return true;
        }
        return false;
    }

    private final void renderGarbEntrance(AccountMine.GarbEntrance garbEntrance) {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        if (garbEntrance == null || !garbEntrance.isValid() || RestrictedMode.isEnable(RestrictedType.LESSONS, "misc")) {
            this.mGarbEntranceUrl = "";
            BiliImageView biliImageView = this.mMineThemeIcon;
            if (biliImageView != null) {
                biliImageView.setVisibility(8);
            }
            MultipleThemeImageView multipleThemeImageView = this.mMineThemeStoreView;
            if (multipleThemeImageView != null) {
                multipleThemeImageView.setVisibility(0);
                return;
            }
            return;
        }
        this.mGarbEntranceUrl = garbEntrance.uri;
        if (!TextUtils.isEmpty(garbEntrance.icon)) {
            MultipleThemeImageView multipleThemeImageView2 = this.mMineThemeStoreView;
            if (multipleThemeImageView2 != null) {
                multipleThemeImageView2.setVisibility(4);
            }
            BiliImageView biliImageView2 = this.mMineThemeIcon;
            if (biliImageView2 != null) {
                biliImageView2.setVisibility(0);
            }
            BiliImageView biliImageView3 = this.mMineThemeIcon;
            if (biliImageView3 != null) {
                biliImageView3.setTintableCallback(new ImageTintableCallback() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$$ExternalSyntheticLambda21
                    public final void tint() {
                        HomeUserCenterFragment.this.setGarbIconColor();
                    }
                });
            }
            BiliImageView it = this.mMineThemeIcon;
            if (it != null) {
                ImageRequestBuilder url = BiliImageLoader.INSTANCE.with(activity).url(garbEntrance.icon);
                ScaleType scaleType = ScaleType.FIT_CENTER;
                Intrinsics.checkNotNullExpressionValue(scaleType, "FIT_CENTER");
                url.actualImageScaleType(scaleType).imageLoadingListener(new ImageLoadingListener() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$renderGarbEntrance$2$1
                    public /* synthetic */ void onImageLoading(Uri uri) {
                        ImageLoadingListener.-CC.$default$onImageLoading(this, uri);
                    }

                    public /* synthetic */ void onImageSet(ImageInfo imageInfo, Bitmap bitmap) {
                        ImageLoadingListener.-CC.$default$onImageSet(this, imageInfo, bitmap);
                    }

                    public /* synthetic */ void onIntermediateImageSet(ImageInfo imageInfo) {
                        ImageLoadingListener.-CC.$default$onIntermediateImageSet(this, imageInfo);
                    }

                    public void onImageSet(ImageInfo imageInfo) {
                        HomeUserCenterFragment.this.setGarbIconColor();
                    }

                    public void onImageLoadFailed(Throwable err) {
                        MultipleThemeImageView multipleThemeImageView3;
                        BiliImageView biliImageView4;
                        multipleThemeImageView3 = HomeUserCenterFragment.this.mMineThemeStoreView;
                        if (multipleThemeImageView3 != null) {
                            multipleThemeImageView3.setVisibility(0);
                        }
                        biliImageView4 = HomeUserCenterFragment.this.mMineThemeIcon;
                        if (biliImageView4 != null) {
                            biliImageView4.setVisibility(8);
                        }
                    }
                }).into(it);
            }
        }
    }

    public static /* synthetic */ void switchNightClick$default(HomeUserCenterFragment homeUserCenterFragment, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        homeUserCenterFragment.switchNightClick(z);
    }

    public final void switchNightClick(boolean booleanReport) {
        if (booleanReport) {
            NavigationReporter.reportNightModeClick();
        }
        Context activity = getActivity();
        if (activity == null) {
            return;
        }
        MainCommonService service = (MainCommonService) BLRouter.INSTANCE.getServices(MainCommonService.class).get(MineReporter.MINE_ICON_TYPE_DEFAULT);
        Boolean changeSuccess = service != null ? Boolean.valueOf(service.changeNightMode(activity, true)) : null;
        if (changeSuccess != null) {
            changeSuccess.booleanValue();
            if (MultipleThemeUtils.isNightFollowSystem(activity)) {
                MultipleThemeUtils.setNightFollowSystem(activity, false);
                ToastHelper.showToastShort(activity, bili.resource.settings.R.string.settings_global_string_217);
            } else {
                ToastHelper.showToastShort(activity, bili.resource.settings.R.string.settings_global_string_242);
            }
        }
        if (booleanReport) {
            NavigationReporter.reportNightModeClickV2(getContext());
        }
    }

    private final void switchDailyNightIcon() {
        Drawable drawable;
        Context activity = getActivity();
        if (activity == null) {
            return;
        }
        if (MultipleThemeUtils.isNightTheme(activity)) {
            drawable = ContextCompat.getDrawable(activity, tv.danmaku.bili.R.drawable.ic_mine_daynight_day);
        } else {
            drawable = ContextCompat.getDrawable(activity, tv.danmaku.bili.R.drawable.ic_mine_daynight_night);
        }
        Drawable icon = drawable;
        MultipleThemeImageView $this$switchDailyNightIcon_u24lambda_u240 = this.mMineDayNightSetting;
        if ($this$switchDailyNightIcon_u24lambda_u240 != null && icon != null) {
            Drawable mTempIcon = DrawableCompat.wrap(icon.mutate());
            $this$switchDailyNightIcon_u24lambda_u240.setImageDrawable(mTempIcon);
            $this$switchDailyNightIcon_u24lambda_u240.tint();
        }
    }

    public static /* synthetic */ void onClickThemeStore$default(HomeUserCenterFragment homeUserCenterFragment, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        homeUserCenterFragment.onClickThemeStore(z);
    }

    public final void onClickThemeStore(boolean booleanReport) {
        if (booleanReport) {
            NavigationReporter.reportThemeClick();
        }
        Context activity = getActivity();
        if (activity == null) {
            return;
        }
        if (!TextUtils.isEmpty(this.mGarbEntranceUrl)) {
            Uri parse = Uri.parse(this.mGarbEntranceUrl);
            Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
            RouteRequest routeRequest = new RouteRequest.Builder(parse).build();
            BLRouter.routeTo(routeRequest, activity);
            return;
        }
        Uri parse2 = Uri.parse(MainRouteUris.ROUTER_THEME_STORE_ACTIVITY);
        Intrinsics.checkNotNullExpressionValue(parse2, "parse(...)");
        RouteRequest routeRequest2 = new RouteRequest.Builder(parse2).build();
        BLRouter.routeTo(routeRequest2, activity);
    }

    private final String getDisplayRank(Activity activity, AccountMine mine) {
        String memberText;
        AccountMine.SeniorStatus seniorStatus = mine.seniorStatus;
        if (seniorStatus != null && (memberText = seniorStatus.memberText) != null && mine.isSeniorUser() && !StringsKt.isBlank(memberText)) {
            return memberText;
        }
        int rank = mine.rank;
        boolean z = false;
        if (5000 <= rank && rank < 10000) {
            z = true;
        }
        if (z) {
            String string = activity.getString(bili.resource.account.R.string.account_global_string_395);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        } else if (rank >= 10000) {
            String string2 = activity.getString(bili.resource.account.R.string.account_global_string_370);
            Intrinsics.checkNotNull(string2);
            return string2;
        } else {
            return "";
        }
    }

    private final void update(final AccountMine mine) {
        VipUserInfo.VipLabel label;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        setAvatar(mine);
        if (mine.showNameGuide) {
            View view = this.mNickNameGuideView;
            if (view != null) {
                view.setVisibility(0);
            }
            NickNameTextView nickNameTextView = this.mNickName;
            if (nickNameTextView != null) {
                nickNameTextView.setVisibility(8);
            }
            MineReporter.INSTANCE.reportShow(MineReporter.MINE_NICK_NAME_GUIDE_SHOW);
        } else {
            View view2 = this.mNickNameGuideView;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            NickNameTextView nickNameTextView2 = this.mNickName;
            if (nickNameTextView2 != null) {
                nickNameTextView2.setVisibility(0);
            }
            NickNameTextView nickNameTextView3 = this.mNickName;
            if (nickNameTextView3 != null) {
                String str = mine.name;
                if (str == null) {
                    str = "";
                }
                nickNameTextView3.setText(str);
            }
        }
        TextView textView = this.mUserHandle;
        if (textView != null) {
            textView.setText(mine.handle);
        }
        View view3 = this.mUserHandle;
        if (view3 != null) {
            View $this$isVisible$iv = view3;
            String str2 = mine.handle;
            boolean value$iv = !(str2 == null || StringsKt.isBlank(str2));
            $this$isVisible$iv.setVisibility(value$iv ? 0 : 8);
        }
        NickNameTextView nickNameTextView4 = this.mNickName;
        if (nickNameTextView4 != null) {
            nickNameTextView4.setVipInfo(false, false, false, mine.getLabelTheme(), mine.nameRender);
        }
        if (mine.isAccountInRegAudit()) {
            TextView textView2 = this.mRankStatus;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            TextView textView3 = this.mVipStatus;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            ViewExtKt.gone(this.mVipStatusImage);
            TextView textView4 = this.mAccountStatus;
            if (textView4 != null) {
                textView4.setVisibility(0);
            }
        } else if (mine.isEffectiveVip()) {
            ViewExtKt.gone(this.mRankStatus);
            TextView textView5 = this.mAccountStatus;
            if (textView5 != null) {
                textView5.setVisibility(8);
            }
            VipUserInfo vipUserInfo = mine.vip;
            final String imgLabelUrl = (vipUserInfo == null || (label = vipUserInfo.getLabel()) == null) ? null : label.getImage();
            String str3 = imgLabelUrl;
            if (!(str3 == null || StringsKt.isBlank(str3))) {
                ViewExtKt.gone(this.mVipStatus);
                ViewExtKt.visible(this.mVipStatusImage);
                Context requireContext = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                this.hardCoreAniShowing = !Xpref.getDefaultSharedPreferences(requireContext).contains(KEY_VIP_LABEL_GIF_SHOWN) && (StringsKt.endsWith$default(imgLabelUrl, "gif", false, 2, (Object) null) || StringsKt.endsWith$default(imgLabelUrl, "webp", false, 2, (Object) null));
                ComposeView composeView = this.mVipStatusImage;
                if (composeView != null) {
                    composeView.setContent(ComposableLambdaKt.composableLambdaInstance(-526300423, true, new Function2() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$$ExternalSyntheticLambda17
                        public final Object invoke(Object obj, Object obj2) {
                            Unit update$lambda$0;
                            update$lambda$0 = HomeUserCenterFragment.update$lambda$0(HomeUserCenterFragment.this, imgLabelUrl, mine, (Composer) obj, ((Integer) obj2).intValue());
                            return update$lambda$0;
                        }
                    }));
                }
            } else {
                showVIPStatusLabel(mine);
            }
            NickNameTextView nickNameTextView5 = this.mNickName;
            if (nickNameTextView5 != null) {
                nickNameTextView5.setVipInfo(mine.isEffectiveVip(), mine.isEffectiveYearVip(), mine.isLittleVip(), mine.getLabelTheme(), mine.nameRender);
            }
        } else {
            TextView textView6 = this.mAccountStatus;
            if (textView6 != null) {
                textView6.setVisibility(8);
            }
            ViewExtKt.gone(this.mVipStatusImage);
            TextView textView7 = this.mVipStatus;
            if (textView7 != null) {
                textView7.setVisibility(8);
            }
            TextView $this$update_u24lambda_u241 = this.mRankStatus;
            if ($this$update_u24lambda_u241 != null) {
                String text = getDisplayRank((Activity) activity, mine);
                if (text.length() == 0) {
                    $this$update_u24lambda_u241.setVisibility(8);
                } else {
                    $this$update_u24lambda_u241.setVisibility(0);
                    $this$update_u24lambda_u241.setText(text);
                }
            }
        }
        showUserLevel(mine);
        TextView textView8 = this.mUserCoinCount;
        if (textView8 != null) {
            textView8.setText(activity.getResources().getQuantityString(bili.resource.homepage.R.plurals.homepage_global_string_443, (int) mine.coin, String.valueOf((int) mine.coin)));
        }
        TextView textView9 = this.mUserBpCount;
        if (textView9 != null) {
            textView9.setText(activity.getResources().getQuantityString(bili.resource.homepage.R.plurals.homepage_global_string_441, (int) mine.bcoin, mine.bCoinStr((Context) activity)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit update$lambda$0(final HomeUserCenterFragment this$0, final String $imgLabelUrl, final AccountMine $mine, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C2073@86013L99,2074@86143L2755,2074@86133L2765:HomeUserCenterFragment.kt#yk7nxf");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-526300423, $changed, -1, "tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment.update.<anonymous> (HomeUserCenterFragment.kt:2073)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, 1031437916, "CC(remember):HomeUserCenterFragment.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Context requireContext = this$0.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                Object value$iv = Boolean.valueOf(!Xpref.getDefaultSharedPreferences(requireContext).contains(KEY_VIP_LABEL_GIF_SHOWN));
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final boolean autoPlayAnimation = ((Boolean) it$iv).booleanValue();
            ComposerKt.sourceInformationMarkerEnd($composer);
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(948307633, true, new Function2() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$$ExternalSyntheticLambda20
                public final Object invoke(Object obj, Object obj2) {
                    Unit update$lambda$0$1;
                    update$lambda$0$1 = HomeUserCenterFragment.update$lambda$0$1($imgLabelUrl, autoPlayAnimation, this$0, $mine, (Composer) obj, ((Integer) obj2).intValue());
                    return update$lambda$0$1;
                }
            }, $composer, 54), $composer, (int) BR.negativeBtnVisible, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit update$lambda$0$1(String $imgLabelUrl, boolean $autoPlayAnimation, final HomeUserCenterFragment this$0, final AccountMine $mine, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C2082@86512L2364,2075@86169L2707:HomeUserCenterFragment.kt#yk7nxf");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(948307633, $changed, -1, "tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment.update.<anonymous>.<anonymous> (HomeUserCenterFragment.kt:2075)");
            }
            BiliImageKt.BiliImage($imgLabelUrl, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), $autoPlayAnimation, 1, (String) null, true, ComposableLambdaKt.rememberComposableLambda(1017130097, true, new Function3() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$$ExternalSyntheticLambda11
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit update$lambda$0$1$0;
                    update$lambda$0$1$0 = HomeUserCenterFragment.update$lambda$0$1$0(HomeUserCenterFragment.this, $mine, (BiliImageState) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return update$lambda$0$1$0;
                }
            }, $composer, 54), $composer, 1772976, 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit update$lambda$0$1$0(final HomeUserCenterFragment this$0, AccountMine $mine, BiliImageState it, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it):HomeUserCenterFragment.kt#yk7nxf");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer.changed(it) : $composer.changedInstance(it) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (!$composer.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1017130097, $dirty2, -1, "tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment.update.<anonymous>.<anonymous>.<anonymous> (HomeUserCenterFragment.kt:2083)");
            }
            if (it.getLoading()) {
                $composer.startReplaceGroup(328546920);
                ComposerKt.sourceInformation($composer, "2085@86633L513");
                Modifier modifier$iv = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv = (6 << 3) & BR.containerVisible;
                ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
                Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    factory$iv$iv$iv = factory$iv$iv$iv2;
                    $composer.createNode(factory$iv$iv$iv);
                } else {
                    factory$iv$iv$iv = factory$iv$iv$iv2;
                    $composer.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                int i = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i2 = ((6 >> 6) & BR.containerVisible) | 6;
                BoxScope $this$update_u24lambda_u240_u241_u240_u240 = boxScope;
                ComposerKt.sourceInformationMarkerStart($composer, 1633994666, "C2091@87055L6,2086@86714L394:HomeUserCenterFragment.kt#yk7nxf");
                BoxKt.Box(BackgroundKt.background-bw27NRU$default($this$update_u24lambda_u240_u241_u240_u240.align(SizeKt.width-3ABfNKs(SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(40)), Alignment.Companion.getTopStart()), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg3-0d7_KjU(), (Shape) null, 2, (Object) null), $composer, 0);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endReplaceGroup();
            } else if (it.getError()) {
                $composer.startReplaceGroup(329158550);
                $composer.endReplaceGroup();
                this$0.showVIPStatusLabel($mine);
                ViewExtKt.gone(this$0.mVipStatusImage);
            } else {
                if (it.getSucceed()) {
                    $composer.startReplaceGroup(329397312);
                    ComposerKt.sourceInformation($composer, "2112@88363L36,2111@88306L480");
                    BiliAnimatedDrawable drawable = it.getDrawable();
                    BiliAnimatedDrawable biliAnimatedDrawable = drawable instanceof BiliAnimatedDrawable ? drawable : null;
                    if (biliAnimatedDrawable != null) {
                        BiliAnimatedDrawable $this$update_u24lambda_u240_u241_u240_u241 = biliAnimatedDrawable;
                        $this$update_u24lambda_u240_u241_u240_u241.setAnimationListener(new AnimationListener() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$update$1$1$1$2$1
                            public /* synthetic */ void onAnimationLastFrame(BiliAnimatable biliAnimatable) {
                                AnimationListener.-CC.$default$onAnimationLastFrame(this, biliAnimatable);
                            }

                            public void onAnimationStart(BiliAnimatable animatable) {
                            }

                            public void onAnimationStop(BiliAnimatable animatable) {
                                Context requireContext = HomeUserCenterFragment.this.requireContext();
                                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                                Xpref.getDefaultSharedPreferences(requireContext).edit().putBoolean(HomeUserCenterFragment.KEY_VIP_LABEL_GIF_SHOWN, true).apply();
                                HomeUserCenterFragment.this.hardCoreAniShowing = false;
                            }
                        });
                    }
                    ImageKt.Image(DrawablePainterKt.rememberDrawablePainter(it.getDrawable(), $composer, 0), "Pic for VIP status", SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), Alignment.Companion.getTopStart(), ContentScale.Companion.getFit(), 0.0f, (ColorFilter) null, $composer, Painter.$stable | 28080, 96);
                } else {
                    $composer.startReplaceGroup(242625553);
                }
                $composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private final void showVIPStatusLabel(AccountMine mine) {
        VipUserInfo.VipLabel label;
        VipUserInfo.VipLabel label2;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        VipUserInfo vipUserInfo = mine.vip;
        String str = null;
        String vipStatus = (vipUserInfo == null || (label2 = vipUserInfo.getLabel()) == null) ? null : label2.getText();
        ViewExtKt.gone(this.mVipStatusImage);
        if (TextUtils.isEmpty(vipStatus)) {
            TextView textView = this.mVipStatus;
            if (textView != null) {
                textView.setVisibility(8);
            }
        } else {
            TextView textView2 = this.mRankStatus;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            TextView textView3 = this.mVipStatus;
            if (textView3 != null) {
                textView3.setVisibility(0);
            }
            VipUserInfo vipUserInfo2 = mine.vip;
            if (vipUserInfo2 != null && (label = vipUserInfo2.getLabel()) != null) {
                str = label.getLabelTheme();
            }
            setVipStatusMode(str, getVipThemeInfo((Context) activity));
        }
        TextView textView4 = this.mVipStatus;
        if (textView4 != null) {
            textView4.setText(vipStatus);
        }
    }

    private final void showUserLevel(final AccountMine mine) {
        AccountMine.SeniorGateFlash seniorGateFlash;
        AccountMine.TopLevelFlash topLevelFlash;
        Context context = getContext();
        if (context != null && this.mIsFragmentSelected) {
            AccountMine.Achievement achievement = mine.achievement;
            String levelFlashIcon = (achievement == null || (topLevelFlash = achievement.topLevelFlash) == null) ? null : topLevelFlash.icon;
            AccountMine.Achievement achievement2 = mine.achievement;
            String seniorGateFlashIcon = (achievement2 == null || (seniorGateFlash = achievement2.seniorGateFlash) == null) ? null : seniorGateFlash.icon;
            Function1 showOtherPops = new Function1() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$$ExternalSyntheticLambda10
                public final Object invoke(Object obj) {
                    Unit showUserLevel$lambda$0;
                    showUserLevel$lambda$0 = HomeUserCenterFragment.showUserLevel$lambda$0(HomeUserCenterFragment.this, mine, (Integer) obj);
                    return showUserLevel$lambda$0;
                }
            };
            String str = seniorGateFlashIcon;
            boolean z = true;
            if (!(str == null || str.length() == 0)) {
                if (!BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).getBoolean(KEY_SENIOR_GATE_SHOWN + BiliAccounts.get(context).mid(), false)) {
                    seniorFlashPop(seniorGateFlashIcon, KEY_SENIOR_GATE_SHOWN, showOtherPops);
                    return;
                }
            }
            String str2 = levelFlashIcon;
            if (str2 != null && str2.length() != 0) {
                z = false;
            }
            if (!z) {
                if (!BiliGlobalPreferenceHelper.getBLKVSharedPreference(context).getBoolean(KEY_SENIOR_VIP_SHOWN + BiliAccounts.get(context).mid(), false)) {
                    seniorFlashPop(levelFlashIcon, KEY_SENIOR_VIP_SHOWN, showOtherPops);
                    return;
                }
            }
            if (this.levelPopWindowShowingFlag) {
                return;
            }
            showNonSeniorUserLevel(mine);
            showOtherPops.invoke((Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showUserLevel$lambda$0(HomeUserCenterFragment this$0, AccountMine $mine, Integer margin) {
        AccountMine.SeniorStatus seniorStatus = $mine.seniorStatus;
        this$0.memberReminderBubble(seniorStatus != null ? seniorStatus.bubble : null);
        AccountMine.SeniorStatus seniorStatus2 = $mine.seniorStatus;
        if (seniorStatus2 != null) {
            seniorStatus2.bubble = null;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void showNonSeniorUserLevel(AccountMine mine) {
        boolean showSeniorEntrance;
        ImageView imageView;
        View view;
        if (this.levelPopWindowShowingFlag) {
            return;
        }
        boolean z = true;
        if (mine.level == 6) {
            AccountMine.SeniorStatus seniorStatus = mine.seniorStatus;
            if (seniorStatus != null ? seniorStatus.showEntrance() : false) {
                showSeniorEntrance = true;
                imageView = this.mLevelLabel;
                if (imageView != null) {
                    imageView.setVisibility(ListExtentionsKt.toVisibility(!showSeniorEntrance));
                }
                view = this.mLevelSeniorEntrance;
                if (view != null) {
                    view.setVisibility(ListExtentionsKt.toVisibility(showSeniorEntrance));
                }
                if (!showSeniorEntrance) {
                    ImageView imageView2 = this.mLevelSeniorEntranceLabel;
                    if (imageView2 != null) {
                        LevelImageUtilV2 levelImageUtilV2 = LevelImageUtilV2.INSTANCE;
                        int i = mine.level;
                        AccountMine.SeniorStatus seniorStatus2 = mine.seniorStatus;
                        imageView2.setImageResource(levelImageUtilV2.getLevelImage(i, seniorStatus2 != null ? seniorStatus2.isSeniorMember() : false));
                    }
                    View view2 = this.mLevelSeniorEntrance;
                    if (view2 != null) {
                        view2.setOnClickListener(getSeniorClickListener());
                    }
                    TextView textView = this.mLevelSeniorEntranceText;
                    if (textView != null) {
                        AccountMine.SeniorStatus seniorStatus3 = mine.seniorStatus;
                        String str = seniorStatus3 != null ? seniorStatus3.entranceTitle : null;
                        textView.setVisibility(ListExtentionsKt.toVisibility(!(str == null || StringsKt.isBlank(str))));
                    }
                    TextView textView2 = this.mLevelSeniorEntranceText;
                    if (textView2 != null) {
                        AccountMine.SeniorStatus seniorStatus4 = mine.seniorStatus;
                        textView2.setText(seniorStatus4 != null ? seniorStatus4.entranceTitle : null);
                    }
                    AccountMine.SeniorStatus seniorStatus5 = mine.seniorStatus;
                    String str2 = seniorStatus5 != null ? seniorStatus5.entranceTitle : null;
                    if (str2 != null && !StringsKt.isBlank(str2)) {
                        z = false;
                    }
                    if (!z) {
                        MineReporter mineReporter = MineReporter.INSTANCE;
                        AccountMine.SeniorStatus seniorStatus6 = mine.seniorStatus;
                        String intString = seniorStatus6 != null ? ListExtentionsKt.toIntString(seniorStatus6.isSeniorMember()) : null;
                        if (intString == null) {
                            intString = "";
                        }
                        mineReporter.reportShow(MineReporter.MINE_MEMBER_GUIDE_SHOW, MapsKt.mapOf(TuplesKt.to("vip_status", intString)));
                        return;
                    }
                    return;
                }
                ImageView imageView3 = this.mLevelLabel;
                if (imageView3 != null) {
                    LevelImageUtilV2 levelImageUtilV22 = LevelImageUtilV2.INSTANCE;
                    int i2 = mine.level;
                    AccountMine.SeniorStatus seniorStatus7 = mine.seniorStatus;
                    imageView3.setImageResource(levelImageUtilV22.getLevelImage(i2, seniorStatus7 != null ? seniorStatus7.isSeniorMember() : false));
                    return;
                }
                return;
            }
        }
        showSeniorEntrance = false;
        imageView = this.mLevelLabel;
        if (imageView != null) {
        }
        view = this.mLevelSeniorEntrance;
        if (view != null) {
        }
        if (!showSeniorEntrance) {
        }
    }

    private final void seniorFlashPop(String iconUrl, final String whichFlash, Function1<? super Integer, Unit> function1) {
        final Context context = getContext();
        if (context == null) {
            return;
        }
        ViewExtKt.gone(this.mLevelLabel);
        ViewExtKt.gone(this.mLevelSeniorEntrance);
        if (this.levelPopWindowShowingFlag) {
            return;
        }
        this.levelPopWindowShowingFlag = true;
        final View contentView = LayoutInflater.from(context).inflate(tv.danmaku.bili.R.layout.bili_layout_mine_senior_flash, (ViewGroup) null);
        contentView.measure(0, 0);
        View findViewById = contentView.findViewById(tv.danmaku.bili.R.id.mine_level_flash);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        View view = (BiliImageView) findViewById;
        View clickArea = contentView.findViewById(tv.danmaku.bili.R.id.mine_level_flash_click_area);
        Intrinsics.checkNotNullExpressionValue(clickArea, "findViewById(...)");
        clickArea.setOnClickListener(getSeniorClickListener());
        PopupWindow it = this.levelPopWindow;
        if (it != null && it.isShowing()) {
            __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookPopupWindowDismiss(it);
            this.levelPopWindow = null;
        }
        this.levelPopWindow = new PopupWindow(contentView, -2, -2);
        FrameLayout frameLayout = this.mRootView;
        final View popAnchor = frameLayout != null ? frameLayout.findViewById(tv.danmaku.bili.R.id.edit_information) : null;
        final PopupWindow pop = this.levelPopWindow;
        if (pop != null) {
            ImageDataSource dataSourceHolder = DrawableAcquireRequestBuilder.enableAnimatable$default(BiliImageLoader.INSTANCE.acquire(view).with(view).asDrawable().url(iconUrl), 1, (Boolean) null, 2, (Object) null).submit();
            dataSourceHolder.subscribe(new HomeUserCenterFragment$seniorFlashPop$2$1(view, whichFlash, function1));
            pop.getContentView().setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    HomeUserCenterFragment.seniorFlashPop$lambda$1$0(HomeUserCenterFragment.this, view2);
                }
            });
            if (popAnchor != null) {
                popAnchor.post(new Runnable() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        HomeUserCenterFragment.seniorFlashPop$lambda$1$1(context, whichFlash, contentView, popAnchor, pop);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void seniorFlashPop$lambda$1$0(HomeUserCenterFragment this$0, View it) {
        View view = this$0.mUserInfoLayout;
        if (view != null) {
            view.callOnClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void seniorFlashPop$lambda$1$1(Context $context, String $whichFlash, View $contentView, View $popAnchor, PopupWindow $pop) {
        BiliGlobalPreferenceHelper.getBLKVSharedPreference($context).edit().putBoolean($whichFlash + BiliAccounts.get($context).mid(), true).apply();
        int offsetY = ((-($contentView.getMeasuredHeight() + $popAnchor.getHeight())) / 2) + DisplayUtils.dp2Px(1);
        PopupWindowCompat.showAsDropDown($pop, $popAnchor, -DisplayUtils.dp2Px(1), offsetY, 8388613);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Flow<Integer> scrollStateFlow(RecyclerView $this$scrollStateFlow) {
        return FlowKt.callbackFlow(new HomeUserCenterFragment$scrollStateFlow$1($this$scrollStateFlow, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object scrollToAdapterPosition(int menuGroupType, long locationItemId, Continuation<? super Unit> continuation) {
        Object obj;
        boolean z;
        RecyclerView outerRecyclerView = this.mRecycleView;
        if (outerRecyclerView == null) {
            return Unit.INSTANCE;
        }
        Iterator it = CollectionsKt.withIndex(this.mSectionListV2).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            IndexedValue it2 = (IndexedValue) obj;
            if (((MenuGroup) it2.getValue()).moduleType == menuGroupType) {
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
        IndexedValue menuGroupWithIndex = (IndexedValue) obj;
        if (menuGroupWithIndex == null) {
            return Unit.INSTANCE;
        }
        Object $this$asTo$iv = outerRecyclerView.getLayoutManager();
        if ($this$asTo$iv != null) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) ($this$asTo$iv instanceof LinearLayoutManager ? $this$asTo$iv : null);
            if (linearLayoutManager != null) {
                linearLayoutManager.smoothScrollToPosition(outerRecyclerView, new RecyclerView.State(), menuGroupWithIndex.getIndex());
            }
        }
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new HomeUserCenterFragment$scrollToAdapterPosition$2(this, outerRecyclerView, menuGroupWithIndex, locationItemId, null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object showTribeeRevisitPop(final View view, boolean anchorInRight, Continuation<? super Unit> continuation) {
        HomeUserCenterFragment$showTribeeRevisitPop$1 homeUserCenterFragment$showTribeeRevisitPop$1;
        PopupWindow tribeeRevisitPop;
        Object $this$asTo$iv;
        if (continuation instanceof HomeUserCenterFragment$showTribeeRevisitPop$1) {
            homeUserCenterFragment$showTribeeRevisitPop$1 = (HomeUserCenterFragment$showTribeeRevisitPop$1) continuation;
            if ((homeUserCenterFragment$showTribeeRevisitPop$1.label & Integer.MIN_VALUE) != 0) {
                homeUserCenterFragment$showTribeeRevisitPop$1.label -= Integer.MIN_VALUE;
                Object $result = homeUserCenterFragment$showTribeeRevisitPop$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (homeUserCenterFragment$showTribeeRevisitPop$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        final Context context = getContext();
                        if (context != null) {
                            final View contentView = LayoutInflater.from(context).inflate(tv.danmaku.bili.R.layout.bili_app_mine_revisit_in_tribee_pop, (ViewGroup) null);
                            ImageView ivAnchor = (ImageView) contentView.findViewById(tv.danmaku.bili.R.id.iv_anchor);
                            if (ivAnchor != null && ($this$asTo$iv = ivAnchor.getLayoutParams()) != null) {
                                LinearLayout.LayoutParams $this$showTribeeRevisitPop_u24lambda_u240 = (LinearLayout.LayoutParams) ($this$asTo$iv instanceof LinearLayout.LayoutParams ? $this$asTo$iv : null);
                                if ($this$showTribeeRevisitPop_u24lambda_u240 != null) {
                                    if (anchorInRight) {
                                        $this$showTribeeRevisitPop_u24lambda_u240.gravity = 8388613;
                                        $this$showTribeeRevisitPop_u24lambda_u240.setMarginEnd(DisplayUtils.dp2Px(34));
                                    } else {
                                        $this$showTribeeRevisitPop_u24lambda_u240.gravity = 8388611;
                                        $this$showTribeeRevisitPop_u24lambda_u240.setMarginStart(DisplayUtils.dp2Px(34));
                                    }
                                }
                            }
                            TextView textView = (TextView) contentView.findViewById(tv.danmaku.bili.R.id.tv_text);
                            if (textView != null) {
                                textView.setText(getResources().getString(bili.resource.space.R.string.space_global_string_349));
                            }
                            final PopupWindow tribeeRevisitPop2 = new PopupWindow(contentView, -2, -2);
                            tribeeRevisitPop2.setOutsideTouchable(true);
                            final boolean z = anchorInRight;
                            view.post(new Runnable() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$$ExternalSyntheticLambda12
                                @Override // java.lang.Runnable
                                public final void run() {
                                    HomeUserCenterFragment.showTribeeRevisitPop$lambda$2(context, contentView, tribeeRevisitPop2, view, z);
                                }
                            });
                            homeUserCenterFragment$showTribeeRevisitPop$1.L$0 = tribeeRevisitPop2;
                            homeUserCenterFragment$showTribeeRevisitPop$1.label = 1;
                            if (DelayKt.delay(3000L, homeUserCenterFragment$showTribeeRevisitPop$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            tribeeRevisitPop = tribeeRevisitPop2;
                            break;
                        } else {
                            return Unit.INSTANCE;
                        }
                    case 1:
                        tribeeRevisitPop = (PopupWindow) homeUserCenterFragment$showTribeeRevisitPop$1.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookPopupWindowDismiss(tribeeRevisitPop);
                return Unit.INSTANCE;
            }
        }
        homeUserCenterFragment$showTribeeRevisitPop$1 = new HomeUserCenterFragment$showTribeeRevisitPop$1(this, continuation);
        Object $result2 = homeUserCenterFragment$showTribeeRevisitPop$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (homeUserCenterFragment$showTribeeRevisitPop$1.label) {
        }
        __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookPopupWindowDismiss(tribeeRevisitPop);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showTribeeRevisitPop$lambda$2(Context $context, View $contentView, PopupWindow $tribeeRevisitPop, View $popAnchor, boolean $anchorInRight) {
        int width;
        BiliGlobalPreferenceHelper.getInstance($context).setBoolean(KEY_TRIBEE_REVISIT_GUIDE_SHOWN, true);
        $contentView.measure(0, 1073741824);
        if (!$anchorInRight) {
            width = ($popAnchor.getWidth() / 2) - DisplayUtils.dp2Px(39);
        } else {
            width = ($popAnchor.getWidth() - $contentView.getMeasuredWidth()) - (($popAnchor.getWidth() / 2) - DisplayUtils.dp2Px(39));
        }
        PopupWindowCompat.showAsDropDown($tribeeRevisitPop, $popAnchor, width, 0, 0);
    }

    private final void seniorFlashPopHide() {
        PopupWindow it = this.levelPopWindow;
        if (it != null) {
            __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookPopupWindowDismiss(it);
            this.levelPopWindowShowingFlag = false;
        }
    }

    private final void seniorLevelShow() {
        final AccountMine accountMine = getMMineInfo();
        if (accountMine != null) {
            if (this.levelPopWindow != null) {
                this.levelPopWindowShowingFlag = false;
                showNonSeniorUserLevel(accountMine);
                return;
            }
            new Function0() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$$ExternalSyntheticLambda16
                public final Object invoke() {
                    Unit seniorLevelShow$lambda$0$1;
                    seniorLevelShow$lambda$0$1 = HomeUserCenterFragment.seniorLevelShow$lambda$0$1(HomeUserCenterFragment.this, accountMine);
                    return seniorLevelShow$lambda$0$1;
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit seniorLevelShow$lambda$0$1(HomeUserCenterFragment this$0, AccountMine $accountMine) {
        this$0.showUserLevel($accountMine);
        return Unit.INSTANCE;
    }

    private final View.OnClickListener getSeniorClickListener() {
        return (View.OnClickListener) this.seniorClickListener$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$seniorClickListener$2$1] */
    public static final HomeUserCenterFragment$seniorClickListener$2$1 seniorClickListener_delegate$lambda$0(final HomeUserCenterFragment this$0) {
        return new View.OnClickListener() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$seniorClickListener$2$1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                AccountMine.SeniorStatus seniorStatus;
                String it;
                AccountMine.SeniorStatus seniorStatus2;
                String str = null;
                if (HomeUserCenterFragment.checkRestrictMode$default(HomeUserCenterFragment.this, false, 1, null)) {
                    return;
                }
                MineReporter mineReporter = MineReporter.INSTANCE;
                AccountMine mMineInfo = HomeUserCenterFragment.this.getMMineInfo();
                if (mMineInfo != null && (seniorStatus2 = mMineInfo.seniorStatus) != null) {
                    str = ListExtentionsKt.toIntString(seniorStatus2.isSeniorMember());
                }
                if (str == null) {
                    str = "";
                }
                mineReporter.reportClick(MineReporter.MINE_MEMBER_GUIDE_CLICK, MapsKt.mapOf(TuplesKt.to("vip_status", str)));
                AccountMine mMineInfo2 = HomeUserCenterFragment.this.getMMineInfo();
                if (mMineInfo2 != null && (seniorStatus = mMineInfo2.seniorStatus) != null && (it = seniorStatus.url) != null) {
                    BLRouter.routeTo(RouteRequestKt.toRouteRequest(it), HomeUserCenterFragment.this.getContext());
                }
            }
        };
    }

    private final void setSplitLine(boolean isPure) {
        if (isPure) {
            View view = this.mSplitLine1;
            if (view != null) {
                view.setVisibility(0);
            }
            View view2 = this.mSplitLine2;
            if (view2 != null) {
                view2.setVisibility(0);
                return;
            }
            return;
        }
        View view3 = this.mSplitLine1;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        View view4 = this.mSplitLine2;
        if (view4 != null) {
            view4.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVipStatusMode(String labelName, VipThemeInfo vipThemeInfo) {
        TextView $this$setVipStatusMode_u24lambda_u240 = this.mVipStatus;
        if ($this$setVipStatusMode_u24lambda_u240 != null) {
            Context context = $this$setVipStatusMode_u24lambda_u240.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            VipThemeInfo.VipThemeDetailInfo detailInfo = getVipThemeDetailInfo(context, labelName, vipThemeInfo);
            if (detailInfo == null) {
                detailInfo = new VipThemeInfo.VipThemeDetailInfo();
            } else {
                detailInfo.checkDetailInfo();
            }
            $this$setVipStatusMode_u24lambda_u240.setTextColor(Color.parseColor(detailInfo.textColor));
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(DisplayUtils.dp2Px(2));
            if (detailInfo.bgStyle == 1) {
                gradientDrawable.setColor(Color.parseColor(detailInfo.bgColor));
            }
            if (detailInfo.bgStyle == 2) {
                gradientDrawable.setStroke(DisplayUtils.dp2Px(0.5f), Color.parseColor(detailInfo.borderColor));
            }
            if (detailInfo.bgStyle == 3) {
                gradientDrawable.setColor(Color.parseColor(detailInfo.bgColor));
                gradientDrawable.setStroke(DisplayUtils.dp2Px(0.5f), Color.parseColor(detailInfo.borderColor));
            }
            $this$setVipStatusMode_u24lambda_u240.setBackground(gradientDrawable);
        }
    }

    private final VipThemeInfo getVipThemeInfo(final Context context) {
        VipThemeInfo vipThemeInfo;
        if (this.mVipThemeInfo != null) {
            vipThemeInfo = this.mVipThemeInfo;
        } else {
            this.mVipThemeInfo = VipThemeConfigManager.getVipThemeInfoFromMod(context, new VipThemeConfigManager.OnModLoadSuccess() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$getVipThemeInfo$1
                public void onSuccess() {
                    VipThemeInfo vipThemeInfo2;
                    VipUserInfo vipUserInfo;
                    VipUserInfo.VipLabel label;
                    String str = null;
                    HomeUserCenterFragment.this.mVipThemeInfo = VipThemeConfigManager.getVipThemeInfoFromMod(context, (VipThemeConfigManager.OnModLoadSuccess) null);
                    HomeUserCenterFragment homeUserCenterFragment = HomeUserCenterFragment.this;
                    AccountMine mMineInfo = HomeUserCenterFragment.this.getMMineInfo();
                    if (mMineInfo != null && (vipUserInfo = mMineInfo.vip) != null && (label = vipUserInfo.getLabel()) != null) {
                        str = label.getLabelTheme();
                    }
                    vipThemeInfo2 = HomeUserCenterFragment.this.mVipThemeInfo;
                    Intrinsics.checkNotNull(vipThemeInfo2);
                    homeUserCenterFragment.setVipStatusMode(str, vipThemeInfo2);
                }
            });
            vipThemeInfo = this.mVipThemeInfo;
        }
        Intrinsics.checkNotNull(vipThemeInfo);
        return vipThemeInfo;
    }

    private final VipThemeInfo.VipThemeDetailInfo getVipThemeDetailInfo(Context context, String labelName, VipThemeInfo vipThemeInfo) {
        VipThemeInfo.VipThemeDetailInfo vipThemeDetailInfo;
        VipThemeInfo.VipThemeDetailInfo vipThemeDetailInfo2;
        Garb garb = GarbManager.getGarbWithNightMode(context);
        if (TextUtils.isEmpty(labelName)) {
            return null;
        }
        if (garb.isPure()) {
            if (garb.isNight()) {
                vipThemeDetailInfo2 = (VipThemeInfo.VipThemeDetailInfo) vipThemeInfo.appThemeNight.get(labelName);
            } else if (garb.isWhite()) {
                vipThemeDetailInfo2 = (VipThemeInfo.VipThemeDetailInfo) vipThemeInfo.appThemeWhite.get(labelName);
            } else {
                vipThemeDetailInfo2 = (VipThemeInfo.VipThemeDetailInfo) vipThemeInfo.getAppThemeColor().get(labelName);
            }
            VipThemeInfo.VipThemeDetailInfo detailInfo = vipThemeDetailInfo2;
            return detailInfo;
        }
        if (garb.isPrimaryOnly()) {
            if (MultipleThemeUtils.isNightTheme(context)) {
                vipThemeDetailInfo = (VipThemeInfo.VipThemeDetailInfo) vipThemeInfo.appThemeNight.get(labelName);
            } else {
                vipThemeDetailInfo = (VipThemeInfo.VipThemeDetailInfo) vipThemeInfo.appThemeWhite.get(labelName);
            }
        } else {
            vipThemeDetailInfo = (VipThemeInfo.VipThemeDetailInfo) vipThemeInfo.getAppThemeSkinDark().get(labelName);
        }
        VipThemeInfo.VipThemeDetailInfo detailInfo2 = vipThemeDetailInfo;
        return detailInfo2;
    }

    private final void setAvatar(AccountMine mine) {
        NFTInfo nFTInfo;
        String it;
        LayerAvatarView layerAvatarView;
        if (getActivity() == null) {
            return;
        }
        boolean z = false;
        if ((mine != null ? mine.avatar : null) == null || mine.showFaceGuide || !AvatarUtils.INSTANCE.getUseLayerAvatar()) {
            LayerAvatarView layerAvatarView2 = this.mLayerAvatar;
            if (layerAvatarView2 != null) {
                layerAvatarView2.setVisibility(8);
            }
            MineAvatarFrameLayout mineAvatarFrameLayout = this.mAvatar;
            if (mineAvatarFrameLayout != null) {
                mineAvatarFrameLayout.setVisibility(0);
            }
            AvatarShowParam showParamBuilder = new AvatarShowParam((mine == null || (r5 = mine.face) == null) ? "" : "");
            showParamBuilder.setDefaultRes(com.bilibili.app.comm.baseres.R.drawable.ic_default_avatar);
            if (mine != null) {
                MineAvatarFrameLayout mineAvatarFrameLayout2 = this.mAvatar;
                if (mineAvatarFrameLayout2 != null) {
                    mineAvatarFrameLayout2.setGuideView(mine.showFaceGuide);
                }
                if (mine.showFaceGuide) {
                    MineReporter.INSTANCE.reportShow(MineReporter.MINE_AVATAR_GUIDE_SHOW);
                }
                OfficialVerify officialVerify = mine.officialVerify;
                Integer valueOf = officialVerify != null ? Integer.valueOf(officialVerify.type) : null;
                if (valueOf != null && valueOf.intValue() == 1) {
                    AvatarShowParam.setEnterpriseOfficial$default(showParamBuilder, false, 1, (Object) null);
                } else if (valueOf != null && valueOf.intValue() == 0) {
                    AvatarShowParam.setPersonalOfficial$default(showParamBuilder, false, 1, (Object) null);
                }
                AccountMine.NFTData $this$setAvatar_u24lambda_u240 = mine.nftData;
                if ($this$setAvatar_u24lambda_u240 == null) {
                    nFTInfo = null;
                } else {
                    int i = $this$setAvatar_u24lambda_u240.type;
                    AccountMine.NFTIcon nFTIcon = $this$setAvatar_u24lambda_u240.icon;
                    int value = nFTIcon != null ? nFTIcon.showStatus : ZoomingType.DEFAULT.getValue();
                    AccountMine.NFTIcon nFTIcon2 = $this$setAvatar_u24lambda_u240.icon;
                    nFTInfo = new NFTInfo(i, value, nFTIcon2 != null ? nFTIcon2.url : null, false, 8, (DefaultConstructorMarker) null);
                }
                showParamBuilder.setNFTBadge(nFTInfo);
                AccountMine.Pendant pendant = mine.pendant;
                if (pendant != null && (it = pendant.getImageEnhanceUrl()) != null) {
                    String it2 = StringsKt.isBlank(it) ? null : it;
                    if (it2 != null) {
                        showParamBuilder.setPendant(it2, true);
                    }
                }
            }
            MineAvatarFrameLayout mineAvatarFrameLayout3 = this.mAvatar;
            if (mineAvatarFrameLayout3 != null) {
                if (mine != null && mine.showFaceGuide) {
                    z = true;
                }
                mineAvatarFrameLayout3.show(showParamBuilder, z);
                return;
            }
            return;
        }
        LayerAvatarView layerAvatarView3 = this.mLayerAvatar;
        if (layerAvatarView3 != null) {
            layerAvatarView3.setVisibility(0);
        }
        MineAvatarFrameLayout mineAvatarFrameLayout4 = this.mAvatar;
        if (mineAvatarFrameLayout4 != null) {
            mineAvatarFrameLayout4.setVisibility(8);
        }
        AvatarItem it3 = mine.avatar;
        if (it3 != null && (layerAvatarView = this.mLayerAvatar) != null) {
            layerAvatarView.show(it3, MapsKt.mapOf(TuplesKt.to(new PluginBuilderKey(ConfigKey.DarkModeOverride), new IAvatarPluginFactory<MineAvatarDrawPlugin>() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$setAvatar$4$1
                public /* synthetic */ AvatarPluginPainter getPlugin(LayerTagConfig layerTagConfig) {
                    return IAvatarPluginFactory.-CC.$default$getPlugin(this, layerTagConfig);
                }

                public MineAvatarDrawPlugin getPlugin(AvatarLayer layer, LayerTagConfig data) {
                    Intrinsics.checkNotNullParameter(layer, "layer");
                    Intrinsics.checkNotNullParameter(data, "data");
                    return new MineAvatarDrawPlugin(layer, data);
                }

                public ConfigKey getRelatedKey() {
                    return ConfigKey.DarkModeAssociate;
                }
            })));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mLoginClickListener$lambda$0(HomeUserCenterFragment this$0, View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        Context activity = this$0.getActivity();
        if (activity == null) {
            return;
        }
        MineReporter.reportTopTabBarClick("主页", "1");
        if (BiliAccounts.get(activity).isLogin()) {
            if (this$0.checkTeenRestrictMode()) {
                return;
            }
            SpaceRouter.startSpace(this$0.getContext(), BiliAccounts.get(activity).mid());
            return;
        }
        Activity warpActivity = ActivityUtils.getWrapperActivity(activity);
        RouteRequest request = new RouteRequest.Builder("activity://main/login/").extras(new Function1() { // from class: tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$$ExternalSyntheticLambda19
            public final Object invoke(Object obj) {
                Unit mLoginClickListener$lambda$0$0;
                mLoginClickListener$lambda$0$0 = HomeUserCenterFragment.mLoginClickListener$lambda$0$0((MutableBundleLike) obj);
                return mLoginClickListener$lambda$0$0;
            }
        }).requestCode(1001).build();
        BLRouter.routeTo(request, warpActivity);
        NavigationReporter.reportLoginClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit mLoginClickListener$lambda$0$0(MutableBundleLike $this$extras) {
        Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
        $this$extras.put("scene", MainRouteUris.MODULE_MAIN);
        $this$extras.put(LoginOriginalActivityV2.KEY_PROMPT_SCENE, OnePassLoginReportManagerKt.SPM_ID_MINE_PAGE_NO_LOGIN);
        $this$extras.put("from_spmid", "main.my-information.my-login.0");
        return Unit.INSTANCE;
    }

    private final Bundle createPvArgs() {
        ArrayList visibleMenu = new ArrayList();
        for (MenuGroup menuGroup : this.mSectionListV2) {
            List it = menuGroup.itemList;
            if (it != null) {
                for (Object obj : it) {
                    Intrinsics.checkNotNullExpressionValue(obj, "next(...)");
                    MenuGroup.Item item = (MenuGroup.Item) obj;
                    visibleMenu.add(Long.valueOf(item.id));
                }
            }
        }
        Bundle args = new Bundle();
        args.putString("module_id", visibleMenu.toString());
        args.putString("publish_btn_type", this.mUpperReportType);
        args.putString("live_btn_type", this.mLiveReportType);
        return args;
    }

    /* compiled from: HomeUserCenterFragment.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/HomeUserCenterFragment$Companion;", "", "<init>", "()V", "TAG", "", "NAVIGATION_EVENT_ID", "QR_ENTRANCE_CLICK", "REQUEST_CODE_LOGIN", "", "PENDANT_AVATAR_BORDER_WIDTH", "", "KEY_GLOBAL_LINK_ENTRACE_SHOWN", "KEY_SHOW_GLOBALLINK_BUBBLE", "FF_KEY_GLOBALLINK_ENTRANCE_ENABLE", "KEY_VIP_LABEL_GIF_SHOWN", "KEY_SENIOR_GATE_SHOWN", "KEY_SENIOR_VIP_SHOWN", "KEY_TRIBEE_REVISIT_GUIDE_SHOWN", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final void tryNotifyTips() {
        Iterable $this$onEachIndexed$iv;
        int $i$f$onEachIndexed;
        Iterable $this$onEachIndexed_u24lambda_u240$iv;
        int i;
        Iterable $this$forEachIndexed$iv$iv;
        Object arrayList;
        Pair pair;
        MenuItemTip findValidOrNull;
        Iterable $this$onEachIndexed$iv2 = this.mSectionListV2;
        int $i$f$onEachIndexed2 = 0;
        Iterable $this$onEachIndexed_u24lambda_u240$iv2 = $this$onEachIndexed$iv2;
        int i2 = 0;
        Iterable $this$forEachIndexed$iv$iv2 = $this$onEachIndexed_u24lambda_u240$iv2;
        int index = 0;
        for (Object item$iv$iv : $this$forEachIndexed$iv$iv2) {
            int index$iv$iv = index + 1;
            if (index < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            MenuGroup menuGroup = (MenuGroup) item$iv$iv;
            List list = menuGroup.menuItemTips;
            if (!(list != null && (list.isEmpty() ^ true))) {
                $this$onEachIndexed$iv = $this$onEachIndexed$iv2;
                $i$f$onEachIndexed = $i$f$onEachIndexed2;
                $this$onEachIndexed_u24lambda_u240$iv = $this$onEachIndexed_u24lambda_u240$iv2;
                i = i2;
                $this$forEachIndexed$iv$iv = $this$forEachIndexed$iv$iv2;
            } else {
                List $this$findNext$iv = menuGroup.menuItemTips;
                if ($this$findNext$iv == null) {
                    $this$onEachIndexed$iv = $this$onEachIndexed$iv2;
                    $i$f$onEachIndexed = $i$f$onEachIndexed2;
                    $this$onEachIndexed_u24lambda_u240$iv = $this$onEachIndexed_u24lambda_u240$iv2;
                    i = i2;
                    $this$forEachIndexed$iv$iv = $this$forEachIndexed$iv$iv2;
                } else {
                    int current$iv = NoticeExtKt.getLastMenuItemIndex($this$findNext$iv);
                    MenuItemTip menuItemTip = null;
                    if ($this$findNext$iv.size() == 0) {
                        $this$onEachIndexed$iv = $this$onEachIndexed$iv2;
                        $i$f$onEachIndexed = $i$f$onEachIndexed2;
                        $this$onEachIndexed_u24lambda_u240$iv = $this$onEachIndexed_u24lambda_u240$iv2;
                        i = i2;
                        $this$forEachIndexed$iv$iv = $this$forEachIndexed$iv$iv2;
                        pair = null;
                    } else {
                        if ($this$findNext$iv instanceof RandomAccess) {
                            $this$onEachIndexed$iv = $this$onEachIndexed$iv2;
                            arrayList = $this$findNext$iv;
                        } else {
                            $this$onEachIndexed$iv = $this$onEachIndexed$iv2;
                            arrayList = new ArrayList($this$findNext$iv);
                        }
                        Object list$iv$iv = arrayList;
                        $i$f$onEachIndexed = $i$f$onEachIndexed2;
                        int p$iv$iv = RangesKt.coerceAtLeast(current$iv, -1);
                        int offset$iv$iv = 1;
                        $this$onEachIndexed_u24lambda_u240$iv = $this$onEachIndexed_u24lambda_u240$iv2;
                        int size = $this$findNext$iv.size();
                        if (1 <= size) {
                            while (true) {
                                i = i2;
                                int size2 = (p$iv$iv + offset$iv$iv) % $this$findNext$iv.size();
                                $this$forEachIndexed$iv$iv = $this$forEachIndexed$iv$iv2;
                                Object node$iv$iv = CollectionsKt.getOrNull((List) list$iv$iv, size2);
                                if (node$iv$iv != null) {
                                    MenuItemTip it$iv = (MenuItemTip) node$iv$iv;
                                    if (it$iv.checkValid() && !NoticeExtKt.isClosed(it$iv)) {
                                        pair = TuplesKt.to(Integer.valueOf(size2), node$iv$iv);
                                        break;
                                    }
                                }
                                if (offset$iv$iv == size) {
                                    break;
                                }
                                offset$iv$iv++;
                                $this$forEachIndexed$iv$iv2 = $this$forEachIndexed$iv$iv;
                                i2 = i;
                            }
                        } else {
                            i = i2;
                            $this$forEachIndexed$iv$iv = $this$forEachIndexed$iv$iv2;
                        }
                        pair = null;
                    }
                    if (pair != null) {
                        Pair it$iv2 = pair;
                        int idx = ((Number) it$iv2.getFirst()).intValue();
                        List list2 = menuGroup.menuItemTips;
                        boolean z = (list2 == null || (findValidOrNull = NoticeExtKt.findValidOrNull(list2)) == null || findValidOrNull.getExposed()) ? false : true;
                        boolean $this$tryNotifyTips_u24lambda_u240_u240_u240 = !z;
                        BLog.i(TAG, "moveCursor=" + $this$tryNotifyTips_u24lambda_u240_u240_u240 + ", cursor=" + idx + ", withOutChanged");
                        if (!z) {
                            NoticeExtKt.setCurrent($this$findNext$iv, (Integer) it$iv2.getFirst());
                        }
                        menuItemTip = (MenuItemTip) it$iv2.getSecond();
                    }
                    if (menuItemTip != null) {
                        MenuItemTip $this$tryNotifyTips_u24lambda_u240_u241 = menuItemTip;
                        $this$tryNotifyTips_u24lambda_u240_u241.setExposed(false);
                        HomeUserCenterAdapter homeUserCenterAdapter = this.mAdapter;
                        if (homeUserCenterAdapter != null) {
                            homeUserCenterAdapter.notifyItemChanged(index);
                        }
                    }
                }
            }
            index = index$iv$iv;
            $this$onEachIndexed$iv2 = $this$onEachIndexed$iv;
            $i$f$onEachIndexed2 = $i$f$onEachIndexed;
            $this$onEachIndexed_u24lambda_u240$iv2 = $this$onEachIndexed_u24lambda_u240$iv;
            $this$forEachIndexed$iv$iv2 = $this$forEachIndexed$iv$iv;
            i2 = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setGarbIconColor() {
        int tintColor;
        BiliImageView $this$setGarbIconColor_u24lambda_u240 = this.mMineThemeIcon;
        if ($this$setGarbIconColor_u24lambda_u240 != null) {
            Context context = $this$setGarbIconColor_u24lambda_u240.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            Garb garb = GarbManager.getGarbWithNightMode(context);
            if (garb.isPure()) {
                if (garb.isNight()) {
                    tintColor = com.bilibili.lib.theme.R.color.Ga7;
                } else if (garb.isWhite()) {
                    tintColor = com.bilibili.lib.theme.R.color.Ga7;
                } else {
                    tintColor = 17170443;
                }
            } else if (garb.isPrimaryOnly()) {
                tintColor = com.bilibili.lib.theme.R.color.Ga7;
            } else if (!garb.isDarkMode()) {
                tintColor = 17170443;
            } else {
                tintColor = tv.danmaku.bili.R.color.bili_mine_main_style_garbLight;
            }
            $this$setGarbIconColor_u24lambda_u240.setColorFilter(ContextCompat.getColor($this$setGarbIconColor_u24lambda_u240.getContext(), tintColor));
        }
    }

    private final void refreshView(View view) {
        if (view == null) {
            return;
        }
        if (view instanceof Tintable) {
            ((Tintable) view).tint();
        }
        if (view instanceof ViewGroup) {
            int count = ((ViewGroup) view).getChildCount();
            for (int i = 0; i < count; i++) {
                refreshView(((ViewGroup) view).getChildAt(i));
            }
        }
    }

    public void onFragmentHide(Flag lastFlag) {
        Intrinsics.checkNotNullParameter(lastFlag, "lastFlag");
        super.onFragmentHide(lastFlag);
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
            HomeUserCenterViewModel $this$onFragmentHide_u24lambda_u240 = getViewModel();
            $this$onFragmentHide_u24lambda_u240.onAction(new HomeUserCenterAction.PageVisibilityChange(false));
        }
        this.mIsMineShowing = false;
        Surface $this$onFragmentHide_u24lambda_u241 = this.mSurface;
        if ($this$onFragmentHide_u24lambda_u241 != null) {
            $this$onFragmentHide_u24lambda_u241.release();
            this.mSurface = null;
        }
        IjkMediaPlayer $this$onFragmentHide_u24lambda_u242 = this.mMediaPlayer;
        if ($this$onFragmentHide_u24lambda_u242 != null) {
            $this$onFragmentHide_u24lambda_u242.release();
            this.mMediaPlayer = null;
        }
        TextureView it = this.mMineGarbBgAnimatorView;
        if (it != null) {
            FrameLayout frameLayout = this.mMineGarbLayout;
            if (frameLayout != null) {
                frameLayout.removeView(it);
            }
            this.mMineGarbBgAnimatorView = null;
        }
        this.mScrollReporter.notifyPageVisibilityChanged(false);
        PageViewTracker.getInstance().setFragmentVisibility((Fragment) this, false);
    }

    public void onFragmentShow(Flag lastFlag) {
        Garb it;
        Intrinsics.checkNotNullParameter(lastFlag, "lastFlag");
        super.onFragmentShow(lastFlag);
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
            HomeUserCenterViewModel $this$onFragmentShow_u24lambda_u240 = getViewModel();
            $this$onFragmentShow_u24lambda_u240.onAction(new HomeUserCenterAction.PageVisibilityChange(true));
        }
        this.mIsMineShowing = true;
        RecyclerView recyclerView = this.mRecycleView;
        if (recyclerView != null) {
            recyclerView.scrollToPosition(0);
        }
        Context activity = getActivity();
        if (activity != null && (it = GarbManager.getGarbWithNightMode(activity)) != null) {
            setHeadAnimator(it);
        }
        this.mScrollReporter.notifyPageVisibilityChanged(true);
        getMGameCenter().notifyGameCenterUpdate();
        this.globalLinkShowing = false;
        this.memberBubbleShowing = false;
        this.hardCoreAniShowing = false;
        PageViewTracker.getInstance().setFragmentVisibility((Fragment) this, true);
    }

    private final void setStatusBarMode() {
        IDrawerHost findActivityOrNull = UtilKt.findActivityOrNull(getContext());
        if ((findActivityOrNull instanceof IDrawerHost) && this.mIsFragmentSelected && GarbManager.getGarbWithNightMode((Context) findActivityOrNull).isPrimaryOnly()) {
            findActivityOrNull.tintStatusBarPureForDrawer();
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1) {
            switch (requestCode) {
                case 17:
                    String modifyName = data != null ? data.getStringExtra("key_modify_name_success") : null;
                    if (!TextUtils.isEmpty(modifyName)) {
                        this.mNeedRefresh = false;
                        View view = this.mNickNameGuideView;
                        if (view != null) {
                            view.setVisibility(8);
                        }
                        NickNameTextView nickNameTextView = this.mNickName;
                        if (nickNameTextView != null) {
                            nickNameTextView.setVisibility(0);
                        }
                        NickNameTextView nickNameTextView2 = this.mNickName;
                        if (nickNameTextView2 != null) {
                            nickNameTextView2.setText(modifyName);
                            return;
                        }
                        return;
                    }
                    return;
                case 1001:
                    AvatarUploader.Companion.uploadAvatar(AvatarChooser.PhotoSource.TAKE, (Uri) null, this.mUploadCallback);
                    return;
                case 1002:
                    ArrayList result = Boxing.getResult(data);
                    if (result == null || result.isEmpty()) {
                        return;
                    }
                    Object obj = result.get(0);
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.bilibili.boxing.model.entity.impl.ImageMedia");
                    ImageMedia cropMedia = (ImageMedia) obj;
                    AvatarUploader.Companion.uploadAvatar(AvatarChooser.PhotoSource.CHOOSE, cropMedia.getImageUri(), this.mUploadCallback);
                    return;
                case 1003:
                case 1005:
                    if (data != null) {
                        Uri uri = (Uri) data.getParcelableExtra("aphro_crop_image_uri");
                        AvatarUploader.Companion.uploadAvatar(AvatarChooser.PhotoSource.APHRO_CHOOSE, uri, this.mUploadCallback);
                        return;
                    }
                    return;
                case 1004:
                    Activity activity = getActivity();
                    if (activity != null) {
                        AvatarChooser.toCropAfterCamera(activity, 1005);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        Context activity = getActivity();
        if (activity != null) {
            onSkinChange(GarbManager.getGarbWithNightMode(activity));
        }
    }
}