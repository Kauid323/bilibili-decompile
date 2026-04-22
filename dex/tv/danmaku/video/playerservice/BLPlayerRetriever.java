package tv.danmaku.video.playerservice;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bilibili.lib.spy.generated.androidx_fragment_app_Fragment;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BLPlayerRetriever.kt */
@Metadata(d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e*\u0001\u000e\b\u0000\u0018\u0000 *2\u00020\u0001:\u0002)*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\u0010\u001a\u0002H\u0011\"\b\b\u0000\u0010\u0011*\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u000e\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00110\u0006H\u0007¢\u0006\u0002\u0010\u0017J\u001c\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u00132\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0007J\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0006J\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0006J$\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u000b2\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u001f\u001a\u00020\u0001H\u0002J7\u0010 \u001a\u0002H\u0011\"\b\b\u0000\u0010\u0011*\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u000e\u0010!\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00110\u0006H\u0002¢\u0006\u0002\u0010\u0017J5\u0010\u0010\u001a\u0002H\u0011\"\b\b\u0000\u0010\u0011*\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u00152\u000e\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00110\u0006¢\u0006\u0002\u0010\"J5\u0010\u0010\u001a\u0002H\u0011\"\b\b\u0000\u0010\u0011*\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u00152\u000e\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00110\u0006¢\u0006\u0002\u0010#J!\u0010$\u001a\u0004\u0018\u0001H\u0011\"\b\b\u0000\u0010\u0011*\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010%J\u0010\u0010&\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u0001H\u0002JG\u0010\u0010\u001a\u0002H\u0011\"\b\b\u0000\u0010\u0011*\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u000e\u0010!\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00110\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010'J\u0018\u0010(\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u0001H\u0002R\u001e\u0010\u0004\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000f¨\u0006+"}, d2 = {"Ltv/danmaku/video/playerservice/BLPlayerRetriever;", "", "<init>", "()V", "mApplicationPlayers", "", "Ljava/lang/Class;", "Ltv/danmaku/video/playerservice/BLPlayerScene;", "mBLPlayerSceneCache", "mPendingPlayerFragments", "Ljava/util/HashMap;", "Landroidx/fragment/app/FragmentManager;", "Ltv/danmaku/video/playerservice/BLPlayerRetriever$PlayerFragment;", "mHandler", "tv/danmaku/video/playerservice/BLPlayerRetriever$mHandler$1", "Ltv/danmaku/video/playerservice/BLPlayerRetriever$mHandler$1;", "get", "T", "context", "Landroid/content/Context;", "service", "Ltv/danmaku/video/playerservice/BLPlayerService;", "type", "(Landroid/content/Context;Ltv/danmaku/video/playerservice/BLPlayerService;Ljava/lang/Class;)Ltv/danmaku/video/playerservice/BLPlayerScene;", "remove", "", "fragment", "Landroidx/fragment/app/Fragment;", "activity", "Landroidx/fragment/app/FragmentActivity;", "fm", "key", "getApplicationPlayer", "sceneClass", "(Landroidx/fragment/app/FragmentActivity;Ltv/danmaku/video/playerservice/BLPlayerService;Ljava/lang/Class;)Ltv/danmaku/video/playerservice/BLPlayerScene;", "(Landroidx/fragment/app/Fragment;Ltv/danmaku/video/playerservice/BLPlayerService;Ljava/lang/Class;)Ltv/danmaku/video/playerservice/BLPlayerScene;", "getFromCache", "(Ljava/lang/Object;)Ltv/danmaku/video/playerservice/BLPlayerScene;", "removeFromCache", "(Landroidx/fragment/app/FragmentManager;Ltv/danmaku/video/playerservice/BLPlayerService;Ljava/lang/Class;Landroid/content/Context;Ljava/lang/Object;)Ltv/danmaku/video/playerservice/BLPlayerScene;", "getPlayerFragment", "PlayerFragment", "Companion", "playerservice_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BLPlayerRetriever {
    private static final int MAX_GLOBAL_PLAYER_COUNT = 3;
    private static final String PLAYER_FRAGMENT_TAG = "player_fragment_tag";
    private static final int REMOVE_PENDING_FRAGMENT = 291;
    private final BLPlayerRetriever$mHandler$1 mHandler;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<BLPlayerRetriever> mInstance$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: tv.danmaku.video.playerservice.BLPlayerRetriever$$ExternalSyntheticLambda2
        public final Object invoke() {
            BLPlayerRetriever mInstance_delegate$lambda$0;
            mInstance_delegate$lambda$0 = BLPlayerRetriever.mInstance_delegate$lambda$0();
            return mInstance_delegate$lambda$0;
        }
    });
    private Map<Class<?>, BLPlayerScene> mApplicationPlayers = new HashMap();
    private final Map<Object, BLPlayerScene> mBLPlayerSceneCache = new WeakHashMap();
    private final HashMap<FragmentManager, PlayerFragment> mPendingPlayerFragments = new HashMap<>();

    /* JADX WARN: Type inference failed for: r1v0, types: [tv.danmaku.video.playerservice.BLPlayerRetriever$mHandler$1] */
    public BLPlayerRetriever() {
        final Looper myLooper = Looper.myLooper();
        Intrinsics.checkNotNull(myLooper);
        this.mHandler = new Handler(myLooper) { // from class: tv.danmaku.video.playerservice.BLPlayerRetriever$mHandler$1
            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                HashMap hashMap;
                Intrinsics.checkNotNullParameter(msg, "msg");
                if (msg.what == 291) {
                    Object obj = msg.obj;
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.fragment.app.FragmentManager");
                    FragmentManager fm = (FragmentManager) obj;
                    hashMap = BLPlayerRetriever.this.mPendingPlayerFragments;
                    hashMap.remove(fm);
                }
            }
        };
    }

    public final <T extends BLPlayerScene> T get(Context context, BLPlayerService service, Class<? extends T> cls) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(cls, "type");
        if (context instanceof FragmentActivity) {
            return (T) get((FragmentActivity) context, service, cls);
        }
        return (T) getApplicationPlayer(context, service, cls);
    }

    public final void remove(Context context, Class<?> cls) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cls, "type");
        if (context instanceof FragmentActivity) {
            remove((FragmentActivity) context, cls);
            return;
        }
        BLPlayerScene bLPlayerScene = this.mApplicationPlayers.get(cls);
        if (bLPlayerScene != null) {
            bLPlayerScene.release();
        }
        this.mApplicationPlayers.remove(cls);
    }

    public final void remove(Fragment fragment, Class<?> cls) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(cls, "type");
        FragmentManager childFragmentManager = fragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        remove(childFragmentManager, cls, fragment);
    }

    public final void remove(FragmentActivity activity, Class<?> cls) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(cls, "type");
        FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        remove(supportFragmentManager, cls, activity);
    }

    private final void remove(FragmentManager fm, Class<?> cls, Object key) {
        PlayerFragment findFragmentByTag = fm.findFragmentByTag(PLAYER_FRAGMENT_TAG);
        PlayerFragment fragment = findFragmentByTag instanceof PlayerFragment ? findFragmentByTag : null;
        if (fragment == null) {
            return;
        }
        removeFromCache(key);
        fragment.removePlayerScene(cls);
    }

    private final <T extends BLPlayerScene> T getApplicationPlayer(Context context, BLPlayerService service, Class<? extends T> cls) {
        T t = (T) this.mApplicationPlayers.get(cls);
        synchronized (this) {
            if (t != null) {
                Unit unit = Unit.INSTANCE;
                return t;
            }
            try {
                T newInstance = cls.newInstance();
                newInstance.initialize(context, service, null);
                this.mApplicationPlayers.put(cls, newInstance);
                if (this.mApplicationPlayers.size() > 3) {
                    Map.Entry abandon = null;
                    Iterator<Map.Entry<Class<?>, BLPlayerScene>> it = this.mApplicationPlayers.entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Map.Entry e = it.next();
                        if (!e.getValue().isActive()) {
                            abandon = e;
                            break;
                        }
                    }
                    if (abandon != null) {
                        Map.Entry it2 = abandon;
                        it2.getValue().release();
                        this.mApplicationPlayers.remove(it2.getKey());
                    }
                }
                Intrinsics.checkNotNull(newInstance);
                return newInstance;
            } catch (Exception e2) {
                BLog.e(BLPlayerService.TAG, "create application player " + cls + " failed, requires a no-parameter constructor");
                throw e2;
            }
        }
    }

    public final <T extends BLPlayerScene> T get(FragmentActivity activity, BLPlayerService service, Class<? extends T> cls) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(cls, "type");
        T t = (T) getFromCache(activity);
        if (t != null) {
            return t;
        }
        if (activity.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
            throw new IllegalStateException("activity@" + activity + " is DESTROYED");
        }
        FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        return (T) get(supportFragmentManager, service, cls, (Context) activity, activity);
    }

    public final <T extends BLPlayerScene> T get(Fragment fragment, BLPlayerService service, Class<? extends T> cls) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(cls, "type");
        T t = (T) getFromCache(fragment);
        if (t != null) {
            return t;
        }
        if (fragment.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
            throw new IllegalStateException("fragment@" + fragment + " is destroyed");
        }
        FragmentManager childFragmentManager = fragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        return (T) get(childFragmentManager, service, cls, (Context) requireActivity, fragment);
    }

    private final <T extends BLPlayerScene> T getFromCache(Object key) {
        BLPlayerScene bLPlayerScene = this.mBLPlayerSceneCache.get(key);
        if (bLPlayerScene instanceof BLPlayerScene) {
            return (T) bLPlayerScene;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeFromCache(Object key) {
        this.mBLPlayerSceneCache.remove(key);
    }

    private final <T extends BLPlayerScene> T get(FragmentManager fm, BLPlayerService service, Class<? extends T> cls, Context context, Object key) {
        LifecycleOwner playerFragment = getPlayerFragment(fm, key);
        T t = (T) playerFragment.getPlayerScene(cls);
        if (t == null) {
            try {
                T newInstance = cls.newInstance();
                newInstance.initialize(context, service, playerFragment);
                Intrinsics.checkNotNull(newInstance);
                playerFragment.addPlayerScene(cls, newInstance);
                this.mBLPlayerSceneCache.put(key, newInstance);
                return newInstance;
            } catch (Exception e) {
                BLog.e(BLPlayerService.TAG, "create player " + cls + " failed, requires a no-parameter constructor");
                throw e;
            }
        }
        return t;
    }

    private final PlayerFragment getPlayerFragment(FragmentManager fm, final Object key) {
        PlayerFragment findFragmentByTag = fm.findFragmentByTag(PLAYER_FRAGMENT_TAG);
        PlayerFragment fragment = findFragmentByTag instanceof PlayerFragment ? findFragmentByTag : null;
        if (fragment == null) {
            fragment = this.mPendingPlayerFragments.get(fm);
        }
        if (fragment == null) {
            Fragment playerFragment = new PlayerFragment();
            this.mPendingPlayerFragments.put(fm, playerFragment);
            fm.beginTransaction().add(playerFragment, PLAYER_FRAGMENT_TAG).commitNowAllowingStateLoss();
            obtainMessage(REMOVE_PENDING_FRAGMENT, fm).sendToTarget();
            playerFragment.getLifecycle().addObserver(new LifecycleEventObserver() { // from class: tv.danmaku.video.playerservice.BLPlayerRetriever$$ExternalSyntheticLambda1
                public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    BLPlayerRetriever.getPlayerFragment$lambda$0(BLPlayerRetriever.this, key, lifecycleOwner, event);
                }
            });
            return playerFragment;
        }
        return fragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getPlayerFragment$lambda$0(final BLPlayerRetriever this$0, final Object $key, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<unused var>");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_DESTROY) {
            this$0.mHandler.post(new Runnable() { // from class: tv.danmaku.video.playerservice.BLPlayerRetriever$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    BLPlayerRetriever.this.removeFromCache($key);
                }
            });
        }
    }

    /* compiled from: BLPlayerRetriever.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\t2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0011\u001a\u00020\u0007J\u0012\u0010\u0012\u001a\u00020\t2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0006J\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00072\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0006R\u001e\u0010\u0004\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Ltv/danmaku/video/playerservice/BLPlayerRetriever$PlayerFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "mBLPlayerScenes", "Ljava/util/HashMap;", "Ljava/lang/Class;", "Ltv/danmaku/video/playerservice/BLPlayerScene;", "onConfigurationChanged", "", "newConfig", "Landroid/content/res/Configuration;", "onMultiWindowModeChanged", "isInMultiWindowMode", "", "addPlayerScene", "type", "playerScene", "removePlayerScene", "getPlayerScene", "playerservice_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class PlayerFragment extends androidx_fragment_app_Fragment {
        private HashMap<Class<?>, BLPlayerScene> mBLPlayerScenes = new HashMap<>();

        public void onConfigurationChanged(Configuration newConfig) {
            Intrinsics.checkNotNullParameter(newConfig, "newConfig");
            super.onConfigurationChanged(newConfig);
            Map $this$forEach$iv = this.mBLPlayerScenes;
            for (Map.Entry element$iv : $this$forEach$iv.entrySet()) {
                element$iv.getValue().onConfigurationChanged(newConfig);
            }
        }

        public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
            super.onMultiWindowModeChanged(isInMultiWindowMode);
            Map $this$forEach$iv = this.mBLPlayerScenes;
            for (Map.Entry element$iv : $this$forEach$iv.entrySet()) {
                element$iv.getValue().onMultiWindowModeChanged(isInMultiWindowMode);
            }
        }

        public final void addPlayerScene(Class<?> cls, BLPlayerScene playerScene) {
            Intrinsics.checkNotNullParameter(cls, "type");
            Intrinsics.checkNotNullParameter(playerScene, "playerScene");
            this.mBLPlayerScenes.put(cls, playerScene);
        }

        public final void removePlayerScene(Class<?> cls) {
            Intrinsics.checkNotNullParameter(cls, "type");
            BLPlayerScene scene = this.mBLPlayerScenes.remove(cls);
            if (scene != null) {
                scene.release();
            }
        }

        public final BLPlayerScene getPlayerScene(Class<?> cls) {
            Intrinsics.checkNotNullParameter(cls, "type");
            return this.mBLPlayerScenes.get(cls);
        }
    }

    /* compiled from: BLPlayerRetriever.kt */
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\u0011\u001a\u0002H\u0012\"\b\b\u0000\u0010\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u000e\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00120\u0019¢\u0006\u0002\u0010\u001aJ5\u0010\u0011\u001a\u0002H\u0012\"\b\b\u0000\u0010\u0012*\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u00172\u000e\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00120\u0019¢\u0006\u0002\u0010\u001dJ5\u0010\u0011\u001a\u0002H\u0012\"\b\b\u0000\u0010\u0012*\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0016\u001a\u00020\u00172\u000e\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00120\u0019¢\u0006\u0002\u0010 J\u001a\u0010!\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\u00152\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u0019J\u001a\u0010!\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u001f2\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u0019J\u001a\u0010!\u001a\u00020\"2\u0006\u0010\u001b\u001a\u00020\u001c2\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u0019R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\f¨\u0006#"}, d2 = {"Ltv/danmaku/video/playerservice/BLPlayerRetriever$Companion;", "", "<init>", "()V", "PLAYER_FRAGMENT_TAG", "", "REMOVE_PENDING_FRAGMENT", "", "MAX_GLOBAL_PLAYER_COUNT", "mInstance", "Ltv/danmaku/video/playerservice/BLPlayerRetriever;", "getMInstance", "()Ltv/danmaku/video/playerservice/BLPlayerRetriever;", "mInstance$delegate", "Lkotlin/Lazy;", "instance", "getInstance", "get", "T", "Ltv/danmaku/video/playerservice/BLPlayerScene;", "context", "Landroid/content/Context;", "service", "Ltv/danmaku/video/playerservice/BLPlayerService;", "type", "Ljava/lang/Class;", "(Landroid/content/Context;Ltv/danmaku/video/playerservice/BLPlayerService;Ljava/lang/Class;)Ltv/danmaku/video/playerservice/BLPlayerScene;", "activity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;Ltv/danmaku/video/playerservice/BLPlayerService;Ljava/lang/Class;)Ltv/danmaku/video/playerservice/BLPlayerScene;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;Ltv/danmaku/video/playerservice/BLPlayerService;Ljava/lang/Class;)Ltv/danmaku/video/playerservice/BLPlayerScene;", "remove", "", "playerservice_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final BLPlayerRetriever getMInstance() {
            return (BLPlayerRetriever) BLPlayerRetriever.mInstance$delegate.getValue();
        }

        private final BLPlayerRetriever getInstance() {
            return getMInstance();
        }

        public final <T extends BLPlayerScene> T get(Context context, BLPlayerService service, Class<? extends T> cls) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(service, "service");
            Intrinsics.checkNotNullParameter(cls, "type");
            return (T) getInstance().get(context, service, cls);
        }

        public final <T extends BLPlayerScene> T get(FragmentActivity activity, BLPlayerService service, Class<? extends T> cls) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(service, "service");
            Intrinsics.checkNotNullParameter(cls, "type");
            return (T) getInstance().get(activity, service, cls);
        }

        public final <T extends BLPlayerScene> T get(Fragment fragment, BLPlayerService service, Class<? extends T> cls) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            Intrinsics.checkNotNullParameter(service, "service");
            Intrinsics.checkNotNullParameter(cls, "type");
            return (T) getInstance().get(fragment, service, cls);
        }

        public final void remove(Context context, Class<?> cls) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(cls, "type");
            getInstance().remove(context, cls);
        }

        public final void remove(Fragment fragment, Class<?> cls) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            Intrinsics.checkNotNullParameter(cls, "type");
            getInstance().remove(fragment, cls);
        }

        public final void remove(FragmentActivity activity, Class<?> cls) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(cls, "type");
            getInstance().remove(activity, cls);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BLPlayerRetriever mInstance_delegate$lambda$0() {
        return new BLPlayerRetriever();
    }
}