package tv.danmaku.bili.ui.main2.main;

import android.content.Context;
import android.content.SharedPreferences;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.droid.StringUtil;
import com.bilibili.homepage.HomeMenuService;
import com.bilibili.lib.badge.Badge;
import com.bilibili.lib.badge.BadgeManager;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.config.BLRemoteConfig;
import com.bilibili.lib.homepage.badge.IBadgeServer;
import com.bilibili.lib.homepage.badge.SimpleBadgeServer;
import com.bilibili.lib.homepage.startdust.menu.DynamicMenuItem;
import com.bilibili.lib.homepage.startdust.menu.IDynamicMenuItemServer;
import com.bilibili.lib.homepage.startdust.menu.IMenuAnimatorServer;
import com.bilibili.lib.homepage.widget.MenuActionView;
import com.bilibili.lib.neuron.api.Neurons;
import java.util.HashMap;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.router.MainRouteUris;
import tv.danmaku.bili.ui.main2.main.GameMenuServiceImpl;
import tv.danmaku.bili.ui.main2.resource.HomeTabReporterKt;

@Singleton
@Named("action://game_center/home/menu")
public class GameMenuServiceImpl implements HomeMenuService {
    public static final String ACTION = "action://game_center/home/menu";
    public static final int BADGE_TYPE_ACT = 5;
    public static final int BADGE_TYPE_BANNER = 4;
    public static final int BADGE_TYPE_GIFT_RETURN = 7;
    public static final int BADGE_TYPE_MOLE = 1;
    public static final int BADGE_TYPE_NUM = 2;
    public static final int BADGE_TYPE_RECOMMEND = 3;
    private static final String TAG = "GameMenuAction";
    private static final String TOP_GAME_ALREADY_CLICKED = "top_game_already_clicked";
    private static final String TOP_GAME_LOCAL_TIME = "top_game_local_time";
    public static final String TOP_GAME_LOTTIE_FILE = "top_game_lottie.json";
    public static final String TOP_GAME_LOTTIE_FINISH = "top_game_lottie_finish";
    private static final String TOP_GAME_RESIDUE_TIME = "top_game_residue_time";
    private String mAnimatorIconUrl;
    private Context mContext;
    private int mCount;
    private String mIconUrl;
    private String mLottieJson;
    private int mType;
    private IBadgeServer mServer = new SimpleBadgeServer() { // from class: tv.danmaku.bili.ui.main2.main.GameMenuServiceImpl.1
        public void refresh(Context context) {
            Context app = context == null ? GameMenuServiceImpl.this.mContext : context.getApplicationContext();
            if (app == null) {
                return;
            }
            if (GameMenuServiceImpl.this.mType != 0 && GameMenuServiceImpl.this.mCount > 0) {
                BadgeManager.getInstance().update("action://game_center/home/menu", GameMenuServiceImpl.getBadgeType(GameMenuServiceImpl.this.mType, GameMenuServiceImpl.this.mCount));
            } else {
                BadgeManager.getInstance().update("action://game_center/home/menu", Badge.obtainNone());
            }
        }
    };
    private IMenuAnimatorServer mMenuAnimatorServer = new IMenuAnimatorServer() { // from class: tv.danmaku.bili.ui.main2.main.GameMenuServiceImpl.2
        public /* synthetic */ void startUpdateAnimator(MenuActionView menuActionView) {
            IMenuAnimatorServer.-CC.$default$startUpdateAnimator(this, menuActionView);
        }

        public void startAnimator(MenuActionView view) {
            BLog.d(GameMenuServiceImpl.TAG, "icon url= " + GameMenuServiceImpl.this.mAnimatorIconUrl);
            DynamicMenuItem.AnimatorParam params = new DynamicMenuItem.AnimatorParam();
            params.animatorIconUrl = GameMenuServiceImpl.this.mAnimatorIconUrl;
            params.lottieJson = GameMenuServiceImpl.this.mLottieJson;
            params.animatorFinishKey = "top_game_lottie_finish";
            params.lottieFileName = "top_game_lottie.json";
            params.remoteCount = BLRemoteConfig.getInstance().getString("game_center_switch_badge_loop");
            params.alreadyClickedKey = GameMenuServiceImpl.TOP_GAME_ALREADY_CLICKED;
            params.residueTimeKey = GameMenuServiceImpl.TOP_GAME_RESIDUE_TIME;
            params.localTimeKey = GameMenuServiceImpl.TOP_GAME_LOCAL_TIME;
            view.startAnimator(params);
        }
    };

    /* renamed from: getDynamicMenuItemServer */
    public IDynamicMenuItemServer m2057getDynamicMenuItemServer(Context context, int type, int badgeNum, String iconUrl, String lottieJsonUrl, String animatorIconUrl, String jumpUrl) {
        if (context == null) {
            return null;
        }
        this.mContext = context.getApplicationContext();
        this.mType = type;
        this.mCount = badgeNum;
        this.mIconUrl = iconUrl;
        this.mLottieJson = lottieJsonUrl;
        this.mAnimatorIconUrl = animatorIconUrl;
        IDynamicMenuItemServer dynamicServer = new AnonymousClass3();
        return dynamicServer;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: tv.danmaku.bili.ui.main2.main.GameMenuServiceImpl$3  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public class AnonymousClass3 implements IDynamicMenuItemServer {
        public /* synthetic */ void strictExpose() {
            IDynamicMenuItemServer.-CC.$default$strictExpose(this);
        }

        AnonymousClass3() {
        }

        public IBadgeServer getBadgeServer() {
            return GameMenuServiceImpl.this.mServer;
        }

        public void show() {
            HomeTabReporterKt.reportGameMenuShow(getReportParams());
            Neurons.reportExposure(false, "main.homepage.gamecenter.0.show", getReportParams());
        }

        public void intent() {
            RouteRequest request = new RouteRequest.Builder(MainRouteUris.URI_BILIBILI_GAME_CENTER).extras(new Function1() { // from class: tv.danmaku.bili.ui.main2.main.GameMenuServiceImpl$3$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    return GameMenuServiceImpl.AnonymousClass3.this.m2058lambda$intent$0$tvdanmakubiliuimain2mainGameMenuServiceImpl$3((MutableBundleLike) obj);
                }
            }).build();
            BLRouter bLRouter = BLRouter.INSTANCE;
            BLRouter.routeTo(request, GameMenuServiceImpl.this.mContext);
            BadgeManager.getInstance().update("action://game_center/home/menu", Badge.obtainNone());
            SharedPreferences.Editor sp = BiliGlobalPreferenceHelper.getBLKVSharedPreference(GameMenuServiceImpl.this.mContext).edit();
            sp.putBoolean(GameMenuServiceImpl.TOP_GAME_ALREADY_CLICKED, true).putString(GameMenuServiceImpl.TOP_GAME_RESIDUE_TIME, null).apply();
            Neurons.reportClick(false, "main.homepage.gamecenter.0.click", getReportParams());
            GameMenuServiceImpl.this.mAnimatorIconUrl = null;
            GameMenuServiceImpl.this.mType = 0;
            GameMenuServiceImpl.this.mCount = 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$intent$0$tv-danmaku-bili-ui-main2-main-GameMenuServiceImpl$3  reason: not valid java name */
        public /* synthetic */ Unit m2058lambda$intent$0$tvdanmakubiliuimain2mainGameMenuServiceImpl$3(MutableBundleLike extra) {
            String sourceFrom;
            if (GameMenuServiceImpl.this.mType == 3) {
                sourceFrom = "1000450011";
            } else if (GameMenuServiceImpl.this.mType == 4) {
                sourceFrom = "1000450021";
            } else if (GameMenuServiceImpl.this.mType == 5) {
                sourceFrom = "1000450031";
            } else {
                sourceFrom = "233";
            }
            extra.put("sourceFrom", sourceFrom);
            extra.put("redDotType", String.valueOf(GameMenuServiceImpl.this.mType));
            return null;
        }

        private HashMap<String, String> getReportParams() {
            String icon;
            HashMap<String, String> params = new HashMap<>(GameMenuServiceImpl.this.getRedParams());
            if (StringUtil.isNotBlank(GameMenuServiceImpl.this.mAnimatorIconUrl)) {
                icon = GameMenuServiceImpl.this.mAnimatorIconUrl;
            } else if (StringUtil.isNotBlank(GameMenuServiceImpl.this.mLottieJson)) {
                icon = GameMenuServiceImpl.this.mLottieJson;
            } else {
                icon = GameMenuServiceImpl.this.mIconUrl;
            }
            params.put("icon", icon);
            return params;
        }

        public IMenuAnimatorServer getMenuAnimatorServer() {
            return GameMenuServiceImpl.this.mMenuAnimatorServer;
        }
    }

    public HashMap<String, String> getRedParams() {
        HashMap<String, String> map = new HashMap<>();
        map.put("reddot", this.mType != 0 ? "1" : "0");
        map.put("reddot_num", String.valueOf(this.mCount));
        map.put("reddot_type", String.valueOf(this.mType));
        return map;
    }

    public static Badge getBadgeType(int type, int count) {
        if (count <= 0) {
            return Badge.NONE;
        }
        if (type == 1) {
            return Badge.obtainMole();
        }
        if (type == 2) {
            return Badge.obtainNumber(count);
        }
        if (type == 3 || type == 4 || type == 5 || type == 7) {
            return Badge.obtainMole();
        }
        return Badge.NONE;
    }
}