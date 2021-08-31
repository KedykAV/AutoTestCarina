package com.qaprosoft.carina.demo.api.openweather;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;

public class PostStation extends AbstractApiMethodV2 {
    public PostStation(){
        super("api/poststation/rq.json", "api/poststation/rs.json", "api/poststation/station.properties");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        addParameter("appId", R.TESTDATA.get("appid"));
    }
}

