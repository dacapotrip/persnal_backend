package com.persnal.persnal_backend.borad.domain.Brewery;

import java.util.List;
import lombok.Data;

@Data
public abstract class RegionResponse {
    private int page;
    private int perPage;
    private int totalCount;
    private int currentCount;
    private int matchCount;
    private List<BreweryDTO> data;
}
