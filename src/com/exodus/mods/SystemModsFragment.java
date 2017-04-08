package com.exodus.mods;

import android.os.Bundle;

import android.os.Bundle;
import android.support.v7.preference.Preference;
import com.android.internal.logging.MetricsProto.MetricsEvent;
import com.android.settings.SettingsPreferenceFragment;


public class SystemModsFragment extends SettingsPreferenceFragment {

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
}
