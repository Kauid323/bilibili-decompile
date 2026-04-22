package tv.danmaku.bili.ui.filechooser;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import tv.danmaku.bili.R;

public class FileListAdapter extends BaseAdapter {
    private List<File> mData = new ArrayList();
    private final LayoutInflater mInflater;
    private static final int ICON_FOLDER = R.drawable.ic_folder;
    private static final int ICON_FILE = R.drawable.ic_file;

    public FileListAdapter(Context context) {
        this.mInflater = LayoutInflater.from(context);
    }

    public void add(File file) {
        this.mData.add(file);
        notifyDataSetChanged();
    }

    public void remove(File file) {
        this.mData.remove(file);
        notifyDataSetChanged();
    }

    public void insert(File file, int index) {
        this.mData.add(index, file);
        notifyDataSetChanged();
    }

    public void clear() {
        this.mData.clear();
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public File getItem(int position) {
        return this.mData.get(position);
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mData.size();
    }

    public List<File> getListItems() {
        return this.mData;
    }

    public void setListItems(List<File> data) {
        this.mData = data;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView row = (TextView) convertView;
        if (row == null) {
            row = (TextView) this.mInflater.inflate(R.layout.bili_app_layout_filechooser_item, parent, false);
        }
        File file = getItem(position);
        String name = file.getName();
        if (name.endsWith("..")) {
            name = String.format(Locale.US, parent.getContext().getString(bili.resource.favorites.R.string.favorites_global_string_165), name);
        }
        row.setText(name);
        int icon = file.isDirectory() ? ICON_FOLDER : ICON_FILE;
        row.setCompoundDrawablesWithIntrinsicBounds(icon, 0, 0, 0);
        return row;
    }
}