package com.dlka.fireinstaller;

import android.content.pm.ApplicationInfo;
import android.view.View;
import android.widget.CheckBox;

/**
 * Data container for holding all the relevant information on a package.
 *
 * @author patrick
 */
class SortablePackageInfo implements Comparable<SortablePackageInfo>,
        View.OnClickListener {

    public String packageName;
    public String displayName;
    public String installer;
    public String tags;
    public boolean selected;
    public int versionCode;
    public String version;
    public long firstInstalled;
    public long lastUpdated;
    public int uid;
    public String dataDir;
    public int targetsdk;
    public ApplicationInfo appInfo;
    public String sourceDir;

    public SortablePackageInfo() {
    }

    @Override
    public int compareTo(SortablePackageInfo another) {
        return displayName.toLowerCase().compareTo(another.displayName.toLowerCase());
    }

    @Override
    public void onClick(View v) {
        selected = ((CheckBox) v).isChecked();
    }

}
