package tv.danmaku.bili.ui.filechooser;

import java.io.File;
import java.io.FileFilter;
import java.util.Comparator;
import java.util.Locale;

public final class FileUtils {
    private static final boolean DEBUG = false;
    public static final String HIDDEN_PREFIX = ".";
    static final String TAG = "FileUtils";
    public static Comparator<File> sComparator = new Comparator<File>() { // from class: tv.danmaku.bili.ui.filechooser.FileUtils.1
        @Override // java.util.Comparator
        public int compare(File f1, File f2) {
            return f1.getName().toLowerCase(Locale.US).compareTo(f2.getName().toLowerCase(Locale.US));
        }
    };
    public static FileFilter sFileFilter = new FileFilter() { // from class: tv.danmaku.bili.ui.filechooser.FileUtils.2
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            String fileName = file.getName();
            return file.isFile() && !fileName.startsWith(FileUtils.HIDDEN_PREFIX);
        }
    };
    public static FileFilter sDirFilter = new FileFilter() { // from class: tv.danmaku.bili.ui.filechooser.FileUtils.3
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            String fileName = file.getName();
            return file.isDirectory() && !fileName.startsWith(FileUtils.HIDDEN_PREFIX);
        }
    };

    private FileUtils() {
    }
}