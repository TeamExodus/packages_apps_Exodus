/*
 * Copyright (C) 2014 The Android Open Source Project
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

package com.exodus.utils.search;

import android.content.Context;
import android.provider.SearchIndexableResource;

import com.android.settings.ButtonsSettings;
import com.android.settings.search.BaseSearchIndexProvider;
import com.android.settings.search.Indexable;
import com.android.settings.search.Indexable.SearchIndexProvider;
import com.android.settings.search.SearchIndexableResources;
import com.android.settings.R;
import com.android.settings.search.Ranking;

import com.exodus.mods.statusbar.*;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class ExodusSearchIndexableResources {

    public static int NO_DATA_RES_ID = 0;

    public static HashMap<String, SearchIndexableResource> sResMap =
            new HashMap<String, SearchIndexableResource>();

    static {

        sResMap.put(StatusbarClock.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(StatusbarClock.class.getName()),
                        R.xml.status_bar_clock,
                        StatusbarClock.class.getName(),
                        R.drawable.ic_status_bar_clock));

        sResMap.put(Traffic.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(Traffic.class.getName()),
                        R.xml.traffic,
                        Traffic.class.getName(),
                        R.drawable.ic_traffic));

        sResMap.put(ButtonsSettings.class.getName(),
                new SearchIndexableResource(
                        Ranking.getRankForClassName(ButtonsSettings.class.getName()),
                        R.xml.buttons_settings,
                        ButtonsSettings.class.getName(),
                        R.drawable.ic_settings_buttons));

    }


    /**
     * Common methods for search indexing
     **/
    public static final List<SearchIndexableResource> fetchXmlResourcesToindex(int xmlResId, Context context, boolean enabled){
        android.provider.SearchIndexableResource sir = new android.provider.SearchIndexableResource(context);
        sir.xmlResId = R.xml.traffic;
        return java.util.Arrays.asList(sir);
    }

    public static final List<String> fetchNonIndexableKeys(Context context) {
        final ArrayList<String> result = new ArrayList<String>();

        final android.os.UserManager um = (android.os.UserManager) context.getSystemService(Context.USER_SERVICE);
        final int myUserId = android.os.UserHandle.myUserId();
        final boolean isSecondaryUser = myUserId != android.os.UserHandle.USER_OWNER;

        // TODO: Implement search index provider.

        return result;
    }
}
