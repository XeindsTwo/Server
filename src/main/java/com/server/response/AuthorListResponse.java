package com.server.response;

import com.server.entity.AuthorEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AuthorListResponse extends BaseResponse {
    public AuthorListResponse(Iterable<AuthorEntity> data) {
        super(true, "Authors:");
        this.data = data;
    }

    private Iterable<AuthorEntity> data;
}
