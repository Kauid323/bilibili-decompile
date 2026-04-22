package tv.danmaku.bili.ui.videodownload.diagnosis;

import android.content.Context;
import android.text.TextUtils;
import com.bilibili.videodownloader.directory.AvVideoDownloadDirectory;
import com.bilibili.videodownloader.directory.BangumiVideoDownloadDirectory;
import com.bilibili.videodownloader.directory.file.VideoFile;
import com.bilibili.videodownloader.model.VideoDownloadAVPageEntry;
import com.bilibili.videodownloader.model.VideoDownloadSeasonEpEntry;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONException;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.services.videodownload.strategy.VideoDownloadStorageStrategy;
import video.biz.offline.base.infra.utils.EntryScannerKt;

public class VideoEntryScanner {
    private static final String TAG = "VideoEntryScanner";

    public static ArrayList<ScanEntry> scan(Context context) {
        BLog.i(TAG, "==================start scan======================");
        VideoFile[] dirs = VideoDownloadStorageStrategy.getCurrentSortedDownloadDirs(context);
        if (dirs == null) {
            return null;
        }
        ArrayList<ScanEntry> scanResult = new ArrayList<>();
        for (VideoFile dir : dirs) {
            loadAllEntriesInDirectory(context, dir, scanResult);
        }
        return scanResult;
    }

    private static void loadAllEntriesInDirectory(Context context, VideoFile rootDirectory, ArrayList<ScanEntry> scanResult) {
        String[] filenames = rootDirectory.list();
        if (filenames == null) {
            BLog.e(TAG, "entry factory download directory " + rootDirectory.getAbsolutePath() + " is empty");
            return;
        }
        for (String dirName : filenames) {
            if (TextUtils.isEmpty(dirName)) {
                BLog.e(TAG, "entry factory subDir is empty : " + rootDirectory.getAbsolutePath());
            } else {
                long avid = AvVideoDownloadDirectory.getAvidFromFilename(dirName);
                if (avid != -1) {
                    loadEntriesForAvid(context, rootDirectory, avid, scanResult);
                } else {
                    String seasonId = BangumiVideoDownloadDirectory.getSeasonIdFromFilename(dirName);
                    if (!"".equals(seasonId)) {
                        loadEntriesForSeasonId(context, rootDirectory, seasonId, scanResult);
                    } else {
                        scanResult.add(new ScanEntry(1, VideoFile.fromVideoFile(rootDirectory, dirName).getAbsolutePath()));
                    }
                }
            }
        }
    }

    private static ArrayList<VideoDownloadAVPageEntry> loadEntriesForAvid(Context context, VideoFile rootDirectory, long avid, ArrayList<ScanEntry> scanResult) {
        VideoFile[] pageList = AvVideoDownloadDirectory.getAvDirectories(context, rootDirectory.getAbsolutePath(), avid);
        if (pageList == null) {
            scanResult.add(new ScanEntry(2, VideoFile.fromVideoFile(rootDirectory, avid + "").getAbsolutePath()));
            return null;
        }
        ArrayList<VideoDownloadAVPageEntry> entryList = new ArrayList<>();
        for (VideoFile subDir : pageList) {
            if (!subDir.isDirectory() || (!TextUtils.isDigitsOnly(subDir.getName()) && !subDir.getName().startsWith(EntryScannerKt.CID_FOLDER_PREFIX))) {
                scanResult.add(new ScanEntry(3, subDir.getAbsolutePath()));
            } else {
                VideoFile entryFile = AvVideoDownloadDirectory.getEntryFile(subDir);
                if (entryFile == null || !entryFile.isFile()) {
                    scanResult.add(new ScanEntry(4, entryFile.getAbsolutePath()));
                } else {
                    try {
                        VideoDownloadAVPageEntry entry = (VideoDownloadAVPageEntry) AvVideoDownloadDirectory.readEntryFrom(entryFile, VideoDownloadAVPageEntry.class);
                        if (entry != null && entry.isValid()) {
                            entryList.add(entry);
                            entry.mCanPlayed = entry.isCompleted();
                            scanResult.add(new ScanEntry(6, entryFile.getAbsolutePath(), entry));
                        } else {
                            scanResult.add(new ScanEntry(5, entryFile.getAbsolutePath(), entry));
                        }
                    } catch (IOException | JSONException e) {
                        scanResult.add(new ScanEntry(5, entryFile.getAbsolutePath()));
                        e.printStackTrace();
                    }
                }
            }
        }
        return entryList;
    }

    private static ArrayList<VideoDownloadSeasonEpEntry> loadEntriesForSeasonId(Context context, VideoFile rootDirectory, String seasonId, ArrayList<ScanEntry> scanResult) {
        VideoFile[] epFiles = BangumiVideoDownloadDirectory.getEpisodeDirectories(context, rootDirectory.getAbsolutePath(), seasonId);
        if (epFiles == null) {
            scanResult.add(new ScanEntry(2, VideoFile.fromVideoFile(rootDirectory, seasonId).getAbsolutePath()));
            return null;
        }
        ArrayList<VideoDownloadSeasonEpEntry> entryList = new ArrayList<>();
        for (VideoFile subDir : epFiles) {
            if (!subDir.isDirectory() || !TextUtils.isDigitsOnly(subDir.getName())) {
                scanResult.add(new ScanEntry(3, subDir.getAbsolutePath()));
            } else {
                VideoFile entryFile = BangumiVideoDownloadDirectory.getEntryFile(subDir);
                if (entryFile == null || !entryFile.isFile()) {
                    scanResult.add(new ScanEntry(4, entryFile.getAbsolutePath()));
                } else {
                    try {
                        VideoDownloadSeasonEpEntry entry = (VideoDownloadSeasonEpEntry) BangumiVideoDownloadDirectory.readEntryFrom(entryFile, VideoDownloadSeasonEpEntry.class);
                        if (entry != null && entry.isValid()) {
                            entryList.add(entry);
                            entry.mCanPlayed = entry.isCompleted();
                            scanResult.add(new ScanEntry(6, entryFile.getAbsolutePath(), entry));
                        } else {
                            scanResult.add(new ScanEntry(5, entryFile.getAbsolutePath(), entry));
                        }
                    } catch (IOException | JSONException e) {
                        scanResult.add(new ScanEntry(5, entryFile.getAbsolutePath()));
                        e.printStackTrace();
                    }
                }
            }
        }
        return entryList;
    }
}