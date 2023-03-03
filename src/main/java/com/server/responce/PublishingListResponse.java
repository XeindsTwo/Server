package com.server.responce;

import com.server.entity.PublishingEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PublishingListResponse extends BaseResponse {
    public PublishingListResponse(Iterable<PublishingEntity> data) {
        super(true, "Publishing's:");
        this.data = data;
    }

    private Iterable<PublishingEntity> data;
}
