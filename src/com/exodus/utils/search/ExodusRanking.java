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

import com.android.settings.ButtonsSettings;

import com.exodus.mods.powermenu.*;
import com.exodus.mods.statusbar.*;

import java.util.HashMap;

/**
 * Utility class for dealing with Search Ranking.
 */
public class ExodusRanking {

    public static HashMap<String, Integer> sRankMap = new HashMap<String, Integer>();
 
    public static final int RANK_CLOCKANDDATE = 26;
    public static final int RANK_TRAFFIC = 27;
    public static final int RANK_POWERMENUACTIONS = 28;

    static {
        // Clock and Date
        sRankMap.put(StatusbarClock.class.getName(), RANK_CLOCKANDDATE);

        // Traffic
        sRankMap.put(Traffic.class.getName(), RANK_TRAFFIC);

        // Power Menu Action
        sRankMap.put(PowerMenuActions.class.getName(), RANK_POWERMENUACTIONS);
    }
}
