package tv.danmaku.bili.ui.main2.mine.provider;

import android.app.Activity;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import bolts.Continuation;
import bolts.Task;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.badge.Badge;
import com.bilibili.lib.badge.BadgeManager;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.homepage.mine.IMineMenuItemRedirection;
import com.bilibili.lib.homepage.mine.IMineMenuItemSolution;
import com.bilibili.lib.homepage.mine.IMinePageInfo;
import com.bilibili.lib.homepage.mine.MenuGroup;
import java.util.concurrent.Callable;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.services.videodownload.utils.VideoDownloadProvider;
import tv.danmaku.bili.ui.main2.mine.DefaultMineMenuSolution;
import tv.danmaku.bili.ui.main2.mine.provider.OfflineMineSolution;

public class OfflineMineSolution implements IMinePageInfo {
    public static final String ROUTE_URI_DOWNLOADLIST = "activity://main/download-list";
    private static final String TAG = "OfflineMineSolution";
    private IMineMenuItemSolution mMenuSolution = new OfflineMineMenuItemSolution();
    private IMineMenuItemRedirection mRedirection = new IMineMenuItemRedirection() { // from class: tv.danmaku.bili.ui.main2.mine.provider.OfflineMineSolution.1
        public void redirect(Activity context, MenuGroup.Item menuData) {
            RouteRequest routeRequest = new RouteRequest.Builder(Uri.parse("activity://main/download-list")).build();
            BLRouter.routeTo(routeRequest, context);
        }

        public boolean isNeedLoginBeforeRedirect(MenuGroup.Item menuData) {
            return menuData.needLogin == 1;
        }
    };

    public IMineMenuItemSolution getMenuItemSolution() {
        return this.mMenuSolution;
    }

    public IMineMenuItemRedirection getRedirection() {
        return this.mRedirection;
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    private static class OfflineMineMenuItemSolution extends DefaultMineMenuSolution {
        private MenuGroup.Item mItem;
        private ContentObserver videoDownloadProvider = new AnonymousClass1(new Handler());

        OfflineMineMenuItemSolution() {
        }

        @Override // tv.danmaku.bili.ui.main2.mine.DefaultMineMenuSolution
        public void onMenuCreated(Context context, MenuGroup.Item item) {
            super.onMenuCreated(context, item);
            VideoDownloadProvider.register(context, this.videoDownloadProvider);
        }

        @Override // tv.danmaku.bili.ui.main2.mine.DefaultMineMenuSolution
        public void onMenuItemUpdate(Context context, MenuGroup.Item item) {
            super.onMenuItemUpdate(context, item);
            this.mItem = item;
        }

        @Override // tv.danmaku.bili.ui.main2.mine.DefaultMineMenuSolution
        public void onMenuDestroy(Context context) {
            super.onMenuDestroy(context);
            VideoDownloadProvider.unregister(context, this.videoDownloadProvider);
        }

        @Override // tv.danmaku.bili.ui.main2.mine.DefaultMineMenuSolution
        public void onMenuItemClick(Context context, MenuGroup.Item item) {
            super.onMenuItemClick(context, item);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: tv.danmaku.bili.ui.main2.mine.provider.OfflineMineSolution$OfflineMineMenuItemSolution$1  reason: invalid class name */
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public class AnonymousClass1 extends ContentObserver {
            AnonymousClass1(Handler arg0) {
                super(arg0);
            }

            @Override // android.database.ContentObserver
            public void onChange(boolean selfChange) {
                onChange(selfChange, null);
            }

            @Override // android.database.ContentObserver
            public void onChange(boolean selfChange, Uri uri) {
                BLog.d(OfflineMineSolution.TAG, "onChange");
                if (BiliContext.application() != null) {
                    Task.callInBackground(new Callable() { // from class: tv.danmaku.bili.ui.main2.mine.provider.OfflineMineSolution$OfflineMineMenuItemSolution$1$$ExternalSyntheticLambda0
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            int[] queryDownloadInfo;
                            queryDownloadInfo = VideoDownloadProvider.queryDownloadInfo(BiliContext.application());
                            return queryDownloadInfo;
                        }
                    }).continueWith(new Continuation() { // from class: tv.danmaku.bili.ui.main2.mine.provider.OfflineMineSolution$OfflineMineMenuItemSolution$1$$ExternalSyntheticLambda1
                        public final Object then(Task task) {
                            return OfflineMineSolution.OfflineMineMenuItemSolution.AnonymousClass1.this.m2105lambda$onChange$1$tvdanmakubiliuimain2mineproviderOfflineMineSolution$OfflineMineMenuItemSolution$1(task);
                        }
                    }, Task.UI_THREAD_EXECUTOR);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* renamed from: lambda$onChange$1$tv-danmaku-bili-ui-main2-mine-provider-OfflineMineSolution$OfflineMineMenuItemSolution$1  reason: not valid java name */
            public /* synthetic */ Void m2105lambda$onChange$1$tvdanmakubiliuimain2mineproviderOfflineMineSolution$OfflineMineMenuItemSolution$1(Task task) throws Exception {
                if (task != null && task.isCompleted() && task.getResult() != null) {
                    int count = ((int[]) task.getResult())[1];
                    BLog.dfmt(OfflineMineSolution.TAG, "badge server refresh: %s", Integer.valueOf(count));
                    BadgeManager.getInstance().update(OfflineMineMenuItemSolution.this.mItem.uri, Badge.obtainNumber(count, 99));
                    return null;
                }
                return null;
            }
        }
    }
}