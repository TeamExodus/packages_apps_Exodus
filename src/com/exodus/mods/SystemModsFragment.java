package com.exodus.mods;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.preference.Preference;
import com.android.internal.logging.MetricsProto.MetricsEvent;
import com.android.settings.SettingsPreferenceFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SystemModsFragment extends SettingsPreferenceFragment implements 
    com.android.settings.search.Indexable {

    @Override
    protected int getMetricsCategory() {
        return MetricsEvent.WIRELESS;
    }

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        addPreferencesFromResource(com.android.settings.R.xml.exodus_android_settings);
    }

    @Override
    public boolean onPreferenceTreeClick(Preference preference) {
        return super.onPreferenceTreeClick(preference);
    }

    /**
     * For Search.
     */
    public static final com.android.settings.search.Indexable.SearchIndexProvider SEARCH_INDEX_DATA_PROVIDER =
        new com.android.settings.search.BaseSearchIndexProvider() {
            @Override
            public List<android.provider.SearchIndexableResource> getXmlResourcesToIndex(
                    Context context, boolean enabled) {
                android.provider.SearchIndexableResource sir = new android.provider.SearchIndexableResource(context);
                sir.xmlResId = com.android.settings.R.xml.exodus_android_settings;
                return Arrays.asList(sir);
            }

            @Override
            public List<String> getNonIndexableKeys(Context context) {
                final ArrayList<String> result = new ArrayList<String>();

                final android.os.UserManager um = (android.os.UserManager) context.getSystemService(Context.USER_SERVICE);
                final int myUserId = android.os.UserHandle.myUserId();
                final boolean isSecondaryUser = myUserId != android.os.UserHandle.USER_OWNER;

                // TODO: Implement search index provider.

                return result;
            }
        };
}
