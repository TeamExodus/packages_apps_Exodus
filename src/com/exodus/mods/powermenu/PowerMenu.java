/*
 * Copyright (C) 2013 Slimroms Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.exodus.mods.powermenu;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.preference.Preference;
import android.support.v14.preference.SwitchPreference;
import android.provider.Settings;
import android.support.v7.preference.Preference;
import com.android.internal.logging.MetricsProto.MetricsEvent;
import com.android.settings.SettingsPreferenceFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PowerMenu extends SettingsPreferenceFragment implements Preference.OnPreferenceChangeListener {

	private static final String ADVANCED_REBOOT_KEY = "advanced_reboot_key";
    private SwitchPreference boolPref = null ;
			
    @Override
    protected int getMetricsCategory() {
        return 1;
    }

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        addPreferencesFromResource(com.android.settings.R.xml.power_menu);
        boolPref = (SwitchPreference) findPreference(ADVANCED_REBOOT_KEY);
        setAdvancedReboot();
        boolPref.setOnPreferenceChangeListener(this);
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object value) {
		String stringValue = value.toString();
		if (preference.getKey().equals(ADVANCED_REBOOT_KEY)) {
			boolPref.setChecked((boolean) value);
            updateAdvancedRebootOptions((boolean) value);
		}
		 
		return true; 
	}

    private void updateAdvancedRebootOptions(boolean isChecked) {
        Settings.Secure.putInt(getActivity().getContentResolver(),
                Settings.Secure.EXTENDED_REBOOT, isChecked?1:0);
    }

    private void setAdvancedReboot() {
        boolPref.setChecked(Settings.Secure.getInt(getActivity().getContentResolver(),
                Settings.Secure.EXTENDED_REBOOT, 0) != 0);
    }
}
