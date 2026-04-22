package tv.danmaku.bili.widget.dropdownmenu;

import java.util.ArrayList;
import tv.danmaku.bili.widget.dropdownmenu.DropDownMenuItem;
import tv.danmaku.bili.widget.section.adapter.BaseAdapter;

public abstract class BaseSubMenuAdapter<T extends DropDownMenuItem> extends BaseAdapter {
    public abstract void setSubMenuData(ArrayList<T> arrayList);
}