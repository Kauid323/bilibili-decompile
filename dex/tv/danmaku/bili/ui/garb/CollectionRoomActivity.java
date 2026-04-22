package tv.danmaku.bili.ui.garb;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentTransaction;
import com.bili.digital.common.data.SpaceBannerItem;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.BaseAppCompatActivity;
import com.bilibili.lib.ui.util.MultipleThemeUtils;
import com.bilibili.lib.ui.util.StatusBarCompat;
import com.bilibili.okretro.call.json.JsonUtilKt;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.report.misaka.MisakaHelper;
import tv.danmaku.bili.ui.garb.CollectionRoomFragment;

/* compiled from: CollectionRoomActivity.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014¨\u0006\t"}, d2 = {"Ltv/danmaku/bili/ui/garb/CollectionRoomActivity;", "Lcom/bilibili/lib/ui/BaseAppCompatActivity;", "<init>", "()V", "onPostCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class CollectionRoomActivity extends BaseAppCompatActivity {
    public static final int $stable = 8;

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        getWindow().clearFlags(67108864);
        getWindow().addFlags(Integer.MIN_VALUE);
        int systemUiVisibility = getWindow().getDecorView().getSystemUiVisibility();
        getWindow().getDecorView().setSystemUiVisibility(StatusBarCompat.setNavigationBarMode((Activity) this, systemUiVisibility | MisakaHelper.MAX_REPORT_SIZE | BR.hallEnterHotText, MultipleThemeUtils.isNightTheme((Context) this)));
        getWindow().setStatusBarColor(0);
        setTitle(null);
    }

    /* JADX WARN: Type inference failed for: r6v6, types: [tv.danmaku.bili.ui.garb.CollectionRoomActivity$onCreate$$inlined$parseJson$1] */
    protected void onCreate(Bundle savedInstanceState) {
        List list;
        InitConfigurationData initConfigurationData;
        String string;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bili_app_activity_collection_room);
        String stringExtra = getIntent().getStringExtra("vmid");
        long vmid = stringExtra != null ? Long.parseLong(stringExtra) : 0L;
        Bundle bundleExtra = getIntent().getBundleExtra("data");
        String fSource = "";
        String list2 = (bundleExtra == null || (r0 = bundleExtra.getString("list")) == null) ? "" : "";
        try {
            Type type = new TypeToken<List<? extends SpaceBannerItem>>() { // from class: tv.danmaku.bili.ui.garb.CollectionRoomActivity$onCreate$$inlined$parseJson$1
            }.getType();
            Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
            list = (List) JsonUtilKt.parseJson(list2, type);
        } catch (Throwable th) {
            list = null;
        }
        List banners = list;
        Bundle bundleExtra2 = getIntent().getBundleExtra("data");
        int position = bundleExtra2 != null ? bundleExtra2.getInt("position") : 0;
        Bundle bundleExtra3 = getIntent().getBundleExtra("data");
        Boolean isPublic = bundleExtra3 != null ? Boolean.valueOf(bundleExtra3.getBoolean("is_public", false)) : null;
        Bundle bundleExtra4 = getIntent().getBundleExtra("data");
        Integer oldPartParam = bundleExtra4 != null ? Integer.valueOf(bundleExtra4.getInt("from")) : null;
        Bundle bundleExtra5 = getIntent().getBundleExtra("data");
        int part = bundleExtra5 != null ? bundleExtra5.getInt("part") : oldPartParam != null ? oldPartParam.intValue() : 0;
        Bundle bundleExtra6 = getIntent().getBundleExtra("data");
        String from = (bundleExtra6 == null || (r0 = bundleExtra6.getString("from")) == null) ? "" : "";
        Bundle bundleExtra7 = getIntent().getBundleExtra("data");
        if (bundleExtra7 != null && (string = bundleExtra7.getString("f_source")) != null) {
            fSource = string;
        }
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        int i = R.id.collection_room_root_view;
        CollectionRoomFragment.Companion companion = CollectionRoomFragment.Companion;
        List emptyList = banners == null ? CollectionsKt.emptyList() : banners;
        boolean booleanValue = isPublic != null ? isPublic.booleanValue() : false;
        Map<String, String> createTrackParams = CollectionRoomFragment.Companion.createTrackParams(fSource, from, String.valueOf(vmid), String.valueOf(part));
        try {
            Bundle bundleExtra8 = getIntent().getBundleExtra("data");
            initConfigurationData = new InitConfigurationData(bundleExtra8 != null ? bundleExtra8.getString("collection_completed_url") : null);
        } catch (Exception e) {
            initConfigurationData = null;
        }
        beginTransaction.replace(i, companion.newInstance(emptyList, position, vmid, booleanValue, createTrackParams, initConfigurationData)).commitAllowingStateLoss();
    }
}