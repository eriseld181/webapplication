package com.crystal.webapplication.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.Mapping;

import com.crystal.webapplication.dto.CommentDto;
import com.crystal.webapplication.models.Comment;

@Mapper
public class CommentMapper {
//mer nje object nga db
//mapoje sipas objektit dto (konverto)-funksion qe mer nje comment model edhe kthen dto: krijohet objekti i ri
//do ta therrasim tek controller

//	CommentMapper commentMapper= Mappers.getMapper(CommentMapper.class);
//	
//	@Mapping(source="comment_text", target="comment_text_dto")
//	CommentDto mappCommentToDto(Comment comment);

//	public CommentDto mappCommentToDto(Comment comment) {
//		CommentDto commentDto= new CommentDto(comment.getComment_text(), comment.getComment_author(), comment.getComment_date());
//		return commentDto;
//	}
}
