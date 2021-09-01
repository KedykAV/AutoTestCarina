package com.qaprosoft.carina.demo.api.openweather;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;

import java.util.Properties;

public class GetOneCallAPI extends AbstractApiMethodV2 {
    public GetOneCallAPI() {
        super(null, "api/getonecallapi/rs.json", new Properties());
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        addParameter("appId", R.TESTDATA.get("appid"));

    }
}
