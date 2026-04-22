package tv.danmaku.bili.ui.main2.resource;

import android.app.Application;
import com.alibaba.fastjson.JSON;
import com.bilibili.base.BiliContext;
import com.bilibili.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main2.resource.MainResourceManager;

/* compiled from: CachedResourceResolver.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nJ\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\nJ\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\nJ\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\nR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0019"}, d2 = {"Ltv/danmaku/bili/ui/main2/resource/CachedResourceResolver;", "", "<init>", "()V", "mTabResponse", "Ltv/danmaku/bili/ui/main2/resource/MainResourceManager$TabResponse;", "tabResponse", "getTabResponse", "()Ltv/danmaku/bili/ui/main2/resource/MainResourceManager$TabResponse;", "forPrimaryPages", "", "Ltv/danmaku/bili/ui/main2/resource/PrimaryPage;", "forHomeTabPages", "Ltv/danmaku/bili/ui/main2/resource/SecondaryPage;", "forHomeTopMenus", "Ltv/danmaku/bili/ui/main2/resource/MenuItem;", "forNoLoginAvatar", "Ltv/danmaku/bili/ui/main2/resource/HomeNoLoginAvatar;", "forTopLeftInfo", "Ltv/danmaku/bili/ui/main2/resource/MainResourceManager$TopLeftInfo;", "forConfig", "Ltv/danmaku/bili/ui/main2/resource/MainResourceManager$Config;", "forMoreCategoryItem", "Ltv/danmaku/bili/ui/main2/resource/MoreCategoryItem;", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class CachedResourceResolver {
    private static final String TAB_DIR = "home_tab_v2.data";
    private static final String TAG = "CachedResourceResolver";
    private static volatile boolean saved;
    private MainResourceManager.TabResponse mTabResponse;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    private final MainResourceManager.TabResponse getTabResponse() {
        if (this.mTabResponse == null) {
            this.mTabResponse = Companion.readFromDisk();
        }
        return this.mTabResponse;
    }

    public final List<PrimaryPage> forPrimaryPages() {
        MainResourceManager.TabData tabData;
        List bottom;
        MainResourceManager.TabResponse tabResponse = getTabResponse();
        if (tabResponse == null || (tabData = tabResponse.tabData) == null || (bottom = tabData.bottom) == null) {
            return null;
        }
        return MainResourceManager.forPrimaryPages(bottom, 2);
    }

    public final List<SecondaryPage> forHomeTabPages() {
        MainResourceManager.TabData tabData;
        List tab;
        MainResourceManager.TabResponse tabResponse = getTabResponse();
        if (tabResponse == null || (tabData = tabResponse.tabData) == null || (tab = tabData.tab) == null) {
            return null;
        }
        return MainResourceManager.forHomeTabPages(tab, 2);
    }

    public final List<MenuItem> forHomeTopMenus() {
        MainResourceManager.TabData tabData;
        List top;
        MainResourceManager.TabResponse tabResponse = getTabResponse();
        if (tabResponse == null || (tabData = tabResponse.tabData) == null || (top = tabData.top) == null) {
            return null;
        }
        return MainResourceManager.forHomeTopMenus(top, 2);
    }

    public final HomeNoLoginAvatar forNoLoginAvatar() {
        MainResourceManager.Config config;
        MainResourceManager.TabResponse tabResponse = getTabResponse();
        if (tabResponse == null || (config = tabResponse.config) == null) {
            return null;
        }
        return new HomeNoLoginAvatar(config.noLoginAvatar, config.noLoginAvatarType);
    }

    public final MainResourceManager.TopLeftInfo forTopLeftInfo() {
        MainResourceManager.TabData tabData;
        MainResourceManager.TabResponse tabResponse = getTabResponse();
        if (tabResponse == null || (tabData = tabResponse.tabData) == null) {
            return null;
        }
        return tabData.topLeftInfo;
    }

    public final MainResourceManager.Config forConfig() {
        MainResourceManager.TabResponse tabResponse = getTabResponse();
        if (tabResponse != null) {
            return tabResponse.config;
        }
        return null;
    }

    public final List<MoreCategoryItem> forMoreCategoryItem() {
        MainResourceManager.TabData tabData;
        List moreCategory;
        MainResourceManager.TabResponse tabResponse = getTabResponse();
        if (tabResponse == null || (tabData = tabResponse.tabData) == null || (moreCategory = tabData.moreCategory) == null) {
            return null;
        }
        return MainResourceManager.forCategoryItem(moreCategory);
    }

    /* compiled from: CachedResourceResolver.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\nH\u0007J\b\u0010\r\u001a\u00020\u000eH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Ltv/danmaku/bili/ui/main2/resource/CachedResourceResolver$Companion;", "", "<init>", "()V", "TAG", "", "TAB_DIR", "saved", "", "readFromDisk", "Ltv/danmaku/bili/ui/main2/resource/MainResourceManager$TabResponse;", "saveToDisk", "tabResponse", "clearCache", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final synchronized MainResourceManager.TabResponse readFromDisk() {
            MainResourceManager.TabData tabData;
            MainResourceManager.TabData tabData2;
            List<MainResourceManager.Tab> list;
            Application context = BiliContext.application();
            List<MainResourceManager.Tab> list2 = null;
            if (context == null) {
                return null;
            }
            File tabFile = new File(context.getFilesDir(), CachedResourceResolver.TAB_DIR);
            if (tabFile.exists()) {
                String str = null;
                try {
                    synchronized (CachedResourceResolver.class) {
                        str = FileUtils.readFileToString(tabFile);
                        Unit unit = Unit.INSTANCE;
                    }
                } catch (IOException e) {
                    BLog.e(e.getMessage(), e);
                }
                if (str == null) {
                    return null;
                }
                BLog.i(CachedResourceResolver.TAG, "readFromDisk json is = " + ((Object) str));
                MainResourceManager.TabResponse tabResponse = null;
                try {
                    tabResponse = (MainResourceManager.TabResponse) JSON.parseObject(str, MainResourceManager.TabResponse.class);
                } catch (Exception e2) {
                    BLog.e(e2.getMessage(), e2);
                }
                if (tabResponse != null && (tabData = tabResponse.tabData) != null) {
                    if (tabResponse != null && (tabData2 = tabResponse.tabData) != null && (list = tabData2.tab) != null) {
                        list2 = TabResponseExtKt.filterNotExpired$default(list, 0L, 1, null);
                    }
                    tabData.tab = list2;
                }
                return tabResponse;
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:36:0x0094 A[Catch: all -> 0x00b4, TryCatch #2 {IOException -> 0x00b7, blocks: (B:10:0x0040, B:42:0x00ae, B:12:0x0042, B:14:0x004c, B:16:0x0050, B:18:0x0054, B:20:0x005c, B:21:0x0063, B:23:0x0069, B:25:0x0073, B:27:0x0077, B:28:0x007c, B:30:0x0080, B:36:0x0094, B:41:0x00a5), top: B:51:0x0040 }] */
        /* JADX WARN: Removed duplicated region for block: B:55:0x009a A[SYNTHETIC] */
        @JvmStatic
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean saveToDisk(MainResourceManager.TabResponse tabResponse) {
            MainResourceManager.TabData tabData;
            List<MainResourceManager.Tab> list;
            Iterable reversed;
            boolean z;
            boolean z2;
            Application context = BiliContext.application();
            if (context == null) {
                return false;
            }
            String json = JSON.toJSONString(tabResponse);
            BLog.i(CachedResourceResolver.TAG, "show tab data is" + json);
            File tabFile = new File(context.getFilesDir(), CachedResourceResolver.TAB_DIR);
            if (tabFile.exists()) {
                tabFile.delete();
            }
            try {
                synchronized (CachedResourceResolver.class) {
                    boolean z3 = false;
                    FileUtils.writeStringToFile(tabFile, json);
                    ArrayList tabNames = new ArrayList();
                    if (tabResponse != null && (tabData = tabResponse.tabData) != null && (list = tabData.tab) != null && (reversed = CollectionsKt.reversed(list)) != null) {
                        Iterable $this$forEach$iv = reversed;
                        for (Object element$iv : $this$forEach$iv) {
                            MainResourceManager.Tab tab = (MainResourceManager.Tab) element$iv;
                            if (tab == null) {
                                z = z3;
                            } else {
                                String p0 = tab.name;
                                if (p0 != null) {
                                    tabNames.add(p0);
                                }
                                String p02 = tab.uri;
                                if (p02 != null) {
                                    z = z3;
                                    if (StringsKt.startsWith$default(p02, "bilibili://campus/home_tab", false, 2, (Object) null)) {
                                        z2 = true;
                                        if (!z2) {
                                            HomeTabReporterKt.onHomeTabResponseSavedWithCampusTab();
                                        }
                                    }
                                } else {
                                    z = z3;
                                }
                                z2 = false;
                                if (!z2) {
                                }
                            }
                            z3 = z;
                        }
                    }
                    HomeTabReporterKt.onHomeTabResponseSaved(tabNames);
                    Unit unit = Unit.INSTANCE;
                }
                CachedResourceResolver.saved = true;
                return true;
            } catch (IOException e) {
                BLog.e(e.getMessage(), e);
                return false;
            }
        }

        @JvmStatic
        public final void clearCache() {
            Application context = BiliContext.application();
            if (context == null) {
                return;
            }
            try {
                synchronized (CachedResourceResolver.class) {
                    File tabFile = new File(context.getFilesDir(), CachedResourceResolver.TAB_DIR);
                    if (tabFile.exists()) {
                        tabFile.delete();
                    }
                    Unit unit = Unit.INSTANCE;
                }
            } catch (Exception e) {
                BLog.e(e.getMessage(), e);
            }
        }
    }

    @JvmStatic
    public static final boolean saveToDisk(MainResourceManager.TabResponse tabResponse) {
        return Companion.saveToDisk(tabResponse);
    }

    @JvmStatic
    public static final void clearCache() {
        Companion.clearCache();
    }
}