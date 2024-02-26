package org.group3.mapper;

import javax.annotation.processing.Generated;
import org.group3.dto.request.CommentRequestDto;
import org.group3.dto.response.CommentFindAllByNotApproveResponse;
import org.group3.dto.response.CommentFindAllResponseDto;
import org.group3.dto.response.CommentResponseDto;
import org.group3.entity.Comment;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-21T22:25:50+0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 19 (Oracle Corporation)"
)
@Component
public class CommentMapperImpl implements CommentMapper {

    @Override
    public Comment saveRequestDtoToComment(CommentRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Comment.CommentBuilder comment = Comment.builder();

        comment.personalId( dto.getPersonalId() );
        comment.companyId( dto.getCompanyId() );
        comment.content( dto.getContent() );

        return comment.build();
    }

    @Override
    public CommentResponseDto commentToResponseDto(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        CommentResponseDto.CommentResponseDtoBuilder commentResponseDto = CommentResponseDto.builder();

        commentResponseDto.companyId( comment.getCompanyId() );
        commentResponseDto.personalId( comment.getPersonalId() );
        commentResponseDto.content( comment.getContent() );

        return commentResponseDto.build();
    }

    @Override
    public CommentFindAllByNotApproveResponse commentToCommentFindAllByNotApproveResponse(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        CommentFindAllByNotApproveResponse.CommentFindAllByNotApproveResponseBuilder commentFindAllByNotApproveResponse = CommentFindAllByNotApproveResponse.builder();

        commentFindAllByNotApproveResponse.id( comment.getId() );
        commentFindAllByNotApproveResponse.content( comment.getContent() );

        return commentFindAllByNotApproveResponse.build();
    }

    @Override
    public CommentFindAllResponseDto commentToCommentFindAllResponseDto(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        CommentFindAllResponseDto.CommentFindAllResponseDtoBuilder commentFindAllResponseDto = CommentFindAllResponseDto.builder();

        commentFindAllResponseDto.id( comment.getId() );

        return commentFindAllResponseDto.build();
    }
}
