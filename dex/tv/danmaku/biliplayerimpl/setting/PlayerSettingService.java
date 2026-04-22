package tv.danmaku.biliplayerimpl.setting;

import android.content.SharedPreferences;
import com.bilibili.lib.media.resource.PlayConfig;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerimpl.AbsCorePlayerService;
import tv.danmaku.biliplayerimpl.PlayerContainerImpl;
import tv.danmaku.biliplayerv2.PlayerConfiguration;
import tv.danmaku.biliplayerv2.PlayerSharingBundle;
import tv.danmaku.biliplayerv2.service.setting.ConstantsKt;
import tv.danmaku.biliplayerv2.service.setting.ICloudConfigObserver;
import tv.danmaku.biliplayerv2.service.setting.IPlayerSettingService;
import tv.danmaku.biliplayerv2.service.setting.PlayerSettingChangeObserver;
import tv.danmaku.biliplayerv2.service.setting.Scope;
import tv.danmaku.biliplayerv2.utils.PlayerCloudConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.core.log.PlayerLog;

/* compiled from: PlayerSettingService.kt */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 S2\u00020\u00012\u00020\u0002:\u0001SB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\u001eH\u0016J\u0010\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u0011H\u0016J\u0010\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u0013H\u0016J)\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u000f2\u0012\u0010(\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070)\"\u00020\u0007H\u0016¢\u0006\u0002\u0010*J\u0010\u0010+\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u000fH\u0016J\u0018\u0010,\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020/H\u0016J\u0018\u00100\u001a\u00020/2\u0006\u0010-\u001a\u00020\u00072\u0006\u00101\u001a\u00020/H\u0016J\u0018\u00102\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u000203H\u0016J\u0018\u00104\u001a\u0002032\u0006\u0010-\u001a\u00020\u00072\u0006\u00101\u001a\u000203H\u0016J\u0018\u00105\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u000206H\u0016J\u0018\u00107\u001a\u0002062\u0006\u0010-\u001a\u00020\u00072\u0006\u00101\u001a\u000206H\u0016J\u0018\u00108\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u000209H\u0016J\u0018\u0010:\u001a\u0002092\u0006\u0010-\u001a\u00020\u00072\u0006\u00101\u001a\u000209H\u0016J\u0018\u0010;\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u0007H\u0016J\u0018\u0010<\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u0007H\u0016J\"\u0010=\u001a\u00020\u001e2\u0018\u0010(\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u001a0>H\u0016J\u0010\u0010?\u001a\u00020\u00132\u0006\u0010-\u001a\u00020\u0007H\u0002J1\u0010@\u001a\u0002HA\"\u0004\b\u0000\u0010A2\u0006\u0010-\u001a\u00020\u00072\f\u0010B\u001a\b\u0012\u0004\u0012\u0002HA0C2\u0006\u00101\u001a\u00020\bH\u0002¢\u0006\u0002\u0010DJ,\u0010E\u001a\u00020\u001e\"\u0004\b\u0000\u0010A2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\b2\f\u0010B\u001a\b\u0012\u0004\u0012\u0002HA0CH\u0002J,\u0010F\u001a\u00020\u001e\"\u0004\b\u0000\u0010A2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\b2\f\u0010B\u001a\b\u0012\u0004\u0012\u0002HA0CH\u0002J\u001c\u0010G\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00152\u0006\u0010%\u001a\u00020\u0013H\u0002J\u0010\u0010H\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020\u0007H\u0002J\u001a\u0010I\u001a\u00020\u001e2\b\u0010J\u001a\u0004\u0018\u00010K2\u0006\u0010L\u001a\u000209H\u0016J\b\u0010M\u001a\u00020\u001eH\u0016J\b\u0010N\u001a\u00020\u001cH\u0016J\b\u0010O\u001a\u00020PH\u0016J\u0010\u0010Q\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u0018H\u0016J\u0010\u0010R\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u0018H\u0016R*\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000R6\u0010\r\u001a*\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u0006j\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000e0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000e0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\u0017\u001a&\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00180\u0018 \u0019*\u0012\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00180\u0018\u0018\u00010\u001a0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006T"}, d2 = {"Ltv/danmaku/biliplayerimpl/setting/PlayerSettingService;", "Ltv/danmaku/biliplayerv2/service/setting/IPlayerSettingService;", "Ltv/danmaku/biliplayerimpl/AbsCorePlayerService;", "<init>", "()V", "mPersistentValuesByKey", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "mPlayerScopeValuesByKey", "mVideoScopeValuesByKey", "mVideoItemScopeValuesByKey", "mSettingChangedObservers", "", "Ltv/danmaku/biliplayerv2/service/setting/PlayerSettingChangeObserver;", "mPlayerContainer", "Ltv/danmaku/biliplayerimpl/PlayerContainerImpl;", "mScopes", "Ltv/danmaku/biliplayerv2/service/setting/Scope;", "mBuiltInKeysByScope", "", "mKeysByScope", "mCloudConfigObserverList", "Ltv/danmaku/biliplayerv2/service/setting/ICloudConfigObserver;", "kotlin.jvm.PlatformType", "", "mPlayerCloudConfig", "Ltv/danmaku/biliplayerv2/utils/PlayerCloudConfig;", "onStart", "", "bundle", "Ltv/danmaku/biliplayerv2/PlayerSharingBundle;", "onStop", "bindPlayerContainer", "playerContainer", "removeAll", "scope", "addPlayerSettingChangeObserver", "observer", "keys", "", "(Ltv/danmaku/biliplayerv2/service/setting/PlayerSettingChangeObserver;[Ljava/lang/String;)V", "removePlayerSettingChangeObserver", "putInt", "key", "value", "", "getInt", "default", "putLong", "", "getLong", "putFloat", "", "getFloat", "putBoolean", "", "getBoolean", "putString", "getString", "putKeysScope", "", "getScopeForKey", "get", "T", "type", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/Object;", "putToPref", "put", "getKeyValuesContainer", "dispatchSettingChanged", "updatePlayMenuConfig", "playConfig", "Lcom/bilibili/lib/media/resource/PlayConfig;", "force", "notifyPlayConfigChanged", "getCloudConfig", "getPlayerParamsConfig", "Ltv/danmaku/biliplayerv2/PlayerConfiguration;", "addCloudConfigObserver", "removeCloudConfigObserver", "Companion", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PlayerSettingService extends AbsCorePlayerService implements IPlayerSettingService {
    private static final String TAG = "PlayerSettingService";
    private PlayerContainerImpl mPlayerContainer;
    public static final Companion Companion = new Companion(null);
    private static final HashMap<String, Object> sAppScopeValuesByKey = new HashMap<>();
    private final HashMap<String, Object> mPersistentValuesByKey = new HashMap<>();
    private final HashMap<String, Object> mPlayerScopeValuesByKey = new HashMap<>();
    private final HashMap<String, Object> mVideoScopeValuesByKey = new HashMap<>();
    private final HashMap<String, Object> mVideoItemScopeValuesByKey = new HashMap<>();
    private final HashMap<String, List<PlayerSettingChangeObserver>> mSettingChangedObservers = new HashMap<>();
    private final List<Scope> mScopes = CollectionsKt.mutableListOf(new Scope[]{Scope.Persistent, Scope.App, Scope.Player, Scope.Video, Scope.VideoItem});
    private final Map<Scope, List<String>> mBuiltInKeysByScope = new HashMap(8);
    private final Map<Scope, List<String>> mKeysByScope = new HashMap(8);
    private List<ICloudConfigObserver> mCloudConfigObserverList = Collections.synchronizedList(new ArrayList());
    private final PlayerCloudConfig mPlayerCloudConfig = new PlayerCloudConfig();

    /* compiled from: PlayerSettingService.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Scope.values().length];
            try {
                iArr[Scope.Video.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Scope.VideoItem.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[Scope.Persistent.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[Scope.App.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[Scope.Player.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* compiled from: PlayerSettingService.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R*\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0007j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001`\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Ltv/danmaku/biliplayerimpl/setting/PlayerSettingService$Companion;", "", "<init>", "()V", "TAG", "", "sAppScopeValuesByKey", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void onStart(PlayerSharingBundle bundle) {
        List keysInVideoItem = new LinkedList();
        keysInVideoItem.addAll(ConstantsKt.getSKeyInScopeVideoItem());
        this.mBuiltInKeysByScope.put(Scope.VideoItem, keysInVideoItem);
        List keysInVideo = new LinkedList();
        keysInVideo.addAll(ConstantsKt.getSKeyInScopeVideo());
        this.mBuiltInKeysByScope.put(Scope.Video, keysInVideo);
        List keysInPlayer = new LinkedList();
        keysInPlayer.addAll(ConstantsKt.getSKeyInScopePlayer());
        this.mBuiltInKeysByScope.put(Scope.Player, keysInPlayer);
        List keysInApp = new LinkedList();
        keysInApp.addAll(ConstantsKt.getSKeyInScopeApp());
        this.mBuiltInKeysByScope.put(Scope.App, keysInApp);
        List keysInPersistent = new LinkedList();
        keysInPersistent.addAll(ConstantsKt.getSKeyInScopePersistent());
        this.mBuiltInKeysByScope.put(Scope.Persistent, keysInPersistent);
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void onStop() {
        this.mPersistentValuesByKey.clear();
        this.mPlayerScopeValuesByKey.clear();
        this.mVideoScopeValuesByKey.clear();
        this.mVideoItemScopeValuesByKey.clear();
        this.mBuiltInKeysByScope.clear();
        this.mKeysByScope.clear();
    }

    @Override // tv.danmaku.biliplayerimpl.AbsCorePlayerService
    public void bindPlayerContainer(PlayerContainerImpl playerContainer) {
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        this.mPlayerContainer = playerContainer;
    }

    @Override // tv.danmaku.biliplayerv2.service.setting.IPlayerSettingService
    public void removeAll(Scope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        switch (WhenMappings.$EnumSwitchMapping$0[scope.ordinal()]) {
            case 1:
                this.mVideoItemScopeValuesByKey.clear();
                this.mVideoScopeValuesByKey.clear();
                return;
            case 2:
                this.mVideoItemScopeValuesByKey.clear();
                Map $this$forEach$iv = this.mVideoItemScopeValuesByKey;
                for (Map.Entry element$iv : $this$forEach$iv.entrySet()) {
                    dispatchSettingChanged(element$iv.getKey());
                }
                return;
            default:
                PlayerLog.w(TAG, "could not remove all key for scope: " + scope);
                return;
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.setting.IPlayerSettingService
    public void addPlayerSettingChangeObserver(PlayerSettingChangeObserver observer, String... keys) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        Intrinsics.checkNotNullParameter(keys, "keys");
        for (String element : keys) {
            List observers = this.mSettingChangedObservers.get(element);
            if (observers == null) {
                observers = new LinkedList();
                this.mSettingChangedObservers.put(element, observers);
            }
            observers.add(observer);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.setting.IPlayerSettingService
    public void removePlayerSettingChangeObserver(PlayerSettingChangeObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        Map $this$forEach$iv = this.mSettingChangedObservers;
        for (Map.Entry element$iv : $this$forEach$iv.entrySet()) {
            element$iv.getValue().remove(observer);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.setting.IPlayerSettingService
    public void putInt(String key, int value) {
        Intrinsics.checkNotNullParameter(key, "key");
        put(key, Integer.valueOf(value), Integer.TYPE);
    }

    @Override // tv.danmaku.biliplayerv2.service.setting.IPlayerSettingService
    public int getInt(String key, int i) {
        Intrinsics.checkNotNullParameter(key, "key");
        return ((Number) get(key, Integer.TYPE, Integer.valueOf(i))).intValue();
    }

    @Override // tv.danmaku.biliplayerv2.service.setting.IPlayerSettingService
    public void putLong(String key, long value) {
        Intrinsics.checkNotNullParameter(key, "key");
        put(key, Long.valueOf(value), Long.TYPE);
    }

    @Override // tv.danmaku.biliplayerv2.service.setting.IPlayerSettingService
    public long getLong(String key, long j) {
        Intrinsics.checkNotNullParameter(key, "key");
        return ((Number) get(key, Long.TYPE, Long.valueOf(j))).longValue();
    }

    @Override // tv.danmaku.biliplayerv2.service.setting.IPlayerSettingService
    public void putFloat(String key, float value) {
        Intrinsics.checkNotNullParameter(key, "key");
        put(key, Float.valueOf(value), Float.TYPE);
    }

    @Override // tv.danmaku.biliplayerv2.service.setting.IPlayerSettingService
    public float getFloat(String key, float f) {
        Intrinsics.checkNotNullParameter(key, "key");
        return ((Number) get(key, Float.TYPE, Float.valueOf(f))).floatValue();
    }

    @Override // tv.danmaku.biliplayerv2.service.setting.IPlayerSettingService
    public void putBoolean(String key, boolean value) {
        Intrinsics.checkNotNullParameter(key, "key");
        put(key, Boolean.valueOf(value), Boolean.TYPE);
    }

    @Override // tv.danmaku.biliplayerv2.service.setting.IPlayerSettingService
    public boolean getBoolean(String key, boolean z) {
        Intrinsics.checkNotNullParameter(key, "key");
        return ((Boolean) get(key, Boolean.TYPE, Boolean.valueOf(z))).booleanValue();
    }

    @Override // tv.danmaku.biliplayerv2.service.setting.IPlayerSettingService
    public void putString(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        put(key, value, String.class);
    }

    @Override // tv.danmaku.biliplayerv2.service.setting.IPlayerSettingService
    public String getString(String key, String str) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(str, "default");
        return (String) get(key, String.class, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // tv.danmaku.biliplayerv2.service.setting.IPlayerSettingService
    public void putKeysScope(Map<Scope, ? extends List<String>> map) {
        Map keys = EnhancedUnmodifiabilityKt.unmodifiable(map);
        Intrinsics.checkNotNullParameter(keys, "keys");
        for (Map.Entry element$iv : keys.entrySet()) {
            List existKeys = this.mKeysByScope.get(element$iv.getKey());
            if (existKeys == null) {
                existKeys = new LinkedList();
                this.mKeysByScope.put(element$iv.getKey(), existKeys);
            }
            existKeys.addAll((Collection) element$iv.getValue());
        }
    }

    private final Scope getScopeForKey(String key) {
        boolean z;
        boolean z2;
        Scope scope = null;
        Iterator<Scope> it = this.mScopes.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Scope s = it.next();
            List<String> list = this.mBuiltInKeysByScope.get(s);
            if (list == null || !list.contains(key)) {
                z2 = false;
                continue;
            } else {
                z2 = true;
                continue;
            }
            if (z2) {
                scope = s;
                break;
            }
        }
        if (scope == null) {
            Iterator<Scope> it2 = this.mScopes.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Scope s2 = it2.next();
                List<String> list2 = this.mKeysByScope.get(s2);
                if (list2 == null || !list2.contains(key)) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (z) {
                    scope = s2;
                    break;
                }
            }
        }
        if (scope == null) {
            Scope scope2 = Scope.Persistent;
            return scope2;
        }
        return scope;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <T> T get(String key, Class<T> cls, Object obj) {
        SharedPreferences preferences;
        SharedPreferences preferences2;
        Scope scope = getScopeForKey(key);
        Map keyValues = getKeyValuesContainer(scope);
        Object value = (T) keyValues.get(key);
        if (value == null && scope == Scope.Persistent) {
            if (ConstantsKt.getSBLKVKeys().contains(key)) {
                if (IPlayerSettingService.Companion.getMBLKVPreference().contains(key)) {
                    value = (T) IPlayerSettingService.Companion.getFromPref(IPlayerSettingService.Companion.getMBLKVPreference(), key, cls, obj);
                } else {
                    if (ConstantsKt.getSMainPlayerSettingKeys().contains(key)) {
                        preferences2 = IPlayerSettingService.Companion.getMMainPlayerPreference();
                    } else {
                        preferences2 = IPlayerSettingService.Companion.getMDefaultPreference();
                    }
                    value = (T) IPlayerSettingService.Companion.getFromPref(preferences2, key, cls, obj);
                    if (value != null) {
                        putToPref(key, value, cls);
                    } else {
                        putToPref(key, obj, cls);
                    }
                }
            } else {
                if (ConstantsKt.getSMainPlayerSettingKeys().contains(key)) {
                    preferences = IPlayerSettingService.Companion.getMMainPlayerPreference();
                } else {
                    preferences = IPlayerSettingService.Companion.getMDefaultPreference();
                }
                if (!preferences.contains(key)) {
                    return obj;
                }
                value = (T) IPlayerSettingService.Companion.getFromPref(preferences, key, cls, obj);
            }
        }
        return value == null ? obj : (T) value;
    }

    private final <T> void putToPref(String key, Object value, Class<T> cls) {
        if (ConstantsKt.getSBLKVKeys().contains(key)) {
            IPlayerSettingService.Companion.putToPref(IPlayerSettingService.Companion.getMBLKVPreference(), key, value, cls);
        } else if (ConstantsKt.getSMainPlayerSettingKeys().contains(key)) {
            IPlayerSettingService.Companion.putToPref(IPlayerSettingService.Companion.getMMainPlayerPreference(), key, value, cls);
        } else {
            IPlayerSettingService.Companion.putToPref(IPlayerSettingService.Companion.getMDefaultPreference(), key, value, cls);
        }
    }

    private final <T> void put(String key, Object value, Class<T> cls) {
        Scope scope = getScopeForKey(key);
        if (scope == Scope.Persistent) {
            putToPref(key, value, cls);
        } else {
            Map keyValues = getKeyValuesContainer(scope);
            keyValues.put(key, value);
        }
        dispatchSettingChanged(key);
    }

    private final Map<String, Object> getKeyValuesContainer(Scope scope) {
        switch (WhenMappings.$EnumSwitchMapping$0[scope.ordinal()]) {
            case 1:
                return this.mVideoScopeValuesByKey;
            case 2:
                return this.mVideoItemScopeValuesByKey;
            case 3:
                return this.mPersistentValuesByKey;
            case 4:
                return sAppScopeValuesByKey;
            case 5:
                return this.mPlayerScopeValuesByKey;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final void dispatchSettingChanged(String key) {
        Iterable observers = (List) this.mSettingChangedObservers.get(key);
        if (observers != null) {
            Iterable $this$forEach$iv = observers;
            for (Object element$iv : $this$forEach$iv) {
                PlayerSettingChangeObserver observer = (PlayerSettingChangeObserver) element$iv;
                observer.onChange(key);
            }
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.setting.IPlayerSettingService
    public void updatePlayMenuConfig(PlayConfig playConfig, boolean force) {
        if (this.mPlayerCloudConfig.setPlayMenuConfig(playConfig) || force) {
            notifyPlayConfigChanged();
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.setting.IPlayerSettingService
    public void notifyPlayConfigChanged() {
        List<ICloudConfigObserver> list = this.mCloudConfigObserverList;
        Intrinsics.checkNotNullExpressionValue(list, "mCloudConfigObserverList");
        synchronized (list) {
            Iterable iterable = this.mCloudConfigObserverList;
            Intrinsics.checkNotNullExpressionValue(iterable, "mCloudConfigObserverList");
            Iterable $this$forEach$iv = iterable;
            for (Object element$iv : $this$forEach$iv) {
                ICloudConfigObserver p0 = (ICloudConfigObserver) element$iv;
                p0.onCloudConfigChanged();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.setting.IPlayerSettingService
    public PlayerCloudConfig getCloudConfig() {
        return this.mPlayerCloudConfig;
    }

    @Override // tv.danmaku.biliplayerv2.service.setting.IPlayerSettingService
    public PlayerConfiguration getPlayerParamsConfig() {
        PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
        if (playerContainerImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl = null;
        }
        return playerContainerImpl.getPlayerParams().getConfig();
    }

    @Override // tv.danmaku.biliplayerv2.service.setting.IPlayerSettingService
    public void addCloudConfigObserver(ICloudConfigObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (this.mCloudConfigObserverList.contains(observer)) {
            return;
        }
        this.mCloudConfigObserverList.add(observer);
    }

    @Override // tv.danmaku.biliplayerv2.service.setting.IPlayerSettingService
    public void removeCloudConfigObserver(ICloudConfigObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mCloudConfigObserverList.remove(observer);
    }
}