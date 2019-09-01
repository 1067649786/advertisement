package com.ygy.ad.adsponsor.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CreativeUnitRequest {

    private List<CreativeUnitItem> unitItems;

    public CreativeUnitRequest(List<CreativeUnitItem> unitItems) {
        this.unitItems = unitItems;
    }

    public List<CreativeUnitItem> getUnitItems() {
        return unitItems;
    }

    public void setUnitItems(List<CreativeUnitItem> unitItems) {
        this.unitItems = unitItems;
    }

    @Data
    @NoArgsConstructor
    public static class CreativeUnitItem{

        private Long creativeId;
        private Long unitId;

        public CreativeUnitItem(Long creativeId, Long unitId) {
            this.creativeId = creativeId;
            this.unitId = unitId;
        }

        public Long getCreativeId() {
            return creativeId;
        }

        public void setCreativeId(Long creativeId) {
            this.creativeId = creativeId;
        }

        public Long getUnitId() {
            return unitId;
        }

        public void setUnitId(Long unitId) {
            this.unitId = unitId;
        }
    }
}
