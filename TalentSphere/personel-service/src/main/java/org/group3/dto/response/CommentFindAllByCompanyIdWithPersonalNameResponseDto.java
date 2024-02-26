package org.group3.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentFindAllByCompanyIdWithPersonalNameResponseDto {

    String personalName;
    String content;
    String createdDate;
}
