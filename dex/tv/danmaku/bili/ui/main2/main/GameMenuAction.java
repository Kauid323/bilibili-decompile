package tv.danmaku.bili.ui.main2.main;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.droid.BundleUtil;
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
import com.bilibili.lib.router.Action;
import com.bilibili.lib.router.RouteParams;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.router.MainRouteUris;
import tv.danmaku.bili.ui.main2.main.GameMenuAction;

public class GameMenuAction implements Action<IDynamicMenuItemServer> {
    public static final String ACTION = "action://game_center/home/menu";
    public static final int BADGE_TYPE_MOLE = 1;
    public static final int BADGE_TYPE_NUM = 2;
    private static final String TAG = "GameMenuAction";
    private static final String TOP_GAME_ALREADY_CLICKED = "top_game_already_clicked";
    private static final String TOP_GAME_LOCAL_TIME = "top_game_local_time";
    public static final String TOP_GAME_LOTTIE_FILE = "top_game_lottie.json";
    public static final String TOP_GAME_LOTTIE_FINISH = "top_game_lottie_finish";
    private static final String TOP_GAME_RESIDUE_TIME = "top_game_residue_time";
    private String mAnimatorIconUrl;
    private Context mContext;
    private int mCount;
    private String mLottieJson;
    private int mType;
    private IBadgeServer mServer = new SimpleBadgeServer() { // from class: tv.danmaku.bili.ui.main2.main.GameMenuAction.1
        public void refresh(Context context) {
            Context app = context == null ? GameMenuAction.this.mContext : context.getApplicationContext();
            if (app == null) {
                return;
            }
            if (GameMenuAction.this.mType != 0 && GameMenuAction.this.mCount > 0) {
                BadgeManager.getInstance().update("action://game_center/home/menu", GameMenuAction.getBadgeType(GameMenuAction.this.mType, GameMenuAction.this.mCount));
            } else {
                BadgeManager.getInstance().update("action://game_center/home/menu", Badge.obtainNone());
            }
        }
    };
    private IMenuAnimatorServer mMenuAnimatorServer = new IMenuAnimatorServer() { // from class: tv.danmaku.bili.ui.main2.main.GameMenuAction.2
        public /* synthetic */ void startUpdateAnimator(MenuActionView menuActionView) {
            IMenuAnimatorServer.-CC.$default$startUpdateAnimator(this, menuActionView);
        }

        public void startAnimator(MenuActionView view) {
            BLog.d(GameMenuAction.TAG, "icon url= " + GameMenuAction.this.mAnimatorIconUrl);
            DynamicMenuItem.AnimatorParam params = new DynamicMenuItem.AnimatorParam();
            params.animatorIconUrl = GameMenuAction.this.mAnimatorIconUrl;
            params.lottieJson = GameMenuAction.this.mLottieJson;
            params.animatorFinishKey = "top_game_lottie_finish";
            params.lottieFileName = "top_game_lottie.json";
            params.remoteCount = BLRemoteConfig.getInstance().getString("game_center_switch_badge_loop");
            params.alreadyClickedKey = GameMenuAction.TOP_GAME_ALREADY_CLICKED;
            params.residueTimeKey = GameMenuAction.TOP_GAME_RESIDUE_TIME;
            params.localTimeKey = GameMenuAction.TOP_GAME_LOCAL_TIME;
            view.startAnimator(params);
        }
    };

    /* renamed from: act */
    public IDynamicMenuItemServer m2045act(RouteParams params) {
        Context context = params.context;
        Bundle bundle = params.extras;
        if (context == null || bundle == null) {
            return null;
        }
        this.mContext = context.getApplicationContext();
        this.mType = BundleUtil.getInteger(bundle, "badgeType", new Integer[]{0}).intValue();
        this.mCount = BundleUtil.getInteger(bundle, "badgeNumber", new Integer[]{0}).intValue();
        this.mLottieJson = bundle.getString("lottieJson", null);
        this.mAnimatorIconUrl = bundle.getString("animatorIcon", null);
        IDynamicMenuItemServer dynamicServer = new AnonymousClass3();
        return dynamicServer;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: tv.danmaku.bili.ui.main2.main.GameMenuAction$3  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public class AnonymousClass3 implements IDynamicMenuItemServer {
        public /* synthetic */ void show() {
            IDynamicMenuItemServer.-CC.$default$show(this);
        }

        public /* synthetic */ void strictExpose() {
            IDynamicMenuItemServer.-CC.$default$strictExpose(this);
        }

        AnonymousClass3() {
        }

        public IBadgeServer getBadgeServer() {
            return GameMenuAction.this.mServer;
        }

        public void intent() {
            RouteRequest request = new RouteRequest.Builder(MainRouteUris.URI_BILIBILI_GAME_CENTER).extras(new Function1() { // from class: tv.danmaku.bili.ui.main2.main.GameMenuAction$3$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    return GameMenuAction.AnonymousClass3.lambda$intent$0((MutableBundleLike) obj);
                }
            }).build();
            BLRouter bLRouter = BLRouter.INSTANCE;
            BLRouter.routeTo(request, GameMenuAction.this.mContext);
            BadgeManager.getInstance().update("action://game_center/home/menu", Badge.obtainNone());
            SharedPreferences.Editor sp = BiliGlobalPreferenceHelper.getBLKVSharedPreference(GameMenuAction.this.mContext).edit();
            sp.putBoolean(GameMenuAction.TOP_GAME_ALREADY_CLICKED, true).putString(GameMenuAction.TOP_GAME_RESIDUE_TIME, null).apply();
            HashMap<String, String> params = new HashMap<>();
            params.put("icon", GameMenuAction.this.mAnimatorIconUrl);
            Neurons.reportClick(false, "main.homepage.gamecenter.0.click", params);
            GameMenuAction.this.mAnimatorIconUrl = null;
            GameMenuAction.this.mType = 0;
            GameMenuAction.this.mCount = 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Unit lambda$intent$0(MutableBundleLike extra) {
            extra.put("sourceFrom", "233");
            return null;
        }

        public IMenuAnimatorServer getMenuAnimatorServer() {
            return GameMenuAction.this.mMenuAnimatorServer;
        }
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
        return Badge.NONE;
    }
}