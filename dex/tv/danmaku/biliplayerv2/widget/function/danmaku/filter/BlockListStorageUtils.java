package tv.danmaku.biliplayerv2.widget.function.danmaku.filter;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.bilibili.commons.io.FileUtils;
import com.bilibili.lib.accounts.BiliAccounts;
import j$.util.Collection;
import j$.util.function.Predicate;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import tv.danmaku.videoplayer.core.log.PlayerLog;
import tv.danmaku.videoplayer.core.log.PlayerLogModule;

public class BlockListStorageUtils {
    private static final String BLOCK_LIST_DIR = "block-list";
    private static final String TAG = "BlockListStorageUtils";

    private static File getFilesDirectory(Context context, String dir) {
        boolean mediaMounted;
        File appFilesDir = null;
        try {
            mediaMounted = "mounted".equals(Environment.getExternalStorageState());
        } catch (NullPointerException e) {
            mediaMounted = false;
        }
        if (mediaMounted) {
            appFilesDir = getExternalFilesDir(context, dir);
        }
        if (appFilesDir == null) {
            appFilesDir = new File(context.getFilesDir(), dir);
        }
        if (appFilesDir != null && !appFilesDir.exists()) {
            appFilesDir.mkdirs();
        }
        return appFilesDir;
    }

    private static File getExternalFilesDir(Context context, String dir) {
        try {
            return context.getExternalFilesDir(dir);
        } catch (Exception e) {
            PlayerLog.e(TAG, "Failed to get external dir -> " + e.getMessage());
            return null;
        }
    }

    private static File getDefaultKeywordsListFile(Context context) {
        File dir = getFilesDirectory(context, BLOCK_LIST_DIR);
        return new File(dir, "keywords_def");
    }

    private static File getKeywordsListFile(Context context, String mid) {
        File dir = getFilesDirectory(context, BLOCK_LIST_DIR);
        return new File(dir, "keywords_" + mid);
    }

    private static File getFailedKeywordsListFile(Context context, String mid) {
        File dir = getFilesDirectory(context, BLOCK_LIST_DIR);
        return new File(dir, "keywords_failed_" + mid);
    }

    private static File getGlobalKeywordsListFile(Context context) {
        File dir = getFilesDirectory(context, BLOCK_LIST_DIR);
        return new File(dir, "keywords_global");
    }

    private static void writeToLocal(File file, BlockedKeywords<? extends BaseKeywordItem> data) {
        if (file == null) {
            return;
        }
        try {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (file.exists()) {
                FileUtils.deleteQuietly(file);
            } else {
                file.createNewFile();
            }
            if (data != null) {
                FileUtils.write(file, data.toString());
            }
        } catch (Exception e) {
            PlayerLog.e(TAG, "Error happened when writeToLocal -> " + e);
        }
    }

    public static void writeGlobalBlockedList(Context context, GlobalBlockedKeywords data) {
        if (data == null) {
            return;
        }
        data.mCreateTime = System.currentTimeMillis();
        File file = getGlobalKeywordsListFile(context);
        writeToLocal(file, data);
    }

    public static GlobalBlockedKeywords readGlobalBlockedKeywords(Context context) {
        if (context == null) {
            return null;
        }
        File file = getGlobalKeywordsListFile(context);
        if (!file.exists()) {
            return null;
        }
        try {
            String json = FileUtils.readFileToString(file);
            if (!TextUtils.isEmpty(json)) {
                return (GlobalBlockedKeywords) JSON.parseObject(json, new TypeReference<GlobalBlockedKeywords>() { // from class: tv.danmaku.biliplayerv2.widget.function.danmaku.filter.BlockListStorageUtils.1
                }, new Feature[0]);
            }
        } catch (Exception e) {
            PlayerLog.e(TAG, "Error happened when readGlobalBlockedKeywords -> " + e);
        }
        return null;
    }

    public static boolean isGlobalBlockListExpired(Context context) {
        GlobalBlockedKeywords keywords = readGlobalBlockedKeywords(context);
        File file = getGlobalKeywordsListFile(context);
        if (keywords == null || !file.exists()) {
            return true;
        }
        long time = (System.currentTimeMillis() - keywords.mCreateTime) / 1000;
        return time >= keywords.mExpiredTime;
    }

    public static long getGlobalBlockListVersion(Context context) {
        GlobalBlockedKeywords keywords = readGlobalBlockedKeywords(context);
        if (keywords != null) {
            return keywords.mVersion;
        }
        return 0L;
    }

    public static BlockedKeywords<UserKeywordItem> readDefaultBlockedKeywords(Context context) {
        long mid;
        if (context == null) {
            return null;
        }
        File defaultFile = getDefaultKeywordsListFile(context);
        if (!defaultFile.exists() || !defaultFile.isFile()) {
            return null;
        }
        try {
            mid = Long.parseLong(FileUtils.readFileToString(defaultFile));
        } catch (Exception e) {
            PlayerLog.e(TAG, "Error happened when readDefaultBlockedKeywords -> " + e);
        }
        if (mid <= 0) {
            return null;
        }
        File file = getKeywordsListFile(context, String.valueOf(mid));
        if (!file.exists()) {
            return null;
        }
        String json = FileUtils.readFileToString(file);
        if (!TextUtils.isEmpty(json)) {
            return (BlockedKeywords) JSON.parseObject(json, new TypeReference<BlockedKeywords<UserKeywordItem>>() { // from class: tv.danmaku.biliplayerv2.widget.function.danmaku.filter.BlockListStorageUtils.2
            }, new Feature[0]);
        }
        return null;
    }

    public static void makeDefault(Context context, long mid) {
        if (mid <= 0) {
            return;
        }
        try {
            File defaultFile = getDefaultKeywordsListFile(context);
            FileUtils.write(defaultFile, String.valueOf(mid));
        } catch (Exception e) {
        }
    }

    public static void writeUserBlockedKeywords(Context context, BlockedKeywords<UserKeywordItem> items) {
        if (items == null || context == null) {
            return;
        }
        long mid = BiliAccounts.get(context).mid();
        if (mid < 0) {
            return;
        }
        items.mCreateTime = System.currentTimeMillis();
        File file = getKeywordsListFile(context, String.valueOf(mid));
        writeToLocal(file, items);
        makeDefault(context, mid);
    }

    public static BlockedKeywords<UserKeywordItem> readUserBlockedKeywords(Context context) {
        if (context == null) {
            return null;
        }
        long mid = BiliAccounts.get(context).mid();
        if (mid < 0) {
            return null;
        }
        File file = getKeywordsListFile(context, String.valueOf(mid));
        if (!file.exists()) {
            return null;
        }
        try {
            String json = FileUtils.readFileToString(file);
            if (!TextUtils.isEmpty(json)) {
                return (BlockedKeywords) JSON.parseObject(json, new TypeReference<BlockedKeywords<UserKeywordItem>>() { // from class: tv.danmaku.biliplayerv2.widget.function.danmaku.filter.BlockListStorageUtils.3
                }, new Feature[0]);
            }
        } catch (Exception e) {
            PlayerLog.e(TAG, "Error happened when readUserBlockedKeywords -> " + e);
        }
        return null;
    }

    public static boolean isUserKeywordsExpired(Context context) {
        long mid = BiliAccounts.get(context).mid();
        if (mid <= 0) {
            return false;
        }
        BlockedKeywords<UserKeywordItem> keywords = readUserBlockedKeywords(context);
        File file = getKeywordsListFile(context, String.valueOf(mid));
        if (keywords == null || !file.exists()) {
            return true;
        }
        long time = (System.currentTimeMillis() - keywords.mCreateTime) / 1000;
        return time >= keywords.mExpiredTime;
    }

    public static void removeUserBlockedKeywords(Context context, Collection<UserKeywordItem> items) {
        if (items == null || context == null || items.isEmpty()) {
            return;
        }
        long mid = BiliAccounts.get(context).mid();
        if (mid < 0) {
            return;
        }
        try {
            BlockedKeywords<UserKeywordItem> keywords = readUserBlockedKeywords(context);
            if (keywords != null && keywords.mKeywordItems != null && !keywords.mKeywordItems.isEmpty()) {
                keywords.mKeywordItems.removeAll(items);
                File file = getKeywordsListFile(context, String.valueOf(mid));
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                if (!file.exists()) {
                    file.createNewFile();
                }
                writeToLocal(file, keywords);
            }
        } catch (Exception e) {
            PlayerLog.e(TAG, "Error happened when removeUserBlockedKeywords -> " + e);
        }
    }

    public static void appendUserBlockedKeywords(Context context, Collection<UserKeywordItem> items) {
        if (items == null || context == null || items.isEmpty()) {
            return;
        }
        long mid = BiliAccounts.get(context).mid();
        if (mid < 0) {
            return;
        }
        try {
            BlockedKeywords<UserKeywordItem> keywords = readUserBlockedKeywords(context);
            if (keywords == null) {
                keywords = new BlockedKeywords<>();
            }
            if (keywords.mKeywordItems == null) {
                keywords.mKeywordItems = new ArrayList();
            }
            for (final UserKeywordItem toAdd : items) {
                if (toAdd != null && Collection.-EL.stream(keywords.mKeywordItems).noneMatch(new Predicate() { // from class: tv.danmaku.biliplayerv2.widget.function.danmaku.filter.BlockListStorageUtils$$ExternalSyntheticLambda0
                    @Override // java.util.function.Predicate
                    public /* synthetic */ Predicate and(Predicate predicate) {
                        return Predicate.-CC.$default$and(this, predicate);
                    }

                    @Override // java.util.function.Predicate
                    public /* synthetic */ java.util.function.Predicate negate() {
                        return Predicate.-CC.$default$negate(this);
                    }

                    @Override // java.util.function.Predicate
                    public /* synthetic */ java.util.function.Predicate or(java.util.function.Predicate predicate) {
                        return Predicate.-CC.$default$or(this, predicate);
                    }

                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        return BlockListStorageUtils.lambda$appendUserBlockedKeywords$0(UserKeywordItem.this, (UserKeywordItem) obj);
                    }
                })) {
                    keywords.mKeywordItems.add(toAdd);
                }
            }
            File file = getKeywordsListFile(context, String.valueOf(mid));
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            writeToLocal(file, keywords);
        } catch (Exception e) {
            PlayerLog.e(PlayerLogModule.Danmaku, "Error happened when appendUserBlockedKeywords -> " + e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$appendUserBlockedKeywords$0(UserKeywordItem toAdd, UserKeywordItem existingItem) {
        return existingItem != null && existingItem.id == toAdd.id && existingItem.type == toAdd.type;
    }

    public static void appendUserBlockedKeyword(Context context, UserKeywordItem data) {
        if (data == null || context == null) {
            return;
        }
        List<UserKeywordItem> items = new ArrayList<>();
        items.add(data);
        appendUserBlockedKeywords(context, items);
    }

    public static List<UserKeywordItem> readUserBlockedUserIds(Context context) {
        List<UserKeywordItem> result = new ArrayList<>();
        BlockedKeywords<UserKeywordItem> blockedList = readUserBlockedKeywords(context);
        if (blockedList == null || blockedList.mKeywordItems == null || blockedList.mKeywordItems.isEmpty()) {
            return result;
        }
        for (UserKeywordItem item : blockedList.mKeywordItems) {
            if (item != null && item.type == 2) {
                result.add(item);
            }
        }
        return result;
    }
}