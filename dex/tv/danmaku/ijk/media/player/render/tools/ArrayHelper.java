package tv.danmaku.ijk.media.player.render.tools;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ArrayHelper {

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class ArrayGroup<T> extends ArrayList<List<T>> {
        private static final long serialVersionUID = 83635341838552478L;

        public ArrayGroup() {
        }

        public ArrayGroup(Collection<? extends List<T>> collection) {
            super(collection);
        }

        public ArrayGroup(int capacity) {
            super(capacity);
        }
    }

    public static <T> ArrayGroup<T> splitForGroupsize(List<T> list, int groupSize) {
        if (list == null) {
            return null;
        }
        int groupCount = (int) Math.ceil(list.size() / groupSize);
        ArrayGroup<T> gList = new ArrayGroup<>(groupCount);
        int len = groupSize;
        int j = 0;
        int k = list.size();
        for (int i = 0; i < groupCount; i++) {
            int end = j + len;
            if (end > k) {
                len = k - j;
            }
            List<T> group = list.subList(j, j + len);
            gList.add(new ArrayList(group));
            j = end;
        }
        return gList;
    }

    public static String join(List<String> list, String split) {
        return join(list, split, null, null);
    }

    public static String join(List<String> list, String split, String prefix, String suffix) {
        if (list == null || list.size() < 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String string : list) {
            if (prefix != null) {
                sb.append(prefix);
            }
            sb.append(string);
            if (suffix != null) {
                sb.append(suffix);
            }
            sb.append(split);
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static boolean contains(int[] list, int target) {
        for (int value : list) {
            if (value == target) {
                return true;
            }
        }
        return false;
    }

    public static int[] toIntArray(List<Integer> list) {
        if (list == null) {
            return null;
        }
        int[] temps = new int[list.size()];
        int j = temps.length;
        for (int i = 0; i < j; i++) {
            if (list != null && list.get(i) != null) {
                temps[i] = list.get(i).intValue();
            }
        }
        return temps;
    }

    public static <T> List<T> toList(T[] array, int[] indexs) {
        if (array == null || indexs == null) {
            return null;
        }
        List<T> list = new ArrayList<>(indexs.length);
        for (int i : indexs) {
            list.add(array[i]);
        }
        return list;
    }
}